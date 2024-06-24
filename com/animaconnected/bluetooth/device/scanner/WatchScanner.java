package com.animaconnected.bluetooth.device.scanner;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.animaconnected.bluetooth.device.ClientProvider;
import com.animaconnected.bluetooth.gatt.DeviceScanner;
import com.animaconnected.logger.LogKt;
import com.polidea.rxandroidble2.RxBleClient;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: WatchScanner.kt */
/* loaded from: classes.dex */
public final class WatchScanner {
    private final boolean allowSmarTime;
    private final BrandFilter brandFilter;
    private final Context context;
    private final Set<ScannedDevice> deviceBuffer;
    private final Handler handler;
    private WatchScannerListener listener;
    private final Function0<List<HybridDevice>> onboardedDevices;
    private boolean oneDeviceFound;
    private final long scanTimeout;
    private Job scannerJob;
    private Job scannerTimeoutJob;
    private final CoroutineScope scope;
    private final String tag;

    /* compiled from: WatchScanner.kt */
    /* loaded from: classes.dex */
    public interface WatchScannerListener {
        void onDeviceFound(ScannedDevice scannedDevice);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WatchScanner(Context context, CoroutineScope scope, BrandFilter brandFilter, Function0<? extends List<HybridDevice>> onboardedDevices, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(brandFilter, "brandFilter");
        Intrinsics.checkNotNullParameter(onboardedDevices, "onboardedDevices");
        this.context = context;
        this.scope = scope;
        this.brandFilter = brandFilter;
        this.onboardedDevices = onboardedDevices;
        this.allowSmarTime = z;
        this.tag = "WatchScanner";
        this.deviceBuffer = new LinkedHashSet();
        int r2 = Duration.$r8$clinit;
        this.scanTimeout = DurationKt.toDuration(11, DurationUnit.SECONDS);
        this.handler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDeviceFound(final ScannedDevice scannedDevice) {
        this.handler.post(new Runnable() { // from class: com.animaconnected.bluetooth.device.scanner.WatchScanner$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WatchScanner.onDeviceFound$lambda$0(WatchScanner.this, scannedDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDeviceFound$lambda$0(WatchScanner this$0, ScannedDevice scannedDevice) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WatchScannerListener watchScannerListener = this$0.listener;
        if (watchScannerListener != null) {
            watchScannerListener.onDeviceFound(scannedDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScannedDevice selectDevice() {
        return (ScannedDevice) CollectionsKt___CollectionsKt.minOrNull((Iterable) this.deviceBuffer);
    }

    public final boolean getOneDeviceFound() {
        return this.oneDeviceFound;
    }

    public final void setListener(WatchScannerListener watchScannerListener) {
        this.listener = watchScannerListener;
    }

    public final void startScan() {
        boolean z;
        Job job = this.scannerJob;
        if (job != null && job.isActive()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String tag = this.tag;
            Intrinsics.checkNotNullExpressionValue(tag, "tag");
            LogKt.debug$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.device.scanner.WatchScanner$startScan$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Do not start scanning, it is already on!";
                }
            }, 6, (Object) null);
            return;
        }
        if (!this.deviceBuffer.isEmpty()) {
            final ScannedDevice selectDevice = selectDevice();
            String tag2 = this.tag;
            Intrinsics.checkNotNullExpressionValue(tag2, "tag");
            LogKt.debug$default((Object) this, tag2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.device.scanner.WatchScanner$startScan$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Pick device from buffer: " + ScannedDevice.this;
                }
            }, 6, (Object) null);
            this.deviceBuffer.clear();
            onDeviceFound(selectDevice);
            Job job2 = this.scannerJob;
            if (job2 != null) {
                job2.cancel(null);
            }
            Job job3 = this.scannerTimeoutJob;
            if (job3 != null) {
                job3.cancel(null);
                return;
            }
            return;
        }
        String tag3 = this.tag;
        Intrinsics.checkNotNullExpressionValue(tag3, "tag");
        LogKt.debug$default((Object) this, tag3, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.device.scanner.WatchScanner$startScan$3
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Starting scan";
            }
        }, 6, (Object) null);
        this.oneDeviceFound = false;
        this.deviceBuffer.clear();
        RxBleClient client = ClientProvider.getClient(this.context);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this.scannerJob = FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new WatchScanner$startScan$4(this, null), new DeviceScanner(client, this.brandFilter).scan()), new WatchScanner$startScan$5(this, null)), this.scope);
        this.scannerTimeoutJob = BuildersKt.launch$default(this.scope, null, null, new WatchScanner$startScan$6(this, null), 3);
    }
}
