package com.animaconnected.secondo.widget.compose;

import android.content.Context;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.workout.utils.ChartMitmapsKt;
import com.animaconnected.secondo.widget.chart.ChartView;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.KanvasView;
import com.animaconnected.watch.display.Scrapbook;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.FitnessIndexChartsKt;
import com.animaconnected.watch.graphs.HorizontalProgressBar;
import com.animaconnected.watch.graphs.LineChartsKt;
import com.animaconnected.watch.graphs.PointEntry;
import com.animaconnected.watch.graphs.SegmentedProgressBar;
import com.google.common.base.Strings;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Charts.kt */
/* loaded from: classes3.dex */
public final class ChartsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChartComposable(Modifier modifier, final List<PointEntry> list, final Function1<? super Kanvas, ? extends Chart> function1, Composer composer, final int r11, final int r12) {
        Modifier fillMaxWidth;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-112749771);
        if ((r12 & 1) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        fillMaxWidth = SizeKt.fillMaxWidth(modifier, 1.0f);
        startRestartGroup.startReplaceableGroup(-1763102952);
        boolean z = (((r11 & 896) ^ 384) > 256 && startRestartGroup.changedInstance(function1)) || (r11 & 384) == 256;
        Object nextSlot = startRestartGroup.nextSlot();
        if (z || nextSlot == Composer.Companion.Empty) {
            nextSlot = new Function1<Context, ChartView>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$ChartComposable$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ChartView invoke(Context context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    ChartView chartView = new ChartView(context, null, 0, 6, null);
                    chartView.setChart(function1.invoke(chartView.getKanvas()));
                    return chartView;
                }
            };
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        AndroidView_androidKt.AndroidView((Function1) nextSlot, fillMaxWidth, new Function1<ChartView, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$ChartComposable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChartView chartView) {
                invoke2(chartView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChartView chartView) {
                Intrinsics.checkNotNullParameter(chartView, "chartView");
                Chart chart = chartView.getChart();
                if (chart != null) {
                    chart.setData(list);
                }
            }
        }, startRestartGroup, 0, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$ChartComposable$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r8) {
                    ChartsKt.ChartComposable(Modifier.this, list, function1, composer2, Strings.updateChangedFlags(r11 | 1), r12);
                }
            };
        }
    }

    public static final void ElevationDetailChart(Modifier modifier, final List<PointEntry> entries, final FitnessProvider.Profile.Measurement measurement, final String duration, Composer composer, final int r13, final int r14) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        Intrinsics.checkNotNullParameter(duration, "duration");
        ComposerImpl startRestartGroup = composer.startRestartGroup(988620388);
        if ((r14 & 1) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ChartComposable(modifier, entries, new Function1<Kanvas, Chart>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$ElevationDetailChart$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Chart invoke(Kanvas kanvas) {
                Intrinsics.checkNotNullParameter(kanvas, "kanvas");
                ProviderFactory providerFactory = ProviderFactory.INSTANCE;
                return LineChartsKt.createElevationDetailChart(kanvas, providerFactory.getThemeProvider().getChartColors(), providerFactory.getThemeProvider().getChartFonts(), entries, measurement, duration);
            }
        }, startRestartGroup, (r13 & 14) | 64, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$ElevationDetailChart$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r9) {
                    ChartsKt.ElevationDetailChart(Modifier.this, entries, measurement, duration, composer2, Strings.updateChangedFlags(r13 | 1), r14);
                }
            };
        }
    }

    public static final void FitnessIndexChart(Modifier modifier, final FitnessProvider.Profile profile, final Integer num, Composer composer, final int r18, final int r19) {
        final Modifier modifier2;
        BarEntry barEntry;
        Intrinsics.checkNotNullParameter(profile, "profile");
        ComposerImpl startRestartGroup = composer.startRestartGroup(1630297273);
        if ((r19 & 1) != 0) {
            modifier2 = Modifier.Companion.$$INSTANCE;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (num != null) {
            barEntry = new BarEntry(num.intValue(), (String) null, 0L, (String) null, (String) null, false, 62, (DefaultConstructorMarker) null);
        } else {
            barEntry = null;
        }
        ChartComposable(modifier2, barEntry, null, new Function1<Kanvas, Chart>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$FitnessIndexChart$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Chart invoke(Kanvas kanvas) {
                Intrinsics.checkNotNullParameter(kanvas, "kanvas");
                ProviderFactory providerFactory = ProviderFactory.INSTANCE;
                return FitnessIndexChartsKt.createFitnessIndexChart(kanvas, providerFactory.getThemeProvider().getChartColors(), providerFactory.getThemeProvider().getChartFonts(), FitnessProvider.Profile.this);
            }
        }, startRestartGroup, (r18 & 14) | 64, 4);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$FitnessIndexChart$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num2) {
                    invoke(composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r8) {
                    ChartsKt.FitnessIndexChart(Modifier.this, profile, num, composer2, Strings.updateChangedFlags(r18 | 1), r19);
                }
            };
        }
    }

    public static final void HeartRateDetailChart(Modifier modifier, final List<PointEntry> entries, final int r9, Composer composer, final int r11, final int r12) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        ComposerImpl startRestartGroup = composer.startRestartGroup(1505427395);
        if ((r12 & 1) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ChartComposable(modifier, entries, new Function1<Kanvas, Chart>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$HeartRateDetailChart$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Chart invoke(Kanvas kanvas) {
                Intrinsics.checkNotNullParameter(kanvas, "kanvas");
                ProviderFactory providerFactory = ProviderFactory.INSTANCE;
                return LineChartsKt.createHeartRateChart(kanvas, providerFactory.getThemeProvider().getChartColors(), providerFactory.getThemeProvider().getChartFonts(), entries, r9);
            }
        }, startRestartGroup, (r11 & 14) | 64, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$HeartRateDetailChart$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r8) {
                    ChartsKt.HeartRateDetailChart(Modifier.this, entries, r9, composer2, Strings.updateChangedFlags(r11 | 1), r12);
                }
            };
        }
    }

    public static final void HeartRateHistoryChart(Modifier modifier, final List<PointEntry> entries, final String duration, final int r11, Composer composer, final int r13, final int r14) {
        boolean z;
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(duration, "duration");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-2093669965);
        if ((r14 & 1) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(1581573644);
        boolean z2 = true;
        if ((((r13 & 896) ^ 384) > 256 && startRestartGroup.changed(duration)) || (r13 & 384) == 256) {
            z = true;
        } else {
            z = false;
        }
        if ((((r13 & 7168) ^ 3072) <= 2048 || !startRestartGroup.changed(r11)) && (r13 & 3072) != 2048) {
            z2 = false;
        }
        boolean z3 = z | z2;
        Object nextSlot = startRestartGroup.nextSlot();
        if (z3 || nextSlot == Composer.Companion.Empty) {
            nextSlot = new Function1<Kanvas, Chart>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$HeartRateHistoryChart$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Chart invoke(Kanvas kanvas) {
                    Intrinsics.checkNotNullParameter(kanvas, "kanvas");
                    ProviderFactory providerFactory = ProviderFactory.INSTANCE;
                    return LineChartsKt.createHeartRateDetailChart(kanvas, providerFactory.getThemeProvider().getChartColors(), providerFactory.getThemeProvider().getChartFonts(), EmptyList.INSTANCE, duration, r11);
                }
            };
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        ChartComposable(modifier, entries, (Function1) nextSlot, startRestartGroup, (r13 & 14) | 64, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$HeartRateHistoryChart$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r9) {
                    ChartsKt.HeartRateHistoryChart(Modifier.this, entries, duration, r11, composer2, Strings.updateChangedFlags(r13 | 1), r14);
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void HorizontalGoalChart(final kotlin.jvm.functions.Function0<com.animaconnected.watch.graphs.BarEntry> r21, final int r22, final boolean r23, final com.animaconnected.watch.graphs.BarChartSize r24, androidx.compose.ui.Modifier r25, com.animaconnected.watch.image.Mitmap r26, boolean r27, com.animaconnected.watch.theme.ChartColors r28, com.animaconnected.watch.theme.ChartFonts r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.widget.compose.ChartsKt.HorizontalGoalChart(kotlin.jvm.functions.Function0, int, boolean, com.animaconnected.watch.graphs.BarChartSize, androidx.compose.ui.Modifier, com.animaconnected.watch.image.Mitmap, boolean, com.animaconnected.watch.theme.ChartColors, com.animaconnected.watch.theme.ChartFonts, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void RestingHeartRateDetailChart(final Modifier modifier, final List<PointEntry> entries, Composer composer, final int r10, final int r11) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-203770382);
        if ((r11 & 1) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ChartComposable(modifier, entries, new Function1<Kanvas, Chart>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$RestingHeartRateDetailChart$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Chart invoke(Kanvas kanvas) {
                Intrinsics.checkNotNullParameter(kanvas, "kanvas");
                ProviderFactory providerFactory = ProviderFactory.INSTANCE;
                return LineChartsKt.createRestingHeartRateDetailChart(kanvas, providerFactory.getThemeProvider().getChartColors(), providerFactory.getThemeProvider().getChartFonts(), entries);
            }
        }, startRestartGroup, (r10 & 14) | 64, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$RestingHeartRateDetailChart$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r5) {
                    ChartsKt.RestingHeartRateDetailChart(Modifier.this, entries, composer2, Strings.updateChangedFlags(r10 | 1), r11);
                }
            };
        }
    }

    public static final void RestingHeartRateHistoryChart(final Modifier modifier, final List<PointEntry> entries, Composer composer, final int r10, final int r11) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        ComposerImpl startRestartGroup = composer.startRestartGroup(1860161179);
        if ((r11 & 1) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ChartComposable(modifier, entries, new Function1<Kanvas, Chart>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$RestingHeartRateHistoryChart$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Chart invoke(Kanvas kanvas) {
                Intrinsics.checkNotNullParameter(kanvas, "kanvas");
                ProviderFactory providerFactory = ProviderFactory.INSTANCE;
                return LineChartsKt.createRestingHeartRateHistoryChart(kanvas, providerFactory.getThemeProvider().getChartColors(), providerFactory.getThemeProvider().getChartFonts(), entries);
            }
        }, startRestartGroup, (r10 & 14) | 64, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$RestingHeartRateHistoryChart$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r5) {
                    ChartsKt.RestingHeartRateHistoryChart(Modifier.this, entries, composer2, Strings.updateChangedFlags(r10 | 1), r11);
                }
            };
        }
    }

    public static final void Scrapbook(final Modifier modifier, Composer composer, final int r9, final int r10) {
        int r2;
        int r22;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-287582477);
        int r0 = r10 & 1;
        if (r0 != 0) {
            r2 = r9 | 6;
        } else if ((r9 & 14) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r22 = 4;
            } else {
                r22 = 2;
            }
            r2 = r22 | r9;
        } else {
            r2 = r9;
        }
        if ((r2 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (r0 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            AndroidView_androidKt.AndroidView(new Function1<Context, KanvasView>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$Scrapbook$1
                @Override // kotlin.jvm.functions.Function1
                public final KanvasView invoke(Context context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    KanvasView kanvasView = new KanvasView(context, null, 0, 6, null);
                    Scrapbook scrapbook = new Scrapbook(kanvasView.getKanvas(), ProviderFactory.INSTANCE.getThemeProvider().getChartFonts());
                    scrapbook.setMitmap(ChartMitmapsKt.getNinePatchProgressHighlighted());
                    scrapbook.drawStuff();
                    kanvasView.setScrapbook(scrapbook);
                    return kanvasView;
                }
            }, modifier, new Function1<KanvasView, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$Scrapbook$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KanvasView kanvasView) {
                    invoke2(kanvasView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KanvasView it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Scrapbook scrapbook = it.getScrapbook();
                    if (scrapbook != null) {
                        scrapbook.drawStuff();
                    }
                }
            }, startRestartGroup, ((r2 << 3) & 112) | 390, 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$Scrapbook$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r4) {
                    ChartsKt.Scrapbook(Modifier.this, composer2, Strings.updateChangedFlags(r9 | 1), r10);
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void SegmentedGoalChart(final kotlin.jvm.functions.Function0<com.animaconnected.watch.graphs.BarEntry> r22, final int r23, final boolean r24, final com.animaconnected.watch.graphs.BarChartSize r25, androidx.compose.ui.Modifier r26, com.animaconnected.watch.image.Mitmap r27, boolean r28, boolean r29, com.animaconnected.watch.theme.ChartColors r30, com.animaconnected.watch.theme.ChartFonts r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.widget.compose.ChartsKt.SegmentedGoalChart(kotlin.jvm.functions.Function0, int, boolean, com.animaconnected.watch.graphs.BarChartSize, androidx.compose.ui.Modifier, com.animaconnected.watch.image.Mitmap, boolean, boolean, com.animaconnected.watch.theme.ChartColors, com.animaconnected.watch.theme.ChartFonts, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChartComposable(Modifier modifier, final BarEntry barEntry, final Integer num, final Function1<? super Kanvas, ? extends Chart> function1, Composer composer, final int r13, final int r14) {
        Modifier fillMaxWidth;
        ComposerImpl startRestartGroup = composer.startRestartGroup(307710809);
        if ((r14 & 1) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        if ((r14 & 4) != 0) {
            num = null;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        fillMaxWidth = SizeKt.fillMaxWidth(modifier, 1.0f);
        startRestartGroup.startReplaceableGroup(-1763102498);
        boolean z = (((r13 & 7168) ^ 3072) > 2048 && startRestartGroup.changedInstance(function1)) || (r13 & 3072) == 2048;
        Object nextSlot = startRestartGroup.nextSlot();
        if (z || nextSlot == Composer.Companion.Empty) {
            nextSlot = new Function1<Context, ChartView>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$ChartComposable$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ChartView invoke(Context context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    ChartView chartView = new ChartView(context, null, 0, 6, null);
                    chartView.setChart(function1.invoke(chartView.getKanvas()));
                    return chartView;
                }
            };
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        AndroidView_androidKt.AndroidView((Function1) nextSlot, fillMaxWidth, new Function1<ChartView, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$ChartComposable$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChartView chartView) {
                invoke2(chartView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChartView chartView) {
                Intrinsics.checkNotNullParameter(chartView, "chartView");
                Chart chart = chartView.getChart();
                if (chart != null) {
                    BarEntry barEntry2 = BarEntry.this;
                    Integer num2 = num;
                    if (barEntry2 != null) {
                        chart.setData(CollectionsKt__CollectionsKt.listOf(barEntry2));
                    }
                    if (num2 != null) {
                        SegmentedProgressBar segmentedProgressBar = chart instanceof SegmentedProgressBar ? (SegmentedProgressBar) chart : null;
                        if (segmentedProgressBar != null) {
                            segmentedProgressBar.setGoalValue(num2.intValue());
                        }
                        HorizontalProgressBar horizontalProgressBar = chart instanceof HorizontalProgressBar ? (HorizontalProgressBar) chart : null;
                        if (horizontalProgressBar == null) {
                            return;
                        }
                        horizontalProgressBar.setGoalValue(num2.intValue());
                    }
                }
            }
        }, startRestartGroup, 0, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            final Integer num2 = num;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.widget.compose.ChartsKt$ChartComposable$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num3) {
                    invoke(composer2, num3.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r9) {
                    ChartsKt.ChartComposable(Modifier.this, barEntry, num2, function1, composer2, Strings.updateChangedFlags(r13 | 1), r14);
                }
            };
        }
    }
}
