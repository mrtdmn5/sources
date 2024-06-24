package aws.sdk.kotlin.runtime.endpoint.functions;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Functions.kt */
/* loaded from: classes.dex */
public final class FunctionsKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    public static final PartitionConfig partition(String str, List partitions) {
        Object obj;
        Object obj2;
        Partition partition;
        Intrinsics.checkNotNullParameter(partitions, "partitions");
        if (str == null) {
            return null;
        }
        List list = partitions;
        Iterator it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((Partition) obj).regions.containsKey(str)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Partition partition2 = (Partition) obj;
        if (partition2 != null) {
            PartitionConfig partitionConfig = partition2.regions.get(str);
            Intrinsics.checkNotNull(partitionConfig);
            PartitionConfig partitionConfig2 = partitionConfig;
            PartitionConfig partitionConfig3 = partition2.baseConfig;
            partitionConfig3.getClass();
            String str2 = partitionConfig2.name;
            if (str2 == null) {
                str2 = partitionConfig3.name;
            }
            String str3 = str2;
            String str4 = partitionConfig2.dnsSuffix;
            if (str4 == null) {
                str4 = partitionConfig3.dnsSuffix;
            }
            String str5 = str4;
            String str6 = partitionConfig2.dualStackDnsSuffix;
            if (str6 == null) {
                str6 = partitionConfig3.dualStackDnsSuffix;
            }
            String str7 = str6;
            Boolean bool = partitionConfig2.supportsFIPS;
            if (bool == null) {
                bool = partitionConfig3.supportsFIPS;
            }
            Boolean bool2 = bool;
            Boolean bool3 = partitionConfig2.supportsDualStack;
            if (bool3 == null) {
                bool3 = partitionConfig3.supportsDualStack;
            }
            return new PartitionConfig(str3, str5, str7, bool2, bool3);
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj2 = it2.next();
                if (((Partition) obj2).regionRegex.matches(str)) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        Partition partition3 = (Partition) obj2;
        if (partition3 == null) {
            Iterator it3 = list.iterator();
            while (true) {
                if (it3.hasNext()) {
                    partition = it3.next();
                    if (Intrinsics.areEqual(((Partition) partition).id, "aws")) {
                        break;
                    }
                } else {
                    partition = 0;
                    break;
                }
            }
            partition3 = partition;
        }
        if (partition3 == null) {
            return null;
        }
        return partition3.baseConfig;
    }
}
