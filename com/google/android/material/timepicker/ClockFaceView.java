package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.timepicker.ClockHandView;
import com.kronaby.watch.app.R;
import java.util.Arrays;

/* loaded from: classes3.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.OnRotateListener {
    public final int clockHandPadding;
    public final ClockHandView clockHandView;
    public final int clockSize;
    public float currentHandRotation;
    public final int[] gradientColors;
    public final float[] gradientPositions;
    public final int minimumHeight;
    public final int minimumWidth;
    public final RectF scratch;
    public final ColorStateList textColor;
    public final SparseArray<TextView> textViewPool;
    public final Rect textViewRect;
    public final AnonymousClass2 valueAccessibilityDelegate;
    public String[] values;

    /* JADX WARN: Type inference failed for: r8v3, types: [com.google.android.material.timepicker.ClockFaceView$2] */
    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        this.textViewRect = new Rect();
        this.scratch = new RectF();
        SparseArray<TextView> sparseArray = new SparseArray<>();
        this.textViewPool = sparseArray;
        this.gradientPositions = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockFaceView, R.attr.materialClockStyle, 2132083861);
        Resources resources = getResources();
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, 1);
        this.textColor = colorStateList;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.clockHandView = clockHandView;
        this.clockHandPadding = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateList.getColorForState(new int[]{android.R.attr.state_selected}, colorStateList.getDefaultColor());
        this.gradientColors = new int[]{colorForState, colorForState, colorStateList.getDefaultColor()};
        clockHandView.listeners.add(this);
        int defaultColor = AppCompatResources.getColorStateList(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, 0);
        setBackgroundColor(colorStateList2 != null ? colorStateList2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.timepicker.ClockFaceView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                ClockFaceView clockFaceView = ClockFaceView.this;
                if (!clockFaceView.isShown()) {
                    return true;
                }
                clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
                int height = ((clockFaceView.getHeight() / 2) - clockFaceView.clockHandView.selectorRadius) - clockFaceView.clockHandPadding;
                if (height != clockFaceView.radius) {
                    clockFaceView.radius = height;
                    clockFaceView.updateLayoutParams();
                    int r1 = clockFaceView.radius;
                    ClockHandView clockHandView2 = clockFaceView.clockHandView;
                    clockHandView2.circleRadius = r1;
                    clockHandView2.invalidate();
                }
                return true;
            }
        });
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.valueAccessibilityDelegate = new AccessibilityDelegateCompat() { // from class: com.google.android.material.timepicker.ClockFaceView.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                View.AccessibilityDelegate accessibilityDelegate = this.mOriginalDelegate;
                AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
                if (intValue > 0) {
                    accessibilityNodeInfo.setTraversalAfter(ClockFaceView.this.textViewPool.get(intValue - 1));
                }
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, intValue, 1, view.isSelected()));
                accessibilityNodeInfo.setClickable(true);
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final boolean performAccessibilityAction(View view, int r13, Bundle bundle) {
                if (r13 == 16) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    float x = view.getX() + (view.getWidth() / 2.0f);
                    float height = (view.getHeight() / 2.0f) + view.getY();
                    ClockFaceView clockFaceView = ClockFaceView.this;
                    clockFaceView.clockHandView.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, x, height, 0));
                    clockFaceView.clockHandView.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, x, height, 0));
                    return true;
                }
                return super.performAccessibilityAction(view, r13, bundle);
            }
        };
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.values = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        for (int r2 = 0; r2 < Math.max(this.values.length, size); r2++) {
            TextView textView = sparseArray.get(r2);
            if (r2 >= this.values.length) {
                removeView(textView);
                sparseArray.remove(r2);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(r2, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.values[r2]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(r2));
                ViewCompat.setAccessibilityDelegate(textView, this.valueAccessibilityDelegate);
                textView.setTextColor(this.textColor);
            }
        }
        this.minimumHeight = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.minimumWidth = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.clockSize = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    public final void findIntersectingTextView() {
        RadialGradient radialGradient;
        RectF rectF = this.clockHandView.selectorBox;
        int r1 = 0;
        while (true) {
            SparseArray<TextView> sparseArray = this.textViewPool;
            if (r1 < sparseArray.size()) {
                TextView textView = sparseArray.get(r1);
                if (textView != null) {
                    Rect rect = this.textViewRect;
                    textView.getDrawingRect(rect);
                    offsetDescendantRectToMyCoords(textView, rect);
                    textView.setSelected(rectF.contains(rect.centerX(), rect.centerY()));
                    RectF rectF2 = this.scratch;
                    rectF2.set(rect);
                    rectF2.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                    if (!RectF.intersects(rectF, rectF2)) {
                        radialGradient = null;
                    } else {
                        radialGradient = new RadialGradient(rectF.centerX() - rectF2.left, rectF.centerY() - rectF2.top, 0.5f * rectF.width(), this.gradientColors, this.gradientPositions, Shader.TileMode.CLAMP);
                    }
                    textView.getPaint().setShader(radialGradient);
                    textView.invalidate();
                }
                r1++;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.values.length, 1, false).mInfo);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r2, int r3, int r4, int r5) {
        super.onLayout(z, r2, r3, r4, r5);
        findIntersectingTextView();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int max = (int) (this.clockSize / Math.max(Math.max(this.minimumHeight / displayMetrics.heightPixels, this.minimumWidth / displayMetrics.widthPixels), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        setMeasuredDimension(max, max);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public final void onRotate(float f) {
        if (Math.abs(this.currentHandRotation - f) > 0.001f) {
            this.currentHandRotation = f;
            findIntersectingTextView();
        }
    }
}
