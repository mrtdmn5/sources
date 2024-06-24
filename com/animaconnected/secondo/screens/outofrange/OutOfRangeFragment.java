package com.animaconnected.secondo.screens.outofrange;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.notification.NotificationDetailsFragment;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class OutOfRangeFragment extends NotificationDetailsFragment {
    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "OutOfRange";
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        ProviderFactory.getWatch();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_out_of_range, viewGroup, false);
        initView(inflate);
        return inflate;
    }
}
