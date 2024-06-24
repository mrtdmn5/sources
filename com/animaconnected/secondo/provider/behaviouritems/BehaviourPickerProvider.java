package com.animaconnected.secondo.provider.behaviouritems;

import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.behaviour.Behaviour;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BehaviourPickerProvider.kt */
/* loaded from: classes3.dex */
public final class BehaviourPickerProvider {
    public static final int $stable = 0;
    private final Slot slot;

    public BehaviourPickerProvider(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        this.slot = slot;
    }

    public final List<BehaviourPlugin<Behaviour>> behavioursPlugins(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        return ProviderFactory.getLabsProvider().getAllBehaviours(ProviderFactory.getBehaviourFactory().getAllPlugins(this.slot, watch));
    }
}
