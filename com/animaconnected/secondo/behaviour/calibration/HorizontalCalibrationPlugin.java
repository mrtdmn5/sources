package com.animaconnected.secondo.behaviour.calibration;

import android.content.Context;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.screens.details.DummyDetailsFragment;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.HorizontalCutoutCalibration;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CutoutCalibrationPlugin.kt */
/* loaded from: classes3.dex */
public final class HorizontalCalibrationPlugin implements BehaviourPlugin<HorizontalCutoutCalibration> {
    public static final int $stable = 8;
    private HorizontalCutoutCalibration cutoutCalibration;

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getNameId() {
        return R.string.calibration_title_text;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return HorizontalCutoutCalibration.TYPE;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(Context context) {
        boolean isHidden;
        Intrinsics.checkNotNullParameter(context, "context");
        isHidden = CutoutCalibrationPluginKt.isHidden();
        this.cutoutCalibration = new HorizontalCutoutCalibration(isHidden, 10);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public DummyDetailsFragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return new DummyDetailsFragment();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public HorizontalCutoutCalibration getBehaviour() {
        HorizontalCutoutCalibration horizontalCutoutCalibration = this.cutoutCalibration;
        if (horizontalCutoutCalibration != null) {
            return horizontalCutoutCalibration;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cutoutCalibration");
        throw null;
    }
}
