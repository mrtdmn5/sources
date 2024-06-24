package com.animaconnected.secondo.screens.onboarding;

import android.os.Bundle;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.onboarding.PermissionState;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: OnboardingPermission.kt */
/* loaded from: classes3.dex */
public abstract class OnboardingPermissionFragment extends ComposeOnboardingFragment {
    public static final int $stable = 8;
    private PermissionCompat.PermissionHelper permissionHelper;
    private final ActivityResultLauncher<String[]> permissionLauncher;
    private final MutableStateFlow<PermissionState> permissionState = StateFlowKt.MutableStateFlow(PermissionState.Idle.INSTANCE);

    public OnboardingPermissionFragment() {
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingPermissionFragment$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                OnboardingPermissionFragment.permissionLauncher$lambda$2(OnboardingPermissionFragment.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.permissionLauncher = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void permissionLauncher$lambda$2(OnboardingPermissionFragment this$0, Map map) {
        PermissionState value;
        PermissionState permissionState;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Set entrySet = map.entrySet();
        boolean z = true;
        if (!(entrySet instanceof Collection) || !entrySet.isEmpty()) {
            Iterator it = entrySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        MutableStateFlow<PermissionState> mutableStateFlow = this$0.permissionState;
        do {
            value = mutableStateFlow.getValue();
            if (z) {
                permissionState = PermissionState.Granted.INSTANCE;
            } else {
                permissionState = PermissionState.Denied.INSTANCE;
            }
        } while (!mutableStateFlow.compareAndSet(value, permissionState));
    }

    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment, com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public final MutableStateFlow<PermissionState> getPermissionState() {
        return this.permissionState;
    }

    public abstract List<String> getPermissions();

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean handlesState(Onboarding.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return false;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.permissionHelper = PermissionCompat.create(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (OnboardingPermissionKt.arePermissionsGranted(getPermissions())) {
            MutableStateFlow<PermissionState> mutableStateFlow = this.permissionState;
            do {
            } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), PermissionState.Granted.INSTANCE));
        }
    }

    public final void requestPermissionOrGoToSettings() {
        PermissionCompat.PermissionHelper permissionHelper = this.permissionHelper;
        if (permissionHelper != null) {
            permissionHelper.requestPermissionOrGoToSettings((String[]) getPermissions().toArray(new String[0]), new Function1<String[], Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingPermissionFragment$requestPermissionOrGoToSettings$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String[] strArr) {
                    invoke2(strArr);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String[] it) {
                    ActivityResultLauncher activityResultLauncher;
                    Intrinsics.checkNotNullParameter(it, "it");
                    activityResultLauncher = OnboardingPermissionFragment.this.permissionLauncher;
                    activityResultLauncher.launch(OnboardingPermissionFragment.this.getPermissions().toArray(new String[0]));
                }
            });
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
            throw null;
        }
    }
}
