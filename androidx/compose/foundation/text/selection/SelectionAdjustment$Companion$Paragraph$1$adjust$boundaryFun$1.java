package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import io.ktor.http.content.NullBody;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectionAdjustment.kt */
/* loaded from: classes.dex */
public /* synthetic */ class SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1 extends FunctionReferenceImpl implements Function1<Integer, TextRange> {
    public SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1(AnnotatedString annotatedString) {
        super(1, annotatedString, NullBody.class, "getParagraphBoundary", "getParagraphBoundary(Ljava/lang/CharSequence;I)J", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final TextRange invoke(Integer num) {
        int intValue = num.intValue();
        CharSequence charSequence = (CharSequence) this.receiver;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int r1 = intValue - 1;
        while (true) {
            if (r1 > 0) {
                int r2 = r1 - 1;
                if (charSequence.charAt(r2) == '\n') {
                    break;
                }
                r1 = r2;
            } else {
                r1 = 0;
                break;
            }
        }
        return new TextRange(TextRangeKt.TextRange(r1, NullBody.findParagraphEnd(intValue, charSequence)));
    }
}
