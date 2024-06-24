package com.animaconnected.secondo.screens.activity.activityHistory;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.animaconnected.draganddrop.utils.Utilities;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.screens.activity.StepFormatHelper;
import com.animaconnected.secondo.utils.UIUtility;
import com.animaconnected.watch.display.DpUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: StepsHistoryGraph.kt */
/* loaded from: classes3.dex */
public final class StepsHistoryGraph extends View {
    private static final float MIN_COLUMN_HEIGHT = 0.025f;
    private Paint bottomLinePaint;
    private Paint columnPaint;
    private Paint columnTodayPaint;
    private List<GraphData> data;
    private Paint goalLegendPaint;
    private Paint goalLinePaint;
    private Path goalPath;
    private final Rect graphRect;
    private int highestValue;
    private Paint hintBackgroundPaint;
    private final RectF hintRect;
    private Paint hintTextPaint;
    private List<String> labels;
    private Paint legendPaint;
    private Paint lineLegendPaint;
    private Paint linePaint;
    private List<? extends Path> paths;
    private float roundness;
    private int selectedIndex;
    private final StepFormatHelper stepFormatHelper;
    private int targetSteps;
    private int todayIndex;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: StepsHistoryGraph.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: StepsHistoryGraph.kt */
    /* loaded from: classes3.dex */
    public static final class GraphData {
        public static final int $stable = 0;
        private final String date;
        private final int steps;

        public GraphData(int r2, String date) {
            Intrinsics.checkNotNullParameter(date, "date");
            this.steps = r2;
            this.date = date;
        }

        public static /* synthetic */ GraphData copy$default(GraphData graphData, int r1, String str, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                r1 = graphData.steps;
            }
            if ((r3 & 2) != 0) {
                str = graphData.date;
            }
            return graphData.copy(r1, str);
        }

        public final int component1() {
            return this.steps;
        }

        public final String component2() {
            return this.date;
        }

        public final GraphData copy(int r2, String date) {
            Intrinsics.checkNotNullParameter(date, "date");
            return new GraphData(r2, date);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GraphData)) {
                return false;
            }
            GraphData graphData = (GraphData) obj;
            if (this.steps == graphData.steps && Intrinsics.areEqual(this.date, graphData.date)) {
                return true;
            }
            return false;
        }

        public final String getDate() {
            return this.date;
        }

        public final int getSteps() {
            return this.steps;
        }

        public int hashCode() {
            return this.date.hashCode() + (Integer.hashCode(this.steps) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("GraphData(steps=");
            sb.append(this.steps);
            sb.append(", date=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.date, ')');
        }
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public StepsHistoryGraph(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final List<String> calculateLabels(int r6) {
        int makeNiceSteps = makeNiceSteps(r6, 6);
        IntRange intRange = new IntRange(1, makeNiceSteps);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(toFormattedString((r6 / makeNiceSteps) * ((IntIterator) it).nextInt()));
        }
        return arrayList;
    }

    private final Path calculateLinePath(float f, Rect rect) {
        Path path = new Path();
        path.moveTo(nw(0.0f, rect), nh(f, rect));
        path.lineTo(nw(1.0f, rect), nh(f, rect));
        return path;
    }

    private final void drawColumns(Canvas canvas, List<Integer> list) {
        int width;
        Paint paint;
        List<Integer> list2 = list;
        if (list.isEmpty()) {
            width = 0;
        } else {
            width = (int) ((this.graphRect.width() / list.size()) * 0.6f);
        }
        int size = list.size();
        int r12 = 0;
        while (r12 < size) {
            float columnLocation = getColumnLocation(r12);
            float f = width / 2.0f;
            float f2 = columnLocation - f;
            float f3 = columnLocation + f;
            float max = Math.max(list2.get(r12).floatValue() / this.highestValue, MIN_COLUMN_HEIGHT);
            Rect rect = this.graphRect;
            float nh = (rect.bottom - nh(max, rect)) + this.graphRect.top;
            if (r12 == this.todayIndex) {
                paint = this.columnTodayPaint;
            } else {
                paint = this.columnPaint;
            }
            canvas.drawRect(f2, nh, f3, r1.bottom, paint);
            if (r12 == this.selectedIndex) {
                int intValue = list2.get(r12).intValue();
                if (intValue < 0) {
                    intValue = 0;
                }
                String formattedString = toFormattedString(intValue);
                UIUtility uIUtility = UIUtility.INSTANCE;
                int textHeight = uIUtility.getTextHeight(formattedString, this.hintTextPaint);
                int textWidth = uIUtility.getTextWidth(formattedString, this.hintTextPaint);
                DpUtils dpUtils = DpUtils.INSTANCE;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                int dpToPx = dpUtils.dpToPx(context, 8.0f);
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                int dpToPx2 = dpUtils.dpToPx(context2, 4.0f);
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                int dpToPx3 = dpUtils.dpToPx(context3, 4.0f);
                float f4 = textWidth / 2.0f;
                float f5 = columnLocation - f4;
                float f6 = dpToPx2;
                float f7 = dpToPx;
                float f8 = nh - f7;
                this.hintRect.set(f5 - f6, (((nh - textHeight) - f7) - f6) - f6, f4 + columnLocation + f6, f8);
                RectF rectF = this.hintRect;
                float f9 = this.roundness;
                canvas.drawRoundRect(rectF, f9, f9, this.hintBackgroundPaint);
                Path path = new Path();
                path.setFillType(Path.FillType.EVEN_ODD);
                float f10 = dpToPx3;
                path.moveTo(columnLocation, this.hintRect.bottom + f10);
                path.lineTo(columnLocation - f10, this.hintRect.bottom);
                path.lineTo(columnLocation + f10, this.hintRect.bottom);
                path.lineTo(columnLocation, this.hintRect.bottom + f10);
                path.close();
                canvas.drawPath(path, this.hintBackgroundPaint);
                canvas.drawText(formattedString, f5, f8 - f6, this.hintTextPaint);
            }
            r12++;
            list2 = list;
        }
    }

    private final void drawLegends(Canvas canvas) {
        int r0;
        Paint paint;
        List<GraphData> list = this.data;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(getHeight(((GraphData) it.next()).getDate(), this.legendPaint)));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.maxOrNull((Iterable) arrayList);
        int r1 = 0;
        if (num != null) {
            r0 = num.intValue();
        } else {
            r0 = 0;
        }
        int size = this.data.size();
        for (int r3 = 0; r3 < size; r3++) {
            canvas.drawText(this.data.get(r3).getDate(), getColumnLocation(r3) - (UIUtility.INSTANCE.getTextWidth(r4, this.legendPaint) / 2), (r0 * 1.5f) + this.graphRect.bottom, this.legendPaint);
        }
        for (Object obj : this.labels) {
            int r4 = r1 + 1;
            if (r1 >= 0) {
                String str = (String) obj;
                if (Intrinsics.areEqual(str, toFormattedString(this.targetSteps))) {
                    paint = this.goalLegendPaint;
                } else {
                    paint = this.lineLegendPaint;
                }
                float f = this.graphRect.right;
                DpUtils dpUtils = DpUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
                canvas.drawText(str, f + dpUtils.dpToPx(r7, 8.0f), (r0 / 2.0f) + nh(1.0f - (r4 / this.labels.size()), this.graphRect), paint);
                r1 = r4;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        Iterator<T> it2 = this.paths.iterator();
        while (it2.hasNext()) {
            canvas.drawPath((Path) it2.next(), this.linePaint);
        }
        Path path = this.goalPath;
        if (path != null) {
            canvas.drawPath(path, this.goalLinePaint);
        }
    }

    private final int getColumnLocation(int r3) {
        int width = this.graphRect.width() / this.data.size();
        int r32 = r3 * width;
        return (width / 2) + r32 + this.graphRect.left;
    }

    private final int getHeight(String str, Paint paint) {
        return UIUtility.INSTANCE.getTextHeight(str, paint);
    }

    private final int makeNiceSteps(int r2, int r3) {
        if (r3 > 2 && (r2 / r3) % 250 != 0) {
            return makeNiceSteps(r2, r3 - 1);
        }
        return r3;
    }

    private final void measure() {
        int r0;
        int r3;
        List<GraphData> list = this.data;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(getHeight(((GraphData) it.next()).getDate(), this.legendPaint)));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.maxOrNull((Iterable) arrayList);
        int r1 = 0;
        if (num != null) {
            r0 = num.intValue();
        } else {
            r0 = 0;
        }
        List<String> list2 = this.labels;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(UIUtility.INSTANCE.getTextWidth((String) it2.next(), this.lineLegendPaint)));
        }
        Integer num2 = (Integer) CollectionsKt___CollectionsKt.maxOrNull((Iterable) arrayList2);
        if (num2 != null) {
            r3 = num2.intValue();
        } else {
            r3 = 0;
        }
        DpUtils dpUtils = DpUtils.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int dpToPx = dpUtils.dpToPx(context, 8.0f);
        Rect rect = this.graphRect;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        int dpToPx2 = dpUtils.dpToPx(context2, 20.0f) + dpToPx;
        int width = (getWidth() - r3) - dpToPx;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        rect.set(dpToPx, dpToPx2, width - dpUtils.dpToPx(context3, 8.0f), (getHeight() - r0) - dpToPx);
        List<String> list3 = this.labels;
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list3, 10));
        for (Object obj : list3) {
            int r5 = r1 + 1;
            Path path = null;
            if (r1 >= 0) {
                if (!Intrinsics.areEqual((String) obj, toFormattedString(this.targetSteps))) {
                    path = calculateLinePath(1.0f - (r5 / this.labels.size()), this.graphRect);
                }
                arrayList3.add(path);
                r1 = r5;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        this.paths = CollectionsKt___CollectionsKt.filterNotNull(arrayList3);
        this.goalPath = calculateLinePath(1.0f - (this.targetSteps / this.highestValue), this.graphRect);
    }

    private final int nh(float f, Rect rect) {
        return rect.top + ((int) (f * rect.height()));
    }

    private final int nw(float f, Rect rect) {
        return rect.left + ((int) (f * rect.width()));
    }

    private final String toFormattedString(int r2) {
        String formatNumber = this.stepFormatHelper.formatNumber(r2);
        Intrinsics.checkNotNullExpressionValue(formatNumber, "formatNumber(...)");
        return formatNumber;
    }

    public final int getColor(TypedArray typedArray, int r2, long j) {
        if (typedArray != null) {
            return typedArray.getColor(r2, (int) j);
        }
        return (int) j;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawLegends(canvas);
        List<GraphData> list = this.data;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((GraphData) it.next()).getSteps()));
        }
        drawColumns(canvas, arrayList);
        Rect rect = this.graphRect;
        float f = rect.left;
        int r1 = rect.bottom;
        canvas.drawLine(f, r1, rect.right, r1, this.bottomLinePaint);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int r2, int r3, int r4, int r5) {
        super.onLayout(z, r2, r3, r4, r5);
        measure();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent != null && motionEvent.getAction() == 0) {
            z = true;
        }
        if (z) {
            if (this.graphRect.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && !this.data.isEmpty()) {
                int x = (int) motionEvent.getX();
                Rect rect = this.graphRect;
                int width = (x - rect.left) / (rect.width() / this.data.size());
                if (width < this.data.size()) {
                    if (this.selectedIndex == width) {
                        width = -1;
                    }
                    this.selectedIndex = width;
                }
                measure();
                invalidate();
            } else {
                return super.onTouchEvent(motionEvent);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setData(List<GraphData> newData, int r6) {
        int r5;
        Intrinsics.checkNotNullParameter(newData, "newData");
        List<GraphData> reversed = CollectionsKt___CollectionsKt.reversed(newData);
        this.data = reversed;
        List<GraphData> list = reversed;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((GraphData) it.next()).getSteps()));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.maxOrNull((Iterable) arrayList);
        if (num != null) {
            r5 = num.intValue();
        } else {
            r5 = 1000;
        }
        int ceil = ((int) Math.ceil(r5 / 2000.0d)) * 2000;
        if (r5 <= r6) {
            ceil = r6;
        }
        this.highestValue = ceil;
        this.labels = calculateLabels(ceil);
        this.targetSteps = r6;
        this.todayIndex = this.data.size() - 1;
        measure();
        invalidate();
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public StepsHistoryGraph(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ StepsHistoryGraph(Context context, AttributeSet attributeSet, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (r4 & 2) != 0 ? null : attributeSet, (r4 & 4) != 0 ? 0 : r3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepsHistoryGraph(Context context, AttributeSet attributeSet, int r19) {
        super(context, attributeSet, r19);
        Intrinsics.checkNotNullParameter(context, "context");
        this.stepFormatHelper = new StepFormatHelper(Locale.getDefault());
        this.graphRect = new Rect();
        this.hintRect = new RectF();
        this.data = new ArrayList();
        EmptyList emptyList = EmptyList.INSTANCE;
        this.labels = emptyList;
        this.paths = emptyList;
        this.selectedIndex = -1;
        TypedArray obtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, R.styleable.StepsHistoryGraph, r19, 0) : null;
        int color = getColor(obtainStyledAttributes, 1, 4281545523L);
        int color2 = getColor(obtainStyledAttributes, 2, 4284900966L);
        int color3 = getColor(obtainStyledAttributes, 9, 4278190080L);
        int color4 = getColor(obtainStyledAttributes, 11, 4278190080L);
        int color5 = getColor(obtainStyledAttributes, 7, 4294967295L);
        int color6 = getColor(obtainStyledAttributes, 6, 4278190080L);
        int color7 = getColor(obtainStyledAttributes, 0, 4278190080L);
        int color8 = getColor(obtainStyledAttributes, 10, 4278190080L);
        int color9 = getColor(obtainStyledAttributes, 5, 4281545523L);
        int color10 = getColor(obtainStyledAttributes, 4, 4281545523L);
        this.roundness = obtainStyledAttributes != null ? obtainStyledAttributes.getDimension(8, 0.0f) : 0.0f;
        Typeface typefaceFromResource = Utilities.getTypefaceFromResource(context, obtainStyledAttributes != null ? obtainStyledAttributes.getResourceId(3, 0) : 0);
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        this.columnPaint = paint;
        Paint paint2 = new Paint(this.columnPaint);
        paint2.setColor(color2);
        this.columnTodayPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setColor(color3);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setTextAlign(Paint.Align.LEFT);
        paint3.setTypeface(typefaceFromResource);
        DpUtils dpUtils = DpUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
        paint3.setTextSize(dpUtils.spToPx(r3, 11.0f));
        this.legendPaint = paint3;
        Paint paint4 = new Paint(this.legendPaint);
        paint4.setColor(color4);
        this.lineLegendPaint = paint4;
        Paint paint5 = new Paint(this.legendPaint);
        paint5.setColor(color10);
        this.goalLegendPaint = paint5;
        Paint paint6 = new Paint(this.legendPaint);
        paint6.setColor(color5);
        this.hintTextPaint = paint6;
        Paint paint7 = new Paint(1);
        paint7.setStyle(Paint.Style.FILL);
        paint7.setColor(color6);
        this.hintBackgroundPaint = paint7;
        Paint paint8 = new Paint(1);
        paint8.setStyle(Paint.Style.STROKE);
        paint8.setColor(color7);
        paint8.setStrokeWidth(4.0f);
        this.bottomLinePaint = paint8;
        Paint paint9 = new Paint(this.bottomLinePaint);
        paint9.setColor(color9);
        paint9.setPathEffect(new DashPathEffect(new float[]{8.0f, 8.0f}, 0.0f));
        this.goalLinePaint = paint9;
        Paint paint10 = new Paint(this.bottomLinePaint);
        paint10.setColor(color8);
        this.linePaint = paint10;
    }
}
