package io.ktor.util.pipeline;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SuspendFunctionGun.kt */
/* loaded from: classes3.dex */
public final class SuspendFunctionGun$continuation$1 implements Continuation<Unit>, CoroutineStackFrame {
    public int currentIndex = Integer.MIN_VALUE;
    public final /* synthetic */ SuspendFunctionGun<TSubject, TContext> this$0;

    public SuspendFunctionGun$continuation$1(SuspendFunctionGun<TSubject, TContext> suspendFunctionGun) {
        this.this$0 = suspendFunctionGun;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.Continuation<TSubject>[]] */
    /* JADX WARN: Type inference failed for: r2v2 */
    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        StackWalkingFailedFrame stackWalkingFailedFrame = StackWalkingFailedFrame.INSTANCE;
        int r1 = this.currentIndex;
        SuspendFunctionGun suspendFunctionGun = this.this$0;
        if (r1 == Integer.MIN_VALUE) {
            this.currentIndex = suspendFunctionGun.lastSuspensionIndex;
        }
        int r12 = this.currentIndex;
        if (r12 < 0) {
            this.currentIndex = Integer.MIN_VALUE;
            stackWalkingFailedFrame = null;
        } else {
            try {
                ?? r2 = suspendFunctionGun.suspensions[r12];
                if (r2 != 0) {
                    this.currentIndex = r12 - 1;
                    stackWalkingFailedFrame = r2;
                }
            } catch (Throwable unused) {
            }
        }
        if (!(stackWalkingFailedFrame instanceof CoroutineStackFrame)) {
            return null;
        }
        return stackWalkingFailedFrame;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        CoroutineContext context;
        SuspendFunctionGun<TSubject, TContext> suspendFunctionGun = this.this$0;
        Continuation continuation = suspendFunctionGun.suspensions[suspendFunctionGun.lastSuspensionIndex];
        if (continuation != null && (context = continuation.getContext()) != null) {
            return context;
        }
        throw new IllegalStateException("Not started".toString());
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        boolean z = obj instanceof Result.Failure;
        SuspendFunctionGun<TSubject, TContext> suspendFunctionGun = this.this$0;
        if (z) {
            Throwable m1661exceptionOrNullimpl = Result.m1661exceptionOrNullimpl(obj);
            Intrinsics.checkNotNull(m1661exceptionOrNullimpl);
            suspendFunctionGun.resumeRootWith(ResultKt.createFailure(m1661exceptionOrNullimpl));
            return;
        }
        suspendFunctionGun.loop(false);
    }
}
