package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.kronaby.watch.app.R;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    public static final LottieAnimationView$$ExternalSyntheticLambda2 DEFAULT_FAILURE_LISTENER = new LottieAnimationView$$ExternalSyntheticLambda2();
    public String animationName;
    public int animationResId;
    public boolean autoPlay;
    public boolean cacheComposition;
    public LottieComposition composition;
    public LottieTask<LottieComposition> compositionTask;
    public LottieListener<Throwable> failureListener;
    public int fallbackResource;
    public boolean ignoreUnschedule;
    public final LottieListener<LottieComposition> loadedListener;
    public final LottieDrawable lottieDrawable;
    public final HashSet lottieOnCompositionLoadedListeners;
    public final HashSet userActionsTaken;
    public final AnonymousClass1 wrappedFailureListener;

    /* renamed from: com.airbnb.lottie.LottieAnimationView$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements LottieListener<Throwable> {
        public AnonymousClass1() {
        }

        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(Throwable th) {
            Throwable th2 = th;
            LottieAnimationView lottieAnimationView = LottieAnimationView.this;
            int r1 = lottieAnimationView.fallbackResource;
            if (r1 != 0) {
                lottieAnimationView.setImageResource(r1);
            }
            LottieListener lottieListener = lottieAnimationView.failureListener;
            if (lottieListener == null) {
                lottieListener = LottieAnimationView.DEFAULT_FAILURE_LISTENER;
            }
            lottieListener.onResult(th2);
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        public String animationName;
        public int animationResId;
        public String imageAssetsFolder;
        public boolean isAnimating;
        public float progress;
        public int repeatCount;
        public int repeatMode;

        /* renamed from: com.airbnb.lottie.LottieAnimationView$SavedState$1 */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r1) {
                return new SavedState[r1];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() == 1;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int r2) {
            super.writeToParcel(parcel, r2);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }

    /* loaded from: classes.dex */
    public enum UserActionTaken {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.loadedListener = new LottieListener() { // from class: com.airbnb.lottie.LottieAnimationView$$ExternalSyntheticLambda1
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.wrappedFailureListener = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            public AnonymousClass1() {
            }

            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Throwable th) {
                Throwable th2 = th;
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                int r1 = lottieAnimationView.fallbackResource;
                if (r1 != 0) {
                    lottieAnimationView.setImageResource(r1);
                }
                LottieListener lottieListener = lottieAnimationView.failureListener;
                if (lottieListener == null) {
                    lottieListener = LottieAnimationView.DEFAULT_FAILURE_LISTENER;
                }
                lottieListener.onResult(th2);
            }
        };
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(null);
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        this.userActionsTaken.add(UserActionTaken.SET_ANIMATION);
        this.composition = null;
        this.lottieDrawable.clearComposition();
        cancelLoaderTask();
        lottieTask.addListener(this.loadedListener);
        lottieTask.addFailureListener(this.wrappedFailureListener);
        this.compositionTask = lottieTask;
    }

    public final void cancelAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        LottieDrawable lottieDrawable = this.lottieDrawable;
        lottieDrawable.lazyCompositionTasks.clear();
        lottieDrawable.animator.cancel();
        if (!lottieDrawable.isVisible()) {
            lottieDrawable.onVisibleAction = LottieDrawable.OnVisibleAction.NONE;
        }
    }

    public final void cancelLoaderTask() {
        LottieTask<LottieComposition> lottieTask = this.compositionTask;
        if (lottieTask != null) {
            LottieListener<LottieComposition> lottieListener = this.loadedListener;
            synchronized (lottieTask) {
                lottieTask.successListeners.remove(lottieListener);
            }
            LottieTask<LottieComposition> lottieTask2 = this.compositionTask;
            AnonymousClass1 anonymousClass1 = this.wrappedFailureListener;
            synchronized (lottieTask2) {
                lottieTask2.failureListeners.remove(anonymousClass1);
            }
        }
    }

    public boolean getClipToCompositionBounds() {
        return this.lottieDrawable.clipToCompositionBounds;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public long getDuration() {
        if (this.composition != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    public int getFrame() {
        return (int) this.lottieDrawable.animator.frame;
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.imageAssetsFolder;
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.lottieDrawable.maintainOriginalImageBounds;
    }

    public float getMaxFrame() {
        return this.lottieDrawable.animator.getMaxFrame();
    }

    public float getMinFrame() {
        return this.lottieDrawable.animator.getMinFrame();
    }

    public PerformanceTracker getPerformanceTracker() {
        LottieComposition lottieComposition = this.lottieDrawable.composition;
        if (lottieComposition != null) {
            return lottieComposition.performanceTracker;
        }
        return null;
    }

    public float getProgress() {
        LottieValueAnimator lottieValueAnimator = this.lottieDrawable.animator;
        LottieComposition lottieComposition = lottieValueAnimator.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = lottieValueAnimator.frame;
        float f2 = lottieComposition.startFrame;
        return (f - f2) / (lottieComposition.endFrame - f2);
    }

    public RenderMode getRenderMode() {
        if (this.lottieDrawable.useSoftwareRendering) {
            return RenderMode.SOFTWARE;
        }
        return RenderMode.HARDWARE;
    }

    public int getRepeatCount() {
        return this.lottieDrawable.animator.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.animator.getRepeatMode();
    }

    public float getSpeed() {
        return this.lottieDrawable.animator.speed;
    }

    public final void init(AttributeSet attributeSet) {
        String string;
        boolean z = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.LottieAnimationView, R.attr.lottieAnimationViewStyle, 0);
        this.cacheComposition = obtainStyledAttributes.getBoolean(1, true);
        boolean hasValue = obtainStyledAttributes.hasValue(11);
        boolean hasValue2 = obtainStyledAttributes.hasValue(6);
        boolean hasValue3 = obtainStyledAttributes.hasValue(16);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(11, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(6);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(16)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(5, 0));
        if (obtainStyledAttributes.getBoolean(0, false)) {
            this.autoPlay = true;
        }
        boolean z2 = obtainStyledAttributes.getBoolean(9, false);
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (z2) {
            lottieDrawable.animator.setRepeatCount(-1);
        }
        if (obtainStyledAttributes.hasValue(14)) {
            setRepeatMode(obtainStyledAttributes.getInt(14, 1));
        }
        if (obtainStyledAttributes.hasValue(13)) {
            setRepeatCount(obtainStyledAttributes.getInt(13, -1));
        }
        if (obtainStyledAttributes.hasValue(15)) {
            setSpeed(obtainStyledAttributes.getFloat(15, 1.0f));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            setClipToCompositionBounds(obtainStyledAttributes.getBoolean(2, true));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(8));
        setProgress(obtainStyledAttributes.getFloat(10, 0.0f));
        boolean z3 = obtainStyledAttributes.getBoolean(4, false);
        if (lottieDrawable.enableMergePaths != z3) {
            lottieDrawable.enableMergePaths = z3;
            if (lottieDrawable.composition != null) {
                lottieDrawable.buildCompositionLayer();
            }
        }
        if (obtainStyledAttributes.hasValue(3)) {
            lottieDrawable.addValueCallback(new KeyPath("**"), LottieProperty.COLOR_FILTER, new LottieValueCallback(new SimpleColorFilter(AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(3, -1)).getDefaultColor())));
        }
        if (obtainStyledAttributes.hasValue(12)) {
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int r1 = obtainStyledAttributes.getInt(12, renderMode.ordinal());
            if (r1 >= RenderMode.values().length) {
                r1 = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[r1]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(7, false));
        obtainStyledAttributes.recycle();
        Context context = getContext();
        Utils.AnonymousClass1 anonymousClass1 = Utils.threadLocalPathMeasure;
        if (Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f) {
            z = true;
        }
        lottieDrawable.systemAnimationsEnabled = Boolean.valueOf(z).booleanValue();
    }

    @Override // android.view.View
    public final void invalidate() {
        RenderMode renderMode;
        super.invalidate();
        Drawable drawable = getDrawable();
        if (drawable instanceof LottieDrawable) {
            if (((LottieDrawable) drawable).useSoftwareRendering) {
                renderMode = RenderMode.SOFTWARE;
            } else {
                renderMode = RenderMode.HARDWARE;
            }
            if (renderMode == RenderMode.SOFTWARE) {
                this.lottieDrawable.invalidateSelf();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.autoPlay) {
            this.lottieDrawable.playAnimation();
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        int r0;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.animationName = savedState.animationName;
        UserActionTaken userActionTaken = UserActionTaken.SET_ANIMATION;
        HashSet hashSet = this.userActionsTaken;
        if (!hashSet.contains(userActionTaken) && !TextUtils.isEmpty(this.animationName)) {
            setAnimation(this.animationName);
        }
        this.animationResId = savedState.animationResId;
        if (!hashSet.contains(userActionTaken) && (r0 = this.animationResId) != 0) {
            setAnimation(r0);
        }
        if (!hashSet.contains(UserActionTaken.SET_PROGRESS)) {
            setProgress(savedState.progress);
        }
        if (!hashSet.contains(UserActionTaken.PLAY_OPTION) && savedState.isAnimating) {
            playAnimation();
        }
        if (!hashSet.contains(UserActionTaken.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.imageAssetsFolder);
        }
        if (!hashSet.contains(UserActionTaken.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.repeatMode);
        }
        if (!hashSet.contains(UserActionTaken.SET_REPEAT_COUNT)) {
            setRepeatCount(savedState.repeatCount);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        float f;
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.animationName;
        savedState.animationResId = this.animationResId;
        LottieDrawable lottieDrawable = this.lottieDrawable;
        LottieValueAnimator lottieValueAnimator = lottieDrawable.animator;
        LottieComposition lottieComposition = lottieValueAnimator.composition;
        if (lottieComposition == null) {
            f = 0.0f;
        } else {
            float f2 = lottieValueAnimator.frame;
            float f3 = lottieComposition.startFrame;
            f = (f2 - f3) / (lottieComposition.endFrame - f3);
        }
        savedState.progress = f;
        boolean isVisible = lottieDrawable.isVisible();
        LottieValueAnimator lottieValueAnimator2 = lottieDrawable.animator;
        if (isVisible) {
            z = lottieValueAnimator2.running;
        } else {
            LottieDrawable.OnVisibleAction onVisibleAction = lottieDrawable.onVisibleAction;
            if (onVisibleAction != LottieDrawable.OnVisibleAction.PLAY && onVisibleAction != LottieDrawable.OnVisibleAction.RESUME) {
                z = false;
            } else {
                z = true;
            }
        }
        savedState.isAnimating = z;
        savedState.imageAssetsFolder = lottieDrawable.imageAssetsFolder;
        savedState.repeatMode = lottieValueAnimator2.getRepeatMode();
        savedState.repeatCount = lottieValueAnimator2.getRepeatCount();
        return savedState;
    }

    public final void playAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.lottieDrawable.playAnimation();
    }

    public void setAnimation(final int r3) {
        LottieTask<LottieComposition> fromRawRes;
        LottieTask<LottieComposition> lottieTask;
        this.animationResId = r3;
        this.animationName = null;
        if (isInEditMode()) {
            lottieTask = new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.LottieAnimationView$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    boolean z = lottieAnimationView.cacheComposition;
                    int r2 = r3;
                    if (z) {
                        Context context = lottieAnimationView.getContext();
                        return LottieCompositionFactory.fromRawResSync(r2, context, LottieCompositionFactory.rawResCacheKey(context, r2));
                    }
                    return LottieCompositionFactory.fromRawResSync(r2, lottieAnimationView.getContext(), null);
                }
            }, true);
        } else {
            if (this.cacheComposition) {
                Context context = getContext();
                fromRawRes = LottieCompositionFactory.fromRawRes(r3, context, LottieCompositionFactory.rawResCacheKey(context, r3));
            } else {
                fromRawRes = LottieCompositionFactory.fromRawRes(r3, getContext(), null);
            }
            lottieTask = fromRawRes;
        }
        setCompositionTask(lottieTask);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setCompositionTask(LottieCompositionFactory.cache(null, new LottieCompositionFactory$$ExternalSyntheticLambda2(new ByteArrayInputStream(str.getBytes()), 0, null)));
    }

    public void setAnimationFromUrl(String str) {
        LottieTask<LottieComposition> cache;
        if (this.cacheComposition) {
            Context context = getContext();
            HashMap hashMap = LottieCompositionFactory.taskCache;
            String m = ConstraintSet$$ExternalSyntheticOutline0.m("url_", str);
            cache = LottieCompositionFactory.cache(m, new LottieCompositionFactory$$ExternalSyntheticLambda0(context, str, m));
        } else {
            cache = LottieCompositionFactory.cache(null, new LottieCompositionFactory$$ExternalSyntheticLambda0(getContext(), str, null));
        }
        setCompositionTask(cache);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.lottieDrawable.isApplyingOpacityToLayersEnabled = z;
    }

    public void setCacheComposition(boolean z) {
        this.cacheComposition = z;
    }

    public void setClipToCompositionBounds(boolean z) {
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (z != lottieDrawable.clipToCompositionBounds) {
            lottieDrawable.clipToCompositionBounds = z;
            CompositionLayer compositionLayer = lottieDrawable.compositionLayer;
            if (compositionLayer != null) {
                compositionLayer.clipToCompositionBounds = z;
            }
            lottieDrawable.invalidateSelf();
        }
    }

    public void setComposition(LottieComposition lottieComposition) {
        LottieDrawable lottieDrawable = this.lottieDrawable;
        lottieDrawable.setCallback(this);
        this.composition = lottieComposition;
        this.ignoreUnschedule = true;
        boolean composition = lottieDrawable.setComposition(lottieComposition);
        boolean z = false;
        this.ignoreUnschedule = false;
        if (getDrawable() == lottieDrawable && !composition) {
            return;
        }
        if (!composition) {
            LottieValueAnimator lottieValueAnimator = lottieDrawable.animator;
            if (lottieValueAnimator != null) {
                z = lottieValueAnimator.running;
            }
            setImageDrawable(null);
            setImageDrawable(lottieDrawable);
            if (z) {
                lottieDrawable.resumeAnimation();
            }
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        Iterator it = this.lottieOnCompositionLoadedListeners.iterator();
        while (it.hasNext()) {
            ((LottieOnCompositionLoadedListener) it.next()).onCompositionLoaded();
        }
    }

    public void setFailureListener(LottieListener<Throwable> lottieListener) {
        this.failureListener = lottieListener;
    }

    public void setFallbackResource(int r1) {
        this.fallbackResource = r1;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        FontAssetManager fontAssetManager = this.lottieDrawable.fontAssetManager;
    }

    public void setFrame(int r2) {
        this.lottieDrawable.setFrame(r2);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.lottieDrawable.ignoreSystemAnimationsDisabled = z;
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        ImageAssetManager imageAssetManager = this.lottieDrawable.imageAssetManager;
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.imageAssetsFolder = str;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r1) {
        cancelLoaderTask();
        super.setImageResource(r1);
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.lottieDrawable.maintainOriginalImageBounds = z;
    }

    public void setMaxFrame(int r2) {
        this.lottieDrawable.setMaxFrame(r2);
    }

    public void setMaxProgress(float f) {
        this.lottieDrawable.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.lottieDrawable.setMinAndMaxFrame(str);
    }

    public void setMinFrame(int r2) {
        this.lottieDrawable.setMinFrame(r2);
    }

    public void setMinProgress(float f) {
        this.lottieDrawable.setMinProgress(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (lottieDrawable.outlineMasksAndMattes != z) {
            lottieDrawable.outlineMasksAndMattes = z;
            CompositionLayer compositionLayer = lottieDrawable.compositionLayer;
            if (compositionLayer != null) {
                compositionLayer.setOutlineMasksAndMattes(z);
            }
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        LottieDrawable lottieDrawable = this.lottieDrawable;
        lottieDrawable.performanceTrackingEnabled = z;
        LottieComposition lottieComposition = lottieDrawable.composition;
        if (lottieComposition != null) {
            lottieComposition.performanceTracker.enabled = z;
        }
    }

    public void setProgress(float f) {
        this.userActionsTaken.add(UserActionTaken.SET_PROGRESS);
        this.lottieDrawable.setProgress(f);
    }

    public void setRenderMode(RenderMode renderMode) {
        LottieDrawable lottieDrawable = this.lottieDrawable;
        lottieDrawable.renderMode = renderMode;
        lottieDrawable.computeRenderMode();
    }

    public void setRepeatCount(int r3) {
        this.userActionsTaken.add(UserActionTaken.SET_REPEAT_COUNT);
        this.lottieDrawable.animator.setRepeatCount(r3);
    }

    public void setRepeatMode(int r3) {
        this.userActionsTaken.add(UserActionTaken.SET_REPEAT_MODE);
        this.lottieDrawable.animator.setRepeatMode(r3);
    }

    public void setSafeMode(boolean z) {
        this.lottieDrawable.safeMode = z;
    }

    public void setSpeed(float f) {
        this.lottieDrawable.animator.speed = f;
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.lottieDrawable.getClass();
    }

    @Override // android.view.View
    public final void unscheduleDrawable(Drawable drawable) {
        LottieDrawable lottieDrawable;
        boolean z;
        boolean z2 = this.ignoreUnschedule;
        boolean z3 = false;
        if (!z2 && drawable == (lottieDrawable = this.lottieDrawable)) {
            LottieValueAnimator lottieValueAnimator = lottieDrawable.animator;
            if (lottieValueAnimator == null) {
                z = false;
            } else {
                z = lottieValueAnimator.running;
            }
            if (z) {
                this.autoPlay = false;
                lottieDrawable.pauseAnimation();
                super.unscheduleDrawable(drawable);
            }
        }
        if (!z2 && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable2 = (LottieDrawable) drawable;
            LottieValueAnimator lottieValueAnimator2 = lottieDrawable2.animator;
            if (lottieValueAnimator2 != null) {
                z3 = lottieValueAnimator2.running;
            }
            if (z3) {
                lottieDrawable2.pauseAnimation();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void setMaxFrame(String str) {
        this.lottieDrawable.setMaxFrame(str);
    }

    public void setMinFrame(String str) {
        this.lottieDrawable.setMinFrame(str);
    }

    public void setAnimation(final String str) {
        LottieTask<LottieComposition> cache;
        LottieTask<LottieComposition> lottieTask;
        this.animationName = str;
        this.animationResId = 0;
        if (isInEditMode()) {
            lottieTask = new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.LottieAnimationView$$ExternalSyntheticLambda3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    boolean z = lottieAnimationView.cacheComposition;
                    String str2 = str;
                    if (z) {
                        Context context = lottieAnimationView.getContext();
                        HashMap hashMap = LottieCompositionFactory.taskCache;
                        return LottieCompositionFactory.fromAssetSync(context, str2, "asset_" + str2);
                    }
                    return LottieCompositionFactory.fromAssetSync(lottieAnimationView.getContext(), str2, null);
                }
            }, true);
        } else {
            if (this.cacheComposition) {
                cache = LottieCompositionFactory.fromAsset(getContext(), str);
            } else {
                Context context = getContext();
                HashMap hashMap = LottieCompositionFactory.taskCache;
                cache = LottieCompositionFactory.cache(null, new LottieCompositionFactory$$ExternalSyntheticLambda3(context.getApplicationContext(), str, null));
            }
            lottieTask = cache;
        }
        setCompositionTask(lottieTask);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loadedListener = new LottieListener() { // from class: com.airbnb.lottie.LottieAnimationView$$ExternalSyntheticLambda1
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.wrappedFailureListener = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            public AnonymousClass1() {
            }

            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Throwable th) {
                Throwable th2 = th;
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                int r1 = lottieAnimationView.fallbackResource;
                if (r1 != 0) {
                    lottieAnimationView.setImageResource(r1);
                }
                LottieListener lottieListener = lottieAnimationView.failureListener;
                if (lottieListener == null) {
                    lottieListener = LottieAnimationView.DEFAULT_FAILURE_LISTENER;
                }
                lottieListener.onResult(th2);
            }
        };
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(attributeSet);
    }
}
