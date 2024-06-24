package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Latch.kt */
/* loaded from: classes.dex */
public final class Latch {
    public final Object lock = new Object();
    public List<Continuation<Unit>> awaiters = new ArrayList();
    public List<Continuation<Unit>> spareList = new ArrayList();
    public boolean _isOpen = true;
}
