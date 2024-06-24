package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;

/* loaded from: classes.dex */
public final class DefaultRunnableScheduler {
    public final Handler mHandler = HandlerCompat.createAsync(Looper.getMainLooper());
}
