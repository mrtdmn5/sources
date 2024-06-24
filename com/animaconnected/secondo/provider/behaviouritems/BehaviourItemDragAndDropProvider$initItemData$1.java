package com.animaconnected.secondo.provider.behaviouritems;

import com.animaconnected.secondo.R;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BehaviourItemDragAndDropProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.behaviouritems.BehaviourItemDragAndDropProvider$initItemData$1", f = "BehaviourItemDragAndDropProvider.kt", l = {113, 124, R.styleable.AppTheme_statusTextH5, R.styleable.AppTheme_statusTopStripeSetup, 133}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BehaviourItemDragAndDropProvider$initItemData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ BehaviourItemDragAndDropProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BehaviourItemDragAndDropProvider$initItemData$1(BehaviourItemDragAndDropProvider behaviourItemDragAndDropProvider, Continuation<? super BehaviourItemDragAndDropProvider$initItemData$1> continuation) {
        super(2, continuation);
        this.this$0 = behaviourItemDragAndDropProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BehaviourItemDragAndDropProvider$initItemData$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x026a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x020e -> B:12:0x024b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0233 -> B:9:0x0236). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.behaviouritems.BehaviourItemDragAndDropProvider$initItemData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BehaviourItemDragAndDropProvider$initItemData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
