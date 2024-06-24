package com.animaconnected.watch.behaviour;

import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.device.Scale;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemoteComplicationBehaviour.kt */
/* loaded from: classes3.dex */
public abstract class RemoteComplicationBehaviour extends WatchFaceBehavior {
    public static final Companion Companion = new Companion(null);
    private static final int[] DEFAULT_REMOTE_DATA_CONFIG = {60, 0, 0};
    private final int[] remoteDataConfig = DEFAULT_REMOTE_DATA_CONFIG;
    private Watch watch;

    /* compiled from: RemoteComplicationBehaviour.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public List<Scale> compatibleScales() {
        return CollectionsKt__CollectionsKt.listOf(Scale.All);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return new Slot[]{Slot.MainComplication, Slot.MainComplicationDouble, Slot.SubComplication1, Slot.SubComplication2};
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void connected(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        this.watch = watch;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void disconnected(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        this.watch = null;
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public int getDeviceComplicationMode() {
        return 3;
    }

    public abstract int[] getRemoteData(List<? extends Scale> list);

    public int[] getRemoteDataConfig() {
        return this.remoteDataConfig;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public boolean isSelectable(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        return watch.getCapabilities().hasRemoteDataFix();
    }
}
