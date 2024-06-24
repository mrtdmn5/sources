package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreImpl;

/* compiled from: Merge.kt */
/* loaded from: classes4.dex */
public final class ChannelFlowMerge$collectTo$2<T> implements FlowCollector {
    public final /* synthetic */ SendingCollector<T> $collector;
    public final /* synthetic */ Job $job;
    public final /* synthetic */ ProducerScope<T> $scope;
    public final /* synthetic */ Semaphore $semaphore;

    /* compiled from: Merge.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", l = {69}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ SendingCollector<T> $collector;
        public final /* synthetic */ Flow<T> $inner;
        public final /* synthetic */ Semaphore $semaphore;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Flow<? extends T> flow, SendingCollector<T> sendingCollector, Semaphore semaphore, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$inner = flow;
            this.$collector = sendingCollector;
            this.$semaphore = semaphore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$inner, this.$collector, this.$semaphore, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            Semaphore semaphore = this.$semaphore;
            try {
                if (r1 != 0) {
                    if (r1 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Flow<T> flow = this.$inner;
                    SendingCollector<T> sendingCollector = this.$collector;
                    this.label = 1;
                    if (flow.collect(sendingCollector, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                semaphore.release();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                semaphore.release();
                throw th;
            }
        }
    }

    public ChannelFlowMerge$collectTo$2(Job job, SemaphoreImpl semaphoreImpl, ProducerScope producerScope, SendingCollector sendingCollector) {
        this.$job = job;
        this.$semaphore = semaphoreImpl;
        this.$scope = producerScope;
        this.$collector = sendingCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(kotlinx.coroutines.flow.Flow<? extends T> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlinx.coroutines.flow.Flow r5 = r0.L$1
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2 r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L56
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.Job r6 = r4.$job
            if (r6 == 0) goto L46
            boolean r2 = r6.isActive()
            if (r2 == 0) goto L41
            goto L46
        L41:
            java.util.concurrent.CancellationException r5 = r6.getCancellationException()
            throw r5
        L46:
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            kotlinx.coroutines.sync.Semaphore r6 = r4.$semaphore
            java.lang.Object r6 = r6.acquire(r0)
            if (r6 != r1) goto L55
            return r1
        L55:
            r0 = r4
        L56:
            kotlinx.coroutines.channels.ProducerScope<T> r6 = r0.$scope
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1 r1 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1
            kotlinx.coroutines.sync.Semaphore r2 = r0.$semaphore
            kotlinx.coroutines.flow.internal.SendingCollector<T> r0 = r0.$collector
            r3 = 0
            r1.<init>(r5, r0, r2, r3)
            r5 = 3
            kotlinx.coroutines.BuildersKt.launch$default(r6, r3, r3, r1, r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2.emit(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Flow) obj, (Continuation<? super Unit>) continuation);
    }
}
