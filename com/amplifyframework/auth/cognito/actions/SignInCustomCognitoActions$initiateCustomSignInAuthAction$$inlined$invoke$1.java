package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.CustomSignInEvent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class SignInCustomCognitoActions$initiateCustomSignInAuthAction$$inlined$invoke$1 implements Action {
    final /* synthetic */ CustomSignInEvent.EventType.InitiateCustomSignIn $event$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.SignInCustomCognitoActions$initiateCustomSignInAuthAction$$inlined$invoke$1", f = "SignInCustomCognitoActions.kt", l = {78, 79, 84}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.SignInCustomCognitoActions$initiateCustomSignInAuthAction$$inlined$invoke$1$1, reason: invalid class name */
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
            return SignInCustomCognitoActions$initiateCustomSignInAuthAction$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public SignInCustomCognitoActions$initiateCustomSignInAuthAction$$inlined$invoke$1(String str, CustomSignInEvent.EventType.InitiateCustomSignIn initiateCustomSignIn) {
        this.$event$inlined = initiateCustomSignIn;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(10:5|6|(1:(1:(1:(8:11|12|13|14|15|(1:17)(1:28)|18|(2:26|27)(3:22|23|24))(2:33|34))(8:35|36|37|38|39|(1:41)|42|(7:44|(1:46)(1:56)|47|(1:49)|(1:51)|52|(1:54)(8:55|14|15|(0)(0)|18|(1:20)|26|27))(6:57|(0)(0)|18|(0)|26|27)))(4:61|62|63|64))(13:75|76|77|(1:79)(1:98)|80|(1:82)(1:97)|83|(1:85)|86|87|88|89|(1:91)(1:92))|65|66|(1:68)|39|(0)|42|(0)(0)))|101|6|(0)(0)|65|66|(0)|39|(0)|42|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0205, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0206, code lost:            r7 = r11;     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01c0 A[Catch: Exception -> 0x0205, TRY_ENTER, TryCatch #5 {Exception -> 0x0205, blocks: (B:17:0x01c0, B:18:0x01c4, B:20:0x01cc, B:22:0x01d0, B:26:0x01f4, B:27:0x0204, B:39:0x0142, B:41:0x0146, B:42:0x014f, B:44:0x015d, B:46:0x0170, B:47:0x0176, B:49:0x0184, B:51:0x018e, B:52:0x0196, B:66:0x0125), top: B:65:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01cc A[Catch: Exception -> 0x0205, TryCatch #5 {Exception -> 0x0205, blocks: (B:17:0x01c0, B:18:0x01c4, B:20:0x01cc, B:22:0x01d0, B:26:0x01f4, B:27:0x0204, B:39:0x0142, B:41:0x0146, B:42:0x014f, B:44:0x015d, B:46:0x0170, B:47:0x0176, B:49:0x0184, B:51:0x018e, B:52:0x0196, B:66:0x0125), top: B:65:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0146 A[Catch: Exception -> 0x0205, TryCatch #5 {Exception -> 0x0205, blocks: (B:17:0x01c0, B:18:0x01c4, B:20:0x01cc, B:22:0x01d0, B:26:0x01f4, B:27:0x0204, B:39:0x0142, B:41:0x0146, B:42:0x014f, B:44:0x015d, B:46:0x0170, B:47:0x0176, B:49:0x0184, B:51:0x018e, B:52:0x0196, B:66:0x0125), top: B:65:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015d A[Catch: Exception -> 0x0205, TryCatch #5 {Exception -> 0x0205, blocks: (B:17:0x01c0, B:18:0x01c4, B:20:0x01cc, B:22:0x01d0, B:26:0x01f4, B:27:0x0204, B:39:0x0142, B:41:0x0146, B:42:0x014f, B:44:0x015d, B:46:0x0170, B:47:0x0176, B:49:0x0184, B:51:0x018e, B:52:0x0196, B:66:0x0125), top: B:65:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0141 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r22, com.amplifyframework.statemachine.Environment r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.SignInCustomCognitoActions$initiateCustomSignInAuthAction$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
