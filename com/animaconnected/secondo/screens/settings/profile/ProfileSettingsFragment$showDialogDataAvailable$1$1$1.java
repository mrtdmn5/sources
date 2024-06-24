package com.animaconnected.secondo.screens.settings.profile;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.animaconnected.secondo.screens.BottomDialog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ProfileSettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.ProfileSettingsFragment$showDialogDataAvailable$1$1$1", f = "ProfileSettingsFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProfileSettingsFragment$showDialogDataAvailable$1$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomDialog $dialog;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ ProfileSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSettingsFragment$showDialogDataAvailable$1$1$1(ProfileSettingsFragment profileSettingsFragment, BottomDialog bottomDialog, String str, Continuation<? super ProfileSettingsFragment$showDialogDataAvailable$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = profileSettingsFragment;
        this.$dialog = bottomDialog;
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileSettingsFragment$showDialogDataAvailable$1$1$1(this.this$0, this.$dialog, this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((ProfileSettingsFragment$showDialogDataAvailable$1$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Intent intent = new Intent("android.intent.action.SEND");
            String str = this.$url;
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str);
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(this.$url));
            Intent createChooser = Intent.createChooser(intent, "Open in...");
            createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{intent2});
            this.this$0.startActivity(createChooser);
            this.$dialog.dismiss();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
