package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.cardview.R$styleable;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {
    public static final int[] COLOR_BACKGROUND_ATTR = {R.attr.colorBackground};
    public static final CardViewApi21Impl IMPL = new CardViewApi21Impl();
    public final AnonymousClass1 mCardViewDelegate;
    public boolean mCompatPadding;
    public final Rect mContentPadding;
    public boolean mPreventCornerOverlap;
    public final Rect mShadowBounds;

    /* renamed from: androidx.cardview.widget.CardView$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements CardViewDelegate {
        public Drawable mCardBackground;

        public AnonymousClass1() {
        }

        public final void setShadowPadding(int r4, int r5, int r6, int r7) {
            CardView cardView = CardView.this;
            cardView.mShadowBounds.set(r4, r5, r6, r7);
            Rect rect = cardView.mContentPadding;
            CardView.super.setPadding(r4 + rect.left, r5 + rect.top, r6 + rect.right, r7 + rect.bottom);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.kronaby.watch.app.R.attr.cardViewStyle);
        int color;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.mContentPadding = rect;
        this.mShadowBounds = new Rect();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.mCardViewDelegate = anonymousClass1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CardView, com.kronaby.watch.app.R.attr.cardViewStyle, com.kronaby.watch.app.R.style.CardView);
        if (obtainStyledAttributes.hasValue(2)) {
            valueOf = obtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(com.kronaby.watch.app.R.color.cardview_light_background);
            } else {
                color = getResources().getColor(com.kronaby.watch.app.R.color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(7, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        CardViewApi21Impl cardViewApi21Impl = IMPL;
        RoundRectDrawable roundRectDrawable = new RoundRectDrawable(dimension, valueOf);
        anonymousClass1.mCardBackground = roundRectDrawable;
        setBackgroundDrawable(roundRectDrawable);
        setClipToOutline(true);
        setElevation(dimension2);
        cardViewApi21Impl.setMaxElevation(anonymousClass1, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((RoundRectDrawable) this.mCardViewDelegate.mCardBackground).mBackground;
    }

    public float getCardElevation() {
        return CardView.this.getElevation();
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return ((RoundRectDrawable) this.mCardViewDelegate.mCardBackground).mPadding;
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return ((RoundRectDrawable) this.mCardViewDelegate.mCardBackground).mRadius;
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public void setCardBackgroundColor(int r2) {
        ColorStateList valueOf = ColorStateList.valueOf(r2);
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) this.mCardViewDelegate.mCardBackground;
        roundRectDrawable.setBackground(valueOf);
        roundRectDrawable.invalidateSelf();
    }

    public void setCardElevation(float f) {
        CardView.this.setElevation(f);
    }

    public void setMaxCardElevation(float f) {
        IMPL.setMaxElevation(this.mCardViewDelegate, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r1) {
        super.setMinimumHeight(r1);
    }

    @Override // android.view.View
    public void setMinimumWidth(int r1) {
        super.setMinimumWidth(r1);
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            CardViewApi21Impl cardViewApi21Impl = IMPL;
            AnonymousClass1 anonymousClass1 = this.mCardViewDelegate;
            cardViewApi21Impl.setMaxElevation(anonymousClass1, ((RoundRectDrawable) anonymousClass1.mCardBackground).mPadding);
        }
    }

    public void setRadius(float f) {
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) this.mCardViewDelegate.mCardBackground;
        if (f != roundRectDrawable.mRadius) {
            roundRectDrawable.mRadius = f;
            roundRectDrawable.updateBounds(null);
            roundRectDrawable.invalidateSelf();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            CardViewApi21Impl cardViewApi21Impl = IMPL;
            AnonymousClass1 anonymousClass1 = this.mCardViewDelegate;
            cardViewApi21Impl.setMaxElevation(anonymousClass1, ((RoundRectDrawable) anonymousClass1.mCardBackground).mPadding);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) this.mCardViewDelegate.mCardBackground;
        roundRectDrawable.setBackground(colorStateList);
        roundRectDrawable.invalidateSelf();
    }

    @Override // android.view.View
    public final void setPadding(int r1, int r2, int r3, int r4) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r1, int r2, int r3, int r4) {
    }
}
