package com.animaconnected.secondo.screens.activity;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.googlefit.GoogleFitProvider;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.DialogMessageKt;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import com.animaconnected.secondo.utils.ViewKt;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityUtil.kt */
/* loaded from: classes3.dex */
public final class ActivityUtilKt {
    public static final void enableGoogleFitAndPresentErrors(final BaseFragment baseFragment, final GoogleFitProvider googleFitProvider, final Function1<? super Boolean, Unit> onCompleted) {
        Intrinsics.checkNotNullParameter(baseFragment, "<this>");
        Intrinsics.checkNotNullParameter(googleFitProvider, "googleFitProvider");
        Intrinsics.checkNotNullParameter(onCompleted, "onCompleted");
        if (ProviderFactory.INSTANCE.getGoogleFitProvider().enableGoogleFit(baseFragment.getActivityLauncher(), new Function1<ActivityResult, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityUtilKt$enableGoogleFitAndPresentErrors$alreadyDone$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActivityResult activityResult) {
                invoke2(activityResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ActivityResult result) {
                GoogleSignInResult googleSignInResult;
                zzw forException;
                GoogleSignInAccount googleSignInAccount;
                Intrinsics.checkNotNullParameter(result, "result");
                Intent intent = result.mData;
                Logger logger = zbm.zba;
                if (intent == null) {
                    googleSignInResult = new GoogleSignInResult(null, Status.RESULT_INTERNAL_ERROR);
                } else {
                    Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
                    GoogleSignInAccount googleSignInAccount2 = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
                    if (googleSignInAccount2 == null) {
                        if (status == null) {
                            status = Status.RESULT_INTERNAL_ERROR;
                        }
                        googleSignInResult = new GoogleSignInResult(null, status);
                    } else {
                        googleSignInResult = new GoogleSignInResult(googleSignInAccount2, Status.RESULT_SUCCESS);
                    }
                }
                Status status2 = googleSignInResult.zba;
                if (status2.isSuccess() && (googleSignInAccount = googleSignInResult.zbb) != null) {
                    forException = Tasks.forResult(googleSignInAccount);
                } else {
                    forException = Tasks.forException(ApiExceptionUtil.fromStatus(status2));
                }
                Exception exception = forException.getException();
                ApiException apiException = exception instanceof ApiException ? (ApiException) exception : null;
                Integer valueOf = apiException != null ? Integer.valueOf(apiException.mStatus.zzc) : null;
                boolean z = forException.zzd || (valueOf != null && valueOf.intValue() == 12501);
                boolean z2 = valueOf != null && valueOf.intValue() == 7;
                if (forException.isComplete()) {
                    if (forException.isSuccessful()) {
                        GoogleFitProvider.this.updateUiState();
                        ProviderFactory.getAppAnalytics().sendAction("google_fit_enabled");
                    } else if (z) {
                        BaseFragment baseFragment2 = baseFragment;
                        String string = baseFragment2.getString(R.string.activity_activate_google_fit_fail_toast);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        ViewKt.toast$default((Fragment) baseFragment2, string, false, 2, (Object) null);
                    } else if (z2) {
                        Context requireContext = baseFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                        AccountUtilsKt.showDialogInfo$default(requireContext, DialogMessageKt.getDialogInfo(DialogMessage.NoInternetConnection.INSTANCE), null, 4, null);
                    } else {
                        Context requireContext2 = baseFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                        AccountUtilsKt.showDialogInfo$default(requireContext2, DialogMessageKt.getDialogInfo(DialogMessage.Generic.INSTANCE), null, 4, null);
                    }
                    onCompleted.invoke(Boolean.valueOf(forException.isSuccessful()));
                }
            }
        })) {
            onCompleted.invoke(Boolean.TRUE);
        }
    }
}
