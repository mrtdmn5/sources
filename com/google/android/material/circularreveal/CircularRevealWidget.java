package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* loaded from: classes3.dex */
public interface CircularRevealWidget {

    /* loaded from: classes3.dex */
    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {
        public static final CircularRevealEvaluator CIRCULAR_REVEAL = new CircularRevealEvaluator();
        public final RevealInfo revealInfo = new RevealInfo();

        @Override // android.animation.TypeEvaluator
        public final RevealInfo evaluate(float f, RevealInfo revealInfo, RevealInfo revealInfo2) {
            RevealInfo revealInfo3 = revealInfo;
            RevealInfo revealInfo4 = revealInfo2;
            float f2 = revealInfo3.centerX;
            float f3 = 1.0f - f;
            float f4 = (revealInfo4.centerX * f) + (f2 * f3);
            float f5 = revealInfo3.centerY;
            float f6 = (revealInfo4.centerY * f) + (f5 * f3);
            float f7 = revealInfo3.radius;
            float f8 = (f * revealInfo4.radius) + (f3 * f7);
            RevealInfo revealInfo5 = this.revealInfo;
            revealInfo5.centerX = f4;
            revealInfo5.centerY = f6;
            revealInfo5.radius = f8;
            return revealInfo5;
        }
    }

    /* loaded from: classes3.dex */
    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {
        public static final CircularRevealProperty CIRCULAR_REVEAL = new CircularRevealProperty();

        public CircularRevealProperty() {
            super(RevealInfo.class, "circularReveal");
        }

        @Override // android.util.Property
        public final RevealInfo get(CircularRevealWidget circularRevealWidget) {
            return circularRevealWidget.getRevealInfo();
        }

        @Override // android.util.Property
        public final void set(CircularRevealWidget circularRevealWidget, RevealInfo revealInfo) {
            circularRevealWidget.setRevealInfo(revealInfo);
        }
    }

    /* loaded from: classes3.dex */
    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
        public static final CircularRevealScrimColorProperty CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty();

        public CircularRevealScrimColorProperty() {
            super(Integer.class, "circularRevealScrimColor");
        }

        @Override // android.util.Property
        public final Integer get(CircularRevealWidget circularRevealWidget) {
            return Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public final void set(CircularRevealWidget circularRevealWidget, Integer num) {
            circularRevealWidget.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* loaded from: classes3.dex */
    public static class RevealInfo {
        public float centerX;
        public float centerY;
        public float radius;

        public RevealInfo() {
        }

        public RevealInfo(float f, float f2, float f3) {
            this.centerX = f;
            this.centerY = f2;
            this.radius = f3;
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    int getCircularRevealScrimColor();

    RevealInfo getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int r1);

    void setRevealInfo(RevealInfo revealInfo);
}
