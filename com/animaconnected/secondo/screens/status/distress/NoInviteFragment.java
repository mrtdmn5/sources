package com.animaconnected.secondo.screens.status.distress;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.status.BaseStatusFragment;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class NoInviteFragment extends BaseStatusFragment {
    @Override // com.animaconnected.secondo.screens.status.BaseStatusFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_status_distress_no_accepted_invite, viewGroup, false);
    }
}
