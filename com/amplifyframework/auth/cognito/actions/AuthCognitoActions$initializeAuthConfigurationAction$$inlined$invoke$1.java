package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class AuthCognitoActions$initializeAuthConfigurationAction$$inlined$invoke$1 implements Action {
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.AuthCognitoActions$initializeAuthConfigurationAction$$inlined$invoke$1", f = "AuthCognitoActions.kt", l = {68}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.AuthCognitoActions$initializeAuthConfigurationAction$$inlined$invoke$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthCognitoActions$initializeAuthConfigurationAction$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public AuthCognitoActions$initializeAuthConfigurationAction$$inlined$invoke$1(String str) {
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r8, com.amplifyframework.statemachine.Environment r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.amplifyframework.auth.cognito.actions.AuthCognitoActions$initializeAuthConfigurationAction$$inlined$invoke$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.amplifyframework.auth.cognito.actions.AuthCognitoActions$initializeAuthConfigurationAction$$inlined$invoke$1$1 r0 = (com.amplifyframework.auth.cognito.actions.AuthCognitoActions$initializeAuthConfigurationAction$$inlined$invoke$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.amplifyframework.auth.cognito.actions.AuthCognitoActions$initializeAuthConfigurationAction$$inlined$invoke$1$1 r0 = new com.amplifyframework.auth.cognito.actions.AuthCognitoActions$initializeAuthConfigurationAction$$inlined$invoke$1$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r8 = r0.L$2
            com.amplifyframework.auth.cognito.AuthEnvironment r8 = (com.amplifyframework.auth.cognito.AuthEnvironment) r8
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r0 = r0.L$0
            com.amplifyframework.statemachine.EventDispatcher r0 = (com.amplifyframework.statemachine.EventDispatcher) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L7b
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r10 = "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r10)
            java.lang.String r10 = r7.getId()
            com.amplifyframework.auth.cognito.AuthEnvironment r9 = (com.amplifyframework.auth.cognito.AuthEnvironment) r9
            com.amplifyframework.logging.Logger r2 = r9.getLogger()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r10)
            java.lang.String r5 = " Starting execution"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.verbose(r4)
            com.amplifyframework.auth.cognito.StoreClientBehavior r2 = r9.getCredentialStoreClient()
            com.amplifyframework.statemachine.codegen.data.CredentialType$Amplify r4 = com.amplifyframework.statemachine.codegen.data.CredentialType.Amplify.INSTANCE
            r0.L$0 = r8
            r0.L$1 = r10
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r0 = r2.loadCredentials(r4, r0)
            if (r0 != r1) goto L76
            return r1
        L76:
            r6 = r0
            r0 = r8
            r8 = r9
            r9 = r10
            r10 = r6
        L7b:
            com.amplifyframework.statemachine.codegen.data.AmplifyCredential r10 = (com.amplifyframework.statemachine.codegen.data.AmplifyCredential) r10
            com.amplifyframework.statemachine.codegen.data.AuthConfiguration r1 = r8.getConfiguration()
            com.amplifyframework.statemachine.codegen.data.UserPoolConfiguration r1 = r1.getUserPool()
            r2 = 2
            r3 = 0
            if (r1 == 0) goto L98
            com.amplifyframework.statemachine.codegen.events.AuthEvent r1 = new com.amplifyframework.statemachine.codegen.events.AuthEvent
            com.amplifyframework.statemachine.codegen.events.AuthEvent$EventType$ConfigureAuthentication r4 = new com.amplifyframework.statemachine.codegen.events.AuthEvent$EventType$ConfigureAuthentication
            com.amplifyframework.statemachine.codegen.data.AuthConfiguration r5 = r8.getConfiguration()
            r4.<init>(r5, r10)
            r1.<init>(r4, r3, r2, r3)
            goto La6
        L98:
            com.amplifyframework.statemachine.codegen.events.AuthEvent r1 = new com.amplifyframework.statemachine.codegen.events.AuthEvent
            com.amplifyframework.statemachine.codegen.events.AuthEvent$EventType$ConfigureAuthorization r4 = new com.amplifyframework.statemachine.codegen.events.AuthEvent$EventType$ConfigureAuthorization
            com.amplifyframework.statemachine.codegen.data.AuthConfiguration r5 = r8.getConfiguration()
            r4.<init>(r5, r10)
            r1.<init>(r4, r3, r2, r3)
        La6:
            com.amplifyframework.logging.Logger r8 = r8.getLogger()
            java.lang.String r10 = " Sending event "
            java.lang.StringBuilder r9 = androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(r9, r10)
            java.lang.String r10 = r1.getType()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.verbose(r9)
            r0.send(r1)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.AuthCognitoActions$initializeAuthConfigurationAction$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
