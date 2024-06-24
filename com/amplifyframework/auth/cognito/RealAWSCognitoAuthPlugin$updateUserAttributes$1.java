package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthUpdateUserAttributesOptions;
import com.amplifyframework.auth.options.AuthUpdateUserAttributesOptions;
import com.amplifyframework.auth.result.AuthUpdateAttributeResult;
import com.amplifyframework.core.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RealAWSCognitoAuthPlugin.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$updateUserAttributes$1", f = "RealAWSCognitoAuthPlugin.kt", l = {1377}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RealAWSCognitoAuthPlugin$updateUserAttributes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<AuthUserAttribute> $attributes;
    final /* synthetic */ Consumer<AuthException> $onError;
    final /* synthetic */ Consumer<Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> $onSuccess;
    final /* synthetic */ AuthUpdateUserAttributesOptions $options;
    Object L$0;
    int label;
    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealAWSCognitoAuthPlugin$updateUserAttributes$1(AuthUpdateUserAttributesOptions authUpdateUserAttributesOptions, Consumer<Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> consumer, RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, List<AuthUserAttribute> list, Consumer<AuthException> consumer2, Continuation<? super RealAWSCognitoAuthPlugin$updateUserAttributes$1> continuation) {
        super(2, continuation);
        this.$options = authUpdateUserAttributesOptions;
        this.$onSuccess = consumer;
        this.this$0 = realAWSCognitoAuthPlugin;
        this.$attributes = list;
        this.$onError = consumer2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RealAWSCognitoAuthPlugin$updateUserAttributes$1(this.$options, this.$onSuccess, this.this$0, this.$attributes, this.$onError, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AWSCognitoAuthUpdateUserAttributesOptions aWSCognitoAuthUpdateUserAttributesOptions;
        Consumer consumer;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    consumer = (Consumer) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                AuthUpdateUserAttributesOptions authUpdateUserAttributesOptions = this.$options;
                Map<String, String> map = null;
                if (authUpdateUserAttributesOptions instanceof AWSCognitoAuthUpdateUserAttributesOptions) {
                    aWSCognitoAuthUpdateUserAttributesOptions = (AWSCognitoAuthUpdateUserAttributesOptions) authUpdateUserAttributesOptions;
                } else {
                    aWSCognitoAuthUpdateUserAttributesOptions = null;
                }
                Consumer<Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> consumer2 = this.$onSuccess;
                RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = this.this$0;
                List<AuthUserAttribute> list = this.$attributes;
                if (aWSCognitoAuthUpdateUserAttributesOptions != null) {
                    map = aWSCognitoAuthUpdateUserAttributesOptions.getMetadata();
                }
                this.L$0 = consumer2;
                this.label = 1;
                obj = realAWSCognitoAuthPlugin.updateUserAttributes((List<AuthUserAttribute>) list, (Map<String, String>) map, (Continuation<? super Map<AuthUserAttributeKey, AuthUpdateAttributeResult>>) this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
                consumer = consumer2;
            }
            consumer.accept(obj);
        } catch (AuthException e) {
            this.$onError.accept(e);
        } catch (Exception e2) {
            this.$onError.accept(CognitoAuthExceptionConverter.Companion.lookup(e2, e2.toString()));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RealAWSCognitoAuthPlugin$updateUserAttributes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
