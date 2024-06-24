package com.animaconnected.secondo.utils;

import com.amplifyframework.auth.result.step.AuthNextSignUpStep;
import com.amplifyframework.auth.result.step.AuthSignUpStep;
import com.animaconnected.secondo.provider.ProviderFactory;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: AmplifyApi.kt */
/* loaded from: classes3.dex */
public final class AmplifyApiKt {
    public static final /* synthetic */ boolean access$accountExist(Exception exc) {
        return accountExist(exc);
    }

    public static final boolean accountExist(Exception exc) {
        String message = exc.getMessage();
        if (message != null) {
            return StringsKt__StringsKt.contains(message, "PreSignUp failed with error User already exists", true);
        }
        return false;
    }

    public static final boolean isConfirmSignUp(AuthNextSignUpStep authNextSignUpStep) {
        Intrinsics.checkNotNullParameter(authNextSignUpStep, "<this>");
        if (authNextSignUpStep.getSignUpStep() == AuthSignUpStep.CONFIRM_SIGN_UP_STEP) {
            return true;
        }
        return false;
    }

    public static final boolean isDone(AuthNextSignUpStep authNextSignUpStep) {
        Intrinsics.checkNotNullParameter(authNextSignUpStep, "<this>");
        if (authNextSignUpStep.getSignUpStep() == AuthSignUpStep.DONE) {
            return true;
        }
        return false;
    }

    public static final boolean isSignInUiEnabled() {
        return ProviderFactory.getWatch().getWatchManager().getCurrentWatch().getHasDisplay();
    }
}
