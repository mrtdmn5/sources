package com.animaconnected.watch.graphs;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ChartEntities.kt */
@Serializable
/* loaded from: classes3.dex */
public final class StackedBarEntry implements ChartEntry {
    private final List<BarEntry> data;
    private final boolean isSelected;
    private final String markerLabel;
    private final String xAxisLabel;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(BarEntry$$serializer.INSTANCE), null, null, null};

    /* compiled from: ChartEntities.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<StackedBarEntry> serializer() {
            return StackedBarEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ StackedBarEntry(int r2, List list, String str, String str2, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (r2 & 3)) {
            zzac.throwMissingFieldException(r2, 3, StackedBarEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.data = list;
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StackedBarEntry copy$default(StackedBarEntry stackedBarEntry, List list, String str, String str2, boolean z, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            list = stackedBarEntry.data;
        }
        if ((r5 & 2) != 0) {
            str = stackedBarEntry.xAxisLabel;
        }
        if ((r5 & 4) != 0) {
            str2 = stackedBarEntry.markerLabel;
        }
        if ((r5 & 8) != 0) {
            z = stackedBarEntry.isSelected;
        }
        return stackedBarEntry.copy(list, str, str2, z);
    }

    public static final /* synthetic */ void write$Self$graphics_release(StackedBarEntry stackedBarEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2 = false;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, $childSerializers[0], stackedBarEntry.data);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, stackedBarEntry.getXAxisLabel());
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(stackedBarEntry.getMarkerLabel(), "")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeStringElement(serialDescriptor, 2, stackedBarEntry.getMarkerLabel());
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || stackedBarEntry.isSelected()) {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 3, stackedBarEntry.isSelected());
        }
    }

    public final List<BarEntry> component1() {
        return this.data;
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

    public final StackedBarEntry copy(List<BarEntry> data, String xAxisLabel, String markerLabel, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(xAxisLabel, "xAxisLabel");
        Intrinsics.checkNotNullParameter(markerLabel, "markerLabel");
        return new StackedBarEntry(data, xAxisLabel, markerLabel, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StackedBarEntry)) {
            return false;
        }
        StackedBarEntry stackedBarEntry = (StackedBarEntry) obj;
        if (Intrinsics.areEqual(this.data, stackedBarEntry.data) && Intrinsics.areEqual(this.xAxisLabel, stackedBarEntry.xAxisLabel) && Intrinsics.areEqual(this.markerLabel, stackedBarEntry.markerLabel) && this.isSelected == stackedBarEntry.isSelected) {
            return true;
        }
        return false;
    }

    public final List<BarEntry> getData() {
        return this.data;
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
        return Boolean.hashCode(this.isSelected) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.markerLabel, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.xAxisLabel, this.data.hashCode() * 31, 31), 31);
    }

    @Override // com.animaconnected.watch.graphs.ChartEntry
    public boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StackedBarEntry(data=");
        sb.append(this.data);
        sb.append(", xAxisLabel=");
        sb.append(this.xAxisLabel);
        sb.append(", markerLabel=");
        sb.append(this.markerLabel);
        sb.append(", isSelected=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isSelected, ')');
    }

    public StackedBarEntry(List<BarEntry> data, String xAxisLabel, String markerLabel, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(xAxisLabel, "xAxisLabel");
        Intrinsics.checkNotNullParameter(markerLabel, "markerLabel");
        this.data = data;
        this.xAxisLabel = xAxisLabel;
        this.markerLabel = markerLabel;
        this.isSelected = z;
    }

    public /* synthetic */ StackedBarEntry(List list, String str, String str2, boolean z, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (r5 & 4) != 0 ? "" : str2, (r5 & 8) != 0 ? false : z);
    }
}
