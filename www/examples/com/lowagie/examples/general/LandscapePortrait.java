/*
 * $Id: LandscapePortrait.java 3373 2008-05-12 16:21:24Z xlv $
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

package com.lowagie.examples.general;


import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.DocumentException;
import com.lowagie.mpl.text.PageSize;
import com.lowagie.mpl.text.Paragraph;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Demonstrates the creating PDF in portrait/landscape.
 * @author blowagie
 */
public class LandscapePortrait {
    /**
     * Creates a PDF document with pages in portrait/landscape.
     * @param args no arguments needed here
     */
    public static void main(String[] args) {
        
        System.out.println("Documents in Landscape and Portrait format");
        // step 1: creation of a document-object
        Document document = new Document(PageSize.A4.rotate());
        
        try {
            
            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            
            PdfWriter.getInstance(document, new FileOutputStream("LandscapePortrait.pdf"));
            
            // step 3: we open the document
            document.open();
            
            // step 4: we add some content
            document.add(new Paragraph("To create a document in landscape format, just make the height smaller than the width. For instance by rotating the PageSize Rectangle: PageSize.A4.rotate()"));
            document.setPageSize(PageSize.A4);
            document.newPage();
            document.add(new Paragraph("This is portrait again"));
            
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
