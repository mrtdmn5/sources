package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.AuthenticationEvent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class AuthenticationCognitoActions$configureAuthenticationAction$$inlined$invoke$1 implements Action {
    final /* synthetic */ AuthenticationEvent.EventType.Configure $event$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.AuthenticationCognitoActions$configureAuthenticationAction$$inlined$invoke$1", f = "AuthenticationCognitoActions.kt", l = {71}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.AuthenticationCognitoActions$configureAuthenticationAction$$inlined$invoke$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthenticationCognitoActions$configureAuthenticationAction$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public AuthenticationCognitoActions$configureAuthenticationAction$$inlined$invoke$1(String str, AuthenticationEvent.EventType.Configure configure) {
        this.$event$inlined = configure;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r20, com.amplifyframework.statemachine.Environment r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.AuthenticationCognitoActions$configureAuthenticationAction$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
