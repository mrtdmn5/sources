package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.util.AttributeKey;

/* compiled from: AwsSigningAttributes.kt */
/* loaded from: classes.dex */
public final class AwsSigningAttributes {
    public static final AttributeKey<Object> Signer = new AttributeKey<>("Signer");
    public static final AttributeKey<String> SigningRegion = new AttributeKey<>("AwsSigningRegion");
    public static final AttributeKey<String> SigningService = new AttributeKey<>("AwsSigningService");
    public static final AttributeKey<CredentialsProvider> CredentialsProvider = new AttributeKey<>("CredentialsProvider");
}
