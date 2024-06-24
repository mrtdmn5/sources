package com.animaconnected.watch.graphs;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ChartEntities.kt */
@Serializable
/* loaded from: classes3.dex */
public final class PointEntry implements ChartEntry {
    private final boolean isSelected;
    private final LineChartValue lineChartValue;
    private final String markerLabel;
    private final String xAxisLabel;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {LineChartValue.Companion.serializer(), null, null, null};

    /* compiled from: ChartEntities.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PointEntry> serializer() {
            return PointEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PointEntry(int r2, LineChartValue lineChartValue, String str, String str2, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (r2 & 3)) {
            zzac.throwMissingFieldException(r2, 3, PointEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.lineChartValue = lineChartValue;
        this.xAxisLabel = str;
        if ((r2 & 4) == 0) {
            this.markerLabel = "";
        } else {
            this.markerLabel = str2;
        }
        if ((r2 & 8) == 0) {
            this.isSelected = false;
        } else {
            this.isSelected = z;
        }
    }

    public static /* synthetic */ PointEntry copy$default(PointEntry pointEntry, LineChartValue lineChartValue, String str, String str2, boolean z, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            lineChartValue = pointEntry.lineChartValue;
        }
        if ((r5 & 2) != 0) {
            str = pointEntry.xAxisLabel;
        }
        if ((r5 & 4) != 0) {
            str2 = pointEntry.markerLabel;
        }
        if ((r5 & 8) != 0) {
            z = pointEntry.isSelected;
        }
        return pointEntry.copy(lineChartValue, str, str2, z);
    }

    public static final /* synthetic */ void write$Self$graphics_release(PointEntry pointEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2 = false;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, $childSerializers[0], pointEntry.lineChartValue);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, pointEntry.getXAxisLabel());
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(pointEntry.getMarkerLabel(), "")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeStringElement(serialDescriptor, 2, pointEntry.getMarkerLabel());
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || pointEntry.isSelected()) {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 3, pointEntry.isSelected());
        }
    }

    public final LineChartValue component1() {
        return this.lineChartValue;
    }

    public final String component2() {
        return this.xAxisLabel;
    }

    public final String component3() {
        return this.markerLabel;
    }

    public final boolean component4() {
        return this.isSelected;
    }

    public final PointEntry copy(LineChartValue lineChartValue, String xAxisLabel, String markerLabel, boolean z) {
        Intrinsics.checkNotNullParameter(lineChartValue, "lineChartValue");
        Intrinsics.checkNotNullParameter(xAxisLabel, "xAxisLabel");
        Intrinsics.checkNotNullParameter(markerLabel, "markerLabel");
        return new PointEntry(lineChartValue, xAxisLabel, markerLabel, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointEntry)) {
            return false;
        }
        PointEntry pointEntry = (PointEntry) obj;
        if (Intrinsics.areEqual(this.lineChartValue, pointEntry.lineChartValue) && Intrinsics.areEqual(this.xAxisLabel, pointEntry.xAxisLabel) && Intrinsics.areEqual(this.markerLabel, pointEntry.markerLabel) && this.isSelected == pointEntry.isSelected) {
            return true;
        }
        return false;
    }

    public final LineChartValue getLineChartValue() {
        return this.lineChartValue;
    }

    @Override // com.animaconnected.watch.graphs.ChartEntry
    public String getMarkerLabel() {
        return this.markerLabel;
    }

    @Override // com.animaconnected.watch.graphs.ChartEntry
    public String getXAxisLabel() {
        return this.xAxisLabel;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isSelected) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.markerLabel, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.xAxisLabel, this.lineChartValue.hashCode() * 31, 31), 31);
    }

    @Override // com.animaconnected.watch.graphs.ChartEntry
    public boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PointEntry(lineChartValue=");
        sb.append(this.lineChartValue);
        sb.append(", xAxisLabel=");
        sb.append(this.xAxisLabel);
        sb.append(", markerLabel=");
        sb.append(this.markerLabel);
        sb.append(", isSelected=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isSelected, ')');
    }

    public PointEntry(LineChartValue lineChartValue, String xAxisLabel, String markerLabel, boolean z) {
        Intrinsics.checkNotNullParameter(lineChartValue, "lineChartValue");
        Intrinsics.checkNotNullParameter(xAxisLabel, "xAxisLabel");
        Intrinsics.checkNotNullParameter(markerLabel, "markerLabel");
        this.lineChartValue = lineChartValue;
        this.xAxisLabel = xAxisLabel;
        this.markerLabel = markerLabel;
        this.isSelected = z;
    }

    public /* synthetic */ PointEntry(LineChartValue lineChartValue, String str, String str2, boolean z, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(lineChartValue, str, (r5 & 4) != 0 ? "" : str2, (r5 & 8) != 0 ? false : z);
    }
}
