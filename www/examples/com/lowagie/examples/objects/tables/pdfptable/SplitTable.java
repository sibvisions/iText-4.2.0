/*
 * $Id: SplitTable.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.objects.tables.pdfptable;

import java.io.FileOutputStream;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.PageSize;
import com.lowagie.mpl.text.pdf.PdfContentByte;
import com.lowagie.mpl.text.pdf.PdfPTable;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Break a large table up into different smaller tables in order to save memory.
 */
public class SplitTable {
	/**
	 * Break a large table up into several smaller tables for memory management
	 * purposes.
	 * 
	 * @param args
	 *            the number of rows for each table fragment.
	 */
	public static void main(String[] args) {

		System.out.println("Split Table");
		// step1
		Document document = new Document(PageSize.A4, 10, 10, 10, 10);
		try {
			// step2
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
					"SplitTable.pdf"));
			// step3
			document.open();
			// step4

            PdfContentByte cb = writer.getDirectContent();
            PdfPTable table = new PdfPTable(10);
            for (int k = 1; k <= 100; ++k) {
                table.addCell("The number " + k);
            }
            table.setTotalWidth(800);
            table.writeSelectedRows(0, 5, 0, -1, 50, 650, cb);
            document.newPage();
            table.writeSelectedRows(5, -1, 0, -1, 50, 650, cb);
            document.close();
		} catch (Exception de) {
			de.printStackTrace();
		}
		// step5
		document.close();
	}
}