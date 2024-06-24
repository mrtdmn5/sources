package com.animaconnected.secondo.provider.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.amplifyframework.auth.result.step.AuthSignInStep;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.SigninStorage;
import com.animaconnected.secondo.provider.login.LoginState;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: LoginViewModel.kt */
/* loaded from: classes3.dex */
public final class LoginViewModel {
    public static final int $stable = 8;
    private final String TAG;
    private final AppEvents appEvents;
    private final LiveData<DialogMessage> dialog;
    private MutableLiveData<DialogMessage> dialogWrite;
    private final FitnessProvider fitnessProvider;
    private final StateFlow<Boolean> isLoading;
    private MutableStateFlow<Boolean> isLoadingWrite;
    private final CommonFlow<LoginState> loginState;
    private MutableStateFlow<LoginState> loginStateWrite;
    private final SigninStorage storage;

    /* compiled from: LoginViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[AuthSignInStep.values().length];
            try {
                r0[AuthSignInStep.CONFIRM_SIGN_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[AuthSignInStep.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public LoginViewModel(SigninStorage storage, AppEvents appEvents, FitnessProvider fitnessProvider) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(appEvents, "appEvents");
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        this.storage = storage;
        this.appEvents = appEvents;
        this.fitnessProvider = fitnessProvider;
        this.TAG = "LoginViewModel";
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(LoginState.Uninitialized.INSTANCE);
        this.loginStateWrite = MutableStateFlow;
        this.loginState = FlowExtensionsKt.asCommonFlow(MutableStateFlow);
        MutableLiveData<DialogMessage> mutableLiveData = new MutableLiveData<>();
        this.dialogWrite = mutableLiveData;
        this.dialog = mutableLiveData;
        StateFlowImpl MutableStateFlow2 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.isLoadingWrite = MutableStateFlow2;
        this.isLoading = MutableStateFlow2;
    }

    private final void loading(boolean z) {
        this.isLoadingWrite.setValue(Boolean.valueOf(z));
    }

    private final void setState(final LoginState loginState) {
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        LogKt.debug$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.login.LoginViewModel$setState$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Changing state to -> " + LoginState.this;
            }
        }, 6, (Object) null);
        this.storage.setState(loginState);
        this.loginStateWrite.setValue(loginState);
    }

    private final void showDialog(DialogMessage dialogMessage) {
        this.dialogWrite.setValue(dialogMessage);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object confirmSignUp(java.lang.String r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.login.LoginViewModel.confirmSignUp(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deleteAccount(kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.login.LoginViewModel.deleteAccount(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final LiveData<DialogMessage> getDialog() {
        return this.dialog;
    }

    public final CommonFlow<LoginState> getLoginState() {
        return this.loginState;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final void loadStoredState() {
        MutableStateFlow<LoginState> mutableStateFlow = this.loginStateWrite;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), this.storage.getState()));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object resendCode(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.provider.login.LoginViewModel$resendCode$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.provider.login.LoginViewModel$resendCode$1 r0 = (com.animaconnected.secondo.provider.login.LoginViewModel$resendCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.provider.login.LoginViewModel$resendCode$1 r0 = new com.animaconnected.secondo.provider.login.LoginViewModel$resendCode$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.provider.login.LoginViewModel r0 = (com.animaconnected.secondo.provider.login.LoginViewModel) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4d
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            r4.loading(r3)
            com.animaconnected.secondo.utils.AmplifyApi r5 = com.animaconnected.secondo.utils.AmplifyApi.INSTANCE
            com.animaconnected.secondo.provider.SigninStorage r2 = r4.storage
            java.lang.String r2 = r2.getEmail()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.resendCode(r2, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            r0 = r4
        L4d:
            com.animaconnected.secondo.utils.AmplifyResult r5 = (com.animaconnected.secondo.utils.AmplifyResult) r5
            boolean r1 = r5 instanceof com.animaconnected.secondo.utils.AmplifyResult.Success
            if (r1 == 0) goto L68
            com.animaconnected.secondo.provider.login.DialogMessage$ConfirmationCodeSent r5 = new com.animaconnected.secondo.provider.login.DialogMessage$ConfirmationCodeSent
            com.animaconnected.secondo.provider.SigninStorage r1 = r0.storage
            java.lang.String r1 = r1.getEmail()
            r5.<init>(r1)
            r0.showDialog(r5)
            com.animaconnected.firebase.AppEvents r5 = r0.appEvents
            r1 = 0
            r5.accountResendConfirmationCode(r1)
            goto La4
        L68:
            boolean r1 = r5 instanceof com.animaconnected.secondo.utils.AmplifyResult.Failure
            if (r1 == 0) goto La2
            com.animaconnected.secondo.utils.AmplifyResult$Failure r5 = (com.animaconnected.secondo.utils.AmplifyResult.Failure) r5
            java.lang.Exception r1 = r5.getException()
            boolean r2 = r1 instanceof com.animaconnected.secondo.utils.NoInternetAccessException
            if (r2 == 0) goto L7c
            com.animaconnected.secondo.provider.login.DialogMessage$NoInternetConnection r1 = com.animaconnected.secondo.provider.login.DialogMessage.NoInternetConnection.INSTANCE
            r0.showDialog(r1)
            goto L94
        L7c:
            boolean r1 = r1 instanceof com.amplifyframework.auth.cognito.exceptions.service.CodeExpiredException
            if (r1 == 0) goto L86
            com.animaconnected.secondo.provider.login.DialogMessage$CodeExpired r1 = com.animaconnected.secondo.provider.login.DialogMessage.CodeExpired.INSTANCE
            r0.showDialog(r1)
            goto L94
        L86:
            com.animaconnected.secondo.provider.login.DialogMessage$FailedToSendConfirmationCode r1 = new com.animaconnected.secondo.provider.login.DialogMessage$FailedToSendConfirmationCode
            com.animaconnected.secondo.provider.SigninStorage r2 = r0.storage
            java.lang.String r2 = r2.getEmail()
            r1.<init>(r2)
            r0.showDialog(r1)
        L94:
            com.animaconnected.firebase.AppEvents r1 = r0.appEvents
            java.lang.Exception r5 = r5.getException()
            java.lang.String r5 = r5.getMessage()
            r1.accountResendConfirmationCode(r5)
            goto La4
        La2:
            boolean r5 = r5 instanceof com.animaconnected.secondo.utils.AmplifyResult.SuccessNothingDone
        La4:
            r5 = 0
            r0.loading(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.login.LoginViewModel.resendCode(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object signInWithEmail(java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.login.LoginViewModel.signInWithEmail(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object signInWithWebUI(com.amplifyframework.auth.AuthProvider r5, android.app.Activity r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.secondo.provider.login.LoginViewModel$signInWithWebUI$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.secondo.provider.login.LoginViewModel$signInWithWebUI$1 r0 = (com.animaconnected.secondo.provider.login.LoginViewModel$signInWithWebUI$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.provider.login.LoginViewModel$signInWithWebUI$1 r0 = new com.animaconnected.secondo.provider.login.LoginViewModel$signInWithWebUI$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$1
            com.amplifyframework.auth.AuthProvider r5 = (com.amplifyframework.auth.AuthProvider) r5
            java.lang.Object r6 = r0.L$0
            com.animaconnected.secondo.provider.login.LoginViewModel r6 = (com.animaconnected.secondo.provider.login.LoginViewModel) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4d
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            r4.loading(r3)
            com.animaconnected.secondo.utils.AmplifyApi r7 = com.animaconnected.secondo.utils.AmplifyApi.INSTANCE
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = r7.trySignInWithSocialWebUI(r5, r6, r0)
            if (r7 != r1) goto L4c
            return r1
        L4c:
            r6 = r4
        L4d:
            com.animaconnected.secondo.utils.AmplifyResult r7 = (com.animaconnected.secondo.utils.AmplifyResult) r7
            boolean r0 = r7 instanceof com.animaconnected.secondo.utils.AmplifyResult.Success
            if (r0 == 0) goto L63
            com.animaconnected.secondo.provider.login.LoginState$SignedIn r7 = com.animaconnected.secondo.provider.login.LoginState.SignedIn.INSTANCE
            r6.setState(r7)
            com.animaconnected.firebase.AppEvents r7 = r6.appEvents
            java.lang.String r5 = r5.getProviderKey()
            r0 = 0
            r7.accountLogin(r5, r0)
            goto La1
        L63:
            boolean r0 = r7 instanceof com.animaconnected.secondo.utils.AmplifyResult.Failure
            if (r0 == 0) goto L98
            com.animaconnected.secondo.utils.AmplifyResult$Failure r7 = (com.animaconnected.secondo.utils.AmplifyResult.Failure) r7
            java.lang.Exception r0 = r7.getException()
            boolean r1 = r0 instanceof com.animaconnected.secondo.utils.NoInternetAccessException
            if (r1 == 0) goto L77
            com.animaconnected.secondo.provider.login.DialogMessage$NoInternetConnection r0 = com.animaconnected.secondo.provider.login.DialogMessage.NoInternetConnection.INSTANCE
            r6.showDialog(r0)
            goto L86
        L77:
            boolean r0 = r0 instanceof com.animaconnected.secondo.utils.WebUiAccountAlreadyExistException
            if (r0 == 0) goto L81
            com.animaconnected.secondo.provider.login.DialogMessage$UsernameExistsException r0 = com.animaconnected.secondo.provider.login.DialogMessage.UsernameExistsException.INSTANCE
            r6.showDialog(r0)
            goto L86
        L81:
            com.animaconnected.secondo.provider.login.DialogMessage$Generic r0 = com.animaconnected.secondo.provider.login.DialogMessage.Generic.INSTANCE
            r6.showDialog(r0)
        L86:
            com.animaconnected.firebase.AppEvents r0 = r6.appEvents
            java.lang.String r5 = r5.getProviderKey()
            java.lang.Exception r7 = r7.getException()
            java.lang.String r7 = r7.getMessage()
            r0.accountLogin(r5, r7)
            goto La1
        L98:
            boolean r5 = r7 instanceof com.animaconnected.secondo.utils.AmplifyResult.SuccessNothingDone
            if (r5 == 0) goto La1
            com.animaconnected.secondo.provider.login.LoginState$SignedIn r5 = com.animaconnected.secondo.provider.login.LoginState.SignedIn.INSTANCE
            r6.setState(r5)
        La1:
            r5 = 0
            r6.loading(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.login.LoginViewModel.signInWithWebUI(com.amplifyframework.auth.AuthProvider, android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object signOut(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.login.LoginViewModel.signOut(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object signUp(java.lang.String r10, java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.login.LoginViewModel.signUp(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
