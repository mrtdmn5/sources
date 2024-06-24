package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.R$styleable;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
class ClockHandView extends View {
    public final float centerDotRadius;
    public boolean changedDuringTouch;
    public int circleRadius;
    public double degRad;
    public final ArrayList listeners;
    public float originalDeg;
    public final Paint paint;
    public final RectF selectorBox;
    public final int selectorRadius;
    public final int selectorStrokeWidth;

    /* loaded from: classes3.dex */
    public interface OnRotateListener {
        void onRotate(float f);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        this.listeners = new ArrayList();
        Paint paint = new Paint();
        this.paint = paint;
        this.selectorBox = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockHandView, R.attr.materialClockStyle, 2132083861);
        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.selectorRadius = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.selectorStrokeWidth = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.centerDotRadius = r4.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        setHandRotation(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api16Impl.setImportantForAccessibility(this, 2);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        float width = getWidth() / 2;
        float cos = (this.circleRadius * ((float) Math.cos(this.degRad))) + width;
        float f = height;
        float sin = (this.circleRadius * ((float) Math.sin(this.degRad))) + f;
        Paint paint = this.paint;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, sin, this.selectorRadius, paint);
        double sin2 = Math.sin(this.degRad);
        double cos2 = Math.cos(this.degRad);
        paint.setStrokeWidth(this.selectorStrokeWidth);
        canvas.drawLine(width, f, r1 + ((int) (cos2 * r11)), height + ((int) (r11 * sin2)), paint);
        canvas.drawCircle(width, f, this.centerDotRadius, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int r2, int r3, int r4, int r5) {
        super.onLayout(z, r2, r3, r4, r5);
        setHandRotation(this.originalDeg);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z4 = false;
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 2) {
                z2 = false;
                z = false;
            } else {
                z2 = this.changedDuringTouch;
                z = false;
            }
        } else {
            this.changedDuringTouch = false;
            z = true;
            z2 = false;
        }
        boolean z5 = this.changedDuringTouch;
        int degrees = ((int) Math.toDegrees(Math.atan2(y - (getHeight() / 2), x - (getWidth() / 2)))) + 90;
        if (degrees < 0) {
            degrees += 360;
        }
        float f = degrees;
        if (this.originalDeg != f) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z || !z3) {
            if (z3 || z2) {
                setHandRotation(f);
            }
            this.changedDuringTouch = z5 | z4;
            return true;
        }
        z4 = true;
        this.changedDuringTouch = z5 | z4;
        return true;
    }

    public final void setHandRotation(float f) {
        setHandRotationInternal(f, false);
    }

    public final void setHandRotationInternal(float f, boolean z) {
        float f2 = f % 360.0f;
        this.originalDeg = f2;
        this.degRad = Math.toRadians(f2 - 90.0f);
        int height = getHeight() / 2;
        float cos = (this.circleRadius * ((float) Math.cos(this.degRad))) + (getWidth() / 2);
        float sin = (this.circleRadius * ((float) Math.sin(this.degRad))) + height;
        float f3 = this.selectorRadius;
        this.selectorBox.set(cos - f3, sin - f3, cos + f3, sin + f3);
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((OnRotateListener) it.next()).onRotate(f2);
        }
        invalidate();
    }
}
