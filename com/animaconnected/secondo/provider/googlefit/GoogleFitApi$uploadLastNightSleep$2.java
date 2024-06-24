package com.animaconnected.secondo.provider.googlefit;

import android.content.Context;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.sleep.SleepSession;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.SessionsClient;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.zzi;
import com.google.android.gms.internal.fitness.zzeh;
import com.google.android.gms.tasks.zzw;
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
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: GoogleFitApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.googlefit.GoogleFitApi$uploadLastNightSleep$2", f = "GoogleFitApi.kt", l = {77, 84}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GoogleFitApi$uploadLastNightSleep$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GoogleFitApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitApi$uploadLastNightSleep$2(GoogleFitApi googleFitApi, Continuation<? super GoogleFitApi$uploadLastNightSleep$2> continuation) {
        super(2, continuation);
        this.this$0 = googleFitApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GoogleFitApi$uploadLastNightSleep$2 googleFitApi$uploadLastNightSleep$2 = new GoogleFitApi$uploadLastNightSleep$2(this.this$0, continuation);
        googleFitApi$uploadLastNightSleep$2.L$0 = obj;
        return googleFitApi$uploadLastNightSleep$2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2;
        FitnessProvider fitnessProvider;
        FitnessProvider fitnessProvider2;
        Device device;
        Context context;
        Function0 function0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ?? r1 = this.label;
        try {
        } catch (Exception e) {
            e = e;
            coroutineScope = r1;
        }
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        LogKt.debug$default((Object) coroutineScope, GoogleFitApi.TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitApi$uploadLastNightSleep$2.1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Successfully uploaded last night sleep session.";
                            }
                        }, 6, (Object) null);
                    } catch (Exception e2) {
                        e = e2;
                        LogKt.warn$default((Object) coroutineScope, GoogleFitApi.TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitApi$uploadLastNightSleep$2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to upload last night sleep session: " + e;
                            }
                        }, 6, (Object) null);
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope2 = (CoroutineScope) this.L$0;
            fitnessProvider = this.this$0.fitness;
            Bedtime bedtime = fitnessProvider.getProfile().getBedtime();
            fitnessProvider2 = this.this$0.fitness;
            CommonFlow<SleepSession> lastNightSleepData = fitnessProvider2.getLastNightSleepData(bedtime);
            this.L$0 = coroutineScope2;
            this.label = 1;
            obj = FlowKt.firstOrNull(lastNightSleepData, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        SleepSession sleepSession = (SleepSession) obj;
        if (sleepSession != null) {
            device = this.this$0.device;
            DataSet buildSleepDataSet = GoogleFitDataSetsKt.buildSleepDataSet(device, sleepSession);
            if (buildSleepDataSet == null) {
                return Unit.INSTANCE;
            }
            SessionInsertRequest buildSleepInsertRequest = GoogleFitDataSetsKt.buildSleepInsertRequest(buildSleepDataSet);
            if (buildSleepInsertRequest != null) {
                context = this.this$0.context;
                function0 = this.this$0.account;
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) function0.invoke();
                int r5 = Fitness.$r8$clinit;
                Preconditions.checkNotNull(googleSignInAccount);
                zabv zabvVar = new SessionsClient(context, new zzi(context, googleSignInAccount)).zai;
                zzeh zzehVar = new zzeh(zabvVar, buildSleepInsertRequest);
                zabvVar.zaa.zad(0, zzehVar);
                zzw voidTask = PendingResultUtil.toVoidTask(zzehVar);
                Intrinsics.checkNotNullExpressionValue(voidTask, "insertSession(...)");
                this.L$0 = coroutineScope2;
                this.label = 2;
                if (GoogleFitProviderKt.getSuspending(voidTask, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                coroutineScope = coroutineScope2;
                LogKt.debug$default((Object) coroutineScope, GoogleFitApi.TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitApi$uploadLastNightSleep$2.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Successfully uploaded last night sleep session.";
                    }
                }, 6, (Object) null);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoogleFitApi$uploadLastNightSleep$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
