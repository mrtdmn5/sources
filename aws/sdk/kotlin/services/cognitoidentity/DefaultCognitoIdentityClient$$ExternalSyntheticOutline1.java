package aws.sdk.kotlin.services.cognitoidentity;

import aws.sdk.kotlin.runtime.http.middleware.RecursionDetection;
import aws.sdk.kotlin.runtime.http.middleware.UserAgent;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class DefaultCognitoIdentityClient$$ExternalSyntheticOutline1 {
    public static void m(UserAgent userAgent, SdkHttpOperation sdkHttpOperation, SdkHttpOperation sdkHttpOperation2) {
        userAgent.install(sdkHttpOperation);
        new RecursionDetection().install(sdkHttpOperation2);
    }
}
