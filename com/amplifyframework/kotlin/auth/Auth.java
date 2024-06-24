package com.amplifyframework.kotlin.auth;

import android.app.Activity;
import android.content.Intent;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;
import com.amplifyframework.auth.AuthDevice;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthProvider;
import com.amplifyframework.auth.AuthSession;
import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
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
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Auth.kt */
/* loaded from: classes.dex */
public interface Auth {

    /* compiled from: Auth.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object confirmResetPassword$default(Auth auth, String str, String str2, String str3, AuthConfirmResetPasswordOptions authConfirmResetPasswordOptions, Continuation continuation, int r12, Object obj) throws AuthException {
            if (obj == null) {
                if ((r12 & 8) != 0) {
                    authConfirmResetPasswordOptions = AuthConfirmResetPasswordOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(authConfirmResetPasswordOptions, "defaults()");
                }
                return auth.confirmResetPassword(str, str2, str3, authConfirmResetPasswordOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: confirmResetPassword");
        }

        public static /* synthetic */ Object confirmSignIn$default(Auth auth, String str, AuthConfirmSignInOptions authConfirmSignInOptions, Continuation continuation, int r4, Object obj) throws AuthException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    authConfirmSignInOptions = AuthConfirmSignInOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(authConfirmSignInOptions, "defaults()");
                }
                return auth.confirmSignIn(str, authConfirmSignInOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: confirmSignIn");
        }

        public static /* synthetic */ Object confirmSignUp$default(Auth auth, String str, String str2, AuthConfirmSignUpOptions authConfirmSignUpOptions, Continuation continuation, int r5, Object obj) throws AuthException {
            if (obj == null) {
                if ((r5 & 4) != 0) {
                    authConfirmSignUpOptions = AuthConfirmSignUpOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(authConfirmSignUpOptions, "defaults()");
                }
                return auth.confirmSignUp(str, str2, authConfirmSignUpOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: confirmSignUp");
        }

        public static /* synthetic */ Object fetchAuthSession$default(Auth auth, AuthFetchSessionOptions authFetchSessionOptions, Continuation continuation, int r3, Object obj) throws AuthException {
            if (obj == null) {
                if ((r3 & 1) != 0) {
                    authFetchSessionOptions = AuthFetchSessionOptions.Companion.defaults();
                }
                return auth.fetchAuthSession(authFetchSessionOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchAuthSession");
        }

        public static /* synthetic */ Object forgetDevice$default(Auth auth, AuthDevice authDevice, Continuation continuation, int r3, Object obj) throws AuthException {
            if (obj == null) {
                if ((r3 & 1) != 0) {
                    authDevice = null;
                }
                return auth.forgetDevice(authDevice, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: forgetDevice");
        }

        public static /* synthetic */ Object resendSignUpCode$default(Auth auth, String str, AuthResendSignUpCodeOptions authResendSignUpCodeOptions, Continuation continuation, int r4, Object obj) throws AuthException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    authResendSignUpCodeOptions = AuthResendSignUpCodeOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(authResendSignUpCodeOptions, "defaults()");
                }
                return auth.resendSignUpCode(str, authResendSignUpCodeOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resendSignUpCode");
        }

        public static /* synthetic */ Object resendUserAttributeConfirmationCode$default(Auth auth, AuthUserAttributeKey authUserAttributeKey, AuthResendUserAttributeConfirmationCodeOptions authResendUserAttributeConfirmationCodeOptions, Continuation continuation, int r4, Object obj) throws AuthException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    authResendUserAttributeConfirmationCodeOptions = AuthResendUserAttributeConfirmationCodeOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(authResendUserAttributeConfirmationCodeOptions, "defaults()");
                }
                return auth.resendUserAttributeConfirmationCode(authUserAttributeKey, authResendUserAttributeConfirmationCodeOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resendUserAttributeConfirmationCode");
        }

        public static /* synthetic */ Object resetPassword$default(Auth auth, String str, AuthResetPasswordOptions authResetPasswordOptions, Continuation continuation, int r4, Object obj) throws AuthException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    authResetPasswordOptions = AuthResetPasswordOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(authResetPasswordOptions, "defaults()");
                }
                return auth.resetPassword(str, authResetPasswordOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetPassword");
        }

        public static /* synthetic */ Object signIn$default(Auth auth, String str, String str2, AuthSignInOptions authSignInOptions, Continuation continuation, int r6, Object obj) throws AuthException {
            if (obj == null) {
                if ((r6 & 1) != 0) {
                    str = null;
                }
                if ((r6 & 2) != 0) {
                    str2 = null;
                }
                if ((r6 & 4) != 0) {
                    authSignInOptions = AuthSignInOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(authSignInOptions, "defaults()");
                }
                return auth.signIn(str, str2, authSignInOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signIn");
        }

        public static /* synthetic */ Object signInWithSocialWebUI$default(Auth auth, AuthProvider authProvider, Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Continuation continuation, int r5, Object obj) throws AuthException {
            if (obj == null) {
                if ((r5 & 4) != 0) {
                    authWebUISignInOptions = AuthWebUISignInOptions.builder().build();
                    Intrinsics.checkNotNullExpressionValue(authWebUISignInOptions, "builder().build()");
                }
                return auth.signInWithSocialWebUI(authProvider, activity, authWebUISignInOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signInWithSocialWebUI");
        }

        public static /* synthetic */ Object signInWithWebUI$default(Auth auth, Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Continuation continuation, int r4, Object obj) throws AuthException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    authWebUISignInOptions = AuthWebUISignInOptions.builder().build();
                    Intrinsics.checkNotNullExpressionValue(authWebUISignInOptions, "builder().build()");
                }
                return auth.signInWithWebUI(activity, authWebUISignInOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signInWithWebUI");
        }

        public static /* synthetic */ Object signOut$default(Auth auth, AuthSignOutOptions authSignOutOptions, Continuation continuation, int r3, Object obj) {
            if (obj == null) {
                if ((r3 & 1) != 0) {
                    authSignOutOptions = AuthSignOutOptions.builder().build();
                    Intrinsics.checkNotNullExpressionValue(authSignOutOptions, "builder().build()");
                }
                return auth.signOut(authSignOutOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signOut");
        }

        public static /* synthetic */ Object signUp$default(Auth auth, String str, String str2, AuthSignUpOptions authSignUpOptions, Continuation continuation, int r5, Object obj) throws AuthException {
            if (obj == null) {
                if ((r5 & 4) != 0) {
                    authSignUpOptions = AuthSignUpOptions.builder().build();
                    Intrinsics.checkNotNullExpressionValue(authSignUpOptions, "builder().build()");
                }
                return auth.signUp(str, str2, authSignUpOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signUp");
        }

        public static /* synthetic */ Object updateUserAttribute$default(Auth auth, AuthUserAttribute authUserAttribute, AuthUpdateUserAttributeOptions authUpdateUserAttributeOptions, Continuation continuation, int r4, Object obj) throws AuthException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    authUpdateUserAttributeOptions = AuthUpdateUserAttributeOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(authUpdateUserAttributeOptions, "defaults()");
                }
                return auth.updateUserAttribute(authUserAttribute, authUpdateUserAttributeOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateUserAttribute");
        }

        public static /* synthetic */ Object updateUserAttributes$default(Auth auth, List list, AuthUpdateUserAttributesOptions authUpdateUserAttributesOptions, Continuation continuation, int r4, Object obj) throws AuthException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    authUpdateUserAttributesOptions = AuthUpdateUserAttributesOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(authUpdateUserAttributesOptions, "defaults()");
                }
                return auth.updateUserAttributes(list, authUpdateUserAttributesOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateUserAttributes");
        }
    }

    Object confirmResetPassword(String str, String str2, String str3, AuthConfirmResetPasswordOptions authConfirmResetPasswordOptions, Continuation<? super Unit> continuation) throws AuthException;

    Object confirmSignIn(String str, AuthConfirmSignInOptions authConfirmSignInOptions, Continuation<? super AuthSignInResult> continuation) throws AuthException;

    Object confirmSignUp(String str, String str2, AuthConfirmSignUpOptions authConfirmSignUpOptions, Continuation<? super AuthSignUpResult> continuation) throws AuthException;

    Object confirmUserAttribute(AuthUserAttributeKey authUserAttributeKey, String str, Continuation<? super Unit> continuation) throws AuthException;

    Object deleteUser(Continuation<? super Unit> continuation) throws AuthException;

    Object fetchAuthSession(AuthFetchSessionOptions authFetchSessionOptions, Continuation<? super AuthSession> continuation) throws AuthException;

    Object fetchDevices(Continuation<? super List<AuthDevice>> continuation) throws AuthException;

    Object fetchUserAttributes(Continuation<? super List<AuthUserAttribute>> continuation) throws AuthException;

    Object forgetDevice(AuthDevice authDevice, Continuation<? super Unit> continuation) throws AuthException;

    Object getCurrentUser(Continuation<? super AuthUser> continuation);

    void handleWebUISignInResponse(Intent intent);

    Object rememberDevice(Continuation<? super Unit> continuation) throws AuthException;

    Object resendSignUpCode(String str, AuthResendSignUpCodeOptions authResendSignUpCodeOptions, Continuation<? super AuthCodeDeliveryDetails> continuation) throws AuthException;

    Object resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, AuthResendUserAttributeConfirmationCodeOptions authResendUserAttributeConfirmationCodeOptions, Continuation<? super AuthCodeDeliveryDetails> continuation) throws AuthException;

    Object resetPassword(String str, AuthResetPasswordOptions authResetPasswordOptions, Continuation<? super AuthResetPasswordResult> continuation) throws AuthException;

    Object signIn(String str, String str2, AuthSignInOptions authSignInOptions, Continuation<? super AuthSignInResult> continuation) throws AuthException;

    Object signInWithSocialWebUI(AuthProvider authProvider, Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Continuation<? super AuthSignInResult> continuation) throws AuthException;

    Object signInWithWebUI(Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Continuation<? super AuthSignInResult> continuation) throws AuthException;

    Object signOut(AuthSignOutOptions authSignOutOptions, Continuation<? super AuthSignOutResult> continuation);

    Object signUp(String str, String str2, AuthSignUpOptions authSignUpOptions, Continuation<? super AuthSignUpResult> continuation) throws AuthException;

    Object updatePassword(String str, String str2, Continuation<? super Unit> continuation) throws AuthException;

    Object updateUserAttribute(AuthUserAttribute authUserAttribute, AuthUpdateUserAttributeOptions authUpdateUserAttributeOptions, Continuation<? super AuthUpdateAttributeResult> continuation) throws AuthException;

    Object updateUserAttributes(List<AuthUserAttribute> list, AuthUpdateUserAttributesOptions authUpdateUserAttributesOptions, Continuation<? super Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> continuation) throws AuthException;
}
