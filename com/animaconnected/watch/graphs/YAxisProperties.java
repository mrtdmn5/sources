package com.animaconnected.watch.graphs;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import com.animaconnected.watch.graphs.utils.YAxisScaleFormatter;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: Chart.kt */
/* loaded from: classes3.dex */
public final class YAxisProperties {
    private Function1<? super List<? extends ChartEntry>, Integer> calculateAverageValue;
    private Function1<? super List<? extends ChartEntry>, Limits> calculateMinMax;
    private Function1<? super List<? extends ChartEntry>, ? extends List<IntRange>> calculateProvidedRanges;
    private Function1<? super Integer, String> convertValueToLabel;
    private int dataAverageValue;
    private int dataLatestValue;
    private int dataMaxValue;
    private int dataMinValue;
    private int labelMargin;
    private LineToLabelRatio lineToLabelRatio;
    private float maxLabelHeight;
    private float maxLabelWidth;
    private int nbrOfGridLines;
    private final YAxisScaleFormatter scaleFormatter;
    private Style style;

    /* compiled from: Chart.kt */
    /* loaded from: classes3.dex */
    public static final class Limits {
        private final int max;
        private final int min;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Limits() {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.graphs.YAxisProperties.Limits.<init>():void");
        }

        public static /* synthetic */ Limits copy$default(Limits limits, int r1, int r2, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                r1 = limits.min;
            }
            if ((r3 & 2) != 0) {
                r2 = limits.max;
            }
            return limits.copy(r1, r2);
        }

        public final int component1() {
            return this.min;
        }

        public final int component2() {
            return this.max;
        }

        public final Limits copy(int r2, int r3) {
            return new Limits(r2, r3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Limits)) {
                return false;
            }
            Limits limits = (Limits) obj;
            if (this.min == limits.min && this.max == limits.max) {
                return true;
            }
            return false;
        }

        public final int getMax() {
            return this.max;
        }

        public final int getMin() {
            return this.min;
        }

        public int hashCode() {
            return Integer.hashCode(this.max) + (Integer.hashCode(this.min) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Limits(min=");
            sb.append(this.min);
            sb.append(", max=");
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.max, ')');
        }

        public Limits(int r1, int r2) {
            this.min = r1;
            this.max = r2;
        }

        public /* synthetic */ Limits(int r2, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
            this((r4 & 1) != 0 ? 0 : r2, (r4 & 2) != 0 ? 0 : r3);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Chart.kt */
    /* loaded from: classes3.dex */
    public static final class LineToLabelRatio {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LineToLabelRatio[] $VALUES;
        public static final LineToLabelRatio One = new LineToLabelRatio("One", 0);
        public static final LineToLabelRatio Two = new LineToLabelRatio("Two", 1);

        private static final /* synthetic */ LineToLabelRatio[] $values() {
            return new LineToLabelRatio[]{One, Two};
        }

        static {
            LineToLabelRatio[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private LineToLabelRatio(String str, int r2) {
        }

        public static EnumEntries<LineToLabelRatio> getEntries() {
            return $ENTRIES;
        }

        public static LineToLabelRatio valueOf(String str) {
            return (LineToLabelRatio) Enum.valueOf(LineToLabelRatio.class, str);
        }

        public static LineToLabelRatio[] values() {
            return (LineToLabelRatio[]) $VALUES.clone();
        }
    }

    /* compiled from: Chart.kt */
    /* loaded from: classes3.dex */
    public static abstract class Style {

        /* compiled from: Chart.kt */
        /* loaded from: classes3.dex */
        public static final class Average extends Style {
            private final String descriptionText;
            private boolean drawLabelBottom;
            private boolean drawZeroLine;

            public /* synthetic */ Average(String str, boolean z, boolean z2, int r5, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (r5 & 2) != 0 ? false : z, (r5 & 4) != 0 ? false : z2);
            }

            public static /* synthetic */ Average copy$default(Average average, String str, boolean z, boolean z2, int r4, Object obj) {
                if ((r4 & 1) != 0) {
                    str = average.descriptionText;
                }
                if ((r4 & 2) != 0) {
                    z = average.drawZeroLine;
                }
                if ((r4 & 4) != 0) {
                    z2 = average.drawLabelBottom;
                }
                return average.copy(str, z, z2);
            }

            public final String component1() {
                return this.descriptionText;
            }

            public final boolean component2() {
                return this.drawZeroLine;
            }

            public final boolean component3() {
                return this.drawLabelBottom;
            }

            public final Average copy(String descriptionText, boolean z, boolean z2) {
                Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
                return new Average(descriptionText, z, z2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Average)) {
                    return false;
                }
                Average average = (Average) obj;
                if (Intrinsics.areEqual(this.descriptionText, average.descriptionText) && this.drawZeroLine == average.drawZeroLine && this.drawLabelBottom == average.drawLabelBottom) {
                    return true;
                }
                return false;
            }

            public final String getDescriptionText() {
                return this.descriptionText;
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public boolean getDrawLabelBottom() {
                return this.drawLabelBottom;
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public boolean getDrawZeroLine() {
                return this.drawZeroLine;
            }

            public int hashCode() {
                return Boolean.hashCode(this.drawLabelBottom) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.drawZeroLine, this.descriptionText.hashCode() * 31, 31);
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public void setDrawLabelBottom(boolean z) {
                this.drawLabelBottom = z;
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public void setDrawZeroLine(boolean z) {
                this.drawZeroLine = z;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Average(descriptionText=");
                sb.append(this.descriptionText);
                sb.append(", drawZeroLine=");
                sb.append(this.drawZeroLine);
                sb.append(", drawLabelBottom=");
                return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.drawLabelBottom, ')');
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Average(String descriptionText, boolean z, boolean z2) {
                super(null);
                Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
                this.descriptionText = descriptionText;
                this.drawZeroLine = z;
                this.drawLabelBottom = z2;
            }
        }

        /* compiled from: Chart.kt */
        /* loaded from: classes3.dex */
        public static final class DualAxes extends Style {
            private boolean drawLabelBottom;
            private boolean drawZeroLine;
            private final List<Pair<String, IntRange>> entriesLeftAxis;

            public /* synthetic */ DualAxes(List list, boolean z, boolean z2, int r5, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, (r5 & 2) != 0 ? false : z, (r5 & 4) != 0 ? false : z2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ DualAxes copy$default(DualAxes dualAxes, List list, boolean z, boolean z2, int r4, Object obj) {
                if ((r4 & 1) != 0) {
                    list = dualAxes.entriesLeftAxis;
                }
                if ((r4 & 2) != 0) {
                    z = dualAxes.drawZeroLine;
                }
                if ((r4 & 4) != 0) {
                    z2 = dualAxes.drawLabelBottom;
                }
                return dualAxes.copy(list, z, z2);
            }

            public final List<Pair<String, IntRange>> component1() {
                return this.entriesLeftAxis;
            }

            public final boolean component2() {
                return this.drawZeroLine;
            }

            public final boolean component3() {
                return this.drawLabelBottom;
            }

            public final DualAxes copy(List<Pair<String, IntRange>> entriesLeftAxis, boolean z, boolean z2) {
                Intrinsics.checkNotNullParameter(entriesLeftAxis, "entriesLeftAxis");
                return new DualAxes(entriesLeftAxis, z, z2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof DualAxes)) {
                    return false;
                }
                DualAxes dualAxes = (DualAxes) obj;
                if (Intrinsics.areEqual(this.entriesLeftAxis, dualAxes.entriesLeftAxis) && this.drawZeroLine == dualAxes.drawZeroLine && this.drawLabelBottom == dualAxes.drawLabelBottom) {
                    return true;
                }
                return false;
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public boolean getDrawLabelBottom() {
                return this.drawLabelBottom;
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public boolean getDrawZeroLine() {
                return this.drawZeroLine;
            }

            public final List<Pair<String, IntRange>> getEntriesLeftAxis() {
                return this.entriesLeftAxis;
            }

            public int hashCode() {
                return Boolean.hashCode(this.drawLabelBottom) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.drawZeroLine, this.entriesLeftAxis.hashCode() * 31, 31);
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public void setDrawLabelBottom(boolean z) {
                this.drawLabelBottom = z;
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public void setDrawZeroLine(boolean z) {
                this.drawZeroLine = z;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("DualAxes(entriesLeftAxis=");
                sb.append(this.entriesLeftAxis);
                sb.append(", drawZeroLine=");
                sb.append(this.drawZeroLine);
                sb.append(", drawLabelBottom=");
                return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.drawLabelBottom, ')');
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DualAxes(List<Pair<String, IntRange>> entriesLeftAxis, boolean z, boolean z2) {
                super(null);
                Intrinsics.checkNotNullParameter(entriesLeftAxis, "entriesLeftAxis");
                this.entriesLeftAxis = entriesLeftAxis;
                this.drawZeroLine = z;
                this.drawLabelBottom = z2;
            }
        }

        /* compiled from: Chart.kt */
        /* loaded from: classes3.dex */
        public static final class Normal extends Style {
            private boolean drawLabelBottom;
            private boolean drawZeroLine;

            public Normal(boolean z, boolean z2) {
                super(null);
                this.drawZeroLine = z;
                this.drawLabelBottom = z2;
            }

            public static /* synthetic */ Normal copy$default(Normal normal, boolean z, boolean z2, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    z = normal.drawZeroLine;
                }
                if ((r3 & 2) != 0) {
                    z2 = normal.drawLabelBottom;
                }
                return normal.copy(z, z2);
            }

            public final boolean component1() {
                return this.drawZeroLine;
            }

            public final boolean component2() {
                return this.drawLabelBottom;
            }

            public final Normal copy(boolean z, boolean z2) {
                return new Normal(z, z2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Normal)) {
                    return false;
                }
                Normal normal = (Normal) obj;
                if (this.drawZeroLine == normal.drawZeroLine && this.drawLabelBottom == normal.drawLabelBottom) {
                    return true;
                }
                return false;
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public boolean getDrawLabelBottom() {
                return this.drawLabelBottom;
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public boolean getDrawZeroLine() {
                return this.drawZeroLine;
            }

            public int hashCode() {
                return Boolean.hashCode(this.drawLabelBottom) + (Boolean.hashCode(this.drawZeroLine) * 31);
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public void setDrawLabelBottom(boolean z) {
                this.drawLabelBottom = z;
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public void setDrawZeroLine(boolean z) {
                this.drawZeroLine = z;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Normal(drawZeroLine=");
                sb.append(this.drawZeroLine);
                sb.append(", drawLabelBottom=");
                return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.drawLabelBottom, ')');
            }
        }

        public /* synthetic */ Style(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract boolean getDrawLabelBottom();

        public abstract boolean getDrawZeroLine();

        public abstract void setDrawLabelBottom(boolean z);

        public abstract void setDrawZeroLine(boolean z);

        /* compiled from: Chart.kt */
        /* loaded from: classes3.dex */
        public static final class Highlight extends Style {
            private final boolean dashedLine;
            private boolean drawLabelBottom;
            private boolean drawZeroLine;
            private final boolean showValue;
            private final Function0<Integer> value;

            public /* synthetic */ Highlight(Function0 function0, boolean z, boolean z2, boolean z3, boolean z4, int r12, DefaultConstructorMarker defaultConstructorMarker) {
                this((r12 & 1) != 0 ? new Function0<Integer>() { // from class: com.animaconnected.watch.graphs.YAxisProperties.Style.Highlight.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Integer invoke() {
                        return 0;
                    }
                } : function0, (r12 & 2) != 0 ? false : z, (r12 & 4) != 0 ? true : z2, z3, z4);
            }

            public static /* synthetic */ Highlight copy$default(Highlight highlight, Function0 function0, boolean z, boolean z2, boolean z3, boolean z4, int r9, Object obj) {
                if ((r9 & 1) != 0) {
                    function0 = highlight.value;
                }
                if ((r9 & 2) != 0) {
                    z = highlight.dashedLine;
                }
                boolean z5 = z;
                if ((r9 & 4) != 0) {
                    z2 = highlight.showValue;
                }
                boolean z6 = z2;
                if ((r9 & 8) != 0) {
                    z3 = highlight.drawZeroLine;
                }
                boolean z7 = z3;
                if ((r9 & 16) != 0) {
                    z4 = highlight.drawLabelBottom;
                }
                return highlight.copy(function0, z5, z6, z7, z4);
            }

            public final Function0<Integer> component1() {
                return this.value;
            }

            public final boolean component2() {
                return this.dashedLine;
            }

            public final boolean component3() {
                return this.showValue;
            }

            public final boolean component4() {
                return this.drawZeroLine;
            }

            public final boolean component5() {
                return this.drawLabelBottom;
            }

            public final Highlight copy(Function0<Integer> value, boolean z, boolean z2, boolean z3, boolean z4) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new Highlight(value, z, z2, z3, z4);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Highlight)) {
                    return false;
                }
                Highlight highlight = (Highlight) obj;
                if (Intrinsics.areEqual(this.value, highlight.value) && this.dashedLine == highlight.dashedLine && this.showValue == highlight.showValue && this.drawZeroLine == highlight.drawZeroLine && this.drawLabelBottom == highlight.drawLabelBottom) {
                    return true;
                }
                return false;
            }

            public final boolean getDashedLine() {
                return this.dashedLine;
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public boolean getDrawLabelBottom() {
                return this.drawLabelBottom;
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public boolean getDrawZeroLine() {
                return this.drawZeroLine;
            }

            public final boolean getShowValue() {
                return this.showValue;
            }

            public final Function0<Integer> getValue() {
                return this.value;
            }

            public int hashCode() {
                return Boolean.hashCode(this.drawLabelBottom) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.drawZeroLine, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.showValue, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.dashedLine, this.value.hashCode() * 31, 31), 31), 31);
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public void setDrawLabelBottom(boolean z) {
                this.drawLabelBottom = z;
            }

            @Override // com.animaconnected.watch.graphs.YAxisProperties.Style
            public void setDrawZeroLine(boolean z) {
                this.drawZeroLine = z;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Highlight(value=");
                sb.append(this.value);
                sb.append(", dashedLine=");
                sb.append(this.dashedLine);
                sb.append(", showValue=");
                sb.append(this.showValue);
                sb.append(", drawZeroLine=");
                sb.append(this.drawZeroLine);
                sb.append(", drawLabelBottom=");
                return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.drawLabelBottom, ')');
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Highlight(Function0<Integer> value, boolean z, boolean z2, boolean z3, boolean z4) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
                this.dashedLine = z;
                this.showValue = z2;
                this.drawZeroLine = z3;
                this.drawLabelBottom = z4;
            }
        }

        private Style() {
        }
    }

    public YAxisProperties() {
        this(null, 0.0f, 0, 0.0f, 0, null, null, null, null, null, 0, 0, 0, 0, null, 32767, null);
    }

    public final Style component1() {
        return this.style;
    }

    public final LineToLabelRatio component10() {
        return this.lineToLabelRatio;
    }

    public final int component11() {
        return this.dataMaxValue;
    }

    public final int component12() {
        return this.dataMinValue;
    }

    public final int component13() {
        return this.dataAverageValue;
    }

    public final int component14() {
        return this.dataLatestValue;
    }

    public final YAxisScaleFormatter component15() {
        return this.scaleFormatter;
    }

    public final float component2() {
        return this.maxLabelHeight;
    }

    public final int component3() {
        return this.labelMargin;
    }

    public final float component4() {
        return this.maxLabelWidth;
    }

    public final int component5() {
        return this.nbrOfGridLines;
    }

    public final Function1<Integer, String> component6() {
        return this.convertValueToLabel;
    }

    public final Function1<List<? extends ChartEntry>, Integer> component7() {
        return this.calculateAverageValue;
    }

    public final Function1<List<? extends ChartEntry>, Limits> component8() {
        return this.calculateMinMax;
    }

    public final Function1<List<? extends ChartEntry>, List<IntRange>> component9() {
        return this.calculateProvidedRanges;
    }

    public final YAxisProperties copy(Style style, float f, int r20, float f2, int r22, Function1<? super Integer, String> convertValueToLabel, Function1<? super List<? extends ChartEntry>, Integer> calculateAverageValue, Function1<? super List<? extends ChartEntry>, Limits> calculateMinMax, Function1<? super List<? extends ChartEntry>, ? extends List<IntRange>> calculateProvidedRanges, LineToLabelRatio lineToLabelRatio, int r28, int r29, int r30, int r31, YAxisScaleFormatter scaleFormatter) {
        Intrinsics.checkNotNullParameter(convertValueToLabel, "convertValueToLabel");
        Intrinsics.checkNotNullParameter(calculateAverageValue, "calculateAverageValue");
        Intrinsics.checkNotNullParameter(calculateMinMax, "calculateMinMax");
        Intrinsics.checkNotNullParameter(calculateProvidedRanges, "calculateProvidedRanges");
        Intrinsics.checkNotNullParameter(lineToLabelRatio, "lineToLabelRatio");
        Intrinsics.checkNotNullParameter(scaleFormatter, "scaleFormatter");
        return new YAxisProperties(style, f, r20, f2, r22, convertValueToLabel, calculateAverageValue, calculateMinMax, calculateProvidedRanges, lineToLabelRatio, r28, r29, r30, r31, scaleFormatter);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YAxisProperties)) {
            return false;
        }
        YAxisProperties yAxisProperties = (YAxisProperties) obj;
        if (Intrinsics.areEqual(this.style, yAxisProperties.style) && Float.compare(this.maxLabelHeight, yAxisProperties.maxLabelHeight) == 0 && this.labelMargin == yAxisProperties.labelMargin && Float.compare(this.maxLabelWidth, yAxisProperties.maxLabelWidth) == 0 && this.nbrOfGridLines == yAxisProperties.nbrOfGridLines && Intrinsics.areEqual(this.convertValueToLabel, yAxisProperties.convertValueToLabel) && Intrinsics.areEqual(this.calculateAverageValue, yAxisProperties.calculateAverageValue) && Intrinsics.areEqual(this.calculateMinMax, yAxisProperties.calculateMinMax) && Intrinsics.areEqual(this.calculateProvidedRanges, yAxisProperties.calculateProvidedRanges) && this.lineToLabelRatio == yAxisProperties.lineToLabelRatio && this.dataMaxValue == yAxisProperties.dataMaxValue && this.dataMinValue == yAxisProperties.dataMinValue && this.dataAverageValue == yAxisProperties.dataAverageValue && this.dataLatestValue == yAxisProperties.dataLatestValue && Intrinsics.areEqual(this.scaleFormatter, yAxisProperties.scaleFormatter)) {
            return true;
        }
        return false;
    }

    public final Function1<List<? extends ChartEntry>, Integer> getCalculateAverageValue() {
        return this.calculateAverageValue;
    }

    public final Function1<List<? extends ChartEntry>, Limits> getCalculateMinMax() {
        return this.calculateMinMax;
    }

    public final Function1<List<? extends ChartEntry>, List<IntRange>> getCalculateProvidedRanges() {
        return this.calculateProvidedRanges;
    }

    public final Function1<Integer, String> getConvertValueToLabel() {
        return this.convertValueToLabel;
    }

    public final int getDataAverageValue() {
        return this.dataAverageValue;
    }

    public final int getDataLatestValue() {
        return this.dataLatestValue;
    }

    public final int getDataMaxValue() {
        return this.dataMaxValue;
    }

    public final int getDataMinValue() {
        return this.dataMinValue;
    }

    public final int getLabelMargin() {
        return this.labelMargin;
    }

    public final LineToLabelRatio getLineToLabelRatio() {
        return this.lineToLabelRatio;
    }

    public final float getMaxLabelHeight() {
        return this.maxLabelHeight;
    }

    public final float getMaxLabelWidth() {
        return this.maxLabelWidth;
    }

    public final int getNbrOfGridLines() {
        return this.nbrOfGridLines;
    }

    public final YAxisScaleFormatter getScaleFormatter() {
        return this.scaleFormatter;
    }

    public final Style getStyle() {
        return this.style;
    }

    public int hashCode() {
        int hashCode;
        Style style = this.style;
        if (style == null) {
            hashCode = 0;
        } else {
            hashCode = style.hashCode();
        }
        return this.scaleFormatter.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.dataLatestValue, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.dataAverageValue, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.dataMinValue, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.dataMaxValue, (this.lineToLabelRatio.hashCode() + ((this.calculateProvidedRanges.hashCode() + ((this.calculateMinMax.hashCode() + ((this.calculateAverageValue.hashCode() + ((this.convertValueToLabel.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.nbrOfGridLines, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.maxLabelWidth, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.labelMargin, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.maxLabelHeight, hashCode * 31, 31), 31), 31), 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31), 31), 31), 31);
    }

    public final void setCalculateAverageValue(Function1<? super List<? extends ChartEntry>, Integer> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.calculateAverageValue = function1;
    }

    public final void setCalculateMinMax(Function1<? super List<? extends ChartEntry>, Limits> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.calculateMinMax = function1;
    }

    public final void setCalculateProvidedRanges(Function1<? super List<? extends ChartEntry>, ? extends List<IntRange>> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.calculateProvidedRanges = function1;
    }

    public final void setConvertValueToLabel(Function1<? super Integer, String> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.convertValueToLabel = function1;
    }

    public final void setDataAverageValue(int r1) {
        this.dataAverageValue = r1;
    }

    public final void setDataLatestValue(int r1) {
        this.dataLatestValue = r1;
    }

    public final void setDataMaxValue(int r1) {
        this.dataMaxValue = r1;
    }

    public final void setDataMinValue(int r1) {
        this.dataMinValue = r1;
    }

    public final void setLabelMargin(int r1) {
        this.labelMargin = r1;
    }

    public final void setLineToLabelRatio(LineToLabelRatio lineToLabelRatio) {
        Intrinsics.checkNotNullParameter(lineToLabelRatio, "<set-?>");
        this.lineToLabelRatio = lineToLabelRatio;
    }

    public final void setMaxLabelHeight(float f) {
        this.maxLabelHeight = f;
    }

    public final void setMaxLabelWidth(float f) {
        this.maxLabelWidth = f;
    }

    public final void setNbrOfGridLines(int r1) {
        this.nbrOfGridLines = r1;
    }

    public final void setStyle(Style style) {
        this.style = style;
    }

    public String toString() {
        return "YAxisProperties(style=" + this.style + ", maxLabelHeight=" + this.maxLabelHeight + ", labelMargin=" + this.labelMargin + ", maxLabelWidth=" + this.maxLabelWidth + ", nbrOfGridLines=" + this.nbrOfGridLines + ", convertValueToLabel=" + this.convertValueToLabel + ", calculateAverageValue=" + this.calculateAverageValue + ", calculateMinMax=" + this.calculateMinMax + ", calculateProvidedRanges=" + this.calculateProvidedRanges + ", lineToLabelRatio=" + this.lineToLabelRatio + ", dataMaxValue=" + this.dataMaxValue + ", dataMinValue=" + this.dataMinValue + ", dataAverageValue=" + this.dataAverageValue + ", dataLatestValue=" + this.dataLatestValue + ", scaleFormatter=" + this.scaleFormatter + ')';
    }

    public YAxisProperties(Style style, float f, int r11, float f2, int r13, Function1<? super Integer, String> convertValueToLabel, Function1<? super List<? extends ChartEntry>, Integer> calculateAverageValue, Function1<? super List<? extends ChartEntry>, Limits> calculateMinMax, Function1<? super List<? extends ChartEntry>, ? extends List<IntRange>> calculateProvidedRanges, LineToLabelRatio lineToLabelRatio, int r19, int r20, int r21, int r22, YAxisScaleFormatter scaleFormatter) {
        Intrinsics.checkNotNullParameter(convertValueToLabel, "convertValueToLabel");
        Intrinsics.checkNotNullParameter(calculateAverageValue, "calculateAverageValue");
        Intrinsics.checkNotNullParameter(calculateMinMax, "calculateMinMax");
        Intrinsics.checkNotNullParameter(calculateProvidedRanges, "calculateProvidedRanges");
        Intrinsics.checkNotNullParameter(lineToLabelRatio, "lineToLabelRatio");
        Intrinsics.checkNotNullParameter(scaleFormatter, "scaleFormatter");
        this.style = style;
        this.maxLabelHeight = f;
        this.labelMargin = r11;
        this.maxLabelWidth = f2;
        this.nbrOfGridLines = r13;
        this.convertValueToLabel = convertValueToLabel;
        this.calculateAverageValue = calculateAverageValue;
        this.calculateMinMax = calculateMinMax;
        this.calculateProvidedRanges = calculateProvidedRanges;
        this.lineToLabelRatio = lineToLabelRatio;
        this.dataMaxValue = r19;
        this.dataMinValue = r20;
        this.dataAverageValue = r21;
        this.dataLatestValue = r22;
        this.scaleFormatter = scaleFormatter;
    }

    public /* synthetic */ YAxisProperties(Style style, float f, int r24, float f2, int r26, Function1 function1, Function1 function12, Function1 function13, Function1 function14, LineToLabelRatio lineToLabelRatio, int r32, int r33, int r34, int r35, YAxisScaleFormatter yAxisScaleFormatter, int r37, DefaultConstructorMarker defaultConstructorMarker) {
        this((r37 & 1) != 0 ? null : style, (r37 & 2) != 0 ? 0.0f : f, (r37 & 4) != 0 ? 8 : r24, (r37 & 8) == 0 ? f2 : 0.0f, (r37 & 16) == 0 ? r26 : 8, (r37 & 32) != 0 ? new Function1<Integer, String>() { // from class: com.animaconnected.watch.graphs.YAxisProperties.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int r1) {
                return String.valueOf(r1);
            }
        } : function1, (r37 & 64) != 0 ? new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.YAxisProperties.2
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return 0;
            }
        } : function12, (r37 & 128) != 0 ? new Function1<List<? extends ChartEntry>, Limits>() { // from class: com.animaconnected.watch.graphs.YAxisProperties.3
            @Override // kotlin.jvm.functions.Function1
            public final Limits invoke(List<? extends ChartEntry> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                int r2 = 0;
                return new Limits(r2, r2, 3, null);
            }
        } : function13, (r37 & 256) != 0 ? new Function1<List<? extends ChartEntry>, List<? extends IntRange>>() { // from class: com.animaconnected.watch.graphs.YAxisProperties.4
            @Override // kotlin.jvm.functions.Function1
            public final List<IntRange> invoke(List<? extends ChartEntry> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return EmptyList.INSTANCE;
            }
        } : function14, (r37 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? LineToLabelRatio.Two : lineToLabelRatio, (r37 & 1024) != 0 ? 0 : r32, (r37 & 2048) != 0 ? 0 : r33, (r37 & 4096) == 0 ? r34 : 0, (r37 & DfuBaseService.ERROR_REMOTE_MASK) != 0 ? -1 : r35, (r37 & DfuBaseService.ERROR_CONNECTION_MASK) != 0 ? new YAxisScaleFormatter(0, 0, 0, null, 15, null) : yAxisScaleFormatter);
    }
}
