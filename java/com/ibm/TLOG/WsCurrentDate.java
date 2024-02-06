package com.ibm.TLOG;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class WsCurrentDate implements Comparable<WsCurrentDate> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final ExternalDecimalAsIntField WSHUNDSECOND = factory.getExternalDecimalAsIntField(2, true);
    private static final StringField WSGMT = factory.getStringField(5);
    private static final ExternalDecimalAsIntField WSYEAR = factory.getExternalDecimalAsIntField(4, true);
    private static final ExternalDecimalAsIntField WSMONTH = factory.getExternalDecimalAsIntField(2, true);
    private static final ExternalDecimalAsIntField WSDAY = factory.getExternalDecimalAsIntField(2, true);
    private static final ExternalDecimalAsIntField WSHOURS = factory.getExternalDecimalAsIntField(2, true);
    private static final ExternalDecimalAsIntField WSMINUTES = factory.getExternalDecimalAsIntField(2, true);
    private static final ExternalDecimalAsIntField WSSECONDS = factory.getExternalDecimalAsIntField(2, true);
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    private int wsHundSecond;
    private String wsGmt = "";
    private int wsYear;
    private int wsMonth;
    private int wsDay;
    private int wsHours;
    private int wsMinutes;
    private int wsSeconds;
    
    public WsCurrentDate() {
    }
    
    public WsCurrentDate(int wsHundSecond, String wsGmt, int wsYear, int wsMonth, int wsDay, int wsHours, int wsMinutes, int wsSeconds) {
        this.wsHundSecond = wsHundSecond;
        this.wsGmt = wsGmt;
        this.wsYear = wsYear;
        this.wsMonth = wsMonth;
        this.wsDay = wsDay;
        this.wsHours = wsHours;
        this.wsMinutes = wsMinutes;
        this.wsSeconds = wsSeconds;
    }
    
    public WsCurrentDate(WsCurrentDate that) {
        this.wsHundSecond = that.wsHundSecond;
        this.wsGmt = that.wsGmt;
        this.wsYear = that.wsYear;
        this.wsMonth = that.wsMonth;
        this.wsDay = that.wsDay;
        this.wsHours = that.wsHours;
        this.wsMinutes = that.wsMinutes;
        this.wsSeconds = that.wsSeconds;
    }
    
    protected WsCurrentDate(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected WsCurrentDate(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static WsCurrentDate fromBytes(byte[] bytes, int offset) {
        return new WsCurrentDate(bytes, offset);
    }
    
    public static WsCurrentDate fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static WsCurrentDate fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int getWsHundSecond() {
        return this.wsHundSecond;
    }
    
    public void setWsHundSecond(int wsHundSecond) {
        this.wsHundSecond = wsHundSecond;
    }
    
    public String getWsGmt() {
        return this.wsGmt;
    }
    
    public void setWsGmt(String wsGmt) {
        this.wsGmt = wsGmt;
    }
    
    public int getWsYear() {
        return this.wsYear;
    }
    
    public void setWsYear(int wsYear) {
        this.wsYear = wsYear;
    }
    
    public int getWsMonth() {
        return this.wsMonth;
    }
    
    public void setWsMonth(int wsMonth) {
        this.wsMonth = wsMonth;
    }
    
    public int getWsDay() {
        return this.wsDay;
    }
    
    public void setWsDay(int wsDay) {
        this.wsDay = wsDay;
    }
    
    public int getWsHours() {
        return this.wsHours;
    }
    
    public void setWsHours(int wsHours) {
        this.wsHours = wsHours;
    }
    
    public int getWsMinutes() {
        return this.wsMinutes;
    }
    
    public void setWsMinutes(int wsMinutes) {
        this.wsMinutes = wsMinutes;
    }
    
    public int getWsSeconds() {
        return this.wsSeconds;
    }
    
    public void setWsSeconds(int wsSeconds) {
        this.wsSeconds = wsSeconds;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ wsHundSecond=\"");
        s.append(getWsHundSecond());
        s.append("\" wsGmt=\"");
        s.append(getWsGmt());
        s.append("\" wsYear=\"");
        s.append(getWsYear());
        s.append("\" wsMonth=\"");
        s.append(getWsMonth());
        s.append("\" wsDay=\"");
        s.append(getWsDay());
        s.append("\" wsHours=\"");
        s.append(getWsHours());
        s.append("\" wsMinutes=\"");
        s.append(getWsMinutes());
        s.append("\" wsSeconds=\"");
        s.append(getWsSeconds());
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(WsCurrentDate that) {
        return this.wsHundSecond == that.wsHundSecond &&
            this.wsGmt.equals(that.wsGmt) &&
            this.wsYear == that.wsYear &&
            this.wsMonth == that.wsMonth &&
            this.wsDay == that.wsDay &&
            this.wsHours == that.wsHours &&
            this.wsMinutes == that.wsMinutes &&
            this.wsSeconds == that.wsSeconds;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof WsCurrentDate) && this.equals((WsCurrentDate)that);
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(wsHundSecond) ^
            Integer.rotateLeft(wsGmt.hashCode(), 1) ^
            Integer.rotateLeft(Integer.hashCode(wsYear), 2) ^
            Integer.rotateLeft(Integer.hashCode(wsMonth), 3) ^
            Integer.rotateLeft(Integer.hashCode(wsDay), 4) ^
            Integer.rotateLeft(Integer.hashCode(wsHours), 5) ^
            Integer.rotateLeft(Integer.hashCode(wsMinutes), 6) ^
            Integer.rotateLeft(Integer.hashCode(wsSeconds), 7);
    }
    
    @Override
    public int compareTo(WsCurrentDate that) {
        int c = Integer.compare(this.wsHundSecond, that.wsHundSecond);
        if ( c != 0 ) return c;
        c = this.wsGmt.compareTo(that.wsGmt);
        if ( c != 0 ) return c;
        c = Integer.compare(this.wsYear, that.wsYear);
        if ( c != 0 ) return c;
        c = Integer.compare(this.wsMonth, that.wsMonth);
        if ( c != 0 ) return c;
        c = Integer.compare(this.wsDay, that.wsDay);
        if ( c != 0 ) return c;
        c = Integer.compare(this.wsHours, that.wsHours);
        if ( c != 0 ) return c;
        c = Integer.compare(this.wsMinutes, that.wsMinutes);
        if ( c != 0 ) return c;
        c = Integer.compare(this.wsSeconds, that.wsSeconds);
        return c;
    }
    
    public byte[] getBytes(byte[] bytes, int offset) {
        WSHUNDSECOND.putInt(wsHundSecond, bytes, offset);
        WSGMT.putString(wsGmt, bytes, offset);
        WSYEAR.putInt(wsYear, bytes, offset);
        WSMONTH.putInt(wsMonth, bytes, offset);
        WSDAY.putInt(wsDay, bytes, offset);
        WSHOURS.putInt(wsHours, bytes, offset);
        WSMINUTES.putInt(wsMinutes, bytes, offset);
        WSSECONDS.putInt(wsSeconds, bytes, offset);
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
        wsHundSecond = WSHUNDSECOND.getInt(bytes, offset);
        wsGmt = WSGMT.getString(bytes, offset);
        wsYear = WSYEAR.getInt(bytes, offset);
        wsMonth = WSMONTH.getInt(bytes, offset);
        wsDay = WSDAY.getInt(bytes, offset);
        wsHours = WSHOURS.getInt(bytes, offset);
        wsMinutes = WSMINUTES.getInt(bytes, offset);
        wsSeconds = WSSECONDS.getInt(bytes, offset);
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
