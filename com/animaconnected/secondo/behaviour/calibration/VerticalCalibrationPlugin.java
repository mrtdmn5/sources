package com.animaconnected.secondo.behaviour.calibration;

import android.content.Context;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.screens.details.DummyDetailsFragment;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.VerticalCutoutCalibration;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CutoutCalibrationPlugin.kt */
/* loaded from: classes3.dex */
public final class VerticalCalibrationPlugin implements BehaviourPlugin<VerticalCutoutCalibration> {
    public static final int $stable = 8;
    private VerticalCutoutCalibration cutoutCalibration;

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getNameId() {
        return R.string.calibration_title_text;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return VerticalCutoutCalibration.TYPE;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(Context context) {
        boolean isHidden;
        Intrinsics.checkNotNullParameter(context, "context");
        isHidden = CutoutCalibrationPluginKt.isHidden();
        this.cutoutCalibration = new VerticalCutoutCalibration(isHidden, 10);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public DummyDetailsFragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return new DummyDetailsFragment();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public VerticalCutoutCalibration getBehaviour() {
        VerticalCutoutCalibration verticalCutoutCalibration = this.cutoutCalibration;
        if (verticalCutoutCalibration != null) {
            return verticalCutoutCalibration;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cutoutCalibration");
        throw null;
    }
}
