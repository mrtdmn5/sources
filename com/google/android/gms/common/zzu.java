package com.google.android.gms.common;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzu {
    public static Animatable Animatable$default(float f) {
        return new Animatable(Float.valueOf(f), VectorConvertersKt.FloatToVector, Float.valueOf(0.01f), 8);
    }
}
