package com.google.android.material.shape;

import androidx.compose.ui.input.key.KeyEvent_androidKt;

/* loaded from: classes3.dex */
public final class CutCornerTreatment extends KeyEvent_androidKt {
    public final float size = -1.0f;

    @Override // androidx.compose.ui.input.key.KeyEvent_androidKt
    public final void getCornerPath(float f, float f2, ShapePath shapePath) {
        shapePath.reset(f2 * f, 180.0f, 90.0f);
        double d = f2;
        double d2 = f;
        shapePath.lineTo((float) (Math.sin(Math.toRadians(90.0f)) * d * d2), (float) (Math.sin(Math.toRadians(0.0f)) * d * d2));
    }
}
