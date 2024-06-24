package com.animaconnected.secondo.utils.debugging;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FileWriter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.debugging.FileWriter$append$1", f = "FileWriter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FileWriter$append$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ FileWriter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriter$append$1(FileWriter fileWriter, String str, Continuation<? super FileWriter$append$1> continuation) {
        super(2, continuation);
        this.this$0 = fileWriter;
        this.$text = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileWriter$append$1(this.this$0, this.$text, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            list = this.this$0.logCache;
            list.add(this.$text);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FileWriter$append$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
