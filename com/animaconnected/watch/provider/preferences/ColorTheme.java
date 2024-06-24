package com.animaconnected.watch.provider.preferences;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PreferenceProvider.kt */
/* loaded from: classes3.dex */
public final class ColorTheme {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ColorTheme[] $VALUES;
    public static final Companion Companion;
    private final int id;
    public static final ColorTheme Sku = new ColorTheme("Sku", 0, 0);
    public static final ColorTheme Default = new ColorTheme("Default", 1, 1);

    /* compiled from: PreferenceProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ColorTheme fromId$watch_release(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = ColorTheme.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((ColorTheme) obj).getId$watch_release() == r4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            return (ColorTheme) obj;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ColorTheme[] $values() {
        return new ColorTheme[]{Sku, Default};
    }

    static {
        ColorTheme[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private ColorTheme(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<ColorTheme> getEntries() {
        return $ENTRIES;
    }

    public static ColorTheme valueOf(String str) {
        return (ColorTheme) Enum.valueOf(ColorTheme.class, str);
    }

    public static ColorTheme[] values() {
        return (ColorTheme[]) $VALUES.clone();
    }

    public final int getId$watch_release() {
        return this.id;
    }
}
