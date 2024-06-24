package com.animaconnected.secondo.behaviour.ifttt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentDetailsIftttBinding;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottiePage;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingPagerAdapter;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.types.Ifttt;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: IftttFragment.kt */
/* loaded from: classes3.dex */
public final class IftttFragment extends BaseAnimationDetailsFragment {
    private FragmentDetailsIftttBinding binding;
    private Ifttt ifttt;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: IftttFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IftttFragment newInstance(Slot slot) {
            IftttFragment iftttFragment = new IftttFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("slot", slot);
            bundle.putString("type", Ifttt.TYPE);
            iftttFragment.setArguments(bundle);
            return iftttFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$lambda$1(IftttFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Ifttt ifttt = this$0.ifttt;
        if (ifttt != null) {
            ifttt.setLocationEnabled(z);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("ifttt");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Behaviour behaviour = getBehaviourPlugin().getBehaviour();
            Intrinsics.checkNotNull(behaviour, "null cannot be cast to non-null type com.animaconnected.watch.behaviour.types.Ifttt");
            this.ifttt = (Ifttt) behaviour;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentDetailsIftttBinding inflate = FragmentDetailsIftttBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        Button setupBtn = inflate.setupBtn;
        Intrinsics.checkNotNullExpressionValue(setupBtn, "setupBtn");
        onClick(setupBtn, new IftttFragment$onCreateView$1$1(this, null));
        SwitchCompat switchCompat = inflate.locationSwitch;
        Ifttt ifttt = this.ifttt;
        if (ifttt != null) {
            switchCompat.setChecked(ifttt.getLocationEnabled());
            inflate.locationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.animaconnected.secondo.behaviour.ifttt.IftttFragment$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    IftttFragment.onCreateView$lambda$2$lambda$1(IftttFragment.this, compoundButton, z);
                }
            });
            Ifttt ifttt2 = this.ifttt;
            if (ifttt2 != null) {
                FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new IftttFragment$onCreateView$1$3(inflate, null), ifttt2.isLoading()), new IftttFragment$onCreateView$1$4(null)), Hashing.getLifecycleScope(this));
                this.binding = inflate;
                LinearLayout root = inflate.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                return root;
            }
            Intrinsics.throwUninitializedPropertyAccessException("ifttt");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ifttt");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (getSlot() == Slot.NotInitialized) {
            View findViewById = view.findViewById(R.id.quick_action_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            ViewKt.gone(findViewById);
            FragmentDetailsIftttBinding fragmentDetailsIftttBinding = this.binding;
            if (fragmentDetailsIftttBinding != null) {
                ViewKt.gone(getLottieViewPager());
                LinearLayout locationCheckboxContainer = fragmentDetailsIftttBinding.locationCheckboxContainer;
                Intrinsics.checkNotNullExpressionValue(locationCheckboxContainer, "locationCheckboxContainer");
                ViewKt.gone(locationCheckboxContainer);
                LinearLayout iftttOverviewSection = fragmentDetailsIftttBinding.iftttOverviewSection;
                Intrinsics.checkNotNullExpressionValue(iftttOverviewSection, "iftttOverviewSection");
                ViewKt.gone(iftttOverviewSection);
                fragmentDetailsIftttBinding.iftttDescriptionTxt.setText(getString(R.string.ifttt_notification_description));
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
        }
        if (!getHasQuickAction()) {
            ListBuilder listBuilder = new ListBuilder();
            DetailLottiePage newInstance = DetailLottiePage.newInstance(selectAnimation(LottieFile.DvPusherIftttTop, LottieFile.DvPusherIftttBottom), R.string.ifttt_animation_title);
            Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
            listBuilder.add(newInstance);
            ListBuilder build = CollectionsKt__CollectionsKt.build(listBuilder);
            MiniOnboardingPagerAdapter miniOnboardingPagerAdapter = new MiniOnboardingPagerAdapter(getChildFragmentManager());
            miniOnboardingPagerAdapter.setData(build);
            getLottieViewPager().setAdapter(miniOnboardingPagerAdapter);
        }
    }
}
