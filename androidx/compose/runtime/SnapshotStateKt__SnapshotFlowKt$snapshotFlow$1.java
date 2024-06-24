package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.ObserverHandle;
import com.animaconnected.secondo.R;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: SnapshotFlow.kt */
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", l = {133, R.styleable.AppTheme_stepsHistoryColumnTodayColorActivity, R.styleable.AppTheme_styleMarbleText}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function0<Object> $block;
    public /* synthetic */ Object L$0;
    public Set L$1;
    public Function1 L$2;
    public Channel L$3;
    public ObserverHandle L$4;
    public Object L$5;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(Function0<Object> function0, Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1> continuation) {
        super(2, continuation);
        this.$block = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(this.$block, continuation);
        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<Object> flowCollector, Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c6 A[Catch: all -> 0x011b, TryCatch #1 {all -> 0x011b, blocks: (B:11:0x002b, B:13:0x00c0, B:15:0x00c6, B:19:0x00d0, B:22:0x00da, B:27:0x00e0, B:33:0x00f8, B:35:0x0101, B:46:0x0125, B:47:0x0128, B:49:0x00a8, B:55:0x0043, B:63:0x0079, B:69:0x008e, B:79:0x0136, B:80:0x0139, B:29:0x00ed, B:32:0x00f5, B:42:0x0121, B:43:0x0124, B:65:0x0083, B:68:0x008b, B:76:0x0132, B:77:0x0135), top: B:2:0x000a, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e0 A[Catch: all -> 0x011b, TRY_LEAVE, TryCatch #1 {all -> 0x011b, blocks: (B:11:0x002b, B:13:0x00c0, B:15:0x00c6, B:19:0x00d0, B:22:0x00da, B:27:0x00e0, B:33:0x00f8, B:35:0x0101, B:46:0x0125, B:47:0x0128, B:49:0x00a8, B:55:0x0043, B:63:0x0079, B:69:0x008e, B:79:0x0136, B:80:0x0139, B:29:0x00ed, B:32:0x00f5, B:42:0x0121, B:43:0x0124, B:65:0x0083, B:68:0x008b, B:76:0x0132, B:77:0x0135), top: B:2:0x000a, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d9  */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r8v4, types: [kotlinx.coroutines.channels.Channel] */
    /* JADX WARN: Type inference failed for: r8v5, types: [kotlinx.coroutines.channels.Channel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0129 -> B:47:0x00a8). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
