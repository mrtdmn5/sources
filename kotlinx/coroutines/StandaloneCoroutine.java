package kotlinx.coroutines;

import kotlin.Unit;

/* compiled from: Builders.common.kt */
/* loaded from: classes4.dex */
public class StandaloneCoroutine extends AbstractCoroutine<Unit> {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean handleJobException(Throwable th) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.context, th);
        return true;
    }
}
