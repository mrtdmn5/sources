package com.animaconnected.secondo.behaviour.counter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CounterPlugin.kt */
/* loaded from: classes3.dex */
public final class CounterPlugin implements BehaviourPlugin<Counter> {
    public static final int $stable = 8;
    private Counter counter;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Counter>() { // from class: com.animaconnected.secondo.behaviour.counter.CounterPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Counter invoke() {
            Counter counter;
            counter = CounterPlugin.this.counter;
            if (counter != null) {
                return counter;
            }
            Intrinsics.throwUninitializedPropertyAccessException("counter");
            throw null;
        }
    });
    private final String type = Counter.TYPE;
    private final int nameId = R.string.behaviour_name_counter;
    private final int iconResourceId = R.drawable.ic_counter;

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        BaseDetailsFragment newInstance = CounterFragment.newInstance(slot);
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
        this.counter = new Counter();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Counter getBehaviour() {
        return (Counter) this.behaviour$delegate.getValue();
    }
}
