package com.animaconnected.watch.behaviour.types;

import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.FirmwareApp;
import com.animaconnected.watch.display.QuickActionType;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.KeyString;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MusicWatchApp.kt */
/* loaded from: classes3.dex */
public class MusicWatchApp implements FirmwareApp {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "MusicDisplay";
    private final String analyticsName;
    private Function0<Boolean> checkPermissions;
    private final Mitmap icon;
    private final AppId id;
    private final Lazy mitmapBackend$delegate;
    private final QuickActionType quickActionType;
    private final String type;

    /* compiled from: MusicWatchApp.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public MusicWatchApp() {
        this(null, 1, 0 == true ? 1 : 0);
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
        return MapsKt__MapsKt.mapOf(new Pair("play", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Music_Play_Icon, null, 2, null)), new Pair("pause", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Music_Pause_Icon, null, 2, null)), new Pair("next", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Music_Next_Icon, null, 2, null)), new Pair("prev", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Music_Prev_Icon, null, 2, null)), new Pair("vol", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Music_Vol_Icon, null, 2, null)));
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public QuickActionType getQuickActionType() {
        return this.quickActionType;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public KeyString getTitle() {
        return StringsExtensionsKt.getKeyString(Key.behaviour_name_music);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    public void setCheckPermissions(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.checkPermissions = function0;
    }

    public MusicWatchApp(QuickActionType quickActionType) {
        Intrinsics.checkNotNullParameter(quickActionType, "quickActionType");
        this.quickActionType = quickActionType;
        this.id = AppId.Music;
        this.type = "MusicDisplay";
        this.analyticsName = "MusicDisplay";
        this.checkPermissions = new Function0<Boolean>() { // from class: com.animaconnected.watch.behaviour.types.MusicWatchApp$checkPermissions$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        };
        this.mitmapBackend$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MitmapBackend>() { // from class: com.animaconnected.watch.behaviour.types.MusicWatchApp$mitmapBackend$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MitmapBackend invoke() {
                return ServiceLocator.INSTANCE.getMitmapBackend();
            }
        });
        this.icon = MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Music_App_Icon, null, 2, null);
    }

    public /* synthetic */ MusicWatchApp(QuickActionType quickActionType, int r2, DefaultConstructorMarker defaultConstructorMarker) {
        this((r2 & 1) != 0 ? QuickActionType.Button : quickActionType);
    }
}
