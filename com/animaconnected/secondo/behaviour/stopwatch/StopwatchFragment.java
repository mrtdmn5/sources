package com.animaconnected.secondo.behaviour.stopwatch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.stopwatch.session.SessionFragment;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.provider.stopwatch.DurationFormatter;
import com.animaconnected.secondo.provider.stopwatch.StopwatchProvider;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.screens.details.BaseDetailsFragmentKt;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottiePage;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottieViewPager;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingPagerAdapter;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.stopwatch.Stopwatch;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: StopwatchFragment.kt */
/* loaded from: classes3.dex */
public final class StopwatchFragment extends BaseDetailsFragment implements StopwatchProvider.LapsUpdateListener {
    private TextView lastSessionTimeText;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: StopwatchFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StopwatchFragment newInstance(Slot slot) {
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
            Bundle bundle = new Bundle();
            BaseDetailsFragmentKt.putSlot(bundle, "slot", slot);
            bundle.putString("type", Stopwatch.TYPE);
            stopwatchFragment.setArguments(bundle);
            return stopwatchFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(StopwatchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainController mainController = this$0.getMainController();
        SessionFragment newInstance = SessionFragment.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        mainController.gotoNextFragment(newInstance);
    }

    private final void updateLastSessionTime() {
        TextView textView = this.lastSessionTimeText;
        if (textView != null) {
            textView.setText(DurationFormatter.millisecondsToString(StopwatchProvider.getInstance().getTotalTime()));
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("lastSessionTimeText");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_details_stopwatch, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.last_session_time);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.lastSessionTimeText = (TextView) findViewById;
        inflate.findViewById(R.id.last_session_button).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.stopwatch.StopwatchFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StopwatchFragment.onCreateView$lambda$0(StopwatchFragment.this, view);
            }
        });
        if (getHasQuickAction()) {
            inflate.findViewById(R.id.content_without_description).setVisibility(8);
            inflate.findViewById(R.id.last_session_title).setVisibility(8);
            inflate.findViewById(R.id.last_session_button).setVisibility(8);
        } else {
            BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new StopwatchFragment$onCreateView$2(this, null), 3);
            DetailLottiePage newInstance = DetailLottiePage.newInstance(LottieFile.DvStopwatch1, R.string.stopwatch_animation_title_using_stopwatch);
            Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
            DetailLottiePage newInstance2 = DetailLottiePage.newInstance(LottieFile.DvStopwatch2, R.string.stopwatch_animation_title_using_laps);
            Intrinsics.checkNotNullExpressionValue(newInstance2, "newInstance(...)");
            ArrayList mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(newInstance, newInstance2);
            MiniOnboardingPagerAdapter miniOnboardingPagerAdapter = new MiniOnboardingPagerAdapter(getChildFragmentManager());
            miniOnboardingPagerAdapter.setData(mutableListOf);
            View findViewById2 = inflate.findViewById(R.id.mini_onboarding_pager);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottieViewPager");
            ((DetailLottieViewPager) findViewById2).setAdapter(miniOnboardingPagerAdapter);
        }
        return inflate;
    }

    @Override // com.animaconnected.secondo.provider.stopwatch.StopwatchProvider.LapsUpdateListener
    public void onLapsUpdated() {
        updateLastSessionTime();
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
        updateLastSessionTime();
    }
}
