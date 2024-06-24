package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
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
public final class StandEntry extends Entry {
    public static final Companion Companion = new Companion(null);
    private String historyDeviceId;
    private final int successfulStands;
    private long timestamp;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<StandEntry> serializer() {
            return StandEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ StandEntry(int r1, @JsonNames(names = {"identifier"}) String str, long j, int r5, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, j, r5, serializationConstructorMarker);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ StandEntry m1489copyOZHprlw$default(StandEntry standEntry, String str, long j, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = standEntry.historyDeviceId;
        }
        if ((r5 & 2) != 0) {
            j = standEntry.timestamp;
        }
        if ((r5 & 4) != 0) {
            r4 = standEntry.successfulStands;
        }
        return standEntry.m1492copyOZHprlw(str, j, r4);
    }

    public static final /* synthetic */ void write$Self$watch_release(StandEntry standEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(standEntry.mo1121getHistoryDeviceIdV9ZILtA()));
        compositeEncoder.encodeLongElement(serialDescriptor, 1, standEntry.getTimestamp());
        compositeEncoder.encodeIntElement(2, standEntry.successfulStands, serialDescriptor);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1491component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.successfulStands;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final StandEntry m1492copyOZHprlw(String historyDeviceId, long j, int r11) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return new StandEntry(historyDeviceId, j, r11, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StandEntry)) {
            return false;
        }
        StandEntry standEntry = (StandEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, standEntry.historyDeviceId) && this.timestamp == standEntry.timestamp && this.successfulStands == standEntry.successfulStands) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    /* renamed from: getHistoryDeviceId-V9ZILtA */
    public String mo1121getHistoryDeviceIdV9ZILtA() {
        return this.historyDeviceId;
    }

    public final int getSuccessfulStands() {
        return this.successfulStands;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Integer.hashCode(this.successfulStands) + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31);
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
        StringBuilder sb = new StringBuilder("StandEntry(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", successfulStands=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.successfulStands, ')');
    }

    public /* synthetic */ StandEntry(String str, long j, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4);
    }

    private StandEntry(int r2, String str, long j, int r6, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (r2 & 7)) {
            zzac.throwMissingFieldException(r2, 7, StandEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.historyDeviceId = str;
        this.timestamp = j;
        this.successfulStands = r6;
    }

    private StandEntry(String historyDeviceId, long j, int r5) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.successfulStands = r5;
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1490getHistoryDeviceIdV9ZILtA$annotations() {
    }
}
