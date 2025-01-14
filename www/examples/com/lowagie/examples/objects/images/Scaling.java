/*
 * $Id: Scaling.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.objects.images;

import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.DocumentException;
import com.lowagie.mpl.text.Image;
import com.lowagie.mpl.text.Paragraph;
import com.lowagie.mpl.text.pdf.PdfWriter;
/**
 * Scaling of images.
 */
public class Scaling {
    /**
     * Scaling an image.
     * @param args no arguments needed
     */
    public static void main(String[] args) {
        
        System.out.println("Scaling an Image");
        
        // step 1: creation of a document-object
        Document document = new Document();
        
        try {
            
            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            
            PdfWriter.getInstance(document, new FileOutputStream("scaling.pdf"));
            
            // step 3: we open the document
            document.open();
            
            // step 4: we add content
            Image jpg1 = Image.getInstance("otsoe.jpg");
            jpg1.scaleAbsolute(160, 120);
            document.add(new Paragraph("scaleAbsolute(160, 120)"));
            document.add(jpg1);
            Image jpg2 = Image.getInstance("otsoe.jpg");
            jpg2.scalePercent(50);
            document.add(new Paragraph("scalePercent(50)"));
            document.add(jpg2);
            Image jpg3 = Image.getInstance("otsoe.jpg");
            jpg3.scaleAbsolute(320, 120);
            document.add(new Paragraph("scaleAbsolute(320, 120)"));
            document.add(jpg3);
            Image jpg4 = Image.getInstance("otsoe.jpg");
            jpg4.scalePercent(100, 50);
            document.add(new Paragraph("scalePercent(100, 50)"));
            document.add(jpg4);
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
