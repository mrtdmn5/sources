package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: DragGestureDetector.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", l = {235, 236, 241}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    public final /* synthetic */ Function0<Unit> $onDragCancel;
    public final /* synthetic */ Function0<Unit> $onDragEnd;
    public final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(Continuation continuation, Function0 function0, Function0 function02, Function1 function1, Function2 function2) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDragEnd = function0;
        this.$onDragCancel = function02;
        this.$onDrag = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(continuation, this.$onDragEnd, this.$onDragCancel, this.$onDragStart, this.$onDrag);
        dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0080 A[Catch: CancellationException -> 0x00ab, TryCatch #0 {CancellationException -> 0x00ab, blocks: (B:8:0x0015, B:9:0x0078, B:11:0x0080, B:13:0x008d, B:15:0x0099, B:17:0x009c, B:20:0x009f, B:24:0x00a5, B:28:0x0025, B:29:0x0053, B:31:0x0057, B:36:0x002d, B:37:0x0044, B:41:0x0039), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a5 A[Catch: CancellationException -> 0x00ab, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x00ab, blocks: (B:8:0x0015, B:9:0x0078, B:11:0x0080, B:13:0x008d, B:15:0x0099, B:17:0x009c, B:20:0x009f, B:24:0x00a5, B:28:0x0025, B:29:0x0053, B:31:0x0057, B:36:0x002d, B:37:0x0044, B:41:0x0039), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057 A[Catch: CancellationException -> 0x00ab, TryCatch #0 {CancellationException -> 0x00ab, blocks: (B:8:0x0015, B:9:0x0078, B:11:0x0080, B:13:0x008d, B:15:0x0099, B:17:0x009c, B:20:0x009f, B:24:0x00a5, B:28:0x0025, B:29:0x0053, B:31:0x0057, B:36:0x002d, B:37:0x0044, B:41:0x0039), top: B:2:0x0009 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r8.label
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r8.$onDragCancel
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L31
            if (r1 == r5) goto L29
            if (r1 == r4) goto L21
            if (r1 != r3) goto L19
            java.lang.Object r0 = r8.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r0 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.util.concurrent.CancellationException -> Lab
            goto L78
        L19:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L21:
            java.lang.Object r1 = r8.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.util.concurrent.CancellationException -> Lab
            goto L53
        L29:
            java.lang.Object r1 = r8.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.util.concurrent.CancellationException -> Lab
            goto L44
        L31:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            r1 = r9
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            r8.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> Lab
            r8.label = r5     // Catch: java.util.concurrent.CancellationException -> Lab
            java.lang.Object r9 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r1, r8, r4)     // Catch: java.util.concurrent.CancellationException -> Lab
            if (r9 != r0) goto L44
            return r0
        L44:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9     // Catch: java.util.concurrent.CancellationException -> Lab
            long r5 = r9.id     // Catch: java.util.concurrent.CancellationException -> Lab
            r8.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> Lab
            r8.label = r4     // Catch: java.util.concurrent.CancellationException -> Lab
            java.lang.Object r9 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m36awaitLongPressOrCancellationrnUCldI(r1, r5, r8)     // Catch: java.util.concurrent.CancellationException -> Lab
            if (r9 != r0) goto L53
            return r0
        L53:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9     // Catch: java.util.concurrent.CancellationException -> Lab
            if (r9 == 0) goto La8
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r8.$onDragStart     // Catch: java.util.concurrent.CancellationException -> Lab
            long r5 = r9.position     // Catch: java.util.concurrent.CancellationException -> Lab
            androidx.compose.ui.geometry.Offset r7 = new androidx.compose.ui.geometry.Offset     // Catch: java.util.concurrent.CancellationException -> Lab
            r7.<init>(r5)     // Catch: java.util.concurrent.CancellationException -> Lab
            r4.invoke(r7)     // Catch: java.util.concurrent.CancellationException -> Lab
            long r4 = r9.id     // Catch: java.util.concurrent.CancellationException -> Lab
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1 r9 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1     // Catch: java.util.concurrent.CancellationException -> Lab
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r6 = r8.$onDrag     // Catch: java.util.concurrent.CancellationException -> Lab
            r9.<init>()     // Catch: java.util.concurrent.CancellationException -> Lab
            r8.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> Lab
            r8.label = r3     // Catch: java.util.concurrent.CancellationException -> Lab
            java.lang.Object r9 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m37dragjO51t88(r1, r4, r9, r8)     // Catch: java.util.concurrent.CancellationException -> Lab
            if (r9 != r0) goto L77
            return r0
        L77:
            r0 = r1
        L78:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.util.concurrent.CancellationException -> Lab
            boolean r9 = r9.booleanValue()     // Catch: java.util.concurrent.CancellationException -> Lab
            if (r9 == 0) goto La5
            androidx.compose.ui.input.pointer.PointerEvent r9 = r0.getCurrentEvent()     // Catch: java.util.concurrent.CancellationException -> Lab
            java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r9 = r9.changes     // Catch: java.util.concurrent.CancellationException -> Lab
            int r0 = r9.size()     // Catch: java.util.concurrent.CancellationException -> Lab
            r1 = 0
        L8b:
            if (r1 >= r0) goto L9f
            java.lang.Object r3 = r9.get(r1)     // Catch: java.util.concurrent.CancellationException -> Lab
            androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3     // Catch: java.util.concurrent.CancellationException -> Lab
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r3)     // Catch: java.util.concurrent.CancellationException -> Lab
            if (r4 == 0) goto L9c
            r3.consume()     // Catch: java.util.concurrent.CancellationException -> Lab
        L9c:
            int r1 = r1 + 1
            goto L8b
        L9f:
            kotlin.jvm.functions.Function0<kotlin.Unit> r9 = r8.$onDragEnd     // Catch: java.util.concurrent.CancellationException -> Lab
            r9.invoke()     // Catch: java.util.concurrent.CancellationException -> Lab
            goto La8
        La5:
            r2.invoke()     // Catch: java.util.concurrent.CancellationException -> Lab
        La8:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        Lab:
            r9 = move-exception
            r2.invoke()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
