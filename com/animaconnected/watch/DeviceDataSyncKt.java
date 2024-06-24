package com.animaconnected.watch;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: DeviceDataSync.kt */
/* loaded from: classes3.dex */
public final class DeviceDataSyncKt {
    private static final /* synthetic */ <T> T getObject(DeviceDataStorage deviceDataStorage, String str) {
        if (deviceDataStorage.getString(str) == null) {
            return null;
        }
        try {
            Json.Default.getClass();
            Intrinsics.reifiedOperationMarker();
            throw null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static final /* synthetic */ <T> boolean putObject(DeviceDataStorage deviceDataStorage, String str, T t) {
        try {
            Json.Default.getClass();
            Intrinsics.reifiedOperationMarker();
            throw null;
        } catch (Exception unused) {
            return false;
        }
    }
}
