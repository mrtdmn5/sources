package com.animaconnected.watch.device;

import com.animaconnected.info.ByteUtils;
import com.animaconnected.msgpack.MsgPack;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Command.kt */
/* loaded from: classes3.dex */
public final class Command {
    public static final String ACTION_APP = "action_app";
    public static final String ALARM = "alarm";
    public static final String ALERT = "alert";
    public static final String ALERT_ASSIGN = "alert_assign";
    public static final String ANCS_FILTER = "ancs_filter";
    public static final String BATTERY = "bat";
    public static final int BAT_NOTIFY_STATE_CHARGING = 1;
    public static final int BAT_NOTIFY_STATE_PERCENTAGE = 0;
    public static final String BUTTON = "button";
    public static final String CALL = "call";
    public static final String CAPABILITIES = "cap";
    public static final String COMPLICATIONS = "complications";
    public static final String COMP_BTN = "comp_btn";
    public static final String COMP_DEF = "comp_def";
    public static final String CONFIG_BASE = "config_base";
    public static final String CONFIG_DEBUG = "config_debug";
    public static final String CONNECTION_INT_CHANGE = "conn_int_change";
    public static final String CRASH = "crash";
    public static final String CSEM_LOGS = "csem_log_data";
    public static final String CSEM_SPEED_CALIB = "csem_speed_calib";
    public static final Companion Companion = new Companion(null);
    public static final String DATETIME = "datetime";
    public static final String DEBUG_APPERROR = "debug_apperror";
    public static final String DEBUG_DISCONNECTED = "debug_disconnect";
    public static final String DEBUG_HARDFAULT = "debug_hardfault";
    public static final String DEBUG_RSSI = "debug_rssi";
    public static final String DEMO_MODE = "demo_mode";
    public static final String DFU_READY = "dfu_ready";
    public static final String DIAGNOSTICS_EVENT = "diag_event";
    public static final String DIRECTORY = "mkdir";
    public static final String DISPLAY_COLOR = "disp_color";
    public static final String DND = "dnd";
    public static final String DUMP_UART = "dump_uart";
    public static final String ENTERBATTERY_SIM = "enterBattery_sim";
    public static final String ERROR = "error";
    public static final String FASTMODE = "fastmode";
    public static final String FILE = "file";
    public static final String FILE_REMOVE = "rm";
    public static final String FITNESS_CONFIG = "fitness_config";
    public static final String FITNESS_CURRENT_METRICS = "fitness_current_metrics";
    public static final String FITNESS_HEARTRATE_LIVE = "fitness_heartrate_live";
    public static final String FITNESS_TARGETS = "fitness_targets";
    public static final String FORGET_DEVICE = "forget_device";
    public static final String FORMAT = "format";
    public static final String HISTORY = "history";
    public static final String HISTORY_CLEAR = "history_clear";
    public static final String LS = "ls";
    public static final String MEDIA = "media";
    public static final String MEDIA_VOL = "media_vol";
    public static final String NEW_NOTIF = "new_notif";
    public static final String NOTIFICATION_SYNC = "notification_sync";
    public static final String ONBOARDING_DONE = "onboarding_done";
    public static final String PICTURE = "picture";
    public static final String POSTMORTEM = "postmortem";
    public static final String RECALIBRATE = "recalibrate";
    public static final String RECALIBRATE_HAND = "recalibrate_hand";
    public static final String RECALIBRATE_MOVE = "recalibrate_move";
    public static final String REMOTE_DATA = "remote_data";
    public static final String REMOTE_DATA_CONFIG = "remote_data_config";
    public static final String REMOVE_NOTIF = "remove_notif";
    public static final String RSSI = "rssi";
    public static final String SESSION_DATA = "fitness_session_data";
    public static final String SESSION_DATA_FEED = "fitness_session_feed";
    public static final String SETTINGS = "settings";
    public static final String SET_COMPLICATION_MODE = "set_complication_mode";
    public static final String SHOW_VIEW = "show_view";
    public static final String SLEEP_DAY = "sleep_day";
    public static final String SPEED_READ = "speed_read";
    public static final String STATUS_BUILDINFO = "status_buildinfo";
    public static final String STATUS_BUILDINFO_BL = "status_buildinfo_bl";
    public static final String STATUS_CRASH = "status_crash";
    public static final String STATUS_DIAG = "status_diag";
    public static final String STEPPER_EXEC_PREDEF = "stepper_exec_predef";
    public static final String STEPPER_GOTO = "stepper_goto";
    public static final String STEPS_DAY = "steps_day";
    public static final String STEPS_NOW = "steps_now";
    public static final String STEPS_TARGET = "steps_target";
    public static final String STILLNESS = "stillness";
    public static final String STOPWATCH = "stopwatch";
    public static final String SYNC_DONE = "sync_done";
    public static final String TEST_COIL = "test_coil";
    public static final String TEST_FCTE = "test_fcte";
    public static final String TIMEZONE = "timezone";
    public static final String TRIGGERS = "triggers";
    public static final String UIM_ACTION = "uim_action";
    public static final String VBAT_SIM = "vbat_sim";
    public static final String VIBRATOR_CONFIG = "vibrator_config";
    public static final String VIBRATOR_END = "vibrator_end";
    public static final String VIBRATOR_START = "vibrator_start";
    private final byte[] msgpackAsBytes;
    private final String name;
    private final MsgPack value;

    /* compiled from: Command.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Command(String name, MsgPack value, byte[] msgpackAsBytes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(msgpackAsBytes, "msgpackAsBytes");
        this.name = name;
        this.value = value;
        this.msgpackAsBytes = msgpackAsBytes;
    }

    public final byte[] getMsgpackAsBytes$watch_release() {
        return this.msgpackAsBytes;
    }

    public final String toString(boolean z) {
        if (z) {
            return "cmd: \"" + this.name + "\" as msgpack " + this.value + " as bytes: [" + ByteUtils.toHex(this.msgpackAsBytes) + ']';
        }
        return "cmd: \"" + this.name + "\" as msgpack " + this.value;
    }
}
