/*
 * $Id: TextFields.java 3373 2008-05-12 16:21:24Z xlv $
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
import com.lowagie.mpl.text.Element;
import com.lowagie.mpl.text.PageSize;
import com.lowagie.mpl.text.Rectangle;
import com.lowagie.mpl.text.pdf.PdfBorderDictionary;
import com.lowagie.mpl.text.pdf.PdfFormField;
import com.lowagie.mpl.text.pdf.PdfWriter;
import com.lowagie.mpl.text.pdf.TextField;

/**
 * Demonstrates the use of PageSize.
 * @author blowagie
 */
public class TextFields {
    /**
     * Creates a PDF document with a certain pagesize
     * @param args no arguments needed here
     */
    public static void main(String[] args) {
        
        System.out.println("Textfields");
        
        // step 1: creation of a document-object
        Document document = new Document(PageSize.A4.rotate());
        
        try {
            
            // step 2:
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("TextFields.pdf"));
            
            // step 3: we open the document
            document.open();
            
            // step 4:
            TextField tf = new TextField(writer, new Rectangle(100, 300, 100 + 100, 300 + 50), "Dickens");
            tf.setBackgroundColor(Color.RED);
            tf.setBorderColor(Color.BLUE);
            tf.setBorderWidth(2);
            tf.setBorderStyle(PdfBorderDictionary.STYLE_BEVELED);
            tf.setText("It was the best of times, it was the worst of times, it was the age of wisdom...");
            tf.setAlignment(Element.ALIGN_CENTER);
            tf.setOptions(TextField.MULTILINE | TextField.REQUIRED);
            tf.setRotation(90);
            PdfFormField field = tf.getTextField();
            writer.addAnnotation(field);
            
            tf = new TextField(writer, new Rectangle(250, 300, 250 + 100, 300 + 20), "Combos");
            tf.setBackgroundColor(Color.RED);
            tf.setBorderColor(Color.BLUE);
            tf.setBorderWidth(2);
            tf.setFontSize(10);
            tf.setBorderStyle(PdfBorderDictionary.STYLE_INSET);
            tf.setVisibility(TextField.VISIBLE_BUT_DOES_NOT_PRINT);
            tf.setChoices(new String[]{"First", "Second"});
            tf.setChoiceExports(new String[]{"value1", "value2"});
            tf.setRotation(90);
            field = tf.getComboField();
            writer.addAnnotation(field);
            
            tf = new TextField(writer, new Rectangle(400, 300, 400 + 100, 300 + 50), "Lists");
            tf.setBackgroundColor(Color.YELLOW);
            tf.setBorderColor(Color.RED);
            tf.setBorderWidth(2);
            tf.setBorderStyle(PdfBorderDictionary.STYLE_DASHED);
            tf.setFontSize(10);
            tf.setChoices(new String[]{"a", "b", "c", "d", "e", "f", "g", "h"});
            tf.setRotation(90);
            tf.setChoiceSelection(4);
            field = tf.getListField();
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