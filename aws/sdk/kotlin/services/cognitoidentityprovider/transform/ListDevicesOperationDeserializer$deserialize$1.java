package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.ListDevicesResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ListDevicesOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.ListDevicesOperationDeserializer", f = "ListDevicesOperationDeserializer.kt", l = {36, 40}, m = "deserialize")
/* loaded from: classes.dex */
public final class ListDevicesOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public ListDevicesResponse.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ListDevicesOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListDevicesOperationDeserializer$deserialize$1(ListDevicesOperationDeserializer listDevicesOperationDeserializer, Continuation<? super ListDevicesOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = listDevicesOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
