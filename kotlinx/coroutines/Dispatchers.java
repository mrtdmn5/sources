package kotlinx.coroutines;

import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: Dispatchers.kt */
/* loaded from: classes4.dex */
public final class Dispatchers {
    public static final DefaultScheduler Default = DefaultScheduler.INSTANCE;
    public static final Unconfined Unconfined = Unconfined.INSTANCE;
    public static final DefaultIoScheduler IO = DefaultIoScheduler.INSTANCE;
}
