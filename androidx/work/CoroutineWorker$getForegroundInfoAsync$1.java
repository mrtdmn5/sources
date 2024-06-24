package androidx.work;

import com.animaconnected.secondo.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CoroutineWorker.kt */
@DebugMetadata(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {R.styleable.AppTheme_stepsHistoryBaseLineColorDetail}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CoroutineWorker$getForegroundInfoAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ JobListenableFuture<ForegroundInfo> $jobFuture;
    public JobListenableFuture L$0;
    public int label;
    public final /* synthetic */ CoroutineWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker$getForegroundInfoAsync$1(JobListenableFuture<ForegroundInfo> jobListenableFuture, CoroutineWorker coroutineWorker, Continuation<? super CoroutineWorker$getForegroundInfoAsync$1> continuation) {
        super(2, continuation);
        this.$jobFuture = jobListenableFuture;
        this.this$0 = coroutineWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineWorker$getForegroundInfoAsync$1(this.$jobFuture, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineWorker$getForegroundInfoAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        JobListenableFuture<ForegroundInfo> jobListenableFuture;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                jobListenableFuture = this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            JobListenableFuture<ForegroundInfo> jobListenableFuture2 = this.$jobFuture;
            this.L$0 = jobListenableFuture2;
            this.label = 1;
            Object foregroundInfo = this.this$0.getForegroundInfo(this);
            if (foregroundInfo == coroutineSingletons) {
                return coroutineSingletons;
            }
            jobListenableFuture = jobListenableFuture2;
            obj = foregroundInfo;
        }
        jobListenableFuture.underlying.set(obj);
        return Unit.INSTANCE;
    }
}
