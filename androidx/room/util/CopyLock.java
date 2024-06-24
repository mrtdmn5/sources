package androidx.room.util;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class CopyLock {
    public static final HashMap sThreadLocks = new HashMap();
    public final File mCopyLockFile;
    public final boolean mFileLevelLock;
    public FileChannel mLockChannel;
    public final Lock mThreadLock;

    public CopyLock(String str, File file, boolean z) {
        Lock lock;
        File file2 = new File(file, ComposableInvoker$$ExternalSyntheticOutline0.m(str, ".lck"));
        this.mCopyLockFile = file2;
        String absolutePath = file2.getAbsolutePath();
        HashMap hashMap = sThreadLocks;
        synchronized (hashMap) {
            lock = (Lock) hashMap.get(absolutePath);
            if (lock == null) {
                lock = new ReentrantLock();
                hashMap.put(absolutePath, lock);
            }
        }
        this.mThreadLock = lock;
        this.mFileLevelLock = z;
    }

    public final void unlock() {
        FileChannel fileChannel = this.mLockChannel;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.mThreadLock.unlock();
    }
}
