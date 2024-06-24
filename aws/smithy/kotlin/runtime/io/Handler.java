package aws.smithy.kotlin.runtime.io;

import kotlin.coroutines.Continuation;

/* compiled from: Handler.kt */
/* loaded from: classes.dex */
public interface Handler<Request, Response> {
    Object call(Request request, Continuation<? super Response> continuation);
}
