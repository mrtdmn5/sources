package com.animaconnected.watch.graphs;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: Chart.kt */
/* loaded from: classes3.dex */
public final class XAxisProperties {
    private boolean centerTextLabels;
    private float circleHeight;
    private boolean drawCircles;
    private float labelHeight;
    private int labelMargin;
    private Function0<Float> startPosition;
    private Style style;
    private float tickSpace;

    /* compiled from: Chart.kt */
    /* loaded from: classes3.dex */
    public static abstract class Style {

        /* compiled from: Chart.kt */
        /* loaded from: classes3.dex */
        public static final class DurationTimeline extends Style {
            private final Function0<String> endTimeLabel;
            private final Function0<String> startTimeLabel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DurationTimeline(Function0<String> startTimeLabel, Function0<String> endTimeLabel) {
                super(null);
                Intrinsics.checkNotNullParameter(startTimeLabel, "startTimeLabel");
                Intrinsics.checkNotNullParameter(endTimeLabel, "endTimeLabel");
                this.startTimeLabel = startTimeLabel;
                this.endTimeLabel = endTimeLabel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ DurationTimeline copy$default(DurationTimeline durationTimeline, Function0 function0, Function0 function02, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    function0 = durationTimeline.startTimeLabel;
                }
                if ((r3 & 2) != 0) {
                    function02 = durationTimeline.endTimeLabel;
                }
                return durationTimeline.copy(function0, function02);
            }

            public final Function0<String> component1() {
                return this.startTimeLabel;
            }

            public final Function0<String> component2() {
                return this.endTimeLabel;
            }

            public final DurationTimeline copy(Function0<String> startTimeLabel, Function0<String> endTimeLabel) {
                Intrinsics.checkNotNullParameter(startTimeLabel, "startTimeLabel");
                Intrinsics.checkNotNullParameter(endTimeLabel, "endTimeLabel");
                return new DurationTimeline(startTimeLabel, endTimeLabel);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof DurationTimeline)) {
                    return false;
                }
                DurationTimeline durationTimeline = (DurationTimeline) obj;
                if (Intrinsics.areEqual(this.startTimeLabel, durationTimeline.startTimeLabel) && Intrinsics.areEqual(this.endTimeLabel, durationTimeline.endTimeLabel)) {
                    return true;
                }
                return false;
            }

            public final Function0<String> getEndTimeLabel() {
                return this.endTimeLabel;
            }

            public final Function0<String> getStartTimeLabel() {
                return this.startTimeLabel;
            }

            public int hashCode() {
                return this.endTimeLabel.hashCode() + (this.startTimeLabel.hashCode() * 31);
            }

            public String toString() {
                return "DurationTimeline(startTimeLabel=" + this.startTimeLabel + ", endTimeLabel=" + this.endTimeLabel + ')';
            }
        }

        /* compiled from: Chart.kt */
        /* loaded from: classes3.dex */
        public static final class Labels extends Style {
            public static final Labels INSTANCE = new Labels();

            private Labels() {
                super(null);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Labels)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1278507808;
            }

            public String toString() {
                return "Labels";
            }
        }

        /* compiled from: Chart.kt */
        /* loaded from: classes3.dex */
        public static final class LabelsStartEndSelected extends Style {
            public static final LabelsStartEndSelected INSTANCE = new LabelsStartEndSelected();

            private LabelsStartEndSelected() {
                super(null);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof LabelsStartEndSelected)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2021587436;
            }

            public String toString() {
                return "LabelsStartEndSelected";
            }
        }

        /* compiled from: Chart.kt */
        /* loaded from: classes3.dex */
        public static final class NoLabels extends Style {
            public static final NoLabels INSTANCE = new NoLabels();

            private NoLabels() {
                super(null);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof NoLabels)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1617683455;
            }

            public String toString() {
                return "NoLabels";
            }
        }

        /* compiled from: Chart.kt */
        /* loaded from: classes3.dex */
        public static final class Timeline extends Style {
            private final String currentTimeLabel;
            private final String startTimeLabel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Timeline(String startTimeLabel, String currentTimeLabel) {
                super(null);
                Intrinsics.checkNotNullParameter(startTimeLabel, "startTimeLabel");
                Intrinsics.checkNotNullParameter(currentTimeLabel, "currentTimeLabel");
                this.startTimeLabel = startTimeLabel;
                this.currentTimeLabel = currentTimeLabel;
            }

            public static /* synthetic */ Timeline copy$default(Timeline timeline, String str, String str2, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    str = timeline.startTimeLabel;
                }
                if ((r3 & 2) != 0) {
                    str2 = timeline.currentTimeLabel;
                }
                return timeline.copy(str, str2);
            }

            public final String component1() {
                return this.startTimeLabel;
            }

            public final String component2() {
                return this.currentTimeLabel;
            }

            public final Timeline copy(String startTimeLabel, String currentTimeLabel) {
                Intrinsics.checkNotNullParameter(startTimeLabel, "startTimeLabel");
                Intrinsics.checkNotNullParameter(currentTimeLabel, "currentTimeLabel");
                return new Timeline(startTimeLabel, currentTimeLabel);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Timeline)) {
                    return false;
                }
                Timeline timeline = (Timeline) obj;
                if (Intrinsics.areEqual(this.startTimeLabel, timeline.startTimeLabel) && Intrinsics.areEqual(this.currentTimeLabel, timeline.currentTimeLabel)) {
                    return true;
                }
                return false;
            }

            public final String getCurrentTimeLabel() {
                return this.currentTimeLabel;
            }

            public final String getStartTimeLabel() {
                return this.startTimeLabel;
            }

            public int hashCode() {
                return this.currentTimeLabel.hashCode() + (this.startTimeLabel.hashCode() * 31);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Timeline(startTimeLabel=");
                sb.append(this.startTimeLabel);
                sb.append(", currentTimeLabel=");
                return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.currentTimeLabel, ')');
            }
        }

        public /* synthetic */ Style(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Style() {
        }
    }

    public XAxisProperties() {
        this(null, 0, 0.0f, null, 0.0f, false, false, 0.0f, 255, null);
    }

    public static /* synthetic */ XAxisProperties copy$default(XAxisProperties xAxisProperties, Style style, int r11, float f, Function0 function0, float f2, boolean z, boolean z2, float f3, int r18, Object obj) {
        Style style2;
        int r3;
        float f4;
        Function0 function02;
        float f5;
        boolean z3;
        boolean z4;
        float f6;
        if ((r18 & 1) != 0) {
            style2 = xAxisProperties.style;
        } else {
            style2 = style;
        }
        if ((r18 & 2) != 0) {
            r3 = xAxisProperties.labelMargin;
        } else {
            r3 = r11;
        }
        if ((r18 & 4) != 0) {
            f4 = xAxisProperties.labelHeight;
        } else {
            f4 = f;
        }
        if ((r18 & 8) != 0) {
            function02 = xAxisProperties.startPosition;
        } else {
            function02 = function0;
        }
        if ((r18 & 16) != 0) {
            f5 = xAxisProperties.tickSpace;
        } else {
            f5 = f2;
        }
        if ((r18 & 32) != 0) {
            z3 = xAxisProperties.centerTextLabels;
        } else {
            z3 = z;
        }
        if ((r18 & 64) != 0) {
            z4 = xAxisProperties.drawCircles;
        } else {
            z4 = z2;
        }
        if ((r18 & 128) != 0) {
            f6 = xAxisProperties.circleHeight;
        } else {
            f6 = f3;
        }
        return xAxisProperties.copy(style2, r3, f4, function02, f5, z3, z4, f6);
    }

    public final Style component1() {
        return this.style;
    }

    public final int component2() {
        return this.labelMargin;
    }

    public final float component3() {
        return this.labelHeight;
    }

    public final Function0<Float> component4() {
        return this.startPosition;
    }

    public final float component5() {
        return this.tickSpace;
    }

    public final boolean component6() {
        return this.centerTextLabels;
    }

    public final boolean component7() {
        return this.drawCircles;
    }

    public final float component8() {
        return this.circleHeight;
    }

    public final XAxisProperties copy(Style style, int r12, float f, Function0<Float> startPosition, float f2, boolean z, boolean z2, float f3) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(startPosition, "startPosition");
        return new XAxisProperties(style, r12, f, startPosition, f2, z, z2, f3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XAxisProperties)) {
            return false;
        }
        XAxisProperties xAxisProperties = (XAxisProperties) obj;
        if (Intrinsics.areEqual(this.style, xAxisProperties.style) && this.labelMargin == xAxisProperties.labelMargin && Float.compare(this.labelHeight, xAxisProperties.labelHeight) == 0 && Intrinsics.areEqual(this.startPosition, xAxisProperties.startPosition) && Float.compare(this.tickSpace, xAxisProperties.tickSpace) == 0 && this.centerTextLabels == xAxisProperties.centerTextLabels && this.drawCircles == xAxisProperties.drawCircles && Float.compare(this.circleHeight, xAxisProperties.circleHeight) == 0) {
            return true;
        }
        return false;
    }

    public final boolean getCenterTextLabels() {
        return this.centerTextLabels;
    }

    public final float getCircleHeight() {
        return this.circleHeight;
    }

    public final boolean getDrawCircles() {
        return this.drawCircles;
    }

    public final float getLabelHeight() {
        return this.labelHeight;
    }

    public final int getLabelMargin() {
        return this.labelMargin;
    }

    public final Function0<Float> getStartPosition() {
        return this.startPosition;
    }

    public final Style getStyle() {
        return this.style;
    }

    public final float getTickSpace() {
        return this.tickSpace;
    }

    public int hashCode() {
        return Float.hashCode(this.circleHeight) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.drawCircles, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.centerTextLabels, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.tickSpace, (this.startPosition.hashCode() + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.labelHeight, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.labelMargin, this.style.hashCode() * 31, 31), 31)) * 31, 31), 31), 31);
    }

    public final void setCenterTextLabels(boolean z) {
        this.centerTextLabels = z;
    }

    public final void setCircleHeight(float f) {
        this.circleHeight = f;
    }

    public final void setDrawCircles(boolean z) {
        this.drawCircles = z;
    }

    public final void setLabelHeight(float f) {
        this.labelHeight = f;
    }

    public final void setLabelMargin(int r1) {
        this.labelMargin = r1;
    }

    public final void setStartPosition(Function0<Float> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.startPosition = function0;
    }

    public final void setStyle(Style style) {
        Intrinsics.checkNotNullParameter(style, "<set-?>");
        this.style = style;
    }

    public final void setTickSpace(float f) {
        this.tickSpace = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XAxisProperties(style=");
        sb.append(this.style);
        sb.append(", labelMargin=");
        sb.append(this.labelMargin);
        sb.append(", labelHeight=");
        sb.append(this.labelHeight);
        sb.append(", startPosition=");
        sb.append(this.startPosition);
        sb.append(", tickSpace=");
        sb.append(this.tickSpace);
        sb.append(", centerTextLabels=");
        sb.append(this.centerTextLabels);
        sb.append(", drawCircles=");
        sb.append(this.drawCircles);
        sb.append(", circleHeight=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.circleHeight, ')');
    }

    public XAxisProperties(Style style, int r3, float f, Function0<Float> startPosition, float f2, boolean z, boolean z2, float f3) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(startPosition, "startPosition");
        this.style = style;
        this.labelMargin = r3;
        this.labelHeight = f;
        this.startPosition = startPosition;
        this.tickSpace = f2;
        this.centerTextLabels = z;
        this.drawCircles = z2;
        this.circleHeight = f3;
    }

    public /* synthetic */ XAxisProperties(Style style, int r10, float f, Function0 function0, float f2, boolean z, boolean z2, float f3, int r17, DefaultConstructorMarker defaultConstructorMarker) {
        this((r17 & 1) != 0 ? Style.Labels.INSTANCE : style, (r17 & 2) != 0 ? 8 : r10, (r17 & 4) != 0 ? 0.0f : f, (r17 & 8) != 0 ? new Function0<Float>() { // from class: com.animaconnected.watch.graphs.XAxisProperties.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(0.0f);
            }
        } : function0, (r17 & 16) == 0 ? f2 : 0.0f, (r17 & 32) != 0 ? true : z, (r17 & 64) != 0 ? false : z2, (r17 & 128) != 0 ? 4.0f : f3);
    }
}
