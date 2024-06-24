package com.animaconnected.watch.account.strava;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StravaClient.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.strava.StravaClient", f = "StravaClient.kt", l = {R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail}, m = "onUploadError")
/* loaded from: classes3.dex */
public final class StravaClient$onUploadError$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StravaClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StravaClient$onUploadError$1(StravaClient stravaClient, Continuation<? super StravaClient$onUploadError$1> continuation) {
        super(continuation);
        this.this$0 = stravaClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object onUploadError;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        onUploadError = this.this$0.onUploadError(null, null, this);
        return onUploadError;
    }
}
