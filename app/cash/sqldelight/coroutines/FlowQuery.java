package app.cash.sqldelight.coroutines;

import app.cash.sqldelight.Query;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SafeFlow;

/* compiled from: FlowExtensions.kt */
/* loaded from: classes.dex */
public final class FlowQuery {
    /* JADX WARN: Type inference failed for: r0v2, types: [app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1] */
    public static final FlowQuery$mapToList$$inlined$map$1 mapToList(final Flow flow, final CoroutineDispatcher context) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return new Flow<List<Object>>() { // from class: app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                public final /* synthetic */ CoroutineContext $context$inlined;
                public final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1$2", f = "FlowExtensions.kt", l = {224, 223}, m = "emit")
                /* renamed from: app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public FlowCollector L$0;
                    public int label;
                    public /* synthetic */ Object result;

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

                public AnonymousClass2(FlowCollector flowCollector, CoroutineContext coroutineContext) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$context$inlined = coroutineContext;
                }

                /* JADX WARN: Removed duplicated region for block: B:19:0x005c A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1$2$1 r0 = (app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1$2$1 r0 = new app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 0
                        r4 = 2
                        r5 = 1
                        if (r2 == 0) goto L39
                        if (r2 == r5) goto L33
                        if (r2 != r4) goto L2b
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L5d
                    L2b:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L33:
                        kotlinx.coroutines.flow.FlowCollector r7 = r0.L$0
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L52
                    L39:
                        kotlin.ResultKt.throwOnFailure(r8)
                        app.cash.sqldelight.Query r7 = (app.cash.sqldelight.Query) r7
                        app.cash.sqldelight.coroutines.FlowQuery$mapToList$1$1 r8 = new app.cash.sqldelight.coroutines.FlowQuery$mapToList$1$1
                        r8.<init>(r7, r3)
                        kotlinx.coroutines.flow.FlowCollector r7 = r6.$this_unsafeFlow
                        r0.L$0 = r7
                        r0.label = r5
                        kotlin.coroutines.CoroutineContext r2 = r6.$context$inlined
                        java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r2, r8, r0)
                        if (r8 != r1) goto L52
                        return r1
                    L52:
                        r0.L$0 = r3
                        r0.label = r4
                        java.lang.Object r7 = r7.emit(r8, r0)
                        if (r7 != r1) goto L5d
                        return r1
                    L5d:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super List<Object>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, context), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static final SafeFlow toFlow(Query query) {
        Intrinsics.checkNotNullParameter(query, "<this>");
        return new SafeFlow(new FlowQuery$asFlow$1(query, null));
    }
}
