package com.animaconnected.secondo.screens.debugsettings.graphs;

import android.os.Bundle;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.widget.compose.ChartsKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: DebugRestingHeartRateChart.kt */
/* loaded from: classes3.dex */
public final class DebugRestingHeartRateChart extends ComposeFragment {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "DebugRestingHeartRateChart";
    private boolean isDetailScreen = true;

    /* compiled from: DebugRestingHeartRateChart.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DebugRestingHeartRateChart newInstance(boolean z) {
            DebugRestingHeartRateChart debugRestingHeartRateChart = new DebugRestingHeartRateChart();
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_detail_screen", z);
            debugRestingHeartRateChart.setArguments(bundle);
            return debugRestingHeartRateChart;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.animaconnected.secondo.screens.debugsettings.graphs.DebugRestingHeartRateChart$ComposeContent$3, kotlin.jvm.internal.Lambda] */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r9) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1522547530);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(1810669767);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = new DebugRestingHeartRateChartVm();
            startRestartGroup.updateValue(nextSlot);
        }
        final DebugRestingHeartRateChartVm debugRestingHeartRateChartVm = (DebugRestingHeartRateChartVm) nextSlot;
        Object m = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 1810669833);
        if (m == composer$Companion$Empty$1) {
            m = debugRestingHeartRateChartVm.getEntries();
            startRestartGroup.updateValue(m);
        }
        startRestartGroup.end(false);
        final List list = (List) Platform.collectAsState((MutableStateFlow) m, EmptyList.INSTANCE, null, startRestartGroup, 2).getValue();
        Object m2 = BottomSheetScaffoldKt$$ExternalSyntheticOutline0.m(startRestartGroup, 773894976, -492369756);
        if (m2 == composer$Companion$Empty$1) {
            m2 = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) m2).coroutineScope;
        startRestartGroup.end(false);
        DebugChartKt.DebugLineChartScreen(new Function2<Integer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugRestingHeartRateChart$ComposeContent$1

            /* compiled from: DebugRestingHeartRateChart.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.graphs.DebugRestingHeartRateChart$ComposeContent$1$1", f = "DebugRestingHeartRateChart.kt", l = {65}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.debugsettings.graphs.DebugRestingHeartRateChart$ComposeContent$1$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ int $baseline;
                final /* synthetic */ int $range;
                final /* synthetic */ DebugRestingHeartRateChartVm $viewModel;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(DebugRestingHeartRateChartVm debugRestingHeartRateChartVm, int r2, int r3, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$viewModel = debugRestingHeartRateChartVm;
                    this.$baseline = r2;
                    this.$range = r3;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$viewModel, this.$baseline, this.$range, continuation);
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
                        DebugRestingHeartRateChartVm debugRestingHeartRateChartVm = this.$viewModel;
                        int r12 = this.$baseline;
                        int r3 = this.$range;
                        this.label = 1;
                        if (debugRestingHeartRateChartVm.randomizeData(r12, r3, this) == coroutineSingletons) {
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
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int r5, int r6) {
                BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(debugRestingHeartRateChartVm, r5, r6, null), 3);
            }
        }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugRestingHeartRateChart$ComposeContent$2
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
                DebugRestingHeartRateChart.this.getMainController().goBack();
            }
        }, ComposableLambdaKt.composableLambda(startRestartGroup, 1304674772, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugRestingHeartRateChart$ComposeContent$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope DebugLineChartScreen, Composer composer2, int r6) {
                boolean z;
                Intrinsics.checkNotNullParameter(DebugLineChartScreen, "$this$DebugLineChartScreen");
                if ((r6 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                z = DebugRestingHeartRateChart.this.isDetailScreen;
                if (z) {
                    composer2.startReplaceableGroup(740858137);
                    int r4 = Modifier.$r8$clinit;
                    ChartsKt.RestingHeartRateDetailChart(PaddingKt.m71padding3ABfNKs(SizeKt.m83height3ABfNKs(Modifier.Companion.$$INSTANCE, 180), 8), list, composer2, 70, 0);
                    composer2.endReplaceableGroup();
                    return;
                }
                composer2.startReplaceableGroup(740858407);
                int r42 = Modifier.$r8$clinit;
                ChartsKt.RestingHeartRateHistoryChart(PaddingKt.m71padding3ABfNKs(SizeKt.m83height3ABfNKs(Modifier.Companion.$$INSTANCE, 500), 8), list, composer2, 70, 0);
                composer2.endReplaceableGroup();
            }
        }), startRestartGroup, 384);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugRestingHeartRateChart$ComposeContent$4
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
                    DebugRestingHeartRateChart.this.ComposeContent(composer2, Strings.updateChangedFlags(r9 | 1));
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

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.isDetailScreen = arguments.getBoolean("is_detail_screen");
        }
    }
}
