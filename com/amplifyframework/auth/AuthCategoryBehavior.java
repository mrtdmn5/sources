package com.amplifyframework.auth;

import android.app.Activity;
import android.content.Intent;
import com.amplifyframework.auth.options.AuthConfirmResetPasswordOptions;
import com.amplifyframework.auth.options.AuthConfirmSignInOptions;
import com.amplifyframework.auth.options.AuthConfirmSignUpOptions;
import com.amplifyframework.auth.options.AuthFetchSessionOptions;
import com.amplifyframework.auth.options.AuthResendSignUpCodeOptions;
import com.amplifyframework.auth.options.AuthResendUserAttributeConfirmationCodeOptions;
import com.amplifyframework.auth.options.AuthResetPasswordOptions;
import com.amplifyframework.auth.options.AuthSignInOptions;
import com.amplifyframework.auth.options.AuthSignOutOptions;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.auth.options.AuthUpdateUserAttributeOptions;
import com.amplifyframework.auth.options.AuthUpdateUserAttributesOptions;
import com.amplifyframework.auth.options.AuthWebUISignInOptions;
import com.amplifyframework.auth.result.AuthResetPasswordResult;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.auth.result.AuthSignOutResult;
import com.amplifyframework.auth.result.AuthSignUpResult;
import com.amplifyframework.auth.result.AuthUpdateAttributeResult;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface AuthCategoryBehavior {
    void confirmResetPassword(String str, String str2, String str3, AuthConfirmResetPasswordOptions authConfirmResetPasswordOptions, Action action, Consumer<AuthException> consumer);

    void confirmResetPassword(String str, String str2, String str3, Action action, Consumer<AuthException> consumer);

    void confirmSignIn(String str, AuthConfirmSignInOptions authConfirmSignInOptions, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2);

    void confirmSignIn(String str, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2);

    void confirmSignUp(String str, String str2, AuthConfirmSignUpOptions authConfirmSignUpOptions, Consumer<AuthSignUpResult> consumer, Consumer<AuthException> consumer2);

    void confirmSignUp(String str, String str2, Consumer<AuthSignUpResult> consumer, Consumer<AuthException> consumer2);

    void confirmUserAttribute(AuthUserAttributeKey authUserAttributeKey, String str, Action action, Consumer<AuthException> consumer);

    void deleteUser(Action action, Consumer<AuthException> consumer);

    void fetchAuthSession(AuthFetchSessionOptions authFetchSessionOptions, Consumer<AuthSession> consumer, Consumer<AuthException> consumer2);

    void fetchAuthSession(Consumer<AuthSession> consumer, Consumer<AuthException> consumer2);

    void fetchDevices(Consumer<List<AuthDevice>> consumer, Consumer<AuthException> consumer2);

    void fetchUserAttributes(Consumer<List<AuthUserAttribute>> consumer, Consumer<AuthException> consumer2);

    void forgetDevice(AuthDevice authDevice, Action action, Consumer<AuthException> consumer);

    void forgetDevice(Action action, Consumer<AuthException> consumer);

    void getCurrentUser(Consumer<AuthUser> consumer, Consumer<AuthException> consumer2);

    void handleWebUISignInResponse(Intent intent);

    void rememberDevice(Action action, Consumer<AuthException> consumer);

    void resendSignUpCode(String str, AuthResendSignUpCodeOptions authResendSignUpCodeOptions, Consumer<AuthCodeDeliveryDetails> consumer, Consumer<AuthException> consumer2);

    void resendSignUpCode(String str, Consumer<AuthCodeDeliveryDetails> consumer, Consumer<AuthException> consumer2);

    void resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, AuthResendUserAttributeConfirmationCodeOptions authResendUserAttributeConfirmationCodeOptions, Consumer<AuthCodeDeliveryDetails> consumer, Consumer<AuthException> consumer2);

    void resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, Consumer<AuthCodeDeliveryDetails> consumer, Consumer<AuthException> consumer2);

    void resetPassword(String str, AuthResetPasswordOptions authResetPasswordOptions, Consumer<AuthResetPasswordResult> consumer, Consumer<AuthException> consumer2);

    void resetPassword(String str, Consumer<AuthResetPasswordResult> consumer, Consumer<AuthException> consumer2);

    void signIn(String str, String str2, AuthSignInOptions authSignInOptions, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2);

    void signIn(String str, String str2, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2);

    void signInWithSocialWebUI(AuthProvider authProvider, Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2);

    void signInWithSocialWebUI(AuthProvider authProvider, Activity activity, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2);

    void signInWithWebUI(Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2);

    void signInWithWebUI(Activity activity, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2);

    void signOut(AuthSignOutOptions authSignOutOptions, Consumer<AuthSignOutResult> consumer);

    void signOut(Consumer<AuthSignOutResult> consumer);

    void signUp(String str, String str2, AuthSignUpOptions authSignUpOptions, Consumer<AuthSignUpResult> consumer, Consumer<AuthException> consumer2);

    void updatePassword(String str, String str2, Action action, Consumer<AuthException> consumer);

    void updateUserAttribute(AuthUserAttribute authUserAttribute, AuthUpdateUserAttributeOptions authUpdateUserAttributeOptions, Consumer<AuthUpdateAttributeResult> consumer, Consumer<AuthException> consumer2);

    void updateUserAttribute(AuthUserAttribute authUserAttribute, Consumer<AuthUpdateAttributeResult> consumer, Consumer<AuthException> consumer2);

    void updateUserAttributes(List<AuthUserAttribute> list, AuthUpdateUserAttributesOptions authUpdateUserAttributesOptions, Consumer<Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> consumer, Consumer<AuthException> consumer2);

    void updateUserAttributes(List<AuthUserAttribute> list, Consumer<Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> consumer, Consumer<AuthException> consumer2);
}
