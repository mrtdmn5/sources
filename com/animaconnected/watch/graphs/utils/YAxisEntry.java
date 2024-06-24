package com.animaconnected.watch.graphs.utils;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: YAxisScaleFormatter.kt */
/* loaded from: classes3.dex */
public final class YAxisEntry {
    private final String label;
    private final int value;

    public YAxisEntry(int r2, String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.value = r2;
        this.label = label;
    }

    public static /* synthetic */ YAxisEntry copy$default(YAxisEntry yAxisEntry, int r1, String str, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = yAxisEntry.value;
        }
        if ((r3 & 2) != 0) {
            str = yAxisEntry.label;
        }
        return yAxisEntry.copy(r1, str);
    }

    public final int component1() {
        return this.value;
    }

    public final String component2() {
        return this.label;
    }

    public final YAxisEntry copy(int r2, String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        return new YAxisEntry(r2, label);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YAxisEntry)) {
            return false;
        }
        YAxisEntry yAxisEntry = (YAxisEntry) obj;
        if (this.value == yAxisEntry.value && Intrinsics.areEqual(this.label, yAxisEntry.label)) {
            return true;
        }
        return false;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.label.hashCode() + (Integer.hashCode(this.value) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("YAxisEntry(value=");
        sb.append(this.value);
        sb.append(", label=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.label, ')');
    }
}
