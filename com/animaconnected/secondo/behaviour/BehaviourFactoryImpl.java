package com.animaconnected.secondo.behaviour;

import android.content.Context;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.behaviour.alarms.AlarmsPlugin;
import com.animaconnected.secondo.behaviour.calibration.HorizontalCalibrationPlugin;
import com.animaconnected.secondo.behaviour.calibration.VerticalCalibrationPlugin;
import com.animaconnected.secondo.behaviour.call.CallsPlugin;
import com.animaconnected.secondo.behaviour.camera.CameraPlugin;
import com.animaconnected.secondo.behaviour.counter.CounterPlugin;
import com.animaconnected.secondo.behaviour.dashboard.DashboardPlugin;
import com.animaconnected.secondo.behaviour.date.DatePlugin;
import com.animaconnected.secondo.behaviour.dayofweek.DayOfWeekPlugin;
import com.animaconnected.secondo.behaviour.dice.DicePlugin;
import com.animaconnected.secondo.behaviour.distress.DistressPlugin;
import com.animaconnected.secondo.behaviour.empty.EmptyPlugin;
import com.animaconnected.secondo.behaviour.findphone.FindPhonePlugin;
import com.animaconnected.secondo.behaviour.habittracker.HabitTrackerPlugin;
import com.animaconnected.secondo.behaviour.ifttt.IftttPlugin;
import com.animaconnected.secondo.behaviour.music.MusicPlugin;
import com.animaconnected.secondo.behaviour.music.MusicWatchAppPlugin;
import com.animaconnected.secondo.behaviour.mutephone.MutePhonePlugin;
import com.animaconnected.secondo.behaviour.notifications.NotificationsPlugin;
import com.animaconnected.secondo.behaviour.phonebattery.PhoneBatteryPlugin;
import com.animaconnected.secondo.behaviour.quickaction.QuickActionPlugin;
import com.animaconnected.secondo.behaviour.rememberthisspot.RememberThisSpotPlugin;
import com.animaconnected.secondo.behaviour.settings.SettingsPlugin;
import com.animaconnected.secondo.behaviour.steps.StepsPlugin;
import com.animaconnected.secondo.behaviour.stoptime.StopTimePlugin;
import com.animaconnected.secondo.behaviour.stopwatch.StopwatchPlugin;
import com.animaconnected.secondo.behaviour.temperature.TemperaturePlugin;
import com.animaconnected.secondo.behaviour.time.TimePlugin;
import com.animaconnected.secondo.behaviour.time.WorldTimePlugin;
import com.animaconnected.secondo.behaviour.timer.TimerPlugin;
import com.animaconnected.secondo.behaviour.watchbattery.WatchBatteryPlugin;
import com.animaconnected.secondo.behaviour.weather.WeatherPlugin;
import com.animaconnected.secondo.behaviour.webhook.WebhookPlugin;
import com.animaconnected.secondo.behaviour.workout.WorkoutPlugin;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.RemoteMessageReceiver;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BehaviourFactoryImpl.kt */
/* loaded from: classes3.dex */
public final class BehaviourFactoryImpl implements BehaviourFactory {
    private List<String> disabledBehaviourTypes;
    private ArrayList<RemoteMessageReceiver> messageReceivers;
    private final Map<String, BehaviourPlugin<Behaviour>> pluginMap;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Class<? extends BehaviourPlugin<? extends Behaviour>>[] plugins = {AlarmsPlugin.class, CallsPlugin.class, CameraPlugin.class, CounterPlugin.class, DashboardPlugin.class, DatePlugin.class, DayOfWeekPlugin.class, DicePlugin.class, DistressPlugin.class, EmptyPlugin.class, FindPhonePlugin.class, HabitTrackerPlugin.class, HorizontalCalibrationPlugin.class, IftttPlugin.class, MusicPlugin.class, MusicWatchAppPlugin.class, MutePhonePlugin.class, NotificationsPlugin.class, PhoneBatteryPlugin.class, QuickActionPlugin.class, RememberThisSpotPlugin.class, SettingsPlugin.class, StepsPlugin.class, StopwatchPlugin.class, StopTimePlugin.class, TemperaturePlugin.class, TimePlugin.class, TimerPlugin.class, VerticalCalibrationPlugin.class, WatchBatteryPlugin.class, WeatherPlugin.class, WebhookPlugin.class, WorkoutPlugin.class, WorldTimePlugin.class};

    /* compiled from: BehaviourFactoryImpl.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BehaviourFactoryImpl(final RemoteConfigController remoteConfigController) {
        Intrinsics.checkNotNullParameter(remoteConfigController, "remoteConfigController");
        this.pluginMap = new HashMap();
        this.disabledBehaviourTypes = ArraysKt___ArraysJvmKt.asList(remoteConfigController.getDisabledBehaviours());
        this.messageReceivers = new ArrayList<>();
        for (Class<? extends BehaviourPlugin<? extends Behaviour>> cls : plugins) {
            add(cls);
        }
        remoteConfigController.registerListener(new RemoteConfigController.RemoteConfigControllerListener() { // from class: com.animaconnected.secondo.behaviour.BehaviourFactoryImpl.2
            @Override // com.animaconnected.secondo.app.RemoteConfigController.RemoteConfigControllerListener
            public void onFetch() {
                BehaviourFactoryImpl.this.disabledBehaviourTypes = ArraysKt___ArraysJvmKt.asList(remoteConfigController.getDisabledBehaviours());
            }

            @Override // com.animaconnected.secondo.app.RemoteConfigController.RemoteConfigControllerListener
            public void onFetchFailed(String msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
            }
        });
    }

    private final BehaviourPlugin<Behaviour> add(Class<? extends BehaviourPlugin<? extends Behaviour>> cls) {
        BehaviourPlugin<Behaviour> behaviourPlugin;
        boolean z = true;
        if (!Modifier.isAbstract(cls.getModifiers())) {
            if (BehaviourPlugin.class.isAssignableFrom(cls)) {
                Object newInstance = ClassUtil.INSTANCE.newInstance(cls);
                if (newInstance instanceof BehaviourPlugin) {
                    behaviourPlugin = (BehaviourPlugin) newInstance;
                } else {
                    behaviourPlugin = null;
                }
                if (behaviourPlugin == null) {
                    z = false;
                }
                if (z) {
                    this.pluginMap.put(behaviourPlugin.getType(), behaviourPlugin);
                    RemoteMessageReceiver remoteMessageReceiver = behaviourPlugin.getRemoteMessageReceiver();
                    if (remoteMessageReceiver != null) {
                        this.messageReceivers.add(remoteMessageReceiver);
                    }
                    return behaviourPlugin;
                }
                throw new IllegalArgumentException(("Instancing " + cls + " failed.").toString());
            }
            throw new IllegalArgumentException((cls + "' must be instance of 'BehaviourPlugin'").toString());
        }
        throw new IllegalArgumentException((cls + " can't be abstract").toString());
    }

    private final boolean isCompatibleWithSlot(Behaviour behaviour, Slot slot) {
        return ArraysKt___ArraysKt.contains(behaviour.compatibleSlots(), slot);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourFactory
    public List<Behaviour> getAllBehaviours() {
        Map<String, BehaviourPlugin<Behaviour>> map = this.pluginMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, BehaviourPlugin<Behaviour>> entry : map.entrySet()) {
            if (isBehaviourTypeEnabled(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(((BehaviourPlugin) ((Map.Entry) it.next()).getValue()).getBehaviour());
        }
        return arrayList;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourFactory
    public List<BehaviourPlugin<Behaviour>> getAllPlugins(Slot firstSlot, Watch watch) {
        Intrinsics.checkNotNullParameter(firstSlot, "firstSlot");
        Intrinsics.checkNotNullParameter(watch, "watch");
        List<Behaviour> allBehaviours = getAllBehaviours(firstSlot, watch);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(allBehaviours, 10));
        Iterator<T> it = allBehaviours.iterator();
        while (it.hasNext()) {
            BehaviourPlugin<Behaviour> plugin = getPlugin(((Behaviour) it.next()).getType());
            Intrinsics.checkNotNull(plugin);
            arrayList.add(plugin);
        }
        return arrayList;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourFactory
    public Behaviour getBehaviour(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        BehaviourPlugin<Behaviour> behaviourPlugin = this.pluginMap.get(type);
        Intrinsics.checkNotNull(behaviourPlugin);
        return behaviourPlugin.getBehaviour();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourFactory
    public BehaviourPlugin<Behaviour> getPlugin(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.pluginMap.get(type);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourFactory
    public List<RemoteMessageReceiver> getRemoteMessageReceivers() {
        return this.messageReceivers;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourFactory
    public void initBehaviours(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Iterator<BehaviourPlugin<Behaviour>> it = this.pluginMap.values().iterator();
        while (it.hasNext()) {
            it.next().initBehaviour(context);
        }
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourFactory
    public boolean isBehaviourTypeEnabled(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return !this.disabledBehaviourTypes.contains(type);
    }

    private final List<Behaviour> getAllBehaviours(Slot slot, Watch watch) {
        boolean isCompatibleWithSlot;
        List<Behaviour> allBehaviours = getAllBehaviours();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allBehaviours) {
            if (((Behaviour) obj).isSelectable(watch)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            Behaviour behaviour = (Behaviour) obj2;
            if (slot == Slot.MainComplication) {
                Slot[] complications = Slot.Companion.getComplications();
                int length = complications.length;
                isCompatibleWithSlot = false;
                int r6 = 0;
                while (true) {
                    if (r6 >= length) {
                        break;
                    }
                    if (isCompatibleWithSlot(behaviour, complications[r6])) {
                        isCompatibleWithSlot = true;
                        break;
                    }
                    r6++;
                }
            } else {
                isCompatibleWithSlot = isCompatibleWithSlot(behaviour, slot);
            }
            if (isCompatibleWithSlot) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }
}
