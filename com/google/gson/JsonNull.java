package com.google.gson;

/* loaded from: classes3.dex */
public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE = new JsonNull();

    @Deprecated
    public JsonNull() {
    }

    public final boolean equals(Object obj) {
        return obj instanceof JsonNull;
    }

    public final int hashCode() {
        return JsonNull.class.hashCode();
    }
}
