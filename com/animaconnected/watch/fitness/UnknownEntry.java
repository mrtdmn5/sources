package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonNames;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class UnknownEntry extends Entry {
    private String historyDeviceId;
    private long timestamp;
    private final String valueAsString;

    public /* synthetic */ UnknownEntry(String str, long j, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ UnknownEntry m1506copyOZHprlw$default(UnknownEntry unknownEntry, String str, long j, String str2, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = unknownEntry.historyDeviceId;
        }
        if ((r5 & 2) != 0) {
            j = unknownEntry.timestamp;
        }
        if ((r5 & 4) != 0) {
            str2 = unknownEntry.valueAsString;
        }
        return unknownEntry.m1509copyOZHprlw(str, j, str2);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1508component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.valueAsString;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final UnknownEntry m1509copyOZHprlw(String historyDeviceId, long j, String valueAsString) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(valueAsString, "valueAsString");
        return new UnknownEntry(historyDeviceId, j, valueAsString, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnknownEntry)) {
            return false;
        }
        UnknownEntry unknownEntry = (UnknownEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, unknownEntry.historyDeviceId) && this.timestamp == unknownEntry.timestamp && Intrinsics.areEqual(this.valueAsString, unknownEntry.valueAsString)) {
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

    public final String getValueAsString() {
        return this.valueAsString;
    }

    public int hashCode() {
        return this.valueAsString.hashCode() + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31);
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
        StringBuilder sb = new StringBuilder("UnknownEntry(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", valueAsString=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.valueAsString, ')');
    }

    private UnknownEntry(String historyDeviceId, long j, String valueAsString) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(valueAsString, "valueAsString");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.valueAsString = valueAsString;
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1507getHistoryDeviceIdV9ZILtA$annotations() {
    }
}
