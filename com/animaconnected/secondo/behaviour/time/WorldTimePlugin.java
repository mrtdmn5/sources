package com.animaconnected.secondo.behaviour.time;

import android.content.Context;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.worldtime.WorldTime;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorldTimePlugin.kt */
/* loaded from: classes3.dex */
public final class WorldTimePlugin implements BehaviourPlugin<WorldTime> {
    public static final int $stable = 8;
    private WorldTime time;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WorldTime>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimePlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WorldTime invoke() {
            WorldTime worldTime;
            worldTime = WorldTimePlugin.this.time;
            if (worldTime != null) {
                return worldTime;
            }
            Intrinsics.throwUninitializedPropertyAccessException(AnalyticsConstants.KEY_TIME);
            throw null;
        }
    });
    private final String type = WorldTime.TYPE;
    private final int nameId = R.string.behaviour_name_time;
    private final int iconResourceId = R.drawable.ic_second_time;

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
        this.time = new WorldTime();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public WorldTimeFragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return new WorldTimeFragment();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public WorldTime getBehaviour() {
        return (WorldTime) this.behaviour$delegate.getValue();
    }
}
