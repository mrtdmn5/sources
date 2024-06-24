package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.persistence.FileStore;

/* loaded from: classes3.dex */
public final class LogFileManager {
    public static final NoopLogStore NOOP_LOG_STORE = new NoopLogStore();
    public FileLogStore currentLog;
    public final FileStore fileStore;

    public LogFileManager(FileStore fileStore) {
        this.fileStore = fileStore;
        this.currentLog = NOOP_LOG_STORE;
    }

    public final void setCurrentSession(String str) {
        this.currentLog.closeLogFile();
        this.currentLog = NOOP_LOG_STORE;
        if (str == null) {
            return;
        }
        this.currentLog = new QueueFileLogStore(this.fileStore.getSessionFile(str, "userlog"));
    }

    public LogFileManager(FileStore fileStore, String str) {
        this(fileStore);
        setCurrentSession(str);
    }

    /* loaded from: classes3.dex */
    public static final class NoopLogStore implements FileLogStore {
        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public final String getLogAsString() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public final void closeLogFile() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public final void writeToLog(long j, String str) {
        }
    }
}
