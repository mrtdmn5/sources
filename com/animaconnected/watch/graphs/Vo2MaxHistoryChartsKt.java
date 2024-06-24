package com.animaconnected.watch.graphs;

import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.graphs.XAxisProperties;
import com.animaconnected.watch.graphs.YAxisProperties;
import com.animaconnected.watch.graphs.utils.YAxisScaleFormatter;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.workout.FitnessIndexCategory;
import com.animaconnected.watch.workout.FitnessIndexKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: Vo2MaxHistoryCharts.kt */
/* loaded from: classes3.dex */
public final class Vo2MaxHistoryChartsKt {
    public static final Vo2MaxHistoryChart createVo2MaxHistoryChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<PointEntry> entries, FitnessProvider.Profile profile) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Vo2MaxHistoryChart vo2MaxHistoryChart = new Vo2MaxHistoryChart(kanvas, colors, fonts);
        Instant.Companion.getClass();
        Instant instant = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
        vo2MaxHistoryChart.getX().setStyle(XAxisProperties.Style.LabelsStartEndSelected.INSTANCE);
        vo2MaxHistoryChart.getX().setDrawCircles(true);
        YAxisProperties y = vo2MaxHistoryChart.getY();
        EnumEntries<FitnessIndexCategory> entries2 = FitnessIndexCategory.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(entries2, 10));
        for (FitnessIndexCategory fitnessIndexCategory : entries2) {
            arrayList.add(new Pair(FitnessIndexKt.getName(fitnessIndexCategory), FitnessIndexKt.getRange(fitnessIndexCategory, profile, instant)));
        }
        y.setStyle(new YAxisProperties.Style.DualAxes(arrayList, false, false, 6, null));
        YAxisProperties y2 = vo2MaxHistoryChart.getY();
        FitnessIndexCategory.Companion companion = FitnessIndexCategory.Companion;
        y2.setDataMaxValue(companion.max(profile, instant));
        vo2MaxHistoryChart.getY().setDataMinValue(companion.min(profile, instant));
        vo2MaxHistoryChart.getY().setLineToLabelRatio(YAxisProperties.LineToLabelRatio.One);
        vo2MaxHistoryChart.getY().getScaleFormatter().setScaleType(YAxisScaleFormatter.ScaleType.CUSTOM_RANGES);
        YAxisScaleFormatter scaleFormatter = vo2MaxHistoryChart.getY().getScaleFormatter();
        EnumEntries<FitnessIndexCategory> entries3 = FitnessIndexCategory.getEntries();
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(entries3, 10));
        Iterator<E> it = entries3.iterator();
        while (it.hasNext()) {
            arrayList2.add(FitnessIndexKt.getRange((FitnessIndexCategory) it.next(), profile, instant));
        }
        scaleFormatter.setCustomRanges(arrayList2);
        vo2MaxHistoryChart.setData(entries);
        vo2MaxHistoryChart.setUserInteractionEnabled(true);
        return vo2MaxHistoryChart;
    }

    public static final void showMonth(Vo2MaxHistoryChart vo2MaxHistoryChart) {
        Intrinsics.checkNotNullParameter(vo2MaxHistoryChart, "<this>");
        vo2MaxHistoryChart.getX().setStyle(XAxisProperties.Style.LabelsStartEndSelected.INSTANCE);
    }

    public static final void showYear(Vo2MaxHistoryChart vo2MaxHistoryChart) {
        Intrinsics.checkNotNullParameter(vo2MaxHistoryChart, "<this>");
        vo2MaxHistoryChart.getX().setStyle(XAxisProperties.Style.Labels.INSTANCE);
    }
}
