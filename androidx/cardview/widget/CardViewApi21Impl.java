package androidx.cardview.widget;

import android.graphics.drawable.Drawable;
import androidx.cardview.widget.CardView;

/* loaded from: classes.dex */
public final class CardViewApi21Impl {
    public final void setMaxElevation(CardViewDelegate cardViewDelegate, float f) {
        float f2;
        CardView.AnonymousClass1 anonymousClass1 = (CardView.AnonymousClass1) cardViewDelegate;
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) anonymousClass1.mCardBackground;
        boolean useCompatPadding = CardView.this.getUseCompatPadding();
        CardView cardView = CardView.this;
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (f != roundRectDrawable.mPadding || roundRectDrawable.mInsetForPadding != useCompatPadding || roundRectDrawable.mInsetForRadius != preventCornerOverlap) {
            roundRectDrawable.mPadding = f;
            roundRectDrawable.mInsetForPadding = useCompatPadding;
            roundRectDrawable.mInsetForRadius = preventCornerOverlap;
            roundRectDrawable.updateBounds(null);
            roundRectDrawable.invalidateSelf();
        }
        if (!cardView.getUseCompatPadding()) {
            anonymousClass1.setShadowPadding(0, 0, 0, 0);
            return;
        }
        Drawable drawable = anonymousClass1.mCardBackground;
        float f3 = ((RoundRectDrawable) drawable).mPadding;
        float f4 = ((RoundRectDrawable) drawable).mRadius;
        if (cardView.getPreventCornerOverlap()) {
            f2 = (float) (((1.0d - RoundRectDrawableWithShadow.COS_45) * f4) + f3);
        } else {
            int r1 = RoundRectDrawableWithShadow.$r8$clinit;
            f2 = f3;
        }
        int ceil = (int) Math.ceil(f2);
        int ceil2 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(f3, f4, cardView.getPreventCornerOverlap()));
        anonymousClass1.setShadowPadding(ceil, ceil2, ceil, ceil2);
    }
}
