package com.animaconnected.watch.display;

import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.display.view.BottomPusher;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.display.view.DisplayDefinitionKt;
import com.animaconnected.watch.display.view.Position;
import com.animaconnected.watch.display.view.Rectangle;
import com.animaconnected.watch.display.view.ScrollContainer;
import com.animaconnected.watch.display.view.Text;
import com.animaconnected.watch.strings.KeyString;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemoteAppViews.kt */
/* loaded from: classes3.dex */
public final class RemoteAppViewsKt {

    /* compiled from: RemoteAppViews.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[DisplayType.values().length];
            try {
                r0[DisplayType.Full.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[DisplayType.Sub.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final Display basicView(final RemoteAppImpl remoteAppImpl, KeyString title, Function1<? super BasicView, Unit> init) {
        DisplayType displayType;
        Intrinsics.checkNotNullParameter(remoteAppImpl, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(init, "init");
        final BasicView basicView = new BasicView(title, null, false, null, null, 30, null);
        init.invoke(basicView);
        DisplayWatch displayWatch$watch_release = remoteAppImpl.getDisplayWatch$watch_release();
        if (displayWatch$watch_release == null || (displayType = displayWatch$watch_release.getDisplayType()) == null) {
            displayType = DisplayType.Sub;
        }
        int r10 = WhenMappings.$EnumSwitchMapping$0[displayType.ordinal()];
        if (r10 != 1) {
            if (r10 == 2) {
                return DisplayDefinitionKt.display(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.display.RemoteAppViewsKt$basicView$2$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Display display) {
                        invoke2(display);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final Display display) {
                        Intrinsics.checkNotNullParameter(display, "$this$display");
                        final BasicView basicView2 = BasicView.this;
                        final RemoteAppImpl remoteAppImpl2 = remoteAppImpl;
                        DisplayDefinitionKt.subDisplaySafeArea(display, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.display.RemoteAppViewsKt$basicView$2$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                final KeyString description = BasicView.this.getDescription();
                                DisplayDefinitionKt.text$default(subDisplaySafeArea, BasicView.this.getTitle(), remoteAppImpl2.getPaint().getTitle(), false, null, null, 24, null);
                                if (description != null) {
                                    int width = subDisplaySafeArea.getWidth();
                                    final RemoteAppImpl remoteAppImpl3 = remoteAppImpl2;
                                    DisplayDefinitionKt.scrollContainer$default(subDisplaySafeArea, width, 0, new Function1<ScrollContainer, Unit>() { // from class: com.animaconnected.watch.display.RemoteAppViewsKt.basicView.2.2.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(ScrollContainer scrollContainer) {
                                            invoke2(scrollContainer);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(ScrollContainer scrollContainer) {
                                            Intrinsics.checkNotNullParameter(scrollContainer, "$this$scrollContainer");
                                            scrollContainer.setY(40);
                                            DisplayDefinitionKt.text$default(scrollContainer, KeyString.this, remoteAppImpl3.getPaint().getNormal(), false, null, null, 28, null);
                                        }
                                    }, 2, null);
                                }
                                Function1<Display, Unit> actions = BasicView.this.getActions();
                                if (actions != null) {
                                    actions.invoke(display);
                                }
                            }
                        });
                        if (BasicView.this.getProgressBar()) {
                            DisplayDefinitionKt.progressbar$default(display, 0, 50, 0, 0, null, 29, null);
                        }
                        final BasicView basicView3 = BasicView.this;
                        DisplayDefinitionKt.bottomPusher(display, new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.display.RemoteAppViewsKt$basicView$2$2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                                invoke2(bottomPusher);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(BottomPusher bottomPusher) {
                                Intrinsics.checkNotNullParameter(bottomPusher, "$this$bottomPusher");
                                BasicView.this.getBottomPusher().invoke(bottomPusher);
                            }
                        });
                    }
                });
            }
            throw new NoWhenBranchMatchedException();
        }
        return DisplayDefinitionKt.display(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.display.RemoteAppViewsKt$basicView$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                final BasicView basicView2 = BasicView.this;
                final RemoteAppImpl remoteAppImpl2 = remoteAppImpl;
                DisplayDefinitionKt.topContainer(display, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.display.RemoteAppViewsKt$basicView$2$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Rectangle rectangle) {
                        invoke2(rectangle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Rectangle topContainer) {
                        Intrinsics.checkNotNullParameter(topContainer, "$this$topContainer");
                        DisplayDefinitionKt.text$default(topContainer, BasicView.this.getTitle(), remoteAppImpl2.getPaint().getTitle(), true, null, new Function1<Text, Unit>() { // from class: com.animaconnected.watch.display.RemoteAppViewsKt.basicView.2.1.1.1
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
                        }, 8, null);
                    }
                });
                final BasicView basicView3 = BasicView.this;
                final RemoteAppImpl remoteAppImpl3 = remoteAppImpl;
                DisplayDefinitionKt.bottomContainer$default(display, 0, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.display.RemoteAppViewsKt$basicView$2$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Rectangle rectangle) {
                        invoke2(rectangle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Rectangle bottomContainer) {
                        Intrinsics.checkNotNullParameter(bottomContainer, "$this$bottomContainer");
                        if (BasicView.this.getProgressBar()) {
                            DisplayDefinitionKt.progressbar$default(bottomContainer, 0, 0, bottomContainer.getWidth(), 0, null, 27, null);
                        }
                        final KeyString description = BasicView.this.getDescription();
                        if (description != null) {
                            int width = bottomContainer.getWidth();
                            final RemoteAppImpl remoteAppImpl4 = remoteAppImpl3;
                            DisplayDefinitionKt.scrollContainer$default(bottomContainer, width, 0, new Function1<ScrollContainer, Unit>() { // from class: com.animaconnected.watch.display.RemoteAppViewsKt.basicView.2.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ScrollContainer scrollContainer) {
                                    invoke2(scrollContainer);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ScrollContainer scrollContainer) {
                                    Intrinsics.checkNotNullParameter(scrollContainer, "$this$scrollContainer");
                                    DisplayDefinitionKt.text$default(scrollContainer, KeyString.this, remoteAppImpl4.getPaint().getNormal(), false, null, null, 28, null);
                                }
                            }, 2, null);
                        }
                    }
                }, 1, null);
                Function1<Display, Unit> actions = BasicView.this.getActions();
                if (actions != null) {
                    actions.invoke(display);
                }
                final BasicView basicView4 = BasicView.this;
                DisplayDefinitionKt.bottomPusher(display, new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.display.RemoteAppViewsKt$basicView$2$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                        invoke2(bottomPusher);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BottomPusher bottomPusher) {
                        Intrinsics.checkNotNullParameter(bottomPusher, "$this$bottomPusher");
                        BasicView.this.getBottomPusher().invoke(bottomPusher);
                    }
                });
            }
        });
    }

    public static final Rectangle displayTypeView(Display display, RemoteAppImpl remoteAppImpl, Function1<? super Display, ? extends Rectangle> sub, Function1<? super Display, ? extends Rectangle> full) {
        DisplayType displayType;
        Intrinsics.checkNotNullParameter(display, "<this>");
        Intrinsics.checkNotNullParameter(remoteAppImpl, "remoteAppImpl");
        Intrinsics.checkNotNullParameter(sub, "sub");
        Intrinsics.checkNotNullParameter(full, "full");
        DisplayWatch displayWatch$watch_release = remoteAppImpl.getDisplayWatch$watch_release();
        if (displayWatch$watch_release == null || (displayType = displayWatch$watch_release.getDisplayType()) == null) {
            displayType = DisplayType.Sub;
        }
        int r2 = WhenMappings.$EnumSwitchMapping$0[displayType.ordinal()];
        if (r2 != 1) {
            if (r2 == 2) {
                return sub.invoke(display);
            }
            throw new NoWhenBranchMatchedException();
        }
        return full.invoke(display);
    }
}
