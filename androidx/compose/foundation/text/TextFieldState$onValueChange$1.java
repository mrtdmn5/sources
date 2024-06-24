package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: CoreTextField.kt */
/* loaded from: classes.dex */
public final class TextFieldState$onValueChange$1 extends Lambda implements Function1<TextFieldValue, Unit> {
    public final /* synthetic */ TextFieldState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldState$onValueChange$1(TextFieldState textFieldState) {
        super(1);
        this.this$0 = textFieldState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(TextFieldValue textFieldValue) {
        String str;
        TextFieldValue it = textFieldValue;
        Intrinsics.checkNotNullParameter(it, "it");
        String str2 = it.annotatedString.text;
        TextFieldState textFieldState = this.this$0;
        AnnotatedString annotatedString = textFieldState.untransformedText;
        if (annotatedString != null) {
            str = annotatedString.text;
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str2, str)) {
            HandleState handleState = HandleState.None;
            Intrinsics.checkNotNullParameter(handleState, "<set-?>");
            textFieldState.handleState$delegate.setValue(handleState);
        }
        textFieldState.onValueChangeOriginal.invoke(it);
        textFieldState.recomposeScope.invalidate();
        return Unit.INSTANCE;
    }
}
