package aws.smithy.kotlin.runtime.retries.delay;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;

/* compiled from: StandardRetryTokenBucket.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket", f = "StandardRetryTokenBucket.kt", l = {R.styleable.AppTheme_stepsHistoryLineColorDetail}, m = "returnCapacity")
/* loaded from: classes.dex */
public final class StandardRetryTokenBucket$returnCapacity$1 extends ContinuationImpl {
    public int I$0;
    public StandardRetryTokenBucket L$0;
    public MutexImpl L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StandardRetryTokenBucket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardRetryTokenBucket$returnCapacity$1(StandardRetryTokenBucket standardRetryTokenBucket, Continuation<? super StandardRetryTokenBucket$returnCapacity$1> continuation) {
        super(continuation);
        this.this$0 = standardRetryTokenBucket;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StandardRetryTokenBucket.access$returnCapacity(this.this$0, 0, this);
    }
}
