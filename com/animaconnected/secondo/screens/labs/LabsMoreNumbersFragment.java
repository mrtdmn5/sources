package com.animaconnected.secondo.screens.labs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.airbnb.lottie.LottieAnimationView;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.labs.LabsProvider;
import com.animaconnected.secondo.screens.BaseFragment;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: LabsMoreNumbersFragment.kt */
/* loaded from: classes3.dex */
public final class LabsMoreNumbersFragment extends BaseFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    public static final String DISABLED_ANALYTICS = "more_numbers_disabled";
    public static final String ENABLED_ANALYTICS = "more_numbers_enabled";
    private final String name = "labsFilterNotification";

    /* compiled from: LabsMoreNumbersFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LabsMoreNumbersFragment newInstance() {
            return new LabsMoreNumbersFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$lambda$0(LabsProvider labsProvider, CompoundButton compoundButton, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(labsProvider, "$labsProvider");
        labsProvider.enableMoreNumbers(z);
        AppEvents appAnalytics = ProviderFactory.getAppAnalytics();
        if (z) {
            str = ENABLED_ANALYTICS;
        } else {
            str = DISABLED_ANALYTICS;
        }
        appAnalytics.sendAction(str);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_labs_more_numbers, viewGroup, false);
        final LabsProvider labsProvider = ProviderFactory.getLabsProvider();
        SwitchCompat switchCompat = (SwitchCompat) inflate.findViewById(R.id.more_numbers_switch);
        switchCompat.setChecked(labsProvider.isMoreNumbersEnabled());
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.animaconnected.secondo.screens.labs.LabsMoreNumbersFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LabsMoreNumbersFragment.onCreateView$lambda$1$lambda$0(LabsProvider.this, compoundButton, z);
            }
        });
        View findViewById = inflate.findViewById(R.id.lottie_animation_view);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new LabsMoreNumbersFragment$onCreateView$2(this, (LottieAnimationView) findViewById, inflate.findViewById(R.id.setup_progressbar), null), 3);
        return inflate;
    }
}
