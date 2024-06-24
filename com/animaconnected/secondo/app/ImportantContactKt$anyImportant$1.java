package com.animaconnected.secondo.app;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ImportantContact.kt */
@DebugMetadata(c = "com.animaconnected.secondo.app.ImportantContactKt", f = "ImportantContact.kt", l = {93}, m = "anyImportant")
/* loaded from: classes.dex */
public final class ImportantContactKt$anyImportant$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public ImportantContactKt$anyImportant$1(Continuation<? super ImportantContactKt$anyImportant$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object anyImportant;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        anyImportant = ImportantContactKt.anyImportant(null, this);
        return anyImportant;
    }
}
