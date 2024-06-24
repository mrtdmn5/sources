package androidx.compose.ui.graphics;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidPaint.android.kt */
/* loaded from: classes.dex */
public final class WrapperVerificationHelperMethods {
    public static final WrapperVerificationHelperMethods INSTANCE = new WrapperVerificationHelperMethods();

    /* renamed from: setBlendMode-GB0RdKg */
    public final void m347setBlendModeGB0RdKg(android.graphics.Paint paint, int r3) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setBlendMode(AndroidBlendMode_androidKt.m280toAndroidBlendModes9anfk8(r3));
    }
}
