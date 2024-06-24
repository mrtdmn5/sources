package com.animaconnected.watch;

import com.animaconnected.bluetooth.gatt.GattDevice;
import com.animaconnected.bluetooth.gatt.GattId;
import com.animaconnected.bluetooth.gatt.ReadCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureUtils;
import com.animaconnected.future.Promise;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.DeviceInfo;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceInformation.kt */
/* loaded from: classes3.dex */
public final class DeviceInformation {
    private final Map<UUID, String> characteristics;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final List<UUID> CHARACTERISTICS = CollectionsKt__CollectionsKt.listOf((Object[]) new UUID[]{GattId.Characteristic.FIRMWARE_REVISION, GattId.Characteristic.HARDWARE_REVISION, GattId.Characteristic.MANUFACTURER_NAME, GattId.Characteristic.MODEL_NUMBER, GattId.Characteristic.SERIAL_NUMBER});

    /* compiled from: DeviceInformation.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Future<String> readCharacteristic(GattDevice gattDevice, UUID r5) {
            final Promise promise = new Promise();
            UUID DEVICE_INFORMATION = GattId.Service.DEVICE_INFORMATION;
            Intrinsics.checkNotNullExpressionValue(DEVICE_INFORMATION, "DEVICE_INFORMATION");
            gattDevice.read(DEVICE_INFORMATION, r5, new ReadCallback() { // from class: com.animaconnected.watch.DeviceInformation$Companion$readCharacteristic$1
                @Override // com.animaconnected.bluetooth.gatt.ReadCallback
                public void onError(Throwable error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    promise.reject(error);
                }

                @Override // com.animaconnected.bluetooth.gatt.ReadCallback
                public void onSuccess(byte[] result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    promise.resolve(new String(result, UTF_8));
                }
            });
            Future<String> future = promise.getFuture();
            Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
            return future;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Future readFromService$lambda$0(Map result) {
            Intrinsics.checkNotNullParameter(result, "result");
            return FutureUtils.just(new DeviceInformation(result, null));
        }

        public final DeviceInformation readFromCache(BasicStorage cache) {
            Intrinsics.checkNotNullParameter(cache, "cache");
            HashMap hashMap = new HashMap();
            Iterator it = DeviceInformation.CHARACTERISTICS.iterator();
            while (true) {
                DefaultConstructorMarker defaultConstructorMarker = null;
                if (it.hasNext()) {
                    UUID r2 = (UUID) it.next();
                    String str = r2.toString();
                    Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
                    String string = cache.getString(str);
                    if (string == null) {
                        return null;
                    }
                    hashMap.put(r2, string);
                } else {
                    return new DeviceInformation(hashMap, defaultConstructorMarker);
                }
            }
        }

        public final Future<DeviceInformation> readFromService(GattDevice gattDevice) {
            Intrinsics.checkNotNullParameter(gattDevice, "gattDevice");
            HashMap hashMap = new HashMap();
            for (UUID r2 : DeviceInformation.CHARACTERISTICS) {
                Intrinsics.checkNotNull(r2);
                hashMap.put(r2, readCharacteristic(gattDevice, r2));
            }
            Future<DeviceInformation> flatMap = FutureUtils.unwrap(hashMap).flatMap(new DeviceInformation$Companion$$ExternalSyntheticLambda0());
            Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap(...)");
            return flatMap;
        }

        private Companion() {
        }
    }

    public /* synthetic */ DeviceInformation(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    public final String getFirmwareRevision() {
        return this.characteristics.get(GattId.Characteristic.FIRMWARE_REVISION);
    }

    public final Map<DeviceInfo, String> getLegacyInformation(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return MapsKt__MapsKt.mapOf(new Pair(DeviceInfo.FirmwareRevision, this.characteristics.get(GattId.Characteristic.FIRMWARE_REVISION)), new Pair(DeviceInfo.HardwareRevision, this.characteristics.get(GattId.Characteristic.HARDWARE_REVISION)), new Pair(DeviceInfo.ManufacturerName, this.characteristics.get(GattId.Characteristic.MANUFACTURER_NAME)), new Pair(DeviceInfo.ModelNumber, this.characteristics.get(GattId.Characteristic.MODEL_NUMBER)), new Pair(DeviceInfo.SerialNumber, this.characteristics.get(GattId.Characteristic.SERIAL_NUMBER)), new Pair(DeviceInfo.Address, address));
    }

    public final void writeToCache(BasicStorage cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        for (UUID r1 : CHARACTERISTICS) {
            String str = r1.toString();
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            cache.put(str, this.characteristics.get(r1));
        }
    }

    private DeviceInformation(Map<UUID, String> map) {
        this.characteristics = map;
    }
}
