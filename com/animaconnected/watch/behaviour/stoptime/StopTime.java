package com.animaconnected.watch.behaviour.stoptime;

import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.behaviour.Complication;
import com.animaconnected.watch.device.Scale;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: StopTime.kt */
/* loaded from: classes3.dex */
public final class StopTime implements Complication {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE;
    private Watch watch;
    private final String type = TYPE;
    private final String analyticsName = "stoptime";
    private final int deviceComplicationMode = 6;

    /* compiled from: StopTime.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(StopTime.class).getSimpleName();
        if (simpleName == null) {
            simpleName = "StopTime";
        }
        TYPE = simpleName;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void activate(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public List<Scale> compatibleScales() {
        return CollectionsKt__CollectionsKt.listOf(Scale.Unknown);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return new Slot[]{Slot.MainComplication, Slot.MainComplicationDouble};
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void connected(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        this.watch = watch;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void deactivated(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void disconnected(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        this.watch = null;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public int getDeviceComplicationMode() {
        return this.deviceComplicationMode;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public boolean isSelectable(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        return watch.getCapabilities().hasComplicationZeroNoTimeout();
    }
}
