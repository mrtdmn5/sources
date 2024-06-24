package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import kotlin.Unit;

/* compiled from: HttpSerde.kt */
/* loaded from: classes.dex */
public final class UnitSerializer implements HttpSerialize<Unit> {
    public static final UnitSerializer INSTANCE = new UnitSerializer();

    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerialize
    public final HttpRequestBuilder serialize(Object obj) {
        return new HttpRequestBuilder();
    }
}
