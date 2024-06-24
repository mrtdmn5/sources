package aws.smithy.kotlin.runtime.io.middleware;

import aws.smithy.kotlin.runtime.io.Handler;
import kotlin.coroutines.Continuation;

/* compiled from: Middleware.kt */
/* loaded from: classes.dex */
public interface Middleware<Request, Response> {
    <H extends Handler<? super Request, ? extends Response>> Object handle(Request request, H h, Continuation<? super Response> continuation);
}
