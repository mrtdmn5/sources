package com.animaconnected.watch.graphs;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.workout.FitnessIndexCategory;
import com.animaconnected.watch.workout.FitnessIndexKt;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FitnessIndexCharts.kt */
/* loaded from: classes3.dex */
public final class FitnessIndexChartsKt {
    public static final FitnessIndexChart createFitnessIndexChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, FitnessProvider.Profile profile) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(profile, "profile");
        EnumEntries<FitnessIndexCategory> entries = FitnessIndexCategory.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(entries, 10));
        Iterator<E> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(FitnessIndexKt.getRange((FitnessIndexCategory) it.next(), profile, DateTimeUtilsKt.now()));
        }
        return new FitnessIndexChart(kanvas, colors, fonts, arrayList);
    }
}
