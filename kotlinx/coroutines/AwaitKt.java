package kotlinx.coroutines;

import io.ktor.util.ByteChannelsKt$split$1;
import java.util.Collection;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.AwaitAll;

/* compiled from: Await.kt */
/* loaded from: classes4.dex */
public final class AwaitKt {
    public static final Object awaitAll(Collection collection, ByteChannelsKt$split$1 byteChannelsKt$split$1) {
        if (collection.isEmpty()) {
            return EmptyList.INSTANCE;
        }
        Deferred[] deferredArr = (Deferred[]) collection.toArray(new Deferred[0]);
        AwaitAll awaitAll = new AwaitAll(deferredArr);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(byteChannelsKt$split$1));
        cancellableContinuationImpl.initCancellability();
        int length = deferredArr.length;
        AwaitAll.AwaitAllNode[] awaitAllNodeArr = new AwaitAll.AwaitAllNode[length];
        for (int r4 = 0; r4 < length; r4++) {
            Deferred deferred = deferredArr[r4];
            deferred.start();
            AwaitAll.AwaitAllNode awaitAllNode = new AwaitAll.AwaitAllNode(cancellableContinuationImpl);
            awaitAllNode.handle = deferred.invokeOnCompletion(awaitAllNode);
            Unit unit = Unit.INSTANCE;
            awaitAllNodeArr[r4] = awaitAllNode;
        }
        AwaitAll.DisposeHandlersOnCancel disposeHandlersOnCancel = new AwaitAll.DisposeHandlersOnCancel(awaitAllNodeArr);
        for (int r1 = 0; r1 < length; r1++) {
            AwaitAll.AwaitAllNode awaitAllNode2 = awaitAllNodeArr[r1];
            awaitAllNode2.getClass();
            AwaitAll.AwaitAllNode._disposer$FU.set(awaitAllNode2, disposeHandlersOnCancel);
        }
        if (cancellableContinuationImpl.isCompleted()) {
            disposeHandlersOnCancel.disposeAll();
        } else {
            cancellableContinuationImpl.invokeOnCancellation(disposeHandlersOnCancel);
        }
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }
}
