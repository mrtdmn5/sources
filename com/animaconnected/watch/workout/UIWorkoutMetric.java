package com.animaconnected.watch.workout;

import com.animaconnected.watch.provider.preferences.WorkoutMetrics;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ConfigureMetricViewModel.kt */
@Serializable
/* loaded from: classes3.dex */
public final class UIWorkoutMetric {
    private final WorkoutMetrics metric;
    private final String name;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, EnumsKt.createSimpleEnumSerializer("com.animaconnected.watch.provider.preferences.WorkoutMetrics", WorkoutMetrics.values())};

    /* compiled from: ConfigureMetricViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UIWorkoutMetric> serializer() {
            return UIWorkoutMetric$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ UIWorkoutMetric(int r2, String str, WorkoutMetrics workoutMetrics, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (r2 & 3)) {
            zzac.throwMissingFieldException(r2, 3, UIWorkoutMetric$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.name = str;
        this.metric = workoutMetrics;
    }

    public static /* synthetic */ UIWorkoutMetric copy$default(UIWorkoutMetric uIWorkoutMetric, String str, WorkoutMetrics workoutMetrics, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            str = uIWorkoutMetric.name;
        }
        if ((r3 & 2) != 0) {
            workoutMetrics = uIWorkoutMetric.metric;
        }
        return uIWorkoutMetric.copy(str, workoutMetrics);
    }

    public static final /* synthetic */ void write$Self$watch_release(UIWorkoutMetric uIWorkoutMetric, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.encodeStringElement(serialDescriptor, 0, uIWorkoutMetric.name);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, kSerializerArr[1], uIWorkoutMetric.metric);
    }

    public final String component1() {
        return this.name;
    }

    public final WorkoutMetrics component2() {
        return this.metric;
    }

    public final UIWorkoutMetric copy(String name, WorkoutMetrics workoutMetrics) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new UIWorkoutMetric(name, workoutMetrics);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UIWorkoutMetric)) {
            return false;
        }
        UIWorkoutMetric uIWorkoutMetric = (UIWorkoutMetric) obj;
        if (Intrinsics.areEqual(this.name, uIWorkoutMetric.name) && this.metric == uIWorkoutMetric.metric) {
            return true;
        }
        return false;
    }

    public final WorkoutMetrics getMetric() {
        return this.metric;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.name.hashCode() * 31;
        WorkoutMetrics workoutMetrics = this.metric;
        if (workoutMetrics == null) {
            hashCode = 0;
        } else {
            hashCode = workoutMetrics.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        return "UIWorkoutMetric(name=" + this.name + ", metric=" + this.metric + ')';
    }

    public UIWorkoutMetric(String name, WorkoutMetrics workoutMetrics) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.metric = workoutMetrics;
    }
}
