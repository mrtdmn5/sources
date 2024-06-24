package com.animaconnected.secondo.utils;

import com.amplifyframework.auth.result.AuthResetPasswordResult;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AmplifyApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi$resetPassword$2", f = "AmplifyApi.kt", l = {201}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmplifyApi$resetPassword$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AmplifyResult<? extends AuthResetPasswordResult>>, Object> {
    final /* synthetic */ String $email;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmplifyApi$resetPassword$2(String str, Continuation<? super AmplifyApi$resetPassword$2> continuation) {
        super(2, continuation);
        this.$email = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AmplifyApi$resetPassword$2 amplifyApi$resetPassword$2 = new AmplifyApi$resetPassword$2(this.$email, continuation);
        amplifyApi$resetPassword$2.L$0 = obj;
        return amplifyApi$resetPassword$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<? extends AuthResetPasswordResult>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super AmplifyResult<AuthResetPasswordResult>>) continuation);
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
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope2 = coroutineScope3;
                } catch (Exception e2) {
                    e = e2;
                    coroutineScope = coroutineScope3;
                    LogKt.verbose$default((Object) coroutineScope, e.toString(), "Amplify", (Throwable) e, false, 8, (Object) null);
                    return new AmplifyResult.Failure(e);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
            try {
                if (Internet.INSTANCE.isAvailable()) {
                    KotlinAuthFacade auth = Amplify.Companion.getAuth();
                    String str = this.$email;
                    this.L$0 = coroutineScope4;
                    this.label = 1;
                    Object resetPassword$default = Auth.DefaultImpls.resetPassword$default(auth, str, null, this, 2, null);
                    if (resetPassword$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    coroutineScope2 = coroutineScope4;
                    obj = resetPassword$default;
                } else {
                    throw new NoInternetAccessException();
                }
            } catch (Exception e3) {
                coroutineScope = coroutineScope4;
                e = e3;
                LogKt.verbose$default((Object) coroutineScope, e.toString(), "Amplify", (Throwable) e, false, 8, (Object) null);
                return new AmplifyResult.Failure(e);
            }
        }
        try {
            final AuthResetPasswordResult authResetPasswordResult = (AuthResetPasswordResult) obj;
            LogKt.verbose$default((Object) coroutineScope2, "Amplify", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$resetPassword$2.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String authResetPasswordResult2 = AuthResetPasswordResult.this.toString();
                    Intrinsics.checkNotNullExpressionValue(authResetPasswordResult2, "toString(...)");
                    return authResetPasswordResult2;
                }
            }, 6, (Object) null);
            return new AmplifyResult.Success(authResetPasswordResult);
        } catch (Exception e4) {
            e = e4;
            coroutineScope = coroutineScope2;
            LogKt.verbose$default((Object) coroutineScope, e.toString(), "Amplify", (Throwable) e, false, 8, (Object) null);
            return new AmplifyResult.Failure(e);
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<AuthResetPasswordResult>> continuation) {
        return ((AmplifyApi$resetPassword$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
