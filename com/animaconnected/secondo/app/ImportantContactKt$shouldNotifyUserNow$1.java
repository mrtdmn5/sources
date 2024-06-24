package com.animaconnected.secondo.app;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ImportantContact.kt */
@DebugMetadata(c = "com.animaconnected.secondo.app.ImportantContactKt", f = "ImportantContact.kt", l = {79, 80, 81, 82}, m = "shouldNotifyUserNow")
/* loaded from: classes.dex */
public final class ImportantContactKt$shouldNotifyUserNow$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public ImportantContactKt$shouldNotifyUserNow$1(Continuation<? super ImportantContactKt$shouldNotifyUserNow$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object shouldNotifyUserNow;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        shouldNotifyUserNow = ImportantContactKt.shouldNotifyUserNow(null, null, this);
        return shouldNotifyUserNow;
    }
}
