package com.animaconnected.secondo.screens.detailspicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.detailspicker.DetailsPickerAdapter;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public abstract class BaseDetailsPickerFragment extends BaseFragment implements DetailsPickerAdapter.DetailsPickerAdapterListener {
    protected DetailsPickerAdapter mAdapter;
    protected RecyclerView mPickerOptions;

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return "";
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "DetailsPicker";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_detailspicker, viewGroup, false);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mPickerOptions = (RecyclerView) view.findViewById(R.id.options_list);
        this.mPickerOptions.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        DetailsPickerAdapter detailsPickerAdapter = new DetailsPickerAdapter();
        this.mAdapter = detailsPickerAdapter;
        this.mPickerOptions.setAdapter(detailsPickerAdapter);
    }
}
