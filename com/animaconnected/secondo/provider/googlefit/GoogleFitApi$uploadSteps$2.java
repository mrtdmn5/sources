package com.animaconnected.secondo.provider.googlefit;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.fitness.TimePeriod;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Device;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GoogleFitApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.googlefit.GoogleFitApi$uploadSteps$2", f = "GoogleFitApi.kt", l = {48}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GoogleFitApi$uploadSteps$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $steps;
    int label;
    final /* synthetic */ GoogleFitApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitApi$uploadSteps$2(GoogleFitApi googleFitApi, int r2, Continuation<? super GoogleFitApi$uploadSteps$2> continuation) {
        super(2, continuation);
        this.this$0 = googleFitApi;
        this.$steps = r2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleFitApi$uploadSteps$2(this.this$0, this.$steps, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Device device;
        Object m801insertDatagIAlus;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getClass();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            TimePeriod timePeriod = new TimePeriod(DateTimeUtilsKt.getStartOfDay$default(null, null, 3, null), DateTimeUtilsKt.now());
            device = this.this$0.device;
            DataSet buildStepsDataSet = GoogleFitDataSetsKt.buildStepsDataSet(device, timePeriod, this.$steps);
            if (buildStepsDataSet == null) {
                return Unit.INSTANCE;
            }
            GoogleFitApi googleFitApi = this.this$0;
            this.label = 1;
            m801insertDatagIAlus = googleFitApi.m801insertDatagIAlus(buildStepsDataSet, this);
            if (m801insertDatagIAlus == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoogleFitApi$uploadSteps$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
