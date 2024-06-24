package com.animaconnected.secondo.screens.workout.utils;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GoogleMapsGenerator.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.utils.GoogleMapBuilder", f = "GoogleMapsGenerator.kt", l = {R.styleable.AppTheme_topPusherDropZoneSelected}, m = "makeUrl")
/* loaded from: classes3.dex */
public final class GoogleMapBuilder$makeUrl$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GoogleMapBuilder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleMapBuilder$makeUrl$1(GoogleMapBuilder googleMapBuilder, Continuation<? super GoogleMapBuilder$makeUrl$1> continuation) {
        super(continuation);
        this.this$0 = googleMapBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.makeUrl(this);
    }
}
