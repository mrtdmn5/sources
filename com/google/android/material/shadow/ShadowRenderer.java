package com.google.android.material.shadow;

import android.graphics.Paint;
import android.graphics.Path;
import androidx.core.graphics.ColorUtils;
import com.animaconnected.watch.image.Kolors;

/* loaded from: classes3.dex */
public final class ShadowRenderer {
    public final Paint cornerShadowPaint;
    public final Paint edgeShadowPaint;
    public final Path scratch = new Path();
    public int shadowEndColor;
    public int shadowMiddleColor;
    public final Paint shadowPaint;
    public int shadowStartColor;
    public final Paint transparentPaint;
    public static final int[] edgeColors = new int[3];
    public static final float[] edgePositions = {0.0f, 0.5f, 1.0f};
    public static final int[] cornerColors = new int[4];
    public static final float[] cornerPositions = {0.0f, 0.0f, 0.5f, 1.0f};

    public ShadowRenderer() {
        Paint paint = new Paint();
        this.transparentPaint = paint;
        this.shadowPaint = new Paint();
        setShadowColor(Kolors.black);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.cornerShadowPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.edgeShadowPaint = new Paint(paint2);
    }

    public final void setShadowColor(int r2) {
        this.shadowStartColor = ColorUtils.setAlphaComponent(r2, 68);
        this.shadowMiddleColor = ColorUtils.setAlphaComponent(r2, 20);
        this.shadowEndColor = ColorUtils.setAlphaComponent(r2, 0);
        this.shadowPaint.setColor(this.shadowStartColor);
    }
}
