package kotlinx.coroutines;

/* compiled from: Job.kt */
/* loaded from: classes4.dex */
public interface ChildJob extends Job {
    void parentCancelled(JobSupport jobSupport);
}
