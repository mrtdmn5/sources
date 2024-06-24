package kotlinx.coroutines;

/* compiled from: CompletableJob.kt */
/* loaded from: classes4.dex */
public interface CompletableJob extends Job {
    boolean complete();

    boolean completeExceptionally(Throwable th);
}
