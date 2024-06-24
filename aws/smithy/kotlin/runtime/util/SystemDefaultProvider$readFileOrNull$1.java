package aws.smithy.kotlin.runtime.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: PlatformJVM.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.util.SystemDefaultProvider", f = "PlatformJVM.kt", l = {38}, m = "readFileOrNull")
/* loaded from: classes.dex */
public final class SystemDefaultProvider$readFileOrNull$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SystemDefaultProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemDefaultProvider$readFileOrNull$1(SystemDefaultProvider systemDefaultProvider, Continuation<? super SystemDefaultProvider$readFileOrNull$1> continuation) {
        super(continuation);
        this.this$0 = systemDefaultProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readFileOrNull(null, this);
    }
}
