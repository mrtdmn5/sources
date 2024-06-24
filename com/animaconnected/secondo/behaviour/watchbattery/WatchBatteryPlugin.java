package com.animaconnected.secondo.behaviour.watchbattery;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchBatteryPlugin.kt */
/* loaded from: classes3.dex */
public final class WatchBatteryPlugin implements BehaviourPlugin<WatchBattery> {
    public static final int $stable = 8;
    private WatchBattery watchBattery;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WatchBattery>() { // from class: com.animaconnected.secondo.behaviour.watchbattery.WatchBatteryPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WatchBattery invoke() {
            WatchBattery watchBattery;
            watchBattery = WatchBatteryPlugin.this.watchBattery;
            if (watchBattery != null) {
                return watchBattery;
            }
            Intrinsics.throwUninitializedPropertyAccessException("watchBattery");
            throw null;
        }
    });
    private final String type = WatchBattery.TYPE;
    private final int nameId = R.string.behaviour_name_watch_battery;
    private final int iconResourceId = R.drawable.ic_watch_battery;

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return WatchBatteryFragment.Companion.newInstance(slot);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getIconResourceId() {
        return this.iconResourceId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getNameId() {
        return this.nameId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.watchBattery = new WatchBattery();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public WatchBattery getBehaviour() {
        return (WatchBattery) this.behaviour$delegate.getValue();
    }
}
