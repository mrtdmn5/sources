package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: CoroutineStart.kt */
/* loaded from: classes4.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* compiled from: CoroutineStart.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[CoroutineStart.values().length];
            try {
                r0[CoroutineStart.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[CoroutineStart.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[CoroutineStart.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public final <T> void invoke(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> completion) {
        int r0 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r0 == 1) {
            try {
                DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function1, completion)), Unit.INSTANCE, null);
                return;
            } finally {
                completion.resumeWith(ResultKt.createFailure(th));
            }
        }
        if (r0 == 2) {
            Intrinsics.checkNotNullParameter(function1, "<this>");
            Intrinsics.checkNotNullParameter(completion, "completion");
            IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function1, completion)).resumeWith(Unit.INSTANCE);
            return;
        }
        if (r0 != 3) {
            if (r0 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        Intrinsics.checkNotNullParameter(completion, "completion");
        try {
            CoroutineContext context = completion.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            try {
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, function1);
                Object invoke = function1.invoke(completion);
                if (invoke != CoroutineSingletons.COROUTINE_SUSPENDED) {
                    completion.resumeWith(invoke);
                }
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        } catch (Throwable th) {
        }
    }

    public final boolean isLazy() {
        if (this == LAZY) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R, T> void invoke(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> completion) {
        int r0 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r0 == 1) {
            try {
                DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, r, completion)), Unit.INSTANCE, null);
                return;
            } finally {
                completion.resumeWith(ResultKt.createFailure(th));
            }
        }
        if (r0 == 2) {
            Intrinsics.checkNotNullParameter(function2, "<this>");
            Intrinsics.checkNotNullParameter(completion, "completion");
            IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, r, completion)).resumeWith(Unit.INSTANCE);
            return;
        }
        if (r0 != 3) {
            if (r0 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        Intrinsics.checkNotNullParameter(completion, "completion");
        try {
            CoroutineContext context = completion.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            try {
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
                Object invoke = function2.invoke(r, completion);
                if (invoke != CoroutineSingletons.COROUTINE_SUSPENDED) {
                    completion.resumeWith(invoke);
                }
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        } catch (Throwable th) {
        }
    }

    public static /* synthetic */ void isLazy$annotations() {
    }
}
