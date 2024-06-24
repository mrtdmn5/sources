package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.compose.foundation.layout.InsetsListener;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class WindowInsetsAnimationCompat {
    public final Impl mImpl;

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public WindowInsets mDispachedInsets;
        public final int mDispatchMode;

        public Callback(int r1) {
            this.mDispatchMode = r1;
        }

        public abstract void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat);

        public abstract void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat);

        public abstract WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list);

        public abstract BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat);
    }

    /* loaded from: classes.dex */
    public static class Impl {
        public final long mDurationMillis;
        public float mFraction;
        public final Interpolator mInterpolator;

        public Impl(Interpolator interpolator, long j) {
            this.mInterpolator = interpolator;
            this.mDurationMillis = j;
        }

        public long getDurationMillis() {
            return this.mDurationMillis;
        }

        public float getInterpolatedFraction() {
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                return interpolator.getInterpolation(this.mFraction);
            }
            return this.mFraction;
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }
    }

    /* loaded from: classes.dex */
    public static class Impl21 extends Impl {
        public static final PathInterpolator SHOW_IME_INTERPOLATOR = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
        public static final FastOutLinearInInterpolator HIDE_IME_INTERPOLATOR = new FastOutLinearInInterpolator();
        public static final DecelerateInterpolator DEFAULT_INSET_INTERPOLATOR = new DecelerateInterpolator();

        /* loaded from: classes.dex */
        public static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
            public final Callback mCallback;
            public WindowInsetsCompat mLastInsets;

            /* renamed from: androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1 */
            /* loaded from: classes.dex */
            public class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
                public final /* synthetic */ int val$animationMask;
                public final /* synthetic */ WindowInsetsCompat val$startingInsets;
                public final /* synthetic */ WindowInsetsCompat val$targetInsets;
                public final /* synthetic */ View val$v;

                public AnonymousClass1(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int r4, View view) {
                    r2 = windowInsetsCompat;
                    r3 = windowInsetsCompat2;
                    r4 = r4;
                    r5 = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    WindowInsetsCompat.BuilderImpl builderImpl20;
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = WindowInsetsAnimationCompat.this;
                    windowInsetsAnimationCompat.mImpl.setFraction(animatedFraction);
                    float interpolatedFraction = windowInsetsAnimationCompat.mImpl.getInterpolatedFraction();
                    PathInterpolator pathInterpolator = Impl21.SHOW_IME_INTERPOLATOR;
                    int r1 = Build.VERSION.SDK_INT;
                    WindowInsetsCompat windowInsetsCompat = r2;
                    if (r1 >= 30) {
                        builderImpl20 = new WindowInsetsCompat.BuilderImpl30(windowInsetsCompat);
                    } else if (r1 >= 29) {
                        builderImpl20 = new WindowInsetsCompat.BuilderImpl29(windowInsetsCompat);
                    } else {
                        builderImpl20 = new WindowInsetsCompat.BuilderImpl20(windowInsetsCompat);
                    }
                    for (int r2 = 1; r2 <= 256; r2 <<= 1) {
                        if ((r4 & r2) == 0) {
                            builderImpl20.setInsets(r2, windowInsetsCompat.getInsets(r2));
                        } else {
                            Insets insets = windowInsetsCompat.getInsets(r2);
                            Insets insets2 = r3.getInsets(r2);
                            float f = 1.0f - interpolatedFraction;
                            builderImpl20.setInsets(r2, WindowInsetsCompat.insetInsets(insets, (int) (((insets.left - insets2.left) * f) + 0.5d), (int) (((insets.top - insets2.top) * f) + 0.5d), (int) (((insets.right - insets2.right) * f) + 0.5d), (int) (((insets.bottom - insets2.bottom) * f) + 0.5d)));
                        }
                    }
                    Impl21.dispatchOnProgress(r5, builderImpl20.build(), Collections.singletonList(windowInsetsAnimationCompat));
                }
            }

            /* renamed from: androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$2 */
            /* loaded from: classes.dex */
            public class AnonymousClass2 extends AnimatorListenerAdapter {
                public final /* synthetic */ View val$v;

                public AnonymousClass2(View view) {
                    r2 = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = WindowInsetsAnimationCompat.this;
                    windowInsetsAnimationCompat.mImpl.setFraction(1.0f);
                    Impl21.dispatchOnEnd(r2, windowInsetsAnimationCompat);
                }
            }

            /* renamed from: androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$3 */
            /* loaded from: classes.dex */
            public class AnonymousClass3 implements Runnable {
                public final /* synthetic */ WindowInsetsAnimationCompat val$anim;
                public final /* synthetic */ BoundsCompat val$animationBounds;
                public final /* synthetic */ ValueAnimator val$animator;
                public final /* synthetic */ View val$v;

                public AnonymousClass3(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat, ValueAnimator valueAnimator) {
                    r1 = view;
                    r2 = windowInsetsAnimationCompat;
                    r3 = boundsCompat;
                    r4 = valueAnimator;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Impl21.dispatchOnStart(r1, r2, r3);
                    r4.start();
                }
            }

            public Impl21OnApplyWindowInsetsListener(View view, InsetsListener insetsListener) {
                WindowInsetsCompat windowInsetsCompat;
                WindowInsetsCompat.BuilderImpl builderImpl20;
                this.mCallback = insetsListener;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                WindowInsetsCompat rootWindowInsets = ViewCompat.Api23Impl.getRootWindowInsets(view);
                if (rootWindowInsets != null) {
                    int r3 = Build.VERSION.SDK_INT;
                    if (r3 >= 30) {
                        builderImpl20 = new WindowInsetsCompat.BuilderImpl30(rootWindowInsets);
                    } else if (r3 >= 29) {
                        builderImpl20 = new WindowInsetsCompat.BuilderImpl29(rootWindowInsets);
                    } else {
                        builderImpl20 = new WindowInsetsCompat.BuilderImpl20(rootWindowInsets);
                    }
                    windowInsetsCompat = builderImpl20.build();
                } else {
                    windowInsetsCompat = null;
                }
                this.mLastInsets = windowInsetsCompat;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                Interpolator interpolator;
                if (!view.isLaidOut()) {
                    this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat(view, windowInsets);
                    return Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(view, windowInsets);
                if (this.mLastInsets == null) {
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    this.mLastInsets = ViewCompat.Api23Impl.getRootWindowInsets(view);
                }
                if (this.mLastInsets == null) {
                    this.mLastInsets = windowInsetsCompat;
                    return Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                Callback callback = Impl21.getCallback(view);
                if (callback != null && Objects.equals(callback.mDispachedInsets, windowInsets)) {
                    return Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat2 = this.mLastInsets;
                int r5 = 0;
                for (int r3 = 1; r3 <= 256; r3 <<= 1) {
                    if (!windowInsetsCompat.getInsets(r3).equals(windowInsetsCompat2.getInsets(r3))) {
                        r5 |= r3;
                    }
                }
                if (r5 == 0) {
                    return Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat3 = this.mLastInsets;
                if ((r5 & 8) != 0) {
                    if (windowInsetsCompat.getInsets(8).bottom > windowInsetsCompat3.getInsets(8).bottom) {
                        interpolator = Impl21.SHOW_IME_INTERPOLATOR;
                    } else {
                        interpolator = Impl21.HIDE_IME_INTERPOLATOR;
                    }
                } else {
                    interpolator = Impl21.DEFAULT_INSET_INTERPOLATOR;
                }
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(r5, interpolator, 160L);
                Impl impl = windowInsetsAnimationCompat.mImpl;
                impl.setFraction(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(impl.getDurationMillis());
                Insets insets = windowInsetsCompat.getInsets(r5);
                Insets insets2 = windowInsetsCompat3.getInsets(r5);
                int min = Math.min(insets.left, insets2.left);
                int r12 = insets.top;
                int r13 = insets2.top;
                int min2 = Math.min(r12, r13);
                int r15 = insets.right;
                int r2 = insets2.right;
                int min3 = Math.min(r15, r2);
                int r11 = insets.bottom;
                int r17 = r5;
                int r52 = insets2.bottom;
                BoundsCompat boundsCompat = new BoundsCompat(Insets.of(min, min2, min3, Math.min(r11, r52)), Insets.of(Math.max(insets.left, insets2.left), Math.max(r12, r13), Math.max(r15, r2), Math.max(r11, r52)));
                Impl21.dispatchOnPrepare(view, windowInsetsAnimationCompat, windowInsets, false);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.1
                    public final /* synthetic */ int val$animationMask;
                    public final /* synthetic */ WindowInsetsCompat val$startingInsets;
                    public final /* synthetic */ WindowInsetsCompat val$targetInsets;
                    public final /* synthetic */ View val$v;

                    public AnonymousClass1(WindowInsetsCompat windowInsetsCompat4, WindowInsetsCompat windowInsetsCompat32, int r172, View view2) {
                        r2 = windowInsetsCompat4;
                        r3 = windowInsetsCompat32;
                        r4 = r172;
                        r5 = view2;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        WindowInsetsCompat.BuilderImpl builderImpl20;
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = WindowInsetsAnimationCompat.this;
                        windowInsetsAnimationCompat2.mImpl.setFraction(animatedFraction);
                        float interpolatedFraction = windowInsetsAnimationCompat2.mImpl.getInterpolatedFraction();
                        PathInterpolator pathInterpolator = Impl21.SHOW_IME_INTERPOLATOR;
                        int r1 = Build.VERSION.SDK_INT;
                        WindowInsetsCompat windowInsetsCompat4 = r2;
                        if (r1 >= 30) {
                            builderImpl20 = new WindowInsetsCompat.BuilderImpl30(windowInsetsCompat4);
                        } else if (r1 >= 29) {
                            builderImpl20 = new WindowInsetsCompat.BuilderImpl29(windowInsetsCompat4);
                        } else {
                            builderImpl20 = new WindowInsetsCompat.BuilderImpl20(windowInsetsCompat4);
                        }
                        for (int r22 = 1; r22 <= 256; r22 <<= 1) {
                            if ((r4 & r22) == 0) {
                                builderImpl20.setInsets(r22, windowInsetsCompat4.getInsets(r22));
                            } else {
                                Insets insets3 = windowInsetsCompat4.getInsets(r22);
                                Insets insets22 = r3.getInsets(r22);
                                float f = 1.0f - interpolatedFraction;
                                builderImpl20.setInsets(r22, WindowInsetsCompat.insetInsets(insets3, (int) (((insets3.left - insets22.left) * f) + 0.5d), (int) (((insets3.top - insets22.top) * f) + 0.5d), (int) (((insets3.right - insets22.right) * f) + 0.5d), (int) (((insets3.bottom - insets22.bottom) * f) + 0.5d)));
                            }
                        }
                        Impl21.dispatchOnProgress(r5, builderImpl20.build(), Collections.singletonList(windowInsetsAnimationCompat2));
                    }
                });
                duration.addListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.2
                    public final /* synthetic */ View val$v;

                    public AnonymousClass2(View view2) {
                        r2 = view2;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = WindowInsetsAnimationCompat.this;
                        windowInsetsAnimationCompat2.mImpl.setFraction(1.0f);
                        Impl21.dispatchOnEnd(r2, windowInsetsAnimationCompat2);
                    }
                });
                OneShotPreDrawListener.add(view2, new Runnable() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.3
                    public final /* synthetic */ WindowInsetsAnimationCompat val$anim;
                    public final /* synthetic */ BoundsCompat val$animationBounds;
                    public final /* synthetic */ ValueAnimator val$animator;
                    public final /* synthetic */ View val$v;

                    public AnonymousClass3(View view2, WindowInsetsAnimationCompat windowInsetsAnimationCompat2, BoundsCompat boundsCompat2, ValueAnimator duration2) {
                        r1 = view2;
                        r2 = windowInsetsAnimationCompat2;
                        r3 = boundsCompat2;
                        r4 = duration2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Impl21.dispatchOnStart(r1, r2, r3);
                        r4.start();
                    }
                });
                this.mLastInsets = windowInsetsCompat4;
                return Impl21.forwardToViewIfNeeded(view2, windowInsets);
            }
        }

        public Impl21(int r1, Interpolator interpolator, long j) {
            super(interpolator, j);
        }

        public static void dispatchOnEnd(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Callback callback = getCallback(view);
            if (callback != null) {
                callback.onEnd(windowInsetsAnimationCompat);
                if (callback.mDispatchMode == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int r0 = 0; r0 < viewGroup.getChildCount(); r0++) {
                    dispatchOnEnd(viewGroup.getChildAt(r0), windowInsetsAnimationCompat);
                }
            }
        }

        public static void dispatchOnPrepare(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean z) {
            Callback callback = getCallback(view);
            if (callback != null) {
                callback.mDispachedInsets = windowInsets;
                if (!z) {
                    callback.onPrepare(windowInsetsAnimationCompat);
                    if (callback.mDispatchMode == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int r1 = 0; r1 < viewGroup.getChildCount(); r1++) {
                    dispatchOnPrepare(viewGroup.getChildAt(r1), windowInsetsAnimationCompat, windowInsets, z);
                }
            }
        }

        public static void dispatchOnProgress(View view, WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
            Callback callback = getCallback(view);
            if (callback != null) {
                windowInsetsCompat = callback.onProgress(windowInsetsCompat, list);
                if (callback.mDispatchMode == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int r0 = 0; r0 < viewGroup.getChildCount(); r0++) {
                    dispatchOnProgress(viewGroup.getChildAt(r0), windowInsetsCompat, list);
                }
            }
        }

        public static void dispatchOnStart(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            Callback callback = getCallback(view);
            if (callback != null) {
                callback.onStart(windowInsetsAnimationCompat, boundsCompat);
                if (callback.mDispatchMode == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int r0 = 0; r0 < viewGroup.getChildCount(); r0++) {
                    dispatchOnStart(viewGroup.getChildAt(r0), windowInsetsAnimationCompat, boundsCompat);
                }
            }
        }

        public static WindowInsets forwardToViewIfNeeded(View view, WindowInsets windowInsets) {
            if (view.getTag(R.id.tag_on_apply_window_listener) != null) {
                return windowInsets;
            }
            return view.onApplyWindowInsets(windowInsets);
        }

        public static Callback getCallback(View view) {
            Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
            if (tag instanceof Impl21OnApplyWindowInsetsListener) {
                return ((Impl21OnApplyWindowInsetsListener) tag).mCallback;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class Impl30 extends Impl {
        public final WindowInsetsAnimation mWrapped;

        /* loaded from: classes.dex */
        public static class ProxyCallback extends WindowInsetsAnimation$Callback {
            public final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> mAnimations;
            public final Callback mCompat;
            public List<WindowInsetsAnimationCompat> mRORunningAnimations;
            public ArrayList<WindowInsetsAnimationCompat> mTmpRunningAnimations;

            public ProxyCallback(InsetsListener insetsListener) {
                super(insetsListener.mDispatchMode);
                this.mAnimations = new HashMap<>();
                this.mCompat = insetsListener;
            }

            public final WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.mAnimations.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat == null) {
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = new WindowInsetsAnimationCompat(windowInsetsAnimation);
                    this.mAnimations.put(windowInsetsAnimation, windowInsetsAnimationCompat2);
                    return windowInsetsAnimationCompat2;
                }
                return windowInsetsAnimationCompat;
            }

            public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.mCompat.onEnd(getWindowInsetsAnimationCompat(windowInsetsAnimation));
                this.mAnimations.remove(windowInsetsAnimation);
            }

            public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.mCompat.onPrepare(getWindowInsetsAnimationCompat(windowInsetsAnimation));
            }

            public final WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
                float fraction;
                ArrayList<WindowInsetsAnimationCompat> arrayList = this.mTmpRunningAnimations;
                if (arrayList == null) {
                    ArrayList<WindowInsetsAnimationCompat> arrayList2 = new ArrayList<>(list.size());
                    this.mTmpRunningAnimations = arrayList2;
                    this.mRORunningAnimations = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                int size = list.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        WindowInsetsAnimation m = WindowInsetsAnimationCompat$Impl30$ProxyCallback$$ExternalSyntheticApiModelOutline0.m(list.get(size));
                        WindowInsetsAnimationCompat windowInsetsAnimationCompat = getWindowInsetsAnimationCompat(m);
                        fraction = m.getFraction();
                        windowInsetsAnimationCompat.mImpl.setFraction(fraction);
                        this.mTmpRunningAnimations.add(windowInsetsAnimationCompat);
                    } else {
                        return this.mCompat.onProgress(WindowInsetsCompat.toWindowInsetsCompat(null, windowInsets), this.mRORunningAnimations).toWindowInsets();
                    }
                }
            }

            public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                BoundsCompat onStart = this.mCompat.onStart(getWindowInsetsAnimationCompat(windowInsetsAnimation), new BoundsCompat(bounds));
                onStart.getClass();
                WindowInsetsAnimationCompat$Impl30$$ExternalSyntheticApiModelOutline6.m();
                return WindowInsetsAnimationCompat$Impl30$$ExternalSyntheticApiModelOutline5.m(onStart.mLowerBound.toPlatformInsets(), onStart.mUpperBound.toPlatformInsets());
            }
        }

        public Impl30(WindowInsetsAnimation windowInsetsAnimation) {
            super(null, 0L);
            this.mWrapped = windowInsetsAnimation;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final long getDurationMillis() {
            long durationMillis;
            durationMillis = this.mWrapped.getDurationMillis();
            return durationMillis;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final float getInterpolatedFraction() {
            float interpolatedFraction;
            interpolatedFraction = this.mWrapped.getInterpolatedFraction();
            return interpolatedFraction;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final void setFraction(float f) {
            this.mWrapped.setFraction(f);
        }
    }

    public WindowInsetsAnimationCompat(int r3, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(WindowInsetsAnimationCompat$Impl30$$ExternalSyntheticApiModelOutline4.m(r3, interpolator, j));
        } else {
            this.mImpl = new Impl21(r3, interpolator, j);
        }
    }

    /* loaded from: classes.dex */
    public static final class BoundsCompat {
        public final Insets mLowerBound;
        public final Insets mUpperBound;

        public BoundsCompat(Insets insets, Insets insets2) {
            this.mLowerBound = insets;
            this.mUpperBound = insets2;
        }

        public final String toString() {
            return "Bounds{lower=" + this.mLowerBound + " upper=" + this.mUpperBound + "}";
        }

        public BoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            android.graphics.Insets lowerBound;
            android.graphics.Insets upperBound;
            lowerBound = bounds.getLowerBound();
            this.mLowerBound = Insets.toCompatInsets(lowerBound);
            upperBound = bounds.getUpperBound();
            this.mUpperBound = Insets.toCompatInsets(upperBound);
        }
    }

    public WindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(windowInsetsAnimation);
        }
    }
}
