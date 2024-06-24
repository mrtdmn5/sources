package com.animaconnected.watch.provider.demo;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.fitness.Entry;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import kotlinx.datetime.Instant;

/* compiled from: DemoDataGenerator.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.demo.DemoDataGenerator$runSession$1", f = "DemoDataGenerator.kt", l = {R.styleable.AppTheme_workoutDetailTintColor, 198, 209, 225, 242, 250, 259, 270}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DemoDataGenerator$runSession$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Entry>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Instant $sessionStart;
    double D$0;
    long J$0;
    long J$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ DemoDataGenerator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DemoDataGenerator$runSession$1(Instant instant, DemoDataGenerator demoDataGenerator, Continuation<? super DemoDataGenerator$runSession$1> continuation) {
        super(2, continuation);
        this.$sessionStart = instant;
        this.this$0 = demoDataGenerator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DemoDataGenerator$runSession$1 demoDataGenerator$runSession$1 = new DemoDataGenerator$runSession$1(this.$sessionStart, this.this$0, continuation);
        demoDataGenerator$runSession$1.L$0 = obj;
        return demoDataGenerator$runSession$1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x038e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0364 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0338 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x023a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x029b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02ba  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x029c -> B:23:0x02a5). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r49) {
        /*
            Method dump skipped, instructions count: 936
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.demo.DemoDataGenerator$runSession$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Entry> sequenceScope, Continuation<? super Unit> continuation) {
        return ((DemoDataGenerator$runSession$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
