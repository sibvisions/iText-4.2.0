/*
 * $Id: VerticalTextInCells.java 3373 2008-05-12 16:21:24Z xlv $
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

import java.awt.Color;
import java.io.FileOutputStream;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.Element;
import com.lowagie.mpl.text.Image;
import com.lowagie.mpl.text.PageSize;
import com.lowagie.mpl.text.pdf.BaseFont;
import com.lowagie.mpl.text.pdf.PdfPCell;
import com.lowagie.mpl.text.pdf.PdfPTable;
import com.lowagie.mpl.text.pdf.PdfTemplate;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Vertical Text in Cells.
 */
public class VerticalTextInCells {
    
    /**
     * Example with vertical text in Cells.
     * @param args
     * 		no arguments needed
     */
    public static void main(String[] args) {

		System.out.println("Vertical text in cells");
        // step1
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            // step2
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("VerticalText.pdf"));
            // step3
            document.open();
            // step4
            
            // make a PdfTemplate with the vertical text
            PdfTemplate template = writer.getDirectContent().createTemplate(20, 20);
            BaseFont bf = BaseFont.createFont("Helvetica", "winansi", false);
            String text = "Vertical";
            float size = 16;
            float width = bf.getWidthPoint(text, size);
            template.beginText();
            template.setRGBColorFillF(1, 1, 1);
            template.setFontAndSize(bf, size);
            template.setTextMatrix(0, 2);
            template.showText(text);
            template.endText();
            template.setWidth(width);
            template.setHeight(size + 2);
            // make an Image object from the template
            Image img = Image.getInstance(template);
            img.setRotationDegrees(90);
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            PdfPCell cell = new PdfPCell(img);
            cell.setPadding(4);
            cell.setBackgroundColor(new Color(0, 0, 255));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("I see a template on my right");
            table.addCell(cell);
            table.addCell("I see a template on my left");
            table.addCell(cell);
            table.addCell("I see a template everywhere");
            table.addCell(cell);
            table.addCell("I see a template on my right");
            table.addCell(cell);
            table.addCell("I see a template on my left");
            document.add(table);
        }
        catch (Exception de) {
            de.printStackTrace();
        }
        // step5
        document.close();
    }
}