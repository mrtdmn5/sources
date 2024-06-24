package com.animaconnected.info;

import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirmwareVariant.kt */
/* loaded from: classes.dex */
public final class FirmwareVariant {
    private final Integer value;

    public FirmwareVariant() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FirmwareVariant copy$default(FirmwareVariant firmwareVariant, Integer num, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            num = firmwareVariant.value;
        }
        return firmwareVariant.copy(num);
    }

    public final Integer component1() {
        return this.value;
    }

    public final FirmwareVariant copy(Integer num) {
        return new FirmwareVariant(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof FirmwareVariant) && Intrinsics.areEqual(this.value, ((FirmwareVariant) obj).value)) {
            return true;
        }
        return false;
    }

    public final Integer getValue() {
        return this.value;
    }

    public int hashCode() {
        Integer num = this.value;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        String str;
        Integer num = this.value;
        if (num == null) {
            str = "Unknown";
        } else if (num.intValue() == 1) {
            str = "Primo";
        } else if (num.intValue() == 2) {
            str = "Secondo";
        } else if (num.intValue() == 3) {
            str = "Secondo_eink";
        } else if (num.intValue() == 4) {
            str = "Garbo";
        } else if (num.intValue() == 5) {
            str = "Mezzo";
        } else if (num.intValue() == 6) {
            str = "BT003";
        } else if (num.intValue() == 7) {
            str = "BT003_dfu";
        } else if (num.intValue() == 8) {
            str = "CALIBRE";
        } else if (num.intValue() == 9) {
            str = "TESTO";
        } else if (num.intValue() == 10) {
            str = "TOBLERONE";
        } else if (num.intValue() == 11) {
            str = "VICINITY";
        } else if (num.intValue() == 12) {
            str = "FKS933";
        } else if (num.intValue() == 13) {
            str = "FKS927";
        } else if (num.intValue() == 15) {
            str = "FKS934_NO_FG";
        } else if (num.intValue() == 16) {
            str = "FKS934";
        } else if (num.intValue() == 17) {
            str = "Dolly";
        } else if (num.intValue() == 18) {
            str = "FKS934_FULL_DISPLAY";
        } else if (num.intValue() == 200) {
            str = "DK52";
        } else if (num.intValue() == 201) {
            str = "DK52840";
        } else if (num.intValue() == 202) {
            str = "DK52840_disp";
        } else if (num.intValue() == 203) {
            str = "DK52840_hr";
        } else if (num.intValue() == 204) {
            str = "FKS934_HR";
        } else if (num.intValue() == 205) {
            str = "FKS934_NO_HR";
        } else {
            str = "Other";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('(');
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.value, ')');
    }

    public FirmwareVariant(Integer num) {
        this.value = num;
    }

    public /* synthetic */ FirmwareVariant(Integer num, int r2, DefaultConstructorMarker defaultConstructorMarker) {
        this((r2 & 1) != 0 ? null : num);
    }
}
