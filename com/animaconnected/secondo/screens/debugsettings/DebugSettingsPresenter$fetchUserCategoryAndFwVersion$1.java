package com.animaconnected.secondo.screens.debugsettings;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DebugSettingsPresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter", f = "DebugSettingsPresenter.kt", l = {R.styleable.AppTheme_themeBackgroundColor, R.styleable.AppTheme_toolbarTitleTextStyle}, m = "fetchUserCategoryAndFwVersion")
/* loaded from: classes3.dex */
public final class DebugSettingsPresenter$fetchUserCategoryAndFwVersion$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebugSettingsPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugSettingsPresenter$fetchUserCategoryAndFwVersion$1(DebugSettingsPresenter debugSettingsPresenter, Continuation<? super DebugSettingsPresenter$fetchUserCategoryAndFwVersion$1> continuation) {
        super(continuation);
        this.this$0 = debugSettingsPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchUserCategoryAndFwVersion;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchUserCategoryAndFwVersion = this.this$0.fetchUserCategoryAndFwVersion(this);
        return fetchUserCategoryAndFwVersion;
    }
}
