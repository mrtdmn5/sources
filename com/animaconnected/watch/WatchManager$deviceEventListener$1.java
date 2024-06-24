package com.animaconnected.watch;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.msgpack.MsgPack;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.device.AppAction;
import com.animaconnected.watch.device.Button;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.device.DeviceError;
import com.animaconnected.watch.device.FileResult;
import com.animaconnected.watch.device.FullWatchEventListener;
import com.animaconnected.watch.device.WatchEventListener;
import com.animaconnected.watch.device.WatchListener;
import com.animaconnected.watch.device.files.WatchFileSystem;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.VisibilityState;
import com.animaconnected.watch.display.WatchApp;
import com.animaconnected.watch.fitness.FitnessMetric;
import com.animaconnected.watch.fitness.HeartrateValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.UInt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.datetime.Instant;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: WatchManager.kt */
/* loaded from: classes3.dex */
public final class WatchManager$deviceEventListener$1 implements FullWatchEventListener {
    private WatchApp currentApp;
    final /* synthetic */ WatchManager this$0;

    public WatchManager$deviceEventListener$1(WatchManager watchManager) {
        this.this$0 = watchManager;
    }

    public final WatchApp getCurrentApp() {
        return this.currentApp;
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onAlarm(int r3) {
        Set set;
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onAlarm(r3);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onAlert(int r9, int r10, int r11, int r12, int r13) {
        Set set;
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onAlert(r9, r10, r11, r12, r13);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    @Override // com.animaconnected.watch.device.InternalEvents
    public void onAppAction(final AppId appId, final int r16, final AppAction action) {
        DisplayWatch displayWatch;
        WatchApp watchApp;
        boolean z;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(action, "action");
        Watch currentWatch = this.this$0.getCurrentWatch();
        if (currentWatch instanceof DisplayWatch) {
            displayWatch = (DisplayWatch) currentWatch;
        } else {
            displayWatch = null;
        }
        if (displayWatch == null) {
            return;
        }
        Iterator it = displayWatch.getApps$watch_release().iterator();
        while (true) {
            if (it.hasNext()) {
                watchApp = it.next();
                if (((WatchApp) watchApp).getId() == appId) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            } else {
                watchApp = 0;
                break;
            }
        }
        WatchApp watchApp2 = watchApp;
        if (watchApp2 == null) {
            WatchApp watchApp3 = this.currentApp;
            if (watchApp3 != null) {
                watchApp3.onStateChanged(VisibilityState.Stopped);
            }
            setCurrentApp(null);
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$deviceEventListener$1$onAppAction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "App action " + AppAction.this + " (id " + AppAction.this + ") for unknown app: " + appId;
                }
            }, 7, (Object) null);
            return;
        }
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$deviceEventListener$1$onAppAction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder("App action ");
                sb.append(AppAction.this);
                sb.append(" for appId ");
                sb.append(appId);
                sb.append(" (displayId: ");
                return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, r16, ')');
            }
        }, 7, (Object) null);
        ServiceLocator.INSTANCE.getAnalytics().getAppEvents().displayAppAction(watchApp2.getAnalyticsName(), r16, action.name());
        if (action == AppAction.AppStart && !Intrinsics.areEqual(watchApp2, this.currentApp)) {
            WatchApp watchApp4 = this.currentApp;
            if (watchApp4 != null) {
                watchApp4.onStateChanged(VisibilityState.Stopped);
            }
            setCurrentApp(watchApp2);
            if (appId != AppId.Workout && !watchApp2.getCheckPermissions().invoke().booleanValue()) {
                BuildersKt.launch$default(displayWatch.getScope(), null, null, new WatchManager$deviceEventListener$1$onAppAction$3(displayWatch, watchApp2, null), 3);
                return;
            } else if (watchApp2.getCheckSetupNeeded().invoke().booleanValue()) {
                BuildersKt.launch$default(displayWatch.getScope(), null, null, new WatchManager$deviceEventListener$1$onAppAction$4(displayWatch, watchApp2, null), 3);
                return;
            } else {
                watchApp2.onStateChanged(VisibilityState.Glanceable);
                watchApp2.onAppAction(r16, action);
                return;
            }
        }
        watchApp2.onAppAction(r16, action);
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onBatteryCharger(boolean z) {
        Set set;
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onBatteryCharger(z);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onBatteryPercent(float f) {
        Set set;
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onBatteryPercent(f);
        }
    }

    @Override // com.animaconnected.watch.device.BehaviourListener
    public void onBehaviourSet(Slot slot, Behaviour behaviour) {
        Set set;
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(behaviour, "behaviour");
        set = this.this$0.eventListeners;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (obj instanceof WatchListener) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((WatchListener) it.next()).onBehaviourSet(slot, behaviour);
        }
    }

    @Override // com.animaconnected.watch.device.BehaviourListener
    public void onButtonClicked(Slot slot, Behaviour behaviour, ButtonAction action, boolean z) {
        Set set;
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(action, "action");
        set = this.this$0.eventListeners;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (obj instanceof WatchListener) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((WatchListener) it.next()).onButtonClicked(slot, behaviour, action, z);
        }
    }

    @Override // com.animaconnected.watch.device.InternalEvents
    public void onCSEMLog(MsgPack msgPack) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(msgPack, "msgPack");
        coroutineScope = this.this$0.scope;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        BuildersKt.launch$default(coroutineScope, MainDispatcherLoader.dispatcher, null, new WatchManager$deviceEventListener$1$onCSEMLog$1(this.this$0, msgPack, null), 2);
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onConnIntChange(int r3, int r4, int r5) {
        Set set;
        this.this$0.getCurrentWatch().setConnectionInterval$watch_release(r3);
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onConnIntChange(r3, r4, r5);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onDeviceButtonClicked(Button button, ButtonAction action) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(action, "action");
        Watch currentWatch = this.this$0.getCurrentWatch();
        if (currentWatch instanceof DisplayWatch) {
            this.this$0.handleDisplayWatchButton(button, (DisplayWatch) currentWatch, action);
        } else if (currentWatch instanceof HybridWatch) {
            coroutineScope = this.this$0.scope;
            BuildersKt.launch$default(coroutineScope, null, null, new WatchManager$deviceEventListener$1$onDeviceButtonClicked$1(this.this$0, button, action, null), 3);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onDeviceCrash(int r5) {
        Set set;
        CoroutineScope coroutineScope;
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onDeviceCrash(r5);
        }
        coroutineScope = this.this$0.scope;
        BuildersKt.launch$default(coroutineScope, null, null, new WatchManager$deviceEventListener$1$onDeviceCrash$2(this.this$0, r5, null), 3);
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onDeviceError(DeviceError deviceError) {
        Set set;
        Intrinsics.checkNotNullParameter(deviceError, "deviceError");
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onDeviceError(deviceError);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onDevicePostMortem() {
        Set set;
        CoroutineScope coroutineScope;
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onDevicePostMortem();
        }
        coroutineScope = this.this$0.scope;
        BuildersKt.launch$default(coroutineScope, null, null, new WatchManager$deviceEventListener$1$onDevicePostMortem$2(this.this$0, null), 3);
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onDiagEvent(Map<String, String> diagEvent) {
        Set set;
        Intrinsics.checkNotNullParameter(diagEvent, "diagEvent");
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onDiagEvent(diagEvent);
        }
    }

    @Override // com.animaconnected.watch.device.InternalEvents
    /* renamed from: onFileChanged-kosIJfI, reason: not valid java name */
    public void mo1048onFileChangedkosIJfI(int r10, Integer num, UInt uInt) {
        DisplayWatch displayWatch;
        CoroutineScope coroutineScope;
        Watch currentWatch = this.this$0.getCurrentWatch();
        if (currentWatch instanceof DisplayWatch) {
            displayWatch = (DisplayWatch) currentWatch;
        } else {
            displayWatch = null;
        }
        if (displayWatch != null && num != null && uInt != null) {
            coroutineScope = this.this$0.scope;
            BuildersKt.launch$default(coroutineScope, null, null, new WatchManager$deviceEventListener$1$onFileChanged$1(displayWatch, r10, num, uInt, null), 3);
        }
    }

    @Override // com.animaconnected.watch.device.InternalEvents
    /* renamed from: onFileDeleteResult-Qn1smSk, reason: not valid java name */
    public void mo1049onFileDeleteResultQn1smSk(FileResult result, int r4) {
        DisplayWatch displayWatch;
        WatchFileSystem fs;
        Intrinsics.checkNotNullParameter(result, "result");
        Watch currentWatch = this.this$0.getCurrentWatch();
        if (currentWatch instanceof DisplayWatch) {
            displayWatch = (DisplayWatch) currentWatch;
        } else {
            displayWatch = null;
        }
        if (displayWatch != null && (fs = displayWatch.getFs()) != null) {
            fs.m1109onFileDeleteResultQn1smSk$watch_release(result, r4);
        }
    }

    @Override // com.animaconnected.watch.device.InternalEvents
    /* renamed from: onFileWriteResult-miZAcA0, reason: not valid java name */
    public void mo1050onFileWriteResultmiZAcA0(FileResult result, int r4, Integer num, UInt uInt) {
        DisplayWatch displayWatch;
        WatchFileSystem fs;
        Intrinsics.checkNotNullParameter(result, "result");
        Watch currentWatch = this.this$0.getCurrentWatch();
        if (currentWatch instanceof DisplayWatch) {
            displayWatch = (DisplayWatch) currentWatch;
        } else {
            displayWatch = null;
        }
        if (displayWatch != null && (fs = displayWatch.getFs()) != null) {
            fs.m1110onFileResultmiZAcA0$watch_release(result, r4, num, uInt);
        }
    }

    @Override // com.animaconnected.watch.device.InternalEvents
    public void onHeartrateLiveData(HeartrateValue heartrateValue) {
        Intrinsics.checkNotNullParameter(heartrateValue, "heartrateValue");
        WatchManager watchManager = this.this$0;
        watchManager.internal$watch_release(watchManager.getFitnessProvider()).updateHeartrateLiveData(heartrateValue);
    }

    @Override // com.animaconnected.watch.device.InternalEvents
    public void onNewFitnessData() {
        CoroutineScope coroutineScope;
        LogKt.verbose$default((Object) this, "FitnessData", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$deviceEventListener$1$onNewFitnessData$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Fitness notification received";
            }
        }, 6, (Object) null);
        if (this.this$0.getEnabledNewDataNotification()) {
            coroutineScope = this.this$0.scope;
            BuildersKt.launch$default(coroutineScope, null, null, new WatchManager$deviceEventListener$1$onNewFitnessData$2(this.this$0, null), 3);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onNotificationDismissed(int r3) {
        Set set;
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onNotificationDismissed(r3);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onPressDuringCall(int r3) {
        Set set;
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onPressDuringCall(r3);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onRssiEvent(int r3) {
        Set set;
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onRssiEvent(r3);
        }
    }

    @Override // com.animaconnected.watch.device.InternalEvents
    public void onSessionData(final Map<FitnessMetric, Integer> data) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(data, "data");
        LogKt.verbose$default((Object) this, "FitnessData", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$deviceEventListener$1$onSessionData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Received: " + data;
            }
        }, 6, (Object) null);
        coroutineScope = this.this$0.scope;
        BuildersKt.launch$default(coroutineScope, null, null, new WatchManager$deviceEventListener$1$onSessionData$2(this.this$0, data, null), 3);
    }

    @Override // com.animaconnected.watch.device.InternalEvents
    public void onSpeedCalibrationFailed() {
        WatchManager watchManager = this.this$0;
        watchManager.internalSessionProvider$watch_release(watchManager.getFitnessProvider()).abortSpeedCalibration();
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onStepsNow(int r10, int r11, int r12, final int r13) {
        Set set;
        Instant.Companion.getClass();
        Instant instant = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
        TimeZone.Companion.getClass();
        final int dayOfMonth = TimeZoneKt.toLocalDateTime(instant, TimeZone.Companion.currentSystemDefault()).getDayOfMonth();
        if (r13 == dayOfMonth) {
            WatchManager watchManager = this.this$0;
            watchManager.internal$watch_release(watchManager.getFitnessProvider()).onHybridSteps(r10, r13);
            set = this.this$0.eventListeners;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                ((WatchEventListener) it.next()).onStepsNow(r10, r11, r12, r13);
            }
            return;
        }
        LogKt.warn$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$deviceEventListener$1$onStepsNow$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Steps notification with the wrong day: " + r13 + " instead of " + dayOfMonth;
            }
        }, 7, (Object) null);
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onStillnessEvent(int r3) {
        Set set;
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onStillnessEvent(r3);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onStopwatchDataChanged() {
        Set set;
        set = this.this$0.eventListeners;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((WatchEventListener) it.next()).onStopwatchDataChanged();
        }
    }

    public final void setCurrentApp(WatchApp watchApp) {
        this.currentApp = watchApp;
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$deviceEventListener$1$currentApp$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                WatchApp watchApp2;
                StringBuilder sb = new StringBuilder("Current app is now ");
                watchApp2 = WatchManager$deviceEventListener$1.this.currentApp;
                sb.append(watchApp2 != null ? watchApp2.getId() : null);
                return sb.toString();
            }
        }, 7, (Object) null);
    }
}
