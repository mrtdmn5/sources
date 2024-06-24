package com.animaconnected.watch.behaviour;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BorderStrokeKt;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.DeviceDataSync;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.GroupLayer;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.WatchManager;
import com.animaconnected.watch.behaviour.types.Empty;
import com.animaconnected.watch.device.BehaviourListener;
import com.animaconnected.watch.device.Button;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.device.Capabilities;
import com.animaconnected.watch.device.WatchFace;
import com.animaconnected.watch.device.files.WatchFileSystem;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.AppPosition;
import com.animaconnected.watch.display.ResourceSynchronizer;
import com.animaconnected.watch.display.WatchApp;
import com.animaconnected.watch.provider.preferences.Preferences;
import com.animaconnected.watch.storage.WatchDb;
import com.animaconnected.watch.sync.DBAppPositions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: Behaviours.kt */
/* loaded from: classes3.dex */
public final class Behaviours {
    private List<? extends Behaviour> all;
    private final BehaviourListener behaviourListener;
    private final WatchDb db;
    private final DeviceDataSync deviceDataSync;
    private List<String> disabledBehaviours;
    private final Preferences preferences;
    private final ResourceSynchronizer resourceSynchronizer;
    private final CoroutineScope scope;
    private final String tag;
    private final WatchManager wm;

    /* compiled from: Behaviours.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[WatchFace.values().length];
            try {
                r0[WatchFace.Main.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[WatchFace.FirstSubdial.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[WatchFace.SecondSubdial.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public Behaviours(WatchDb db, DeviceDataSync deviceDataSync, WatchManager wm, ResourceSynchronizer resourceSynchronizer, BehaviourListener behaviourListener, Preferences preferences) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(deviceDataSync, "deviceDataSync");
        Intrinsics.checkNotNullParameter(wm, "wm");
        Intrinsics.checkNotNullParameter(resourceSynchronizer, "resourceSynchronizer");
        Intrinsics.checkNotNullParameter(behaviourListener, "behaviourListener");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.db = db;
        this.deviceDataSync = deviceDataSync;
        this.wm = wm;
        this.resourceSynchronizer = resourceSynchronizer;
        this.behaviourListener = behaviourListener;
        this.preferences = preferences;
        EmptyList emptyList = EmptyList.INSTANCE;
        this.disabledBehaviours = emptyList;
        this.all = emptyList;
        this.tag = "Behaviours";
        this.scope = ServiceLocator.INSTANCE.getScope();
    }

    private final Slot checkSlot(Slot slot) {
        if (ArraysKt___ArraysKt.contains(Slot.Companion.getAll(), slot)) {
            return slot;
        }
        throw new IllegalArgumentException("Invalid slot " + slot.name() + " (" + slot.getId() + ')');
    }

    private final Capabilities getCapabilities() {
        return this.wm.getCurrentWatch().getCapabilities();
    }

    private final boolean hasCompBtnAndCompDef() {
        return this.wm.getCurrentWatch().getCommandCenter().hasCompBtnAndCompDef();
    }

    private final boolean isRemoteComplication(Complication complication) {
        if (complication.getDeviceComplicationMode() == 3) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x009e -> B:22:0x009f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object removeBehaviour(com.animaconnected.watch.behaviour.Behaviour r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.Behaviours.removeBehaviour(com.animaconnected.watch.behaviour.Behaviour, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object removeBehaviourFromSlot(Slot slot, Continuation<? super Unit> continuation) {
        Object behaviourForSlot = setBehaviourForSlot(checkSlot(slot), Empty.INSTANCE, continuation);
        if (behaviourForSlot == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return behaviourForSlot;
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void removeQuickAction$default(Behaviours behaviours, WatchApp watchApp, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            watchApp = null;
        }
        behaviours.removeQuickAction(watchApp);
    }

    private final void updateQuickAction(final WatchApp watchApp) {
        AppId appId;
        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.Behaviours$updateQuickAction$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Quick action set to " + WatchApp.this;
            }
        }, 6, (Object) null);
        Preferences preferences = this.preferences;
        if (watchApp != null) {
            appId = watchApp.getId();
        } else {
            appId = null;
        }
        preferences.setQuickAction(appId);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0089 -> B:10:0x008c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object activateBehaviours(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.behaviour.Behaviours$activateBehaviours$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.behaviour.Behaviours$activateBehaviours$1 r0 = (com.animaconnected.watch.behaviour.Behaviours$activateBehaviours$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.behaviour.Behaviours$activateBehaviours$1 r0 = new com.animaconnected.watch.behaviour.Behaviours$activateBehaviours$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r2 = r0.L$2
            com.animaconnected.watch.Slot r2 = (com.animaconnected.watch.Slot) r2
            java.lang.Object r4 = r0.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r0.L$0
            com.animaconnected.watch.behaviour.Behaviours r5 = (com.animaconnected.watch.behaviour.Behaviours) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L8c
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3b:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.WatchManager r7 = r6.wm
            com.animaconnected.watch.Watch r7 = r7.getCurrentWatch()
            boolean r7 = r7 instanceof com.animaconnected.watch.DisplayWatch
            if (r7 == 0) goto L64
            java.util.List r7 = r6.getWatchApps()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L52:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L92
            java.lang.Object r0 = r7.next()
            com.animaconnected.watch.display.WatchApp r0 = (com.animaconnected.watch.display.WatchApp) r0
            com.animaconnected.watch.Slot r1 = com.animaconnected.watch.Slot.Display
            r0.activate(r1)
            goto L52
        L64:
            java.util.List r7 = r6.getAvailableSlots()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
            r5 = r6
            r4 = r7
        L70:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L92
            java.lang.Object r7 = r4.next()
            r2 = r7
            com.animaconnected.watch.Slot r2 = (com.animaconnected.watch.Slot) r2
            r0.L$0 = r5
            r0.L$1 = r4
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r7 = r5.getBehaviour(r2, r0)
            if (r7 != r1) goto L8c
            return r1
        L8c:
            com.animaconnected.watch.behaviour.Behaviour r7 = (com.animaconnected.watch.behaviour.Behaviour) r7
            r7.activate(r2)
            goto L70
        L92:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.Behaviours.activateBehaviours(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void connectBehaviours(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        if (this.wm.getCurrentWatch() instanceof DisplayWatch) {
            Iterator<T> it = getWatchApps().iterator();
            while (it.hasNext()) {
                ((WatchApp) it.next()).connected(watch);
            }
            return;
        }
        List<Slot> availableSlots = getAvailableSlots();
        List<? extends Behaviour> list = this.all;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Slot[] compatibleSlots = ((Behaviour) obj).compatibleSlots();
            int length = compatibleSlots.length;
            boolean z = false;
            int r7 = 0;
            while (true) {
                if (r7 >= length) {
                    break;
                }
                if (availableSlots.contains(compatibleSlots[r7])) {
                    z = true;
                    break;
                }
                r7++;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((Behaviour) it2.next()).connected(watch);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0086 -> B:10:0x0089). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deactivateBehaviours(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.behaviour.Behaviours$deactivateBehaviours$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.behaviour.Behaviours$deactivateBehaviours$1 r0 = (com.animaconnected.watch.behaviour.Behaviours$deactivateBehaviours$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.behaviour.Behaviours$deactivateBehaviours$1 r0 = new com.animaconnected.watch.behaviour.Behaviours$deactivateBehaviours$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            int r2 = r0.I$1
            int r4 = r0.I$0
            java.lang.Object r5 = r0.L$2
            com.animaconnected.watch.Slot r5 = (com.animaconnected.watch.Slot) r5
            java.lang.Object r6 = r0.L$1
            com.animaconnected.watch.Slot[] r6 = (com.animaconnected.watch.Slot[]) r6
            java.lang.Object r7 = r0.L$0
            com.animaconnected.watch.behaviour.Behaviours r7 = (com.animaconnected.watch.behaviour.Behaviours) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L89
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3f:
            kotlin.ResultKt.throwOnFailure(r9)
            com.animaconnected.watch.WatchManager r9 = r8.wm
            com.animaconnected.watch.Watch r9 = r9.getCurrentWatch()
            boolean r9 = r9 instanceof com.animaconnected.watch.DisplayWatch
            if (r9 == 0) goto L68
            java.util.List r9 = r8.getWatchApps()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L56:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L90
            java.lang.Object r0 = r9.next()
            com.animaconnected.watch.display.WatchApp r0 = (com.animaconnected.watch.display.WatchApp) r0
            com.animaconnected.watch.Slot r1 = com.animaconnected.watch.Slot.Display
            r0.deactivated(r1)
            goto L56
        L68:
            com.animaconnected.watch.Slot$Companion r9 = com.animaconnected.watch.Slot.Companion
            com.animaconnected.watch.Slot[] r9 = r9.getAll()
            int r2 = r9.length
            r4 = 0
            r7 = r8
            r6 = r9
        L72:
            if (r4 >= r2) goto L90
            r5 = r6[r4]
            r0.L$0 = r7
            r0.L$1 = r6
            r0.L$2 = r5
            r0.I$0 = r4
            r0.I$1 = r2
            r0.label = r3
            java.lang.Object r9 = r7.getBehaviour(r5, r0)
            if (r9 != r1) goto L89
            return r1
        L89:
            com.animaconnected.watch.behaviour.Behaviour r9 = (com.animaconnected.watch.behaviour.Behaviour) r9
            r9.deactivated(r5)
            int r4 = r4 + r3
            goto L72
        L90:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.Behaviours.deactivateBehaviours(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List<Behaviour> getAll() {
        return this.all;
    }

    public final WatchApp getApp(AppId appId) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Iterator<T> it = getWatchApps().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((WatchApp) obj).getId() == appId) {
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
        return (WatchApp) obj;
    }

    public final Long getAppPosition(AppId appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        return this.resourceSynchronizer.getAppPosition(appId.getCode());
    }

    public final List<AppPosition> getAppPositions() {
        List<DBAppPositions> allAppPositions = this.resourceSynchronizer.getAllAppPositions();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(allAppPositions, 10));
        for (DBAppPositions dBAppPositions : allAppPositions) {
            arrayList.add(new AppPosition((int) dBAppPositions.getPosition(), AppId.Companion.fromStatus(dBAppPositions.getAppId())));
        }
        return arrayList;
    }

    public final String getAppPositionsAnalytics() {
        Pair pair;
        List<AppPosition> appPositions = getAppPositions();
        ArrayList arrayList = new ArrayList();
        for (AppPosition appPosition : appPositions) {
            WatchApp app2 = getApp(appPosition.getAppId());
            if (app2 == null) {
                pair = null;
            } else {
                pair = new Pair(Integer.valueOf(appPosition.getPosition()), app2.getAnalyticsName());
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        Map map = MapsKt__MapsKt.toMap(arrayList);
        Json.Default r1 = Json.Default;
        r1.getClass();
        return r1.encodeToString(new LinkedHashMapSerializer(IntSerializer.INSTANCE, StringSerializer.INSTANCE), map);
    }

    public final List<Slot> getAvailableSlots() {
        ListBuilder listBuilder = new ListBuilder();
        Slot.Companion companion = Slot.Companion;
        CollectionsKt__ReversedViewsKt.addAll(listBuilder, companion.getPushers());
        listBuilder.add(Slot.MainComplication);
        if (getCapabilities().getHasDoubleMainComplication()) {
            listBuilder.add(Slot.MainComplicationDouble);
        }
        if (getCapabilities().hasOneSubComplication()) {
            listBuilder.add(Slot.SubComplication1);
        } else if (getCapabilities().hasTwoSubComplications()) {
            CollectionsKt__ReversedViewsKt.addAll(listBuilder, companion.getSubComplications());
        }
        return CollectionsKt__CollectionsKt.build(listBuilder);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1 A[EDGE_INSN: B:39:0x00c1->B:32:0x00c1 BREAK  A[LOOP:1: B:26:0x00a9->B:38:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getBehaviour(com.animaconnected.watch.Slot r7, kotlin.coroutines.Continuation<? super com.animaconnected.watch.behaviour.Behaviour> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.behaviour.Behaviours$getBehaviour$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.behaviour.Behaviours$getBehaviour$1 r0 = (com.animaconnected.watch.behaviour.Behaviours$getBehaviour$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.behaviour.Behaviours$getBehaviour$1 r0 = new com.animaconnected.watch.behaviour.Behaviours$getBehaviour$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r7 = r0.L$0
            com.animaconnected.watch.behaviour.Behaviours r7 = (com.animaconnected.watch.behaviour.Behaviours) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L79
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            java.lang.Object r7 = r0.L$0
            com.animaconnected.watch.behaviour.Behaviours r7 = (com.animaconnected.watch.behaviour.Behaviours) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L58
        L3f:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.watch.Slot r8 = com.animaconnected.watch.Slot.MagicKey
            if (r7 != r8) goto L63
            com.animaconnected.watch.storage.WatchDb r7 = r6.db
            com.animaconnected.watch.Slot r8 = com.animaconnected.watch.Slot.MainComplication
            com.animaconnected.watch.GroupLayer r2 = com.animaconnected.watch.GroupLayer.MagicKey
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r8 = r7.getBehaviourOnSlot(r8, r2, r0)
            if (r8 != r1) goto L57
            return r1
        L57:
            r7 = r6
        L58:
            com.animaconnected.watch.storage.models.BehaviourSlot r8 = (com.animaconnected.watch.storage.models.BehaviourSlot) r8
            if (r8 == 0) goto L61
            java.lang.String r8 = r8.getBehaviour_type()
            goto L81
        L61:
            r8 = r5
            goto L81
        L63:
            com.animaconnected.watch.storage.WatchDb r8 = r6.db
            com.animaconnected.watch.device.Capabilities r2 = r6.getCapabilities()
            com.animaconnected.watch.GroupLayer r2 = com.animaconnected.watch.device.WatchConstantsKt.groupLayer(r7, r2)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = r8.getBehaviourOnSlot(r7, r2, r0)
            if (r8 != r1) goto L78
            return r1
        L78:
            r7 = r6
        L79:
            com.animaconnected.watch.storage.models.BehaviourSlot r8 = (com.animaconnected.watch.storage.models.BehaviourSlot) r8
            if (r8 == 0) goto L61
            java.lang.String r8 = r8.getBehaviour_type()
        L81:
            java.util.List<? extends com.animaconnected.watch.behaviour.Behaviour> r0 = r7.all
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L8e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto La5
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.animaconnected.watch.behaviour.Behaviour r3 = (com.animaconnected.watch.behaviour.Behaviour) r3
            boolean r3 = r7.isEnabled(r3)
            if (r3 == 0) goto L8e
            r1.add(r2)
            goto L8e
        La5:
            java.util.Iterator r7 = r1.iterator()
        La9:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto Lc1
            java.lang.Object r0 = r7.next()
            r1 = r0
            com.animaconnected.watch.behaviour.Behaviour r1 = (com.animaconnected.watch.behaviour.Behaviour) r1
            java.lang.String r1 = r1.getType()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r8)
            if (r1 == 0) goto La9
            r5 = r0
        Lc1:
            com.animaconnected.watch.behaviour.Behaviour r5 = (com.animaconnected.watch.behaviour.Behaviour) r5
            if (r5 != 0) goto Lc7
            com.animaconnected.watch.behaviour.types.Empty r5 = com.animaconnected.watch.behaviour.types.Empty.INSTANCE
        Lc7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.Behaviours.getBehaviour(com.animaconnected.watch.Slot, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List<String> getDisabledBehaviours() {
        return this.disabledBehaviours;
    }

    public final WatchApp getQuickAction() {
        Object obj;
        boolean z;
        AppId quickAction = this.preferences.getQuickAction();
        Iterator<T> it = getWatchApps().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((WatchApp) obj).getId() == quickAction) {
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
        return (WatchApp) obj;
    }

    public final Slot getSlotForWatchFace(WatchFace watchFace) {
        Intrinsics.checkNotNullParameter(watchFace, "watchFace");
        int r2 = WhenMappings.$EnumSwitchMapping$0[watchFace.ordinal()];
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 == 3) {
                    return Slot.SubComplication2;
                }
                throw new NoWhenBranchMatchedException();
            }
            return Slot.SubComplication1;
        }
        return Slot.MainComplication;
    }

    public final Slot getSlotFromButtonIndex$watch_release(Button button, ButtonAction action) {
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(action, "action");
        if (getCapabilities().getHasDoubleMainComplication() && button == Button.Crown && action == ButtonAction.DoublePress) {
            return Slot.MainComplicationDouble;
        }
        if (getCapabilities().getHasMagicKeyOne() && button == Button.Crown && action == ButtonAction.UltraLongPress) {
            return Slot.MagicKey;
        }
        if (button == Button.Top) {
            return Slot.TopPusher;
        }
        if (button == Button.Crown) {
            return Slot.MainComplication;
        }
        if (button == Button.Bottom) {
            return Slot.BottomPusher;
        }
        return Slot.Unknown;
    }

    public final List<WatchApp> getWatchApps() {
        List<? extends Behaviour> list = this.all;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof WatchApp) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.animaconnected.watch.behaviour.Behaviours$special$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                long j;
                Long appPosition = Behaviours.this.getAppPosition(((WatchApp) t).getId());
                long j2 = Long.MAX_VALUE;
                if (appPosition != null) {
                    j = appPosition.longValue();
                } else {
                    j = Long.MAX_VALUE;
                }
                Long valueOf = Long.valueOf(j);
                Long appPosition2 = Behaviours.this.getAppPosition(((WatchApp) t2).getId());
                if (appPosition2 != null) {
                    j2 = appPosition2.longValue();
                }
                return BorderStrokeKt.compareValues(valueOf, Long.valueOf(j2));
            }
        });
    }

    public final boolean isEnabled(Behaviour behaviour) {
        Intrinsics.checkNotNullParameter(behaviour, "<this>");
        return !this.disabledBehaviours.contains(behaviour.getType());
    }

    public final boolean isQuickAction(WatchApp app2) {
        Intrinsics.checkNotNullParameter(app2, "app");
        if (this.preferences.getQuickAction() == app2.getId()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object moveBehaviourToSlot(com.animaconnected.watch.Slot r6, com.animaconnected.watch.behaviour.Behaviour r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.behaviour.Behaviours$moveBehaviourToSlot$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.behaviour.Behaviours$moveBehaviourToSlot$1 r0 = (com.animaconnected.watch.behaviour.Behaviours$moveBehaviourToSlot$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.behaviour.Behaviours$moveBehaviourToSlot$1 r0 = new com.animaconnected.watch.behaviour.Behaviours$moveBehaviourToSlot$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L69
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.lang.Object r6 = r0.L$2
            r7 = r6
            com.animaconnected.watch.behaviour.Behaviour r7 = (com.animaconnected.watch.behaviour.Behaviour) r7
            java.lang.Object r6 = r0.L$1
            com.animaconnected.watch.Slot r6 = (com.animaconnected.watch.Slot) r6
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.behaviour.Behaviours r2 = (com.animaconnected.watch.behaviour.Behaviours) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L59
        L43:
            kotlin.ResultKt.throwOnFailure(r8)
            r5.checkSlot(r6)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = r5.removeBehaviour(r7, r0)
            if (r8 != r1) goto L58
            return r1
        L58:
            r2 = r5
        L59:
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r6 = r2.setBehaviourForSlot(r6, r7, r0)
            if (r6 != r1) goto L69
            return r1
        L69:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.Behaviours.moveBehaviourToSlot(com.animaconnected.watch.Slot, com.animaconnected.watch.behaviour.Behaviour, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void notifyDisconnected(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        if (this.wm.getCurrentWatch() instanceof DisplayWatch) {
            Iterator<T> it = getWatchApps().iterator();
            while (it.hasNext()) {
                ((WatchApp) it.next()).disconnected(watch);
            }
            return;
        }
        List<Slot> availableSlots = getAvailableSlots();
        List<? extends Behaviour> list = this.all;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Behaviour behaviour = (Behaviour) obj;
            List<Slot> list2 = availableSlots;
            boolean z = false;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (ArraysKt___ArraysKt.contains(behaviour.compatibleSlots(), (Slot) it2.next())) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((Behaviour) it3.next()).disconnected(watch);
        }
    }

    public final CommonFlow<WatchApp> quickActionFlow() {
        final CommonFlow<AppId> quickActionFlow = this.preferences.getQuickActionFlow();
        return FlowExtensionsKt.asCommonFlow(new Flow<WatchApp>() { // from class: com.animaconnected.watch.behaviour.Behaviours$quickActionFlow$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.behaviour.Behaviours$quickActionFlow$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Behaviours this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.behaviour.Behaviours$quickActionFlow$$inlined$map$1$2", f = "Behaviours.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.behaviour.Behaviours$quickActionFlow$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Behaviours behaviours) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = behaviours;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.animaconnected.watch.behaviour.Behaviours$quickActionFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.animaconnected.watch.behaviour.Behaviours$quickActionFlow$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.behaviour.Behaviours$quickActionFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.behaviour.Behaviours$quickActionFlow$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.behaviour.Behaviours$quickActionFlow$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L65
                    L27:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                        com.animaconnected.watch.display.AppId r7 = (com.animaconnected.watch.display.AppId) r7
                        com.animaconnected.watch.behaviour.Behaviours r2 = r6.this$0
                        java.util.List r2 = r2.getWatchApps()
                        java.lang.Iterable r2 = (java.lang.Iterable) r2
                        java.util.Iterator r2 = r2.iterator()
                    L42:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L5b
                        java.lang.Object r4 = r2.next()
                        r5 = r4
                        com.animaconnected.watch.display.WatchApp r5 = (com.animaconnected.watch.display.WatchApp) r5
                        com.animaconnected.watch.display.AppId r5 = r5.getId()
                        if (r5 != r7) goto L57
                        r5 = r3
                        goto L58
                    L57:
                        r5 = 0
                    L58:
                        if (r5 == 0) goto L42
                        goto L5c
                    L5b:
                        r4 = 0
                    L5c:
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r4, r0)
                        if (r7 != r1) goto L65
                        return r1
                    L65:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.Behaviours$quickActionFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super WatchApp> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void removeQuickAction(WatchApp watchApp) {
        String str = null;
        updateQuickAction(null);
        AppEvents appEvents = ServiceLocator.INSTANCE.getAnalytics().getAppEvents();
        if (watchApp != null) {
            str = watchApp.getAnalyticsName();
        }
        appEvents.appListRemoveQA(str);
    }

    public final void setAll(List<? extends Behaviour> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.all = list;
    }

    public final void setBehaviourForMagicKey(final String behaviourType) {
        Intrinsics.checkNotNullParameter(behaviourType, "behaviourType");
        Behaviour behaviour = getBehaviour(behaviourType);
        if (behaviour != null) {
            WatchDb.Companion companion = WatchDb.Companion;
            WatchDb watchDb = this.db;
            Slot slot = Slot.MainComplication;
            GroupLayer groupLayer = GroupLayer.MagicKey;
            companion.saveBehaviour(watchDb, behaviour, slot, groupLayer, CollectionsKt__CollectionsKt.listOf(groupLayer));
            return;
        }
        LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.Behaviours$setBehaviourForMagicKey$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("Behaviour "), behaviourType, " is not real");
            }
        }, 6, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setBehaviourForSlot(final com.animaconnected.watch.Slot r12, final com.animaconnected.watch.behaviour.Behaviour r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.Behaviours.setBehaviourForSlot(com.animaconnected.watch.Slot, com.animaconnected.watch.behaviour.Behaviour, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setDisabledBehaviours(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.disabledBehaviours = list;
    }

    public final void setQuickAction(WatchApp app2) {
        Intrinsics.checkNotNullParameter(app2, "app");
        updateQuickAction(app2);
        ServiceLocator.INSTANCE.getAnalytics().getAppEvents().appListSetQA(app2.getAnalyticsName());
    }

    public final void updatePositions(List<? extends AppId> appPositions) {
        WatchFileSystem fs;
        Intrinsics.checkNotNullParameter(appPositions, "appPositions");
        ResourceSynchronizer resourceSynchronizer = this.resourceSynchronizer;
        List<? extends AppId> list = appPositions;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((AppId) it.next()).getCode()));
        }
        List<Integer> updateAppPositions = resourceSynchronizer.updateAppPositions(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(updateAppPositions, 10));
        Iterator<T> it2 = updateAppPositions.iterator();
        while (it2.hasNext()) {
            arrayList2.add(AppId.Companion.fromStatus(((Number) it2.next()).intValue()));
        }
        final String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, null, null, null, new Function1<AppId, CharSequence>() { // from class: com.animaconnected.watch.behaviour.Behaviours$updatePositions$changedString$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(AppId appId) {
                Intrinsics.checkNotNullParameter(appId, "appId");
                return AppId.Companion.fromStatus(appId.getCode()).name();
            }
        }, 31);
        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.Behaviours$updatePositions$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Apps changed: " + joinToString$default;
            }
        }, 6, (Object) null);
        ServiceLocator.INSTANCE.getAnalytics().getAppEvents().appListChangedPositions(joinToString$default);
        Watch currentWatch = this.wm.getCurrentWatch();
        if (!(currentWatch instanceof DisplayWatch) || (fs = ((DisplayWatch) currentWatch).getFs()) == null) {
            return;
        }
        BuildersKt.launch$default(currentWatch.getScope(), null, null, new Behaviours$updatePositions$2(currentWatch, fs, null), 3);
    }

    public final Behaviour getBehaviour(String type) {
        Object obj;
        Intrinsics.checkNotNullParameter(type, "type");
        Iterator<T> it = this.all.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Behaviour) obj).getType(), type)) {
                break;
            }
        }
        return (Behaviour) obj;
    }
}
