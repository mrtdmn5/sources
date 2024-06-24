package aws.smithy.kotlin.runtime;

import aws.smithy.kotlin.runtime.util.AttributeKey;
import aws.smithy.kotlin.runtime.util.AttributesImpl;

/* compiled from: Exceptions.kt */
/* loaded from: classes.dex */
public class ErrorMetadata {
    public static final AttributeKey<Boolean> Retryable = new AttributeKey<>("Retryable");
    public static final AttributeKey<Boolean> ThrottlingError = new AttributeKey<>("ThrottlingError");
    public final AttributesImpl attributes = new AttributesImpl();

    public final boolean isRetryable() {
        Boolean bool = (Boolean) this.attributes.getOrNull(Retryable);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
