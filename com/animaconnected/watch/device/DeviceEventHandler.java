package com.animaconnected.watch.device;

import com.animaconnected.logger.LogKt;
import com.animaconnected.msgpack.MsgPack;
import com.animaconnected.msgpack.MsgPackCreator;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.fitness.FitnessMetric;
import com.animaconnected.watch.fitness.SpeedCalibrationFailed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeviceEventHandler.kt */
/* loaded from: classes3.dex */
public final class DeviceEventHandler implements EventHandler {
    private final CommandCenter commandCenter;
    private final Lazy io$delegate;
    private final FullWatchEventListener listener;
    private final MsgPackCreator msgPackCreator;
    private final CoroutineScope scope;
    private final String tag;

    /* compiled from: DeviceEventHandler.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FileResult.values().length];
            try {
                r0[FileResult.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FileResult.Changed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public DeviceEventHandler(final Watch watch, FullWatchEventListener listener) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.commandCenter = watch.getCommandCenter();
        this.msgPackCreator = watch.getMsgPackCreator$watch_release();
        this.io$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WatchIO>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$io$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WatchIO invoke() {
                return Watch.this.getIo();
            }
        });
        this.scope = ServiceLocator.INSTANCE.getScope();
        this.tag = "DeviceEventHandler";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WatchIO getIo() {
        return (WatchIO) this.io$delegate.getValue();
    }

    private final MsgPack unpackReceivedValue(byte[] bArr) {
        boolean z;
        if (bArr != null) {
            if (bArr.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return this.msgPackCreator.newEmpty();
            }
        }
        MsgPackCreator msgPackCreator = this.msgPackCreator;
        Intrinsics.checkNotNull(bArr);
        return msgPackCreator.fromBytes(bArr);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0083. Please report as an issue. */
    @Override // com.animaconnected.watch.device.EventHandler
    public void handleEvent(byte[] data) {
        Integer valueOf;
        Integer num;
        int r1;
        int r3;
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            Map<Integer, MsgPack> map = unpackReceivedValue(data).getMap();
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<Integer, MsgPack> entry : map.entrySet()) {
                arrayList.add(new Pair(entry.getKey(), entry.getValue()));
            }
            final Map translate$watch_release = this.commandCenter.translate$watch_release(MapsKt__MapsKt.toMap(arrayList));
            LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "notification: ".concat(CollectionsKt___CollectionsKt.joinToString$default(translate$watch_release.keySet(), null, null, null, null, 63));
                }
            }, 6, (Object) null);
            for (Map.Entry entry2 : translate$watch_release.entrySet()) {
                final String str = (String) entry2.getKey();
                final MsgPack msgPack = (MsgPack) entry2.getValue();
                Integer num2 = null;
                UInt uInt = null;
                boolean z = true;
                int r10 = 0;
                switch (str.hashCode()) {
                    case -1986501434:
                        if (str.equals(Command.DIAGNOSTICS_EVENT)) {
                            BuildersKt.launch$default(this.scope, null, null, new DeviceEventHandler$handleEvent$5(this, msgPack, null), 3);
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case -1936089172:
                        if (str.equals(Command.POSTMORTEM)) {
                            this.listener.onDevicePostMortem();
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case -1931153238:
                        if (str.equals(Command.SESSION_DATA)) {
                            Map<Integer, MsgPack> map2 = msgPack.getMap();
                            ArrayList arrayList2 = new ArrayList(map2.size());
                            for (Map.Entry<Integer, MsgPack> entry3 : map2.entrySet()) {
                                FitnessMetric parse = FitnessMetric.Companion.parse(this.commandCenter.translate$watch_release(entry3.getKey().intValue()));
                                if (entry3.getValue().isNilValue()) {
                                    valueOf = null;
                                } else {
                                    valueOf = Integer.valueOf(entry3.getValue().asInt());
                                }
                                arrayList2.add(new Pair(parse, valueOf));
                            }
                            this.listener.onSessionData(MapsKt__MapsKt.toMap(arrayList2));
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case -1840271677:
                        if (str.equals(Command.DEBUG_RSSI)) {
                            this.listener.onRssiEvent(msgPack.asInt());
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case -1383015736:
                        if (str.equals(Command.CSEM_SPEED_CALIB)) {
                            if (msgPack.isIntegerValue()) {
                                num2 = Integer.valueOf(msgPack.asInt());
                            } else if (msgPack.isArrayValue()) {
                                num2 = Integer.valueOf(msgPack.asList().get(0).asInt());
                            }
                            int id = SpeedCalibrationFailed.INSTANCE.getId();
                            if (num2 != null && num2.intValue() == id) {
                                this.listener.onSpeedCalibrationFailed();
                            }
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                        break;
                    case -1377687758:
                        if (str.equals(Command.BUTTON)) {
                            List<MsgPack> asList = msgPack.asList();
                            Button parse$watch_release = Button.Companion.parse$watch_release(Integer.valueOf(asList.get(0).asInt()));
                            if (parse$watch_release != null) {
                                ButtonAction parse$watch_release2 = ButtonAction.Companion.parse$watch_release(Integer.valueOf(asList.get(1).asInt()));
                                if (parse$watch_release2 != null) {
                                    this.listener.onDeviceButtonClicked(parse$watch_release, parse$watch_release2);
                                } else {
                                    throw new IllegalArgumentException(("Invalid Button Action id " + asList.get(1).asInt()).toString());
                                }
                            } else {
                                throw new IllegalArgumentException(("Invalid Button id " + asList.get(0).asInt()).toString());
                            }
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case -515491915:
                        if (str.equals(Command.REMOVE_NOTIF)) {
                            final int asInt = msgPack.asInt();
                            LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$7
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Dismiss notification. notificationId: " + asInt;
                                }
                            }, 6, (Object) null);
                            this.listener.onNotificationDismissed(asInt);
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case -262332660:
                        if (str.equals(Command.CSEM_LOGS)) {
                            this.listener.onCSEMLog(msgPack);
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 3643:
                        if (str.equals(Command.FILE_REMOVE)) {
                            List<MsgPack> asList2 = msgPack.asList();
                            this.listener.mo1049onFileDeleteResultQn1smSk(FileResult.Companion.fromStatus(asList2.get(1).asInt()), (int) asList2.get(0).asLong());
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 97301:
                        if (str.equals(Command.BATTERY)) {
                            List<MsgPack> asList3 = msgPack.asList();
                            if (asList3.size() == 2) {
                                final int asInt2 = asList3.get(0).asInt();
                                int asInt3 = asList3.get(1).asInt();
                                if (asInt2 != 0) {
                                    if (asInt2 != 1) {
                                        LogKt.err$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final String invoke() {
                                                return "bat error: invalid state: " + asInt2;
                                            }
                                        }, 7, (Object) null);
                                    } else {
                                        FullWatchEventListener fullWatchEventListener = this.listener;
                                        if (asInt3 != 1) {
                                            z = false;
                                        }
                                        fullWatchEventListener.onBatteryCharger(z);
                                    }
                                } else {
                                    this.listener.onBatteryPercent(RangesKt___RangesKt.coerceIn(asInt3 / 100.0f, 0.0f, 1.0f));
                                }
                            }
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 3045982:
                        if (str.equals("call")) {
                            this.listener.onPressDuringCall(msgPack.asInt());
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 3143036:
                        if (str.equals("file")) {
                            List<MsgPack> asList4 = msgPack.asList();
                            int asLong = (int) asList4.get(0).asLong();
                            FileResult fromStatus = FileResult.Companion.fromStatus(asList4.get(1).asInt());
                            if (asList4.size() >= 3) {
                                num = Integer.valueOf(asList4.get(2).asInt());
                            } else {
                                num = null;
                            }
                            if (asList4.size() >= 4) {
                                uInt = new UInt((int) asList4.get(3).asLong());
                            }
                            int r12 = WhenMappings.$EnumSwitchMapping$0[fromStatus.ordinal()];
                            if (r12 != 1) {
                                if (r12 != 2) {
                                    InternalEvents.m1068onFileWriteResultmiZAcA0$default(this.listener, fromStatus, asLong, null, null, 12, null);
                                } else {
                                    this.listener.mo1048onFileChangedkosIJfI(asLong, num, uInt);
                                }
                            } else {
                                this.listener.mo1050onFileWriteResultmiZAcA0(fromStatus, asLong, num, uInt);
                            }
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 73085171:
                        if (str.equals(Command.CONNECTION_INT_CHANGE)) {
                            List<MsgPack> asList5 = msgPack.asList();
                            if (asList5.size() == 3) {
                                this.listener.onConnIntChange(asList5.get(0).asInt(), asList5.get(1).asInt(), asList5.get(2).asInt());
                            }
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 92895825:
                        if (str.equals(Command.ALARM)) {
                            this.listener.onAlarm(msgPack.asInt());
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 92899676:
                        if (str.equals(Command.ALERT)) {
                            List<MsgPack> asList6 = msgPack.asList();
                            if (asList6.size() == 5) {
                                this.listener.onAlert(asList6.get(0).asInt(), asList6.get(1).asInt(), asList6.get(2).asInt(), asList6.get(3).asInt(), asList6.get(4).asInt());
                            }
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 94921639:
                        if (str.equals(Command.CRASH)) {
                            BuildersKt.launch$default(this.scope, null, null, new DeviceEventHandler$handleEvent$2(msgPack, this, null), 3);
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 96784904:
                        if (str.equals("error")) {
                            final int asInt4 = msgPack.asInt();
                            DeviceError fromErrorCode = DeviceError.Companion.fromErrorCode(asInt4);
                            if (fromErrorCode != null) {
                                this.listener.onDeviceError(fromErrorCode);
                            } else {
                                LogKt.err$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "DeviceEventHandler: error code: " + asInt4;
                                    }
                                }, 7, (Object) null);
                            }
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 103950895:
                        if (str.equals(Command.DIRECTORY)) {
                            List<MsgPack> asList7 = msgPack.asList();
                            InternalEvents.m1068onFileWriteResultmiZAcA0$default(this.listener, FileResult.Companion.fromStatus(asList7.get(1).asInt()), (int) asList7.get(0).asLong(), null, null, 12, null);
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 497375231:
                        if (str.equals(Command.STILLNESS)) {
                            this.listener.onStillnessEvent(msgPack.asInt());
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 926934164:
                        if (str.equals(Command.HISTORY)) {
                            this.listener.onNewFitnessData();
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 1362870718:
                        if (str.equals(Command.STEPS_NOW)) {
                            List<MsgPack> asList8 = msgPack.asList();
                            if (asList8.size() == 2 || asList8.size() == 4) {
                                int asInt5 = asList8.get(0).asInt();
                                if (asList8.size() == 2) {
                                    r1 = asList8.get(1).asInt();
                                    r3 = 0;
                                } else if (asList8.size() == 4) {
                                    r10 = asList8.get(1).asInt();
                                    r3 = asList8.get(2).asInt();
                                    r1 = asList8.get(3).asInt();
                                } else {
                                    r1 = 0;
                                    r3 = 0;
                                }
                                this.listener.onStepsNow(asInt5, r10, r3, r1);
                            }
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                        break;
                    case 1635738268:
                        if (str.equals(Command.FITNESS_HEARTRATE_LIVE)) {
                            BuildersKt.launch$default(this.scope, null, null, new DeviceEventHandler$handleEvent$6(msgPack, this, null), 3);
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 1651731981:
                        if (str.equals(Command.STOPWATCH)) {
                            this.listener.onStopwatchDataChanged();
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    case 1852185752:
                        if (str.equals(Command.ACTION_APP)) {
                            List<MsgPack> asList9 = msgPack.asList();
                            this.listener.onAppAction(AppId.Companion.fromStatus(asList9.get(0).asInt()), asList9.get(1).asInt(), AppAction.Companion.parse$watch_release(asList9.get(2).asInt()));
                        } else {
                            LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Not handling key " + str + " with value " + msgPack;
                                }
                            }, 6, (Object) null);
                        }
                    default:
                        LogKt.warn$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Not handling key " + str + " with value " + msgPack;
                            }
                        }, 6, (Object) null);
                }
            }
        } catch (Exception e) {
            LogKt.err$default((Object) this, this.tag, (Throwable) e, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to parse notification data: " + e;
                }
            }, 4, (Object) null);
        }
    }
}
