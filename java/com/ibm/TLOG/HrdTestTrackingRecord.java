package com.ibm.TLOG;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class HrdTestTrackingRecord implements Comparable<HrdTestTrackingRecord> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final ExternalDecimalAsIntField TESTRECORDID = factory.getExternalDecimalAsIntField(6, true);
    private static final StringField TESTCATEGORY = factory.getStringField(28);
    private static final StringField TESTGROUP = factory.getStringField(28);
    private static final StringField TESTAUTHOR = factory.getStringField(28);
    private static final StringField TESTEMAIL = factory.getStringField(28);
    private static final ByteArrayField TESTDATE = factory.getByteArrayField(TestDate.SIZE);
    private static final StringField TESTSUBJECT = factory.getStringField(66);
    private static final ByteArrayField TESTNOTES = factory.getByteArrayField(TestNotes.SIZE);
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    private int testRecordId;
    private String testCategory = "";
    private String testGroup = "";
    private String testAuthor = "";
    private String testEmail = "";
    private TestDate testDate = new TestDate();
    private String testSubject = "";
    private TestNotes testNotes = new TestNotes();
    
    public HrdTestTrackingRecord() {
    }
    
    public HrdTestTrackingRecord(int testRecordId, String testCategory, String testGroup, String testAuthor, String testEmail, TestDate testDate, String testSubject, TestNotes testNotes) {
        this.testRecordId = testRecordId;
        this.testCategory = testCategory;
        this.testGroup = testGroup;
        this.testAuthor = testAuthor;
        this.testEmail = testEmail;
        this.testDate = testDate;
        this.testSubject = testSubject;
        this.testNotes = testNotes;
    }
    
    public HrdTestTrackingRecord(HrdTestTrackingRecord that) {
        this.testRecordId = that.testRecordId;
        this.testCategory = that.testCategory;
        this.testGroup = that.testGroup;
        this.testAuthor = that.testAuthor;
        this.testEmail = that.testEmail;
        this.testDate = new TestDate(that.testDate);
        this.testSubject = that.testSubject;
        this.testNotes = new TestNotes(that.testNotes);
    }
    
    protected HrdTestTrackingRecord(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected HrdTestTrackingRecord(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static HrdTestTrackingRecord fromBytes(byte[] bytes, int offset) {
        return new HrdTestTrackingRecord(bytes, offset);
    }
    
    public static HrdTestTrackingRecord fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static HrdTestTrackingRecord fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void addPara(char tlogEofSwitch, int wsIdSum) {}
    
    public int getTestRecordId() {
        return this.testRecordId;
    }
    
    public void setTestRecordId(int testRecordId) {
        this.testRecordId = testRecordId;
    }
    
    public String getTestCategory() {
        return this.testCategory;
    }
    
    public void setTestCategory(String testCategory) {
        this.testCategory = testCategory;
    }
    
    public String getTestGroup() {
        return this.testGroup;
    }
    
    public void setTestGroup(String testGroup) {
        this.testGroup = testGroup;
    }
    
    public String getTestAuthor() {
        return this.testAuthor;
    }
    
    public void setTestAuthor(String testAuthor) {
        this.testAuthor = testAuthor;
    }
    
    public String getTestEmail() {
        return this.testEmail;
    }
    
    public void setTestEmail(String testEmail) {
        this.testEmail = testEmail;
    }
    
    public TestDate getTestDate() {
        return this.testDate;
    }
    
    public void setTestDate(TestDate testDate) {
        this.testDate = testDate;
    }
    
    public String getTestSubject() {
        return this.testSubject;
    }
    
    public void setTestSubject(String testSubject) {
        this.testSubject = testSubject;
    }
    
    public TestNotes getTestNotes() {
        return this.testNotes;
    }
    
    public void setTestNotes(TestNotes testNotes) {
        this.testNotes = testNotes;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ testRecordId=\"");
        s.append(getTestRecordId());
        s.append("\" testCategory=\"");
        s.append(getTestCategory());
        s.append("\" testGroup=\"");
        s.append(getTestGroup());
        s.append("\" testAuthor=\"");
        s.append(getTestAuthor());
        s.append("\" testEmail=\"");
        s.append(getTestEmail());
        s.append("\" testDate=\"");
        s.append(getTestDate());
        s.append("\" testSubject=\"");
        s.append(getTestSubject());
        s.append("\" testNotes=\"");
        s.append(getTestNotes());
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(HrdTestTrackingRecord that) {
        return this.testRecordId == that.testRecordId &&
            this.testCategory.equals(that.testCategory) &&
            this.testGroup.equals(that.testGroup) &&
            this.testAuthor.equals(that.testAuthor) &&
            this.testEmail.equals(that.testEmail) &&
            this.testDate.equals(that.testDate) &&
            this.testSubject.equals(that.testSubject) &&
            this.testNotes.equals(that.testNotes);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof HrdTestTrackingRecord) && this.equals((HrdTestTrackingRecord)that);
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(testRecordId) ^
            Integer.rotateLeft(testCategory.hashCode(), 1) ^
            Integer.rotateLeft(testGroup.hashCode(), 2) ^
            Integer.rotateLeft(testAuthor.hashCode(), 3) ^
            Integer.rotateLeft(testEmail.hashCode(), 4) ^
            Integer.rotateLeft(testDate.hashCode(), 5) ^
            Integer.rotateLeft(testSubject.hashCode(), 6) ^
            Integer.rotateLeft(testNotes.hashCode(), 7);
    }
    
    @Override
    public int compareTo(HrdTestTrackingRecord that) {
        int c = Integer.compare(this.testRecordId, that.testRecordId);
        if ( c != 0 ) return c;
        c = this.testCategory.compareTo(that.testCategory);
        if ( c != 0 ) return c;
        c = this.testGroup.compareTo(that.testGroup);
        if ( c != 0 ) return c;
        c = this.testAuthor.compareTo(that.testAuthor);
        if ( c != 0 ) return c;
        c = this.testEmail.compareTo(that.testEmail);
        if ( c != 0 ) return c;
        c = this.testDate.compareTo(that.testDate);
        if ( c != 0 ) return c;
        c = this.testSubject.compareTo(that.testSubject);
        if ( c != 0 ) return c;
        c = this.testNotes.compareTo(that.testNotes);
        return c;
    }
    
    public byte[] getBytes(byte[] bytes, int offset) {
        TESTRECORDID.putInt(testRecordId, bytes, offset);
        TESTCATEGORY.putString(testCategory, bytes, offset);
        TESTGROUP.putString(testGroup, bytes, offset);
        TESTAUTHOR.putString(testAuthor, bytes, offset);
        TESTEMAIL.putString(testEmail, bytes, offset);
        testDate.getBytes(bytes, TESTDATE.getOffset() + offset);
        TESTSUBJECT.putString(testSubject, bytes, offset);
        testNotes.getBytes(bytes, TESTNOTES.getOffset() + offset);
        return bytes;
    }
    
    public final byte[] getBytes(byte[] bytes) {
        return getBytes(bytes, 0);
    }
    
    public final byte[] getBytes() {
        return getBytes(new byte[numBytes()]);
    }
    
    public final String toByteString() {
        try {
            return new String(getBytes(), factory.getStringEncoding());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void setBytes(byte[] bytes, int offset) {
        if (bytes.length < SIZE + offset) {
            byte[] newBytes = Arrays.copyOf(bytes, SIZE + offset);
            Arrays.fill(newBytes, bytes.length, SIZE + offset, (byte)0x40 /*default EBCDIC space character*/);
            bytes = newBytes;
        }
        testRecordId = TESTRECORDID.getInt(bytes, offset);
        testCategory = TESTCATEGORY.getString(bytes, offset);
        testGroup = TESTGROUP.getString(bytes, offset);
        testAuthor = TESTAUTHOR.getString(bytes, offset);
        testEmail = TESTEMAIL.getString(bytes, offset);
        testDate.setBytes(bytes, TESTDATE.getOffset() + offset);
        testSubject = TESTSUBJECT.getString(bytes, offset);
        testNotes.setBytes(bytes, TESTNOTES.getOffset() + offset);
    }
    
    public final void setBytes(byte[] bytes) {
        setBytes(bytes, 0);
    }
    
    public final void setBytes(String bytes) {
        try {
            setBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int numBytes() {
        return SIZE;
    }
}
