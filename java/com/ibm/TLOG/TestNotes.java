package com.ibm.TLOG;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class TestNotes implements Comparable<TestNotes> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final StringField TESTNOTE1 = factory.getStringField(77);
    private static final StringField TESTNOTE2 = factory.getStringField(77);
    private static final StringField TESTNOTE3 = factory.getStringField(77);
    private static final StringField TESTNOTE4 = factory.getStringField(77);
    private static final StringField TESTNOTE5 = factory.getStringField(77);
    private static final StringField TESTNOTE6 = factory.getStringField(77);
    private static final StringField TESTNOTE7 = factory.getStringField(77);
    private static final StringField TESTNOTE8 = factory.getStringField(77);
    private static final StringField TESTNOTE9 = factory.getStringField(77);
    private static final StringField TESTNOTE10 = factory.getStringField(77);
    private static final StringField TESTNOTE11 = factory.getStringField(77);
    private static final StringField TESTNOTE12 = factory.getStringField(77);
    private static final StringField TESTNOTE13 = factory.getStringField(77);
    private static final StringField TESTNOTE14 = factory.getStringField(77);
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    private String testNote1 = "";
    private String testNote2 = "";
    private String testNote3 = "";
    private String testNote4 = "";
    private String testNote5 = "";
    private String testNote6 = "";
    private String testNote7 = "";
    private String testNote8 = "";
    private String testNote9 = "";
    private String testNote10 = "";
    private String testNote11 = "";
    private String testNote12 = "";
    private String testNote13 = "";
    private String testNote14 = "";
    
    public TestNotes() {
    }
    
    public TestNotes(String testNote1, String testNote2, String testNote3, String testNote4, String testNote5, String testNote6, String testNote7, String testNote8, String testNote9, String testNote10, String testNote11, String testNote12, String testNote13, String testNote14) {
        this.testNote1 = testNote1;
        this.testNote2 = testNote2;
        this.testNote3 = testNote3;
        this.testNote4 = testNote4;
        this.testNote5 = testNote5;
        this.testNote6 = testNote6;
        this.testNote7 = testNote7;
        this.testNote8 = testNote8;
        this.testNote9 = testNote9;
        this.testNote10 = testNote10;
        this.testNote11 = testNote11;
        this.testNote12 = testNote12;
        this.testNote13 = testNote13;
        this.testNote14 = testNote14;
    }
    
    public TestNotes(TestNotes that) {
        this.testNote1 = that.testNote1;
        this.testNote2 = that.testNote2;
        this.testNote3 = that.testNote3;
        this.testNote4 = that.testNote4;
        this.testNote5 = that.testNote5;
        this.testNote6 = that.testNote6;
        this.testNote7 = that.testNote7;
        this.testNote8 = that.testNote8;
        this.testNote9 = that.testNote9;
        this.testNote10 = that.testNote10;
        this.testNote11 = that.testNote11;
        this.testNote12 = that.testNote12;
        this.testNote13 = that.testNote13;
        this.testNote14 = that.testNote14;
    }
    
    protected TestNotes(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected TestNotes(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static TestNotes fromBytes(byte[] bytes, int offset) {
        return new TestNotes(bytes, offset);
    }
    
    public static TestNotes fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static TestNotes fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getTestNote1() {
        return this.testNote1;
    }
    
    public void setTestNote1(String testNote1) {
        this.testNote1 = testNote1;
    }
    
    public String getTestNote2() {
        return this.testNote2;
    }
    
    public void setTestNote2(String testNote2) {
        this.testNote2 = testNote2;
    }
    
    public String getTestNote3() {
        return this.testNote3;
    }
    
    public void setTestNote3(String testNote3) {
        this.testNote3 = testNote3;
    }
    
    public String getTestNote4() {
        return this.testNote4;
    }
    
    public void setTestNote4(String testNote4) {
        this.testNote4 = testNote4;
    }
    
    public String getTestNote5() {
        return this.testNote5;
    }
    
    public void setTestNote5(String testNote5) {
        this.testNote5 = testNote5;
    }
    
    public String getTestNote6() {
        return this.testNote6;
    }
    
    public void setTestNote6(String testNote6) {
        this.testNote6 = testNote6;
    }
    
    public String getTestNote7() {
        return this.testNote7;
    }
    
    public void setTestNote7(String testNote7) {
        this.testNote7 = testNote7;
    }
    
    public String getTestNote8() {
        return this.testNote8;
    }
    
    public void setTestNote8(String testNote8) {
        this.testNote8 = testNote8;
    }
    
    public String getTestNote9() {
        return this.testNote9;
    }
    
    public void setTestNote9(String testNote9) {
        this.testNote9 = testNote9;
    }
    
    public String getTestNote10() {
        return this.testNote10;
    }
    
    public void setTestNote10(String testNote10) {
        this.testNote10 = testNote10;
    }
    
    public String getTestNote11() {
        return this.testNote11;
    }
    
    public void setTestNote11(String testNote11) {
        this.testNote11 = testNote11;
    }
    
    public String getTestNote12() {
        return this.testNote12;
    }
    
    public void setTestNote12(String testNote12) {
        this.testNote12 = testNote12;
    }
    
    public String getTestNote13() {
        return this.testNote13;
    }
    
    public void setTestNote13(String testNote13) {
        this.testNote13 = testNote13;
    }
    
    public String getTestNote14() {
        return this.testNote14;
    }
    
    public void setTestNote14(String testNote14) {
        this.testNote14 = testNote14;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ testNote1=\"");
        s.append(getTestNote1());
        s.append("\" testNote2=\"");
        s.append(getTestNote2());
        s.append("\" testNote3=\"");
        s.append(getTestNote3());
        s.append("\" testNote4=\"");
        s.append(getTestNote4());
        s.append("\" testNote5=\"");
        s.append(getTestNote5());
        s.append("\" testNote6=\"");
        s.append(getTestNote6());
        s.append("\" testNote7=\"");
        s.append(getTestNote7());
        s.append("\" testNote8=\"");
        s.append(getTestNote8());
        s.append("\" testNote9=\"");
        s.append(getTestNote9());
        s.append("\" testNote10=\"");
        s.append(getTestNote10());
        s.append("\" testNote11=\"");
        s.append(getTestNote11());
        s.append("\" testNote12=\"");
        s.append(getTestNote12());
        s.append("\" testNote13=\"");
        s.append(getTestNote13());
        s.append("\" testNote14=\"");
        s.append(getTestNote14());
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(TestNotes that) {
        return this.testNote1.equals(that.testNote1) &&
            this.testNote2.equals(that.testNote2) &&
            this.testNote3.equals(that.testNote3) &&
            this.testNote4.equals(that.testNote4) &&
            this.testNote5.equals(that.testNote5) &&
            this.testNote6.equals(that.testNote6) &&
            this.testNote7.equals(that.testNote7) &&
            this.testNote8.equals(that.testNote8) &&
            this.testNote9.equals(that.testNote9) &&
            this.testNote10.equals(that.testNote10) &&
            this.testNote11.equals(that.testNote11) &&
            this.testNote12.equals(that.testNote12) &&
            this.testNote13.equals(that.testNote13) &&
            this.testNote14.equals(that.testNote14);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof TestNotes) && this.equals((TestNotes)that);
    }
    
    @Override
    public int hashCode() {
        return testNote1.hashCode() ^
            Integer.rotateLeft(testNote2.hashCode(), 1) ^
            Integer.rotateLeft(testNote3.hashCode(), 2) ^
            Integer.rotateLeft(testNote4.hashCode(), 3) ^
            Integer.rotateLeft(testNote5.hashCode(), 4) ^
            Integer.rotateLeft(testNote6.hashCode(), 5) ^
            Integer.rotateLeft(testNote7.hashCode(), 6) ^
            Integer.rotateLeft(testNote8.hashCode(), 7) ^
            Integer.rotateLeft(testNote9.hashCode(), 8) ^
            Integer.rotateLeft(testNote10.hashCode(), 9) ^
            Integer.rotateLeft(testNote11.hashCode(), 10) ^
            Integer.rotateLeft(testNote12.hashCode(), 11) ^
            Integer.rotateLeft(testNote13.hashCode(), 12) ^
            Integer.rotateLeft(testNote14.hashCode(), 13);
    }
    
    @Override
    public int compareTo(TestNotes that) {
        int c = this.testNote1.compareTo(that.testNote1);
        if ( c != 0 ) return c;
        c = this.testNote2.compareTo(that.testNote2);
        if ( c != 0 ) return c;
        c = this.testNote3.compareTo(that.testNote3);
        if ( c != 0 ) return c;
        c = this.testNote4.compareTo(that.testNote4);
        if ( c != 0 ) return c;
        c = this.testNote5.compareTo(that.testNote5);
        if ( c != 0 ) return c;
        c = this.testNote6.compareTo(that.testNote6);
        if ( c != 0 ) return c;
        c = this.testNote7.compareTo(that.testNote7);
        if ( c != 0 ) return c;
        c = this.testNote8.compareTo(that.testNote8);
        if ( c != 0 ) return c;
        c = this.testNote9.compareTo(that.testNote9);
        if ( c != 0 ) return c;
        c = this.testNote10.compareTo(that.testNote10);
        if ( c != 0 ) return c;
        c = this.testNote11.compareTo(that.testNote11);
        if ( c != 0 ) return c;
        c = this.testNote12.compareTo(that.testNote12);
        if ( c != 0 ) return c;
        c = this.testNote13.compareTo(that.testNote13);
        if ( c != 0 ) return c;
        c = this.testNote14.compareTo(that.testNote14);
        return c;
    }
    
    public byte[] getBytes(byte[] bytes, int offset) {
        TESTNOTE1.putString(testNote1, bytes, offset);
        TESTNOTE2.putString(testNote2, bytes, offset);
        TESTNOTE3.putString(testNote3, bytes, offset);
        TESTNOTE4.putString(testNote4, bytes, offset);
        TESTNOTE5.putString(testNote5, bytes, offset);
        TESTNOTE6.putString(testNote6, bytes, offset);
        TESTNOTE7.putString(testNote7, bytes, offset);
        TESTNOTE8.putString(testNote8, bytes, offset);
        TESTNOTE9.putString(testNote9, bytes, offset);
        TESTNOTE10.putString(testNote10, bytes, offset);
        TESTNOTE11.putString(testNote11, bytes, offset);
        TESTNOTE12.putString(testNote12, bytes, offset);
        TESTNOTE13.putString(testNote13, bytes, offset);
        TESTNOTE14.putString(testNote14, bytes, offset);
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
        testNote1 = TESTNOTE1.getString(bytes, offset);
        testNote2 = TESTNOTE2.getString(bytes, offset);
        testNote3 = TESTNOTE3.getString(bytes, offset);
        testNote4 = TESTNOTE4.getString(bytes, offset);
        testNote5 = TESTNOTE5.getString(bytes, offset);
        testNote6 = TESTNOTE6.getString(bytes, offset);
        testNote7 = TESTNOTE7.getString(bytes, offset);
        testNote8 = TESTNOTE8.getString(bytes, offset);
        testNote9 = TESTNOTE9.getString(bytes, offset);
        testNote10 = TESTNOTE10.getString(bytes, offset);
        testNote11 = TESTNOTE11.getString(bytes, offset);
        testNote12 = TESTNOTE12.getString(bytes, offset);
        testNote13 = TESTNOTE13.getString(bytes, offset);
        testNote14 = TESTNOTE14.getString(bytes, offset);
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
