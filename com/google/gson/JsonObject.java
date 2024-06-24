package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;

/* loaded from: classes3.dex */
public final class JsonObject extends JsonElement {
    public final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap<>(false);

    public final boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof JsonObject) || !((JsonObject) obj).members.equals(this.members))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.members.hashCode();
    }
}
