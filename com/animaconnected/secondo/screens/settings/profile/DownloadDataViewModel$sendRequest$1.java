package com.animaconnected.secondo.screens.settings.profile;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ProfileSettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.DownloadDataViewModel", f = "ProfileSettingsFragment.kt", l = {261}, m = "sendRequest")
/* loaded from: classes3.dex */
public final class DownloadDataViewModel$sendRequest$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadDataViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadDataViewModel$sendRequest$1(DownloadDataViewModel downloadDataViewModel, Continuation<? super DownloadDataViewModel$sendRequest$1> continuation) {
        super(continuation);
        this.this$0 = downloadDataViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendRequest(this);
    }
}
