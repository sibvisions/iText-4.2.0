/*
 * $Id: BitsetArgument.java 3271 2008-04-18 20:39:42Z xlv $
 * Copyright (c) 2005-2007 Bruno Lowagie, Carsten Hammer
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

/*
 * This class was originally published under the MPL by Bruno Lowagie
 * and Carsten Hammer.
 * It was a part of iText, a Java-PDF library. You can now use it under
 * the MIT License; for backward compatibility you can also use it under
 * the MPL version 1.1: http://www.mozilla.org/MPL/
 * A copy of the MPL license is bundled with the source code FYI.
 */

package com.lowagie.mpl.toolbox.arguments;

import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import com.lowagie.mpl.toolbox.AbstractTool;

/**
 * Argument that results in a set of "1" and "0" values.
 * @since 2.1.1 (imported from itexttoolbox project)
 */
public class BitsetArgument extends AbstractArgument {
    /** These are the different options that can be true or false. */
    private JCheckBox[] options;

    /**
     * Constructs an BitsetArgument.
     * @param tool the tool that needs this argument
     * @param name the name of the argument
     * @param description the description of the argument
     * @param options the different options that can be true or false
     */
    public BitsetArgument(AbstractTool tool, String name, String description,
                          String[] options) {
        super(tool, name, description, null);
        this.options = new JCheckBox[options.length];
        for (int i = 0; i < options.length; i++) {
            this.options[i] = new JCheckBox(options[i]);
        }
    }

    /**
     *
     * @see com.lowagie.mpl.toolbox.arguments.StringArgument#getUsage()
     * @return String
     */
    public String getUsage() {
        StringBuffer buf = new StringBuffer(super.getUsage());
        buf.append("    possible options:\n");
        for (int i = 0; i < options.length; i++) {
            buf.append("    - ");
            buf.append(options[i].getText());
            buf.append('\n');
        }
        return buf.toString();
    }

    /**
     *
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     * @param evt ActionEvent
     */
    public void actionPerformed(ActionEvent evt) {
        Object[] message = new Object[1 + options.length];
        message[0] = "Check the options you need:";
        System.arraycopy(options, 0, message, 1, options.length);
        int result = JOptionPane.showOptionDialog(
                tool.getInternalFrame(),
                message,
                description,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null
                     );
        if (result == 0) {
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < options.length; i++) {
                if (options[i].isSelected()) {
                    buf.append('1');
                } else {
                    buf.append('0');
                }
            }
            setValue(buf.toString());
        }
    }
}
