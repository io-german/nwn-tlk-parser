package ua.in.ualt.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class DataReader {

    public static short readShort(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(reverse(bytes));
        return buffer.getShort();
    }

    public static int readInt(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(reverse(bytes));
        return buffer.getInt();
    }

    public static float readFloat(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(reverse(bytes));
        return buffer.getFloat();

    }

    public static String readString(byte[] bytes) {
        return new String(bytes, Charset.forName("CP1251"));
    }

    private static byte[] reverse(byte[] bytes) {
        final byte[] result = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            result[i] = bytes[bytes.length - i - 1];
        }
        return result;
    }
}
