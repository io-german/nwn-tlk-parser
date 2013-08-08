package ua.in.ualt.model;

import java.util.ArrayList;
import java.util.List;

public class TlkFile implements DialogsFile {

    final Header header;
    final List<Row> rows;

    public TlkFile(Header header, List<Row> rows) {
        this.header = header;
        this.rows = rows;
    }

    @Override
    public List<String> getRows() {
        List<String> result = new ArrayList<>();

        for (Row row : rows) {
            result.add(row.text);
        }

        return result;
    }
}
