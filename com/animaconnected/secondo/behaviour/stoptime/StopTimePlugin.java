package com.animaconnected.secondo.behaviour.stoptime;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.stoptime.StopTime;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StopTimePlugin.kt */
/* loaded from: classes3.dex */
public final class StopTimePlugin implements BehaviourPlugin<StopTime> {
    public static final int $stable = 8;
    private StopTime stopTime;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<StopTime>() { // from class: com.animaconnected.secondo.behaviour.stoptime.StopTimePlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StopTime invoke() {
            StopTime stopTime;
            stopTime = StopTimePlugin.this.stopTime;
            if (stopTime != null) {
                return stopTime;
            }
            Intrinsics.throwUninitializedPropertyAccessException("stopTime");
            throw null;
        }
    });
    private final String type = StopTime.TYPE;
    private final int nameId = R.string.behaviour_name_stoptime;
    private final int iconResourceId = R.drawable.ic_stop_time;

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return StopTimeFragment.newInstance(slot);
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
        this.stopTime = new StopTime();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public StopTime getBehaviour() {
        return (StopTime) this.behaviour$delegate.getValue();
    }
}
