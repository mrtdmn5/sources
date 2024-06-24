package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import kotlin.jvm.internal.Intrinsics;
import mu.KMarkerFactory;

/* compiled from: AndroidPaint.android.kt */
/* loaded from: classes.dex */
public final class AndroidPaint implements Paint {
    public int _blendMode;
    public ColorFilter internalColorFilter;
    public final android.graphics.Paint internalPaint;
    public Shader internalShader;

    public AndroidPaint(android.graphics.Paint internalPaint) {
        Intrinsics.checkNotNullParameter(internalPaint, "internalPaint");
        this.internalPaint = internalPaint;
        this._blendMode = 3;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public final android.graphics.Paint asFrameworkPaint() {
        return this.internalPaint;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public final float getAlpha() {
        Intrinsics.checkNotNullParameter(this.internalPaint, "<this>");
        return r1.getAlpha() / 255.0f;
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int mo292getBlendMode0nO6VwU() {
        return this._blendMode;
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long mo293getColor0d7_KjU() {
        android.graphics.Paint paint = this.internalPaint;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return ColorKt.Color(paint.getColor());
    }

    @Override // androidx.compose.ui.graphics.Paint
    public final ColorFilter getColorFilter() {
        return this.internalColorFilter;
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: getFilterQuality-f-v9h1I, reason: not valid java name */
    public final int mo294getFilterQualityfv9h1I() {
        android.graphics.Paint paint = this.internalPaint;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return paint.isFilterBitmap() ? 1 : 0;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public final Shader getShader() {
        return this.internalShader;
    }

    /* renamed from: getStrokeCap-KaPHkGw, reason: not valid java name */
    public final int m295getStrokeCapKaPHkGw() {
        int r0;
        android.graphics.Paint paint = this.internalPaint;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        Paint.Cap strokeCap = paint.getStrokeCap();
        if (strokeCap == null) {
            r0 = -1;
        } else {
            r0 = AndroidPaint_androidKt.WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()];
        }
        if (r0 != 1) {
            if (r0 == 2) {
                return 1;
            }
            if (r0 == 3) {
                return 2;
            }
        }
        return 0;
    }

    /* renamed from: getStrokeJoin-LxFBmk8, reason: not valid java name */
    public final int m296getStrokeJoinLxFBmk8() {
        int r0;
        android.graphics.Paint paint = this.internalPaint;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        Paint.Join strokeJoin = paint.getStrokeJoin();
        if (strokeJoin == null) {
            r0 = -1;
        } else {
            r0 = AndroidPaint_androidKt.WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        }
        if (r0 != 1) {
            if (r0 == 2) {
                return 2;
            }
            if (r0 == 3) {
                return 1;
            }
        }
        return 0;
    }

    public final float getStrokeMiterLimit() {
        android.graphics.Paint paint = this.internalPaint;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return paint.getStrokeMiter();
    }

    public final float getStrokeWidth() {
        android.graphics.Paint paint = this.internalPaint;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return paint.getStrokeWidth();
    }

    @Override // androidx.compose.ui.graphics.Paint
    public final void setAlpha(float f) {
        android.graphics.Paint paint = this.internalPaint;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setAlpha((int) Math.rint(f * 255.0f));
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void mo297setBlendModes9anfk8(int r4) {
        boolean z;
        if (this._blendMode == r4) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            this._blendMode = r4;
            android.graphics.Paint setNativeBlendMode = this.internalPaint;
            Intrinsics.checkNotNullParameter(setNativeBlendMode, "$this$setNativeBlendMode");
            if (Build.VERSION.SDK_INT >= 29) {
                WrapperVerificationHelperMethods.INSTANCE.m347setBlendModeGB0RdKg(setNativeBlendMode, r4);
            } else {
                setNativeBlendMode.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m281toPorterDuffModes9anfk8(r4)));
            }
        }
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: setColor-8_81llA, reason: not valid java name */
    public final void mo298setColor8_81llA(long j) {
        android.graphics.Paint setNativeColor = this.internalPaint;
        Intrinsics.checkNotNullParameter(setNativeColor, "$this$setNativeColor");
        setNativeColor.setColor(ColorKt.m327toArgb8_81llA(j));
    }

    @Override // androidx.compose.ui.graphics.Paint
    public final void setColorFilter(ColorFilter colorFilter) {
        android.graphics.ColorFilter colorFilter2;
        this.internalColorFilter = colorFilter;
        android.graphics.Paint paint = this.internalPaint;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        if (colorFilter != null) {
            colorFilter2 = colorFilter.nativeColorFilter;
        } else {
            colorFilter2 = null;
        }
        paint.setColorFilter(colorFilter2);
    }

    @Override // androidx.compose.ui.graphics.Paint
    /* renamed from: setFilterQuality-vDHp3xo, reason: not valid java name */
    public final void mo299setFilterQualityvDHp3xo(int r3) {
        boolean z;
        android.graphics.Paint setNativeFilterQuality = this.internalPaint;
        Intrinsics.checkNotNullParameter(setNativeFilterQuality, "$this$setNativeFilterQuality");
        if (r3 == 0) {
            z = true;
        } else {
            z = false;
        }
        setNativeFilterQuality.setFilterBitmap(!z);
    }

    public final void setPathEffect(KMarkerFactory kMarkerFactory) {
        android.graphics.Paint paint = this.internalPaint;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setPathEffect(null);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public final void setShader(Shader shader) {
        this.internalShader = shader;
        android.graphics.Paint paint = this.internalPaint;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setShader(shader);
    }

    /* renamed from: setStrokeCap-BeK7IIE, reason: not valid java name */
    public final void m300setStrokeCapBeK7IIE(int r5) {
        boolean z;
        boolean z2;
        Paint.Cap cap;
        android.graphics.Paint setNativeStrokeCap = this.internalPaint;
        Intrinsics.checkNotNullParameter(setNativeStrokeCap, "$this$setNativeStrokeCap");
        boolean z3 = false;
        if (r5 == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            cap = Paint.Cap.SQUARE;
        } else {
            if (r5 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                cap = Paint.Cap.ROUND;
            } else {
                if (r5 == 0) {
                    z3 = true;
                }
                if (z3) {
                    cap = Paint.Cap.BUTT;
                } else {
                    cap = Paint.Cap.BUTT;
                }
            }
        }
        setNativeStrokeCap.setStrokeCap(cap);
    }

    /* renamed from: setStrokeJoin-Ww9F2mQ, reason: not valid java name */
    public final void m301setStrokeJoinWw9F2mQ(int r5) {
        boolean z;
        boolean z2;
        Paint.Join join;
        android.graphics.Paint setNativeStrokeJoin = this.internalPaint;
        Intrinsics.checkNotNullParameter(setNativeStrokeJoin, "$this$setNativeStrokeJoin");
        boolean z3 = false;
        if (r5 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            join = Paint.Join.MITER;
        } else {
            if (r5 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                join = Paint.Join.BEVEL;
            } else {
                if (r5 == 1) {
                    z3 = true;
                }
                if (z3) {
                    join = Paint.Join.ROUND;
                } else {
                    join = Paint.Join.MITER;
                }
            }
        }
        setNativeStrokeJoin.setStrokeJoin(join);
    }

    public final void setStrokeMiterLimit(float f) {
        android.graphics.Paint paint = this.internalPaint;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setStrokeMiter(f);
    }

    public final void setStrokeWidth(float f) {
        android.graphics.Paint paint = this.internalPaint;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setStrokeWidth(f);
    }

    /* renamed from: setStyle-k9PVt8s, reason: not valid java name */
    public final void m302setStylek9PVt8s(int r3) {
        Paint.Style style;
        android.graphics.Paint setNativeStyle = this.internalPaint;
        Intrinsics.checkNotNullParameter(setNativeStyle, "$this$setNativeStyle");
        boolean z = true;
        if (r3 != 1) {
            z = false;
        }
        if (z) {
            style = Paint.Style.STROKE;
        } else {
            style = Paint.Style.FILL;
        }
        setNativeStyle.setStyle(style);
    }
}
