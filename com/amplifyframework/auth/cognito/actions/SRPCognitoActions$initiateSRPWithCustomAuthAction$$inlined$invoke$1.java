package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.SRPEvent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class SRPCognitoActions$initiateSRPWithCustomAuthAction$$inlined$invoke$1 implements Action {
    final /* synthetic */ SRPEvent.EventType.InitiateSRPWithCustom $event$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.SRPCognitoActions$initiateSRPWithCustomAuthAction$$inlined$invoke$1", f = "SRPCognitoActions.kt", l = {84, 85, 90}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.SRPCognitoActions$initiateSRPWithCustomAuthAction$$inlined$invoke$1$1, reason: invalid class name */
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
            return SRPCognitoActions$initiateSRPWithCustomAuthAction$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public SRPCognitoActions$initiateSRPWithCustomAuthAction$$inlined$invoke$1(String str, SRPEvent.EventType.InitiateSRPWithCustom initiateSRPWithCustom) {
        this.$event$inlined = initiateSRPWithCustom;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|(1:(1:(1:(8:11|12|13|14|15|(1:17)(1:34)|18|(2:20|(4:(1:25)|26|27|28)(2:30|31))(2:32|33))(2:39|40))(8:41|42|43|44|45|(1:47)|48|(7:50|(1:52)(1:62)|53|(1:55)|(1:57)|58|(1:60)(6:61|14|15|(0)(0)|18|(0)(0)))(4:63|(0)(0)|18|(0)(0))))(4:68|69|70|71))(13:82|83|84|(2:107|108)(1:86)|87|(1:89)(1:106)|90|(1:92)|96|97|98|99|(1:101)(1:102))|72|73|(1:75)(5:76|45|(0)|48|(0)(0))))|111|6|(0)(0)|72|73|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x024d, code lost:            r0 = e;     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01fe A[Catch: Exception -> 0x024d, TRY_ENTER, TryCatch #3 {Exception -> 0x024d, blocks: (B:17:0x01fe, B:18:0x0202, B:20:0x020a, B:23:0x0210, B:25:0x0216, B:26:0x021f, B:30:0x0235, B:31:0x0244, B:32:0x0245, B:33:0x024c, B:45:0x0174, B:47:0x0178, B:48:0x017f, B:50:0x018d, B:52:0x01a0, B:53:0x01a6, B:55:0x01b4, B:57:0x01be, B:58:0x01c6, B:73:0x0151), top: B:72:0x0151 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x020a A[Catch: Exception -> 0x024d, TryCatch #3 {Exception -> 0x024d, blocks: (B:17:0x01fe, B:18:0x0202, B:20:0x020a, B:23:0x0210, B:25:0x0216, B:26:0x021f, B:30:0x0235, B:31:0x0244, B:32:0x0245, B:33:0x024c, B:45:0x0174, B:47:0x0178, B:48:0x017f, B:50:0x018d, B:52:0x01a0, B:53:0x01a6, B:55:0x01b4, B:57:0x01be, B:58:0x01c6, B:73:0x0151), top: B:72:0x0151 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0245 A[Catch: Exception -> 0x024d, TryCatch #3 {Exception -> 0x024d, blocks: (B:17:0x01fe, B:18:0x0202, B:20:0x020a, B:23:0x0210, B:25:0x0216, B:26:0x021f, B:30:0x0235, B:31:0x0244, B:32:0x0245, B:33:0x024c, B:45:0x0174, B:47:0x0178, B:48:0x017f, B:50:0x018d, B:52:0x01a0, B:53:0x01a6, B:55:0x01b4, B:57:0x01be, B:58:0x01c6, B:73:0x0151), top: B:72:0x0151 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0178 A[Catch: Exception -> 0x024d, TryCatch #3 {Exception -> 0x024d, blocks: (B:17:0x01fe, B:18:0x0202, B:20:0x020a, B:23:0x0210, B:25:0x0216, B:26:0x021f, B:30:0x0235, B:31:0x0244, B:32:0x0245, B:33:0x024c, B:45:0x0174, B:47:0x0178, B:48:0x017f, B:50:0x018d, B:52:0x01a0, B:53:0x01a6, B:55:0x01b4, B:57:0x01be, B:58:0x01c6, B:73:0x0151), top: B:72:0x0151 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018d A[Catch: Exception -> 0x024d, TryCatch #3 {Exception -> 0x024d, blocks: (B:17:0x01fe, B:18:0x0202, B:20:0x020a, B:23:0x0210, B:25:0x0216, B:26:0x021f, B:30:0x0235, B:31:0x0244, B:32:0x0245, B:33:0x024c, B:45:0x0174, B:47:0x0178, B:48:0x017f, B:50:0x018d, B:52:0x01a0, B:53:0x01a6, B:55:0x01b4, B:57:0x01be, B:58:0x01c6, B:73:0x0151), top: B:72:0x0151 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r20, com.amplifyframework.statemachine.Environment r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instructions count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.SRPCognitoActions$initiateSRPWithCustomAuthAction$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
