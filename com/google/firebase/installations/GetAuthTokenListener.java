package com.google.firebase.installations;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallation;

/* loaded from: classes3.dex */
public final class GetAuthTokenListener implements StateListener {
    public final TaskCompletionSource<InstallationTokenResult> resultTaskCompletionSource;
    public final Utils utils;

    public GetAuthTokenListener(Utils utils, TaskCompletionSource<InstallationTokenResult> taskCompletionSource) {
        this.utils = utils;
        this.resultTaskCompletionSource = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean onException(Exception exc) {
        this.resultTaskCompletionSource.trySetException(exc);
        return true;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean onStateReached(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) {
        boolean z;
        if (autoValue_PersistedInstallationEntry.getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTERED) {
            z = true;
        } else {
            z = false;
        }
        if (!z || this.utils.isAuthTokenExpired(autoValue_PersistedInstallationEntry)) {
            return false;
        }
        String str = autoValue_PersistedInstallationEntry.authToken;
        if (str != null) {
            Long valueOf = Long.valueOf(autoValue_PersistedInstallationEntry.expiresInSecs);
            Long valueOf2 = Long.valueOf(autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs);
            String str2 = "";
            if (valueOf == null) {
                str2 = "".concat(" tokenExpirationTimestamp");
            }
            if (valueOf2 == null) {
                str2 = ComposableInvoker$$ExternalSyntheticOutline0.m(str2, " tokenCreationTimestamp");
            }
            if (str2.isEmpty()) {
                this.resultTaskCompletionSource.setResult(new AutoValue_InstallationTokenResult(str, valueOf.longValue(), valueOf2.longValue()));
                return true;
            }
            throw new IllegalStateException("Missing required properties:".concat(str2));
        }
        throw new NullPointerException("Null token");
    }
}
