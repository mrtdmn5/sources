package kotlinx.coroutines;

/* compiled from: Supervisor.kt */
/* loaded from: classes4.dex */
public final class SupervisorJobImpl extends JobImpl {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean childCancelled(Throwable th) {
        return false;
    }
}
