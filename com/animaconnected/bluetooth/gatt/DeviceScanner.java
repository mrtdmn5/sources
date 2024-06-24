package com.animaconnected.bluetooth.gatt;

import com.animaconnected.bluetooth.device.scanner.BrandFilter;
import com.animaconnected.bluetooth.device.scanner.HybridDevice;
import com.animaconnected.bluetooth.device.scanner.ScannedDevice;
import com.animaconnected.bluetooth.device.scanner.SmarTimeBrand;
import com.animaconnected.bluetooth.device.scanner.SmarTimeDevice;
import com.animaconnected.bluetooth.gatt.GattId;
import com.animaconnected.bluetooth.util.BrandId;
import com.animaconnected.info.ByteUtils;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.logger.LogKt;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.scan.ScanRecord;
import com.polidea.rxandroidble2.scan.ScanResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: DeviceScanner.kt */
/* loaded from: classes.dex */
public final class DeviceScanner {
    private final List<Integer> blockedVariants;
    private final BrandFilter brandFilter;
    private final RxBleClient rxBleClient;
    private final String tag;

    public DeviceScanner(RxBleClient rxBleClient, BrandFilter brandFilter) {
        Intrinsics.checkNotNullParameter(rxBleClient, "rxBleClient");
        Intrinsics.checkNotNullParameter(brandFilter, "brandFilter");
        this.rxBleClient = rxBleClient;
        this.brandFilter = brandFilter;
        this.tag = String.valueOf(Reflection.getOrCreateKotlinClass(DeviceScanner.class).getSimpleName());
        this.blockedVariants = CollectionsKt__CollectionsKt.listOf((Object) 15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String description(BleScanException bleScanException) {
        int r2 = bleScanException.reason;
        switch (r2) {
            case 0:
                return "Unable to start scanning";
            case 1:
                return "Enable bluetooth and try again";
            case 2:
                return "Bluetooth is not available";
            case 3:
                return "On Android 6.0 location permission is required. Implement Runtime Permissions";
            case 4:
                return "Location services needs to be enabled on Android 6.0+";
            case 5:
                return "Scan with the same filters is already started";
            case 6:
                return "Failed to register application for bluetooth scan";
            case 7:
                return "Scan failed due to internal error";
            case 8:
                return "Scan with specified parameters is not supported";
            case 9:
                return "Scan cannot start due to limited hardware resources";
            default:
                switch (r2) {
                    case 2147483646:
                        return "Android 7+ does not allow more scans";
                    case Integer.MAX_VALUE:
                    default:
                        return "Unable to start scanning";
                }
        }
    }

    private final byte[] getAdvertisementData(ScanRecord scanRecord) {
        Object obj;
        boolean z;
        boolean z2;
        int[] ALL = GattId.Company.ALL;
        Intrinsics.checkNotNullExpressionValue(ALL, "ALL");
        ArrayList arrayList = new ArrayList(ALL.length);
        for (int r0 : ALL) {
            arrayList.add(scanRecord.getManufacturerSpecificData(r0));
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                byte[] bArr = (byte[]) obj;
                if (bArr != null) {
                    if (bArr.length == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z = !z2;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (byte[]) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScannedDevice parseScannedDevice(ScanResult scanResult) {
        final DeviceType deviceType;
        FirmwareVariant firmwareVariant;
        DeviceType fromAdvertisedNumber;
        RxBleDevice rxBleDevice = scanResult.bleDevice;
        Locale locale = Locale.ROOT;
        int r9 = scanResult.rssi;
        final String format = String.format(locale, "RSSI: %11d: %s %s", Arrays.copyOf(new Object[]{Integer.valueOf(r9), rxBleDevice.getMacAddress(), rxBleDevice.getName()}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        ScanRecord scanRecord = scanResult.scanRecord;
        Intrinsics.checkNotNull(scanRecord);
        final byte[] advertisementData = getAdvertisementData(scanRecord);
        if (advertisementData != null) {
            try {
                if (advertisementData.length == 1 && this.brandFilter.getUseLegacyAdvertisement()) {
                    fromAdvertisedNumber = DeviceType.Companion.fromAdvertisedNumber(advertisementData[0]);
                } else {
                    if (advertisementData.length != 2) {
                        if (advertisementData.length == 3) {
                        }
                        fromAdvertisedNumber = null;
                    }
                    byte b = advertisementData[1];
                    byte b2 = advertisementData[0];
                    if (b == this.brandFilter.getBrandId().getId() || b == BrandId.None.getId()) {
                        fromAdvertisedNumber = DeviceType.Companion.fromAdvertisedNumber(b2);
                    }
                    fromAdvertisedNumber = null;
                }
                deviceType = fromAdvertisedNumber;
            } catch (IllegalArgumentException unused) {
                LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.gatt.DeviceScanner$parseScannedDevice$deviceType$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to parse devicetype";
                    }
                }, 6, (Object) null);
                deviceType = null;
            }
            if (advertisementData.length == 3) {
                firmwareVariant = new FirmwareVariant(Integer.valueOf(advertisementData[2] & 255));
            } else {
                firmwareVariant = new FirmwareVariant(null, 1, null);
            }
            FirmwareVariant firmwareVariant2 = firmwareVariant;
            if (deviceType != null && !CollectionsKt___CollectionsKt.contains(this.blockedVariants, firmwareVariant2.getValue())) {
                LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.gatt.DeviceScanner$parseScannedDevice$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return format + " HybridWatch[" + deviceType + " {" + ByteUtils.toHex(advertisementData) + "}]";
                    }
                }, 6, (Object) null);
                String macAddress = rxBleDevice.getMacAddress();
                Intrinsics.checkNotNullExpressionValue(macAddress, "getMacAddress(...)");
                return new HybridDevice(macAddress, r9, deviceType, firmwareVariant2);
            }
        }
        final SmarTimeBrand parseFromName = SmarTimeBrand.Companion.parseFromName(rxBleDevice.getName());
        if (parseFromName == null) {
            return null;
        }
        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.gatt.DeviceScanner$parseScannedDevice$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return format + " SmarTime[" + parseFromName + ']';
            }
        }, 6, (Object) null);
        String macAddress2 = rxBleDevice.getMacAddress();
        Intrinsics.checkNotNullExpressionValue(macAddress2, "getMacAddress(...)");
        return new SmarTimeDevice(macAddress2, r9, parseFromName);
    }

    public final String getTag() {
        return this.tag;
    }

    public final Flow<ScannedDevice> scan() {
        return FlowKt.callbackFlow(new DeviceScanner$scan$1(this, null));
    }
}
