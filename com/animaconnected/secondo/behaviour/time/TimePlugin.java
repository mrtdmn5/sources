package com.animaconnected.secondo.behaviour.time;

import android.content.Context;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimePlugin.kt */
/* loaded from: classes3.dex */
public final class TimePlugin implements BehaviourPlugin<Time> {
    public static final int $stable = 8;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Time>() { // from class: com.animaconnected.secondo.behaviour.time.TimePlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Time invoke() {
            Time time;
            time = TimePlugin.this.time;
            if (time != null) {
                return time;
            }
            Intrinsics.throwUninitializedPropertyAccessException(AnalyticsConstants.KEY_TIME);
            throw null;
        }
    });
    private final int iconResourceId;
    private final int nameId;
    private Time time;
    private final String type;

    public TimePlugin() {
        String TYPE = Time.TYPE;
        Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
        this.type = TYPE;
        this.nameId = R.string.behaviour_name_time;
        this.iconResourceId = R.drawable.ic_second_time;
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
        this.time = new Time(context, ProviderFactory.getWatch());
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public TimeFragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        TimeFragment newInstance = TimeFragment.newInstance(slot);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        return newInstance;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Time getBehaviour() {
        return (Time) this.behaviour$delegate.getValue();
    }
}
