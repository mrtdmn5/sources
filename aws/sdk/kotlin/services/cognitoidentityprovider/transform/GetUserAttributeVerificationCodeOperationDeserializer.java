package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResponse;
import aws.smithy.kotlin.runtime.http.operation.HttpDeserialize;

/* compiled from: GetUserAttributeVerificationCodeOperationDeserializer.kt */
/* loaded from: classes.dex */
public final class GetUserAttributeVerificationCodeOperationDeserializer implements HttpDeserialize<GetUserAttributeVerificationCodeResponse> {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpDeserialize
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deserialize(aws.smithy.kotlin.runtime.operation.ExecutionContext r6, aws.smithy.kotlin.runtime.http.response.HttpResponse r7, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResponse> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof aws.sdk.kotlin.services.cognitoidentityprovider.transform.GetUserAttributeVerificationCodeOperationDeserializer$deserialize$1
            if (r0 == 0) goto L13
            r0 = r8
            aws.sdk.kotlin.services.cognitoidentityprovider.transform.GetUserAttributeVerificationCodeOperationDeserializer$deserialize$1 r0 = (aws.sdk.kotlin.services.cognitoidentityprovider.transform.GetUserAttributeVerificationCodeOperationDeserializer$deserialize$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.sdk.kotlin.services.cognitoidentityprovider.transform.GetUserAttributeVerificationCodeOperationDeserializer$deserialize$1 r0 = new aws.sdk.kotlin.services.cognitoidentityprovider.transform.GetUserAttributeVerificationCodeOperationDeserializer$deserialize$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResponse$Builder r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L64
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4c
        L38:
            kotlin.ResultKt.throwOnFailure(r8)
            aws.smithy.kotlin.runtime.http.HttpStatusCode r8 = r7.status
            boolean r8 = aws.smithy.kotlin.runtime.http.HttpStatusCodeKt.isSuccess(r8)
            if (r8 != 0) goto L52
            r0.label = r4
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = aws.sdk.kotlin.services.cognitoidentityprovider.transform.GetUserAttributeVerificationCodeOperationDeserializerKt.access$throwGetUserAttributeVerificationCodeError(r6, r7, r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        L52:
            aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResponse$Builder r6 = new aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResponse$Builder
            r6.<init>()
            r0.L$0 = r6
            r0.label = r3
            aws.smithy.kotlin.runtime.http.HttpBody r7 = r7.body
            java.io.Serializable r8 = aws.smithy.kotlin.runtime.http.HttpBodyKt.readAll(r7, r0)
            if (r8 != r1) goto L64
            return r1
        L64:
            byte[] r8 = (byte[]) r8
            if (r8 == 0) goto La4
            aws.smithy.kotlin.runtime.serde.json.JsonDeserializer r7 = new aws.smithy.kotlin.runtime.serde.json.JsonDeserializer
            r7.<init>(r8)
            aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor r8 = new aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor
            aws.smithy.kotlin.runtime.serde.SerialKind$Struct r0 = aws.smithy.kotlin.runtime.serde.SerialKind.Struct.INSTANCE
            aws.smithy.kotlin.runtime.serde.FieldTrait[] r1 = new aws.smithy.kotlin.runtime.serde.FieldTrait[r4]
            aws.smithy.kotlin.runtime.serde.json.JsonSerialName r2 = new aws.smithy.kotlin.runtime.serde.json.JsonSerialName
            java.lang.String r3 = "CodeDeliveryDetails"
            r2.<init>(r3)
            r3 = 0
            r1[r3] = r2
            r8.<init>(r0, r1)
            aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor$Builder r0 = aws.sdk.kotlin.services.cognitoidentity.transform.ExternalServiceExceptionDeserializer$$ExternalSyntheticOutline1.m(r8)
            aws.smithy.kotlin.runtime.serde.Deserializer$FieldIterator r0 = aws.sdk.kotlin.services.cognitoidentity.transform.ExternalServiceExceptionDeserializer$$ExternalSyntheticOutline0.m(r0, r7)
        L88:
            java.lang.Integer r1 = r0.findNextFieldIndex()
            int r2 = r8.index
            if (r1 != 0) goto L91
            goto L9e
        L91:
            int r3 = r1.intValue()
            if (r3 != r2) goto L9e
            aws.sdk.kotlin.services.cognitoidentityprovider.model.CodeDeliveryDetailsType r1 = aws.sdk.kotlin.services.cognitoidentityprovider.transform.CodeDeliveryDetailsTypeDocumentDeserializerKt.deserializeCodeDeliveryDetailsTypeDocument(r7)
            r6.codeDeliveryDetails = r1
            goto L88
        L9e:
            if (r1 == 0) goto La4
            r0.skipValue()
            goto L88
        La4:
            r6.getClass()
            aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResponse r7 = new aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResponse
            r7.<init>(r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.transform.GetUserAttributeVerificationCodeOperationDeserializer.deserialize(aws.smithy.kotlin.runtime.operation.ExecutionContext, aws.smithy.kotlin.runtime.http.response.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
