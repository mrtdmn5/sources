package androidx.compose.ui.text.font;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidFontLoader.android.kt */
@DebugMetadata(c = "androidx.compose.ui.text.font.AndroidFontLoader", f = "AndroidFontLoader.android.kt", l = {61, 62}, m = "awaitLoad")
/* loaded from: classes.dex */
public final class AndroidFontLoader$awaitLoad$1 extends ContinuationImpl {
    public AndroidFontLoader L$0;
    public Font L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AndroidFontLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidFontLoader$awaitLoad$1(AndroidFontLoader androidFontLoader, Continuation<? super AndroidFontLoader$awaitLoad$1> continuation) {
        super(continuation);
        this.this$0 = androidFontLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.awaitLoad(null, this);
    }
}
