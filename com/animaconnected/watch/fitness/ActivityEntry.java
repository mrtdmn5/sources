package com.animaconnected.watch.fitness;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.model.HistoryDeviceId$$serializer;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonNames;

/* compiled from: FitnessData.kt */
@Serializable
/* loaded from: classes3.dex */
public final class ActivityEntry extends Entry {
    public static final Companion Companion = new Companion(null);
    private final Integer activityClass;
    private final Integer calories;
    private final Integer distance;
    private String historyDeviceId;
    private final Integer otherSteps;
    private final Integer rhythmicStepsCadence;
    private final Integer runSteps;
    private final Float speed;
    private long timestamp;
    private final Integer walkSteps;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ActivityEntry> serializer() {
            return ActivityEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ActivityEntry(int r1, @JsonNames(names = {"identifier"}) String str, long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, j, num, num2, num3, num4, num5, f, num6, num7, serializationConstructorMarker);
    }

    public static final /* synthetic */ void write$Self$watch_release(ActivityEntry activityEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(activityEntry.mo1121getHistoryDeviceIdV9ZILtA()));
        compositeEncoder.encodeLongElement(serialDescriptor, 1, activityEntry.getTimestamp());
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, intSerializer, activityEntry.activityClass);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, intSerializer, activityEntry.walkSteps);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, intSerializer, activityEntry.runSteps);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, intSerializer, activityEntry.otherSteps);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, intSerializer, activityEntry.rhythmicStepsCadence);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, FloatSerializer.INSTANCE, activityEntry.speed);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, intSerializer, activityEntry.distance);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, intSerializer, activityEntry.calories);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1119component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final Integer component10() {
        return this.calories;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final Integer component3() {
        return this.activityClass;
    }

    public final Integer component4() {
        return this.walkSteps;
    }

    public final Integer component5() {
        return this.runSteps;
    }

    public final Integer component6() {
        return this.otherSteps;
    }

    public final Integer component7() {
        return this.rhythmicStepsCadence;
    }

    public final Float component8() {
        return this.speed;
    }

    public final Integer component9() {
        return this.distance;
    }

    /* renamed from: copy-hSv7xU0, reason: not valid java name */
    public final ActivityEntry m1120copyhSv7xU0(String historyDeviceId, long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return new ActivityEntry(historyDeviceId, j, num, num2, num3, num4, num5, f, num6, num7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityEntry)) {
            return false;
        }
        ActivityEntry activityEntry = (ActivityEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, activityEntry.historyDeviceId) && this.timestamp == activityEntry.timestamp && Intrinsics.areEqual(this.activityClass, activityEntry.activityClass) && Intrinsics.areEqual(this.walkSteps, activityEntry.walkSteps) && Intrinsics.areEqual(this.runSteps, activityEntry.runSteps) && Intrinsics.areEqual(this.otherSteps, activityEntry.otherSteps) && Intrinsics.areEqual(this.rhythmicStepsCadence, activityEntry.rhythmicStepsCadence) && Intrinsics.areEqual(this.speed, activityEntry.speed) && Intrinsics.areEqual(this.distance, activityEntry.distance) && Intrinsics.areEqual(this.calories, activityEntry.calories)) {
            return true;
        }
        return false;
    }

    public final Integer getActivityClass() {
        return this.activityClass;
    }

    public final Integer getCalories() {
        return this.calories;
    }

    public final Integer getDistance() {
        return this.distance;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    /* renamed from: getHistoryDeviceId-V9ZILtA, reason: not valid java name */
    public String mo1121getHistoryDeviceIdV9ZILtA() {
        return this.historyDeviceId;
    }

    public final Integer getOtherSteps() {
        return this.otherSteps;
    }

    public final Integer getRhythmicStepsCadence() {
        return this.rhythmicStepsCadence;
    }

    public final Integer getRunSteps() {
        return this.runSteps;
    }

    public final Float getSpeed() {
        return this.speed;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    public long getTimestamp() {
        return this.timestamp;
    }

    public final Integer getWalkSteps() {
        return this.walkSteps;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int m = Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31);
        Integer num = this.activityClass;
        int r2 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        Integer num2 = this.walkSteps;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        Integer num3 = this.runSteps;
        if (num3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num3.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        Integer num4 = this.otherSteps;
        if (num4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = num4.hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        Integer num5 = this.rhythmicStepsCadence;
        if (num5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = num5.hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        Float f = this.speed;
        if (f == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = f.hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        Integer num6 = this.distance;
        if (num6 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = num6.hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        Integer num7 = this.calories;
        if (num7 != null) {
            r2 = num7.hashCode();
        }
        return r07 + r2;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    /* renamed from: setHistoryDeviceId-Y1s2hH8, reason: not valid java name */
    public void mo1122setHistoryDeviceIdY1s2hH8(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.historyDeviceId = str;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ActivityEntry(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", activityClass=");
        sb.append(this.activityClass);
        sb.append(", walkSteps=");
        sb.append(this.walkSteps);
        sb.append(", runSteps=");
        sb.append(this.runSteps);
        sb.append(", otherSteps=");
        sb.append(this.otherSteps);
        sb.append(", rhythmicStepsCadence=");
        sb.append(this.rhythmicStepsCadence);
        sb.append(", speed=");
        sb.append(this.speed);
        sb.append(", distance=");
        sb.append(this.distance);
        sb.append(", calories=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.calories, ')');
    }

    public /* synthetic */ ActivityEntry(String str, long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, num, num2, num3, num4, num5, f, num6, num7);
    }

    private ActivityEntry(int r2, String str, long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7, SerializationConstructorMarker serializationConstructorMarker) {
        if (1023 != (r2 & 1023)) {
            zzac.throwMissingFieldException(r2, 1023, ActivityEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.historyDeviceId = str;
        this.timestamp = j;
        this.activityClass = num;
        this.walkSteps = num2;
        this.runSteps = num3;
        this.otherSteps = num4;
        this.rhythmicStepsCadence = num5;
        this.speed = f;
        this.distance = num6;
        this.calories = num7;
    }

    private ActivityEntry(String historyDeviceId, long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.activityClass = num;
        this.walkSteps = num2;
        this.runSteps = num3;
        this.otherSteps = num4;
        this.rhythmicStepsCadence = num5;
        this.speed = f;
        this.distance = num6;
        this.calories = num7;
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1118getHistoryDeviceIdV9ZILtA$annotations() {
    }
}
