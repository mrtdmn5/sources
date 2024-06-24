package aws.sdk.kotlin.runtime.config.profile;

import aws.sdk.kotlin.runtime.ConfigurationException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwsConfigParser.kt */
/* loaded from: classes.dex */
public class AwsConfigParseException extends ConfigurationException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AwsConfigParseException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
