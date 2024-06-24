package com.animaconnected.secondo.behaviour.temperature;

import android.content.Context;
import android.os.Build;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TemperaturePlugin.kt */
/* loaded from: classes3.dex */
public final class TemperaturePlugin implements BehaviourPlugin<Temperature> {
    public static final int $stable = 8;
    private final String[] requiredPermissions;
    private Temperature temperature;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Temperature>() { // from class: com.animaconnected.secondo.behaviour.temperature.TemperaturePlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Temperature invoke() {
            Temperature temperature;
            temperature = TemperaturePlugin.this.temperature;
            if (temperature != null) {
                return temperature;
            }
            Intrinsics.throwUninitializedPropertyAccessException("temperature");
            throw null;
        }
    });
    private final String type = Temperature.TYPE;
    private final int nameId = R.string.temperature_name;
    private final int iconResourceId = R.drawable.ic_temperature;

    public TemperaturePlugin() {
        String[] strArr;
        if (Build.VERSION.SDK_INT == 29) {
            strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"};
        } else {
            strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        }
        this.requiredPermissions = strArr;
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
    public String[] getRequiredPermissions() {
        return this.requiredPermissions;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.temperature = new Temperature();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public BaseDetailsFragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return TemperatureFragment.Companion.newInstance(slot);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Temperature getBehaviour() {
        return (Temperature) this.behaviour$delegate.getValue();
    }
}
