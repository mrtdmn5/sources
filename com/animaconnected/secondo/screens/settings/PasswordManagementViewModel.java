package com.animaconnected.secondo.screens.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.screens.settings.PasswordState;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: PasswordManagementViewModel.kt */
/* loaded from: classes3.dex */
public final class PasswordManagementViewModel {
    public static final int $stable = 8;
    private final String TAG = "PasswordManagementViewModel";
    private final LiveData<DialogMessage> dialog;
    private MutableLiveData<DialogMessage> dialogWrite;
    private final StateFlow<Boolean> isLoading;
    private MutableStateFlow<Boolean> isLoadingWrite;
    private final CommonFlow<PasswordState> state;
    private MutableStateFlow<PasswordState> stateWrite;

    public PasswordManagementViewModel() {
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(PasswordState.Idle.INSTANCE);
        this.stateWrite = MutableStateFlow;
        this.state = FlowExtensionsKt.asCommonFlow(MutableStateFlow);
        MutableLiveData<DialogMessage> mutableLiveData = new MutableLiveData<>();
        this.dialogWrite = mutableLiveData;
        this.dialog = mutableLiveData;
        StateFlowImpl MutableStateFlow2 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.isLoadingWrite = MutableStateFlow2;
        this.isLoading = MutableStateFlow2;
    }

    private final void setState(final PasswordState passwordState) {
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        LogKt.debug$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.settings.PasswordManagementViewModel$setState$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Changing state to " + PasswordState.this;
            }
        }, 6, (Object) null);
        this.stateWrite.setValue(passwordState);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enterConfirmationCode(java.lang.String r6, java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.PasswordManagementViewModel.enterConfirmationCode(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final LiveData<DialogMessage> getDialog() {
        return this.dialog;
    }

    public final CommonFlow<PasswordState> getState() {
        return this.state;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendConfirmationCode(java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.PasswordManagementViewModel.sendConfirmationCode(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
