package ua.in.ualt.parser;

import org.apache.commons.lang.StringEscapeUtils;
import ua.in.ualt.model.TlkFile;

public class TlkXmlConverter implements XmlConverter<TlkFile> {

    @Override
    public String toXml(TlkFile dialogs) {
        String[] rows = dialogs.getRows().toArray(new String[0]);
        StringBuilder result = new StringBuilder();

        result.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        result.append("<resources>");

        for (int i = 0; i < rows.length; i++) {
            String s = "<string name=\"" + i + "\">" + StringEscapeUtils.escapeXml(rows[i]) + "</string>\n";
            result.append(s);
        }

        result.append("</resources>");

        return result.toString();
    }

    @Override
    public TlkFile fromXml(String src) {
        throw new UnsupportedOperationException();
    }
}
