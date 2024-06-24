package com.animaconnected.secondo.utils.debugging;

import android.content.Context;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: FileWriter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.debugging.FileWriter$append$2", f = "FileWriter.kt", l = {54, 55}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FileWriter$append$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ FileWriter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriter$append$2(FileWriter fileWriter, Context context, Continuation<? super FileWriter$append$2> continuation) {
        super(2, continuation);
        this.this$0 = fileWriter;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileWriter$append$2(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            j = this.this$0.saveInterval;
            this.label = 1;
            if (DelayKt.m1695delayVtjQ1oo(j, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        FileWriter fileWriter = this.this$0;
        Context context = this.$context;
        this.label = 2;
        if (fileWriter.saveToFile(context, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FileWriter$append$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
