package io.ktor.util.date;

/* compiled from: Date.kt */
/* loaded from: classes3.dex */
public enum WeekDay {
    MONDAY("Mon"),
    TUESDAY("Tue"),
    WEDNESDAY("Wed"),
    THURSDAY("Thu"),
    FRIDAY("Fri"),
    SATURDAY("Sat"),
    SUNDAY("Sun");

    public static final Companion Companion = new Companion();
    private final String value;

    /* compiled from: Date.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    WeekDay(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
