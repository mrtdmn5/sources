package com.animaconnected.watch;

import com.animaconnected.secondo.KronabyApplication;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* compiled from: LePingReq.kt */
/* loaded from: classes3.dex */
public final class LePingReq {
    private static Job refreshJob;
    public static final LePingReq INSTANCE = new LePingReq();
    public static final int $stable = 8;

    private LePingReq() {
    }

    public final void disable() {
        Job job = refreshJob;
        if (job != null) {
            job.cancel(null);
        }
        refreshJob = null;
    }

    public final void enable() {
        if (refreshJob == null) {
            refreshJob = BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new LePingReq$enable$1(null), 3);
        }
    }
}
