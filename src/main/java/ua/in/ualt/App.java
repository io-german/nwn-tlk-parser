package ua.in.ualt;

import org.apache.commons.io.FileUtils;
import ua.in.ualt.model.TlkFile;
import ua.in.ualt.parser.TlkParser;
import ua.in.ualt.parser.TlkXmlConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class App {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        if (args.length < 1) throw new IllegalArgumentException("Path to dialog.tlk is not specified");
        if (args.length < 2) throw new IllegalArgumentException("Path to result file is not specified");

        int startIndex = args.length < 3 ? 0 : Integer.parseInt(args[2]);

        TlkParser parser = new TlkParser();
        TlkXmlConverter xmlConverter = new TlkXmlConverter();

        TlkFile tlk = (TlkFile) parser.toObject(new FileInputStream(new File(args[0])));
        List<String> xmls = xmlConverter.toMultipleXmls(tlk, 10000, startIndex);

        for (int i = 0; i < xmls.size(); i++) {
            File out = new File(new File(args[1]), "/dialogs_" + i + ".xml");
            FileUtils.writeStringToFile(out, xmls.get(i));
        }
    }
}
