package com.animaconnected.watch.display;

import com.animaconnected.watch.display.view.BottomPusher;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.display.view.DisplayDefinitionKt;
import com.animaconnected.watch.display.view.Line;
import com.animaconnected.watch.display.view.ListView;
import com.animaconnected.watch.display.view.Orientation;
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
public final class Dashboard extends RemoteAppImpl {
    private final String type = "TestDashboard";
    private final String analyticsName = getType();
    private final Static title = StringsExtensionsKt.m1571static(getType());
    private final Mitmap icon = GraphicsKt.emptyMitmap();
    private final AppId id = AppId.Dashboard;

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.display.RemoteApp
    public List<Display> getDisplays() {
        return CollectionsKt__CollectionsKt.listOf(DisplayDefinitionKt.display(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.display.Dashboard$getDisplays$1
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
                final Dashboard dashboard = Dashboard.this;
                DisplayDefinitionKt.subDisplaySafeArea(display, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.display.Dashboard$getDisplays$1.1
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
                        int width = subDisplaySafeArea.getWidth();
                        int height = subDisplaySafeArea.getHeight();
                        final Dashboard dashboard2 = Dashboard.this;
                        DisplayDefinitionKt.listView$default(subDisplaySafeArea, 0, 0, width, height, new Function1<ListView, Unit>() { // from class: com.animaconnected.watch.display.Dashboard.getDisplays.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ListView listView) {
                                invoke2(listView);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ListView listView) {
                                Intrinsics.checkNotNullParameter(listView, "$this$listView");
                                DisplayDefinitionKt.variable$default(listView, VarType.Time, null, 2, null);
                                DisplayDefinitionKt.space$default(listView, 0, 2, null, 5, null);
                                DisplayDefinitionKt.line(listView, Integer.MIN_VALUE, Integer.MIN_VALUE, listView.getWidth(), 0, new Function1<Line, Unit>() { // from class: com.animaconnected.watch.display.Dashboard.getDisplays.1.1.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Line line) {
                                        invoke2(line);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Line line) {
                                        Intrinsics.checkNotNullParameter(line, "$this$line");
                                        line.m1112setColorukcjflE(Kolor.m1537constructorimpl(Kolors.red));
                                    }
                                });
                                DisplayDefinitionKt.space$default(listView, 0, 6, null, 5, null);
                                DisplayDefinitionKt.variable$default(listView, VarType.Timezone1, null, 2, null);
                                int width2 = listView.getWidth();
                                final Dashboard dashboard3 = Dashboard.this;
                                DisplayDefinitionKt.listView$default(listView, 0, 0, width2, 15, new Function1<ListView, Unit>() { // from class: com.animaconnected.watch.display.Dashboard.getDisplays.1.1.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(ListView listView2) {
                                        invoke2(listView2);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(ListView listView2) {
                                        Intrinsics.checkNotNullParameter(listView2, "$this$listView");
                                        listView2.setOrientation(Orientation.Horizontal);
                                        DisplayDefinitionKt.text$default(listView2, StringsExtensionsKt.m1571static("Steps:"), Dashboard.this.getPaint().getDefault(), false, null, null, 28, null);
                                        DisplayDefinitionKt.variable$default(listView2, VarType.ActivityStepsToday, null, 2, null);
                                    }
                                }, 3, null);
                            }
                        }, 3, null);
                    }
                });
                DisplayDefinitionKt.bottomPusher(display, new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.display.Dashboard$getDisplays$1.2
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

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Static getTitle() {
        return this.title;
    }
}
