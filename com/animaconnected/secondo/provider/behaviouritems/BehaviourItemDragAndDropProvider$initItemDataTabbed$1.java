package com.animaconnected.secondo.provider.behaviouritems;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BehaviourItemDragAndDropProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.behaviouritems.BehaviourItemDragAndDropProvider", f = "BehaviourItemDragAndDropProvider.kt", l = {R.styleable.AppTheme_themeBackgroundColor, R.styleable.AppTheme_themeBackgroundResource, 180, 182}, m = "initItemDataTabbed")
/* loaded from: classes3.dex */
public final class BehaviourItemDragAndDropProvider$initItemDataTabbed$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BehaviourItemDragAndDropProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BehaviourItemDragAndDropProvider$initItemDataTabbed$1(BehaviourItemDragAndDropProvider behaviourItemDragAndDropProvider, Continuation<? super BehaviourItemDragAndDropProvider$initItemDataTabbed$1> continuation) {
        super(continuation);
        this.this$0 = behaviourItemDragAndDropProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object initItemDataTabbed;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        initItemDataTabbed = this.this$0.initItemDataTabbed(this);
        return initItemDataTabbed;
    }
}
