package com.polidea.rxandroidble2.internal.logger;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.operations.Operation;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class LoggerUtil {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* loaded from: classes3.dex */
    public static class AttributeLogWrapper {
        public final byte[] value;
        public final boolean valueMatters;

        public AttributeLogWrapper(UUID r1, byte[] bArr, boolean z) {
            this.value = bArr;
            this.valueMatters = z;
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder("[uuid='...");
            LoggerUtil.getUuidToLog();
            if (this.valueMatters) {
                str = "', hexValue=".concat(LoggerUtil.bytesToHex(this.value));
            } else {
                str = "'";
            }
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, str, ']');
        }
    }

    static {
        "0123456789ABCDEF".toCharArray();
    }

    public static String bytesToHex(byte[] bArr) {
        if (bArr == null) {
            return Constants.NULL_VERSION_ID;
        }
        RxBleLog.loggerSetup.getClass();
        return "[...]";
    }

    public static String commonMacMessage(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt == null ? "MAC=null" : commonMacMessage(bluetoothGatt.getDevice().getAddress());
    }

    public static void getUuidToLog() {
        RxBleLog.loggerSetup.getClass();
    }

    public static void logCallback(String str, BluetoothGatt bluetoothGatt, int r4, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        if (RxBleLog.isAtLeast(4)) {
            RxBleLog.i(commonMacMessage(bluetoothGatt) + " %24s(), status=%d, value=%s", str, Integer.valueOf(r4), new AttributeLogWrapper(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue(), z));
        }
    }

    public static void logOperationFinished(Operation operation, long j, long j2) {
        if (RxBleLog.isAtLeast(3)) {
            RxBleLog.d("FINISHED %s(%d) in %d ms", operation.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(operation)), Long.valueOf(j2 - j));
        }
    }

    public static void logOperationQueued(Operation operation) {
        if (RxBleLog.isAtLeast(3)) {
            RxBleLog.d("QUEUED   %s(%d)", operation.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(operation)));
        }
    }

    public static void logOperationRemoved(Operation operation) {
        if (RxBleLog.isAtLeast(3)) {
            RxBleLog.d("REMOVED  %s(%d)", operation.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(operation)));
        }
    }

    public static void logOperationStarted(Operation operation) {
        if (RxBleLog.isAtLeast(3)) {
            RxBleLog.d("STARTED  %s(%d)", operation.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(operation)));
        }
    }

    public static String commonMacMessage(String str) {
        if (str == null) {
            return "MAC=null";
        }
        RxBleLog.loggerSetup.getClass();
        return String.format("MAC='%s'", "XX:XX:XX:XX:XX:XX");
    }

    public static void logCallback(String str, BluetoothGatt bluetoothGatt, int r4, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z) {
        if (RxBleLog.isAtLeast(4)) {
            RxBleLog.i(commonMacMessage(bluetoothGatt) + " %24s(), status=%d, value=%s", str, Integer.valueOf(r4), new AttributeLogWrapper(bluetoothGattDescriptor.getUuid(), bluetoothGattDescriptor.getValue(), z));
        }
    }

    public static void logCallback(String str, BluetoothGatt bluetoothGatt, int r3) {
        if (RxBleLog.isAtLeast(4)) {
            RxBleLog.i(commonMacMessage(bluetoothGatt) + " %24s(), status=%d", str, Integer.valueOf(r3));
        }
    }

    public static void logCallback(String str, BluetoothGatt bluetoothGatt, int r3, int r4) {
        if (RxBleLog.isAtLeast(4)) {
            RxBleLog.i(commonMacMessage(bluetoothGatt) + " %24s(), status=%d, value=%s", str, Integer.valueOf(r3), Integer.valueOf(r4));
        }
    }
}
