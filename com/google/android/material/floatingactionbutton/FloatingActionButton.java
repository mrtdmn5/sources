package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.collection.SimpleArrayMap;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class FloatingActionButton extends VisibilityAwareImageButton implements ExpandableWidget, Shapeable, CoordinatorLayout.AttachedBehavior {
    public ColorStateList backgroundTint;
    public PorterDuff.Mode backgroundTintMode;
    public boolean compatPadding;
    public int customSize;
    public PorterDuff.Mode imageMode;
    public ColorStateList imageTint;
    public FloatingActionButtonImplLollipop impl;
    public int maxImageSize;
    public ColorStateList rippleColor;
    public int size;

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements FloatingActionButtonImpl.InternalVisibilityChangedListener {
        public final /* synthetic */ OnVisibilityChangedListener val$listener;

        public AnonymousClass1(OnVisibilityChangedListener onVisibilityChangedListener) {
            this.val$listener = onVisibilityChangedListener;
        }
    }

    /* loaded from: classes3.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes3.dex */
    public class ShadowDelegateImpl implements ShadowViewDelegate {
        public ShadowDelegateImpl() {
        }
    }

    /* loaded from: classes3.dex */
    public class TransformationCallbackWrapper<T extends FloatingActionButton> implements FloatingActionButtonImpl.InternalTransformationCallback {
        public TransformationCallbackWrapper(FloatingActionButton floatingActionButton) {
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof TransformationCallbackWrapper)) {
                return false;
            }
            ((TransformationCallbackWrapper) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public final void onScaleChanged() {
            throw null;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public final void onTranslationChanged() {
            throw null;
        }
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.impl == null) {
            this.impl = new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl());
        }
        return this.impl;
    }

    public final void addOnHideAnimationListener() {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.hideListeners == null) {
            impl.hideListeners = new ArrayList<>();
        }
        impl.hideListeners.add(null);
    }

    public final void addOnShowAnimationListener(BottomAppBar.AnonymousClass9 anonymousClass9) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.showListeners == null) {
            impl.showListeners = new ArrayList<>();
        }
        impl.showListeners.add(anonymousClass9);
    }

    public final void addTransformationCallback() {
        FloatingActionButtonImpl impl = getImpl();
        TransformationCallbackWrapper transformationCallbackWrapper = new TransformationCallbackWrapper(this);
        if (impl.transformationCallbacks == null) {
            impl.transformationCallbacks = new ArrayList<>();
        }
        impl.transformationCallbacks.add(transformationCallbackWrapper);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().onDrawableStateChanged(getDrawableState());
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().hoveredFocusedTranslationZ;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().pressedTranslationZ;
    }

    public Drawable getContentBackground() {
        getImpl().getClass();
        return null;
    }

    public int getCustomSize() {
        return this.customSize;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public MotionSpec getHideMotionSpec() {
        return getImpl().hideMotionSpec;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.rippleColor;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        ShapeAppearanceModel shapeAppearanceModel = getImpl().shapeAppearance;
        shapeAppearanceModel.getClass();
        return shapeAppearanceModel;
    }

    public MotionSpec getShowMotionSpec() {
        return getImpl().showMotionSpec;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public final void hide(BottomAppBar.AnonymousClass5 anonymousClass5, final boolean z) {
        final AnonymousClass1 anonymousClass1;
        boolean z2;
        int r0;
        AnimatorSet createDefaultAnimator;
        final FloatingActionButtonImpl impl = getImpl();
        if (anonymousClass5 == null) {
            anonymousClass1 = null;
        } else {
            anonymousClass1 = new AnonymousClass1(anonymousClass5);
        }
        boolean z3 = true;
        if (impl.view.getVisibility() != 0 ? impl.animState != 2 : impl.animState == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            Animator animator = impl.currentAnimator;
            if (animator != null) {
                animator.cancel();
            }
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            FloatingActionButton floatingActionButton = impl.view;
            if (!ViewCompat.Api19Impl.isLaidOut(floatingActionButton) || floatingActionButton.isInEditMode()) {
                z3 = false;
            }
            if (z3) {
                MotionSpec motionSpec = impl.hideMotionSpec;
                if (motionSpec != null) {
                    createDefaultAnimator = impl.createAnimator(motionSpec, 0.0f, 0.0f, 0.0f);
                } else {
                    createDefaultAnimator = impl.createDefaultAnimator(0.0f, 0.4f, 0.4f);
                }
                createDefaultAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1
                    public boolean cancelled;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationCancel(Animator animator2) {
                        this.cancelled = true;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator2) {
                        int r1;
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.animState = 0;
                        floatingActionButtonImpl.currentAnimator = null;
                        if (!this.cancelled) {
                            boolean z4 = z;
                            if (z4) {
                                r1 = 8;
                            } else {
                                r1 = 4;
                            }
                            floatingActionButtonImpl.view.internalSetVisibility(r1, z4);
                            InternalVisibilityChangedListener internalVisibilityChangedListener = anonymousClass1;
                            if (internalVisibilityChangedListener != null) {
                                FloatingActionButton.AnonymousClass1 anonymousClass12 = (FloatingActionButton.AnonymousClass1) internalVisibilityChangedListener;
                                anonymousClass12.val$listener.onHidden(FloatingActionButton.this);
                            }
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationStart(Animator animator2) {
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.view.internalSetVisibility(0, z);
                        floatingActionButtonImpl.animState = 1;
                        floatingActionButtonImpl.currentAnimator = animator2;
                        this.cancelled = false;
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = impl.hideListeners;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        createDefaultAnimator.addListener(it.next());
                    }
                }
                createDefaultAnimator.start();
                return;
            }
            if (z) {
                r0 = 8;
            } else {
                r0 = 4;
            }
            floatingActionButton.internalSetVisibility(r0, z);
            if (anonymousClass1 != null) {
                anonymousClass1.val$listener.onHidden(FloatingActionButton.this);
            }
        }
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public final boolean isExpanded() {
        throw null;
    }

    public final boolean isOrWillBeHidden() {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.view.getVisibility() == 0) {
            if (impl.animState != 1) {
                return false;
            }
        } else if (impl.animState == 2) {
            return false;
        }
        return true;
    }

    public final boolean isOrWillBeShown() {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.view.getVisibility() != 0) {
            if (impl.animState != 2) {
                return false;
            }
        } else if (impl.animState == 1) {
            return false;
        }
        return true;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().jumpDrawableToCurrentState();
    }

    public final void onApplySupportImageTint() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.imageTint;
        if (colorStateList == null) {
            drawable.clearColorFilter();
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.imageMode;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$6] */
    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        final FloatingActionButtonImpl impl = getImpl();
        impl.getClass();
        if (!(impl instanceof FloatingActionButtonImplLollipop)) {
            ViewTreeObserver viewTreeObserver = impl.view.getViewTreeObserver();
            if (impl.preDrawListener == null) {
                impl.preDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.6
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public final boolean onPreDraw() {
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        float rotation = floatingActionButtonImpl.view.getRotation();
                        if (floatingActionButtonImpl.rotation != rotation) {
                            floatingActionButtonImpl.rotation = rotation;
                            floatingActionButtonImpl.updateFromViewRotation();
                            return true;
                        }
                        return true;
                    }
                };
            }
            viewTreeObserver.addOnPreDrawListener(impl.preDrawListener);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FloatingActionButtonImpl impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.view.getViewTreeObserver();
        FloatingActionButtonImpl.AnonymousClass6 anonymousClass6 = impl.preDrawListener;
        if (anonymousClass6 != null) {
            viewTreeObserver.removeOnPreDrawListener(anonymousClass6);
            impl.preDrawListener = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r1, int r2) {
        int sizeDimension = (getSizeDimension() - this.maxImageSize) / 2;
        getImpl().updatePadding();
        throw null;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.mSuperState);
        extendableSavedState.extendableStates.getOrDefault("expandableWidgetHelper", null).getClass();
        throw null;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        if (super.onSaveInstanceState() == null) {
            new Bundle();
        }
        new SimpleArrayMap();
        throw null;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (ViewCompat.Api19Impl.isLaidOut(this)) {
                getWidth();
                getHeight();
                throw null;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int r2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            getImpl().getClass();
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            getImpl().getClass();
        }
    }

    public void setCompatElevation(float f) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.elevation != f) {
            impl.elevation = f;
            impl.onElevationsChanged(f, impl.hoveredFocusedTranslationZ, impl.pressedTranslationZ);
        }
    }

    public void setCompatElevationResource(int r2) {
        setCompatElevation(getResources().getDimension(r2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.hoveredFocusedTranslationZ != f) {
            impl.hoveredFocusedTranslationZ = f;
            impl.onElevationsChanged(impl.elevation, f, impl.pressedTranslationZ);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int r2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(r2));
    }

    public void setCompatPressedTranslationZ(float f) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.pressedTranslationZ != f) {
            impl.pressedTranslationZ = f;
            impl.onElevationsChanged(impl.elevation, impl.hoveredFocusedTranslationZ, f);
        }
    }

    public void setCompatPressedTranslationZResource(int r2) {
        setCompatPressedTranslationZ(getResources().getDimension(r2));
    }

    public void setCustomSize(int r2) {
        if (r2 >= 0) {
            if (r2 != this.customSize) {
                this.customSize = r2;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        getImpl().getClass();
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().ensureMinTouchTargetSize) {
            getImpl().ensureMinTouchTargetSize = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int r1) {
        throw null;
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        getImpl().hideMotionSpec = motionSpec;
    }

    public void setHideMotionSpecResource(int r2) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            FloatingActionButtonImpl impl = getImpl();
            float f = impl.imageMatrixScale;
            impl.imageMatrixScale = f;
            Matrix matrix = impl.tmpMatrix;
            impl.calculateImageMatrixFromScale(f, matrix);
            impl.view.setImageMatrix(matrix);
            if (this.imageTint != null) {
                onApplySupportImageTint();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r1) {
        throw null;
    }

    public void setMaxImageSize(int r3) {
        this.maxImageSize = r3;
        FloatingActionButtonImpl impl = getImpl();
        if (impl.maxImageSize != r3) {
            impl.maxImageSize = r3;
            float f = impl.imageMatrixScale;
            impl.imageMatrixScale = f;
            Matrix matrix = impl.tmpMatrix;
            impl.calculateImageMatrixFromScale(f, matrix);
            impl.view.setImageMatrix(matrix);
        }
    }

    public void setRippleColor(int r1) {
        setRippleColor(ColorStateList.valueOf(r1));
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        ArrayList<FloatingActionButtonImpl.InternalTransformationCallback> arrayList = getImpl().transformationCallbacks;
        if (arrayList != null) {
            Iterator<FloatingActionButtonImpl.InternalTransformationCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onScaleChanged();
            }
        }
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        ArrayList<FloatingActionButtonImpl.InternalTransformationCallback> arrayList = getImpl().transformationCallbacks;
        if (arrayList != null) {
            Iterator<FloatingActionButtonImpl.InternalTransformationCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onScaleChanged();
            }
        }
    }

    public void setShadowPaddingEnabled(boolean z) {
        FloatingActionButtonImpl impl = getImpl();
        impl.shadowPaddingEnabled = z;
        impl.updatePadding();
        throw null;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        getImpl().shapeAppearance = shapeAppearanceModel;
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        getImpl().showMotionSpec = motionSpec;
    }

    public void setShowMotionSpecResource(int r2) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    public void setSize(int r2) {
        this.customSize = 0;
        if (r2 != this.size) {
            this.size = r2;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.imageTint != colorStateList) {
            this.imageTint = colorStateList;
            onApplySupportImageTint();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.imageMode != mode) {
            this.imageMode = mode;
            onApplySupportImageTint();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().onTranslationChanged();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().onTranslationChanged();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().onTranslationChanged();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.compatPadding != z) {
            this.compatPadding = z;
            getImpl().onCompatShadowChanged();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
    }

    public final void show(BottomAppBar.AnonymousClass5.AnonymousClass1 anonymousClass1, final boolean z) {
        final AnonymousClass1 anonymousClass12;
        boolean z2;
        boolean z3;
        AnimatorSet createDefaultAnimator;
        float f;
        float f2;
        final FloatingActionButtonImpl impl = getImpl();
        if (anonymousClass1 == null) {
            anonymousClass12 = null;
        } else {
            anonymousClass12 = new AnonymousClass1(anonymousClass1);
        }
        boolean z4 = true;
        if (impl.view.getVisibility() == 0 ? impl.animState != 1 : impl.animState == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            Animator animator = impl.currentAnimator;
            if (animator != null) {
                animator.cancel();
            }
            if (impl.showMotionSpec == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            FloatingActionButton floatingActionButton = impl.view;
            if (!ViewCompat.Api19Impl.isLaidOut(floatingActionButton) || floatingActionButton.isInEditMode()) {
                z4 = false;
            }
            Matrix matrix = impl.tmpMatrix;
            if (z4) {
                if (floatingActionButton.getVisibility() != 0) {
                    float f3 = 0.0f;
                    floatingActionButton.setAlpha(0.0f);
                    if (z3) {
                        f = 0.4f;
                    } else {
                        f = 0.0f;
                    }
                    floatingActionButton.setScaleY(f);
                    if (z3) {
                        f2 = 0.4f;
                    } else {
                        f2 = 0.0f;
                    }
                    floatingActionButton.setScaleX(f2);
                    if (z3) {
                        f3 = 0.4f;
                    }
                    impl.imageMatrixScale = f3;
                    impl.calculateImageMatrixFromScale(f3, matrix);
                    floatingActionButton.setImageMatrix(matrix);
                }
                MotionSpec motionSpec = impl.showMotionSpec;
                if (motionSpec != null) {
                    createDefaultAnimator = impl.createAnimator(motionSpec, 1.0f, 1.0f, 1.0f);
                } else {
                    createDefaultAnimator = impl.createDefaultAnimator(1.0f, 1.0f, 1.0f);
                }
                createDefaultAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator2) {
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.animState = 0;
                        floatingActionButtonImpl.currentAnimator = null;
                        InternalVisibilityChangedListener internalVisibilityChangedListener = anonymousClass12;
                        if (internalVisibilityChangedListener != null) {
                            ((FloatingActionButton.AnonymousClass1) internalVisibilityChangedListener).val$listener.onShown();
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationStart(Animator animator2) {
                        FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                        floatingActionButtonImpl.view.internalSetVisibility(0, z);
                        floatingActionButtonImpl.animState = 2;
                        floatingActionButtonImpl.currentAnimator = animator2;
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = impl.showListeners;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        createDefaultAnimator.addListener(it.next());
                    }
                }
                createDefaultAnimator.start();
                return;
            }
            floatingActionButton.internalSetVisibility(0, z);
            floatingActionButton.setAlpha(1.0f);
            floatingActionButton.setScaleY(1.0f);
            floatingActionButton.setScaleX(1.0f);
            impl.imageMatrixScale = 1.0f;
            impl.calculateImageMatrixFromScale(1.0f, matrix);
            floatingActionButton.setImageMatrix(matrix);
            if (anonymousClass12 != null) {
                anonymousClass12.val$listener.onShown();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        public final boolean autoHideEnabled;
        public Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean getInsetDodgeRect(View view) {
            ((FloatingActionButton) view).getLeft();
            throw null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            boolean z;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                    z = ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior;
                } else {
                    z = false;
                }
                if (z) {
                    updateFabVisibilityForBottomSheet(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int r10) {
            boolean z;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int r3 = 0; r3 < size; r3++) {
                View view2 = (View) dependencies.get(r3);
                if (view2 instanceof AppBarLayout) {
                    if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                        break;
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                        z = ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior;
                    } else {
                        z = false;
                    }
                    if (z && updateFabVisibilityForBottomSheet(view2, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(r10, floatingActionButton);
            return true;
        }

        public final boolean shouldUpdateVisibility(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            if (!this.autoHideEnabled || layoutParams.mAnchorId != view.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            return true;
        }

        public final boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.hide(null, false);
                return true;
            }
            floatingActionButton.show(null, false);
            return true;
        }

        public final boolean updateFabVisibilityForBottomSheet(View view, FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.hide(null, false);
                return true;
            }
            floatingActionButton.show(null, false);
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }
    }

    public final int getSizeDimension(int r4) {
        int r0 = this.customSize;
        if (r0 != 0) {
            return r0;
        }
        Resources resources = getResources();
        if (r4 != -1) {
            if (r4 != 1) {
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
        }
        if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return getSizeDimension(1);
        }
        return getSizeDimension(0);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            getImpl().setRippleColor();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class OnVisibilityChangedListener {
        public void onShown() {
        }

        public void onHidden(FloatingActionButton floatingActionButton) {
        }
    }
}
