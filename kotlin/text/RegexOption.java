package kotlin.text;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Regex.kt */
/* loaded from: classes.dex */
public final class RegexOption {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RegexOption[] $VALUES;
    public static final RegexOption COMMENTS;
    public static final RegexOption LITERAL;
    private final int mask;
    private final int value;
    public static final RegexOption IGNORE_CASE = new RegexOption("IGNORE_CASE", 0, 2, 0, 2, null);
    public static final RegexOption MULTILINE = new RegexOption("MULTILINE", 1, 8, 0, 2, null);
    public static final RegexOption UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, 0, 2, null);
    public static final RegexOption DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 32, 0, 2, null);
    public static final RegexOption CANON_EQ = new RegexOption("CANON_EQ", 6, 128, 0, 2, null);

    private static final /* synthetic */ RegexOption[] $values() {
        return new RegexOption[]{IGNORE_CASE, MULTILINE, LITERAL, UNIX_LINES, COMMENTS, DOT_MATCHES_ALL, CANON_EQ};
    }

    static {
        int r12 = 0;
        int r13 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        LITERAL = new RegexOption("LITERAL", 2, 16, r12, r13, defaultConstructorMarker);
        COMMENTS = new RegexOption("COMMENTS", 4, 4, r12, r13, defaultConstructorMarker);
        RegexOption[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private RegexOption(String str, int r2, int r3, int r4) {
        this.value = r3;
        this.mask = r4;
    }

    public static EnumEntries<RegexOption> getEntries() {
        return $ENTRIES;
    }

    public static RegexOption valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) $VALUES.clone();
    }

    public int getMask() {
        return this.mask;
    }

    public int getValue() {
        return this.value;
    }

    public /* synthetic */ RegexOption(String str, int r2, int r3, int r4, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, r2, r3, (r5 & 2) != 0 ? r3 : r4);
    }
}
