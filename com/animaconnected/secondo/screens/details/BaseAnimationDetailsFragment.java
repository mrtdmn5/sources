package com.animaconnected.secondo.screens.details;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottieViewPager;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseAnimationDetailsFragment.kt */
/* loaded from: classes3.dex */
public abstract class BaseAnimationDetailsFragment extends BaseDetailsFragment {
    public static final int $stable = 8;
    protected DetailLottieViewPager lottieViewPager;

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public final DetailLottieViewPager getLottieViewPager() {
        DetailLottieViewPager detailLottieViewPager = this.lottieViewPager;
        if (detailLottieViewPager != null) {
            return detailLottieViewPager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lottieViewPager");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.lottie_animation_pager);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        setLottieViewPager((DetailLottieViewPager) findViewById);
        if (!getHasQuickAction()) {
            ViewKt.visible(getLottieViewPager());
        }
    }

    public final LottieFile selectAnimation(LottieFile top, LottieFile bottom) {
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        if (getSlot() == Slot.BottomPusher) {
            return bottom;
        }
        return top;
    }

    public final void setLottieViewPager(DetailLottieViewPager detailLottieViewPager) {
        Intrinsics.checkNotNullParameter(detailLottieViewPager, "<set-?>");
        this.lottieViewPager = detailLottieViewPager;
    }
}
