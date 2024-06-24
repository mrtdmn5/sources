package aws.sdk.kotlin.runtime.http;

import aws.sdk.kotlin.runtime.http.operation.CustomUserAgentMetadata;
import aws.smithy.kotlin.runtime.util.OperatingSystem;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import aws.smithy.kotlin.runtime.util.SystemDefaultProvider;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: AwsUserAgentMetadata.kt */
/* loaded from: classes.dex */
public final class AwsUserAgentMetadata {
    public final ApiMetadata apiMetadata;
    public final String appId;
    public final CustomUserAgentMetadata customMetadata;
    public final ExecutionEnvMetadata execEnvMetadata;
    public final FrameworkMetadata frameworkMetadata;
    public final LanguageMetadata languageMetadata;
    public final OsMetadata osMetadata;
    public final SdkMetadata sdkMetadata;

    /* compiled from: AwsUserAgentMetadata.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static AwsUserAgentMetadata fromEnvironment(ApiMetadata apiMetadata) {
            FrameworkMetadata frameworkMetadata;
            ExecutionEnvMetadata executionEnvMetadata;
            boolean z;
            PlatformProvider.Companion.getClass();
            SystemDefaultProvider platform = PlatformProvider.Companion.System;
            Set<Character> set = AwsUserAgentMetadataKt.VALID_TCHAR;
            Intrinsics.checkNotNullParameter(platform, "platform");
            SdkMetadata sdkMetadata = new SdkMetadata(apiMetadata.version);
            OperatingSystem osInfo = platform.osInfo();
            OsMetadata osMetadata = new OsMetadata(osInfo.family, osInfo.version);
            LanguageMetadata languageMetadata = new LanguageMetadata((Map) AwsUserAgentMetadataJvmKt.jvmMetadataExtras.getValue(), 1);
            String property = System.getProperty("aws.userAgentAppId");
            if (property == null) {
                property = platform.getenv("AWS_SDK_UA_APP_ID");
            }
            String str = property;
            String property2 = System.getProperty("aws.frameworkMetadata");
            if (property2 == null) {
                property2 = platform.getenv("AWS_FRAMEWORK_METADATA");
            }
            int r7 = 2;
            if (property2 != null) {
                List split$default = StringsKt__StringsKt.split$default(2, 2, property2, new char[]{':'});
                if (split$default.size() == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    frameworkMetadata = new FrameworkMetadata((String) split$default.get(0), (String) split$default.get(1));
                } else {
                    throw new IllegalStateException(zzav$$ExternalSyntheticOutline0.m("Invalid value for FRAMEWORK_METADATA: ", property2, "; must be of the form `name:version`").toString());
                }
            } else {
                frameworkMetadata = null;
            }
            CustomUserAgentMetadata customUserAgentMetadata = new CustomUserAgentMetadata(MapsKt__MapsKt.plus(CustomUserAgentMetadata.Companion.fromEnvironment$findAndStripKeyPrefix("AWS_CUSTOM_METADATA_", platform.getAllEnvVars()), CustomUserAgentMetadata.Companion.fromEnvironment$findAndStripKeyPrefix("aws.customMetadata.", platform.getAllProperties())), r7);
            String str2 = platform.getenv("AWS_EXECUTION_ENV");
            if (str2 != null) {
                executionEnvMetadata = new ExecutionEnvMetadata(str2);
            } else {
                executionEnvMetadata = null;
            }
            return new AwsUserAgentMetadata(sdkMetadata, apiMetadata, osMetadata, languageMetadata, executionEnvMetadata, frameworkMetadata, str, customUserAgentMetadata);
        }
    }

    public AwsUserAgentMetadata(SdkMetadata sdkMetadata, ApiMetadata apiMetadata, OsMetadata osMetadata, LanguageMetadata languageMetadata, ExecutionEnvMetadata executionEnvMetadata, FrameworkMetadata frameworkMetadata, String str, CustomUserAgentMetadata customUserAgentMetadata) {
        this.sdkMetadata = sdkMetadata;
        this.apiMetadata = apiMetadata;
        this.osMetadata = osMetadata;
        this.languageMetadata = languageMetadata;
        this.execEnvMetadata = executionEnvMetadata;
        this.frameworkMetadata = frameworkMetadata;
        this.appId = str;
        this.customMetadata = customUserAgentMetadata;
    }

    public static AwsUserAgentMetadata copy$default(AwsUserAgentMetadata awsUserAgentMetadata, CustomUserAgentMetadata customUserAgentMetadata) {
        SdkMetadata sdkMetadata = awsUserAgentMetadata.sdkMetadata;
        ApiMetadata apiMetadata = awsUserAgentMetadata.apiMetadata;
        OsMetadata osMetadata = awsUserAgentMetadata.osMetadata;
        LanguageMetadata languageMetadata = awsUserAgentMetadata.languageMetadata;
        ExecutionEnvMetadata executionEnvMetadata = awsUserAgentMetadata.execEnvMetadata;
        FrameworkMetadata frameworkMetadata = awsUserAgentMetadata.frameworkMetadata;
        String str = awsUserAgentMetadata.appId;
        awsUserAgentMetadata.getClass();
        Intrinsics.checkNotNullParameter(sdkMetadata, "sdkMetadata");
        Intrinsics.checkNotNullParameter(apiMetadata, "apiMetadata");
        Intrinsics.checkNotNullParameter(osMetadata, "osMetadata");
        Intrinsics.checkNotNullParameter(languageMetadata, "languageMetadata");
        return new AwsUserAgentMetadata(sdkMetadata, apiMetadata, osMetadata, languageMetadata, executionEnvMetadata, frameworkMetadata, str, customUserAgentMetadata);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AwsUserAgentMetadata)) {
            return false;
        }
        AwsUserAgentMetadata awsUserAgentMetadata = (AwsUserAgentMetadata) obj;
        if (Intrinsics.areEqual(this.sdkMetadata, awsUserAgentMetadata.sdkMetadata) && Intrinsics.areEqual(this.apiMetadata, awsUserAgentMetadata.apiMetadata) && Intrinsics.areEqual(this.osMetadata, awsUserAgentMetadata.osMetadata) && Intrinsics.areEqual(this.languageMetadata, awsUserAgentMetadata.languageMetadata) && Intrinsics.areEqual(this.execEnvMetadata, awsUserAgentMetadata.execEnvMetadata) && Intrinsics.areEqual(this.frameworkMetadata, awsUserAgentMetadata.frameworkMetadata) && Intrinsics.areEqual(this.appId, awsUserAgentMetadata.appId) && Intrinsics.areEqual(this.customMetadata, awsUserAgentMetadata.customMetadata)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4 = (this.languageMetadata.hashCode() + ((this.osMetadata.hashCode() + ((this.apiMetadata.hashCode() + (this.sdkMetadata.hashCode() * 31)) * 31)) * 31)) * 31;
        int r0 = 0;
        ExecutionEnvMetadata executionEnvMetadata = this.execEnvMetadata;
        if (executionEnvMetadata == null) {
            hashCode = 0;
        } else {
            hashCode = executionEnvMetadata.hashCode();
        }
        int r1 = (hashCode4 + hashCode) * 31;
        FrameworkMetadata frameworkMetadata = this.frameworkMetadata;
        if (frameworkMetadata == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = frameworkMetadata.hashCode();
        }
        int r12 = (r1 + hashCode2) * 31;
        String str = this.appId;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int r13 = (r12 + hashCode3) * 31;
        CustomUserAgentMetadata customUserAgentMetadata = this.customMetadata;
        if (customUserAgentMetadata != null) {
            r0 = customUserAgentMetadata.hashCode();
        }
        return r13 + r0;
    }

    public final String toString() {
        return "AwsUserAgentMetadata(sdkMetadata=" + this.sdkMetadata + ", apiMetadata=" + this.apiMetadata + ", osMetadata=" + this.osMetadata + ", languageMetadata=" + this.languageMetadata + ", execEnvMetadata=" + this.execEnvMetadata + ", frameworkMetadata=" + this.frameworkMetadata + ", appId=" + this.appId + ", customMetadata=" + this.customMetadata + ')';
    }
}
