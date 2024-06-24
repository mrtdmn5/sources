package com.animaconnected.watch.display;

import com.animaconnected.watch.display.view.BottomPusher;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.display.view.DisplayDefinitionKt;
import com.animaconnected.watch.display.view.Rectangle;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Kolor;
import com.animaconnected.watch.image.Kolors;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.Static;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugRemoteApps.kt */
/* loaded from: classes3.dex */
public final class FullScreenTest extends RemoteAppImpl {
    private final String analyticsName;
    private final Mitmap icon;
    private final AppId id;
    private final Mitmap mitmap;
    private final VisibilityState onStartState;
    private final Static title;
    private final String type;

    public FullScreenTest(Mitmap mitmap) {
        Intrinsics.checkNotNullParameter(mitmap, "mitmap");
        this.mitmap = mitmap;
        this.type = "FullScreenTest";
        this.title = StringsExtensionsKt.m1571static(getType());
        this.analyticsName = getType();
        this.icon = GraphicsKt.emptyMitmap();
        this.onStartState = VisibilityState.Persistent;
        this.id = AppId.DebugFullScreen;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.display.RemoteApp
    public List<Display> getDisplays() {
        return CollectionsKt__CollectionsKt.listOf(DisplayDefinitionKt.display(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.display.FullScreenTest$getDisplays$1
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
                final FullScreenTest fullScreenTest = FullScreenTest.this;
                DisplayDefinitionKt.fullDisplayArea(display, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.display.FullScreenTest$getDisplays$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Rectangle rectangle) {
                        invoke2(rectangle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Rectangle fullDisplayArea) {
                        Mitmap mitmap;
                        Intrinsics.checkNotNullParameter(fullDisplayArea, "$this$fullDisplayArea");
                        fullDisplayArea.m1114setColor1L9c4HM(Kolor.m1536boximpl(Kolor.m1537constructorimpl(Kolors.red)));
                        fullDisplayArea.setFill(false);
                        mitmap = FullScreenTest.this.mitmap;
                        DisplayDefinitionKt.image$default(fullDisplayArea, 0, 0, mitmap, (String) null, (Function1) null, 24, (Object) null);
                        final FullScreenTest fullScreenTest2 = FullScreenTest.this;
                        DisplayDefinitionKt.rectangle(fullDisplayArea, 100, 200, 100, 80, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.display.FullScreenTest.getDisplays.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Rectangle rectangle) {
                                invoke2(rectangle);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Rectangle rectangle) {
                                Intrinsics.checkNotNullParameter(rectangle, "$this$rectangle");
                                DisplayDefinitionKt.text$default(rectangle, StringsExtensionsKt.m1571static("22:22"), FullScreenTest.this.getPaint().getDefault(), false, null, null, 28, null);
                            }
                        });
                    }
                });
                DisplayDefinitionKt.bottomPusher(display, new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.display.FullScreenTest$getDisplays$1.2
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

    @Override // com.animaconnected.watch.display.RemoteAppImpl, com.animaconnected.watch.display.RemoteApp
    public VisibilityState getOnStartState() {
        return this.onStartState;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Static getTitle() {
        return this.title;
    }
}
