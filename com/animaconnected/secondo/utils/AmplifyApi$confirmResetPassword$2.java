package com.animaconnected.secondo.utils;

import com.amplifyframework.kotlin.auth.Auth;
import com.amplifyframework.kotlin.auth.KotlinAuthFacade;
import com.amplifyframework.kotlin.core.Amplify;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.utils.AmplifyResult;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AmplifyApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi$confirmResetPassword$2", f = "AmplifyApi.kt", l = {218}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmplifyApi$confirmResetPassword$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AmplifyResult>, Object> {
    final /* synthetic */ String $confirmationCode;
    final /* synthetic */ String $email;
    final /* synthetic */ String $newPassword;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmplifyApi$confirmResetPassword$2(String str, String str2, String str3, Continuation<? super AmplifyApi$confirmResetPassword$2> continuation) {
        super(2, continuation);
        this.$email = str;
        this.$newPassword = str2;
        this.$confirmationCode = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AmplifyApi$confirmResetPassword$2 amplifyApi$confirmResetPassword$2 = new AmplifyApi$confirmResetPassword$2(this.$email, this.$newPassword, this.$confirmationCode, continuation);
        amplifyApi$confirmResetPassword$2.L$0 = obj;
        return amplifyApi$confirmResetPassword$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Exception e;
        CoroutineScope coroutineScope2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e2) {
                    e = e2;
                    coroutineScope = coroutineScope2;
                    LogKt.verbose$default((Object) coroutineScope, e.toString(), "Amplify", (Throwable) e, false, 8, (Object) null);
                    return new AmplifyResult.Failure(e);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            if (Internet.INSTANCE.isAvailable()) {
                final String str = this.$email;
                final String str2 = this.$confirmationCode;
                LogKt.verbose$default((Object) coroutineScope3, "Amplify", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$confirmResetPassword$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Confirming reset password for email: " + str + ", confirmation code " + str2;
                    }
                }, 6, (Object) null);
                try {
                    KotlinAuthFacade auth = Amplify.Companion.getAuth();
                    String str3 = this.$email;
                    String str4 = this.$newPassword;
                    String str5 = this.$confirmationCode;
                    this.L$0 = coroutineScope3;
                    this.label = 1;
                    if (Auth.DefaultImpls.confirmResetPassword$default(auth, str3, str4, str5, null, this, 8, null) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    coroutineScope2 = coroutineScope3;
                } catch (Exception e3) {
                    coroutineScope = coroutineScope3;
                    e = e3;
                    LogKt.verbose$default((Object) coroutineScope, e.toString(), "Amplify", (Throwable) e, false, 8, (Object) null);
                    return new AmplifyResult.Failure(e);
                }
            } else {
                throw new NoInternetAccessException();
            }
        }
        LogKt.verbose$default((Object) coroutineScope2, "Amplify", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$confirmResetPassword$2.2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Confirm reset password SUCCESS!";
            }
        }, 6, (Object) null);
        return AmplifyResult.SuccessNothingDone.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AmplifyResult> continuation) {
        return ((AmplifyApi$confirmResetPassword$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
