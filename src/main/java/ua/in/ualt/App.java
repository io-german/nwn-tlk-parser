package ua.in.ualt;

import org.apache.commons.io.FileUtils;
import ua.in.ualt.parser.TlkParser;
import ua.in.ualt.parser.TlkXmlConverter;
import ua.in.ualt.parser.XmlConverter;

import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) throw new IllegalArgumentException("Path to dialog.tlk is not specified");
        if (args.length < 2) throw new IllegalArgumentException("Path to result file is not specified");

        TlkParser parser = new TlkParser();
        XmlConverter xmlConverter = new TlkXmlConverter();
        String xml = xmlConverter.toXml(parser.toObject(new File(args[0])));

        File out = new File(args[1]);
        FileUtils.writeStringToFile(out, xml);
    }
}
