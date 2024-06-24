package com.animaconnected.watch.graphs;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
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
public final class AvgMaxMinEntry implements ChartEntry {
    public static final Companion Companion = new Companion(null);
    private final int avgValue;
    private final boolean isSelected;
    private final String markerLabel;
    private final int maxValue;
    private final int minValue;
    private final String xAxisLabel;

    /* compiled from: ChartEntities.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AvgMaxMinEntry> serializer() {
            return AvgMaxMinEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AvgMaxMinEntry(int r2, int r3, int r4, int r5, String str, String str2, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (r2 & 15)) {
            zzac.throwMissingFieldException(r2, 15, AvgMaxMinEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.avgValue = r3;
        this.maxValue = r4;
        this.minValue = r5;
        this.xAxisLabel = str;
        if ((r2 & 16) == 0) {
            this.markerLabel = "";
        } else {
            this.markerLabel = str2;
        }
        if ((r2 & 32) == 0) {
            this.isSelected = false;
        } else {
            this.isSelected = z;
        }
    }

    public static /* synthetic */ AvgMaxMinEntry copy$default(AvgMaxMinEntry avgMaxMinEntry, int r5, int r6, int r7, String str, String str2, boolean z, int r11, Object obj) {
        if ((r11 & 1) != 0) {
            r5 = avgMaxMinEntry.avgValue;
        }
        if ((r11 & 2) != 0) {
            r6 = avgMaxMinEntry.maxValue;
        }
        int r12 = r6;
        if ((r11 & 4) != 0) {
            r7 = avgMaxMinEntry.minValue;
        }
        int r0 = r7;
        if ((r11 & 8) != 0) {
            str = avgMaxMinEntry.xAxisLabel;
        }
        String str3 = str;
        if ((r11 & 16) != 0) {
            str2 = avgMaxMinEntry.markerLabel;
        }
        String str4 = str2;
        if ((r11 & 32) != 0) {
            z = avgMaxMinEntry.isSelected;
        }
        return avgMaxMinEntry.copy(r5, r12, r0, str3, str4, z);
    }

    public static final /* synthetic */ void write$Self$graphics_release(AvgMaxMinEntry avgMaxMinEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2 = false;
        compositeEncoder.encodeIntElement(0, avgMaxMinEntry.avgValue, serialDescriptor);
        compositeEncoder.encodeIntElement(1, avgMaxMinEntry.maxValue, serialDescriptor);
        compositeEncoder.encodeIntElement(2, avgMaxMinEntry.minValue, serialDescriptor);
        compositeEncoder.encodeStringElement(serialDescriptor, 3, avgMaxMinEntry.getXAxisLabel());
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(avgMaxMinEntry.getMarkerLabel(), "")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeStringElement(serialDescriptor, 4, avgMaxMinEntry.getMarkerLabel());
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || avgMaxMinEntry.isSelected()) {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 5, avgMaxMinEntry.isSelected());
        }
    }

    public final int component1() {
        return this.avgValue;
    }

    public final int component2() {
        return this.maxValue;
    }

    public final int component3() {
        return this.minValue;
    }

    public final String component4() {
        return this.xAxisLabel;
    }

    public final String component5() {
        return this.markerLabel;
    }

    public final boolean component6() {
        return this.isSelected;
    }

    public final AvgMaxMinEntry copy(int r9, int r10, int r11, String xAxisLabel, String markerLabel, boolean z) {
        Intrinsics.checkNotNullParameter(xAxisLabel, "xAxisLabel");
        Intrinsics.checkNotNullParameter(markerLabel, "markerLabel");
        return new AvgMaxMinEntry(r9, r10, r11, xAxisLabel, markerLabel, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AvgMaxMinEntry)) {
            return false;
        }
        AvgMaxMinEntry avgMaxMinEntry = (AvgMaxMinEntry) obj;
        if (this.avgValue == avgMaxMinEntry.avgValue && this.maxValue == avgMaxMinEntry.maxValue && this.minValue == avgMaxMinEntry.minValue && Intrinsics.areEqual(this.xAxisLabel, avgMaxMinEntry.xAxisLabel) && Intrinsics.areEqual(this.markerLabel, avgMaxMinEntry.markerLabel) && this.isSelected == avgMaxMinEntry.isSelected) {
            return true;
        }
        return false;
    }

    public final int getAvgValue() {
        return this.avgValue;
    }

    @Override // com.animaconnected.watch.graphs.ChartEntry
    public String getMarkerLabel() {
        return this.markerLabel;
    }

    public final int getMaxValue() {
        return this.maxValue;
    }

    public final int getMinValue() {
        return this.minValue;
    }

    @Override // com.animaconnected.watch.graphs.ChartEntry
    public String getXAxisLabel() {
        return this.xAxisLabel;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isSelected) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.markerLabel, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.xAxisLabel, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.minValue, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.maxValue, Integer.hashCode(this.avgValue) * 31, 31), 31), 31), 31);
    }

    @Override // com.animaconnected.watch.graphs.ChartEntry
    public boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AvgMaxMinEntry(avgValue=");
        sb.append(this.avgValue);
        sb.append(", maxValue=");
        sb.append(this.maxValue);
        sb.append(", minValue=");
        sb.append(this.minValue);
        sb.append(", xAxisLabel=");
        sb.append(this.xAxisLabel);
        sb.append(", markerLabel=");
        sb.append(this.markerLabel);
        sb.append(", isSelected=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isSelected, ')');
    }

    public AvgMaxMinEntry(int r2, int r3, int r4, String xAxisLabel, String markerLabel, boolean z) {
        Intrinsics.checkNotNullParameter(xAxisLabel, "xAxisLabel");
        Intrinsics.checkNotNullParameter(markerLabel, "markerLabel");
        this.avgValue = r2;
        this.maxValue = r3;
        this.minValue = r4;
        this.xAxisLabel = xAxisLabel;
        this.markerLabel = markerLabel;
        this.isSelected = z;
    }

    public /* synthetic */ AvgMaxMinEntry(int r8, int r9, int r10, String str, String str2, boolean z, int r14, DefaultConstructorMarker defaultConstructorMarker) {
        this(r8, r9, r10, str, (r14 & 16) != 0 ? "" : str2, (r14 & 32) != 0 ? false : z);
    }
}
