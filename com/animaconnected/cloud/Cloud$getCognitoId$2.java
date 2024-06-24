package com.animaconnected.cloud;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthSession;
import com.amplifyframework.auth.result.AuthSessionResult;
import com.amplifyframework.kotlin.auth.KotlinAuthFacade;
import com.amplifyframework.kotlin.core.Amplify;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Cloud.kt */
@DebugMetadata(c = "com.animaconnected.cloud.Cloud$getCognitoId$2", f = "Cloud.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_toolbarActionTextStyle}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class Cloud$getCognitoId$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
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

    public Cloud$getCognitoId$2(Continuation<? super Cloud$getCognitoId$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Cloud$getCognitoId$2(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String obj2;
        AWSCognitoAuthSession aWSCognitoAuthSession;
        int r0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                KotlinAuthFacade auth = Amplify.Companion.getAuth();
                this.label = 1;
                obj = CloudKt.getAuthSession(auth, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            aWSCognitoAuthSession = (AWSCognitoAuthSession) obj;
            r0 = WhenMappings.$EnumSwitchMapping$0[aWSCognitoAuthSession.getIdentityIdResult().getType().ordinal()];
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                obj2 = e.toString();
            } else {
                return message;
            }
        }
        if (r0 != 1) {
            if (r0 != 2) {
                return "Unknown error";
            }
            AuthException error = aWSCognitoAuthSession.getIdentityIdResult().getError();
            if (error == null) {
                return "Unknown error";
            }
            obj2 = error.getMessage();
            if (obj2 == null) {
                return "Unknown error";
            }
            return obj2;
        }
        String value = aWSCognitoAuthSession.getIdentityIdResult().getValue();
        if (value == null) {
            return "Idd received: Null";
        }
        return value;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((Cloud$getCognitoId$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
