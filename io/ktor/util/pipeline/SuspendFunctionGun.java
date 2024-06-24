package io.ktor.util.pipeline;

import io.ktor.utils.io.ExceptionUtilsJvmKt;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SuspendFunctionGun.kt */
/* loaded from: classes3.dex */
public final class SuspendFunctionGun<TSubject, TContext> extends PipelineContext<TSubject, TContext> {
    public final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> blocks;
    public final SuspendFunctionGun$continuation$1 continuation;
    public int index;
    public int lastSuspensionIndex;
    public TSubject subject;
    public final Continuation<TSubject>[] suspensions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SuspendFunctionGun(TSubject initial, TContext context, List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list) {
        super(context);
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(context, "context");
        this.blocks = list;
        this.continuation = new SuspendFunctionGun$continuation$1(this);
        this.subject = initial;
        this.suspensions = new Continuation[list.size()];
        this.lastSuspensionIndex = -1;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object execute$ktor_utils(TSubject tsubject, Continuation<? super TSubject> continuation) {
        this.index = 0;
        if (this.blocks.size() == 0) {
            return tsubject;
        }
        Intrinsics.checkNotNullParameter(tsubject, "<set-?>");
        this.subject = tsubject;
        if (this.lastSuspensionIndex < 0) {
            return proceed(continuation);
        }
        throw new IllegalStateException("Already started");
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.continuation.getContext();
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final TSubject getSubject() {
        return this.subject;
    }

    public final boolean loop(boolean z) {
        int r0;
        List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> list;
        do {
            r0 = this.index;
            list = this.blocks;
            if (r0 == list.size()) {
                if (!z) {
                    resumeRootWith(this.subject);
                    return false;
                }
                return true;
            }
            this.index = r0 + 1;
            try {
            } catch (Throwable th) {
                resumeRootWith(ResultKt.createFailure(th));
                return false;
            }
        } while (list.get(r0).invoke(this, this.subject, this.continuation) != CoroutineSingletons.COROUTINE_SUSPENDED);
        return false;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object proceed(Continuation<? super TSubject> frame) {
        Object obj;
        if (this.index == this.blocks.size()) {
            obj = this.subject;
        } else {
            Continuation<TSubject> intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(frame);
            int r1 = this.lastSuspensionIndex + 1;
            this.lastSuspensionIndex = r1;
            Continuation<TSubject>[] continuationArr = this.suspensions;
            continuationArr[r1] = intercepted;
            if (loop(true)) {
                int r0 = this.lastSuspensionIndex;
                if (r0 >= 0) {
                    this.lastSuspensionIndex = r0 - 1;
                    continuationArr[r0] = null;
                    obj = this.subject;
                } else {
                    throw new IllegalStateException("No more continuations to resume");
                }
            } else {
                obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            }
        }
        if (obj == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return obj;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object proceedWith(TSubject tsubject, Continuation<? super TSubject> continuation) {
        Intrinsics.checkNotNullParameter(tsubject, "<set-?>");
        this.subject = tsubject;
        return proceed(continuation);
    }

    public final void resumeRootWith(Object obj) {
        Throwable tryCopyException;
        int r0 = this.lastSuspensionIndex;
        if (r0 >= 0) {
            Continuation<TSubject>[] continuationArr = this.suspensions;
            Continuation<TSubject> continuation = continuationArr[r0];
            Intrinsics.checkNotNull(continuation);
            int r2 = this.lastSuspensionIndex;
            this.lastSuspensionIndex = r2 - 1;
            continuationArr[r2] = null;
            if (!(obj instanceof Result.Failure)) {
                continuation.resumeWith(obj);
                return;
            }
            Throwable m1661exceptionOrNullimpl = Result.m1661exceptionOrNullimpl(obj);
            Intrinsics.checkNotNull(m1661exceptionOrNullimpl);
            try {
                Throwable cause = m1661exceptionOrNullimpl.getCause();
                if (cause != null && !Intrinsics.areEqual(m1661exceptionOrNullimpl.getCause(), cause) && (tryCopyException = ExceptionUtilsJvmKt.tryCopyException(m1661exceptionOrNullimpl, cause)) != null) {
                    tryCopyException.setStackTrace(m1661exceptionOrNullimpl.getStackTrace());
                    m1661exceptionOrNullimpl = tryCopyException;
                }
            } catch (Throwable unused) {
            }
            continuation.resumeWith(ResultKt.createFailure(m1661exceptionOrNullimpl));
            return;
        }
        throw new IllegalStateException("No more continuations to resume".toString());
    }
}
