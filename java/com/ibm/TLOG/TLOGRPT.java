package com.ibm.TLOG;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class TLOGRPT implements Comparable<TLOGRPT> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    public TLOGRPT() {
    }
    
    public TLOGRPT(TLOGRPT that) {
    }
    
    protected TLOGRPT(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected TLOGRPT(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static TLOGRPT fromBytes(byte[] bytes, int offset) {
        return new TLOGRPT(bytes, offset);
    }
    
    public static TLOGRPT fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static TLOGRPT fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void printTitle(DateLine dateLine) {
    String outfileRecord = "";
    outfileRecord = "                           ATM REPORT                             ";
    System.out.println(outfileRecord);
    outfileRecord = "********************ATM REPORT*************************";
    System.out.println(outfileRecord);
    outfileRecord = "Generated on " + dateLine.getAtmDate() + " at " + dateLine.getClockTime();
    System.out.println(outfileRecord);
    outfileRecord = "********************ATM REPORT*************************";
    System.out.println(outfileRecord);
    outfileRecord = " ";
    System.out.println(outfileRecord);
    outfileRecord = "ACCOUNT       BALANCE      BRANCH  ";
    System.out.println(outfileRecord);
    outfileRecord = "--------   ------------   ------  ";
    System.out.println(outfileRecord);
}


    
    public static void mainProgram(String[] args){
    DateLine dateLine = new DateLine();
    HrdTestTrackingRecord hrdTestTrackingRecord = new HrdTestTrackingRecord();
    char tlogEofSwitch = 'N';
    WsCurrentDate wsCurrentDate = new WsCurrentDate();
    String wsIdCat = "";
    int wsIdSum;

    wsCurrentDate.setWsYear(Integer.parseInt(DateTimeFormatter.ofPattern("yyyy").format(LocalDate.now())));
    wsCurrentDate.setWsMonth(Integer.parseInt(DateTimeFormatter.ofPattern("MM").format(LocalDate.now())));
    wsCurrentDate.setWsDay(Integer.parseInt(DateTimeFormatter.ofPattern("dd").format(LocalDate.now())));
    try {
        BufferedReader inFile = new BufferedReader(new FileReader("inFile.txt"));
        PrintWriter outFile = new PrintWriter(new BufferedWriter(new FileWriter("outFile.txt")));
        String inFileData;
        while ((inFileData = inFile.readLine()) != null) {
            tlogEofSwitch = 'N';
        }
        addPara();
        while (tlogEofSwitch == 'N') {
            evaluatePara();
        }
        System.out.println(wsIdCat);
        printTitle();
        while (tlogEofSwitch == 'N') {
            dataLoop();
        }
        inFile.close();
        outFile.close();
    }
    catch(IOException ioException) {
        System.out.println(ioException);
    }
    System.out.println(hrdTestTrackingRecord.getTestRecordId());
    System.out.println(wsIdSum);
    tlogCalled(hrdTestTrackingRecord.getTestRecordId());
}


    
    public static void dataLoop(HrdTestTrackingRecord hrdTestTrackingRecord) {
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
        tlogEofSwitch = 'N';
        while(tlogEofSwitch == 'N') {
            hrdTestTrackingRecord = HrdTestTrackingRecord.getHrdTestTrackingRecord();
            if (hrdTestTrackingRecord == null) {
                tlogEofSwitch = 'Y';
            }
        }
    }
    catch(Exception exception) {
        System.out.println(exception);
    }
}


    
    public static void evaluatePara(String wsIdCat, int wsIdSum) {
    wsIdFirst = 999999;
    if (wsIdSum > wsIdFirst) {
        wsIdCat = "ID SUM MORE THAN ALL 9'S";
    }
    else if (wsIdSum == wsIdFirst) {
        wsIdCat = "ID SUM EQUAL TO ALL 9'S";
    }
    else if (wsIdSum < wsIdFirst) {
        wsIdCat = "ID SUM LESS THAN ALL 9'S";
    }
}


    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(TLOGRPT that) {
        return true;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof TLOGRPT) && this.equals((TLOGRPT)that);
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public int compareTo(TLOGRPT that) {
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
