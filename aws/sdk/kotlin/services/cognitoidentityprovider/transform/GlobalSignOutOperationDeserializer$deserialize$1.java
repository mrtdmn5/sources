package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GlobalSignOutOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.GlobalSignOutOperationDeserializer", f = "GlobalSignOutOperationDeserializer.kt", l = {21}, m = "deserialize")
/* loaded from: classes.dex */
public final class GlobalSignOutOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ GlobalSignOutOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSignOutOperationDeserializer$deserialize$1(GlobalSignOutOperationDeserializer globalSignOutOperationDeserializer, Continuation<? super GlobalSignOutOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = globalSignOutOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
