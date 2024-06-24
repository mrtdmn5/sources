package io.ktor.client.plugins.auth.providers;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BearerAuthProvider.kt */
@DebugMetadata(c = "io.ktor.client.plugins.auth.providers.BearerAuthProvider", f = "BearerAuthProvider.kt", l = {R.styleable.AppTheme_stepsHistoryFontActivity}, m = "refreshToken")
/* loaded from: classes3.dex */
public final class BearerAuthProvider$refreshToken$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ BearerAuthProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BearerAuthProvider$refreshToken$1(BearerAuthProvider bearerAuthProvider, Continuation<? super BearerAuthProvider$refreshToken$1> continuation) {
        super(continuation);
        this.this$0 = bearerAuthProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refreshToken(null, this);
    }
}
