package com.animaconnected.watch.display;

import com.animaconnected.watch.display.view.BottomPusher;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.display.view.DisplayDefinitionKt;
import com.animaconnected.watch.display.view.Image;
import com.animaconnected.watch.display.view.Position;
import com.animaconnected.watch.display.view.Rectangle;
import com.animaconnected.watch.display.view.Text;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Kolor;
import com.animaconnected.watch.image.Kolors;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.Static;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugRemoteApps.kt */
/* loaded from: classes3.dex */
public final class TestDrawCommandsWatchApp extends RemoteAppImpl {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "TestDrawCmd";
    private final String type = TYPE;
    private final Static title = StringsExtensionsKt.m1571static(TYPE);
    private final String analyticsName = getType();
    private final Mitmap icon = GraphicsKt.emptyMitmap();
    private Mitmap mitmap = GraphicsKt.emptyMitmap();
    private final AppId id = AppId.DebugDrawCommands;

    /* compiled from: DebugRemoteApps.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.display.RemoteApp
    public List<Display> getDisplays() {
        return CollectionsKt__CollectionsKt.listOf(DisplayDefinitionKt.display(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.display.TestDrawCommandsWatchApp$getDisplays$1
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
                DisplayDefinitionKt.text$default(display, StringsExtensionsKt.m1571static("display"), TestDrawCommandsWatchApp.this.getPaint().getDefault(), false, null, new Function1<Text, Unit>() { // from class: com.animaconnected.watch.display.TestDrawCommandsWatchApp$getDisplays$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                        invoke2(text);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Text text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setPosition(Position.Top);
                    }
                }, 12, null);
                final TestDrawCommandsWatchApp testDrawCommandsWatchApp = TestDrawCommandsWatchApp.this;
                DisplayDefinitionKt.subDisplayArea(display, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.display.TestDrawCommandsWatchApp$getDisplays$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Rectangle rectangle) {
                        invoke2(rectangle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Rectangle subDisplayArea) {
                        Intrinsics.checkNotNullParameter(subDisplayArea, "$this$subDisplayArea");
                        subDisplayArea.m1114setColor1L9c4HM(Kolor.m1536boximpl(Kolor.m1537constructorimpl(Kolors.red)));
                        subDisplayArea.setFill(false);
                        DisplayDefinitionKt.text$default(subDisplayArea, StringsExtensionsKt.m1571static("sub"), TestDrawCommandsWatchApp.this.getPaint().getDefault(), false, null, null, 28, null);
                    }
                });
                final TestDrawCommandsWatchApp testDrawCommandsWatchApp2 = TestDrawCommandsWatchApp.this;
                DisplayDefinitionKt.subDisplaySafeArea(display, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.display.TestDrawCommandsWatchApp$getDisplays$1.3

                    /* compiled from: DebugRemoteApps.kt */
                    /* renamed from: com.animaconnected.watch.display.TestDrawCommandsWatchApp$getDisplays$1$3$EntriesMappings */
                    /* loaded from: classes3.dex */
                    public /* synthetic */ class EntriesMappings {
                        public static final /* synthetic */ EnumEntries<Position> entries$0 = EnumEntriesKt.enumEntries(Position.values());
                    }

                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Rectangle rectangle) {
                        invoke2(rectangle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Rectangle subDisplaySafeArea) {
                        Intrinsics.checkNotNullParameter(subDisplaySafeArea, "$this$subDisplaySafeArea");
                        subDisplaySafeArea.m1114setColor1L9c4HM(Kolor.m1536boximpl(Kolor.m1537constructorimpl(Kolors.green)));
                        subDisplaySafeArea.setFill(false);
                        DisplayDefinitionKt.text$default(subDisplaySafeArea, StringsExtensionsKt.m1571static("safe"), TestDrawCommandsWatchApp.this.getPaint().getDefault(), false, null, null, 28, null);
                        EnumEntries<Position> enumEntries = EntriesMappings.entries$0;
                        TestDrawCommandsWatchApp testDrawCommandsWatchApp3 = TestDrawCommandsWatchApp.this;
                        for (final Position position : enumEntries) {
                            DisplayDefinitionKt.image$default(subDisplaySafeArea, 0, 0, testDrawCommandsWatchApp3.getMitmap(), testDrawCommandsWatchApp3.getType() + position.ordinal(), new Function1<Image, Unit>() { // from class: com.animaconnected.watch.display.TestDrawCommandsWatchApp$getDisplays$1$3$1$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Image image) {
                                    invoke2(image);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Image image) {
                                    Intrinsics.checkNotNullParameter(image, "$this$image");
                                    image.setPosition(Position.this);
                                }
                            }, 3, (Object) null);
                        }
                    }
                });
                DisplayDefinitionKt.bottomPusher(display, new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.display.TestDrawCommandsWatchApp$getDisplays$1.4
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

    public final void setMitmap(Mitmap mitmap) {
        Intrinsics.checkNotNullParameter(mitmap, "<set-?>");
        this.mitmap = mitmap;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Static getTitle() {
        return this.title;
    }
}
