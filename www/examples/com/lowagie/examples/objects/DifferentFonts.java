/*
 * $Id: DifferentFonts.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.objects;

import java.io.FileOutputStream;

import com.lowagie.mpl.text.Chunk;
import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.Font;
import com.lowagie.mpl.text.Paragraph;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Selects the appropriate fonts that contain the glyphs needed to render text correctly.
 */
public class DifferentFonts {
    /**
     * Using FontSelector.
     * @param args no arguments needed
     */
    public static void main(String[] args) {
        try {
        	// step 1
        	Document document = new Document();
        	// step 2
            PdfWriter.getInstance(document, new FileOutputStream("differentfonts.pdf"));
            // step 3
            document.open();
            // step 4
            Paragraph p = new Paragraph();
            p.add(new Chunk("This text is in Times Roman. This is ZapfDingbats: ", new Font(Font.TIMES_ROMAN, 12)));
            p.add(new Chunk("abcdefghijklmnopqrstuvwxyz", new Font(Font.ZAPFDINGBATS, 12)));
            p.add(new Chunk(". This is font Symbol: ", new Font(Font.TIMES_ROMAN, 12)));
            p.add(new Chunk("abcdefghijklmnopqrstuvwxyz", new Font(Font.SYMBOL, 12)));
            document.add(new Paragraph(p));
            // step 5
            document.close();
        }
        catch(Exception de) {
            de.printStackTrace();
        }
    }
}
