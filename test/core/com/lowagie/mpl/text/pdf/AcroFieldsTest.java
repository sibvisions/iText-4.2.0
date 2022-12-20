package com.lowagie.mpl.text.pdf;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

import com.lowagie.mpl.testutils.TestResourceUtils;
import com.lowagie.mpl.text.pdf.AcroFields;
import com.lowagie.mpl.text.pdf.PdfReader;
import com.lowagie.mpl.text.pdf.PdfStamper;
import com.lowagie.mpl.text.pdf.XfdfReader;

public class AcroFieldsTest {
    
    @Test
    public void testSetFields() throws Exception {
        singleTest("register.xfdf");
    }

    @Test
    public void testListInSetFields() throws Exception {
        singleTest("list_register.xfdf");
    }
    
    private void singleTest(String xfdfFileName) throws Exception {
        // merging the FDF file
        PdfReader pdfreader = TestResourceUtils.getResourceAsPdfReader(this, "SimpleRegistrationForm.pdf");
        PdfStamper stamp = new PdfStamper(pdfreader, new ByteArrayOutputStream());
        XfdfReader fdfreader = new XfdfReader(xfdfFileName);
        AcroFields form = stamp.getAcroFields();
        form.setFields(fdfreader);
        stamp.close();
    }
}
