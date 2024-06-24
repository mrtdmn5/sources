package kotlinx.coroutines.channels;

import com.animaconnected.secondo.R;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

/* compiled from: Produce.kt */
@DebugMetadata(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {R.styleable.AppTheme_stepsHistoryLineColorActivity}, m = "awaitClose")
/* loaded from: classes4.dex */
public final class ProduceKt$awaitClose$1 extends ContinuationImpl {
    public ProducerScope L$0;
    public Function0 L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ProduceKt.awaitClose(null, null, this);
    }
}
