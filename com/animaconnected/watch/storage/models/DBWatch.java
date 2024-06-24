package com.animaconnected.watch.storage.models;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: DBWatch.kt */
/* loaded from: classes3.dex */
public final class DBWatch {
    private final String category;
    private final String device_address;
    private final int device_type;
    private final String last_dfu_result;
    private final String sku;
    private final boolean stronger_vibration;
    private final long time_diagnostics_sent;
    private final long time_since_daily;
    private final Integer variant;

    /* compiled from: DBWatch.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Integer, Long> device_typeAdapter;
        private final ColumnAdapter<Integer, Long> variantAdapter;

        public Adapter(ColumnAdapter<Integer, Long> device_typeAdapter, ColumnAdapter<Integer, Long> variantAdapter) {
            Intrinsics.checkNotNullParameter(device_typeAdapter, "device_typeAdapter");
            Intrinsics.checkNotNullParameter(variantAdapter, "variantAdapter");
            this.device_typeAdapter = device_typeAdapter;
            this.variantAdapter = variantAdapter;
        }

        public final ColumnAdapter<Integer, Long> getDevice_typeAdapter() {
            return this.device_typeAdapter;
        }

        public final ColumnAdapter<Integer, Long> getVariantAdapter() {
            return this.variantAdapter;
        }
    }

    public DBWatch(String device_address, int r3, String str, String last_dfu_result, boolean z, long j, long j2, Integer num, String str2) {
        Intrinsics.checkNotNullParameter(device_address, "device_address");
        Intrinsics.checkNotNullParameter(last_dfu_result, "last_dfu_result");
        this.device_address = device_address;
        this.device_type = r3;
        this.sku = str;
        this.last_dfu_result = last_dfu_result;
        this.stronger_vibration = z;
        this.time_diagnostics_sent = j;
        this.time_since_daily = j2;
        this.variant = num;
        this.category = str2;
    }

    public static /* synthetic */ DBWatch copy$default(DBWatch dBWatch, String str, int r14, String str2, String str3, boolean z, long j, long j2, Integer num, String str4, int r24, Object obj) {
        String str5;
        int r3;
        String str6;
        String str7;
        boolean z2;
        long j3;
        long j4;
        Integer num2;
        String str8;
        if ((r24 & 1) != 0) {
            str5 = dBWatch.device_address;
        } else {
            str5 = str;
        }
        if ((r24 & 2) != 0) {
            r3 = dBWatch.device_type;
        } else {
            r3 = r14;
        }
        if ((r24 & 4) != 0) {
            str6 = dBWatch.sku;
        } else {
            str6 = str2;
        }
        if ((r24 & 8) != 0) {
            str7 = dBWatch.last_dfu_result;
        } else {
            str7 = str3;
        }
        if ((r24 & 16) != 0) {
            z2 = dBWatch.stronger_vibration;
        } else {
            z2 = z;
        }
        if ((r24 & 32) != 0) {
            j3 = dBWatch.time_diagnostics_sent;
        } else {
            j3 = j;
        }
        if ((r24 & 64) != 0) {
            j4 = dBWatch.time_since_daily;
        } else {
            j4 = j2;
        }
        if ((r24 & 128) != 0) {
            num2 = dBWatch.variant;
        } else {
            num2 = num;
        }
        if ((r24 & 256) != 0) {
            str8 = dBWatch.category;
        } else {
            str8 = str4;
        }
        return dBWatch.copy(str5, r3, str6, str7, z2, j3, j4, num2, str8);
    }

    public final String component1() {
        return this.device_address;
    }

    public final int component2() {
        return this.device_type;
    }

    public final String component3() {
        return this.sku;
    }

    public final String component4() {
        return this.last_dfu_result;
    }

    public final boolean component5() {
        return this.stronger_vibration;
    }

    public final long component6() {
        return this.time_diagnostics_sent;
    }

    public final long component7() {
        return this.time_since_daily;
    }

    public final Integer component8() {
        return this.variant;
    }

    public final String component9() {
        return this.category;
    }

    public final DBWatch copy(String device_address, int r15, String str, String last_dfu_result, boolean z, long j, long j2, Integer num, String str2) {
        Intrinsics.checkNotNullParameter(device_address, "device_address");
        Intrinsics.checkNotNullParameter(last_dfu_result, "last_dfu_result");
        return new DBWatch(device_address, r15, str, last_dfu_result, z, j, j2, num, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBWatch)) {
            return false;
        }
        DBWatch dBWatch = (DBWatch) obj;
        if (Intrinsics.areEqual(this.device_address, dBWatch.device_address) && this.device_type == dBWatch.device_type && Intrinsics.areEqual(this.sku, dBWatch.sku) && Intrinsics.areEqual(this.last_dfu_result, dBWatch.last_dfu_result) && this.stronger_vibration == dBWatch.stronger_vibration && this.time_diagnostics_sent == dBWatch.time_diagnostics_sent && this.time_since_daily == dBWatch.time_since_daily && Intrinsics.areEqual(this.variant, dBWatch.variant) && Intrinsics.areEqual(this.category, dBWatch.category)) {
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

    public final int getDevice_type() {
        return this.device_type;
    }

    public final String getLast_dfu_result() {
        return this.last_dfu_result;
    }

    public final String getSku() {
        return this.sku;
    }

    public final boolean getStronger_vibration() {
        return this.stronger_vibration;
    }

    public final long getTime_diagnostics_sent() {
        return this.time_diagnostics_sent;
    }

    public final long getTime_since_daily() {
        return this.time_since_daily;
    }

    public final Integer getVariant() {
        return this.variant;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.device_type, this.device_address.hashCode() * 31, 31);
        String str = this.sku;
        int r2 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int m2 = Scale$$ExternalSyntheticOutline0.m(this.time_since_daily, Scale$$ExternalSyntheticOutline0.m(this.time_diagnostics_sent, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.stronger_vibration, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.last_dfu_result, (m + hashCode) * 31, 31), 31), 31), 31);
        Integer num = this.variant;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int r0 = (m2 + hashCode2) * 31;
        String str2 = this.category;
        if (str2 != null) {
            r2 = str2.hashCode();
        }
        return r0 + r2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBWatch(device_address=");
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
