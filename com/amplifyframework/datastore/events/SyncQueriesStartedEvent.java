package com.amplifyframework.datastore.events;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class SyncQueriesStartedEvent {
    private final String[] models;

    public SyncQueriesStartedEvent(String[] strArr) {
        this.models = (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SyncQueriesStartedEvent.class == obj.getClass()) {
            return Arrays.equals(this.models, ((SyncQueriesStartedEvent) obj).models);
        }
        return false;
    }

    public String[] getModels() {
        return this.models;
    }

    public int hashCode() {
        return Arrays.hashCode(this.models);
    }

    public String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("SyncQueriesStartedEvent{models="), Arrays.toString(this.models), '}');
    }
}
