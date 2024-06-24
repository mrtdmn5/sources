package com.animaconnected.secondo.utils;

import com.amplifyframework.auth.AuthCodeDeliveryDetails;
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
@DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi$resendCode$2", f = "AmplifyApi.kt", l = {96}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmplifyApi$resendCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AmplifyResult<? extends AuthCodeDeliveryDetails>>, Object> {
    final /* synthetic */ String $emailAddress;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmplifyApi$resendCode$2(String str, Continuation<? super AmplifyApi$resendCode$2> continuation) {
        super(2, continuation);
        this.$emailAddress = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AmplifyApi$resendCode$2 amplifyApi$resendCode$2 = new AmplifyApi$resendCode$2(this.$emailAddress, continuation);
        amplifyApi$resendCode$2.L$0 = obj;
        return amplifyApi$resendCode$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<? extends AuthCodeDeliveryDetails>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super AmplifyResult<AuthCodeDeliveryDetails>>) continuation);
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
            LogKt.verbose$default((Object) coroutineScope4, "Amplify", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$resendCode$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "trying to send a new verification code to: " + str;
                }
            }, 6, (Object) null);
            try {
                if (Internet.INSTANCE.isAvailable()) {
                    KotlinAuthFacade auth = Amplify.Companion.getAuth();
                    String str2 = this.$emailAddress;
                    this.L$0 = coroutineScope4;
                    this.label = 1;
                    Object resendSignUpCode$default = Auth.DefaultImpls.resendSignUpCode$default(auth, str2, null, this, 2, null);
                    if (resendSignUpCode$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    coroutineScope2 = coroutineScope4;
                    obj = resendSignUpCode$default;
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
            AuthCodeDeliveryDetails authCodeDeliveryDetails = (AuthCodeDeliveryDetails) obj;
            String authCodeDeliveryDetails2 = authCodeDeliveryDetails.toString();
            Intrinsics.checkNotNullExpressionValue(authCodeDeliveryDetails2, "toString(...)");
            LogKt.verbose$default((Object) coroutineScope2, authCodeDeliveryDetails2, "Amplify", (Throwable) null, false, 12, (Object) null);
            return new AmplifyResult.Success(authCodeDeliveryDetails);
        } catch (Exception e4) {
            e = e4;
            coroutineScope = coroutineScope2;
            LogKt.verbose$default((Object) coroutineScope, e.toString(), "Amplify", (Throwable) e, false, 8, (Object) null);
            return new AmplifyResult.Failure(e);
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<AuthCodeDeliveryDetails>> continuation) {
        return ((AmplifyApi$resendCode$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
