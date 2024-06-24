package com.animaconnected.watch;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.animaconnected.bluetooth.device.DeviceFotaListener;
import com.animaconnected.bluetooth.dfu.BaseDfuController;
import com.animaconnected.bluetooth.dfu.BaseFotaController;
import com.animaconnected.bluetooth.dfu.DfuProgressListener;
import com.animaconnected.bluetooth.dfu.FotaProgressListener;
import com.animaconnected.bluetooth.gatt.DeviceListener;
import com.animaconnected.bluetooth.gatt.GattDevice;
import com.animaconnected.bluetooth.gatt.GattId;
import com.animaconnected.bluetooth.gatt.OnboardingConnectionListener;
import com.animaconnected.bluetooth.gatt.ReadCallback;
import com.animaconnected.bluetooth.profile.InputDeviceConnector;
import com.animaconnected.bluetooth.util.Callback;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureUtils;
import com.animaconnected.future.Promise;
import com.animaconnected.info.ByteUtils;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.DeviceInterface;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.DeviceConnectionListener;
import com.animaconnected.watch.device.DeviceDfuListener;
import com.animaconnected.watch.device.DeviceInfo;
import com.animaconnected.watch.device.EventHandler;
import com.animaconnected.watch.device.FirmwareUpdate;
import com.animaconnected.watch.device.WatchBackend;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: BtDevice.kt */
/* loaded from: classes3.dex */
public final class BtDevice implements DeviceInterface, WatchBackend {
    private static final String CACHE_KEY_EXPECT_FIRMWARE_UPDATE = "kronaby_app_expect_firmware_update";
    private static final String CACHE_KEY_FIRMWARE_UPDATE = "kronaby_app_firmware_update";
    private final BasicStorage cache;
    private final DeviceConnectionListener connectionListener;
    private final Context context;
    private boolean deviceConnected;
    private EventHandler deviceEventHandler;
    private DeviceInformation deviceInformation;
    private final DeviceListener deviceListener;
    private final Set<DeviceDfuListener> dfuListeners;
    private Promise<Void> dfuPromise;
    private final Handler finishDfuDelayHandler;
    private DeviceInterface.FirmwareInfoListener firmwareInfoListener;
    private BaseFotaController fotaController;
    private final Set<DeviceFotaListener> fotaListeners;
    private final GattDevice gattDevice;
    private boolean isDebugEnabled;
    private boolean isFotaSlowModeEnabled;
    private boolean isInDfuMode;
    private boolean isInUpdateRequired;
    private boolean isReady;
    private boolean isRunningDFU;
    private List<Byte> lastPagesInfo;
    private CoroutineScope scope;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "BtDevice";

    /* compiled from: BtDevice.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BtDevice create(Context context, GattDevice gattDevice, DeviceConnectionListener connectionListener, BasicStorage cache) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(gattDevice, "gattDevice");
            Intrinsics.checkNotNullParameter(connectionListener, "connectionListener");
            Intrinsics.checkNotNullParameter(cache, "cache");
            return new BtDevice(context, gattDevice, connectionListener, cache, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ BtDevice(Context context, GattDevice gattDevice, DeviceConnectionListener deviceConnectionListener, BasicStorage basicStorage, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, gattDevice, deviceConnectionListener, basicStorage);
    }

    private final void cancelDfu() {
        Promise<Void> promise = this.dfuPromise;
        if (promise != null) {
            promise.reject(new RuntimeException("Operation canceled"));
        }
        finishDfu();
    }

    private final void connectInputDeviceIfNeeded() {
        BluetoothDevice device = ConnectionFactory.getConnection().device(this.gattDevice.getAddress());
        if (device != null) {
            InputDeviceConnector.getInstance().doConnectIfNeeded(device, this.context);
        }
    }

    private final void enterDfuMode() {
        if (this.deviceConnected) {
            Log.d(TAG, "Entering DFU mode");
            this.isInDfuMode = true;
            this.connectionListener.onEnterDfuMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|7|(1:(1:(1:(3:12|13|14)(2:16|17))(5:18|19|20|21|(2:23|24)(4:25|26|13|14)))(4:34|35|36|37))(7:67|68|69|70|71|72|(1:74)(1:75))|38|39|(3:44|45|(1:47)(3:48|21|(0)(0)))(5:41|42|43|13|14)))|83|6|7|(0)(0)|38|39|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ed, code lost:            r0 = th;     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ee, code lost:            r6 = r15;     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0047, code lost:            r0 = th;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b A[Catch: all -> 0x0047, Exception -> 0x004a, TRY_LEAVE, TryCatch #3 {Exception -> 0x004a, blocks: (B:20:0x0043, B:21:0x0095, B:23:0x009b, B:30:0x00b3), top: B:19:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5 A[Catch: all -> 0x00ed, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x00ed, blocks: (B:39:0x0070, B:45:0x007f, B:41:0x00d5), top: B:38:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.animaconnected.watch.BtDevice, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object establishConnection(boolean r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.BtDevice.establishConnection(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void finishDfu() {
        if (this.isRunningDFU) {
            this.isRunningDFU = false;
            this.dfuPromise = null;
            if (!this.gattDevice.isConnected()) {
                this.finishDfuDelayHandler.postDelayed(new Runnable() { // from class: com.animaconnected.watch.BtDevice$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        BtDevice.finishDfu$lambda$0(BtDevice.this);
                    }
                }, 7000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void finishDfu$lambda$0(BtDevice this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gattDevice.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getDeviceInformation(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.BtDevice$getDeviceInformation$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.BtDevice$getDeviceInformation$1 r0 = (com.animaconnected.watch.BtDevice$getDeviceInformation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.BtDevice$getDeviceInformation$1 r0 = new com.animaconnected.watch.BtDevice$getDeviceInformation$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.BtDevice r0 = (com.animaconnected.watch.BtDevice) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L4a
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L33:
            kotlin.ResultKt.throwOnFailure(r9)
            com.animaconnected.watch.DeviceInformation$Companion r9 = com.animaconnected.watch.DeviceInformation.Companion
            com.animaconnected.bluetooth.gatt.GattDevice r2 = r8.gattDevice
            com.animaconnected.future.Future r9 = r9.readFromService(r2)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = com.animaconnected.future.FutureCoroutineKt.getSuspending(r9, r0)
            if (r9 != r1) goto L49
            return r1
        L49:
            r0 = r8
        L4a:
            com.animaconnected.watch.DeviceInformation r9 = (com.animaconnected.watch.DeviceInformation) r9
            com.animaconnected.watch.device.BasicStorage r1 = r0.cache
            java.lang.String r2 = "kronaby_app_expect_firmware_update"
            java.lang.Boolean r1 = r1.getBoolean(r2)
            if (r1 == 0) goto L5b
            boolean r1 = r1.booleanValue()
            goto L5c
        L5b:
            r1 = 0
        L5c:
            com.animaconnected.watch.DeviceInformation r2 = r0.deviceInformation
            r3 = 0
            if (r2 == 0) goto L66
            java.lang.String r2 = r2.getFirmwareRevision()
            goto L67
        L66:
            r2 = r3
        L67:
            java.lang.String r4 = r9.getFirmwareRevision()
            if (r1 != 0) goto L73
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r2)
            if (r5 != 0) goto La9
        L73:
            java.lang.String r5 = com.animaconnected.watch.BtDevice.TAG
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "onConnected() "
            r6.<init>(r7)
            r6.append(r2)
            java.lang.String r7 = " -> "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r7 = ". Expected firmware update: "
            r6.append(r7)
            r6.append(r1)
            java.lang.String r7 = ". Clearing all caches."
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r5, r6)
            r0.deviceInformation = r3
            com.animaconnected.watch.device.BasicStorage r3 = r0.cache
            r3.clear()
            com.animaconnected.watch.DeviceInterface$FirmwareInfoListener r3 = r0.firmwareInfoListener
            if (r3 == 0) goto La9
            r3.onFirmwareChanged(r2, r4, r1)
        La9:
            r0.getFirmwareUpdate()
            com.animaconnected.watch.device.BasicStorage r1 = r0.cache
            r9.writeToCache(r1)
            r0.deviceInformation = r9
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.BtDevice.getDeviceInformation(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyFotaError(String str) {
        Iterator<T> it = this.fotaListeners.iterator();
        while (it.hasNext()) {
            ((DeviceFotaListener) it.next()).onFotaError(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyPerformFotaCompleted() {
        Iterator<T> it = this.fotaListeners.iterator();
        while (it.hasNext()) {
            ((DeviceFotaListener) it.next()).onPerformFotaCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyPerformFotaError(byte b) {
        Iterator<T> it = this.fotaListeners.iterator();
        while (it.hasNext()) {
            ((DeviceFotaListener) it.next()).onPerformFotaError(b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyReadyToPerformFota() {
        Iterator<T> it = this.fotaListeners.iterator();
        while (it.hasNext()) {
            ((DeviceFotaListener) it.next()).onReadyToPerformFota();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDfuError(Throwable th) {
        Promise<Void> promise = this.dfuPromise;
        if (promise != null) {
            promise.reject(th);
        }
        finishDfu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDfuProgress(int r3) {
        Iterator<T> it = this.dfuListeners.iterator();
        while (it.hasNext()) {
            ((DeviceDfuListener) it.next()).onDfuProgress(r3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDfuSuccess() {
        Log.d(TAG, "DFU successful.");
        this.cache.put(CACHE_KEY_EXPECT_FIRMWARE_UPDATE, true);
        Promise<Void> promise = this.dfuPromise;
        if (promise != null) {
            promise.resolve(null);
        }
        finishDfu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFotaProgress(List<Byte> list) {
        Iterator<T> it = this.fotaListeners.iterator();
        while (it.hasNext()) {
            ((DeviceFotaListener) it.next()).onFotaProgress(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object writeReadSuspending(GattDevice gattDevice, UUID r3, UUID r4, final byte[] bArr, Continuation<? super byte[]> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        gattDevice.writeRead(r3, r4, bArr, new ReadCallback() { // from class: com.animaconnected.watch.BtDevice$writeReadSuspending$2$1
            @Override // com.animaconnected.bluetooth.gatt.ReadCallback
            public void onError(Throwable th) {
                safeContinuation.resumeWith(ResultKt.createFailure(new IOException("writeRead error [" + ByteUtils.toHex(bArr) + ']', th)));
            }

            @Override // com.animaconnected.bluetooth.gatt.ReadCallback
            public void onSuccess(byte[] bArr2) {
                safeContinuation.resumeWith(bArr2);
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object writeSuspending(GattDevice gattDevice, UUID r3, UUID r4, final byte[] bArr, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        gattDevice.write(r3, r4, bArr, new Callback<Void>() { // from class: com.animaconnected.watch.BtDevice$writeSuspending$2$1
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                safeContinuation.resumeWith(ResultKt.createFailure(new IOException("write error [" + ByteUtils.toHex(bArr) + ']', th)));
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r2) {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void cancelFota() {
        BaseFotaController baseFotaController = this.fotaController;
        if (baseFotaController != null) {
            baseFotaController.cancelFota();
        }
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void changeAddress(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.gattDevice.changeAddress(address);
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void close() {
        if (this.isReady) {
            this.isReady = false;
            this.connectionListener.onDisconnected();
        }
        if (isInUpdateRequired()) {
            this.isInUpdateRequired = false;
            this.connectionListener.onLeaveUpdateRequired();
        }
        if (isInDfuMode()) {
            this.isInDfuMode = false;
            this.connectionListener.onLeaveDfuMode();
        }
        this.gattDevice.unregisterListener(this.deviceListener);
        cancelDfu();
        this.gattDevice.disconnect();
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void connect() {
        this.gattDevice.connect();
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public Object debugFakeConnect(Continuation<? super Unit> continuation) {
        Object fakeConnect = this.gattDevice.fakeConnect(continuation);
        if (fakeConnect == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return fakeConnect;
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public Object debugScan(Continuation<? super Unit> continuation) {
        GattDevice gattDevice = this.gattDevice;
        Object scan = gattDevice.scan(gattDevice.getAddress(), continuation);
        if (scan == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return scan;
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public String getAddress() {
        return this.gattDevice.getAddress();
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public boolean getDebugMode() {
        return this.isDebugEnabled;
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public Map<DeviceInfo, String> getDeviceInfo() {
        Map<DeviceInfo, String> legacyInformation;
        DeviceInformation deviceInformation = this.deviceInformation;
        if (deviceInformation == null || (legacyInformation = deviceInformation.getLegacyInformation(this.gattDevice.getAddress())) == null) {
            return EmptyMap.INSTANCE;
        }
        return legacyInformation;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public Future<Map<DeviceInfo, String>> getDeviceInformationCached() {
        Future<Map<DeviceInfo, String>> future;
        DeviceInformation deviceInformation = this.deviceInformation;
        if (deviceInformation != null) {
            future = FutureUtils.just(deviceInformation.getLegacyInformation(this.gattDevice.getAddress()));
        } else {
            future = null;
        }
        if (future == null) {
            Future<Map<DeviceInfo, String>> error = FutureUtils.error(new IllegalStateException("Device not onboarded."));
            Intrinsics.checkNotNullExpressionValue(error, "error(...)");
            return error;
        }
        return future;
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public String getDeviceName() {
        return null;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public DeviceType getDeviceType() {
        return this.gattDevice.getDeviceType();
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public String getFirmwareRevisionCached() {
        DeviceInformation deviceInformation = this.deviceInformation;
        if (deviceInformation != null) {
            return deviceInformation.getFirmwareRevision();
        }
        return null;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public FirmwareUpdate getFirmwareUpdate() {
        FirmwareUpdate firmwareUpdate;
        if (this.gattDevice.isConnected()) {
            GattDevice gattDevice = this.gattDevice;
            UUID NORDIC_DEVICE_FIRMWARE_UPDATE_SDK8 = GattId.Service.NORDIC_DEVICE_FIRMWARE_UPDATE_SDK8;
            Intrinsics.checkNotNullExpressionValue(NORDIC_DEVICE_FIRMWARE_UPDATE_SDK8, "NORDIC_DEVICE_FIRMWARE_UPDATE_SDK8");
            if (gattDevice.hasGattService(NORDIC_DEVICE_FIRMWARE_UPDATE_SDK8)) {
                firmwareUpdate = FirmwareUpdate.DFU;
            } else {
                GattDevice gattDevice2 = this.gattDevice;
                UUID NORDIC_DEVICE_FIRMWARE_UPDATE_SDK15 = GattId.Service.NORDIC_DEVICE_FIRMWARE_UPDATE_SDK15;
                Intrinsics.checkNotNullExpressionValue(NORDIC_DEVICE_FIRMWARE_UPDATE_SDK15, "NORDIC_DEVICE_FIRMWARE_UPDATE_SDK15");
                if (gattDevice2.hasGattService(NORDIC_DEVICE_FIRMWARE_UPDATE_SDK15)) {
                    firmwareUpdate = FirmwareUpdate.DFU15;
                } else {
                    GattDevice gattDevice3 = this.gattDevice;
                    UUID FOTA = GattId.Service.FOTA;
                    Intrinsics.checkNotNullExpressionValue(FOTA, "FOTA");
                    if (gattDevice3.hasGattService(FOTA)) {
                        firmwareUpdate = FirmwareUpdate.FOTA;
                    } else {
                        firmwareUpdate = FirmwareUpdate.NONE;
                    }
                }
            }
            this.cache.put(CACHE_KEY_FIRMWARE_UPDATE, firmwareUpdate.name());
            return firmwareUpdate;
        }
        return FirmwareUpdate.NONE;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public FirmwareUpdate getFirmwareUpdateCached() {
        String string = this.cache.getString(CACHE_KEY_FIRMWARE_UPDATE);
        if (string == null) {
            return FirmwareUpdate.NONE;
        }
        try {
            return FirmwareUpdate.valueOf(string);
        } catch (IllegalArgumentException unused) {
            return FirmwareUpdate.NONE;
        }
    }

    @Override // com.animaconnected.watch.DeviceInterface, com.animaconnected.watch.device.WatchBackend
    public FirmwareVariant getFirmwareVariant() {
        return this.gattDevice.getFirmwareVariant();
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public String getIdentifier() {
        return this.gattDevice.getAddress();
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public List<Byte> getLastPagesInfo() {
        return this.lastPagesInfo;
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public DeviceType getWatchType() {
        return this.gattDevice.getDeviceType();
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public boolean isBonded() {
        return this.gattDevice.isBonded();
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public boolean isConnected() {
        return this.isReady;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public boolean isConnecting() {
        if (this.deviceConnected && !this.isReady && !isInDfuMode()) {
            return true;
        }
        return false;
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
        if (this.fotaController != null) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void onConnectionIntervalChange(int r2) {
        BaseFotaController baseFotaController = this.fotaController;
        if (baseFotaController != null) {
            baseFotaController.onConnIntChange(r2);
        }
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public void onEventHandlerReady(EventHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.deviceEventHandler = handler;
        if (getWatchType().getHasDisplay()) {
            GattDevice gattDevice = this.gattDevice;
            UUID ANIMA = GattId.Service.ANIMA;
            Intrinsics.checkNotNullExpressionValue(ANIMA, "ANIMA");
            UUID ANIMA_NOTIFY = GattId.Characteristic.ANIMA_NOTIFY;
            Intrinsics.checkNotNullExpressionValue(ANIMA_NOTIFY, "ANIMA_NOTIFY");
            byte[] ENABLE_NOTIFICATION_AND_INDICATION_VALUE = GattId.Notify.ENABLE_NOTIFICATION_AND_INDICATION_VALUE;
            Intrinsics.checkNotNullExpressionValue(ENABLE_NOTIFICATION_AND_INDICATION_VALUE, "ENABLE_NOTIFICATION_AND_INDICATION_VALUE");
            gattDevice.setNotification(ANIMA, ANIMA_NOTIFY, ENABLE_NOTIFICATION_AND_INDICATION_VALUE);
            return;
        }
        GattDevice gattDevice2 = this.gattDevice;
        UUID ANIMA2 = GattId.Service.ANIMA;
        Intrinsics.checkNotNullExpressionValue(ANIMA2, "ANIMA");
        UUID ANIMA_NOTIFY2 = GattId.Characteristic.ANIMA_NOTIFY;
        Intrinsics.checkNotNullExpressionValue(ANIMA_NOTIFY2, "ANIMA_NOTIFY");
        GattDevice.setNotification$default(gattDevice2, ANIMA2, ANIMA_NOTIFY2, null, 4, null);
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void onResume() {
        this.gattDevice.onResume();
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void performFota() {
        if (this.fotaController != null) {
            this.cache.put(CACHE_KEY_EXPECT_FIRMWARE_UPDATE, true);
            BaseFotaController baseFotaController = this.fotaController;
            Intrinsics.checkNotNull(baseFotaController);
            baseFotaController.performFota();
        }
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public Object read(byte[] bArr, Continuation<? super byte[]> continuation) {
        GattDevice gattDevice = this.gattDevice;
        UUID ANIMA = GattId.Service.ANIMA;
        Intrinsics.checkNotNullExpressionValue(ANIMA, "ANIMA");
        if (gattDevice.hasGattService(ANIMA)) {
            GattDevice gattDevice2 = this.gattDevice;
            Intrinsics.checkNotNullExpressionValue(ANIMA, "ANIMA");
            UUID ANIMA_READ_WRITE = GattId.Characteristic.ANIMA_READ_WRITE;
            Intrinsics.checkNotNullExpressionValue(ANIMA_READ_WRITE, "ANIMA_READ_WRITE");
            return writeReadSuspending(gattDevice2, ANIMA, ANIMA_READ_WRITE, bArr, continuation);
        }
        throw new IOException("Anima service not found.");
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void registerDfuListener(DeviceDfuListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dfuListeners.add(listener);
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void registerFotaListener(DeviceFotaListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.fotaListeners.add(listener);
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void registerOnboardingConnectionListener(OnboardingConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.gattDevice.setOnboardingConnectionListener(listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.animaconnected.watch.DeviceInterface
    /* renamed from: removeBond-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo1044removeBondIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r14) {
        /*
            r13 = this;
            java.lang.String r0 = "Removing bonding for "
            boolean r1 = r14 instanceof com.animaconnected.watch.BtDevice$removeBond$1
            if (r1 == 0) goto L15
            r1 = r14
            com.animaconnected.watch.BtDevice$removeBond$1 r1 = (com.animaconnected.watch.BtDevice$removeBond$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.animaconnected.watch.BtDevice$removeBond$1 r1 = new com.animaconnected.watch.BtDevice$removeBond$1
            r1.<init>(r13, r14)
        L1a:
            java.lang.Object r14 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            java.lang.String r4 = "TAG"
            r5 = 1
            if (r3 == 0) goto L39
            if (r3 != r5) goto L31
            java.lang.Object r0 = r1.L$0
            com.animaconnected.watch.BtDevice r0 = (com.animaconnected.watch.BtDevice) r0
            kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Exception -> L2f
            goto L6b
        L2f:
            r14 = move-exception
            goto L70
        L31:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L39:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6e
            r14.<init>(r0)     // Catch: java.lang.Exception -> L6e
            java.lang.String r0 = r13.getAddress()     // Catch: java.lang.Exception -> L6e
            r14.append(r0)     // Catch: java.lang.Exception -> L6e
            java.lang.String r7 = r14.toString()     // Catch: java.lang.Exception -> L6e
            java.lang.String r8 = com.animaconnected.watch.BtDevice.TAG     // Catch: java.lang.Exception -> L6e
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r4)     // Catch: java.lang.Exception -> L6e
            r9 = 0
            r10 = 1
            r11 = 4
            r12 = 0
            r6 = r13
            com.animaconnected.logger.LogKt.debug$default(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L6e
            com.animaconnected.bluetooth.gatt.GattDevice r14 = r13.gattDevice     // Catch: java.lang.Exception -> L6e
            com.animaconnected.future.Future r14 = r14.removeBond()     // Catch: java.lang.Exception -> L6e
            r1.L$0 = r13     // Catch: java.lang.Exception -> L6e
            r1.label = r5     // Catch: java.lang.Exception -> L6e
            java.lang.Object r14 = com.animaconnected.future.FutureCoroutineKt.getSuspending(r14, r1)     // Catch: java.lang.Exception -> L6e
            if (r14 != r2) goto L6a
            return r2
        L6a:
            r0 = r13
        L6b:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L2f
            goto L7e
        L6e:
            r14 = move-exception
            r0 = r13
        L70:
            java.lang.String r1 = com.animaconnected.watch.BtDevice.TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            java.lang.String r2 = "Removing bond failed"
            com.animaconnected.logger.LogKt.debug(r0, r2, r1, r14, r5)
            kotlin.Result$Failure r14 = kotlin.ResultKt.createFailure(r14)
        L7e:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.BtDevice.mo1044removeBondIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void setDebugMode(boolean z) {
        this.isDebugEnabled = z;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void setFirmwareInfoListener(DeviceInterface.FirmwareInfoListener firmwareInfoListener) {
        Intrinsics.checkNotNullParameter(firmwareInfoListener, "firmwareInfoListener");
        this.firmwareInfoListener = firmwareInfoListener;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void setFotaSlowMode(boolean z) {
        this.isFotaSlowModeEnabled = z;
        BaseFotaController baseFotaController = this.fotaController;
        if (baseFotaController != null) {
            baseFotaController.setFotaSlowMode(z);
        }
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public Future<Void> startDfu(BaseDfuController dfu, Uri firmware) {
        Intrinsics.checkNotNullParameter(dfu, "dfu");
        Intrinsics.checkNotNullParameter(firmware, "firmware");
        if (this.isRunningDFU) {
            Future<Void> error = FutureUtils.error(new InvalidParameterException("Already running a DFU"));
            Intrinsics.checkNotNullExpressionValue(error, "error(...)");
            return error;
        }
        Promise<Void> promise = new Promise<>();
        this.dfuPromise = promise;
        this.isRunningDFU = true;
        dfu.start(this.gattDevice, firmware, new DfuProgressListener() { // from class: com.animaconnected.watch.BtDevice$startDfu$1
            @Override // com.animaconnected.bluetooth.dfu.DfuProgressListener
            public void onError(Throwable error2) {
                Intrinsics.checkNotNullParameter(error2, "error");
                BtDevice.this.onDfuError(error2);
            }

            @Override // com.animaconnected.bluetooth.dfu.DfuProgressListener
            public void onProgressChanged(int r2) {
                BtDevice.this.onDfuProgress(r2);
            }

            @Override // com.animaconnected.bluetooth.dfu.DfuProgressListener
            public void onSuccess() {
                BtDevice.this.onDfuSuccess();
            }
        });
        Future<Void> future = promise.getFuture();
        Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
        return future;
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void startFota(BaseFotaController fota, Uri firmware, boolean z) {
        Intrinsics.checkNotNullParameter(fota, "fota");
        Intrinsics.checkNotNullParameter(firmware, "firmware");
        if (this.fotaController == null) {
            this.fotaController = fota;
            fota.start(this.gattDevice, firmware, z, new FotaProgressListener() { // from class: com.animaconnected.watch.BtDevice$startFota$1
                @Override // com.animaconnected.bluetooth.dfu.FotaProgressListener
                public void onClosing() {
                    BtDevice.this.fotaController = null;
                }

                @Override // com.animaconnected.bluetooth.dfu.FotaProgressListener
                public void onError(String error) {
                    String str;
                    Intrinsics.checkNotNullParameter(error, "error");
                    String concat = "Fota error: ".concat(error);
                    str = BtDevice.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    LogKt.debug$default((Object) this, concat, str, (Throwable) null, true, 4, (Object) null);
                    BtDevice.this.notifyFotaError(error);
                }

                @Override // com.animaconnected.bluetooth.dfu.FotaProgressListener
                public void onPerformFotaCompleted() {
                    BtDevice.this.notifyPerformFotaCompleted();
                }

                @Override // com.animaconnected.bluetooth.dfu.FotaProgressListener
                public void onPerformFotaError(byte b) {
                    String str;
                    BasicStorage basicStorage;
                    String m = SubMenuBuilder$$ExternalSyntheticOutline0.m("Perform fota error: ", b);
                    str = BtDevice.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    LogKt.debug$default((Object) this, m, str, (Throwable) null, true, 4, (Object) null);
                    basicStorage = BtDevice.this.cache;
                    basicStorage.put("kronaby_app_expect_firmware_update", false);
                    BtDevice.this.notifyPerformFotaError(b);
                }

                @Override // com.animaconnected.bluetooth.dfu.FotaProgressListener
                public void onProgressChanged(List<Byte> pages) {
                    Intrinsics.checkNotNullParameter(pages, "pages");
                    BtDevice.this.lastPagesInfo = pages;
                    BtDevice.this.onFotaProgress(pages);
                }

                @Override // com.animaconnected.bluetooth.dfu.FotaProgressListener
                public void onReadyToPerformFota() {
                    BtDevice.this.notifyReadyToPerformFota();
                }
            });
            BaseFotaController baseFotaController = this.fotaController;
            Intrinsics.checkNotNull(baseFotaController);
            baseFotaController.setFotaSlowMode(isFotaSlowModeEnabled());
            return;
        }
        Log.d(TAG, "Fota already running");
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void unregisterDfuListener(DeviceDfuListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dfuListeners.remove(listener);
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void unregisterFotaListener(DeviceFotaListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.fotaListeners.remove(listener);
    }

    @Override // com.animaconnected.watch.DeviceInterface
    public void unregisterOnboardingConnectionListener(OnboardingConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.gattDevice.removeOnboardingConnectionListener(listener);
    }

    @Override // com.animaconnected.watch.device.WatchBackend
    public Object write(byte[] bArr, Continuation<? super Unit> continuation) {
        GattDevice gattDevice = this.gattDevice;
        UUID ANIMA = GattId.Service.ANIMA;
        Intrinsics.checkNotNullExpressionValue(ANIMA, "ANIMA");
        if (gattDevice.hasGattService(ANIMA)) {
            GattDevice gattDevice2 = this.gattDevice;
            Intrinsics.checkNotNullExpressionValue(ANIMA, "ANIMA");
            UUID ANIMA_READ_WRITE = GattId.Characteristic.ANIMA_READ_WRITE;
            Intrinsics.checkNotNullExpressionValue(ANIMA_READ_WRITE, "ANIMA_READ_WRITE");
            Object writeSuspending = writeSuspending(gattDevice2, ANIMA, ANIMA_READ_WRITE, bArr, continuation);
            if (writeSuspending == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return writeSuspending;
            }
            return Unit.INSTANCE;
        }
        throw new IOException("Anima service not found.");
    }

    private BtDevice(Context context, GattDevice gattDevice, DeviceConnectionListener deviceConnectionListener, BasicStorage basicStorage) {
        this.context = context;
        this.gattDevice = gattDevice;
        this.connectionListener = deviceConnectionListener;
        this.cache = basicStorage;
        this.finishDfuDelayHandler = new Handler(Looper.getMainLooper());
        this.dfuListeners = new CopyOnWriteArraySet();
        this.fotaListeners = new CopyOnWriteArraySet();
        this.deviceInformation = DeviceInformation.Companion.readFromCache(basicStorage);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        this.scope = CoroutineScopeKt.CoroutineScope(MainDispatcherLoader.dispatcher.plus(SupervisorKt.SupervisorJob$default()));
        DeviceListener deviceListener = new DeviceListener() { // from class: com.animaconnected.watch.BtDevice$deviceListener$1
            /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:            r1 = r0.this$0.deviceEventHandler;     */
            @Override // com.animaconnected.bluetooth.gatt.DeviceListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onCharacteristicChanged(java.util.UUID r1, java.util.UUID r2, byte[] r3) {
                /*
                    r0 = this;
                    java.lang.String r2 = "service"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                    java.util.UUID r2 = com.animaconnected.bluetooth.gatt.GattId.Service.ANIMA
                    boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                    if (r1 != 0) goto Le
                    return
                Le:
                    if (r3 != 0) goto L11
                    return
                L11:
                    com.animaconnected.watch.BtDevice r1 = com.animaconnected.watch.BtDevice.this
                    com.animaconnected.watch.device.EventHandler r1 = com.animaconnected.watch.BtDevice.access$getDeviceEventHandler$p(r1)
                    if (r1 == 0) goto L1c
                    r1.handleEvent(r3)
                L1c:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.BtDevice$deviceListener$1.onCharacteristicChanged(java.util.UUID, java.util.UUID, byte[]):void");
            }

            @Override // com.animaconnected.bluetooth.gatt.DeviceListener
            public void onConnected() {
                DeviceConnectionListener deviceConnectionListener2;
                CoroutineScope coroutineScope;
                BtDevice.this.deviceConnected = true;
                deviceConnectionListener2 = BtDevice.this.connectionListener;
                deviceConnectionListener2.onConnecting();
                BtDevice btDevice = BtDevice.this;
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                btDevice.scope = CoroutineScopeKt.CoroutineScope(MainDispatcherLoader.dispatcher.plus(SupervisorKt.SupervisorJob$default()));
                coroutineScope = BtDevice.this.scope;
                BuildersKt.launch$default(coroutineScope, null, null, new BtDevice$deviceListener$1$onConnected$1(BtDevice.this, null), 3);
            }

            @Override // com.animaconnected.bluetooth.gatt.DeviceListener
            public void onDisconnected() {
                CoroutineScope coroutineScope;
                boolean z;
                DeviceConnectionListener deviceConnectionListener2;
                DeviceConnectionListener deviceConnectionListener3;
                DeviceConnectionListener deviceConnectionListener4;
                DeviceConnectionListener deviceConnectionListener5;
                coroutineScope = BtDevice.this.scope;
                CoroutineScopeKt.cancel(coroutineScope, ExceptionsKt.CancellationException("Watch disconnected", null));
                BtDevice.this.deviceConnected = false;
                z = BtDevice.this.isReady;
                if (z) {
                    BtDevice.this.isReady = false;
                    deviceConnectionListener5 = BtDevice.this.connectionListener;
                    deviceConnectionListener5.onDisconnected();
                } else if (BtDevice.this.isInUpdateRequired()) {
                    BtDevice.this.isInUpdateRequired = false;
                    deviceConnectionListener4 = BtDevice.this.connectionListener;
                    deviceConnectionListener4.onLeaveUpdateRequired();
                } else if (BtDevice.this.isInDfuMode()) {
                    BtDevice.this.isInDfuMode = false;
                    deviceConnectionListener3 = BtDevice.this.connectionListener;
                    deviceConnectionListener3.onLeaveDfuMode();
                } else {
                    deviceConnectionListener2 = BtDevice.this.connectionListener;
                    deviceConnectionListener2.onDisconnected();
                }
            }
        };
        this.deviceListener = deviceListener;
        gattDevice.registerListener(deviceListener);
    }
}
