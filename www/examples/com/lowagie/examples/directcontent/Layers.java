/*
 * $Id: Layers.java 3838 2009-04-07 18:34:15Z mstorer $
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
package com.lowagie.examples.directcontent;

import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.mpl.text.Chunk;
import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.DocumentException;
import com.lowagie.mpl.text.Image;
import com.lowagie.mpl.text.Paragraph;
import com.lowagie.mpl.text.pdf.PdfContentByte;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Explains the concept concerning PdfContentByte layers.
 */
public class Layers {
    
    /**
     * Draws different things into different layers.
     * @param args no arguments needed
     */
    public static void main(String[] args) {
        
        System.out.println("Layers");
        
        // step 1: creation of a document-object
        Document document = new Document();
        
        try {
            
            // step 2: creation of the writer
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("layers.pdf"));
            
            // step 3: we open the document
            document.open();
            
            // step 4:
            
            // high level
            Paragraph p = new Paragraph();
            for (int i = 0; i < 100; i++) p.add(new Chunk("Blah blah blah blah blah. "));
            document.add(p);
            Image img = Image.getInstance("hitchcock.png");
            img.setAbsolutePosition(100, 500);
            document.add(img);
            
            // low level
            PdfContentByte cb = writer.getDirectContent();
            PdfContentByte cbu = writer.getDirectContentUnder();
            cb.setRGBColorFill(0xFF, 0xFF, 0xFF);
            cb.circle(250.0f, 500.0f, 50.0f);
            cb.fill();
            cb.sanityCheck();
            
            cbu.setRGBColorFill(0xFF, 0x00, 0x00);
            cbu.circle(250.0f, 500.0f, 100.0f);
            cbu.fill();
            cbu.sanityCheck();
            
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
