package ua.in.ualt;

import org.apache.commons.io.FileUtils;
import ua.in.ualt.parser.TlkParser;
import ua.in.ualt.parser.TlkXmlConverter;
import ua.in.ualt.parser.XmlConverter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class App {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        if (args.length < 1) throw new IllegalArgumentException("Path to dialog.tlk is not specified");
        if (args.length < 2) throw new IllegalArgumentException("Path to result file is not specified");

        TlkParser parser = new TlkParser();
        XmlConverter xmlConverter = new TlkXmlConverter();
        List<String> xmls = xmlConverter.toMultipleXmls(parser.toObject(new File(args[0])), 10000);

        for (int i = 0; i < xmls.size(); i++) {
            File out = new File(new File(args[1]), "/dialogs_" + i + ".xml");
            FileUtils.writeStringToFile(out, xmls.get(i));
        }
    }
}
