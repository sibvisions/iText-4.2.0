/*
 * $Id: RepeatingTable.java 3373 2008-05-12 16:21:24Z xlv $
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

import com.lowagie.mpl.text.Cell;
import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.Element;
import com.lowagie.mpl.text.Font;
import com.lowagie.mpl.text.FontFactory;
import com.lowagie.mpl.text.PageSize;
import com.lowagie.mpl.text.Paragraph;
import com.lowagie.mpl.text.Phrase;
import com.lowagie.mpl.text.Rectangle;
import com.lowagie.mpl.text.Table;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Shows how a table is split if it doesn't fit the page.
 */
public class RepeatingTable {

    /**
     * Shows how a table is split if it doesn't fit the page.
     * @param args no arguments needed
     */
    public static void main(String[] args) {
        System.out.println("table splitting");
        // creation of the document with a certain size and certain margins
        Document document = new Document(PageSize.A4.rotate(), 50, 50, 50, 50);
        
        try {
            // creation of the different writers
            PdfWriter.getInstance(document, new FileOutputStream("repeatingtable.pdf"));
            
            // we add some meta information to the document
            document.addAuthor("Alan Soukup");
            document.addSubject("This is the result of a Test.");
            
            document.open();
            
            Table datatable = new Table(10);
            
            int headerwidths[] = {10, 24, 12, 12, 7, 7, 7, 7, 7, 7};
            datatable.setWidths(headerwidths);
            datatable.setWidth(100);
            datatable.setPadding(3);
            
            // the first cell spans 10 columns
            Cell cell = new Cell(new Phrase("Administration -System Users Report", FontFactory.getFont(FontFactory.HELVETICA, 24, Font.BOLD)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setLeading(30);
            cell.setColspan(10);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setBackgroundColor(new Color(0xC0, 0xC0, 0xC0));
            datatable.addCell(cell);
            
            // These cells span 2 rows
            datatable.getDefaultCell().setBorderWidth(2);
            datatable.getDefaultCell().setHorizontalAlignment(1);
            datatable.addCell("User Id");
            datatable.addCell("Name\nAddress");
            datatable.addCell("Company");
            datatable.addCell("Department");
            datatable.addCell("Admin");
            datatable.addCell("Data");
            datatable.addCell("Expl");
            datatable.addCell("Prod");
            datatable.addCell("Proj");
            datatable.addCell("Online");
            
            // this is the end of the table header
            datatable.endHeaders();
            
            datatable.getDefaultCell().setBorderWidth(1);
            
            for (int i = 1; i < 30; i++) {
                
                datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
                
                datatable.addCell("myUserId");
                datatable.addCell("Somebody with a very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very long long name");
                datatable.addCell("No Name Company");
                datatable.addCell("D" + i);
                
                datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
                datatable.addCell("No");
                datatable.addCell("Yes");
                datatable.addCell("No");
                datatable.addCell("Yes");
                datatable.addCell("No");
                datatable.addCell("Yes");
                
            }
            document.add(new Paragraph("com.lowagie.text.Table - Cells split"));
            document.add(datatable);
            document.newPage();
            document.add(new Paragraph("com.lowagie.text.pdf.PdfPTable - Cells split\n\n"));
            datatable.setConvert2pdfptable(true);
            document.add(datatable);
            document.newPage();
            document.add(new Paragraph("com.lowagie.text.Table - Cells kept together"));
            datatable.setConvert2pdfptable(false);
            datatable.setCellsFitPage(true);
            document.add(datatable);
            document.newPage();
            document.add(new Paragraph("com.lowagie.text.pdf.PdfPTable - Cells kept together\n\n"));
            datatable.setConvert2pdfptable(true);
            document.add(datatable);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        // we close the document
        document.close();
    }
}
