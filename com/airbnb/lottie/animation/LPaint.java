package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes.dex */
public final class LPaint extends Paint {
    public LPaint(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public final void setAlpha(int r5) {
        if (Build.VERSION.SDK_INT < 30) {
            int color = getColor();
            PointF pointF = MiscUtils.pathFromDataCurrentPoint;
            setColor((Math.max(0, Math.min(255, r5)) << 24) | (color & 16777215));
        } else {
            PointF pointF2 = MiscUtils.pathFromDataCurrentPoint;
            super.setAlpha(Math.max(0, Math.min(255, r5)));
        }
    }

    public LPaint(PorterDuff.Mode mode, int r2) {
        super(1);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public final void setTextLocales(LocaleList localeList) {
    }
}
