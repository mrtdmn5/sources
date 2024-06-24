package androidx.compose.foundation.text;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.IntSize;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CoreTextField.kt */
@DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1$1", f = "CoreTextField.kt", l = {318}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CoreTextFieldKt$CoreTextField$focusModifier$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    public final /* synthetic */ TextLayoutResultProxy $layoutResult;
    public final /* synthetic */ OffsetMapping $offsetMapping;
    public final /* synthetic */ TextFieldState $state;
    public final /* synthetic */ TextFieldValue $value;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextFieldState textFieldState, TextLayoutResultProxy textLayoutResultProxy, OffsetMapping offsetMapping, Continuation<? super CoreTextFieldKt$CoreTextField$focusModifier$1$1$1> continuation) {
        super(2, continuation);
        this.$bringIntoViewRequester = bringIntoViewRequester;
        this.$value = textFieldValue;
        this.$state = textFieldState;
        this.$layoutResult = textLayoutResultProxy;
        this.$offsetMapping = offsetMapping;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(this.$bringIntoViewRequester, this.$value, this.$state, this.$layoutResult, this.$offsetMapping, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoreTextFieldKt$CoreTextField$focusModifier$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Rect rect;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            TextDelegate textDelegate = this.$state.textDelegate;
            TextLayoutResult textLayoutResult = this.$layoutResult.value;
            this.label = 1;
            int originalToTransformed = this.$offsetMapping.originalToTransformed(TextRange.m524getMaximpl(this.$value.selection));
            if (originalToTransformed < textLayoutResult.layoutInput.text.length()) {
                rect = textLayoutResult.getBoundingBox(originalToTransformed);
            } else if (originalToTransformed != 0) {
                rect = textLayoutResult.getBoundingBox(originalToTransformed - 1);
            } else {
                rect = new Rect(0.0f, 0.0f, 1.0f, IntSize.m593getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textDelegate.style, textDelegate.density, textDelegate.fontFamilyResolver, TextFieldDelegateKt.EmptyTextReplacement, 1)));
            }
            Object bringIntoView = this.$bringIntoViewRequester.bringIntoView(rect, this);
            if (bringIntoView != coroutineSingletons) {
                bringIntoView = Unit.INSTANCE;
            }
            if (bringIntoView == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
