package com.amplifyframework.datastore.events;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.datastore.DataStoreChannelEventName;
import com.amplifyframework.hub.HubEvent;

/* loaded from: classes.dex */
public final class ModelSyncedEvent implements HubEvent.Data<ModelSyncedEvent> {
    private final int added;
    private final int deleted;
    private final boolean isDeltaSync;
    private final boolean isFullSync;
    private final String model;
    private final int updated;

    public ModelSyncedEvent(String str, boolean z, int r3, int r4, int r5) {
        this.added = r3;
        this.updated = r4;
        this.deleted = r5;
        this.model = str;
        this.isFullSync = z;
        this.isDeltaSync = !z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ModelSyncedEvent.class != obj.getClass()) {
            return false;
        }
        ModelSyncedEvent modelSyncedEvent = (ModelSyncedEvent) obj;
        if (!ObjectsCompat$Api19Impl.equals(this.model, modelSyncedEvent.model) || !ObjectsCompat$Api19Impl.equals(Boolean.valueOf(this.isFullSync), Boolean.valueOf(modelSyncedEvent.isFullSync)) || !ObjectsCompat$Api19Impl.equals(Boolean.valueOf(this.isDeltaSync), Boolean.valueOf(modelSyncedEvent.isDeltaSync)) || !ObjectsCompat$Api19Impl.equals(Integer.valueOf(this.added), Integer.valueOf(modelSyncedEvent.added)) || !ObjectsCompat$Api19Impl.equals(Integer.valueOf(this.updated), Integer.valueOf(modelSyncedEvent.updated))) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(Integer.valueOf(this.deleted), Integer.valueOf(modelSyncedEvent.deleted));
    }

    public int getAdded() {
        return this.added;
    }

    public int getDeleted() {
        return this.deleted;
    }

    public String getModel() {
        return this.model;
    }

    public int getUpdated() {
        return this.updated;
    }

    public int hashCode() {
        int r0;
        String str = this.model;
        if (str != null) {
            r0 = str.hashCode();
        } else {
            r0 = 0;
        }
        return Integer.valueOf(this.deleted).intValue() + ((Integer.valueOf(this.updated).intValue() + ((Integer.valueOf(this.added).intValue() + ((Boolean.valueOf(this.isDeltaSync).hashCode() + ((Boolean.valueOf(this.isFullSync).hashCode() + (r0 * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public boolean isDeltaSync() {
        return this.isDeltaSync;
    }

    public boolean isFullSync() {
        return this.isFullSync;
    }

    @Override // com.amplifyframework.hub.HubEvent.Data
    public HubEvent<ModelSyncedEvent> toHubEvent() {
        return HubEvent.create(DataStoreChannelEventName.MODEL_SYNCED, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ModelSyncedEvent{model=");
        sb.append(this.model);
        sb.append(", isFullSync=");
        sb.append(this.isFullSync);
        sb.append(", isDeltaSync=");
        sb.append(this.isDeltaSync);
        sb.append(", added=");
        sb.append(this.added);
        sb.append(", updated=");
        sb.append(this.updated);
        sb.append(", deleted=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.deleted, '}');
    }
}
