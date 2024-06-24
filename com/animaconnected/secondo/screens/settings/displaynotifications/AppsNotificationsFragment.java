package com.animaconnected.secondo.screens.settings.displaynotifications;

import android.content.Context;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.onboarding.OnboardingPermissionKt;
import com.animaconnected.secondo.screens.onboarding.PermissionState;
import com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt;
import com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt;
import com.google.common.base.Strings;
import com.google.common.collect.Hashing;
import com.google.common.collect.Platform;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AppsNotificationsFragment.kt */
/* loaded from: classes3.dex */
public final class AppsNotificationsFragment extends ComposeFragment {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "AppsNotificationsFragment";
    private final DisplayNotificationViewModel viewModel = new DisplayNotificationViewModel();
    private final MutableStateFlow<PermissionState> permissionState = StateFlowKt.MutableStateFlow(PermissionState.Idle.INSTANCE);

    /* compiled from: AppsNotificationsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isBadgeVisible() {
            return !OnboardingPermissionKt.arePermissionsGranted(SmsPermissionFragmentKt.getSmsPermissions());
        }

        public final AppsNotificationsFragment newInstance() {
            return new AppsNotificationsFragment();
        }

        private Companion() {
        }
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
    public static final boolean ComposeContent$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private final PermissionState checkPermissions() {
        if (OnboardingPermissionKt.arePermissionsGranted(SmsPermissionFragmentKt.getSmsPermissions())) {
            return PermissionState.Granted.INSTANCE;
        }
        return PermissionState.Denied.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$2, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$3, kotlin.jvm.internal.Lambda] */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r26) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-44627210);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-950656152);
        Object nextSlot = startRestartGroup.nextSlot();
        if (nextSlot == Composer.Companion.Empty) {
            nextSlot = Platform.mutableStateOf$default(Boolean.FALSE);
            startRestartGroup.updateValue(nextSlot);
        }
        final MutableState mutableState = (MutableState) nextSlot;
        startRestartGroup.end(false);
        final ModalBottomSheetState rememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, false, startRestartGroup, 14);
        final PermissionState permissionState = (PermissionState) Platform.collectAsState(this.permissionState, startRestartGroup).getValue();
        final MutableState rememberUpdatedState = Platform.rememberUpdatedState(Boolean.valueOf(WindowInsets_androidKt.isImeVisible(startRestartGroup)), startRestartGroup);
        final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.LocalFocusManager);
        EffectsKt.LaunchedEffect(permissionState, new AppsNotificationsFragment$ComposeContent$1(permissionState, rememberModalBottomSheetState, null), startRestartGroup);
        long j = Color.Transparent;
        long j2 = Color.White;
        ModalBottomSheetKt.m191ModalBottomSheetLayoutGs3lGvM(ComposableLambdaKt.composableLambda(startRestartGroup, -1183727580, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$2

            /* compiled from: AppsNotificationsFragment.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$2$1", f = "AppsNotificationsFragment.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$2$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ AppsNotificationsFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(AppsNotificationsFragment appsNotificationsFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                    this.this$0 = appsNotificationsFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        NotificationUtil notificationUtil = NotificationUtil.INSTANCE;
                        Context requireContext = this.this$0.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                        notificationUtil.openNotificationAccess(requireContext);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope ModalBottomSheetLayout, Composer composer2, int r5) {
                Intrinsics.checkNotNullParameter(ModalBottomSheetLayout, "$this$ModalBottomSheetLayout");
                if ((r5 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    CallsTextComponentsKt.FeatureIssueDialog(SmsPermissionFragmentKt.getSmsPermissions(), new AnonymousClass1(AppsNotificationsFragment.this, null), composer2, 72);
                }
            }
        }), null, rememberModalBottomSheetState, false, RectangleShapeKt.RectangleShape, 0.0f, j2, 0L, j, ComposableLambdaKt.composableLambda(startRestartGroup, 1391308061, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(Composer composer2, int r21) {
                boolean ComposeContent$lambda$2;
                DisplayNotificationViewModel displayNotificationViewModel;
                boolean ComposeContent$lambda$22;
                if ((r21 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                Modifier m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(companion, ((Colors) composer2.consume(ColorsKt.LocalColors)).m164getBackground0d7_KjU(), RectangleShapeKt.RectangleShape);
                final AppsNotificationsFragment appsNotificationsFragment = AppsNotificationsFragment.this;
                final MutableState<Boolean> mutableState2 = mutableState;
                PermissionState permissionState2 = permissionState;
                ModalBottomSheetState modalBottomSheetState = rememberModalBottomSheetState;
                FocusManager focusManager2 = focusManager;
                State<Boolean> state = rememberUpdatedState;
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m21backgroundbw27NRU);
                if (composer2.getApplier() instanceof Applier) {
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        composer2.useNode();
                    }
                    Updater.m228setimpl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    modifierMaterializerOf.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                    composer2.startReplaceableGroup(2058660585);
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$3$1$1
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
                            AppsNotificationsFragment.this.getMainController().goBack();
                        }
                    };
                    composer2.startReplaceableGroup(837324062);
                    Object rememberedValue = composer2.rememberedValue();
                    if (rememberedValue == Composer.Companion.Empty) {
                        rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$3$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                AppsNotificationsFragment.ComposeContent$lambda$3(mutableState2, true);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceableGroup();
                    Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$3$1$3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String query) {
                            DisplayNotificationViewModel displayNotificationViewModel2;
                            Intrinsics.checkNotNullParameter(query, "query");
                            displayNotificationViewModel2 = AppsNotificationsFragment.this.viewModel;
                            displayNotificationViewModel2.filterApps(query);
                        }
                    };
                    Function0<Unit> function02 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$3$1$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            DisplayNotificationViewModel displayNotificationViewModel2;
                            displayNotificationViewModel2 = AppsNotificationsFragment.this.viewModel;
                            displayNotificationViewModel2.filterApps("");
                            AppsNotificationsFragment.ComposeContent$lambda$3(mutableState2, false);
                        }
                    };
                    ComposeContent$lambda$2 = AppsNotificationsFragment.ComposeContent$lambda$2(mutableState2);
                    AppsNotificationsFragmentKt.access$SearchTopAppBar(null, function0, (Function0) rememberedValue, function1, function02, ComposeContent$lambda$2, composer2, 384, 1);
                    Modifier m73paddingVpY3zN4$default = PaddingKt.m73paddingVpY3zN4$default(companion, 32, 0.0f, 2);
                    displayNotificationViewModel = appsNotificationsFragment.viewModel;
                    AppsUIState appsUIState = (AppsUIState) Platform.collectAsState(displayNotificationViewModel.getAppUiState(), composer2).getValue();
                    AppsNotificationsFragment$ComposeContent$3$1$5 appsNotificationsFragment$ComposeContent$3$1$5 = new AppsNotificationsFragment$ComposeContent$3$1$5(permissionState2, modalBottomSheetState, appsNotificationsFragment, null);
                    AppsNotificationsFragment$ComposeContent$3$1$6 appsNotificationsFragment$ComposeContent$3$1$6 = new AppsNotificationsFragment$ComposeContent$3$1$6(permissionState2, focusManager2, modalBottomSheetState, appsNotificationsFragment, state, null);
                    ComposeContent$lambda$22 = AppsNotificationsFragment.ComposeContent$lambda$2(mutableState2);
                    AppsNotificationsFragmentKt.access$AppsList(m73paddingVpY3zN4$default, appsUIState, appsNotificationsFragment$ComposeContent$3$1$5, appsNotificationsFragment$ComposeContent$3$1$6, ComposeContent$lambda$22, composer2, 4678, 0);
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, 907567622, 170);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$4
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
                    AppsNotificationsFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r26 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MutableStateFlow<PermissionState> mutableStateFlow = this.permissionState;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), checkPermissions()));
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), Dispatchers.IO, null, new AppsNotificationsFragment$onResume$2(this, null), 2);
    }
}
