package com.animaconnected.cloud.amazon;

import com.amazonaws.regions.Regions;
import com.animaconnected.secondo.provider.PoolIdProvider;
import java.util.Locale;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: AWSCloudConfig.kt */
/* loaded from: classes.dex */
public final class AWSCloudConfig {
    public static final Companion Companion = new Companion(null);
    private final boolean crashReporting;
    private final String lambdaType;
    private final String poolId;
    private final Regions region;
    private final String s3UploadDeviceCrashBucket;

    /* compiled from: AWSCloudConfig.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String poolIdToString(String str, String str2) {
            boolean z = false;
            if (str != null && StringsKt__StringsKt.contains(str, ":", false)) {
                z = true;
            }
            if (!z) {
                return str2 + ':' + str;
            }
            return str;
        }

        private Companion() {
        }
    }

    /* compiled from: AWSCloudConfig.kt */
    /* loaded from: classes.dex */
    public static final class LambdaType extends Enum<LambdaType> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LambdaType[] $VALUES;
        public static final LambdaType STABLE = new LambdaType("STABLE", 0);
        public static final LambdaType UNSTABLE = new LambdaType("UNSTABLE", 1);
        public static final LambdaType LATEST = new LambdaType("LATEST", 2);

        private static final /* synthetic */ LambdaType[] $values() {
            return new LambdaType[]{STABLE, UNSTABLE, LATEST};
        }

        static {
            LambdaType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private LambdaType(String str, int r2) {
            super(str, r2);
        }

        public static EnumEntries<LambdaType> getEntries() {
            return $ENTRIES;
        }

        public static LambdaType valueOf(String str) {
            return (LambdaType) Enum.valueOf(LambdaType.class, str);
        }

        public static LambdaType[] values() {
            return (LambdaType[]) $VALUES.clone();
        }
    }

    public AWSCloudConfig(String poolId, String region, String lambdaType, boolean z, String s3UploadDeviceCrashBucket) {
        Intrinsics.checkNotNullParameter(poolId, "poolId");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(lambdaType, "lambdaType");
        Intrinsics.checkNotNullParameter(s3UploadDeviceCrashBucket, "s3UploadDeviceCrashBucket");
        this.lambdaType = lambdaType;
        this.crashReporting = z;
        this.s3UploadDeviceCrashBucket = s3UploadDeviceCrashBucket;
        this.poolId = Companion.poolIdToString(poolId, region);
        this.region = regionStringToRegion(region);
    }

    private final LambdaType lambdaTypeToString(String str) {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (Intrinsics.areEqual(upperCase, "STABLE")) {
            return LambdaType.STABLE;
        }
        return LambdaType.LATEST;
    }

    public static final String poolIdToString(String str, String str2) {
        return Companion.poolIdToString(str, str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    private final Regions regionStringToRegion(String str) {
        switch (str.hashCode()) {
            case -1967372893:
                if (str.equals("us-west-2")) {
                    return Regions.US_WEST_1;
                }
                return Regions.EU_WEST_1;
            case -534364932:
                if (str.equals("eu-central-1")) {
                    return Regions.EU_CENTRAL_1;
                }
                return Regions.EU_WEST_1;
            case -281577977:
                if (str.equals("cn-north-1")) {
                    return Regions.CN_NORTH_1;
                }
                return Regions.EU_WEST_1;
            case -177297728:
                if (str.equals("sa-east-1")) {
                    return Regions.SA_EAST_1;
                }
                return Regions.EU_WEST_1;
            case 372748112:
                if (str.equals(PoolIdProvider.SANDBOX_REGION)) {
                    return Regions.EU_WEST_1;
                }
                return Regions.EU_WEST_1;
            case 372748113:
                if (str.equals("eu-west-2")) {
                    return Regions.US_WEST_2;
                }
                return Regions.EU_WEST_1;
            case 468199888:
                if (str.equals("ap-southeast-1")) {
                    return Regions.AP_SOUTHEAST_1;
                }
                return Regions.EU_WEST_1;
            case 468199889:
                if (str.equals("ap-southeast-2")) {
                    return Regions.AP_SOUTHEAST_2;
                }
                return Regions.EU_WEST_1;
            case 892625985:
                if (str.equals("us-gov-west-1")) {
                    return Regions.GovCloud;
                }
                return Regions.EU_WEST_1;
            case 1808575600:
                if (str.equals("us-east-1")) {
                    return Regions.US_EAST_1;
                }
                return Regions.EU_WEST_1;
            case 1990418184:
                if (str.equals("ap-northeast-1")) {
                    return Regions.AP_NORTHEAST_1;
                }
                return Regions.EU_WEST_1;
            case 1990418185:
                if (str.equals("ap-northeast-2")) {
                    return Regions.AP_NORTHEAST_2;
                }
                return Regions.EU_WEST_1;
            default:
                return Regions.EU_WEST_1;
        }
    }

    public final boolean getCrashReporting() {
        return this.crashReporting;
    }

    public final LambdaType getLambdaType() {
        return lambdaTypeToString(this.lambdaType);
    }

    public final String getPoolId() {
        return this.poolId;
    }

    public final Regions getRegion() {
        return this.region;
    }

    public final String getS3UploadDeviceCrashBucket() {
        return this.s3UploadDeviceCrashBucket;
    }
}
