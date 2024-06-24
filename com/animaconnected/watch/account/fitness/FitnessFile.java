package com.animaconnected.watch.account.fitness;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FitnessCloudSyncApi.kt */
/* loaded from: classes3.dex */
public final class FitnessFile {
    private final String content;
    private final long timestamp;

    public FitnessFile(long j, String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.timestamp = j;
        this.content = content;
    }

    public static /* synthetic */ FitnessFile copy$default(FitnessFile fitnessFile, long j, String str, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            j = fitnessFile.timestamp;
        }
        if ((r4 & 2) != 0) {
            str = fitnessFile.content;
        }
        return fitnessFile.copy(j, str);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final String component2() {
        return this.content;
    }

    public final FitnessFile copy(long j, String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new FitnessFile(j, content);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FitnessFile)) {
            return false;
        }
        FitnessFile fitnessFile = (FitnessFile) obj;
        if (this.timestamp == fitnessFile.timestamp && Intrinsics.areEqual(this.content, fitnessFile.content)) {
            return true;
        }
        return false;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return this.content.hashCode() + (Long.hashCode(this.timestamp) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FitnessFile(timestamp=");
        sb.append(this.timestamp);
        sb.append(", content=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.content, ')');
    }
}
