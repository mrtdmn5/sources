package com.animaconnected.secondo.behaviour.camera;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.screens.details.BaseDetailsFragmentKt;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottiePage;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingPagerAdapter;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.types.Camera;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraFragment.kt */
/* loaded from: classes3.dex */
public final class CameraFragment extends BaseAnimationDetailsFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: CameraFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseDetailsFragment newInstance(Slot slot) {
            CameraFragment cameraFragment = new CameraFragment();
            Bundle bundle = new Bundle();
            BaseDetailsFragmentKt.putSlot(bundle, "slot", slot);
            bundle.putString("type", Camera.TYPE);
            cameraFragment.setArguments(bundle);
            return cameraFragment;
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_details_camera, viewGroup, false);
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (!getHasQuickAction()) {
            DetailLottiePage newInstance = DetailLottiePage.newInstance(selectAnimation(LottieFile.DvCameraTop, LottieFile.DvCameraBottom), R.string.camera_animation_description);
            Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
            List<Fragment> listOf = CollectionsKt__CollectionsKt.listOf(newInstance);
            MiniOnboardingPagerAdapter miniOnboardingPagerAdapter = new MiniOnboardingPagerAdapter(getChildFragmentManager());
            miniOnboardingPagerAdapter.setData(listOf);
            getLottieViewPager().setAdapter(miniOnboardingPagerAdapter);
        }
    }
}
