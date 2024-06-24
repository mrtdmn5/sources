package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.DeviceSRPSignInEvent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class DeviceSRPCognitoSignInActions$respondDevicePasswordVerifier$$inlined$invoke$1 implements Action {
    final /* synthetic */ DeviceSRPSignInEvent.EventType.RespondDevicePasswordVerifier $event$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.DeviceSRPCognitoSignInActions$respondDevicePasswordVerifier$$inlined$invoke$1", f = "DeviceSRPCognitoSignInActions.kt", l = {77, 83, 97}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.DeviceSRPCognitoSignInActions$respondDevicePasswordVerifier$$inlined$invoke$1$1, reason: invalid class name */
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
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeviceSRPCognitoSignInActions$respondDevicePasswordVerifier$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public DeviceSRPCognitoSignInActions$respondDevicePasswordVerifier$$inlined$invoke$1(String str, DeviceSRPSignInEvent.EventType.RespondDevicePasswordVerifier respondDevicePasswordVerifier) {
        this.$event$inlined = respondDevicePasswordVerifier;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|(1:(1:(1:(5:11|12|13|14|15)(2:17|18))(7:19|20|21|22|23|24|(3:26|14|15)(4:27|28|29|30)))(4:48|49|50|51))(7:61|62|63|64|65|66|(1:68)(1:69))|52|(2:54|(1:56)(4:57|23|24|(0)(0)))|28|29|30))|76|6|(0)(0)|52|(0)|28|29|30) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x01b5, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01b6, code lost:            r6 = r12;        r7 = r13;        r10 = r14;     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137 A[Catch: Exception -> 0x01bd, TRY_LEAVE, TryCatch #1 {Exception -> 0x01bd, blocks: (B:50:0x0095, B:52:0x011e, B:54:0x0137), top: B:49:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v32, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.util.Date] */
    /* JADX WARN: Type inference failed for: r2v39 */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r27, com.amplifyframework.statemachine.Environment r28, kotlin.coroutines.Continuation<? super kotlin.Unit> r29) {
        /*
            Method dump skipped, instructions count: 621
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.DeviceSRPCognitoSignInActions$respondDevicePasswordVerifier$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
