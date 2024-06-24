package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.model.HistoryDeviceId$$serializer;
import com.animaconnected.watch.workout.SleepType;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonNames;

/* compiled from: FitnessData.kt */
@Serializable
/* loaded from: classes3.dex */
public final class SleepEntry extends Entry {
    public static final Companion Companion = new Companion(null);
    private String historyDeviceId;
    private final SleepType state;
    private long timestamp;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SleepEntry> serializer() {
            return SleepEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SleepEntry(int r1, @JsonNames(names = {"identifier"}) String str, long j, SleepType sleepType, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, j, sleepType, serializationConstructorMarker);
    }

    /* renamed from: copy-OZHprlw$default */
    public static /* synthetic */ SleepEntry m1477copyOZHprlw$default(SleepEntry sleepEntry, String str, long j, SleepType sleepType, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = sleepEntry.historyDeviceId;
        }
        if ((r5 & 2) != 0) {
            j = sleepEntry.timestamp;
        }
        if ((r5 & 4) != 0) {
            sleepType = sleepEntry.state;
        }
        return sleepEntry.m1480copyOZHprlw(str, j, sleepType);
    }

    public static final /* synthetic */ void write$Self$watch_release(SleepEntry sleepEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(sleepEntry.mo1121getHistoryDeviceIdV9ZILtA()));
        compositeEncoder.encodeLongElement(serialDescriptor, 1, sleepEntry.getTimestamp());
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, SleepTypeSerializer.INSTANCE, sleepEntry.state);
    }

    /* renamed from: component1-V9ZILtA */
    public final String m1479component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final SleepType component3() {
        return this.state;
    }

    /* renamed from: copy-OZHprlw */
    public final SleepEntry m1480copyOZHprlw(String historyDeviceId, long j, SleepType state) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(state, "state");
        return new SleepEntry(historyDeviceId, j, state, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepEntry)) {
            return false;
        }
        SleepEntry sleepEntry = (SleepEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, sleepEntry.historyDeviceId) && this.timestamp == sleepEntry.timestamp && this.state == sleepEntry.state) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    /* renamed from: getHistoryDeviceId-V9ZILtA */
    public String mo1121getHistoryDeviceIdV9ZILtA() {
        return this.historyDeviceId;
    }

    public final SleepType getState() {
        return this.state;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return this.state.hashCode() + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31);
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
        StringBuilder sb = new StringBuilder("SleepEntry(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ SleepEntry(String str, long j, SleepType sleepType, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, sleepType);
    }

    private SleepEntry(int r2, String str, long j, SleepType sleepType, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (r2 & 7)) {
            zzac.throwMissingFieldException(r2, 7, SleepEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.historyDeviceId = str;
        this.timestamp = j;
        this.state = sleepType;
    }

    private SleepEntry(String historyDeviceId, long j, SleepType state) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(state, "state");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.state = state;
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations */
    public static /* synthetic */ void m1478getHistoryDeviceIdV9ZILtA$annotations() {
    }
}
