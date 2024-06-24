package kotlin.coroutines.intrinsics;

import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;

/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1 extends RestrictedContinuationImpl {
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        return obj;
    }
}
