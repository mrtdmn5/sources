package com.animaconnected.watch;

import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.Complication;
import com.animaconnected.watch.device.Capabilities;
import com.animaconnected.watch.device.Scale;
import com.animaconnected.watch.device.WatchConstantsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlotScalesHelper.kt */
/* loaded from: classes3.dex */
public final class SlotScalesHelper {
    public static final SlotScalesHelper INSTANCE = new SlotScalesHelper();

    /* compiled from: SlotScalesHelper.kt */
    /* loaded from: classes3.dex */
    public static final class SlotScale {
        private final Scale scale;
        private final Slot slot;

        public SlotScale(Slot slot, Scale scale) {
            Intrinsics.checkNotNullParameter(slot, "slot");
            Intrinsics.checkNotNullParameter(scale, "scale");
            this.slot = slot;
            this.scale = scale;
        }

        public static /* synthetic */ SlotScale copy$default(SlotScale slotScale, Slot slot, Scale scale, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                slot = slotScale.slot;
            }
            if ((r3 & 2) != 0) {
                scale = slotScale.scale;
            }
            return slotScale.copy(slot, scale);
        }

        public final Slot component1() {
            return this.slot;
        }

        public final Scale component2() {
            return this.scale;
        }

        public final SlotScale copy(Slot slot, Scale scale) {
            Intrinsics.checkNotNullParameter(slot, "slot");
            Intrinsics.checkNotNullParameter(scale, "scale");
            return new SlotScale(slot, scale);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SlotScale)) {
                return false;
            }
            SlotScale slotScale = (SlotScale) obj;
            if (this.slot == slotScale.slot && this.scale == slotScale.scale) {
                return true;
            }
            return false;
        }

        public final Scale getScale() {
            return this.scale;
        }

        public final Slot getSlot() {
            return this.slot;
        }

        public int hashCode() {
            return this.scale.hashCode() + (this.slot.hashCode() * 31);
        }

        public String toString() {
            return "SlotScale(slot=" + this.slot + ", scale=" + this.scale + ')';
        }
    }

    private SlotScalesHelper() {
    }

    private final List<SlotScale> getSlotScalesMain(List<? extends Slot> list) {
        Object obj;
        boolean z;
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                Slot slot = (Slot) obj;
                if (slot != Slot.MainComplication && slot != Slot.MainComplicationDouble) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Slot slot2 = (Slot) obj;
        if (slot2 != null) {
            return CollectionsKt__CollectionsKt.listOf(new SlotScale(slot2, Scale.Unknown));
        }
        return EmptyList.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<SlotScale> getSlotScalesSub(List<? extends Slot> list, Capabilities capabilities, List<? extends Scale> list2) {
        List<Scale> list3;
        boolean z;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Slot slot = (Slot) obj;
            if (slot != Slot.SubComplication1 && slot != Slot.SubComplication2) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Slot slot2 = (Slot) it.next();
            Capabilities.WatchFaceData watchFaceData = capabilities.getWatchFaces().get(WatchConstantsKt.toWatchFace(slot2));
            Pair pair = null;
            if (watchFaceData != null) {
                list3 = watchFaceData.getScales();
            } else {
                list3 = null;
            }
            if (list3 != null) {
                pair = new Pair(slot2, list3);
            }
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Pair pair2 = (Pair) it2.next();
            Slot slot3 = (Slot) pair2.first;
            List list4 = (List) pair2.second;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : list2) {
                if (list4.contains((Scale) obj2)) {
                    arrayList4.add(obj2);
                }
            }
            ArrayList arrayList5 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList4, 10));
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                arrayList5.add(new SlotScale(slot3, (Scale) it3.next()));
            }
            arrayList3.add(arrayList5);
        }
        return CollectionsKt__IteratorsJVMKt.flatten(arrayList3);
    }

    public final List<SlotScale> getSlotScales(Capabilities capabilities, Behaviour behaviour, Slot currentSlot) {
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(behaviour, "behaviour");
        Intrinsics.checkNotNullParameter(currentSlot, "currentSlot");
        List<? extends Slot> listOf = CollectionsKt__CollectionsKt.listOf(currentSlot);
        if (!(behaviour instanceof Complication)) {
            return EmptyList.INSTANCE;
        }
        List<SlotScale> slotScalesMain = getSlotScalesMain(listOf);
        if (!slotScalesMain.isEmpty()) {
            return slotScalesMain;
        }
        Complication complication = (Complication) behaviour;
        List<SlotScale> slotScalesSub = getSlotScalesSub(listOf, capabilities, complication.compatibleScales());
        if (!slotScalesSub.isEmpty()) {
            return slotScalesSub;
        }
        List<? extends Slot> asList = ArraysKt___ArraysJvmKt.asList(behaviour.compatibleSlots());
        return CollectionsKt___CollectionsKt.plus((Iterable) getSlotScalesSub(asList, capabilities, complication.compatibleScales()), (Collection) getSlotScalesMain(asList));
    }
}
