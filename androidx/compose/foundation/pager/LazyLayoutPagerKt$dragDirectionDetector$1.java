package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: LazyLayoutPager.kt */
@DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1", f = "LazyLayoutPager.kt", l = {265}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class LazyLayoutPagerKt$dragDirectionDetector$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ PagerState $state;
    public /* synthetic */ Object L$0;
    public int label;

    /* compiled from: LazyLayoutPager.kt */
    @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1", f = "LazyLayoutPager.kt", l = {266}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ PointerInputScope $$this$pointerInput;
        public final /* synthetic */ PagerState $state;
        public int label;

        /* compiled from: LazyLayoutPager.kt */
        @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1", f = "LazyLayoutPager.kt", l = {268, 271}, m = "invokeSuspend")
        /* renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00101 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ PagerState $state;
            public /* synthetic */ Object L$0;
            public PointerInputChange L$1;
            public PointerInputChange L$2;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00101(PagerState pagerState, Continuation<? super C00101> continuation) {
                super(2, continuation);
                this.$state = pagerState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00101 c00101 = new C00101(this.$state, continuation);
                c00101.L$0 = obj;
                return c00101;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((C00101) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:14:0x0083  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0098  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0080 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:8:0x006f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005d -> B:6:0x0064). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r14) {
                /*
                    r13 = this;
                    kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                    int r1 = r13.label
                    r2 = 2
                    r3 = 0
                    r4 = 1
                    if (r1 == 0) goto L2e
                    if (r1 == r4) goto L26
                    if (r1 != r2) goto L1e
                    androidx.compose.ui.input.pointer.PointerInputChange r1 = r13.L$2
                    androidx.compose.ui.input.pointer.PointerInputChange r5 = r13.L$1
                    java.lang.Object r6 = r13.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
                    kotlin.ResultKt.throwOnFailure(r14)
                    r7 = r6
                    r6 = r5
                    r5 = r1
                    r1 = r0
                    r0 = r13
                    goto L64
                L1e:
                    java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r14.<init>(r0)
                    throw r14
                L26:
                    java.lang.Object r1 = r13.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                    kotlin.ResultKt.throwOnFailure(r14)
                    goto L43
                L2e:
                    kotlin.ResultKt.throwOnFailure(r14)
                    java.lang.Object r14 = r13.L$0
                    r1 = r14
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                    androidx.compose.ui.input.pointer.PointerEventPass r14 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                    r13.L$0 = r1
                    r13.label = r4
                    java.lang.Object r14 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r1, r3, r14, r13)
                    if (r14 != r0) goto L43
                    return r0
                L43:
                    androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
                    r5 = 0
                    r6 = r1
                    r1 = r5
                    r5 = r14
                    r14 = r13
                L4a:
                    if (r1 != 0) goto L98
                    androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                    r14.L$0 = r6
                    r14.L$1 = r5
                    r14.L$2 = r1
                    r14.label = r2
                    java.lang.Object r7 = r6.awaitPointerEvent(r7, r14)
                    if (r7 != r0) goto L5d
                    return r0
                L5d:
                    r12 = r0
                    r0 = r14
                    r14 = r7
                    r7 = r6
                    r6 = r5
                    r5 = r1
                    r1 = r12
                L64:
                    androidx.compose.ui.input.pointer.PointerEvent r14 = (androidx.compose.ui.input.pointer.PointerEvent) r14
                    java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r8 = r14.changes
                    int r9 = r8.size()
                    r10 = r3
                L6d:
                    if (r10 >= r9) goto L80
                    java.lang.Object r11 = r8.get(r10)
                    androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                    boolean r11 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r11)
                    if (r11 != 0) goto L7d
                    r8 = r3
                    goto L81
                L7d:
                    int r10 = r10 + 1
                    goto L6d
                L80:
                    r8 = r4
                L81:
                    if (r8 == 0) goto L92
                    java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r14 = r14.changes
                    java.lang.Object r14 = r14.get(r3)
                    androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
                    r5 = r6
                    r6 = r7
                    r12 = r1
                    r1 = r14
                    r14 = r0
                    r0 = r12
                    goto L4a
                L92:
                    r14 = r0
                    r0 = r1
                    r1 = r5
                    r5 = r6
                    r6 = r7
                    goto L4a
                L98:
                    long r2 = r5.position
                    long r0 = r1.position
                    long r0 = androidx.compose.ui.geometry.Offset.m261minusMKHz9U(r0, r2)
                    androidx.compose.foundation.pager.PagerState r14 = r14.$state
                    androidx.compose.runtime.ParcelableSnapshotMutableState r14 = r14.upDownDifference$delegate
                    androidx.compose.ui.geometry.Offset r2 = new androidx.compose.ui.geometry.Offset
                    r2.<init>(r0)
                    r14.setValue(r2)
                    kotlin.Unit r14 = kotlin.Unit.INSTANCE
                    return r14
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1.AnonymousClass1.C00101.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PointerInputScope pointerInputScope, PagerState pagerState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$pointerInput = pointerInputScope;
            this.$state = pagerState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$$this$pointerInput, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                C00101 c00101 = new C00101(this.$state, null);
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(this.$$this$pointerInput, c00101, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutPagerKt$dragDirectionDetector$1(PagerState pagerState, Continuation<? super LazyLayoutPagerKt$dragDirectionDetector$1> continuation) {
        super(2, continuation);
        this.$state = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LazyLayoutPagerKt$dragDirectionDetector$1 lazyLayoutPagerKt$dragDirectionDetector$1 = new LazyLayoutPagerKt$dragDirectionDetector$1(this.$state, continuation);
        lazyLayoutPagerKt$dragDirectionDetector$1.L$0 = obj;
        return lazyLayoutPagerKt$dragDirectionDetector$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutPagerKt$dragDirectionDetector$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((PointerInputScope) this.L$0, this.$state, null);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
