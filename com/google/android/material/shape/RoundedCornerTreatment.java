package com.google.android.material.shape;

import androidx.compose.ui.input.key.KeyEvent_androidKt;

/* loaded from: classes3.dex */
public final class RoundedCornerTreatment extends KeyEvent_androidKt {
    public final float radius = -1.0f;

    @Override // androidx.compose.ui.input.key.KeyEvent_androidKt
    public final void getCornerPath(float f, float f2, ShapePath shapePath) {
        shapePath.reset(f2 * f, 180.0f, 90.0f);
        float f3 = f2 * 2.0f * f;
        shapePath.addArc(0.0f, 0.0f, f3, f3, 180.0f, 90.0f);
    }
}
