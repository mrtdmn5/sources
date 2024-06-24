package com.animaconnected.secondo.screens.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.watch.CallHelper;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class AllCallsFragment extends NotificationDetailsFragment {
    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "AllCalls";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_all_calls, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.all_calls_description);
        if (!CallHelper.shouldMuteCalls()) {
            textView.setText(R.string.nft_all_calls_description_with_reject);
        } else {
            textView.setText(R.string.nft_all_calls_description_with_mute);
        }
        initView(inflate);
        return inflate;
    }
}
