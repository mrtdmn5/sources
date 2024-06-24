package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1 implements Action {
    final /* synthetic */ AmplifyCredential $amplifyCredential$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1", f = "AuthorizationCognitoActions.kt", l = {69}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1(String str, AmplifyCredential amplifyCredential) {
        this.$amplifyCredential$inlined = amplifyCredential;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r9, com.amplifyframework.statemachine.Environment r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1$1 r0 = (com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1$1 r0 = new com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L48
            if (r2 != r4) goto L40
            java.lang.Object r9 = r0.L$3
            com.amplifyframework.auth.cognito.AuthEnvironment r9 = (com.amplifyframework.auth.cognito.AuthEnvironment) r9
            java.lang.Object r10 = r0.L$2
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r1 = r0.L$1
            com.amplifyframework.statemachine.EventDispatcher r1 = (com.amplifyframework.statemachine.EventDispatcher) r1
            java.lang.Object r0 = r0.L$0
            com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1 r0 = (com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L3c
            r11 = r10
            r10 = r9
            r9 = r1
            goto L79
        L3c:
            r11 = r10
            r10 = r9
            r9 = r1
            goto L86
        L40:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L48:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r11 = "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)
            java.lang.String r11 = r8.getId()
            com.amplifyframework.auth.cognito.AuthEnvironment r10 = (com.amplifyframework.auth.cognito.AuthEnvironment) r10
            com.amplifyframework.logging.Logger r2 = r10.getLogger()
            java.lang.String r6 = " Starting execution"
            com.amplifyframework.auth.cognito.actions.AuthCognitoActions$initializeAuthorizationConfigurationAction$$inlined$invoke$1$$ExternalSyntheticOutline0.m(r11, r6, r2)
            com.amplifyframework.auth.cognito.StoreClientBehavior r2 = r10.getCredentialStoreClient()     // Catch: java.lang.Exception -> L86
            com.amplifyframework.statemachine.codegen.data.CredentialType$Amplify r6 = com.amplifyframework.statemachine.codegen.data.CredentialType.Amplify.INSTANCE     // Catch: java.lang.Exception -> L86
            com.amplifyframework.statemachine.codegen.data.AmplifyCredential r7 = r8.$amplifyCredential$inlined     // Catch: java.lang.Exception -> L86
            r0.L$0 = r8     // Catch: java.lang.Exception -> L86
            r0.L$1 = r9     // Catch: java.lang.Exception -> L86
            r0.L$2 = r11     // Catch: java.lang.Exception -> L86
            r0.L$3 = r10     // Catch: java.lang.Exception -> L86
            r0.label = r4     // Catch: java.lang.Exception -> L86
            java.lang.Object r0 = r2.storeCredentials(r6, r7, r0)     // Catch: java.lang.Exception -> L86
            if (r0 != r1) goto L78
            return r1
        L78:
            r0 = r8
        L79:
            com.amplifyframework.statemachine.codegen.events.AuthEvent r1 = new com.amplifyframework.statemachine.codegen.events.AuthEvent     // Catch: java.lang.Exception -> L86
            com.amplifyframework.statemachine.codegen.events.AuthEvent$EventType$ReceivedCachedCredentials r2 = new com.amplifyframework.statemachine.codegen.events.AuthEvent$EventType$ReceivedCachedCredentials     // Catch: java.lang.Exception -> L86
            com.amplifyframework.statemachine.codegen.data.AmplifyCredential r0 = r0.$amplifyCredential$inlined     // Catch: java.lang.Exception -> L86
            r2.<init>(r0)     // Catch: java.lang.Exception -> L86
            r1.<init>(r2, r5, r3, r5)     // Catch: java.lang.Exception -> L86
            goto L8d
        L86:
            com.amplifyframework.statemachine.codegen.events.AuthEvent r1 = new com.amplifyframework.statemachine.codegen.events.AuthEvent
            com.amplifyframework.statemachine.codegen.events.AuthEvent$EventType$CachedCredentialsFailed r0 = com.amplifyframework.statemachine.codegen.events.AuthEvent.EventType.CachedCredentialsFailed.INSTANCE
            r1.<init>(r0, r5, r3, r5)
        L8d:
            com.amplifyframework.logging.Logger r10 = r10.getLogger()
            java.lang.String r0 = " Sending event "
            java.lang.StringBuilder r11 = androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(r11, r0)
            java.lang.String r0 = r1.getType()
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.verbose(r11)
            r9.send(r1)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.AuthorizationCognitoActions$persistCredentials$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
