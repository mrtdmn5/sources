package com.animaconnected.secondo.provider.googlefit;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GoogleFitApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.googlefit.GoogleFitApi$uploadHeartRate$2", f = "GoogleFitApi.kt", l = {69, 71}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GoogleFitApi$uploadHeartRate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ GoogleFitApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitApi$uploadHeartRate$2(GoogleFitApi googleFitApi, Continuation<? super GoogleFitApi$uploadHeartRate$2> continuation) {
        super(2, continuation);
        this.this$0 = googleFitApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleFitApi$uploadHeartRate$2(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0078  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            java.lang.Object r0 = r5.L$0
            com.google.android.gms.fitness.data.DataSet r0 = (com.google.android.gms.fitness.data.DataSet) r0
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.value
            goto L71
        L18:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L20:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4d
        L24:
            kotlin.ResultKt.throwOnFailure(r6)
            com.animaconnected.watch.fitness.TimePeriod r6 = new com.animaconnected.watch.fitness.TimePeriod
            com.animaconnected.secondo.provider.googlefit.GoogleFitApi r1 = r5.this$0
            com.animaconnected.secondo.provider.googlefit.GoogleFitStorage r1 = com.animaconnected.secondo.provider.googlefit.GoogleFitApi.access$getStorage$p(r1)
            kotlinx.datetime.Instant r1 = r1.getLastHeartRateUpload()
            kotlinx.datetime.Instant r4 = com.animaconnected.info.DateTimeUtilsKt.now()
            r6.<init>(r1, r4)
            com.animaconnected.secondo.provider.googlefit.GoogleFitApi r1 = r5.this$0
            com.animaconnected.watch.fitness.FitnessProvider r1 = com.animaconnected.secondo.provider.googlefit.GoogleFitApi.access$getFitness$p(r1)
            com.animaconnected.watch.CommonFlow r6 = r1.getHeartrateDataForCurrentDevice(r6)
            r5.label = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r6, r5)
            if (r6 != r0) goto L4d
            return r0
        L4d:
            java.util.List r6 = (java.util.List) r6
            if (r6 != 0) goto L53
            kotlin.collections.EmptyList r6 = kotlin.collections.EmptyList.INSTANCE
        L53:
            com.animaconnected.secondo.provider.googlefit.GoogleFitApi r1 = r5.this$0
            com.google.android.gms.fitness.data.Device r1 = com.animaconnected.secondo.provider.googlefit.GoogleFitApi.access$getDevice$p(r1)
            com.google.android.gms.fitness.data.DataSet r6 = com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt.buildHeartRateDataSet(r1, r6)
            if (r6 != 0) goto L62
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L62:
            com.animaconnected.secondo.provider.googlefit.GoogleFitApi r1 = r5.this$0
            r5.L$0 = r6
            r5.label = r2
            java.lang.Object r1 = com.animaconnected.secondo.provider.googlefit.GoogleFitApi.m800access$insertDatagIAlus(r1, r6, r5)
            if (r1 != r0) goto L6f
            return r0
        L6f:
            r0 = r6
            r6 = r1
        L71:
            com.animaconnected.secondo.provider.googlefit.GoogleFitApi r1 = r5.this$0
            boolean r2 = r6 instanceof kotlin.Result.Failure
            r2 = r2 ^ r3
            if (r2 == 0) goto L85
            kotlin.Unit r6 = (kotlin.Unit) r6
            com.animaconnected.secondo.provider.googlefit.GoogleFitStorage r6 = com.animaconnected.secondo.provider.googlefit.GoogleFitApi.access$getStorage$p(r1)
            kotlinx.datetime.Instant r0 = com.animaconnected.secondo.provider.googlefit.GoogleFitApi.access$getLastInstant(r1, r0)
            r6.setLastHeartRateUpload(r0)
        L85:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.googlefit.GoogleFitApi$uploadHeartRate$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoogleFitApi$uploadHeartRate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
