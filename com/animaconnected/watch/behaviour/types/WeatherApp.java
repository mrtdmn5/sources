package com.animaconnected.watch.behaviour.types;

import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.device.WatchAppAnimation;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.RemoteAppImpl;
import com.animaconnected.watch.display.RemoteAppViewsKt;
import com.animaconnected.watch.display.view.BottomPusher;
import com.animaconnected.watch.display.view.Button;
import com.animaconnected.watch.display.view.Container;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.display.view.DisplayDefinitionKt;
import com.animaconnected.watch.display.view.Image;
import com.animaconnected.watch.display.view.Rectangle;
import com.animaconnected.watch.display.view.ScrollContainer;
import com.animaconnected.watch.display.view.Text;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.provider.weather.DailyForecast;
import com.animaconnected.watch.provider.weather.HourlyForecast;
import com.animaconnected.watch.provider.weather.WeatherForecastWatch;
import com.animaconnected.watch.provider.weather.WeatherViewModel;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.KeyString;
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

/* compiled from: WeatherApp.kt */
/* loaded from: classes3.dex */
public final class WeatherApp extends RemoteAppImpl {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "WeatherDisplay";
    private final String analyticsName;
    private final Mitmap icon;
    private final AppId id;
    private final Lazy mitmapBackend$delegate;
    private final String type;
    private final WeatherViewModel viewModel;

    /* compiled from: WeatherApp.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public WeatherApp(Function0<? extends FitnessProvider.Profile.Temperature> temperatureUnit) {
        Intrinsics.checkNotNullParameter(temperatureUnit, "temperatureUnit");
        this.mitmapBackend$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MitmapBackend>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$mitmapBackend$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MitmapBackend invoke() {
                return ServiceLocator.INSTANCE.getMitmapBackend();
            }
        });
        this.viewModel = new WeatherViewModel(temperatureUnit);
        this.id = AppId.Weather;
        this.icon = MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Weather_App_Icon, null, 2, null);
        this.type = TYPE;
        this.analyticsName = "WeatherRemoteApp";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateTempX(int r1, int r2, int r3, int r4) {
        return ((((r1 - r2) - r3) - r4) / 2) + r2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void currentDayForecast(Rectangle rectangle, final String str, final String str2, final String str3, final String str4, final int r15, int r16, final CanvasPaint canvasPaint) {
        DisplayDefinitionKt.scrollContainer(rectangle, rectangle.getWidth(), r16, new Function1<ScrollContainer, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$currentDayForecast$1
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
                scrollContainer.setY(r15);
                final int width = scrollContainer.getWidth() / 2;
                final int height = scrollContainer.getHeight() / 2;
                DisplayDefinitionKt.text(scrollContainer, StringsExtensionsKt.m1571static("🔼 " + str), canvasPaint, false, "maxTemp", new Function1<Text, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$currentDayForecast$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                        invoke2(text);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Text text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setWidth(width);
                        text.setHeight(height);
                    }
                });
                DisplayDefinitionKt.text(scrollContainer, StringsExtensionsKt.m1571static("🌧 " + str3), canvasPaint, false, "rain", new Function1<Text, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$currentDayForecast$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                        invoke2(text);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Text text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setWidth(width);
                        text.setHeight(height);
                        text.setX(width);
                    }
                });
                DisplayDefinitionKt.text(scrollContainer, StringsExtensionsKt.m1571static("🔽 " + str2), canvasPaint, false, "minTemp", new Function1<Text, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$currentDayForecast$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                        invoke2(text);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Text text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setWidth(width);
                        text.setHeight(height);
                        text.setY(height);
                    }
                });
                DisplayDefinitionKt.text(scrollContainer, StringsExtensionsKt.m1571static(StringsExtensionsKt.getFirmwareString(Key.weather_uv) + ' ' + str4), canvasPaint, false, "uv", new Function1<Text, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$currentDayForecast$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                        invoke2(text);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Text text) {
                        Intrinsics.checkNotNullParameter(text, "$this$text");
                        text.setWidth(width);
                        text.setHeight(height);
                        text.setX(width);
                        text.setY(height);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void currentDayTitleForecast(Rectangle rectangle, String str, final Mitmap mitmap, final int r12, CanvasPaint canvasPaint) {
        DisplayDefinitionKt.text(rectangle, StringsExtensionsKt.m1571static(str), canvasPaint, false, "0:temp", new Function1<Text, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$currentDayTitleForecast$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                invoke2(text);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Text text) {
                Intrinsics.checkNotNullParameter(text, "$this$text");
                text.setHeight(r12);
            }
        });
        if (Intrinsics.areEqual(mitmap, GraphicsKt.emptyMitmap())) {
            DisplayDefinitionKt.text$default(rectangle, StringsExtensionsKt.m1571static("-"), canvasPaint, false, null, new Function1<Text, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$currentDayTitleForecast$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                    invoke2(text);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Text text) {
                    Intrinsics.checkNotNullParameter(text, "$this$text");
                    text.setHeight(r12);
                    text.setX(((text.getWidth() / 2) - (mitmap.getWidth() / 2)) + text.getX());
                }
            }, 12, null);
        } else {
            DisplayDefinitionKt.image$default(rectangle, ((rectangle.getWidth() / 2) + rectangle.getX()) - (mitmap.getWidth() / 2), 0, mitmap, "0:icon", (Function1) null, 18, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fullHeader(Rectangle rectangle, String str, Mitmap mitmap, CanvasPaint canvasPaint) {
        final int width = rectangle.getWidth() / 2;
        final int r7 = 100;
        DisplayDefinitionKt.text(rectangle, StringsExtensionsKt.m1571static(str), canvasPaint, false, "0:temp", new Function1<Text, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$fullHeader$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                invoke2(text);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Text text) {
                Intrinsics.checkNotNullParameter(text, "$this$text");
                text.setX(width - 40);
                text.setY(r7);
            }
        });
        if (Intrinsics.areEqual(mitmap, GraphicsKt.emptyMitmap())) {
            DisplayDefinitionKt.text$default(rectangle, StringsExtensionsKt.m1571static("-"), canvasPaint, false, null, new Function1<Text, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$fullHeader$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                    invoke2(text);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Text text) {
                    Intrinsics.checkNotNullParameter(text, "$this$text");
                    text.setX(width + 20);
                    text.setY(r7);
                }
            }, 12, null);
        } else {
            DisplayDefinitionKt.image$default(rectangle, width + 70, 100, mitmap, "0:icon", (Function1) null, 16, (Object) null);
        }
    }

    private final MitmapBackend getMitmapBackend() {
        return (MitmapBackend) this.mitmapBackend$delegate.getValue();
    }

    private final int maxElementHeight(CanvasPaint canvasPaint, String str, boolean z, String str2) {
        int r3;
        int measureHeight;
        int measureHeight2 = (int) canvasPaint.measureHeight(str);
        if (z) {
            r3 = 40;
        } else {
            r3 = 24;
        }
        if (str2 == null) {
            measureHeight = 0;
        } else {
            measureHeight = (int) canvasPaint.measureHeight(str2);
        }
        return Math.max(measureHeight2, Math.max(r3, measureHeight));
    }

    public static /* synthetic */ int maxElementHeight$default(WeatherApp weatherApp, CanvasPaint canvasPaint, String str, boolean z, String str2, int r5, Object obj) {
        if ((r5 & 4) != 0) {
            str2 = null;
        }
        return weatherApp.maxElementHeight(canvasPaint, str, z, str2);
    }

    private final List<Display> weatherDisplay(final WeatherForecastWatch weatherForecastWatch, final CanvasPaint canvasPaint, final CanvasPaint canvasPaint2) {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Display[]{DisplayDefinitionKt.display(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$1
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
                final WeatherApp weatherApp = WeatherApp.this;
                final CanvasPaint canvasPaint3 = canvasPaint;
                final WeatherForecastWatch weatherForecastWatch2 = weatherForecastWatch;
                final CanvasPaint canvasPaint4 = canvasPaint2;
                Function1<Display, Rectangle> function1 = new Function1<Display, Rectangle>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Rectangle invoke(Display displayTypeView) {
                        Intrinsics.checkNotNullParameter(displayTypeView, "$this$displayTypeView");
                        final WeatherApp weatherApp2 = WeatherApp.this;
                        final CanvasPaint canvasPaint5 = canvasPaint3;
                        final WeatherForecastWatch weatherForecastWatch3 = weatherForecastWatch2;
                        final CanvasPaint canvasPaint6 = canvasPaint4;
                        return DisplayDefinitionKt.subDisplaySafeArea(displayTypeView, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp.weatherDisplay.1.1.1
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
                                int height = (subDisplaySafeArea.getHeight() - subDisplaySafeArea.getY()) - 65;
                                int maxElementHeight$default = WeatherApp.maxElementHeight$default(WeatherApp.this, canvasPaint5, weatherForecastWatch3.getCurrent().getTemp(), true, null, 4, null);
                                WeatherApp.this.currentDayTitleForecast(subDisplaySafeArea, weatherForecastWatch3.getCurrent().getTemp(), weatherForecastWatch3.getCurrent().getIcon(), maxElementHeight$default, canvasPaint5);
                                WeatherApp.this.currentDayForecast(subDisplaySafeArea, weatherForecastWatch3.getToday().getMaxTemp(), weatherForecastWatch3.getToday().getMinTemp(), weatherForecastWatch3.getToday().getRain(), weatherForecastWatch3.getToday().getUv(), maxElementHeight$default + 12, height, canvasPaint6);
                            }
                        });
                    }
                };
                final WeatherApp weatherApp2 = WeatherApp.this;
                final WeatherForecastWatch weatherForecastWatch3 = weatherForecastWatch;
                final CanvasPaint canvasPaint5 = canvasPaint;
                final CanvasPaint canvasPaint6 = canvasPaint2;
                RemoteAppViewsKt.displayTypeView(display, weatherApp, function1, new Function1<Display, Rectangle>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Rectangle invoke(Display displayTypeView) {
                        Intrinsics.checkNotNullParameter(displayTypeView, "$this$displayTypeView");
                        final WeatherApp weatherApp3 = WeatherApp.this;
                        final WeatherForecastWatch weatherForecastWatch4 = weatherForecastWatch3;
                        final CanvasPaint canvasPaint7 = canvasPaint5;
                        DisplayDefinitionKt.topContainer(displayTypeView, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp.weatherDisplay.1.2.1
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
                                WeatherApp.this.fullHeader(topContainer, weatherForecastWatch4.getCurrent().getTemp(), weatherForecastWatch4.getCurrent().getIcon(), canvasPaint7);
                            }
                        });
                        final WeatherApp weatherApp4 = WeatherApp.this;
                        final WeatherForecastWatch weatherForecastWatch5 = weatherForecastWatch3;
                        final CanvasPaint canvasPaint8 = canvasPaint6;
                        return DisplayDefinitionKt.bottomContainer(displayTypeView, 70, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp.weatherDisplay.1.2.2
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
                                WeatherApp.this.currentDayForecast(bottomContainer, weatherForecastWatch5.getToday().getMaxTemp(), weatherForecastWatch5.getToday().getMinTemp(), weatherForecastWatch5.getToday().getRain(), weatherForecastWatch5.getToday().getUv(), 40, bottomContainer.getHeight(), canvasPaint8);
                            }
                        });
                    }
                });
                DisplayDefinitionKt.button(display, StringsExtensionsKt.getKeyString(Key.weather_hourly_forecast), new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                        invoke2(button);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Button button) {
                        Intrinsics.checkNotNullParameter(button, "$this$button");
                        button.setNavCommand(1);
                        button.setAnimation(Integer.valueOf(WatchAppAnimation.ScrollLeft.getId()));
                    }
                });
                DisplayDefinitionKt.button(display, StringsExtensionsKt.getKeyString(Key.weather_7_days_forecast), new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                        invoke2(button);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Button button) {
                        Intrinsics.checkNotNullParameter(button, "$this$button");
                        button.setNavCommand(2);
                        button.setAnimation(Integer.valueOf(WatchAppAnimation.ScrollLeft.getId()));
                    }
                });
                DisplayDefinitionKt.bottomPusher(display, new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$1.5
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
        }), DisplayDefinitionKt.display(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$2
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
                final WeatherApp weatherApp = WeatherApp.this;
                final CanvasPaint canvasPaint3 = canvasPaint2;
                final WeatherForecastWatch weatherForecastWatch2 = weatherForecastWatch;
                final int r4 = 10;
                Function1<Display, Rectangle> function1 = new Function1<Display, Rectangle>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Rectangle invoke(Display displayTypeView) {
                        Intrinsics.checkNotNullParameter(displayTypeView, "$this$displayTypeView");
                        final WeatherApp weatherApp2 = WeatherApp.this;
                        final CanvasPaint canvasPaint4 = canvasPaint3;
                        final WeatherForecastWatch weatherForecastWatch3 = weatherForecastWatch2;
                        final int r42 = r4;
                        return DisplayDefinitionKt.subDisplaySafeArea(displayTypeView, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp.weatherDisplay.2.1.1
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
                                final int calculateTempX;
                                Intrinsics.checkNotNullParameter(subDisplaySafeArea, "$this$subDisplaySafeArea");
                                calculateTempX = WeatherApp.this.calculateTempX(subDisplaySafeArea.getWidth(), (int) canvasPaint4.measureWidth("00:00"), 24, (int) canvasPaint4.measureWidth("00°"));
                                int width = subDisplaySafeArea.getWidth();
                                final WeatherForecastWatch weatherForecastWatch4 = weatherForecastWatch3;
                                final WeatherApp weatherApp3 = WeatherApp.this;
                                final int r8 = r42;
                                final CanvasPaint canvasPaint5 = canvasPaint4;
                                DisplayDefinitionKt.scrollContainer$default(subDisplaySafeArea, width, 0, new Function1<ScrollContainer, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp.weatherDisplay.2.1.1.1
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
                                        List<HourlyForecast> hourly = WeatherForecastWatch.this.getHourly();
                                        WeatherApp weatherApp4 = weatherApp3;
                                        int r13 = r8;
                                        CanvasPaint canvasPaint6 = canvasPaint5;
                                        int r15 = calculateTempX;
                                        int r2 = 0;
                                        for (Object obj : hourly) {
                                            int r16 = r2 + 1;
                                            if (r2 >= 0) {
                                                HourlyForecast hourlyForecast = (HourlyForecast) obj;
                                                weatherApp4.weatherRow(scrollContainer, r13 + r2, (r2 * 37) + 8, canvasPaint6, hourlyForecast.getTime(), hourlyForecast.getTemp(), r15, hourlyForecast.getIcon());
                                                r2 = r16;
                                            } else {
                                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                throw null;
                                            }
                                        }
                                    }
                                }, 2, null);
                            }
                        });
                    }
                };
                final WeatherApp weatherApp2 = WeatherApp.this;
                final WeatherForecastWatch weatherForecastWatch3 = weatherForecastWatch;
                final CanvasPaint canvasPaint4 = canvasPaint;
                final CanvasPaint canvasPaint5 = canvasPaint2;
                final int r10 = 10;
                RemoteAppViewsKt.displayTypeView(display, weatherApp, function1, new Function1<Display, Rectangle>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Rectangle invoke(Display displayTypeView) {
                        Intrinsics.checkNotNullParameter(displayTypeView, "$this$displayTypeView");
                        final WeatherApp weatherApp3 = WeatherApp.this;
                        final WeatherForecastWatch weatherForecastWatch4 = weatherForecastWatch3;
                        final CanvasPaint canvasPaint6 = canvasPaint4;
                        DisplayDefinitionKt.topContainer(displayTypeView, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp.weatherDisplay.2.2.1
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
                                WeatherApp.this.fullHeader(topContainer, weatherForecastWatch4.getCurrent().getTemp(), weatherForecastWatch4.getCurrent().getIcon(), canvasPaint6);
                            }
                        });
                        final WeatherApp weatherApp4 = WeatherApp.this;
                        final CanvasPaint canvasPaint7 = canvasPaint5;
                        final WeatherForecastWatch weatherForecastWatch5 = weatherForecastWatch3;
                        final int r42 = r10;
                        return DisplayDefinitionKt.bottomContainer(displayTypeView, 70, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp.weatherDisplay.2.2.2
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
                                final int calculateTempX;
                                Intrinsics.checkNotNullParameter(bottomContainer, "$this$bottomContainer");
                                calculateTempX = WeatherApp.this.calculateTempX(bottomContainer.getWidth(), (int) canvasPaint7.measureWidth("00:00"), 24, (int) canvasPaint7.measureWidth("00°"));
                                int width = bottomContainer.getWidth();
                                final WeatherForecastWatch weatherForecastWatch6 = weatherForecastWatch5;
                                final WeatherApp weatherApp5 = WeatherApp.this;
                                final int r8 = r42;
                                final CanvasPaint canvasPaint8 = canvasPaint7;
                                DisplayDefinitionKt.scrollContainer$default(bottomContainer, width, 0, new Function1<ScrollContainer, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp.weatherDisplay.2.2.2.1
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
                                        List<HourlyForecast> hourly = WeatherForecastWatch.this.getHourly();
                                        WeatherApp weatherApp6 = weatherApp5;
                                        int r13 = r8;
                                        CanvasPaint canvasPaint9 = canvasPaint8;
                                        int r15 = calculateTempX;
                                        int r2 = 0;
                                        for (Object obj : hourly) {
                                            int r16 = r2 + 1;
                                            if (r2 >= 0) {
                                                HourlyForecast hourlyForecast = (HourlyForecast) obj;
                                                weatherApp6.weatherRow(scrollContainer, r13 + r2, (r2 * 37) + 40, canvasPaint9, hourlyForecast.getTime(), hourlyForecast.getTemp(), r15, hourlyForecast.getIcon());
                                                r2 = r16;
                                            } else {
                                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                throw null;
                                            }
                                        }
                                    }
                                }, 2, null);
                            }
                        });
                    }
                });
                DisplayDefinitionKt.button(display, StringsExtensionsKt.getKeyString(Key.general_back), new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$2.3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                        invoke2(button);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Button button) {
                        Intrinsics.checkNotNullParameter(button, "$this$button");
                        button.setNavCommand(0);
                    }
                });
                DisplayDefinitionKt.bottomPusher(display, new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$2.4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                        invoke2(bottomPusher);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BottomPusher bottomPusher) {
                        Intrinsics.checkNotNullParameter(bottomPusher, "$this$bottomPusher");
                        bottomPusher.setNavCommand(0);
                    }
                });
            }
        }), DisplayDefinitionKt.display(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$3
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
                final WeatherApp weatherApp = WeatherApp.this;
                final CanvasPaint canvasPaint3 = canvasPaint2;
                final WeatherForecastWatch weatherForecastWatch2 = weatherForecastWatch;
                final int r4 = 20;
                Function1<Display, Rectangle> function1 = new Function1<Display, Rectangle>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$3.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Rectangle invoke(Display displayTypeView) {
                        Intrinsics.checkNotNullParameter(displayTypeView, "$this$displayTypeView");
                        final WeatherApp weatherApp2 = WeatherApp.this;
                        final CanvasPaint canvasPaint4 = canvasPaint3;
                        final int r3 = r4;
                        final WeatherForecastWatch weatherForecastWatch3 = weatherForecastWatch2;
                        return DisplayDefinitionKt.subDisplaySafeArea(displayTypeView, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp.weatherDisplay.3.1.1
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
                                final int calculateTempX;
                                Intrinsics.checkNotNullParameter(subDisplaySafeArea, "$this$subDisplaySafeArea");
                                calculateTempX = WeatherApp.this.calculateTempX(subDisplaySafeArea.getWidth(), (int) canvasPaint4.measureWidth("00:00"), 24, (int) canvasPaint4.measureWidth("00°"));
                                int width = subDisplaySafeArea.getWidth();
                                final WeatherApp weatherApp3 = WeatherApp.this;
                                final int r7 = r3;
                                final CanvasPaint canvasPaint5 = canvasPaint4;
                                final WeatherForecastWatch weatherForecastWatch4 = weatherForecastWatch3;
                                DisplayDefinitionKt.scrollContainer$default(subDisplaySafeArea, width, 0, new Function1<ScrollContainer, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp.weatherDisplay.3.1.1.1
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
                                        WeatherApp.this.weatherRow(scrollContainer, r7, 8, canvasPaint5, weatherForecastWatch4.getToday().getWeekDay(), weatherForecastWatch4.getToday().getMaxTemp(), calculateTempX, weatherForecastWatch4.getToday().getIconSmall());
                                        List<DailyForecast> daily = weatherForecastWatch4.getDaily();
                                        WeatherApp weatherApp4 = WeatherApp.this;
                                        int r13 = r7;
                                        CanvasPaint canvasPaint6 = canvasPaint5;
                                        int r15 = calculateTempX;
                                        int r2 = 0;
                                        for (Object obj : daily) {
                                            int r16 = r2 + 1;
                                            if (r2 >= 0) {
                                                DailyForecast dailyForecast = (DailyForecast) obj;
                                                weatherApp4.weatherRow(scrollContainer, r13 + r16, (r16 * 37) + 8, canvasPaint6, dailyForecast.getDate(), dailyForecast.getTemp(), r15, dailyForecast.getIcon());
                                                r2 = r16;
                                            } else {
                                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                throw null;
                                            }
                                        }
                                    }
                                }, 2, null);
                            }
                        });
                    }
                };
                final WeatherApp weatherApp2 = WeatherApp.this;
                final WeatherForecastWatch weatherForecastWatch3 = weatherForecastWatch;
                final CanvasPaint canvasPaint4 = canvasPaint;
                final CanvasPaint canvasPaint5 = canvasPaint2;
                final int r10 = 20;
                RemoteAppViewsKt.displayTypeView(display, weatherApp, function1, new Function1<Display, Rectangle>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$3.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Rectangle invoke(Display displayTypeView) {
                        Intrinsics.checkNotNullParameter(displayTypeView, "$this$displayTypeView");
                        final WeatherApp weatherApp3 = WeatherApp.this;
                        final WeatherForecastWatch weatherForecastWatch4 = weatherForecastWatch3;
                        final CanvasPaint canvasPaint6 = canvasPaint4;
                        DisplayDefinitionKt.topContainer(displayTypeView, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp.weatherDisplay.3.2.1
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
                                WeatherApp.this.fullHeader(topContainer, weatherForecastWatch4.getCurrent().getTemp(), weatherForecastWatch4.getCurrent().getIcon(), canvasPaint6);
                            }
                        });
                        final WeatherApp weatherApp4 = WeatherApp.this;
                        final CanvasPaint canvasPaint7 = canvasPaint5;
                        final int r3 = r10;
                        final WeatherForecastWatch weatherForecastWatch5 = weatherForecastWatch3;
                        return DisplayDefinitionKt.bottomContainer(displayTypeView, 70, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp.weatherDisplay.3.2.2
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
                                final int calculateTempX;
                                Intrinsics.checkNotNullParameter(bottomContainer, "$this$bottomContainer");
                                calculateTempX = WeatherApp.this.calculateTempX(bottomContainer.getWidth(), (int) canvasPaint7.measureWidth("00:00"), 24, (int) canvasPaint7.measureWidth("00°"));
                                int width = bottomContainer.getWidth();
                                final WeatherApp weatherApp5 = WeatherApp.this;
                                final int r7 = r3;
                                final CanvasPaint canvasPaint8 = canvasPaint7;
                                final WeatherForecastWatch weatherForecastWatch6 = weatherForecastWatch5;
                                DisplayDefinitionKt.scrollContainer$default(bottomContainer, width, 0, new Function1<ScrollContainer, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp.weatherDisplay.3.2.2.1
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
                                        WeatherApp.this.weatherRow(scrollContainer, r7, 40, canvasPaint8, weatherForecastWatch6.getToday().getWeekDay(), weatherForecastWatch6.getToday().getMaxTemp(), calculateTempX, weatherForecastWatch6.getToday().getIconSmall());
                                        List<DailyForecast> daily = weatherForecastWatch6.getDaily();
                                        WeatherApp weatherApp6 = WeatherApp.this;
                                        int r13 = r7;
                                        CanvasPaint canvasPaint9 = canvasPaint8;
                                        int r15 = calculateTempX;
                                        int r2 = 0;
                                        for (Object obj : daily) {
                                            int r16 = r2 + 1;
                                            if (r2 >= 0) {
                                                DailyForecast dailyForecast = (DailyForecast) obj;
                                                weatherApp6.weatherRow(scrollContainer, r13 + r16, (r16 * 37) + 40, canvasPaint9, dailyForecast.getDate(), dailyForecast.getTemp(), r15, dailyForecast.getIcon());
                                                r2 = r16;
                                            } else {
                                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                throw null;
                                            }
                                        }
                                    }
                                }, 2, null);
                            }
                        });
                    }
                });
                DisplayDefinitionKt.button(display, StringsExtensionsKt.getKeyString(Key.general_back), new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$3.3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                        invoke2(button);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Button button) {
                        Intrinsics.checkNotNullParameter(button, "$this$button");
                        button.setNavCommand(0);
                    }
                });
                DisplayDefinitionKt.bottomPusher(display, new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherDisplay$3.4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                        invoke2(bottomPusher);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BottomPusher bottomPusher) {
                        Intrinsics.checkNotNullParameter(bottomPusher, "$this$bottomPusher");
                        bottomPusher.setNavCommand(0);
                    }
                });
            }
        })});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void weatherRow(final Container container, int r11, final int r12, CanvasPaint canvasPaint, String str, String str2, final int r16, Mitmap mitmap) {
        DisplayDefinitionKt.text(container, StringsExtensionsKt.m1571static(str), canvasPaint, false, r11 + ":time", new Function1<Text, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherRow$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                invoke2(text);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Text text) {
                Intrinsics.checkNotNullParameter(text, "$this$text");
                text.setX(0);
                text.setY(r12);
            }
        });
        DisplayDefinitionKt.text(container, StringsExtensionsKt.m1571static(str2), canvasPaint, false, r11 + ":temp", new Function1<Text, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherRow$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                invoke2(text);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Text text) {
                Intrinsics.checkNotNullParameter(text, "$this$text");
                text.setX(r16);
                text.setY(r12);
            }
        });
        if (Intrinsics.areEqual(mitmap, GraphicsKt.emptyMitmap())) {
            DisplayDefinitionKt.text$default(container, StringsExtensionsKt.m1571static("-"), canvasPaint, false, null, new Function1<Text, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherRow$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                    invoke2(text);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Text text) {
                    Intrinsics.checkNotNullParameter(text, "$this$text");
                    text.setX(Container.this.getWidth() - 24);
                    text.setY(r12);
                }
            }, 12, null);
            return;
        }
        DisplayDefinitionKt.image$default(container, 0, 0, mitmap, r11 + ":icon", new Function1<Image, Unit>() { // from class: com.animaconnected.watch.behaviour.types.WeatherApp$weatherRow$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                image.setX(Container.this.getWidth() - 24);
                image.setY(r12);
            }
        }, 3, (Object) null);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.display.RemoteApp
    public List<Display> getDisplays() {
        return weatherDisplay(this.viewModel.getWatchData(), getPaint().getTitle(), getPaint().getDefault());
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
        return StringsExtensionsKt.getKeyString(Key.weather_app_title);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }
}
