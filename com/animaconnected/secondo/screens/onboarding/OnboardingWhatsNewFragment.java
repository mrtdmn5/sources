package com.animaconnected.secondo.screens.onboarding;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingWhatsNewFragment.kt */
/* loaded from: classes3.dex */
public final class OnboardingWhatsNewFragment extends ComposeOnboardingFragment {
    private boolean isBackAllowed;
    private final String name = "OnboardingWhatsNewFragment";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: OnboardingWhatsNewFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OnboardingWhatsNewFragment newInstance() {
            return new OnboardingWhatsNewFragment();
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment
    public void ComposeContent(Composer composer, final int r5) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1905725158);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        OnboardingWhatsNewFragmentKt.WhatsNewScreen(WhatsNewStorage.INSTANCE.getFeatures(), new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWhatsNewFragment$ComposeContent$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                OnboardingWhatsNewFragment.this.getOnboarding().setWhatsNewDone();
            }
        }, startRestartGroup, 8);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWhatsNewFragment$ComposeContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r3) {
                    OnboardingWhatsNewFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment, com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean handlesState(Onboarding.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == Onboarding.State.WHATSNEW) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean isBackAllowed() {
        return this.isBackAllowed;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public void setBackAllowed(boolean z) {
        this.isBackAllowed = z;
    }
}
