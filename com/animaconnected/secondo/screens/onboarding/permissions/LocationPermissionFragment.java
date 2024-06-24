package com.animaconnected.secondo.screens.onboarding.permissions;

import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.State;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.onboarding.OnboardingPermissionFragment;
import com.animaconnected.secondo.screens.onboarding.PermissionState;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: LocationPermissionFragment.kt */
/* loaded from: classes3.dex */
public final class LocationPermissionFragment extends OnboardingPermissionFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name = "OnboardingLocationPermission";

    /* compiled from: LocationPermissionFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocationPermissionFragment newInstance() {
            return new LocationPermissionFragment();
        }

        private Companion() {
        }
    }

    private static final PermissionState ComposeContent$lambda$0(State<? extends PermissionState> state) {
        return state.getValue();
    }

    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment
    public void ComposeContent(Composer composer, final int r11) {
        int r0;
        boolean z;
        boolean z2;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-436578912);
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
            MutableState collectAsState = Platform.collectAsState(getPermissionState(), PermissionState.Idle.INSTANCE, null, startRestartGroup, 2);
            startRestartGroup.startReplaceableGroup(1084755508);
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
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragment$ComposeContent$1$1
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
                        LocationPermissionFragment.this.requestPermissionOrGoToSettings();
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            Function0 function0 = (Function0) nextSlot;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(1084755578);
            if (r03 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (z2 || nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragment$ComposeContent$2$1
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
                        MutableStateFlow<PermissionState> permissionState = LocationPermissionFragment.this.getPermissionState();
                        do {
                        } while (!permissionState.compareAndSet(permissionState.getValue(), PermissionState.Denied.INSTANCE));
                    }
                };
                startRestartGroup.updateValue(nextSlot2);
            }
            Function0 function02 = (Function0) nextSlot2;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(1084755659);
            if (r03 != 4) {
                z3 = false;
            }
            Object nextSlot3 = startRestartGroup.nextSlot();
            if (z3 || nextSlot3 == composer$Companion$Empty$1) {
                nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragment$ComposeContent$3$1
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
                        LocationPermissionFragment.this.getOnboarding().updateState();
                    }
                };
                startRestartGroup.updateValue(nextSlot3);
            }
            startRestartGroup.end(false);
            LocationPermissionFragmentKt.LocationPermissionContent(function0, function02, (Function0) nextSlot3, ComposeContent$lambda$0(collectAsState), startRestartGroup, 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragment$ComposeContent$4
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
                    LocationPermissionFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r11 | 1));
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
        if (Build.VERSION.SDK_INT >= 31) {
            return CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN"});
        }
        return CollectionsKt__CollectionsKt.listOf("android.permission.ACCESS_FINE_LOCATION");
    }
}
