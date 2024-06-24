package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: Combine.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {54, 76, 79}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function0<Object[]> $arrayFactory;
    public final /* synthetic */ Flow<Object>[] $flows;
    public final /* synthetic */ FlowCollector<Object> $this_combineInternal;
    public final /* synthetic */ Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> $transform;
    public int I$0;
    public int I$1;
    public /* synthetic */ Object L$0;
    public Channel L$1;
    public byte[] L$2;
    public int label;

    /* compiled from: Combine.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {31}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1 */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Flow<Object>[] $flows;
        public final /* synthetic */ int $i;
        public final /* synthetic */ AtomicInteger $nonClosed;
        public final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;
        public int label;

        /* compiled from: Combine.kt */
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1 */
        /* loaded from: classes4.dex */
        public static final class C01391<T> implements FlowCollector {
            public final /* synthetic */ int $i;
            public final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;

            public C01391(Channel<IndexedValue<Object>> channel, int r2) {
                this.$resultChannel = channel;
                this.$i = r2;
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0053 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(T r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    r0.<init>(r5, r7)
                L18:
                    java.lang.Object r7 = r0.result
                    kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L36
                    if (r2 == r4) goto L32
                    if (r2 != r3) goto L2a
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L54
                L2a:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L32:
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L4b
                L36:
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlin.collections.IndexedValue r7 = new kotlin.collections.IndexedValue
                    int r2 = r5.$i
                    r7.<init>(r2, r6)
                    r0.label = r4
                    kotlinx.coroutines.channels.Channel<kotlin.collections.IndexedValue<java.lang.Object>> r6 = r5.$resultChannel
                    java.lang.Object r6 = r6.send(r7, r0)
                    if (r6 != r1) goto L4b
                    return r1
                L4b:
                    r0.label = r3
                    java.lang.Object r6 = kotlinx.coroutines.YieldKt.yield(r0)
                    if (r6 != r1) goto L54
                    return r1
                L54:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.AnonymousClass1.C01391.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Flow<Object>[] flowArr, int r2, AtomicInteger atomicInteger, Channel<IndexedValue<Object>> channel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$flows = flowArr;
            this.$i = r2;
            this.$nonClosed = atomicInteger;
            this.$resultChannel = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            AtomicInteger atomicInteger = this.$nonClosed;
            Channel<IndexedValue<Object>> channel = this.$resultChannel;
            try {
                if (r1 != 0) {
                    if (r1 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Flow<Object>[] flowArr = this.$flows;
                    int r12 = this.$i;
                    Flow<Object> flow = flowArr[r12];
                    C01391 c01391 = new C01391(channel, r12);
                    this.label = 1;
                    if (flow.collect(c01391, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    channel.close(null);
                }
                return Unit.INSTANCE;
            } finally {
                if (atomicInteger.decrementAndGet() == 0) {
                    channel.close(null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2(Continuation continuation, Function0 function0, Function3 function3, FlowCollector flowCollector, Flow[] flowArr) {
        super(2, continuation);
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
        this.$this_combineInternal = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(continuation, this.$arrayFactory, this.$transform, this.$this_combineInternal, this.$flows);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00da, code lost:            if (r9 != 0) goto L65;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00dc, code lost:            r13 = r4.$arrayFactory.invoke();        r14 = r4.$this_combineInternal;        r15 = r4.$transform;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e8, code lost:            if (r13 != null) goto L106;     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ea, code lost:            r4.L$0 = r12;        r4.L$1 = r11;        r4.L$2 = r10;        r4.I$0 = r9;        r4.I$1 = r2;        r4.label = r7;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fa, code lost:            if (r15.invoke(r14, r12, r4) != r1) goto L65;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fc, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fd, code lost:            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default(r12, r13, 0, 0, 14);        r4.L$0 = r12;        r4.L$1 = r11;        r4.L$2 = r10;        r4.I$0 = r9;        r4.I$1 = r2;        r4.label = 3;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0113, code lost:            if (r15.invoke(r14, r13, r4) != r1) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0115, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0024, code lost:            if (r9 != 0) goto L65;     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00fa -> B:7:0x0024). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0113 -> B:8:0x0116). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
