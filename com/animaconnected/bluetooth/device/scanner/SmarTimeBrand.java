package com.animaconnected.bluetooth.device.scanner;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ScannedDevice.kt */
/* loaded from: classes.dex */
public final class SmarTimeBrand {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SmarTimeBrand[] $VALUES;
    public static final Companion Companion;
    private final Regex nameRegex;
    public static final SmarTimeBrand Lotus = new SmarTimeBrand("Lotus", 0, new Regex("(Lotus S[0-9]*)"));
    public static final SmarTimeBrand Calypso = new SmarTimeBrand("Calypso", 1, new Regex("(Calypso S[0-9]*)"));
    public static final SmarTimeBrand Festina = new SmarTimeBrand("Festina", 2, new Regex("(Festina#[0-9]*)"));

    /* compiled from: ScannedDevice.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SmarTimeBrand parseFromName(String str) {
            Object obj = null;
            if (str == null) {
                return null;
            }
            Iterator<E> it = SmarTimeBrand.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Regex nameRegex = ((SmarTimeBrand) next).getNameRegex();
                nameRegex.getClass();
                if (nameRegex.nativePattern.matcher(str).find()) {
                    obj = next;
                    break;
                }
            }
            return (SmarTimeBrand) obj;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SmarTimeBrand[] $values() {
        return new SmarTimeBrand[]{Lotus, Calypso, Festina};
    }

    static {
        SmarTimeBrand[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private SmarTimeBrand(String str, int r2, Regex regex) {
        this.nameRegex = regex;
    }

    public static EnumEntries<SmarTimeBrand> getEntries() {
        return $ENTRIES;
    }

    public static final SmarTimeBrand parseFromName(String str) {
        return Companion.parseFromName(str);
    }

    public static SmarTimeBrand valueOf(String str) {
        return (SmarTimeBrand) Enum.valueOf(SmarTimeBrand.class, str);
    }

    public static SmarTimeBrand[] values() {
        return (SmarTimeBrand[]) $VALUES.clone();
    }

    public final Regex getNameRegex() {
        return this.nameRegex;
    }
}
