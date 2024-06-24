package aws.sdk.kotlin.services.cognitoidentity;

import aws.smithy.kotlin.runtime.http.operation.HttpOperationContext;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationBuilder;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class DefaultCognitoIdentityClient$$ExternalSyntheticOutline0 {
    public static SdkHttpOperation m(HttpOperationContext.Builder builder, Integer num, String str, String str2, SdkHttpOperationBuilder sdkHttpOperationBuilder) {
        builder.setExpectedHttpStatus(num);
        builder.setService(str);
        builder.setOperationName(str2);
        return sdkHttpOperationBuilder.build();
    }
}
