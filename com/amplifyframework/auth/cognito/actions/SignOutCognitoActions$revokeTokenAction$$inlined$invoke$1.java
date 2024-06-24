package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.SignOutEvent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class SignOutCognitoActions$revokeTokenAction$$inlined$invoke$1 implements Action {
    final /* synthetic */ SignOutEvent.EventType.RevokeToken $event$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.SignOutCognitoActions$revokeTokenAction$$inlined$invoke$1", f = "SignOutCognitoActions.kt", l = {74}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.SignOutCognitoActions$revokeTokenAction$$inlined$invoke$1$1, reason: invalid class name */
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
            return SignOutCognitoActions$revokeTokenAction$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public SignOutCognitoActions$revokeTokenAction$$inlined$invoke$1(String str, SignOutEvent.EventType.RevokeToken revokeToken) {
        this.$event$inlined = revokeToken;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:24|(3:46|47|(3:49|27|(2:29|(4:31|32|33|(1:35)(1:36))(4:41|13|14|15))(6:42|43|44|21|14|15)))|26|27|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0135, code lost:            r0 = e;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0 A[Catch: Exception -> 0x0098, TryCatch #1 {Exception -> 0x0098, blocks: (B:47:0x008c, B:29:0x00a0, B:31:0x00aa), top: B:46:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.amplifyframework.auth.cognito.helpers.JWTParser] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r18, com.amplifyframework.statemachine.Environment r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.SignOutCognitoActions$revokeTokenAction$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
