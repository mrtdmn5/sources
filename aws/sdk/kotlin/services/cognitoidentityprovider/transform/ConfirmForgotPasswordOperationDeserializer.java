package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmForgotPasswordResponse;
import aws.smithy.kotlin.runtime.http.operation.HttpDeserialize;

/* compiled from: ConfirmForgotPasswordOperationDeserializer.kt */
/* loaded from: classes.dex */
public final class ConfirmForgotPasswordOperationDeserializer implements HttpDeserialize<ConfirmForgotPasswordResponse> {
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpDeserialize
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deserialize(aws.smithy.kotlin.runtime.operation.ExecutionContext r5, aws.smithy.kotlin.runtime.http.response.HttpResponse r6, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmForgotPasswordResponse> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmForgotPasswordOperationDeserializer$deserialize$1
            if (r0 == 0) goto L13
            r0 = r7
            aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmForgotPasswordOperationDeserializer$deserialize$1 r0 = (aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmForgotPasswordOperationDeserializer$deserialize$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmForgotPasswordOperationDeserializer$deserialize$1 r0 = new aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmForgotPasswordOperationDeserializer$deserialize$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2b:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L43
        L2f:
            kotlin.ResultKt.throwOnFailure(r7)
            aws.smithy.kotlin.runtime.http.HttpStatusCode r7 = r6.status
            boolean r7 = aws.smithy.kotlin.runtime.http.HttpStatusCodeKt.isSuccess(r7)
            if (r7 != 0) goto L49
            r0.label = r3
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmForgotPasswordOperationDeserializerKt.access$throwConfirmForgotPasswordError(r5, r6, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        L49:
            aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmForgotPasswordResponse r5 = new aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmForgotPasswordResponse
            r5.<init>()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmForgotPasswordOperationDeserializer.deserialize(aws.smithy.kotlin.runtime.operation.ExecutionContext, aws.smithy.kotlin.runtime.http.response.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
