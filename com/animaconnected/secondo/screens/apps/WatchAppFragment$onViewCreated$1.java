package com.animaconnected.secondo.screens.apps;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.WatchManager;
import com.animaconnected.watch.display.WatchApp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: WatchAppFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.apps.WatchAppFragment$onViewCreated$1", f = "WatchAppFragment.kt", l = {128}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchAppFragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WatchAppFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchAppFragment$onViewCreated$1(WatchAppFragment watchAppFragment, Continuation<? super WatchAppFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = watchAppFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchAppFragment$onViewCreated$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WatchManager watchManager;
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
            watchManager = this.this$0.watchManager;
            CommonFlow<WatchApp> quickActionFlow = watchManager.getBehaviours().quickActionFlow();
            final WatchAppFragment watchAppFragment = this.this$0;
            FlowCollector<? super WatchApp> flowCollector = new FlowCollector() { // from class: com.animaconnected.secondo.screens.apps.WatchAppFragment$onViewCreated$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((WatchApp) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(WatchApp watchApp, Continuation<? super Unit> continuation) {
                    WatchAppFragment.this.getAdapter().notifyDataSetChanged();
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
        return ((WatchAppFragment$onViewCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
