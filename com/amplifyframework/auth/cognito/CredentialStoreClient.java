package com.amplifyframework.auth.cognito;

import android.content.Context;
import com.amplifyframework.auth.cognito.data.AWSCognitoAuthCredentialStore;
import com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.StateChangeListenerToken;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.AuthConfiguration;
import com.amplifyframework.statemachine.codegen.data.CredentialType;
import com.amplifyframework.statemachine.codegen.events.CredentialStoreEvent;
import com.amplifyframework.statemachine.codegen.states.CredentialStoreState;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: CredentialStoreClient.kt */
/* loaded from: classes.dex */
public final class CredentialStoreClient implements StoreClientBehavior {
    private final CredentialStoreStateMachine credentialStoreStateMachine;
    private final Logger logger;

    public CredentialStoreClient(AuthConfiguration configuration, Context context, Logger logger) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.credentialStoreStateMachine = createCredentialStoreStateMachine(configuration, context);
    }

    private final CredentialStoreStateMachine createCredentialStoreStateMachine(AuthConfiguration authConfiguration, Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        AWSCognitoAuthCredentialStore aWSCognitoAuthCredentialStore = new AWSCognitoAuthCredentialStore(applicationContext, authConfiguration, false, null, 12, null);
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
        return new CredentialStoreStateMachine(new CredentialStoreEnvironment(aWSCognitoAuthCredentialStore, new AWSCognitoLegacyCredentialStore(applicationContext2, authConfiguration, null, 4, null), this.logger));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, com.amplifyframework.statemachine.StateChangeListenerToken] */
    private final void listenForResult(final CredentialStoreEvent credentialStoreEvent, final Function1<? super Result<? extends AmplifyCredential>, Unit> function1, final Function1<? super Exception, Unit> function12) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        ?? stateChangeListenerToken = new StateChangeListenerToken();
        ref$ObjectRef3.element = stateChangeListenerToken;
        this.credentialStoreStateMachine.listen(stateChangeListenerToken, new Function1<CredentialStoreState, Unit>() { // from class: com.amplifyframework.auth.cognito.CredentialStoreClient$listenForResult$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CredentialStoreState credentialStoreState) {
                invoke2(credentialStoreState);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.Result, T] */
            /* JADX WARN: Type inference failed for: r4v12, types: [com.amplifyframework.statemachine.codegen.errors.CredentialStoreError, T] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CredentialStoreState storeState) {
                CredentialStoreStateMachine credentialStoreStateMachine;
                CredentialStoreStateMachine credentialStoreStateMachine2;
                Intrinsics.checkNotNullParameter(storeState, "storeState");
                CredentialStoreClient.this.getLogger().verbose("Credential Store State Change: " + storeState);
                if (storeState instanceof CredentialStoreState.Success) {
                    ref$ObjectRef.element = new Result(((CredentialStoreState.Success) storeState).getStoredCredentials());
                    return;
                }
                if (storeState instanceof CredentialStoreState.Error) {
                    ref$ObjectRef2.element = ((CredentialStoreState.Error) storeState).getError();
                    return;
                }
                if (storeState instanceof CredentialStoreState.Idle) {
                    Result<AmplifyCredential> result = ref$ObjectRef.element;
                    Exception exc = ref$ObjectRef2.element;
                    if (result != null && ref$ObjectRef3.element != null) {
                        credentialStoreStateMachine2 = CredentialStoreClient.this.credentialStoreStateMachine;
                        StateChangeListenerToken stateChangeListenerToken2 = ref$ObjectRef3.element;
                        Intrinsics.checkNotNull(stateChangeListenerToken2);
                        credentialStoreStateMachine2.cancel(stateChangeListenerToken2);
                        ref$ObjectRef3.element = null;
                        function1.invoke(result);
                        return;
                    }
                    if (exc == null || ref$ObjectRef3.element == null) {
                        return;
                    }
                    credentialStoreStateMachine = CredentialStoreClient.this.credentialStoreStateMachine;
                    StateChangeListenerToken stateChangeListenerToken3 = ref$ObjectRef3.element;
                    Intrinsics.checkNotNull(stateChangeListenerToken3);
                    credentialStoreStateMachine.cancel(stateChangeListenerToken3);
                    ref$ObjectRef3.element = null;
                    function12.invoke(exc);
                }
            }
        }, new Function0<Unit>() { // from class: com.amplifyframework.auth.cognito.CredentialStoreClient$listenForResult$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CredentialStoreStateMachine credentialStoreStateMachine;
                credentialStoreStateMachine = CredentialStoreClient.this.credentialStoreStateMachine;
                credentialStoreStateMachine.send(credentialStoreEvent);
            }
        });
    }

    @Override // com.amplifyframework.auth.cognito.StoreClientBehavior
    public Object clearCredentials(CredentialType credentialType, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        listenForResult(new CredentialStoreEvent(new CredentialStoreEvent.EventType.ClearCredentialStore(credentialType), null, 2, null), new Function1<Result<? extends AmplifyCredential>, Unit>() { // from class: com.amplifyframework.auth.cognito.CredentialStoreClient$clearCredentials$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Result<? extends AmplifyCredential> result) {
                m629invoke(result.value);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m629invoke(Object obj) {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Function1<Exception, Unit>() { // from class: com.amplifyframework.auth.cognito.CredentialStoreClient$clearCredentials$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    @Override // com.amplifyframework.auth.cognito.StoreClientBehavior
    public Object loadCredentials(CredentialType credentialType, Continuation<? super AmplifyCredential> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        listenForResult(new CredentialStoreEvent(new CredentialStoreEvent.EventType.LoadCredentialStore(credentialType), null, 2, null), new Function1<Result<? extends AmplifyCredential>, Unit>() { // from class: com.amplifyframework.auth.cognito.CredentialStoreClient$loadCredentials$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Result<? extends AmplifyCredential> result) {
                m630invoke(result.value);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m630invoke(Object obj) {
                safeContinuation.resumeWith(obj);
            }
        }, new Function1<Exception, Unit>() { // from class: com.amplifyframework.auth.cognito.CredentialStoreClient$loadCredentials$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    @Override // com.amplifyframework.auth.cognito.StoreClientBehavior
    public Object storeCredentials(CredentialType credentialType, AmplifyCredential amplifyCredential, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        listenForResult(new CredentialStoreEvent(new CredentialStoreEvent.EventType.StoreCredentials(credentialType, amplifyCredential), null, 2, null), new Function1<Result<? extends AmplifyCredential>, Unit>() { // from class: com.amplifyframework.auth.cognito.CredentialStoreClient$storeCredentials$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Result<? extends AmplifyCredential> result) {
                m631invoke(result.value);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m631invoke(Object obj) {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Function1<Exception, Unit>() { // from class: com.amplifyframework.auth.cognito.CredentialStoreClient$storeCredentials$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }
}
