package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes3.dex */
public final class UserMetadata {
    public final CrashlyticsBackgroundWorker backgroundWorker;
    public final MetaDataStore metaDataStore;
    public final String sessionIdentifier;
    public final SerializeableKeysMap customKeys = new SerializeableKeysMap(false);
    public final SerializeableKeysMap internalKeys = new SerializeableKeysMap(true);
    public final AtomicMarkableReference<String> userId = new AtomicMarkableReference<>(null, false);

    /* loaded from: classes3.dex */
    public class SerializeableKeysMap {
        public final AtomicMarkableReference<KeysMap> map;

        public SerializeableKeysMap(boolean z) {
            int r3;
            new AtomicReference(null);
            if (z) {
                r3 = DfuBaseService.ERROR_REMOTE_MASK;
            } else {
                r3 = 1024;
            }
            this.map = new AtomicMarkableReference<>(new KeysMap(r3), false);
        }
    }

    public UserMetadata(String str, FileStore fileStore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        this.sessionIdentifier = str;
        this.metaDataStore = new MetaDataStore(fileStore);
        this.backgroundWorker = crashlyticsBackgroundWorker;
    }
}
