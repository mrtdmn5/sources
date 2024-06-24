package com.animaconnected.cloud;

import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.AWSCognitoUserPoolTokens;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthSession;
import com.amplifyframework.auth.result.AuthSessionResult;
import com.amplifyframework.kotlin.auth.KotlinAuthFacade;
import com.amplifyframework.kotlin.core.Amplify;
import com.animaconnected.logger.LogKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Cloud.kt */
@DebugMetadata(c = "com.animaconnected.cloud.Cloud$getCognitoToken$2", f = "Cloud.kt", l = {188}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class Cloud$getCognitoToken$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends String>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Cloud.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[AuthSessionResult.Type.values().length];
            try {
                r0[AuthSessionResult.Type.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[AuthSessionResult.Type.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public Cloud$getCognitoToken$2(Continuation<? super Cloud$getCognitoToken$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Cloud$getCognitoToken$2 cloud$getCognitoToken$2 = new Cloud$getCognitoToken$2(continuation);
        cloud$getCognitoToken$2.L$0 = obj;
        return cloud$getCognitoToken$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<String>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        final Exception e;
        Object createFailure;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e2) {
                    e = e2;
                    LogKt.verbose$default((Object) coroutineScope, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.cloud.Cloud$getCognitoToken$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Failed to get cognito token, error: "));
                        }
                    }, 7, (Object) null);
                    createFailure = ResultKt.createFailure(e);
                    return new Result(createFailure);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                KotlinAuthFacade auth = Amplify.Companion.getAuth();
                this.L$0 = coroutineScope2;
                this.label = 1;
                Object authSession = CloudKt.getAuthSession(auth, this);
                if (authSession == coroutineSingletons) {
                    return coroutineSingletons;
                }
                obj = authSession;
            } catch (Exception e3) {
                coroutineScope = coroutineScope2;
                e = e3;
                LogKt.verbose$default((Object) coroutineScope, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.cloud.Cloud$getCognitoToken$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Failed to get cognito token, error: "));
                    }
                }, 7, (Object) null);
                createFailure = ResultKt.createFailure(e);
                return new Result(createFailure);
            }
        }
        AWSCognitoAuthSession aWSCognitoAuthSession = (AWSCognitoAuthSession) obj;
        int r12 = WhenMappings.$EnumSwitchMapping$0[aWSCognitoAuthSession.getUserPoolTokensResult().getType().ordinal()];
        if (r12 != 1) {
            if (r12 != 2) {
                createFailure = ResultKt.createFailure(new AuthException("Unknown error", "", null, 4, null));
            } else {
                AuthException error = aWSCognitoAuthSession.getUserPoolTokensResult().getError();
                if (error == null) {
                    error = new AuthException("Failure -> Unknown error", "", null, 4, null);
                }
                createFailure = ResultKt.createFailure(error);
            }
        } else {
            AWSCognitoUserPoolTokens value = aWSCognitoAuthSession.getUserPoolTokensResult().getValue();
            if (value == null || (createFailure = value.getAccessToken()) == null) {
                createFailure = ResultKt.createFailure(new AuthException("null is token", "", null, 4, null));
            }
        }
        return new Result(createFailure);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<String>> continuation) {
        return ((Cloud$getCognitoToken$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
