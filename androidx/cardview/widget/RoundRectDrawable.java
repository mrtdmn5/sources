package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class RoundRectDrawable extends Drawable {
    public ColorStateList mBackground;
    public final RectF mBoundsF;
    public final Rect mBoundsI;
    public float mPadding;
    public float mRadius;
    public ColorStateList mTint;
    public PorterDuffColorFilter mTintFilter;
    public boolean mInsetForPadding = false;
    public boolean mInsetForRadius = true;
    public PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_IN;
    public final Paint mPaint = new Paint(5);

    public RoundRectDrawable(float f, ColorStateList colorStateList) {
        this.mRadius = f;
        setBackground(colorStateList);
        this.mBoundsF = new RectF();
        this.mBoundsI = new Rect();
    }

    public final PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.mPaint;
        if (this.mTintFilter != null && paint.getColorFilter() == null) {
            paint.setColorFilter(this.mTintFilter);
            z = true;
        } else {
            z = false;
        }
        RectF rectF = this.mBoundsF;
        float f = this.mRadius;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.mBoundsI, this.mRadius);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.mTint;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || (((colorStateList = this.mBackground) != null && colorStateList.isStateful()) || super.isStateful())) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        updateBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r4) {
        boolean z;
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.mBackground;
        int colorForState = colorStateList.getColorForState(r4, colorStateList.getDefaultColor());
        Paint paint = this.mPaint;
        if (colorForState != paint.getColor()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.mTint;
        if (colorStateList2 != null && (mode = this.mTintMode) != null) {
            this.mTintFilter = createTintFilter(colorStateList2, mode);
            return true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.mPaint.setAlpha(r2);
    }

    public final void setBackground(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.mBackground = colorStateList;
        this.mPaint.setColor(colorStateList.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.mTint = colorStateList;
        this.mTintFilter = createTintFilter(colorStateList, this.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        this.mTintFilter = createTintFilter(this.mTint, mode);
        invalidateSelf();
    }

    public final void updateBounds(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        RectF rectF = this.mBoundsF;
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
        Rect rect2 = this.mBoundsI;
        rect2.set(rect);
        if (this.mInsetForPadding) {
            float calculateVerticalPadding = RoundRectDrawableWithShadow.calculateVerticalPadding(this.mPadding, this.mRadius, this.mInsetForRadius);
            float f = this.mPadding;
            float f2 = this.mRadius;
            if (this.mInsetForRadius) {
                f = (float) (((1.0d - RoundRectDrawableWithShadow.COS_45) * f2) + f);
            }
            rect2.inset((int) Math.ceil(f), (int) Math.ceil(calculateVerticalPadding));
            rectF.set(rect2);
        }
    }
}
