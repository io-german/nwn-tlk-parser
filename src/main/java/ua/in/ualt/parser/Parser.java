package ua.in.ualt.parser;

import ua.in.ualt.model.DialogsFile;

import java.io.*;

public interface Parser {

    DialogsFile toObject(InputStream src) throws IOException;
    void toFile(DialogsFile src, OutputStream dest);
}
