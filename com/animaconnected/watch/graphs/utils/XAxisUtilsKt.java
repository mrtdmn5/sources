package com.animaconnected.watch.graphs.utils;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.ChartEntry;
import com.animaconnected.watch.graphs.XAxisProperties;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.LocalDateTime;

/* compiled from: XAxisUtils.kt */
/* loaded from: classes3.dex */
public final class XAxisUtilsKt {
    public static final float adjustPositionOfText(float f, float f2, float f3, float f4) {
        float f5 = f - (0.5f * f2);
        if (f5 < f3) {
            return 0.0f;
        }
        float f6 = f4 - f2;
        if (f5 > f6) {
            return f6;
        }
        return f5;
    }

    private static final int getIndexForCurrentTime(LocalDateTime localDateTime, int r5, int r6) {
        int minute = localDateTime.getMinute() / r6;
        int hour = localDateTime.getHour();
        boolean z = false;
        if (1 <= hour && hour < 25) {
            z = true;
        }
        if (z) {
            return minute + (localDateTime.getHour() * r5);
        }
        return minute;
    }

    /* renamed from: getXPositionCurrentTime-VtjQ1oo, reason: not valid java name */
    public static final float m1534getXPositionCurrentTimeVtjQ1oo(long j, Function1<? super Integer, Float> xPosCenter) {
        boolean z;
        Intrinsics.checkNotNullParameter(xPosCenter, "xPosCenter");
        float m1678getInWholeMinutesimpl = (float) Duration.m1678getInWholeMinutesimpl(j);
        if (m1678getInWholeMinutesimpl <= 60.0f && m1678getInWholeMinutesimpl >= 0.0f) {
            if (m1678getInWholeMinutesimpl % 5 == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return xPosCenter.invoke(Integer.valueOf(getIndexForCurrentTime(DateTimeUtilsKt.getLocalDateTime$default(null, null, 3, null), (int) (((float) Duration.m1678getInWholeMinutesimpl(DurationKt.toDuration(1, DurationUnit.HOURS))) / m1678getInWholeMinutesimpl), (int) m1678getInWholeMinutesimpl))).floatValue();
            }
        }
        throw new Exception("Time resolution must be in the range 0-60m and evenly divisible by 5.");
    }

    /* renamed from: getXPositionCurrentTime-VtjQ1oo$default, reason: not valid java name */
    public static /* synthetic */ float m1535getXPositionCurrentTimeVtjQ1oo$default(long j, Function1 function1, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            int r0 = Duration.$r8$clinit;
            j = DurationKt.toDuration(30, DurationUnit.MINUTES);
        }
        return m1534getXPositionCurrentTimeVtjQ1oo(j, function1);
    }

    public static final float measureXAxisLabelHeight(Chart chart, CanvasPaint paintLabel, List<? extends ChartEntry> data) {
        boolean areEqual;
        Float valueOf;
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paintLabel, "paintLabel");
        Intrinsics.checkNotNullParameter(data, "data");
        XAxisProperties.Style style = chart.getX().getStyle();
        if (style instanceof XAxisProperties.Style.Timeline) {
            XAxisProperties.Style.Timeline timeline = (XAxisProperties.Style.Timeline) style;
            return Math.max(paintLabel.measureHeight(timeline.getStartTimeLabel()), paintLabel.measureHeight(timeline.getCurrentTimeLabel()));
        }
        if (style instanceof XAxisProperties.Style.DurationTimeline) {
            XAxisProperties.Style.DurationTimeline durationTimeline = (XAxisProperties.Style.DurationTimeline) style;
            return Math.max(paintLabel.measureHeight(durationTimeline.getStartTimeLabel().invoke()), paintLabel.measureHeight(durationTimeline.getEndTimeLabel().invoke()));
        }
        if (style instanceof XAxisProperties.Style.Labels) {
            areEqual = true;
        } else {
            areEqual = Intrinsics.areEqual(style, XAxisProperties.Style.LabelsStartEndSelected.INSTANCE);
        }
        if (areEqual) {
            Iterator<T> it = data.iterator();
            if (!it.hasNext()) {
                valueOf = null;
            } else {
                float measureHeight = paintLabel.measureHeight(((ChartEntry) it.next()).getXAxisLabel());
                while (it.hasNext()) {
                    measureHeight = Math.max(measureHeight, paintLabel.measureHeight(((ChartEntry) it.next()).getXAxisLabel()));
                }
                valueOf = Float.valueOf(measureHeight);
            }
            if (valueOf != null) {
                return valueOf.floatValue();
            }
        } else if (!(style instanceof XAxisProperties.Style.NoLabels)) {
            throw new NoWhenBranchMatchedException();
        }
        return 0.0f;
    }

    public static /* synthetic */ float measureXAxisLabelHeight$default(Chart chart, CanvasPaint canvasPaint, List list, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            list = EmptyList.INSTANCE;
        }
        return measureXAxisLabelHeight(chart, canvasPaint, list);
    }
}
