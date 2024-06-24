package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextPreparedSelection.kt */
/* loaded from: classes.dex */
public final class TextFieldPreparedSelection extends BaseTextPreparedSelection<TextFieldPreparedSelection> {
    public final TextFieldValue currentValue;
    public final TextLayoutResultProxy layoutResultProxy;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TextFieldPreparedSelection(androidx.compose.ui.text.input.TextFieldValue r9, androidx.compose.ui.text.input.OffsetMapping r10, androidx.compose.foundation.text.TextLayoutResultProxy r11, androidx.compose.foundation.text.selection.TextPreparedSelectionState r12) {
        /*
            r8 = this;
            java.lang.String r0 = "currentValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "offsetMapping"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            androidx.compose.ui.text.AnnotatedString r2 = r9.annotatedString
            long r3 = r9.selection
            if (r11 == 0) goto L19
            androidx.compose.ui.text.TextLayoutResult r0 = r11.value
            goto L1a
        L19:
            r0 = 0
        L1a:
            r5 = r0
            r1 = r8
            r6 = r10
            r7 = r12
            r1.<init>(r2, r3, r5, r6, r7)
            r8.currentValue = r9
            r8.layoutResultProxy = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldPreparedSelection.<init>(androidx.compose.ui.text.input.TextFieldValue, androidx.compose.ui.text.input.OffsetMapping, androidx.compose.foundation.text.TextLayoutResultProxy, androidx.compose.foundation.text.selection.TextPreparedSelectionState):void");
    }

    public final List<EditCommand> deleteIfSelectedOr(Function1<? super TextFieldPreparedSelection, ? extends EditCommand> or) {
        Intrinsics.checkNotNullParameter(or, "or");
        if (TextRange.m522getCollapsedimpl(this.selection)) {
            EditCommand invoke = or.invoke(this);
            if (invoke != null) {
                return CollectionsKt__CollectionsKt.listOf(invoke);
            }
            return null;
        }
        return CollectionsKt__CollectionsKt.listOf((Object[]) new EditCommand[]{new CommitTextCommand("", 0), new SetSelectionCommand(TextRange.m525getMinimpl(this.selection), TextRange.m525getMinimpl(this.selection))});
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:            if (r0 == null) goto L9;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int jumpByPagesOffset(androidx.compose.foundation.text.TextLayoutResultProxy r6, int r7) {
        /*
            r5 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r6.innerTextFieldCoordinates
            if (r0 == 0) goto L11
            androidx.compose.ui.layout.LayoutCoordinates r1 = r6.decorationBoxCoordinates
            if (r1 == 0) goto Le
            r2 = 1
            androidx.compose.ui.geometry.Rect r0 = r1.localBoundingBoxOf(r0, r2)
            goto Lf
        Le:
            r0 = 0
        Lf:
            if (r0 != 0) goto L13
        L11:
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.ui.geometry.Rect.Zero
        L13:
            androidx.compose.ui.text.input.TextFieldValue r1 = r5.currentValue
            long r1 = r1.selection
            int r1 = androidx.compose.ui.text.TextRange.m523getEndimpl(r1)
            androidx.compose.ui.text.input.OffsetMapping r2 = r5.offsetMapping
            int r1 = r2.originalToTransformed(r1)
            androidx.compose.ui.text.TextLayoutResult r6 = r6.value
            androidx.compose.ui.geometry.Rect r1 = r6.getCursorRect(r1)
            float r3 = r0.right
            float r4 = r0.left
            float r3 = r3 - r4
            float r4 = r0.bottom
            float r0 = r0.top
            float r4 = r4 - r0
            long r3 = androidx.compose.ui.geometry.SizeKt.Size(r3, r4)
            float r0 = androidx.compose.ui.geometry.Size.m274getHeightimpl(r3)
            float r7 = (float) r7
            float r0 = r0 * r7
            float r7 = r1.top
            float r0 = r0 + r7
            float r7 = r1.left
            long r0 = androidx.compose.ui.geometry.OffsetKt.Offset(r7, r0)
            int r6 = r6.m519getOffsetForPositionk4lQ0M(r0)
            int r6 = r2.transformedToOriginal(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldPreparedSelection.jumpByPagesOffset(androidx.compose.foundation.text.TextLayoutResultProxy, int):int");
    }
}
