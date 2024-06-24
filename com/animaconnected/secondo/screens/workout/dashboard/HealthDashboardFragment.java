package com.animaconnected.secondo.screens.workout.dashboard;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.watch.HideWatchLayouter;
import com.animaconnected.secondo.screens.watch.WatchViewLayouter;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.HealthSettingsViewModel;
import com.animaconnected.watch.fitness.MockFitnessProvider;
import com.animaconnected.watch.fitness.mock.HeartRateMock;
import com.animaconnected.watch.theme.ChartTheme;
import com.animaconnected.watch.workout.DashboardViewModel;
import com.animaconnected.watch.workout.HealthOnboardingState;
import com.animaconnected.widget.SessionCardData;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: HealthDashboardFragment.kt */
/* loaded from: classes3.dex */
public final class HealthDashboardFragment extends ComposeFragment implements WatchViewLayouter {
    public static final String name = "HealthDashboardFragment";
    private final /* synthetic */ HideWatchLayouter $$delegate_0 = new HideWatchLayouter(0, 1, null);
    private final Lazy featurePathName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$featurePathName$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String string = HealthDashboardFragment.this.getString(R.string.health_top_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
    });
    private final String name$1 = name;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: HealthDashboardFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseFragment newInstance() {
            return new HealthDashboardFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HealthOnboardingState ComposeContent$lambda$10(State<? extends HealthOnboardingState> state) {
        return state.getValue();
    }

    private static final boolean ComposeContent$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ComposeContent$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final SessionCardData ComposeContent$lambda$7(State<SessionCardData> state) {
        return state.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r19) {
        Object obj;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1275468572);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(1087554110);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = new DashboardViewModel(ProviderFactory.getWatch().fitness());
            startRestartGroup.updateValue(nextSlot);
        }
        final DashboardViewModel dashboardViewModel = (DashboardViewModel) nextSlot;
        Object m = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 1087554206);
        if (m == composer$Companion$Empty$1) {
            m = new HealthSettingsViewModel(ProviderFactory.getWatch().fitness());
            startRestartGroup.updateValue(m);
        }
        HealthSettingsViewModel healthSettingsViewModel = (HealthSettingsViewModel) m;
        Object m2 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 1087554301);
        if (m2 == composer$Companion$Empty$1) {
            m2 = Platform.mutableStateOf$default(Boolean.FALSE);
            startRestartGroup.updateValue(m2);
        }
        MutableState mutableState = (MutableState) m2;
        Object m3 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 1087554360);
        HeartRateMock heartRateMock = null;
        if (m3 == composer$Companion$Empty$1) {
            final CommonFlow latestWorkout$default = DashboardViewModel.getLatestWorkout$default(dashboardViewModel, null, 1, null);
            Flow<SessionCardData> flow = new Flow<SessionCardData>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$lambda$6$$inlined$map$1

                /* compiled from: Emitters.kt */
                /* renamed from: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$lambda$6$$inlined$map$1$2, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @DebugMetadata(c = "com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$lambda$6$$inlined$map$1$2", f = "HealthDashboardFragment.kt", l = {223}, m = "emit")
                    /* renamed from: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$lambda$6$$inlined$map$1$2$1, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$lambda$6$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$lambda$6$$inlined$map$1$2$1 r0 = (com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$lambda$6$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$lambda$6$$inlined$map$1$2$1 r0 = new com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$lambda$6$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L2f
                            if (r2 != r3) goto L27
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L47
                        L27:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L2f:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                            com.animaconnected.watch.workout.SessionListItem r5 = (com.animaconnected.watch.workout.SessionListItem) r5
                            if (r5 == 0) goto L3d
                            com.animaconnected.widget.SessionCardData r5 = com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardUtilsKt.toSessionCardData(r5)
                            goto L3e
                        L3d:
                            r5 = 0
                        L3e:
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L47
                            return r1
                        L47:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$lambda$6$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super SessionCardData> flowCollector, Continuation continuation) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateValue(flow);
            m3 = flow;
        }
        startRestartGroup.end(false);
        MutableState collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle((Flow) m3, null, startRestartGroup, 56);
        startRestartGroup.startReplaceableGroup(1087554577);
        Object nextSlot2 = startRestartGroup.nextSlot();
        int r3 = 3;
        if (nextSlot2 == composer$Companion$Empty$1) {
            nextSlot2 = new DashboardViewModel(new MockFitnessProvider(heartRateMock, 0 == true ? 1 : 0, r3, 0 == true ? 1 : 0)).getMetrics();
            startRestartGroup.updateValue(nextSlot2);
        }
        List list = (List) nextSlot2;
        Object m4 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 1087554674);
        if (m4 == composer$Companion$Empty$1) {
            m4 = HealthDashboardUtilsKt.toSessionCardData(new MockFitnessProvider(0 == true ? 1 : 0, 0 == true ? 1 : 0, r3, 0 == true ? 1 : 0).healthOnboardingSessions());
            startRestartGroup.updateValue(m4);
        }
        startRestartGroup.end(false);
        int r16 = SessionCardData.$stable;
        HealthOnboardingUIState rememberHealthOnboardingUIState = HealthOnboardingKt.rememberHealthOnboardingUIState((SessionCardData) m4, list, null, 0, startRestartGroup, r16 | 64, 12);
        MutableState collectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(dashboardViewModel.getCurrentState(), startRestartGroup);
        Unit unit = Unit.INSTANCE;
        startRestartGroup.startReplaceableGroup(1087554882);
        Object nextSlot3 = startRestartGroup.nextSlot();
        if (nextSlot3 == composer$Companion$Empty$1) {
            nextSlot3 = new HealthDashboardFragment$ComposeContent$1$1(mutableState, null);
            startRestartGroup.updateValue(nextSlot3);
        }
        startRestartGroup.end(false);
        EffectsKt.LaunchedEffect(unit, (Function2) nextSlot3, startRestartGroup);
        EffectsKt.LaunchedEffect(ComposeContent$lambda$10(collectAsStateWithLifecycle2), new HealthDashboardFragment$ComposeContent$2(rememberHealthOnboardingUIState, dashboardViewModel, collectAsStateWithLifecycle2, null), startRestartGroup);
        Modifier m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(Modifier.Companion.$$INSTANCE, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m164getBackground0d7_KjU(), RectangleShapeKt.RectangleShape);
        startRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.TopStart, false, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m21backgroundbw27NRU);
        if (startRestartGroup.applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-488062727);
            Object nextSlot4 = startRestartGroup.nextSlot();
            if (nextSlot4 == composer$Companion$Empty$1) {
                nextSlot4 = new GoalData(dashboardViewModel.getDailyGoalItem(), healthSettingsViewModel.getGoals());
                startRestartGroup.updateValue(nextSlot4);
            }
            GoalData goalData = (GoalData) nextSlot4;
            Object m5 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -488062497);
            if (m5 == composer$Companion$Empty$1) {
                m5 = dashboardViewModel.getMetrics();
                startRestartGroup.updateValue(m5);
            }
            List list2 = (List) m5;
            startRestartGroup.end(false);
            SessionCardData ComposeContent$lambda$7 = ComposeContent$lambda$7(collectAsStateWithLifecycle);
            HealthOnboardingState ComposeContent$lambda$10 = ComposeContent$lambda$10(collectAsStateWithLifecycle2);
            boolean ComposeContent$lambda$3 = ComposeContent$lambda$3(mutableState);
            startRestartGroup.startReplaceableGroup(-488062257);
            Object nextSlot5 = startRestartGroup.nextSlot();
            if (nextSlot5 == composer$Companion$Empty$1) {
                obj = null;
                nextSlot5 = DashboardViewModel.lastSynced$default(dashboardViewModel, null, null, 3, null);
                startRestartGroup.updateValue(nextSlot5);
            } else {
                obj = null;
            }
            startRestartGroup.end(false);
            String str = (String) FlowExtKt.collectAsStateWithLifecycle((CommonFlow) nextSlot5, obj, startRestartGroup, 56).getValue();
            startRestartGroup.startReplaceableGroup(-488062149);
            Object nextSlot6 = startRestartGroup.nextSlot();
            if (nextSlot6 == composer$Companion$Empty$1) {
                ProviderFactory providerFactory = ProviderFactory.INSTANCE;
                nextSlot6 = new ChartTheme(providerFactory.getThemeProvider().getChartColors(), providerFactory.getThemeProvider().getChartFonts());
                startRestartGroup.updateValue(nextSlot6);
            }
            startRestartGroup.end(false);
            HealthDashboardScreenKt.HealthDashboardScreen(goalData, ComposeContent$lambda$7, list2, rememberHealthOnboardingUIState, ComposeContent$lambda$10, ComposeContent$lambda$3, str, (ChartTheme) nextSlot6, new Function1<ClickEvent, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$3$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ClickEvent clickEvent) {
                    invoke2(clickEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ClickEvent clickEvent) {
                    Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
                    HealthDashboardFragmentKt.handleClicks(HealthDashboardFragment.this.getMainController(), clickEvent, dashboardViewModel);
                }
            }, startRestartGroup, (r16 << 3) | 16781832);
            startRestartGroup.startReplaceableGroup(1087556478);
            startRestartGroup.end(false);
            startRestartGroup.end(false);
            startRestartGroup.end(true);
            startRestartGroup.end(false);
            startRestartGroup.end(false);
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r32) {
                        HealthDashboardFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r19 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
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
    public String getFeaturePathName() {
        return (String) this.featurePathName$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name$1;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r2, int r3, int r4, int r5) {
        return this.$$delegate_0.getWatchOffset(r2, r3, r4, r5);
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int hideWatch() {
        return 1;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewLayouted() {
        this.$$delegate_0.onWatchViewLayouted();
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewUpdated(int r2) {
        this.$$delegate_0.onWatchViewUpdated(r2);
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r7, int r8, int r9, int r10, int r11) {
        return this.$$delegate_0.getWatchOffset(r7, r8, r9, r10, r11);
    }
}
