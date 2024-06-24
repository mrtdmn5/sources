package com.j256.ormlite.android.compat;

import android.os.CancellationSignal;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;

/* loaded from: classes3.dex */
public final class JellyBeanApiCompatibility extends LockFreeLinkedListKt {

    /* loaded from: classes3.dex */
    public static class JellyBeanCancellationHook {
        public final CancellationSignal cancellationSignal = new CancellationSignal();
    }
}
