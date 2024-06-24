package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.model.HistoryDeviceId$$serializer;
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
public final class WristEntry extends Entry {
    public static final Companion Companion = new Companion(null);
    private String historyDeviceId;
    private final WristState state;
    private long timestamp;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<WristEntry> serializer() {
            return WristEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ WristEntry(int r1, @JsonNames(names = {"identifier"}) String str, long j, WristState wristState, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, j, wristState, serializationConstructorMarker);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ WristEntry m1514copyOZHprlw$default(WristEntry wristEntry, String str, long j, WristState wristState, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = wristEntry.historyDeviceId;
        }
        if ((r5 & 2) != 0) {
            j = wristEntry.timestamp;
        }
        if ((r5 & 4) != 0) {
            wristState = wristEntry.state;
        }
        return wristEntry.m1517copyOZHprlw(str, j, wristState);
    }

    public static final /* synthetic */ void write$Self$watch_release(WristEntry wristEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(wristEntry.mo1121getHistoryDeviceIdV9ZILtA()));
        compositeEncoder.encodeLongElement(serialDescriptor, 1, wristEntry.getTimestamp());
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, WristStateSerializer.INSTANCE, wristEntry.state);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1516component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final WristState component3() {
        return this.state;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final WristEntry m1517copyOZHprlw(String historyDeviceId, long j, WristState state) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(state, "state");
        return new WristEntry(historyDeviceId, j, state, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WristEntry)) {
            return false;
        }
        WristEntry wristEntry = (WristEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, wristEntry.historyDeviceId) && this.timestamp == wristEntry.timestamp && this.state == wristEntry.state) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    /* renamed from: getHistoryDeviceId-V9ZILtA */
    public String mo1121getHistoryDeviceIdV9ZILtA() {
        return this.historyDeviceId;
    }

    public final WristState getState() {
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
        StringBuilder sb = new StringBuilder("WristEntry(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ WristEntry(String str, long j, WristState wristState, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, wristState);
    }

    private WristEntry(int r2, String str, long j, WristState wristState, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (r2 & 7)) {
            zzac.throwMissingFieldException(r2, 7, WristEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.historyDeviceId = str;
        this.timestamp = j;
        this.state = wristState;
    }

    private WristEntry(String historyDeviceId, long j, WristState state) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(state, "state");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.state = state;
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1515getHistoryDeviceIdV9ZILtA$annotations() {
    }
}
