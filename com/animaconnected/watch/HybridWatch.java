package com.animaconnected.watch;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import com.animaconnected.firebase.config.AppFeatureGetMovingParams;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.logger.LogKt;
import com.animaconnected.msgpack.MsgPackCreator;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.Command;
import com.animaconnected.watch.device.WatchIO;
import com.animaconnected.watch.display.ResourceSynchronizer;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.provider.WatchAlarmProvider;
import com.animaconnected.watch.storage.WatchDb;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HybridWatch.kt */
/* loaded from: classes3.dex */
public final class HybridWatch extends Watch {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_CALL_STATUS_IS_RINGING_DIRTY = "call-status-is-ringing";
    private final WatchAlarmProvider alarms;
    private final boolean ignoreAlertAssign;
    private final int[] remoteComplications;

    /* compiled from: HybridWatch.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: HybridWatch.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Slot.values().length];
            try {
                r0[Slot.MainComplication.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Slot.SubComplication1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Slot.SubComplication2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[Slot.MainComplicationDouble.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HybridWatch(BasicStorage storage, String identifier, String str, DeviceType watchType, FirmwareVariant firmwareVariant, MsgPackCreator msgPackCreator, ResourceSynchronizer resourceSynchronizer, WatchDb watchDb, FitnessQueries fitnessQueries, DeviceDataSync deviceDataSync, Function1<? super Continuation<? super Unit>, ? extends Object> syncSuspend, Behaviours behaviours, boolean z) {
        super(storage, identifier, str, watchType, firmwareVariant, fitnessQueries, msgPackCreator, resourceSynchronizer, watchDb, deviceDataSync, syncSuspend, behaviours, null);
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(watchType, "watchType");
        Intrinsics.checkNotNullParameter(firmwareVariant, "firmwareVariant");
        Intrinsics.checkNotNullParameter(msgPackCreator, "msgPackCreator");
        Intrinsics.checkNotNullParameter(resourceSynchronizer, "resourceSynchronizer");
        Intrinsics.checkNotNullParameter(watchDb, "watchDb");
        Intrinsics.checkNotNullParameter(fitnessQueries, "fitnessQueries");
        Intrinsics.checkNotNullParameter(deviceDataSync, "deviceDataSync");
        Intrinsics.checkNotNullParameter(syncSuspend, "syncSuspend");
        Intrinsics.checkNotNullParameter(behaviours, "behaviours");
        this.ignoreAlertAssign = z;
        this.alarms = ServiceLocator.INSTANCE.getAlarmsProvider();
        this.remoteComplications = new int[]{3, 10, 36, 37};
    }

    private final int getRemoteComplicationFromSlot(Slot slot) {
        int r0 = WhenMappings.$EnumSwitchMapping$0[slot.ordinal()];
        if (r0 == 1) {
            return 3;
        }
        if (r0 != 2) {
            if (r0 != 3) {
                if (r0 == 4) {
                    return 37;
                }
                throw new IllegalArgumentException("Slot " + slot + " can't be used for remote complications");
            }
            return 36;
        }
        return 10;
    }

    private final Slot getSlotForRemoteComplication(int r4) {
        if (r4 != 3) {
            if (r4 != 10) {
                if (r4 != 36) {
                    if (r4 == 37) {
                        return Slot.MainComplicationDouble;
                    }
                    throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("remoteComplication ", r4, " has no corresponding slot"));
                }
                return Slot.SubComplication2;
            }
            return Slot.SubComplication1;
        }
        return Slot.MainComplication;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getTrigger(final com.animaconnected.watch.Slot r13, kotlin.coroutines.Continuation<? super java.lang.Integer> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.animaconnected.watch.HybridWatch$getTrigger$1
            if (r0 == 0) goto L13
            r0 = r14
            com.animaconnected.watch.HybridWatch$getTrigger$1 r0 = (com.animaconnected.watch.HybridWatch$getTrigger$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.HybridWatch$getTrigger$1 r0 = new com.animaconnected.watch.HybridWatch$getTrigger$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r13 = r0.L$1
            com.animaconnected.watch.Slot r13 = (com.animaconnected.watch.Slot) r13
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.HybridWatch r0 = (com.animaconnected.watch.HybridWatch) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L5d
        L30:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L38:
            kotlin.ResultKt.throwOnFailure(r14)
            com.animaconnected.watch.Slot r14 = com.animaconnected.watch.Slot.BottomPusher
            if (r13 == r14) goto L49
            com.animaconnected.watch.Slot r14 = com.animaconnected.watch.Slot.TopPusher
            if (r13 == r14) goto L49
            java.lang.Integer r13 = new java.lang.Integer
            r13.<init>(r3)
            return r13
        L49:
            com.animaconnected.watch.storage.WatchDb r14 = r12.getWatchDb()
            com.animaconnected.watch.GroupLayer r2 = com.animaconnected.watch.GroupLayer.Default
            r0.L$0 = r12
            r0.L$1 = r13
            r0.label = r4
            java.lang.Object r14 = r14.getBehaviourOnSlot(r13, r2, r0)
            if (r14 != r1) goto L5c
            return r1
        L5c:
            r0 = r12
        L5d:
            com.animaconnected.watch.storage.models.BehaviourSlot r14 = (com.animaconnected.watch.storage.models.BehaviourSlot) r14
            if (r14 == 0) goto L66
            java.lang.String r14 = r14.getBehaviour_type()
            goto L67
        L66:
            r14 = 0
        L67:
            java.lang.String r6 = r0.getTag$watch_release()
            r7 = 0
            r8 = 0
            com.animaconnected.watch.HybridWatch$getTrigger$2 r9 = new com.animaconnected.watch.HybridWatch$getTrigger$2
            r9.<init>()
            r10 = 6
            r11 = 0
            r5 = r0
            com.animaconnected.logger.LogKt.debug$default(r5, r6, r7, r8, r9, r10, r11)
            java.lang.String r13 = "Music"
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r13)
            if (r13 == 0) goto L8c
            com.animaconnected.watch.DeviceDataSync r13 = r0.getDeviceDataSync()
            boolean r13 = r13.getUseHidForMusic()
            if (r13 == 0) goto L8c
            r3 = 2
            goto L95
        L8c:
            java.lang.String r13 = com.animaconnected.watch.behaviour.types.Camera.TYPE
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r13)
            if (r13 == 0) goto L95
            r3 = r4
        L95:
            java.lang.Integer r13 = new java.lang.Integer
            r13.<init>(r3)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.HybridWatch.getTrigger(com.animaconnected.watch.Slot, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean isRemoteComplication(int r2) {
        if (r2 == 3) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object resetCallStatus(com.animaconnected.watch.device.WatchIO r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.HybridWatch$resetCallStatus$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.HybridWatch$resetCallStatus$1 r0 = (com.animaconnected.watch.HybridWatch$resetCallStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.HybridWatch$resetCallStatus$1 r0 = new com.animaconnected.watch.HybridWatch$resetCallStatus$1
            r0.<init>(r8, r10)
        L18:
            r6 = r0
            java.lang.Object r10 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.label
            java.lang.String r7 = "call-status-is-ringing"
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r9 = r6.L$0
            com.animaconnected.watch.HybridWatch r9 = (com.animaconnected.watch.HybridWatch) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L62
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            kotlin.ResultKt.throwOnFailure(r10)
            com.animaconnected.watch.device.BasicStorage r10 = r8.getStorage$watch_release()
            java.lang.Boolean r10 = r10.getBoolean(r7)
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r1)
            if (r10 == 0) goto L6a
            r10 = 1
            r3 = 0
            r4 = 0
            com.animaconnected.watch.device.Capabilities r1 = r8.getCapabilities()
            boolean r5 = r1.getHasCallRepeatsAlert()
            r6.L$0 = r8
            r6.label = r2
            r1 = r9
            r2 = r10
            java.lang.Object r9 = r1.writeIncomingCall(r2, r3, r4, r5, r6)
            if (r9 != r0) goto L61
            return r0
        L61:
            r9 = r8
        L62:
            com.animaconnected.watch.device.BasicStorage r9 = r9.getStorage$watch_release()
            r10 = 0
            r9.put(r7, r10)
        L6a:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.HybridWatch.resetCallStatus(com.animaconnected.watch.device.WatchIO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setConfigSettings(com.animaconnected.watch.device.WatchIO r5, java.util.Map<java.lang.String, java.lang.Integer> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.HybridWatch$setConfigSettings$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.HybridWatch$setConfigSettings$1 r0 = (com.animaconnected.watch.HybridWatch$setConfigSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.HybridWatch$setConfigSettings$1 r0 = new com.animaconnected.watch.HybridWatch$setConfigSettings$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.NumberFormatException -> L47
            goto L44
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L3b
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L3b:
            r0.label = r3     // Catch: java.lang.NumberFormatException -> L47
            java.lang.Object r5 = r5.writeConfigSettings(r6, r0)     // Catch: java.lang.NumberFormatException -> L47
            if (r5 != r1) goto L44
            return r1
        L44:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L47:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "Error converting map string value to int"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.HybridWatch.setConfigSettings(com.animaconnected.watch.device.WatchIO, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0089 A[Catch: Exception -> 0x0033, TryCatch #1 {Exception -> 0x0033, blocks: (B:11:0x002f, B:12:0x0080, B:14:0x0089, B:17:0x008c), top: B:10:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c A[Catch: Exception -> 0x0033, TRY_LEAVE, TryCatch #1 {Exception -> 0x0033, blocks: (B:11:0x002f, B:12:0x0080, B:14:0x0089, B:17:0x008c), top: B:10:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncStepsTarget(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r12 = this;
            java.lang.String r0 = "Synced steps target to watch: "
            boolean r1 = r13 instanceof com.animaconnected.watch.HybridWatch$syncStepsTarget$1
            if (r1 == 0) goto L15
            r1 = r13
            com.animaconnected.watch.HybridWatch$syncStepsTarget$1 r1 = (com.animaconnected.watch.HybridWatch$syncStepsTarget$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.animaconnected.watch.HybridWatch$syncStepsTarget$1 r1 = new com.animaconnected.watch.HybridWatch$syncStepsTarget$1
            r1.<init>(r12, r13)
        L1a:
            java.lang.Object r13 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            java.lang.String r4 = "steps_target"
            r5 = 1
            if (r3 == 0) goto L40
            if (r3 != r5) goto L38
            int r2 = r1.I$1
            int r3 = r1.I$0
            java.lang.Object r1 = r1.L$0
            com.animaconnected.watch.HybridWatch r1 = (com.animaconnected.watch.HybridWatch) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> L33
            goto L80
        L33:
            r13 = move-exception
            r3 = r13
            r0 = r1
            goto Lb9
        L38:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L40:
            kotlin.ResultKt.throwOnFailure(r13)
            com.animaconnected.watch.display.ResourceSynchronizer r13 = r12.getResourceSynchronizer$watch_release()
            com.animaconnected.watch.fitness.HealthGoals r13 = r13.getCurrentDailyGoals()
            if (r13 != 0) goto L53
            com.animaconnected.watch.fitness.HealthGoals$Companion r13 = com.animaconnected.watch.fitness.HealthGoals.Companion
            com.animaconnected.watch.fitness.HealthGoals r13 = com.animaconnected.watch.fitness.FitnessDataKt.m1223default(r13)
        L53:
            int r3 = r13.getSteps()
            int r13 = java.lang.Integer.hashCode(r3)
            com.animaconnected.watch.display.ResourceSynchronizer r6 = r12.getResourceSynchronizer$watch_release()
            java.lang.String r7 = r12.getIdentifier()
            boolean r6 = r6.isConfigSynced(r7, r4, r13)
            if (r6 != 0) goto Lc3
            com.animaconnected.watch.device.WatchIO r6 = r12.getIo()     // Catch: java.lang.Exception -> Lb6
            if (r6 == 0) goto L83
            r1.L$0 = r12     // Catch: java.lang.Exception -> Lb6
            r1.I$0 = r3     // Catch: java.lang.Exception -> Lb6
            r1.I$1 = r13     // Catch: java.lang.Exception -> Lb6
            r1.label = r5     // Catch: java.lang.Exception -> Lb6
            java.lang.Object r1 = r6.writeStepsTarget(r3, r1)     // Catch: java.lang.Exception -> Lb6
            if (r1 != r2) goto L7e
            return r2
        L7e:
            r1 = r12
            r2 = r13
        L80:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L33
            goto L87
        L83:
            r1 = 0
            r2 = r13
            r13 = r1
            r1 = r12
        L87:
            if (r13 != 0) goto L8c
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L33
            return r13
        L8c:
            com.animaconnected.watch.display.ResourceSynchronizer r13 = r1.getResourceSynchronizer$watch_release()     // Catch: java.lang.Exception -> L33
            java.lang.String r5 = r1.getIdentifier()     // Catch: java.lang.Exception -> L33
            r13.setConfigSynced(r5, r4, r2)     // Catch: java.lang.Exception -> L33
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L33
            r13.<init>(r0)     // Catch: java.lang.Exception -> L33
            r13.append(r3)     // Catch: java.lang.Exception -> L33
            java.lang.String r0 = " | hash: "
            r13.append(r0)     // Catch: java.lang.Exception -> L33
            r13.append(r2)     // Catch: java.lang.Exception -> L33
            java.lang.String r6 = r13.toString()     // Catch: java.lang.Exception -> L33
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 14
            r11 = 0
            r5 = r1
            com.animaconnected.logger.LogKt.verbose$default(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L33
            goto Lc3
        Lb6:
            r13 = move-exception
            r0 = r12
            r3 = r13
        Lb9:
            java.lang.String r1 = "Failed to sync steps target"
            r2 = 0
            r4 = 0
            r5 = 10
            r6 = 0
            com.animaconnected.logger.LogKt.verbose$default(r0, r1, r2, r3, r4, r5, r6)
        Lc3:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.HybridWatch.syncStepsTarget(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0020. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0194 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x016a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0138 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeCommonSettings(com.animaconnected.watch.device.WatchIO r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.HybridWatch.writeCommonSettings(com.animaconnected.watch.device.WatchIO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0022. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0197 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0172 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeComplications(com.animaconnected.watch.device.WatchIO r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.HybridWatch.writeComplications(com.animaconnected.watch.device.WatchIO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00c3 -> B:17:0x00c7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeRemoteComplicationData(com.animaconnected.watch.device.WatchIO r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.HybridWatch.writeRemoteComplicationData(com.animaconnected.watch.device.WatchIO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0099 -> B:17:0x009c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeRemoteComplicationDataConfigs(com.animaconnected.watch.device.WatchIO r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.HybridWatch.writeRemoteComplicationDataConfigs(com.animaconnected.watch.device.WatchIO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object writeSleepStartTime(WatchIO watchIO, Continuation<? super Unit> continuation) {
        Object writeConfigSettings = watchIO.writeConfigSettings(MapsKt__MapsKt.mapOf(new Pair("user_information_sleep_starting_time_hour", new Integer(10)), new Pair("user_information_sleep_starting_time_minute", new Integer(0))), continuation);
        if (writeConfigSettings == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return writeConfigSettings;
        }
        return Unit.INSTANCE;
    }

    public final Object writeStillness(WatchIO watchIO, boolean z, Continuation<? super Unit> continuation) {
        Object writeStillness;
        if (!z) {
            Object writeStillness2 = watchIO.writeStillness(0, 0, 0, 0, continuation);
            if (writeStillness2 == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return writeStillness2;
            }
            return Unit.INSTANCE;
        }
        AppFeatureGetMovingParams stillnessParameters = getDeviceDataSync().getStillnessParameters();
        if (stillnessParameters != null && (writeStillness = watchIO.writeStillness(stillnessParameters.getTimeout(), stillnessParameters.getWindow(), stillnessParameters.getStart(), stillnessParameters.getEnd(), continuation)) == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return writeStillness;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.animaconnected.watch.Watch
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doConnect(com.animaconnected.watch.device.WatchIO r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.animaconnected.watch.HybridWatch$doConnect$1
            if (r0 == 0) goto L13
            r0 = r15
            com.animaconnected.watch.HybridWatch$doConnect$1 r0 = (com.animaconnected.watch.HybridWatch$doConnect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.HybridWatch$doConnect$1 r0 = new com.animaconnected.watch.HybridWatch$doConnect$1
            r0.<init>(r13, r15)
        L18:
            java.lang.Object r15 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L55
            if (r2 == r5) goto L47
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r15)
            goto L9b
        L2e:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L36:
            java.lang.Object r14 = r0.L$2
            com.animaconnected.watch.HybridWatch r14 = (com.animaconnected.watch.HybridWatch) r14
            java.lang.Object r2 = r0.L$1
            com.animaconnected.watch.device.WatchIO r2 = (com.animaconnected.watch.device.WatchIO) r2
            java.lang.Object r4 = r0.L$0
            com.animaconnected.watch.HybridWatch r4 = (com.animaconnected.watch.HybridWatch) r4
            kotlin.ResultKt.throwOnFailure(r15)
            r11 = r4
            goto L7a
        L47:
            java.lang.Object r14 = r0.L$1
            com.animaconnected.watch.device.WatchIO r14 = (com.animaconnected.watch.device.WatchIO) r14
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.HybridWatch r2 = (com.animaconnected.watch.HybridWatch) r2
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r14
            r14 = r2
            goto L67
        L55:
            kotlin.ResultKt.throwOnFailure(r15)
            r0.L$0 = r13
            r0.L$1 = r14
            r0.label = r5
            java.lang.Object r15 = r13.initConfigs(r14, r0)
            if (r15 != r1) goto L65
            return r1
        L65:
            r15 = r14
            r14 = r13
        L67:
            r0.L$0 = r14
            r0.L$1 = r15
            r0.L$2 = r14
            r0.label = r4
            java.lang.Object r2 = r14.readCapabilities(r15, r0)
            if (r2 != r1) goto L76
            return r1
        L76:
            r11 = r14
            r12 = r2
            r2 = r15
            r15 = r12
        L7a:
            com.animaconnected.watch.device.Capabilities r15 = (com.animaconnected.watch.device.Capabilities) r15
            r14.setCapabilities(r15)
            java.lang.String r5 = "capabilities ready"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r4 = r11
            com.animaconnected.logger.LogKt.debug$default(r4, r5, r6, r7, r8, r9, r10)
            r14 = 0
            r0.L$0 = r14
            r0.L$1 = r14
            r0.L$2 = r14
            r0.label = r3
            java.lang.Object r14 = r11.resetCallStatus(r2, r0)
            if (r14 != r1) goto L9b
            return r1
        L9b:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.HybridWatch.doConnect(com.animaconnected.watch.device.WatchIO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.Watch
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doPostSync(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.HybridWatch$doPostSync$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.HybridWatch$doPostSync$1 r0 = (com.animaconnected.watch.HybridWatch$doPostSync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.HybridWatch$doPostSync$1 r0 = new com.animaconnected.watch.HybridWatch$doPostSync$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5e
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.HybridWatch r2 = (com.animaconnected.watch.HybridWatch) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L52
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.animaconnected.watch.device.WatchIO r6 = r5.getIo()
            if (r6 != 0) goto L46
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L46:
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.writeComplications(r6, r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            r2 = r5
        L52:
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r2.syncStepsTarget(r0)
            if (r6 != r1) goto L5e
            return r1
        L5e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.HybridWatch.doPostSync(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.animaconnected.watch.Watch
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doSync(boolean r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r7 = r8 instanceof com.animaconnected.watch.HybridWatch$doSync$1
            if (r7 == 0) goto L13
            r7 = r8
            com.animaconnected.watch.HybridWatch$doSync$1 r7 = (com.animaconnected.watch.HybridWatch$doSync$1) r7
            int r0 = r7.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r7.label = r0
            goto L18
        L13:
            com.animaconnected.watch.HybridWatch$doSync$1 r7 = new com.animaconnected.watch.HybridWatch$doSync$1
            r7.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r7.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r7.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L5d
            if (r1 == r5) goto L51
            if (r1 == r4) goto L45
            if (r1 == r3) goto L39
            if (r1 != r2) goto L31
            kotlin.ResultKt.throwOnFailure(r8)
            goto La1
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            java.lang.Object r1 = r7.L$1
            com.animaconnected.watch.device.WatchIO r1 = (com.animaconnected.watch.device.WatchIO) r1
            java.lang.Object r3 = r7.L$0
            com.animaconnected.watch.HybridWatch r3 = (com.animaconnected.watch.HybridWatch) r3
            kotlin.ResultKt.throwOnFailure(r8)
            goto L93
        L45:
            java.lang.Object r1 = r7.L$1
            com.animaconnected.watch.device.WatchIO r1 = (com.animaconnected.watch.device.WatchIO) r1
            java.lang.Object r4 = r7.L$0
            com.animaconnected.watch.HybridWatch r4 = (com.animaconnected.watch.HybridWatch) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L85
        L51:
            java.lang.Object r1 = r7.L$1
            com.animaconnected.watch.device.WatchIO r1 = (com.animaconnected.watch.device.WatchIO) r1
            java.lang.Object r5 = r7.L$0
            com.animaconnected.watch.HybridWatch r5 = (com.animaconnected.watch.HybridWatch) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L77
        L5d:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.watch.device.WatchIO r1 = r6.getIo()
            if (r1 != 0) goto L69
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L69:
            r7.L$0 = r6
            r7.L$1 = r1
            r7.label = r5
            java.lang.Object r8 = r6.writeRemoteComplicationDataConfigs(r1, r7)
            if (r8 != r0) goto L76
            return r0
        L76:
            r5 = r6
        L77:
            r7.L$0 = r5
            r7.L$1 = r1
            r7.label = r4
            java.lang.Object r8 = r5.writeRemoteComplicationData(r1, r7)
            if (r8 != r0) goto L84
            return r0
        L84:
            r4 = r5
        L85:
            r7.L$0 = r4
            r7.L$1 = r1
            r7.label = r3
            java.lang.Object r8 = r4.writeCommonSettings(r1, r7)
            if (r8 != r0) goto L92
            return r0
        L92:
            r3 = r4
        L93:
            r8 = 0
            r7.L$0 = r8
            r7.L$1 = r8
            r7.label = r2
            java.lang.Object r7 = r3.writeTimeZoneIfActive$watch_release(r1, r7)
            if (r7 != r0) goto La1
            return r0
        La1:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.HybridWatch.doSync(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.Watch
    public Object isFirmwareSupported(WatchIO watchIO, Continuation<? super Boolean> continuation) {
        return Boolean.TRUE;
    }

    @Override // com.animaconnected.watch.Watch
    public void resetConfigs() {
        LogKt.verbose$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.HybridWatch$resetConfigs$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Resetting configs";
            }
        }, 7, (Object) null);
        getResourceSynchronizer$watch_release().setConfigUnSynced(getIdentifier(), Command.VIBRATOR_CONFIG);
        getResourceSynchronizer$watch_release().setConfigUnSynced(getIdentifier(), Command.FITNESS_TARGETS);
        getResourceSynchronizer$watch_release().setConfigUnSynced(getIdentifier(), Command.STEPS_TARGET);
    }

    public final void updateRemoteComplication() {
        getDeviceDataSync().setRemoteComplicationDirty();
        reSync$watch_release();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeIncomingCall(int r8, boolean r9, java.lang.Integer r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.animaconnected.watch.HybridWatch$writeIncomingCall$1
            if (r0 == 0) goto L13
            r0 = r11
            com.animaconnected.watch.HybridWatch$writeIncomingCall$1 r0 = (com.animaconnected.watch.HybridWatch$writeIncomingCall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.HybridWatch$writeIncomingCall$1 r0 = new com.animaconnected.watch.HybridWatch$writeIncomingCall$1
            r0.<init>(r7, r11)
        L18:
            r6 = r0
            java.lang.Object r11 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            boolean r9 = r6.Z$0
            java.lang.Object r8 = r6.L$0
            com.animaconnected.watch.HybridWatch r8 = (com.animaconnected.watch.HybridWatch) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5b
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            com.animaconnected.watch.device.WatchIO r1 = r7.getIo()
            if (r1 != 0) goto L42
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L42:
            com.animaconnected.watch.device.Capabilities r11 = r7.getCapabilities()
            boolean r5 = r11.getHasCallRepeatsAlert()
            r6.L$0 = r7
            r6.Z$0 = r9
            r6.label = r2
            r2 = r8
            r3 = r9
            r4 = r10
            java.lang.Object r8 = r1.writeIncomingCall(r2, r3, r4, r5, r6)
            if (r8 != r0) goto L5a
            return r0
        L5a:
            r8 = r7
        L5b:
            com.animaconnected.watch.device.BasicStorage r8 = r8.getStorage$watch_release()
            java.lang.String r10 = "call-status-is-ringing"
            r8.put(r10, r9)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.HybridWatch.writeIncomingCall(int, boolean, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.Watch
    public void doDisconnect() {
    }
}
