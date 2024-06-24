package androidx.compose.foundation.layout;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.WeakHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowInsets.android.kt */
/* loaded from: classes.dex */
public final class WindowInsets_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean isImeVisible(Composer composer) {
        final WindowInsetsHolder windowInsetsHolder;
        composer.startReplaceableGroup(-1873571424);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        WeakHashMap<View, WindowInsetsHolder> weakHashMap = WindowInsetsHolder.viewMap;
        composer.startReplaceableGroup(-1366542614);
        final View view = (View) composer.consume(AndroidCompositionLocals_androidKt.LocalView);
        WeakHashMap<View, WindowInsetsHolder> weakHashMap2 = WindowInsetsHolder.viewMap;
        synchronized (weakHashMap2) {
            WindowInsetsHolder windowInsetsHolder2 = weakHashMap2.get(view);
            if (windowInsetsHolder2 == null) {
                windowInsetsHolder2 = new WindowInsetsHolder(view);
                weakHashMap2.put(view, windowInsetsHolder2);
            }
            windowInsetsHolder = windowInsetsHolder2;
        }
        EffectsKt.DisposableEffect(windowInsetsHolder, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.layout.WindowInsetsHolder$Companion$current$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                DisposableEffectScope DisposableEffect = disposableEffectScope;
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final WindowInsetsHolder windowInsetsHolder3 = WindowInsetsHolder.this;
                windowInsetsHolder3.getClass();
                final View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "view");
                if (windowInsetsHolder3.accessCount == 0) {
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
                    InsetsListener insetsListener = windowInsetsHolder3.insetsListener;
                    ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(view2, insetsListener);
                    if (view2.isAttachedToWindow()) {
                        view2.requestApplyInsets();
                    }
                    view2.addOnAttachStateChangeListener(insetsListener);
                    ViewCompat.setWindowInsetsAnimationCallback(view2, insetsListener);
                }
                windowInsetsHolder3.accessCount++;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.layout.WindowInsetsHolder$Companion$current$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public final void dispose() {
                        WindowInsetsHolder windowInsetsHolder4 = WindowInsetsHolder.this;
                        windowInsetsHolder4.getClass();
                        View view3 = view2;
                        Intrinsics.checkNotNullParameter(view3, "view");
                        int r2 = windowInsetsHolder4.accessCount - 1;
                        windowInsetsHolder4.accessCount = r2;
                        if (r2 == 0) {
                            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap4 = ViewCompat.sViewPropertyAnimatorMap;
                            ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(view3, null);
                            ViewCompat.setWindowInsetsAnimationCallback(view3, null);
                            view3.removeOnAttachStateChangeListener(windowInsetsHolder4.insetsListener);
                        }
                    }
                };
            }
        }, composer);
        composer.endReplaceableGroup();
        boolean booleanValue = ((Boolean) windowInsetsHolder.ime.isVisible$delegate.getValue()).booleanValue();
        composer.endReplaceableGroup();
        return booleanValue;
    }

    public static final InsetsValues toInsetsValues(Insets insets) {
        return new InsetsValues(insets.left, insets.top, insets.right, insets.bottom);
    }
}
