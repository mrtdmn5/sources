package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.SignInEvent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class MigrateAuthCognitoActions$initiateMigrateAuthAction$$inlined$invoke$1 implements Action {
    final /* synthetic */ SignInEvent.EventType.InitiateMigrateAuth $event$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.MigrateAuthCognitoActions$initiateMigrateAuthAction$$inlined$invoke$1", f = "MigrateAuthCognitoActions.kt", l = {78, 82}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.MigrateAuthCognitoActions$initiateMigrateAuthAction$$inlined$invoke$1$1, reason: invalid class name */
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
            return MigrateAuthCognitoActions$initiateMigrateAuthAction$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public MigrateAuthCognitoActions$initiateMigrateAuthAction$$inlined$invoke$1(String str, SignInEvent.EventType.InitiateMigrateAuth initiateMigrateAuth) {
        this.$event$inlined = initiateMigrateAuth;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|(1:(1:(7:10|11|12|13|14|15|(3:17|18|19)(2:21|22))(2:30|31))(4:32|33|34|35))(13:60|61|62|(1:64)(1:83)|65|(1:67)(1:82)|68|(1:70)|71|72|73|74|(1:76)(1:77))|36|37|(7:39|(1:41)(1:52)|42|(1:44)|(1:46)|47|(1:49)(5:50|13|14|15|(0)(0)))(3:53|15|(0)(0))))|86|6|(0)(0)|36|37|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01b0, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01b1, code lost:            r5 = r6;        r2 = r11;        r11 = r10;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x017b A[Catch: Exception -> 0x01aa, TRY_ENTER, TryCatch #1 {Exception -> 0x01aa, blocks: (B:17:0x017b, B:21:0x019a, B:22:0x01a9), top: B:15:0x0179 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x019a A[Catch: Exception -> 0x01aa, TryCatch #1 {Exception -> 0x01aa, blocks: (B:17:0x017b, B:21:0x019a, B:22:0x01a9), top: B:15:0x0179 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011b A[Catch: Exception -> 0x01b0, TryCatch #0 {Exception -> 0x01b0, blocks: (B:37:0x010b, B:39:0x011b, B:41:0x012e, B:42:0x0134, B:44:0x0142, B:46:0x014c, B:47:0x0154), top: B:36:0x010b }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Type inference failed for: r0v28, types: [java.util.Map] */
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
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.MigrateAuthCognitoActions$initiateMigrateAuthAction$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
