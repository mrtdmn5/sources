package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.model.HistoryDeviceId$$serializer;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonNames;

/* compiled from: FitnessData.kt */
@Serializable
/* loaded from: classes3.dex */
public final class SleepHistoryEntry extends Entry {
    public static final Companion Companion = new Companion(null);
    private final long deepSleepMs;
    private final long end;
    private String historyDeviceId;
    private final long lightSleepMs;
    private long timestamp;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SleepHistoryEntry> serializer() {
            return SleepHistoryEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SleepHistoryEntry(int r1, @JsonNames(names = {"identifier"}) String str, long j, long j2, long j3, long j4, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, j, j2, j3, j4, serializationConstructorMarker);
    }

    /* renamed from: copy-_w5UW7A$default */
    public static /* synthetic */ SleepHistoryEntry m1481copy_w5UW7A$default(SleepHistoryEntry sleepHistoryEntry, String str, long j, long j2, long j3, long j4, int r20, Object obj) {
        String str2;
        long j5;
        long j6;
        long j7;
        long j8;
        if ((r20 & 1) != 0) {
            str2 = sleepHistoryEntry.historyDeviceId;
        } else {
            str2 = str;
        }
        if ((r20 & 2) != 0) {
            j5 = sleepHistoryEntry.timestamp;
        } else {
            j5 = j;
        }
        if ((r20 & 4) != 0) {
            j6 = sleepHistoryEntry.end;
        } else {
            j6 = j2;
        }
        if ((r20 & 8) != 0) {
            j7 = sleepHistoryEntry.lightSleepMs;
        } else {
            j7 = j3;
        }
        if ((r20 & 16) != 0) {
            j8 = sleepHistoryEntry.deepSleepMs;
        } else {
            j8 = j4;
        }
        return sleepHistoryEntry.m1484copy_w5UW7A(str2, j5, j6, j7, j8);
    }

    public static final /* synthetic */ void write$Self$watch_release(SleepHistoryEntry sleepHistoryEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(sleepHistoryEntry.mo1121getHistoryDeviceIdV9ZILtA()));
        compositeEncoder.encodeLongElement(serialDescriptor, 1, sleepHistoryEntry.getTimestamp());
        compositeEncoder.encodeLongElement(serialDescriptor, 2, sleepHistoryEntry.end);
        compositeEncoder.encodeLongElement(serialDescriptor, 3, sleepHistoryEntry.lightSleepMs);
        compositeEncoder.encodeLongElement(serialDescriptor, 4, sleepHistoryEntry.deepSleepMs);
    }

    /* renamed from: component1-V9ZILtA */
    public final String m1483component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final long component3() {
        return this.end;
    }

    public final long component4() {
        return this.lightSleepMs;
    }

    public final long component5() {
        return this.deepSleepMs;
    }

    /* renamed from: copy-_w5UW7A */
    public final SleepHistoryEntry m1484copy_w5UW7A(String historyDeviceId, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return new SleepHistoryEntry(historyDeviceId, j, j2, j3, j4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepHistoryEntry)) {
            return false;
        }
        SleepHistoryEntry sleepHistoryEntry = (SleepHistoryEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, sleepHistoryEntry.historyDeviceId) && this.timestamp == sleepHistoryEntry.timestamp && this.end == sleepHistoryEntry.end && this.lightSleepMs == sleepHistoryEntry.lightSleepMs && this.deepSleepMs == sleepHistoryEntry.deepSleepMs) {
            return true;
        }
        return false;
    }

    public final long getDeepSleepMs() {
        return this.deepSleepMs;
    }

    public final long getEnd() {
        return this.end;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    /* renamed from: getHistoryDeviceId-V9ZILtA */
    public String mo1121getHistoryDeviceIdV9ZILtA() {
        return this.historyDeviceId;
    }

    public final long getLightSleepMs() {
        return this.lightSleepMs;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Long.hashCode(this.deepSleepMs) + Scale$$ExternalSyntheticOutline0.m(this.lightSleepMs, Scale$$ExternalSyntheticOutline0.m(this.end, Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31), 31), 31);
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
        String trimMargin;
        StringBuilder sb = new StringBuilder("\n  |SleepHistoryEntry {\n  |  fitnessDeviceId: ");
        sb.append((Object) HistoryDeviceId.m1561toStringimpl(mo1121getHistoryDeviceIdV9ZILtA()));
        sb.append("\n  |  timestamp: ");
        sb.append(getTimestamp());
        sb.append(" (");
        Instant.Companion companion = Instant.Companion;
        long timestamp = getTimestamp();
        companion.getClass();
        sb.append(Instant.Companion.fromEpochMilliseconds(timestamp));
        sb.append(")\n  |  end: ");
        sb.append(this.end);
        sb.append(" (");
        sb.append(Instant.Companion.fromEpochMilliseconds(this.end));
        sb.append(")\n  |  lightSleepMs: ");
        sb.append(this.lightSleepMs);
        sb.append(" (");
        int r2 = Duration.$r8$clinit;
        long j = this.lightSleepMs;
        DurationUnit durationUnit = DurationUnit.MILLISECONDS;
        sb.append((Object) Duration.m1690toStringimpl(DurationKt.toDuration(j, durationUnit)));
        sb.append(")\n  |  deepSleepMs: ");
        sb.append(this.deepSleepMs);
        sb.append(" (");
        sb.append((Object) Duration.m1690toStringimpl(DurationKt.toDuration(this.deepSleepMs, durationUnit)));
        sb.append(")\n  |}\n  ");
        trimMargin = StringsKt__IndentKt.trimMargin(sb.toString(), "|");
        return trimMargin;
    }

    public /* synthetic */ SleepHistoryEntry(String str, long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, j3, j4);
    }

    private SleepHistoryEntry(int r2, String str, long j, long j2, long j3, long j4, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (r2 & 31)) {
            zzac.throwMissingFieldException(r2, 31, SleepHistoryEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.historyDeviceId = str;
        this.timestamp = j;
        this.end = j2;
        this.lightSleepMs = j3;
        this.deepSleepMs = j4;
    }

    private SleepHistoryEntry(String historyDeviceId, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.end = j2;
        this.lightSleepMs = j3;
        this.deepSleepMs = j4;
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations */
    public static /* synthetic */ void m1482getHistoryDeviceIdV9ZILtA$annotations() {
    }
}
