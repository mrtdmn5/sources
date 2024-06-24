package com.google.android.datatransport.runtime.scheduling.persistence;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public final class AutoValue_EventStoreConfig extends EventStoreConfig {
    public final int criticalSectionEnterTimeoutMs;
    public final long eventCleanUpAge;
    public final int loadBatchSize;
    public final int maxBlobByteSizePerRow;
    public final long maxStorageSizeInBytes;

    public AutoValue_EventStoreConfig(long j, int r3, int r4, long j2, int r7) {
        this.maxStorageSizeInBytes = j;
        this.loadBatchSize = r3;
        this.criticalSectionEnterTimeoutMs = r4;
        this.eventCleanUpAge = j2;
        this.maxBlobByteSizePerRow = r7;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventStoreConfig)) {
            return false;
        }
        EventStoreConfig eventStoreConfig = (EventStoreConfig) obj;
        if (this.maxStorageSizeInBytes == eventStoreConfig.getMaxStorageSizeInBytes() && this.loadBatchSize == eventStoreConfig.getLoadBatchSize() && this.criticalSectionEnterTimeoutMs == eventStoreConfig.getCriticalSectionEnterTimeoutMs() && this.eventCleanUpAge == eventStoreConfig.getEventCleanUpAge() && this.maxBlobByteSizePerRow == eventStoreConfig.getMaxBlobByteSizePerRow()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public final int getCriticalSectionEnterTimeoutMs() {
        return this.criticalSectionEnterTimeoutMs;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public final long getEventCleanUpAge() {
        return this.eventCleanUpAge;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public final int getLoadBatchSize() {
        return this.loadBatchSize;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public final int getMaxBlobByteSizePerRow() {
        return this.maxBlobByteSizePerRow;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public final long getMaxStorageSizeInBytes() {
        return this.maxStorageSizeInBytes;
    }

    public final int hashCode() {
        long j = this.maxStorageSizeInBytes;
        int r0 = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.loadBatchSize) * 1000003) ^ this.criticalSectionEnterTimeoutMs) * 1000003;
        long j2 = this.eventCleanUpAge;
        return ((r0 ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.maxBlobByteSizePerRow;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb.append(this.maxStorageSizeInBytes);
        sb.append(", loadBatchSize=");
        sb.append(this.loadBatchSize);
        sb.append(", criticalSectionEnterTimeoutMs=");
        sb.append(this.criticalSectionEnterTimeoutMs);
        sb.append(", eventCleanUpAge=");
        sb.append(this.eventCleanUpAge);
        sb.append(", maxBlobByteSizePerRow=");
        return ConstraintWidget$$ExternalSyntheticOutline0.m(sb, this.maxBlobByteSizePerRow, "}");
    }
}
