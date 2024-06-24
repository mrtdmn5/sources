package com.animaconnected.watch.fitness.sync;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.DisplayWatch;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FitnessSyncWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.sync.FitnessSyncWatch$readFitnessData$1", f = "FitnessSyncWatch.kt", l = {81, 92, R.styleable.AppTheme_tabTextColor}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FitnessSyncWatch$readFitnessData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DisplayWatch $watch;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ FitnessSyncWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessSyncWatch$readFitnessData$1(DisplayWatch displayWatch, FitnessSyncWatch fitnessSyncWatch, Continuation<? super FitnessSyncWatch$readFitnessData$1> continuation) {
        super(2, continuation);
        this.$watch = displayWatch;
        this.this$0 = fitnessSyncWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FitnessSyncWatch$readFitnessData$1 fitnessSyncWatch$readFitnessData$1 = new FitnessSyncWatch$readFitnessData$1(this.$watch, this.this$0, continuation);
        fitnessSyncWatch$readFitnessData$1.L$0 = obj;
        return fitnessSyncWatch$readFitnessData$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00fd A[Catch: Exception -> 0x011e, TryCatch #1 {Exception -> 0x011e, blocks: (B:9:0x0138, B:23:0x00f0, B:25:0x00fd, B:26:0x00d1, B:29:0x0120), top: B:22:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0120 A[Catch: Exception -> 0x011e, TryCatch #1 {Exception -> 0x011e, blocks: (B:9:0x0138, B:23:0x00f0, B:25:0x00fd, B:26:0x00d1, B:29:0x0120), top: B:22:0x00f0 }] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.util.List, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ed -> B:22:0x00f0). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.sync.FitnessSyncWatch$readFitnessData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FitnessSyncWatch$readFitnessData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
