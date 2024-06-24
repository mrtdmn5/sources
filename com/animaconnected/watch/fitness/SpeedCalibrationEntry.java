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
public final class SpeedCalibrationEntry extends Entry {
    public static final Companion Companion = new Companion(null);
    private final int coefficient;
    private String historyDeviceId;
    private long timestamp;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SpeedCalibrationEntry> serializer() {
            return SpeedCalibrationEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SpeedCalibrationEntry(int r1, @JsonNames(names = {"identifier"}) String str, long j, int r5, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, j, r5, serializationConstructorMarker);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ SpeedCalibrationEntry m1485copyOZHprlw$default(SpeedCalibrationEntry speedCalibrationEntry, String str, long j, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = speedCalibrationEntry.historyDeviceId;
        }
        if ((r5 & 2) != 0) {
            j = speedCalibrationEntry.timestamp;
        }
        if ((r5 & 4) != 0) {
            r4 = speedCalibrationEntry.coefficient;
        }
        return speedCalibrationEntry.m1488copyOZHprlw(str, j, r4);
    }

    public static final /* synthetic */ void write$Self$watch_release(SpeedCalibrationEntry speedCalibrationEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(speedCalibrationEntry.mo1121getHistoryDeviceIdV9ZILtA()));
        compositeEncoder.encodeLongElement(serialDescriptor, 1, speedCalibrationEntry.getTimestamp());
        compositeEncoder.encodeIntElement(2, speedCalibrationEntry.coefficient, serialDescriptor);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1487component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.coefficient;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final SpeedCalibrationEntry m1488copyOZHprlw(String historyDeviceId, long j, int r11) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return new SpeedCalibrationEntry(historyDeviceId, j, r11, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpeedCalibrationEntry)) {
            return false;
        }
        SpeedCalibrationEntry speedCalibrationEntry = (SpeedCalibrationEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, speedCalibrationEntry.historyDeviceId) && this.timestamp == speedCalibrationEntry.timestamp && this.coefficient == speedCalibrationEntry.coefficient) {
            return true;
        }
        return false;
    }

    public final int getCoefficient() {
        return this.coefficient;
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
        return Integer.hashCode(this.coefficient) + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31);
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
        StringBuilder sb = new StringBuilder("SpeedCalibrationEntry(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", coefficient=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.coefficient, ')');
    }

    public /* synthetic */ SpeedCalibrationEntry(String str, long j, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4);
    }

    private SpeedCalibrationEntry(int r2, String str, long j, int r6, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (r2 & 7)) {
            zzac.throwMissingFieldException(r2, 7, SpeedCalibrationEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.historyDeviceId = str;
        this.timestamp = j;
        this.coefficient = r6;
    }

    private SpeedCalibrationEntry(String historyDeviceId, long j, int r5) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.coefficient = r5;
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1486getHistoryDeviceIdV9ZILtA$annotations() {
    }
}
