package com.animaconnected.watch.storage.models;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BehaviourSlot.kt */
/* loaded from: classes3.dex */
public final class BehaviourSlot {
    private final String behaviour_type;
    private final int group_layer;
    private final int slot;

    /* compiled from: BehaviourSlot.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Integer, Long> group_layerAdapter;
        private final ColumnAdapter<Integer, Long> slotAdapter;

        public Adapter(ColumnAdapter<Integer, Long> group_layerAdapter, ColumnAdapter<Integer, Long> slotAdapter) {
            Intrinsics.checkNotNullParameter(group_layerAdapter, "group_layerAdapter");
            Intrinsics.checkNotNullParameter(slotAdapter, "slotAdapter");
            this.group_layerAdapter = group_layerAdapter;
            this.slotAdapter = slotAdapter;
        }

        public final ColumnAdapter<Integer, Long> getGroup_layerAdapter() {
            return this.group_layerAdapter;
        }

        public final ColumnAdapter<Integer, Long> getSlotAdapter() {
            return this.slotAdapter;
        }
    }

    public BehaviourSlot(String behaviour_type, int r3, int r4) {
        Intrinsics.checkNotNullParameter(behaviour_type, "behaviour_type");
        this.behaviour_type = behaviour_type;
        this.group_layer = r3;
        this.slot = r4;
    }

    public static /* synthetic */ BehaviourSlot copy$default(BehaviourSlot behaviourSlot, String str, int r2, int r3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = behaviourSlot.behaviour_type;
        }
        if ((r4 & 2) != 0) {
            r2 = behaviourSlot.group_layer;
        }
        if ((r4 & 4) != 0) {
            r3 = behaviourSlot.slot;
        }
        return behaviourSlot.copy(str, r2, r3);
    }

    public final String component1() {
        return this.behaviour_type;
    }

    public final int component2() {
        return this.group_layer;
    }

    public final int component3() {
        return this.slot;
    }

    public final BehaviourSlot copy(String behaviour_type, int r3, int r4) {
        Intrinsics.checkNotNullParameter(behaviour_type, "behaviour_type");
        return new BehaviourSlot(behaviour_type, r3, r4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BehaviourSlot)) {
            return false;
        }
        BehaviourSlot behaviourSlot = (BehaviourSlot) obj;
        if (Intrinsics.areEqual(this.behaviour_type, behaviourSlot.behaviour_type) && this.group_layer == behaviourSlot.group_layer && this.slot == behaviourSlot.slot) {
            return true;
        }
        return false;
    }

    public final String getBehaviour_type() {
        return this.behaviour_type;
    }

    public final int getGroup_layer() {
        return this.group_layer;
    }

    public final int getSlot() {
        return this.slot;
    }

    public int hashCode() {
        return Integer.hashCode(this.slot) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.group_layer, this.behaviour_type.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BehaviourSlot(behaviour_type=");
        sb.append(this.behaviour_type);
        sb.append(", group_layer=");
        sb.append(this.group_layer);
        sb.append(", slot=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.slot, ')');
    }
}
