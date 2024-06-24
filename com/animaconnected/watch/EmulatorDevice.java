package com.animaconnected.watch;

import android.net.Uri;
import com.animaconnected.bluetooth.device.DeviceFotaListener;
import com.animaconnected.bluetooth.dfu.BaseDfuController;
import com.animaconnected.bluetooth.dfu.BaseFotaController;
import com.animaconnected.bluetooth.gatt.OnboardingConnectionListener;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureUtils;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.EmulatorInfo;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.watch.DeviceInterface;
import com.animaconnected.watch.device.DeviceConnectionListener;
import com.animaconnected.watch.device.DeviceDfuListener;
import com.animaconnected.watch.device.DeviceInfo;
import com.animaconnected.watch.device.EventHandler;
import com.animaconnected.watch.device.FirmwareUpdate;
import com.animaconnected.watch.device.WatchBackend;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: EmulatorDevice.kt */
/* loaded from: classes3.dex */
public final class EmulatorDevice implements DeviceInterface, WatchBackend {
    public static final int $stable = 8;
    private boolean connected;
    private final DeviceConnectionListener connectionListener;
    private final EmulatorInfo emulatorInfo;
    private EventHandler handler;
    private final String identifier;
    private final boolean isBonded;
    private final boolean isConnecting;
    private final boolean isFotaSlowModeEnabled;
    private final boolean isInDfuMode;
    private final boolean isInUpdateRequired;
    private final boolean isRunningFota;
    private final List<Byte> lastPagesInfo;
    private final DeviceType watchType;

    public EmulatorDevice(EmulatorInfo emulatorInfo, DeviceConnectionListener connectionListener) {
        Intrinsics.checkNotNullParameter(emulatorInfo, "emulatorInfo");
        Intrinsics.checkNotNullParameter(connectionListener, "connectionListener");
        this.emulatorInfo = emulatorInfo;
        this.connectionListener = connectionListener;
        this.isBonded = true;
        this.identifier = emulatorInfo.getAddress();
        this.watchType = emulatorInfo.getDeviceType();
        this.lastPagesInfo = EmptyList.INSTANCE;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void changeAddress(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void close() {
        this.connected = false;
        this.connectionListener.onDisconnected();
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void connect() {
        CoroutineScope scope = KronabyApplication.Companion.getScope();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        BuildersKt.launch$default(scope, MainDispatcherLoader.dispatcher.getImmediate(), null, new EmulatorDevice$connect$1(this, null), 2);
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public Object debugFakeConnect(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public Object debugScan(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public String getAddress() {
        return this.emulatorInfo.getAddress();
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public boolean getDebugMode() {
        return false;
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public Map<DeviceInfo, String> getDeviceInfo() {
        return MapsKt__MapsKt.mapOf(new Pair(DeviceInfo.SerialNumber, this.emulatorInfo.getSerialnumber()), new Pair(DeviceInfo.Address, this.emulatorInfo.getAddress()), new Pair(DeviceInfo.FirmwareRevision, this.emulatorInfo.getFirmwareRevision()), new Pair(DeviceInfo.HardwareRevision, this.emulatorInfo.getHardwareRevision()), new Pair(DeviceInfo.ManufacturerName, this.emulatorInfo.getManufacturerName()), new Pair(DeviceInfo.ModelNumber, this.emulatorInfo.getCoreUnit()));
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public Future<Map<DeviceInfo, String>> getDeviceInformationCached() {
        Future<Map<DeviceInfo, String>> just = FutureUtils.just(getDeviceInfo());
        Intrinsics.checkNotNullExpressionValue(just, "just(...)");
        return just;
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public String getDeviceName() {
        return "emulator";
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public DeviceType getDeviceType() {
        return this.emulatorInfo.getDeviceType();
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public String getFirmwareRevisionCached() {
        return null;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public FirmwareUpdate getFirmwareUpdate() {
        return FirmwareUpdate.FOTA;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public FirmwareUpdate getFirmwareUpdateCached() {
        return FirmwareUpdate.FOTA;
    }

    @Override // com.animaconnected.watch.DeviceInterface, com.animaconnected.watch.device.WatchBackend
    public FirmwareVariant getFirmwareVariant() {
        return new FirmwareVariant(null, 1, null);
    }

    public final EventHandler getHandler() {
        return this.handler;
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public String getIdentifier() {
        return this.identifier;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public List<Byte> getLastPagesInfo() {
        return this.lastPagesInfo;
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public DeviceType getWatchType() {
        return this.watchType;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public boolean isBonded() {
        return this.isBonded;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public boolean isConnected() {
        return this.connected;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public boolean isConnecting() {
        return this.isConnecting;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public boolean isFotaSlowModeEnabled() {
        return this.isFotaSlowModeEnabled;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public boolean isInDfuMode() {
        return this.isInDfuMode;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public boolean isInUpdateRequired() {
        return this.isInUpdateRequired;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public boolean isRunningFota() {
        return this.isRunningFota;
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public void onEventHandlerReady(EventHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public Object read(byte[] bArr, Continuation continuation) {
        return null;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void registerDfuListener(DeviceDfuListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void registerFotaListener(DeviceFotaListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void registerOnboardingConnectionListener(OnboardingConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.animaconnected.watch.DeviceInterface
    /* renamed from: removeBond-IoAF18A */
    public Object mo1044removeBondIoAF18A(Continuation<? super Result<Unit>> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void setFirmwareInfoListener(DeviceInterface.FirmwareInfoListener firmwareInfoListener) {
        Intrinsics.checkNotNullParameter(firmwareInfoListener, "firmwareInfoListener");
    }

    public final void setHandler(EventHandler eventHandler) {
        this.handler = eventHandler;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public Future<Void> startDfu(BaseDfuController dfu, Uri firmware) {
        Intrinsics.checkNotNullParameter(dfu, "dfu");
        Intrinsics.checkNotNullParameter(firmware, "firmware");
        Future<Void> just = FutureUtils.just(null);
        Intrinsics.checkNotNullExpressionValue(just, "just(...)");
        return just;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void startFota(BaseFotaController fota, Uri firmware, boolean z) {
        Intrinsics.checkNotNullParameter(fota, "fota");
        Intrinsics.checkNotNullParameter(firmware, "firmware");
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void unregisterDfuListener(DeviceDfuListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void unregisterFotaListener(DeviceFotaListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void unregisterOnboardingConnectionListener(OnboardingConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public Object write(byte[] bArr, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void cancelFota() {
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void onResume() {
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void performFota() {
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void onConnectionIntervalChange(int r1) {
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void setDebugMode(boolean z) {
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void setFotaSlowMode(boolean z) {
    }
}
