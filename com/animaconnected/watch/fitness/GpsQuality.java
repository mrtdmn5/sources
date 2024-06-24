package com.animaconnected.watch.fitness;

import com.animaconnected.logger.LogKt;
import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class GpsQuality {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GpsQuality[] $VALUES;
    public static final Companion Companion;
    private final int id;
    public static final GpsQuality None = new GpsQuality("None", 0, 0);
    public static final GpsQuality Bad = new GpsQuality("Bad", 1, 1);
    public static final GpsQuality Good = new GpsQuality("Good", 2, 2);

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GpsQuality fromId(final Integer num) {
            Object obj;
            boolean z;
            Iterator<E> it = GpsQuality.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    int id = ((GpsQuality) obj).getId();
                    if (num != null && id == num.intValue()) {
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
            GpsQuality gpsQuality = (GpsQuality) obj;
            if (gpsQuality == null) {
                final GpsQuality gpsQuality2 = GpsQuality.None;
                LogKt.warn$default((Object) GpsQuality.Companion, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.GpsQuality$Companion$fromId$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Invalid SessionGps id: " + num + ", defaulting to " + gpsQuality2;
                    }
                }, 7, (Object) null);
                return gpsQuality2;
            }
            return gpsQuality;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ GpsQuality[] $values() {
        return new GpsQuality[]{None, Bad, Good};
    }

    static {
        GpsQuality[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private GpsQuality(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<GpsQuality> getEntries() {
        return $ENTRIES;
    }

    public static GpsQuality valueOf(String str) {
        return (GpsQuality) Enum.valueOf(GpsQuality.class, str);
    }

    public static GpsQuality[] values() {
        return (GpsQuality[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
