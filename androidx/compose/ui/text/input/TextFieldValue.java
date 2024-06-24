package androidx.compose.ui.text.input;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverKt$Saver$1;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldValue.kt */
/* loaded from: classes.dex */
public final class TextFieldValue {
    public final AnnotatedString annotatedString;
    public final TextRange composition;
    public final long selection;

    static {
        SaverKt.Saver(new Function2<SaverScope, TextFieldValue, Object>() { // from class: androidx.compose.ui.text.input.TextFieldValue$Companion$Saver$1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(SaverScope saverScope, TextFieldValue textFieldValue) {
                SaverScope Saver = saverScope;
                TextFieldValue it = textFieldValue;
                Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                Intrinsics.checkNotNullParameter(it, "it");
                return CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(it.annotatedString, SaversKt.AnnotatedStringSaver, Saver), SaversKt.save(new TextRange(it.selection), SaversKt.TextRangeSaver, Saver));
            }
        }, new Function1<Object, TextFieldValue>() { // from class: androidx.compose.ui.text.input.TextFieldValue$Companion$Saver$2
            @Override // kotlin.jvm.functions.Function1
            public final TextFieldValue invoke(Object it) {
                AnnotatedString annotatedString;
                TextRange textRange;
                Intrinsics.checkNotNullParameter(it, "it");
                List list = (List) it;
                Object obj = list.get(0);
                SaverKt$Saver$1 saverKt$Saver$1 = SaversKt.AnnotatedStringSaver;
                Boolean bool = Boolean.FALSE;
                if (!Intrinsics.areEqual(obj, bool) && obj != null) {
                    annotatedString = (AnnotatedString) saverKt$Saver$1.$restore.invoke(obj);
                } else {
                    annotatedString = null;
                }
                Intrinsics.checkNotNull(annotatedString);
                Object obj2 = list.get(1);
                int r2 = TextRange.$r8$clinit;
                SaverKt$Saver$1 saverKt$Saver$12 = SaversKt.TextRangeSaver;
                if (!Intrinsics.areEqual(obj2, bool) && obj2 != null) {
                    textRange = (TextRange) saverKt$Saver$12.$restore.invoke(obj2);
                } else {
                    textRange = null;
                }
                Intrinsics.checkNotNull(textRange);
                return new TextFieldValue(annotatedString, textRange.packedValue, (TextRange) null);
            }
        });
    }

    public TextFieldValue(AnnotatedString annotatedString, long j, TextRange textRange) {
        TextRange textRange2;
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        this.annotatedString = annotatedString;
        String str = annotatedString.text;
        this.selection = TextRangeKt.m528coerceIn8ffj60Q(j, str.length());
        if (textRange != null) {
            textRange2 = new TextRange(TextRangeKt.m528coerceIn8ffj60Q(textRange.packedValue, str.length()));
        } else {
            textRange2 = null;
        }
        this.composition = textRange2;
    }

    /* renamed from: copy-3r_uNRQ$default, reason: not valid java name */
    public static TextFieldValue m545copy3r_uNRQ$default(TextFieldValue textFieldValue, AnnotatedString annotatedString, long j, int r5) {
        TextRange textRange;
        if ((r5 & 1) != 0) {
            annotatedString = textFieldValue.annotatedString;
        }
        if ((r5 & 2) != 0) {
            j = textFieldValue.selection;
        }
        if ((r5 & 4) != 0) {
            textRange = textFieldValue.composition;
        } else {
            textRange = null;
        }
        textFieldValue.getClass();
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        return new TextFieldValue(annotatedString, j, textRange);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldValue)) {
            return false;
        }
        TextFieldValue textFieldValue = (TextFieldValue) obj;
        if (TextRange.m521equalsimpl0(this.selection, textFieldValue.selection) && Intrinsics.areEqual(this.composition, textFieldValue.composition) && Intrinsics.areEqual(this.annotatedString, textFieldValue.annotatedString)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int hashCode = this.annotatedString.hashCode() * 31;
        int r12 = TextRange.$r8$clinit;
        int m = Scale$$ExternalSyntheticOutline0.m(this.selection, hashCode, 31);
        TextRange textRange = this.composition;
        if (textRange != null) {
            r1 = Long.hashCode(textRange.packedValue);
        } else {
            r1 = 0;
        }
        return m + r1;
    }

    public final String toString() {
        return "TextFieldValue(text='" + ((Object) this.annotatedString) + "', selection=" + ((Object) TextRange.m527toStringimpl(this.selection)) + ", composition=" + this.composition + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TextFieldValue(java.lang.String r3, long r4, int r6) {
        /*
            r2 = this;
            r0 = r6 & 1
            if (r0 == 0) goto L6
            java.lang.String r3 = ""
        L6:
            r6 = r6 & 2
            if (r6 == 0) goto Lc
            long r4 = androidx.compose.ui.text.TextRange.Zero
        Lc:
            java.lang.String r6 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r6)
            androidx.compose.ui.text.AnnotatedString r6 = new androidx.compose.ui.text.AnnotatedString
            r0 = 6
            r1 = 0
            r6.<init>(r3, r1, r0)
            r2.<init>(r6, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.TextFieldValue.<init>(java.lang.String, long, int):void");
    }
}
