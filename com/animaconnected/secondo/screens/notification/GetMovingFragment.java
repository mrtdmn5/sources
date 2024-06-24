package com.animaconnected.secondo.screens.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class GetMovingFragment extends NotificationDetailsFragment {
    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "GetMoving";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_get_moving, viewGroup, false);
        initView(inflate);
        return inflate;
    }
}
