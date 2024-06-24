package com.animaconnected.secondo.behaviour.steps;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StepsPlugin.kt */
/* loaded from: classes3.dex */
public final class StepsPlugin implements BehaviourPlugin<Steps> {
    public static final int $stable = 8;
    private Steps steps;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Steps>() { // from class: com.animaconnected.secondo.behaviour.steps.StepsPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Steps invoke() {
            Steps steps;
            steps = StepsPlugin.this.steps;
            if (steps != null) {
                return steps;
            }
            Intrinsics.throwUninitializedPropertyAccessException("steps");
            throw null;
        }
    });
    private final String type = Steps.type;
    private final int nameId = R.string.behaviour_name_steps;
    private final int iconResourceId = R.drawable.ic_daily_hundred;

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return StepsFragment.Companion.newInstance(slot);
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
        this.steps = new Steps(ProviderFactory.getWatch().fitness());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Steps getBehaviour() {
        return (Steps) this.behaviour$delegate.getValue();
    }
}
