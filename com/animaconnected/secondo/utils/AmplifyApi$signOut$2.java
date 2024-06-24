package com.animaconnected.secondo.utils;

import com.animaconnected.secondo.R;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AmplifyApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi$signOut$2", f = "AmplifyApi.kt", l = {R.styleable.AppTheme_stepsHistoryLineLegendColorActivity, R.styleable.AppTheme_stepsHistoryLineLegendColorDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmplifyApi$signOut$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AmplifyResult<? extends Boolean>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public AmplifyApi$signOut$2(Continuation<? super AmplifyApi$signOut$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AmplifyApi$signOut$2 amplifyApi$signOut$2 = new AmplifyApi$signOut$2(continuation);
        amplifyApi$signOut$2.L$0 = obj;
        return amplifyApi$signOut$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<? extends Boolean>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super AmplifyResult<Boolean>>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005c A[Catch: Exception -> 0x0084, TryCatch #3 {Exception -> 0x0084, blocks: (B:10:0x0054, B:12:0x005c, B:17:0x0070), top: B:9:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0070 A[Catch: Exception -> 0x0084, TRY_LEAVE, TryCatch #3 {Exception -> 0x0084, blocks: (B:10:0x0054, B:12:0x005c, B:17:0x0070), top: B:9:0x0054 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            java.lang.Object r0 = r8.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L15
            r7 = r0
            goto L54
        L15:
            r9 = move-exception
            r1 = r0
            goto L8a
        L19:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L21:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L2a
            r9 = r1
            goto L45
        L2a:
            r9 = move-exception
            goto L8a
        L2c:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            com.amplifyframework.kotlin.core.Amplify$Companion r1 = com.amplifyframework.kotlin.core.Amplify.Companion     // Catch: java.lang.Exception -> L87
            com.amplifyframework.kotlin.auth.KotlinAuthFacade r1 = r1.getAuth()     // Catch: java.lang.Exception -> L87
            r8.L$0 = r9     // Catch: java.lang.Exception -> L87
            r8.label = r3     // Catch: java.lang.Exception -> L87
            r4 = 0
            java.lang.Object r1 = com.amplifyframework.kotlin.auth.Auth.DefaultImpls.signOut$default(r1, r4, r8, r3, r4)     // Catch: java.lang.Exception -> L87
            if (r1 != r0) goto L45
            return r0
        L45:
            com.animaconnected.secondo.utils.AmplifyApi r1 = com.animaconnected.secondo.utils.AmplifyApi.INSTANCE     // Catch: java.lang.Exception -> L87
            r8.L$0 = r9     // Catch: java.lang.Exception -> L87
            r8.label = r2     // Catch: java.lang.Exception -> L87
            java.lang.Object r1 = com.animaconnected.secondo.utils.AmplifyApi.access$isSignedIn(r1, r8)     // Catch: java.lang.Exception -> L87
            if (r1 != r0) goto L52
            return r0
        L52:
            r7 = r9
            r9 = r1
        L54:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Exception -> L84
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Exception -> L84
            if (r9 == 0) goto L70
            java.lang.String r1 = "Amplify"
            r2 = 0
            r3 = 0
            com.animaconnected.secondo.utils.AmplifyApi$signOut$2$1 r4 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$signOut$2.1
                static {
                    /*
                        com.animaconnected.secondo.utils.AmplifyApi$signOut$2$1 r0 = new com.animaconnected.secondo.utils.AmplifyApi$signOut$2$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.secondo.utils.AmplifyApi$signOut$2$1) com.animaconnected.secondo.utils.AmplifyApi$signOut$2.1.INSTANCE com.animaconnected.secondo.utils.AmplifyApi$signOut$2$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi$signOut$2.AnonymousClass1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi$signOut$2.AnonymousClass1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Could not sign out the user"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi$signOut$2.AnonymousClass1.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi$signOut$2.AnonymousClass1.invoke():java.lang.Object");
                }
            }     // Catch: java.lang.Exception -> L84
            r5 = 6
            r6 = 0
            r0 = r7
            com.animaconnected.logger.LogKt.verbose$default(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L84
            com.animaconnected.secondo.utils.AmplifyResult$Success r9 = new com.animaconnected.secondo.utils.AmplifyResult$Success     // Catch: java.lang.Exception -> L84
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L84
            r9.<init>(r0)     // Catch: java.lang.Exception -> L84
            goto L9e
        L70:
            java.lang.String r1 = "Amplify"
            r2 = 0
            r3 = 0
            com.animaconnected.secondo.utils.AmplifyApi$signOut$2$2 r4 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$signOut$2.2
                static {
                    /*
                        com.animaconnected.secondo.utils.AmplifyApi$signOut$2$2 r0 = new com.animaconnected.secondo.utils.AmplifyApi$signOut$2$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.secondo.utils.AmplifyApi$signOut$2$2) com.animaconnected.secondo.utils.AmplifyApi$signOut$2.2.INSTANCE com.animaconnected.secondo.utils.AmplifyApi$signOut$2$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi$signOut$2.AnonymousClass2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi$signOut$2.AnonymousClass2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Sign out success"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi$signOut$2.AnonymousClass2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi$signOut$2.AnonymousClass2.invoke():java.lang.Object");
                }
            }     // Catch: java.lang.Exception -> L84
            r5 = 6
            r6 = 0
            r0 = r7
            com.animaconnected.logger.LogKt.verbose$default(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L84
            com.animaconnected.secondo.utils.AmplifyResult$Success r9 = new com.animaconnected.secondo.utils.AmplifyResult$Success     // Catch: java.lang.Exception -> L84
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L84
            r9.<init>(r0)     // Catch: java.lang.Exception -> L84
            goto L9e
        L84:
            r9 = move-exception
            r1 = r7
            goto L8a
        L87:
            r0 = move-exception
            r1 = r9
            r9 = r0
        L8a:
            java.lang.String r2 = r9.toString()
            java.lang.String r3 = "Amplify"
            r5 = 0
            r6 = 8
            r7 = 0
            r4 = r9
            com.animaconnected.logger.LogKt.verbose$default(r1, r2, r3, r4, r5, r6, r7)
            com.animaconnected.secondo.utils.AmplifyResult$Failure r0 = new com.animaconnected.secondo.utils.AmplifyResult$Failure
            r0.<init>(r9)
            r9 = r0
        L9e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi$signOut$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<Boolean>> continuation) {
        return ((AmplifyApi$signOut$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
