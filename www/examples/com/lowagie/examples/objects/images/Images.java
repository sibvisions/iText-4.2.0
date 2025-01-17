/*
 * $Id: Images.java 3373 2008-05-12 16:21:24Z xlv $
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
 * General Images example.
 */
public class Images {
    
    /**
     * General Images example
     * @param args	no arguments needed
     */
    public static void main(String[] args) {
        
        System.out.println("Images");
        
        // step 1: creation of a document-object
        Document document = new Document();
        
        try {
            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            PdfWriter.getInstance(document, new FileOutputStream("Images.pdf"));
            
            // step 3: we open the document
            document.open();
            
            // step 4:
            document.add(new Paragraph("A picture of my dog: otsoe.jpg"));
            Image jpg = Image.getInstance("otsoe.jpg");
            document.add(jpg);
            document.add(new Paragraph("getacro.gif"));
            Image gif= Image.getInstance("getacro.gif");
            document.add(gif);
            document.add(new Paragraph("pngnow.png"));
            Image png = Image.getInstance("pngnow.png");
            document.add(png);
            document.add(new Paragraph("iText.bmp"));
            Image bmp = Image.getInstance("iText.bmp");
            document.add(bmp);
            document.add(new Paragraph("iText.wmf"));
            Image wmf = Image.getInstance("iText.wmf");
            document.add(wmf);
            document.add(new Paragraph("iText.tif"));
            Image tiff = Image.getInstance("iText.tif");
            document.add(tiff);
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