package com.animaconnected.secondo.provider.login;

import com.amplifyframework.auth.AWSCredentials;
import com.amplifyframework.auth.AWSTemporaryCredentials;
import com.amplifyframework.auth.cognito.AWSCognitoAuthSession;
import com.amplifyframework.kotlin.auth.KotlinAuthFacade;
import com.amplifyframework.kotlin.core.Amplify;
import com.animaconnected.cloud.CloudKt;
import com.animaconnected.cloud.amazon.AWSAmplifyCredentials;
import com.animaconnected.future.Promise;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AWSAmplifyCredentialsProviderImpl.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.login.AWSAmplifyCredentialsProviderImpl$getCredentialsProvider$1", f = "AWSAmplifyCredentialsProviderImpl.kt", l = {26}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AWSAmplifyCredentialsProviderImpl$getCredentialsProvider$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Promise<AWSAmplifyCredentials> $promise;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWSAmplifyCredentialsProviderImpl$getCredentialsProvider$1(Promise<AWSAmplifyCredentials> promise, Continuation<? super AWSAmplifyCredentialsProviderImpl$getCredentialsProvider$1> continuation) {
        super(2, continuation);
        this.$promise = promise;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AWSAmplifyCredentialsProviderImpl$getCredentialsProvider$1(this.$promise, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AWSTemporaryCredentials aWSTemporaryCredentials;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                KotlinAuthFacade auth = Amplify.Companion.getAuth();
                this.label = 1;
                obj = CloudKt.getAuthSession(auth, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            AWSCredentials value = ((AWSCognitoAuthSession) obj).getAwsCredentialsResult().getValue();
            if (value instanceof AWSTemporaryCredentials) {
                aWSTemporaryCredentials = (AWSTemporaryCredentials) value;
            } else {
                aWSTemporaryCredentials = null;
            }
            if (aWSTemporaryCredentials == null) {
                this.$promise.reject(new RuntimeException("Credentials is not AWSTemporaryCredentials type"));
                return Unit.INSTANCE;
            }
            this.$promise.resolve(new AWSAmplifyCredentials(aWSTemporaryCredentials.getAccessKeyId(), aWSTemporaryCredentials.getSecretAccessKey(), aWSTemporaryCredentials.getSessionToken()));
            return Unit.INSTANCE;
        } catch (Exception e) {
            this.$promise.reject(e);
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AWSAmplifyCredentialsProviderImpl$getCredentialsProvider$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
