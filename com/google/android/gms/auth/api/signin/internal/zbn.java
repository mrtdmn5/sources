package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public final class zbn {
    public static zbn zbd;
    public final Storage zba;
    public GoogleSignInAccount zbb;

    public zbn(Context context) {
        Storage storage = Storage.getInstance(context);
        this.zba = storage;
        this.zbb = storage.getSavedDefaultGoogleSignInAccount();
        storage.getSavedDefaultGoogleSignInOptions();
    }

    public static synchronized zbn zbc(Context context) {
        zbn zbnVar;
        synchronized (zbn.class) {
            Context applicationContext = context.getApplicationContext();
            synchronized (zbn.class) {
                zbnVar = zbd;
                if (zbnVar == null) {
                    zbnVar = new zbn(applicationContext);
                    zbd = zbnVar;
                }
            }
            return zbnVar;
        }
        return zbnVar;
    }

    public final synchronized void zbd() {
        Storage storage = this.zba;
        ReentrantLock reentrantLock = storage.zac;
        reentrantLock.lock();
        try {
            storage.zad.edit().clear().apply();
            reentrantLock.unlock();
            this.zbb = null;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
