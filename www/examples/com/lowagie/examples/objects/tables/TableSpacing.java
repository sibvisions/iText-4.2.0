/*
 * $Id: TableSpacing.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.objects.tables;

import java.awt.Color;
import java.io.FileOutputStream;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.PageSize;
import com.lowagie.mpl.text.Paragraph;
import com.lowagie.mpl.text.pdf.PdfPCell;
import com.lowagie.mpl.text.pdf.PdfPTable;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Defining the spacing between the table and other content.
 */
public class TableSpacing {

	/**
	 * Defining the spacing between the table and other content.
	 * 
	 * @param args
	 *            no arguments needed
	 */
	public static void main(String[] args) {

		System.out.println("TableSpacing");
		// step1
		Document document = new Document(PageSize.A4);
		try {
			// step2
			PdfWriter.getInstance(document,
					new FileOutputStream("TableSpacing.pdf"));
			// step3
			document.open();
			// step4
			PdfPTable table = new PdfPTable(3);
			PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 3"));
			cell.setColspan(3);
			table.addCell(cell);
			table.addCell("1.1");
			table.addCell("2.1");
			table.addCell("3.1");
			table.addCell("1.2");
			table.addCell("2.2");
			table.addCell("3.2");
			cell = new PdfPCell(new Paragraph("cell test1"));
			cell.setBorderColor(new Color(255, 0, 0));
			table.addCell(cell);
			cell = new PdfPCell(new Paragraph("cell test2"));
			cell.setColspan(2);
			cell.setBackgroundColor(new Color(0xC0, 0xC0, 0xC0));
			table.addCell(cell);
			table.setWidthPercentage(50);
			document.add(new Paragraph("We add 2 tables:"));
			document.add(table);
			document.add(table);
			document.add(new Paragraph("They are glued to eachother"));
			document.add(table);
			document.add(new Paragraph("This is not very nice. Turn to the next page to see how we solved this"));
			document.newPage();
			document.add(new Paragraph("We add 2 tables, but with a certain 'SpacingBefore':"));
			table.setSpacingBefore(15f);
			document.add(table);
			document.add(table);
			document.add(new Paragraph("Unfortunately, there was no spacing after."));
			table.setSpacingAfter(15f);
			document.add(table);
			document.add(new Paragraph("This is much better, don't you think so?"));
		} catch (Exception de) {
			de.printStackTrace();
		}
		// step5
		document.close();
	}
}