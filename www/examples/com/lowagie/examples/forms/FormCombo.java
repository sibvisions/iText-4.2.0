/*
 * $Id: FormCombo.java 3373 2008-05-12 16:21:24Z xlv $
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


import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.DocumentException;
import com.lowagie.mpl.text.PageSize;
import com.lowagie.mpl.text.Rectangle;
import com.lowagie.mpl.text.pdf.PdfAnnotation;
import com.lowagie.mpl.text.pdf.PdfContentByte;
import com.lowagie.mpl.text.pdf.PdfFormField;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Generates an Acroform with a Combobox
 * @author blowagie
 */
public class FormCombo {
    /**
     * Generates an Acroform with a Combobox
     * @param args no arguments needed here
     */
    public static void main(String[] args) {
        
        System.out.println("Combo");
        
        // step 1: creation of a document-object
        Document document = new Document(PageSize.A4);
        
        try {
            
            // step 2:
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("combo.pdf"));
            
            // step 3: we open the document
            document.open();
            
            // step 4:
            PdfContentByte cb = writer.getDirectContent();
            cb.moveTo(0, 0);
            String options[] = {"Red", "Green", "Blue"};
            PdfFormField field = PdfFormField.createCombo(writer, true, options, 0);
            field.setWidget(new Rectangle(100, 700, 180, 720), PdfAnnotation.HIGHLIGHT_INVERT);
            field.setFieldName("ACombo");
            field.setValueAsString("Red");
            writer.addAnnotation(field);
            
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