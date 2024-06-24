package com.animaconnected.secondo.utils;

import android.app.Activity;
import com.amplifyframework.auth.AuthProvider;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.animaconnected.secondo.R;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AmplifyApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi$signInWithSocialWebUI$2", f = "AmplifyApi.kt", l = {R.styleable.AppTheme_stepsHistoryFontDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmplifyApi$signInWithSocialWebUI$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AmplifyResult<? extends AuthSignInResult>>, Object> {
    final /* synthetic */ Activity $callingActivity;
    final /* synthetic */ AuthProvider $provider;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmplifyApi$signInWithSocialWebUI$2(AuthProvider authProvider, Activity activity, Continuation<? super AmplifyApi$signInWithSocialWebUI$2> continuation) {
        super(2, continuation);
        this.$provider = authProvider;
        this.$callingActivity = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AmplifyApi$signInWithSocialWebUI$2 amplifyApi$signInWithSocialWebUI$2 = new AmplifyApi$signInWithSocialWebUI$2(this.$provider, this.$callingActivity, continuation);
        amplifyApi$signInWithSocialWebUI$2.L$0 = obj;
        return amplifyApi$signInWithSocialWebUI$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<? extends AuthSignInResult>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super AmplifyResult<AuthSignInResult>>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L1d
            if (r1 != r2) goto L15
            java.lang.Object r0 = r10.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L12
            r7 = r0
            goto L47
        L12:
            r11 = move-exception
            r1 = r0
            goto L6a
        L15:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1d:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            com.animaconnected.secondo.utils.Internet r1 = com.animaconnected.secondo.utils.Internet.INSTANCE     // Catch: java.lang.Exception -> L67
            boolean r1 = r1.isAvailable()     // Catch: java.lang.Exception -> L67
            if (r1 == 0) goto L61
            com.amplifyframework.kotlin.core.Amplify$Companion r1 = com.amplifyframework.kotlin.core.Amplify.Companion     // Catch: java.lang.Exception -> L67
            com.amplifyframework.kotlin.auth.KotlinAuthFacade r3 = r1.getAuth()     // Catch: java.lang.Exception -> L67
            com.amplifyframework.auth.AuthProvider r4 = r10.$provider     // Catch: java.lang.Exception -> L67
            android.app.Activity r5 = r10.$callingActivity     // Catch: java.lang.Exception -> L67
            r6 = 0
            r8 = 4
            r9 = 0
            r10.L$0 = r11     // Catch: java.lang.Exception -> L67
            r10.label = r2     // Catch: java.lang.Exception -> L67
            r7 = r10
            java.lang.Object r1 = com.amplifyframework.kotlin.auth.Auth.DefaultImpls.signInWithSocialWebUI$default(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L67
            if (r1 != r0) goto L45
            return r0
        L45:
            r7 = r11
            r11 = r1
        L47:
            com.amplifyframework.auth.result.AuthSignInResult r11 = (com.amplifyframework.auth.result.AuthSignInResult) r11     // Catch: java.lang.Exception -> L5e
            java.lang.String r1 = "Amplify"
            r2 = 0
            r3 = 0
            com.animaconnected.secondo.utils.AmplifyApi$signInWithSocialWebUI$2$1 r4 = new com.animaconnected.secondo.utils.AmplifyApi$signInWithSocialWebUI$2$1     // Catch: java.lang.Exception -> L5e
            r4.<init>()     // Catch: java.lang.Exception -> L5e
            r5 = 6
            r6 = 0
            r0 = r7
            com.animaconnected.logger.LogKt.verbose$default(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L5e
            com.animaconnected.secondo.utils.AmplifyResult$Success r0 = new com.animaconnected.secondo.utils.AmplifyResult$Success     // Catch: java.lang.Exception -> L5e
            r0.<init>(r11)     // Catch: java.lang.Exception -> L5e
            goto L8f
        L5e:
            r11 = move-exception
            r1 = r7
            goto L6a
        L61:
            com.animaconnected.secondo.utils.NoInternetAccessException r0 = new com.animaconnected.secondo.utils.NoInternetAccessException     // Catch: java.lang.Exception -> L67
            r0.<init>()     // Catch: java.lang.Exception -> L67
            throw r0     // Catch: java.lang.Exception -> L67
        L67:
            r0 = move-exception
            r1 = r11
            r11 = r0
        L6a:
            java.lang.String r2 = r11.toString()
            java.lang.String r3 = "Amplify"
            r5 = 0
            r6 = 8
            r7 = 0
            r4 = r11
            com.animaconnected.logger.LogKt.verbose$default(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = com.animaconnected.secondo.utils.AmplifyApiKt.access$accountExist(r11)
            if (r0 == 0) goto L8a
            com.animaconnected.secondo.utils.AmplifyResult$Failure r11 = new com.animaconnected.secondo.utils.AmplifyResult$Failure
            com.animaconnected.secondo.utils.WebUiAccountAlreadyExistException r0 = new com.animaconnected.secondo.utils.WebUiAccountAlreadyExistException
            r0.<init>()
            r11.<init>(r0)
            r0 = r11
            goto L8f
        L8a:
            com.animaconnected.secondo.utils.AmplifyResult$Failure r0 = new com.animaconnected.secondo.utils.AmplifyResult$Failure
            r0.<init>(r11)
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi$signInWithSocialWebUI$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<AuthSignInResult>> continuation) {
        return ((AmplifyApi$signInWithSocialWebUI$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
