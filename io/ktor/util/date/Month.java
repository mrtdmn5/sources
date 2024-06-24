package io.ktor.util.date;

/* compiled from: Date.kt */
/* loaded from: classes3.dex */
public enum Month {
    JANUARY("Jan"),
    FEBRUARY("Feb"),
    MARCH("Mar"),
    APRIL("Apr"),
    MAY("May"),
    JUNE("Jun"),
    JULY("Jul"),
    AUGUST("Aug"),
    SEPTEMBER("Sep"),
    OCTOBER("Oct"),
    NOVEMBER("Nov"),
    DECEMBER("Dec");

    public static final Companion Companion = new Companion();
    private final String value;

    /* compiled from: Date.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    Month(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
