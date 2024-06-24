package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
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
public final class DebugEntry extends Entry {
    public static final Companion Companion = new Companion(null);
    private String historyDeviceId;
    private long timestamp;
    private final int type;
    private final int value;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DebugEntry> serializer() {
            return DebugEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ DebugEntry(int r1, @JsonNames(names = {"identifier"}) String str, long j, int r5, int r6, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, j, r5, r6, serializationConstructorMarker);
    }

    /* renamed from: copy-4i7cvns$default, reason: not valid java name */
    public static /* synthetic */ DebugEntry m1211copy4i7cvns$default(DebugEntry debugEntry, String str, long j, int r7, int r8, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            str = debugEntry.historyDeviceId;
        }
        if ((r9 & 2) != 0) {
            j = debugEntry.timestamp;
        }
        long j2 = j;
        if ((r9 & 4) != 0) {
            r7 = debugEntry.type;
        }
        int r10 = r7;
        if ((r9 & 8) != 0) {
            r8 = debugEntry.value;
        }
        return debugEntry.m1214copy4i7cvns(str, j2, r10, r8);
    }

    public static final /* synthetic */ void write$Self$watch_release(DebugEntry debugEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(debugEntry.mo1121getHistoryDeviceIdV9ZILtA()));
        compositeEncoder.encodeLongElement(serialDescriptor, 1, debugEntry.getTimestamp());
        compositeEncoder.encodeIntElement(2, debugEntry.type, serialDescriptor);
        compositeEncoder.encodeIntElement(3, debugEntry.value, serialDescriptor);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1213component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.type;
    }

    public final int component4() {
        return this.value;
    }

    /* renamed from: copy-4i7cvns, reason: not valid java name */
    public final DebugEntry m1214copy4i7cvns(String historyDeviceId, long j, int r12, int r13) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return new DebugEntry(historyDeviceId, j, r12, r13, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DebugEntry)) {
            return false;
        }
        DebugEntry debugEntry = (DebugEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, debugEntry.historyDeviceId) && this.timestamp == debugEntry.timestamp && this.type == debugEntry.type && this.value == debugEntry.value) {
            return true;
        }
        return false;
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

    public final int getType() {
        return this.type;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return Integer.hashCode(this.value) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.type, Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31), 31);
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
        StringBuilder sb = new StringBuilder("DebugEntry(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", value=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.value, ')');
    }

    public /* synthetic */ DebugEntry(String str, long j, int r4, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4, r5);
    }

    private DebugEntry(int r2, String str, long j, int r6, int r7, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (r2 & 15)) {
            zzac.throwMissingFieldException(r2, 15, DebugEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.historyDeviceId = str;
        this.timestamp = j;
        this.type = r6;
        this.value = r7;
    }

    private DebugEntry(String historyDeviceId, long j, int r5, int r6) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.type = r5;
        this.value = r6;
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1212getHistoryDeviceIdV9ZILtA$annotations() {
    }
}
