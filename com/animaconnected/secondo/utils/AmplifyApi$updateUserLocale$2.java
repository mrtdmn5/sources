package com.animaconnected.secondo.utils;

import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.result.AuthUpdateAttributeResult;
import com.amplifyframework.kotlin.auth.Auth;
import com.amplifyframework.kotlin.auth.KotlinAuthFacade;
import com.amplifyframework.kotlin.core.Amplify;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.utils.AmplifyResult;
import com.animaconnected.watch.AndroidStringsBackendKt;
import java.util.Locale;
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
@DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi$updateUserLocale$2", f = "AmplifyApi.kt", l = {236}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmplifyApi$updateUserLocale$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AmplifyResult<? extends AuthUpdateAttributeResult>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public AmplifyApi$updateUserLocale$2(Continuation<? super AmplifyApi$updateUserLocale$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AmplifyApi$updateUserLocale$2 amplifyApi$updateUserLocale$2 = new AmplifyApi$updateUserLocale$2(continuation);
        amplifyApi$updateUserLocale$2.L$0 = obj;
        return amplifyApi$updateUserLocale$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<? extends AuthUpdateAttributeResult>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super AmplifyResult<AuthUpdateAttributeResult>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        final Exception e;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e2) {
                    e = e2;
                    LogKt.verbose$default((Object) coroutineScope, "Amplify", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$updateUserLocale$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Error updating user locale: "));
                        }
                    }, 6, (Object) null);
                    return new AmplifyResult.Failure(e);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                final String bCP47LanguageTag = AndroidStringsBackendKt.toBCP47LanguageTag(locale);
                AuthUserAttribute authUserAttribute = new AuthUserAttribute(AuthUserAttributeKey.locale(), bCP47LanguageTag);
                LogKt.verbose$default((Object) coroutineScope2, "Amplify", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$updateUserLocale$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Successfully updated user locale to " + bCP47LanguageTag;
                    }
                }, 6, (Object) null);
                KotlinAuthFacade auth = Amplify.Companion.getAuth();
                this.L$0 = coroutineScope2;
                this.label = 1;
                Object updateUserAttribute$default = Auth.DefaultImpls.updateUserAttribute$default(auth, authUserAttribute, null, this, 2, null);
                if (updateUserAttribute$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
                coroutineScope = coroutineScope2;
                obj = updateUserAttribute$default;
            } catch (Exception e3) {
                coroutineScope = coroutineScope2;
                e = e3;
                LogKt.verbose$default((Object) coroutineScope, "Amplify", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$updateUserLocale$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Error updating user locale: "));
                    }
                }, 6, (Object) null);
                return new AmplifyResult.Failure(e);
            }
        }
        return new AmplifyResult.Success((AuthUpdateAttributeResult) obj);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<AuthUpdateAttributeResult>> continuation) {
        return ((AmplifyApi$updateUserLocale$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
