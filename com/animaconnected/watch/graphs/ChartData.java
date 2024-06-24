package com.animaconnected.watch.graphs;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import com.animaconnected.watch.graphs.ChartEntry;
import com.google.android.gms.tasks.zzac;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: ChartEntities.kt */
@Serializable
/* loaded from: classes3.dex */
public final class ChartData<T extends ChartEntry> {
    private static final SerialDescriptor $cachedDescriptor;
    public static final Companion Companion = new Companion(null);
    private final List<T> entries;
    private final boolean hasOlderData;
    private final boolean isDataEmpty;

    /* compiled from: ChartEntities.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T0> KSerializer<ChartData<T0>> serializer(KSerializer<T0> typeSerial0) {
            Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
            return new ChartData$$serializer(typeSerial0);
        }

        private Companion() {
        }
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.graphs.ChartData", null, 3);
        pluginGeneratedSerialDescriptor.addElement("entries", false);
        pluginGeneratedSerialDescriptor.addElement("hasOlderData", false);
        pluginGeneratedSerialDescriptor.addElement("isDataEmpty", false);
        $cachedDescriptor = pluginGeneratedSerialDescriptor;
    }

    public /* synthetic */ ChartData(int r2, List list, boolean z, boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (r2 & 7)) {
            zzac.throwMissingFieldException(r2, 7, $cachedDescriptor);
            throw null;
        }
        this.entries = list;
        this.hasOlderData = z;
        this.isDataEmpty = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChartData copy$default(ChartData chartData, List list, boolean z, boolean z2, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            list = chartData.entries;
        }
        if ((r4 & 2) != 0) {
            z = chartData.hasOlderData;
        }
        if ((r4 & 4) != 0) {
            z2 = chartData.isDataEmpty;
        }
        return chartData.copy(list, z, z2);
    }

    public static final /* synthetic */ void write$Self$graphics_release(ChartData chartData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor, KSerializer kSerializer) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, new ArrayListSerializer(kSerializer), chartData.entries);
        compositeEncoder.encodeBooleanElement(serialDescriptor, 1, chartData.hasOlderData);
        compositeEncoder.encodeBooleanElement(serialDescriptor, 2, chartData.isDataEmpty);
    }

    public final List<T> component1() {
        return this.entries;
    }

    public final boolean component2() {
        return this.hasOlderData;
    }

    public final boolean component3() {
        return this.isDataEmpty;
    }

    public final ChartData<T> copy(List<? extends T> entries, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new ChartData<>(entries, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChartData)) {
            return false;
        }
        ChartData chartData = (ChartData) obj;
        if (Intrinsics.areEqual(this.entries, chartData.entries) && this.hasOlderData == chartData.hasOlderData && this.isDataEmpty == chartData.isDataEmpty) {
            return true;
        }
        return false;
    }

    public final List<T> getEntries() {
        return this.entries;
    }

    public final boolean getHasOlderData() {
        return this.hasOlderData;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isDataEmpty) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.hasOlderData, this.entries.hashCode() * 31, 31);
    }

    public final boolean isDataEmpty() {
        return this.isDataEmpty;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChartData(entries=");
        sb.append(this.entries);
        sb.append(", hasOlderData=");
        sb.append(this.hasOlderData);
        sb.append(", isDataEmpty=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isDataEmpty, ')');
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChartData(List<? extends T> entries, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
        this.hasOlderData = z;
        this.isDataEmpty = z2;
    }
}
