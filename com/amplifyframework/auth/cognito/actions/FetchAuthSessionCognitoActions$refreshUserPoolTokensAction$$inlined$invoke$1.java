package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class FetchAuthSessionCognitoActions$refreshUserPoolTokensAction$$inlined$invoke$1 implements Action {
    final /* synthetic */ SignedInData $signedInData$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions$refreshUserPoolTokensAction$$inlined$invoke$1", f = "FetchAuthSessionCognitoActions.kt", l = {82, 83, 88}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions$refreshUserPoolTokensAction$$inlined$invoke$1$1, reason: invalid class name */
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
            return FetchAuthSessionCognitoActions$refreshUserPoolTokensAction$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public FetchAuthSessionCognitoActions$refreshUserPoolTokensAction$$inlined$invoke$1(String str, SignedInData signedInData) {
        this.$signedInData$inlined = signedInData;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|7|(1:(1:(1:(18:12|13|14|15|16|(1:59)(1:20)|21|(1:58)(1:25)|(1:57)(1:29)|30|(1:56)|34|(5:39|40|(5:42|(1:44)(1:53)|45|(1:47)(1:52)|48)(1:54)|49|50)|55|40|(0)(0)|49|50)(2:68|69))(7:70|71|72|73|(1:75)|76|(7:78|(1:80)(1:90)|81|(1:83)|(1:85)|86|(1:88)(20:89|15|16|(1:18)|59|21|(1:23)|58|(1:27)|57|30|(1:32)|56|34|(6:36|39|40|(0)(0)|49|50)|55|40|(0)(0)|49|50))(18:91|(0)|59|21|(0)|58|(0)|57|30|(0)|56|34|(0)|55|40|(0)(0)|49|50)))(2:92|93))(14:98|99|100|(1:102)(1:125)|103|(1:105)(1:124)|106|(1:108)|(1:110)|111|112|113|114|(1:116)(1:117))|94|(1:96)(5:97|73|(0)|76|(0)(0))))|132|6|7|(0)(0)|94|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00ab, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0087, code lost:            r0 = e;     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01d4 A[Catch: Exception -> 0x0087, NotAuthorizedException -> 0x00ab, TRY_ENTER, TryCatch #5 {NotAuthorizedException -> 0x00ab, Exception -> 0x0087, blocks: (B:18:0x01d4, B:20:0x01d8, B:21:0x01de, B:23:0x01e2, B:25:0x01e6, B:27:0x01ec, B:29:0x01f0, B:30:0x01f4, B:32:0x021e, B:34:0x022c, B:36:0x0233, B:40:0x023f, B:42:0x0257, B:44:0x0263, B:45:0x0269, B:47:0x0273, B:48:0x0279, B:54:0x028f, B:56:0x0226, B:71:0x007b, B:73:0x014f, B:75:0x0153, B:76:0x015c, B:78:0x016a, B:80:0x017d, B:81:0x0183, B:83:0x0189, B:85:0x0193, B:86:0x019b, B:93:0x00a6, B:94:0x012f), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01e2 A[Catch: Exception -> 0x0087, NotAuthorizedException -> 0x00ab, TryCatch #5 {NotAuthorizedException -> 0x00ab, Exception -> 0x0087, blocks: (B:18:0x01d4, B:20:0x01d8, B:21:0x01de, B:23:0x01e2, B:25:0x01e6, B:27:0x01ec, B:29:0x01f0, B:30:0x01f4, B:32:0x021e, B:34:0x022c, B:36:0x0233, B:40:0x023f, B:42:0x0257, B:44:0x0263, B:45:0x0269, B:47:0x0273, B:48:0x0279, B:54:0x028f, B:56:0x0226, B:71:0x007b, B:73:0x014f, B:75:0x0153, B:76:0x015c, B:78:0x016a, B:80:0x017d, B:81:0x0183, B:83:0x0189, B:85:0x0193, B:86:0x019b, B:93:0x00a6, B:94:0x012f), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01ec A[Catch: Exception -> 0x0087, NotAuthorizedException -> 0x00ab, TryCatch #5 {NotAuthorizedException -> 0x00ab, Exception -> 0x0087, blocks: (B:18:0x01d4, B:20:0x01d8, B:21:0x01de, B:23:0x01e2, B:25:0x01e6, B:27:0x01ec, B:29:0x01f0, B:30:0x01f4, B:32:0x021e, B:34:0x022c, B:36:0x0233, B:40:0x023f, B:42:0x0257, B:44:0x0263, B:45:0x0269, B:47:0x0273, B:48:0x0279, B:54:0x028f, B:56:0x0226, B:71:0x007b, B:73:0x014f, B:75:0x0153, B:76:0x015c, B:78:0x016a, B:80:0x017d, B:81:0x0183, B:83:0x0189, B:85:0x0193, B:86:0x019b, B:93:0x00a6, B:94:0x012f), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x021e A[Catch: Exception -> 0x0087, NotAuthorizedException -> 0x00ab, TryCatch #5 {NotAuthorizedException -> 0x00ab, Exception -> 0x0087, blocks: (B:18:0x01d4, B:20:0x01d8, B:21:0x01de, B:23:0x01e2, B:25:0x01e6, B:27:0x01ec, B:29:0x01f0, B:30:0x01f4, B:32:0x021e, B:34:0x022c, B:36:0x0233, B:40:0x023f, B:42:0x0257, B:44:0x0263, B:45:0x0269, B:47:0x0273, B:48:0x0279, B:54:0x028f, B:56:0x0226, B:71:0x007b, B:73:0x014f, B:75:0x0153, B:76:0x015c, B:78:0x016a, B:80:0x017d, B:81:0x0183, B:83:0x0189, B:85:0x0193, B:86:0x019b, B:93:0x00a6, B:94:0x012f), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0233 A[Catch: Exception -> 0x0087, NotAuthorizedException -> 0x00ab, TryCatch #5 {NotAuthorizedException -> 0x00ab, Exception -> 0x0087, blocks: (B:18:0x01d4, B:20:0x01d8, B:21:0x01de, B:23:0x01e2, B:25:0x01e6, B:27:0x01ec, B:29:0x01f0, B:30:0x01f4, B:32:0x021e, B:34:0x022c, B:36:0x0233, B:40:0x023f, B:42:0x0257, B:44:0x0263, B:45:0x0269, B:47:0x0273, B:48:0x0279, B:54:0x028f, B:56:0x0226, B:71:0x007b, B:73:0x014f, B:75:0x0153, B:76:0x015c, B:78:0x016a, B:80:0x017d, B:81:0x0183, B:83:0x0189, B:85:0x0193, B:86:0x019b, B:93:0x00a6, B:94:0x012f), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0257 A[Catch: Exception -> 0x0087, NotAuthorizedException -> 0x00ab, TryCatch #5 {NotAuthorizedException -> 0x00ab, Exception -> 0x0087, blocks: (B:18:0x01d4, B:20:0x01d8, B:21:0x01de, B:23:0x01e2, B:25:0x01e6, B:27:0x01ec, B:29:0x01f0, B:30:0x01f4, B:32:0x021e, B:34:0x022c, B:36:0x0233, B:40:0x023f, B:42:0x0257, B:44:0x0263, B:45:0x0269, B:47:0x0273, B:48:0x0279, B:54:0x028f, B:56:0x0226, B:71:0x007b, B:73:0x014f, B:75:0x0153, B:76:0x015c, B:78:0x016a, B:80:0x017d, B:81:0x0183, B:83:0x0189, B:85:0x0193, B:86:0x019b, B:93:0x00a6, B:94:0x012f), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x028f A[Catch: Exception -> 0x0087, NotAuthorizedException -> 0x00ab, TRY_LEAVE, TryCatch #5 {NotAuthorizedException -> 0x00ab, Exception -> 0x0087, blocks: (B:18:0x01d4, B:20:0x01d8, B:21:0x01de, B:23:0x01e2, B:25:0x01e6, B:27:0x01ec, B:29:0x01f0, B:30:0x01f4, B:32:0x021e, B:34:0x022c, B:36:0x0233, B:40:0x023f, B:42:0x0257, B:44:0x0263, B:45:0x0269, B:47:0x0273, B:48:0x0279, B:54:0x028f, B:56:0x0226, B:71:0x007b, B:73:0x014f, B:75:0x0153, B:76:0x015c, B:78:0x016a, B:80:0x017d, B:81:0x0183, B:83:0x0189, B:85:0x0193, B:86:0x019b, B:93:0x00a6, B:94:0x012f), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0153 A[Catch: Exception -> 0x0087, NotAuthorizedException -> 0x00ab, TryCatch #5 {NotAuthorizedException -> 0x00ab, Exception -> 0x0087, blocks: (B:18:0x01d4, B:20:0x01d8, B:21:0x01de, B:23:0x01e2, B:25:0x01e6, B:27:0x01ec, B:29:0x01f0, B:30:0x01f4, B:32:0x021e, B:34:0x022c, B:36:0x0233, B:40:0x023f, B:42:0x0257, B:44:0x0263, B:45:0x0269, B:47:0x0273, B:48:0x0279, B:54:0x028f, B:56:0x0226, B:71:0x007b, B:73:0x014f, B:75:0x0153, B:76:0x015c, B:78:0x016a, B:80:0x017d, B:81:0x0183, B:83:0x0189, B:85:0x0193, B:86:0x019b, B:93:0x00a6, B:94:0x012f), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x016a A[Catch: Exception -> 0x0087, NotAuthorizedException -> 0x00ab, TryCatch #5 {NotAuthorizedException -> 0x00ab, Exception -> 0x0087, blocks: (B:18:0x01d4, B:20:0x01d8, B:21:0x01de, B:23:0x01e2, B:25:0x01e6, B:27:0x01ec, B:29:0x01f0, B:30:0x01f4, B:32:0x021e, B:34:0x022c, B:36:0x0233, B:40:0x023f, B:42:0x0257, B:44:0x0263, B:45:0x0269, B:47:0x0273, B:48:0x0279, B:54:0x028f, B:56:0x0226, B:71:0x007b, B:73:0x014f, B:75:0x0153, B:76:0x015c, B:78:0x016a, B:80:0x017d, B:81:0x0183, B:83:0x0189, B:85:0x0193, B:86:0x019b, B:93:0x00a6, B:94:0x012f), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0149 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r23, com.amplifyframework.statemachine.Environment r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            Method dump skipped, instructions count: 744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions$refreshUserPoolTokensAction$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
