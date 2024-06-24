package com.animaconnected.secondo.behaviour.calibration;

import com.animaconnected.info.UserCategoryKt;
import com.animaconnected.secondo.provider.ProviderFactory;

/* compiled from: CutoutCalibrationPlugin.kt */
/* loaded from: classes3.dex */
public final class CutoutCalibrationPluginKt {
    private static final int maxOffset = 10;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isHidden() {
        return !UserCategoryKt.useDogfoodingLogger(ProviderFactory.getWatch().getUserCategory());
    }
}
