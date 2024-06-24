package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: TextFieldDelegate.kt */
/* loaded from: classes.dex */
public final class TextFieldDelegate$Companion$restartInput$1 extends Lambda implements Function1<List<? extends EditCommand>, Unit> {
    public final /* synthetic */ EditProcessor $editProcessor;
    public final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChange;
    public final /* synthetic */ Ref$ObjectRef<TextInputSession> $session;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldDelegate$Companion$restartInput$1(EditProcessor editProcessor, TextFieldState$onValueChange$1 textFieldState$onValueChange$1, Ref$ObjectRef ref$ObjectRef) {
        super(1);
        this.$editProcessor = editProcessor;
        this.$onValueChange = textFieldState$onValueChange$1;
        this.$session = ref$ObjectRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(List<? extends EditCommand> list) {
        List<? extends EditCommand> it = list;
        Intrinsics.checkNotNullParameter(it, "it");
        TextInputSession textInputSession = this.$session.element;
        EditProcessor editProcessor = this.$editProcessor;
        Intrinsics.checkNotNullParameter(editProcessor, "editProcessor");
        Function1<TextFieldValue, Unit> onValueChange = this.$onValueChange;
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        TextFieldValue apply = editProcessor.apply(it);
        if (textInputSession != null) {
            textInputSession.updateState(null, apply);
        }
        onValueChange.invoke(apply);
        return Unit.INSTANCE;
    }
}
