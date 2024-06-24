package com.animaconnected.secondo.screens.campaigns;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.campaign.CampaignProvider;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.provider.lottie.LottieKt;
import com.animaconnected.watch.display.DpUtils;
import com.kronaby.watch.app.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DashboardMarbleView.kt */
/* loaded from: classes3.dex */
public final class DashboardMarbleView extends RelativeLayout {
    public static final int $stable = 8;
    private ValueAnimator alphaAnimator;
    private LottieAnimationView animationView;

    /* compiled from: DashboardMarbleView.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.campaigns.DashboardMarbleView$3", f = "DashboardMarbleView.kt", l = {66}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.campaigns.DashboardMarbleView$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ DashboardMarbleView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context, DashboardMarbleView dashboardMarbleView, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$context = context;
            this.this$0 = dashboardMarbleView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$context, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Context context = this.$context;
                LottieFile lottieFile = LottieFile.CampaignGiftHintSplash;
                this.label = 1;
                obj = LottieKt.loadLottieAnimation(context, lottieFile, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            LottieComposition lottieComposition = (LottieComposition) obj;
            if (lottieComposition == null) {
                return Unit.INSTANCE;
            }
            this.this$0.animationView.setComposition(lottieComposition);
            this.this$0.animationView.setRepeatCount(-1);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public DashboardMarbleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void hide() {
        if (getVisibility() == 8) {
            return;
        }
        ValueAnimator valueAnimator = this.alphaAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<DashboardMarbleView, Float>) View.ALPHA, getAlpha(), 0.0f);
        ofFloat.setDuration(100L);
        ofFloat.start();
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.animaconnected.secondo.screens.campaigns.DashboardMarbleView$hide$lambda$6$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LottieAnimationView lottieAnimationView = DashboardMarbleView.this.animationView;
                lottieAnimationView.autoPlay = false;
                lottieAnimationView.lottieDrawable.pauseAnimation();
                DashboardMarbleView.this.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.alphaAnimator = ofFloat;
    }

    public final void show() {
        boolean isCampaignEnabled = CampaignProvider.INSTANCE.isCampaignEnabled(CampaignProvider.PROMOTION_ID);
        if (getVisibility() == 8 && isCampaignEnabled) {
            setVisibility(0);
            this.animationView.playAnimation();
            ValueAnimator valueAnimator = this.alphaAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<DashboardMarbleView, Float>) View.ALPHA, getAlpha(), 1.0f);
            ofFloat.setStartDelay(250L);
            ofFloat.setDuration(100L);
            ofFloat.start();
            this.alphaAnimator = ofFloat;
            ProviderFactory.getAppAnalytics().giftShown();
        }
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public DashboardMarbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DashboardMarbleView(Context context, AttributeSet attributeSet, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (r4 & 2) != 0 ? null : attributeSet, (r4 & 4) != 0 ? 0 : r3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DashboardMarbleView(Context context, AttributeSet attributeSet, int r5) {
        super(context, attributeSet, r5);
        Intrinsics.checkNotNullParameter(context, "context");
        setVisibility(8);
        DpUtils dpUtils = DpUtils.INSTANCE;
        setTranslationY(dpUtils.dpToPx(context, -32.0f));
        setTranslationX(dpUtils.dpToPx(context, 32.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(12, -1);
        setLayoutParams(layoutParams);
        View imageView = new ImageView(context);
        Object obj = ContextCompat.sLock;
        imageView.setBackground(ContextCompat.Api21Impl.getDrawable(context, R.drawable.dashboard_marble));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        imageView.setLayoutParams(layoutParams2);
        addView(imageView);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        lottieAnimationView.setRepeatCount(0);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        lottieAnimationView.setLayoutParams(layoutParams3);
        this.animationView = lottieAnimationView;
        BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new AnonymousClass3(context, this, null), 3);
        addView(this.animationView);
        setAlpha(0.0f);
    }
}
