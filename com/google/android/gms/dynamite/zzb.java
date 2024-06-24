package com.google.android.gms.dynamite;

import android.os.Looper;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzb {
    public static volatile ClassLoader zza;
    public static volatile Thread zzb;

    public static synchronized ClassLoader zza() {
        ClassLoader classLoader;
        synchronized (zzb.class) {
            if (zza == null) {
                zza = zzb();
            }
            classLoader = zza;
        }
        return classLoader;
    }

    public static synchronized ClassLoader zzb() {
        synchronized (zzb.class) {
            ClassLoader classLoader = null;
            if (zzb == null) {
                zzb = zzc();
                if (zzb == null) {
                    return null;
                }
            }
            synchronized (zzb) {
                try {
                    classLoader = zzb.getContextClassLoader();
                } catch (SecurityException e) {
                    Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + e.getMessage());
                }
            }
            return classLoader;
        }
    }

    public static synchronized Thread zzc() {
        SecurityException e;
        Thread thread;
        Thread thread2;
        ThreadGroup threadGroup;
        synchronized (zzb.class) {
            ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
            if (threadGroup2 == null) {
                return null;
            }
            synchronized (Void.class) {
                try {
                    int activeGroupCount = threadGroup2.activeGroupCount();
                    ThreadGroup[] threadGroupArr = new ThreadGroup[activeGroupCount];
                    threadGroup2.enumerate(threadGroupArr);
                    int r6 = 0;
                    int r7 = 0;
                    while (true) {
                        if (r7 < activeGroupCount) {
                            threadGroup = threadGroupArr[r7];
                            if ("dynamiteLoader".equals(threadGroup.getName())) {
                                break;
                            }
                            r7++;
                        } else {
                            threadGroup = null;
                            break;
                        }
                    }
                    if (threadGroup == null) {
                        threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                    }
                    int activeCount = threadGroup.activeCount();
                    Thread[] threadArr = new Thread[activeCount];
                    threadGroup.enumerate(threadArr);
                    while (true) {
                        if (r6 < activeCount) {
                            thread2 = threadArr[r6];
                            if ("GmsDynamite".equals(thread2.getName())) {
                                break;
                            }
                            r6++;
                        } else {
                            thread2 = null;
                            break;
                        }
                    }
                } catch (SecurityException e2) {
                    e = e2;
                    thread = null;
                }
                if (thread2 == null) {
                    try {
                        thread = new zza(threadGroup);
                    } catch (SecurityException e3) {
                        e = e3;
                        thread = thread2;
                    }
                    try {
                        thread.setContextClassLoader(null);
                        thread.start();
                    } catch (SecurityException e4) {
                        e = e4;
                        Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e.getMessage());
                        thread2 = thread;
                        return thread2;
                    }
                    thread2 = thread;
                }
            }
            return thread2;
        }
    }
}
