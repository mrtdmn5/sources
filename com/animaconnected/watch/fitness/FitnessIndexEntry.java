package com.animaconnected.watch.fitness;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
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
public final class FitnessIndexEntry extends Entry {
    public static final Companion Companion = new Companion(null);
    private String historyDeviceId;
    private long timestamp;
    private final float value;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<FitnessIndexEntry> serializer() {
            return FitnessIndexEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ FitnessIndexEntry(int r1, @JsonNames(names = {"identifier"}) String str, long j, float f, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, j, f, serializationConstructorMarker);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ FitnessIndexEntry m1280copyOZHprlw$default(FitnessIndexEntry fitnessIndexEntry, String str, long j, float f, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = fitnessIndexEntry.historyDeviceId;
        }
        if ((r5 & 2) != 0) {
            j = fitnessIndexEntry.timestamp;
        }
        if ((r5 & 4) != 0) {
            f = fitnessIndexEntry.value;
        }
        return fitnessIndexEntry.m1283copyOZHprlw(str, j, f);
    }

    public static final /* synthetic */ void write$Self$watch_release(FitnessIndexEntry fitnessIndexEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(fitnessIndexEntry.mo1121getHistoryDeviceIdV9ZILtA()));
        compositeEncoder.encodeLongElement(serialDescriptor, 1, fitnessIndexEntry.getTimestamp());
        compositeEncoder.encodeFloatElement(serialDescriptor, 2, fitnessIndexEntry.value);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1282component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final float component3() {
        return this.value;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final FitnessIndexEntry m1283copyOZHprlw(String historyDeviceId, long j, float f) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return new FitnessIndexEntry(historyDeviceId, j, f, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FitnessIndexEntry)) {
            return false;
        }
        FitnessIndexEntry fitnessIndexEntry = (FitnessIndexEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, fitnessIndexEntry.historyDeviceId) && this.timestamp == fitnessIndexEntry.timestamp && Float.compare(this.value, fitnessIndexEntry.value) == 0) {
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

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return Float.hashCode(this.value) + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31);
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
        StringBuilder sb = new StringBuilder("FitnessIndexEntry(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", value=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.value, ')');
    }

    public /* synthetic */ FitnessIndexEntry(String str, long j, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, f);
    }

    private FitnessIndexEntry(int r2, String str, long j, float f, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (r2 & 7)) {
            zzac.throwMissingFieldException(r2, 7, FitnessIndexEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.historyDeviceId = str;
        this.timestamp = j;
        this.value = f;
    }

    private FitnessIndexEntry(String historyDeviceId, long j, float f) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.value = f;
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1281getHistoryDeviceIdV9ZILtA$annotations() {
    }
}
