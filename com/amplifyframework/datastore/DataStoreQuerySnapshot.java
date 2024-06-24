package com.amplifyframework.datastore;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.util.Immutable;
import java.util.List;

/* loaded from: classes.dex */
public class DataStoreQuerySnapshot<T extends Model> {
    private final boolean isSynced;
    private final List<T> items;

    public DataStoreQuerySnapshot(List<T> list, boolean z) {
        this.items = list;
        this.isSynced = z;
    }

    public boolean getIsSynced() {
        return this.isSynced;
    }

    public List<T> getItems() {
        return Immutable.of(this.items);
    }
}
