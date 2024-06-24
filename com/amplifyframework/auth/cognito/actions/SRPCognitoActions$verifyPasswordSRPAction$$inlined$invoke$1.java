package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.SRPEvent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class SRPCognitoActions$verifyPasswordSRPAction$$inlined$invoke$1 implements Action {
    final /* synthetic */ SRPEvent.EventType.RespondPasswordVerifier $event$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.SRPCognitoActions$verifyPasswordSRPAction$$inlined$invoke$1", f = "SRPCognitoActions.kt", l = {95, 99}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.SRPCognitoActions$verifyPasswordSRPAction$$inlined$invoke$1$1, reason: invalid class name */
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
            return SRPCognitoActions$verifyPasswordSRPAction$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public SRPCognitoActions$verifyPasswordSRPAction$$inlined$invoke$1(String str, SRPEvent.EventType.RespondPasswordVerifier respondPasswordVerifier) {
        this.$event$inlined = respondPasswordVerifier;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|(1:(1:(7:10|11|12|13|14|15|(3:17|18|19)(2:21|22))(2:29|30))(4:31|32|33|34))(11:55|56|57|(1:59)(1:73)|60|(1:62)|63|64|65|66|(1:68)(1:69))|35|36|(5:38|(1:40)|(1:42)|43|(1:45)(5:46|13|14|15|(0)(0)))(3:48|15|(0)(0))))|76|6|(0)(0)|35|36|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0207, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0208, code lost:            r4 = r7;        r7 = r8;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01dd A[Catch: Exception -> 0x0204, TRY_ENTER, TryCatch #5 {Exception -> 0x0204, blocks: (B:17:0x01dd, B:21:0x01f5, B:22:0x0203), top: B:15:0x01db }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01f5 A[Catch: Exception -> 0x0204, TryCatch #5 {Exception -> 0x0204, blocks: (B:17:0x01dd, B:21:0x01f5, B:22:0x0203), top: B:15:0x01db }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0172 A[Catch: Exception -> 0x0207, TryCatch #2 {Exception -> 0x0207, blocks: (B:36:0x0162, B:38:0x0172, B:40:0x019d, B:42:0x01a7, B:43:0x01af), top: B:35:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.util.Map] */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r22, com.amplifyframework.statemachine.Environment r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.SRPCognitoActions$verifyPasswordSRPAction$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
