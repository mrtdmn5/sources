package kotlin.coroutines.intrinsics;

import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2 extends ContinuationImpl {
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        return obj;
    }
}
