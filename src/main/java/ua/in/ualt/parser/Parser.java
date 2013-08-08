package ua.in.ualt.parser;

import ua.in.ualt.model.DialogsFile;

import java.io.InputStream;
import java.io.OutputStream;

public interface Parser {

    DialogsFile toObject(InputStream src);
    void toFile(DialogsFile src, OutputStream dest);
}
