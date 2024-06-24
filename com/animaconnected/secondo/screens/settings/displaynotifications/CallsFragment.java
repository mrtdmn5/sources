package com.animaconnected.secondo.screens.settings.displaynotifications;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultLauncherHolder;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectImpl;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateListIterator;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.onboarding.OnboardingPermissionKt;
import com.animaconnected.secondo.screens.onboarding.PermissionState;
import com.animaconnected.secondo.screens.onboarding.permissions.CallsPermissionFragmentKt;
import com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt;
import com.animaconnected.secondo.screens.settings.displaynotifications.components.Filter;
import com.animaconnected.watch.filter.FilterSettings;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: CallsFragment.kt */
/* loaded from: classes3.dex */
public final class CallsFragment extends ComposeFragment {
    private PermissionCompat.PermissionHelper permissionHelper;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "CallsFragment";
    private final DisplayNotificationViewModel viewModel = new DisplayNotificationViewModel();
    private final MutableStateFlow<PermissionState> permissionState = StateFlowKt.MutableStateFlow(PermissionState.Idle.INSTANCE);

    /* compiled from: CallsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isBadgeVisible() {
            if (!OnboardingPermissionKt.arePermissionsGranted(CallsPermissionFragmentKt.getCallPermissions()) && ProviderFactory.getWatch().getWatchManager().getFilterSettings().getCallsFilter() != FilterSettings.Allowed.None) {
                return true;
            }
            return false;
        }

        public final CallsFragment newInstance() {
            return new CallsFragment();
        }

        private Companion() {
        }
    }

    private static final SnapshotStateList<Filter> ComposeContent$lambda$11(State<SnapshotStateList<Filter>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ComposeContent$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ComposeContent$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PermissionState checkPermissions() {
        if (OnboardingPermissionKt.arePermissionsGranted(CallsPermissionFragmentKt.getCallPermissions())) {
            return PermissionState.Granted.INSTANCE;
        }
        return PermissionState.Denied.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.animaconnected.secondo.screens.settings.displaynotifications.CallsFragment$ComposeContent$4, kotlin.jvm.internal.Lambda] */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r20) {
        boolean z;
        boolean z2;
        Filter filter;
        boolean z3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1351395528);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final ModalBottomSheetState rememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, false, startRestartGroup, 14);
        startRestartGroup.startReplaceableGroup(-1221612861);
        Object nextSlot = startRestartGroup.nextSlot();
        Object obj = Composer.Companion.Empty;
        if (nextSlot == obj) {
            nextSlot = Platform.mutableStateOf$default(Boolean.FALSE);
            startRestartGroup.updateValue(nextSlot);
        }
        final MutableState mutableState = (MutableState) nextSlot;
        startRestartGroup.end(false);
        final FilterSettings.Allowed allowed = (FilterSettings.Allowed) Platform.collectAsState(this.viewModel.getCallsFilter(), startRestartGroup).getValue();
        PermissionState permissionState = (PermissionState) Platform.collectAsState(this.permissionState, startRestartGroup).getValue();
        Object m = BottomSheetScaffoldKt$$ExternalSyntheticOutline0.m(startRestartGroup, 773894976, -492369756);
        if (m == obj) {
            m = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) m).coroutineScope;
        startRestartGroup.end(false);
        if (Intrinsics.areEqual(permissionState, PermissionState.Denied.INSTANCE) && allowed != FilterSettings.Allowed.None) {
            z = true;
        } else {
            z = false;
        }
        ComposeContent$lambda$3(mutableState, z);
        final ActivityResultContracts$RequestMultiplePermissions activityResultContracts$RequestMultiplePermissions = new ActivityResultContracts$RequestMultiplePermissions();
        startRestartGroup.startReplaceableGroup(-1221612396);
        boolean changed = startRestartGroup.changed(allowed);
        Object nextSlot2 = startRestartGroup.nextSlot();
        if (changed || nextSlot2 == obj) {
            nextSlot2 = new Function1<Map<String, Boolean>, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsFragment$ComposeContent$launcher$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<String, Boolean> map) {
                    invoke2(map);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<String, Boolean> permissionMap) {
                    boolean z4;
                    Intrinsics.checkNotNullParameter(permissionMap, "permissionMap");
                    boolean z5 = false;
                    if (!permissionMap.isEmpty()) {
                        Iterator<Map.Entry<String, Boolean>> it = permissionMap.entrySet().iterator();
                        while (it.hasNext()) {
                            if (!it.next().getValue().booleanValue()) {
                                z4 = false;
                                break;
                            }
                        }
                    }
                    z4 = true;
                    boolean z6 = !z4;
                    boolean z7 = FilterSettings.Allowed.this != FilterSettings.Allowed.None;
                    MutableState<Boolean> mutableState2 = mutableState;
                    if (z6 && z7) {
                        z5 = true;
                    }
                    CallsFragment.ComposeContent$lambda$3(mutableState2, z5);
                }
            };
            startRestartGroup.updateValue(nextSlot2);
        }
        Function1 onResult = (Function1) nextSlot2;
        startRestartGroup.end(false);
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        startRestartGroup.startReplaceableGroup(-1408504823);
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(activityResultContracts$RequestMultiplePermissions, startRestartGroup);
        final MutableState rememberUpdatedState2 = Platform.rememberUpdatedState(onResult, startRestartGroup);
        Object obj2 = null;
        Object rememberSaveable = RememberSaveableKt.rememberSaveable(new Object[0], null, new Function0<String>() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return UUID.randomUUID().toString();
            }
        }, startRestartGroup, 6);
        Intrinsics.checkNotNullExpressionValue(rememberSaveable, "rememberSaveable { UUID.randomUUID().toString() }");
        final String str = (String) rememberSaveable;
        DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = LocalActivityResultRegistryOwner.LocalComposition;
        startRestartGroup.startReplaceableGroup(1418020823);
        ActivityResultRegistryOwner activityResultRegistryOwner = (ActivityResultRegistryOwner) startRestartGroup.consume(LocalActivityResultRegistryOwner.LocalComposition);
        if (activityResultRegistryOwner == null) {
            Object obj3 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.LocalContext);
            while (true) {
                if (!(obj3 instanceof ContextWrapper)) {
                    break;
                }
                if (obj3 instanceof ActivityResultRegistryOwner) {
                    obj2 = obj3;
                    break;
                } else {
                    obj3 = ((ContextWrapper) obj3).getBaseContext();
                    Intrinsics.checkNotNullExpressionValue(obj3, "innerContext.baseContext");
                }
            }
            activityResultRegistryOwner = (ActivityResultRegistryOwner) obj2;
        }
        startRestartGroup.end(false);
        if (activityResultRegistryOwner != null) {
            final ActivityResultRegistry activityResultRegistry = activityResultRegistryOwner.getActivityResultRegistry();
            startRestartGroup.startReplaceableGroup(-3687241);
            Object nextSlot3 = startRestartGroup.nextSlot();
            if (nextSlot3 == obj) {
                nextSlot3 = new ActivityResultLauncherHolder();
                startRestartGroup.updateValue(nextSlot3);
            }
            startRestartGroup.end(false);
            final ActivityResultLauncherHolder activityResultLauncherHolder = (ActivityResultLauncherHolder) nextSlot3;
            startRestartGroup.startReplaceableGroup(-3687241);
            Object nextSlot4 = startRestartGroup.nextSlot();
            if (nextSlot4 == obj) {
                nextSlot4 = new ManagedActivityResultLauncher(activityResultLauncherHolder, rememberUpdatedState);
                startRestartGroup.updateValue(nextSlot4);
            }
            startRestartGroup.end(false);
            final ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) nextSlot4;
            Object obj4 = null;
            Function1<DisposableEffectScope, DisposableEffectResult> function1 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    DisposableEffectScope DisposableEffect = disposableEffectScope;
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final State<Function1<Object, Unit>> state = rememberUpdatedState2;
                    ActivityResultCallback<Object> activityResultCallback = new ActivityResultCallback<Object>() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1.1
                        @Override // androidx.activity.result.ActivityResultCallback
                        public final void onActivityResult(Object obj5) {
                            state.getValue().invoke(obj5);
                        }
                    };
                    ActivityResultRegistry.AnonymousClass3 register = activityResultRegistry.register(str, activityResultContracts$RequestMultiplePermissions, activityResultCallback);
                    final ActivityResultLauncherHolder<Object> activityResultLauncherHolder2 = ActivityResultLauncherHolder.this;
                    activityResultLauncherHolder2.launcher = register;
                    return new DisposableEffectResult() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public final void dispose() {
                            Unit unit;
                            ActivityResultLauncher<I> activityResultLauncher = ActivityResultLauncherHolder.this.launcher;
                            if (activityResultLauncher != 0) {
                                activityResultLauncher.unregister();
                                unit = Unit.INSTANCE;
                            } else {
                                unit = null;
                            }
                            if (unit != null) {
                            } else {
                                throw new IllegalStateException("Launcher has not been initialized".toString());
                            }
                        }
                    };
                }
            };
            DisposableEffectScope disposableEffectScope = EffectsKt.InternalDisposableEffectScope;
            startRestartGroup.startReplaceableGroup(-1239538271);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(1618982084);
            boolean changed2 = startRestartGroup.changed(activityResultContracts$RequestMultiplePermissions) | startRestartGroup.changed(activityResultRegistry) | startRestartGroup.changed(str);
            Object nextSlot5 = startRestartGroup.nextSlot();
            if (changed2 || nextSlot5 == obj) {
                startRestartGroup.updateValue(new DisposableEffectImpl(function1));
            }
            startRestartGroup.end(false);
            startRestartGroup.end(false);
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(-1221612131);
            Object nextSlot6 = startRestartGroup.nextSlot();
            if (nextSlot6 == obj) {
                String string = getString(R.string.filtered_notifications_preference_title_everyone);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = getString(R.string.filtered_notifications_preference_subtitle_calls_everyone);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                nextSlot6 = new Filter(string, string2, FilterSettings.Allowed.All, ComposeContent$lambda$2(mutableState));
                startRestartGroup.updateValue(nextSlot6);
            }
            final Filter filter2 = (Filter) nextSlot6;
            Object m2 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -1221611755);
            if (m2 == obj) {
                String string3 = getString(R.string.filtered_notifications_preference_title_known_contacts);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                String string4 = getString(R.string.filtered_notifications_preference_subtitle_calls_known_contacts);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                m2 = new Filter(string3, string4, FilterSettings.Allowed.Known, ComposeContent$lambda$2(mutableState));
                startRestartGroup.updateValue(m2);
            }
            final Filter filter3 = (Filter) m2;
            Object m3 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -1221611361);
            if (m3 == obj) {
                String string5 = getString(R.string.filtered_notifications_preference_title_phone_favourites);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                String string6 = getString(R.string.filtered_notifications_preference_subtitle_calls_phone_favourites);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                m3 = new Filter(string5, string6, FilterSettings.Allowed.Favourites, ComposeContent$lambda$2(mutableState));
                startRestartGroup.updateValue(m3);
            }
            final Filter filter4 = (Filter) m3;
            Object m4 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -1221610958);
            if (m4 == obj) {
                String string7 = getString(R.string.filtered_notifications_important_contacts);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                String string8 = getString(R.string.filtered_notifications_preference_subtitle_calls_important);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                m4 = new Filter(string7, string8, FilterSettings.Allowed.Important, ComposeContent$lambda$2(mutableState));
                startRestartGroup.updateValue(m4);
            }
            final Filter filter5 = (Filter) m4;
            Object m5 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -1221610583);
            if (m5 == obj) {
                String string9 = getString(R.string.filtered_notifications_preference_title_none);
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                String string10 = getString(R.string.filtered_notifications_preference_subtitle_calls_none);
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                z2 = false;
                m5 = new Filter(string9, string10, FilterSettings.Allowed.None, false);
                startRestartGroup.updateValue(m5);
            } else {
                z2 = false;
            }
            final Filter filter6 = (Filter) m5;
            Object m6 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, z2, -1221610220);
            if (m6 == obj) {
                m6 = Platform.derivedStateOf(new Function0<SnapshotStateList<Filter>>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsFragment$ComposeContent$filters$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final SnapshotStateList<Filter> invoke() {
                        boolean ComposeContent$lambda$2;
                        boolean ComposeContent$lambda$22;
                        boolean ComposeContent$lambda$23;
                        boolean ComposeContent$lambda$24;
                        Filter filter7 = Filter.this;
                        ComposeContent$lambda$2 = CallsFragment.ComposeContent$lambda$2(mutableState);
                        Filter copy$default = Filter.copy$default(filter7, null, null, null, ComposeContent$lambda$2, 7, null);
                        Filter filter8 = filter3;
                        ComposeContent$lambda$22 = CallsFragment.ComposeContent$lambda$2(mutableState);
                        Filter copy$default2 = Filter.copy$default(filter8, null, null, null, ComposeContent$lambda$22, 7, null);
                        Filter filter9 = filter4;
                        ComposeContent$lambda$23 = CallsFragment.ComposeContent$lambda$2(mutableState);
                        Filter copy$default3 = Filter.copy$default(filter9, null, null, null, ComposeContent$lambda$23, 7, null);
                        Filter filter10 = filter5;
                        ComposeContent$lambda$24 = CallsFragment.ComposeContent$lambda$2(mutableState);
                        return Platform.mutableStateListOf(copy$default, copy$default2, copy$default3, Filter.copy$default(filter10, null, null, null, ComposeContent$lambda$24, 7, null), filter6);
                    }
                });
                startRestartGroup.updateValue(m6);
            }
            State state = (State) m6;
            startRestartGroup.end(false);
            SnapshotStateList<Filter> ComposeContent$lambda$11 = ComposeContent$lambda$11(state);
            ListIterator<Filter> listIterator = ComposeContent$lambda$11(state).listIterator();
            while (true) {
                StateListIterator stateListIterator = (StateListIterator) listIterator;
                if (!stateListIterator.hasNext()) {
                    break;
                }
                Object next = stateListIterator.next();
                if (((Filter) next).getAllowed() == allowed) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    obj4 = next;
                    break;
                }
            }
            Filter filter7 = (Filter) obj4;
            if (filter7 == null) {
                filter = filter6;
            } else {
                filter = filter7;
            }
            CallsTextComponentsKt.CallsTextScreen(ComposeContent$lambda$11, filter, URLProtocolKt.stringResource(R.string.nft_calls, startRestartGroup), R.drawable.ic_all_calls, rememberModalBottomSheetState, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsFragment$ComposeContent$2
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
                    CallsFragment.this.getMainController().goBack();
                }
            }, new Function1<Filter, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsFragment$ComposeContent$3

                /* compiled from: CallsFragment.kt */
                @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.CallsFragment$ComposeContent$3$1", f = "CallsFragment.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryBackgroundDetail}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.secondo.screens.settings.displaynotifications.CallsFragment$ComposeContent$3$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ModalBottomSheetState $sheetState;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$sheetState = modalBottomSheetState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$sheetState, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        int r1 = this.label;
                        if (r1 != 0) {
                            if (r1 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                            this.label = 1;
                            if (modalBottomSheetState.show(this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
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
                public /* bridge */ /* synthetic */ Unit invoke(Filter filter8) {
                    invoke2(filter8);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Filter filter8) {
                    DisplayNotificationViewModel displayNotificationViewModel;
                    PermissionState checkPermissions;
                    Intrinsics.checkNotNullParameter(filter8, "filter");
                    displayNotificationViewModel = CallsFragment.this.viewModel;
                    displayNotificationViewModel.setCallsFilter(filter8.getAllowed());
                    checkPermissions = CallsFragment.this.checkPermissions();
                    boolean areEqual = Intrinsics.areEqual(checkPermissions, PermissionState.Denied.INSTANCE);
                    boolean z4 = filter8.getAllowed() != FilterSettings.Allowed.None;
                    if (areEqual && z4) {
                        BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass1(rememberModalBottomSheetState, null), 3);
                    }
                }
            }, ComposableLambdaKt.composableLambda(startRestartGroup, -2102223740, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsFragment$ComposeContent$4

                /* compiled from: CallsFragment.kt */
                @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.CallsFragment$ComposeContent$4$1", f = "CallsFragment.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.secondo.screens.settings.displaynotifications.CallsFragment$ComposeContent$4$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                    final /* synthetic */ ManagedActivityResultLauncher<String[], Map<String, Boolean>> $launcher;
                    final /* synthetic */ ModalBottomSheetState $sheetState;
                    int label;
                    final /* synthetic */ CallsFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(ModalBottomSheetState modalBottomSheetState, CallsFragment callsFragment, ManagedActivityResultLauncher<String[], Map<String, Boolean>> managedActivityResultLauncher, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.$sheetState = modalBottomSheetState;
                        this.this$0 = callsFragment;
                        this.$launcher = managedActivityResultLauncher;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.$sheetState, this.this$0, this.$launcher, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        PermissionCompat.PermissionHelper permissionHelper;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        int r1 = this.label;
                        if (r1 != 0) {
                            if (r1 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                            this.label = 1;
                            if (modalBottomSheetState.hide(this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        permissionHelper = this.this$0.permissionHelper;
                        if (permissionHelper != null) {
                            String[] strArr = (String[]) CallsPermissionFragmentKt.getCallPermissions().toArray(new String[0]);
                            final ManagedActivityResultLauncher<String[], Map<String, Boolean>> managedActivityResultLauncher = this.$launcher;
                            permissionHelper.requestPermissionOrGoToSettings(strArr, new Function1<String[], Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsFragment.ComposeContent.4.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(String[] strArr2) {
                                    invoke2(strArr2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(String[] it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    managedActivityResultLauncher.launch(it);
                                }
                            });
                            return Unit.INSTANCE;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
                        throw null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope CallsTextScreen, Composer composer2, int r7) {
                    Intrinsics.checkNotNullParameter(CallsTextScreen, "$this$CallsTextScreen");
                    if ((r7 & 81) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                        CallsTextComponentsKt.FeatureIssueDialog(CallsPermissionFragmentKt.getCallPermissions(), new AnonymousClass1(ModalBottomSheetState.this, this, managedActivityResultLauncher, null), composer2, 72);
                    }
                }
            }), startRestartGroup, 12618752, 0);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.CallsFragment$ComposeContent$5
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
                        CallsFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r20 | 1));
                    }
                };
                return;
            }
            return;
        }
        throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner".toString());
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.permissionHelper = PermissionCompat.create(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MutableStateFlow<PermissionState> mutableStateFlow = this.permissionState;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), checkPermissions()));
    }
}
