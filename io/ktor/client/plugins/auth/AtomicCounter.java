package io.ktor.client.plugins.auth;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: Auth.kt */
/* loaded from: classes3.dex */
public final class AtomicCounter {
    public static final /* synthetic */ AtomicIntegerFieldUpdater atomic$FU = AtomicIntegerFieldUpdater.newUpdater(AtomicCounter.class, "atomic");
    volatile /* synthetic */ int atomic = 0;
}
