package aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal;

import aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.EndpointParameters;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResolveEndpoint.kt */
/* loaded from: classes.dex */
public final class ResolveEndpointKt {
    public static final void bindAwsBuiltins(EndpointParameters.Builder builder, CognitoIdentityProviderClient.Config config) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        builder.region = config.region;
        Boolean bool = Boolean.FALSE;
        builder.useDualStack = bool;
        builder.useFips = bool;
        builder.endpoint = null;
    }
}
