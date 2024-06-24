package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;

/* compiled from: HttpSerde.kt */
/* loaded from: classes.dex */
public interface HttpSerialize<T> {
    HttpRequestBuilder serialize(Object obj);
}
