package aws.smithy.kotlin.runtime;

import aws.smithy.kotlin.runtime.ServiceException;
import aws.smithy.kotlin.runtime.util.AttributeKey;

/* compiled from: Exceptions.kt */
/* loaded from: classes.dex */
public class ServiceErrorMetadata extends ErrorMetadata {
    public static final AttributeKey<String> ErrorCode = new AttributeKey<>("ErrorCode");
    public static final AttributeKey<String> ErrorMessage = new AttributeKey<>("ErrorMessage");
    public static final AttributeKey<ServiceException.ErrorType> ErrorType = new AttributeKey<>("ErrorType");
    public static final AttributeKey<ProtocolResponse> ProtocolResponse = new AttributeKey<>("ProtocolResponse");
    public static final AttributeKey<String> RequestId = new AttributeKey<>("RequestId");
}
