package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.DrawableCompat$Api23Impl;
import com.kronaby.watch.app.R;

/* loaded from: classes.dex */
public final class DrawerArrowDrawable extends Drawable {
    public static final float ARROW_HEAD_ANGLE = (float) Math.toRadians(45.0d);
    public final float mArrowHeadLength;
    public final float mArrowShaftLength;
    public float mBarGap;
    public final float mBarLength;
    public final int mDirection;
    public float mMaxCutForBarSize;
    public final Paint mPaint;
    public final Path mPath;
    public float mProgress;
    public final int mSize;
    public boolean mSpin;

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mPath = new Path();
        this.mDirection = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R$styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, 2132082939);
        int color = obtainStyledAttributes.getColor(3, 0);
        if (color != paint.getColor()) {
            paint.setColor(color);
            invalidateSelf();
        }
        float dimension = obtainStyledAttributes.getDimension(7, 0.0f);
        if (paint.getStrokeWidth() != dimension) {
            paint.setStrokeWidth(dimension);
            this.mMaxCutForBarSize = (float) (Math.cos(ARROW_HEAD_ANGLE) * (dimension / 2.0f));
            invalidateSelf();
        }
        boolean z = obtainStyledAttributes.getBoolean(6, true);
        if (this.mSpin != z) {
            this.mSpin = z;
            invalidateSelf();
        }
        float round = Math.round(obtainStyledAttributes.getDimension(5, 0.0f));
        if (round != this.mBarGap) {
            this.mBarGap = round;
            invalidateSelf();
        }
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.mBarLength = Math.round(obtainStyledAttributes.getDimension(2, 0.0f));
        this.mArrowHeadLength = Math.round(obtainStyledAttributes.getDimension(0, 0.0f));
        this.mArrowShaftLength = obtainStyledAttributes.getDimension(1, 0.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float f;
        int r0;
        Rect bounds = getBounds();
        boolean z = true;
        int r2 = this.mDirection;
        if (r2 == 0 || (r2 != 1 && (r2 == 3 ? DrawableCompat$Api23Impl.getLayoutDirection(this) != 0 : DrawableCompat$Api23Impl.getLayoutDirection(this) != 1))) {
            z = false;
        }
        float f2 = this.mArrowHeadLength;
        float sqrt = (float) Math.sqrt(f2 * f2 * 2.0f);
        float f3 = this.mProgress;
        float f4 = this.mBarLength;
        float m = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(sqrt, f4, f3, f4);
        float m2 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(this.mArrowShaftLength, f4, f3, f4);
        float f5 = 0.0f;
        float round = Math.round(((this.mMaxCutForBarSize - 0.0f) * f3) + 0.0f);
        float f6 = this.mProgress;
        float m3 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(ARROW_HEAD_ANGLE, 0.0f, f6, 0.0f);
        if (z) {
            f = 0.0f;
        } else {
            f = -180.0f;
        }
        if (z) {
            f5 = 180.0f;
        }
        float m4 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f5, f, f6, f);
        double d = m;
        double d2 = m3;
        float round2 = (float) Math.round(Math.cos(d2) * d);
        float round3 = (float) Math.round(Math.sin(d2) * d);
        Path path = this.mPath;
        path.rewind();
        float f7 = this.mBarGap;
        Paint paint = this.mPaint;
        float strokeWidth = paint.getStrokeWidth() + f7;
        float m5 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(-this.mMaxCutForBarSize, strokeWidth, this.mProgress, strokeWidth);
        float f8 = (-m2) / 2.0f;
        path.moveTo(f8 + round, 0.0f);
        path.rLineTo(m2 - (round * 2.0f), 0.0f);
        path.moveTo(f8, m5);
        path.rLineTo(round2, round3);
        path.moveTo(f8, -m5);
        path.rLineTo(round2, -round3);
        path.close();
        canvas.save();
        float strokeWidth2 = paint.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth2);
        float f9 = this.mBarGap;
        canvas.translate(bounds.centerX(), (strokeWidth2 * 1.5f) + f9 + ((((int) (height - (2.0f * f9))) / 4) * 2));
        if (this.mSpin) {
            if (z) {
                r0 = -1;
            } else {
                r0 = 1;
            }
            canvas.rotate(m4 * r0);
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r3) {
        Paint paint = this.mPaint;
        if (r3 != paint.getAlpha()) {
            paint.setAlpha(r3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(float f) {
        if (this.mProgress != f) {
            this.mProgress = f;
            invalidateSelf();
        }
    }
}
