package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.SignInEvent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class SignInCognitoActions$confirmDevice$$inlined$invoke$1 implements Action {
    final /* synthetic */ SignInEvent.EventType.ConfirmDevice $event$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.SignInCognitoActions$confirmDevice$$inlined$invoke$1", f = "SignInCognitoActions.kt", l = {74, 87}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.SignInCognitoActions$confirmDevice$$inlined$invoke$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SignInCognitoActions$confirmDevice$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public SignInCognitoActions$confirmDevice$$inlined$invoke$1(String str, SignInEvent.EventType.ConfirmDevice confirmDevice) {
        this.$event$inlined = confirmDevice;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00f8 A[Catch: Exception -> 0x0084, TRY_LEAVE, TryCatch #3 {Exception -> 0x0084, blocks: (B:26:0x0078, B:28:0x00f4, B:30:0x00f8, B:34:0x016b, B:35:0x017b), top: B:25:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r22, com.amplifyframework.statemachine.Environment r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.SignInCognitoActions$confirmDevice$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
