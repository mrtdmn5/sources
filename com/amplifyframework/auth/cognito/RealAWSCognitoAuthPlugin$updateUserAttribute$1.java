package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.cognito.options.AWSCognitoAuthUpdateUserAttributeOptions;
import com.amplifyframework.auth.options.AuthUpdateUserAttributeOptions;
import com.amplifyframework.auth.result.AuthUpdateAttributeResult;
import com.amplifyframework.core.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RealAWSCognitoAuthPlugin.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.RealAWSCognitoAuthPlugin$updateUserAttribute$1", f = "RealAWSCognitoAuthPlugin.kt", l = {1350}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RealAWSCognitoAuthPlugin$updateUserAttribute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthUserAttribute $attribute;
    final /* synthetic */ Consumer<AuthException> $onError;
    final /* synthetic */ Consumer<AuthUpdateAttributeResult> $onSuccess;
    final /* synthetic */ AuthUpdateUserAttributeOptions $options;
    int label;
    final /* synthetic */ RealAWSCognitoAuthPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealAWSCognitoAuthPlugin$updateUserAttribute$1(AuthUserAttribute authUserAttribute, AuthUpdateUserAttributeOptions authUpdateUserAttributeOptions, RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin, Consumer<AuthUpdateAttributeResult> consumer, Consumer<AuthException> consumer2, Continuation<? super RealAWSCognitoAuthPlugin$updateUserAttribute$1> continuation) {
        super(2, continuation);
        this.$attribute = authUserAttribute;
        this.$options = authUpdateUserAttributeOptions;
        this.this$0 = realAWSCognitoAuthPlugin;
        this.$onSuccess = consumer;
        this.$onError = consumer2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RealAWSCognitoAuthPlugin$updateUserAttribute$1(this.$attribute, this.$options, this.this$0, this.$onSuccess, this.$onError, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AWSCognitoAuthUpdateUserAttributeOptions aWSCognitoAuthUpdateUserAttributeOptions;
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
                List listOf = CollectionsKt__CollectionsKt.listOf(this.$attribute);
                AuthUpdateUserAttributeOptions authUpdateUserAttributeOptions = this.$options;
                Map<String, String> map = null;
                if (authUpdateUserAttributeOptions instanceof AWSCognitoAuthUpdateUserAttributeOptions) {
                    aWSCognitoAuthUpdateUserAttributeOptions = (AWSCognitoAuthUpdateUserAttributeOptions) authUpdateUserAttributeOptions;
                } else {
                    aWSCognitoAuthUpdateUserAttributeOptions = null;
                }
                RealAWSCognitoAuthPlugin realAWSCognitoAuthPlugin = this.this$0;
                ArrayList mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) listOf);
                if (aWSCognitoAuthUpdateUserAttributeOptions != null) {
                    map = aWSCognitoAuthUpdateUserAttributeOptions.getMetadata();
                }
                this.label = 1;
                obj = realAWSCognitoAuthPlugin.updateUserAttributes((List<AuthUserAttribute>) mutableList, (Map<String, String>) map, (Continuation<? super Map<AuthUserAttributeKey, AuthUpdateAttributeResult>>) this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            this.$onSuccess.accept(((Map.Entry) CollectionsKt___CollectionsKt.first(((Map) obj).entrySet())).getValue());
        } catch (AuthException e) {
            this.$onError.accept(e);
        } catch (Exception e2) {
            this.$onError.accept(CognitoAuthExceptionConverter.Companion.lookup(e2, e2.toString()));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RealAWSCognitoAuthPlugin$updateUserAttribute$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
