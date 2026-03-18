package edu.cscc.lab12.model;

//Using ENUM
public enum RecordSize {
    SEVEN_INCH(7),
    TEN_INCH(10),
    TWELVE_INCH(12);

    private final int inches;

    RecordSize(int inches) {
        this.inches = inches;
    }

    public int getInches() {
        return inches;
    }

    @Override
    public String toString() {
        return inches + "\"";
    }
}
