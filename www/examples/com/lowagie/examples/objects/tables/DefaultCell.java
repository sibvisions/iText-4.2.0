/*
 * $Id: DefaultCell.java 3373 2008-05-12 16:21:24Z xlv $
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
import java.io.IOException;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.DocumentException;
import com.lowagie.mpl.text.Paragraph;
import com.lowagie.mpl.text.pdf.PdfPCell;
import com.lowagie.mpl.text.pdf.PdfPTable;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * A very simple PdfPTable example using getDefaultCell().
 */
public class DefaultCell {

	/**
	 * Demonstrates the use of getDefaultCell().
	 * 
	 * @param args
	 *            no arguments needed
	 */
	public static void main(String[] args) {

		System.out.println("DefaultCell");

		// step 1: creation of a document-object
		Document document = new Document();

		try {
			// step 2:
			// we create a writer that listens to the document
			// and directs a PDF-stream to a file
			PdfWriter.getInstance(document, new FileOutputStream("DefaultCell.pdf"));

			// step 3: we open the document
			document.open();

			PdfPTable table = new PdfPTable(3);
			PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 3"));
			cell.setColspan(3);
			table.addCell(cell);
			table.addCell("1.1");
			table.addCell("2.1");
			table.addCell("3.1");
			table.getDefaultCell().setGrayFill(0.8f);
			table.addCell("1.2");
			table.addCell("2.2");
			table.addCell("3.2");
			table.getDefaultCell().setGrayFill(0f);
			table.getDefaultCell().setBorderColor(new Color(255, 0, 0));
			table.addCell("cell test1");
			table.getDefaultCell().setColspan(2);
			table.getDefaultCell().setBackgroundColor(new Color(0xC0, 0xC0, 0xC0));
			table.addCell("cell test2");
			document.add(table);
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		// step 5: we close the document
		document.close();
	}
}