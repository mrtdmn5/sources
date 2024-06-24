package com.animaconnected.watch.behaviour.types;

import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.FirmwareApp;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.Static;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallsWatchApp.kt */
/* loaded from: classes3.dex */
public class CallsWatchApp implements FirmwareApp {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "CallsDisplay";
    private final Lazy mitmapBackend$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MitmapBackend>() { // from class: com.animaconnected.watch.behaviour.types.CallsWatchApp$mitmapBackend$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MitmapBackend invoke() {
            return ServiceLocator.INSTANCE.getMitmapBackend();
        }
    });
    private Function0<Boolean> checkPermissions = new Function0<Boolean>() { // from class: com.animaconnected.watch.behaviour.types.CallsWatchApp$checkPermissions$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    };
    private final AppId id = AppId.Calls;
    private final String type = "CallsDisplay";
    private final String analyticsName = "CallsDisplay";
    private final Static title = StringsExtensionsKt.m1571static("Calls");
    private final Mitmap icon = MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Calls_Accept_Icon, null, 2, null);
    private final boolean isHidden = true;

    /* compiled from: CallsWatchApp.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final MitmapBackend getMitmapBackend() {
        return (MitmapBackend) this.mitmapBackend$delegate.getValue();
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Function0<Boolean> getCheckPermissions() {
        return this.checkPermissions;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Mitmap getIcon() {
        return this.icon;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public AppId getId() {
        return this.id;
    }

    @Override // com.animaconnected.watch.display.FirmwareApp
    public Map<String, Mitmap> getImages() {
        return MapsKt__MapsKt.mapOf(new Pair("accept", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Calls_Accept_Icon, null, 2, null)), new Pair("decline", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Calls_Decline_Icon, null, 2, null)), new Pair("incoming", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Calls_Incoming_Icon, null, 2, null)));
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public boolean isHidden() {
        return this.isHidden;
    }

    public void setCheckPermissions(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.checkPermissions = function0;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Static getTitle() {
        return this.title;
    }
}
