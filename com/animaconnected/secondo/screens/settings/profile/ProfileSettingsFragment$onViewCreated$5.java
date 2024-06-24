package com.animaconnected.secondo.screens.settings.profile;

import android.view.View;
import com.animaconnected.secondo.screens.settings.profile.DownloadDataViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileSettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.ProfileSettingsFragment$onViewCreated$5", f = "ProfileSettingsFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProfileSettingsFragment$onViewCreated$5 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ProfileSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSettingsFragment$onViewCreated$5(ProfileSettingsFragment profileSettingsFragment, Continuation<? super ProfileSettingsFragment$onViewCreated$5> continuation) {
        super(2, continuation);
        this.this$0 = profileSettingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileSettingsFragment$onViewCreated$5(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((ProfileSettingsFragment$onViewCreated$5) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DownloadDataViewModel downloadDataViewModel;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            downloadDataViewModel = this.this$0.downloadDataViewModel;
            if (downloadDataViewModel != null) {
                DownloadDataViewModel.AccountDownloadState value = downloadDataViewModel.getState().getValue();
                if (value instanceof DownloadDataViewModel.AccountDownloadState.DataAvailable) {
                    this.this$0.showDialogDataAvailable(((DownloadDataViewModel.AccountDownloadState.DataAvailable) value).getUrl());
                } else {
                    this.this$0.showDialogStartDownload();
                }
                return Unit.INSTANCE;
            }
            Intrinsics.throwUninitializedPropertyAccessException("downloadDataViewModel");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
