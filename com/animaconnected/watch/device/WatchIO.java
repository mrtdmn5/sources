package com.animaconnected.watch.device;

import com.animaconnected.msgpack.MsgPack;
import com.animaconnected.watch.SyncFlags;
import com.animaconnected.watch.display.VisibilityState;
import com.animaconnected.watch.filter.AncsFilter;
import com.animaconnected.watch.fitness.Distance;
import com.animaconnected.watch.fitness.Entry;
import com.animaconnected.watch.fitness.FitnessConfig;
import com.animaconnected.watch.fitness.FitnessMetric;
import com.animaconnected.watch.fitness.GpsQuality;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.fitness.MetricValue;
import com.animaconnected.watch.fitness.SpeedCalibration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchIO.kt */
/* loaded from: classes3.dex */
public interface WatchIO {
    public static final int CRASH_TYPE_HANDLED = 255;
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int REMOTE_DATA_CONFIG_HOUR_HAND_INDEX = 1;
    public static final int REMOTE_DATA_CONFIG_MINUTE_HAND_INDEX = 2;
    public static final int REMOTE_DATA_CONFIG_TIMEOUT_INDEX = 0;
    public static final int REMOTE_DATA_HOUR_HAND_INDEX = 0;
    public static final int REMOTE_DATA_MINUTE_HAND_INDEX = 1;

    /* compiled from: WatchIO.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final int CRASH_TYPE_HANDLED = 255;
        public static final int REMOTE_DATA_CONFIG_HOUR_HAND_INDEX = 1;
        public static final int REMOTE_DATA_CONFIG_MINUTE_HAND_INDEX = 2;
        public static final int REMOTE_DATA_CONFIG_TIMEOUT_INDEX = 0;
        public static final int REMOTE_DATA_HOUR_HAND_INDEX = 0;
        public static final int REMOTE_DATA_MINUTE_HAND_INDEX = 1;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int[] DEFAULT_REMOTE_DATA = {0, 0};
        private static final int[] DEFAULT_REMOTE_DATA_CONFIG = {10, 0, 0};

        private Companion() {
        }

        public final int[] getDEFAULT_REMOTE_DATA() {
            return DEFAULT_REMOTE_DATA;
        }

        public final int[] getDEFAULT_REMOTE_DATA_CONFIG() {
            return DEFAULT_REMOTE_DATA_CONFIG;
        }
    }

    /* compiled from: WatchIO.kt */
    /* loaded from: classes3.dex */
    public static final class FileMeta {
        private final UInt deckHash;
        private final int size;
        private final Long timestamp;

        public /* synthetic */ FileMeta(int r1, UInt uInt, Long l, DefaultConstructorMarker defaultConstructorMarker) {
            this(r1, uInt, l);
        }

        /* renamed from: copy-SLwFa_Y$default, reason: not valid java name */
        public static /* synthetic */ FileMeta m1094copySLwFa_Y$default(FileMeta fileMeta, int r1, UInt uInt, Long l, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                r1 = fileMeta.size;
            }
            if ((r4 & 2) != 0) {
                uInt = fileMeta.deckHash;
            }
            if ((r4 & 4) != 0) {
                l = fileMeta.timestamp;
            }
            return fileMeta.m1096copySLwFa_Y(r1, uInt, l);
        }

        public final int component1() {
            return this.size;
        }

        /* renamed from: component2-0hXNFcg, reason: not valid java name */
        public final UInt m1095component20hXNFcg() {
            return this.deckHash;
        }

        public final Long component3() {
            return this.timestamp;
        }

        /* renamed from: copy-SLwFa_Y, reason: not valid java name */
        public final FileMeta m1096copySLwFa_Y(int r3, UInt uInt, Long l) {
            return new FileMeta(r3, uInt, l, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FileMeta)) {
                return false;
            }
            FileMeta fileMeta = (FileMeta) obj;
            if (this.size == fileMeta.size && Intrinsics.areEqual(this.deckHash, fileMeta.deckHash) && Intrinsics.areEqual(this.timestamp, fileMeta.timestamp)) {
                return true;
            }
            return false;
        }

        /* renamed from: getDeckHash-0hXNFcg, reason: not valid java name */
        public final UInt m1097getDeckHash0hXNFcg() {
            return this.deckHash;
        }

        public final int getSize() {
            return this.size;
        }

        public final Long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = Integer.hashCode(this.size) * 31;
            UInt uInt = this.deckHash;
            int r2 = 0;
            if (uInt == null) {
                hashCode = 0;
            } else {
                hashCode = Integer.hashCode(uInt.data);
            }
            int r0 = (hashCode2 + hashCode) * 31;
            Long l = this.timestamp;
            if (l != null) {
                r2 = l.hashCode();
            }
            return r0 + r2;
        }

        public String toString() {
            return "FileMeta(size=" + this.size + ", deckHash=" + this.deckHash + ", timestamp=" + this.timestamp + ')';
        }

        private FileMeta(int r1, UInt uInt, Long l) {
            this.size = r1;
            this.deckHash = uInt;
            this.timestamp = l;
        }
    }

    int calculateFilePartSize(String str, int r2, Integer num);

    int calculateMaxReadFileBytes();

    Object clearFitnessData(long j, Continuation<? super Unit> continuation);

    Object deleteFile(String str, Continuation<? super Unit> continuation);

    String getDeviceName();

    List<String> getFilesToReadOnConnect();

    Object initCommandMap(Continuation<? super Unit> continuation);

    Object parseFitnessMetric(Map<Integer, ? extends MsgPack> map, Continuation<? super Map<FitnessMetric, ? extends MetricValue>> continuation);

    Object prepareDiagnosticsMap(MsgPack msgPack, Continuation<? super Map<String, String>> continuation);

    Object readBuildInfo(Continuation<? super Map<String, String>> continuation);

    Object readBuildInfoBl(Continuation<? super Map<String, String>> continuation);

    Object readCapabilities(Continuation<? super MsgPack> continuation);

    Object readCrashStatus(Continuation<? super Pair<String, CrashInfo>> continuation);

    Object readCurrentFitnessMetrics(Continuation<? super Map<FitnessMetric, ? extends MetricValue>> continuation);

    Object readDebugDisconnect(Continuation<? super List<Integer>> continuation);

    Object readDfuReady(Continuation<? super DfuStatus> continuation);

    Object readDiagnostics(boolean z, Continuation<? super Map<String, String>> continuation);

    Object readFile(String str, int r2, int r3, Continuation<? super byte[]> continuation);

    Object readFilesPaged(String str, String str2, Continuation<? super Map<String, FileMeta>> continuation);

    /* renamed from: readFitnessData-OZHprlw */
    Object mo1078readFitnessDataOZHprlw(String str, long j, Continuation<? super List<? extends Entry>> continuation);

    Object readFitnessDataAmount(long j, Continuation<? super Integer> continuation);

    Object readOnboardingDone(Continuation<? super Boolean> continuation);

    Object readPostMortemData(Continuation<? super byte[]> continuation);

    Object readRssi(Continuation<? super Integer> continuation);

    Object readSessionData(Continuation<? super Map<FitnessMetric, Integer>> continuation);

    Object readSleep(long j, int r3, Function2<? super Integer, ? super List<Pair<Long, Integer>>, Unit> function2, Continuation<? super Boolean> continuation);

    Object readStepsDay(int r1, Continuation<? super List<Integer>> continuation);

    Object readStopwatch(Continuation<? super List<Integer[]>> continuation);

    Object readWatchTime(boolean z, Continuation<? super WatchTime> continuation);

    void setDeviceName(String str);

    Object writeAlarms(List<HybridAlarm> list, Continuation<? super Unit> continuation);

    Object writeAlert(int r1, Continuation<? super Unit> continuation);

    Object writeAlertConfig(int[] r1, Continuation<? super Unit> continuation);

    Object writeAncs(AncsFilter ancsFilter, Continuation<? super Unit> continuation);

    Object writeApp(int r1, String str, int r3, int r4, int r5, List<Integer> list, Continuation<? super Unit> continuation);

    Object writeBaseConfig(int r1, int r2, Continuation<? super Unit> continuation);

    Object writeButtonPressed(Button button, ButtonAction buttonAction, WatchFace watchFace, int r4, Continuation<? super Unit> continuation);

    Object writeChangeView(int r1, int r2, int r3, Continuation<? super Unit> continuation);

    Object writeColour(int r1, int r2, Continuation<? super Unit> continuation);

    Object writeComplication(int r1, Continuation<? super Unit> continuation);

    Object writeComplicationModes(int r1, int r2, int r3, int r4, Continuation<? super Unit> continuation);

    Object writeComplicationModes(int r1, int r2, Continuation<? super Unit> continuation);

    Object writeComplications(int[] r1, Continuation<? super Unit> continuation);

    Object writeConfigSettings(Map<String, Integer> map, Continuation<? super Unit> continuation);

    Object writeConfigVibrator(int[][] r1, Continuation<? super Unit> continuation);

    Object writeCrashHandled(Continuation<? super Unit> continuation);

    Object writeDebugConfig(boolean z, boolean z2, boolean z3, boolean z4, int r5, boolean z5, Continuation<? super Unit> continuation);

    Object writeDebugHardFault(Continuation<? super Unit> continuation);

    Object writeDemoMode(int r1, Continuation<? super Unit> continuation);

    Object writeDfuReady(DfuUiState dfuUiState, Continuation<? super Unit> continuation);

    Object writeDirectory(String str, Continuation<? super Unit> continuation);

    Object writeFastMode(boolean z, Continuation<? super Unit> continuation);

    Object writeFilePart(String str, byte[] bArr, int r3, int r4, Integer num, Continuation<? super Unit> continuation);

    Object writeFitnessConfig(FitnessConfig fitnessConfig, Continuation<? super Unit> continuation);

    Object writeFitnessRamData(Map<FitnessMetric, Integer> map, Continuation<? super Unit> continuation);

    Object writeForgetDevice(Continuation<? super Unit> continuation);

    Object writeFormat(Continuation<? super Unit> continuation);

    Object writeHealthGoals(HealthGoals healthGoals, Continuation<? super Unit> continuation);

    Object writeHeartrateLiveMode(boolean z, Continuation<? super Unit> continuation);

    Object writeIncomingCall(int r1, CallState callState, String str, boolean z, boolean z2, Continuation<? super Unit> continuation);

    Object writeIncomingCall(int r1, boolean z, Integer num, boolean z2, Continuation<? super Unit> continuation);

    /* renamed from: writeMediaNotification-eH_QyT8 */
    Object mo1080writeMediaNotificationeH_QyT8(String str, String str2, String str3, int r4, int r5, int r6, int r7, Continuation<? super Result<Unit>> continuation);

    /* renamed from: writeNotification-hUnOzRk */
    Object mo1081writeNotificationhUnOzRk(int r1, String str, String str2, String str3, Vibration vibration, Continuation<? super Result<Unit>> continuation);

    Object writeOnboardingDone(boolean z, Continuation<? super Unit> continuation);

    Object writePicture(int r1, String str, int r3, int r4, byte[] bArr, Continuation<? super Unit> continuation);

    Object writeQuietHours(boolean z, int r2, int r3, int r4, int r5, Continuation<? super Unit> continuation);

    Object writeRecalibrate(boolean z, Continuation<? super Unit> continuation);

    Object writeRecalibrateHand(WatchFace watchFace, int r2, int r3, Continuation<? super Unit> continuation);

    Object writeRecalibrateMove(WatchFace watchFace, int r2, int r3, Continuation<? super Unit> continuation);

    Object writeRemoteDataConfigs(int[][] r1, Continuation<? super Unit> continuation);

    Object writeRemoteDatas(int[][] r1, Continuation<? super Unit> continuation);

    Object writeRemoveNotification(int r1, Continuation<? super Unit> continuation);

    Object writeRequestAppState(int r1, VisibilityState visibilityState, Continuation<? super Boolean> continuation);

    Object writeSessionDataFeed(GpsQuality gpsQuality, Distance distance, Float f, Continuation<? super Unit> continuation);

    Object writeSpeedCalibration(SpeedCalibration speedCalibration, Continuation<? super Unit> continuation);

    Object writeStartVibratorWithPattern(int[] r1, Continuation<? super Unit> continuation);

    Object writeStepsDay(int r1, int r2, Continuation<? super Unit> continuation);

    Object writeStepsTarget(int r1, Continuation<? super Unit> continuation);

    Object writeStillness(int r1, int r2, int r3, int r4, Continuation<? super Unit> continuation);

    Object writeStopVibrator(Continuation<? super Unit> continuation);

    Object writeSyncDone(Set<? extends SyncFlags> set, Continuation<? super Unit> continuation);

    Object writeTimeZone(int r1, int r2, Continuation<? super Unit> continuation);

    Object writeTriggers(int r1, int r2, Continuation<? super Unit> continuation);

    Object writeVolume(int r1, Continuation<? super Unit> continuation);

    Object writeWatchTime(WatchTime watchTime, boolean z, Continuation<? super Unit> continuation);
}
