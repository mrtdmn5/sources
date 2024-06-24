package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBHeartrateData.kt */
/* loaded from: classes3.dex */
public final class DBHeartrateData {
    private final int confidence;
    private final String hdid;
    private final int heartrate;
    private final Integer heartrate_high;
    private final Integer heartrate_low;
    private final long timestamp;

    /* compiled from: DBHeartrateData.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Integer, Long> confidenceAdapter;
        private final ColumnAdapter<HistoryDeviceId, String> hdidAdapter;
        private final ColumnAdapter<Integer, Long> heartrateAdapter;
        private final ColumnAdapter<Integer, Long> heartrate_highAdapter;
        private final ColumnAdapter<Integer, Long> heartrate_lowAdapter;

        public Adapter(ColumnAdapter<HistoryDeviceId, String> hdidAdapter, ColumnAdapter<Integer, Long> heartrateAdapter, ColumnAdapter<Integer, Long> confidenceAdapter, ColumnAdapter<Integer, Long> heartrate_lowAdapter, ColumnAdapter<Integer, Long> heartrate_highAdapter) {
            Intrinsics.checkNotNullParameter(hdidAdapter, "hdidAdapter");
            Intrinsics.checkNotNullParameter(heartrateAdapter, "heartrateAdapter");
            Intrinsics.checkNotNullParameter(confidenceAdapter, "confidenceAdapter");
            Intrinsics.checkNotNullParameter(heartrate_lowAdapter, "heartrate_lowAdapter");
            Intrinsics.checkNotNullParameter(heartrate_highAdapter, "heartrate_highAdapter");
            this.hdidAdapter = hdidAdapter;
            this.heartrateAdapter = heartrateAdapter;
            this.confidenceAdapter = confidenceAdapter;
            this.heartrate_lowAdapter = heartrate_lowAdapter;
            this.heartrate_highAdapter = heartrate_highAdapter;
        }

        public final ColumnAdapter<Integer, Long> getConfidenceAdapter() {
            return this.confidenceAdapter;
        }

        public final ColumnAdapter<HistoryDeviceId, String> getHdidAdapter() {
            return this.hdidAdapter;
        }

        public final ColumnAdapter<Integer, Long> getHeartrateAdapter() {
            return this.heartrateAdapter;
        }

        public final ColumnAdapter<Integer, Long> getHeartrate_highAdapter() {
            return this.heartrate_highAdapter;
        }

        public final ColumnAdapter<Integer, Long> getHeartrate_lowAdapter() {
            return this.heartrate_lowAdapter;
        }
    }

    public /* synthetic */ DBHeartrateData(String str, long j, int r4, int r5, Integer num, Integer num2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4, r5, num, num2);
    }

    /* renamed from: copy-FGKXf14$default, reason: not valid java name */
    public static /* synthetic */ DBHeartrateData m1159copyFGKXf14$default(DBHeartrateData dBHeartrateData, String str, long j, int r9, int r10, Integer num, Integer num2, int r13, Object obj) {
        if ((r13 & 1) != 0) {
            str = dBHeartrateData.hdid;
        }
        if ((r13 & 2) != 0) {
            j = dBHeartrateData.timestamp;
        }
        long j2 = j;
        if ((r13 & 4) != 0) {
            r9 = dBHeartrateData.heartrate;
        }
        int r14 = r9;
        if ((r13 & 8) != 0) {
            r10 = dBHeartrateData.confidence;
        }
        int r2 = r10;
        if ((r13 & 16) != 0) {
            num = dBHeartrateData.heartrate_low;
        }
        Integer num3 = num;
        if ((r13 & 32) != 0) {
            num2 = dBHeartrateData.heartrate_high;
        }
        return dBHeartrateData.m1161copyFGKXf14(str, j2, r14, r2, num3, num2);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1160component1V9ZILtA() {
        return this.hdid;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.heartrate;
    }

    public final int component4() {
        return this.confidence;
    }

    public final Integer component5() {
        return this.heartrate_low;
    }

    public final Integer component6() {
        return this.heartrate_high;
    }

    /* renamed from: copy-FGKXf14, reason: not valid java name */
    public final DBHeartrateData m1161copyFGKXf14(String hdid, long j, int r14, int r15, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        return new DBHeartrateData(hdid, j, r14, r15, num, num2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBHeartrateData)) {
            return false;
        }
        DBHeartrateData dBHeartrateData = (DBHeartrateData) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.hdid, dBHeartrateData.hdid) && this.timestamp == dBHeartrateData.timestamp && this.heartrate == dBHeartrateData.heartrate && this.confidence == dBHeartrateData.confidence && Intrinsics.areEqual(this.heartrate_low, dBHeartrateData.heartrate_low) && Intrinsics.areEqual(this.heartrate_high, dBHeartrateData.heartrate_high)) {
            return true;
        }
        return false;
    }

    public final int getConfidence() {
        return this.confidence;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1162getHdidV9ZILtA() {
        return this.hdid;
    }

    public final int getHeartrate() {
        return this.heartrate;
    }

    public final Integer getHeartrate_high() {
        return this.heartrate_high;
    }

    public final Integer getHeartrate_low() {
        return this.heartrate_low;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int hashCode;
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.confidence, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.heartrate, Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.hdid) * 31, 31), 31), 31);
        Integer num = this.heartrate_low;
        int r2 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        Integer num2 = this.heartrate_high;
        if (num2 != null) {
            r2 = num2.hashCode();
        }
        return r0 + r2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBHeartrateData(hdid=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.hdid, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", heartrate=");
        sb.append(this.heartrate);
        sb.append(", confidence=");
        sb.append(this.confidence);
        sb.append(", heartrate_low=");
        sb.append(this.heartrate_low);
        sb.append(", heartrate_high=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.heartrate_high, ')');
    }

    private DBHeartrateData(String hdid, long j, int r5, int r6, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(hdid, "hdid");
        this.hdid = hdid;
        this.timestamp = j;
        this.heartrate = r5;
        this.confidence = r6;
        this.heartrate_low = num;
        this.heartrate_high = num2;
    }
}
