package com.animaconnected.watch.strings;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public final class Language {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Language[] $VALUES;
    public static final Language EN;
    public static final Language ES;
    public static final Language FR;
    public static final Language HU;
    public static final Language IT;
    public static final Language PL;
    public static final Language PT;
    private final String code;
    private final boolean latinSupported;
    public static final Language CS = new Language("CS", 0, "cs", false, 2, null);
    public static final Language DA = new Language("DA", 1, "da", false, 2, null);
    public static final Language DE = new Language("DE", 2, "de", false, 2, null);
    public static final Language EL = new Language("EL", 3, "el", false);
    public static final Language JA = new Language("JA", 9, "ja", false);
    public static final Language RU = new Language("RU", 12, "ru", false);
    public static final Language SK = new Language("SK", 13, "sk", false, 2, null);
    public static final Language SV = new Language("SV", 14, "sv", false, 2, null);
    public static final Language ZH = new Language("ZH", 15, "zh", false);

    private static final /* synthetic */ Language[] $values() {
        return new Language[]{CS, DA, DE, EL, EN, ES, FR, HU, IT, JA, PL, PT, RU, SK, SV, ZH};
    }

    static {
        boolean z = false;
        int r10 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        EN = new Language("EN", 4, "en", z, r10, defaultConstructorMarker);
        boolean z2 = false;
        int r21 = 2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        ES = new Language("ES", 5, "es", z2, r21, defaultConstructorMarker2);
        FR = new Language("FR", 6, "fr", z, r10, defaultConstructorMarker);
        HU = new Language("HU", 7, "hu", z2, r21, defaultConstructorMarker2);
        IT = new Language("IT", 8, "it", z, r10, defaultConstructorMarker);
        PL = new Language("PL", 10, "pl", z2, r21, defaultConstructorMarker2);
        PT = new Language("PT", 11, "pt", z, r10, defaultConstructorMarker);
        Language[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Language(String str, int r2, String str2, boolean z) {
        this.code = str2;
        this.latinSupported = z;
    }

    public static EnumEntries<Language> getEntries() {
        return $ENTRIES;
    }

    public static Language valueOf(String str) {
        return (Language) Enum.valueOf(Language.class, str);
    }

    public static Language[] values() {
        return (Language[]) $VALUES.clone();
    }

    public final String getCode() {
        return this.code;
    }

    public final boolean getLatinSupported() {
        return this.latinSupported;
    }

    public /* synthetic */ Language(String str, int r2, String str2, boolean z, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, r2, str2, (r5 & 2) != 0 ? true : z);
    }
}
