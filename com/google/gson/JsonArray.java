package com.google.gson;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    public final ArrayList<JsonElement> elements = new ArrayList<>();

    public final boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof JsonArray) || !((JsonArray) obj).elements.equals(this.elements))) {
            return false;
        }
        return true;
    }

    @Override // com.google.gson.JsonElement
    public final String getAsString() {
        ArrayList<JsonElement> arrayList = this.elements;
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0).getAsString();
        }
        throw new IllegalStateException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Array must have size 1, but has size ", size));
    }

    public final int hashCode() {
        return this.elements.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }
}
