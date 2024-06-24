package com.animaconnected.watch.storage;

import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.CrashStatus;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;

/* compiled from: RemoteCrashStorage.kt */
/* loaded from: classes3.dex */
public final class RemoteCrashStorage {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_CRASH_HANDLE_ATTEMPTS = "crash_handle_attempts";
    private static final String KEY_CRASH_STATUS = "crash_status";
    private static final String KEY_REMOTE_CRASH = "crash_remote";
    private final BasicStorage storage;

    /* compiled from: RemoteCrashStorage.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RemoteCrashStorage(BasicStorage storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        this.storage = storage;
    }

    public final void clear() {
        setRemotelyCrashed(false);
        setCrashStatus(null);
        setHandleAttempts(0);
    }

    public final CrashStatus getCrashStatus() {
        String string = this.storage.getString(KEY_CRASH_STATUS);
        if (string != null) {
            Json.Default r1 = Json.Default;
            r1.getClass();
            return (CrashStatus) r1.decodeFromString(BuiltinSerializersKt.getNullable(CrashStatus.Companion.serializer()), string);
        }
        return null;
    }

    public final int getHandleAttempts() {
        Integer num = this.storage.getInt(KEY_CRASH_HANDLE_ATTEMPTS);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final boolean isRemotelyCrashed() {
        Boolean bool = this.storage.getBoolean(KEY_REMOTE_CRASH);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void setCrashStatus(CrashStatus crashStatus) {
        BasicStorage basicStorage = this.storage;
        Json.Default r1 = Json.Default;
        r1.getClass();
        basicStorage.put(KEY_CRASH_STATUS, r1.encodeToString(BuiltinSerializersKt.getNullable(CrashStatus.Companion.serializer()), crashStatus));
    }

    public final void setHandleAttempts(int r3) {
        this.storage.put(KEY_CRASH_HANDLE_ATTEMPTS, r3);
    }

    public final void setRemotelyCrashed(boolean z) {
        this.storage.put(KEY_REMOTE_CRASH, z);
    }
}
