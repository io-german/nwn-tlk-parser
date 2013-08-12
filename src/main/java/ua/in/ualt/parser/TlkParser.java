package ua.in.ualt.parser;

import ua.in.ualt.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static ua.in.ualt.util.DataReader.*;

public class TlkParser implements Parser {

    @Override
    public DialogsFile toObject(InputStream src) throws IOException {
        Header header = readHeader(src);
        List<RowInfo> infos = readRowsInfo(src, header);
        List<Row> rows = readRows(src, infos);

        return new TlkFile(header, rows);
    }

    @Override
    public void toFile(DialogsFile src, OutputStream dest) {
        throw new UnsupportedOperationException();
    }

    private Header readHeader(InputStream file) throws IOException {
        final String fileType = readString(readBytes(file, 8));
        final int languageId = readInt(readBytes(file,4));
        final int stringCount = readInt(readBytes(file, 4));
        final int stringEntriesOffset = readInt(readBytes(file, 4));

        return new Header(fileType, languageId, stringCount, stringEntriesOffset);
    }

    private List<RowInfo> readRowsInfo(InputStream file, Header header) throws IOException {

        List<RowInfo> result = new ArrayList<>();
        for (int i = 0; i < header.stringCount; i++) {
            final int flags = readInt(readBytes(file, 4));
            final String soundResRef = readString(readBytes(file, 16));
            final int volumeVariance = readInt(readBytes(file, 4));
            final int pitchVariance = readInt(readBytes(file, 4));
            final int offsetToString = readInt(readBytes(file, 4));
            final int stringSize = readInt(readBytes(file, 4));
            final float soundLength = readFloat(readBytes(file, 4));

            result.add(
                    new RowInfo(flags, soundResRef, volumeVariance, pitchVariance,
                            offsetToString, stringSize, soundLength));
        }
        return result;
    }

    private List<Row> readRows(InputStream file, List<RowInfo> infos) throws IOException {
        List<Row> rows  = new ArrayList<>();
        for (RowInfo info : infos) {
            final String text = readString(readBytes(file, info.stringSize));
            rows.add(new Row(info, text));
        }

        return rows;
    }
}
