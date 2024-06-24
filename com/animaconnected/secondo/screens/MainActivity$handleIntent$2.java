package com.animaconnected.secondo.screens;

import com.animaconnected.watch.account.strava.StravaClient;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MainActivity.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.MainActivity$handleIntent$2", f = "MainActivity.kt", l = {909}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MainActivity$handleIntent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $authorizationCode;
    final /* synthetic */ StravaClient $client;
    final /* synthetic */ String $scopes;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$handleIntent$2(StravaClient stravaClient, String str, String str2, Continuation<? super MainActivity$handleIntent$2> continuation) {
        super(2, continuation);
        this.$client = stravaClient;
        this.$authorizationCode = str;
        this.$scopes = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$handleIntent$2(this.$client, this.$authorizationCode, this.$scopes, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
            StravaClient stravaClient = this.$client;
            String str = this.$authorizationCode;
            String str2 = this.$scopes;
            this.label = 1;
            if (stravaClient.finishAuthentication(str, str2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$handleIntent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
