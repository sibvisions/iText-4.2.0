/*
 * $Id: SimpleRegistrationForm.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.forms;

import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.DocumentException;
import com.lowagie.mpl.text.Rectangle;
import com.lowagie.mpl.text.pdf.PdfContentByte;
import com.lowagie.mpl.text.pdf.PdfFormField;
import com.lowagie.mpl.text.pdf.PdfPCell;
import com.lowagie.mpl.text.pdf.PdfPCellEvent;
import com.lowagie.mpl.text.pdf.PdfPTable;
import com.lowagie.mpl.text.pdf.PdfWriter;
import com.lowagie.mpl.text.pdf.TextField;

/**
 * General example using TableEvents and CellEvents.
 */
public class SimpleRegistrationForm implements PdfPCellEvent {
	
	/** the writer with the acroform */
	private PdfWriter writer;

	/** the current fieldname */
	private String fieldname = "NoName";

	/**
	 * Construct an implementation of PdfPCellEvent.
	 * 
	 * @param writer
	 *            the writer with the Acroform that will have to hold the
	 *            fields.
	 */
	public SimpleRegistrationForm(PdfWriter writer) {
		this.writer = writer;
	}

	/**
	 * Construct an implementation of PdfPCellEvent.
	 * 
	 * @param writer
	 *            the writer with the Acroform that will have to hold the
	 *            fields.
	 * @param fieldname
	 *            the name of the TextField
	 *  
	 */
	public SimpleRegistrationForm(PdfWriter writer, String fieldname) {
		this.writer = writer;
		this.fieldname = fieldname;
	}

	/**
	 * @see com.lowagie.mpl.text.pdf.PdfPCellEvent#cellLayout(com.lowagie.mpl.text.pdf.PdfPCell,
	 *      com.lowagie.mpl.text.Rectangle, com.lowagie.mpl.text.pdf.PdfContentByte[])
	 */
	public void cellLayout(PdfPCell cell, Rectangle position,
			PdfContentByte[] canvases) {
		TextField tf = new TextField(writer, position, fieldname);
		tf.setFontSize(12);
		try {
			PdfFormField field = tf.getTextField();
			writer.addAnnotation(field);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Example originally written by Wendy Smoak to generate a Table with
	 * 'floating boxes'. Adapted by Bruno Lowagie.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// step 1
		Document document = new Document();
		try {
			// step 2

			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("SimpleRegistrationForm.pdf"));
			// step 3
			document.open();
			// step 4
			PdfPTable table = new PdfPTable(2);
			PdfPCell cell;
			table.getDefaultCell().setPadding(5f);

			table.addCell("Your name:");
			cell = new PdfPCell();
			cell.setCellEvent(new SimpleRegistrationForm(writer, "name"));
			table.addCell(cell);

			table.addCell("Your home address:");
			cell = new PdfPCell();
			cell.setCellEvent(new SimpleRegistrationForm(writer, "address"));
			table.addCell(cell);

			table.addCell("Postal code:");
			cell = new PdfPCell();
			cell
					.setCellEvent(new SimpleRegistrationForm(writer,
							"postal_code"));
			table.addCell(cell);

			table.addCell("Your email address:");
			cell = new PdfPCell();
			cell.setCellEvent(new SimpleRegistrationForm(writer, "email"));
			table.addCell(cell);

			document.add(table);

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		// step 5
		document.close();
	}
}