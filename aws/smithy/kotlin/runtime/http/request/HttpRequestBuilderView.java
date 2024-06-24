package aws.smithy.kotlin.runtime.http.request;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.http.DeferredHeaders;
import aws.smithy.kotlin.runtime.http.DeferredHeadersImpl;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HeadersImpl;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.net.Url;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequestBuilder.kt */
/* loaded from: classes.dex */
public final class HttpRequestBuilderView implements HttpRequest {
    public final boolean allowToBuilder;
    public final HttpBody body;
    public final HttpRequestBuilder builder;
    public final SynchronizedLazyImpl headers$delegate;
    public final HttpMethod method;
    public final SynchronizedLazyImpl trailingHeaders$delegate;
    public final SynchronizedLazyImpl url$delegate;

    public HttpRequestBuilderView(HttpRequestBuilder builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.allowToBuilder = z;
        this.method = builder.method;
        this.url$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Url>() { // from class: aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView$url$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Url invoke() {
                return HttpRequestBuilderView.this.builder.url.build();
            }
        });
        this.headers$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Headers>() { // from class: aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView$headers$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Headers invoke() {
                return new HeadersImpl(HttpRequestBuilderView.this.builder.headers.values);
            }
        });
        this.body = builder.body;
        this.trailingHeaders$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DeferredHeaders>() { // from class: aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView$trailingHeaders$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final DeferredHeaders invoke() {
                return new DeferredHeadersImpl(HttpRequestBuilderView.this.builder.trailingHeaders.values);
            }
        });
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRequestBuilderView)) {
            return false;
        }
        HttpRequestBuilderView httpRequestBuilderView = (HttpRequestBuilderView) obj;
        if (Intrinsics.areEqual(this.builder, httpRequestBuilderView.builder) && this.allowToBuilder == httpRequestBuilderView.allowToBuilder) {
            return true;
        }
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public final HttpBody getBody() {
        return this.body;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public final Headers getHeaders() {
        return (Headers) this.headers$delegate.getValue();
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public final HttpMethod getMethod() {
        return this.method;
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public final DeferredHeaders getTrailingHeaders() {
        return (DeferredHeaders) this.trailingHeaders$delegate.getValue();
    }

    @Override // aws.smithy.kotlin.runtime.http.request.HttpRequest
    public final Url getUrl() {
        return (Url) this.url$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.builder.hashCode() * 31;
        boolean z = this.allowToBuilder;
        int r1 = z;
        if (z != 0) {
            r1 = 1;
        }
        return hashCode + r1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HttpRequestBuilderView(builder=");
        sb.append(this.builder);
        sb.append(", allowToBuilder=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.allowToBuilder, ')');
    }
}
