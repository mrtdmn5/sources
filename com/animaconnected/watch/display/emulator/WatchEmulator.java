package com.animaconnected.watch.display.emulator;

import androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda2;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import com.animaconnected.msgpack.MsgPack;
import com.animaconnected.msgpack.MsgPackKotlin;
import com.animaconnected.watch.SyncFlags;
import com.animaconnected.watch.device.Button;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.device.CallState;
import com.animaconnected.watch.device.CrashInfo;
import com.animaconnected.watch.device.DfuStatus;
import com.animaconnected.watch.device.DfuUiState;
import com.animaconnected.watch.device.FileResult;
import com.animaconnected.watch.device.FullWatchEventListener;
import com.animaconnected.watch.device.HybridAlarm;
import com.animaconnected.watch.device.InternalEvents;
import com.animaconnected.watch.device.Vibration;
import com.animaconnected.watch.device.WatchFace;
import com.animaconnected.watch.device.WatchIO;
import com.animaconnected.watch.device.WatchIODebug;
import com.animaconnected.watch.device.WatchTime;
import com.animaconnected.watch.device.files.WatchFileKt;
import com.animaconnected.watch.display.Dashboard;
import com.animaconnected.watch.display.DrawCommand;
import com.animaconnected.watch.display.ImageCommand;
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
import com.animaconnected.watch.utils.WatchLibResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntProgression;

/* compiled from: WatchEmulator.kt */
/* loaded from: classes3.dex */
public final class WatchEmulator implements WatchIO, WatchButtons, WatchIODebug {
    private final HashMap<Integer, EmuAppConfig> apps;
    private int currentApp;
    private int dashboardId;
    private FullWatchEventListener deviceEventListener;
    private String deviceName;
    private final HashMap<String, byte[]> fileData;
    private final List<String> filesToReadOnConnect;
    private boolean isDebugEnabled;

    /* compiled from: WatchEmulator.kt */
    /* loaded from: classes3.dex */
    public static final class EmuAppConfig {
        private final List<DrawCommand> drawCommands;
        private final int id;

        /* JADX WARN: Multi-variable type inference failed */
        public EmuAppConfig(int r2, List<? extends DrawCommand> drawCommands) {
            Intrinsics.checkNotNullParameter(drawCommands, "drawCommands");
            this.id = r2;
            this.drawCommands = drawCommands;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EmuAppConfig copy$default(EmuAppConfig emuAppConfig, int r1, List list, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                r1 = emuAppConfig.id;
            }
            if ((r3 & 2) != 0) {
                list = emuAppConfig.drawCommands;
            }
            return emuAppConfig.copy(r1, list);
        }

        public final int component1() {
            return this.id;
        }

        public final List<DrawCommand> component2() {
            return this.drawCommands;
        }

        public final EmuAppConfig copy(int r2, List<? extends DrawCommand> drawCommands) {
            Intrinsics.checkNotNullParameter(drawCommands, "drawCommands");
            return new EmuAppConfig(r2, drawCommands);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EmuAppConfig)) {
                return false;
            }
            EmuAppConfig emuAppConfig = (EmuAppConfig) obj;
            if (this.id == emuAppConfig.id && Intrinsics.areEqual(this.drawCommands, emuAppConfig.drawCommands)) {
                return true;
            }
            return false;
        }

        public final List<DrawCommand> getDrawCommands() {
            return this.drawCommands;
        }

        public final int getId() {
            return this.id;
        }

        public int hashCode() {
            return this.drawCommands.hashCode() + (Integer.hashCode(this.id) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("EmuAppConfig(id=");
            sb.append(this.id);
            sb.append(", drawCommands=");
            return LocaleList$$ExternalSyntheticOutline0.m(sb, this.drawCommands, ')');
        }
    }

    public WatchEmulator() {
        int code = new Dashboard().getId().getCode();
        this.dashboardId = code;
        this.currentApp = code;
        this.apps = new HashMap<>();
        this.fileData = new HashMap<>();
        this.filesToReadOnConnect = EmptyList.INSTANCE;
        this.deviceName = "Debug device";
        this.isDebugEnabled = true;
    }

    private final List<EmulatedDisplay> displays() {
        return new ArrayList();
    }

    private final void drawCurrentScreen() {
        List<DrawCommand> list;
        EmuAppConfig emuAppConfig = this.apps.get(Integer.valueOf(this.currentApp));
        if (emuAppConfig != null) {
            list = emuAppConfig.getDrawCommands();
        } else {
            list = null;
        }
        if (list != null) {
            Iterator<T> it = displays().iterator();
            while (it.hasNext()) {
                ((EmulatedDisplay) it.next()).setDrawCommands(list);
            }
        }
    }

    public final void addDisplay(EmulatedDisplay debugDisplayView) {
        Intrinsics.checkNotNullParameter(debugDisplayView, "debugDisplayView");
        displays().add(debugDisplayView);
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public int calculateFilePartSize(String fullName, int r2, Integer num) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        return Integer.MAX_VALUE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public int calculateMaxReadFileBytes() {
        return Integer.MAX_VALUE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object clearFitnessData(long j, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object deleteFile(String str, Continuation<? super Unit> continuation) {
        FullWatchEventListener fullWatchEventListener = this.deviceEventListener;
        if (fullWatchEventListener != null) {
            InternalEvents.m1068onFileWriteResultmiZAcA0$default(fullWatchEventListener, FileResult.OK, WatchFileKt.dekHash(str), null, null, 12, null);
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object enableCSEMLogs(boolean z, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final FullWatchEventListener getDeviceEventListener$watch_release() {
        return this.deviceEventListener;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public String getDeviceName() {
        return this.deviceName;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public List<String> getFilesToReadOnConnect() {
        return this.filesToReadOnConnect;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object initCommandMap(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public boolean isDebugEnabled() {
        return this.isDebugEnabled;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object parseFitnessMetric(Map<Integer, ? extends MsgPack> map, Continuation<? super Map<FitnessMetric, ? extends MetricValue>> continuation) {
        return EmptyMap.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object prepareDiagnosticsMap(MsgPack msgPack, Continuation<? super Map<String, String>> continuation) {
        return EmptyMap.INSTANCE;
    }

    @Override // com.animaconnected.watch.display.emulator.WatchButtons
    public void pressBottom() {
        FullWatchEventListener fullWatchEventListener = this.deviceEventListener;
        if (fullWatchEventListener != null) {
            fullWatchEventListener.onDeviceButtonClicked(Button.Bottom, ButtonAction.Press);
        }
    }

    @Override // com.animaconnected.watch.display.emulator.WatchButtons
    public void pressCrown() {
        drawCurrentScreen();
        FullWatchEventListener fullWatchEventListener = this.deviceEventListener;
        if (fullWatchEventListener != null) {
            fullWatchEventListener.onDeviceButtonClicked(Button.Crown, ButtonAction.Press);
        }
    }

    @Override // com.animaconnected.watch.display.emulator.WatchButtons
    public void pressTop() {
        FullWatchEventListener fullWatchEventListener = this.deviceEventListener;
        if (fullWatchEventListener != null) {
            fullWatchEventListener.onDeviceButtonClicked(Button.Top, ButtonAction.Press);
        }
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readBuildInfo(Continuation<? super Map<String, String>> continuation) {
        return EmptyMap.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readBuildInfoBl(Continuation<? super Map<String, String>> continuation) {
        return EmptyMap.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object readCSEMLogsHeaders(Continuation<? super List<String>> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readCapabilities(Continuation<? super MsgPack> continuation) {
        return MsgPackKotlin.Companion.newEmpty();
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object readCoil(Continuation<? super List<Integer>> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readCrashStatus(Continuation<? super Pair<String, CrashInfo>> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readCurrentFitnessMetrics(Continuation<? super Map<FitnessMetric, ? extends MetricValue>> continuation) {
        return EmptyMap.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readDebugDisconnect(Continuation<? super List<Integer>> continuation) {
        return EmptyList.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readDfuReady(Continuation<? super DfuStatus> continuation) {
        return DfuStatus.Ready;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readDiagnostics(boolean z, Continuation<? super Map<String, String>> continuation) {
        return Rgb$$ExternalSyntheticLambda2.m("Diagnostics", "0");
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object readDumpUart(WatchIODebug.DumpUartProgressCallback dumpUartProgressCallback, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object readFcte(Continuation<? super List<Integer>> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readFile(String str, int r2, int r3, Continuation<? super byte[]> continuation) {
        return new byte[0];
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readFilesPaged(String str, String str2, Continuation<? super Map<String, WatchIO.FileMeta>> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    /* renamed from: readFitnessData-OZHprlw */
    public Object mo1078readFitnessDataOZHprlw(String str, long j, Continuation<? super List<? extends Entry>> continuation) {
        return EmptyList.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readFitnessDataAmount(long j, Continuation<? super Integer> continuation) {
        return new Integer(0);
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readOnboardingDone(Continuation<? super Boolean> continuation) {
        return Boolean.TRUE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readPostMortemData(Continuation<? super byte[]> continuation) {
        throw new NotImplementedError();
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readRssi(Continuation<? super Integer> continuation) {
        return new Integer(-33);
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readSessionData(Continuation<? super Map<FitnessMetric, Integer>> continuation) {
        return EmptyMap.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readSleep(long j, int r5, Function2<? super Integer, ? super List<Pair<Long, Integer>>, Unit> function2, Continuation<? super Boolean> continuation) {
        if (j < 395200000) {
            j = 395200000;
        }
        while (1000000000 > j) {
            j += (r7.nextFloat() * 4000000) + 60000;
            function2.invoke(new Integer(0), CollectionsKt__CollectionsKt.listOf(new Pair(new Long(j), new Integer((int) (Random.Default.nextFloat() * 3)))));
        }
        return Boolean.TRUE;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    @Override // com.animaconnected.watch.device.WatchIO
    public Object readStepsDay(int r3, Continuation<? super List<Integer>> continuation) {
        IntProgression intProgression = new IntProgression(r3, 0, -1);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(intProgression, 10));
        ?? it = intProgression.iterator();
        while (it.hasNext) {
            arrayList.add(new Integer((it.nextInt() * 1000) + 337));
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readStopwatch(Continuation<? super List<Integer[]>> continuation) {
        return EmptyList.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object readValues(String str, String str2, Continuation<? super WatchLibResult<String, ? extends Exception>> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readWatchTime(boolean z, Continuation<? super WatchTime> continuation) {
        return new WatchTime(1, 2, 3, 4, 5, 6, 7, null, null);
    }

    @Override // com.animaconnected.watch.display.emulator.WatchButtons
    public void scrollDown() {
        FullWatchEventListener fullWatchEventListener = this.deviceEventListener;
        if (fullWatchEventListener != null) {
            fullWatchEventListener.onDeviceButtonClicked(Button.Top, ButtonAction.Press);
        }
    }

    @Override // com.animaconnected.watch.display.emulator.WatchButtons
    public void scrollUp() {
        FullWatchEventListener fullWatchEventListener = this.deviceEventListener;
        if (fullWatchEventListener != null) {
            fullWatchEventListener.onDeviceButtonClicked(Button.Bottom, ButtonAction.Press);
        }
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public void setDebugEnabled(boolean z) {
        this.isDebugEnabled = z;
    }

    public final void setDeviceEventListener$watch_release(FullWatchEventListener fullWatchEventListener) {
        this.deviceEventListener = fullWatchEventListener;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeAlarms(List<HybridAlarm> list, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeAlert(int r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeAlertConfig(int[] r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeAncs(AncsFilter ancsFilter, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeApp(int r1, String str, int r3, int r4, int r5, List<Integer> list, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeBaseConfig(int r1, int r2, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeButtonPressed(Button button, ButtonAction buttonAction, WatchFace watchFace, int r4, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeChangeView(int r1, int r2, int r3, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeColour(int r1, int r2, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeComplication(int r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeComplicationMode(int r1, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeComplicationModes(int r1, int r2, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeComplications(int[] r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeConfigSettings(Map<String, Integer> map, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeConfigVibrator(int[][] r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeCrashHandled(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeDebugAppError(int r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeDebugConfig(boolean z, boolean z2, boolean z3, boolean z4, int r5, boolean z5, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeDebugHardFault(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeDemoMode(int r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeDfuReady(DfuUiState dfuUiState, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeDirectory(String str, Continuation<? super Unit> continuation) {
        FullWatchEventListener fullWatchEventListener = this.deviceEventListener;
        if (fullWatchEventListener != null) {
            InternalEvents.m1068onFileWriteResultmiZAcA0$default(fullWatchEventListener, FileResult.OK, WatchFileKt.dekHash(str), null, null, 12, null);
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeEnterBatterySim(int r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeFastMode(boolean z, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeFilePart(String str, byte[] bArr, int r20, int r21, Integer num, Continuation<? super Unit> continuation) {
        this.fileData.put(str, bArr);
        Iterator<T> it = displays().iterator();
        while (it.hasNext()) {
            ((EmulatedDisplay) it.next()).setDrawCommands(CollectionsKt__CollectionsKt.listOf(new ImageCommand(0, 0, 30, 30, bArr, "hash", null, null, 192, null)));
        }
        FullWatchEventListener fullWatchEventListener = this.deviceEventListener;
        if (fullWatchEventListener != null) {
            InternalEvents.m1068onFileWriteResultmiZAcA0$default(fullWatchEventListener, FileResult.OK, WatchFileKt.dekHash(str), null, null, 12, null);
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeFitnessConfig(FitnessConfig fitnessConfig, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeFitnessRamData(Map<FitnessMetric, Integer> map, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeForgetDevice(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeFormat(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeHealthGoals(HealthGoals healthGoals, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeHeartrateLiveMode(boolean z, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeIncomingCall(int r1, boolean z, Integer num, boolean z2, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    /* renamed from: writeMediaNotification-eH_QyT8 */
    public Object mo1080writeMediaNotificationeH_QyT8(String str, String str2, String str3, int r4, int r5, int r6, int r7, Continuation<? super Result<Unit>> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeMotor(int r1, int r2, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    /* renamed from: writeNotification-hUnOzRk */
    public Object mo1081writeNotificationhUnOzRk(int r1, String str, String str2, String str3, Vibration vibration, Continuation<? super Result<Unit>> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeOnboardingDone(boolean z, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writePicture(int r15, String str, int r17, int r18, byte[] bArr, Continuation<? super Unit> continuation) {
        Iterator<T> it = displays().iterator();
        while (it.hasNext()) {
            ((EmulatedDisplay) it.next()).setDrawCommands(CollectionsKt__CollectionsKt.listOf(new ImageCommand(0, 0, r17, r18, bArr, "hash", null, null, 192, null)));
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeQuietHours(boolean z, int r2, int r3, int r4, int r5, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeRecalibrate(boolean z, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeRecalibrateHand(WatchFace watchFace, int r2, int r3, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeRecalibrateMove(WatchFace watchFace, int r2, int r3, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeRemoteDataConfigs(int[][] r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeRemoteDatas(int[][] r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeRemoveNotification(int r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeRequestAppState(int r4, VisibilityState visibilityState, Continuation<? super Boolean> continuation) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (visibilityState == VisibilityState.Stopped) {
            this.currentApp = this.dashboardId;
            drawCurrentScreen();
        } else {
            HashMap<Integer, EmuAppConfig> hashMap = this.apps;
            if (!hashMap.isEmpty()) {
                Iterator<Map.Entry<Integer, EmuAppConfig>> it = hashMap.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getKey().intValue() == r4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (z2 && (visibilityState == VisibilityState.Glanceable || visibilityState == VisibilityState.Persistent)) {
                this.currentApp = r4;
                drawCurrentScreen();
            } else {
                z3 = false;
            }
        }
        return Boolean.valueOf(z3);
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeSessionDataFeed(GpsQuality gpsQuality, Distance distance, Float f, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeSpeedCalibration(SpeedCalibration speedCalibration, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeSpeedRead(int r1, int r2, String str, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeStartVibratorWithBuiltinTestPattern(Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeStartVibratorWithPattern(int[] r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeStepperExecPredef(int r1, int r2, int r3, int r4, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeStepsDay(int r1, int r2, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeStepsTarget(int r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeStillness(int r1, int r2, int r3, int r4, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeStopVibrator(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeSyncDone(Set<? extends SyncFlags> set, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeTimeZone(int r1, int r2, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeTriggers(int r1, int r2, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeValues(String str, String str2, Continuation<? super WatchLibResult<Boolean, ? extends Exception>> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeVbatSim(int r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeVolume(int r1, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeWatchTime(WatchTime watchTime, boolean z, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeComplicationMode(int r1, int r2, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeComplicationModes(int r1, int r2, int r3, int r4, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeDebugConfig(List<Integer> list, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeIncomingCall(int r1, CallState callState, String str, boolean z, boolean z2, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeComplicationMode(int[] r1, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeComplicationModes(int r1, int r2, int r3, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeDebugConfig(boolean z, boolean z2, boolean z3, boolean z4, int r5, int r6, boolean z5, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeComplicationModes(int[] r1, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeComplicationModes(int r1, int r2, int r3, int r4, int r5, int r6, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
