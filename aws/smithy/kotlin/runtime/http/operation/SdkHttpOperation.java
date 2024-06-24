package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.util.Uuid;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: SdkHttpOperation.kt */
/* loaded from: classes.dex */
public final class SdkHttpOperation<I, O> {
    public final ExecutionContext context;
    public final HttpDeserialize<O> deserializer;
    public final SdkOperationExecution<I, O> execution;
    public final ArrayList interceptors;
    public final HttpSerialize<I> serializer;
    public final OperationTypeInfo typeInfo;

    public SdkHttpOperation(SdkOperationExecution<I, O> execution, ExecutionContext executionContext, HttpSerialize<I> httpSerialize, HttpDeserialize<O> httpDeserialize, OperationTypeInfo operationTypeInfo) {
        Intrinsics.checkNotNullParameter(execution, "execution");
        this.execution = execution;
        this.context = executionContext;
        this.serializer = httpSerialize;
        this.deserializer = httpDeserialize;
        this.typeInfo = operationTypeInfo;
        Random.Default r5 = Uuid.random;
        executionContext.set(HttpOperationContext.SdkRequestId, new Uuid((r5.nextLong() & (~Uuid.v4Mask)) | Uuid.v4Set, (r5.nextLong() & (~Uuid.type2Mask)) | Uuid.type2Set).stringRep);
        this.interceptors = new ArrayList();
    }
}
