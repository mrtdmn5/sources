package com.animaconnected.secondo.provider.googlefit;

import android.content.Context;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.fitness.Session;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.SessionsClient;
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

/* compiled from: GoogleFitApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.googlefit.GoogleFitApi$uploadSession$2", f = "GoogleFitApi.kt", l = {111}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GoogleFitApi$uploadSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Session $session;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GoogleFitApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitApi$uploadSession$2(GoogleFitApi googleFitApi, Session session, Continuation<? super GoogleFitApi$uploadSession$2> continuation) {
        super(2, continuation);
        this.this$0 = googleFitApi;
        this.$session = session;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GoogleFitApi$uploadSession$2 googleFitApi$uploadSession$2 = new GoogleFitApi$uploadSession$2(this.this$0, this.$session, continuation);
        googleFitApi$uploadSession$2.L$0 = obj;
        return googleFitApi$uploadSession$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Device device;
        CoroutineScope coroutineScope;
        final Exception e;
        Context context;
        Function0 function0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e2) {
                    e = e2;
                    LogKt.warn$default((Object) coroutineScope, GoogleFitApi.TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitApi$uploadSession$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to upload session: " + e;
                        }
                    }, 6, (Object) null);
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            device = this.this$0.device;
            SessionInsertRequest buildWorkoutInsertRequest = GoogleFitDataSetsKt.buildWorkoutInsertRequest(device, this.$session);
            if (buildWorkoutInsertRequest != null) {
                try {
                    context = this.this$0.context;
                    function0 = this.this$0.account;
                    GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) function0.invoke();
                    int r5 = Fitness.$r8$clinit;
                    Preconditions.checkNotNull(googleSignInAccount);
                    zabv zabvVar = new SessionsClient(context, new zzi(context, googleSignInAccount)).zai;
                    zzeh zzehVar = new zzeh(zabvVar, buildWorkoutInsertRequest);
                    zabvVar.zaa.zad(0, zzehVar);
                    zzw voidTask = PendingResultUtil.toVoidTask(zzehVar);
                    Intrinsics.checkNotNullExpressionValue(voidTask, "insertSession(...)");
                    this.L$0 = coroutineScope2;
                    this.label = 1;
                    if (GoogleFitProviderKt.getSuspending(voidTask, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    coroutineScope = coroutineScope2;
                } catch (Exception e3) {
                    coroutineScope = coroutineScope2;
                    e = e3;
                    LogKt.warn$default((Object) coroutineScope, GoogleFitApi.TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitApi$uploadSession$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to upload session: " + e;
                        }
                    }, 6, (Object) null);
                    return Unit.INSTANCE;
                }
            } else {
                return Unit.INSTANCE;
            }
        }
        LogKt.debug$default((Object) coroutineScope, GoogleFitApi.TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitApi$uploadSession$2.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Successfully uploaded session.";
            }
        }, 6, (Object) null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoogleFitApi$uploadSession$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
