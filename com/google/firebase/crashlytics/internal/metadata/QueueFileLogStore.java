package com.google.firebase.crashlytics.internal.metadata;

import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class QueueFileLogStore implements FileLogStore {
    public static final Charset UTF_8 = Charset.forName(Constants.DEFAULT_ENCODING);
    public QueueFile logFile;
    public final int maxLogSize = 65536;
    public final File workingFile;

    /* loaded from: classes3.dex */
    public static class LogBytes {
        public final byte[] bytes;
        public final int offset;

        public LogBytes(byte[] bArr, int r2) {
            this.bytes = bArr;
            this.offset = r2;
        }
    }

    public QueueFileLogStore(File file) {
        this.workingFile = file;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public final void closeLogFile() {
        CommonUtils.closeOrLog(this.logFile, "There was a problem closing the Crashlytics log file.");
        this.logFile = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d  */
    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getLogAsString() {
        /*
            r10 = this;
            java.io.File r0 = r10.workingFile
            boolean r0 = r0.exists()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto Lb
            goto L12
        Lb:
            r10.openLogFile()
            com.google.firebase.crashlytics.internal.metadata.QueueFile r0 = r10.logFile
            if (r0 != 0) goto L14
        L12:
            r4 = r1
            goto L69
        L14:
            int[] r3 = new int[]{r2}
            int r0 = r0.usedBytes()
            byte[] r0 = new byte[r0]
            com.google.firebase.crashlytics.internal.metadata.QueueFile r4 = r10.logFile     // Catch: java.io.IOException -> L5a
            monitor-enter(r4)     // Catch: java.io.IOException -> L5a
            com.google.firebase.crashlytics.internal.metadata.QueueFile$Element r5 = r4.first     // Catch: java.lang.Throwable -> L57
            int r5 = r5.position     // Catch: java.lang.Throwable -> L57
            r6 = r2
        L26:
            int r7 = r4.elementCount     // Catch: java.lang.Throwable -> L57
            if (r6 >= r7) goto L55
            com.google.firebase.crashlytics.internal.metadata.QueueFile$Element r5 = r4.readElement(r5)     // Catch: java.lang.Throwable -> L57
            com.google.firebase.crashlytics.internal.metadata.QueueFile$ElementInputStream r7 = new com.google.firebase.crashlytics.internal.metadata.QueueFile$ElementInputStream     // Catch: java.lang.Throwable -> L57
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L57
            int r8 = r5.length     // Catch: java.lang.Throwable -> L57
            r9 = r3[r2]     // Catch: java.lang.Throwable -> L50
            r7.read(r0, r9, r8)     // Catch: java.lang.Throwable -> L50
            r9 = r3[r2]     // Catch: java.lang.Throwable -> L50
            int r9 = r9 + r8
            r3[r2] = r9     // Catch: java.lang.Throwable -> L50
            r7.close()     // Catch: java.lang.Throwable -> L57
            int r7 = r5.position     // Catch: java.lang.Throwable -> L57
            int r7 = r7 + 4
            int r5 = r5.length     // Catch: java.lang.Throwable -> L57
            int r7 = r7 + r5
            int r5 = r4.wrapPosition(r7)     // Catch: java.lang.Throwable -> L57
            int r6 = r6 + 1
            goto L26
        L50:
            r5 = move-exception
            r7.close()     // Catch: java.lang.Throwable -> L57
            throw r5     // Catch: java.lang.Throwable -> L57
        L55:
            monitor-exit(r4)     // Catch: java.io.IOException -> L5a
            goto L62
        L57:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.io.IOException -> L5a
            throw r5     // Catch: java.io.IOException -> L5a
        L5a:
            r4 = move-exception
            java.lang.String r5 = "FirebaseCrashlytics"
            java.lang.String r6 = "A problem occurred while reading the Crashlytics log file."
            android.util.Log.e(r5, r6, r4)
        L62:
            com.google.firebase.crashlytics.internal.metadata.QueueFileLogStore$LogBytes r4 = new com.google.firebase.crashlytics.internal.metadata.QueueFileLogStore$LogBytes
            r3 = r3[r2]
            r4.<init>(r0, r3)
        L69:
            if (r4 != 0) goto L6d
            r3 = r1
            goto L76
        L6d:
            int r0 = r4.offset
            byte[] r3 = new byte[r0]
            byte[] r4 = r4.bytes
            java.lang.System.arraycopy(r4, r2, r3, r2, r0)
        L76:
            if (r3 == 0) goto L7f
            java.lang.String r1 = new java.lang.String
            java.nio.charset.Charset r0 = com.google.firebase.crashlytics.internal.metadata.QueueFileLogStore.UTF_8
            r1.<init>(r3, r0)
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.metadata.QueueFileLogStore.getLogAsString():java.lang.String");
    }

    public final void openLogFile() {
        File file = this.workingFile;
        if (this.logFile == null) {
            try {
                this.logFile = new QueueFile(file);
            } catch (IOException e) {
                Log.e("FirebaseCrashlytics", "Could not open log file: " + file, e);
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public final void writeToLog(long j, String str) {
        boolean z;
        openLogFile();
        int r1 = this.maxLogSize;
        if (this.logFile != null) {
            if (str == null) {
                str = Constants.NULL_VERSION_ID;
            }
            try {
                int r3 = r1 / 4;
                if (str.length() > r3) {
                    str = "..." + str.substring(str.length() - r3);
                }
                this.logFile.add(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(UTF_8));
                while (true) {
                    QueueFile queueFile = this.logFile;
                    synchronized (queueFile) {
                        if (queueFile.elementCount == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (!z && this.logFile.usedBytes() > r1) {
                        this.logFile.remove();
                    } else {
                        return;
                    }
                }
            } catch (IOException e) {
                Log.e("FirebaseCrashlytics", "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }
}
