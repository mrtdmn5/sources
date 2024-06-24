package aws.smithy.kotlin.runtime;

/* compiled from: Exceptions.kt */
/* loaded from: classes.dex */
public class ServiceException extends SdkBaseException {
    public final ServiceErrorMetadata sdkErrorMetadata;

    /* compiled from: Exceptions.kt */
    /* loaded from: classes.dex */
    public enum ErrorType {
        Client,
        Server,
        Unknown
    }

    public ServiceException() {
        this.sdkErrorMetadata = new ServiceErrorMetadata();
    }

    @Override // aws.smithy.kotlin.runtime.SdkBaseException
    public ServiceErrorMetadata getSdkErrorMetadata() {
        return this.sdkErrorMetadata;
    }

    public ServiceException(String str) {
        super(str);
        this.sdkErrorMetadata = new ServiceErrorMetadata();
    }

    public ServiceException(Exception exc) {
        super("Failed to parse response as 'awsJson1_1' error", exc);
        this.sdkErrorMetadata = new ServiceErrorMetadata();
    }
}
