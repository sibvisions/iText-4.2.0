/*
 * $Id: RegisterFont.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.fonts.getting;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.DocumentException;
import com.lowagie.mpl.text.Font;
import com.lowagie.mpl.text.FontFactory;
import com.lowagie.mpl.text.Paragraph;
import com.lowagie.mpl.text.pdf.BaseFont;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Registering Fonts with the FontFactory.
 */
public class RegisterFont {

	/**
	 * Registering fonts with the fontfactory.
	 * @param args no arguments needed
	 */
	public static void main(String[] args) {
        
        System.out.println("Registering fonts with the FontFactory");
        
        FontFactory.register("c:\\windows\\fonts\\comicbd.ttf");
        FontFactory.register("c:\\windows\\fonts\\comic.ttf");
        FontFactory.register("c:\\windows\\fonts\\msgothic.ttc");
        
        // step 1: creation of a document-object
        Document document = new Document();
        
        try {
            // step 2: creation of the writer
            PdfWriter.getInstance(document, new FileOutputStream("registerfont.pdf"));
            
            // step 3: we open the document
            document.open();
            
            // step 4: we add content to the document
            Font font0 = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.WINANSI, 12);
            String text0 = "This is the quite popular built in font '" + BaseFont.HELVETICA + "'.";
            document.add(new Paragraph(text0, font0));
            Font font1 = FontFactory.getFont("ComicSansMS", BaseFont.WINANSI, 12);
            String text1 = "This is the quite popular True Type font 'ComicSansMS'.";
            document.add(new Paragraph(text1, font1));
            Font font2 = FontFactory.getFont("ComicSansMS-Bold", BaseFont.WINANSI, 12);
            String text2 = "This is the quite popular True Type font 'ComicSansMS-Bold'.";
            document.add(new Paragraph(text2, font2));
            Font font3= FontFactory.getFont("MS-PGothic", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 12);
            String text3 = "\u5951\u7d04\u8005\u4f4f\u6240\u30e9\u30a4\u30f3\uff11";
            document.add(new Paragraph(text3, font3));
    		BufferedWriter out = new BufferedWriter(new FileWriter("registered.txt"));
            out.write("These fonts were registered at the FontFactory:\r\n");
            for (Iterator i = FontFactory.getRegisteredFonts().iterator(); i.hasNext(); ) {
                out.write((String) i.next());
                out.write("\r\n");
            }
            out.write("\r\n\r\nThese are the families these fonts belong to:\r\n");
            for (Iterator i = FontFactory.getRegisteredFamilies().iterator(); i.hasNext(); ) {
                out.write((String) i.next());
                out.write("\r\n");
            }
            out.flush();
            out.close();
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