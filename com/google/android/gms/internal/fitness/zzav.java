package com.google.android.gms.internal.fitness;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzav {
    public static KeyEvent_androidKt createCornerTreatment(int r1) {
        if (r1 != 0) {
            if (r1 != 1) {
                return new RoundedCornerTreatment();
            }
            return new CutCornerTreatment();
        }
        return new RoundedCornerTreatment();
    }

    public static void setParentAbsoluteElevation(View view, MaterialShapeDrawable materialShapeDrawable) {
        boolean z;
        ElevationOverlayProvider elevationOverlayProvider = materialShapeDrawable.drawableState.elevationOverlayProvider;
        if (elevationOverlayProvider != null && elevationOverlayProvider.elevationOverlayEnabled) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            float f = 0.0f;
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                f += ViewCompat.Api21Impl.getElevation((View) parent);
            }
            MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
            if (materialShapeDrawableState.parentAbsoluteElevation != f) {
                materialShapeDrawableState.parentAbsoluteElevation = f;
                materialShapeDrawable.updateZ();
            }
        }
    }
}
