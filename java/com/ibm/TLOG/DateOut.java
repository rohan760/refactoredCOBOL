package com.ibm.TLOG;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class DateOut implements Comparable<DateOut> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final StringField YEAROUT = factory.getStringField(4);
    private static final StringField MONTHOUT = factory.getStringField(2);
    private static final StringField DAYOUT = factory.getStringField(2);
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    private String yearOut = "";
    private String monthOut = "";
    private String dayOut = "";
    
    public DateOut() {
    }
    
    public DateOut(String yearOut, String monthOut, String dayOut) {
        this.yearOut = yearOut;
        this.monthOut = monthOut;
        this.dayOut = dayOut;
    }
    
    public DateOut(DateOut that) {
        this.yearOut = that.yearOut;
        this.monthOut = that.monthOut;
        this.dayOut = that.dayOut;
    }
    
    protected DateOut(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected DateOut(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static DateOut fromBytes(byte[] bytes, int offset) {
        return new DateOut(bytes, offset);
    }
    
    public static DateOut fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static DateOut fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getYearOut() {
        return this.yearOut;
    }
    
    public void setYearOut(String yearOut) {
        this.yearOut = yearOut;
    }
    
    public String getMonthOut() {
        return this.monthOut;
    }
    
    public void setMonthOut(String monthOut) {
        this.monthOut = monthOut;
    }
    
    public String getDayOut() {
        return this.dayOut;
    }
    
    public void setDayOut(String dayOut) {
        this.dayOut = dayOut;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ yearOut=\"");
        s.append(getYearOut());
        s.append("\" monthOut=\"");
        s.append(getMonthOut());
        s.append("\" dayOut=\"");
        s.append(getDayOut());
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(DateOut that) {
        return this.yearOut.equals(that.yearOut) &&
            this.monthOut.equals(that.monthOut) &&
            this.dayOut.equals(that.dayOut);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof DateOut) && this.equals((DateOut)that);
    }
    
    @Override
    public int hashCode() {
        return yearOut.hashCode() ^
            Integer.rotateLeft(monthOut.hashCode(), 1) ^
            Integer.rotateLeft(dayOut.hashCode(), 2);
    }
    
    @Override
    public int compareTo(DateOut that) {
        int c = this.yearOut.compareTo(that.yearOut);
        if ( c != 0 ) return c;
        c = this.monthOut.compareTo(that.monthOut);
        if ( c != 0 ) return c;
        c = this.dayOut.compareTo(that.dayOut);
        return c;
    }
    
    public byte[] getBytes(byte[] bytes, int offset) {
        YEAROUT.putString(yearOut, bytes, offset);
        MONTHOUT.putString(monthOut, bytes, offset);
        DAYOUT.putString(dayOut, bytes, offset);
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
        yearOut = YEAROUT.getString(bytes, offset);
        monthOut = MONTHOUT.getString(bytes, offset);
        dayOut = DAYOUT.getString(bytes, offset);
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
