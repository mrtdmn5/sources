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
public final class ExerciseEntry extends Entry {
    public static final Companion Companion = new Companion(null);
    private final int activeMinutes;
    private String historyDeviceId;
    private long timestamp;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ExerciseEntry> serializer() {
            return ExerciseEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ExerciseEntry(int r1, @JsonNames(names = {"identifier"}) String str, long j, int r5, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, j, r5, serializationConstructorMarker);
    }

    /* renamed from: copy-OZHprlw$default, reason: not valid java name */
    public static /* synthetic */ ExerciseEntry m1219copyOZHprlw$default(ExerciseEntry exerciseEntry, String str, long j, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = exerciseEntry.historyDeviceId;
        }
        if ((r5 & 2) != 0) {
            j = exerciseEntry.timestamp;
        }
        if ((r5 & 4) != 0) {
            r4 = exerciseEntry.activeMinutes;
        }
        return exerciseEntry.m1222copyOZHprlw(str, j, r4);
    }

    public static final /* synthetic */ void write$Self$watch_release(ExerciseEntry exerciseEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(exerciseEntry.mo1121getHistoryDeviceIdV9ZILtA()));
        compositeEncoder.encodeLongElement(serialDescriptor, 1, exerciseEntry.getTimestamp());
        compositeEncoder.encodeIntElement(2, exerciseEntry.activeMinutes, serialDescriptor);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1221component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.activeMinutes;
    }

    /* renamed from: copy-OZHprlw, reason: not valid java name */
    public final ExerciseEntry m1222copyOZHprlw(String historyDeviceId, long j, int r11) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return new ExerciseEntry(historyDeviceId, j, r11, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExerciseEntry)) {
            return false;
        }
        ExerciseEntry exerciseEntry = (ExerciseEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, exerciseEntry.historyDeviceId) && this.timestamp == exerciseEntry.timestamp && this.activeMinutes == exerciseEntry.activeMinutes) {
            return true;
        }
        return false;
    }

    public final int getActiveMinutes() {
        return this.activeMinutes;
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
        return Integer.hashCode(this.activeMinutes) + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31);
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
        StringBuilder sb = new StringBuilder("ExerciseEntry(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", activeMinutes=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.activeMinutes, ')');
    }

    public /* synthetic */ ExerciseEntry(String str, long j, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, r4);
    }

    private ExerciseEntry(int r2, String str, long j, int r6, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (r2 & 7)) {
            zzac.throwMissingFieldException(r2, 7, ExerciseEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.historyDeviceId = str;
        this.timestamp = j;
        this.activeMinutes = r6;
    }

    private ExerciseEntry(String historyDeviceId, long j, int r5) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.activeMinutes = r5;
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1220getHistoryDeviceIdV9ZILtA$annotations() {
    }
}
