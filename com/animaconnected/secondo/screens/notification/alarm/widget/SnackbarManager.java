package com.animaconnected.secondo.screens.notification.alarm.widget;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarManager;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class SnackbarManager {
    private static WeakReference<Snackbar> sSnackbar;

    private SnackbarManager() {
    }

    public static void dismiss() {
        WeakReference<Snackbar> weakReference = sSnackbar;
        if (weakReference != null && weakReference.get() != null) {
            sSnackbar.get().getClass();
            BaseTransientBottomBar.dispatchDismiss(3);
            sSnackbar = null;
        }
    }

    public static void show(Snackbar snackbar) {
        sSnackbar = new WeakReference<>(snackbar);
        snackbar.getClass();
        com.google.android.material.snackbar.SnackbarManager snackbarManager = com.google.android.material.snackbar.SnackbarManager.getInstance();
        snackbar.getDuration();
        synchronized (snackbarManager.lock) {
            snackbarManager.nextSnackbar = new SnackbarManager.SnackbarRecord(0);
            SnackbarManager.SnackbarRecord snackbarRecord = snackbarManager.currentSnackbar;
            if (snackbarRecord == null || !snackbarManager.cancelSnackbarLocked(snackbarRecord, 4)) {
                snackbarManager.currentSnackbar = null;
                SnackbarManager.SnackbarRecord snackbarRecord2 = snackbarManager.nextSnackbar;
                if (snackbarRecord2 != null) {
                    snackbarManager.currentSnackbar = snackbarRecord2;
                    snackbarManager.nextSnackbar = null;
                    SnackbarManager.Callback callback = snackbarRecord2.callback.get();
                    if (callback != null) {
                        callback.show();
                    } else {
                        snackbarManager.currentSnackbar = null;
                    }
                }
            }
        }
    }
}
