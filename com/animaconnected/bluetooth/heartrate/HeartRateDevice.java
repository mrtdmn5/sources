package com.animaconnected.bluetooth.heartrate;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import com.animaconnected.bluetooth.heartrate.HeartRateDevice;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.bluetooth.util.ConnectionListener;
import com.animaconnected.info.ByteUtils;
import com.animaconnected.info.DateTimeUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: HeartRateDevice.kt */
@SuppressLint({"StaticFieldLeak", "MissingPermission"})
/* loaded from: classes.dex */
public final class HeartRateDevice {
    private static BluetoothGatt gattDevice;
    private static ReferenceDeviceListener listener;
    public static final HeartRateDevice INSTANCE = new HeartRateDevice();
    private static UUID UUID_HEART_RATE_MEASUREMENT_CHARACTERISTIC = UUID.fromString("00002a37-0000-1000-8000-00805f9b34fb");
    private static UUID UUID_HEART_RATE_SERVICE = UUID.fromString("0000180d-0000-1000-8000-00805f9b34fb");
    private static UUID CLIENT_CHARACTERISTIC_CONFIG = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    private static final MutableStateFlow<State> stateFlow = StateFlowKt.MutableStateFlow(State.Inactive);
    private static final MutableStateFlow<BluetoothDevice> deviceFlow = StateFlowKt.MutableStateFlow(null);
    private static final MutableStateFlow<Integer> heartrateFlow = StateFlowKt.MutableStateFlow(0);
    private static final ConnectionListener connectionListener = new HeartRateDevice$$ExternalSyntheticLambda0();
    private static final HeartRateDevice$gattCallback$1 gattCallback = new BluetoothGattCallback() { // from class: com.animaconnected.bluetooth.heartrate.HeartRateDevice$gattCallback$1
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            UUID r0;
            boolean z;
            Byte valueOf;
            int r6;
            List list;
            int r3;
            int r1;
            if (bluetoothGattCharacteristic != null) {
                UUID uuid = bluetoothGattCharacteristic.getUuid();
                r0 = HeartRateDevice.UUID_HEART_RATE_MEASUREMENT_CHARACTERISTIC;
                if (Intrinsics.areEqual(uuid, r0)) {
                    byte[] value = bluetoothGattCharacteristic.getValue();
                    Intrinsics.checkNotNull(value);
                    if (value.length == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        valueOf = null;
                    } else {
                        valueOf = Byte.valueOf(value[0]);
                    }
                    if (valueOf != null) {
                        byte byteValue = valueOf.byteValue();
                        boolean isSet = ByteUtils.isSet(byteValue, 0);
                        boolean isSet2 = ByteUtils.isSet(byteValue, 3);
                        boolean isSet3 = ByteUtils.isSet(byteValue, 4);
                        if (isSet) {
                            r6 = 18;
                        } else {
                            r6 = 17;
                        }
                        Integer intValue = bluetoothGattCharacteristic.getIntValue(r6, 1);
                        if (isSet3) {
                            if (isSet) {
                                r3 = 2;
                            } else {
                                r3 = 1;
                            }
                            int r32 = r3 + 1;
                            if (isSet2) {
                                r1 = 2;
                            } else {
                                r1 = 0;
                            }
                            IntRange until = RangesKt___RangesKt.until(0, (value.length - (r32 + r1)) / 2);
                            list = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
                            Iterator<Integer> it = until.iterator();
                            while (it.hasNext()) {
                                list.add(Float.valueOf(bluetoothGattCharacteristic.getIntValue(18, (((IntIterator) it).nextInt() * 2) + r3).intValue() / 1024.0f));
                            }
                        } else {
                            list = EmptyList.INSTANCE;
                        }
                        HeartRateDevice heartRateDevice = HeartRateDevice.INSTANCE;
                        MutableStateFlow<Integer> heartrateFlow2 = heartRateDevice.getHeartrateFlow();
                        Intrinsics.checkNotNull(intValue);
                        heartrateFlow2.setValue(intValue);
                        ReferenceDeviceListener listener2 = heartRateDevice.getListener();
                        if (listener2 != null) {
                            listener2.onData(new HeartRateDevice.HRValue(DateTimeUtilsKt.currentTimeMillis(), intValue.intValue(), list));
                        }
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int r2, int r3) {
            BluetoothGatt bluetoothGatt2;
            if (r3 != 0) {
                if (r3 == 2) {
                    HeartRateDevice.INSTANCE.getStateFlow().setValue(HeartRateDevice.State.DiscoverServices);
                    bluetoothGatt2 = HeartRateDevice.gattDevice;
                    if (bluetoothGatt2 != null) {
                        bluetoothGatt2.discoverServices();
                        return;
                    }
                    return;
                }
                return;
            }
            HeartRateDevice heartRateDevice = HeartRateDevice.INSTANCE;
            heartRateDevice.getStateFlow().setValue(HeartRateDevice.State.Disconnected);
            heartRateDevice.close();
            if (ConnectionFactory.getConnection().isEnabled()) {
                heartRateDevice.connect();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
        @Override // android.bluetooth.BluetoothGattCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onServicesDiscovered(android.bluetooth.BluetoothGatt r4, int r5) {
            /*
                r3 = this;
                com.animaconnected.bluetooth.heartrate.HeartRateDevice r4 = com.animaconnected.bluetooth.heartrate.HeartRateDevice.INSTANCE
                kotlinx.coroutines.flow.MutableStateFlow r4 = r4.getStateFlow()
                com.animaconnected.bluetooth.heartrate.HeartRateDevice$State r5 = com.animaconnected.bluetooth.heartrate.HeartRateDevice.State.SetNotification
                r4.setValue(r5)
                android.bluetooth.BluetoothGatt r4 = com.animaconnected.bluetooth.heartrate.HeartRateDevice.access$getGattDevice$p()
                r5 = 0
                if (r4 == 0) goto L6b
                java.util.List r4 = r4.getServices()
                if (r4 == 0) goto L6b
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                java.util.Iterator r4 = r4.iterator()
            L1e:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L3a
                java.lang.Object r0 = r4.next()
                r1 = r0
                android.bluetooth.BluetoothGattService r1 = (android.bluetooth.BluetoothGattService) r1
                java.util.UUID r1 = r1.getUuid()
                java.util.UUID r2 = com.animaconnected.bluetooth.heartrate.HeartRateDevice.access$getUUID_HEART_RATE_SERVICE$p()
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                if (r1 == 0) goto L1e
                goto L3b
            L3a:
                r0 = r5
            L3b:
                android.bluetooth.BluetoothGattService r0 = (android.bluetooth.BluetoothGattService) r0
                if (r0 == 0) goto L6b
                java.util.List r4 = r0.getCharacteristics()
                if (r4 == 0) goto L6b
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                java.util.Iterator r4 = r4.iterator()
            L4b:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L67
                java.lang.Object r0 = r4.next()
                r1 = r0
                android.bluetooth.BluetoothGattCharacteristic r1 = (android.bluetooth.BluetoothGattCharacteristic) r1
                java.util.UUID r1 = r1.getUuid()
                java.util.UUID r2 = com.animaconnected.bluetooth.heartrate.HeartRateDevice.access$getUUID_HEART_RATE_MEASUREMENT_CHARACTERISTIC$p()
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                if (r1 == 0) goto L4b
                goto L68
            L67:
                r0 = r5
            L68:
                android.bluetooth.BluetoothGattCharacteristic r0 = (android.bluetooth.BluetoothGattCharacteristic) r0
                goto L6c
            L6b:
                r0 = r5
            L6c:
                if (r0 != 0) goto L74
                com.animaconnected.bluetooth.heartrate.HeartRateDevice r4 = com.animaconnected.bluetooth.heartrate.HeartRateDevice.INSTANCE
                r4.inactivate()
                return
            L74:
                android.bluetooth.BluetoothGatt r4 = com.animaconnected.bluetooth.heartrate.HeartRateDevice.access$getGattDevice$p()
                if (r4 == 0) goto L7e
                r1 = 1
                r4.setCharacteristicNotification(r0, r1)
            L7e:
                android.bluetooth.BluetoothGatt r4 = com.animaconnected.bluetooth.heartrate.HeartRateDevice.access$getGattDevice$p()
                if (r4 == 0) goto L97
                java.util.UUID r1 = com.animaconnected.bluetooth.heartrate.HeartRateDevice.access$getCLIENT_CHARACTERISTIC_CONFIG$p()
                android.bluetooth.BluetoothGattDescriptor r0 = r0.getDescriptor(r1)
                if (r0 == 0) goto L94
                byte[] r5 = android.bluetooth.BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
                r0.setValue(r5)
                r5 = r0
            L94:
                r4.writeDescriptor(r5)
            L97:
                com.animaconnected.bluetooth.heartrate.HeartRateDevice r4 = com.animaconnected.bluetooth.heartrate.HeartRateDevice.INSTANCE
                kotlinx.coroutines.flow.MutableStateFlow r4 = r4.getStateFlow()
                com.animaconnected.bluetooth.heartrate.HeartRateDevice$State r5 = com.animaconnected.bluetooth.heartrate.HeartRateDevice.State.Ready
                r4.setValue(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.heartrate.HeartRateDevice$gattCallback$1.onServicesDiscovered(android.bluetooth.BluetoothGatt, int):void");
        }
    };

    /* compiled from: HeartRateDevice.kt */
    /* loaded from: classes.dex */
    public static final class HRValue {
        private final int heartRate;
        private final List<Float> rrValues;
        private final long ts;

        public HRValue(long j, int r4, List<Float> rrValues) {
            Intrinsics.checkNotNullParameter(rrValues, "rrValues");
            this.ts = j;
            this.heartRate = r4;
            this.rrValues = rrValues;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HRValue copy$default(HRValue hRValue, long j, int r3, List list, int r5, Object obj) {
            if ((r5 & 1) != 0) {
                j = hRValue.ts;
            }
            if ((r5 & 2) != 0) {
                r3 = hRValue.heartRate;
            }
            if ((r5 & 4) != 0) {
                list = hRValue.rrValues;
            }
            return hRValue.copy(j, r3, list);
        }

        public final long component1() {
            return this.ts;
        }

        public final int component2() {
            return this.heartRate;
        }

        public final List<Float> component3() {
            return this.rrValues;
        }

        public final HRValue copy(long j, int r4, List<Float> rrValues) {
            Intrinsics.checkNotNullParameter(rrValues, "rrValues");
            return new HRValue(j, r4, rrValues);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HRValue)) {
                return false;
            }
            HRValue hRValue = (HRValue) obj;
            if (this.ts == hRValue.ts && this.heartRate == hRValue.heartRate && Intrinsics.areEqual(this.rrValues, hRValue.rrValues)) {
                return true;
            }
            return false;
        }

        public final int getHeartRate() {
            return this.heartRate;
        }

        public final List<Float> getRrValues() {
            return this.rrValues;
        }

        public final long getTs() {
            return this.ts;
        }

        public int hashCode() {
            return this.rrValues.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.heartRate, Long.hashCode(this.ts) * 31, 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("HRValue(ts=");
            sb.append(this.ts);
            sb.append(", heartRate=");
            sb.append(this.heartRate);
            sb.append(", rrValues=");
            return LocaleList$$ExternalSyntheticOutline0.m(sb, this.rrValues, ')');
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: HeartRateDevice.kt */
    /* loaded from: classes.dex */
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State Inactive = new State("Inactive", 0);
        public static final State Connecting = new State("Connecting", 1);
        public static final State DiscoverServices = new State("DiscoverServices", 2);
        public static final State SetNotification = new State("SetNotification", 3);
        public static final State Ready = new State("Ready", 4);
        public static final State Disconnected = new State("Disconnected", 5);

        private static final /* synthetic */ State[] $values() {
            return new State[]{Inactive, Connecting, DiscoverServices, SetNotification, Ready, Disconnected};
        }

        static {
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private State(String str, int r2) {
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    private HeartRateDevice() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void close() {
        BluetoothGatt bluetoothGatt = gattDevice;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
        }
        gattDevice = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connect() {
        BluetoothGatt bluetoothGatt;
        MutableStateFlow<BluetoothDevice> mutableStateFlow = deviceFlow;
        if (mutableStateFlow.getValue() == null) {
            return;
        }
        stateFlow.setValue(State.Connecting);
        BluetoothDevice value = mutableStateFlow.getValue();
        if (value != null) {
            bluetoothGatt = value.connectGatt(ConnectionFactory.getContext(), false, gattCallback);
        } else {
            bluetoothGatt = null;
        }
        gattDevice = bluetoothGatt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectionListener$lambda$0(boolean z) {
        if (z) {
            INSTANCE.connect();
        } else {
            stateFlow.setValue(State.Disconnected);
            INSTANCE.close();
        }
    }

    public final MutableStateFlow<BluetoothDevice> getDeviceFlow() {
        return deviceFlow;
    }

    public final MutableStateFlow<Integer> getHeartrateFlow() {
        return heartrateFlow;
    }

    public final ReferenceDeviceListener getListener() {
        return listener;
    }

    public final MutableStateFlow<State> getStateFlow() {
        return stateFlow;
    }

    public final void inactivate() {
        close();
        listener = null;
        ConnectionFactory.getConnection().removeConnectionListener(connectionListener);
        deviceFlow.setValue(null);
        stateFlow.setValue(State.Inactive);
    }

    public final void setHearRateReferenceDevice(BluetoothDevice device, ReferenceDeviceListener listener2) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(listener2, "listener");
        listener = listener2;
        ConnectionFactory.getConnection().addConnectionListener(connectionListener);
        deviceFlow.setValue(device);
        connect();
    }

    public final void setListener(ReferenceDeviceListener referenceDeviceListener) {
        listener = referenceDeviceListener;
    }
}
