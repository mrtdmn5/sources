package com.animaconnected.secondo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.animaconnected.secondo.widget.CirclePageIndicator;
import com.animaconnected.watch.display.DpUtils;
import java.lang.reflect.Method;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CirclePageIndicator.kt */
/* loaded from: classes3.dex */
public final class CirclePageIndicator extends View implements PageIndicator {
    public static final int $stable = 8;
    private int activePointerId;
    private boolean centered;
    private int currentPage;
    private final int invalidPointer;
    private boolean isDragging;
    private float lastMotionX;
    private ViewPager.OnPageChangeListener listener;
    private int orientation;
    private float pageOffset;
    private final Paint paintBackgroundFillColor;
    private final Paint paintBackgroundStrokeColor;
    private final Paint paintHighlightColor;
    private float radius;
    private int scrollState;
    private boolean snap;
    private int snapPage;
    private final int touchSlop;
    private ViewPager viewPager;

    /* compiled from: CirclePageIndicator.kt */
    /* loaded from: classes3.dex */
    public static final class SavedState extends View.BaseSavedState {
        private int currentPage;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.animaconnected.secondo.widget.CirclePageIndicator$SavedState$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CirclePageIndicator.SavedState createFromParcel(Parcel inP) {
                Intrinsics.checkNotNullParameter(inP, "inP");
                return new CirclePageIndicator.SavedState(inP, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CirclePageIndicator.SavedState[] newArray(int r1) {
                return new CirclePageIndicator.SavedState[r1];
            }
        };

        /* compiled from: CirclePageIndicator.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        public final int getCurrentPage() {
            return this.currentPage;
        }

        public final void setCurrentPage(int r1) {
            this.currentPage = r1;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int r3) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            super.writeToParcel(dest, r3);
            dest.writeInt(this.currentPage);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentPage = parcel.readInt();
        }
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public CirclePageIndicator(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int measureLong(int r6) {
        ViewPager viewPager;
        int r1;
        PagerAdapter adapter;
        int mode = View.MeasureSpec.getMode(r6);
        int size = View.MeasureSpec.getSize(r6);
        if (mode != 1073741824 && (viewPager = this.viewPager) != null) {
            if (viewPager != null && (adapter = viewPager.getAdapter()) != null) {
                r1 = adapter.getCount();
            } else {
                r1 = 0;
            }
            float paddingRight = getPaddingRight() + getPaddingLeft();
            float f = this.radius;
            int r12 = (int) (((r1 - 1) * f) + (r1 * 2 * f) + paddingRight + 1);
            if (mode != Integer.MIN_VALUE || r12 <= size) {
                return r12;
            }
            return size;
        }
        return size;
    }

    private final int measureShort(int r4) {
        int mode = View.MeasureSpec.getMode(r4);
        int size = View.MeasureSpec.getSize(r4);
        if (mode != 1073741824) {
            int paddingTop = (int) ((2 * this.radius) + getPaddingTop() + getPaddingBottom() + 1);
            if (mode != Integer.MIN_VALUE || paddingTop <= size) {
                return paddingTop;
            }
            return size;
        }
        return size;
    }

    private final void setCentered(boolean z) {
        this.centered = z;
        invalidate();
    }

    private final void setSnap(boolean z) {
        this.snap = z;
        invalidate();
    }

    public final int getBackgroundFillColor() {
        return this.paintHighlightColor.getColor();
    }

    public final int getBackgroundStrokeColor() {
        return this.paintBackgroundStrokeColor.getColor();
    }

    public final int getHighlightColor() {
        return this.paintBackgroundFillColor.getColor();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final float getRadius() {
        return this.radius;
    }

    @Override // com.animaconnected.secondo.widget.PageIndicator
    public void notifyDataSetChanged() {
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int r0;
        int height;
        int paddingTop;
        int paddingBottom;
        int paddingLeft;
        int r1;
        float f;
        float f2;
        boolean z;
        PagerAdapter adapter;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        ViewPager viewPager = this.viewPager;
        if (viewPager == null) {
            return;
        }
        if (viewPager != null && (adapter = viewPager.getAdapter()) != null) {
            r0 = adapter.getCount();
        } else {
            r0 = 0;
        }
        if (r0 == 0) {
            return;
        }
        if (this.currentPage >= r0) {
            setCurrentItem(r0 - 1);
            return;
        }
        if (this.orientation == 0) {
            height = getWidth();
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
            paddingLeft = getPaddingTop();
        } else {
            height = getHeight();
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
            paddingLeft = getPaddingLeft();
        }
        float f3 = this.radius;
        float f4 = 3 * f3;
        float f5 = paddingLeft + f3;
        float f6 = paddingTop + f3;
        if (this.centered) {
            f6 += (((height - paddingTop) - paddingBottom) / 2.0f) - ((r0 * f4) / 2.0f);
        }
        if (this.paintBackgroundStrokeColor.getStrokeWidth() > 0.0f) {
            f3 -= this.paintBackgroundStrokeColor.getStrokeWidth() / 2.0f;
        }
        for (int r2 = 0; r2 < r0; r2++) {
            float f7 = (r2 * f4) + f6;
            if (this.orientation == 0) {
                f2 = f5;
            } else {
                f2 = f7;
                f7 = f5;
            }
            if (this.paintHighlightColor.getAlpha() > 0) {
                canvas.drawCircle(f7, f2, f3, this.paintHighlightColor);
            }
            float f8 = this.radius;
            if (f3 == f8) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                canvas.drawCircle(f7, f2, f8, this.paintBackgroundStrokeColor);
            }
        }
        boolean z2 = this.snap;
        if (z2) {
            r1 = this.snapPage;
        } else {
            r1 = this.currentPage;
        }
        float f9 = r1 * f4;
        if (!z2) {
            f9 += this.pageOffset * f4;
        }
        if (this.orientation == 0) {
            float f10 = f6 + f9;
            f = f5;
            f5 = f10;
        } else {
            f = f6 + f9;
        }
        canvas.drawCircle(f5, f, this.radius, this.paintBackgroundFillColor);
    }

    @Override // android.view.View
    public void onMeasure(int r2, int r3) {
        if (this.orientation == 0) {
            setMeasuredDimension(measureLong(r2), measureShort(r3));
        } else {
            setMeasuredDimension(measureShort(r2), measureLong(r3));
        }
    }

    @Override // com.animaconnected.secondo.widget.PageIndicator, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int r2) {
        this.scrollState = r2;
        ViewPager.OnPageChangeListener onPageChangeListener = this.listener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(r2);
        }
    }

    @Override // com.animaconnected.secondo.widget.PageIndicator, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int r2, float f, int r4) {
        this.currentPage = r2;
        this.pageOffset = f;
        invalidate();
        ViewPager.OnPageChangeListener onPageChangeListener = this.listener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(r2, f, r4);
        }
    }

    @Override // com.animaconnected.secondo.widget.PageIndicator, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int r2) {
        if (this.snap || this.scrollState == 0) {
            this.currentPage = r2;
            this.snapPage = r2;
            invalidate();
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.listener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(r2);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        Intrinsics.checkNotNullParameter(state, "state");
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPage = savedState.getCurrentPage();
        this.snapPage = savedState.getCurrentPage();
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.setCurrentPage(this.currentPage);
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        int r3;
        int r5;
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (super.onTouchEvent(ev)) {
            return true;
        }
        ViewPager viewPager = this.viewPager;
        int r2 = 0;
        if (viewPager == null) {
            return false;
        }
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter != null) {
            r3 = adapter.getCount();
        } else {
            r3 = 0;
        }
        if (r3 == 0) {
            return false;
        }
        int action = ev.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                int actionIndex = ev.getActionIndex();
                                if (ev.getPointerId(actionIndex) == this.activePointerId) {
                                    if (actionIndex == 0) {
                                        r2 = 1;
                                    }
                                    this.activePointerId = ev.getPointerId(r2);
                                }
                                this.lastMotionX = ev.getX(ev.findPointerIndex(this.activePointerId));
                            }
                        } else {
                            int actionIndex2 = ev.getActionIndex();
                            this.lastMotionX = ev.getX(actionIndex2);
                            this.activePointerId = ev.getPointerId(actionIndex2);
                        }
                    }
                } else {
                    float x = ev.getX(ev.findPointerIndex(this.activePointerId));
                    float f = x - this.lastMotionX;
                    if (!this.isDragging && Math.abs(f) > this.touchSlop) {
                        this.isDragging = true;
                    }
                    if (this.isDragging) {
                        this.lastMotionX = x;
                        if (viewPager.isFakeDragging() || viewPager.beginFakeDrag()) {
                            viewPager.fakeDragBy(f);
                        }
                    }
                }
            }
            if (!this.isDragging) {
                PagerAdapter adapter2 = viewPager.getAdapter();
                if (adapter2 != null) {
                    r5 = adapter2.getCount();
                } else {
                    r5 = 0;
                }
                float width = getWidth();
                float f2 = width / 2.0f;
                float f3 = width / 6.0f;
                if (this.currentPage > 0 && ev.getX() < f2 - f3) {
                    if (action != 3) {
                        viewPager.setCurrentItem(this.currentPage - 1);
                    }
                    return true;
                }
                if (this.currentPage < r5 - 1 && ev.getX() > f2 + f3) {
                    if (action != 3) {
                        viewPager.setCurrentItem(this.currentPage + 1);
                    }
                    return true;
                }
            }
            this.isDragging = false;
            this.activePointerId = this.invalidPointer;
            if (viewPager.isFakeDragging()) {
                viewPager.endFakeDrag();
            }
        } else {
            this.activePointerId = ev.getPointerId(0);
            this.lastMotionX = ev.getX();
        }
        return true;
    }

    public final void setBackgroundFillColor(int r2) {
        this.paintHighlightColor.setColor(r2);
        invalidate();
    }

    public final void setBackgroundStrokeColor(int r2) {
        this.paintBackgroundStrokeColor.setColor(r2);
        invalidate();
    }

    @Override // com.animaconnected.secondo.widget.PageIndicator
    public void setCurrentItem(int r2) {
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            if (viewPager != null) {
                viewPager.setCurrentItem(r2);
            }
            this.currentPage = r2;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.".toString());
    }

    public final void setHighlightColor(int r2) {
        this.paintBackgroundFillColor.setColor(r2);
        invalidate();
    }

    @Override // com.animaconnected.secondo.widget.PageIndicator
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void setOrientation(int r2) {
        if (r2 != 0 && r2 != 1) {
            throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
        this.orientation = r2;
        requestLayout();
    }

    public final void setRadius(float f) {
        this.radius = f;
        invalidate();
    }

    @Override // com.animaconnected.secondo.widget.PageIndicator
    public void setViewPager(ViewPager view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Intrinsics.areEqual(this.viewPager, view)) {
            return;
        }
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(null);
        }
        if (view.getAdapter() != null) {
            this.viewPager = view;
            view.setOnPageChangeListener(this);
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.".toString());
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CirclePageIndicator(Context context, AttributeSet attributeSet, int r5) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.invalidPointer = -1;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0);
        this.paintHighlightColor = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(-2236963);
        paint2.setStrokeWidth(2.0f);
        this.paintBackgroundStrokeColor = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(-1);
        this.paintBackgroundFillColor = paint3;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        Method method = ViewConfigurationCompat.sGetScaledScrollFactorMethod;
        this.touchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.lastMotionX = -1.0f;
        this.activePointerId = -1;
        this.centered = true;
        this.radius = DpUtils.INSTANCE.dpToPx(context, 3.0f);
    }

    @Override // com.animaconnected.secondo.widget.PageIndicator
    public void setViewPager(ViewPager view, int r3) {
        Intrinsics.checkNotNullParameter(view, "view");
        setViewPager(view);
        setCurrentItem(r3);
    }

    public /* synthetic */ CirclePageIndicator(Context context, AttributeSet attributeSet, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (r4 & 2) != 0 ? null : attributeSet, (r4 & 4) != 0 ? 0 : r3);
    }
}
