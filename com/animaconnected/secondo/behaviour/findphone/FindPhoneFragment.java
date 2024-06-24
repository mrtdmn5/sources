package com.animaconnected.secondo.behaviour.findphone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottiePage;
import com.animaconnected.secondo.screens.detailspicker.FindPhonePickerFragment;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingPagerAdapter;
import com.animaconnected.watch.HybridWatch;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.types.FindPhone;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FindPhoneFragment.kt */
/* loaded from: classes3.dex */
public final class FindPhoneFragment extends BaseAnimationDetailsFragment {
    private FindPhone behaviour;
    private TextView soundTypeText;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: FindPhoneFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseDetailsFragment newInstance(Slot slot) {
            FindPhoneFragment findPhoneFragment = new FindPhoneFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(findPhoneFragment.getSLOT(), slot);
            bundle.putString(findPhoneFragment.getTYPE(), FindPhone.TYPE);
            findPhoneFragment.setArguments(bundle);
            return findPhoneFragment;
        }

        private Companion() {
        }
    }

    public static final void onViewCreated$lambda$0(FindPhoneFragment this$0, View view) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainController mainController = this$0.getMainController();
        FindPhonePickerFragment.Companion companion = FindPhonePickerFragment.Companion;
        BaseFragment parentBaseFragment = this$0.getParentBaseFragment();
        if (parentBaseFragment != null) {
            str = parentBaseFragment.getFeaturePathName();
        } else {
            str = null;
        }
        mainController.gotoNextFragment(companion.newInstance(str));
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_details_findphone, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TextView textView = this.soundTypeText;
        if (textView != null) {
            FindPhone findPhone = this.behaviour;
            if (findPhone != null) {
                textView.setText(getString(FindPhonePluginKt.getResource(findPhone.getUserPreferredMusic())));
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("behaviour");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("soundTypeText");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Behaviour behaviour = ProviderFactory.getWatch().getBehaviours().getBehaviour(FindPhone.TYPE);
        Intrinsics.checkNotNull(behaviour, "null cannot be cast to non-null type com.animaconnected.watch.behaviour.types.FindPhone");
        this.behaviour = (FindPhone) behaviour;
        View findViewById = view.findViewById(R.id.sound_type);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.soundTypeText = (TextView) findViewById;
        view.findViewById(R.id.set_sound_container).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.findphone.FindPhoneFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FindPhoneFragment.onViewCreated$lambda$0(FindPhoneFragment.this, view2);
            }
        });
        if (ProviderFactory.getWatch().getCapabilities().getHasMagicKeyOne() && (ProviderFactory.getWatch().getWatch() instanceof HybridWatch)) {
            view.findViewById(R.id.find_phone_description_always_available).setVisibility(0);
        }
        if (!getHasQuickAction()) {
            List<Fragment> listOf = CollectionsKt__CollectionsKt.listOf(DetailLottiePage.newInstance(selectAnimation(LottieFile.DvFindphoneTop, LottieFile.DvFindphoneBottom), R.string.find_phone_animation_description));
            MiniOnboardingPagerAdapter miniOnboardingPagerAdapter = new MiniOnboardingPagerAdapter(getChildFragmentManager());
            miniOnboardingPagerAdapter.setData(listOf);
            getLottieViewPager().setAdapter(miniOnboardingPagerAdapter);
        }
    }
}
