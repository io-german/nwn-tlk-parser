package ua.in.ualt.model;

public class Header {

    final public String fileType;
    final public int languageId;
    final public int stringCount;
    final public int stringEntriesOffset;

    public Header(String fileType, int languageId, int stringCount, int stringEntriesOffset) {
        this.fileType = fileType;
        this.languageId = languageId;
        this.stringCount = stringCount;
        this.stringEntriesOffset = stringEntriesOffset;
    }
}
