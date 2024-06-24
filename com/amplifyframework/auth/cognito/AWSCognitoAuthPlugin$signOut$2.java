package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.options.AuthSignOutOptions;
import com.amplifyframework.auth.result.AuthSignOutResult;
import com.amplifyframework.core.Consumer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AWSCognitoAuthPlugin.kt */
@DebugMetadata(c = "com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin$signOut$2", f = "AWSCognitoAuthPlugin.kt", l = {733}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AWSCognitoAuthPlugin$signOut$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Consumer<AuthSignOutResult> $onComplete;
    final /* synthetic */ AuthSignOutOptions $options;
    int label;
    final /* synthetic */ AWSCognitoAuthPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWSCognitoAuthPlugin$signOut$2(AWSCognitoAuthPlugin aWSCognitoAuthPlugin, AuthSignOutOptions authSignOutOptions, Consumer<AuthSignOutResult> consumer, Continuation<? super AWSCognitoAuthPlugin$signOut$2> continuation) {
        super(2, continuation);
        this.this$0 = aWSCognitoAuthPlugin;
        this.$options = authSignOutOptions;
        this.$onComplete = consumer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AWSCognitoAuthPlugin$signOut$2(this.this$0, this.$options, this.$onComplete, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KotlinAuthFacadeInternal queueFacade;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            queueFacade = this.this$0.getQueueFacade();
            AuthSignOutOptions authSignOutOptions = this.$options;
            this.label = 1;
            obj = queueFacade.signOut(authSignOutOptions, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        this.$onComplete.accept((AuthSignOutResult) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AWSCognitoAuthPlugin$signOut$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
