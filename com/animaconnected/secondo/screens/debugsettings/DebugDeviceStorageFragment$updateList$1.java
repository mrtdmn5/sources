package com.animaconnected.secondo.screens.debugsettings;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DebugDeviceStorageFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment", f = "DebugDeviceStorageFragment.kt", l = {98, 99}, m = "updateList")
/* loaded from: classes3.dex */
public final class DebugDeviceStorageFragment$updateList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebugDeviceStorageFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugDeviceStorageFragment$updateList$1(DebugDeviceStorageFragment debugDeviceStorageFragment, Continuation<? super DebugDeviceStorageFragment$updateList$1> continuation) {
        super(continuation);
        this.this$0 = debugDeviceStorageFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object updateList;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateList = this.this$0.updateList(this);
        return updateList;
    }
}
