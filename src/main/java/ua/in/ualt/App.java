package ua.in.ualt;

import ua.in.ualt.parser.TlkParser;

import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) throw new IllegalArgumentException("Path to dialog.tlk is not specified");

        TlkParser parser = new TlkParser();
        parser.toObject(new File(args[0]));
    }
}
