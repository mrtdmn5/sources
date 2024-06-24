package com.animaconnected.watch.fitness;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: FitnessProvider.kt */
/* loaded from: classes3.dex */
public interface SessionListener {
    Object onCompletedPreProcess(Session session, List<? extends List<LocationEntry>> list, Continuation<? super Unit> continuation);
}
