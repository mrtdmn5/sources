package com.animaconnected.secondo.screens.details.watch;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;

/* loaded from: classes3.dex */
public abstract class BaseDetailWatchPage extends Fragment {
    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public abstract void updateHands(boolean z);
}
