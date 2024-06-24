package io.ktor.http;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpMethod.kt */
/* loaded from: classes3.dex */
public final class HttpMethod {
    public static final List<HttpMethod> DefaultMethods;
    public static final HttpMethod Delete;
    public static final HttpMethod Get;
    public static final HttpMethod Head;
    public static final HttpMethod Post;
    public static final HttpMethod Put;
    public final String value;

    static {
        HttpMethod httpMethod = new HttpMethod("GET");
        Get = httpMethod;
        HttpMethod httpMethod2 = new HttpMethod("POST");
        Post = httpMethod2;
        HttpMethod httpMethod3 = new HttpMethod("PUT");
        Put = httpMethod3;
        HttpMethod httpMethod4 = new HttpMethod("PATCH");
        HttpMethod httpMethod5 = new HttpMethod("DELETE");
        Delete = httpMethod5;
        HttpMethod httpMethod6 = new HttpMethod("HEAD");
        Head = httpMethod6;
        DefaultMethods = CollectionsKt__CollectionsKt.listOf((Object[]) new HttpMethod[]{httpMethod, httpMethod2, httpMethod3, httpMethod4, httpMethod5, httpMethod6, new HttpMethod("OPTIONS")});
    }

    public HttpMethod(String str) {
        this.value = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof HttpMethod) && Intrinsics.areEqual(this.value, ((HttpMethod) obj).value)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.value.hashCode();
    }

    public final String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("HttpMethod(value="), this.value, ')');
    }
}
