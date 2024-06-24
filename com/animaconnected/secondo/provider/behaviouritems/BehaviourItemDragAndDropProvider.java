package com.animaconnected.secondo.provider.behaviouritems;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.animaconnected.draganddrop.provider.BadgeState;
import com.animaconnected.draganddrop.provider.BadgeVisualState;
import com.animaconnected.draganddrop.provider.DragAndDropProvider;
import com.animaconnected.draganddrop.provider.model.DragAndDropDroppableItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropMarbleIconItem;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.behaviour.BehaviourPluginKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.ThemeProviderBase;
import com.animaconnected.secondo.provider.labs.LabsProvider;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.behaviour.Complication;
import com.animaconnected.watch.behaviour.types.Empty;
import com.animaconnected.watch.device.Capabilities;
import com.animaconnected.watch.device.Scale;
import com.animaconnected.watch.device.WatchConstantsKt;
import com.animaconnected.watch.device.WatchFace;
import com.animaconnected.watch.device.WatchFacePosition;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: BehaviourItemDragAndDropProvider.kt */
/* loaded from: classes3.dex */
public final class BehaviourItemDragAndDropProvider extends DragAndDropProvider<Behaviour> {
    private static final int GROUP_1 = 0;
    private static final int GROUP_2 = 1;
    private static final int GROUP_3 = 2;
    private static final int WATCH_FACE_POSITION_DOUBLE_MAIN_COMPLICATION = 9;
    private final Map<String, BadgeState> badgeStatesMain;
    private final Map<String, BadgeState> badgeStatesSub;
    private final List<BehaviourPlugin<Behaviour>> behaviourPlugins;
    private final Behaviours behaviours;
    private final Capabilities capabilities;
    private final DoubleCrownProvider doubleCrownProvider;
    private Slot doubleMainComplicationSlot;
    private final int draggedItemResourceId;
    private final int droppedItemResourceId;
    private final int emptyMarbleColorInt;
    private final Slot firstSlot;
    private final int gridDropZoneNotSelectedResourceId;
    private final int gridDropZoneSelectedResourceId;
    private int group1ResourceId;
    private int group2ResourceId;
    private int group3ResourceId;
    private int groupBottomNotSelectedResourceId;
    private int groupBottomSelectedResourceId;
    private int groupDoubleMainComplication;
    private int groupDoubleMainComplicationNotSelectedResourceId;
    private int groupDoubleMainComplicationSelectedResourceId;
    private int groupMainComplicationNotSelectedResourceId;
    private int groupMainComplicationSelectedResourceId;
    private int groupSubComplicationNotSelectedResourceId;
    private int groupSubComplicationSelectedResourceId;
    private int groupTopNotSelectedResourceId;
    private int groupTopSelectedResourceId;
    private final boolean hasDoubleMainComplication;
    private final boolean hasOneSubComplication;
    private final boolean hasSubComplication;
    private final boolean hasTwoSubComplications;
    private final int headerTextStyle;
    private final LabsProvider labsProvider;
    private Slot secondSlot;
    private Slot thirdSlot;
    private final boolean useTabbed;
    private final WatchProvider watch;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: BehaviourItemDragAndDropProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private static /* synthetic */ void getWATCH_FACE_POSITION_DOUBLE_MAIN_COMPLICATION$annotations() {
        }
    }

    /* compiled from: BehaviourItemDragAndDropProvider.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[WatchFacePosition.values().length];
            try {
                r0[WatchFacePosition.Center.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[WatchFacePosition.BottomCenter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[WatchFacePosition.BottomLeft.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[WatchFacePosition.BottomRight.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BehaviourItemDragAndDropProvider(Context context, Slot behaviourSlot, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(behaviourSlot, "behaviourSlot");
        this.useTabbed = z;
        WatchProvider watch = ProviderFactory.getWatch();
        this.watch = watch;
        this.labsProvider = ProviderFactory.getLabsProvider();
        this.doubleCrownProvider = ProviderFactory.getDoubleCrownProvider();
        this.capabilities = watch.getCapabilities();
        this.behaviours = watch.getWatchManager().getBehaviours();
        this.groupDoubleMainComplication = -1;
        ArrayList<BehaviourPlugin> arrayList = new ArrayList();
        this.behaviourPlugins = arrayList;
        Slot slot = Slot.Unknown;
        this.secondSlot = slot;
        this.thirdSlot = slot;
        this.doubleMainComplicationSlot = slot;
        this.badgeStatesMain = new HashMap();
        this.badgeStatesSub = new HashMap();
        ThemeProviderBase.Companion companion = ThemeProviderBase.Companion;
        this.emptyMarbleColorInt = companion.getColor(context, R.attr.colorMarbleEmptyIcon);
        this.headerTextStyle = companion.getResourceId(context, R.attr.headersTextStyle);
        arrayList.addAll(new BehaviourPickerProvider(behaviourSlot).behavioursPlugins(watch.getWatch()));
        for (BehaviourPlugin behaviourPlugin : arrayList) {
            Map<String, BadgeState> map = this.badgeStatesMain;
            String type = behaviourPlugin.getType();
            BadgeState badgeState = BadgeState.Normal;
            map.put(type, badgeState);
            if (this.useTabbed) {
                this.badgeStatesSub.put(behaviourPlugin.getType(), badgeState);
            }
        }
        this.firstSlot = behaviourSlot;
        boolean hasSubComplications = this.capabilities.hasSubComplications();
        this.hasSubComplication = hasSubComplications;
        boolean hasOneSubComplication = this.capabilities.hasOneSubComplication();
        this.hasOneSubComplication = hasOneSubComplication;
        boolean hasTwoSubComplications = this.capabilities.hasTwoSubComplications();
        this.hasTwoSubComplications = hasTwoSubComplications;
        boolean hasDoubleMainComplication = this.capabilities.getHasDoubleMainComplication();
        this.hasDoubleMainComplication = hasDoubleMainComplication;
        ThemeProviderBase.Companion companion2 = ThemeProviderBase.Companion;
        this.gridDropZoneNotSelectedResourceId = companion2.getResourceId(context, R.attr.gridDropZoneNotSelected);
        this.gridDropZoneSelectedResourceId = companion2.getResourceId(context, R.attr.gridDropZoneSelected);
        this.draggedItemResourceId = companion2.getResourceId(context, R.attr.draggedItem);
        this.droppedItemResourceId = companion2.getResourceId(context, R.attr.droppedItem);
        if (behaviourSlot == Slot.TopPusher) {
            this.secondSlot = Slot.BottomPusher;
            this.group1ResourceId = R.string.pushers_top;
            this.group2ResourceId = R.string.pushers_bottom;
            this.groupTopNotSelectedResourceId = companion2.getResourceId(context, R.attr.topPusherDropZoneNotSelected);
            this.groupBottomNotSelectedResourceId = companion2.getResourceId(context, R.attr.bottomPusherDropZoneNotSelected);
            this.groupTopSelectedResourceId = companion2.getResourceId(context, R.attr.topPusherDropZoneSelected);
            this.groupBottomSelectedResourceId = companion2.getResourceId(context, R.attr.bottomPusherDropZoneSelected);
            return;
        }
        if (behaviourSlot == Slot.MainComplication) {
            this.group1ResourceId = R.string.complication_main;
            this.groupMainComplicationNotSelectedResourceId = companion2.getResourceId(context, R.attr.mainComplicationDropZoneNotSelected);
            this.groupMainComplicationSelectedResourceId = companion2.getResourceId(context, R.attr.mainComplicationDropZoneSelected);
            if (hasSubComplications) {
                this.groupSubComplicationNotSelectedResourceId = companion2.getResourceId(context, R.attr.subComplicationDropZoneNotSelected);
                this.groupSubComplicationSelectedResourceId = companion2.getResourceId(context, R.attr.subComplicationDropZoneSelected);
                if (hasOneSubComplication) {
                    WatchFace watchFaceAtPosition = this.capabilities.getWatchFaceAtPosition(WatchFacePosition.BottomCenter);
                    Behaviours behaviours = this.behaviours;
                    Intrinsics.checkNotNull(watchFaceAtPosition);
                    this.secondSlot = behaviours.getSlotForWatchFace(watchFaceAtPosition);
                    this.group2ResourceId = R.string.complication_sub;
                    if (hasDoubleMainComplication) {
                        this.groupDoubleMainComplication = 2;
                    }
                } else if (hasTwoSubComplications) {
                    WatchFace watchFaceAtPosition2 = this.capabilities.getWatchFaceAtPosition(WatchFacePosition.BottomRight);
                    Behaviours behaviours2 = this.behaviours;
                    Intrinsics.checkNotNull(watchFaceAtPosition2);
                    this.secondSlot = behaviours2.getSlotForWatchFace(watchFaceAtPosition2);
                    WatchFace watchFaceAtPosition3 = this.capabilities.getWatchFaceAtPosition(WatchFacePosition.BottomLeft);
                    Behaviours behaviours3 = this.behaviours;
                    Intrinsics.checkNotNull(watchFaceAtPosition3);
                    this.thirdSlot = behaviours3.getSlotForWatchFace(watchFaceAtPosition3);
                    this.group2ResourceId = R.string.complication_sub;
                    this.group3ResourceId = R.string.complication_sub;
                    if (hasDoubleMainComplication) {
                        this.groupDoubleMainComplication = 3;
                    }
                }
            } else if (hasDoubleMainComplication) {
                this.groupDoubleMainComplication = 1;
            }
            if (hasDoubleMainComplication) {
                this.doubleMainComplicationSlot = Slot.MainComplicationDouble;
                this.groupDoubleMainComplicationNotSelectedResourceId = companion2.getResourceId(context, R.attr.subComplicationDropZoneNotSelected);
                this.groupDoubleMainComplicationSelectedResourceId = companion2.getResourceId(context, R.attr.subComplicationDropZoneSelected);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DragAndDropMarbleIconItem createDragAndDropMarbleIconItem(BehaviourPlugin<?> behaviourPlugin, int r16, LabsProvider labsProvider) {
        ThemeProviderBase.Companion companion = ThemeProviderBase.Companion;
        int resourceId = companion.getResourceId(getContext(), R.attr.styleMarbleText);
        Integer valueOf = Integer.valueOf(companion.getColor(getContext(), R.attr.colorMarbleIcon));
        if (!behaviourPlugin.shouldTintIcon()) {
            valueOf = null;
        }
        Integer num = valueOf;
        Context context = getContext();
        int resourceId2 = companion.getResourceId(getContext(), R.attr.colorMarbleEmptyIcon);
        Object obj = ContextCompat.sLock;
        int color = ContextCompat.Api23Impl.getColor(context, resourceId2);
        if (labsProvider.isBehaviourTypeLabs(behaviourPlugin.getType())) {
            return new DragAndDropMarbleIconItem(r16, -1, behaviourPlugin.getIconResourceId(), getContext().getString(behaviourPlugin.getNameId()), labsProvider.getLabsBackgroundDroppedResourceId(), labsProvider.getLabsBackgroundDraggedResourceId(), resourceId, (Integer) (-1), color);
        }
        return new DragAndDropMarbleIconItem(r16, -1, behaviourPlugin.getIconResourceId(), getContext().getString(behaviourPlugin.getNameId()), this.droppedItemResourceId, this.draggedItemResourceId, resourceId, num, color);
    }

    private final Map<String, BadgeState> getBadgeStateMap(int r2) {
        if (r2 == 1) {
            return this.badgeStatesSub;
        }
        return this.badgeStatesMain;
    }

    private final int getGroupFromPosition(WatchFacePosition watchFacePosition) {
        int r4 = WhenMappings.$EnumSwitchMapping$0[watchFacePosition.ordinal()];
        if (r4 != 1) {
            if (r4 == 2 || r4 == 3) {
                return 1;
            }
            if (r4 == 4) {
                return 2;
            }
            return -1;
        }
        return 0;
    }

    private final int getGroupFromSlot(Slot slot) {
        Slot slot2 = this.firstSlot;
        if (slot2 == Slot.TopPusher) {
            if (slot == slot2) {
                return 0;
            }
            if (slot == this.secondSlot) {
                return 1;
            }
            return -1;
        }
        if (slot == Slot.MainComplicationDouble) {
            return this.groupDoubleMainComplication;
        }
        Capabilities.WatchFaceData watchFaceData = this.capabilities.getWatchFaces().get(WatchConstantsKt.toWatchFace(slot));
        Intrinsics.checkNotNull(watchFaceData);
        return getGroupFromPosition(watchFaceData.getPosition());
    }

    private final WatchFacePosition getPositionFromGroup(int r3) {
        if (this.hasOneSubComplication) {
            if (r3 != 0) {
                if (r3 == 1) {
                    return WatchFacePosition.BottomCenter;
                }
                return null;
            }
            return WatchFacePosition.Center;
        }
        if (this.hasTwoSubComplications) {
            if (r3 != 0) {
                if (r3 != 1) {
                    if (r3 == 2) {
                        return WatchFacePosition.BottomRight;
                    }
                    return null;
                }
                return WatchFacePosition.BottomLeft;
            }
            return WatchFacePosition.Center;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initIndexes() {
        int r1 = 0;
        for (DragAndDropItem dragAndDropItem : getItems()) {
            int r2 = r1 + 1;
            if (dragAndDropItem instanceof DragAndDropDroppableItem) {
                ((DragAndDropDroppableItem) dragAndDropItem).setSourceGridViewIndex(r1);
            }
            r1 = r2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x028c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x020a -> B:17:0x0266). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0248 -> B:13:0x024b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0264 -> B:16:0x025c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0280 -> B:18:0x028a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initItemDataTabbed(kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            Method dump skipped, instructions count: 669
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.behaviouritems.BehaviourItemDragAndDropProvider.initItemDataTabbed(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean isCompatibleWithSlot(Behaviour behaviour, Slot slot) {
        List<Scale> arrayList;
        if (slot != Slot.MainComplication && slot != Slot.MainComplicationDouble) {
            Capabilities.WatchFaceData watchFaceData = this.capabilities.getWatchFaces().get(WatchConstantsKt.toWatchFace(slot));
            if (watchFaceData == null || (arrayList = watchFaceData.getScales()) == null) {
                arrayList = new ArrayList<>();
            }
            if (!(behaviour instanceof Complication)) {
                return false;
            }
            for (Scale scale : ((Complication) behaviour).compatibleScales()) {
                if (scale == Scale.All || arrayList.contains(scale)) {
                    return true;
                }
            }
        } else {
            for (Slot slot2 : behaviour.compatibleSlots()) {
                if (slot2 == slot) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isCompatibleWithSlots(String str, Slot[] slotArr) {
        Behaviour behaviour = this.watch.getBehaviours().getBehaviour(str);
        if (behaviour == null) {
            return false;
        }
        for (Slot slot : slotArr) {
            if (isCompatibleWithSlot(behaviour, slot)) {
                return true;
            }
        }
        return false;
    }

    private final void setDroppedFromGroup(DragAndDropDroppableItem dragAndDropDroppableItem, int r7, int r8) {
        boolean z = true;
        if (this.firstSlot == Slot.TopPusher) {
            Intrinsics.checkNotNull(dragAndDropDroppableItem);
            if (r7 == -1) {
                z = false;
            }
            dragAndDropDroppableItem.setDropped(z, 2);
            return;
        }
        if (belongsToAdapterType(r7, r8)) {
            Intrinsics.checkNotNull(dragAndDropDroppableItem);
            if (r7 == -1) {
                z = false;
            }
            dragAndDropDroppableItem.setDropped(z, r8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupDragAndDropItem(DragAndDropDroppableItem dragAndDropDroppableItem, Slot slot, int r4) {
        dragAndDropDroppableItem.setGroup(getGroupFromSlot(slot));
        dragAndDropDroppableItem.setTargetLayoutPosition(getGroupFromSlot(slot));
        setDroppedFromGroup(dragAndDropDroppableItem, getGroupFromSlot(slot), r4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBadgeState(BehaviourPlugin<Behaviour> behaviourPlugin, DragAndDropDroppableItem dragAndDropDroppableItem, int r5) {
        BadgeState badgeState = getBadgeStateMap(r5).get(behaviourPlugin.getType());
        BadgeState badgeState2 = BehaviourPluginKt.getBadgeState(behaviourPlugin);
        if (badgeState != badgeState2 && dragAndDropDroppableItem.isDropped(r5)) {
            if (badgeState2 != BadgeState.Normal) {
                dragAndDropDroppableItem.setBadgeVisualState(BadgeVisualState.AnimateIn);
            } else {
                dragAndDropDroppableItem.setBadgeVisualState(BadgeVisualState.AnimateOut);
            }
            getBadgeStateMap(r5).put(behaviourPlugin.getType(), badgeState2);
        } else if (dragAndDropDroppableItem.isDropped(r5) && badgeState2 != BadgeState.Normal) {
            dragAndDropDroppableItem.setBadgeVisualState(BadgeVisualState.Visible);
        } else {
            getBadgeStateMap(r5).put(behaviourPlugin.getType(), BadgeState.Normal);
            dragAndDropDroppableItem.setBadgeVisualState(BadgeVisualState.Invisible);
        }
        dragAndDropDroppableItem.setBadgeState(badgeState2);
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public boolean belongsToAdapterType(int r4, int r5) {
        if (r5 == 2) {
            if (!this.hasDoubleMainComplication || r4 != this.groupDoubleMainComplication) {
                return true;
            }
            return this.doubleCrownProvider.shouldShowDoubleCrown();
        }
        if (this.hasDoubleMainComplication && r4 == this.groupDoubleMainComplication) {
            if (this.doubleCrownProvider.shouldShowDoubleCrown() && r5 == 0) {
                return true;
            }
            return false;
        }
        WatchFacePosition positionFromGroup = getPositionFromGroup(r4);
        Capabilities capabilities = this.capabilities;
        Intrinsics.checkNotNull(positionFromGroup);
        WatchFace watchFaceAtPosition = capabilities.getWatchFaceAtPosition(positionFromGroup);
        Behaviours behaviours = this.behaviours;
        Intrinsics.checkNotNull(watchFaceAtPosition);
        Slot slotForWatchFace = behaviours.getSlotForWatchFace(watchFaceAtPosition);
        if (r5 != 0) {
            if (r5 == 1 && (slotForWatchFace == Slot.SubComplication1 || slotForWatchFace == Slot.SubComplication2)) {
                return true;
            }
        } else if (slotForWatchFace == Slot.MainComplication || slotForWatchFace == Slot.MainComplicationDouble) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public void clearBadgeState(DragAndDropDroppableItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Map<String, BadgeState> map = this.badgeStatesMain;
        String obj = item.getData().toString();
        BadgeState badgeState = BadgeState.Normal;
        map.put(obj, badgeState);
        if (this.useTabbed) {
            this.badgeStatesSub.put(item.getData().toString(), badgeState);
        }
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public Drawable getBackgroundNotSelectedDrawable(int r5) {
        if (this.firstSlot == Slot.TopPusher) {
            if (r5 != 0) {
                if (r5 != 1) {
                    return null;
                }
                Context context = getContext();
                int r0 = this.groupBottomNotSelectedResourceId;
                Object obj = ContextCompat.sLock;
                Drawable drawable = ContextCompat.Api21Impl.getDrawable(context, r0);
                Intrinsics.checkNotNull(drawable);
                return drawable;
            }
            Context context2 = getContext();
            int r02 = this.groupTopNotSelectedResourceId;
            Object obj2 = ContextCompat.sLock;
            Drawable drawable2 = ContextCompat.Api21Impl.getDrawable(context2, r02);
            Intrinsics.checkNotNull(drawable2);
            return drawable2;
        }
        if (this.hasDoubleMainComplication && r5 == this.groupDoubleMainComplication) {
            Context context3 = getContext();
            int r03 = this.groupDoubleMainComplicationNotSelectedResourceId;
            Object obj3 = ContextCompat.sLock;
            Drawable drawable3 = ContextCompat.Api21Impl.getDrawable(context3, r03);
            Intrinsics.checkNotNull(drawable3);
            return drawable3;
        }
        if (r5 != 0) {
            if (r5 != 1 && r5 != 2) {
                return null;
            }
            Context context4 = getContext();
            int r04 = this.groupSubComplicationNotSelectedResourceId;
            Object obj4 = ContextCompat.sLock;
            Drawable drawable4 = ContextCompat.Api21Impl.getDrawable(context4, r04);
            Intrinsics.checkNotNull(drawable4);
            return drawable4;
        }
        Context context5 = getContext();
        int r05 = this.groupMainComplicationNotSelectedResourceId;
        Object obj5 = ContextCompat.sLock;
        Drawable drawable5 = ContextCompat.Api21Impl.getDrawable(context5, r05);
        Intrinsics.checkNotNull(drawable5);
        return drawable5;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public Drawable getBackgroundSelectedDrawable(int r5) {
        if (this.firstSlot == Slot.TopPusher) {
            if (r5 != 0) {
                if (r5 != 1) {
                    return null;
                }
                Context context = getContext();
                int r0 = this.groupBottomSelectedResourceId;
                Object obj = ContextCompat.sLock;
                Drawable drawable = ContextCompat.Api21Impl.getDrawable(context, r0);
                Intrinsics.checkNotNull(drawable);
                return drawable;
            }
            Context context2 = getContext();
            int r02 = this.groupTopSelectedResourceId;
            Object obj2 = ContextCompat.sLock;
            Drawable drawable2 = ContextCompat.Api21Impl.getDrawable(context2, r02);
            Intrinsics.checkNotNull(drawable2);
            return drawable2;
        }
        if (this.hasDoubleMainComplication && r5 == this.groupDoubleMainComplication) {
            Context context3 = getContext();
            int r03 = this.groupDoubleMainComplicationSelectedResourceId;
            Object obj3 = ContextCompat.sLock;
            Drawable drawable3 = ContextCompat.Api21Impl.getDrawable(context3, r03);
            Intrinsics.checkNotNull(drawable3);
            return drawable3;
        }
        if (r5 != 0) {
            if (r5 != 1 && r5 != 2) {
                return null;
            }
            Context context4 = getContext();
            int r04 = this.groupSubComplicationSelectedResourceId;
            Object obj4 = ContextCompat.sLock;
            Drawable drawable4 = ContextCompat.Api21Impl.getDrawable(context4, r04);
            Intrinsics.checkNotNull(drawable4);
            return drawable4;
        }
        Context context5 = getContext();
        int r05 = this.groupMainComplicationSelectedResourceId;
        Object obj5 = ContextCompat.sLock;
        Drawable drawable5 = ContextCompat.Api21Impl.getDrawable(context5, r05);
        Intrinsics.checkNotNull(drawable5);
        return drawable5;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public List<Integer> getDisabledGroups(DragAndDropDroppableItem dragAndDropDroppableItem, int r8) {
        Slot[] subComplications;
        Intrinsics.checkNotNullParameter(dragAndDropDroppableItem, "dragAndDropDroppableItem");
        if (this.firstSlot == Slot.TopPusher || !this.hasSubComplication) {
            return null;
        }
        List<BehaviourPlugin<Behaviour>> list = this.behaviourPlugins;
        Integer id = dragAndDropDroppableItem.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        BehaviourPlugin<Behaviour> behaviourPlugin = list.get(id.intValue());
        if (r8 == 0) {
            if (this.hasDoubleMainComplication) {
                subComplications = Slot.Companion.getMainComplications();
            } else {
                subComplications = new Slot[]{Slot.MainComplication};
            }
        } else if (this.hasOneSubComplication) {
            subComplications = new Slot[]{Slot.SubComplication1};
        } else {
            subComplications = Slot.Companion.getSubComplications();
        }
        ArrayList arrayList = new ArrayList();
        for (Slot slot : subComplications) {
            if (!isCompatibleWithSlot(behaviourPlugin.getBehaviour(), slot)) {
                arrayList.add(slot);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(getGroupFromSlot((Slot) it.next())));
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return arrayList2;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public Drawable getDraggedItemDrawable() {
        Context context = getContext();
        int r1 = this.draggedItemResourceId;
        Object obj = ContextCompat.sLock;
        Drawable drawable = ContextCompat.Api21Impl.getDrawable(context, r1);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public Drawable getDroppedItemDrawable() {
        Context context = getContext();
        int r1 = this.droppedItemResourceId;
        Object obj = ContextCompat.sLock;
        Drawable drawable = ContextCompat.Api21Impl.getDrawable(context, r1);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public int getEmptyMarbleColorInt() {
        return this.emptyMarbleColorInt;
    }

    public final int getGroupDoubleMainComplication() {
        return this.groupDoubleMainComplication;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public String getGroupText(int r4) {
        if (r4 != 0) {
            if (r4 != 1) {
                if (r4 != 2 || this.firstSlot != Slot.MainComplication || !this.hasTwoSubComplications) {
                    return null;
                }
                return getContext().getString(this.group3ResourceId);
            }
            Slot slot = this.firstSlot;
            Slot slot2 = Slot.MainComplication;
            if (slot == slot2 && this.hasSubComplication) {
                return getContext().getString(this.group2ResourceId);
            }
            if (slot == Slot.TopPusher) {
                return getContext().getString(this.group2ResourceId);
            }
            if (slot != slot2 || !this.hasTwoSubComplications) {
                return null;
            }
            return getContext().getString(this.group3ResourceId);
        }
        return getContext().getString(this.group1ResourceId);
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public int getHeaderTextStyle() {
        return this.headerTextStyle;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public List<Integer> getHiddenGroups(int r6) {
        Slot[] subComplications;
        ArrayList arrayList = new ArrayList();
        if (r6 != 0) {
            if (r6 != 1) {
                return null;
            }
            if (this.hasDoubleMainComplication) {
                subComplications = Slot.Companion.getMainComplications();
            } else {
                subComplications = new Slot[]{Slot.MainComplication};
            }
        } else if (this.hasOneSubComplication) {
            subComplications = new Slot[]{Slot.SubComplication1};
        } else {
            subComplications = Slot.Companion.getSubComplications();
        }
        for (Slot slot : subComplications) {
            arrayList.add(Integer.valueOf(getGroupFromSlot(slot)));
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        return arrayList;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public List<DragAndDropItem> getItems(int r2) {
        if (r2 != 0) {
            if (r2 != 1) {
                if (r2 != 2) {
                    return EmptyList.INSTANCE;
                }
                return this.mutableItems;
            }
            return getItemsTabbed2();
        }
        return getItemsTabbed1();
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public Drawable getPanelDropZoneNotSelectedDrawable() {
        Context context = getContext();
        int r1 = this.gridDropZoneNotSelectedResourceId;
        Object obj = ContextCompat.sLock;
        Drawable drawable = ContextCompat.Api21Impl.getDrawable(context, r1);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public Drawable getPanelDropZoneSelectedDrawable() {
        Context context = getContext();
        int r1 = this.gridDropZoneSelectedResourceId;
        Object obj = ContextCompat.sLock;
        Drawable drawable = ContextCompat.Api21Impl.getDrawable(context, r1);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public List<Integer> getShownGroups(int r6) {
        Slot[] slotArr;
        ArrayList arrayList = new ArrayList();
        if (r6 != 0) {
            if (r6 != 1) {
                return null;
            }
            if (this.hasOneSubComplication) {
                slotArr = new Slot[]{Slot.SubComplication1};
            } else {
                slotArr = Slot.Companion.getSubComplications();
            }
        } else if (this.hasDoubleMainComplication) {
            slotArr = Slot.Companion.getMainComplications();
        } else {
            slotArr = new Slot[]{Slot.MainComplication};
        }
        for (Slot slot : slotArr) {
            arrayList.add(Integer.valueOf(getGroupFromSlot(slot)));
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        return arrayList;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public void initItemData() {
        BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new BehaviourItemDragAndDropProvider$initItemData$1(this, null));
    }

    public final void setGroupDoubleMainComplication(int r1) {
        this.groupDoubleMainComplication = r1;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public boolean shouldDrawEmptyIcon() {
        return true;
    }

    public final void syncUiWithStorage() {
        initData();
        notifyDataChanged();
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public void updateItemData(DragAndDropDroppableItem dragAndDropItem) {
        Intrinsics.checkNotNullParameter(dragAndDropItem, "dragAndDropItem");
        List<BehaviourPlugin<Behaviour>> list = this.behaviourPlugins;
        Integer id = dragAndDropItem.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        Behaviour behaviour = this.watch.getBehaviours().getBehaviour(list.get(id.intValue()).getType());
        if (behaviour == null) {
            behaviour = Empty.INSTANCE;
        }
        notifyItemChanged(behaviour, dragAndDropItem.getGroup(), dragAndDropItem.getCenterX(), dragAndDropItem.getCenterY());
    }

    private final void initIndexes(int r6) {
        int r1 = 0;
        for (DragAndDropItem dragAndDropItem : getItems(r6)) {
            int r2 = r1 + 1;
            if (dragAndDropItem instanceof DragAndDropDroppableItem) {
                ((DragAndDropDroppableItem) dragAndDropItem).setSourceGridViewIndex(r1, r6);
            }
            r1 = r2;
        }
    }
}
