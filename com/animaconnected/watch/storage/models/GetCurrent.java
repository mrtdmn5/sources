package com.animaconnected.watch.storage.models;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetCurrent.kt */
/* loaded from: classes3.dex */
public final class GetCurrent {
    private final String category;
    private final String device_address;
    private final Integer device_type;
    private final String last_dfu_result;
    private final String sku;
    private final Boolean stronger_vibration;
    private final Long time_diagnostics_sent;
    private final Long time_since_daily;
    private final Integer variant;

    public GetCurrent(String str, Integer num, String str2, String str3, Boolean bool, Long l, Long l2, Integer num2, String str4) {
        this.device_address = str;
        this.device_type = num;
        this.sku = str2;
        this.last_dfu_result = str3;
        this.stronger_vibration = bool;
        this.time_diagnostics_sent = l;
        this.time_since_daily = l2;
        this.variant = num2;
        this.category = str4;
    }

    public static /* synthetic */ GetCurrent copy$default(GetCurrent getCurrent, String str, Integer num, String str2, String str3, Boolean bool, Long l, Long l2, Integer num2, String str4, int r20, Object obj) {
        String str5;
        Integer num3;
        String str6;
        String str7;
        Boolean bool2;
        Long l3;
        Long l4;
        Integer num4;
        String str8;
        if ((r20 & 1) != 0) {
            str5 = getCurrent.device_address;
        } else {
            str5 = str;
        }
        if ((r20 & 2) != 0) {
            num3 = getCurrent.device_type;
        } else {
            num3 = num;
        }
        if ((r20 & 4) != 0) {
            str6 = getCurrent.sku;
        } else {
            str6 = str2;
        }
        if ((r20 & 8) != 0) {
            str7 = getCurrent.last_dfu_result;
        } else {
            str7 = str3;
        }
        if ((r20 & 16) != 0) {
            bool2 = getCurrent.stronger_vibration;
        } else {
            bool2 = bool;
        }
        if ((r20 & 32) != 0) {
            l3 = getCurrent.time_diagnostics_sent;
        } else {
            l3 = l;
        }
        if ((r20 & 64) != 0) {
            l4 = getCurrent.time_since_daily;
        } else {
            l4 = l2;
        }
        if ((r20 & 128) != 0) {
            num4 = getCurrent.variant;
        } else {
            num4 = num2;
        }
        if ((r20 & 256) != 0) {
            str8 = getCurrent.category;
        } else {
            str8 = str4;
        }
        return getCurrent.copy(str5, num3, str6, str7, bool2, l3, l4, num4, str8);
    }

    public final String component1() {
        return this.device_address;
    }

    public final Integer component2() {
        return this.device_type;
    }

    public final String component3() {
        return this.sku;
    }

    public final String component4() {
        return this.last_dfu_result;
    }

    public final Boolean component5() {
        return this.stronger_vibration;
    }

    public final Long component6() {
        return this.time_diagnostics_sent;
    }

    public final Long component7() {
        return this.time_since_daily;
    }

    public final Integer component8() {
        return this.variant;
    }

    public final String component9() {
        return this.category;
    }

    public final GetCurrent copy(String str, Integer num, String str2, String str3, Boolean bool, Long l, Long l2, Integer num2, String str4) {
        return new GetCurrent(str, num, str2, str3, bool, l, l2, num2, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetCurrent)) {
            return false;
        }
        GetCurrent getCurrent = (GetCurrent) obj;
        if (Intrinsics.areEqual(this.device_address, getCurrent.device_address) && Intrinsics.areEqual(this.device_type, getCurrent.device_type) && Intrinsics.areEqual(this.sku, getCurrent.sku) && Intrinsics.areEqual(this.last_dfu_result, getCurrent.last_dfu_result) && Intrinsics.areEqual(this.stronger_vibration, getCurrent.stronger_vibration) && Intrinsics.areEqual(this.time_diagnostics_sent, getCurrent.time_diagnostics_sent) && Intrinsics.areEqual(this.time_since_daily, getCurrent.time_since_daily) && Intrinsics.areEqual(this.variant, getCurrent.variant) && Intrinsics.areEqual(this.category, getCurrent.category)) {
            return true;
        }
        return false;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getDevice_address() {
        return this.device_address;
    }

    public final Integer getDevice_type() {
        return this.device_type;
    }

    public final String getLast_dfu_result() {
        return this.last_dfu_result;
    }

    public final String getSku() {
        return this.sku;
    }

    public final Boolean getStronger_vibration() {
        return this.stronger_vibration;
    }

    public final Long getTime_diagnostics_sent() {
        return this.time_diagnostics_sent;
    }

    public final Long getTime_since_daily() {
        return this.time_since_daily;
    }

    public final Integer getVariant() {
        return this.variant;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        String str = this.device_address;
        int r1 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = hashCode * 31;
        Integer num = this.device_type;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        String str2 = this.sku;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        String str3 = this.last_dfu_result;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        Boolean bool = this.stronger_vibration;
        if (bool == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = bool.hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        Long l = this.time_diagnostics_sent;
        if (l == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = l.hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        Long l2 = this.time_since_daily;
        if (l2 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = l2.hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        Integer num2 = this.variant;
        if (num2 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = num2.hashCode();
        }
        int r08 = (r07 + hashCode8) * 31;
        String str4 = this.category;
        if (str4 != null) {
            r1 = str4.hashCode();
        }
        return r08 + r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetCurrent(device_address=");
        sb.append(this.device_address);
        sb.append(", device_type=");
        sb.append(this.device_type);
        sb.append(", sku=");
        sb.append(this.sku);
        sb.append(", last_dfu_result=");
        sb.append(this.last_dfu_result);
        sb.append(", stronger_vibration=");
        sb.append(this.stronger_vibration);
        sb.append(", time_diagnostics_sent=");
        sb.append(this.time_diagnostics_sent);
        sb.append(", time_since_daily=");
        sb.append(this.time_since_daily);
        sb.append(", variant=");
        sb.append(this.variant);
        sb.append(", category=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.category, ')');
    }
}
