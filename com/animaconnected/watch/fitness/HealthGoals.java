package com.animaconnected.watch.fitness;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: FitnessData.kt */
@Serializable
/* loaded from: classes3.dex */
public final class HealthGoals {
    public static final Companion Companion = new Companion(null);
    private final int exercise;
    private final int stand;
    private final int steps;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<HealthGoals> serializer() {
            return HealthGoals$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public HealthGoals(int r1, int r2, int r3) {
        this.steps = r1;
        this.stand = r2;
        this.exercise = r3;
    }

    public static /* synthetic */ HealthGoals copy$default(HealthGoals healthGoals, int r1, int r2, int r3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            r1 = healthGoals.steps;
        }
        if ((r4 & 2) != 0) {
            r2 = healthGoals.stand;
        }
        if ((r4 & 4) != 0) {
            r3 = healthGoals.exercise;
        }
        return healthGoals.copy(r1, r2, r3);
    }

    public static final /* synthetic */ void write$Self$watch_release(HealthGoals healthGoals, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeIntElement(0, healthGoals.steps, serialDescriptor);
        compositeEncoder.encodeIntElement(1, healthGoals.stand, serialDescriptor);
        compositeEncoder.encodeIntElement(2, healthGoals.exercise, serialDescriptor);
    }

    public final int component1() {
        return this.steps;
    }

    public final int component2() {
        return this.stand;
    }

    public final int component3() {
        return this.exercise;
    }

    public final HealthGoals copy(int r2, int r3, int r4) {
        return new HealthGoals(r2, r3, r4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HealthGoals)) {
            return false;
        }
        HealthGoals healthGoals = (HealthGoals) obj;
        if (this.steps == healthGoals.steps && this.stand == healthGoals.stand && this.exercise == healthGoals.exercise) {
            return true;
        }
        return false;
    }

    public final int getExercise() {
        return this.exercise;
    }

    public final int getStand() {
        return this.stand;
    }

    public final int getSteps() {
        return this.steps;
    }

    public int hashCode() {
        return Integer.hashCode(this.exercise) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.stand, Integer.hashCode(this.steps) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HealthGoals(steps=");
        sb.append(this.steps);
        sb.append(", stand=");
        sb.append(this.stand);
        sb.append(", exercise=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.exercise, ')');
    }

    public /* synthetic */ HealthGoals(int r2, int r3, int r4, int r5, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (r2 & 7)) {
            zzac.throwMissingFieldException(r2, 7, HealthGoals$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.steps = r3;
        this.stand = r4;
        this.exercise = r5;
    }
}
