package com.animaconnected.secondo.screens;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentComposeBinding;
import com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt;
import com.animaconnected.secondo.widget.compose.ComponentsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposeFragment.kt */
/* loaded from: classes3.dex */
public abstract class ComposeFragment extends BaseFragment {
    public static final int $stable = 8;
    private FragmentComposeBinding binding;
    private Rect cardBounds = new Rect(0, 0, 0, 0);
    private boolean shouldReveal;

    public abstract void ComposeContent(Composer composer, int r2);

    public final FragmentComposeBinding getBinding() {
        FragmentComposeBinding fragmentComposeBinding = this.binding;
        if (fragmentComposeBinding != null) {
            return fragmentComposeBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public final Rect getCardBounds() {
        return this.cardBounds;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cardBounds.left = arguments.getInt(AnimationFactoryKotlinKt.LEFT, 0);
            this.cardBounds.top = arguments.getInt(AnimationFactoryKotlinKt.TOP, 0);
            this.cardBounds.right = arguments.getInt(AnimationFactoryKotlinKt.RIGHT, 0);
            this.cardBounds.bottom = arguments.getInt(AnimationFactoryKotlinKt.BOTTOM, 0);
            this.shouldReveal = arguments.getBoolean(AnimationFactoryKotlinKt.SHOULD_REVEAL, false);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.animaconnected.secondo.screens.ComposeFragment$onCreateView$1$1, kotlin.jvm.internal.Lambda] */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentComposeBinding inflate = FragmentComposeBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.composeView.setContent(ComposableLambdaKt.composableLambdaInstance(2054744872, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.ComposeFragment$onCreateView$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r3v3, types: [com.animaconnected.secondo.screens.ComposeFragment$onCreateView$1$1$1, kotlin.jvm.internal.Lambda] */
            public final void invoke(Composer composer, int r3) {
                if ((r3 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                final ComposeFragment composeFragment = ComposeFragment.this;
                ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, -1823121417, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.ComposeFragment$onCreateView$1$1.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r32) {
                        if ((r32 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                            ComposeFragment.this.ComposeContent(composer2, 8);
                        }
                    }
                }), composer, 6);
            }
        }, true));
        this.binding = inflate;
        if (this.shouldReveal) {
            FrameLayout root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            View viewAnimContainer = getBinding().viewAnimContainer;
            Intrinsics.checkNotNullExpressionValue(viewAnimContainer, "viewAnimContainer");
            AnimationFactoryKotlinKt.enterCardRevealAnim(this, root, viewAnimContainer, this.cardBounds);
        }
        this.shouldReveal = false;
        FrameLayout root2 = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        return root2;
    }
}
