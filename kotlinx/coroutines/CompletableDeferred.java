package kotlinx.coroutines;

/* compiled from: CompletableDeferred.kt */
/* loaded from: classes4.dex */
public interface CompletableDeferred<T> extends Deferred<T> {
    boolean complete(T t);
}
