package com.animaconnected.watch.graphs;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
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
public final class BarEntry implements ChartEntry {
    public static final Companion Companion = new Companion(null);
    private final String barValueLabel;
    private final boolean isSelected;
    private final String markerLabel;
    private final int value;
    private final String xAxisLabel;
    private long xAxisValue;

    /* compiled from: ChartEntities.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<BarEntry> serializer() {
            return BarEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public BarEntry(int r7, String str, long j, String str2, String str3, boolean z) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, "xAxisLabel", str2, "barValueLabel", str3, "markerLabel");
        this.value = r7;
        this.xAxisLabel = str;
        this.xAxisValue = j;
        this.barValueLabel = str2;
        this.markerLabel = str3;
        this.isSelected = z;
    }

    public static /* synthetic */ BarEntry copy$default(BarEntry barEntry, int r6, String str, long j, String str2, String str3, boolean z, int r13, Object obj) {
        if ((r13 & 1) != 0) {
            r6 = barEntry.value;
        }
        if ((r13 & 2) != 0) {
            str = barEntry.xAxisLabel;
        }
        String str4 = str;
        if ((r13 & 4) != 0) {
            j = barEntry.xAxisValue;
        }
        long j2 = j;
        if ((r13 & 8) != 0) {
            str2 = barEntry.barValueLabel;
        }
        String str5 = str2;
        if ((r13 & 16) != 0) {
            str3 = barEntry.markerLabel;
        }
        String str6 = str3;
        if ((r13 & 32) != 0) {
            z = barEntry.isSelected;
        }
        return barEntry.copy(r6, str4, j2, str5, str6, z);
    }

    public static final /* synthetic */ void write$Self$graphics_release(BarEntry barEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        compositeEncoder.encodeIntElement(0, barEntry.value, serialDescriptor);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(barEntry.getXAxisLabel(), "")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeStringElement(serialDescriptor, 1, barEntry.getXAxisLabel());
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || barEntry.xAxisValue != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            compositeEncoder.encodeLongElement(serialDescriptor, 2, barEntry.xAxisValue);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(barEntry.barValueLabel, "")) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            compositeEncoder.encodeStringElement(serialDescriptor, 3, barEntry.barValueLabel);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(barEntry.getMarkerLabel(), "")) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            compositeEncoder.encodeStringElement(serialDescriptor, 4, barEntry.getMarkerLabel());
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || barEntry.isSelected()) {
            z5 = true;
        }
        if (z5) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 5, barEntry.isSelected());
        }
    }

    public final int component1() {
        return this.value;
    }

    public final String component2() {
        return this.xAxisLabel;
    }

    public final long component3() {
        return this.xAxisValue;
    }

    public final String component4() {
        return this.barValueLabel;
    }

    public final String component5() {
        return this.markerLabel;
    }

    public final boolean component6() {
        return this.isSelected;
    }

    public final BarEntry copy(int r10, String xAxisLabel, long j, String barValueLabel, String markerLabel, boolean z) {
        Intrinsics.checkNotNullParameter(xAxisLabel, "xAxisLabel");
        Intrinsics.checkNotNullParameter(barValueLabel, "barValueLabel");
        Intrinsics.checkNotNullParameter(markerLabel, "markerLabel");
        return new BarEntry(r10, xAxisLabel, j, barValueLabel, markerLabel, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BarEntry)) {
            return false;
        }
        BarEntry barEntry = (BarEntry) obj;
        if (this.value == barEntry.value && Intrinsics.areEqual(this.xAxisLabel, barEntry.xAxisLabel) && this.xAxisValue == barEntry.xAxisValue && Intrinsics.areEqual(this.barValueLabel, barEntry.barValueLabel) && Intrinsics.areEqual(this.markerLabel, barEntry.markerLabel) && this.isSelected == barEntry.isSelected) {
            return true;
        }
        return false;
    }

    public final String getBarValueLabel() {
        return this.barValueLabel;
    }

    @Override // com.animaconnected.watch.graphs.ChartEntry
    public String getMarkerLabel() {
        return this.markerLabel;
    }

    public final int getValue() {
        return this.value;
    }

    @Override // com.animaconnected.watch.graphs.ChartEntry
    public String getXAxisLabel() {
        return this.xAxisLabel;
    }

    public final long getXAxisValue() {
        return this.xAxisValue;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isSelected) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.markerLabel, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.barValueLabel, Scale$$ExternalSyntheticOutline0.m(this.xAxisValue, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.xAxisLabel, Integer.hashCode(this.value) * 31, 31), 31), 31), 31);
    }

    @Override // com.animaconnected.watch.graphs.ChartEntry
    public boolean isSelected() {
        return this.isSelected;
    }

    public final void setXAxisValue(long j) {
        this.xAxisValue = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BarEntry(value=");
        sb.append(this.value);
        sb.append(", xAxisLabel=");
        sb.append(this.xAxisLabel);
        sb.append(", xAxisValue=");
        sb.append(this.xAxisValue);
        sb.append(", barValueLabel=");
        sb.append(this.barValueLabel);
        sb.append(", markerLabel=");
        sb.append(this.markerLabel);
        sb.append(", isSelected=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isSelected, ')');
    }

    public /* synthetic */ BarEntry(int r2, int r3, String str, long j, String str2, String str3, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (r2 & 1)) {
            zzac.throwMissingFieldException(r2, 1, BarEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.value = r3;
        if ((r2 & 2) == 0) {
            this.xAxisLabel = "";
        } else {
            this.xAxisLabel = str;
        }
        if ((r2 & 4) == 0) {
            this.xAxisValue = 0L;
        } else {
            this.xAxisValue = j;
        }
        if ((r2 & 8) == 0) {
            this.barValueLabel = "";
        } else {
            this.barValueLabel = str2;
        }
        if ((r2 & 16) == 0) {
            this.markerLabel = "";
        } else {
            this.markerLabel = str3;
        }
        if ((r2 & 32) == 0) {
            this.isSelected = false;
        } else {
            this.isSelected = z;
        }
    }

    public /* synthetic */ BarEntry(int r7, String str, long j, String str2, String str3, boolean z, int r14, DefaultConstructorMarker defaultConstructorMarker) {
        this(r7, (r14 & 2) != 0 ? "" : str, (r14 & 4) != 0 ? 0L : j, (r14 & 8) != 0 ? "" : str2, (r14 & 16) == 0 ? str3 : "", (r14 & 32) != 0 ? false : z);
    }
}
