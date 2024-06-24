package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidFontLoader.android.kt */
@DebugMetadata(c = "androidx.compose.ui.text.font.AndroidFontLoader_androidKt$loadAsync$2", f = "AndroidFontLoader.android.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AndroidFontLoader_androidKt$loadAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Typeface>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ ResourceFont $this_loadAsync;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidFontLoader_androidKt$loadAsync$2(ResourceFont resourceFont, Context context, Continuation<? super AndroidFontLoader_androidKt$loadAsync$2> continuation) {
        super(2, continuation);
        this.$this_loadAsync = resourceFont;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidFontLoader_androidKt$loadAsync$2(this.$this_loadAsync, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Typeface> continuation) {
        return ((AndroidFontLoader_androidKt$loadAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        return AndroidFontLoader_androidKt.access$load(this.$context, this.$this_loadAsync);
    }
}
