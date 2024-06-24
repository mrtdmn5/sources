package com.animaconnected.info;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import com.amplifyframework.core.model.ModelIdentifier;
import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceType.kt */
/* loaded from: classes.dex */
public final class DeviceType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeviceType[] $VALUES;
    public static final int ADVERTISED_NUMBER_INVALID = -1;
    public static final DeviceType BT001;
    public static final DeviceType BT002;
    public static final DeviceType BT003;
    public static final Companion Companion;
    public static final DeviceType FKS927;
    public static final DeviceType FKS933;
    public static final DeviceType GARBO;
    public static final DeviceType PASCAL;
    public static final DeviceType PASCAL_FULL;
    public static final DeviceType PRONTO_WATCH;
    public static final DeviceType SECONDO;
    private final int advertisedNumber;

    /* compiled from: DeviceType.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DeviceType fromAdvertisedNumber(int r4) {
            DeviceType fromAdvertisedNumberOrNull = fromAdvertisedNumberOrNull(r4);
            if (fromAdvertisedNumberOrNull != null) {
                return fromAdvertisedNumberOrNull;
            }
            throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR, r4, "\" isn't a valid DeviceType"));
        }

        public final DeviceType fromAdvertisedNumberOrNull(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = DeviceType.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((DeviceType) obj).getAdvertisedNumber() == r4) {
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
            return (DeviceType) obj;
        }

        private Companion() {
        }

        public static /* synthetic */ void getPRONTO_WATCH$annotations() {
        }
    }

    private static final /* synthetic */ DeviceType[] $values() {
        return new DeviceType[]{BT001, BT002, BT003, PASCAL, FKS933, FKS927, PASCAL_FULL};
    }

    static {
        DeviceType deviceType = new DeviceType("BT001", 0, 1);
        BT001 = deviceType;
        DeviceType deviceType2 = new DeviceType("BT002", 1, 2);
        BT002 = deviceType2;
        DeviceType deviceType3 = new DeviceType("BT003", 2, 3);
        BT003 = deviceType3;
        PASCAL = new DeviceType("PASCAL", 3, 7);
        FKS933 = new DeviceType("FKS933", 4, 8);
        FKS927 = new DeviceType("FKS927", 5, 9);
        PASCAL_FULL = new DeviceType("PASCAL_FULL", 6, 10);
        DeviceType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        GARBO = deviceType2;
        SECONDO = deviceType;
        PRONTO_WATCH = deviceType3;
    }

    private DeviceType(String str, int r2, int r3) {
        this.advertisedNumber = r3;
    }

    public static final DeviceType fromAdvertisedNumber(int r1) {
        return Companion.fromAdvertisedNumber(r1);
    }

    public static final DeviceType fromAdvertisedNumberOrNull(int r1) {
        return Companion.fromAdvertisedNumberOrNull(r1);
    }

    public static EnumEntries<DeviceType> getEntries() {
        return $ENTRIES;
    }

    public static DeviceType valueOf(String str) {
        return (DeviceType) Enum.valueOf(DeviceType.class, str);
    }

    public static DeviceType[] values() {
        return (DeviceType[]) $VALUES.clone();
    }

    public final int getAdvertisedNumber() {
        return this.advertisedNumber;
    }

    public final boolean getHasDisplay() {
        if (this != PASCAL && this != PASCAL_FULL) {
            return false;
        }
        return true;
    }

    public final boolean isPrimo() {
        if (this != BT001 && this != BT002) {
            return false;
        }
        return true;
    }
}
