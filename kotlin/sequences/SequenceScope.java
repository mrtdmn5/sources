package kotlin.sequences;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* compiled from: SequenceBuilder.kt */
/* loaded from: classes.dex */
public abstract class SequenceScope<T> {
    public abstract CoroutineSingletons yield(Object obj, Continuation continuation);

    public abstract Object yieldAll(Iterator<? extends T> it, Continuation<? super Unit> continuation);
}
