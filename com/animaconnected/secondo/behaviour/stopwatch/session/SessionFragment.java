package com.animaconnected.secondo.behaviour.stopwatch.session;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.secondo.provider.stopwatch.DurationFormatter;
import com.animaconnected.secondo.provider.stopwatch.Lap;
import com.animaconnected.secondo.provider.stopwatch.StopwatchProvider;
import com.animaconnected.secondo.screens.BaseFragment;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SessionFragment extends BaseFragment implements StopwatchProvider.LapsUpdateListener {
    private LapsAdapter mLapsAdapter;
    private TextView mTotalViewText;

    public static SessionFragment newInstance() {
        return new SessionFragment();
    }

    private void update() {
        List<Lap> allLaps = StopwatchProvider.getInstance().getAllLaps();
        this.mTotalViewText.setText(DurationFormatter.millisecondsToString(StopwatchProvider.getInstance().getTotalTime()));
        if (allLaps.size() > 1) {
            this.mLapsAdapter.setLaps(allLaps);
        } else {
            this.mLapsAdapter.setLaps(new ArrayList());
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return getString(R.string.feature_path_complications);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "StopwatchSessionFragment";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_stopwatch_session, viewGroup, false);
        this.mTotalViewText = (TextView) inflate.findViewById(R.id.total_time);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.laps_recycler_view);
        this.mLapsAdapter = new LapsAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(this.mLapsAdapter);
        return inflate;
    }

    @Override // com.animaconnected.secondo.provider.stopwatch.StopwatchProvider.LapsUpdateListener
    public void onLapsUpdated() {
        update();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        StopwatchProvider.getInstance().unregisterLapsUpdateListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        StopwatchProvider.getInstance().registerLapsUpdateListener(this);
        update();
    }
}
