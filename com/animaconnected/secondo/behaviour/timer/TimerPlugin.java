package com.animaconnected.secondo.behaviour.timer;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.timer.Timer;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimerPlugin.kt */
/* loaded from: classes3.dex */
public final class TimerPlugin implements BehaviourPlugin<Timer> {
    public static final int $stable = 8;
    private Timer timer;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Timer>() { // from class: com.animaconnected.secondo.behaviour.timer.TimerPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Timer invoke() {
            Timer timer;
            timer = TimerPlugin.this.timer;
            if (timer != null) {
                return timer;
            }
            Intrinsics.throwUninitializedPropertyAccessException("timer");
            throw null;
        }
    });
    private final String type = Timer.TYPE;
    private final int nameId = R.string.behaviour_name_timer;
    private final int iconResourceId = R.drawable.ic_timer;

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        TimerFragment newInstance = TimerFragment.newInstance(slot);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        return newInstance;
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
        this.timer = new Timer();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Timer getBehaviour() {
        return (Timer) this.behaviour$delegate.getValue();
    }
}
