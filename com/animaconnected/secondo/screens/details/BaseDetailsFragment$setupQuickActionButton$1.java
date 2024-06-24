package com.animaconnected.secondo.screens.details;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.display.WatchApp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: BaseDetailsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.details.BaseDetailsFragment$setupQuickActionButton$1", f = "BaseDetailsFragment.kt", l = {R.styleable.AppTheme_stepsHistoryHintRoundnessActivity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BaseDetailsFragment$setupQuickActionButton$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $updateVisibility;
    int label;
    final /* synthetic */ BaseDetailsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDetailsFragment$setupQuickActionButton$1(BaseDetailsFragment baseDetailsFragment, Function0<Unit> function0, Continuation<? super BaseDetailsFragment$setupQuickActionButton$1> continuation) {
        super(2, continuation);
        this.this$0 = baseDetailsFragment;
        this.$updateVisibility = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseDetailsFragment$setupQuickActionButton$1(this.this$0, this.$updateVisibility, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WatchProvider watch;
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
            watch = this.this$0.getWatch();
            CommonFlow<WatchApp> quickActionFlow = watch.getWatchManager().getBehaviours().quickActionFlow();
            final Function0<Unit> function0 = this.$updateVisibility;
            FlowCollector<? super WatchApp> flowCollector = new FlowCollector() { // from class: com.animaconnected.secondo.screens.details.BaseDetailsFragment$setupQuickActionButton$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((WatchApp) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(WatchApp watchApp, Continuation<? super Unit> continuation) {
                    function0.invoke();
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (quickActionFlow.collect(flowCollector, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseDetailsFragment$setupQuickActionButton$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
