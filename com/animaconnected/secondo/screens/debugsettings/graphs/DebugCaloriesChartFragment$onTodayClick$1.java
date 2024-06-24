package com.animaconnected.secondo.screens.debugsettings.graphs;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.workout.CaloriesViewModel;
import java.util.Collection;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: DebugCaloriesChartFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.graphs.DebugCaloriesChartFragment$onTodayClick$1", f = "DebugCaloriesChartFragment.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugCaloriesChartFragment$onTodayClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DebugCaloriesChartFragment this$0;

    /* compiled from: DebugCaloriesChartFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.graphs.DebugCaloriesChartFragment$onTodayClick$1$1", f = "DebugCaloriesChartFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.debugsettings.graphs.DebugCaloriesChartFragment$onTodayClick$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ChartData<? extends BarEntry>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DebugCaloriesChartFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DebugCaloriesChartFragment debugCaloriesChartFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = debugCaloriesChartFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ChartData<BarEntry> chartData, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(chartData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChartData chartData = (ChartData) this.L$0;
                this.this$0.caloriesData = CollectionsKt___CollectionsKt.toMutableList((Collection) chartData.getEntries());
                this.this$0.invalidateCurrentScreen();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ChartData<? extends BarEntry> chartData, Continuation<? super Unit> continuation) {
            return invoke2((ChartData<BarEntry>) chartData, continuation);
        }
    }

    /* compiled from: DebugCaloriesChartFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.graphs.DebugCaloriesChartFragment$onTodayClick$1$2", f = "DebugCaloriesChartFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.debugsettings.graphs.DebugCaloriesChartFragment$onTodayClick$1$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super ChartData<? extends BarEntry>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ DebugCaloriesChartFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DebugCaloriesChartFragment debugCaloriesChartFragment, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.this$0 = debugCaloriesChartFragment;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super ChartData<? extends BarEntry>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super ChartData<BarEntry>>) flowCollector, th, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LogKt.debug$default(this.L$0, "Exception from today steps, maybe watch was just closed?", this.this$0.getName(), (Throwable) this.L$1, false, 8, (Object) null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super ChartData<BarEntry>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
            anonymousClass2.L$0 = flowCollector;
            anonymousClass2.L$1 = th;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugCaloriesChartFragment$onTodayClick$1(DebugCaloriesChartFragment debugCaloriesChartFragment, Continuation<? super DebugCaloriesChartFragment$onTodayClick$1> continuation) {
        super(2, continuation);
        this.this$0 = debugCaloriesChartFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DebugCaloriesChartFragment$onTodayClick$1 debugCaloriesChartFragment$onTodayClick$1 = new DebugCaloriesChartFragment$onTodayClick$1(this.this$0, continuation);
        debugCaloriesChartFragment$onTodayClick$1.L$0 = obj;
        return debugCaloriesChartFragment$onTodayClick$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CaloriesViewModel caloriesViewModel;
        CoroutineScope coroutineScope;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            caloriesViewModel = this.this$0.viewModel;
            this.L$0 = coroutineScope2;
            this.label = 1;
            Object observeCaloriesToday = caloriesViewModel.observeCaloriesToday(this);
            if (observeCaloriesToday == coroutineSingletons) {
                return coroutineSingletons;
            }
            coroutineScope = coroutineScope2;
            obj = observeCaloriesToday;
        }
        FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AnonymousClass1(this.this$0, null), (Flow) obj), new AnonymousClass2(this.this$0, null)), coroutineScope);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugCaloriesChartFragment$onTodayClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
