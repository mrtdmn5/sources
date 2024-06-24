package com.amazonaws.mobileconnectors.s3.transferutility;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Map;

/* loaded from: classes.dex */
public class TransferService extends Service {
    private static final int ANDROID_OREO = 26;
    public static final String INTENT_KEY_NOTIFICATION = "notification";
    public static final String INTENT_KEY_NOTIFICATION_ID = "ongoing-notification-id";
    public static final String INTENT_KEY_REMOVE_NOTIFICATION = "remove-notification";
    private static final Log LOGGER = LogFactory.getLog((Class<?>) TransferService.class);
    static TransferNetworkLossHandler transferNetworkLossHandler;
    boolean isReceiverNotRegistered = true;
    private int ongoingNotificationId = 3462;
    private boolean removeNotification = true;

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if ((getApplicationInfo().flags & 2) == 0) {
            return;
        }
        printWriter.printf("network status: %s\n", Boolean.valueOf(transferNetworkLossHandler.isNetworkConnected()));
        Map<Integer, TransferRecord> transfers = TransferStatusUpdater.getInstance(this).getTransfers();
        printWriter.printf("# of active transfers: %d\n", Integer.valueOf(transfers.size()));
        for (TransferRecord transferRecord : transfers.values()) {
            printWriter.printf("bucket: %s, key: %s, status: %s, total size: %d, current: %d\n", transferRecord.bucketName, transferRecord.key, transferRecord.state, Long.valueOf(transferRecord.bytesTotal), Long.valueOf(transferRecord.bytesCurrent));
        }
        printWriter.flush();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Can't bind to TransferService");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log log = LOGGER;
        log.info("Starting Transfer Service to listen for network connectivity changes.");
        transferNetworkLossHandler = TransferNetworkLossHandler.getInstance(getApplicationContext());
        synchronized (this) {
            if (this.isReceiverNotRegistered) {
                try {
                    log.info("Registering the network receiver");
                    registerReceiver(transferNetworkLossHandler, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.isReceiverNotRegistered = false;
                } catch (IllegalArgumentException unused) {
                    LOGGER.warn("Ignoring the exception trying to register the receiver for connectivity change.");
                } catch (IllegalStateException unused2) {
                    LOGGER.warn("Ignoring the leak in registering the receiver.");
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:(2:1|2)|(6:4|d|23|24|25|26)|16|17|33) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0048, code lost:            com.amazonaws.mobileconnectors.s3.transferutility.TransferService.LOGGER.warn("Exception trying to de-register the network receiver");     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDestroy() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L18
            r1 = 26
            if (r0 < r1) goto L2c
            com.amazonaws.logging.Log r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.LOGGER     // Catch: java.lang.Exception -> L18
            java.lang.String r1 = "Moving the service out of the Foreground state."
            r0.info(r1)     // Catch: java.lang.Exception -> L18
            monitor-enter(r4)     // Catch: java.lang.Exception -> L18
            boolean r0 = r4.removeNotification     // Catch: java.lang.Throwable -> L15
            r4.stopForeground(r0)     // Catch: java.lang.Throwable -> L15
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L15
            goto L2c
        L15:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L15
            throw r0     // Catch: java.lang.Exception -> L18
        L18:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.LOGGER
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Error in moving the service out of the foreground state: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.error(r0)
        L2c:
            com.amazonaws.logging.Log r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.LOGGER     // Catch: java.lang.IllegalArgumentException -> L48
            java.lang.String r1 = "De-registering the network receiver."
            r0.info(r1)     // Catch: java.lang.IllegalArgumentException -> L48
            monitor-enter(r4)     // Catch: java.lang.IllegalArgumentException -> L48
            boolean r0 = r4.isReceiverNotRegistered     // Catch: java.lang.Throwable -> L45
            if (r0 != 0) goto L43
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.transferNetworkLossHandler     // Catch: java.lang.Throwable -> L45
            r4.unregisterReceiver(r0)     // Catch: java.lang.Throwable -> L45
            r0 = 1
            r4.isReceiverNotRegistered = r0     // Catch: java.lang.Throwable -> L45
            r0 = 0
            com.amazonaws.mobileconnectors.s3.transferutility.TransferService.transferNetworkLossHandler = r0     // Catch: java.lang.Throwable -> L45
        L43:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L45
            goto L4f
        L45:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L45
            throw r0     // Catch: java.lang.IllegalArgumentException -> L48
        L48:
            com.amazonaws.logging.Log r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.LOGGER
            java.lang.String r1 = "Exception trying to de-register the network receiver"
            r0.warn(r1)
        L4f:
            super.onDestroy()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferService.onDestroy():void");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int r3, int r4) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                synchronized (this) {
                    Notification notification = (Notification) intent.getParcelableExtra(INTENT_KEY_NOTIFICATION);
                    if (notification != null) {
                        this.ongoingNotificationId = intent.getIntExtra(INTENT_KEY_NOTIFICATION_ID, this.ongoingNotificationId);
                        this.removeNotification = intent.getBooleanExtra(INTENT_KEY_REMOVE_NOTIFICATION, this.removeNotification);
                        LOGGER.info("Putting the service in Foreground state.");
                        startForeground(this.ongoingNotificationId, notification);
                    } else {
                        LOGGER.error("No notification is passed in the intent. Unable to transition to foreground.");
                    }
                }
            } catch (Exception e) {
                LOGGER.error("Error in moving the service to foreground state: " + e);
            }
            return 1;
        }
        synchronized (this) {
            if (this.isReceiverNotRegistered) {
                try {
                    LOGGER.info("Registering the network receiver");
                    registerReceiver(transferNetworkLossHandler, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.isReceiverNotRegistered = false;
                } catch (IllegalArgumentException unused) {
                    LOGGER.warn("Ignoring the exception trying to register the receiver for connectivity change.");
                } catch (IllegalStateException unused2) {
                    LOGGER.warn("Ignoring the leak in registering the receiver.");
                }
            }
            return 1;
        }
    }
}
