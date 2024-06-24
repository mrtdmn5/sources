package com.amplifyframework.kotlin.storage;

import com.amplifyframework.storage.StorageException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Storage.kt */
@DebugMetadata(c = "com.amplifyframework.kotlin.storage.Storage$InProgressStorageOperation$result$2", f = "Storage.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class Storage$InProgressStorageOperation$result$2 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public Storage$InProgressStorageOperation$result$2(Continuation<? super Storage$InProgressStorageOperation$result$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Storage$InProgressStorageOperation$result$2 storage$InProgressStorageOperation$result$2 = new Storage$InProgressStorageOperation$result$2(continuation);
        storage$InProgressStorageOperation$result$2.L$0 = obj;
        return storage$InProgressStorageOperation$result$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            if (!(obj2 instanceof StorageException)) {
                return Unit.INSTANCE;
            }
            throw ((Throwable) obj2);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((Storage$InProgressStorageOperation$result$2) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
