package aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal;

import aws.sdk.kotlin.runtime.endpoint.functions.Partition;
import aws.sdk.kotlin.runtime.endpoint.functions.PartitionConfig;
import com.animaconnected.secondo.provider.PoolIdProvider;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.text.Regex;

/* compiled from: Partitions.kt */
/* loaded from: classes.dex */
public final class PartitionsKt {
    public static final List<Partition> defaultPartitions;

    static {
        Regex regex = new Regex("^(us|eu|ap|sa|ca|me|af)\\-\\w+\\-\\d+$");
        Map mapOf = MapsKt__MapsKt.mapOf(new Pair("af-south-1", new PartitionConfig(0)), new Pair("ap-east-1", new PartitionConfig(0)), new Pair("ap-northeast-1", new PartitionConfig(0)), new Pair("ap-northeast-2", new PartitionConfig(0)), new Pair("ap-northeast-3", new PartitionConfig(0)), new Pair("ap-south-1", new PartitionConfig(0)), new Pair("ap-south-2", new PartitionConfig(0)), new Pair("ap-southeast-1", new PartitionConfig(0)), new Pair("ap-southeast-2", new PartitionConfig(0)), new Pair("ap-southeast-3", new PartitionConfig(0)), new Pair("aws-global", new PartitionConfig(0)), new Pair("ca-central-1", new PartitionConfig(0)), new Pair("eu-central-1", new PartitionConfig(0)), new Pair("eu-central-2", new PartitionConfig(0)), new Pair("eu-north-1", new PartitionConfig(0)), new Pair("eu-south-1", new PartitionConfig(0)), new Pair("eu-south-2", new PartitionConfig(0)), new Pair(PoolIdProvider.SANDBOX_REGION, new PartitionConfig(0)), new Pair("eu-west-2", new PartitionConfig(0)), new Pair("eu-west-3", new PartitionConfig(0)), new Pair("me-central-1", new PartitionConfig(0)), new Pair("me-south-1", new PartitionConfig(0)), new Pair("sa-east-1", new PartitionConfig(0)), new Pair("us-east-1", new PartitionConfig(0)), new Pair("us-east-2", new PartitionConfig(0)), new Pair("us-west-1", new PartitionConfig(0)), new Pair("us-west-2", new PartitionConfig(0)));
        Boolean bool = Boolean.TRUE;
        Partition partition = new Partition("aws", mapOf, regex, new PartitionConfig("aws", "amazonaws.com", "api.aws", bool, bool));
        Partition partition2 = new Partition("aws-cn", MapsKt__MapsKt.mapOf(new Pair("aws-cn-global", new PartitionConfig(0)), new Pair("cn-north-1", new PartitionConfig(0)), new Pair("cn-northwest-1", new PartitionConfig(0))), new Regex("^cn\\-\\w+\\-\\d+$"), new PartitionConfig("aws-cn", "amazonaws.com.cn", "api.amazonwebservices.com.cn", bool, bool));
        Partition partition3 = new Partition("aws-us-gov", MapsKt__MapsKt.mapOf(new Pair("aws-us-gov-global", new PartitionConfig(0)), new Pair("us-gov-east-1", new PartitionConfig(0)), new Pair("us-gov-west-1", new PartitionConfig(0))), new Regex("^us\\-gov\\-\\w+\\-\\d+$"), new PartitionConfig("aws-us-gov", "amazonaws.com", "api.aws", bool, bool));
        Regex regex2 = new Regex("^us\\-iso\\-\\w+\\-\\d+$");
        Map mapOf2 = MapsKt__MapsKt.mapOf(new Pair("aws-iso-global", new PartitionConfig(0)), new Pair("us-iso-east-1", new PartitionConfig(0)), new Pair("us-iso-west-1", new PartitionConfig(0)));
        Boolean bool2 = Boolean.FALSE;
        defaultPartitions = CollectionsKt__CollectionsKt.listOf((Object[]) new Partition[]{partition, partition2, partition3, new Partition("aws-iso", mapOf2, regex2, new PartitionConfig("aws-iso", "c2s.ic.gov", "c2s.ic.gov", bool, bool2)), new Partition("aws-iso-b", MapsKt__MapsKt.mapOf(new Pair("aws-iso-b-global", new PartitionConfig(0)), new Pair("us-isob-east-1", new PartitionConfig(0))), new Regex("^us\\-isob\\-\\w+\\-\\d+$"), new PartitionConfig("aws-iso-b", "sc2s.sgov.gov", "sc2s.sgov.gov", bool, bool2))});
    }
}
