package com.animaconnected.secondo.screens.details.watch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.app.animation.WatchHandsAnimation;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.watch.imageprovider.WatchImageProvider;
import com.animaconnected.secondo.screens.watch.imageprovider.WatchImageProviderFactory;
import com.animaconnected.secondo.widget.WatchLayout;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.WatchFaceBehavior;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class DetailWatchPageFragment extends BaseDetailWatchPage {
    private static final String BEHAVIOUR_TYPE = "behaviour_type";
    private static final String FRAGMENT_SLOT = "fragment_slot";
    protected static final String LAYOUT_RESOURCE_ID = "layoutResourceId";
    private String mBehaviourType;
    private int mLayoutResourceId;
    private Slot mSlot;
    private WatchFaceBehavior mWatchFaceBehavior;
    private WatchImageProvider mWatchImageProvider;
    private WatchLayout mWatchLayout;

    public static DetailWatchPageFragment newInstance(int r3, Slot slot, String str) {
        DetailWatchPageFragment detailWatchPageFragment = new DetailWatchPageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(LAYOUT_RESOURCE_ID, r3);
        bundle.putSerializable(FRAGMENT_SLOT, slot);
        bundle.putString(BEHAVIOUR_TYPE, str);
        detailWatchPageFragment.setArguments(bundle);
        return detailWatchPageFragment;
    }

    private void setupWatchHandModel() {
        this.mWatchLayout.setWatchHandModel(new WatchHandsAnimation.WatchHandModel() { // from class: com.animaconnected.secondo.screens.details.watch.DetailWatchPageFragment.1
            @Override // com.animaconnected.secondo.app.animation.WatchHandsAnimation.WatchHandModel
            public float getHoursInDegrees() {
                return DetailWatchPageFragment.this.mWatchFaceBehavior.getHoursInDegrees(DetailWatchPageFragment.this.mSlot);
            }

            @Override // com.animaconnected.secondo.app.animation.WatchHandsAnimation.WatchHandModel
            public float getMinutesInDegrees() {
                return DetailWatchPageFragment.this.mWatchFaceBehavior.getMinutesInDegrees();
            }
        });
    }

    @Override // com.animaconnected.secondo.screens.details.watch.BaseDetailWatchPage, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mLayoutResourceId = arguments.getInt(LAYOUT_RESOURCE_ID);
            Slot slot = (Slot) arguments.getSerializable(FRAGMENT_SLOT);
            this.mSlot = slot;
            if (slot == null) {
                slot = Slot.Unknown;
            }
            this.mSlot = slot;
            this.mBehaviourType = arguments.getString(BEHAVIOUR_TYPE, null);
        }
        this.mWatchImageProvider = WatchImageProviderFactory.createWatchImageProvider();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.mLayoutResourceId, viewGroup, false);
        this.mWatchLayout = (WatchLayout) inflate.findViewById(R.id.imageViewMeterWatchHandContainer);
        this.mWatchFaceBehavior = (WatchFaceBehavior) ProviderFactory.getWatch().getBehaviours().getBehaviour(this.mBehaviourType);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setupWatchHandModel();
        ((ImageView) view.findViewById(R.id.imageViewMeter)).setImageResource(this.mWatchImageProvider.getWatchSubComplicationImageResource(this.mWatchFaceBehavior.getType(), this.mSlot));
        ((ImageView) view.findViewById(R.id.imageViewWatchHandHours)).setImageResource(this.mWatchImageProvider.getWatchDynamicImageHourHandResource(this.mWatchFaceBehavior.getType(), this.mSlot));
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewWatchHandMinutes);
        if (imageView != null) {
            imageView.setImageResource(this.mWatchImageProvider.getWatchDynamicImageMinuteHandResource(this.mWatchFaceBehavior.getType(), this.mSlot));
        }
    }

    @Override // com.animaconnected.secondo.screens.details.watch.BaseDetailWatchPage
    public void updateHands(boolean z) {
        WatchLayout watchLayout = this.mWatchLayout;
        if (watchLayout != null) {
            watchLayout.updateHands(z);
        }
    }
}
