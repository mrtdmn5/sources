package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: TextFieldScroll.kt */
/* loaded from: classes.dex */
public final class HorizontalScrollLayoutModifier implements LayoutModifier {
    public final int cursorOffset;
    public final TextFieldScrollerPosition scrollerPosition;
    public final Function0<TextLayoutResultProxy> textLayoutResultProvider;
    public final TransformedText transformedText;

    public HorizontalScrollLayoutModifier(TextFieldScrollerPosition textFieldScrollerPosition, int r2, TransformedText transformedText, CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1 coreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1) {
        this.scrollerPosition = textFieldScrollerPosition;
        this.cursorOffset = r2;
        this.transformedText = transformedText;
        this.textLayoutResultProvider = coreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HorizontalScrollLayoutModifier)) {
            return false;
        }
        HorizontalScrollLayoutModifier horizontalScrollLayoutModifier = (HorizontalScrollLayoutModifier) obj;
        if (Intrinsics.areEqual(this.scrollerPosition, horizontalScrollLayoutModifier.scrollerPosition) && this.cursorOffset == horizontalScrollLayoutModifier.cursorOffset && Intrinsics.areEqual(this.transformedText, horizontalScrollLayoutModifier.transformedText) && Intrinsics.areEqual(this.textLayoutResultProvider, horizontalScrollLayoutModifier.textLayoutResultProvider)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.textLayoutResultProvider.hashCode() + ((this.transformedText.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.cursorOffset, this.scrollerPosition.hashCode() * 31, 31)) * 31);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo5measure3p2s80s(final MeasureScope measure, Measurable measurable, long j) {
        long m558copyZbe2FdA$default;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        if (measurable.maxIntrinsicWidth(Constraints.m564getMaxHeightimpl(j)) < Constraints.m565getMaxWidthimpl(j)) {
            m558copyZbe2FdA$default = j;
        } else {
            m558copyZbe2FdA$default = Constraints.m558copyZbe2FdA$default(j, 0, Integer.MAX_VALUE, 0, 0, 13);
        }
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(m558copyZbe2FdA$default);
        final int min = Math.min(mo421measureBRTryo0.width, Constraints.m565getMaxWidthimpl(j));
        return measure.layout(min, mo421measureBRTryo0.height, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.HorizontalScrollLayoutModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                TextLayoutResult textLayoutResult;
                boolean z;
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                MeasureScope measureScope = MeasureScope.this;
                HorizontalScrollLayoutModifier horizontalScrollLayoutModifier = this;
                int r2 = horizontalScrollLayoutModifier.cursorOffset;
                TransformedText transformedText = horizontalScrollLayoutModifier.transformedText;
                TextLayoutResultProxy invoke = horizontalScrollLayoutModifier.textLayoutResultProvider.invoke();
                if (invoke != null) {
                    textLayoutResult = invoke.value;
                } else {
                    textLayoutResult = null;
                }
                if (MeasureScope.this.getLayoutDirection() == LayoutDirection.Rtl) {
                    z = true;
                } else {
                    z = false;
                }
                Placeable placeable = mo421measureBRTryo0;
                Rect access$getCursorRectInScroller = TextFieldScrollKt.access$getCursorRectInScroller(measureScope, r2, transformedText, textLayoutResult, z, placeable.width);
                Orientation orientation = Orientation.Horizontal;
                int r3 = placeable.width;
                TextFieldScrollerPosition textFieldScrollerPosition = horizontalScrollLayoutModifier.scrollerPosition;
                textFieldScrollerPosition.update(orientation, access$getCursorRectInScroller, min, r3);
                Placeable.PlacementScope.placeRelative$default(layout, placeable, MathKt__MathJVMKt.roundToInt(-textFieldScrollerPosition.getOffset()), 0);
                return Unit.INSTANCE;
            }
        });
    }

    public final String toString() {
        return "HorizontalScrollLayoutModifier(scrollerPosition=" + this.scrollerPosition + ", cursorOffset=" + this.cursorOffset + ", transformedText=" + this.transformedText + ", textLayoutResultProvider=" + this.textLayoutResultProvider + ')';
    }
}
