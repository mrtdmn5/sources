package com.animaconnected.secondo.utils;

import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.auth.result.AuthSignUpResult;
import com.amplifyframework.kotlin.auth.KotlinAuthFacade;
import com.amplifyframework.kotlin.core.Amplify;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.utils.AmplifyResult;
import com.animaconnected.watch.AndroidStringsBackendKt;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AmplifyApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi$signUp$2", f = "AmplifyApi.kt", l = {83}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmplifyApi$signUp$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AmplifyResult<? extends AuthSignUpResult>>, Object> {
    final /* synthetic */ String $emailAddress;
    final /* synthetic */ String $password;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmplifyApi$signUp$2(String str, String str2, Continuation<? super AmplifyApi$signUp$2> continuation) {
        super(2, continuation);
        this.$emailAddress = str;
        this.$password = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AmplifyApi$signUp$2 amplifyApi$signUp$2 = new AmplifyApi$signUp$2(this.$emailAddress, this.$password, continuation);
        amplifyApi$signUp$2.L$0 = obj;
        return amplifyApi$signUp$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<? extends AuthSignUpResult>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super AmplifyResult<AuthSignUpResult>>) continuation);
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [com.amplifyframework.auth.options.AuthSignUpOptions$Builder] */
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
            LogKt.verbose$default((Object) coroutineScope4, "Amplify", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$signUp$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "signing up with email: " + str;
                }
            }, 6, (Object) null);
            try {
                if (Internet.INSTANCE.isAvailable()) {
                    AuthUserAttribute authUserAttribute = new AuthUserAttribute(AuthUserAttributeKey.email(), this.$emailAddress);
                    AuthUserAttributeKey locale = AuthUserAttributeKey.locale();
                    Locale locale2 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                    AuthSignUpOptions build = AuthSignUpOptions.builder().userAttributes(CollectionsKt__CollectionsKt.listOf((Object[]) new AuthUserAttribute[]{authUserAttribute, new AuthUserAttribute(locale, AndroidStringsBackendKt.toBCP47LanguageTag(locale2))})).build();
                    Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                    KotlinAuthFacade auth = Amplify.Companion.getAuth();
                    String str2 = this.$emailAddress;
                    String str3 = this.$password;
                    this.L$0 = coroutineScope4;
                    this.label = 1;
                    Object signUp = auth.signUp(str2, str3, build, this);
                    if (signUp == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    coroutineScope2 = coroutineScope4;
                    obj = signUp;
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
        return ((AmplifyApi$signUp$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
