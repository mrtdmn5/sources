package androidx.compose.ui.text.font;

import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@DebugMetadata(c = "androidx.compose.ui.text.font.AsyncFontListLoader", f = "FontListFontFamilyTypefaceAdapter.kt", l = {TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY}, m = "loadWithTimeoutOrNull$ui_text_release")
/* loaded from: classes.dex */
public final class AsyncFontListLoader$loadWithTimeoutOrNull$1 extends ContinuationImpl {
    public Font L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AsyncFontListLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncFontListLoader$loadWithTimeoutOrNull$1(AsyncFontListLoader asyncFontListLoader, Continuation<? super AsyncFontListLoader$loadWithTimeoutOrNull$1> continuation) {
        super(continuation);
        this.this$0 = asyncFontListLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadWithTimeoutOrNull$ui_text_release(null, this);
    }
}
