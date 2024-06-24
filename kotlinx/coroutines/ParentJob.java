package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* compiled from: Job.kt */
/* loaded from: classes4.dex */
public interface ParentJob extends Job {
    CancellationException getChildJobCancellationCause();
}
