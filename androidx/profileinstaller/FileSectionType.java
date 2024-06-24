package androidx.profileinstaller;

/* loaded from: classes.dex */
public enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);

    private final long mValue;

    FileSectionType(long j) {
        this.mValue = j;
    }

    public static FileSectionType fromValue(long j) {
        FileSectionType[] values = values();
        for (int r1 = 0; r1 < values.length; r1++) {
            if (values[r1].getValue() == j) {
                return values[r1];
            }
        }
        throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("Unsupported FileSection Type ", j));
    }

    public long getValue() {
        return this.mValue;
    }
}
