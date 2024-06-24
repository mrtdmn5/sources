package androidx.compose.foundation.text;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import com.google.common.collect.Platform;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SafeFlow;

/* compiled from: CoreTextField.kt */
@DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2", f = "CoreTextField.kt", l = {336}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CoreTextFieldKt$CoreTextField$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ImeOptions $imeOptions;
    public final /* synthetic */ OffsetMapping $offsetMapping;
    public final /* synthetic */ TextFieldState $state;
    public final /* synthetic */ TextInputService $textInputService;
    public final /* synthetic */ TextFieldValue $value;
    public final /* synthetic */ State<Boolean> $writeable$delegate;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$2(TextFieldState textFieldState, State<Boolean> state, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping, Continuation<? super CoreTextFieldKt$CoreTextField$2> continuation) {
        super(2, continuation);
        this.$state = textFieldState;
        this.$writeable$delegate = state;
        this.$textInputService = textInputService;
        this.$value = textFieldValue;
        this.$imeOptions = imeOptions;
        this.$offsetMapping = offsetMapping;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoreTextFieldKt$CoreTextField$2(this.$state, this.$writeable$delegate, this.$textInputService, this.$value, this.$imeOptions, this.$offsetMapping, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoreTextFieldKt$CoreTextField$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        TextFieldState textFieldState = this.$state;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                final State<Boolean> state = this.$writeable$delegate;
                SafeFlow snapshotFlow = Platform.snapshotFlow(new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(state.getValue().booleanValue());
                    }
                });
                final TextFieldState textFieldState2 = this.$state;
                final TextInputService textInputService = this.$textInputService;
                final TextFieldValue textFieldValue = this.$value;
                final ImeOptions imeOptions = this.$imeOptions;
                final OffsetMapping offsetMapping = this.$offsetMapping;
                FlowCollector<Boolean> flowCollector = new FlowCollector<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Boolean bool, Continuation continuation) {
                        boolean booleanValue = bool.booleanValue();
                        TextFieldState textFieldState3 = TextFieldState.this;
                        if (booleanValue && textFieldState3.getHasFocus()) {
                            CoreTextFieldKt.access$startInputSession(textFieldState3, imeOptions, offsetMapping, textFieldValue, textInputService);
                        } else {
                            CoreTextFieldKt.access$endInputSession(textFieldState3);
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (snapshotFlow.collect(flowCollector, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            CoreTextFieldKt.access$endInputSession(textFieldState);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            CoreTextFieldKt.access$endInputSession(textFieldState);
            throw th;
        }
    }
}
