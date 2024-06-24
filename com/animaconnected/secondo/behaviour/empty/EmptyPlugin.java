package com.animaconnected.secondo.behaviour.empty;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.types.Empty;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmptyPlugin.kt */
/* loaded from: classes3.dex */
public final class EmptyPlugin implements BehaviourPlugin<Empty> {
    public static final int $stable = 8;
    private final Empty behaviour;
    private final int nameId;
    private final String type;

    public EmptyPlugin() {
        Empty empty = Empty.INSTANCE;
        this.behaviour = empty;
        this.type = empty.getTYPE();
        this.nameId = R.string.behaviour_name_empty;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return null;
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
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Empty getBehaviour() {
        return this.behaviour;
    }
}
