package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
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
public final class DiagnosticsEntry extends Entry {
    public static final Companion Companion = new Companion(null);
    private String historyDeviceId;
    private final String key;
    private long timestamp;
    private final int value;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DiagnosticsEntry> serializer() {
            return DiagnosticsEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ DiagnosticsEntry(int r1, @JsonNames(names = {"identifier"}) String str, long j, String str2, int r6, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, j, str2, r6, serializationConstructorMarker);
    }

    /* renamed from: copy-4i7cvns$default, reason: not valid java name */
    public static /* synthetic */ DiagnosticsEntry m1215copy4i7cvns$default(DiagnosticsEntry diagnosticsEntry, String str, long j, String str2, int r8, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            str = diagnosticsEntry.historyDeviceId;
        }
        if ((r9 & 2) != 0) {
            j = diagnosticsEntry.timestamp;
        }
        long j2 = j;
        if ((r9 & 4) != 0) {
            str2 = diagnosticsEntry.key;
        }
        String str3 = str2;
        if ((r9 & 8) != 0) {
            r8 = diagnosticsEntry.value;
        }
        return diagnosticsEntry.m1218copy4i7cvns(str, j2, str3, r8);
    }

    public static final /* synthetic */ void write$Self$watch_release(DiagnosticsEntry diagnosticsEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(diagnosticsEntry.mo1121getHistoryDeviceIdV9ZILtA()));
        compositeEncoder.encodeLongElement(serialDescriptor, 1, diagnosticsEntry.getTimestamp());
        compositeEncoder.encodeStringElement(serialDescriptor, 2, diagnosticsEntry.key);
        compositeEncoder.encodeIntElement(3, diagnosticsEntry.value, serialDescriptor);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1217component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.key;
    }

    public final int component4() {
        return this.value;
    }

    /* renamed from: copy-4i7cvns, reason: not valid java name */
    public final DiagnosticsEntry m1218copy4i7cvns(String historyDeviceId, long j, String key, int r13) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(key, "key");
        return new DiagnosticsEntry(historyDeviceId, j, key, r13, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DiagnosticsEntry)) {
            return false;
        }
        DiagnosticsEntry diagnosticsEntry = (DiagnosticsEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, diagnosticsEntry.historyDeviceId) && this.timestamp == diagnosticsEntry.timestamp && Intrinsics.areEqual(this.key, diagnosticsEntry.key) && this.value == diagnosticsEntry.value) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    /* renamed from: getHistoryDeviceId-V9ZILtA */
    public String mo1121getHistoryDeviceIdV9ZILtA() {
        return this.historyDeviceId;
    }

    public final String getKey() {
        return this.key;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    public long getTimestamp() {
        return this.timestamp;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return Integer.hashCode(this.value) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.key, Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31), 31);
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
        StringBuilder sb = new StringBuilder("DiagnosticsEntry(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", key=");
        sb.append(this.key);
        sb.append(", value=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.value, ')');
    }

    public /* synthetic */ DiagnosticsEntry(String str, long j, String str2, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, r5);
    }

    private DiagnosticsEntry(int r2, String str, long j, String str2, int r7, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (r2 & 15)) {
            zzac.throwMissingFieldException(r2, 15, DiagnosticsEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.historyDeviceId = str;
        this.timestamp = j;
        this.key = str2;
        this.value = r7;
    }

    private DiagnosticsEntry(String historyDeviceId, long j, String key, int r6) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(key, "key");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.key = key;
        this.value = r6;
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1216getHistoryDeviceIdV9ZILtA$annotations() {
    }
}
