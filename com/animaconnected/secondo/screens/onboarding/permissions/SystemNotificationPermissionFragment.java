package com.animaconnected.secondo.screens.onboarding.permissions;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.onboarding.OnboardingPermissionFragment;
import com.animaconnected.secondo.screens.onboarding.PermissionState;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: SystemNotificationPermissionFragment.kt */
/* loaded from: classes3.dex */
public final class SystemNotificationPermissionFragment extends OnboardingPermissionFragment {
    private final String name = "SystemNotificationPermissionFragment";
    private final List<String> permissions = SystemNotificationPermissionFragmentKt.getSystemNotificationPermission();
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: SystemNotificationPermissionFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SystemNotificationPermissionFragment newInstance() {
            return new SystemNotificationPermissionFragment();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment
    public void ComposeContent(Composer composer, final int r7) {
        boolean areEqual;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1482492694);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        PermissionState permissionState = (PermissionState) Platform.collectAsState(getPermissionState(), PermissionState.Idle.INSTANCE, null, startRestartGroup, 2).getValue();
        if (Intrinsics.areEqual(permissionState, PermissionState.Denied.INSTANCE)) {
            areEqual = true;
        } else {
            areEqual = Intrinsics.areEqual(permissionState, PermissionState.Granted.INSTANCE);
        }
        if (areEqual) {
            Onboarding.setHandled$default(getOnboarding(), Onboarding.State.SYSTEM_NOTIFICATION_PERMISSION, false, 2, null);
            getOnboarding().updateState();
        }
        SystemNotificationPermissionFragmentKt.SystemNotificationPermissionContent(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragment$ComposeContent$1
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
                SystemNotificationPermissionFragment.this.requestPermissionOrGoToSettings();
            }
        }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragment$ComposeContent$2
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
                MutableStateFlow<PermissionState> permissionState2 = SystemNotificationPermissionFragment.this.getPermissionState();
                do {
                } while (!permissionState2.compareAndSet(permissionState2.getValue(), PermissionState.Denied.INSTANCE));
            }
        }, startRestartGroup, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragment$ComposeContent$3
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
                    SystemNotificationPermissionFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r7 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.OnboardingPermissionFragment, com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment, com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.OnboardingPermissionFragment
    public List<String> getPermissions() {
        return this.permissions;
    }
}
