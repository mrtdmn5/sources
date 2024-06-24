package com.animaconnected.secondo.screens.settings.profile;

import android.view.View;
import com.animaconnected.secondo.screens.BottomDialog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileSettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.ProfileSettingsFragment$showDialogStartDownload$1$1$1", f = "ProfileSettingsFragment.kt", l = {183}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProfileSettingsFragment$showDialogStartDownload$1$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomDialog $dialog;
    int label;
    final /* synthetic */ ProfileSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSettingsFragment$showDialogStartDownload$1$1$1(ProfileSettingsFragment profileSettingsFragment, BottomDialog bottomDialog, Continuation<? super ProfileSettingsFragment$showDialogStartDownload$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = profileSettingsFragment;
        this.$dialog = bottomDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileSettingsFragment$showDialogStartDownload$1$1$1(this.this$0, this.$dialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((ProfileSettingsFragment$showDialogStartDownload$1$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DownloadDataViewModel downloadDataViewModel;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            downloadDataViewModel = this.this$0.downloadDataViewModel;
            if (downloadDataViewModel != null) {
                this.label = 1;
                if (downloadDataViewModel.sendRequest(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("downloadDataViewModel");
                throw null;
            }
        }
        this.$dialog.dismiss();
        return Unit.INSTANCE;
    }
}
