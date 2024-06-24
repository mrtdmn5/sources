package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.SRPEvent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class SRPCognitoActions$initiateSRPAuthAction$$inlined$invoke$1 implements Action {
    final /* synthetic */ SRPEvent.EventType.InitiateSRP $event$inlined;
    private final String id;

    /* compiled from: Action.kt */
    @DebugMetadata(c = "com.amplifyframework.auth.cognito.actions.SRPCognitoActions$initiateSRPAuthAction$$inlined$invoke$1", f = "SRPCognitoActions.kt", l = {80, 81, 86}, m = "execute")
    /* renamed from: com.amplifyframework.auth.cognito.actions.SRPCognitoActions$initiateSRPAuthAction$$inlined$invoke$1$1, reason: invalid class name */
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
            return SRPCognitoActions$initiateSRPAuthAction$$inlined$invoke$1.this.execute(null, null, this);
        }
    }

    public SRPCognitoActions$initiateSRPAuthAction$$inlined$invoke$1(String str, SRPEvent.EventType.InitiateSRP initiateSRP) {
        this.$event$inlined = initiateSRP;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x01e4 A[Catch: Exception -> 0x0074, TRY_ENTER, TryCatch #3 {Exception -> 0x0074, blocks: (B:17:0x01e4, B:18:0x01e8, B:20:0x01f0, B:23:0x01f6, B:25:0x01fc, B:26:0x0205, B:30:0x021a, B:31:0x0221, B:32:0x0222, B:33:0x0229, B:43:0x006f, B:44:0x015a, B:46:0x015e, B:47:0x0165, B:49:0x0173, B:51:0x0186, B:52:0x018c, B:54:0x019a, B:56:0x01a4, B:57:0x01ac), top: B:42:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01f0 A[Catch: Exception -> 0x0074, TryCatch #3 {Exception -> 0x0074, blocks: (B:17:0x01e4, B:18:0x01e8, B:20:0x01f0, B:23:0x01f6, B:25:0x01fc, B:26:0x0205, B:30:0x021a, B:31:0x0221, B:32:0x0222, B:33:0x0229, B:43:0x006f, B:44:0x015a, B:46:0x015e, B:47:0x0165, B:49:0x0173, B:51:0x0186, B:52:0x018c, B:54:0x019a, B:56:0x01a4, B:57:0x01ac), top: B:42:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0222 A[Catch: Exception -> 0x0074, TryCatch #3 {Exception -> 0x0074, blocks: (B:17:0x01e4, B:18:0x01e8, B:20:0x01f0, B:23:0x01f6, B:25:0x01fc, B:26:0x0205, B:30:0x021a, B:31:0x0221, B:32:0x0222, B:33:0x0229, B:43:0x006f, B:44:0x015a, B:46:0x015e, B:47:0x0165, B:49:0x0173, B:51:0x0186, B:52:0x018c, B:54:0x019a, B:56:0x01a4, B:57:0x01ac), top: B:42:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015e A[Catch: Exception -> 0x0074, TryCatch #3 {Exception -> 0x0074, blocks: (B:17:0x01e4, B:18:0x01e8, B:20:0x01f0, B:23:0x01f6, B:25:0x01fc, B:26:0x0205, B:30:0x021a, B:31:0x0221, B:32:0x0222, B:33:0x0229, B:43:0x006f, B:44:0x015a, B:46:0x015e, B:47:0x0165, B:49:0x0173, B:51:0x0186, B:52:0x018c, B:54:0x019a, B:56:0x01a4, B:57:0x01ac), top: B:42:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0173 A[Catch: Exception -> 0x0074, TryCatch #3 {Exception -> 0x0074, blocks: (B:17:0x01e4, B:18:0x01e8, B:20:0x01f0, B:23:0x01f6, B:25:0x01fc, B:26:0x0205, B:30:0x021a, B:31:0x0221, B:32:0x0222, B:33:0x0229, B:43:0x006f, B:44:0x015a, B:46:0x015e, B:47:0x0165, B:49:0x0173, B:51:0x0186, B:52:0x018c, B:54:0x019a, B:56:0x01a4, B:57:0x01ac), top: B:42:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0152 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @Override // com.amplifyframework.statemachine.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r18, com.amplifyframework.statemachine.Environment r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.SRPCognitoActions$initiateSRPAuthAction$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
