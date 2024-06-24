package com.animaconnected.watch.display;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.theme.FontConfig;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidKanvas.kt */
/* loaded from: classes3.dex */
public final class AndroidKanvas implements Kanvas {
    private Context context;
    private float displayMultiplier;
    private final DisplayMetrics metrics;
    private Canvas nativeCanvas;

    /* compiled from: AndroidKanvas.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[Kanvas.Anchor.Position.values().length];
            try {
                r0[Kanvas.Anchor.Position.MIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Kanvas.Anchor.Position.MID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Kanvas.Anchor.Position.MAX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[Kanvas.TextAlignment.values().length];
            try {
                r02[Kanvas.TextAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r02[Kanvas.TextAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r02[Kanvas.TextAlignment.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    public AndroidKanvas(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.metrics = Resources.getSystem().getDisplayMetrics();
        this.displayMultiplier = DpUtilsKt.getDensity();
    }

    private final float spToPx(float f) {
        return (float) Math.ceil(f * this.metrics.scaledDensity);
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public CanvasPaint createColorPaint(int r5, boolean z, float f, Kanvas.DashedLine dashedLine) {
        Paint paint = new Paint(1);
        paint.setColor(r5);
        if (z) {
            paint.setStyle(Paint.Style.FILL);
        } else {
            if (dashedLine != null) {
                paint.setPathEffect(new DashPathEffect(new float[]{DpUtilsKt.toPx(dashedLine.getDashLength()), DpUtilsKt.toPx(dashedLine.getSpaceLength())}, 0.0f));
            }
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(DpUtilsKt.toPx(f));
        }
        return new AndroidPaint(paint);
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public CanvasPath createPath() {
        return new AndroidPath(new Path());
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public CanvasPaint createTextPaint(Kanvas.TextConfig textConfig) {
        Paint.Align align;
        Intrinsics.checkNotNullParameter(textConfig, "textConfig");
        TextPaint textPaint = new TextPaint(1);
        FontConfig fontConfig = textConfig.getFontConfig();
        Intrinsics.checkNotNull(fontConfig, "null cannot be cast to non-null type com.animaconnected.watch.display.AndroidFontConfig");
        textPaint.setTypeface(((AndroidFontConfig) fontConfig).getTypeface(this.context));
        textPaint.setTextSize(spToPx(textConfig.getFontConfig().getFontSize()));
        textPaint.setColor(textConfig.getTextColor());
        int r2 = WhenMappings.$EnumSwitchMapping$1[textConfig.getTextAlignment().ordinal()];
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 == 3) {
                    align = Paint.Align.RIGHT;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                align = Paint.Align.CENTER;
            }
        } else {
            align = Paint.Align.LEFT;
        }
        textPaint.setTextAlign(align);
        Kanvas.Shadow textShadow = textConfig.getTextShadow();
        if (textShadow != null) {
            textPaint.setShadowLayer(textShadow.getRadius(), textShadow.getDx(), textShadow.getDy(), textShadow.getColor());
        }
        return new AndroidPaint(textPaint);
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void drawCircle(float f, float f2, float f3, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawCircle(DpUtilsKt.toPx(f), DpUtilsKt.toPx(f2), DpUtilsKt.toPx(f3), ((AndroidPaint) paint).getPaint());
        }
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void drawImage(float f, float f2, float f3, float f4, Mitmap mitmap, CanvasPaint canvasPaint) {
        AndroidPaint androidPaint;
        Intrinsics.checkNotNullParameter(mitmap, "mitmap");
        Mitmap stretch = KanvasKt.stretch(mitmap, DpUtilsKt.toPxInt(f3), DpUtilsKt.toPxInt(f4));
        DisplayMetrics metrics = this.metrics;
        Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
        Bitmap bitmap = AndroidGraphicsKt.toBitmap(stretch, metrics);
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            float pxInt = DpUtilsKt.toPxInt(f);
            float pxInt2 = DpUtilsKt.toPxInt(f2);
            Paint paint = null;
            if (canvasPaint instanceof AndroidPaint) {
                androidPaint = (AndroidPaint) canvasPaint;
            } else {
                androidPaint = null;
            }
            if (androidPaint != null) {
                paint = androidPaint.getPaint();
            }
            canvas.drawBitmap(bitmap, pxInt, pxInt2, paint);
        }
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void drawLine(float f, float f2, float f3, float f4, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawLine(DpUtilsKt.toPx(f), DpUtilsKt.toPx(f2), DpUtilsKt.toPx(f3), DpUtilsKt.toPx(f4), ((AndroidPaint) paint).getPaint());
        }
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void drawPath(CanvasPath path, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawPath(((AndroidPath) path).getPath$graphics_release(), ((AndroidPaint) paint).getPaint());
        }
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void drawRect(float f, float f2, float f3, float f4, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawRect(DpUtilsKt.toPx(f), DpUtilsKt.toPx(f2), DpUtilsKt.toPx(f3), DpUtilsKt.toPx(f4), ((AndroidPaint) paint).getPaint());
        }
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void drawText(String text, float f, float f2, float f3, Kanvas.Anchor anchor, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.save();
        }
        PointF pointRelativeToAnchor = pointRelativeToAnchor(anchor, paint.measureSize(text));
        Canvas canvas2 = this.nativeCanvas;
        if (canvas2 != null) {
            canvas2.translate(DpUtilsKt.toPx(f), DpUtilsKt.toPx(f2));
        }
        Canvas canvas3 = this.nativeCanvas;
        if (canvas3 != null) {
            canvas3.rotate(f3);
        }
        Canvas canvas4 = this.nativeCanvas;
        if (canvas4 != null) {
            canvas4.drawText(text, pointRelativeToAnchor.getX(), pointRelativeToAnchor.getY(), ((AndroidPaint) paint).getPaint());
        }
        Canvas canvas5 = this.nativeCanvas;
        if (canvas5 != null) {
            canvas5.restore();
        }
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public float getDisplayMultiplier() {
        return this.displayMultiplier;
    }

    public final Canvas getNativeCanvas() {
        return this.nativeCanvas;
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public PointF pointRelativeToAnchor(Kanvas.Anchor anchor, Size size) {
        float f;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(size, "size");
        Kanvas.Anchor.Position horizontal = anchor.getHorizontal();
        int[] r2 = WhenMappings.$EnumSwitchMapping$0;
        int r1 = r2[horizontal.ordinal()];
        float f2 = 0.0f;
        if (r1 != 1) {
            if (r1 != 2) {
                if (r1 == 3) {
                    f = -size.getWidth();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                f = (-size.getWidth()) / 2.0f;
            }
        } else {
            f = 0.0f;
        }
        float px = DpUtilsKt.toPx(f);
        int r9 = r2[anchor.getVertical().ordinal()];
        if (r9 != 1) {
            if (r9 != 2) {
                if (r9 == 3) {
                    f2 = size.getHeight();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                f2 = size.getHeight() / 2.0f;
            }
        }
        return new PointF(px, DpUtilsKt.toPx(f2));
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void rotate(float f) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.rotate(f);
        }
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void setDisplayMultiplier(float f) {
        this.displayMultiplier = f;
    }

    public final void setNativeCanvas(Canvas canvas) {
        this.nativeCanvas = canvas;
    }
}
