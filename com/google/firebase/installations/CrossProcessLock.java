package com.google.firebase.installations;

import android.util.Log;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: classes3.dex */
public final class CrossProcessLock {
    public final FileChannel channel;
    public final FileLock lock;

    public CrossProcessLock(FileChannel fileChannel, FileLock fileLock) {
        this.channel = fileChannel;
        this.lock = fileLock;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.firebase.installations.CrossProcessLock acquire(android.content.Context r5) {
        /*
            java.lang.String r0 = "generatefid.lock"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L31 java.io.IOException -> L33
            java.io.File r5 = r5.getFilesDir()     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L31 java.io.IOException -> L33
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L31 java.io.IOException -> L33
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L31 java.io.IOException -> L33
            java.lang.String r0 = "rw"
            r5.<init>(r2, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L31 java.io.IOException -> L33
            java.nio.channels.FileChannel r5 = r5.getChannel()     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L31 java.io.IOException -> L33
            java.nio.channels.FileLock r0 = r5.lock()     // Catch: java.nio.channels.OverlappingFileLockException -> L27 java.lang.Error -> L29 java.io.IOException -> L2b
            com.google.firebase.installations.CrossProcessLock r2 = new com.google.firebase.installations.CrossProcessLock     // Catch: java.nio.channels.OverlappingFileLockException -> L21 java.lang.Error -> L23 java.io.IOException -> L25
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L21 java.lang.Error -> L23 java.io.IOException -> L25
            return r2
        L21:
            r2 = move-exception
            goto L37
        L23:
            r2 = move-exception
            goto L37
        L25:
            r2 = move-exception
            goto L37
        L27:
            r0 = move-exception
            goto L2c
        L29:
            r0 = move-exception
            goto L2c
        L2b:
            r0 = move-exception
        L2c:
            r2 = r0
            r0 = r1
            goto L37
        L2f:
            r5 = move-exception
            goto L34
        L31:
            r5 = move-exception
            goto L34
        L33:
            r5 = move-exception
        L34:
            r2 = r5
            r5 = r1
            r0 = r5
        L37:
            java.lang.String r3 = "CrossProcessLock"
            java.lang.String r4 = "encountered error while creating and acquiring the lock, ignoring"
            android.util.Log.e(r3, r4, r2)
            if (r0 == 0) goto L43
            r0.release()     // Catch: java.io.IOException -> L43
        L43:
            if (r5 == 0) goto L48
            r5.close()     // Catch: java.io.IOException -> L48
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.CrossProcessLock.acquire(android.content.Context):com.google.firebase.installations.CrossProcessLock");
    }

    public final void releaseAndClose() {
        try {
            this.lock.release();
            this.channel.close();
        } catch (IOException e) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e);
        }
    }
}
