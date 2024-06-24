package com.google.firebase.installations;

import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;

/* loaded from: classes3.dex */
public interface StateListener {
    boolean onException(Exception exc);

    boolean onStateReached(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry);
}
