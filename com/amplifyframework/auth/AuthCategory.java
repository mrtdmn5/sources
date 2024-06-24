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
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class AuthCategory extends Category<AuthPlugin<?>> implements AuthCategoryBehavior {
    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmResetPassword(String str, String str2, String str3, AuthConfirmResetPasswordOptions authConfirmResetPasswordOptions, Action action, Consumer<AuthException> consumer) {
        getSelectedPlugin().confirmResetPassword(str, str2, str3, authConfirmResetPasswordOptions, action, consumer);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmSignIn(String str, AuthConfirmSignInOptions authConfirmSignInOptions, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().confirmSignIn(str, authConfirmSignInOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmSignUp(String str, String str2, AuthConfirmSignUpOptions authConfirmSignUpOptions, Consumer<AuthSignUpResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().confirmSignUp(str, str2, authConfirmSignUpOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmUserAttribute(AuthUserAttributeKey authUserAttributeKey, String str, Action action, Consumer<AuthException> consumer) {
        getSelectedPlugin().confirmUserAttribute(authUserAttributeKey, str, action, consumer);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void deleteUser(Action action, Consumer<AuthException> consumer) {
        getSelectedPlugin().deleteUser(action, consumer);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void fetchAuthSession(AuthFetchSessionOptions authFetchSessionOptions, Consumer<AuthSession> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().fetchAuthSession(authFetchSessionOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void fetchDevices(Consumer<List<AuthDevice>> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().fetchDevices(consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void fetchUserAttributes(Consumer<List<AuthUserAttribute>> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().fetchUserAttributes(consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void forgetDevice(Action action, Consumer<AuthException> consumer) {
        getSelectedPlugin().forgetDevice(action, consumer);
    }

    @Override // com.amplifyframework.core.category.CategoryTypeable
    public CategoryType getCategoryType() {
        return CategoryType.AUTH;
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void getCurrentUser(Consumer<AuthUser> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().getCurrentUser(consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void handleWebUISignInResponse(Intent intent) {
        getSelectedPlugin().handleWebUISignInResponse(intent);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void rememberDevice(Action action, Consumer<AuthException> consumer) {
        getSelectedPlugin().rememberDevice(action, consumer);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void resendSignUpCode(String str, AuthResendSignUpCodeOptions authResendSignUpCodeOptions, Consumer<AuthCodeDeliveryDetails> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().resendSignUpCode(str, authResendSignUpCodeOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, AuthResendUserAttributeConfirmationCodeOptions authResendUserAttributeConfirmationCodeOptions, Consumer<AuthCodeDeliveryDetails> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().resendUserAttributeConfirmationCode(authUserAttributeKey, authResendUserAttributeConfirmationCodeOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void resetPassword(String str, AuthResetPasswordOptions authResetPasswordOptions, Consumer<AuthResetPasswordResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().resetPassword(str, authResetPasswordOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signIn(String str, String str2, AuthSignInOptions authSignInOptions, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().signIn(str, str2, authSignInOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signInWithSocialWebUI(AuthProvider authProvider, Activity activity, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().signInWithSocialWebUI(authProvider, activity, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signInWithWebUI(Activity activity, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().signInWithWebUI(activity, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signOut(Consumer<AuthSignOutResult> consumer) {
        getSelectedPlugin().signOut(consumer);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signUp(String str, String str2, AuthSignUpOptions authSignUpOptions, Consumer<AuthSignUpResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().signUp(str, str2, authSignUpOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void updatePassword(String str, String str2, Action action, Consumer<AuthException> consumer) {
        getSelectedPlugin().updatePassword(str, str2, action, consumer);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void updateUserAttribute(AuthUserAttribute authUserAttribute, AuthUpdateUserAttributeOptions authUpdateUserAttributeOptions, Consumer<AuthUpdateAttributeResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().updateUserAttribute(authUserAttribute, authUpdateUserAttributeOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void updateUserAttributes(List<AuthUserAttribute> list, AuthUpdateUserAttributesOptions authUpdateUserAttributesOptions, Consumer<Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().updateUserAttributes(list, authUpdateUserAttributesOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmResetPassword(String str, String str2, String str3, Action action, Consumer<AuthException> consumer) {
        getSelectedPlugin().confirmResetPassword(str, str2, str3, action, consumer);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmSignIn(String str, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().confirmSignIn(str, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void confirmSignUp(String str, String str2, Consumer<AuthSignUpResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().confirmSignUp(str, str2, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void fetchAuthSession(Consumer<AuthSession> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().fetchAuthSession(consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void forgetDevice(AuthDevice authDevice, Action action, Consumer<AuthException> consumer) {
        getSelectedPlugin().forgetDevice(authDevice, action, consumer);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void resendSignUpCode(String str, Consumer<AuthCodeDeliveryDetails> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().resendSignUpCode(str, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, Consumer<AuthCodeDeliveryDetails> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().resendUserAttributeConfirmationCode(authUserAttributeKey, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void resetPassword(String str, Consumer<AuthResetPasswordResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().resetPassword(str, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signIn(String str, String str2, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().signIn(str, str2, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signInWithSocialWebUI(AuthProvider authProvider, Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().signInWithSocialWebUI(authProvider, activity, authWebUISignInOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signInWithWebUI(Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Consumer<AuthSignInResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().signInWithWebUI(activity, authWebUISignInOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void signOut(AuthSignOutOptions authSignOutOptions, Consumer<AuthSignOutResult> consumer) {
        getSelectedPlugin().signOut(authSignOutOptions, consumer);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void updateUserAttribute(AuthUserAttribute authUserAttribute, Consumer<AuthUpdateAttributeResult> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().updateUserAttribute(authUserAttribute, consumer, consumer2);
    }

    @Override // com.amplifyframework.auth.AuthCategoryBehavior
    public void updateUserAttributes(List<AuthUserAttribute> list, Consumer<Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> consumer, Consumer<AuthException> consumer2) {
        getSelectedPlugin().updateUserAttributes(list, consumer, consumer2);
    }
}
