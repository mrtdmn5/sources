package com.google.android.material.elevation;

import android.content.Context;
import android.util.TypedValue;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ElevationOverlayProvider {
    public static final int OVERLAY_ACCENT_COLOR_ALPHA = (int) Math.round(5.1000000000000005d);
    public final int colorSurface;
    public final float displayDensity;
    public final int elevationOverlayAccentColor;
    public final int elevationOverlayColor;
    public final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(Context context) {
        boolean z;
        TypedValue resolve = MaterialAttributes.resolve(context, R.attr.elevationOverlayEnabled);
        if (resolve != null && resolve.type == 18 && resolve.data != 0) {
            z = true;
        } else {
            z = false;
        }
        int color = MaterialColors.getColor(context, R.attr.elevationOverlayColor, 0);
        int color2 = MaterialColors.getColor(context, R.attr.elevationOverlayAccentColor, 0);
        int color3 = MaterialColors.getColor(context, R.attr.colorSurface, 0);
        float f = context.getResources().getDisplayMetrics().density;
        this.elevationOverlayEnabled = z;
        this.elevationOverlayColor = color;
        this.elevationOverlayAccentColor = color2;
        this.colorSurface = color3;
        this.displayDensity = f;
    }
}
