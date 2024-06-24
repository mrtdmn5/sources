package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import com.google.android.gms.internal.fitness.zzav;
import com.google.android.material.R$styleable;

/* loaded from: classes3.dex */
public final class ShapeAppearanceModel {
    public final EdgeTreatment bottomEdge;
    public final KeyEvent_androidKt bottomLeftCorner;
    public final CornerSize bottomLeftCornerSize;
    public final KeyEvent_androidKt bottomRightCorner;
    public final CornerSize bottomRightCornerSize;
    public final EdgeTreatment leftEdge;
    public final EdgeTreatment rightEdge;
    public final EdgeTreatment topEdge;
    public final KeyEvent_androidKt topLeftCorner;
    public final CornerSize topLeftCornerSize;
    public final KeyEvent_androidKt topRightCorner;
    public final CornerSize topRightCornerSize;

    public ShapeAppearanceModel(Builder builder) {
        this.topLeftCorner = builder.topLeftCorner;
        this.topRightCorner = builder.topRightCorner;
        this.bottomRightCorner = builder.bottomRightCorner;
        this.bottomLeftCorner = builder.bottomLeftCorner;
        this.topLeftCornerSize = builder.topLeftCornerSize;
        this.topRightCornerSize = builder.topRightCornerSize;
        this.bottomRightCornerSize = builder.bottomRightCornerSize;
        this.bottomLeftCornerSize = builder.bottomLeftCornerSize;
        this.topEdge = builder.topEdge;
        this.rightEdge = builder.rightEdge;
        this.bottomEdge = builder.bottomEdge;
        this.leftEdge = builder.leftEdge;
    }

    public static Builder builder(Context context, AttributeSet attributeSet, int r5, int r6) {
        AbsoluteCornerSize absoluteCornerSize = new AbsoluteCornerSize(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, r5, r6);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return builder(context, resourceId, resourceId2, absoluteCornerSize);
    }

    public static CornerSize getCornerSize(TypedArray typedArray, int r3, CornerSize cornerSize) {
        TypedValue peekValue = typedArray.peekValue(r3);
        if (peekValue == null) {
            return cornerSize;
        }
        int r0 = peekValue.type;
        if (r0 == 5) {
            return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        if (r0 == 6) {
            return new RelativeCornerSize(peekValue.getFraction(1.0f, 1.0f));
        }
        return cornerSize;
    }

    public final boolean isRoundRect(RectF rectF) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.leftEdge.getClass().equals(EdgeTreatment.class) && this.rightEdge.getClass().equals(EdgeTreatment.class) && this.topEdge.getClass().equals(EdgeTreatment.class) && this.bottomEdge.getClass().equals(EdgeTreatment.class)) {
            z = true;
        } else {
            z = false;
        }
        float cornerSize = this.topLeftCornerSize.getCornerSize(rectF);
        if (this.topRightCornerSize.getCornerSize(rectF) == cornerSize && this.bottomLeftCornerSize.getCornerSize(rectF) == cornerSize && this.bottomRightCornerSize.getCornerSize(rectF) == cornerSize) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((this.topRightCorner instanceof RoundedCornerTreatment) && (this.topLeftCorner instanceof RoundedCornerTreatment) && (this.bottomRightCorner instanceof RoundedCornerTreatment) && (this.bottomLeftCorner instanceof RoundedCornerTreatment)) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z && z2 && z3) {
            return true;
        }
        return false;
    }

    public final ShapeAppearanceModel withCornerSize(float f) {
        Builder builder = new Builder(this);
        builder.setTopLeftCornerSize(f);
        builder.setTopRightCornerSize(f);
        builder.bottomRightCornerSize = new AbsoluteCornerSize(f);
        builder.bottomLeftCornerSize = new AbsoluteCornerSize(f);
        return new ShapeAppearanceModel(builder);
    }

    public static Builder builder(Context context, int r9, int r10, AbsoluteCornerSize absoluteCornerSize) {
        if (r10 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, r9);
            r9 = r10;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(r9, R$styleable.ShapeAppearance);
        try {
            int r92 = obtainStyledAttributes.getInt(0, 0);
            int r102 = obtainStyledAttributes.getInt(3, r92);
            int r0 = obtainStyledAttributes.getInt(4, r92);
            int r1 = obtainStyledAttributes.getInt(2, r92);
            int r93 = obtainStyledAttributes.getInt(1, r92);
            CornerSize cornerSize = getCornerSize(obtainStyledAttributes, 5, absoluteCornerSize);
            CornerSize cornerSize2 = getCornerSize(obtainStyledAttributes, 8, cornerSize);
            CornerSize cornerSize3 = getCornerSize(obtainStyledAttributes, 9, cornerSize);
            CornerSize cornerSize4 = getCornerSize(obtainStyledAttributes, 7, cornerSize);
            CornerSize cornerSize5 = getCornerSize(obtainStyledAttributes, 6, cornerSize);
            Builder builder = new Builder();
            KeyEvent_androidKt createCornerTreatment = zzav.createCornerTreatment(r102);
            builder.topLeftCorner = createCornerTreatment;
            float compatCornerTreatmentSize = Builder.compatCornerTreatmentSize(createCornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                builder.setTopLeftCornerSize(compatCornerTreatmentSize);
            }
            builder.topLeftCornerSize = cornerSize2;
            KeyEvent_androidKt createCornerTreatment2 = zzav.createCornerTreatment(r0);
            builder.topRightCorner = createCornerTreatment2;
            float compatCornerTreatmentSize2 = Builder.compatCornerTreatmentSize(createCornerTreatment2);
            if (compatCornerTreatmentSize2 != -1.0f) {
                builder.setTopRightCornerSize(compatCornerTreatmentSize2);
            }
            builder.topRightCornerSize = cornerSize3;
            KeyEvent_androidKt createCornerTreatment3 = zzav.createCornerTreatment(r1);
            builder.bottomRightCorner = createCornerTreatment3;
            float compatCornerTreatmentSize3 = Builder.compatCornerTreatmentSize(createCornerTreatment3);
            if (compatCornerTreatmentSize3 != -1.0f) {
                builder.bottomRightCornerSize = new AbsoluteCornerSize(compatCornerTreatmentSize3);
            }
            builder.bottomRightCornerSize = cornerSize4;
            KeyEvent_androidKt createCornerTreatment4 = zzav.createCornerTreatment(r93);
            builder.bottomLeftCorner = createCornerTreatment4;
            float compatCornerTreatmentSize4 = Builder.compatCornerTreatmentSize(createCornerTreatment4);
            if (compatCornerTreatmentSize4 != -1.0f) {
                builder.bottomLeftCornerSize = new AbsoluteCornerSize(compatCornerTreatmentSize4);
            }
            builder.bottomLeftCornerSize = cornerSize5;
            return builder;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        public final EdgeTreatment bottomEdge;
        public KeyEvent_androidKt bottomLeftCorner;
        public CornerSize bottomLeftCornerSize;
        public KeyEvent_androidKt bottomRightCorner;
        public CornerSize bottomRightCornerSize;
        public final EdgeTreatment leftEdge;
        public final EdgeTreatment rightEdge;
        public final EdgeTreatment topEdge;
        public KeyEvent_androidKt topLeftCorner;
        public CornerSize topLeftCornerSize;
        public KeyEvent_androidKt topRightCorner;
        public CornerSize topRightCornerSize;

        public Builder() {
            this.topLeftCorner = new RoundedCornerTreatment();
            this.topRightCorner = new RoundedCornerTreatment();
            this.bottomRightCorner = new RoundedCornerTreatment();
            this.bottomLeftCorner = new RoundedCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = new EdgeTreatment();
            this.rightEdge = new EdgeTreatment();
            this.bottomEdge = new EdgeTreatment();
            this.leftEdge = new EdgeTreatment();
        }

        public static float compatCornerTreatmentSize(KeyEvent_androidKt keyEvent_androidKt) {
            if (keyEvent_androidKt instanceof RoundedCornerTreatment) {
                return ((RoundedCornerTreatment) keyEvent_androidKt).radius;
            }
            if (keyEvent_androidKt instanceof CutCornerTreatment) {
                return ((CutCornerTreatment) keyEvent_androidKt).size;
            }
            return -1.0f;
        }

        public final ShapeAppearanceModel build() {
            return new ShapeAppearanceModel(this);
        }

        public final void setTopLeftCornerSize(float f) {
            this.topLeftCornerSize = new AbsoluteCornerSize(f);
        }

        public final void setTopRightCornerSize(float f) {
            this.topRightCornerSize = new AbsoluteCornerSize(f);
        }

        public Builder(ShapeAppearanceModel shapeAppearanceModel) {
            this.topLeftCorner = new RoundedCornerTreatment();
            this.topRightCorner = new RoundedCornerTreatment();
            this.bottomRightCorner = new RoundedCornerTreatment();
            this.bottomLeftCorner = new RoundedCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = new EdgeTreatment();
            this.rightEdge = new EdgeTreatment();
            this.bottomEdge = new EdgeTreatment();
            this.leftEdge = new EdgeTreatment();
            this.topLeftCorner = shapeAppearanceModel.topLeftCorner;
            this.topRightCorner = shapeAppearanceModel.topRightCorner;
            this.bottomRightCorner = shapeAppearanceModel.bottomRightCorner;
            this.bottomLeftCorner = shapeAppearanceModel.bottomLeftCorner;
            this.topLeftCornerSize = shapeAppearanceModel.topLeftCornerSize;
            this.topRightCornerSize = shapeAppearanceModel.topRightCornerSize;
            this.bottomRightCornerSize = shapeAppearanceModel.bottomRightCornerSize;
            this.bottomLeftCornerSize = shapeAppearanceModel.bottomLeftCornerSize;
            this.topEdge = shapeAppearanceModel.topEdge;
            this.rightEdge = shapeAppearanceModel.rightEdge;
            this.bottomEdge = shapeAppearanceModel.bottomEdge;
            this.leftEdge = shapeAppearanceModel.leftEdge;
        }
    }

    public ShapeAppearanceModel() {
        this.topLeftCorner = new RoundedCornerTreatment();
        this.topRightCorner = new RoundedCornerTreatment();
        this.bottomRightCorner = new RoundedCornerTreatment();
        this.bottomLeftCorner = new RoundedCornerTreatment();
        this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topEdge = new EdgeTreatment();
        this.rightEdge = new EdgeTreatment();
        this.bottomEdge = new EdgeTreatment();
        this.leftEdge = new EdgeTreatment();
    }
}
