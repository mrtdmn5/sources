package kotlin.coroutines.intrinsics;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<Unit> createCoroutineUnintercepted(final Function1<? super Continuation<? super T>, ? extends Object> function1, final Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        if (function1 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function1).create(completion);
        }
        final CoroutineContext context = completion.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(completion) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(completion);
                    Intrinsics.checkNotNull(completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    int r0 = this.label;
                    if (r0 != 0) {
                        if (r0 == 1) {
                            this.label = 2;
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    ResultKt.throwOnFailure(obj);
                    Function1 function12 = Function1.this;
                    Intrinsics.checkNotNull(function12, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                    TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, function12);
                    return function12.invoke(this);
                }
            };
        }
        return new ContinuationImpl(completion, context, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
            public final /* synthetic */ Function1 $this_createCoroutineUnintercepted$inlined;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(completion, context);
                this.$this_createCoroutineUnintercepted$inlined = function1;
                Intrinsics.checkNotNull(completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                int r0 = this.label;
                if (r0 != 0) {
                    if (r0 == 1) {
                        this.label = 2;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 1;
                ResultKt.throwOnFailure(obj);
                Function1 function12 = this.$this_createCoroutineUnintercepted$inlined;
                Intrinsics.checkNotNull(function12, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, function12);
                return function12.invoke(this);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> intercepted(Continuation<? super T> continuation) {
        ContinuationImpl continuationImpl;
        Continuation<T> continuation2;
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        if (continuation instanceof ContinuationImpl) {
            continuationImpl = (ContinuationImpl) continuation;
        } else {
            continuationImpl = null;
        }
        if (continuationImpl != null && (continuation2 = (Continuation<T>) continuationImpl.intercepted()) != null) {
            return continuation2;
        }
        return continuation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(final Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, final R r, final Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(r, completion);
        }
        final CoroutineContext context = completion.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(r, completion) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                public final /* synthetic */ Object $receiver$inlined;
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(completion);
                    Intrinsics.checkNotNull(completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    int r0 = this.label;
                    if (r0 != 0) {
                        if (r0 == 1) {
                            this.label = 2;
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    ResultKt.throwOnFailure(obj);
                    Function2 function22 = Function2.this;
                    Intrinsics.checkNotNull(function22, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                    TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function22);
                    return function22.invoke(this.$receiver$inlined, this);
                }
            };
        }
        return new ContinuationImpl(completion, context, function2, r) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            public final /* synthetic */ Object $receiver$inlined;
            public final /* synthetic */ Function2 $this_createCoroutineUnintercepted$inlined;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(completion, context);
                this.$this_createCoroutineUnintercepted$inlined = function2;
                this.$receiver$inlined = r;
                Intrinsics.checkNotNull(completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                int r0 = this.label;
                if (r0 != 0) {
                    if (r0 == 1) {
                        this.label = 2;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 1;
                ResultKt.throwOnFailure(obj);
                Function2 function22 = this.$this_createCoroutineUnintercepted$inlined;
                Intrinsics.checkNotNull(function22, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function22);
                return function22.invoke(this.$receiver$inlined, this);
            }
        };
    }
}
