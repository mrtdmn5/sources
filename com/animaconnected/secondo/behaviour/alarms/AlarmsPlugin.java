package com.animaconnected.secondo.behaviour.alarms;

import android.content.Context;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.screens.notification.alarm.AlarmNewFragment;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.alarms.AlarmsApp;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlarmsPlugin.kt */
/* loaded from: classes3.dex */
public final class AlarmsPlugin implements BehaviourPlugin<AlarmsApp> {
    public static final int $stable = 8;
    private AlarmsApp alarmsApp;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<AlarmsApp>() { // from class: com.animaconnected.secondo.behaviour.alarms.AlarmsPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AlarmsApp invoke() {
            AlarmsApp alarmsApp;
            alarmsApp = AlarmsPlugin.this.alarmsApp;
            if (alarmsApp != null) {
                return alarmsApp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("alarmsApp");
            throw null;
        }
    });
    private final String type = AlarmsApp.TYPE;
    private final int nameId = R.string.alarm_app_title;
    private final int iconResourceId = R.drawable.ic_alarm;
    private final String iconWatchAsset = "watch/ic_camera.png";

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getIconResourceId() {
        return this.iconResourceId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getIconWatchAsset() {
        return this.iconWatchAsset;
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
        this.alarmsApp = new AlarmsApp();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public AlarmNewFragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return AlarmNewFragment.Companion.newInstance(Slot.Display);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public AlarmsApp getBehaviour() {
        return (AlarmsApp) this.behaviour$delegate.getValue();
    }
}
