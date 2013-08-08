package ua.in.ualt.model;

public class Row {

    final public int flags;
    final public String soundResRef;
    final public int volumeVariance;
    final public int pitchVariance;
    final public int offsetToString;
    final public int stringSize;
    final public float soundLength;

    final public String text;

    public Row(int flags, String soundResRef, int volumeVariance, int pitchVariance,
               int offsetToString, int stringSize, float soundLength, String text) {

        this.flags = flags;
        this.soundResRef = soundResRef;
        this.volumeVariance = volumeVariance;
        this.pitchVariance = pitchVariance;
        this.offsetToString = offsetToString;
        this.stringSize = stringSize;
        this.soundLength = soundLength;
        this.text = text;
    }
}
