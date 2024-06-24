package com.animaconnected.secondo.utils;

import com.amplifyframework.auth.result.AuthSignUpResult;
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
@DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi$confirmSignUp$2", f = "AmplifyApi.kt", l = {109}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmplifyApi$confirmSignUp$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AmplifyResult<? extends AuthSignUpResult>>, Object> {
    final /* synthetic */ String $code;
    final /* synthetic */ String $emailAddress;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmplifyApi$confirmSignUp$2(String str, String str2, Continuation<? super AmplifyApi$confirmSignUp$2> continuation) {
        super(2, continuation);
        this.$emailAddress = str;
        this.$code = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AmplifyApi$confirmSignUp$2 amplifyApi$confirmSignUp$2 = new AmplifyApi$confirmSignUp$2(this.$emailAddress, this.$code, continuation);
        amplifyApi$confirmSignUp$2.L$0 = obj;
        return amplifyApi$confirmSignUp$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<? extends AuthSignUpResult>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super AmplifyResult<AuthSignUpResult>>) continuation);
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
            final String str = this.$emailAddress;
            final String str2 = this.$code;
            LogKt.verbose$default((Object) coroutineScope4, "Amplify", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$confirmSignUp$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "trying to confirm email: " + str + " with confirmation code: " + str2;
                }
            }, 6, (Object) null);
            try {
                if (Internet.INSTANCE.isAvailable()) {
                    KotlinAuthFacade auth = Amplify.Companion.getAuth();
                    String str3 = this.$emailAddress;
                    String str4 = this.$code;
                    this.L$0 = coroutineScope4;
                    this.label = 1;
                    Object confirmSignUp$default = Auth.DefaultImpls.confirmSignUp$default(auth, str3, str4, null, this, 4, null);
                    if (confirmSignUp$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    coroutineScope2 = coroutineScope4;
                    obj = confirmSignUp$default;
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
            AuthSignUpResult authSignUpResult = (AuthSignUpResult) obj;
            String authSignUpResult2 = authSignUpResult.toString();
            Intrinsics.checkNotNullExpressionValue(authSignUpResult2, "toString(...)");
            LogKt.verbose$default((Object) coroutineScope2, authSignUpResult2, "Amplify", (Throwable) null, false, 12, (Object) null);
            return new AmplifyResult.Success(authSignUpResult);
        } catch (Exception e4) {
            e = e4;
            coroutineScope = coroutineScope2;
            LogKt.verbose$default((Object) coroutineScope, e.toString(), "Amplify", (Throwable) e, false, 8, (Object) null);
            return new AmplifyResult.Failure(e);
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<AuthSignUpResult>> continuation) {
        return ((AmplifyApi$confirmSignUp$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
