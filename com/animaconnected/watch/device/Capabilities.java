package com.animaconnected.watch.device;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import com.animaconnected.info.ByteUtils;
import com.animaconnected.info.DeviceType;
import com.animaconnected.logger.LogKt;
import com.animaconnected.msgpack.MsgPack;
import com.animaconnected.msgpack.MsgPackCreator;
import com.animaconnected.watch.device.WatchFacePosition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Capabilities.kt */
/* loaded from: classes3.dex */
public final class Capabilities {
    public static final Companion Companion = new Companion(null);
    private final DeviceType deviceType;
    private boolean hasActivityTracker;
    private boolean hasAncsActivity;
    private boolean hasAncsLongFilter;
    private boolean hasCallRepeatsAlert;
    private boolean hasChargeableBattery;
    private final boolean hasCompBtnAndCompDef;
    private boolean hasDiagnosticPages;
    private boolean hasDice;
    private boolean hasDisconnectAlert;
    private boolean hasDoubleMainComplication;
    private boolean hasMagicKeyOne;
    private final boolean hasRecalibrateHand;
    private boolean hasRememberLast;
    private boolean hasSixAlerts;
    private boolean hasSleepTracker;
    private boolean hasStopwatch;
    private boolean hasSwButtonReleaseNotify;
    private boolean hasUTCOffset;
    private boolean hasVolumeUpDownViaHid;
    private int numOfButtons;
    private boolean remoteDataFix;
    private Map<WatchFace, WatchFaceData> watchFaces;

    /* compiled from: Capabilities.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Capabilities createDefault() {
            return new Capabilities(DeviceType.GARBO, MapsKt__MapsJVMKt.mapOf(new Pair(WatchFace.Main, new WatchFaceData(WatchFacePosition.Center, EmptyList.INSTANCE, CollectionsKt__CollectionsKt.listOf((Object[]) new Hand[]{new Hand(120), new Hand(180)})))), 3, false, false, (DefaultConstructorMarker) null);
        }

        public final Capabilities createForLegacyDevices(DeviceType deviceType, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            if (!deviceType.isPrimo()) {
                LogKt.warn$default((Object) this, deviceType + " is not a legacy device.", (String) null, (Throwable) null, false, 14, (Object) null);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(WatchFace.Main, new WatchFaceData(WatchFacePosition.Center, EmptyList.INSTANCE, CollectionsKt__CollectionsKt.listOf((Object[]) new Hand[]{new Hand(120), new Hand(180)})));
            if (deviceType == DeviceType.SECONDO) {
                linkedHashMap.put(WatchFace.FirstSubdial, new WatchFaceData(WatchFacePosition.BottomCenter, CollectionsKt__CollectionsKt.listOf((Object[]) new Scale[]{Scale.ZeroToHundred, Scale.ZeroToTwelve}), CollectionsKt__CollectionsKt.listOf((Object[]) new Hand[]{new Hand(120), new Hand(180)})));
            }
            return new Capabilities(deviceType, linkedHashMap, 3, z, z2, (DefaultConstructorMarker) null);
        }

        public final Capabilities createFromBytes(DeviceType deviceType, byte[] bArr, boolean z, boolean z2, MsgPackCreator msgPackCreator) {
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            Intrinsics.checkNotNullParameter(msgPackCreator, "msgPackCreator");
            return new Capabilities(deviceType, bArr, z, z2, msgPackCreator, (DefaultConstructorMarker) null);
        }

        private Companion() {
        }
    }

    /* compiled from: Capabilities.kt */
    /* loaded from: classes3.dex */
    public static final class Hand {
        private final int resolution;

        public Hand(int r1) {
            this.resolution = r1;
        }

        public static /* synthetic */ Hand copy$default(Hand hand, int r1, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                r1 = hand.resolution;
            }
            return hand.copy(r1);
        }

        public final int component1() {
            return this.resolution;
        }

        public final Hand copy(int r2) {
            return new Hand(r2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Hand) && this.resolution == ((Hand) obj).resolution) {
                return true;
            }
            return false;
        }

        public final int getResolution() {
            return this.resolution;
        }

        public int hashCode() {
            return Integer.hashCode(this.resolution);
        }

        public String toString() {
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("Hand(resolution="), this.resolution, ')');
        }
    }

    /* compiled from: Capabilities.kt */
    /* loaded from: classes3.dex */
    public static final class WatchFaceData {
        private final List<Hand> hands;
        private final WatchFacePosition position;
        private final List<Scale> scales;

        /* JADX WARN: Multi-variable type inference failed */
        public WatchFaceData(WatchFacePosition position, List<? extends Scale> scales, List<Hand> hands) {
            Intrinsics.checkNotNullParameter(position, "position");
            Intrinsics.checkNotNullParameter(scales, "scales");
            Intrinsics.checkNotNullParameter(hands, "hands");
            this.position = position;
            this.scales = scales;
            this.hands = hands;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WatchFaceData copy$default(WatchFaceData watchFaceData, WatchFacePosition watchFacePosition, List list, List list2, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                watchFacePosition = watchFaceData.position;
            }
            if ((r4 & 2) != 0) {
                list = watchFaceData.scales;
            }
            if ((r4 & 4) != 0) {
                list2 = watchFaceData.hands;
            }
            return watchFaceData.copy(watchFacePosition, list, list2);
        }

        public final WatchFacePosition component1() {
            return this.position;
        }

        public final List<Scale> component2() {
            return this.scales;
        }

        public final List<Hand> component3() {
            return this.hands;
        }

        public final WatchFaceData copy(WatchFacePosition position, List<? extends Scale> scales, List<Hand> hands) {
            Intrinsics.checkNotNullParameter(position, "position");
            Intrinsics.checkNotNullParameter(scales, "scales");
            Intrinsics.checkNotNullParameter(hands, "hands");
            return new WatchFaceData(position, scales, hands);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WatchFaceData)) {
                return false;
            }
            WatchFaceData watchFaceData = (WatchFaceData) obj;
            if (this.position == watchFaceData.position && Intrinsics.areEqual(this.scales, watchFaceData.scales) && Intrinsics.areEqual(this.hands, watchFaceData.hands)) {
                return true;
            }
            return false;
        }

        public final List<Hand> getHands() {
            return this.hands;
        }

        public final WatchFacePosition getPosition() {
            return this.position;
        }

        public final List<Scale> getScales() {
            return this.scales;
        }

        public int hashCode() {
            return this.hands.hashCode() + VectorGroup$$ExternalSyntheticOutline0.m(this.scales, this.position.hashCode() * 31, 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("WatchFaceData(position=");
            sb.append(this.position);
            sb.append(", scales=");
            sb.append(this.scales);
            sb.append(", hands=");
            return LocaleList$$ExternalSyntheticOutline0.m(sb, this.hands, ')');
        }
    }

    public /* synthetic */ Capabilities(DeviceType deviceType, Map map, int r3, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceType, (Map<WatchFace, WatchFaceData>) map, r3, z, z2);
    }

    private final List<Scale> getSupportedScales(byte b) {
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Scale[]{Scale.ZeroToTwentyFour, Scale.ZeroToHundred, Scale.ZeroToThirtyOne, Scale.DaysOfWeek, Scale.ZeroToSixty});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listOf) {
            if (ByteUtils.isSet(b, ((Scale) obj).getPosition())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean getHasActivityTracker() {
        return this.hasActivityTracker;
    }

    public final boolean getHasAncsActivity() {
        return this.hasAncsActivity;
    }

    public final boolean getHasAncsLongFilter() {
        return this.hasAncsLongFilter;
    }

    public final boolean getHasCallRepeatsAlert() {
        return this.hasCallRepeatsAlert;
    }

    public final boolean getHasChargeableBattery() {
        return this.hasChargeableBattery;
    }

    public final boolean getHasDiagnosticPages() {
        return this.hasDiagnosticPages;
    }

    public final boolean getHasDice() {
        return this.hasDice;
    }

    public final boolean getHasDoubleMainComplication() {
        return this.hasDoubleMainComplication;
    }

    public final boolean getHasMagicKeyOne() {
        return this.hasMagicKeyOne;
    }

    public final boolean getHasRecalibrateHand() {
        return this.hasRecalibrateHand;
    }

    public final boolean getHasRememberLast() {
        return this.hasRememberLast;
    }

    public final boolean getHasSixAlerts() {
        return this.hasSixAlerts;
    }

    public final boolean getHasSleepTracker() {
        return this.hasSleepTracker;
    }

    public final boolean getHasStopwatch() {
        return this.hasStopwatch;
    }

    public final boolean getHasUTCOffset() {
        return this.hasUTCOffset;
    }

    public final boolean getHasVolumeUpDownViaHid() {
        return this.hasVolumeUpDownViaHid;
    }

    public final int getNumOfButtons() {
        return this.numOfButtons;
    }

    public final WatchFace getWatchFaceAtPosition(WatchFacePosition position) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(position, "position");
        Iterator<T> it = this.watchFaces.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((WatchFaceData) ((Map.Entry) obj).getValue()).getPosition() == position) {
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
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return null;
        }
        return (WatchFace) entry.getKey();
    }

    public final Map<WatchFace, WatchFaceData> getWatchFaces() {
        return this.watchFaces;
    }

    public final boolean hasButtonActionLongPressReleaseNotify() {
        if (!this.hasSwButtonReleaseNotify && this.deviceType.isPrimo()) {
            return false;
        }
        return true;
    }

    public final boolean hasComplicationZeroNoTimeout() {
        return this.hasCompBtnAndCompDef;
    }

    public final boolean hasDisconnectAlert() {
        DeviceType deviceType = this.deviceType;
        if (deviceType == DeviceType.FKS927) {
            return false;
        }
        if (deviceType.isPrimo()) {
            return this.hasStopwatch;
        }
        return this.hasDisconnectAlert;
    }

    public final boolean hasIncreaseDecreaseTimer() {
        if (this.deviceType.isPrimo()) {
            return this.hasRememberLast;
        }
        return true;
    }

    public final boolean hasOneSubComplication() {
        if (this.watchFaces.size() == 2) {
            return true;
        }
        return false;
    }

    public final boolean hasRemoteDataFix() {
        return this.remoteDataFix;
    }

    public final boolean hasScaleOnSubdials(Scale capability) {
        Intrinsics.checkNotNullParameter(capability, "capability");
        if (!hasScaleOnWatchFace(WatchFace.FirstSubdial, capability) && !hasScaleOnWatchFace(WatchFace.SecondSubdial, capability)) {
            return false;
        }
        return true;
    }

    public final boolean hasScaleOnWatchFace(WatchFace watchFace, Scale capability) {
        List<Scale> scales;
        Intrinsics.checkNotNullParameter(watchFace, "watchFace");
        Intrinsics.checkNotNullParameter(capability, "capability");
        WatchFaceData watchFaceData = this.watchFaces.get(watchFace);
        if (watchFaceData != null && (scales = watchFaceData.getScales()) != null) {
            return scales.contains(capability);
        }
        return false;
    }

    public final boolean hasSubComplications() {
        if (this.watchFaces.size() > 1) {
            return true;
        }
        return false;
    }

    public final boolean hasTwoSubComplications() {
        if (this.watchFaces.size() == 3) {
            return true;
        }
        return false;
    }

    public final boolean hasWatchfaceLayout(int... handsPerWatchFace) {
        Intrinsics.checkNotNullParameter(handsPerWatchFace, "handsPerWatchFace");
        if (this.watchFaces.size() != handsPerWatchFace.length) {
            return false;
        }
        int r1 = 0;
        for (Object obj : this.watchFaces.values()) {
            int r4 = r1 + 1;
            if (r1 >= 0) {
                if (((WatchFaceData) obj).getHands().size() != handsPerWatchFace[r1]) {
                    return false;
                }
                r1 = r4;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        return true;
    }

    public final void setHasUTCOffset(boolean z) {
        this.hasUTCOffset = z;
    }

    public /* synthetic */ Capabilities(DeviceType deviceType, byte[] bArr, boolean z, boolean z2, MsgPackCreator msgPackCreator, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceType, bArr, z, z2, msgPackCreator);
    }

    private Capabilities(DeviceType deviceType, Map<WatchFace, WatchFaceData> map, int r3, boolean z, boolean z2) {
        this.deviceType = deviceType;
        this.watchFaces = map;
        this.numOfButtons = r3;
        this.hasCompBtnAndCompDef = z;
        this.hasRecalibrateHand = z2;
        this.hasDoubleMainComplication = false;
        this.hasSleepTracker = false;
        this.hasActivityTracker = false;
    }

    private Capabilities(DeviceType deviceType, byte[] bArr, boolean z, boolean z2, MsgPackCreator msgPackCreator) {
        Pair pair;
        Map<WatchFace, WatchFaceData> map = EmptyMap.INSTANCE;
        this.watchFaces = map;
        this.deviceType = deviceType;
        this.hasCompBtnAndCompDef = z;
        this.hasRecalibrateHand = z2;
        try {
            Intrinsics.checkNotNull(bArr);
            Map<Integer, MsgPack> map2 = msgPackCreator.fromBytes(bArr).getMap();
            ArrayList arrayList = new ArrayList(map2.size());
            for (Map.Entry<Integer, MsgPack> entry : map2.entrySet()) {
                arrayList.add(new Pair(Integer.valueOf(entry.getKey().intValue()), entry.getValue()));
            }
            Map map3 = MapsKt__MapsKt.toMap(arrayList);
            List<MsgPack> tryList = MsgPackKt.tryList(map3, 21);
            int r5 = 0;
            if (tryList != null) {
                List<MsgPack> list = tryList;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
                int r9 = 0;
                for (Object obj : list) {
                    int r11 = r9 + 1;
                    if (r9 >= 0) {
                        List<MsgPack> asList = ((MsgPack) obj).asList();
                        MsgPack msgPack = (MsgPack) CollectionsKt___CollectionsKt.getOrNull(r5, asList);
                        List<Integer> tryIntList = msgPack != null ? MsgPackKt.tryIntList(msgPack) : null;
                        if (tryIntList != null) {
                            MsgPack msgPack2 = (MsgPack) CollectionsKt___CollectionsKt.getOrNull(1, asList);
                            Byte valueOf = msgPack2 != null ? Byte.valueOf(msgPack2.asByte()) : null;
                            if (valueOf != null) {
                                byte byteValue = valueOf.byteValue();
                                WatchFacePosition.Companion companion = WatchFacePosition.Companion;
                                MsgPack msgPack3 = (MsgPack) CollectionsKt___CollectionsKt.getOrNull(2, asList);
                                WatchFacePosition parse$watch_release = companion.parse$watch_release(msgPack3 != null ? Integer.valueOf(msgPack3.asInt()) : null);
                                if (parse$watch_release != null) {
                                    WatchFace parseIndex = WatchFace.Companion.parseIndex(r9);
                                    List<Scale> supportedScales = getSupportedScales(byteValue);
                                    List<Integer> list2 = tryIntList;
                                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
                                    Iterator<T> it = list2.iterator();
                                    while (it.hasNext()) {
                                        arrayList3.add(new Hand(((Number) it.next()).intValue()));
                                    }
                                    arrayList2.add(new Pair(parseIndex, new WatchFaceData(parse$watch_release, supportedScales, arrayList3)));
                                    r9 = r11;
                                    r5 = 0;
                                } else {
                                    throw new IllegalArgumentException("Missing position index".toString());
                                }
                            } else {
                                throw new IllegalArgumentException("Missing capabilities index".toString());
                            }
                        } else {
                            throw new IllegalArgumentException("Missing hands index".toString());
                        }
                    } else {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                        throw null;
                    }
                }
                this.watchFaces = MapsKt__MapsKt.toMap(arrayList2);
            } else {
                List<MsgPack> tryList2 = MsgPackKt.tryList(map3, 1);
                if (tryList2 != null) {
                    List<MsgPack> list3 = tryList2;
                    ArrayList arrayList4 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list3, 10));
                    int r52 = 0;
                    for (Object obj2 : list3) {
                        int r10 = r52 + 1;
                        if (r52 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                            throw null;
                        }
                        List<MsgPack> asList2 = ((MsgPack) obj2).asList();
                        ArrayList arrayList5 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(asList2, 10));
                        Iterator<T> it2 = asList2.iterator();
                        while (it2.hasNext()) {
                            arrayList5.add(new Hand(((MsgPack) it2.next()).asInt()));
                        }
                        if (r52 == 0) {
                            pair = new Pair(WatchFace.Companion.parseIndex(r52), new WatchFaceData(WatchFacePosition.Center, EmptyList.INSTANCE, arrayList5));
                        } else {
                            pair = new Pair(WatchFace.Companion.parseIndex(r52), new WatchFaceData(WatchFacePosition.BottomCenter, CollectionsKt__CollectionsKt.listOf((Object[]) new Scale[]{Scale.ZeroToHundred, Scale.ZeroToTwelve}), arrayList5));
                        }
                        arrayList4.add(pair);
                        r52 = r10;
                    }
                    map = MapsKt__MapsKt.toMap(arrayList4);
                }
                this.watchFaces = map;
            }
            this.numOfButtons = MsgPackKt.tryInt$default(map3, 2, 0, 2, (Object) null);
            this.remoteDataFix = MsgPackKt.tryBool$default(map3, 4, false, 2, null);
            this.hasUTCOffset = MsgPackKt.tryBool$default(map3, 37, false, 2, null);
            this.hasVolumeUpDownViaHid = MsgPackKt.tryBool$default(map3, 5, false, 2, null);
            this.hasStopwatch = MsgPackKt.tryBool$default(map3, 9, false, 2, null);
            this.hasSwButtonReleaseNotify = MsgPackKt.tryBool$default(map3, 22, false, 2, null);
            this.hasCallRepeatsAlert = MsgPackKt.tryBool$default(map3, 6, false, 2, null);
            this.hasMagicKeyOne = MsgPackKt.tryBool$default(map3, 7, false, 2, null);
            this.hasDoubleMainComplication = MsgPackKt.tryBool$default(map3, 24, false, 2, null);
            this.hasDisconnectAlert = MsgPackKt.tryBool$default(map3, 27, false, 2, null);
            this.hasSleepTracker = MsgPackKt.tryBool$default(map3, 30, false, 2, null);
            this.hasChargeableBattery = MsgPackKt.tryBool$default(map3, 31, false, 2, null);
            this.hasDiagnosticPages = MsgPackKt.tryBool$default(map3, 34, false, 2, null);
            this.hasActivityTracker = MsgPackKt.tryBool$default(map3, 32, false, 2, null);
            this.hasDice = MsgPackKt.tryBool$default(map3, 15, false, 2, null);
            this.hasRememberLast = MsgPackKt.tryBool$default(map3, 11, false, 2, null);
            this.hasSixAlerts = MsgPackKt.tryBool$default(map3, 17, false, 2, null);
            this.hasAncsActivity = MsgPackKt.tryBool$default(map3, 20, false, 2, null);
            this.hasAncsLongFilter = MsgPackKt.tryBool$default(map3, 23, false, 2, null);
        } catch (Exception e) {
            LogKt.warn$default((Object) this, "Failed to cast data from map", (String) null, (Throwable) e, false, 10, (Object) null);
        }
    }

    public static /* synthetic */ void getHasAncsActivity$annotations() {
    }

    public static /* synthetic */ void getHasAncsLongFilter$annotations() {
    }

    public static /* synthetic */ void getHasRememberLast$annotations() {
    }
}
