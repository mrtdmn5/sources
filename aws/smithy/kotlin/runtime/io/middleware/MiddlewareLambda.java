package aws.smithy.kotlin.runtime.io.middleware;

import aws.smithy.kotlin.runtime.io.Handler;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Middleware.kt */
/* loaded from: classes.dex */
public final class MiddlewareLambda<Request, Response> implements Middleware<Request, Response> {
    public final Function3<Request, Handler<? super Request, ? extends Response>, Continuation<? super Response>, Object> fn;

    /* JADX WARN: Multi-variable type inference failed */
    public MiddlewareLambda(Function3<? super Request, ? super Handler<? super Request, ? extends Response>, ? super Continuation<? super Response>, ? extends Object> fn) {
        Intrinsics.checkNotNullParameter(fn, "fn");
        this.fn = fn;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof MiddlewareLambda) && Intrinsics.areEqual(this.fn, ((MiddlewareLambda) obj).fn)) {
            return true;
        }
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.io.middleware.Middleware
    public final <H extends Handler<? super Request, ? extends Response>> Object handle(Request request, H h, Continuation<? super Response> continuation) {
        return this.fn.invoke(request, h, continuation);
    }

    public final int hashCode() {
        return this.fn.hashCode();
    }

    public final String toString() {
        return "MiddlewareLambda(fn=" + this.fn + ')';
    }
}
