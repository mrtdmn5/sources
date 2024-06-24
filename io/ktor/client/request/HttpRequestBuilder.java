package io.ktor.client.request;

import io.ktor.client.utils.EmptyContent;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLUtilsKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.AttributesJvmBase;
import io.ktor.util.ConcurrentSafeAttributes;
import io.ktor.util.StringValuesKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: HttpRequest.kt */
/* loaded from: classes3.dex */
public final class HttpRequestBuilder implements HttpMessageBuilder {
    public final URLBuilder url = new URLBuilder(null);
    public HttpMethod method = HttpMethod.Get;
    public final HeadersBuilder headers = new HeadersBuilder(0);
    public Object body = EmptyContent.INSTANCE;
    public Job executionContext = SupervisorKt.SupervisorJob$default();
    public final AttributesJvmBase attributes = new ConcurrentSafeAttributes();

    @Override // io.ktor.http.HttpMessageBuilder
    public final HeadersBuilder getHeaders() {
        return this.headers;
    }

    public final void setBodyType(TypeInfo typeInfo) {
        AttributesJvmBase attributesJvmBase = this.attributes;
        if (typeInfo != null) {
            attributesJvmBase.put(RequestBodyKt.BodyTypeAttributeKey, typeInfo);
            return;
        }
        AttributeKey<TypeInfo> key = RequestBodyKt.BodyTypeAttributeKey;
        attributesJvmBase.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        attributesJvmBase.getMap().remove(key);
    }

    public final void setMethod(HttpMethod httpMethod) {
        Intrinsics.checkNotNullParameter(httpMethod, "<set-?>");
        this.method = httpMethod;
    }

    public final void takeFrom(HttpRequestBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.method = builder.method;
        this.body = builder.body;
        AttributeKey<TypeInfo> attributeKey = RequestBodyKt.BodyTypeAttributeKey;
        AttributesJvmBase other = builder.attributes;
        setBodyType((TypeInfo) other.getOrNull(attributeKey));
        URLBuilder uRLBuilder = this.url;
        URLUtilsKt.takeFrom(uRLBuilder, builder.url);
        List<String> list = uRLBuilder.encodedPathSegments;
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        uRLBuilder.encodedPathSegments = list;
        StringValuesKt.appendAll(this.headers, builder.headers);
        AttributesJvmBase attributesJvmBase = this.attributes;
        Intrinsics.checkNotNullParameter(attributesJvmBase, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Iterator<T> it = other.getAllKeys().iterator();
        while (it.hasNext()) {
            AttributeKey attributeKey2 = (AttributeKey) it.next();
            Intrinsics.checkNotNull(attributeKey2, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            attributesJvmBase.put(attributeKey2, other.get(attributeKey2));
        }
    }

    public final void takeFromWithExecutionContext(HttpRequestBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.executionContext = builder.executionContext;
        takeFrom(builder);
    }
}
