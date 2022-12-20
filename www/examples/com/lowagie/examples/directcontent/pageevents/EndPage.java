/*
 * $Id: EndPage.java 3373 2008-05-12 16:21:24Z xlv $
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
package com.lowagie.examples.directcontent.pageevents;

import java.io.FileOutputStream;

import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.ExceptionConverter;
import com.lowagie.mpl.text.PageSize;
import com.lowagie.mpl.text.Paragraph;
import com.lowagie.mpl.text.Rectangle;
import com.lowagie.mpl.text.pdf.PdfPTable;
import com.lowagie.mpl.text.pdf.PdfPageEventHelper;
import com.lowagie.mpl.text.pdf.PdfWriter;

/**
 * Demonstrates the use of PageEvents.
 */
public class EndPage extends PdfPageEventHelper {
    
    /**
     * Demonstrates the use of PageEvents.
     * @param args no arguments needed
     */
    public static void main(String[] args)
    {
        Document document = new Document(PageSize.A4, 50, 50, 70, 70);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("endpage.pdf"));
            writer.setPageEvent(new EndPage());
            document.open();
            String text = "Lots of text. ";
            for (int k = 0; k < 10; ++k)
                text += text;
            document.add(new Paragraph(text));
            document.close();
        }
        catch (Exception de) {
            de.printStackTrace();
        }
    }
    
    /**
     * @see com.lowagie.mpl.text.pdf.PdfPageEventHelper#onEndPage(com.lowagie.mpl.text.pdf.PdfWriter, com.lowagie.mpl.text.Document)
     */
    public void onEndPage(PdfWriter writer, Document document) {
        try {
            Rectangle page = document.getPageSize();
            PdfPTable head = new PdfPTable(3);
            for (int k = 1; k <= 6; ++k)
                head.addCell("head " + k);
            head.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
            head.writeSelectedRows(0, -1, document.leftMargin(), page.getHeight() - document.topMargin() + head.getTotalHeight(),
                writer.getDirectContent());
            PdfPTable foot = new PdfPTable(3);
            for (int k = 1; k <= 6; ++k)
                foot.addCell("foot " + k);
            foot.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
            foot.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin(),
                writer.getDirectContent());
        }
        catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

}
