package aws.sdk.kotlin.runtime.config.imds;

import aws.sdk.kotlin.runtime.AwsServiceException;

/* compiled from: ImdsClient.kt */
/* loaded from: classes.dex */
public final class EC2MetadataError extends AwsServiceException {
    public final int statusCode;

    public EC2MetadataError(int r1, String str) {
        super(str);
        this.statusCode = r1;
    }
}
