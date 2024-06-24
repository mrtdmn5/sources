package com.animaconnected.watch.device;

import com.animaconnected.watch.GroupLayer;
import com.animaconnected.watch.Slot;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchConstants.kt */
/* loaded from: classes3.dex */
public final class WatchConstantsKt {

    /* compiled from: WatchConstants.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[GroupLayer.values().length];
            try {
                r0[GroupLayer.Sonic.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[GroupLayer.MezzoSecundo.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[Slot.values().length];
            try {
                r02[Slot.MainComplication.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r02[Slot.SubComplication1.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r02[Slot.SubComplication2.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    public static final List<GroupLayer> affectedGroupLayers(Slot slot, Capabilities capabilities) {
        Intrinsics.checkNotNullParameter(slot, "<this>");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        int r1 = WhenMappings.$EnumSwitchMapping$0[groupLayer(slot, capabilities).ordinal()];
        if (r1 != 1) {
            if (r1 != 2) {
                return CollectionsKt__CollectionsKt.listOf((Object[]) new GroupLayer[]{GroupLayer.Default, GroupLayer.MezzoSecundo, GroupLayer.Sonic});
            }
            return CollectionsKt__CollectionsKt.listOf((Object[]) new GroupLayer[]{GroupLayer.MezzoSecundo, GroupLayer.Default});
        }
        return CollectionsKt__CollectionsKt.listOf((Object[]) new GroupLayer[]{GroupLayer.Sonic, GroupLayer.Default});
    }

    public static final GroupLayer groupLayer(Slot slot, Capabilities capabilities) {
        Intrinsics.checkNotNullParameter(slot, "<this>");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        if (capabilities.hasTwoSubComplications() && ArraysKt___ArraysKt.contains(Slot.Companion.getSubComplications(), slot)) {
            return GroupLayer.Sonic;
        }
        if (capabilities.hasOneSubComplication() && slot == Slot.SubComplication1) {
            return GroupLayer.MezzoSecundo;
        }
        return GroupLayer.Default;
    }

    public static final WatchFace toWatchFace(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "<this>");
        int r1 = WhenMappings.$EnumSwitchMapping$1[slot.ordinal()];
        if (r1 != 1) {
            if (r1 != 2) {
                if (r1 != 3) {
                    return null;
                }
                return WatchFace.SecondSubdial;
            }
            return WatchFace.FirstSubdial;
        }
        return WatchFace.Main;
    }
}
