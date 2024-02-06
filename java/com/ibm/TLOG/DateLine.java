package com.ibm.TLOG;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class DateLine implements Comparable<DateLine> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final ExternalDecimalAsIntField DTMONTH = factory.getExternalDecimalAsIntField(2, true);
    private static final ExternalDecimalAsIntField DTYEAR = factory.getExternalDecimalAsIntField(4, true);
    private static final ExternalDecimalAsIntField DTDAY = factory.getExternalDecimalAsIntField(2, true);
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    private int dtMonth;
    private int dtYear;
    private int dtDay;
    
    public DateLine() {
    }
    
    public DateLine(int dtMonth, int dtYear, int dtDay) {
        this.dtMonth = dtMonth;
        this.dtYear = dtYear;
        this.dtDay = dtDay;
    }
    
    public DateLine(DateLine that) {
        this.dtMonth = that.dtMonth;
        this.dtYear = that.dtYear;
        this.dtDay = that.dtDay;
    }
    
    protected DateLine(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected DateLine(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static DateLine fromBytes(byte[] bytes, int offset) {
        return new DateLine(bytes, offset);
    }
    
    public static DateLine fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static DateLine fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int getDtMonth() {
        return this.dtMonth;
    }
    
    public void setDtMonth(int dtMonth) {
        this.dtMonth = dtMonth;
    }
    
    public int getDtYear() {
        return this.dtYear;
    }
    
    public void setDtYear(int dtYear) {
        this.dtYear = dtYear;
    }
    
    public int getDtDay() {
        return this.dtDay;
    }
    
    public void setDtDay(int dtDay) {
        this.dtDay = dtDay;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ dtMonth=\"");
        s.append(getDtMonth());
        s.append("\" dtYear=\"");
        s.append(getDtYear());
        s.append("\" dtDay=\"");
        s.append(getDtDay());
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(DateLine that) {
        return this.dtMonth == that.dtMonth &&
            this.dtYear == that.dtYear &&
            this.dtDay == that.dtDay;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof DateLine) && this.equals((DateLine)that);
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(dtMonth) ^
            Integer.rotateLeft(Integer.hashCode(dtYear), 1) ^
            Integer.rotateLeft(Integer.hashCode(dtDay), 2);
    }
    
    @Override
    public int compareTo(DateLine that) {
        int c = Integer.compare(this.dtMonth, that.dtMonth);
        if ( c != 0 ) return c;
        c = Integer.compare(this.dtYear, that.dtYear);
        if ( c != 0 ) return c;
        c = Integer.compare(this.dtDay, that.dtDay);
        return c;
    }
    
    public byte[] getBytes(byte[] bytes, int offset) {
        DTMONTH.putInt(dtMonth, bytes, offset);
        DTYEAR.putInt(dtYear, bytes, offset);
        DTDAY.putInt(dtDay, bytes, offset);
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
        dtMonth = DTMONTH.getInt(bytes, offset);
        dtYear = DTYEAR.getInt(bytes, offset);
        dtDay = DTDAY.getInt(bytes, offset);
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
