package kotlinx.coroutines.flow;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LookaheadDelegate;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.ObjectConstructor;
import kotlin.Function;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NopCollector;

/* loaded from: classes4.dex */
public final class FlowKt implements ObjectConstructor {
    public static final ReadonlySharedFlow asSharedFlow(MutableSharedFlow mutableSharedFlow) {
        return new ReadonlySharedFlow(mutableSharedFlow, null);
    }

    public static final CallbackFlowBuilder callbackFlow(Function2 function2) {
        return new CallbackFlowBuilder(function2, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.io.Serializable catchImpl(kotlin.coroutines.Continuation r4, kotlinx.coroutines.flow.Flow r5, kotlinx.coroutines.flow.FlowCollector r6) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            if (r0 == 0) goto L13
            r0 = r4
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.jvm.internal.Ref$ObjectRef r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r4)     // Catch: java.lang.Throwable -> L29
            goto L4c
        L29:
            r4 = move-exception
            r1 = r4
            goto L51
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            kotlin.ResultKt.throwOnFailure(r4)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2 r2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2     // Catch: java.lang.Throwable -> L4e
            r2.<init>(r6, r4)     // Catch: java.lang.Throwable -> L4e
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L4e
            r0.label = r3     // Catch: java.lang.Throwable -> L4e
            java.lang.Object r4 = r5.collect(r2, r0)     // Catch: java.lang.Throwable -> L4e
            if (r4 != r1) goto L4c
            goto L8b
        L4c:
            r1 = 0
            goto L8b
        L4e:
            r5 = move-exception
            r1 = r5
            r5 = r4
        L51:
            T r4 = r5.element
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r5 = 0
            if (r4 == 0) goto L60
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            if (r6 == 0) goto L60
            r6 = r3
            goto L61
        L60:
            r6 = r5
        L61:
            if (r6 != 0) goto L98
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            kotlinx.coroutines.Job$Key r0 = kotlinx.coroutines.Job.Key.$$INSTANCE
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r0)
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
            if (r6 == 0) goto L87
            boolean r0 = r6.isCancelled()
            if (r0 != 0) goto L78
            goto L87
        L78:
            java.util.concurrent.CancellationException r6 = r6.getCancellationException()
            if (r6 == 0) goto L85
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            if (r6 == 0) goto L85
            goto L86
        L85:
            r3 = r5
        L86:
            r5 = r3
        L87:
            if (r5 != 0) goto L98
            if (r4 != 0) goto L8c
        L8b:
            return r1
        L8c:
            boolean r5 = r1 instanceof java.util.concurrent.CancellationException
            if (r5 == 0) goto L94
            kotlin.ExceptionsKt.addSuppressed(r4, r1)
            throw r4
        L94:
            kotlin.ExceptionsKt.addSuppressed(r1, r4)
            throw r1
        L98:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.catchImpl(kotlin.coroutines.Continuation, kotlinx.coroutines.flow.Flow, kotlinx.coroutines.flow.FlowCollector):java.io.Serializable");
    }

    public static final Object collectLatest(Flow flow, Function2 function2, Continuation continuation) {
        int r0 = FlowKt__MergeKt.DEFAULT_CONCURRENCY;
        FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1(function2, null);
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        BufferOverflow bufferOverflow = BufferOverflow.SUSPEND;
        Object collect = FusibleFlow.DefaultImpls.fuse$default(new ChannelFlowTransformLatest(flowKt__MergeKt$mapLatest$1, flow, emptyCoroutineContext, -2, bufferOverflow), null, 0, bufferOverflow, 1).collect(NopCollector.INSTANCE, continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (collect != coroutineSingletons) {
            collect = Unit.INSTANCE;
        }
        if (collect != coroutineSingletons) {
            return Unit.INSTANCE;
        }
        return collect;
    }

    public static final Flow distinctUntilChanged(Flow flow) {
        FlowKt__DistinctKt$defaultKeySelector$1 flowKt__DistinctKt$defaultKeySelector$1 = FlowKt__DistinctKt.defaultKeySelector;
        if (!(flow instanceof StateFlow)) {
            Function function = FlowKt__DistinctKt.defaultKeySelector;
            FlowKt__DistinctKt$defaultAreEquivalent$1 flowKt__DistinctKt$defaultAreEquivalent$1 = FlowKt__DistinctKt.defaultAreEquivalent;
            if (flow instanceof DistinctFlowImpl) {
                DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) flow;
                if (distinctFlowImpl.keySelector == function && distinctFlowImpl.areEquivalent == flowKt__DistinctKt$defaultAreEquivalent$1) {
                    return flow;
                }
            }
            return new DistinctFlowImpl(flow);
        }
        return flow;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1] */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlinx.coroutines.internal.Symbol, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object first(kotlinx.coroutines.flow.Flow r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            kotlinx.coroutines.internal.Symbol r3 = com.google.android.gms.measurement.internal.zzgp.NULL
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1 r5 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2d
            goto L5d
        L2d:
            r6 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            r6.element = r3
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1
            r2.<init>()
            r0.L$0 = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L55
            r0.L$1 = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L55
            r0.label = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L55
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L55
            if (r5 != r1) goto L53
            goto L61
        L53:
            r0 = r6
            goto L5d
        L55:
            r5 = move-exception
            r0 = r6
            r6 = r5
            r5 = r2
        L59:
            kotlinx.coroutines.flow.FlowCollector<?> r1 = r6.owner
            if (r1 != r5) goto L6a
        L5d:
            T r1 = r0.element
            if (r1 == r3) goto L62
        L61:
            return r1
        L62:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.String r6 = "Expected at least one element"
            r5.<init>(r6)
            throw r5
        L6a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.first(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object firstOrNull(kotlinx.coroutines.flow.Flow r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 r4 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2b
            goto L59
        L2b:
            r5 = move-exception
            goto L55
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1
            r2.<init>()
            r0.L$0 = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r0.L$1 = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            if (r4 != r1) goto L4f
            goto L5b
        L4f:
            r0 = r5
            goto L59
        L51:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L55:
            kotlinx.coroutines.flow.FlowCollector<?> r1 = r5.owner
            if (r1 != r4) goto L5c
        L59:
            T r1 = r0.element
        L5b:
            return r1
        L5c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.firstOrNull(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static Flow flattenMerge$default(final FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1) {
        boolean z;
        int r2 = FlowKt__MergeKt.DEFAULT_CONCURRENCY;
        if (r2 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r2 == 1) {
                return new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1
                    @Override // kotlinx.coroutines.flow.Flow
                    public final Object collect(FlowCollector<? super Object> flowCollector, Continuation<? super Unit> continuation) {
                        Object collect = flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.collect(new FlowKt__MergeKt$flattenConcat$1$1(flowCollector), continuation);
                        if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                            return collect;
                        }
                        return Unit.INSTANCE;
                    }
                };
            }
            return new ChannelFlowMerge(flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1, r2, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Expected positive concurrency level, but had ", r2).toString());
    }

    public static final Flow flowOn(Flow flow, CoroutineDispatcher coroutineDispatcher) {
        boolean z;
        if (coroutineDispatcher.get(Job.Key.$$INSTANCE) == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (!Intrinsics.areEqual(coroutineDispatcher, EmptyCoroutineContext.INSTANCE)) {
                if (flow instanceof FusibleFlow) {
                    return FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) flow, coroutineDispatcher, 0, null, 6);
                }
                return new ChannelFlowOperatorImpl(flow, coroutineDispatcher, 0, null, 12);
            }
            return flow;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineDispatcher).toString());
    }

    public static final LookaheadDelegate getRootLookaheadDelegate(LookaheadDelegate lookaheadDelegate) {
        LayoutNode layoutNode;
        Intrinsics.checkNotNullParameter(lookaheadDelegate, "<this>");
        LayoutNode layoutNode2 = lookaheadDelegate.coordinator.layoutNode;
        while (true) {
            LayoutNode parent$ui_release = layoutNode2.getParent$ui_release();
            LayoutNode layoutNode3 = null;
            if (parent$ui_release != null) {
                layoutNode = parent$ui_release.lookaheadRoot;
            } else {
                layoutNode = null;
            }
            if (layoutNode != null) {
                LayoutNode parent$ui_release2 = layoutNode2.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutNode3 = parent$ui_release2.lookaheadRoot;
                }
                Intrinsics.checkNotNull(layoutNode3);
                LayoutNode parent$ui_release3 = layoutNode2.getParent$ui_release();
                Intrinsics.checkNotNull(parent$ui_release3);
                layoutNode2 = parent$ui_release3.lookaheadRoot;
                Intrinsics.checkNotNull(layoutNode2);
            } else {
                LookaheadDelegate lookaheadDelegate2 = layoutNode2.nodes.outerCoordinator.getLookaheadDelegate();
                Intrinsics.checkNotNull(lookaheadDelegate2);
                return lookaheadDelegate2;
            }
        }
    }

    public static final StandaloneCoroutine launchIn(Flow flow, CoroutineScope coroutineScope) {
        return BuildersKt.launch$default(coroutineScope, null, null, new FlowKt__CollectKt$launchIn$1(flow, null), 3);
    }

    public static final ReadonlySharedFlow shareIn(Flow flow, CoroutineScope coroutineScope, StartedWhileSubscribed startedWhileSubscribed, int r11) {
        SharingConfig configureSharing$FlowKt__ShareKt = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt(flow, r11);
        SharedFlowImpl MutableSharedFlow = SharedFlowKt.MutableSharedFlow(r11, configureSharing$FlowKt__ShareKt.extraBufferCapacity, configureSharing$FlowKt__ShareKt.onBufferOverflow);
        return new ReadonlySharedFlow(MutableSharedFlow, FlowKt__ShareKt.launchSharing$FlowKt__ShareKt(coroutineScope, configureSharing$FlowKt__ShareKt.context, configureSharing$FlowKt__ShareKt.upstream, MutableSharedFlow, startedWhileSubscribed, SharedFlowKt.NO_VALUE));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlinx.coroutines.internal.Symbol, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object single(kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1 r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            kotlinx.coroutines.internal.Symbol r3 = com.google.android.gms.measurement.internal.zzgp.NULL
            r4 = 1
            if (r2 == 0) goto L33
            if (r2 != r4) goto L2b
            kotlin.jvm.internal.Ref$ObjectRef r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4e
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            r6.element = r3
            kotlinx.coroutines.flow.FlowKt__ReduceKt$single$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$single$2
            r2.<init>()
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r5 = r5.collect(r2, r0)
            if (r5 != r1) goto L4d
            goto L52
        L4d:
            r5 = r6
        L4e:
            T r1 = r5.element
            if (r1 == r3) goto L53
        L52:
            return r1
        L53:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.String r6 = "Flow is empty"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.single(kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        return new LinkedTreeMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:            if (r6.collect(r2, r0) == r1) goto L66;     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlinx.coroutines.internal.Symbol, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object first(kotlinx.coroutines.flow.Flow r6, kotlin.jvm.functions.Function2 r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            kotlinx.coroutines.internal.Symbol r3 = com.google.android.gms.measurement.internal.zzgp.NULL
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L35
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r6 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r7 = r0.L$1
            kotlin.jvm.functions.Function2 r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2f
            goto L64
        L2f:
            r8 = move-exception
            r5 = r8
            r8 = r7
            r7 = r0
            r0 = r5
            goto L5e
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            r8.element = r3
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2
            r2.<init>(r7, r8)
            r0.L$0 = r7     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5b
            r0.L$1 = r8     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5b
            r0.L$2 = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5b
            r0.label = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5b
            java.lang.Object r6 = r6.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5b
            if (r6 != r1) goto L62
            goto L68
        L5b:
            r6 = move-exception
            r0 = r6
            r6 = r2
        L5e:
            kotlinx.coroutines.flow.FlowCollector<?> r1 = r0.owner
            if (r1 != r6) goto L7d
        L62:
            r0 = r7
            r7 = r8
        L64:
            T r1 = r7.element
            if (r1 == r3) goto L69
        L68:
            return r1
        L69:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Expected at least one element matching the predicate "
            r7.<init>(r8)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L7d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.first(kotlinx.coroutines.flow.Flow, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object firstOrNull(kotlinx.coroutines.flow.Flow r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r4 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2b
            goto L59
        L2b:
            r6 = move-exception
            goto L55
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2
            r2.<init>(r5, r6)
            r0.L$0 = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r0.L$1 = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            if (r4 != r1) goto L4f
            goto L5b
        L4f:
            r5 = r6
            goto L59
        L51:
            r4 = move-exception
            r5 = r6
            r6 = r4
            r4 = r2
        L55:
            kotlinx.coroutines.flow.FlowCollector<?> r0 = r6.owner
            if (r0 != r4) goto L5c
        L59:
            T r1 = r5.element
        L5b:
            return r1
        L5c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.firstOrNull(kotlinx.coroutines.flow.Flow, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
