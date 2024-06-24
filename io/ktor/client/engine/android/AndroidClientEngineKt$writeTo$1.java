package io.ktor.client.engine.android;

import com.animaconnected.secondo.R;
import java.io.OutputStream;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidClientEngine.kt */
@DebugMetadata(c = "io.ktor.client.engine.android.AndroidClientEngineKt", f = "AndroidClientEngine.kt", l = {124, R.styleable.AppTheme_stepsHistoryBackgroundActivity}, m = "writeTo")
/* loaded from: classes3.dex */
public final class AndroidClientEngineKt$writeTo$1 extends ContinuationImpl {
    public OutputStream L$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AndroidClientEngineKt.writeTo(null, null, null, this);
    }
}
