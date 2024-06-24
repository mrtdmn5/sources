package com.animaconnected.watch.device;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: StringsBackend.kt */
/* loaded from: classes3.dex */
public final class FormattingContext {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FormattingContext[] $VALUES;
    public static final FormattingContext UNKNOWN = new FormattingContext("UNKNOWN", 0);
    public static final FormattingContext DYNAMIC = new FormattingContext("DYNAMIC", 1);
    public static final FormattingContext STANDALONE = new FormattingContext("STANDALONE", 2);
    public static final FormattingContext LIST_ITEM = new FormattingContext("LIST_ITEM", 3);
    public static final FormattingContext BEGINNING_OF_SENTENCE = new FormattingContext("BEGINNING_OF_SENTENCE", 4);
    public static final FormattingContext MIDDLE_OF_SENTENCE = new FormattingContext("MIDDLE_OF_SENTENCE", 5);

    private static final /* synthetic */ FormattingContext[] $values() {
        return new FormattingContext[]{UNKNOWN, DYNAMIC, STANDALONE, LIST_ITEM, BEGINNING_OF_SENTENCE, MIDDLE_OF_SENTENCE};
    }

    static {
        FormattingContext[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private FormattingContext(String str, int r2) {
    }

    public static EnumEntries<FormattingContext> getEntries() {
        return $ENTRIES;
    }

    public static FormattingContext valueOf(String str) {
        return (FormattingContext) Enum.valueOf(FormattingContext.class, str);
    }

    public static FormattingContext[] values() {
        return (FormattingContext[]) $VALUES.clone();
    }
}
