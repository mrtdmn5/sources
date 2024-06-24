package com.animaconnected.secondo.screens.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.widget.compose.ComponentsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposeOnboardingFragment.kt */
/* loaded from: classes3.dex */
public abstract class ComposeOnboardingFragment extends BaseOnboardingFragment {
    public static final int $stable = 0;

    public abstract void ComposeContent(Composer composer, int r2);

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment$onCreateView$1$1, kotlin.jvm.internal.Lambda] */
    @Override // androidx.fragment.app.Fragment
    public ComposeView onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        ComposeView composeView = new ComposeView(requireContext, null, 6);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1021463307, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment$onCreateView$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r3v3, types: [com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment$onCreateView$1$1$1, kotlin.jvm.internal.Lambda] */
            public final void invoke(Composer composer, int r3) {
                if ((r3 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                final ComposeOnboardingFragment composeOnboardingFragment = ComposeOnboardingFragment.this;
                ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, -1871394790, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment$onCreateView$1$1.1
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
                            ComposeOnboardingFragment.this.ComposeContent(composer2, 0);
                        }
                    }
                }), composer, 6);
            }
        }, true));
        return composeView;
    }
}
