package aws.sdk.kotlin.runtime.endpoint.functions;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: Functions.kt */
/* loaded from: classes.dex */
public final class Partition {
    public final PartitionConfig baseConfig;
    public final String id;
    public final Regex regionRegex;
    public final Map<String, PartitionConfig> regions;

    public Partition(String str, Map<String, PartitionConfig> map, Regex regex, PartitionConfig partitionConfig) {
        this.id = str;
        this.regions = map;
        this.regionRegex = regex;
        this.baseConfig = partitionConfig;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Partition)) {
            return false;
        }
        Partition partition = (Partition) obj;
        if (Intrinsics.areEqual(this.id, partition.id) && Intrinsics.areEqual(this.regions, partition.regions) && Intrinsics.areEqual(this.regionRegex, partition.regionRegex) && Intrinsics.areEqual(this.baseConfig, partition.baseConfig)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.baseConfig.hashCode() + ((this.regionRegex.hashCode() + ((this.regions.hashCode() + (this.id.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Partition(id=" + this.id + ", regions=" + this.regions + ", regionRegex=" + this.regionRegex + ", baseConfig=" + this.baseConfig + ')';
    }
}
