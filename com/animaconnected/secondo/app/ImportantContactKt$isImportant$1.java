package com.animaconnected.secondo.app;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ImportantContact.kt */
@DebugMetadata(c = "com.animaconnected.secondo.app.ImportantContactKt", f = "ImportantContact.kt", l = {99}, m = "isImportant")
/* loaded from: classes.dex */
public final class ImportantContactKt$isImportant$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public ImportantContactKt$isImportant$1(Continuation<? super ImportantContactKt$isImportant$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ImportantContactKt.isImportant(null, this);
    }
}
