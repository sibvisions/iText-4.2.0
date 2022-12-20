package com.lowagie.mpl.text.rtf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.Test;

import com.lowagie.mpl.text.Chunk;
import com.lowagie.mpl.text.Document;
import com.lowagie.mpl.text.Image;
import com.lowagie.mpl.text.rtf.RtfWriter2;
import com.lowagie.mpl.text.rtf.document.RtfDocument;
import com.lowagie.mpl.text.rtf.document.RtfDocumentSettings;
import com.lowagie.mpl.text.rtf.graphic.RtfImage;
import com.lowagie.mpl.text.rtf.parser.RtfParser;
import com.sibvisions.util.FileViewer;

public class TestParser
{
	@Test
	public void test() throws Exception
	{
		Document doc = new Document();

//		RtfDocument rtfdoc = new RtfDocument();
		
		RtfWriter2 rtw = RtfWriter2.getInstance(doc, new FileOutputStream("d:\\test_damo.rtf"));

		doc.open();
//		rtfdoc.open();
		
//		RtfImage img = new RtfImage(rtfdoc, Image.getInstance("D:\\Entwicklung\\sibvisions\\visionx\\trunk\\java\\rad\\apps\\visionx\\src.client\\com\\sibvisions\\visionx\\images\\embedded\\login.png"));

//		rtfdoc.getDocumentSettings().is
		
//		img.writeContent(new FileOutputStream("D:\\test_img.rtf"));
		
		
//		RtfDocument rtfdoc = new RtfDocument();
		
		rtw.getDocumentSettings().setWriteImageScalingInformation(true);
		rtw.getDocumentSettings().setImageWrittenAsBinary(false);
		rtw.getDocumentSettings().setImagePDFConformance(false);
		rtw.importRtfDocument(new FileInputStream("D:\\Entwicklung\\bmukk\\wienaktion\\trunk\\java\\rad\\apps\\wienaktion\\reports\\Datenmodell.rtf"));
		
		rtw.close();
		
//		RtfParser rtfp = new RtfParser(doc);
//		rtfp.importRtfDocument(new FileInputStream("D:\\Entwicklung\\bmukk\\wienaktion\\trunk\\java\\rad\\apps\\wienaktion\\reports\\Datenmodell.rtf"), rtfdoc);
//		rtfp.convertRtfDocument(new FileInputStream("D:\\Entwicklung\\bmukk\\wienaktion\\trunk\\java\\rad\\apps\\wienaktion\\reports\\Datenmodell.rtf"), doc);

		
		
//		RtfWriter2 rtw = new RtfWriter2(doc, new FileOutputStream("D:\\test_damo.rtf"));
//		rtw.close();

//		rtw.close();
//		doc.close();
	}
	
	@Test
	public void testImage() throws Exception
	{
        // Step 1: Create a new Document
        Document document = new Document();
        
        // Step 2: Create a new instance of the RtfWriter2 with the document
        //         and target output stream.
        RtfWriter2 writer = RtfWriter2.getInstance(document, new FileOutputStream("d:\\test_image.rtf"));
        
        // Step 3: Open the document.
        document.open();
        
        // Step 4: Add content to the document.
        document.add(new Chunk(Image.getInstance("D:\\Entwicklung\\sibvisions\\visionx\\trunk\\java\\rad\\apps\\visionx\\src.client\\com\\sibvisions\\visionx\\images\\embedded\\login.png"), 0, 0));
        
        // Step 5: Close the document. It will be written to the target output stream.
        document.close();		
	}
	
	@Test
	public void testImageStream() throws Exception
	{
		RtfDocument rtfdoc = new RtfDocument();
		
		RtfDocumentSettings rtfs = rtfdoc.getDocumentSettings();
		
		rtfs.setWriteImageScalingInformation(true);
		rtfs.setImageWrittenAsBinary(false);
		rtfs.setImagePDFConformance(false);
		
		RtfImage rti = new RtfImage(rtfdoc, Image.getInstance("D:\\Entwicklung\\sibvisions\\visionx\\trunk\\java\\rad\\apps\\visionx\\src.client\\com\\sibvisions\\visionx\\images\\embedded\\login.png"));

		rti.writeContent(new FileOutputStream("d:\\test_image2.txt"));
	}
	
	@Test
	public void testCreateTemplate() throws Exception
	{
        File fiTemplate = new File("D:\\Entwicklung\\sibvisions\\visionx\\trunk\\java\\rad\\apps\\visionx\\resources\\application\\reports\\Report_template.rtf");

		
		Document doc = new Document();
		RtfDocument rtfdoc = new RtfDocument();

		doc.open();
		rtfdoc.open();
		
		RtfParser rtfp = new RtfParser(doc);

//		rtfdoc.getDocumentSettings().setImagePDFConformance(false);
//		rtfdoc.getDocumentHeader().getPageSetting().setMarginLeft(1415);
//		rtfdoc.getDocumentHeader().getPageSetting().setMarginRight(1415);
		
//		rtfp.importRtfDocument(new FileInputStream(fiTemplate), rtfdoc);
		
//		rtfdoc.writeDocument(new FileOutputStream("D:\\test_image.rtf"));
		
		RtfWriter2 writer = RtfWriter2.getInstance(doc, new FileOutputStream("D:\\test_image.rtf"));
		writer.open();
		
		writer.importRtfDocument(new FileInputStream(fiTemplate));

		writer.getDocumentSettings().setImagePDFConformance(false);
//		writer.getDocumentSettings().setImageWrittenAsBinary(true);
//		writer.getDocumentSettings().setWriteImageScalingInformation(false);
		
		writer.setMargins(70.8f, 70.8f, 84.96f, 63.72f);

        doc.add(new Chunk(Image.getInstance("D:\\Entwicklung\\sibvisions\\visionx\\trunk\\java\\rad\\apps\\visionx\\src.client\\com\\sibvisions\\visionx\\images\\embedded\\login.png"), 0, 0));
		
		writer.close();
		
        FileViewer.open("D:\\test_image.rtf");
	}
	
}
