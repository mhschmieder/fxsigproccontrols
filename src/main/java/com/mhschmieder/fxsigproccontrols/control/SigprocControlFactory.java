/*
 * MIT License
 *
 * Copyright (c) 2020, 2026 Mark Schmieder. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * This file is part of the FxSigProc Library
 *
 * You should have received a copy of the MIT License along with the
 * FxSigProc Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/fxsigproc
 */
package com.mhschmieder.fxsigproccontrols.control;

import com.mhschmieder.fxcontrols.control.DoubleEditor;
import com.mhschmieder.jcommons.util.ClientProperties;

/**
 * This is a utility class for making custom controls for Signal Processing.
 */
public final class SigprocControlFactory {

    /**
     * The default constructor is disabled, as this is a static factory class.
     */
    private SigprocControlFactory() {}


    // This is a helper method to get a stand-alone Bandwidth Editor.
    public static DoubleEditor getBandwidthEditor( final ClientProperties clientProperties,
                                                   final double minimumValue,
                                                   final double maximumValue,
                                                   final double initialValue ) {
        // Get the current value and format it as initial text.
        // TODO: Make sure this is locale-sensitive?
        final String initialText = Double.toString( initialValue );

        // Declare value increment/decrement amount for up and down arrow keys.
        final double valueIncrement = 0.01d;

        final DoubleEditor bandwidthEditor = new DoubleEditor( clientProperties,
                                                               initialText,
                                                               null,
                                                               true,
                                                               0,
                                                               2,
                                                               0,
                                                               4,
                                                               minimumValue,
                                                               maximumValue,
                                                               0.0d,
                                                               valueIncrement );

        return bandwidthEditor;
    }

    // Helper method to get a stand-alone Delay Editor.
    public static DoubleEditor getDelayEditor( final ClientProperties clientProperties,
                                               final String measurementUnitString,
                                               final double minimumValue,
                                               final double maximumValue,
                                               final double initialValue ) {
        // Get the current value and format it as initial text.
        // TODO: Make sure this is locale-sensitive?
        final String initialText = Double.toString( initialValue );

        // Declare value increment/decrement amount for up and down arrow keys.
        final double valueIncrementMs = 0.1d;

        final DoubleEditor delayEditor = new DoubleEditor( clientProperties,
                                                           initialText,
                                                           null,
                                                           true,
                                                           0,
                                                           2,
                                                           0,
                                                           4,
                                                           minimumValue,
                                                           maximumValue,
                                                           0.0d,
                                                           valueIncrementMs );

        delayEditor.setMeasurementUnitString( measurementUnitString );

        return delayEditor;
    }

    // Helper method to get a standalone Frequency Editor.
    public static FrequencyEditor getFrequencyEditor( final ClientProperties clientProperties,
                                                      final String tooltipText,
                                                      final String measurementUnitString,
                                                      final double minimumValue,
                                                      final double maximumValue,
                                                      final double initialValue,
                                                      final double pPrecisionCutoffFrequencyHz,
                                                      final int pNumberOfDecimalPlaces ) {
        // Get the current value and format it as initial text.
        // TODO: Make sure this is locale-sensitive?
        final String initialText = Double.toString( initialValue );

        final FrequencyEditor frequencyEditor = new FrequencyEditor( clientProperties,
                                                                     initialText,
                                                                     tooltipText,
                                                                     minimumValue,
                                                                     maximumValue,
                                                                     initialValue,
                                                                     pPrecisionCutoffFrequencyHz,
                                                                     pNumberOfDecimalPlaces );

        frequencyEditor.setMeasurementUnitString( measurementUnitString );

        return frequencyEditor;
    }

    // This is a helper method to get a standalone Gain Editor.
    public static GainEditor getGainEditor( final ClientProperties clientProperties,
                                            final String measurementUnitString,
                                            final double gainMinimumDb,
                                            final double gainMaximumDb,
                                            final double gainDefaultDb,
                                            final boolean defaultToNegativeGain ) {
        // Get the current value and format it as initial text.
        // TODO: Make sure this is locale-sensitive?
        final String initialText = Double.toString( gainDefaultDb );

        final GainEditor gainEditor = new GainEditor( clientProperties,
                                                      initialText,
                                                      null,
                                                      gainMinimumDb,
                                                      gainMaximumDb,
                                                      gainDefaultDb,
                                                      defaultToNegativeGain );

        gainEditor.setMeasurementUnitString( measurementUnitString );

        return gainEditor;
    }
}
