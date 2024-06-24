package com.animaconnected.watch.graphs;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.graphs.XAxisProperties;
import com.animaconnected.watch.graphs.utils.ChartUtilsKt;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.workout.SleepType;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;

/* compiled from: SleepCharts.kt */
/* loaded from: classes3.dex */
public final class SleepChartsKt {
    public static final StateChart createSleepTodayChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<StateEntry> entries, Bedtime bedtime) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(bedtime, "bedtime");
        final StateChart stateChart = new StateChart(kanvas, colors, fonts);
        stateChart.getX().setStyle(getDurationTimeline(stateChart, bedtime));
        stateChart.getX().setStartPosition(new Function0<Float>() { // from class: com.animaconnected.watch.graphs.SleepChartsKt$createSleepTodayChart$1$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float timelineOffset;
                timelineOffset = SleepChartsKt.timelineOffset(StateChart.this);
                return Float.valueOf(timelineOffset);
            }
        });
        stateChart.setNoDataText(StringsExtensionsKt.getAppString(Key.general_no_data_available));
        stateChart.setData(entries);
        stateChart.setUserInteractionEnabled(true);
        return stateChart;
    }

    private static final XAxisProperties.Style.DurationTimeline getDurationTimeline(final StateChart stateChart, Bedtime bedtime) {
        DateFormatter createDateFormatter$default = StringsBackend.createDateFormatter$default(ServiceLocator.INSTANCE.getStringsBackend(), DateTimeFormattersKt.getHourMinuteFormat(), false, 2, null);
        Instant startOfDay$default = DateTimeUtilsKt.getStartOfDay$default(null, null, 3, null);
        int r2 = Duration.$r8$clinit;
        int hour = bedtime.getHour();
        DurationUnit durationUnit = DurationUnit.HOURS;
        Instant m1706plusLRDsOJo = startOfDay$default.m1706plusLRDsOJo(DurationKt.toDuration(hour, durationUnit)).m1706plusLRDsOJo(DurationKt.toDuration(bedtime.getMinute(), DurationUnit.MINUTES));
        Instant m1706plusLRDsOJo2 = m1706plusLRDsOJo.m1706plusLRDsOJo(DurationKt.toDuration(7, durationUnit));
        final String format$default = DateFormatter.format$default(createDateFormatter$default, m1706plusLRDsOJo.toEpochMilliseconds(), null, false, 6, null);
        final String format$default2 = DateFormatter.format$default(createDateFormatter$default, m1706plusLRDsOJo2.toEpochMilliseconds(), null, false, 6, null);
        final Function0<Boolean> function0 = new Function0<Boolean>() { // from class: com.animaconnected.watch.graphs.SleepChartsKt$getDurationTimeline$isDataEmpty$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(StateChart.this.getData().size() <= SleepType.getEntries().size());
            }
        };
        return new XAxisProperties.Style.DurationTimeline(new Function0<String>() { // from class: com.animaconnected.watch.graphs.SleepChartsKt$getDurationTimeline$startTimeLabel$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                ChartEntry chartEntry;
                String str = null;
                if (!function0.invoke().booleanValue() ? (chartEntry = (ChartEntry) CollectionsKt___CollectionsKt.getOrNull(1, stateChart.getData())) != null : (chartEntry = (ChartEntry) CollectionsKt___CollectionsKt.firstOrNull((List) stateChart.getData())) != null) {
                    str = chartEntry.getXAxisLabel();
                }
                return str == null ? format$default : str;
            }
        }, new Function0<String>() { // from class: com.animaconnected.watch.graphs.SleepChartsKt$getDurationTimeline$endTimeLabel$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v12 com.animaconnected.watch.graphs.ChartEntry, still in use, count: 2, list:
                  (r0v12 com.animaconnected.watch.graphs.ChartEntry) from 0x001b: IF  (r0v12 com.animaconnected.watch.graphs.ChartEntry) != (null com.animaconnected.watch.graphs.ChartEntry)  -> B:10:0x0038 A[HIDDEN]
                  (r0v12 com.animaconnected.watch.graphs.ChartEntry) from 0x0038: PHI (r0v8 com.animaconnected.watch.graphs.ChartEntry) = (r0v7 com.animaconnected.watch.graphs.ChartEntry), (r0v12 com.animaconnected.watch.graphs.ChartEntry) binds: [B:12:0x0036, B:4:0x001b] A[DONT_GENERATE, DONT_INLINE]
                	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
                	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
                	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
                	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
                	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:53)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
                	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:40)
                	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:34)
                	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
                */
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.String invoke() {
                /*
                    r3 = this;
                    kotlin.jvm.functions.Function0<java.lang.Boolean> r0 = r1
                    java.lang.Object r0 = r0.invoke()
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    r1 = 0
                    if (r0 == 0) goto L1e
                    com.animaconnected.watch.graphs.StateChart r0 = r2
                    java.util.List r0 = r0.getData()
                    java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r0)
                    com.animaconnected.watch.graphs.ChartEntry r0 = (com.animaconnected.watch.graphs.ChartEntry) r0
                    if (r0 == 0) goto L3c
                    goto L38
                L1e:
                    com.animaconnected.watch.graphs.StateChart r0 = r2
                    java.util.List r0 = r0.getData()
                    com.animaconnected.watch.graphs.StateChart r2 = r2
                    java.util.List r2 = r2.getData()
                    int r2 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r2)
                    int r2 = r2 + (-1)
                    java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r2, r0)
                    com.animaconnected.watch.graphs.ChartEntry r0 = (com.animaconnected.watch.graphs.ChartEntry) r0
                    if (r0 == 0) goto L3c
                L38:
                    java.lang.String r1 = r0.getXAxisLabel()
                L3c:
                    if (r1 != 0) goto L40
                    java.lang.String r1 = r3
                L40:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.graphs.SleepChartsKt$getDurationTimeline$endTimeLabel$1.invoke():java.lang.String");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float timelineOffset(StateChart stateChart) {
        boolean z;
        if (stateChart.getData().size() <= SleepType.getEntries().size()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return 0.0f;
        }
        List<ChartEntry> data = stateChart.getData();
        ArrayList arrayList = new ArrayList();
        for (Object obj : data) {
            if (obj instanceof StateEntry) {
                arrayList.add(obj);
            }
        }
        return ChartUtilsKt.normalizeValueToXPos(stateChart, ((StateEntry) arrayList.get(1)).getTimestamp(), ((StateEntry) CollectionsKt___CollectionsKt.first((List) arrayList)).getTimestamp(), ((StateEntry) CollectionsKt___CollectionsKt.last(arrayList)).getTimestamp());
    }
}
