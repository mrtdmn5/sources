package com.animaconnected.bluetooth.gatt;

import java.util.UUID;

/* loaded from: classes.dex */
public final class GattId {

    /* loaded from: classes.dex */
    public static final class Characteristic {
        public static final UUID FIRMWARE_REVISION = UUID.fromString("00002a26-0000-1000-8000-00805f9b34fb");
        public static final UUID HARDWARE_REVISION = UUID.fromString("00002a27-0000-1000-8000-00805f9b34fb");
        public static final UUID MANUFACTURER_NAME = UUID.fromString("00002a29-0000-1000-8000-00805f9b34fb");
        public static final UUID MODEL_NUMBER = UUID.fromString("00002a24-0000-1000-8000-00805f9b34fb");
        public static final UUID SERIAL_NUMBER = UUID.fromString("00002a25-0000-1000-8000-00805f9b34fb");
        public static final UUID ANIMA_READ_WRITE = UUID.fromString("6e401980-b5a3-f393-e0a9-e6414d494e41");
        public static final UUID ANIMA_NOTIFY = UUID.fromString("6e401981-b5a3-f393-e0a9-e6414d494e41");
    }

    /* loaded from: classes.dex */
    public static final class Company {
        public static final int ANIMA = 719;
        public static final int SOPROD = 1298;
        public static final int FESTINA = 3358;
        public static final int[] ALL = {ANIMA, SOPROD, FESTINA};
    }

    /* loaded from: classes.dex */
    public static final class Descriptor {
        public static final UUID CLIENT_CHARACTERISTIC_CONFIGURATION = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    }

    /* loaded from: classes.dex */
    public static final class Notify {
        public static final byte[] ENABLE_NOTIFICATION_AND_INDICATION_VALUE = {3, 0};
    }

    /* loaded from: classes.dex */
    public static final class Service {
        public static final UUID GENERIC_ACCESS = UUID.fromString("00001800-0000-1000-8000-00805f9b34fb");
        public static final UUID GENERIC_ATTRIBUTE = UUID.fromString("00001801-0000-1000-8000-00805f9b34fb");
        public static final UUID DEVICE_INFORMATION = UUID.fromString("0000180a-0000-1000-8000-00805f9b34fb");
        public static final UUID ANIMA = UUID.fromString("6e406d41-b5a3-f393-e0a9-e6414d494e41");
        public static final UUID FOTA = UUID.fromString("6e400001-b5a3-f393-e043-565341544f46");
        public static final UUID NORDIC_DEVICE_FIRMWARE_UPDATE_SDK8 = UUID.fromString("00001530-1212-efde-1523-785feabcd123");
        public static final UUID NORDIC_DEVICE_FIRMWARE_UPDATE_SDK15 = UUID.fromString("0000fe59-0000-1000-8000-00805f9b34fb");
    }
}
