package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
/* loaded from: classes4.dex */
public final class JobCancellationException extends CancellationException implements CopyableThrowable<JobCancellationException> {
    public final transient Job job;

    public JobCancellationException(String str, Throwable th, Job job) {
        super(str);
        this.job = job;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final /* bridge */ /* synthetic */ JobCancellationException createCopy() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!Intrinsics.areEqual(jobCancellationException.getMessage(), getMessage()) || !Intrinsics.areEqual(jobCancellationException.job, this.job) || !Intrinsics.areEqual(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        int r0;
        String message = getMessage();
        Intrinsics.checkNotNull(message);
        int hashCode = (this.job.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            r0 = cause.hashCode();
        } else {
            r0 = 0;
        }
        return hashCode + r0;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.job;
    }
}
