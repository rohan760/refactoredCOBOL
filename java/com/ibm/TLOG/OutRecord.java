package com.ibm.TLOG;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class OutRecord implements Comparable<OutRecord> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final StringField GROUPOUT = factory.getStringField(28);
    private static final StringField AUTHOROUT = factory.getStringField(28);
    private static final StringField SUBJECTOUT = factory.getStringField(66);
    private static final StringField IDOUT = factory.getStringField(6);
    private static final ByteArrayField DATEOUT = factory.getByteArrayField(DateOut.SIZE);
    private static final StringField CATEGORYOUT = factory.getStringField(28);
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    private String groupOut = "";
    private String authorOut = "";
    private String subjectOut = "";
    private String idOut = "";
    private DateOut dateOut = new DateOut();
    private String categoryOut = "";
    
    public OutRecord() {
    }
    
    public OutRecord(String groupOut, String authorOut, String subjectOut, String idOut, DateOut dateOut, String categoryOut) {
        this.groupOut = groupOut;
        this.authorOut = authorOut;
        this.subjectOut = subjectOut;
        this.idOut = idOut;
        this.dateOut = dateOut;
        this.categoryOut = categoryOut;
    }
    
    public OutRecord(OutRecord that) {
        this.groupOut = that.groupOut;
        this.authorOut = that.authorOut;
        this.subjectOut = that.subjectOut;
        this.idOut = that.idOut;
        this.dateOut = new DateOut(that.dateOut);
        this.categoryOut = that.categoryOut;
    }
    
    protected OutRecord(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected OutRecord(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static OutRecord fromBytes(byte[] bytes, int offset) {
        return new OutRecord(bytes, offset);
    }
    
    public static OutRecord fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static OutRecord fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getGroupOut() {
        return this.groupOut;
    }
    
    public void setGroupOut(String groupOut) {
        this.groupOut = groupOut;
    }
    
    public String getAuthorOut() {
        return this.authorOut;
    }
    
    public void setAuthorOut(String authorOut) {
        this.authorOut = authorOut;
    }
    
    public String getSubjectOut() {
        return this.subjectOut;
    }
    
    public void setSubjectOut(String subjectOut) {
        this.subjectOut = subjectOut;
    }
    
    public String getIdOut() {
        return this.idOut;
    }
    
    public void setIdOut(String idOut) {
        this.idOut = idOut;
    }
    
    public DateOut getDateOut() {
        return this.dateOut;
    }
    
    public void setDateOut(DateOut dateOut) {
        this.dateOut = dateOut;
    }
    
    public String getCategoryOut() {
        return this.categoryOut;
    }
    
    public void setCategoryOut(String categoryOut) {
        this.categoryOut = categoryOut;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ groupOut=\"");
        s.append(getGroupOut());
        s.append("\" authorOut=\"");
        s.append(getAuthorOut());
        s.append("\" subjectOut=\"");
        s.append(getSubjectOut());
        s.append("\" idOut=\"");
        s.append(getIdOut());
        s.append("\" dateOut=\"");
        s.append(getDateOut());
        s.append("\" categoryOut=\"");
        s.append(getCategoryOut());
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(OutRecord that) {
        return this.groupOut.equals(that.groupOut) &&
            this.authorOut.equals(that.authorOut) &&
            this.subjectOut.equals(that.subjectOut) &&
            this.idOut.equals(that.idOut) &&
            this.dateOut.equals(that.dateOut) &&
            this.categoryOut.equals(that.categoryOut);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof OutRecord) && this.equals((OutRecord)that);
    }
    
    @Override
    public int hashCode() {
        return groupOut.hashCode() ^
            Integer.rotateLeft(authorOut.hashCode(), 1) ^
            Integer.rotateLeft(subjectOut.hashCode(), 2) ^
            Integer.rotateLeft(idOut.hashCode(), 3) ^
            Integer.rotateLeft(dateOut.hashCode(), 4) ^
            Integer.rotateLeft(categoryOut.hashCode(), 5);
    }
    
    @Override
    public int compareTo(OutRecord that) {
        int c = this.groupOut.compareTo(that.groupOut);
        if ( c != 0 ) return c;
        c = this.authorOut.compareTo(that.authorOut);
        if ( c != 0 ) return c;
        c = this.subjectOut.compareTo(that.subjectOut);
        if ( c != 0 ) return c;
        c = this.idOut.compareTo(that.idOut);
        if ( c != 0 ) return c;
        c = this.dateOut.compareTo(that.dateOut);
        if ( c != 0 ) return c;
        c = this.categoryOut.compareTo(that.categoryOut);
        return c;
    }
    
    public byte[] getBytes(byte[] bytes, int offset) {
        GROUPOUT.putString(groupOut, bytes, offset);
        AUTHOROUT.putString(authorOut, bytes, offset);
        SUBJECTOUT.putString(subjectOut, bytes, offset);
        IDOUT.putString(idOut, bytes, offset);
        dateOut.getBytes(bytes, DATEOUT.getOffset() + offset);
        CATEGORYOUT.putString(categoryOut, bytes, offset);
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
        groupOut = GROUPOUT.getString(bytes, offset);
        authorOut = AUTHOROUT.getString(bytes, offset);
        subjectOut = SUBJECTOUT.getString(bytes, offset);
        idOut = IDOUT.getString(bytes, offset);
        dateOut.setBytes(bytes, DATEOUT.getOffset() + offset);
        categoryOut = CATEGORYOUT.getString(bytes, offset);
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
