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
public final class StateEntry implements ChartEntry {
    public static final Companion Companion = new Companion(null);
    private final boolean isSelected;
    private final String markerLabel;
    private final int state;
    private final long timestamp;
    private final String xAxisLabel;
    private final String yAxisLabel;

    /* compiled from: ChartEntities.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<StateEntry> serializer() {
            return StateEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public StateEntry(int r7, long j, String str, String str2, String str3, boolean z) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, "xAxisLabel", str2, "yAxisLabel", str3, "markerLabel");
        this.state = r7;
        this.timestamp = j;
        this.xAxisLabel = str;
        this.yAxisLabel = str2;
        this.markerLabel = str3;
        this.isSelected = z;
    }

    public static /* synthetic */ StateEntry copy$default(StateEntry stateEntry, int r6, long j, String str, String str2, String str3, boolean z, int r13, Object obj) {
        if ((r13 & 1) != 0) {
            r6 = stateEntry.state;
        }
        if ((r13 & 2) != 0) {
            j = stateEntry.timestamp;
        }
        long j2 = j;
        if ((r13 & 4) != 0) {
            str = stateEntry.xAxisLabel;
        }
        String str4 = str;
        if ((r13 & 8) != 0) {
            str2 = stateEntry.yAxisLabel;
        }
        String str5 = str2;
        if ((r13 & 16) != 0) {
            str3 = stateEntry.markerLabel;
        }
        String str6 = str3;
        if ((r13 & 32) != 0) {
            z = stateEntry.isSelected;
        }
        return stateEntry.copy(r6, j2, str4, str5, str6, z);
    }

    public static final /* synthetic */ void write$Self$graphics_release(StateEntry stateEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2 = false;
        compositeEncoder.encodeIntElement(0, stateEntry.state, serialDescriptor);
        compositeEncoder.encodeLongElement(serialDescriptor, 1, stateEntry.timestamp);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, stateEntry.getXAxisLabel());
        compositeEncoder.encodeStringElement(serialDescriptor, 3, stateEntry.yAxisLabel);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || !Intrinsics.areEqual(stateEntry.getMarkerLabel(), "")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeStringElement(serialDescriptor, 4, stateEntry.getMarkerLabel());
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || stateEntry.isSelected()) {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 5, stateEntry.isSelected());
        }
    }

    public final int component1() {
        return this.state;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.xAxisLabel;
    }

    public final String component4() {
        return this.yAxisLabel;
    }

    public final String component5() {
        return this.markerLabel;
    }

    public final boolean component6() {
        return this.isSelected;
    }

    public final StateEntry copy(int r10, long j, String xAxisLabel, String yAxisLabel, String markerLabel, boolean z) {
        Intrinsics.checkNotNullParameter(xAxisLabel, "xAxisLabel");
        Intrinsics.checkNotNullParameter(yAxisLabel, "yAxisLabel");
        Intrinsics.checkNotNullParameter(markerLabel, "markerLabel");
        return new StateEntry(r10, j, xAxisLabel, yAxisLabel, markerLabel, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StateEntry)) {
            return false;
        }
        StateEntry stateEntry = (StateEntry) obj;
        if (this.state == stateEntry.state && this.timestamp == stateEntry.timestamp && Intrinsics.areEqual(this.xAxisLabel, stateEntry.xAxisLabel) && Intrinsics.areEqual(this.yAxisLabel, stateEntry.yAxisLabel) && Intrinsics.areEqual(this.markerLabel, stateEntry.markerLabel) && this.isSelected == stateEntry.isSelected) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.graphs.ChartEntry
    public String getMarkerLabel() {
        return this.markerLabel;
    }

    public final int getState() {
        return this.state;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.animaconnected.watch.graphs.ChartEntry
    public String getXAxisLabel() {
        return this.xAxisLabel;
    }

    public final String getYAxisLabel() {
        return this.yAxisLabel;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isSelected) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.markerLabel, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.yAxisLabel, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.xAxisLabel, Scale$$ExternalSyntheticOutline0.m(this.timestamp, Integer.hashCode(this.state) * 31, 31), 31), 31), 31);
    }

    @Override // com.animaconnected.watch.graphs.ChartEntry
    public boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StateEntry(state=");
        sb.append(this.state);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", xAxisLabel=");
        sb.append(this.xAxisLabel);
        sb.append(", yAxisLabel=");
        sb.append(this.yAxisLabel);
        sb.append(", markerLabel=");
        sb.append(this.markerLabel);
        sb.append(", isSelected=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isSelected, ')');
    }

    public /* synthetic */ StateEntry(int r2, int r3, long j, String str, String str2, String str3, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (r2 & 15)) {
            zzac.throwMissingFieldException(r2, 15, StateEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.state = r3;
        this.timestamp = j;
        this.xAxisLabel = str;
        this.yAxisLabel = str2;
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

    public /* synthetic */ StateEntry(int r10, long j, String str, String str2, String str3, boolean z, int r17, DefaultConstructorMarker defaultConstructorMarker) {
        this(r10, j, str, str2, (r17 & 16) != 0 ? "" : str3, (r17 & 32) != 0 ? false : z);
    }
}
