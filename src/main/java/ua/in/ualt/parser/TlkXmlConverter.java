package ua.in.ualt.parser;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringEscapeUtils;
import ua.in.ualt.model.TlkFile;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class TlkXmlConverter implements XmlConverter<TlkFile> {

    @Override
    public String toXml(TlkFile dialogs) {
        return genXml(dialogs.getRows(), 0);
    }

    @Override
    public List<String> toMultipleXmls(TlkFile dialogs, int partitionSize) {
        return toMultipleXmls(dialogs, partitionSize, 0);
    }

    public List<String> toMultipleXmls(TlkFile dialogs, int partitionSize, int startIndex) {
        List<List<String>> rowPacks = Lists.partition(dialogs.getRows(), partitionSize);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < rowPacks.size(); i++) {
            result.add(genXml(rowPacks.get(i), i * partitionSize + startIndex));
        }
        return result;
    }

    @Override
    public TlkFile fromXml(String src) {
        throw new UnsupportedOperationException();
    }



    private String genXml(List<String> rows, int startIndex) {
        StringBuilder result = new StringBuilder();

        result.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        result.append("<resources>");

        for (int i = 0; i < rows.size(); i++) {
            if (i == 0 && rows.get(i).equals("Bad Strref")) continue;
            String s = "<string name=\"" + (i + startIndex) + "\">" + StringEscapeUtils.escapeXml(rows.get(i)) + "</string>\n";
            result.append(s);
        }

        result.append("</resources>");

        // tlk is encoded in cp1251 but utf8 is required by transifex
        return cp1251toUtf8(result.toString());
    }

    private String cp1251toUtf8(String cp1251) {
        return new String(cp1251.getBytes(Charset.forName("cp1251")), Charset.forName("utf-8"));
    }
}
