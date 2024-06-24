package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class SnackbarManager {
    public static SnackbarManager snackbarManager;
    public SnackbarRecord currentSnackbar;
    public SnackbarRecord nextSnackbar;
    public final Object lock = new Object();
    public final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarManager.1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager snackbarManager2 = SnackbarManager.this;
            SnackbarRecord snackbarRecord = (SnackbarRecord) message.obj;
            synchronized (snackbarManager2.lock) {
                if (snackbarManager2.currentSnackbar == snackbarRecord || snackbarManager2.nextSnackbar == snackbarRecord) {
                    snackbarManager2.cancelSnackbarLocked(snackbarRecord, 2);
                }
            }
            return true;
        }
    });

    /* loaded from: classes3.dex */
    public interface Callback {
        void dismiss();

        void show();
    }

    /* loaded from: classes3.dex */
    public static class SnackbarRecord {
        public final WeakReference<Callback> callback = new WeakReference<>(null);

        public SnackbarRecord(int r2) {
        }
    }

    public static SnackbarManager getInstance() {
        if (snackbarManager == null) {
            snackbarManager = new SnackbarManager();
        }
        return snackbarManager;
    }

    public final boolean cancelSnackbarLocked(SnackbarRecord snackbarRecord, int r3) {
        Callback callback = snackbarRecord.callback.get();
        if (callback != null) {
            this.handler.removeCallbacksAndMessages(snackbarRecord);
            callback.dismiss();
            return true;
        }
        return false;
    }
}
