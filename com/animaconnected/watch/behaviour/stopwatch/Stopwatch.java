package com.animaconnected.watch.behaviour.stopwatch;

import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.behaviour.Complication;
import com.animaconnected.watch.device.Scale;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.FirmwareApp;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.KeyString;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Stopwatch.kt */
/* loaded from: classes3.dex */
public final class Stopwatch implements Complication, FirmwareApp {
    private static final String BEHAVIOUR_ANALYTICS_NAME = "stopwatch";
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "Stopwatch";
    private final String analyticsName;
    private final Function0<Boolean> checkIsSelectable;
    private Function0<Boolean> checkPermissions;
    private final int deviceComplicationMode;
    private final Mitmap icon;
    private final AppId id;
    private final String type;

    /* compiled from: Stopwatch.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Stopwatch(Function0<Boolean> checkIsSelectable) {
        Intrinsics.checkNotNullParameter(checkIsSelectable, "checkIsSelectable");
        this.checkIsSelectable = checkIsSelectable;
        this.icon = MitmapBackend.getMitmap$default(ServiceLocator.INSTANCE.getMitmapBackend(), WatchAsset.Stopwatch_App_Icon, null, 2, null);
        this.analyticsName = "stopwatch";
        this.checkPermissions = new Function0<Boolean>() { // from class: com.animaconnected.watch.behaviour.stopwatch.Stopwatch$checkPermissions$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        };
        this.id = AppId.Stopwatch;
        this.type = TYPE;
        this.deviceComplicationMode = 23;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void activate(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public List<Scale> compatibleScales() {
        return CollectionsKt__CollectionsKt.listOf(Scale.Unknown);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return new Slot[]{Slot.MainComplication, Slot.MainComplicationDouble, Slot.Display};
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void deactivated(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Function0<Boolean> getCheckPermissions() {
        return this.checkPermissions;
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public int getDeviceComplicationMode() {
        return this.deviceComplicationMode;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Mitmap getIcon() {
        return this.icon;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public AppId getId() {
        return this.id;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public KeyString getTitle() {
        return StringsExtensionsKt.getKeyString(Key.behaviour_name_stopwatch);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public boolean isSelectable(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        return this.checkIsSelectable.invoke().booleanValue();
    }

    public void setCheckPermissions(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.checkPermissions = function0;
    }
}
