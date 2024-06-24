package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.InvalidPasswordException;
import aws.smithy.kotlin.runtime.http.operation.HttpDeserialize;

/* compiled from: InvalidPasswordExceptionDeserializer.kt */
/* loaded from: classes.dex */
public final class InvalidPasswordExceptionDeserializer implements HttpDeserialize<InvalidPasswordException> {
    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpDeserialize
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deserialize(aws.smithy.kotlin.runtime.operation.ExecutionContext r6, aws.smithy.kotlin.runtime.http.response.HttpResponse r7, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.services.cognitoidentityprovider.model.InvalidPasswordException> r8) {
        /*
            r5 = this;
            boolean r6 = r8 instanceof aws.sdk.kotlin.services.cognitoidentityprovider.transform.InvalidPasswordExceptionDeserializer$deserialize$1
            if (r6 == 0) goto L13
            r6 = r8
            aws.sdk.kotlin.services.cognitoidentityprovider.transform.InvalidPasswordExceptionDeserializer$deserialize$1 r6 = (aws.sdk.kotlin.services.cognitoidentityprovider.transform.InvalidPasswordExceptionDeserializer$deserialize$1) r6
            int r0 = r6.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r6.label = r0
            goto L18
        L13:
            aws.sdk.kotlin.services.cognitoidentityprovider.transform.InvalidPasswordExceptionDeserializer$deserialize$1 r6 = new aws.sdk.kotlin.services.cognitoidentityprovider.transform.InvalidPasswordExceptionDeserializer$deserialize$1
            r6.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            aws.sdk.kotlin.services.cognitoidentityprovider.model.InvalidPasswordException$Builder r6 = r6.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L49
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.throwOnFailure(r8)
            aws.sdk.kotlin.services.cognitoidentityprovider.model.InvalidPasswordException$Builder r8 = new aws.sdk.kotlin.services.cognitoidentityprovider.model.InvalidPasswordException$Builder
            r8.<init>()
            aws.smithy.kotlin.runtime.http.HttpBody r7 = r7.body
            r6.L$0 = r8
            r6.label = r2
            java.io.Serializable r6 = aws.smithy.kotlin.runtime.http.HttpBodyKt.readAll(r7, r6)
            if (r6 != r0) goto L46
            return r0
        L46:
            r4 = r8
            r8 = r6
            r6 = r4
        L49:
            byte[] r8 = (byte[]) r8
            if (r8 == 0) goto L89
            aws.smithy.kotlin.runtime.serde.json.JsonDeserializer r7 = new aws.smithy.kotlin.runtime.serde.json.JsonDeserializer
            r7.<init>(r8)
            aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor r8 = new aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor
            aws.smithy.kotlin.runtime.serde.SerialKind$String r0 = aws.smithy.kotlin.runtime.serde.SerialKind.String.INSTANCE
            aws.smithy.kotlin.runtime.serde.FieldTrait[] r1 = new aws.smithy.kotlin.runtime.serde.FieldTrait[r2]
            aws.smithy.kotlin.runtime.serde.json.JsonSerialName r2 = new aws.smithy.kotlin.runtime.serde.json.JsonSerialName
            java.lang.String r3 = "message"
            r2.<init>(r3)
            r3 = 0
            r1[r3] = r2
            r8.<init>(r0, r1)
            aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor$Builder r0 = aws.sdk.kotlin.services.cognitoidentity.transform.ExternalServiceExceptionDeserializer$$ExternalSyntheticOutline1.m(r8)
            aws.smithy.kotlin.runtime.serde.Deserializer$FieldIterator r7 = aws.sdk.kotlin.services.cognitoidentity.transform.ExternalServiceExceptionDeserializer$$ExternalSyntheticOutline0.m(r0, r7)
        L6d:
            java.lang.Integer r0 = r7.findNextFieldIndex()
            int r1 = r8.index
            if (r0 != 0) goto L76
            goto L83
        L76:
            int r2 = r0.intValue()
            if (r2 != r1) goto L83
            java.lang.String r0 = r7.deserializeString()
            r6.message = r0
            goto L6d
        L83:
            if (r0 == 0) goto L89
            r7.skipValue()
            goto L6d
        L89:
            r6.getClass()
            aws.sdk.kotlin.services.cognitoidentityprovider.model.InvalidPasswordException r7 = new aws.sdk.kotlin.services.cognitoidentityprovider.model.InvalidPasswordException
            r7.<init>(r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.services.cognitoidentityprovider.transform.InvalidPasswordExceptionDeserializer.deserialize(aws.smithy.kotlin.runtime.operation.ExecutionContext, aws.smithy.kotlin.runtime.http.response.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
