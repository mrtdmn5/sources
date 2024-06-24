package com.animaconnected.watch.account.profile;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ProfileProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.profile.ProfileProvider", f = "ProfileProvider.kt", l = {R.styleable.AppTheme_subComplicationDropZoneSelected}, m = "fetchToken")
/* loaded from: classes3.dex */
public final class ProfileProvider$fetchToken$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProfileProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileProvider$fetchToken$1(ProfileProvider profileProvider, Continuation<? super ProfileProvider$fetchToken$1> continuation) {
        super(continuation);
        this.this$0 = profileProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchToken;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchToken = this.this$0.fetchToken(this);
        return fetchToken;
    }
}
