package com.animaconnected.secondo.screens.debugsettings;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MsgPackFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.MsgPackFragment", f = "MsgPackFragment.kt", l = {R.styleable.AppTheme_themeGradientOpacity}, m = "write")
/* loaded from: classes3.dex */
public final class MsgPackFragment$write$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MsgPackFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPackFragment$write$1(MsgPackFragment msgPackFragment, Continuation<? super MsgPackFragment$write$1> continuation) {
        super(continuation);
        this.this$0 = msgPackFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object write;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        write = this.this$0.write(null, null, this);
        return write;
    }
}
