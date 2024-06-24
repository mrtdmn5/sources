package com.amplifyframework.storage.result;

import com.amplifyframework.storage.StorageItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class StorageListResult {
    private final List<StorageItem> items;

    private StorageListResult(List<StorageItem> list) {
        this.items = list;
    }

    public static StorageListResult fromItems(List<StorageItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        return new StorageListResult(Collections.unmodifiableList(arrayList));
    }

    public List<StorageItem> getItems() {
        return this.items;
    }
}
