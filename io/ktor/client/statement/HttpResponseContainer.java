package io.ktor.client.statement;

import io.ktor.util.reflect.TypeInfo;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpResponsePipeline.kt */
/* loaded from: classes3.dex */
public final class HttpResponseContainer {
    public final TypeInfo expectedType;
    public final Object response;

    public HttpResponseContainer(TypeInfo expectedType, Object response) {
        Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        Intrinsics.checkNotNullParameter(response, "response");
        this.expectedType = expectedType;
        this.response = response;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpResponseContainer)) {
            return false;
        }
        HttpResponseContainer httpResponseContainer = (HttpResponseContainer) obj;
        if (Intrinsics.areEqual(this.expectedType, httpResponseContainer.expectedType) && Intrinsics.areEqual(this.response, httpResponseContainer.response)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.response.hashCode() + (this.expectedType.hashCode() * 31);
    }

    public final String toString() {
        return "HttpResponseContainer(expectedType=" + this.expectedType + ", response=" + this.response + ')';
    }
}
