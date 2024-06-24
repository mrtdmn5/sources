package aws.smithy.kotlin.runtime.io.middleware;

import aws.smithy.kotlin.runtime.io.Handler;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Middleware.kt */
/* loaded from: classes.dex */
public final class DecoratedHandler<Request, Response> implements Handler<Request, Response> {
    public final Handler<Request, Response> handler;
    public final Middleware<Request, Response> with;

    /* JADX WARN: Multi-variable type inference failed */
    public DecoratedHandler(Handler<? super Request, ? extends Response> handler, Middleware<Request, Response> with) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(with, "with");
        this.handler = handler;
        this.with = with;
    }

    @Override // aws.smithy.kotlin.runtime.io.Handler
    public final Object call(Request request, Continuation<? super Response> continuation) {
        return this.with.handle(request, this.handler, continuation);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecoratedHandler)) {
            return false;
        }
        DecoratedHandler decoratedHandler = (DecoratedHandler) obj;
        if (Intrinsics.areEqual(this.handler, decoratedHandler.handler) && Intrinsics.areEqual(this.with, decoratedHandler.with)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.with.hashCode() + (this.handler.hashCode() * 31);
    }

    public final String toString() {
        return "DecoratedHandler(handler=" + this.handler + ", with=" + this.with + ')';
    }
}
