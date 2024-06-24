package aws.sdk.kotlin.runtime;

import aws.smithy.kotlin.runtime.ErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceException;

/* compiled from: Exceptions.kt */
/* loaded from: classes.dex */
public class AwsServiceException extends ServiceException {
    public final AwsErrorMetadata sdkErrorMetadata;

    public AwsServiceException() {
        this.sdkErrorMetadata = new AwsErrorMetadata();
    }

    @Override // aws.smithy.kotlin.runtime.ServiceException, aws.smithy.kotlin.runtime.SdkBaseException
    public final ErrorMetadata getSdkErrorMetadata() {
        return this.sdkErrorMetadata;
    }

    @Override // aws.smithy.kotlin.runtime.ServiceException, aws.smithy.kotlin.runtime.SdkBaseException
    public final ServiceErrorMetadata getSdkErrorMetadata() {
        return this.sdkErrorMetadata;
    }

    public AwsServiceException(String str) {
        super(str);
        this.sdkErrorMetadata = new AwsErrorMetadata();
    }

    public AwsServiceException(Exception exc) {
        super(exc);
        this.sdkErrorMetadata = new AwsErrorMetadata();
    }
}
