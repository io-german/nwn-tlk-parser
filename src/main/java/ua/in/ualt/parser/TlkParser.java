package ua.in.ualt.parser;

import ua.in.ualt.model.DialogsFile;

import java.io.InputStream;
import java.io.OutputStream;

public class TlkParser implements Parser {

    @Override
    public DialogsFile toObject(InputStream src) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void toFile(DialogsFile src, OutputStream dest) {
        throw new UnsupportedOperationException();
    }
}
