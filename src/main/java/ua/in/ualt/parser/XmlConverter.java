package ua.in.ualt.parser;

import ua.in.ualt.model.DialogsFile;

import java.util.List;

public interface XmlConverter<T extends DialogsFile> {

    String toXml(T dialogs);
    List<String> toMultipleXmls(T dialogs, int partitionCount);
    T fromXml(String src);
}
