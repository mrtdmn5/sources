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
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.ProfileSettingsFragment$showDialogDataAvailable$1$1$2", f = "ProfileSettingsFragment.kt", l = {215}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProfileSettingsFragment$showDialogDataAvailable$1$1$2 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomDialog $dialog;
    int label;
    final /* synthetic */ ProfileSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSettingsFragment$showDialogDataAvailable$1$1$2(BottomDialog bottomDialog, ProfileSettingsFragment profileSettingsFragment, Continuation<? super ProfileSettingsFragment$showDialogDataAvailable$1$1$2> continuation) {
        super(2, continuation);
        this.$dialog = bottomDialog;
        this.this$0 = profileSettingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileSettingsFragment$showDialogDataAvailable$1$1$2(this.$dialog, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((ProfileSettingsFragment$showDialogDataAvailable$1$1$2) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
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
            this.$dialog.dismiss();
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
        return Unit.INSTANCE;
    }
}
