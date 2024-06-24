package com.amplifyframework.kotlin.auth;

import android.app.Activity;
import android.content.Intent;
import com.amplifyframework.auth.AuthCategoryBehavior;
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

/* compiled from: KotlinAuthFacade.kt */
/* loaded from: classes.dex */
public final class KotlinAuthFacade implements Auth {
    private final AuthCategoryBehavior delegate;

    public KotlinAuthFacade() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object confirmResetPassword(String str, String str2, String str3, AuthConfirmResetPasswordOptions authConfirmResetPasswordOptions, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.confirmResetPassword(str, str2, str3, authConfirmResetPasswordOptions, new Action() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$confirmResetPassword$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$confirmResetPassword$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object confirmSignIn(String str, AuthConfirmSignInOptions authConfirmSignInOptions, Continuation<? super AuthSignInResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.confirmSignIn(str, authConfirmSignInOptions, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$confirmSignIn$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignInResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$confirmSignIn$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object confirmSignUp(String str, String str2, AuthConfirmSignUpOptions authConfirmSignUpOptions, Continuation<? super AuthSignUpResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.confirmSignUp(str, str2, authConfirmSignUpOptions, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$confirmSignUp$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignUpResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$confirmSignUp$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object confirmUserAttribute(AuthUserAttributeKey authUserAttributeKey, String str, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.confirmUserAttribute(authUserAttributeKey, str, new Action() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$confirmUserAttribute$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$confirmUserAttribute$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object deleteUser(Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.deleteUser(new Action() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$deleteUser$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$deleteUser$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object fetchAuthSession(AuthFetchSessionOptions authFetchSessionOptions, Continuation<? super AuthSession> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.fetchAuthSession(AuthFetchSessionOptions.Companion.defaults(), new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$fetchAuthSession$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSession it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$fetchAuthSession$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object fetchDevices(Continuation<? super List<AuthDevice>> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.fetchDevices(new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$fetchDevices$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(List<AuthDevice> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$fetchDevices$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object fetchUserAttributes(Continuation<? super List<AuthUserAttribute>> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.fetchUserAttributes(new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$fetchUserAttributes$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(List<AuthUserAttribute> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$fetchUserAttributes$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object forgetDevice(AuthDevice authDevice, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        if (authDevice == null) {
            this.delegate.forgetDevice(new Action() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$forgetDevice$2$1
                @Override // com.amplifyframework.core.Action
                public final void call() {
                    safeContinuation.resumeWith(Unit.INSTANCE);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$forgetDevice$2$2
                @Override // com.amplifyframework.core.Consumer
                public final void accept(AuthException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    safeContinuation.resumeWith(ResultKt.createFailure(it));
                }
            });
        } else {
            this.delegate.forgetDevice(authDevice, new Action() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$forgetDevice$2$3
                @Override // com.amplifyframework.core.Action
                public final void call() {
                    safeContinuation.resumeWith(Unit.INSTANCE);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$forgetDevice$2$4
                @Override // com.amplifyframework.core.Consumer
                public final void accept(AuthException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    safeContinuation.resumeWith(ResultKt.createFailure(it));
                }
            });
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object getCurrentUser(Continuation<? super AuthUser> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.getCurrentUser(new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$getCurrentUser$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthUser it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$getCurrentUser$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public void handleWebUISignInResponse(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.delegate.handleWebUISignInResponse(intent);
    }

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object rememberDevice(Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.rememberDevice(new Action() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$rememberDevice$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$rememberDevice$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object resendSignUpCode(String str, AuthResendSignUpCodeOptions authResendSignUpCodeOptions, Continuation<? super AuthCodeDeliveryDetails> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.resendSignUpCode(str, authResendSignUpCodeOptions, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$resendSignUpCode$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthCodeDeliveryDetails it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$resendSignUpCode$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object resendUserAttributeConfirmationCode(AuthUserAttributeKey authUserAttributeKey, AuthResendUserAttributeConfirmationCodeOptions authResendUserAttributeConfirmationCodeOptions, Continuation<? super AuthCodeDeliveryDetails> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.resendUserAttributeConfirmationCode(authUserAttributeKey, authResendUserAttributeConfirmationCodeOptions, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$resendUserAttributeConfirmationCode$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthCodeDeliveryDetails it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$resendUserAttributeConfirmationCode$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object resetPassword(String str, AuthResetPasswordOptions authResetPasswordOptions, Continuation<? super AuthResetPasswordResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.resetPassword(str, authResetPasswordOptions, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$resetPassword$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthResetPasswordResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$resetPassword$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object signIn(String str, String str2, AuthSignInOptions authSignInOptions, Continuation<? super AuthSignInResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signIn(str, str2, authSignInOptions, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$signIn$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignInResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$signIn$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object signInWithSocialWebUI(AuthProvider authProvider, Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Continuation<? super AuthSignInResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signInWithSocialWebUI(authProvider, activity, authWebUISignInOptions, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$signInWithSocialWebUI$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignInResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$signInWithSocialWebUI$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object signInWithWebUI(Activity activity, AuthWebUISignInOptions authWebUISignInOptions, Continuation<? super AuthSignInResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signInWithWebUI(activity, authWebUISignInOptions, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$signInWithWebUI$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignInResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$signInWithWebUI$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object signOut(AuthSignOutOptions authSignOutOptions, Continuation<? super AuthSignOutResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signOut(authSignOutOptions, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$signOut$2$1
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object signUp(String str, String str2, AuthSignUpOptions authSignUpOptions, Continuation<? super AuthSignUpResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.signUp(str, str2, authSignUpOptions, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$signUp$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthSignUpResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$signUp$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object updatePassword(String str, String str2, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.updatePassword(str, str2, new Action() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$updatePassword$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$updatePassword$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object updateUserAttribute(AuthUserAttribute authUserAttribute, AuthUpdateUserAttributeOptions authUpdateUserAttributeOptions, Continuation<? super AuthUpdateAttributeResult> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.updateUserAttribute(authUserAttribute, authUpdateUserAttributeOptions, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$updateUserAttribute$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(AuthUpdateAttributeResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$updateUserAttribute$2$2
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

    @Override // com.amplifyframework.kotlin.auth.Auth
    public Object updateUserAttributes(List<AuthUserAttribute> list, AuthUpdateUserAttributesOptions authUpdateUserAttributesOptions, Continuation<? super Map<AuthUserAttributeKey, AuthUpdateAttributeResult>> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.updateUserAttributes(list, authUpdateUserAttributesOptions, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$updateUserAttributes$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Map<AuthUserAttributeKey, AuthUpdateAttributeResult> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.auth.KotlinAuthFacade$updateUserAttributes$2$2
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

    public KotlinAuthFacade(AuthCategoryBehavior delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ KotlinAuthFacade(com.amplifyframework.auth.AuthCategoryBehavior r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto Lb
            com.amplifyframework.auth.AuthCategory r1 = com.amplifyframework.core.Amplify.Auth
            java.lang.String r2 = "Auth"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        Lb:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.auth.KotlinAuthFacade.<init>(com.amplifyframework.auth.AuthCategoryBehavior, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
