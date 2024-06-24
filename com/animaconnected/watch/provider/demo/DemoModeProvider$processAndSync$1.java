package com.animaconnected.watch.provider.demo;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DemoModeProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.demo.DemoModeProvider", f = "DemoModeProvider.kt", l = {R.styleable.AppTheme_topPusherDropZoneSelected, 183, 191}, m = "processAndSync")
/* loaded from: classes3.dex */
public final class DemoModeProvider$processAndSync$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DemoModeProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DemoModeProvider$processAndSync$1(DemoModeProvider demoModeProvider, Continuation<? super DemoModeProvider$processAndSync$1> continuation) {
        super(continuation);
        this.this$0 = demoModeProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object processAndSync;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        processAndSync = this.this$0.processAndSync(this);
        return processAndSync;
    }
}
