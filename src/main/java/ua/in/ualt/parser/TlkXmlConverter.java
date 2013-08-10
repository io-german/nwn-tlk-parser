package ua.in.ualt.parser;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringEscapeUtils;
import ua.in.ualt.model.TlkFile;

import java.util.ArrayList;
import java.util.List;

public class TlkXmlConverter implements XmlConverter<TlkFile> {

    @Override
    public String toXml(TlkFile dialogs) {
        return genXml(dialogs.getRows(), 0);
    }

    @Override
    public List<String> toMultipleXmls(TlkFile dialogs, int partitionSize) {
        List<List<String>> rowPacks = Lists.partition(dialogs.getRows(), partitionSize);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < rowPacks.size(); i++) {
            result.add(genXml(rowPacks.get(i), i * partitionSize));
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
            String s = "<string name=\"" + (i + startIndex) + "\">" + StringEscapeUtils.escapeXml(rows.get(i)) + "</string>\n";
            result.append(s);
        }

        result.append("</resources>");
        return result.toString();
    }
}
