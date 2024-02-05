package com.ibm.dataloop;

import com.ibm.jzos.fields.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class DATALOOP implements Comparable<DATALOOP> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    public DATALOOP() {
    }
    
    public DATALOOP(DATALOOP that) {
    }
    
    protected DATALOOP(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected DATALOOP(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static DATALOOP fromBytes(byte[] bytes, int offset) {
        return new DATALOOP(bytes, offset);
    }
    
    public static DATALOOP fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static DATALOOP fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args){
    HrdTestTrackingRecord hrdTestTrackingRecord = new HrdTestTrackingRecord();
    OutRecord outRecord = new OutRecord();
    String outfileRecord = "";
    char tlogEofSwitch = 'N';

    outRecord.setIdOut(String.valueOf(hrdTestTrackingRecord.getTestRecordId()));
    outRecord.getDateOut().setYearOut(String.valueOf(hrdTestTrackingRecord.getTestDate().getTestYear()));
    outRecord.getDateOut().setMonthOut(String.valueOf(hrdTestTrackingRecord.getTestDate().getTestMonth()));
    outRecord.getDateOut().setDayOut(String.valueOf(hrdTestTrackingRecord.getTestDate().getTestDay()));
    outRecord.setCategoryOut(hrdTestTrackingRecord.getTestCategory());
    outRecord.setGroupOut(hrdTestTrackingRecord.getTestGroup());
    outRecord.setAuthorOut(hrdTestTrackingRecord.getTestAuthor());
    outRecord.setSubjectOut(hrdTestTrackingRecord.getTestSubject());
    outfileRecord = outRecord.formatOutputRecord();
    System.out.println(outfileRecord);
    try {
        BufferedReader infile = new BufferedReader(new FileReader("INFILE"));
        String currentLine;
        while ((currentLine = infile.readLine()) != null) {
            if (tlogEofSwitch == 'Y') {
                break;
            }
        }
        infile.close();
    }
    catch (IOException e) {
        System.out.println("Error: " + e);
    }
}



    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(DATALOOP that) {
        return true;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof DATALOOP) && this.equals((DATALOOP)that);
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public int compareTo(DATALOOP that) {
        int c = 0;
        return c;
    }
    
    public byte[] getBytes(byte[] bytes, int offset) {
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
