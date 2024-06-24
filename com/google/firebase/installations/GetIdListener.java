package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallation;

/* loaded from: classes3.dex */
public final class GetIdListener implements StateListener {
    public final TaskCompletionSource<String> taskCompletionSource;

    public GetIdListener(TaskCompletionSource<String> taskCompletionSource) {
        this.taskCompletionSource = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean onException(Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean onStateReached(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) {
        boolean z;
        boolean z2;
        boolean z3;
        if (autoValue_PersistedInstallationEntry.getRegistrationStatus() == PersistedInstallation.RegistrationStatus.UNREGISTERED) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (autoValue_PersistedInstallationEntry.getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTERED) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                if (autoValue_PersistedInstallationEntry.getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    return false;
                }
            }
        }
        this.taskCompletionSource.trySetResult(autoValue_PersistedInstallationEntry.firebaseInstallationId);
        return true;
    }
}
