package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HttpClientEngine.kt */
/* loaded from: classes.dex */
public interface HttpClientEngine extends CoroutineScope {
    Object roundTrip(ExecutionContext executionContext, HttpRequest httpRequest, Continuation<? super HttpCall> continuation);
}
