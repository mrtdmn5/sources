package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import androidx.core.graphics.PathParser;
import androidx.core.util.Preconditions;
import androidx.core.view.animation.PathInterpolatorCompat$Api21Impl;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import com.google.android.gms.location.zzae;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class FloatingActionButtonImpl {
    public Animator currentAnimator;
    public float elevation;
    public boolean ensureMinTouchTargetSize;
    public ArrayList<Animator.AnimatorListener> hideListeners;
    public MotionSpec hideMotionSpec;
    public float hoveredFocusedTranslationZ;
    public int maxImageSize;
    public AnonymousClass6 preDrawListener;
    public float pressedTranslationZ;
    public float rotation;
    public final ShadowViewDelegate shadowViewDelegate;
    public ShapeAppearanceModel shapeAppearance;
    public ArrayList<Animator.AnimatorListener> showListeners;
    public MotionSpec showMotionSpec;
    public ArrayList<InternalTransformationCallback> transformationCallbacks;
    public final FloatingActionButton view;
    public static final FastOutLinearInInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    public static final int[] PRESSED_ENABLED_STATE_SET = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    public static final int[] FOCUSED_ENABLED_STATE_SET = {R.attr.state_focused, R.attr.state_enabled};
    public static final int[] HOVERED_ENABLED_STATE_SET = {R.attr.state_hovered, R.attr.state_enabled};
    public static final int[] ENABLED_STATE_SET = {R.attr.state_enabled};
    public static final int[] EMPTY_STATE_SET = new int[0];
    public boolean shadowPaddingEnabled = true;
    public float imageMatrixScale = 1.0f;
    public int animState = 0;
    public final Rect tmpRect = new Rect();
    public final RectF tmpRectF1 = new RectF();
    public final RectF tmpRectF2 = new RectF();
    public final Matrix tmpMatrix = new Matrix();

    /* loaded from: classes3.dex */
    public class DisabledElevationAnimation extends ShadowAnimatorImpl {
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public final float getTargetShadowSize() {
            return 0.0f;
        }
    }

    /* loaded from: classes3.dex */
    public class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        public final /* synthetic */ FloatingActionButtonImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ElevateToHoveredFocusedTranslationZAnimation(FloatingActionButtonImplLollipop floatingActionButtonImplLollipop) {
            super(floatingActionButtonImplLollipop);
            this.this$0 = floatingActionButtonImplLollipop;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public final float getTargetShadowSize() {
            FloatingActionButtonImpl floatingActionButtonImpl = this.this$0;
            return floatingActionButtonImpl.elevation + floatingActionButtonImpl.hoveredFocusedTranslationZ;
        }
    }

    /* loaded from: classes3.dex */
    public class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        public final /* synthetic */ FloatingActionButtonImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ElevateToPressedTranslationZAnimation(FloatingActionButtonImplLollipop floatingActionButtonImplLollipop) {
            super(floatingActionButtonImplLollipop);
            this.this$0 = floatingActionButtonImplLollipop;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public final float getTargetShadowSize() {
            FloatingActionButtonImpl floatingActionButtonImpl = this.this$0;
            return floatingActionButtonImpl.elevation + floatingActionButtonImpl.pressedTranslationZ;
        }
    }

    /* loaded from: classes3.dex */
    public interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    /* loaded from: classes3.dex */
    public interface InternalVisibilityChangedListener {
    }

    /* loaded from: classes3.dex */
    public class ResetElevationAnimation extends ShadowAnimatorImpl {
        public final /* synthetic */ FloatingActionButtonImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResetElevationAnimation(FloatingActionButtonImplLollipop floatingActionButtonImplLollipop) {
            super(floatingActionButtonImplLollipop);
            this.this$0 = floatingActionButtonImplLollipop;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public final float getTargetShadowSize() {
            return this.this$0.elevation;
        }
    }

    /* loaded from: classes3.dex */
    public abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ FloatingActionButtonImpl this$0;
        public boolean validValues;

        public ShadowAnimatorImpl(FloatingActionButtonImplLollipop floatingActionButtonImplLollipop) {
            this.this$0 = floatingActionButtonImplLollipop;
        }

        public abstract float getTargetShadowSize();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            this.this$0.getClass();
            this.validValues = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            boolean z = this.validValues;
            FloatingActionButtonImpl floatingActionButtonImpl = this.this$0;
            if (!z) {
                floatingActionButtonImpl.getClass();
                getTargetShadowSize();
                this.validValues = true;
            }
            valueAnimator.getAnimatedFraction();
            floatingActionButtonImpl.getClass();
        }
    }

    public FloatingActionButtonImpl(FloatingActionButton floatingActionButton, FloatingActionButton.ShadowDelegateImpl shadowDelegateImpl) {
        this.view = floatingActionButton;
        this.shadowViewDelegate = shadowDelegateImpl;
        StateListAnimator stateListAnimator = new StateListAnimator();
        FloatingActionButtonImplLollipop floatingActionButtonImplLollipop = (FloatingActionButtonImplLollipop) this;
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation(floatingActionButtonImplLollipop)));
        stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(floatingActionButtonImplLollipop)));
        stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(floatingActionButtonImplLollipop)));
        stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(floatingActionButtonImplLollipop)));
        stateListAnimator.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation(floatingActionButtonImplLollipop)));
        stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation(floatingActionButtonImplLollipop)));
        this.rotation = floatingActionButton.getRotation();
    }

    public static ValueAnimator createElevationAnimator(ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void calculateImageMatrixFromScale(float f, Matrix matrix) {
        matrix.reset();
        if (this.view.getDrawable() != null && this.maxImageSize != 0) {
            RectF rectF = this.tmpRectF1;
            RectF rectF2 = this.tmpRectF2;
            rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            int r0 = this.maxImageSize;
            rectF2.set(0.0f, 0.0f, r0, r0);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int r02 = this.maxImageSize;
            matrix.postScale(f, f, r02 / 2.0f, r02 / 2.0f);
        }
    }

    public final AnimatorSet createAnimator(MotionSpec motionSpec, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.view;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) property, fArr);
        motionSpec.getTiming("opacity").apply(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_X, f2);
        motionSpec.getTiming("scale").apply(ofFloat2);
        int r5 = Build.VERSION.SDK_INT;
        if (r5 == 26) {
            ofFloat2.setEvaluator(new TypeEvaluator<Float>() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.5
                public final FloatEvaluator floatEvaluator = new FloatEvaluator();

                @Override // android.animation.TypeEvaluator
                public final Float evaluate(float f4, Float f5, Float f6) {
                    float floatValue = this.floatEvaluator.evaluate(f4, (Number) f5, (Number) f6).floatValue();
                    if (floatValue < 0.1f) {
                        floatValue = 0.0f;
                    }
                    return Float.valueOf(floatValue);
                }
            });
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_Y, f2);
        motionSpec.getTiming("scale").apply(ofFloat3);
        if (r5 == 26) {
            ofFloat3.setEvaluator(new TypeEvaluator<Float>() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.5
                public final FloatEvaluator floatEvaluator = new FloatEvaluator();

                @Override // android.animation.TypeEvaluator
                public final Float evaluate(float f4, Float f5, Float f6) {
                    float floatValue = this.floatEvaluator.evaluate(f4, (Number) f5, (Number) f6).floatValue();
                    if (floatValue < 0.1f) {
                        floatValue = 0.0f;
                    }
                    return Float.valueOf(floatValue);
                }
            });
        }
        arrayList.add(ofFloat3);
        Matrix matrix = this.tmpMatrix;
        calculateImageMatrixFromScale(f3, matrix);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(floatingActionButton, new ImageMatrixProperty(), new MatrixEvaluator() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.3
            @Override // android.animation.TypeEvaluator
            public final Matrix evaluate(float f4, Matrix matrix2, Matrix matrix3) {
                FloatingActionButtonImpl.this.imageMatrixScale = f4;
                float[] fArr2 = this.tempStartValues;
                matrix2.getValues(fArr2);
                float[] fArr3 = this.tempEndValues;
                matrix3.getValues(fArr3);
                for (int r6 = 0; r6 < 9; r6++) {
                    float f5 = fArr3[r6];
                    float f6 = fArr2[r6];
                    fArr3[r6] = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f5, f6, f4, f6);
                }
                Matrix matrix4 = this.tempMatrix;
                matrix4.setValues(fArr3);
                return matrix4;
            }
        }, new Matrix(matrix));
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        zzae.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet createDefaultAnimator(final float f, final float f2, final float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        FloatingActionButton floatingActionButton = this.view;
        final float alpha = floatingActionButton.getAlpha();
        final float scaleX = floatingActionButton.getScaleX();
        final float scaleY = floatingActionButton.getScaleY();
        final float f4 = this.imageMatrixScale;
        final Matrix matrix = new Matrix(this.tmpMatrix);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.view.setAlpha(AnimationUtils.lerp(alpha, f, 0.0f, 0.2f, floatValue));
                FloatingActionButton floatingActionButton2 = floatingActionButtonImpl.view;
                float f5 = f2;
                float f6 = scaleX;
                floatingActionButton2.setScaleX(((f5 - f6) * floatValue) + f6);
                FloatingActionButton floatingActionButton3 = floatingActionButtonImpl.view;
                float f7 = scaleY;
                floatingActionButton3.setScaleY(((f5 - f7) * floatValue) + f7);
                float f8 = f3;
                float f9 = f4;
                floatingActionButtonImpl.imageMatrixScale = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f8, f9, floatValue, f9);
                float m = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f8, f9, floatValue, f9);
                Matrix matrix2 = matrix;
                floatingActionButtonImpl.calculateImageMatrixFromScale(m, matrix2);
                floatingActionButtonImpl.view.setImageMatrix(matrix2);
            }
        });
        arrayList.add(ofFloat);
        zzae.playTogether(animatorSet, arrayList);
        Context context = floatingActionButton.getContext();
        int integer = floatingActionButton.getContext().getResources().getInteger(com.kronaby.watch.app.R.integer.material_motion_duration_long_1);
        TypedValue resolve = MaterialAttributes.resolve(context, com.kronaby.watch.app.R.attr.motionDurationLong1);
        if (resolve != null && resolve.type == 16) {
            integer = resolve.data;
        }
        animatorSet.setDuration(integer);
        Context context2 = floatingActionButton.getContext();
        TimeInterpolator timeInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        TypedValue typedValue = new TypedValue();
        if (context2.getTheme().resolveAttribute(com.kronaby.watch.app.R.attr.motionEasingStandard, typedValue, true)) {
            if (typedValue.type == 3) {
                String valueOf = String.valueOf(typedValue.string);
                if (MotionUtils.isEasingType(valueOf, "cubic-bezier")) {
                    String[] split = valueOf.substring(13, valueOf.length() - 1).split(",");
                    if (split.length == 4) {
                        timeInterpolator = PathInterpolatorCompat$Api21Impl.createPathInterpolator(MotionUtils.getControlPoint(0, split), MotionUtils.getControlPoint(1, split), MotionUtils.getControlPoint(2, split), MotionUtils.getControlPoint(3, split));
                    } else {
                        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
                    }
                } else if (MotionUtils.isEasingType(valueOf, "path")) {
                    timeInterpolator = PathInterpolatorCompat$Api21Impl.createPathInterpolator(PathParser.createPathFromPathData(valueOf.substring(5, valueOf.length() - 1)));
                } else {
                    throw new IllegalArgumentException("Invalid motion easing type: ".concat(valueOf));
                }
            } else {
                throw new IllegalArgumentException("Motion easing theme attribute must be a string");
            }
        }
        animatorSet.setInterpolator(timeInterpolator);
        return animatorSet;
    }

    public float getElevation() {
        throw null;
    }

    public void getPadding(Rect rect) {
        float f;
        int r1 = 0;
        if (this.ensureMinTouchTargetSize) {
            r1 = (0 - this.view.getSizeDimension()) / 2;
        }
        if (this.shadowPaddingEnabled) {
            f = getElevation() + this.pressedTranslationZ;
        } else {
            f = 0.0f;
        }
        int max = Math.max(r1, (int) Math.ceil(f));
        int max2 = Math.max(r1, (int) Math.ceil(f * 1.5f));
        rect.set(max, max2, max, max2);
    }

    public void jumpDrawableToCurrentState() {
        throw null;
    }

    public void onCompatShadowChanged() {
        throw null;
    }

    public void onDrawableStateChanged(int[] r1) {
        throw null;
    }

    public void onElevationsChanged(float f, float f2, float f3) {
        throw null;
    }

    public final void onTranslationChanged() {
        ArrayList<InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList != null) {
            Iterator<InternalTransformationCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTranslationChanged();
            }
        }
    }

    public void setRippleColor() {
        throw null;
    }

    public void updateFromViewRotation() {
        throw null;
    }

    public final void updatePadding() {
        getPadding(this.tmpRect);
        Preconditions.checkNotNull(null, "Didn't initialize content background");
        throw null;
    }
}
