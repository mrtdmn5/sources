package com.animaconnected.secondo.utils;

import com.amplifyframework.auth.cognito.AWSCognitoAuthSession;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.utils.AmplifyResult;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AmplifyApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi$isSignedIn$2", f = "AmplifyApi.kt", l = {R.styleable.AppTheme_themeBackgroundResource}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmplifyApi$isSignedIn$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    public AmplifyApi$isSignedIn$2(Continuation<? super AmplifyApi$isSignedIn$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AmplifyApi$isSignedIn$2(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            AmplifyApi amplifyApi = AmplifyApi.INSTANCE;
            this.label = 1;
            obj = amplifyApi.fetchAuthSession(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        AmplifyResult amplifyResult = (AmplifyResult) obj;
        if (amplifyResult instanceof AmplifyResult.Success) {
            z = ((AWSCognitoAuthSession) ((AmplifyResult.Success) amplifyResult).getResult()).getSignedIn();
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((AmplifyApi$isSignedIn$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
