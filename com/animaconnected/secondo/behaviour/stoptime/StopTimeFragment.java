package com.animaconnected.secondo.behaviour.stoptime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.stoptime.StopTime;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class StopTimeFragment extends BaseDetailsFragment {
    public static BaseDetailsFragment newInstance(Slot slot) {
        StopTimeFragment stopTimeFragment = new StopTimeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("slot", slot);
        bundle.putString("type", StopTime.TYPE);
        stopTimeFragment.setArguments(bundle);
        return stopTimeFragment;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_details_stoptime, viewGroup, false);
    }
}
