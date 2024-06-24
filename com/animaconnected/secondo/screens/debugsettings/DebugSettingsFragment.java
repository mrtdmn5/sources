package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestPermission;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.State;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.PoolIdProvider;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.FragmentFactory;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.debugsettings.DebugClick;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.secondo.utils.ViewKt;
import com.google.common.base.Strings;
import com.google.common.collect.Hashing;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: DebugSettingsFragment.kt */
/* loaded from: classes3.dex */
public final class DebugSettingsFragment extends ComposeFragment {
    private final String name = "DebugSettingsFragment";
    private final ActivityResultLauncher<String> permissionLauncher;
    private DebugSettingsPresenter presenter;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DebugSettingsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DebugSettingsFragment newInstance() {
            return new DebugSettingsFragment();
        }

        private Companion() {
        }
    }

    public DebugSettingsFragment() {
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestPermission(), new ActivityResultCallback() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$special$$inlined$registerPermission$default$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Boolean bool) {
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    DebugSettingsFragment.this.showFirmwarePicker();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.permissionLauncher = registerForActivityResult;
    }

    private static final DebugUiState ComposeContent$lambda$1(State<DebugUiState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void changePoolId() {
        PoolIdProvider poolIdProvider = ProviderFactory.getPoolIdProvider();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        BottomSheetKt.createBottomDialog(requireActivity, new DebugSettingsFragment$changePoolId$1(poolIdProvider, this)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[Catch: Exception -> 0x002b, TryCatch #0 {Exception -> 0x002b, blocks: (B:11:0x0027, B:12:0x0048, B:14:0x004c, B:17:0x004f), top: B:10:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f A[Catch: Exception -> 0x002b, TRY_LEAVE, TryCatch #0 {Exception -> 0x002b, blocks: (B:11:0x0027, B:12:0x0048, B:14:0x004c, B:17:0x004f), top: B:10:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchAndSharePostMortem(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$1 r0 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$1 r0 = new com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment r0 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L2b
            goto L48
        L2b:
            r8 = move-exception
            goto L8c
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r8 = r7.presenter     // Catch: java.lang.Exception -> L8a
            if (r8 == 0) goto L83
            r0.L$0 = r7     // Catch: java.lang.Exception -> L8a
            r0.label = r3     // Catch: java.lang.Exception -> L8a
            java.lang.Object r8 = r8.fetchPostMortem(r0)     // Catch: java.lang.Exception -> L8a
            if (r8 != r1) goto L47
            return r1
        L47:
            r0 = r7
        L48:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L2b
            if (r8 != 0) goto L4f
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L2b
            return r8
        L4f:
            com.animaconnected.secondo.utils.debugging.Debugging r1 = com.animaconnected.secondo.utils.debugging.Debugging.INSTANCE     // Catch: java.lang.Exception -> L2b
            android.content.Context r2 = r0.requireContext()     // Catch: java.lang.Exception -> L2b
            java.lang.String r3 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch: java.lang.Exception -> L2b
            java.lang.String r3 = "postmortem.bin"
            java.io.File r8 = r1.saveFile(r2, r3, r8)     // Catch: java.lang.Exception -> L2b
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> L2b
            java.lang.String r2 = "android.intent.action.SEND"
            r1.<init>(r2)     // Catch: java.lang.Exception -> L2b
            java.lang.String r2 = "text/plain"
            r1.setType(r2)     // Catch: java.lang.Exception -> L2b
            java.lang.String r2 = "android.intent.extra.STREAM"
            android.content.Context r3 = r0.requireContext()     // Catch: java.lang.Exception -> L2b
            android.net.Uri r8 = androidx.core.content.FileProvider.getUriForFile(r3, r8)     // Catch: java.lang.Exception -> L2b
            r1.putExtra(r2, r8)     // Catch: java.lang.Exception -> L2b
            java.lang.String r8 = "Send postmortem"
            android.content.Intent r8 = android.content.Intent.createChooser(r1, r8)     // Catch: java.lang.Exception -> L2b
            r0.startActivity(r8)     // Catch: java.lang.Exception -> L2b
            goto L97
        L83:
            java.lang.String r8 = "presenter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)     // Catch: java.lang.Exception -> L8a
            r8 = 0
            throw r8     // Catch: java.lang.Exception -> L8a
        L8a:
            r8 = move-exception
            r0 = r7
        L8c:
            r2 = r8
            java.lang.String r1 = "DebugSettings"
            r3 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$2 r4 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$2
                static {
                    /*
                        com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$2 r0 = new com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$2) com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$2.INSTANCE com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Failed to share post mortem file"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$fetchAndSharePostMortem$2.invoke():java.lang.Object");
                }
            }
            r5 = 4
            r6 = 0
            com.animaconnected.logger.LogKt.warn$default(r0, r1, r2, r3, r4, r5, r6)
        L97:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment.fetchAndSharePostMortem(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchPermissionSettings() {
        String str;
        if (Build.VERSION.SDK_INT >= 30) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                str = activity.getPackageName();
            } else {
                str = null;
            }
            Uri fromParts = Uri.fromParts("package", str, null);
            Intent intent = new Intent("android.intent.action.AUTO_REVOKE_PERMISSIONS");
            intent.setData(fromParts);
            CustomActivityResult.launch$default(getActivityLauncher(), intent, null, 2, null);
            return;
        }
        ViewKt.toast$default((Fragment) this, "Not Android 11+ device", false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDebugTestClick() {
        try {
            MainController mainController = getMainController();
            BaseFragment debugTestingFragment = FragmentFactory.getDebugTestingFragment();
            Intrinsics.checkNotNullExpressionValue(debugTestingFragment, "getDebugTestingFragment(...)");
            mainController.gotoNextFragment(debugTestingFragment);
        } catch (UnsupportedOperationException unused) {
            ViewKt.toast$default((Fragment) this, "Debug testing not supported for flavour", false, 2, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectDfuFile() {
        if (Build.VERSION.SDK_INT < 33 && !PermissionCompat.INSTANCE.isPermissionGranted("android.permission.READ_EXTERNAL_STORAGE")) {
            this.permissionLauncher.launch("android.permission.READ_EXTERNAL_STORAGE");
        } else {
            showFirmwarePicker();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFirmwarePicker() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType(DfuBaseService.MIME_TYPE_ZIP);
        intent.addCategory("android.intent.category.OPENABLE");
        getActivityLauncher().launch(intent, new Function1<ActivityResult, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$showFirmwarePicker$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActivityResult activityResult) {
                invoke2(activityResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ActivityResult activityResult) {
                Intrinsics.checkNotNullParameter(activityResult, "activityResult");
                Intent intent2 = activityResult.mData;
                if (intent2 != null) {
                    DebugSettingsFragment debugSettingsFragment = DebugSettingsFragment.this;
                    BuildersKt.launch$default(Hashing.getLifecycleScope(debugSettingsFragment), null, null, new DebugSettingsFragment$showFirmwarePicker$1$1$1(debugSettingsFragment, intent2, null), 3);
                }
            }
        });
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r8) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(154649307);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        DebugSettingsPresenter debugSettingsPresenter = this.presenter;
        if (debugSettingsPresenter != null) {
            MutableState collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(debugSettingsPresenter.getUiState(), startRestartGroup);
            startRestartGroup.startReplaceableGroup(773894976);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object nextSlot = startRestartGroup.nextSlot();
            if (nextSlot == Composer.Companion.Empty) {
                nextSlot = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
            }
            startRestartGroup.end(false);
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) nextSlot).coroutineScope;
            startRestartGroup.end(false);
            EffectsKt.LaunchedEffect(Unit.INSTANCE, new DebugSettingsFragment$ComposeContent$1(this, null), startRestartGroup);
            DebugSettingsScreenKt.DebugSettingsScreen(ComposeContent$lambda$1(collectAsStateWithLifecycle), new Function1<DebugClick, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$ComposeContent$2

                /* compiled from: DebugSettingsFragment.kt */
                @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$ComposeContent$2$1", f = "DebugSettingsFragment.kt", l = {82, 83, 84, 86, 88, 94, 95, 96, 97}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$ComposeContent$2$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ DebugClick $event;
                    int label;
                    final /* synthetic */ DebugSettingsFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(DebugClick debugClick, DebugSettingsFragment debugSettingsFragment, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$event = debugClick;
                        this.this$0 = debugSettingsFragment;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$event, this.this$0, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        DebugSettingsPresenter debugSettingsPresenter;
                        DebugSettingsPresenter debugSettingsPresenter2;
                        DebugSettingsPresenter debugSettingsPresenter3;
                        DebugSettingsPresenter debugSettingsPresenter4;
                        DebugSettingsPresenter debugSettingsPresenter5;
                        DebugSettingsPresenter debugSettingsPresenter6;
                        DebugSettingsPresenter debugSettingsPresenter7;
                        DebugSettingsPresenter debugSettingsPresenter8;
                        DebugSettingsPresenter debugSettingsPresenter9;
                        DebugSettingsPresenter debugSettingsPresenter10;
                        DebugSettingsPresenter debugSettingsPresenter11;
                        DebugSettingsPresenter debugSettingsPresenter12;
                        DebugSettingsPresenter debugSettingsPresenter13;
                        DebugSettingsPresenter debugSettingsPresenter14;
                        Object fetchAndSharePostMortem;
                        DebugSettingsPresenter debugSettingsPresenter15;
                        DebugSettingsPresenter debugSettingsPresenter16;
                        DebugSettingsPresenter debugSettingsPresenter17;
                        DebugSettingsPresenter debugSettingsPresenter18;
                        DebugSettingsPresenter debugSettingsPresenter19;
                        DebugSettingsPresenter debugSettingsPresenter20;
                        DebugSettingsPresenter debugSettingsPresenter21;
                        DebugSettingsPresenter debugSettingsPresenter22;
                        DebugSettingsPresenter debugSettingsPresenter23;
                        DebugSettingsPresenter debugSettingsPresenter24;
                        DebugSettingsPresenter debugSettingsPresenter25;
                        DebugSettingsPresenter debugSettingsPresenter26;
                        DebugSettingsPresenter debugSettingsPresenter27;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure(obj);
                                DebugClick debugClick = this.$event;
                                if (Intrinsics.areEqual(debugClick, DebugClick.FetchDfuCloud.INSTANCE)) {
                                    debugSettingsPresenter27 = this.this$0.presenter;
                                    if (debugSettingsPresenter27 != null) {
                                        debugSettingsPresenter27.startDfuFromCloud();
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.FetchDfuLocal.INSTANCE)) {
                                    this.this$0.selectDfuFile();
                                    break;
                                } else if (debugClick instanceof DebugClick.ToggleDemoMode) {
                                    debugSettingsPresenter26 = this.this$0.presenter;
                                    if (debugSettingsPresenter26 != null) {
                                        debugSettingsPresenter26.toggleDemoMode(((DebugClick.ToggleDemoMode) this.$event).isChecked());
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (debugClick instanceof DebugClick.ToggleMockFitness) {
                                    debugSettingsPresenter25 = this.this$0.presenter;
                                    if (debugSettingsPresenter25 != null) {
                                        debugSettingsPresenter25.toggleMockFitness(((DebugClick.ToggleMockFitness) this.$event).isChecked());
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (debugClick instanceof DebugClick.ToggleSpeedCalibration) {
                                    debugSettingsPresenter24 = this.this$0.presenter;
                                    if (debugSettingsPresenter24 != null) {
                                        debugSettingsPresenter24.toggleSpeedCalibration(((DebugClick.ToggleSpeedCalibration) this.$event).isChecked());
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (debugClick instanceof DebugClick.ToggleWorkInProgress) {
                                    debugSettingsPresenter23 = this.this$0.presenter;
                                    if (debugSettingsPresenter23 != null) {
                                        debugSettingsPresenter23.toggleWorkInProgress(((DebugClick.ToggleWorkInProgress) this.$event).isChecked());
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (debugClick instanceof DebugClick.ToggleHealthDashboard) {
                                    debugSettingsPresenter22 = this.this$0.presenter;
                                    if (debugSettingsPresenter22 != null) {
                                        debugSettingsPresenter22.toggleHealthDashboard(((DebugClick.ToggleHealthDashboard) this.$event).isChecked());
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (debugClick instanceof DebugClick.ToggleKtorLogging) {
                                    debugSettingsPresenter21 = this.this$0.presenter;
                                    if (debugSettingsPresenter21 != null) {
                                        debugSettingsPresenter21.toggleHttpLogs(((DebugClick.ToggleKtorLogging) this.$event).isChecked());
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (debugClick instanceof DebugClick.ToggleAppAlwaysOn) {
                                    debugSettingsPresenter20 = this.this$0.presenter;
                                    if (debugSettingsPresenter20 != null) {
                                        debugSettingsPresenter20.toggleAppAlwaysOn(((DebugClick.ToggleAppAlwaysOn) this.$event).isChecked());
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (debugClick instanceof DebugClick.ToggleCustomerSupportDevEnv) {
                                    debugSettingsPresenter19 = this.this$0.presenter;
                                    if (debugSettingsPresenter19 != null) {
                                        debugSettingsPresenter19.toggleCustomerSupportDevEnv(((DebugClick.ToggleCustomerSupportDevEnv) this.$event).isChecked());
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (debugClick instanceof DebugClick.ToggleBluetoothDebug) {
                                    debugSettingsPresenter18 = this.this$0.presenter;
                                    if (debugSettingsPresenter18 != null) {
                                        debugSettingsPresenter18.toggleBluetoothDebug(((DebugClick.ToggleBluetoothDebug) this.$event).isChecked());
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (debugClick instanceof DebugClick.ToggleRssiNotification) {
                                    debugSettingsPresenter17 = this.this$0.presenter;
                                    if (debugSettingsPresenter17 != null) {
                                        debugSettingsPresenter17.toggleRssiLiveUpdates(((DebugClick.ToggleRssiNotification) this.$event).isChecked());
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.PermissionSettings.INSTANCE)) {
                                    this.this$0.launchPermissionSettings();
                                    break;
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.DisablePowerOptimizations.INSTANCE)) {
                                    debugSettingsPresenter16 = this.this$0.presenter;
                                    if (debugSettingsPresenter16 != null) {
                                        debugSettingsPresenter16.disablePowerOptimizations();
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.ResetRecentDemoData.INSTANCE)) {
                                    debugSettingsPresenter15 = this.this$0.presenter;
                                    if (debugSettingsPresenter15 != null) {
                                        debugSettingsPresenter15.resetRecentDemoData();
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.ReadPostMortem.INSTANCE)) {
                                    DebugSettingsFragment debugSettingsFragment = this.this$0;
                                    this.label = 1;
                                    fetchAndSharePostMortem = debugSettingsFragment.fetchAndSharePostMortem(this);
                                    if (fetchAndSharePostMortem == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.ClearDisplayDatabase.INSTANCE)) {
                                    debugSettingsPresenter14 = this.this$0.presenter;
                                    if (debugSettingsPresenter14 != null) {
                                        this.label = 2;
                                        if (debugSettingsPresenter14.clearDisplayDatabase(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (debugClick instanceof DebugClick.SetBatteryLevel) {
                                    debugSettingsPresenter13 = this.this$0.presenter;
                                    if (debugSettingsPresenter13 != null) {
                                        int level = ((DebugClick.SetBatteryLevel) this.$event).getLevel();
                                        this.label = 3;
                                        if (debugSettingsPresenter13.setBatteryLevel(level, this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.TriggerHardFault.INSTANCE)) {
                                    debugSettingsPresenter12 = this.this$0.presenter;
                                    if (debugSettingsPresenter12 != null) {
                                        debugSettingsPresenter12.triggerHardFault();
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.TriggerAppError.INSTANCE)) {
                                    debugSettingsPresenter11 = this.this$0.presenter;
                                    if (debugSettingsPresenter11 != null) {
                                        this.label = 4;
                                        if (debugSettingsPresenter11.triggerAppError(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.DebugTesting.INSTANCE)) {
                                    this.this$0.onDebugTestClick();
                                    break;
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.GetLastDisconnectInfo.INSTANCE)) {
                                    debugSettingsPresenter10 = this.this$0.presenter;
                                    if (debugSettingsPresenter10 != null) {
                                        this.label = 5;
                                        if (debugSettingsPresenter10.getLastDisconnectInfo(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.RequestAssociation.INSTANCE)) {
                                    debugSettingsPresenter9 = this.this$0.presenter;
                                    if (debugSettingsPresenter9 != null) {
                                        debugSettingsPresenter9.requestAssociation();
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.RemoveAssociation.INSTANCE)) {
                                    debugSettingsPresenter8 = this.this$0.presenter;
                                    if (debugSettingsPresenter8 != null) {
                                        debugSettingsPresenter8.removeAssociation();
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.RemoveBond.INSTANCE)) {
                                    debugSettingsPresenter7 = this.this$0.presenter;
                                    if (debugSettingsPresenter7 != null) {
                                        debugSettingsPresenter7.removeBond();
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.Close.INSTANCE)) {
                                    debugSettingsPresenter6 = this.this$0.presenter;
                                    if (debugSettingsPresenter6 != null) {
                                        debugSettingsPresenter6.close();
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.Connect.INSTANCE)) {
                                    debugSettingsPresenter5 = this.this$0.presenter;
                                    if (debugSettingsPresenter5 != null) {
                                        debugSettingsPresenter5.connect();
                                        break;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.Scan.INSTANCE)) {
                                    debugSettingsPresenter4 = this.this$0.presenter;
                                    if (debugSettingsPresenter4 != null) {
                                        this.label = 6;
                                        if (debugSettingsPresenter4.scan(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.FakeConnect.INSTANCE)) {
                                    debugSettingsPresenter3 = this.this$0.presenter;
                                    if (debugSettingsPresenter3 != null) {
                                        this.label = 7;
                                        if (debugSettingsPresenter3.fakeConnect(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.RefreshAmplifySession.INSTANCE)) {
                                    debugSettingsPresenter2 = this.this$0.presenter;
                                    if (debugSettingsPresenter2 != null) {
                                        this.label = 8;
                                        if (debugSettingsPresenter2.refreshAmplifySession(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.SendCrashlytics.INSTANCE)) {
                                    debugSettingsPresenter = this.this$0.presenter;
                                    if (debugSettingsPresenter != null) {
                                        this.label = 9;
                                        if (debugSettingsPresenter.sendCrashlytics(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                        throw null;
                                    }
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.ChangePoolID.INSTANCE)) {
                                    this.this$0.changePoolId();
                                    break;
                                } else if (Intrinsics.areEqual(debugClick, DebugClick.NavigateBack.INSTANCE)) {
                                    this.this$0.getMainController().goBack();
                                    break;
                                } else if (debugClick instanceof DebugClick.GoToNextFragment) {
                                    this.this$0.getMainController().gotoNextFragment(((DebugClick.GoToNextFragment) this.$event).getDestination());
                                    break;
                                }
                                break;
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                                ResultKt.throwOnFailure(obj);
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DebugClick debugClick) {
                    invoke2(debugClick);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DebugClick event) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(event, this, null), 3);
                }
            }, startRestartGroup, 0);
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$ComposeContent$3
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
                        DebugSettingsFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r8 | 1));
                    }
                };
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.presenter = new DebugSettingsPresenter(new DebugCompanionDevice(requireActivity), new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$onCreateView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                ViewKt.toast$default((Fragment) DebugSettingsFragment.this, text, false, 2, (Object) null);
            }
        });
        return super.onCreateView(inflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        DebugSettingsPresenter debugSettingsPresenter = this.presenter;
        if (debugSettingsPresenter != null) {
            debugSettingsPresenter.onPause();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DebugSettingsPresenter debugSettingsPresenter = this.presenter;
        if (debugSettingsPresenter != null) {
            debugSettingsPresenter.onResume();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }
}
