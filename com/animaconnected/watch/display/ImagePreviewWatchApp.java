package com.animaconnected.watch.display;

import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.display.view.BottomPusher;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.display.view.DisplayDefinitionKt;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.Static;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugRemoteApps.kt */
/* loaded from: classes3.dex */
public final class ImagePreviewWatchApp extends RemoteAppImpl {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "ImgPrev";
    private final Lazy mitmapBackend$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MitmapBackend>() { // from class: com.animaconnected.watch.display.ImagePreviewWatchApp$mitmapBackend$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MitmapBackend invoke() {
            return ServiceLocator.INSTANCE.getMitmapBackend();
        }
    });
    private final String type = TYPE;
    private final Static title = StringsExtensionsKt.m1571static(TYPE);
    private final String analyticsName = getType();
    private final Mitmap icon = MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Settings_App_Icon, null, 2, null);
    private final AppId id = AppId.DebugImages;
    private Mitmap mitmap = getIcon();
    private int x = 100;
    private int y = 100;

    /* compiled from: DebugRemoteApps.kt */
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

    @Override // com.animaconnected.watch.display.RemoteApp
    public List<Display> getDisplays() {
        return CollectionsKt__CollectionsKt.listOf(DisplayDefinitionKt.display(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.display.ImagePreviewWatchApp$getDisplays$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Display display) {
                invoke2(display);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Display display) {
                Intrinsics.checkNotNullParameter(display, "$this$display");
                DisplayDefinitionKt.image$default(display, ImagePreviewWatchApp.this.getX(), ImagePreviewWatchApp.this.getY(), ImagePreviewWatchApp.this.getMitmap(), ImagePreviewWatchApp.this.getType(), (Function1) null, 16, (Object) null);
                DisplayDefinitionKt.bottomPusher(display, new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.display.ImagePreviewWatchApp$getDisplays$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                        invoke2(bottomPusher);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BottomPusher bottomPusher) {
                        Intrinsics.checkNotNullParameter(bottomPusher, "$this$bottomPusher");
                        bottomPusher.setNavCommand(-1);
                    }
                });
            }
        }));
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Mitmap getIcon() {
        return this.icon;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public AppId getId() {
        return this.id;
    }

    public final Mitmap getMitmap() {
        return this.mitmap;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public final void setMitmap(Mitmap mitmap) {
        Intrinsics.checkNotNullParameter(mitmap, "<set-?>");
        this.mitmap = mitmap;
    }

    public final void setX(int r1) {
        this.x = r1;
    }

    public final void setY(int r1) {
        this.y = r1;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Static getTitle() {
        return this.title;
    }
}
