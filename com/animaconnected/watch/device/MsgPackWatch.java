package com.animaconnected.watch.device;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import com.animaconnected.msgpack.MsgPack;
import com.animaconnected.msgpack.MsgPackCreator;
import com.animaconnected.watch.device.files.WatchFileSystem;
import com.animaconnected.watch.display.VisibilityState;
import com.animaconnected.watch.fitness.FitnessMetric;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MsgPackWatch.kt */
/* loaded from: classes3.dex */
public final class MsgPackWatch implements WatchIO, WatchIODebug {
    private static final int CONFIG_VIBRATOR_FIRST_VIBRATION = 8;
    public static final Companion Companion = new Companion(null);
    private static final long TEST_FCTE_DELAY = 2000;
    private final List<FitnessMetric> activityMetrics;
    private final WatchBackend backend;
    private CommandCenter commandCenter;
    private String deviceName;
    private DeviceWriter deviceWriter;
    private final List<String> filesToReadOnConnect;
    private boolean isDebugEnabled;
    private MsgPackCreator msgPackCreator;

    /* compiled from: MsgPackWatch.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: MsgPackWatch.kt */
    /* loaded from: classes3.dex */
    public static final class WatchTimestamp {
        private final int count;
        private final int timestamp;

        public WatchTimestamp(int r1, int r2) {
            this.timestamp = r1;
            this.count = r2;
        }

        public static /* synthetic */ WatchTimestamp copy$default(WatchTimestamp watchTimestamp, int r1, int r2, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                r1 = watchTimestamp.timestamp;
            }
            if ((r3 & 2) != 0) {
                r2 = watchTimestamp.count;
            }
            return watchTimestamp.copy(r1, r2);
        }

        public final int component1() {
            return this.timestamp;
        }

        public final int component2() {
            return this.count;
        }

        public final WatchTimestamp copy(int r2, int r3) {
            return new WatchTimestamp(r2, r3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WatchTimestamp)) {
                return false;
            }
            WatchTimestamp watchTimestamp = (WatchTimestamp) obj;
            if (this.timestamp == watchTimestamp.timestamp && this.count == watchTimestamp.count) {
                return true;
            }
            return false;
        }

        public final int getCount() {
            return this.count;
        }

        public final int getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return Integer.hashCode(this.count) + (Integer.hashCode(this.timestamp) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("WatchTimestamp(timestamp=");
            sb.append(this.timestamp);
            sb.append(", count=");
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.count, ')');
        }
    }

    /* compiled from: MsgPackWatch.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[FitnessMetric.values().length];
            try {
                r0[FitnessMetric.Heartrate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FitnessMetric.HeartrateLow.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FitnessMetric.HeartrateHigh.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[VisibilityState.values().length];
            try {
                r02[VisibilityState.Stopped.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    public MsgPackWatch(WatchBackend backend, boolean z) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        this.backend = backend;
        this.filesToReadOnConnect = CollectionsKt__CollectionsKt.listOf(WatchFileSystem.prefsDir);
        this.isDebugEnabled = z;
        this.activityMetrics = CollectionsKt__CollectionsKt.listOf((Object[]) new FitnessMetric[]{FitnessMetric.ActivityClass, FitnessMetric.WalkSteps, FitnessMetric.RunSteps, FitnessMetric.OtherSteps, FitnessMetric.Cadence, FitnessMetric.Speed, FitnessMetric.Distance, FitnessMetric.EnergyExpenditure});
    }

    private final MsgPack decodeReturnMap(int r4, MsgPack msgPack) {
        if (msgPack.isNilValue()) {
            return msgPack;
        }
        Map<Integer, MsgPack> map = msgPack.getMap();
        if (map.size() == 1) {
            Map.Entry entry = (Map.Entry) CollectionsKt___CollectionsKt.first(map.entrySet());
            int intValue = ((Number) entry.getKey()).intValue();
            MsgPack msgPack2 = (MsgPack) entry.getValue();
            if (intValue == r4) {
                return msgPack2;
            }
            throw new IOException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Expected read map's key ", r4, " but got ", intValue));
        }
        throw new IOException("Expected read map to contain 1 key, but it has size " + map.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchDefinition(java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$fetchDefinition$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$fetchDefinition$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$fetchDefinition$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$fetchDefinition$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$fetchDefinition$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "commandCenter"
            r5 = 1
            if (r2 == 0) goto L3a
            if (r2 != r5) goto L32
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r0 = (com.animaconnected.watch.device.MsgPackWatch) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L55
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.watch.device.CommandCenter r8 = r6.commandCenter
            if (r8 == 0) goto L66
            boolean r8 = r8.isMapKnown$watch_release(r7)
            if (r8 != 0) goto L63
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r6.readPages(r7, r0)
            if (r8 != r1) goto L54
            return r1
        L54:
            r0 = r6
        L55:
            java.util.Map r8 = (java.util.Map) r8
            com.animaconnected.watch.device.CommandCenter r0 = r0.commandCenter
            if (r0 == 0) goto L5f
            r0.parseDefinitionMapAndCache$watch_release(r7, r8)
            goto L63
        L5f:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            throw r3
        L63:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L66:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.fetchDefinition(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final List<Integer> getHrValues(MsgPack msgPack) {
        List<MsgPack> asList = msgPack.asList();
        if (asList.size() == 2) {
            return CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(asList.get(0).asInt()), Integer.valueOf(asList.get(1).asInt())});
        }
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Void[]{null, null});
    }

    private final boolean isActivityEntry(Map<FitnessMetric, ? extends MsgPack> map) {
        Set<FitnessMetric> keySet = map.keySet();
        if ((keySet instanceof Collection) && keySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = keySet.iterator();
        while (it.hasNext()) {
            if (this.activityMetrics.contains((FitnessMetric) it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object read(String str, int[] r12, Continuation<? super MsgPack> continuation) {
        Object[] objArr = new Object[1];
        MsgPackCreator msgPackCreator = this.msgPackCreator;
        if (msgPackCreator != null) {
            ArrayList arrayList = new ArrayList(r12.length);
            for (int r8 : r12) {
                MsgPackCreator msgPackCreator2 = this.msgPackCreator;
                if (msgPackCreator2 != null) {
                    arrayList.add(msgPackCreator2.newInt(r8));
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("msgPackCreator");
                    throw null;
                }
            }
            objArr[0] = msgPackCreator.newArray(arrayList.toArray(new MsgPack[0]));
            return readArray(str, objArr, continuation);
        }
        Intrinsics.throwUninitializedPropertyAccessException("msgPackCreator");
        throw null;
    }

    public static /* synthetic */ Object read$default(MsgPackWatch msgPackWatch, String str, int[] r2, Continuation continuation, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            r2 = new int[0];
        }
        return msgPackWatch.read(str, r2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readArray(final java.lang.String r16, final java.lang.Object[] r17, kotlin.coroutines.Continuation<? super com.animaconnected.msgpack.MsgPack> r18) {
        /*
            r15 = this;
            r7 = r15
            r8 = r16
            r9 = r17
            r0 = r18
            boolean r1 = r0 instanceof com.animaconnected.watch.device.MsgPackWatch$readArray$1
            if (r1 == 0) goto L1a
            r1 = r0
            com.animaconnected.watch.device.MsgPackWatch$readArray$1 r1 = (com.animaconnected.watch.device.MsgPackWatch$readArray$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L1a
            int r2 = r2 - r3
            r1.label = r2
            goto L1f
        L1a:
            com.animaconnected.watch.device.MsgPackWatch$readArray$1 r1 = new com.animaconnected.watch.device.MsgPackWatch$readArray$1
            r1.<init>(r15, r0)
        L1f:
            r10 = r1
            java.lang.Object r0 = r10.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r11 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r10.label
            r12 = 1
            if (r1 == 0) goto L3d
            if (r1 != r12) goto L35
            int r1 = r10.I$0
            java.lang.Object r2 = r10.L$0
            com.animaconnected.watch.device.MsgPackWatch r2 = (com.animaconnected.watch.device.MsgPackWatch) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L72
        L35:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3d:
            kotlin.ResultKt.throwOnFailure(r0)
            com.animaconnected.watch.device.CommandCenter r0 = r7.commandCenter
            r13 = 0
            if (r0 == 0) goto L8b
            int r14 = r0.getCommandNumber$watch_release(r8)
            if (r14 < 0) goto L7f
            boolean r0 = r15.isDebugEnabled()
            if (r0 == 0) goto L5f
            r1 = 0
            r2 = 0
            r3 = 0
            com.animaconnected.watch.device.MsgPackWatch$readArray$2 r4 = new com.animaconnected.watch.device.MsgPackWatch$readArray$2
            r4.<init>()
            r5 = 7
            r6 = 0
            r0 = r15
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
        L5f:
            com.animaconnected.watch.device.DeviceWriter r0 = r7.deviceWriter
            if (r0 == 0) goto L79
            r10.L$0 = r7
            r10.I$0 = r14
            r10.label = r12
            java.lang.Object r0 = r0.read(r8, r9, r10)
            if (r0 != r11) goto L70
            return r11
        L70:
            r2 = r7
            r1 = r14
        L72:
            com.animaconnected.msgpack.MsgPack r0 = (com.animaconnected.msgpack.MsgPack) r0
            com.animaconnected.msgpack.MsgPack r0 = r2.decodeReturnMap(r1, r0)
            return r0
        L79:
            java.lang.String r0 = "deviceWriter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r13
        L7f:
            com.animaconnected.watch.device.IOException r0 = new com.animaconnected.watch.device.IOException
            java.lang.String r1 = "No such command found: "
            java.lang.String r1 = androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0.m(r1, r8)
            r0.<init>(r1)
            throw r0
        L8b:
            java.lang.String r0 = "commandCenter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readArray(java.lang.String, java.lang.Object[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object readArray$default(MsgPackWatch msgPackWatch, String str, Object[] objArr, Continuation continuation, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            objArr = new Object[0];
        }
        return msgPackWatch.readArray(str, objArr, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readIntStringMap(final java.lang.String r10, java.lang.Integer r11, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.Integer, java.lang.String>> r12) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readIntStringMap(java.lang.String, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object readIntStringMap$default(MsgPackWatch msgPackWatch, String str, Integer num, Continuation continuation, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            num = null;
        }
        return msgPackWatch.readIntStringMap(str, num, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readIntValMap(java.lang.String r8, java.lang.Integer r9, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.Integer, ? extends com.animaconnected.msgpack.MsgPack>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.device.MsgPackWatch$readIntValMap$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.device.MsgPackWatch$readIntValMap$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readIntValMap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readIntValMap$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readIntValMap$1
            r0.<init>(r7, r10)
        L18:
            r4 = r0
            java.lang.Object r10 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L37
            if (r1 == r3) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r10)
            goto L5f
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L4b
        L37:
            kotlin.ResultKt.throwOnFailure(r10)
            if (r9 != 0) goto L4e
            r9 = 0
            r5 = 2
            r6 = 0
            r4.label = r3
            r1 = r7
            r2 = r8
            r3 = r9
            java.lang.Object r10 = read$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L4b
            return r0
        L4b:
            com.animaconnected.msgpack.MsgPack r10 = (com.animaconnected.msgpack.MsgPack) r10
            goto L61
        L4e:
            int r9 = r9.intValue()
            int[] r9 = new int[]{r9}
            r4.label = r2
            java.lang.Object r10 = r7.read(r8, r9, r4)
            if (r10 != r0) goto L5f
            return r0
        L5f:
            com.animaconnected.msgpack.MsgPack r10 = (com.animaconnected.msgpack.MsgPack) r10
        L61:
            boolean r8 = r10.isNilValue()
            if (r8 != 0) goto L9e
            java.util.Map r8 = r10.getMap()
            java.util.ArrayList r9 = new java.util.ArrayList
            int r10 = r8.size()
            r9.<init>(r10)
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L7c:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L99
            java.lang.Object r10 = r8.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r0 = r10.getKey()
            java.lang.Object r10 = r10.getValue()
            kotlin.Pair r1 = new kotlin.Pair
            r1.<init>(r0, r10)
            r9.add(r1)
            goto L7c
        L99:
            java.util.Map r8 = kotlin.collections.MapsKt__MapsKt.toMap(r9)
            goto La0
        L9e:
            kotlin.collections.EmptyMap r8 = kotlin.collections.EmptyMap.INSTANCE
        La0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readIntValMap(java.lang.String, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object readIntValMap$default(MsgPackWatch msgPackWatch, String str, Integer num, Continuation continuation, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            num = null;
        }
        return msgPackWatch.readIntValMap(str, num, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00b8 -> B:11:0x00bb). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readPages(java.lang.String r11, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.Integer, java.lang.String>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.animaconnected.watch.device.MsgPackWatch$readPages$1
            if (r0 == 0) goto L13
            r0 = r12
            com.animaconnected.watch.device.MsgPackWatch$readPages$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readPages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readPages$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readPages$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L56
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            int r11 = r0.I$0
            java.lang.Object r2 = r0.L$2
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r6 = (com.animaconnected.watch.device.MsgPackWatch) r6
            kotlin.ResultKt.throwOnFailure(r12)
            goto Lbb
        L39:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L41:
            int r11 = r0.I$0
            java.lang.Object r2 = r0.L$2
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r6 = (com.animaconnected.watch.device.MsgPackWatch) r6
            kotlin.ResultKt.throwOnFailure(r12)
            r9 = r5
            r5 = r11
            r11 = r9
            goto L76
        L56:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.lang.Integer r12 = new java.lang.Integer
            r5 = 0
            r12.<init>(r5)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r2
            r0.I$0 = r5
            r0.label = r4
            java.lang.Object r12 = r10.readIntStringMap(r11, r12, r0)
            if (r12 != r1) goto L75
            return r1
        L75:
            r6 = r10
        L76:
            java.util.Map r12 = (java.util.Map) r12
            r9 = r5
            r5 = r11
            r11 = r9
        L7b:
            boolean r7 = r12.isEmpty()
            r7 = r7 ^ r4
            if (r7 == 0) goto Lbe
            java.util.Set r12 = r12.entrySet()
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L8c:
            boolean r7 = r12.hasNext()
            if (r7 == 0) goto La4
            java.lang.Object r7 = r12.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getKey()
            java.lang.Object r7 = r7.getValue()
            r2.put(r8, r7)
            goto L8c
        La4:
            int r11 = r11 + r4
            java.lang.Integer r12 = new java.lang.Integer
            r12.<init>(r11)
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r0.I$0 = r11
            r0.label = r3
            java.lang.Object r12 = r6.readIntStringMap(r5, r12, r0)
            if (r12 != r1) goto Lbb
            return r1
        Lbb:
            java.util.Map r12 = (java.util.Map) r12
            goto L7b
        Lbe:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readPages(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0068 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0056 -> B:10:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readPostMortem(kotlin.coroutines.Continuation<? super java.util.List<? extends com.animaconnected.msgpack.MsgPack>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$readPostMortem$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$readPostMortem$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readPostMortem$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readPostMortem$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readPostMortem$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$1
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r5 = (com.animaconnected.watch.device.MsgPackWatch) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L59
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L39:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r2 = 0
            r5 = r7
            r4 = r8
        L44:
            int[] r8 = new int[]{r2}
            r0.L$0 = r5
            r0.L$1 = r4
            r0.I$0 = r2
            r0.label = r3
            java.lang.String r6 = "postmortem"
            java.lang.Object r8 = r5.read(r6, r8, r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            com.animaconnected.msgpack.MsgPack r8 = (com.animaconnected.msgpack.MsgPack) r8
            r4.add(r8)
            byte[] r8 = r8.asByteArray()
            int r8 = r8.length
            int r2 = r2 + r3
            r6 = 500(0x1f4, float:7.0E-43)
            if (r8 >= r6) goto L44
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readPostMortem(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readStringMap(final java.lang.String r13, final java.lang.String r14, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.animaconnected.watch.device.MsgPackWatch$readStringMap$1
            if (r0 == 0) goto L13
            r0 = r15
            com.animaconnected.watch.device.MsgPackWatch$readStringMap$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readStringMap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readStringMap$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readStringMap$1
            r0.<init>(r12, r15)
        L18:
            r4 = r0
            java.lang.Object r15 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L48
            if (r1 == r3) goto L3c
            if (r1 != r2) goto L34
            java.lang.Object r13 = r4.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r4.L$0
            com.animaconnected.watch.device.MsgPackWatch r14 = (com.animaconnected.watch.device.MsgPackWatch) r14
            kotlin.ResultKt.throwOnFailure(r15)
        L32:
            r0 = r14
            goto L7f
        L34:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3c:
            java.lang.Object r13 = r4.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r4.L$0
            com.animaconnected.watch.device.MsgPackWatch r14 = (com.animaconnected.watch.device.MsgPackWatch) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L6d
        L48:
            kotlin.ResultKt.throwOnFailure(r15)
            boolean r15 = r12.isDebugEnabled()
            if (r15 == 0) goto L5f
            r6 = 0
            r7 = 0
            r8 = 0
            com.animaconnected.watch.device.MsgPackWatch$readStringMap$2 r9 = new com.animaconnected.watch.device.MsgPackWatch$readStringMap$2
            r9.<init>()
            r10 = 7
            r11 = 0
            r5 = r12
            com.animaconnected.logger.LogKt.debug$default(r5, r6, r7, r8, r9, r10, r11)
        L5f:
            r4.L$0 = r12
            r4.L$1 = r13
            r4.label = r3
            java.lang.Object r14 = r12.fetchDefinition(r14, r4)
            if (r14 != r0) goto L6c
            return r0
        L6c:
            r14 = r12
        L6d:
            r3 = 0
            r5 = 2
            r6 = 0
            r4.L$0 = r14
            r4.L$1 = r13
            r4.label = r2
            r1 = r14
            r2 = r13
            java.lang.Object r15 = readIntStringMap$default(r1, r2, r3, r4, r5, r6)
            if (r15 != r0) goto L32
            return r0
        L7f:
            java.util.Map r15 = (java.util.Map) r15
            com.animaconnected.watch.device.CommandCenter r14 = r0.commandCenter
            if (r14 == 0) goto L9d
            java.util.Map r14 = r14.translate$watch_release(r15)
            boolean r15 = r0.isDebugEnabled()
            if (r15 == 0) goto L9c
            r1 = 0
            r2 = 0
            r3 = 0
            com.animaconnected.watch.device.MsgPackWatch$readStringMap$3 r4 = new com.animaconnected.watch.device.MsgPackWatch$readStringMap$3
            r4.<init>()
            r5 = 7
            r6 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
        L9c:
            return r14
        L9d:
            java.lang.String r13 = "commandCenter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r13)
            r13 = 0
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readStringMap(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readStringMapPages(final java.lang.String r13, final java.lang.String r14, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.animaconnected.watch.device.MsgPackWatch$readStringMapPages$1
            if (r0 == 0) goto L13
            r0 = r15
            com.animaconnected.watch.device.MsgPackWatch$readStringMapPages$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readStringMapPages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readStringMapPages$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readStringMapPages$1
            r0.<init>(r12, r15)
        L18:
            java.lang.Object r15 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r13 = r0.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r14 = (com.animaconnected.watch.device.MsgPackWatch) r14
            kotlin.ResultKt.throwOnFailure(r15)
        L31:
            r0 = r14
            goto L79
        L33:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3b:
            java.lang.Object r13 = r0.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r14 = (com.animaconnected.watch.device.MsgPackWatch) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L6c
        L47:
            kotlin.ResultKt.throwOnFailure(r15)
            boolean r15 = r12.isDebugEnabled()
            if (r15 == 0) goto L5e
            r6 = 0
            r7 = 0
            r8 = 0
            com.animaconnected.watch.device.MsgPackWatch$readStringMapPages$2 r9 = new com.animaconnected.watch.device.MsgPackWatch$readStringMapPages$2
            r9.<init>()
            r10 = 7
            r11 = 0
            r5 = r12
            com.animaconnected.logger.LogKt.debug$default(r5, r6, r7, r8, r9, r10, r11)
        L5e:
            r0.L$0 = r12
            r0.L$1 = r13
            r0.label = r4
            java.lang.Object r14 = r12.fetchDefinition(r14, r0)
            if (r14 != r1) goto L6b
            return r1
        L6b:
            r14 = r12
        L6c:
            r0.L$0 = r14
            r0.L$1 = r13
            r0.label = r3
            java.lang.Object r15 = r14.readPages(r13, r0)
            if (r15 != r1) goto L31
            return r1
        L79:
            java.util.Map r15 = (java.util.Map) r15
            com.animaconnected.watch.device.CommandCenter r14 = r0.commandCenter
            if (r14 == 0) goto L97
            java.util.Map r14 = r14.translate$watch_release(r15)
            boolean r15 = r0.isDebugEnabled()
            if (r15 == 0) goto L96
            r1 = 0
            r2 = 0
            r3 = 0
            com.animaconnected.watch.device.MsgPackWatch$readStringMapPages$3 r4 = new com.animaconnected.watch.device.MsgPackWatch$readStringMapPages$3
            r4.<init>()
            r5 = 7
            r6 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
        L96:
            return r14
        L97:
            java.lang.String r13 = "commandCenter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r13)
            r13 = 0
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readStringMapPages(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final long toAppTimestamp(WatchTimestamp watchTimestamp) {
        return (watchTimestamp.getTimestamp() * 1000) + watchTimestamp.getCount();
    }

    private final WatchTimestamp toWatchTimestamp(long j) {
        int r4;
        int r0 = (int) (j % 1000);
        if (j != 0) {
            r4 = (int) (j / 1000);
        } else {
            r4 = 0;
        }
        return new WatchTimestamp(r4, r0);
    }

    /* renamed from: write-0E7RQCE$watch_release$default, reason: not valid java name */
    public static /* synthetic */ Object m1073write0E7RQCE$watch_release$default(MsgPackWatch msgPackWatch, String str, MsgPack msgPack, Continuation continuation, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            MsgPackCreator msgPackCreator = msgPackWatch.msgPackCreator;
            if (msgPackCreator != null) {
                msgPack = msgPackCreator.newInt(0);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("msgPackCreator");
                throw null;
            }
        }
        return msgPackWatch.m1079write0E7RQCE$watch_release(str, msgPack, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: writeArray-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1074writeArray0E7RQCE(java.lang.String r6, java.lang.Object[] r7, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$writeArray$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$writeArray$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeArray$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeArray$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeArray$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r6 = r8.value
            goto L4c
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.watch.device.DeviceWriter r8 = r5.deviceWriter
            r2 = 0
            if (r8 == 0) goto L53
            com.animaconnected.msgpack.MsgPackCreator r4 = r5.msgPackCreator
            if (r4 == 0) goto L4d
            com.animaconnected.msgpack.MsgPack r7 = r4.newArray(r7)
            r0.label = r3
            java.lang.Object r6 = r8.m1065write0E7RQCE(r6, r7, r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            return r6
        L4d:
            java.lang.String r6 = "msgPackCreator"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            throw r2
        L53:
            java.lang.String r6 = "deviceWriter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.m1074writeArray0E7RQCE(java.lang.String, java.lang.Object[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: writeBoolean-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1075writeBoolean0E7RQCE(java.lang.String r6, boolean r7, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$writeBoolean$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$writeBoolean$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeBoolean$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeBoolean$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeBoolean$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r6 = r8.value
            goto L4c
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.watch.device.DeviceWriter r8 = r5.deviceWriter
            r2 = 0
            if (r8 == 0) goto L53
            com.animaconnected.msgpack.MsgPackCreator r4 = r5.msgPackCreator
            if (r4 == 0) goto L4d
            com.animaconnected.msgpack.MsgPack r7 = r4.newBoolean(r7)
            r0.label = r3
            java.lang.Object r6 = r8.m1065write0E7RQCE(r6, r7, r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            return r6
        L4d:
            java.lang.String r6 = "msgPackCreator"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            throw r2
        L53:
            java.lang.String r6 = "deviceWriter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.m1075writeBoolean0E7RQCE(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: writeInt-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1076writeInt0E7RQCE(java.lang.String r6, int r7, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$writeInt$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$writeInt$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeInt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeInt$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeInt$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r6 = r8.value
            goto L4c
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.watch.device.DeviceWriter r8 = r5.deviceWriter
            r2 = 0
            if (r8 == 0) goto L53
            com.animaconnected.msgpack.MsgPackCreator r4 = r5.msgPackCreator
            if (r4 == 0) goto L4d
            com.animaconnected.msgpack.MsgPack r7 = r4.newInt(r7)
            r0.label = r3
            java.lang.Object r6 = r8.m1065write0E7RQCE(r6, r7, r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            return r6
        L4d:
            java.lang.String r6 = "msgPackCreator"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            throw r2
        L53:
            java.lang.String r6 = "deviceWriter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.m1076writeInt0E7RQCE(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: writeInts-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1077writeInts0E7RQCE(java.lang.String r9, int[] r10, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.animaconnected.watch.device.MsgPackWatch$writeInts$1
            if (r0 == 0) goto L13
            r0 = r11
            com.animaconnected.watch.device.MsgPackWatch$writeInts$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeInts$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeInts$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeInts$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result r11 = (kotlin.Result) r11
            java.lang.Object r9 = r11.value
            goto L63
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L33:
            kotlin.ResultKt.throwOnFailure(r11)
            com.animaconnected.watch.device.DeviceWriter r11 = r8.deviceWriter
            r2 = 0
            if (r11 == 0) goto L6a
            com.animaconnected.msgpack.MsgPackCreator r4 = r8.msgPackCreator
            if (r4 == 0) goto L64
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            int r2 = r10.length
            java.lang.Integer[] r2 = new java.lang.Integer[r2]
            int r5 = r10.length
            r6 = 0
        L49:
            if (r6 >= r5) goto L56
            r7 = r10[r6]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r2[r6] = r7
            int r6 = r6 + 1
            goto L49
        L56:
            com.animaconnected.msgpack.MsgPack r10 = r4.newArray(r2)
            r0.label = r3
            java.lang.Object r9 = r11.m1065write0E7RQCE(r9, r10, r0)
            if (r9 != r1) goto L63
            return r1
        L63:
            return r9
        L64:
            java.lang.String r9 = "msgPackCreator"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            throw r2
        L6a:
            java.lang.String r9 = "deviceWriter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.m1077writeInts0E7RQCE(java.lang.String, int[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeMap(java.lang.String r6, java.util.Map<java.lang.Integer, java.lang.Integer> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$writeMap$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$writeMap$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeMap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeMap$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeMap$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            r8.getClass()
            goto L4d
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.watch.device.DeviceWriter r8 = r5.deviceWriter
            r2 = 0
            if (r8 == 0) goto L56
            com.animaconnected.msgpack.MsgPackCreator r4 = r5.msgPackCreator
            if (r4 == 0) goto L50
            com.animaconnected.msgpack.MsgPack r7 = r4.newIntMap(r7)
            r0.label = r3
            java.lang.Object r6 = r8.m1065write0E7RQCE(r6, r7, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L50:
            java.lang.String r6 = "msgPackCreator"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            throw r2
        L56:
            java.lang.String r6 = "deviceWriter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeMap(java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.animaconnected.watch.device.WatchIO
    public int calculateFilePartSize(String fullName, int r5, Integer num) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        ArrayList mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(fullName, Integer.valueOf(r5), Integer.valueOf(r5), new byte[1]);
        if (num != null) {
            mutableListOf.add(num);
        }
        DeviceWriter deviceWriter = this.deviceWriter;
        if (deviceWriter != null) {
            MsgPackCreator msgPackCreator = this.msgPackCreator;
            if (msgPackCreator != null) {
                return 247 - deviceWriter.createWriteCommand("file", msgPackCreator.newArray(mutableListOf.toArray(new Serializable[0]))).getMsgpackAsBytes$watch_release().length;
            }
            Intrinsics.throwUninitializedPropertyAccessException("msgPackCreator");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deviceWriter");
        throw null;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public int calculateMaxReadFileBytes() {
        DeviceWriter deviceWriter = this.deviceWriter;
        if (deviceWriter != null) {
            MsgPackCreator msgPackCreator = this.msgPackCreator;
            if (msgPackCreator != null) {
                return 247 - deviceWriter.createWriteCommand("file", msgPackCreator.newArray(new byte[][]{new byte[1]})).getMsgpackAsBytes$watch_release().length;
            }
            Intrinsics.throwUninitializedPropertyAccessException("msgPackCreator");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deviceWriter");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object clearFitnessData(long r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$clearFitnessData$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$clearFitnessData$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$clearFitnessData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$clearFitnessData$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$clearFitnessData$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            r7.getClass()
            goto L52
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.device.MsgPackWatch$WatchTimestamp r5 = r4.toWatchTimestamp(r5)
            int r6 = r5.getTimestamp()
            int r5 = r5.getCount()
            int[] r5 = new int[]{r6, r5}
            r0.label = r3
            java.lang.String r6 = "history_clear"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L52
            return r1
        L52:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.clearFitnessData(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void connect$watch_release(MsgPackCreator msgPackCreator, CommandCenter commandCenter) {
        Intrinsics.checkNotNullParameter(msgPackCreator, "msgPackCreator");
        Intrinsics.checkNotNullParameter(commandCenter, "commandCenter");
        this.msgPackCreator = msgPackCreator;
        this.commandCenter = commandCenter;
        this.deviceWriter = new DeviceWriter(this.backend, commandCenter, msgPackCreator, false, 8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object deleteFile(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$deleteFile$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$deleteFile$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$deleteFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$deleteFile$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$deleteFile$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object[] r5 = new java.lang.Object[]{r5}
            r0.label = r3
            java.lang.String r6 = "rm"
            java.lang.Object r5 = r4.m1074writeArray0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.deleteFile(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object enableCSEMLogs(boolean r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$enableCSEMLogs$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$enableCSEMLogs$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$enableCSEMLogs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$enableCSEMLogs$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$enableCSEMLogs$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L42
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.String r6 = "csem_log_data"
            java.lang.Object r5 = r4.m1075writeBoolean0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.enableCSEMLogs(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public String getDeviceName() {
        return this.backend.getDeviceName();
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public List<String> getFilesToReadOnConnect() {
        return this.filesToReadOnConnect;
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object initCommandMap(Continuation<? super Unit> continuation) {
        Object fetchDefinition = fetchDefinition(Definition.MAP_CMD, continuation);
        if (fetchDefinition == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return fetchDefinition;
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public boolean isDebugEnabled() {
        return this.isDebugEnabled;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object parseFitnessMetric(java.util.Map<java.lang.Integer, ? extends com.animaconnected.msgpack.MsgPack> r13, kotlin.coroutines.Continuation<? super java.util.Map<com.animaconnected.watch.fitness.FitnessMetric, ? extends com.animaconnected.watch.fitness.MetricValue>> r14) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.parseFitnessMetric(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object prepareDiagnosticsMap(com.animaconnected.msgpack.MsgPack r5, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$prepareDiagnosticsMap$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$prepareDiagnosticsMap$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$prepareDiagnosticsMap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$prepareDiagnosticsMap$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$prepareDiagnosticsMap$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$1
            com.animaconnected.msgpack.MsgPack r5 = (com.animaconnected.msgpack.MsgPack) r5
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r0 = (com.animaconnected.watch.device.MsgPackWatch) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.String r6 = "map_diag_event"
            java.lang.Object r6 = r4.fetchDefinition(r6, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r0 = r4
        L4a:
            boolean r6 = r5.isNilValue()
            if (r6 != 0) goto L8b
            java.util.Map r5 = r5.getMap()
            java.util.ArrayList r6 = new java.util.ArrayList
            int r1 = r5.size()
            r6.<init>(r1)
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L65:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L86
            java.lang.Object r1 = r5.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = r1.toString()
            kotlin.Pair r3 = new kotlin.Pair
            r3.<init>(r2, r1)
            r6.add(r3)
            goto L65
        L86:
            java.util.Map r5 = kotlin.collections.MapsKt__MapsKt.toMap(r6)
            goto L8d
        L8b:
            kotlin.collections.EmptyMap r5 = kotlin.collections.EmptyMap.INSTANCE
        L8d:
            com.animaconnected.watch.device.CommandCenter r6 = r0.commandCenter
            if (r6 == 0) goto L96
            java.util.Map r5 = r6.translate$watch_release(r5)
            return r5
        L96:
            java.lang.String r5 = "commandCenter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.prepareDiagnosticsMap(com.animaconnected.msgpack.MsgPack, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readBuildInfo(Continuation<? super Map<String, String>> continuation) {
        return readStringMap(Command.STATUS_BUILDINFO, Definition.MAP_BUILDINFO, continuation);
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readBuildInfoBl(Continuation<? super Map<String, String>> continuation) {
        return readStringMap(Command.STATUS_BUILDINFO_BL, Definition.MAP_BUILDINFO, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0060 A[LOOP:0: B:11:0x005a->B:13:0x0060, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readCSEMLogsHeaders(kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$readCSEMLogsHeaders$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$readCSEMLogsHeaders$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readCSEMLogsHeaders$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readCSEMLogsHeaders$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readCSEMLogsHeaders$1
            r0.<init>(r7, r8)
        L18:
            r4 = r0
            java.lang.Object r8 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L28
            kotlin.ResultKt.throwOnFailure(r8)
            goto L43
        L28:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L30:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "csem_log_data"
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r2
            r1 = r7
            r2 = r8
            java.lang.Object r8 = read$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L43
            return r0
        L43:
            com.animaconnected.msgpack.MsgPack r8 = (com.animaconnected.msgpack.MsgPack) r8
            java.util.List r8 = r8.asList()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r8, r1)
            r0.<init>(r1)
            java.util.Iterator r8 = r8.iterator()
        L5a:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L6e
            java.lang.Object r1 = r8.next()
            com.animaconnected.msgpack.MsgPack r1 = (com.animaconnected.msgpack.MsgPack) r1
            java.lang.String r1 = r1.toString()
            r0.add(r1)
            goto L5a
        L6e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readCSEMLogsHeaders(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readCapabilities(Continuation<? super MsgPack> continuation) {
        return read$default(this, Command.CAPABILITIES, null, continuation, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0060 A[LOOP:0: B:11:0x005a->B:13:0x0060, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readCoil(kotlin.coroutines.Continuation<? super java.util.List<java.lang.Integer>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$readCoil$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$readCoil$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readCoil$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readCoil$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readCoil$1
            r0.<init>(r7, r8)
        L18:
            r4 = r0
            java.lang.Object r8 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L28
            kotlin.ResultKt.throwOnFailure(r8)
            goto L43
        L28:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L30:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "test_coil"
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r2
            r1 = r7
            r2 = r8
            java.lang.Object r8 = read$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L43
            return r0
        L43:
            com.animaconnected.msgpack.MsgPack r8 = (com.animaconnected.msgpack.MsgPack) r8
            java.util.List r8 = r8.asList()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r8, r1)
            r0.<init>(r1)
            java.util.Iterator r8 = r8.iterator()
        L5a:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L73
            java.lang.Object r1 = r8.next()
            com.animaconnected.msgpack.MsgPack r1 = (com.animaconnected.msgpack.MsgPack) r1
            int r1 = r1.asInt()
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r1)
            r0.add(r2)
            goto L5a
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readCoil(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readCrashStatus(kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.String, com.animaconnected.watch.device.CrashInfo>> r10) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readCrashStatus(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0063 A[PHI: r10
  0x0063: PHI (r10v8 java.lang.Object) = (r10v7 java.lang.Object), (r10v1 java.lang.Object) binds: [B:17:0x0060, B:10:0x0026] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readCurrentFitnessMetrics(kotlin.coroutines.Continuation<? super java.util.Map<com.animaconnected.watch.fitness.FitnessMetric, ? extends com.animaconnected.watch.fitness.MetricValue>> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.device.MsgPackWatch$readCurrentFitnessMetrics$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.device.MsgPackWatch$readCurrentFitnessMetrics$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readCurrentFitnessMetrics$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readCurrentFitnessMetrics$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readCurrentFitnessMetrics$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r0.label
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L3a
            if (r1 == r2) goto L32
            if (r1 != r8) goto L2a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L63
        L2a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L32:
            java.lang.Object r1 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r1 = (com.animaconnected.watch.device.MsgPackWatch) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L51
        L3a:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r10 = "fitness_current_metrics"
            r3 = 0
            r5 = 2
            r6 = 0
            r0.L$0 = r9
            r0.label = r2
            r1 = r9
            r2 = r10
            r4 = r0
            java.lang.Object r10 = read$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r7) goto L50
            return r7
        L50:
            r1 = r9
        L51:
            com.animaconnected.msgpack.MsgPack r10 = (com.animaconnected.msgpack.MsgPack) r10
            java.util.Map r10 = r10.getMap()
            r2 = 0
            r0.L$0 = r2
            r0.label = r8
            java.lang.Object r10 = r1.parseFitnessMetric(r10, r0)
            if (r10 != r7) goto L63
            return r7
        L63:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readCurrentFitnessMetrics(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0060 A[LOOP:0: B:11:0x005a->B:13:0x0060, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readDebugDisconnect(kotlin.coroutines.Continuation<? super java.util.List<java.lang.Integer>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$readDebugDisconnect$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$readDebugDisconnect$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readDebugDisconnect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readDebugDisconnect$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readDebugDisconnect$1
            r0.<init>(r7, r8)
        L18:
            r4 = r0
            java.lang.Object r8 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L28
            kotlin.ResultKt.throwOnFailure(r8)
            goto L43
        L28:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L30:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "debug_disconnect"
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r2
            r1 = r7
            r2 = r8
            java.lang.Object r8 = read$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L43
            return r0
        L43:
            com.animaconnected.msgpack.MsgPack r8 = (com.animaconnected.msgpack.MsgPack) r8
            java.util.List r8 = r8.asList()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r8, r1)
            r0.<init>(r1)
            java.util.Iterator r8 = r8.iterator()
        L5a:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L73
            java.lang.Object r1 = r8.next()
            com.animaconnected.msgpack.MsgPack r1 = (com.animaconnected.msgpack.MsgPack) r1
            int r1 = r1.asInt()
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r1)
            r0.add(r2)
            goto L5a
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readDebugDisconnect(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readDfuReady(kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.DfuStatus> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$readDfuReady$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$readDfuReady$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readDfuReady$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readDfuReady$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readDfuReady$1
            r0.<init>(r7, r8)
        L18:
            r4 = r0
            java.lang.Object r8 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r0 = r4.L$0
            com.animaconnected.watch.device.MsgPackWatch r0 = (com.animaconnected.watch.device.MsgPackWatch) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L2c
            goto L4c
        L2c:
            r8 = move-exception
            goto L5b
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "dfu_ready"
            r3 = 0
            r5 = 2
            r6 = 0
            r4.L$0 = r7     // Catch: java.lang.Exception -> L59
            r4.label = r2     // Catch: java.lang.Exception -> L59
            r1 = r7
            r2 = r8
            java.lang.Object r8 = read$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L59
            if (r8 != r0) goto L4b
            return r0
        L4b:
            r0 = r7
        L4c:
            com.animaconnected.msgpack.MsgPack r8 = (com.animaconnected.msgpack.MsgPack) r8     // Catch: java.lang.Exception -> L2c
            int r8 = r8.asInt()     // Catch: java.lang.Exception -> L2c
            com.animaconnected.watch.device.DfuStatus$Companion r1 = com.animaconnected.watch.device.DfuStatus.Companion     // Catch: java.lang.Exception -> L2c
            com.animaconnected.watch.device.DfuStatus r8 = r1.fromInt(r8)     // Catch: java.lang.Exception -> L2c
            goto L68
        L59:
            r8 = move-exception
            r0 = r7
        L5b:
            r3 = r8
            java.lang.String r1 = "Couldn't run dfu_ready command. Assuming that device is ready."
            r2 = 0
            r4 = 0
            r5 = 10
            r6 = 0
            com.animaconnected.logger.LogKt.warn$default(r0, r1, r2, r3, r4, r5, r6)
            com.animaconnected.watch.device.DfuStatus r8 = com.animaconnected.watch.device.DfuStatus.Unknown
        L68:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readDfuReady(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object readDiagnostics(boolean z, Continuation<? super Map<String, String>> continuation) {
        if (z) {
            Object readStringMapPages = readStringMapPages(Command.STATUS_DIAG, Definition.MAP_DIAG, continuation);
            if (readStringMapPages == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return readStringMapPages;
            }
            return (Map) readStringMapPages;
        }
        return readStringMap(Command.STATUS_DIAG, Definition.MAP_DIAG, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0084 -> B:11:0x0087). Please report as a decompilation issue!!! */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readDumpUart(com.animaconnected.watch.device.WatchIODebug.DumpUartProgressCallback r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.animaconnected.watch.device.MsgPackWatch$readDumpUart$1
            if (r0 == 0) goto L13
            r0 = r13
            com.animaconnected.watch.device.MsgPackWatch$readDumpUart$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readDumpUart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readDumpUart$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readDumpUart$1
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r0.label
            r8 = 2
            r9 = 1
            if (r1 == 0) goto L4a
            if (r1 == r9) goto L3e
            if (r1 != r8) goto L36
            int r12 = r0.I$1
            int r1 = r0.I$0
            java.lang.Object r2 = r0.L$1
            com.animaconnected.watch.device.WatchIODebug$DumpUartProgressCallback r2 = (com.animaconnected.watch.device.WatchIODebug.DumpUartProgressCallback) r2
            java.lang.Object r3 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r3 = (com.animaconnected.watch.device.MsgPackWatch) r3
            kotlin.ResultKt.throwOnFailure(r13)
            goto L87
        L36:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3e:
            java.lang.Object r12 = r0.L$1
            com.animaconnected.watch.device.WatchIODebug$DumpUartProgressCallback r12 = (com.animaconnected.watch.device.WatchIODebug.DumpUartProgressCallback) r12
            java.lang.Object r1 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r1 = (com.animaconnected.watch.device.MsgPackWatch) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L62
        L4a:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.String r2 = "dump_uart"
            r3 = 0
            r5 = 2
            r6 = 0
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r9
            r1 = r11
            r4 = r0
            java.lang.Object r13 = read$default(r1, r2, r3, r4, r5, r6)
            if (r13 != r7) goto L61
            return r7
        L61:
            r1 = r11
        L62:
            com.animaconnected.msgpack.MsgPack r13 = (com.animaconnected.msgpack.MsgPack) r13
            int r13 = r13.asInt()
            r2 = 0
            r3 = r1
            r1 = r13
            r10 = r2
            r2 = r12
            r12 = r10
        L6e:
            if (r12 >= r1) goto L97
            int[] r13 = new int[]{r12}
            r0.L$0 = r3
            r0.L$1 = r2
            r0.I$0 = r1
            r0.I$1 = r12
            r0.label = r8
            java.lang.String r4 = "dump_uart"
            java.lang.Object r13 = r3.read(r4, r13, r0)
            if (r13 != r7) goto L87
            return r7
        L87:
            com.animaconnected.msgpack.MsgPack r13 = (com.animaconnected.msgpack.MsgPack) r13
            byte[] r13 = r13.asByteArray()
            java.lang.String r4 = com.animaconnected.watch.device.MsgPackWatchKt.access$dumpUartLogPartToStr(r13)
            int r13 = r13.length
            r2.onProgress(r4, r13, r1)
            int r12 = r12 + r9
            goto L6e
        L97:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readDumpUart(com.animaconnected.watch.device.WatchIODebug$DumpUartProgressCallback, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b4 A[LOOP:0: B:14:0x00ae->B:16:0x00b4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readFcte(kotlin.coroutines.Continuation<? super java.util.List<java.lang.Integer>> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.device.MsgPackWatch$readFcte$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.device.MsgPackWatch$readFcte$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readFcte$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readFcte$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readFcte$1
            r0.<init>(r8, r9)
        L18:
            r4 = r0
            java.lang.Object r9 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            java.lang.String r2 = "test_fcte"
            r3 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L5d
            if (r1 == r7) goto L50
            if (r1 == r6) goto L48
            if (r1 == r5) goto L3b
            if (r1 != r3) goto L33
            kotlin.ResultKt.throwOnFailure(r9)
            goto L97
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3b:
            java.lang.Object r1 = r4.L$0
            com.animaconnected.watch.device.MsgPackWatch r1 = (com.animaconnected.watch.device.MsgPackWatch) r1
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            r9.getClass()
            goto L85
        L48:
            java.lang.Object r1 = r4.L$0
            com.animaconnected.watch.device.MsgPackWatch r1 = (com.animaconnected.watch.device.MsgPackWatch) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L79
        L50:
            java.lang.Object r1 = r4.L$0
            com.animaconnected.watch.device.MsgPackWatch r1 = (com.animaconnected.watch.device.MsgPackWatch) r1
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            r9.getClass()
            goto L6c
        L5d:
            kotlin.ResultKt.throwOnFailure(r9)
            r4.L$0 = r8
            r4.label = r7
            java.lang.Object r9 = r8.m1076writeInt0E7RQCE(r2, r7, r4)
            if (r9 != r0) goto L6b
            return r0
        L6b:
            r1 = r8
        L6c:
            r4.L$0 = r1
            r4.label = r6
            r6 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r6, r4)
            if (r9 != r0) goto L79
            return r0
        L79:
            r4.L$0 = r1
            r4.label = r5
            r9 = 0
            java.lang.Object r9 = r1.m1076writeInt0E7RQCE(r2, r9, r4)
            if (r9 != r0) goto L85
            return r0
        L85:
            java.lang.String r2 = "test_fcte"
            r9 = 0
            r5 = 2
            r6 = 0
            r7 = 0
            r4.L$0 = r7
            r4.label = r3
            r3 = r9
            java.lang.Object r9 = read$default(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L97
            return r0
        L97:
            com.animaconnected.msgpack.MsgPack r9 = (com.animaconnected.msgpack.MsgPack) r9
            java.util.List r9 = r9.asList()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r9, r1)
            r0.<init>(r1)
            java.util.Iterator r9 = r9.iterator()
        Lae:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto Lc7
            java.lang.Object r1 = r9.next()
            com.animaconnected.msgpack.MsgPack r1 = (com.animaconnected.msgpack.MsgPack) r1
            int r1 = r1.asInt()
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r1)
            r0.add(r2)
            goto Lae
        Lc7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readFcte(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readFile(java.lang.String r5, int r6, int r7, kotlin.coroutines.Continuation<? super byte[]> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$readFile$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$readFile$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readFile$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readFile$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4f
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Integer r8 = new java.lang.Integer
            r8.<init>(r6)
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r7)
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r8, r6}
            java.lang.Object[] r5 = new java.lang.Object[]{r5}
            r0.label = r3
            java.lang.String r6 = "file"
            java.lang.Object r8 = r4.readArray(r6, r5, r0)
            if (r8 != r1) goto L4f
            return r1
        L4f:
            com.animaconnected.msgpack.MsgPack r8 = (com.animaconnected.msgpack.MsgPack) r8
            byte[] r5 = r8.asByteArray()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readFile(java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0181 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x016d -> B:11:0x0175). Please report as a decompilation issue!!! */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readFilesPaged(java.lang.String r21, java.lang.String r22, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, com.animaconnected.watch.device.WatchIO.FileMeta>> r23) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readFilesPaged(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:148:0x0624, code lost:            r8 = r8;        r20 = r6;     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x05fd, code lost:            r0 = true;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Type inference failed for: r11v43, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v22, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:138:0x0443 -> B:12:0x044e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:139:0x04ac -> B:18:0x04bc). Please report as a decompilation issue!!! */
    @Override // com.animaconnected.watch.device.WatchIO
    /* renamed from: readFitnessData-OZHprlw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo1078readFitnessDataOZHprlw(java.lang.String r29, long r30, kotlin.coroutines.Continuation<? super java.util.List<? extends com.animaconnected.watch.fitness.Entry>> r32) {
        /*
            Method dump skipped, instructions count: 1603
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.mo1078readFitnessDataOZHprlw(java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readFitnessDataAmount(long r5, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$readFitnessDataAmount$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$readFitnessDataAmount$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readFitnessDataAmount$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readFitnessDataAmount$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readFitnessDataAmount$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4d
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.device.MsgPackWatch$WatchTimestamp r5 = r4.toWatchTimestamp(r5)
            int r6 = r5.getTimestamp()
            int r5 = r5.getCount()
            int[] r5 = new int[]{r6, r5, r3}
            r0.label = r3
            java.lang.String r6 = "history"
            java.lang.Object r7 = r4.read(r6, r5, r0)
            if (r7 != r1) goto L4d
            return r1
        L4d:
            com.animaconnected.msgpack.MsgPack r7 = (com.animaconnected.msgpack.MsgPack) r7
            int r5 = r7.asInt()
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readFitnessDataAmount(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readOnboardingDone(kotlin.coroutines.Continuation<? super java.lang.Boolean> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.device.MsgPackWatch$readOnboardingDone$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.device.MsgPackWatch$readOnboardingDone$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readOnboardingDone$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readOnboardingDone$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readOnboardingDone$1
            r0.<init>(r8, r9)
        L18:
            r4 = r0
            java.lang.Object r9 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r7 = 1
            if (r1 == 0) goto L30
            if (r1 != r7) goto L28
            kotlin.ResultKt.throwOnFailure(r9)
            goto L42
        L28:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L30:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.String r2 = "onboarding_done"
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r7
            r1 = r8
            java.lang.Object r9 = read$default(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L42
            return r0
        L42:
            com.animaconnected.msgpack.MsgPack r9 = (com.animaconnected.msgpack.MsgPack) r9
            int r9 = r9.asInt()
            if (r9 != r7) goto L4b
            goto L4c
        L4b:
            r7 = 0
        L4c:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readOnboardingDone(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readPostMortemData(kotlin.coroutines.Continuation<? super byte[]> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.device.MsgPackWatch$readPostMortemData$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.device.MsgPackWatch$readPostMortemData$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readPostMortemData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readPostMortemData$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readPostMortemData$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r0 = (com.animaconnected.watch.device.MsgPackWatch) r0
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r0
            goto L43
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L34:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r10 = r9.readPostMortem(r0)
            if (r10 != r1) goto L42
            return r1
        L42:
            r7 = r9
        L43:
            java.util.List r10 = (java.util.List) r10
            r0 = 0
            byte[] r0 = new byte[r0]
            java.util.Iterator r10 = r10.iterator()
            r8 = r0
        L4d:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L70
            java.lang.Object r0 = r10.next()
            com.animaconnected.msgpack.MsgPack r0 = (com.animaconnected.msgpack.MsgPack) r0
            byte[] r0 = r0.asByteArray()     // Catch: com.animaconnected.watch.device.IOException -> L62
            byte[] r8 = kotlin.collections.ArraysKt___ArraysJvmKt.plus(r8, r0)     // Catch: com.animaconnected.watch.device.IOException -> L62
            goto L4d
        L62:
            r0 = move-exception
            r3 = r0
            java.lang.String r1 = "Failed to read post mortem "
            r2 = 0
            r4 = 0
            r5 = 10
            r6 = 0
            r0 = r7
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
            goto L4d
        L70:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readPostMortemData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readRssi(kotlin.coroutines.Continuation<? super java.lang.Integer> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$readRssi$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$readRssi$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readRssi$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readRssi$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readRssi$1
            r0.<init>(r7, r8)
        L18:
            r4 = r0
            java.lang.Object r8 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L28
            kotlin.ResultKt.throwOnFailure(r8)
            goto L43
        L28:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L30:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "rssi"
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r2
            r1 = r7
            r2 = r8
            java.lang.Object r8 = read$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L43
            return r0
        L43:
            com.animaconnected.msgpack.MsgPack r8 = (com.animaconnected.msgpack.MsgPack) r8
            int r8 = r8.asInt()
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readRssi(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readSessionData(kotlin.coroutines.Continuation<? super java.util.Map<com.animaconnected.watch.fitness.FitnessMetric, java.lang.Integer>> r9) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readSessionData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0096 -> B:10:0x00a0). Please report as a decompilation issue!!! */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readSleep(long r24, int r26, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.util.List<kotlin.Pair<java.lang.Long, java.lang.Integer>>, kotlin.Unit> r27, kotlin.coroutines.Continuation<? super java.lang.Boolean> r28) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readSleep(long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006e A[LOOP:0: B:17:0x0068->B:19:0x006e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readStepsDay(int r5, kotlin.coroutines.Continuation<? super java.util.List<java.lang.Integer>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$readStepsDay$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$readStepsDay$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readStepsDay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readStepsDay$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readStepsDay$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r6)
            goto L41
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r6)
            int[] r5 = new int[]{r5}
            r0.label = r3
            java.lang.String r6 = "steps_day"
            java.lang.Object r6 = r4.read(r6, r5, r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            com.animaconnected.msgpack.MsgPack r6 = (com.animaconnected.msgpack.MsgPack) r6
            java.util.List r5 = r6.asList()
            int r6 = r5.size()
            r0 = 2
            if (r6 == r0) goto L57
            int r6 = r5.size()
            r0 = 4
            if (r6 == r0) goto L57
            r5 = 0
            return r5
        L57:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r5, r0)
            r6.<init>(r0)
            java.util.Iterator r5 = r5.iterator()
        L68:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L81
            java.lang.Object r0 = r5.next()
            com.animaconnected.msgpack.MsgPack r0 = (com.animaconnected.msgpack.MsgPack) r0
            int r0 = r0.asInt()
            java.lang.Integer r1 = new java.lang.Integer
            r1.<init>(r0)
            r6.add(r1)
            goto L68
        L81:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readStepsDay(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0055 A[LOOP:0: B:11:0x0053->B:12:0x0055, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readStopwatch(kotlin.coroutines.Continuation<? super java.util.List<java.lang.Integer[]>> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.animaconnected.watch.device.MsgPackWatch$readStopwatch$1
            if (r0 == 0) goto L13
            r0 = r11
            com.animaconnected.watch.device.MsgPackWatch$readStopwatch$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readStopwatch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readStopwatch$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readStopwatch$1
            r0.<init>(r10, r11)
        L18:
            r4 = r0
            java.lang.Object r11 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r7 = 1
            if (r1 == 0) goto L30
            if (r1 != r7) goto L28
            kotlin.ResultKt.throwOnFailure(r11)
            goto L42
        L28:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L30:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r2 = "stopwatch"
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r7
            r1 = r10
            java.lang.Object r11 = read$default(r1, r2, r3, r4, r5, r6)
            if (r11 != r0) goto L42
            return r0
        L42:
            com.animaconnected.msgpack.MsgPack r11 = (com.animaconnected.msgpack.MsgPack) r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r11 = r11.asList()
            int r1 = r11.size()
            r2 = 0
            r3 = r2
        L53:
            if (r3 >= r1) goto Lc0
            java.lang.Object r4 = r11.get(r3)
            com.animaconnected.msgpack.MsgPack r4 = (com.animaconnected.msgpack.MsgPack) r4
            java.util.List r4 = r4.asList()
            r5 = 5
            java.lang.Integer[] r5 = new java.lang.Integer[r5]
            java.lang.Object r6 = r4.get(r2)
            com.animaconnected.msgpack.MsgPack r6 = (com.animaconnected.msgpack.MsgPack) r6
            int r6 = r6.asInt()
            java.lang.Integer r8 = new java.lang.Integer
            r8.<init>(r6)
            r5[r2] = r8
            java.lang.Object r6 = r4.get(r7)
            com.animaconnected.msgpack.MsgPack r6 = (com.animaconnected.msgpack.MsgPack) r6
            int r6 = r6.asInt()
            java.lang.Integer r8 = new java.lang.Integer
            r8.<init>(r6)
            r5[r7] = r8
            r6 = 2
            java.lang.Object r8 = r4.get(r6)
            com.animaconnected.msgpack.MsgPack r8 = (com.animaconnected.msgpack.MsgPack) r8
            int r8 = r8.asInt()
            java.lang.Integer r9 = new java.lang.Integer
            r9.<init>(r8)
            r5[r6] = r9
            r6 = 3
            java.lang.Object r8 = r4.get(r6)
            com.animaconnected.msgpack.MsgPack r8 = (com.animaconnected.msgpack.MsgPack) r8
            int r8 = r8.asInt()
            java.lang.Integer r9 = new java.lang.Integer
            r9.<init>(r8)
            r5[r6] = r9
            r6 = 4
            java.lang.Object r4 = r4.get(r6)
            com.animaconnected.msgpack.MsgPack r4 = (com.animaconnected.msgpack.MsgPack) r4
            int r4 = r4.asInt()
            java.lang.Integer r8 = new java.lang.Integer
            r8.<init>(r4)
            r5[r6] = r8
            r0.add(r3, r5)
            int r3 = r3 + 1
            goto L53
        Lc0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readStopwatch(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readValues(java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<java.lang.String, ? extends java.lang.Exception>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.device.MsgPackWatch$readValues$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.device.MsgPackWatch$readValues$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$readValues$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$readValues$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$readValues$1
            r0.<init>(r7, r10)
        L18:
            r4 = r0
            java.lang.Object r10 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L39
            if (r1 == r3) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L37
            goto L68
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L37
            goto L50
        L37:
            r8 = move-exception
            goto L72
        L39:
            kotlin.ResultKt.throwOnFailure(r10)
            if (r9 == 0) goto L5a
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L37
            java.lang.Object[] r9 = com.animaconnected.watch.device.MsgPackKt.parseStringToArray(r9)     // Catch: java.lang.Exception -> L37
            r1 = 0
            r10[r1] = r9     // Catch: java.lang.Exception -> L37
            r4.label = r3     // Catch: java.lang.Exception -> L37
            java.lang.Object r10 = r7.readArray(r8, r10, r4)     // Catch: java.lang.Exception -> L37
            if (r10 != r0) goto L50
            return r0
        L50:
            java.lang.String r8 = r10.toString()     // Catch: java.lang.Exception -> L37
            com.animaconnected.watch.utils.WatchLibResult$Success r9 = new com.animaconnected.watch.utils.WatchLibResult$Success     // Catch: java.lang.Exception -> L37
            r9.<init>(r8)     // Catch: java.lang.Exception -> L37
            goto L77
        L5a:
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r2     // Catch: java.lang.Exception -> L37
            r1 = r7
            r2 = r8
            java.lang.Object r10 = read$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L37
            if (r10 != r0) goto L68
            return r0
        L68:
            java.lang.String r8 = r10.toString()     // Catch: java.lang.Exception -> L37
            com.animaconnected.watch.utils.WatchLibResult$Success r9 = new com.animaconnected.watch.utils.WatchLibResult$Success     // Catch: java.lang.Exception -> L37
            r9.<init>(r8)     // Catch: java.lang.Exception -> L37
            goto L77
        L72:
            com.animaconnected.watch.utils.WatchLibResult$Failure r9 = new com.animaconnected.watch.utils.WatchLibResult$Failure
            r9.<init>(r8)
        L77:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readValues(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006e A[LOOP:0: B:11:0x0068->B:13:0x006e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readWatchTime(boolean r21, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.WatchTime> r22) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.readWatchTime(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public void setDebugEnabled(boolean z) {
        this.isDebugEnabled = z;
        DeviceWriter deviceWriter = this.deviceWriter;
        if (deviceWriter != null) {
            deviceWriter.setDebugEnabled(z);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("deviceWriter");
            throw null;
        }
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: write-0E7RQCE$watch_release, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1079write0E7RQCE$watch_release(java.lang.String r5, com.animaconnected.msgpack.MsgPack r6, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$write$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$write$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$write$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$write$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$write$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.value
            goto L43
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.device.DeviceWriter r7 = r4.deviceWriter
            if (r7 == 0) goto L44
            r0.label = r3
            java.lang.Object r5 = r7.m1065write0E7RQCE(r5, r6, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            return r5
        L44:
            java.lang.String r5 = "deviceWriter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.m1079write0E7RQCE$watch_release(java.lang.String, com.animaconnected.msgpack.MsgPack, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeAlarms(java.util.List<com.animaconnected.watch.device.HybridAlarm> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.device.MsgPackWatch$writeAlarms$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.device.MsgPackWatch$writeAlarms$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeAlarms$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeAlarms$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeAlarms$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            r10.getClass()
            goto L97
        L2c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L34:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r10 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r9, r2)
            r10.<init>(r2)
            java.util.Iterator r9 = r9.iterator()
        L48:
            boolean r2 = r9.hasNext()
            r4 = 0
            if (r2 == 0) goto L82
            java.lang.Object r2 = r9.next()
            com.animaconnected.watch.device.HybridAlarm r2 = (com.animaconnected.watch.device.HybridAlarm) r2
            r5 = 3
            java.lang.Comparable[] r5 = new java.lang.Comparable[r5]
            int r6 = r2.getHours()
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r6)
            r5[r4] = r7
            int r4 = r2.getMinutes()
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r4)
            r5[r3] = r6
            byte r2 = r2.m1066getConfigurationBitsAsIntw2LRezQ()
            kotlin.UByte r4 = new kotlin.UByte
            r4.<init>(r2)
            r2 = 2
            r5[r2] = r4
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r5)
            r10.add(r2)
            goto L48
        L82:
            java.util.ArrayList r9 = kotlin.collections.CollectionsKt__IteratorsJVMKt.flatten(r10)
            java.lang.Object[] r10 = new java.lang.Object[r4]
            java.lang.Object[] r9 = r9.toArray(r10)
            r0.label = r3
            java.lang.String r10 = "alarm"
            java.lang.Object r9 = r8.m1074writeArray0E7RQCE(r10, r9, r0)
            if (r9 != r1) goto L97
            return r1
        L97:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeAlarms(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeAlert(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeAlert$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeAlert$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeAlert$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeAlert$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeAlert$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L42
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.String r6 = "alert"
            java.lang.Object r5 = r4.m1076writeInt0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeAlert(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeAlertConfig(int[] r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r8 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r8 = (com.animaconnected.watch.device.MsgPackWatch) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L30
            kotlin.Result r9 = (kotlin.Result) r9     // Catch: java.lang.Exception -> L30
            r9.getClass()     // Catch: java.lang.Exception -> L30
            goto L61
        L30:
            r9 = move-exception
            r0 = r8
            goto L66
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            kotlin.ResultKt.throwOnFailure(r9)
            int r9 = r8.length
            r2 = 3
            if (r9 == r2) goto L4f
            int r9 = r8.length
            r2 = 6
            if (r9 != r2) goto L47
            goto L4f
        L47:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "alertConfigBitmasks must have length == 3 or 6"
            r8.<init>(r9)
            throw r8
        L4f:
            java.lang.String r9 = "alert_assign"
            int r2 = r8.length     // Catch: java.lang.Exception -> L64
            int[] r8 = java.util.Arrays.copyOf(r8, r2)     // Catch: java.lang.Exception -> L64
            r0.L$0 = r7     // Catch: java.lang.Exception -> L64
            r0.label = r3     // Catch: java.lang.Exception -> L64
            java.lang.Object r8 = r7.m1077writeInts0E7RQCE(r9, r8, r0)     // Catch: java.lang.Exception -> L64
            if (r8 != r1) goto L61
            return r1
        L61:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L64:
            r9 = move-exception
            r0 = r7
        L66:
            r1 = 0
            r2 = 0
            r3 = 0
            com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$2 r4 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$2
                static {
                    /*
                        com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$2 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$2) com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$2.INSTANCE com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "write alert_assign failed, check that FW >= 20170124.01"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch$writeAlertConfig$2.invoke():java.lang.Object");
                }
            }
            r5 = 7
            r6 = 0
            com.animaconnected.logger.LogKt.warn$default(r0, r1, r2, r3, r4, r5, r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeAlertConfig(int[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeAncs(com.animaconnected.watch.filter.AncsFilter r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeAncs$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeAncs$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeAncs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeAncs$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeAncs$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object[] r5 = com.animaconnected.watch.filter.FilterSettingsExtensionKt.asArray(r5)
            r0.label = r3
            java.lang.String r6 = "ancs_filter"
            java.lang.Object r5 = r4.m1074writeArray0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeAncs(com.animaconnected.watch.filter.AncsFilter, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeApp(int r1, String str, int r3, int r4, int r5, List<Integer> list, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeBaseConfig(int r5, int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$writeBaseConfig$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$writeBaseConfig$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeBaseConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeBaseConfig$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeBaseConfig$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            r7.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            int[] r5 = new int[]{r5, r6}
            r0.label = r3
            java.lang.String r6 = "config_base"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeBaseConfig(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeButtonPressed(com.animaconnected.watch.device.Button r5, com.animaconnected.watch.device.ButtonAction r6, com.animaconnected.watch.device.WatchFace r7, int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.device.MsgPackWatch$writeButtonPressed$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.device.MsgPackWatch$writeButtonPressed$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeButtonPressed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeButtonPressed$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeButtonPressed$1
            r0.<init>(r4, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            r9.getClass()
            goto L52
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r9)
            int r5 = r5.getId$watch_release()
            int r6 = r6.getId()
            int r7 = r7.getIndex$watch_release()
            int[] r5 = new int[]{r5, r6, r7, r8}
            r0.label = r3
            java.lang.String r6 = "comp_btn"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L52
            return r1
        L52:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeButtonPressed(com.animaconnected.watch.device.Button, com.animaconnected.watch.device.ButtonAction, com.animaconnected.watch.device.WatchFace, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeChangeView(int r5, int r6, int r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$writeChangeView$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$writeChangeView$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeChangeView$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeChangeView$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeChangeView$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            r8.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            int[] r5 = new int[]{r5, r6, r7}
            r0.label = r3
            java.lang.String r6 = "show_view"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeChangeView(int, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeColour(int r5, int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$writeColour$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$writeColour$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeColour$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeColour$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeColour$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            r7.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            int[] r5 = new int[]{r5, r6}
            r0.label = r3
            java.lang.String r6 = "disp_color"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeColour(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeComplication(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeComplication$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeComplication$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeComplication$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeComplication$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeComplication$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            int[] r5 = new int[]{r5}
            r0.label = r3
            java.lang.String r6 = "comp_def"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeComplication(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeComplicationMode(int r5, int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$writeComplicationMode$2
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$writeComplicationMode$2 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeComplicationMode$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeComplicationMode$2 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeComplicationMode$2
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            r7.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            int[] r5 = new int[]{r5, r6}
            r0.label = r3
            java.lang.String r6 = "set_complication_mode"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeComplicationMode(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeComplicationModes(int r5, int r6, int r7, int r8, int r9, int r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r4 = this;
            boolean r0 = r11 instanceof com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$4
            if (r0 == 0) goto L13
            r0 = r11
            com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$4 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$4 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$4
            r0.<init>(r4, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result r11 = (kotlin.Result) r11
            r11.getClass()
            goto L56
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 6
            int[] r11 = new int[r11]
            r2 = 0
            r11[r2] = r5
            r11[r3] = r6
            r5 = 2
            r11[r5] = r7
            r5 = 3
            r11[r5] = r8
            r5 = 4
            r11[r5] = r9
            r5 = 5
            r11[r5] = r10
            r0.label = r3
            java.lang.String r5 = "complications"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r5, r11, r0)
            if (r5 != r1) goto L56
            return r1
        L56:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeComplicationModes(int, int, int, int, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeComplications(int[] r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeComplications$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeComplications$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeComplications$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeComplications$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeComplications$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L47
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            int r6 = r5.length
            int[] r5 = java.util.Arrays.copyOf(r5, r6)
            r0.label = r3
            java.lang.String r6 = "comp_def"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeComplications(int[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|(1:(1:(7:10|11|12|13|14|15|16)(2:21|22))(1:23))(2:49|(1:51)(1:52))|24|25|(2:26|(2:28|(3:30|(2:33|34)|35)(3:38|39|40))(4:41|42|(2:44|(1:46))|47))))|53|6|(0)(0)|24|25|(3:26|(0)(0)|35)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cc, code lost:            r0 = r2;     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072 A[Catch: Exception -> 0x00cc, TryCatch #0 {Exception -> 0x00cc, blocks: (B:25:0x0056, B:26:0x006b, B:28:0x0072, B:30:0x007c, B:33:0x008a, B:35:0x0095, B:39:0x0099, B:40:0x009e, B:42:0x009f, B:44:0x00ae), top: B:24:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeConfigSettings(java.util.Map<java.lang.String, java.lang.Integer> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeConfigSettings(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Type inference failed for: r14v5, types: [kotlin.ranges.IntProgressionIterator] */
    /* JADX WARN: Type inference failed for: r8v3, types: [kotlin.ranges.IntProgressionIterator] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00ed -> B:10:0x00f2). Please report as a decompilation issue!!! */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeConfigVibrator(int[][] r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeConfigVibrator(int[][], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeCrashHandled(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.watch.device.MsgPackWatch$writeCrashHandled$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.watch.device.MsgPackWatch$writeCrashHandled$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeCrashHandled$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeCrashHandled$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeCrashHandled$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            r5.getClass()
            goto L44
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.String r5 = "crash"
            r2 = 255(0xff, float:3.57E-43)
            java.lang.Object r5 = r4.m1076writeInt0E7RQCE(r5, r2, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeCrashHandled(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeDebugAppError(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeDebugAppError$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeDebugAppError$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeDebugAppError$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeDebugAppError$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeDebugAppError$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L42
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.String r6 = "debug_apperror"
            java.lang.Object r5 = r4.m1076writeInt0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeDebugAppError(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeDebugConfig(boolean z, boolean z2, boolean z3, boolean z4, int r7, int r8, boolean z5, Continuation<? super Unit> continuation) {
        Object writeDebugConfig = writeDebugConfig(CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{new Integer(0), new Integer(z ? 1 : 0), new Integer(z2 ? 1 : 0), new Integer(z3 ? 1 : 0), new Integer(0), new Integer(r7), new Integer(r8), new Integer(z5 ? 1 : 0)}), continuation);
        return writeDebugConfig == CoroutineSingletons.COROUTINE_SUSPENDED ? writeDebugConfig : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeDebugHardFault(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$writeDebugHardFault$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$writeDebugHardFault$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeDebugHardFault$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeDebugHardFault$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeDebugHardFault$1
            r0.<init>(r7, r8)
        L18:
            r4 = r0
            java.lang.Object r8 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            r8.getClass()
            goto L48
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "debug_hardfault"
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r2
            r1 = r7
            r2 = r8
            java.lang.Object r8 = m1073write0E7RQCE$watch_release$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L48
            return r0
        L48:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeDebugHardFault(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeDemoMode(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeDemoMode$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeDemoMode$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeDemoMode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeDemoMode$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeDemoMode$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L42
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.String r6 = "demo_mode"
            java.lang.Object r5 = r4.m1076writeInt0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeDemoMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeDfuReady(com.animaconnected.watch.device.DfuUiState r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeDfuReady$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeDfuReady$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeDfuReady$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeDfuReady$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeDfuReady$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            int r5 = r5.getId()
            r0.label = r3
            java.lang.String r6 = "dfu_ready"
            java.lang.Object r5 = r4.m1076writeInt0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeDfuReady(com.animaconnected.watch.device.DfuUiState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeDirectory(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeDirectory$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeDirectory$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeDirectory$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeDirectory$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeDirectory$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object[] r5 = new java.lang.Object[]{r5}
            r0.label = r3
            java.lang.String r6 = "mkdir"
            java.lang.Object r5 = r4.m1074writeArray0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeDirectory(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeEnterBatterySim(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeEnterBatterySim$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeEnterBatterySim$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeEnterBatterySim$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeEnterBatterySim$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeEnterBatterySim$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L42
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.String r6 = "enterBattery_sim"
            java.lang.Object r5 = r4.m1076writeInt0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeEnterBatterySim(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeFastMode(boolean r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeFastMode$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeFastMode$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeFastMode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeFastMode$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeFastMode$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L42
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.String r6 = "fastmode"
            java.lang.Object r5 = r4.m1075writeBoolean0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeFastMode(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeFilePart(final java.lang.String r8, byte[] r9, final int r10, final int r11, java.lang.Integer r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r7 = this;
            boolean r0 = r13 instanceof com.animaconnected.watch.device.MsgPackWatch$writeFilePart$1
            if (r0 == 0) goto L13
            r0 = r13
            com.animaconnected.watch.device.MsgPackWatch$writeFilePart$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeFilePart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeFilePart$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeFilePart$1
            r0.<init>(r7, r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            int r11 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r9 = (com.animaconnected.watch.device.MsgPackWatch) r9
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.Result r13 = (kotlin.Result) r13
            r13.getClass()
            r0 = r9
            goto L83
        L39:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L41:
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = 4
            java.io.Serializable[] r13 = new java.io.Serializable[r13]
            r2 = 0
            r13[r2] = r8
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r11)
            r13[r3] = r4
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r10)
            r5 = 2
            r13[r5] = r4
            r4 = 3
            r13[r4] = r9
            java.util.ArrayList r13 = kotlin.collections.CollectionsKt__CollectionsKt.mutableListOf(r13)
            if (r12 == 0) goto L69
            int r9 = r9.length
            int r9 = r9 + r10
            if (r9 != r11) goto L69
            r13.add(r12)
        L69:
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.Object[] r9 = r13.toArray(r9)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.I$0 = r10
            r0.I$1 = r11
            r0.label = r3
            java.lang.String r12 = "file"
            java.lang.Object r9 = r7.m1074writeArray0E7RQCE(r12, r9, r0)
            if (r9 != r1) goto L82
            return r1
        L82:
            r0 = r7
        L83:
            r1 = 0
            r2 = 0
            r3 = 0
            com.animaconnected.watch.device.MsgPackWatch$writeFilePart$2 r4 = new com.animaconnected.watch.device.MsgPackWatch$writeFilePart$2
            r4.<init>()
            r5 = 7
            r6 = 0
            com.animaconnected.logger.LogKt.verbose$default(r0, r1, r2, r3, r4, r5, r6)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeFilePart(java.lang.String, byte[], int, int, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeFitnessConfig(com.animaconnected.watch.fitness.FitnessConfig r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.device.MsgPackWatch$writeFitnessConfig$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.device.MsgPackWatch$writeFitnessConfig$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeFitnessConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeFitnessConfig$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeFitnessConfig$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            r10.getClass()
            goto Le4
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Integer r10 = r9.getHeight()
            if (r10 == 0) goto L43
            int r10 = r10.intValue()
            goto L45
        L43:
            r10 = 1700(0x6a4, float:2.382E-42)
        L45:
            int r10 = r10 / 10
            java.lang.Integer r2 = r9.getWeight()
            if (r2 == 0) goto L52
            int r2 = r2.intValue()
            goto L55
        L52:
            r2 = 70000(0x11170, float:9.8091E-41)
        L55:
            int r2 = r2 / 100
            java.lang.Long r4 = r9.getDateOfBirthTs()
            if (r4 == 0) goto L8e
            long r4 = r4.longValue()
            kotlinx.datetime.Instant$Companion r6 = kotlinx.datetime.Instant.Companion
            r6.getClass()
            kotlinx.datetime.Instant r4 = kotlinx.datetime.Instant.Companion.fromEpochMilliseconds(r4)
            r5 = 0
            r6 = 2
            kotlinx.datetime.LocalDateTime r4 = com.animaconnected.info.DateTimeUtilsKt.getLocalDateTime$default(r4, r5, r6, r5)
            kotlinx.datetime.LocalDate r4 = r4.getDate()
            r6 = 3
            kotlinx.datetime.LocalDateTime r5 = com.animaconnected.info.DateTimeUtilsKt.getLocalDateTime$default(r5, r5, r6, r5)
            kotlinx.datetime.LocalDate r5 = r5.getDate()
            int r6 = kotlinx.datetime.LocalDateJvmKt.$r8$clinit
            j$.time.temporal.ChronoUnit r6 = j$.time.temporal.ChronoUnit.YEARS
            j$.time.LocalDate r4 = r4.value
            j$.time.LocalDate r5 = r5.value
            long r4 = r4.until(r5, r6)
            int r4 = kotlinx.datetime.internal.MathKt.clampToInt(r4)
            goto L90
        L8e:
            r4 = 30
        L90:
            java.lang.Integer r5 = r9.getGender()
            com.animaconnected.watch.fitness.FitnessProvider$Profile$Gender r6 = com.animaconnected.watch.fitness.FitnessProvider.Profile.Gender.Male
            int r7 = r6.getId$watch_release()
            if (r5 != 0) goto L9d
            goto La3
        L9d:
            int r5 = r5.intValue()
            if (r5 == r7) goto Lbc
        La3:
            java.lang.Integer r5 = r9.getGender()
            com.animaconnected.watch.fitness.FitnessProvider$Profile$Gender r7 = com.animaconnected.watch.fitness.FitnessProvider.Profile.Gender.Female
            int r7 = r7.getId$watch_release()
            if (r5 != 0) goto Lb0
            goto Lb7
        Lb0:
            int r5 = r5.intValue()
            if (r5 != r7) goto Lb7
            goto Lbc
        Lb7:
            int r5 = r6.getId$watch_release()
            goto Lc4
        Lbc:
            java.lang.Integer r5 = r9.getGender()
            int r5 = r5.intValue()
        Lc4:
            java.lang.Integer r9 = r9.getMeasurement()
            if (r9 == 0) goto Lcf
            int r9 = r9.intValue()
            goto Ld5
        Lcf:
            com.animaconnected.watch.fitness.FitnessProvider$Profile$Measurement r9 = com.animaconnected.watch.fitness.FitnessProvider.Profile.Measurement.Metric
            int r9 = r9.getId$watch_release()
        Ld5:
            int[] r9 = new int[]{r10, r2, r4, r5, r9}
            r0.label = r3
            java.lang.String r10 = "fitness_config"
            java.lang.Object r9 = r8.m1077writeInts0E7RQCE(r10, r9, r0)
            if (r9 != r1) goto Le4
            return r1
        Le4:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeFitnessConfig(com.animaconnected.watch.fitness.FitnessConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeFitnessRamData(Map<FitnessMetric, Integer> map, Continuation<? super Unit> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            CommandCenter commandCenter = this.commandCenter;
            if (commandCenter != null) {
                linkedHashMap.put(new Integer(commandCenter.getCommandNumber$watch_release(((FitnessMetric) entry.getKey()).getMetric())), entry.getValue());
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("commandCenter");
                throw null;
            }
        }
        Object writeMap = writeMap(Command.FITNESS_CURRENT_METRICS, linkedHashMap, continuation);
        if (writeMap == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return writeMap;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeForgetDevice(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$writeForgetDevice$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$writeForgetDevice$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeForgetDevice$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeForgetDevice$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeForgetDevice$1
            r0.<init>(r7, r8)
        L18:
            r4 = r0
            java.lang.Object r8 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            r8.getClass()
            goto L48
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "forget_device"
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r2
            r1 = r7
            r2 = r8
            java.lang.Object r8 = m1073write0E7RQCE$watch_release$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L48
            return r0
        L48:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeForgetDevice(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeFormat(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$writeFormat$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$writeFormat$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeFormat$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeFormat$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeFormat$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            java.lang.String r3 = "format"
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L46
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            r7.getClass()
            goto L6d
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L39:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r2 = (com.animaconnected.watch.device.MsgPackWatch) r2
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            r7.getClass()
            goto L5b
        L46:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = "/ram"
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r6.m1074writeArray0E7RQCE(r3, r7, r0)
            if (r7 != r1) goto L5a
            return r1
        L5a:
            r2 = r6
        L5b:
            java.lang.String r7 = "/flash/ext"
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            r5 = 0
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r2.m1074writeArray0E7RQCE(r3, r7, r0)
            if (r7 != r1) goto L6d
            return r1
        L6d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeFormat(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeHealthGoals(com.animaconnected.watch.fitness.HealthGoals r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.device.MsgPackWatch$writeHealthGoals$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.device.MsgPackWatch$writeHealthGoals$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeHealthGoals$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeHealthGoals$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeHealthGoals$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r9)
            goto Le2
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            java.lang.Object r8 = r0.L$1
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.device.MsgPackWatch r2 = (com.animaconnected.watch.device.MsgPackWatch) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8a
        L3f:
            kotlin.ResultKt.throwOnFailure(r9)
            com.animaconnected.watch.fitness.FitnessMetric r9 = com.animaconnected.watch.fitness.FitnessMetric.Steps
            int r2 = r8.getSteps()
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r2)
            kotlin.Pair r2 = new kotlin.Pair
            r2.<init>(r9, r5)
            com.animaconnected.watch.fitness.FitnessMetric r9 = com.animaconnected.watch.fitness.FitnessMetric.Stand
            int r5 = r8.getStand()
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            kotlin.Pair r5 = new kotlin.Pair
            r5.<init>(r9, r6)
            com.animaconnected.watch.fitness.FitnessMetric r9 = com.animaconnected.watch.fitness.FitnessMetric.Exercise
            int r8 = r8.getExercise()
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r8)
            kotlin.Pair r8 = new kotlin.Pair
            r8.<init>(r9, r6)
            kotlin.Pair[] r8 = new kotlin.Pair[]{r2, r5, r8}
            java.util.Map r8 = kotlin.collections.MapsKt__MapsKt.mapOf(r8)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.String r9 = "map_fitness_metrics"
            java.lang.Object r9 = r7.fetchDefinition(r9, r0)
            if (r9 != r1) goto L89
            return r1
        L89:
            r2 = r7
        L8a:
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            int r4 = r8.size()
            int r4 = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(r4)
            r9.<init>(r4)
            java.util.Set r8 = r8.entrySet()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        La1:
            boolean r4 = r8.hasNext()
            r5 = 0
            if (r4 == 0) goto Ld3
            java.lang.Object r4 = r8.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            com.animaconnected.watch.device.CommandCenter r6 = r2.commandCenter
            if (r6 == 0) goto Lcd
            java.lang.Object r5 = r4.getKey()
            com.animaconnected.watch.fitness.FitnessMetric r5 = (com.animaconnected.watch.fitness.FitnessMetric) r5
            java.lang.String r5 = r5.getMetric()
            int r5 = r6.getCommandNumber$watch_release(r5)
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            java.lang.Object r4 = r4.getValue()
            r9.put(r6, r4)
            goto La1
        Lcd:
            java.lang.String r8 = "commandCenter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            throw r5
        Ld3:
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.String r8 = "fitness_targets"
            java.lang.Object r8 = r2.writeMap(r8, r9, r0)
            if (r8 != r1) goto Le2
            return r1
        Le2:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeHealthGoals(com.animaconnected.watch.fitness.HealthGoals, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeHeartrateLiveMode(boolean r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeHeartrateLiveMode$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeHeartrateLiveMode$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeHeartrateLiveMode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeHeartrateLiveMode$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeHeartrateLiveMode$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L42
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.String r6 = "fitness_heartrate_live"
            java.lang.Object r5 = r4.m1075writeBoolean0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeHeartrateLiveMode(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeIncomingCall(int r5, com.animaconnected.watch.device.CallState r6, java.lang.String r7, boolean r8, boolean r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r4 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.device.MsgPackWatch$writeIncomingCall$2
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.device.MsgPackWatch$writeIncomingCall$2 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeIncomingCall$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeIncomingCall$2 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeIncomingCall$2
            r0.<init>(r4, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            r10.getClass()
            goto L69
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 5
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r5)
            r5 = 0
            r10[r5] = r2
            int r5 = r6.getValue()
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            r10[r3] = r6
            r5 = 2
            r10[r5] = r7
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r8)
            r6 = 3
            r10[r6] = r5
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r9)
            r6 = 4
            r10[r6] = r5
            r0.label = r3
            java.lang.String r5 = "call"
            java.lang.Object r5 = r4.m1074writeArray0E7RQCE(r5, r10, r0)
            if (r5 != r1) goto L69
            return r1
        L69:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeIncomingCall(int, com.animaconnected.watch.device.CallState, java.lang.String, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.animaconnected.watch.device.WatchIO
    /* renamed from: writeMediaNotification-eH_QyT8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo1080writeMediaNotificationeH_QyT8(java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, int r18, int r19, int r20, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r21) {
        /*
            r13 = this;
            r0 = r13
            r1 = r21
            boolean r2 = r1 instanceof com.animaconnected.watch.device.MsgPackWatch$writeMediaNotification$1
            if (r2 == 0) goto L16
            r2 = r1
            com.animaconnected.watch.device.MsgPackWatch$writeMediaNotification$1 r2 = (com.animaconnected.watch.device.MsgPackWatch$writeMediaNotification$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r2.label = r3
            goto L1b
        L16:
            com.animaconnected.watch.device.MsgPackWatch$writeMediaNotification$1 r2 = new com.animaconnected.watch.device.MsgPackWatch$writeMediaNotification$1
            r2.<init>(r13, r1)
        L1b:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L36
            if (r4 != r5) goto L2e
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.Result r1 = (kotlin.Result) r1
            java.lang.Object r1 = r1.value
            goto L68
        L2e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L36:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.Integer r9 = new java.lang.Integer
            r1 = r17
            r9.<init>(r1)
            java.lang.Integer r10 = new java.lang.Integer
            r1 = r18
            r10.<init>(r1)
            java.lang.Integer r11 = new java.lang.Integer
            r1 = r19
            r11.<init>(r1)
            java.lang.Integer r12 = new java.lang.Integer
            r1 = r20
            r12.<init>(r1)
            r6 = r14
            r7 = r15
            r8 = r16
            java.lang.Object[] r1 = new java.lang.Object[]{r6, r7, r8, r9, r10, r11, r12}
            r2.label = r5
            java.lang.String r4 = "media"
            java.lang.Object r1 = r13.m1074writeArray0E7RQCE(r4, r1, r2)
            if (r1 != r3) goto L68
            return r3
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.mo1080writeMediaNotificationeH_QyT8(java.lang.String, java.lang.String, java.lang.String, int, int, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeMotor(int r5, int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$writeMotor$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$writeMotor$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeMotor$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeMotor$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeMotor$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            r7.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            int[] r5 = new int[]{r5, r6}
            r0.label = r3
            java.lang.String r6 = "stepper_goto"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeMotor(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /* renamed from: writeNotification-hUnOzRk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo1081writeNotificationhUnOzRk(int r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, com.animaconnected.watch.device.Vibration r9, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r10) {
        /*
            r4 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.device.MsgPackWatch$writeNotification$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.device.MsgPackWatch$writeNotification$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeNotification$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeNotification$1
            r0.<init>(r4, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r5 = r10.value
            goto L53
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r5)
            int r5 = r9.getId()
            java.lang.Integer r9 = new java.lang.Integer
            r9.<init>(r5)
            java.lang.Object[] r5 = new java.lang.Object[]{r10, r6, r7, r8, r9}
            r0.label = r3
            java.lang.String r6 = "new_notif"
            java.lang.Object r5 = r4.m1074writeArray0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L53
            return r1
        L53:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.mo1081writeNotificationhUnOzRk(int, java.lang.String, java.lang.String, java.lang.String, com.animaconnected.watch.device.Vibration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeOnboardingDone(boolean r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeOnboardingDone$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeOnboardingDone$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeOnboardingDone$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeOnboardingDone$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeOnboardingDone$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L42
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.String r6 = "onboarding_done"
            java.lang.Object r5 = r4.m1076writeInt0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeOnboardingDone(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writePicture(int r13, java.lang.String r14, int r15, int r16, byte[] r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            r12 = this;
            r0 = r12
            r1 = r18
            boolean r2 = r1 instanceof com.animaconnected.watch.device.MsgPackWatch$writePicture$1
            if (r2 == 0) goto L16
            r2 = r1
            com.animaconnected.watch.device.MsgPackWatch$writePicture$1 r2 = (com.animaconnected.watch.device.MsgPackWatch$writePicture$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r2.label = r3
            goto L1b
        L16:
            com.animaconnected.watch.device.MsgPackWatch$writePicture$1 r2 = new com.animaconnected.watch.device.MsgPackWatch$writePicture$1
            r2.<init>(r12, r1)
        L1b:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L37
            if (r4 != r5) goto L2f
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.Result r1 = (kotlin.Result) r1
            r1.getClass()
            goto L67
        L2f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L37:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.Integer r6 = new java.lang.Integer
            r1 = r13
            r6.<init>(r13)
            java.lang.Integer r8 = new java.lang.Integer
            r1 = r15
            r8.<init>(r15)
            java.lang.Integer r9 = new java.lang.Integer
            r1 = r16
            r9.<init>(r1)
            java.lang.Integer r10 = new java.lang.Integer
            r1 = 0
            r10.<init>(r1)
            byte[][] r11 = new byte[r5]
            r11[r1] = r17
            r7 = r14
            java.lang.Object[] r1 = new java.lang.Object[]{r6, r7, r8, r9, r10, r11}
            r2.label = r5
            java.lang.String r4 = "picture"
            java.lang.Object r1 = r12.m1074writeArray0E7RQCE(r4, r1, r2)
            if (r1 != r3) goto L67
            return r3
        L67:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writePicture(int, java.lang.String, int, int, byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeQuietHours(boolean r5, int r6, int r7, int r8, int r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r4 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.device.MsgPackWatch$writeQuietHours$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.device.MsgPackWatch$writeQuietHours$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeQuietHours$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeQuietHours$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeQuietHours$1
            r0.<init>(r4, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            r10.getClass()
            goto L6b
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 5
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r2 = 0
            r10[r2] = r5
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r6)
            r10[r3] = r5
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r7)
            r6 = 2
            r10[r6] = r5
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r8)
            r6 = 3
            r10[r6] = r5
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r9)
            r6 = 4
            r10[r6] = r5
            r0.label = r3
            java.lang.String r5 = "dnd"
            java.lang.Object r5 = r4.m1074writeArray0E7RQCE(r5, r10, r0)
            if (r5 != r1) goto L6b
            return r1
        L6b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeQuietHours(boolean, int, int, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeRecalibrate(boolean r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeRecalibrate$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeRecalibrate$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeRecalibrate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeRecalibrate$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeRecalibrate$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L42
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.String r6 = "recalibrate"
            java.lang.Object r5 = r4.m1075writeBoolean0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeRecalibrate(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeRecalibrateHand(com.animaconnected.watch.device.WatchFace r5, int r6, int r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$writeRecalibrateHand$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$writeRecalibrateHand$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeRecalibrateHand$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeRecalibrateHand$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeRecalibrateHand$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            r8.getClass()
            goto L4a
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            int r5 = r5.getIndex$watch_release()
            int[] r5 = new int[]{r5, r6, r7}
            r0.label = r3
            java.lang.String r6 = "recalibrate_hand"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeRecalibrateHand(com.animaconnected.watch.device.WatchFace, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeRecalibrateMove(com.animaconnected.watch.device.WatchFace r5, int r6, int r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$writeRecalibrateMove$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$writeRecalibrateMove$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeRecalibrateMove$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeRecalibrateMove$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeRecalibrateMove$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            r8.getClass()
            goto L4d
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            int r5 = r5.getIndex$watch_release()
            int r5 = r5 * 2
            int r5 = r5 + r6
            int[] r5 = new int[]{r5, r7}
            r0.label = r3
            java.lang.String r6 = "recalibrate_move"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L4d
            return r1
        L4d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeRecalibrateMove(com.animaconnected.watch.device.WatchFace, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeRemoteDataConfigs(int[][] r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.animaconnected.watch.device.MsgPackWatch$writeRemoteDataConfigs$1
            if (r0 == 0) goto L13
            r0 = r11
            com.animaconnected.watch.device.MsgPackWatch$writeRemoteDataConfigs$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeRemoteDataConfigs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeRemoteDataConfigs$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeRemoteDataConfigs$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result r11 = (kotlin.Result) r11
            r11.getClass()
            goto L8a
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L34:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            int r2 = r10.length
            r4 = 0
            r5 = r4
        L3f:
            if (r5 >= r2) goto L65
            r6 = r10[r5]
            r7 = r6[r4]
            java.lang.Integer r8 = new java.lang.Integer
            r8.<init>(r7)
            r11.add(r8)
            r7 = r6[r3]
            java.lang.Integer r8 = new java.lang.Integer
            r8.<init>(r7)
            r11.add(r8)
            r7 = 2
            r6 = r6[r7]
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r6)
            r11.add(r7)
            int r5 = r5 + 1
            goto L3f
        L65:
            int r10 = r11.size()
            if (r10 == 0) goto L94
            com.animaconnected.watch.device.CommandCenter r10 = r9.commandCenter
            if (r10 == 0) goto L8d
            java.lang.String r2 = "remote_data_config"
            boolean r10 = r10.hasCommand$watch_release(r2)
            if (r10 != 0) goto L78
            goto L94
        L78:
            int[] r10 = kotlin.collections.CollectionsKt___CollectionsKt.toIntArray(r11)
            int r11 = r10.length
            int[] r10 = java.util.Arrays.copyOf(r10, r11)
            r0.label = r3
            java.lang.Object r10 = r9.m1077writeInts0E7RQCE(r2, r10, r0)
            if (r10 != r1) goto L8a
            return r1
        L8a:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L8d:
            java.lang.String r10 = "commandCenter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r10 = 0
            throw r10
        L94:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeRemoteDataConfigs(int[][], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeRemoteDatas(int[][] r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.animaconnected.watch.device.MsgPackWatch$writeRemoteDatas$1
            if (r0 == 0) goto L13
            r0 = r11
            com.animaconnected.watch.device.MsgPackWatch$writeRemoteDatas$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeRemoteDatas$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeRemoteDatas$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeRemoteDatas$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result r11 = (kotlin.Result) r11
            r11.getClass()
            goto L7f
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L34:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            int r2 = r10.length
            r4 = 0
            r5 = r4
        L3f:
            if (r5 >= r2) goto L5a
            r6 = r10[r5]
            r7 = r6[r4]
            java.lang.Integer r8 = new java.lang.Integer
            r8.<init>(r7)
            r11.add(r8)
            r6 = r6[r3]
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r6)
            r11.add(r7)
            int r5 = r5 + 1
            goto L3f
        L5a:
            int r10 = r11.size()
            if (r10 == 0) goto L89
            com.animaconnected.watch.device.CommandCenter r10 = r9.commandCenter
            if (r10 == 0) goto L82
            java.lang.String r2 = "remote_data"
            boolean r10 = r10.hasCommand$watch_release(r2)
            if (r10 != 0) goto L6d
            goto L89
        L6d:
            int[] r10 = kotlin.collections.CollectionsKt___CollectionsKt.toIntArray(r11)
            int r11 = r10.length
            int[] r10 = java.util.Arrays.copyOf(r10, r11)
            r0.label = r3
            java.lang.Object r10 = r9.m1077writeInts0E7RQCE(r2, r10, r0)
            if (r10 != r1) goto L7f
            return r1
        L7f:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L82:
            java.lang.String r10 = "commandCenter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r10 = 0
            throw r10
        L89:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeRemoteDatas(int[][], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeRemoveNotification(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeRemoveNotification$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeRemoveNotification$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeRemoveNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeRemoveNotification$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeRemoveNotification$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L42
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.String r6 = "remove_notif"
            java.lang.Object r5 = r4.m1076writeInt0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeRemoveNotification(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeRequestAppState(int r5, com.animaconnected.watch.display.VisibilityState r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$writeRequestAppState$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$writeRequestAppState$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeRequestAppState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeRequestAppState$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeRequestAppState$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            r7.getClass()
            goto L51
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            int[] r7 = com.animaconnected.watch.device.MsgPackWatch.WhenMappings.$EnumSwitchMapping$1
            int r6 = r6.ordinal()
            r6 = r7[r6]
            if (r6 != r3) goto L51
            r6 = 0
            int[] r5 = new int[]{r6, r5}
            r0.label = r3
            java.lang.String r6 = "uim_action"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L51
            return r1
        L51:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeRequestAppState(int, com.animaconnected.watch.display.VisibilityState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeSessionDataFeed(com.animaconnected.watch.fitness.GpsQuality r5, com.animaconnected.watch.fitness.Distance r6, java.lang.Float r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$writeSessionDataFeed$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$writeSessionDataFeed$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeSessionDataFeed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeSessionDataFeed$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeSessionDataFeed$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            r8.getClass()
            goto L8f
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Integer[] r8 = new java.lang.Integer[r3]
            int r5 = r5.getId()
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r5)
            r5 = 0
            r8[r5] = r2
            java.util.ArrayList r8 = kotlin.collections.CollectionsKt__CollectionsKt.mutableListOf(r8)
            boolean r2 = r6 instanceof com.animaconnected.watch.fitness.KnownDistance
            if (r2 != 0) goto L4f
            if (r7 == 0) goto L60
        L4f:
            if (r2 == 0) goto L58
            com.animaconnected.watch.fitness.KnownDistance r6 = (com.animaconnected.watch.fitness.KnownDistance) r6
            double r5 = r6.getTotal()
            int r5 = (int) r5
        L58:
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            r8.add(r6)
        L60:
            if (r7 == 0) goto L7c
            float r5 = r7.floatValue()
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 < 0) goto L7c
            float r5 = r7.floatValue()
            r6 = 1000(0x3e8, float:1.401E-42)
            float r6 = (float) r6
            float r5 = r5 * r6
            int r5 = (int) r5
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            r8.add(r6)
        L7c:
            com.animaconnected.msgpack.MsgPackCreator r5 = r4.msgPackCreator
            if (r5 == 0) goto L92
            com.animaconnected.msgpack.MsgPack r5 = r5.newArray(r8)
            r0.label = r3
            java.lang.String r6 = "fitness_session_feed"
            java.lang.Object r5 = r4.m1079write0E7RQCE$watch_release(r6, r5, r0)
            if (r5 != r1) goto L8f
            return r1
        L8f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L92:
            java.lang.String r5 = "msgPackCreator"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeSessionDataFeed(com.animaconnected.watch.fitness.GpsQuality, com.animaconnected.watch.fitness.Distance, java.lang.Float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeSpeedCalibration(com.animaconnected.watch.fitness.SpeedCalibration r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.device.MsgPackWatch$writeSpeedCalibration$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.device.MsgPackWatch$writeSpeedCalibration$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeSpeedCalibration$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeSpeedCalibration$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeSpeedCalibration$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            r10.getClass()
            goto Lae
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            kotlin.ResultKt.throwOnFailure(r10)
            com.animaconnected.watch.fitness.SpeedCalibrationFailed r10 = com.animaconnected.watch.fitness.SpeedCalibrationFailed.INSTANCE
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r10)
            if (r10 == 0) goto L42
            r10 = r3
            goto L48
        L42:
            com.animaconnected.watch.fitness.SpeedCalibrationStart r10 = com.animaconnected.watch.fitness.SpeedCalibrationStart.INSTANCE
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r10)
        L48:
            if (r10 == 0) goto L58
            int r9 = r9.getId()
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r9)
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r10)
            goto L9b
        L58:
            boolean r10 = r9 instanceof com.animaconnected.watch.fitness.SpeedCalibrationStop
            if (r10 == 0) goto Lb8
            r10 = 4
            java.lang.Integer[] r10 = new java.lang.Integer[r10]
            int r2 = r9.getId()
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r2)
            r2 = 0
            r10[r2] = r4
            com.animaconnected.watch.fitness.SpeedCalibrationStop r9 = (com.animaconnected.watch.fitness.SpeedCalibrationStop) r9
            int r2 = r9.getDistance()
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r2)
            r10[r3] = r4
            double r4 = r9.getGpsMeanError()
            r2 = 1000(0x3e8, float:1.401E-42)
            double r6 = (double) r2
            double r4 = r4 * r6
            int r2 = (int) r4
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r2)
            r2 = 2
            r10[r2] = r4
            double r4 = r9.getGpsStdError()
            double r4 = r4 * r6
            int r9 = (int) r4
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r9)
            r9 = 3
            r10[r9] = r2
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r10)
        L9b:
            com.animaconnected.msgpack.MsgPackCreator r10 = r8.msgPackCreator
            if (r10 == 0) goto Lb1
            com.animaconnected.msgpack.MsgPack r9 = r10.newArray(r9)
            r0.label = r3
            java.lang.String r10 = "csem_speed_calib"
            java.lang.Object r9 = r8.m1079write0E7RQCE$watch_release(r10, r9, r0)
            if (r9 != r1) goto Lae
            return r1
        Lae:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        Lb1:
            java.lang.String r9 = "msgPackCreator"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r9 = 0
            throw r9
        Lb8:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeSpeedCalibration(com.animaconnected.watch.fitness.SpeedCalibration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeSpeedRead(int r5, int r6, java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$writeSpeedRead$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$writeSpeedRead$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeSpeedRead$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeSpeedRead$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeSpeedRead$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            r8.getClass()
            goto L63
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 3
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r5)
            r5 = 0
            r8[r5] = r2
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r6)
            r8[r3] = r5
            com.animaconnected.msgpack.MsgPackCreator r5 = r4.msgPackCreator
            if (r5 == 0) goto L66
            com.animaconnected.msgpack.MsgPack r5 = r5.newString(r7)
            byte[] r5 = r5.toMsgPackBytes()
            r6 = 2
            r8[r6] = r5
            r0.label = r3
            java.lang.String r5 = "speed_read"
            java.lang.Object r5 = r4.m1074writeArray0E7RQCE(r5, r8, r0)
            if (r5 != r1) goto L63
            return r1
        L63:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L66:
            java.lang.String r5 = "msgPackCreator"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeSpeedRead(int, int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeStartVibratorWithBuiltinTestPattern(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.watch.device.MsgPackWatch$writeStartVibratorWithBuiltinTestPattern$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.watch.device.MsgPackWatch$writeStartVibratorWithBuiltinTestPattern$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeStartVibratorWithBuiltinTestPattern$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeStartVibratorWithBuiltinTestPattern$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeStartVibratorWithBuiltinTestPattern$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            r5.getClass()
            goto L47
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r5)
            r5 = 0
            int[] r5 = new int[]{r5}
            r0.label = r3
            java.lang.String r2 = "vibrator_start"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r2, r5, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeStartVibratorWithBuiltinTestPattern(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeStartVibratorWithPattern(int[] r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.device.MsgPackWatch$writeStartVibratorWithPattern$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.device.MsgPackWatch$writeStartVibratorWithPattern$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeStartVibratorWithPattern$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeStartVibratorWithPattern$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeStartVibratorWithPattern$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            r9.getClass()
            goto L7c
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            kotlin.ResultKt.throwOnFailure(r9)
            int r9 = r8.length
            r2 = 0
            if (r3 > r9) goto L41
            r4 = 18
            if (r9 >= r4) goto L41
            r9 = r3
            goto L42
        L41:
            r9 = r2
        L42:
            if (r9 == 0) goto L4f
            int r9 = r8.length
            int r9 = r9 % 2
            if (r9 == 0) goto L4f
            r9 = r8[r2]
            if (r9 == 0) goto L4f
            r9 = r3
            goto L50
        L4f:
            r9 = r2
        L50:
            if (r9 == 0) goto L7f
            java.util.ArrayList r9 = new java.util.ArrayList
            int r4 = r8.length
            r9.<init>(r4)
            int r4 = r8.length
        L59:
            if (r2 >= r4) goto L68
            r5 = r8[r2]
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            r9.add(r6)
            int r2 = r2 + 1
            goto L59
        L68:
            int[] r8 = kotlin.collections.CollectionsKt___CollectionsKt.toIntArray(r9)
            int r9 = r8.length
            int[] r8 = java.util.Arrays.copyOf(r8, r9)
            r0.label = r3
            java.lang.String r9 = "vibrator_start"
            java.lang.Object r8 = r7.m1077writeInts0E7RQCE(r9, r8, r0)
            if (r8 != r1) goto L7c
            return r1
        L7c:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L7f:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Failed requirement."
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeStartVibratorWithPattern(int[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeStepperExecPredef(int r5, int r6, int r7, int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.device.MsgPackWatch$writeStepperExecPredef$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.device.MsgPackWatch$writeStepperExecPredef$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeStepperExecPredef$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeStepperExecPredef$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeStepperExecPredef$1
            r0.<init>(r4, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            r9.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r9)
            int[] r5 = new int[]{r5, r6, r7, r8}
            r0.label = r3
            java.lang.String r6 = "stepper_exec_predef"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeStepperExecPredef(int, int, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeStepsDay(int r5, int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$writeStepsDay$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$writeStepsDay$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeStepsDay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeStepsDay$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeStepsDay$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            r7.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            int[] r5 = new int[]{r5, r6}
            r0.label = r3
            java.lang.String r6 = "steps_day"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeStepsDay(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeStepsTarget(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeStepsTarget$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeStepsTarget$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeStepsTarget$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeStepsTarget$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeStepsTarget$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L42
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.String r6 = "steps_target"
            java.lang.Object r5 = r4.m1076writeInt0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeStepsTarget(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeStillness(int r5, int r6, int r7, int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.device.MsgPackWatch$writeStillness$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.device.MsgPackWatch$writeStillness$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeStillness$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeStillness$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeStillness$1
            r0.<init>(r4, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            r9.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r9)
            int[] r5 = new int[]{r5, r6, r7, r8}
            r0.label = r3
            java.lang.String r6 = "stillness"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeStillness(int, int, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeStopVibrator(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$writeStopVibrator$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$writeStopVibrator$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeStopVibrator$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeStopVibrator$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeStopVibrator$1
            r0.<init>(r7, r8)
        L18:
            r4 = r0
            java.lang.Object r8 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            r8.getClass()
            goto L48
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "vibrator_end"
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r2
            r1 = r7
            r2 = r8
            java.lang.Object r8 = m1073write0E7RQCE$watch_release$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L48
            return r0
        L48:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeStopVibrator(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeSyncDone(java.util.Set<? extends com.animaconnected.watch.SyncFlags> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeSyncDone$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeSyncDone$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeSyncDone$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeSyncDone$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeSyncDone$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L48
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            com.animaconnected.watch.SyncFlags$Companion r6 = com.animaconnected.watch.SyncFlags.Companion
            int r5 = r6.bitmask(r5)
            r0.label = r3
            java.lang.String r6 = "sync_done"
            java.lang.Object r5 = r4.m1076writeInt0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L48
            return r1
        L48:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeSyncDone(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeTimeZone(int r5, int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$writeTimeZone$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$writeTimeZone$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeTimeZone$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeTimeZone$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeTimeZone$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            r7.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            int[] r5 = new int[]{r5, r6}
            r0.label = r3
            java.lang.String r6 = "timezone"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeTimeZone(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeTriggers(int r5, int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$writeTriggers$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$writeTriggers$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeTriggers$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeTriggers$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeTriggers$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            r7.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            int[] r5 = new int[]{r5, r6}
            r0.label = r3
            java.lang.String r6 = "triggers"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeTriggers(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeValues(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<java.lang.Boolean, ? extends java.lang.Exception>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$writeValues$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$writeValues$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeValues$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeValues$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeValues$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L2c
            kotlin.Result r7 = (kotlin.Result) r7     // Catch: java.lang.Exception -> L2c
            r7.getClass()     // Catch: java.lang.Exception -> L2c
            goto L46
        L2c:
            r5 = move-exception
            goto L4e
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object[] r6 = com.animaconnected.watch.device.MsgPackKt.parseStringToArray(r6)     // Catch: java.lang.Exception -> L2c
            r0.label = r3     // Catch: java.lang.Exception -> L2c
            java.lang.Object r5 = r4.m1074writeArray0E7RQCE(r5, r6, r0)     // Catch: java.lang.Exception -> L2c
            if (r5 != r1) goto L46
            return r1
        L46:
            com.animaconnected.watch.utils.WatchLibResult$Success r5 = new com.animaconnected.watch.utils.WatchLibResult$Success     // Catch: java.lang.Exception -> L2c
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L2c
            r5.<init>(r6)     // Catch: java.lang.Exception -> L2c
            goto L54
        L4e:
            com.animaconnected.watch.utils.WatchLibResult$Failure r6 = new com.animaconnected.watch.utils.WatchLibResult$Failure
            r6.<init>(r5)
            r5 = r6
        L54:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeValues(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeVbatSim(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeVbatSim$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeVbatSim$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeVbatSim$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeVbatSim$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeVbatSim$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L42
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.String r6 = "vbat_sim"
            java.lang.Object r5 = r4.m1076writeInt0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeVbatSim(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeVolume(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeVolume$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeVolume$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeVolume$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeVolume$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeVolume$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L4c
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = 0
            if (r5 < 0) goto L3f
            r2 = 101(0x65, float:1.42E-43)
            if (r5 >= r2) goto L3f
            r6 = r3
        L3f:
            if (r6 == 0) goto L4f
            r0.label = r3
            java.lang.String r6 = "media_vol"
            java.lang.Object r5 = r4.m1076writeInt0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L4f:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Failed requirement."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeVolume(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeWatchTime(com.animaconnected.watch.device.WatchTime r7, boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.device.MsgPackWatch$writeWatchTime$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.device.MsgPackWatch$writeWatchTime$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeWatchTime$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeWatchTime$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeWatchTime$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            r9.getClass()
            goto Lb8
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = 7
            java.lang.Integer[] r9 = new java.lang.Integer[r9]
            int r2 = r7.getYear()
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r2)
            r2 = 0
            r9[r2] = r4
            int r4 = r7.getMonth()
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r4)
            r9[r3] = r5
            int r4 = r7.getDayOfMonth()
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r4)
            r4 = 2
            r9[r4] = r5
            int r4 = r7.getHour()
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r4)
            r4 = 3
            r9[r4] = r5
            int r4 = r7.getMinute()
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r4)
            r4 = 4
            r9[r4] = r5
            int r4 = r7.getSecond()
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r4)
            r4 = 5
            r9[r4] = r5
            int r7 = r7.getDayOfWeek()
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r7)
            r7 = 6
            r9[r7] = r4
            java.util.List r7 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r9)
            if (r8 == 0) goto La5
            java.util.Collection r7 = (java.util.Collection) r7
            r8 = 0
            long r8 = com.animaconnected.info.DateTimeUtilsKt.getCurrentTimezoneOffsetToUTCInMinutes$default(r8, r3, r8)
            int r8 = (int) r8
            java.lang.Integer r9 = new java.lang.Integer
            r9.<init>(r8)
            java.util.ArrayList r7 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r7, r9)
        La5:
            java.util.Collection r7 = (java.util.Collection) r7
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.Object[] r7 = r7.toArray(r8)
            r0.label = r3
            java.lang.String r8 = "datetime"
            java.lang.Object r7 = r6.m1074writeArray0E7RQCE(r8, r7, r0)
            if (r7 != r1) goto Lb8
            return r1
        Lb8:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeWatchTime(com.animaconnected.watch.device.WatchTime, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeComplicationMode(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeComplicationMode$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeComplicationMode$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeComplicationMode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeComplicationMode$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeComplicationMode$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            int[] r5 = new int[]{r5}
            r0.label = r3
            java.lang.String r6 = "set_complication_mode"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeComplicationMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeComplicationModes(int r5, int r6, int r7, int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$2
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$2 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$2 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$2
            r0.<init>(r4, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            r9.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r9)
            int[] r5 = new int[]{r5, r6, r7, r8}
            r0.label = r3
            java.lang.String r6 = "complications"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeComplicationModes(int, int, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeComplicationMode(int[] r5, Continuation<? super Unit> continuation) {
        int length = r5.length;
        if (length == 1) {
            Object writeComplicationMode = writeComplicationMode(r5[0], continuation);
            return writeComplicationMode == CoroutineSingletons.COROUTINE_SUSPENDED ? writeComplicationMode : Unit.INSTANCE;
        }
        if (length == 2) {
            Object writeComplicationMode2 = writeComplicationMode(r5[0], r5[1], continuation);
            return writeComplicationMode2 == CoroutineSingletons.COROUTINE_SUSPENDED ? writeComplicationMode2 : Unit.INSTANCE;
        }
        throw new RuntimeException("Invalid args");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeComplicationModes(int r5, int r6, int r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$3
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$3 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$3 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$3
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            r8.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            int[] r5 = new int[]{r5, r6, r7}
            r0.label = r3
            java.lang.String r6 = "complications"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeComplicationModes(int, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeIncomingCall(int r3, boolean r4, java.lang.Integer r5, boolean r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r2 = this;
            boolean r5 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$writeIncomingCall$1
            if (r5 == 0) goto L13
            r5 = r7
            com.animaconnected.watch.device.MsgPackWatch$writeIncomingCall$1 r5 = (com.animaconnected.watch.device.MsgPackWatch$writeIncomingCall$1) r5
            int r6 = r5.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r6 & r0
            if (r1 == 0) goto L13
            int r6 = r6 - r0
            r5.label = r6
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeIncomingCall$1 r5 = new com.animaconnected.watch.device.MsgPackWatch$writeIncomingCall$1
            r5.<init>(r2, r7)
        L18:
            java.lang.Object r6 = r5.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r0 = r5.label
            r1 = 1
            if (r0 == 0) goto L34
            if (r0 != r1) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L54
        L2c:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r3)
            r3 = 0
            r6[r3] = r0
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r4)
            r6[r1] = r3
            r5.label = r1
            java.lang.String r3 = "call"
            java.lang.Object r3 = r2.m1074writeArray0E7RQCE(r3, r6, r5)
            if (r3 != r7) goto L54
            return r7
        L54:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeIncomingCall(int, boolean, java.lang.Integer, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeComplicationModes(int r5, int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeComplicationModes$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            r7.getClass()
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            int[] r5 = new int[]{r5, r6}
            r0.label = r3
            java.lang.String r6 = "complications"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeComplicationModes(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.device.WatchIODebug
    public Object writeComplicationModes(int[] r10, Continuation<? super Unit> continuation) {
        int length = r10.length;
        if (length == 2) {
            Object writeComplicationModes = writeComplicationModes(r10[0], r10[1], continuation);
            return writeComplicationModes == CoroutineSingletons.COROUTINE_SUSPENDED ? writeComplicationModes : Unit.INSTANCE;
        }
        if (length == 3) {
            Object writeComplicationModes2 = writeComplicationModes(r10[0], r10[1], r10[2], continuation);
            return writeComplicationModes2 == CoroutineSingletons.COROUTINE_SUSPENDED ? writeComplicationModes2 : Unit.INSTANCE;
        }
        if (length == 4) {
            Object writeComplicationModes3 = writeComplicationModes(r10[0], r10[1], r10[2], r10[3], continuation);
            return writeComplicationModes3 == CoroutineSingletons.COROUTINE_SUSPENDED ? writeComplicationModes3 : Unit.INSTANCE;
        }
        if (length == 6) {
            Object writeComplicationModes4 = writeComplicationModes(r10[0], r10[1], r10[2], r10[3], r10[4], r10[5], continuation);
            return writeComplicationModes4 == CoroutineSingletons.COROUTINE_SUSPENDED ? writeComplicationModes4 : Unit.INSTANCE;
        }
        throw new RuntimeException("Invalid args");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.WatchIODebug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeDebugConfig(java.util.List<java.lang.Integer> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.device.MsgPackWatch$writeDebugConfig$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.device.MsgPackWatch$writeDebugConfig$1 r0 = (com.animaconnected.watch.device.MsgPackWatch$writeDebugConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.MsgPackWatch$writeDebugConfig$1 r0 = new com.animaconnected.watch.device.MsgPackWatch$writeDebugConfig$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.getClass()
            goto L56
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L40
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L40:
            java.util.Collection r5 = (java.util.Collection) r5
            int[] r5 = kotlin.collections.CollectionsKt___CollectionsKt.toIntArray(r5)
            int r6 = r5.length
            int[] r5 = java.util.Arrays.copyOf(r5, r6)
            r0.label = r3
            java.lang.String r6 = "config_debug"
            java.lang.Object r5 = r4.m1077writeInts0E7RQCE(r6, r5, r0)
            if (r5 != r1) goto L56
            return r1
        L56:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.MsgPackWatch.writeDebugConfig(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public /* synthetic */ MsgPackWatch(WatchBackend watchBackend, boolean z, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(watchBackend, (r3 & 2) != 0 ? false : z);
    }

    @Override // com.animaconnected.watch.device.WatchIO
    public Object writeDebugConfig(boolean z, boolean z2, boolean z3, boolean z4, int r14, boolean z5, Continuation<? super Unit> continuation) {
        Object writeDebugConfig = writeDebugConfig(z, z2, z3, z4, r14, 60000, z5, continuation);
        return writeDebugConfig == CoroutineSingletons.COROUTINE_SUSPENDED ? writeDebugConfig : Unit.INSTANCE;
    }
}
