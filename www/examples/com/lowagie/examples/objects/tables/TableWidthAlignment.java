/*
 * $Id: TableWidthAlignment.java 3373 2008-05-12 16:21:24Z xlv $
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
import com.lowagie.mpl.text.Element;
import com.lowagie.mpl.text.PageSize;
import com.lowagie.mpl.text.Paragraph;
import com.lowagie.mpl.text.pdf.PdfPCell;
import com.lowagie.mpl.text.pdf.PdfPTable;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Changing the width and alignment of the complete table.
 */
public class TableWidthAlignment {

	/**
	 * Changing the width and alignment of the complete table.
	 * 
	 * @param args
	 *            no arguments needed
	 */
	public static void main(String[] args) {

		System.out.println("table width and alignment");
		// step1
		Document document = new Document(PageSize.A4);
		try {
			// step2
			PdfWriter.getInstance(document,
					new FileOutputStream("TableWidthAlignment.pdf"));
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
			document.add(table);
			table.setWidthPercentage(100);
			document.add(table);
			table.setWidthPercentage(50);
			table.setHorizontalAlignment(Element.ALIGN_RIGHT);
			document.add(table);
			table.setHorizontalAlignment(Element.ALIGN_LEFT);
			document.add(table);
		} catch (Exception de) {
			de.printStackTrace();
		}
		// step5
		document.close();
	}
}