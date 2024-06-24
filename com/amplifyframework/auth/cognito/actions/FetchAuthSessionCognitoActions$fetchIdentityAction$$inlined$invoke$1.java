package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.data.LoginsMapProvider;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class FetchAuthSessionCognitoActions$fetchIdentityAction$$inlined$invoke$1 implements Action {
    final /* synthetic */ LoginsMapProvider $loginsMap$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions$fetchIdentityAction$$inlined$invoke$1", f = "FetchAuthSessionCognitoActions.kt", l = {74}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions$fetchIdentityAction$$inlined$invoke$1$1, reason: invalid class name */
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
            return FetchAuthSessionCognitoActions$fetchIdentityAction$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public FetchAuthSessionCognitoActions$fetchIdentityAction$$inlined$invoke$1(String str, LoginsMapProvider loginsMapProvider) {
        this.$loginsMap$inlined = loginsMapProvider;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00ad A[Catch: Exception -> 0x0041, NotAuthorizedException -> 0x0044, TryCatch #4 {NotAuthorizedException -> 0x0044, Exception -> 0x0041, blocks: (B:11:0x003d, B:12:0x009d, B:14:0x00ad, B:16:0x00b1, B:20:0x00be, B:21:0x00c5), top: B:10:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r16, com.amplifyframework.statemachine.Environment r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions$fetchIdentityAction$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
