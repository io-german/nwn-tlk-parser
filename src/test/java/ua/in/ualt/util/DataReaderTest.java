package ua.in.ualt.util;

import org.junit.Test;
import static org.junit.Assert.*;
import static ua.in.ualt.util.DataReader.*;

public class DataReaderTest {

    @Test
    public void testReadShort() {
        byte[] bytes = { 0x01, 0x00 };
        assertEquals(1, readShort(bytes));
    }

    @Test
    public void testReadInt() {
        byte[] bytes = { 0x01, 0x00, 0x00, 0x00 };
        assertEquals(1, readInt(bytes));
    }

    @Test
    public void testReadFloat() {
        byte[] bytes = { 0x00, 0x00, -0x80, 0x3F };
        assertEquals(1F, readFloat(bytes), 0.01F);
    }

    @Test
    public void testReadString() {
        byte[] bytes = { 0x61, 0x41, 0x31 };
        assertEquals("aA1", readString(bytes));
    }
}
