package aws.sdk.kotlin.runtime.config;

/* compiled from: AwsSdkSetting.kt */
/* loaded from: classes.dex */
public abstract class AwsSdkSetting<T> {
    public final T defaultValue;
    public final String environmentVariable;
    public final String jvmProperty;

    /* compiled from: AwsSdkSetting.kt */
    /* loaded from: classes.dex */
    public static final class AwsConfigFile extends AwsSdkSetting<String> {
        public static final AwsConfigFile INSTANCE = new AwsConfigFile();

        public AwsConfigFile() {
            super("AWS_CONFIG_FILE", "aws.configFile", null);
        }
    }

    /* compiled from: AwsSdkSetting.kt */
    /* loaded from: classes.dex */
    public static final class AwsEc2MetadataServiceEndpoint extends AwsSdkSetting<String> {
        public static final AwsEc2MetadataServiceEndpoint INSTANCE = new AwsEc2MetadataServiceEndpoint();

        public AwsEc2MetadataServiceEndpoint() {
            super("AWS_EC2_METADATA_SERVICE_ENDPOINT", "aws.ec2MetadataServiceEndpoint", null);
        }
    }

    /* compiled from: AwsSdkSetting.kt */
    /* loaded from: classes.dex */
    public static final class AwsEc2MetadataServiceEndpointMode extends AwsSdkSetting<String> {
        public static final AwsEc2MetadataServiceEndpointMode INSTANCE = new AwsEc2MetadataServiceEndpointMode();

        public AwsEc2MetadataServiceEndpointMode() {
            super("AWS_EC2_METADATA_SERVICE_ENDPOINT_MODE", "aws.ec2MetadataServiceEndpointMode", null);
        }
    }

    /* compiled from: AwsSdkSetting.kt */
    /* loaded from: classes.dex */
    public static final class AwsSharedCredentialsFile extends AwsSdkSetting<String> {
        public static final AwsSharedCredentialsFile INSTANCE = new AwsSharedCredentialsFile();

        public AwsSharedCredentialsFile() {
            super("AWS_SHARED_CREDENTIALS_FILE", "aws.sharedCredentialsFile", null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AwsSdkSetting(String str, String str2, Object obj) {
        this.environmentVariable = str;
        this.jvmProperty = str2;
        this.defaultValue = obj;
    }
}
