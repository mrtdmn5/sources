package com.animaconnected.secondo.screens.tipsandtricks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.behaviour.time.TimeFragment$$ExternalSyntheticLambda0;
import com.animaconnected.secondo.provider.lottie.Lottie;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.kronaby.watch.app.R;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TipsAndTricksPageFragment.kt */
/* loaded from: classes3.dex */
public class TipsAndTricksPageFragment extends Fragment {
    protected static final String DESCRIPTION_LAYOUT_RESOURCE_ID_LONG = "descriptionLayoutResourceIdLong";
    protected static final String DESCRIPTION_LAYOUT_RESOURCE_ID_SHORT = "descriptionLayoutResourceIdShort";
    protected static final String LAYOUT_RESOURCE_ID = "layoutResourceId";
    protected static final String LOOP = "loop";
    protected static final String LOTTIE_FILE = "lottieFile";
    protected static final String NAME = "name";
    private static final int RESOURCE_ID_NOT_USED = -1;
    protected static final String TITLE_LAYOUT_RESOURCE_ID = "titlteLayoutResourceId";
    protected static final String URL = "url";
    private int descriptionResourceIdLong;
    private int descriptionResourceIdShort;
    private int layoutResourceId;
    private boolean loop;
    private LottieAnimationView lottieAnimationView;
    private LottieFile lottieFile;
    private String name;
    private boolean shouldStartAnimation;
    private int titleResourceId;
    private String url;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: TipsAndTricksPageFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TipsAndTricksPageFragment newInstance(TipsAndTricksModel tipsAndTricksModel) {
            Intrinsics.checkNotNullParameter(tipsAndTricksModel, "tipsAndTricksModel");
            TipsAndTricksPageFragment tipsAndTricksPageFragment = new TipsAndTricksPageFragment();
            tipsAndTricksPageFragment.setArguments(TipsAndTricksPageFragment.tipsAndTricksModelToBundle(tipsAndTricksModel, R.layout.tips_and_tricks_settings_page_fragment, false));
            return tipsAndTricksPageFragment;
        }

        public final Bundle tipsAndTricksModelToBundle(TipsAndTricksModel tipsAndTricksModel, int r5, boolean z) {
            int r1;
            Intrinsics.checkNotNullParameter(tipsAndTricksModel, "<this>");
            Bundle bundle = new Bundle();
            bundle.putString("name", tipsAndTricksModel.getName());
            bundle.putInt(TipsAndTricksPageFragment.TITLE_LAYOUT_RESOURCE_ID, tipsAndTricksModel.getTitleResourceId());
            bundle.putInt(TipsAndTricksPageFragment.DESCRIPTION_LAYOUT_RESOURCE_ID_LONG, tipsAndTricksModel.getDescriptionResourceIdLong());
            Integer descriptionResourceIdShort = tipsAndTricksModel.getDescriptionResourceIdShort();
            if (descriptionResourceIdShort != null) {
                r1 = descriptionResourceIdShort.intValue();
            } else {
                r1 = -1;
            }
            bundle.putInt(TipsAndTricksPageFragment.DESCRIPTION_LAYOUT_RESOURCE_ID_SHORT, r1);
            bundle.putString("url", tipsAndTricksModel.getUrl());
            bundle.putSerializable(TipsAndTricksPageFragment.LOTTIE_FILE, tipsAndTricksModel.getLottieFile());
            bundle.putInt(TipsAndTricksPageFragment.LAYOUT_RESOURCE_ID, r5);
            bundle.putBoolean(TipsAndTricksPageFragment.LOOP, z);
            return bundle;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$lambda$4$lambda$3(TipsAndTricksPageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onDescriptionShortClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$lambda$5(TipsAndTricksPageFragment this$0, ProgressBar setupProgressBar, LottieComposition result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(setupProgressBar, "$setupProgressBar");
        Intrinsics.checkNotNullParameter(result, "result");
        LottieAnimationView lottieAnimationView = this$0.lottieAnimationView;
        Intrinsics.checkNotNull(lottieAnimationView);
        lottieAnimationView.setComposition(result);
        setupProgressBar.setVisibility(4);
        lottieAnimationView.setVisibility(0);
        if (this$0.loop) {
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.playAnimation();
        }
    }

    private final void onDescriptionShortClicked() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.url)));
    }

    public static final Bundle tipsAndTricksModelToBundle(TipsAndTricksModel tipsAndTricksModel, int r2, boolean z) {
        return Companion.tipsAndTricksModelToBundle(tipsAndTricksModel, r2, z);
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public final LottieAnimationView getLottieAnimationView() {
        return this.lottieAnimationView;
    }

    public final String getName() {
        return this.name;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.layoutResourceId = arguments.getInt(LAYOUT_RESOURCE_ID);
            this.name = arguments.getString("name");
            Serializable serializable = arguments.getSerializable(LOTTIE_FILE);
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.animaconnected.secondo.provider.lottie.LottieFile");
            this.lottieFile = (LottieFile) serializable;
            this.titleResourceId = arguments.getInt(TITLE_LAYOUT_RESOURCE_ID);
            this.descriptionResourceIdLong = arguments.getInt(DESCRIPTION_LAYOUT_RESOURCE_ID_LONG);
            this.descriptionResourceIdShort = arguments.getInt(DESCRIPTION_LAYOUT_RESOURCE_ID_SHORT);
            this.url = arguments.getString("url");
            this.loop = arguments.getBoolean(LOOP);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int r2, boolean z, int r4) {
        Fragment parentFragment = getParentFragment();
        if (!z && parentFragment != null && parentFragment.isRemoving()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
            alphaAnimation.setDuration(requireContext().getResources().getInteger(R.integer.screen_transition_duration_horizontal));
            return alphaAnimation;
        }
        return super.onCreateAnimation(r2, z, r4);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(this.layoutResourceId, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.tips_and_tricks_title)).setText(this.titleResourceId);
        ((TextView) inflate.findViewById(R.id.tips_and_tricks_description_long)).setText(this.descriptionResourceIdLong);
        if (this.descriptionResourceIdShort != -1) {
            TextView textView = (TextView) inflate.findViewById(R.id.tips_and_tricks_description_short);
            textView.setText(this.descriptionResourceIdShort);
            if (this.url != null) {
                textView.setOnClickListener(new TimeFragment$$ExternalSyntheticLambda0(this, 1));
            }
        }
        this.lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.animation_view_in);
        View findViewById = inflate.findViewById(R.id.setup_progressbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        final ProgressBar progressBar = (ProgressBar) findViewById;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        LottieFile lottieFile = this.lottieFile;
        if (lottieFile != null) {
            Lottie.loadAnimation(requireContext, lottieFile).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPageFragment$$ExternalSyntheticLambda0
                @Override // com.animaconnected.future.SuccessCallback
                public final void onSuccess(Object obj) {
                    TipsAndTricksPageFragment.onCreateView$lambda$6$lambda$5(TipsAndTricksPageFragment.this, progressBar, (LottieComposition) obj);
                }
            });
            if (this.shouldStartAnimation) {
                startAnimation();
                this.shouldStartAnimation = false;
            }
            return inflate;
        }
        Intrinsics.throwUninitializedPropertyAccessException(LOTTIE_FILE);
        throw null;
    }

    public final void setLottieAnimationView(LottieAnimationView lottieAnimationView) {
        this.lottieAnimationView = lottieAnimationView;
    }

    public final void startAnimation() {
        LottieAnimationView lottieAnimationView = this.lottieAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.playAnimation();
        } else {
            new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPageFragment$startAnimation$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    TipsAndTricksPageFragment.this.shouldStartAnimation = true;
                }
            };
        }
    }

    public final void stopAnimation() {
        LottieAnimationView lottieAnimationView = this.lottieAnimationView;
        Intrinsics.checkNotNull(lottieAnimationView);
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setProgress(0.0f);
    }
}
