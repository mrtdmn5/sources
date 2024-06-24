package androidx.sqlite.util;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ProcessLock.kt */
/* loaded from: classes.dex */
public final class ProcessLock {
    public static final HashMap threadLocksMap = new HashMap();
    public FileChannel lockChannel;
    public final File lockFile;
    public final boolean processLock = false;
    public final Lock threadLock;

    public ProcessLock(String str, File file) {
        File file2;
        Lock lock;
        if (file != null) {
            file2 = new File(file, str.concat(".lck"));
        } else {
            file2 = null;
        }
        this.lockFile = file2;
        HashMap hashMap = threadLocksMap;
        synchronized (hashMap) {
            Object obj = hashMap.get(str);
            if (obj == null) {
                obj = new ReentrantLock();
                hashMap.put(str, obj);
            }
            lock = (Lock) obj;
        }
        this.threadLock = lock;
    }

    public final void lock(boolean z) {
        this.threadLock.lock();
        if (z) {
            File file = this.lockFile;
            try {
                if (file != null) {
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    FileChannel channel = new FileOutputStream(file).getChannel();
                    channel.lock();
                    this.lockChannel = channel;
                    return;
                }
                throw new IOException("No lock directory was provided.");
            } catch (IOException e) {
                this.lockChannel = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e);
            }
        }
    }

    public final void unlock() {
        try {
            FileChannel fileChannel = this.lockChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.threadLock.unlock();
    }
}
