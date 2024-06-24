package io.ktor.client.request.forms;

import io.ktor.http.Headers;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: formDsl.kt */
/* loaded from: classes3.dex */
public final class FormPart<T> {
    public final Headers headers;
    public final String key;
    public final T value;

    public FormPart(String str, T value, Headers headers) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.key = str;
        this.value = value;
        this.headers = headers;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormPart)) {
            return false;
        }
        FormPart formPart = (FormPart) obj;
        if (Intrinsics.areEqual(this.key, formPart.key) && Intrinsics.areEqual(this.value, formPart.value) && Intrinsics.areEqual(this.headers, formPart.headers)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.headers.hashCode() + ((this.value.hashCode() + (this.key.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "FormPart(key=" + this.key + ", value=" + this.value + ", headers=" + this.headers + ')';
    }
}
