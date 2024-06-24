package aws.sdk.kotlin.runtime.auth.credentials;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ImdsCredentialsProvider.kt */
@DebugMetadata(c = "aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider", f = "ImdsCredentialsProvider.kt", l = {R.styleable.AppTheme_stepsHistoryGoalLegendColorActivity}, m = "loadProfile")
/* loaded from: classes.dex */
public final class ImdsCredentialsProvider$loadProfile$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ImdsCredentialsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImdsCredentialsProvider$loadProfile$1(ImdsCredentialsProvider imdsCredentialsProvider, Continuation<? super ImdsCredentialsProvider$loadProfile$1> continuation) {
        super(continuation);
        this.this$0 = imdsCredentialsProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ImdsCredentialsProvider.access$loadProfile(this.this$0, this);
    }
}
