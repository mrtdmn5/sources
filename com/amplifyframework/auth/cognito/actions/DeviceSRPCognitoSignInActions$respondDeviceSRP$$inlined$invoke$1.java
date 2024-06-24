package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.DeviceSRPSignInEvent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class DeviceSRPCognitoSignInActions$respondDeviceSRP$$inlined$invoke$1 implements Action {
    final /* synthetic */ DeviceSRPSignInEvent.EventType.RespondDeviceSRPChallenge $event$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.DeviceSRPCognitoSignInActions$respondDeviceSRP$$inlined$invoke$1", f = "DeviceSRPCognitoSignInActions.kt", l = {70, 71, 77, 99}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.DeviceSRPCognitoSignInActions$respondDeviceSRP$$inlined$invoke$1$1, reason: invalid class name */
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
            return DeviceSRPCognitoSignInActions$respondDeviceSRP$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public DeviceSRPCognitoSignInActions$respondDeviceSRP$$inlined$invoke$1(String str, DeviceSRPSignInEvent.EventType.RespondDeviceSRPChallenge respondDeviceSRPChallenge) {
        this.$event$inlined = respondDeviceSRPChallenge;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:(1:(1:(5:13|14|15|16|17)(2:19|20))(5:21|22|23|24|(4:(1:27)|28|16|17)(2:29|30)))(8:41|42|43|44|45|(1:57)|49|(2:51|(1:53)(3:54|24|(0)(0)))(2:55|56)))(2:61|62))(7:67|68|69|70|71|72|(1:74)(1:75))|63|(1:65)(7:66|44|45|(1:47)|57|49|(0)(0))))|82|6|7|(0)(0)|63|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00b2, code lost:            r0 = e;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0198 A[Catch: Exception -> 0x006f, TryCatch #0 {Exception -> 0x006f, blocks: (B:23:0x006a, B:24:0x015f, B:27:0x0167, B:28:0x0185, B:29:0x0198, B:30:0x01a7), top: B:22:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012c A[Catch: Exception -> 0x01b3, TRY_LEAVE, TryCatch #3 {Exception -> 0x01b3, blocks: (B:45:0x0109, B:47:0x0114, B:49:0x011c, B:51:0x012c, B:55:0x01ad, B:56:0x01b2), top: B:44:0x0109 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ad A[Catch: Exception -> 0x01b3, TRY_ENTER, TryCatch #3 {Exception -> 0x01b3, blocks: (B:45:0x0109, B:47:0x0114, B:49:0x011c, B:51:0x012c, B:55:0x01ad, B:56:0x01b2), top: B:44:0x0109 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0103 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11, types: [com.amplifyframework.auth.cognito.AuthEnvironment, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r23, com.amplifyframework.statemachine.Environment r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            Method dump skipped, instructions count: 600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.DeviceSRPCognitoSignInActions$respondDeviceSRP$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
