/*
 * $Id: TablePdfPTable.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.objects.tables.alternatives;

import java.awt.Color;
import java.io.FileOutputStream;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.Element;
import com.lowagie.mpl.text.PageSize;
import com.lowagie.mpl.text.Paragraph;
import com.lowagie.mpl.text.SimpleCell;
import com.lowagie.mpl.text.SimpleTable;
import com.lowagie.mpl.text.pdf.PdfWriter;
import com.lowagie.mpl.text.rtf.RtfWriter2;

/**
 * Example that is used to test the TableAttributes class.
 */
public class TablePdfPTable {

    /**
     * Example that is used to test the TableAttributes class.
     * @param args no arguments needed
     */
    public static void main(String[] args) {
        System.out.println("TableAttributes");
        // creation of the document with a certain size and certain margins
        Document document = new Document(PageSize.A4.rotate(), 50, 50, 50, 50);
        
        try {
            // creation of the different writers
            PdfWriter.getInstance(document, new FileOutputStream("tableattributes.pdf"));
            RtfWriter2.getInstance(document, new FileOutputStream("tableattributes.rtf"));
            // open the document
            document.open();
            // add content
            SimpleTable table = new SimpleTable();
            table.setCellpadding(5);
            table.setCellspacing(8);
            SimpleCell row = new SimpleCell(SimpleCell.ROW);
            row.setBackgroundColor(Color.yellow);
            SimpleCell cell = new SimpleCell(SimpleCell.CELL);
            cell.setWidth(100f);
            cell.add(new Paragraph("rownumber"));
            row.add(cell);
            cell = new SimpleCell(SimpleCell.CELL);
            cell.setWidth(50f);
            cell.add(new Paragraph("A"));
            row.add(cell);
            cell = new SimpleCell(SimpleCell.CELL);
            cell.setWidth(50f);
            cell.add(new Paragraph("B"));
            row.add(cell);
            cell = new SimpleCell(SimpleCell.CELL);
            cell.setWidth(50f);
            cell.add(new Paragraph("C"));
            row.add(cell);
            table.addElement(row);
            for (int i = 0; i < 100; i++) {
            	row = new SimpleCell(SimpleCell.ROW);
            	switch (i % 3) {
        		case 0:
        			row.setBackgroundColor(Color.red);
        			break;
        		case 1:
        			row.setBackgroundColor(Color.green);
        			break;
        		case 2:
        			row.setBackgroundColor(Color.blue);
        			break;
            	}
            	if (i % 2 == 1) {
            		row.setBorderWidth(3f);
            	}
            	cell = new SimpleCell(SimpleCell.CELL);
            	cell.add(new Paragraph("Row " + (i + 1)));
            	cell.setSpacing_left(20f);
            	row.add(cell);
            	if (i % 5 == 4) {
            		cell = new SimpleCell(SimpleCell.CELL);
            		cell.setColspan(3);
            		cell.setBorderColor(Color.orange);
            		cell.setBorderWidth(5f);
            		cell.add(new Paragraph("Hello!"));
            		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            		row.add(cell);
            	}
            	else {
            		cell = new SimpleCell(SimpleCell.CELL);
            		cell.add(new Paragraph("A"));
            		row.add(cell);
            		cell = new SimpleCell(SimpleCell.CELL);
            		cell.add(new Paragraph("B"));
            		cell.setBackgroundColor(Color.gray);
            		row.add(cell);
            		cell = new SimpleCell(SimpleCell.CELL);
            		cell.add(new Paragraph("C"));
            		row.add(cell);
            	}
            	table.addElement(row);
            }
        	document.add(table);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        // we close the document
        document.close();
    }
	
}
