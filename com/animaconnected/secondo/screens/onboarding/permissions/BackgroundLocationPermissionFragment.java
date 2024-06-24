package com.animaconnected.secondo.screens.onboarding.permissions;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
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
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: BackgroundLocationPermissionFragment.kt */
/* loaded from: classes3.dex */
public final class BackgroundLocationPermissionFragment extends OnboardingPermissionFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name = "OnboardingBackgroundLocationPermission";

    /* compiled from: BackgroundLocationPermissionFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BackgroundLocationPermissionFragment newInstance() {
            return new BackgroundLocationPermissionFragment();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment
    public void ComposeContent(Composer composer, final int r11) {
        int r0;
        boolean z;
        boolean z2;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1744685764);
        if ((r11 & 14) == 0) {
            if (startRestartGroup.changed(this)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r11;
        } else {
            r0 = r11;
        }
        if ((r0 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-1798230848);
            int r03 = r0 & 14;
            boolean z3 = true;
            if (r03 == 4) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (z || nextSlot == composer$Companion$Empty$1) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragment$ComposeContent$1$1
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
                        BackgroundLocationPermissionFragment.this.requestPermissionOrGoToSettings();
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            Function0 function0 = (Function0) nextSlot;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(-1798230778);
            if (r03 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (z2 || nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragment$ComposeContent$2$1
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
                        MutableStateFlow<PermissionState> permissionState = BackgroundLocationPermissionFragment.this.getPermissionState();
                        do {
                        } while (!permissionState.compareAndSet(permissionState.getValue(), PermissionState.Denied.INSTANCE));
                    }
                };
                startRestartGroup.updateValue(nextSlot2);
            }
            Function0 function02 = (Function0) nextSlot2;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(-1798230697);
            if (r03 != 4) {
                z3 = false;
            }
            Object nextSlot3 = startRestartGroup.nextSlot();
            if (z3 || nextSlot3 == composer$Companion$Empty$1) {
                nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragment$ComposeContent$3$1
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
                        Onboarding.setHandled$default(BackgroundLocationPermissionFragment.this.getOnboarding(), Onboarding.State.BACKGROUND_LOCATION_PERMISSION, false, 2, null);
                        BackgroundLocationPermissionFragment.this.getOnboarding().updateState();
                    }
                };
                startRestartGroup.updateValue(nextSlot3);
            }
            startRestartGroup.end(false);
            BackgroundLocationPermissionFragmentKt.BackgroundLocationPermissionContent(function0, function02, (Function0) nextSlot3, (PermissionState) Platform.collectAsState(getPermissionState(), PermissionState.Idle.INSTANCE, null, startRestartGroup, 2).getValue(), startRestartGroup, 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragment$ComposeContent$4
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
                    BackgroundLocationPermissionFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r11 | 1));
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
        return BackgroundLocationPermissionFragmentKt.getLocationPermissions();
    }
}
