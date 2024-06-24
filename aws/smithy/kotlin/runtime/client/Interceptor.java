package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.http.interceptors.HttpAttemptInterceptorContext;
import aws.smithy.kotlin.runtime.http.interceptors.HttpFinalInterceptorContext;
import aws.smithy.kotlin.runtime.http.interceptors.HttpInputInterceptorContext;
import aws.smithy.kotlin.runtime.http.interceptors.HttpInputOutputInterceptorContext;
import aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolResponseInterceptorContext;
import kotlin.coroutines.Continuation;

/* compiled from: Interceptor.kt */
/* loaded from: classes.dex */
public interface Interceptor<Input, Output, ProtocolRequest, ProtocolResponse> {
    /* renamed from: modifyBeforeAttemptCompletion-gIAlu-s */
    Object mo615modifyBeforeAttemptCompletiongIAlus(HttpAttemptInterceptorContext httpAttemptInterceptorContext);

    /* renamed from: modifyBeforeCompletion-gIAlu-s */
    Object mo616modifyBeforeCompletiongIAlus(HttpFinalInterceptorContext httpFinalInterceptorContext);

    Object modifyBeforeDeserialization(HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext);

    Object modifyBeforeRetryLoop(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext, Continuation continuation);

    Object modifyBeforeSerialization(HttpInputInterceptorContext httpInputInterceptorContext);

    Object modifyBeforeSigning(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext);

    Object modifyBeforeTransmit(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext);

    void readAfterAttempt(HttpAttemptInterceptorContext httpAttemptInterceptorContext);

    void readAfterDeserialization(HttpInputOutputInterceptorContext httpInputOutputInterceptorContext);

    void readAfterExecution(HttpFinalInterceptorContext httpFinalInterceptorContext);

    void readAfterSerialization(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext);

    void readAfterSigning(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext);

    void readAfterTransmit(HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext);

    void readBeforeAttempt(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext);

    void readBeforeDeserialization(HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext);

    void readBeforeExecution(HttpInputInterceptorContext httpInputInterceptorContext);

    void readBeforeSerialization(HttpInputInterceptorContext httpInputInterceptorContext);

    void readBeforeSigning(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext);

    void readBeforeTransmit(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext);
}
