/*
 * $Id: FormPushButton.java 3373 2008-05-12 16:21:24Z xlv $
 *
 * This code is part of the 'iText Tutorial'.
 * You can find the complete tutorial at the following address:
 * http://itextdocs.lowagie.com/tutorial/
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * itext-questions@lists.sourceforge.net
 */

package com.lowagie.examples.forms;


import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.DocumentException;
import com.lowagie.mpl.text.PageSize;
import com.lowagie.mpl.text.Rectangle;
import com.lowagie.mpl.text.pdf.PdfAnnotation;
import com.lowagie.mpl.text.pdf.PdfAppearance;
import com.lowagie.mpl.text.pdf.PdfContentByte;
import com.lowagie.mpl.text.pdf.PdfFormField;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Generates an Acroform with a PushButton
 * @author blowagie
 */
public class FormPushButton {
    /**
     * Generates an Acroform with a PushButton
     * @param args no arguments needed here
     */
    public static void main(String[] args) {
        
        System.out.println("PushButton");
        Document.compress = false;
        // step 1: creation of a document-object
        Document document = new Document(PageSize.A4);
        
        try {
            
            // step 2:
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pushbutton.pdf"));
            
            // step 3: we open the document
            document.open();
            
            // step 4:
            PdfFormField pushbutton = PdfFormField.createPushButton(writer);
            PdfContentByte cb = writer.getDirectContent();
            cb.moveTo(0, 0);
            PdfAppearance normal = cb.createAppearance(100, 50);
            normal.setColorFill(Color.GRAY);
            normal.rectangle(5, 5, 90, 40);
            normal.fill();
            PdfAppearance rollover = cb.createAppearance(100, 50);
            rollover.setColorFill(Color.RED);
            rollover.rectangle(5, 5, 90, 40);
            rollover.fill();
            PdfAppearance down = cb.createAppearance(100, 50);
            down.setColorFill(Color.BLUE);
            down.rectangle(5, 5, 90, 40);
            down.fill();            
            pushbutton.setFieldName("PushMe");
            pushbutton.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, normal);
            pushbutton.setAppearance(PdfAnnotation.APPEARANCE_ROLLOVER, rollover);
            pushbutton.setAppearance(PdfAnnotation.APPEARANCE_DOWN, down);
            pushbutton.setWidget(new Rectangle(100, 700, 200, 750), PdfAnnotation.HIGHLIGHT_PUSH);
            writer.addAnnotation(pushbutton);
            
        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        
        // step 5: we close the document
        document.close();
    }
}