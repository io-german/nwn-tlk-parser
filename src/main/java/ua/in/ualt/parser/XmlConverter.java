package ua.in.ualt.parser;

import ua.in.ualt.model.DialogsFile;

public interface XmlConverter<T extends DialogsFile> {

    String toXml(T dialogs);
    T fromXml(String src);
}
