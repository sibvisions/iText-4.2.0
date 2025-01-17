/*
 * $Id: Background.java 3373 2008-05-12 16:21:24Z xlv $
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

package com.lowagie.examples.objects.chunk;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.mpl.text.Chunk;
import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.DocumentException;
import com.lowagie.mpl.text.FontFactory;
import com.lowagie.mpl.text.Paragraph;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Demonstrates how 'highlight' Chunks using a Background color.
 * 
 * @author blowagie
 */

public class Background {

	/**
	 * Using Background Colors in Chunks.
	 * 
	 * @param args no arguments needed here
	 */
	public static void main(String[] args) {

		System.out.println("Background color");

		// step 1: creation of a document-object
		Document document = new Document();
		try {
			// step 2:
			// we create a writer that listens to the document
			PdfWriter.getInstance(document,
					new FileOutputStream("Background.pdf"));

			// step 3: we open the document
			document.open();
			// step 4:
			Chunk high = new Chunk("highlighted");
			high.setBackground(new Color(0xFF, 0xFF, 0x00));
			Paragraph p = new Paragraph("The following chunk is ");
			p.add(high);
			document.add(p);
			Chunk c;
			c = new Chunk("background");
			c.setBackground(new Color(0xC0, 0xC0, 0xC0));
			document.add(c);
			c = new Chunk("background");
			c.setTextRise(8);
			c.setBackground(new Color(0xFF, 0xDE, 0xAD));
			document.add(c);
			c = new Chunk("background", FontFactory.getFont(FontFactory.HELVETICA, 8));
			c.setBackground(new Color(0x70, 0x70, 0x70));
			document.add(c);
			c = new Chunk("background");
			c.setBackground(new Color(0x00, 0x80, 0x80));
			document.add(c);
			document.add(Chunk.NEWLINE);
			p = new Paragraph("An more complex ");
			c = new Chunk("background chunk");
			c.setBackground(new Color(0xFF, 0x00, 0x00), 5f, 30f, -10f, 0f);
			p.add(c);
			p.add(" example");
			document.add(p);
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		// step 5: we close the document
		document.close();
	}
}