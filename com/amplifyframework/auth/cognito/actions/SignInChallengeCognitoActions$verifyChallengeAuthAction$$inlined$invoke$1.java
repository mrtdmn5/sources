package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.data.AuthChallenge;
import com.amplifyframework.statemachine.codegen.events.SignInChallengeEvent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class SignInChallengeCognitoActions$verifyChallengeAuthAction$$inlined$invoke$1 implements Action {
    final /* synthetic */ AuthChallenge $challenge$inlined;
    final /* synthetic */ SignInChallengeEvent.EventType.VerifyChallengeAnswer $event$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.SignInChallengeCognitoActions$verifyChallengeAuthAction$$inlined$invoke$1", f = "SignInChallengeCognitoActions.kt", l = {87, 91}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.SignInChallengeCognitoActions$verifyChallengeAuthAction$$inlined$invoke$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SignInChallengeCognitoActions$verifyChallengeAuthAction$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public SignInChallengeCognitoActions$verifyChallengeAuthAction$$inlined$invoke$1(String str, AuthChallenge authChallenge, SignInChallengeEvent.EventType.VerifyChallengeAnswer verifyChallengeAnswer) {
        this.$challenge$inlined = authChallenge;
        this.$event$inlined = verifyChallengeAnswer;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x01bc, code lost:            if (r0 == null) goto L84;     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012b A[Catch: Exception -> 0x006e, TryCatch #1 {Exception -> 0x006e, blocks: (B:38:0x0069, B:39:0x010a, B:40:0x011d, B:42:0x012b, B:44:0x013a, B:45:0x0140, B:47:0x0162, B:49:0x016c, B:50:0x0174), top: B:37:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00a2 A[Catch: Exception -> 0x01d9, TryCatch #2 {Exception -> 0x01d9, blocks: (B:61:0x0089, B:63:0x0096, B:68:0x00a2, B:69:0x00a7, B:71:0x00b5, B:72:0x00be, B:74:0x00ca, B:75:0x00d0, B:77:0x00da, B:78:0x00e0, B:80:0x00e6, B:82:0x00ed), top: B:60:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b5 A[Catch: Exception -> 0x01d9, TryCatch #2 {Exception -> 0x01d9, blocks: (B:61:0x0089, B:63:0x0096, B:68:0x00a2, B:69:0x00a7, B:71:0x00b5, B:72:0x00be, B:74:0x00ca, B:75:0x00d0, B:77:0x00da, B:78:0x00e0, B:80:0x00e6, B:82:0x00ed), top: B:60:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ca A[Catch: Exception -> 0x01d9, TryCatch #2 {Exception -> 0x01d9, blocks: (B:61:0x0089, B:63:0x0096, B:68:0x00a2, B:69:0x00a7, B:71:0x00b5, B:72:0x00be, B:74:0x00ca, B:75:0x00d0, B:77:0x00da, B:78:0x00e0, B:80:0x00e6, B:82:0x00ed), top: B:60:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da A[Catch: Exception -> 0x01d9, TryCatch #2 {Exception -> 0x01d9, blocks: (B:61:0x0089, B:63:0x0096, B:68:0x00a2, B:69:0x00a7, B:71:0x00b5, B:72:0x00be, B:74:0x00ca, B:75:0x00d0, B:77:0x00da, B:78:0x00e0, B:80:0x00e6, B:82:0x00ed), top: B:60:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6 A[Catch: Exception -> 0x01d9, TryCatch #2 {Exception -> 0x01d9, blocks: (B:61:0x0089, B:63:0x0096, B:68:0x00a2, B:69:0x00a7, B:71:0x00b5, B:72:0x00be, B:74:0x00ca, B:75:0x00d0, B:77:0x00da, B:78:0x00e0, B:80:0x00e6, B:82:0x00ed), top: B:60:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ed A[Catch: Exception -> 0x01d9, TRY_LEAVE, TryCatch #2 {Exception -> 0x01d9, blocks: (B:61:0x0089, B:63:0x0096, B:68:0x00a2, B:69:0x00a7, B:71:0x00b5, B:72:0x00be, B:74:0x00ca, B:75:0x00d0, B:77:0x00da, B:78:0x00e0, B:80:0x00e6, B:82:0x00ed), top: B:60:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00cf  */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r23, com.amplifyframework.statemachine.Environment r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            Method dump skipped, instructions count: 521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.SignInChallengeCognitoActions$verifyChallengeAuthAction$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
