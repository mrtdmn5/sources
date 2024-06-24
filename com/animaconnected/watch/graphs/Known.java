package com.animaconnected.watch.graphs;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ChartEntities.kt */
@Serializable
/* loaded from: classes3.dex */
public final class Known extends LineChartValue {
    public static final Companion Companion = new Companion(null);
    private final boolean dashedLine;
    private final int value;

    /* compiled from: ChartEntities.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Known> serializer() {
            return Known$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Known(int r3, int r4, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        super(r3, serializationConstructorMarker);
        if (1 != (r3 & 1)) {
            zzac.throwMissingFieldException(r3, 1, Known$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.value = r4;
        if ((r3 & 2) == 0) {
            this.dashedLine = false;
        } else {
            this.dashedLine = z;
        }
    }

    public static /* synthetic */ Known copy$default(Known known, int r1, boolean z, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = known.value;
        }
        if ((r3 & 2) != 0) {
            z = known.dashedLine;
        }
        return known.copy(r1, z);
    }

    public static final /* synthetic */ void write$Self$graphics_release(Known known, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        LineChartValue.write$Self(known, compositeEncoder, serialDescriptor);
        boolean z = false;
        compositeEncoder.encodeIntElement(0, known.value, serialDescriptor);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || known.dashedLine) {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 1, known.dashedLine);
        }
    }

    public final int component1() {
        return this.value;
    }

    public final boolean component2() {
        return this.dashedLine;
    }

    public final Known copy(int r2, boolean z) {
        return new Known(r2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Known)) {
            return false;
        }
        Known known = (Known) obj;
        if (this.value == known.value && this.dashedLine == known.dashedLine) {
            return true;
        }
        return false;
    }

    public final boolean getDashedLine() {
        return this.dashedLine;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return Boolean.hashCode(this.dashedLine) + (Integer.hashCode(this.value) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Known(value=");
        sb.append(this.value);
        sb.append(", dashedLine=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.dashedLine, ')');
    }

    public Known(int r2, boolean z) {
        super(null);
        this.value = r2;
        this.dashedLine = z;
    }

    public /* synthetic */ Known(int r1, boolean z, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, (r3 & 2) != 0 ? false : z);
    }
}
