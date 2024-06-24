package com.animaconnected.secondo.behaviour.phonebattery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class PhoneBatteryFragment extends BaseDetailsFragment {
    public static BaseDetailsFragment newInstance(Slot slot) {
        PhoneBatteryFragment phoneBatteryFragment = new PhoneBatteryFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("slot", slot);
        bundle.putString("type", PhoneBattery.TYPE);
        phoneBatteryFragment.setArguments(bundle);
        return phoneBatteryFragment;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_details_phone_battery, viewGroup, false);
    }
}
