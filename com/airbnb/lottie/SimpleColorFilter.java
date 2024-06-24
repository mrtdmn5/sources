package com.airbnb.lottie;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

/* loaded from: classes.dex */
public final class SimpleColorFilter extends PorterDuffColorFilter {
    public SimpleColorFilter(int r2) {
        super(r2, PorterDuff.Mode.SRC_ATOP);
    }
}
