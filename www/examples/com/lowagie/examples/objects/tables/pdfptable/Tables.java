/*
 * $Id: Tables.java 3373 2008-05-12 16:21:24Z xlv $
 *
 * This code is free software. It may only be copied or modified
 * if you include the following copyright notice:
 *
 * --> Copyright 2001-2005 by G. Martinelli and Bruno Lowagie <--
 *
 * This code is part of the 'iText Tutorial'.
 * You can find the complete tutorial at the following address:
 * http://www.lowagie.com/iText/tutorial/
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * itext-questions@lists.sourceforge.net
 */
package com.lowagie.examples.objects.tables.pdfptable;

import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.DocumentException;
import com.lowagie.mpl.text.Font;
import com.lowagie.mpl.text.FontFactory;
import com.lowagie.mpl.text.PageSize;
import com.lowagie.mpl.text.Phrase;
import com.lowagie.mpl.text.pdf.PdfPCell;
import com.lowagie.mpl.text.pdf.PdfPTable;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Adds a table to a page twice.
 */
public class Tables {

	/**
	 * Adds a table to a page twice.
	 * 
	 * @param args
	 *            no arguments needed
	 */
	public static void main(String[] args) {

		Font font8 = FontFactory.getFont(FontFactory.HELVETICA, 8);
		
		// step 1
		Document document = new Document(PageSize.A4);

		try {
			// step 2
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("tables.pdf"));
			float width = document.getPageSize().getWidth();
			float height = document.getPageSize().getHeight();
			// step 3
			document.open();

			// step 4
			float[] columnDefinitionSize = { 33.33F, 33.33F, 33.33F };

			float pos = height / 2;
			PdfPTable table = null;
			PdfPCell cell = null;

			table = new PdfPTable(columnDefinitionSize);
			table.getDefaultCell().setBorder(0);
			table.setHorizontalAlignment(0);
			table.setTotalWidth(width - 72);
			table.setLockedWidth(true);

			cell = new PdfPCell(new Phrase("Table added with document.add()"));
			cell.setColspan(columnDefinitionSize.length);
			table.addCell(cell);
			table.addCell(new Phrase("Louis Pasteur", font8));
			table.addCell(new Phrase("Albert Einstein", font8));
			table.addCell(new Phrase("Isaac Newton", font8));
			table.addCell(new Phrase("8, Rabic street", font8));
			table.addCell(new Phrase("2 Photons Avenue", font8));
			table.addCell(new Phrase("32 Gravitation Court", font8));
			table.addCell(new Phrase("39100 Dole France", font8));
			table.addCell(new Phrase("12345 Ulm Germany", font8));
			table.addCell(new Phrase("45789 Cambridge  England", font8));
			
			document.add(table);
			
			table = new PdfPTable(columnDefinitionSize);
			table.getDefaultCell().setBorder(0);
			table.setHorizontalAlignment(0);
			table.setTotalWidth(width - 72);
			table.setLockedWidth(true);

			cell = new PdfPCell(new Phrase("Table added with writeSelectedRows"));
			cell.setColspan(columnDefinitionSize.length);
			table.addCell(cell);
			table.addCell(new Phrase("Louis Pasteur", font8));
			table.addCell(new Phrase("Albert Einstein", font8));
			table.addCell(new Phrase("Isaac Newton", font8));
			table.addCell(new Phrase("8, Rabic street", font8));
			table.addCell(new Phrase("2 Photons Avenue", font8));
			table.addCell(new Phrase("32 Gravitation Court", font8));
			table.addCell(new Phrase("39100 Dole France", font8));
			table.addCell(new Phrase("12345 Ulm Germany", font8));
			table.addCell(new Phrase("45789 Cambridge  England", font8));
			
			table.writeSelectedRows(0, -1, 50, pos, writer.getDirectContent());
		}

		catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		// step 5
		document.close();
	}
}