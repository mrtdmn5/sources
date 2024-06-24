package com.animaconnected.secondo.behaviour.rememberthisspot.spots;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.behaviour.rememberthisspot.location.LocationIntentCreator;
import com.animaconnected.secondo.behaviour.rememberthisspot.spots.SpotsAdapter;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.watch.location.Spot;
import com.animaconnected.watch.provider.SpotsProvider;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class SavedSpotsFragment extends BaseFragment implements SpotsProvider.SpotsProviderListener {
    private static final String ASSIGNED_TO_PUSHER = "assignedToPusher";
    private static final String FEATURE_PATH = "featurePath";
    private static final String SPOT_RENAMED = "RememberThisSpot_spot_renamed";
    private TextView mActionText;
    private boolean mIsAssignedToSlot;
    private RecyclerView mRecyclerView;
    private SpotsAdapter mSpotsAdapter;
    private String mTitle;
    private SpotsProvider spotsProvider;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(View view, View view2) {
        this.mSpotsAdapter.setInEditMode(!this.mSpotsAdapter.isInEditMode(), view);
        updateToolbarActionText(this.mActionText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchMapView(Spot spot) {
        try {
            startActivity(LocationIntentCreator.createMapsIntent(spot));
        } catch (Exception e) {
            LogKt.err((Object) this, "Failed to open Google Maps", "SavedSpotsFragment", (Throwable) e, true);
        }
    }

    public static SavedSpotsFragment newInstance(boolean z, String str) {
        SavedSpotsFragment savedSpotsFragment = new SavedSpotsFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(ASSIGNED_TO_PUSHER, z);
        bundle.putString(FEATURE_PATH, str);
        savedSpotsFragment.setArguments(bundle);
        return savedSpotsFragment;
    }

    private void updateEditText() {
        boolean z;
        if (isResumed()) {
            AnimatedToolbar toolbar = getToolbar();
            if (this.mSpotsAdapter.getSpotsCount() > 0) {
                z = true;
            } else {
                z = false;
            }
            toolbar.enableActionText(z);
            updateToolbarActionText(this.mActionText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateToolbarActionText(TextView textView) {
        int r0;
        if (this.mSpotsAdapter.isInEditMode()) {
            r0 = R.string.remember_this_spot_saved_spots_done;
        } else {
            r0 = R.string.remember_this_spot_saved_spots_edit;
        }
        textView.setText(getString(r0));
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return this.mTitle;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "SavedSpotsFragment";
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mIsAssignedToSlot = arguments.getBoolean(ASSIGNED_TO_PUSHER);
            this.mTitle = arguments.getString(FEATURE_PATH);
        }
        this.spotsProvider = SpotsProvider.getInstance();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_saved_spots, viewGroup, false);
        SpotsAdapter spotsAdapter = new SpotsAdapter();
        this.mSpotsAdapter = spotsAdapter;
        spotsAdapter.setAssignedToSlot(this.mIsAssignedToSlot);
        this.mSpotsAdapter.setSpots(this.spotsProvider.getAllSpots());
        this.mSpotsAdapter.setOnSpotsListener(new SpotsAdapter.OnSpotClickedListener() { // from class: com.animaconnected.secondo.behaviour.rememberthisspot.spots.SavedSpotsFragment.1
            @Override // com.animaconnected.secondo.behaviour.rememberthisspot.spots.SpotsAdapter.OnSpotClickedListener
            public void onSpotDeletedClick(int r2) {
                SavedSpotsFragment.this.spotsProvider.removeSpot(r2);
            }

            @Override // com.animaconnected.secondo.behaviour.rememberthisspot.spots.SpotsAdapter.OnSpotClickedListener
            public void onSpotLongClick() {
                SavedSpotsFragment savedSpotsFragment = SavedSpotsFragment.this;
                savedSpotsFragment.updateToolbarActionText(savedSpotsFragment.getToolbar().enableActionText(true));
            }

            @Override // com.animaconnected.secondo.behaviour.rememberthisspot.spots.SpotsAdapter.OnSpotClickedListener
            public void onSpotSaveClick(int r3, int r4) {
                SpotsAdapter.ViewHolder viewHolder = (SpotsAdapter.ViewHolder) SavedSpotsFragment.this.mRecyclerView.findViewHolderForAdapterPosition(r4);
                String obj = viewHolder.mEditName.getText().toString();
                if (obj.isEmpty()) {
                    obj = viewHolder.mAddress.getText().toString();
                }
                SavedSpotsFragment.this.spotsProvider.updateSpotName(r3, obj);
            }

            @Override // com.animaconnected.secondo.behaviour.rememberthisspot.spots.SpotsAdapter.OnSpotClickedListener
            public void onSpotSelectedClick(int r3) {
                SavedSpotsFragment savedSpotsFragment = SavedSpotsFragment.this;
                savedSpotsFragment.launchMapView(savedSpotsFragment.spotsProvider.getSpot(r3));
            }
        });
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.my_recycler_view);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mRecyclerView.setAdapter(this.mSpotsAdapter);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.spotsProvider.unregisterSpotsProviderListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.spotsProvider.registerSpotsProviderListener(this);
        updateEditText();
    }

    @Override // com.animaconnected.watch.provider.SpotsProvider.SpotsProviderListener
    public void onSpotAdded(int r3) {
        this.mSpotsAdapter.onSpotAdded(r3, this.spotsProvider.getAllSpots());
        updateEditText();
    }

    @Override // com.animaconnected.watch.provider.SpotsProvider.SpotsProviderListener
    public void onSpotRemoved(int r3) {
        this.mSpotsAdapter.onSpotRemoved(r3, this.spotsProvider.getAllSpots());
        updateEditText();
    }

    @Override // com.animaconnected.watch.provider.SpotsProvider.SpotsProviderListener
    public void onSpotRenamed(int r3) {
        ProviderFactory.getAppAnalytics().sendAction(SPOT_RENAMED);
        this.mSpotsAdapter.onSpotNameUpdated(r3, this.spotsProvider.getAllSpots());
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView enableActionText = getToolbar().enableActionText(true);
        this.mActionText = enableActionText;
        enableActionText.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.rememberthisspot.spots.SavedSpotsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SavedSpotsFragment.this.lambda$onViewCreated$0(view, view2);
            }
        });
    }
}
