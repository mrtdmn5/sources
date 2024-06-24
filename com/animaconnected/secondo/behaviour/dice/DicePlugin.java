package com.animaconnected.secondo.behaviour.dice;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.dice.Dice;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DicePlugin.kt */
/* loaded from: classes3.dex */
public final class DicePlugin implements BehaviourPlugin<Dice> {
    public static final int $stable = 8;
    private Dice dice;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Dice>() { // from class: com.animaconnected.secondo.behaviour.dice.DicePlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Dice invoke() {
            Dice dice;
            dice = DicePlugin.this.dice;
            if (dice != null) {
                return dice;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dice");
            throw null;
        }
    });
    private final String type = Dice.TYPE;
    private final int nameId = R.string.behaviour_name_dice;
    private final int iconResourceId = R.drawable.ic_dice;

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        BaseDetailsFragment newInstance = DiceFragment.newInstance(slot);
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
        this.dice = new Dice();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Dice getBehaviour() {
        return (Dice) this.behaviour$delegate.getValue();
    }
}
