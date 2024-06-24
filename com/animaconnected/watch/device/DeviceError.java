package com.animaconnected.watch.device;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceError.kt */
/* loaded from: classes3.dex */
public final class DeviceError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeviceError[] $VALUES;
    public static final Companion Companion;
    private final int errorCode;
    public static final DeviceError NO_ERROR = new DeviceError("NO_ERROR", 0, 0);
    public static final DeviceError WRONG_NUMBER_OF_ARGS = new DeviceError("WRONG_NUMBER_OF_ARGS", 1, 1);
    public static final DeviceError INVALID_ARGUMENT = new DeviceError("INVALID_ARGUMENT", 2, 2);
    public static final DeviceError FAULTY_MSGPACK_FORMAT = new DeviceError("FAULTY_MSGPACK_FORMAT", 3, 3);
    public static final DeviceError TEMPORARILY_OUT_OF_MEM_TRY_AGAIN = new DeviceError("TEMPORARILY_OUT_OF_MEM_TRY_AGAIN", 4, 4);
    public static final DeviceError BATTERY_CRITICAL = new DeviceError("BATTERY_CRITICAL", 5, 5);
    public static final DeviceError BATTERY_WARNING = new DeviceError("BATTERY_WARNING", 6, 6);
    public static final DeviceError BUFFER_TOO_SMALL = new DeviceError("BUFFER_TOO_SMALL", 7, 7);
    public static final DeviceError STACK_OVERFLOW = new DeviceError("STACK_OVERFLOW", 8, 8);
    public static final DeviceError VIBRATOR_TEMP_OUT_OF_RANGE = new DeviceError("VIBRATOR_TEMP_OUT_OF_RANGE", 9, 9);
    public static final DeviceError UNKNOWN_TESTCASE = new DeviceError("UNKNOWN_TESTCASE", 10, 10);
    public static final DeviceError ON_STARTUP = new DeviceError("ON_STARTUP", 11, 11);
    public static final DeviceError ANCS_FILTER_OVERFLOW = new DeviceError("ANCS_FILTER_OVERFLOW", 12, 12);
    public static final DeviceError DISPLAY_PARTIAL_LINE_RECEIVED = new DeviceError("DISPLAY_PARTIAL_LINE_RECEIVED", 13, 13);
    public static final DeviceError DISPLAY_TOO_MUCH_DATA = new DeviceError("DISPLAY_TOO_MUCH_DATA", 14, 14);
    public static final DeviceError DISPLAY_FEED_NOT_STARTED = new DeviceError("DISPLAY_FEED_NOT_STARTED", 15, 15);
    public static final DeviceError DISPLAY_TRANSFER_ONGOING = new DeviceError("DISPLAY_TRANSFER_ONGOING", 16, 16);
    public static final DeviceError CALIBRATION_TIMEOUT = new DeviceError("CALIBRATION_TIMEOUT", 17, 17);
    public static final DeviceError CALIBRATION_INVALID_STATE = new DeviceError("CALIBRATION_INVALID_STATE", 18, 18);
    public static final DeviceError POSTMORTEM_FLASH_FAILED = new DeviceError("POSTMORTEM_FLASH_FAILED", 19, 19);
    public static final DeviceError INTERNAL = new DeviceError("INTERNAL", 20, 20);
    public static final DeviceError POSTMORTEM_INVALID_STATE = new DeviceError("POSTMORTEM_INVALID_STATE", 21, 21);
    public static final DeviceError BATTERY_OK = new DeviceError("BATTERY_OK", 22, 22);
    public static final DeviceError UNHANDLED_COMMAND = new DeviceError("UNHANDLED_COMMAND", 23, 23);

    /* compiled from: DeviceError.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DeviceError fromErrorCode(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = DeviceError.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((DeviceError) obj).getErrorCode() == r4) {
                        z = true;
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
            return (DeviceError) obj;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ DeviceError[] $values() {
        return new DeviceError[]{NO_ERROR, WRONG_NUMBER_OF_ARGS, INVALID_ARGUMENT, FAULTY_MSGPACK_FORMAT, TEMPORARILY_OUT_OF_MEM_TRY_AGAIN, BATTERY_CRITICAL, BATTERY_WARNING, BUFFER_TOO_SMALL, STACK_OVERFLOW, VIBRATOR_TEMP_OUT_OF_RANGE, UNKNOWN_TESTCASE, ON_STARTUP, ANCS_FILTER_OVERFLOW, DISPLAY_PARTIAL_LINE_RECEIVED, DISPLAY_TOO_MUCH_DATA, DISPLAY_FEED_NOT_STARTED, DISPLAY_TRANSFER_ONGOING, CALIBRATION_TIMEOUT, CALIBRATION_INVALID_STATE, POSTMORTEM_FLASH_FAILED, INTERNAL, POSTMORTEM_INVALID_STATE, BATTERY_OK, UNHANDLED_COMMAND};
    }

    static {
        DeviceError[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private DeviceError(String str, int r2, int r3) {
        this.errorCode = r3;
    }

    public static EnumEntries<DeviceError> getEntries() {
        return $ENTRIES;
    }

    public static DeviceError valueOf(String str) {
        return (DeviceError) Enum.valueOf(DeviceError.class, str);
    }

    public static DeviceError[] values() {
        return (DeviceError[]) $VALUES.clone();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
