/*
 * $Id: Concatenate.java 3373 2008-05-12 16:21:24Z xlv $
 *
 * This code is free software. It may only be copied or modified
 * if you include the following copyright notice:
 *
 * This class by Mark Thompson. Copyright (c) 2002 Mark Thompson.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */

/**
 * This class demonstrates copying a PDF file using iText.
 * @author Mark Thompson
 */
package com.lowagie.examples.general.copystamp;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.pdf.PRAcroForm;
import com.lowagie.mpl.text.pdf.PdfCopy;
import com.lowagie.mpl.text.pdf.PdfImportedPage;
import com.lowagie.mpl.text.pdf.PdfReader;
import com.lowagie.mpl.text.pdf.SimpleBookmark;

/**
 * Tool that can be used to concatenate existing PDF files.
 */
public class Concatenate {

    /**
     * This class can be used to concatenate existing PDF files.
     * (This was an example known as PdfCopy.java)
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        if (args.length < 2) {
            System.err.println("arguments: file1 [file2 ...] destfile");
        }
        else {
        	System.out.println("PdfCopy example");
            try {
                int pageOffset = 0;
                ArrayList master = new ArrayList();
                int f = 0;
                String outFile = args[args.length-1];
                Document document = null;
                PdfCopy  writer = null;
                while (f < args.length-1) {
                    // we create a reader for a certain document
                    PdfReader reader = new PdfReader(args[f]);
                    reader.consolidateNamedDestinations();
                    // we retrieve the total number of pages
                    int n = reader.getNumberOfPages();
                    List bookmarks = SimpleBookmark.getBookmark(reader);
                    if (bookmarks != null) {
                        if (pageOffset != 0)
                            SimpleBookmark.shiftPageNumbers(bookmarks, pageOffset, null);
                        master.addAll(bookmarks);
                    }
                    pageOffset += n;
                    
                    if (f == 0) {
                        // step 1: creation of a document-object
                        document = new Document(reader.getPageSizeWithRotation(1));
                        // step 2: we create a writer that listens to the document
                        writer = new PdfCopy(document, new FileOutputStream(outFile));
                        // step 3: we open the document
                        document.open();
                    }
                    // step 4: we add content
                    PdfImportedPage page;
                    for (int i = 0; i < n; ) {
                        ++i;
                        page = writer.getImportedPage(reader, i);
                        writer.addPage(page);
                    }
                    PRAcroForm form = reader.getAcroForm();
                    if (form != null)
                        writer.copyAcroForm(reader);
                    f++;
                }
                if (!master.isEmpty())
                    writer.setOutlines(master);
                // step 5: we close the document
                document.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
