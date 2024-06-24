package com.animaconnected.watch.behaviour.types;

import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.behaviour.Complication;
import com.animaconnected.watch.behaviour.Pusher;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.device.Scale;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Empty.kt */
/* loaded from: classes3.dex */
public final class Empty implements Complication, Pusher {
    private static final String TYPE;
    private static final String type;
    public static final Empty INSTANCE = new Empty();
    private static final int deviceComplicationMode = 15;
    private static final String analyticsName = "empty";

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(Empty.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        TYPE = simpleName;
        type = simpleName;
    }

    private Empty() {
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public List<Scale> compatibleScales() {
        return CollectionsKt__CollectionsKt.listOf(Scale.Unknown);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return new Slot[]{Slot.TopPusher, Slot.BottomPusher, Slot.SubComplication1, Slot.SubComplication2, Slot.MainComplication, Slot.MainComplicationDouble};
    }

    @Override // com.animaconnected.watch.behaviour.Pusher
    public boolean execute(ButtonAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (ButtonAction.Press == action) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public int getDeviceComplicationMode() {
        return deviceComplicationMode;
    }

    public final String getTYPE() {
        return TYPE;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return type;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public boolean isSelectable(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        return false;
    }
}
