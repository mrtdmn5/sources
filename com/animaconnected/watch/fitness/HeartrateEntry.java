package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.model.HistoryDeviceId$$serializer;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonNames;

/* compiled from: FitnessData.kt */
@Serializable
/* loaded from: classes3.dex */
public final class HeartrateEntry extends Entry {
    public static final Companion Companion = new Companion(null);
    private final int confidence;
    private final int heartrate;
    private final Integer heartrateHigh;
    private final Integer heartrateLow;
    private String historyDeviceId;
    private long timestamp;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<HeartrateEntry> serializer() {
            return HeartrateEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ HeartrateEntry(int r1, @JsonNames(names = {"identifier"}) String str, long j, int r5, int r6, Integer num, Integer num2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, j, r5, r6, num, num2, serializationConstructorMarker);
    }

    /* renamed from: copy-FGKXf14$default, reason: not valid java name */
    public static /* synthetic */ HeartrateEntry m1443copyFGKXf14$default(HeartrateEntry heartrateEntry, String str, long j, int r9, int r10, Integer num, Integer num2, int r13, Object obj) {
        if ((r13 & 1) != 0) {
            str = heartrateEntry.historyDeviceId;
        }
        if ((r13 & 2) != 0) {
            j = heartrateEntry.timestamp;
        }
        long j2 = j;
        if ((r13 & 4) != 0) {
            r9 = heartrateEntry.heartrate;
        }
        int r14 = r9;
        if ((r13 & 8) != 0) {
            r10 = heartrateEntry.confidence;
        }
        int r2 = r10;
        if ((r13 & 16) != 0) {
            num = heartrateEntry.heartrateLow;
        }
        Integer num3 = num;
        if ((r13 & 32) != 0) {
            num2 = heartrateEntry.heartrateHigh;
        }
        return heartrateEntry.m1446copyFGKXf14(str, j2, r14, r2, num3, num2);
    }

    public static final /* synthetic */ void write$Self$watch_release(HeartrateEntry heartrateEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2 = false;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(heartrateEntry.mo1121getHistoryDeviceIdV9ZILtA()));
        compositeEncoder.encodeLongElement(serialDescriptor, 1, heartrateEntry.getTimestamp());
        compositeEncoder.encodeIntElement(2, heartrateEntry.heartrate, serialDescriptor);
        compositeEncoder.encodeIntElement(3, heartrateEntry.confidence, serialDescriptor);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || heartrateEntry.heartrateLow != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, heartrateEntry.heartrateLow);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || heartrateEntry.heartrateHigh != null) {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, heartrateEntry.heartrateHigh);
        }
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1445component1V9ZILtA() {
        return this.historyDeviceId;
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
        return this.heartrateLow;
    }

    public final Integer component6() {
        return this.heartrateHigh;
    }

    /* renamed from: copy-FGKXf14, reason: not valid java name */
    public final HeartrateEntry m1446copyFGKXf14(String historyDeviceId, long j, int r14, int r15, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return new HeartrateEntry(historyDeviceId, j, r14, r15, num, num2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeartrateEntry)) {
            return false;
        }
        HeartrateEntry heartrateEntry = (HeartrateEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, heartrateEntry.historyDeviceId) && this.timestamp == heartrateEntry.timestamp && this.heartrate == heartrateEntry.heartrate && this.confidence == heartrateEntry.confidence && Intrinsics.areEqual(this.heartrateLow, heartrateEntry.heartrateLow) && Intrinsics.areEqual(this.heartrateHigh, heartrateEntry.heartrateHigh)) {
            return true;
        }
        return false;
    }

    public final int getConfidence() {
        return this.confidence;
    }

    public final int getHeartrate() {
        return this.heartrate;
    }

    public final Integer getHeartrateHigh() {
        return this.heartrateHigh;
    }

    public final Integer getHeartrateLow() {
        return this.heartrateLow;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    /* renamed from: getHistoryDeviceId-V9ZILtA */
    public String mo1121getHistoryDeviceIdV9ZILtA() {
        return this.historyDeviceId;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int hashCode;
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.confidence, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.heartrate, Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31), 31), 31);
        Integer num = this.heartrateLow;
        int r2 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        Integer num2 = this.heartrateHigh;
        if (num2 != null) {
            r2 = num2.hashCode();
        }
        return r0 + r2;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    /* renamed from: setHistoryDeviceId-Y1s2hH8 */
    public void mo1122setHistoryDeviceIdY1s2hH8(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.historyDeviceId = str;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HeartrateEntry(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", heartrate=");
        sb.append(this.heartrate);
        sb.append(", confidence=");
        sb.append(this.confidence);
        sb.append(", heartrateLow=");
        sb.append(this.heartrateLow);
        sb.append(", heartrateHigh=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.heartrateHigh, ')');
    }

    public /* synthetic */ HeartrateEntry(String str, long j, int r4, int r5, Integer num, Integer num2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4, r5, num, num2);
    }

    private HeartrateEntry(int r3, String str, long j, int r7, int r8, Integer num, Integer num2, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (r3 & 15)) {
            zzac.throwMissingFieldException(r3, 15, HeartrateEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.historyDeviceId = str;
        this.timestamp = j;
        this.heartrate = r7;
        this.confidence = r8;
        if ((r3 & 16) == 0) {
            this.heartrateLow = null;
        } else {
            this.heartrateLow = num;
        }
        if ((r3 & 32) == 0) {
            this.heartrateHigh = null;
        } else {
            this.heartrateHigh = num2;
        }
    }

    public /* synthetic */ HeartrateEntry(String str, long j, int r15, int r16, Integer num, Integer num2, int r19, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r15, r16, (r19 & 16) != 0 ? null : num, (r19 & 32) != 0 ? null : num2, null);
    }

    private HeartrateEntry(String historyDeviceId, long j, int r5, int r6, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.heartrate = r5;
        this.confidence = r6;
        this.heartrateLow = num;
        this.heartrateHigh = num2;
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1444getHistoryDeviceIdV9ZILtA$annotations() {
    }
}
