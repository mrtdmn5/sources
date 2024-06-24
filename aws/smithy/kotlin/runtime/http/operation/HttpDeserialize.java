package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.coroutines.Continuation;

/* compiled from: HttpSerde.kt */
/* loaded from: classes.dex */
public interface HttpDeserialize<T> {
    Object deserialize(ExecutionContext executionContext, HttpResponse httpResponse, Continuation<? super T> continuation);
}
