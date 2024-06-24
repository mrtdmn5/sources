package com.animaconnected.secondo.behaviour.phonebattery;

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

/* compiled from: PhoneBatteryPlugin.kt */
/* loaded from: classes3.dex */
public final class PhoneBatteryPlugin implements BehaviourPlugin<PhoneBattery> {
    public static final int $stable = 8;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<PhoneBattery>() { // from class: com.animaconnected.secondo.behaviour.phonebattery.PhoneBatteryPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PhoneBattery invoke() {
            PhoneBattery phoneBattery;
            phoneBattery = PhoneBatteryPlugin.this.phoneBattery;
            if (phoneBattery != null) {
                return phoneBattery;
            }
            Intrinsics.throwUninitializedPropertyAccessException("phoneBattery");
            throw null;
        }
    });
    private final int iconResourceId;
    private final int nameId;
    private PhoneBattery phoneBattery;
    private final String type;

    public PhoneBatteryPlugin() {
        String TYPE = PhoneBattery.TYPE;
        Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
        this.type = TYPE;
        this.nameId = R.string.behaviour_name_phone_battery;
        this.iconResourceId = R.drawable.ic_phone_battery;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        BaseDetailsFragment newInstance = PhoneBatteryFragment.newInstance(slot);
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
        this.phoneBattery = new PhoneBattery(context);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public PhoneBattery getBehaviour() {
        return (PhoneBattery) this.behaviour$delegate.getValue();
    }
}
