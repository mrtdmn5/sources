package com.animaconnected.secondo.screens.tipsandtricks;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.airbnb.lottie.LottieAnimationView;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TipsAndTricksPageTextAnimationFragment.kt */
/* loaded from: classes3.dex */
public final class TipsAndTricksPageTextAnimationFragment extends TipsAndTricksPageFragment {
    private static final String DESCRIPTION_LAYOUT_RESOURCE_ID_SHORT_1 = "descriptionLayoutResourceIdShort1";
    private static final String DESCRIPTION_LAYOUT_RESOURCE_ID_SHORT_2 = "descriptionLayoutResourceIdShort2";
    private static final float FADED_ALPHA = 0.3f;
    private static final long FADE_DURATION = 200;
    private static final String FRAME_ANIMATION_CHANGE = "frameAnimationChange";
    private int mDescriptionResourceIdShort1;
    private int mDescriptionResourceIdShort2;
    private TextView mDescriptionShort1;
    private TextView mDescriptionShort2;
    private float mFrameAnimationChange;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: TipsAndTricksPageTextAnimationFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TipsAndTricksPageTextAnimationFragment newInstance(TipsAndTricksTextAnimationModel tipsAndTricksTextAnimationModel) {
            Intrinsics.checkNotNullParameter(tipsAndTricksTextAnimationModel, "tipsAndTricksTextAnimationModel");
            TipsAndTricksPageTextAnimationFragment tipsAndTricksPageTextAnimationFragment = new TipsAndTricksPageTextAnimationFragment();
            Bundle tipsAndTricksModelToBundle = TipsAndTricksPageFragment.tipsAndTricksModelToBundle(tipsAndTricksTextAnimationModel, R.layout.tips_and_tricks_settings_page_text_animations_fragment, false);
            tipsAndTricksModelToBundle.putFloat(TipsAndTricksPageTextAnimationFragment.FRAME_ANIMATION_CHANGE, tipsAndTricksTextAnimationModel.getFrameAnimationChange());
            tipsAndTricksModelToBundle.putInt(TipsAndTricksPageTextAnimationFragment.DESCRIPTION_LAYOUT_RESOURCE_ID_SHORT_1, tipsAndTricksTextAnimationModel.getDescriptionResourceIdAnimation1());
            tipsAndTricksModelToBundle.putInt(TipsAndTricksPageTextAnimationFragment.DESCRIPTION_LAYOUT_RESOURCE_ID_SHORT_2, tipsAndTricksTextAnimationModel.getDescriptionResourceIdAnimation2());
            tipsAndTricksPageTextAnimationFragment.setArguments(tipsAndTricksModelToBundle);
            return tipsAndTricksPageTextAnimationFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(ViewFadeInOutAnimationController viewFadeInOutAnimationController1, ViewFadeInOutAnimationController viewFadeInOutAnimationController2, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(viewFadeInOutAnimationController1, "$viewFadeInOutAnimationController1");
        Intrinsics.checkNotNullParameter(viewFadeInOutAnimationController2, "$viewFadeInOutAnimationController2");
        Intrinsics.checkNotNullParameter(animation, "animation");
        float animatedFraction = animation.getAnimatedFraction();
        viewFadeInOutAnimationController1.update(animatedFraction);
        viewFadeInOutAnimationController2.update(animatedFraction);
    }

    @Override // com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPageFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPageFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrameAnimationChange = arguments.getFloat(FRAME_ANIMATION_CHANGE);
            this.mDescriptionResourceIdShort1 = arguments.getInt(DESCRIPTION_LAYOUT_RESOURCE_ID_SHORT_1);
            this.mDescriptionResourceIdShort2 = arguments.getInt(DESCRIPTION_LAYOUT_RESOURCE_ID_SHORT_2);
        }
    }

    @Override // com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPageFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        Intrinsics.checkNotNull(onCreateView);
        View findViewById = onCreateView.findViewById(R.id.tips_and_tricks_description_short_1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.mDescriptionShort1 = textView;
        textView.setText(this.mDescriptionResourceIdShort1);
        View findViewById2 = onCreateView.findViewById(R.id.tips_and_tricks_description_short_2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        TextView textView2 = (TextView) findViewById2;
        this.mDescriptionShort2 = textView2;
        textView2.setText(this.mDescriptionResourceIdShort2);
        TextView textView3 = this.mDescriptionShort1;
        if (textView3 != null) {
            final ViewFadeInOutAnimationController viewFadeInOutAnimationController = new ViewFadeInOutAnimationController(textView3, 0.0f, this.mFrameAnimationChange, 200L, FADED_ALPHA, false);
            TextView textView4 = this.mDescriptionShort2;
            if (textView4 != null) {
                final ViewFadeInOutAnimationController viewFadeInOutAnimationController2 = new ViewFadeInOutAnimationController(textView4, this.mFrameAnimationChange, 1.0f, 200L, FADED_ALPHA, true);
                LottieAnimationView lottieAnimationView = getLottieAnimationView();
                Intrinsics.checkNotNull(lottieAnimationView);
                lottieAnimationView.lottieDrawable.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPageTextAnimationFragment$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TipsAndTricksPageTextAnimationFragment.onCreateView$lambda$0(ViewFadeInOutAnimationController.this, viewFadeInOutAnimationController2, valueAnimator);
                    }
                });
                return onCreateView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mDescriptionShort2");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDescriptionShort1");
        throw null;
    }
}
