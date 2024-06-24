package com.animaconnected.watch.account.profile;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ProfileProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.profile.ProfileProvider", f = "ProfileProvider.kt", l = {R.styleable.AppTheme_stepsHistoryFontDetail, R.styleable.AppTheme_stepsHistoryGoalLegendColorActivity}, m = "saveAndSyncConfig")
/* loaded from: classes3.dex */
public final class ProfileProvider$saveAndSyncConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProfileProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileProvider$saveAndSyncConfig$1(ProfileProvider profileProvider, Continuation<? super ProfileProvider$saveAndSyncConfig$1> continuation) {
        super(continuation);
        this.this$0 = profileProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.saveAndSyncConfig(null, this);
    }
}
