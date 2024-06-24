package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import androidx.work.Logger;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class WakeLocks {
    public static final String TAG = Logger.tagWithPrefix("WakeLocks");
    public static final WeakHashMap<PowerManager.WakeLock, String> sWakeLocks = new WeakHashMap<>();

    public static PowerManager.WakeLock newWakeLock(Context context, String tag) {
        PowerManager powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        String m = ConstraintSet$$ExternalSyntheticOutline0.m("WorkManager: ", tag);
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, m);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = sWakeLocks;
        synchronized (weakHashMap) {
            weakHashMap.put(newWakeLock, m);
        }
        return newWakeLock;
    }
}
