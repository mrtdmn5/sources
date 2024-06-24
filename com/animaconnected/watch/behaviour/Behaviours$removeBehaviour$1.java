package com.animaconnected.watch.behaviour;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Behaviours.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.Behaviours", f = "Behaviours.kt", l = {R.styleable.AppTheme_themeGradientOpacity, R.styleable.AppTheme_themeShadowOpacity}, m = "removeBehaviour")
/* loaded from: classes3.dex */
public final class Behaviours$removeBehaviour$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Behaviours this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Behaviours$removeBehaviour$1(Behaviours behaviours, Continuation<? super Behaviours$removeBehaviour$1> continuation) {
        super(continuation);
        this.this$0 = behaviours;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object removeBehaviour;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        removeBehaviour = this.this$0.removeBehaviour(null, this);
        return removeBehaviour;
    }
}
