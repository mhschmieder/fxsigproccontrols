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

import com.mhschmieder.fxcontrols.control.XToggleButton;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.ToggleButton;

public class SigprocLabeledControlFactory {

    // NOTE: We must substitute "." for resource directory tree delimiters.
    public static final String BUNDLE_NAME = "properties.SigprocActionLabels";

    /**
     * The default constructor is disabled, as this is a static factory class.
     */
    private SigprocLabeledControlFactory() {}


    public static XToggleButton getPolarityToggleButton( final boolean applyAspectRatio,
                                                         final boolean selected ) {
        final String selectedText = "Reversed"; //$NON-NLS-1$
        final String deselectedText = "Normal"; //$NON-NLS-1$
        final String tooltipText = "Click to Toggle Polarity Status Between Normal and Reversed"; //$NON-NLS-1$

        // NOTE: JavaFX CSS automatically darkens unselected buttons, and
        // auto-selects the foreground for text fill; we use a custom fill.
        final XToggleButton toggleButton = new XToggleButton( selectedText,
                                                              deselectedText,
                                                              tooltipText,
                                                              "polarity-toggle", //$NON-NLS-1$
                                                              applyAspectRatio,
                                                              3.0d,
                                                              false,
                                                              selected );

        return toggleButton;
    }

    public static XToggleButton getMuteToggleButton( final boolean applyAspectRatio,
                                                     final boolean selected ) {
        final String selectedText = "Muted"; //$NON-NLS-1$
        final String deselectedText = "Mute"; //$NON-NLS-1$
        final String tooltipText = "Click to Toggle Mute Status Between Muted and Unmuted"; //$NON-NLS-1$

        // NOTE: JavaFX CSS automatically darkens unselected buttons, and
        // auto-selects the foreground for text fill; we use a custom fill.
        final XToggleButton toggleButton = new XToggleButton( selectedText,
                                                              deselectedText,
                                                              tooltipText,
                                                              "mute-toggle", //$NON-NLS-1$
                                                              applyAspectRatio,
                                                              3.0d,
                                                              false,
                                                              selected );

        return toggleButton;
    }


    @SuppressWarnings("nls")
    public static XToggleButton getProcessingToggleButton( final String selectedText,
                                                           final String deselectedText,
                                                           final String tooltipText,
                                                           final boolean applyAspectRatio,
                                                           final double aspectRatio,
                                                           final boolean wordWrap,
                                                           final boolean selected ) {
        // NOTE: JavaFX CSS automatically darkens unselected buttons, and
        //  auto-selects the foreground for text fill, but we mimic legacy apps.
        // NOTE: "selected" means "bypassed" and "deselected" means "enabled".
        final XToggleButton toggleButton = new XToggleButton( selectedText,
                                                              deselectedText,
                                                              tooltipText,
                                                              "bypass-toggle",
                                                              applyAspectRatio,
                                                              aspectRatio,
                                                              wordWrap,
                                                              selected );
    
        return toggleButton;
    }


    public static ToggleButton getSingleFilterToggleButton( final int filterNumber,
                                                            final boolean applyAspectRatio,
                                                            final boolean selected ) {
        final String selectedText = filterNumber + " Bypassed"; //$NON-NLS-1$
        final String deselectedText = filterNumber + " Enabled"; //$NON-NLS-1$
        final String tooltipText = "Bypass/Enable Filter"; //$NON-NLS-1$
    
        // NOTE: JavaFX CSS automatically darkens unselected buttons, and
        //  auto-selects the foreground for text fill, but we mimic legacy apps.
        // NOTE: "selected" means "bypassed" and "deselected" means "enabled".
        final ToggleButton toggleButton = getProcessingToggleButton( selectedText,
                                                                     deselectedText,
                                                                     tooltipText,
                                                                     applyAspectRatio,
                                                                     4.0d,
                                                                     false,
                                                                     selected );
    
        // NOTE: Single filter toggle buttons are typically used in dense
        //  layouts with many filters and columns, so it is better to clip the
        //  text than to have an ellipsis (the default overrun handler)
        //  potentially cut off even the all-important filter number.
        toggleButton.setTextOverrun( OverrunStyle.CLIP );
    
        return toggleButton;
    }


    public static XToggleButton getProcessingFilterToggleButton( final String filterName,
                                                                 final boolean applyAspectRatio,
                                                                 final boolean selected ) {
        final XToggleButton toggleButton = getFilterToggleButton( filterName,
                                                                  applyAspectRatio,
                                                                  2.0d,
                                                                  true,
                                                                  selected );
    
        return toggleButton;
    }


    public static ToggleButton getParametricToggleButton( final boolean applyAspectRatio ) {
        final ToggleButton toggleButton = getProcessingFilterToggleButton( "Parametric", //$NON-NLS-1$
                                                                           applyAspectRatio,
                                                                           false );
    
        return toggleButton;
    }


    public static XToggleButton getHighLowPassToggleButton( final String filterName,
                                                            final boolean applyAspectRatio,
                                                            final boolean selected ) {
        final String selectedText = "Bypassed"; //$NON-NLS-1$
        final String deselectedText = "Enabled"; //$NON-NLS-1$
        final String tooltipText = "Bypass/Enable " + filterName + " Filter"; //$NON-NLS-1$ //$NON-NLS-2$
    
        // NOTE: JavaFX CSS automatically darkens unselected buttons, and
        // auto-selects the foreground for text fill, but we mimic legacy apps.
        // NOTE: "selected" means "bypassed" and "deselected" means "enabled".
        final XToggleButton toggleButton = getProcessingToggleButton( selectedText,
                                                                      deselectedText,
                                                                      tooltipText,
                                                                      applyAspectRatio,
                                                                      4.0d,
                                                                      false,
                                                                      selected );
    
        return toggleButton;
    }


    public static ToggleButton getGeneralAllPassToggleButton( final boolean applyAspectRatio ) {
        final ToggleButton toggleButton = getProcessingFilterToggleButton( "All Pass", //$NON-NLS-1$
                                                                           applyAspectRatio,
                                                                           true );
    
        return toggleButton;
    }


    public static XToggleButton getFilterToggleButton( final String filterName,
                                                       final boolean applyAspectRatio,
                                                       final double aspectRatio,
                                                       final boolean wordWrap,
                                                       final boolean selected ) {
        final String selectedText = filterName + " Bypassed"; //$NON-NLS-1$
        final String deselectedText = filterName + " Enabled"; //$NON-NLS-1$
        final String tooltipText = "Bypass/Enable " + filterName + " Filter"; //$NON-NLS-1$ //$NON-NLS-2$
    
        // NOTE: JavaFX CSS automatically darkens unselected buttons, and
        // auto-selects the foreground for text fill, but we mimic legacy apps.
        // NOTE: "selected" means "bypassed" and "deselected" means "enabled".
        final XToggleButton toggleButton = getProcessingToggleButton( selectedText,
                                                                      deselectedText,
                                                                      tooltipText,
                                                                      applyAspectRatio,
                                                                      aspectRatio,
                                                                      wordWrap,
                                                                      selected );
    
        return toggleButton;
    }


    public static ToggleButton getEqualizationToggleButton( final boolean applyAspectRatio ) {
        // NOTE: We only have to abbreviate when in the channel strip context.
        final String filterName = applyAspectRatio ? "Equalization" : "EQ"; //$NON-NLS-1$ //$NON-NLS-2$
        final ToggleButton toggleButton = getProcessingFilterToggleButton( filterName,
                                                                           applyAspectRatio,
                                                                           false );
    
        return toggleButton;
    }


    public static ToggleButton getAllFiltersToggleButton( final boolean applyAspectRatio,
                                                          final boolean selected ) {
        final String selectedText = "<<<"; //$NON-NLS-1$
        final String deselectedText = ">>>"; //$NON-NLS-1$
        final String tooltipText = "Bypass/Enable All Filters"; //$NON-NLS-1$
    
        // NOTE: JavaFX CSS automatically darkens unselected buttons, and
        // auto-selects the foreground for text fill, but we mimic legacy apps.
        // NOTE: "selected" means "bypassed" and "deselected" means "enabled".
        final ToggleButton toggleButton = getProcessingToggleButton( selectedText,
                                                                     deselectedText,
                                                                     tooltipText,
                                                                     applyAspectRatio,
                                                                     4.0d,
                                                                     false,
                                                                     selected );
    
        return toggleButton;
    }
}
