package com.amplifyframework.auth.cognito;

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
import com.amplifyframework.auth.cognito.options.FederateToIdentityPoolOptions;
import com.amplifyframework.auth.cognito.result.FederateToIdentityPoolResult;
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
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinAuthFacadeInternal.kt */
/* loaded from: classes.dex */
public final class KotlinAuthFacadeInternal {
    private final RealAWSCognitoAuthPlugin delegate;

    public KotlinAuthFacadeInternal(RealAWSCognitoAuthPlugin delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public final Object clearFederationToIdentityPool(Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.clearFederationToIdentityPool(new Action() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$clearFederationToIdentityPool$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$clearFederationToIdentityPool$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    public final Object confirmResetPassword(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.confirmResetPassword(str, str2, str3, new Action() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmResetPassword$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmResetPassword$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        return orThrow == CoroutineSingletons.COROUTINE_SUSPENDED ? orThrow : Unit.INSTANCE;
    }

    public final Object confirmSignIn(String str, Continuation<? super AuthSignInResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.confirmSignIn(str, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmSignIn$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignInResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmSignIn$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object confirmSignUp(String str, String str2, Continuation<? super AuthSignUpResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.confirmSignUp(str, str2, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmSignUp$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignUpResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmSignUp$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object confirmUserAttribute(AuthUserAttributeKey authUserAttributeKey, String str, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.confirmUserAttribute(authUserAttributeKey, str, new Action() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmUserAttribute$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmUserAttribute$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    public final Object deleteUser(Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.deleteUser(new Action() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$deleteUser$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$deleteUser$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    public final Object federateToIdentityPool(String str, AuthProvider authProvider, FederateToIdentityPoolOptions federateToIdentityPoolOptions, Continuation<? super FederateToIdentityPoolResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.federateToIdentityPool(str, authProvider, federateToIdentityPoolOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$federateToIdentityPool$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(FederateToIdentityPoolResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$federateToIdentityPool$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object fetchAuthSession(Continuation<? super AuthSession> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.fetchAuthSession(new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$fetchAuthSession$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSession it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$fetchAuthSession$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object fetchDevices(Continuation<? super List<AuthDevice>> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.fetchDevices(new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$fetchDevices$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(List<AuthDevice> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$fetchDevices$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object fetchUserAttributes(Continuation<? super List<AuthUserAttribute>> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.fetchUserAttributes(new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$fetchUserAttributes$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(List<AuthUserAttribute> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$fetchUserAttributes$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object forgetDevice(Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.forgetDevice(new Action() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$forgetDevice$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$forgetDevice$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        return orThrow == CoroutineSingletons.COROUTINE_SUSPENDED ? orThrow : Unit.INSTANCE;
    }

    public final Object getCurrentUser(Continuation<? super AuthUser> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.getCurrentUser(new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$getCurrentUser$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthUser it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$getCurrentUser$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final void handleWebUISignInResponse(Intent intent) {
        this.delegate.handleWebUISignInResponse(intent);
    }

    public final Object rememberDevice(Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.rememberDevice(new Action() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$rememberDevice$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$rememberDevice$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    public final Object resendSignUpCode(String str, Continuation<? super AuthCodeDeliveryDetails> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.resendSignUpCode(str, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$resendSignUpCode$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthCodeDeliveryDetails it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$resendSignUpCode$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, Continuation<? super AuthCodeDeliveryDetails> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.resendUserAttributeConfirmationCode(authUserAttributeKey, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$resendUserAttributeConfirmationCode$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthCodeDeliveryDetails it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$resendUserAttributeConfirmationCode$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object resetPassword(String str, Continuation<? super AuthResetPasswordResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.resetPassword(str, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$resetPassword$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthResetPasswordResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$resetPassword$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object signIn(String str, String str2, Continuation<? super AuthSignInResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signIn(str, str2, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signIn$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignInResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signIn$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object signInWithSocialWebUI(AuthProvider authProvider, Activity activity, Continuation<? super AuthSignInResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signInWithSocialWebUI(authProvider, activity, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signInWithSocialWebUI$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignInResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signInWithSocialWebUI$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object signInWithWebUI(Activity activity, Continuation<? super AuthSignInResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signInWithWebUI(activity, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signInWithWebUI$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignInResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signInWithWebUI$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object signOut(Continuation<? super AuthSignOutResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signOut(new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signOut$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignOutResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object signUp(String str, String str2, AuthSignUpOptions authSignUpOptions, Continuation<? super AuthSignUpResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signUp(str, str2, authSignUpOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signUp$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignUpResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signUp$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object updatePassword(String str, String str2, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.updatePassword(str, str2, new Action() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$updatePassword$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$updatePassword$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    public final Object updateUserAttribute(AuthUserAttribute authUserAttribute, Continuation<? super AuthUpdateAttributeResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.updateUserAttribute(authUserAttribute, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$updateUserAttribute$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthUpdateAttributeResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$updateUserAttribute$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object updateUserAttributes(List<AuthUserAttribute> list, Continuation<? super Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.updateUserAttributes(list, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$updateUserAttributes$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Map<AuthUserAttributeKey, AuthUpdateAttributeResult> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$updateUserAttributes$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object confirmSignIn(String str, AuthConfirmSignInOptions authConfirmSignInOptions, Continuation<? super AuthSignInResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.confirmSignIn(str, authConfirmSignInOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmSignIn$4$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignInResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmSignIn$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object confirmSignUp(String str, String str2, AuthConfirmSignUpOptions authConfirmSignUpOptions, Continuation<? super AuthSignUpResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.confirmSignUp(str, str2, authConfirmSignUpOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmSignUp$4$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignUpResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmSignUp$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object fetchAuthSession(AuthFetchSessionOptions authFetchSessionOptions, Continuation<? super AuthSession> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.fetchAuthSession(authFetchSessionOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$fetchAuthSession$4$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSession it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$fetchAuthSession$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object resendSignUpCode(String str, AuthResendSignUpCodeOptions authResendSignUpCodeOptions, Continuation<? super AuthCodeDeliveryDetails> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.resendSignUpCode(str, authResendSignUpCodeOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$resendSignUpCode$4$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthCodeDeliveryDetails it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$resendSignUpCode$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, AuthResendUserAttributeConfirmationCodeOptions authResendUserAttributeConfirmationCodeOptions, Continuation<? super AuthCodeDeliveryDetails> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.resendUserAttributeConfirmationCode(authUserAttributeKey, authResendUserAttributeConfirmationCodeOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$resendUserAttributeConfirmationCode$4$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthCodeDeliveryDetails it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$resendUserAttributeConfirmationCode$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object resetPassword(String str, AuthResetPasswordOptions authResetPasswordOptions, Continuation<? super AuthResetPasswordResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.resetPassword(str, authResetPasswordOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$resetPassword$4$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthResetPasswordResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$resetPassword$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object signIn(String str, String str2, AuthSignInOptions authSignInOptions, Continuation<? super AuthSignInResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signIn(str, str2, authSignInOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signIn$4$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignInResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signIn$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object signInWithSocialWebUI(AuthProvider authProvider, Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Continuation<? super AuthSignInResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signInWithSocialWebUI(authProvider, activity, authWebUISignInOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signInWithSocialWebUI$4$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignInResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signInWithSocialWebUI$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object signInWithWebUI(Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Continuation<? super AuthSignInResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signInWithWebUI(activity, authWebUISignInOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signInWithWebUI$4$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignInResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signInWithWebUI$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object signOut(AuthSignOutOptions authSignOutOptions, Continuation<? super AuthSignOutResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signOut(authSignOutOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$signOut$4$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignOutResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object updateUserAttribute(AuthUserAttribute authUserAttribute, AuthUpdateUserAttributeOptions authUpdateUserAttributeOptions, Continuation<? super AuthUpdateAttributeResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.updateUserAttribute(authUserAttribute, authUpdateUserAttributeOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$updateUserAttribute$4$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthUpdateAttributeResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$updateUserAttribute$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object updateUserAttributes(List<AuthUserAttribute> list, AuthUpdateUserAttributesOptions authUpdateUserAttributesOptions, Continuation<? super Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.updateUserAttributes(list, authUpdateUserAttributesOptions, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$updateUserAttributes$4$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Map<AuthUserAttributeKey, AuthUpdateAttributeResult> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$updateUserAttributes$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    public final Object confirmResetPassword(String str, String str2, String str3, AuthConfirmResetPasswordOptions authConfirmResetPasswordOptions, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.confirmResetPassword(str, str2, str3, authConfirmResetPasswordOptions, new Action() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmResetPassword$4$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$confirmResetPassword$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        return orThrow == CoroutineSingletons.COROUTINE_SUSPENDED ? orThrow : Unit.INSTANCE;
    }

    public final Object forgetDevice(AuthDevice authDevice, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.forgetDevice(authDevice, new Action() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$forgetDevice$4$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.auth.cognito.KotlinAuthFacadeInternal$forgetDevice$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        return orThrow == CoroutineSingletons.COROUTINE_SUSPENDED ? orThrow : Unit.INSTANCE;
    }
}
