package com.ibm.dataloop;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class TestDate implements Comparable<TestDate> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final ExternalDecimalAsIntField TESTYEAR = factory.getExternalDecimalAsIntField(4, true);
    private static final ExternalDecimalAsIntField TESTMONTH = factory.getExternalDecimalAsIntField(2, true);
    private static final ExternalDecimalAsIntField TESTDAY = factory.getExternalDecimalAsIntField(2, true);
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    private int testYear;
    private int testMonth;
    private int testDay;
    
    public TestDate() {
    }
    
    public TestDate(int testYear, int testMonth, int testDay) {
        this.testYear = testYear;
        this.testMonth = testMonth;
        this.testDay = testDay;
    }
    
    public TestDate(TestDate that) {
        this.testYear = that.testYear;
        this.testMonth = that.testMonth;
        this.testDay = that.testDay;
    }
    
    protected TestDate(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected TestDate(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static TestDate fromBytes(byte[] bytes, int offset) {
        return new TestDate(bytes, offset);
    }
    
    public static TestDate fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static TestDate fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int getTestYear() {
        return this.testYear;
    }
    
    public void setTestYear(int testYear) {
        this.testYear = testYear;
    }
    
    public int getTestMonth() {
        return this.testMonth;
    }
    
    public void setTestMonth(int testMonth) {
        this.testMonth = testMonth;
    }
    
    public int getTestDay() {
        return this.testDay;
    }
    
    public void setTestDay(int testDay) {
        this.testDay = testDay;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ testYear=\"");
        s.append(getTestYear());
        s.append("\" testMonth=\"");
        s.append(getTestMonth());
        s.append("\" testDay=\"");
        s.append(getTestDay());
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(TestDate that) {
        return this.testYear == that.testYear &&
            this.testMonth == that.testMonth &&
            this.testDay == that.testDay;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof TestDate) && this.equals((TestDate)that);
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(testYear) ^
            Integer.rotateLeft(Integer.hashCode(testMonth), 1) ^
            Integer.rotateLeft(Integer.hashCode(testDay), 2);
    }
    
    @Override
    public int compareTo(TestDate that) {
        int c = Integer.compare(this.testYear, that.testYear);
        if ( c != 0 ) return c;
        c = Integer.compare(this.testMonth, that.testMonth);
        if ( c != 0 ) return c;
        c = Integer.compare(this.testDay, that.testDay);
        return c;
    }
    
    public byte[] getBytes(byte[] bytes, int offset) {
        TESTYEAR.putInt(testYear, bytes, offset);
        TESTMONTH.putInt(testMonth, bytes, offset);
        TESTDAY.putInt(testDay, bytes, offset);
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
        testYear = TESTYEAR.getInt(bytes, offset);
        testMonth = TESTMONTH.getInt(bytes, offset);
        testDay = TESTDAY.getInt(bytes, offset);
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
