package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowInsets.android.kt */
/* loaded from: classes.dex */
public final class InsetsListener extends WindowInsetsAnimationCompat.Callback implements Runnable, OnApplyWindowInsetsListener, View.OnAttachStateChangeListener {
    public final WindowInsetsHolder composeInsets;
    public boolean prepared;
    public boolean runningAnimation;
    public WindowInsetsCompat savedInsets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InsetsListener(WindowInsetsHolder composeInsets) {
        super(!composeInsets.consumes ? 1 : 0);
        Intrinsics.checkNotNullParameter(composeInsets, "composeInsets");
        this.composeInsets = composeInsets;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.savedInsets = windowInsetsCompat;
        WindowInsetsHolder windowInsetsHolder = this.composeInsets;
        windowInsetsHolder.getClass();
        Insets insets = windowInsetsCompat.getInsets(8);
        Intrinsics.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…wInsetsCompat.Type.ime())");
        windowInsetsHolder.imeAnimationTarget.value$delegate.setValue(WindowInsets_androidKt.toInsetsValues(insets));
        if (this.prepared) {
            if (Build.VERSION.SDK_INT == 30) {
                view.post(this);
            }
        } else if (!this.runningAnimation) {
            windowInsetsHolder.updateImeAnimationSource(windowInsetsCompat);
            WindowInsetsHolder.update$default(windowInsetsHolder, windowInsetsCompat);
        }
        if (windowInsetsHolder.consumes) {
            WindowInsetsCompat CONSUMED = WindowInsetsCompat.CONSUMED;
            Intrinsics.checkNotNullExpressionValue(CONSUMED, "CONSUMED");
            return CONSUMED;
        }
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onEnd(WindowInsetsAnimationCompat animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.prepared = false;
        this.runningAnimation = false;
        WindowInsetsCompat windowInsetsCompat = this.savedInsets;
        if (animation.mImpl.getDurationMillis() != 0 && windowInsetsCompat != null) {
            WindowInsetsHolder windowInsetsHolder = this.composeInsets;
            windowInsetsHolder.updateImeAnimationSource(windowInsetsCompat);
            Insets insets = windowInsetsCompat.getInsets(8);
            Intrinsics.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…wInsetsCompat.Type.ime())");
            windowInsetsHolder.imeAnimationTarget.value$delegate.setValue(WindowInsets_androidKt.toInsetsValues(insets));
            WindowInsetsHolder.update$default(windowInsetsHolder, windowInsetsCompat);
        }
        this.savedInsets = null;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.prepared = true;
        this.runningAnimation = true;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
        WindowInsetsHolder windowInsetsHolder = this.composeInsets;
        WindowInsetsHolder.update$default(windowInsetsHolder, insets);
        if (windowInsetsHolder.consumes) {
            WindowInsetsCompat CONSUMED = WindowInsetsCompat.CONSUMED;
            Intrinsics.checkNotNullExpressionValue(CONSUMED, "CONSUMED");
            return CONSUMED;
        }
        return insets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.prepared = false;
        return bounds;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.requestApplyInsets();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.prepared) {
            this.prepared = false;
            this.runningAnimation = false;
            WindowInsetsCompat windowInsetsCompat = this.savedInsets;
            if (windowInsetsCompat != null) {
                WindowInsetsHolder windowInsetsHolder = this.composeInsets;
                windowInsetsHolder.updateImeAnimationSource(windowInsetsCompat);
                WindowInsetsHolder.update$default(windowInsetsHolder, windowInsetsCompat);
                this.savedInsets = null;
            }
        }
    }
}
