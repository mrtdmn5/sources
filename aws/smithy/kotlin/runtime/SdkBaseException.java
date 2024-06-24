package aws.smithy.kotlin.runtime;

/* compiled from: Exceptions.kt */
/* loaded from: classes.dex */
public class SdkBaseException extends RuntimeException {
    public final ErrorMetadata sdkErrorMetadata;

    public SdkBaseException() {
        this.sdkErrorMetadata = new ErrorMetadata();
    }

    public ErrorMetadata getSdkErrorMetadata() {
        return this.sdkErrorMetadata;
    }

    public SdkBaseException(String str) {
        super(str);
        this.sdkErrorMetadata = new ErrorMetadata();
    }

    public SdkBaseException(String str, Throwable th) {
        super(str, th);
        this.sdkErrorMetadata = new ErrorMetadata();
    }

    public SdkBaseException(Exception exc) {
        super(exc);
        this.sdkErrorMetadata = new ErrorMetadata();
    }
}
