package com.ibm.string;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class STRINGS implements Comparable<STRINGS> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    public STRINGS() {
    }
    
    public STRINGS(STRINGS that) {
    }
    
    protected STRINGS(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected STRINGS(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static STRINGS fromBytes(byte[] bytes, int offset) {
        return new STRINGS(bytes, offset);
    }
    
    public static STRINGS fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static STRINGS fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args){
    int wsCnt1 = 0;
    int wsCnt2 = 0;
    int wsCount = 1;
    int wsCount2 = 0;
    int wsCount3 = 0;
    String wsStr1 = "PERSISTENT";
    String wsStr2 = "WELCOME";
    String wsStr3 = "TO AND";
    String wsString = "ABCDADADADABVDFDFFAF";
    String wsStringDest = "";
    String wsTag = "";
    String wsUnstr = "WELCOME TO PERSISTENT";

    wsCnt1 = wsString.length();
    wsCnt2 = wsString.length() - wsString.replace("A", "").length();
    System.out.println("WS-CNT1 : " + wsCnt1);
    System.out.println("WS-CNT2 : " + wsCnt2);
    System.out.println("OLD STRING : " + wsString);
    wsString = wsString.replace("A", "X");
    System.out.println("NEW STRING : " + wsString);
    if (wsCount + wsStr2.length() > wsStringDest.length()) {
        System.out.println("OVERFLOW!");
    } else {
        String jdecl_var1 = wsStringDest.substring(0, wsCount > 0 ? wsCount : 0) + wsStr2;
        if (jdecl_var1.length() > wsStringDest.length()) {
            System.out.println("OVERFLOW!");
            wsStringDest = jdecl_var1.substring(0, wsStringDest.length());
            wsCount = wsStringDest.length();
        } else {
            wsCount = jdecl_var1.length();
            wsStringDest = jdecl_var1 + wsStringDest.substring(wsCount);
        }
    }
    System.out.println("WS-STRING : " + wsStringDest);
    System.out.println("WS-COUNT : " + wsCount);
    String[] jdecl_arrOfStr = wsUnstr.split(" ",-1);
    int jdecl_size = jdecl_arrOfStr.length;
    if(jdecl_arrOfStr[jdecl_arrOfStr.length -1].equals(""))	jdecl_size = jdecl_arrOfStr.length - 1;
    if(jdecl_size == 1){
        wsStr3 = (jdecl_arrOfStr[0] + String.valueOf(' ').repeat(10)).substring(0,10);
    }else if(jdecl_size == 2){
        wsStr3 = (jdecl_arrOfStr[0] + String.valueOf(' ').repeat(10)).substring(0,10);
        wsStr2 = (jdecl_arrOfStr[1] + String.valueOf(' ').repeat(10)).substring(0,10);
    }else{
        wsStr3 = (jdecl_arrOfStr[0] + String.valueOf(' ').repeat(10)).substring(0,10);
        wsStr2 = (jdecl_arrOfStr[1] + String.valueOf(' ').repeat(10)).substring(0,10);
        wsStr1 = (jdecl_arrOfStr[2] + String.valueOf(' ').repeat(10)).substring(0,10);
    }
    System.out.println("WS-STR3 : " + wsStr3);
    System.out.println("WS-STR2 : " + wsStr2);
    System.out.println("WS-STR1 : " + wsStr1);
    wsTag = "VDFDF";
    wsCount2 = wsString.length() - wsString.substring(0,wsString.indexOf(wsTag)).length();
    wsCount3 = wsString.substring(wsString.indexOf(wsTag) + wsTag.length()).length();
    System.out.println("ws-count2 :" + wsCount2);
    System.out.println("WS-COUNT3 :" + wsCount3);
}



    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(STRINGS that) {
        return true;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof STRINGS) && this.equals((STRINGS)that);
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public int compareTo(STRINGS that) {
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
