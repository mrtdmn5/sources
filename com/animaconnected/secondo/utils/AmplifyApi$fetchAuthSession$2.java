package com.animaconnected.secondo.utils;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthSession;
import com.amplifyframework.auth.result.AuthSessionResult;
import com.amplifyframework.kotlin.auth.KotlinAuthFacade;
import com.amplifyframework.kotlin.core.Amplify;
import com.animaconnected.cloud.CloudKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.utils.AmplifyResult;
import kotlin.NoWhenBranchMatchedException;
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
@DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi$fetchAuthSession$2", f = "AmplifyApi.kt", l = {R.styleable.AppTheme_workoutDetailColorBackground}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmplifyApi$fetchAuthSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AmplifyResult<? extends AWSCognitoAuthSession>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: AmplifyApi.kt */
    /* loaded from: classes3.dex */
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

    public AmplifyApi$fetchAuthSession$2(Continuation<? super AmplifyApi$fetchAuthSession$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AmplifyApi$fetchAuthSession$2 amplifyApi$fetchAuthSession$2 = new AmplifyApi$fetchAuthSession$2(continuation);
        amplifyApi$fetchAuthSession$2.L$0 = obj;
        return amplifyApi$fetchAuthSession$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<? extends AWSCognitoAuthSession>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super AmplifyResult<AWSCognitoAuthSession>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Exception e;
        CoroutineScope coroutineScope2;
        String str;
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
                    LogKt.err$default((Object) coroutineScope, e.toString(), "Amplify", (Throwable) e, false, 8, (Object) null);
                    return new AmplifyResult.Failure(e);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            try {
                KotlinAuthFacade auth = Amplify.Companion.getAuth();
                this.L$0 = coroutineScope3;
                this.label = 1;
                Object authSession = CloudKt.getAuthSession(auth, this);
                if (authSession == coroutineSingletons) {
                    return coroutineSingletons;
                }
                coroutineScope2 = coroutineScope3;
                obj = authSession;
            } catch (Exception e3) {
                coroutineScope = coroutineScope3;
                e = e3;
                LogKt.err$default((Object) coroutineScope, e.toString(), "Amplify", (Throwable) e, false, 8, (Object) null);
                return new AmplifyResult.Failure(e);
            }
        }
        final AWSCognitoAuthSession aWSCognitoAuthSession = (AWSCognitoAuthSession) obj;
        AuthSessionResult<String> identityIdResult = aWSCognitoAuthSession.getIdentityIdResult();
        int r3 = WhenMappings.$EnumSwitchMapping$0[identityIdResult.getType().ordinal()];
        if (r3 != 1) {
            if (r3 == 2) {
                AuthException error = identityIdResult.getError();
                if (error == null || (str = error.getMessage()) == null) {
                    str = "";
                }
                LogKt.verbose$default((Object) coroutineScope2, str, "Amplify", (Throwable) identityIdResult.getError(), false, 8, (Object) null);
                return new AmplifyResult.Failure(new Exception(str));
            }
            throw new NoWhenBranchMatchedException();
        }
        LogKt.verbose$default((Object) coroutineScope2, "Amplify", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$fetchAuthSession$2.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return AWSCognitoAuthSession.this.toString();
            }
        }, 6, (Object) null);
        return new AmplifyResult.Success(aWSCognitoAuthSession);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super AmplifyResult<AWSCognitoAuthSession>> continuation) {
        return ((AmplifyApi$fetchAuthSession$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
