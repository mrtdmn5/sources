package com.animaconnected.secondo.screens.details;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.animaconnected.info.DeviceType;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.ThemeProviderBase;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.FeedbackView;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.secondo.utils.UIUtility;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.secondo.widget.MorseCodeView;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.display.QuickActionType;
import com.animaconnected.watch.display.WatchApp;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.BuildersKt;

/* compiled from: BaseDetailsFragment.kt */
/* loaded from: classes3.dex */
public abstract class BaseDetailsFragment extends Fragment {
    public static final String SLOT = "slot";
    public static final String TYPE = "type";
    private boolean quickActionVisible;
    protected Slot slot;
    protected String type;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String SLOT$1 = "slot";
    private final String TYPE$1 = "type";
    private final Lazy watch$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WatchProvider>() { // from class: com.animaconnected.secondo.screens.details.BaseDetailsFragment$watch$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WatchProvider invoke() {
            return ProviderFactory.getWatch();
        }
    });

    /* compiled from: BaseDetailsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final WatchProvider getWatch() {
        return (WatchProvider) this.watch$delegate.getValue();
    }

    public static final void onClick$lambda$9(BaseDetailsFragment this$0, Function2 onClick, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        BuildersKt.launch$default(Hashing.getLifecycleScope(this$0), null, null, new BaseDetailsFragment$onClick$1$1(onClick, view, null), 3);
    }

    public static final void onViewCreated$lambda$4(BaseDetailsFragment this$0, Function0 updateViews, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(updateViews, "$updateViews");
        this$0.quickActionVisible = !this$0.quickActionVisible;
        updateViews.invoke();
    }

    private final void setupQuickActionButton(View view) {
        WatchApp watchApp;
        final String string = getString(getBehaviourPlugin().getNameId());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Behaviour behaviour = getBehaviourPlugin().getBehaviour();
        if (behaviour instanceof WatchApp) {
            watchApp = (WatchApp) behaviour;
        } else {
            watchApp = null;
        }
        if (watchApp == null || watchApp.getQuickActionType() == QuickActionType.None) {
            return;
        }
        final Button button = (Button) view.findViewById(R.id.assign_to_quick_action_btn);
        final Button button2 = (Button) view.findViewById(R.id.unassign_to_quick_action_btn);
        final TextView textView = (TextView) view.findViewById(R.id.quick_action_btn_description);
        final WatchApp watchApp2 = watchApp;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.details.BaseDetailsFragment$setupQuickActionButton$updateVisibility$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                WatchProvider watch;
                String string2;
                watch = BaseDetailsFragment.this.getWatch();
                WatchApp quickAction = watch.getWatchManager().getBehaviours().getQuickAction();
                if ((quickAction != null ? quickAction.getId() : null) == watchApp2.getId()) {
                    Button assignQABtn = button;
                    Intrinsics.checkNotNullExpressionValue(assignQABtn, "$assignQABtn");
                    ViewKt.gone(assignQABtn);
                    Button unAssignQABtn = button2;
                    Intrinsics.checkNotNullExpressionValue(unAssignQABtn, "$unAssignQABtn");
                    ViewKt.visible(unAssignQABtn);
                    textView.setText(BaseDetailsFragment.this.getString(R.string.quick_action_unassign_description, string));
                    return;
                }
                Button assignQABtn2 = button;
                Intrinsics.checkNotNullExpressionValue(assignQABtn2, "$assignQABtn");
                ViewKt.visible(assignQABtn2);
                Button unAssignQABtn2 = button2;
                Intrinsics.checkNotNullExpressionValue(unAssignQABtn2, "$unAssignQABtn");
                ViewKt.gone(unAssignQABtn2);
                TextView textView2 = textView;
                if (quickAction == null) {
                    string2 = BaseDetailsFragment.this.getString(R.string.quick_action_assign_description, string);
                } else {
                    BaseDetailsFragment baseDetailsFragment = BaseDetailsFragment.this;
                    Object[] objArr = new Object[1];
                    BehaviourPlugin<Behaviour> plugin = ProviderFactory.getBehaviourFactory().getPlugin(quickAction.getType());
                    objArr[0] = baseDetailsFragment.getString(plugin != null ? plugin.getNameId() : R.string.behaviour_name_empty);
                    string2 = baseDetailsFragment.getString(R.string.quick_action_replace_description, objArr);
                }
                textView2.setText(string2);
            }
        };
        BaseFragmentUtilsKt.launchOnStarted(this, new BaseDetailsFragment$setupQuickActionButton$1(this, function0, null));
        View view2 = (Button) view.findViewById(R.id.assign_to_quick_action_btn);
        Intrinsics.checkNotNull(view2);
        onClick(view2, new BaseDetailsFragment$setupQuickActionButton$2$1(this, watchApp, function0, null));
        Button button3 = (Button) view.findViewById(R.id.unassign_to_quick_action_btn);
        button3.setText(getString(R.string.quick_action_unassign));
        onClick(button3, new BaseDetailsFragment$setupQuickActionButton$3$1(this, watchApp, function0, null));
    }

    public final BehaviourPlugin<Behaviour> getBehaviourPlugin() {
        BehaviourPlugin<Behaviour> plugin = ProviderFactory.getBehaviourFactory().getPlugin(getType());
        if (plugin != null) {
            return plugin;
        }
        throw new IllegalArgumentException("Behaviour has no plugin".toString());
    }

    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public final boolean getHasQuickAction() {
        DeviceType deviceType = getWatch().getDeviceType();
        if (deviceType == null || !deviceType.getHasDisplay()) {
            return false;
        }
        return true;
    }

    public final MainController getMainController() {
        BaseFragment parentBaseFragment = getParentBaseFragment();
        Intrinsics.checkNotNull(parentBaseFragment);
        return parentBaseFragment.getMainController();
    }

    public final BaseFragment getParentBaseFragment() {
        return (BaseFragment) getParentFragment();
    }

    public final String getSLOT() {
        return this.SLOT$1;
    }

    public final Slot getSlot() {
        Slot slot = this.slot;
        if (slot != null) {
            return slot;
        }
        Intrinsics.throwUninitializedPropertyAccessException("slot");
        throw null;
    }

    public final String getTYPE() {
        return this.TYPE$1;
    }

    public final String getType() {
        String str = this.type;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("type");
        throw null;
    }

    public final void onClick(View view, final Function2<? super View, ? super Continuation<? super Unit>, ? extends Object> onClick) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.details.BaseDetailsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseDetailsFragment.onClick$lambda$9(BaseDetailsFragment.this, onClick, view2);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Slot slot;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable(this.SLOT$1);
            if (serializable instanceof Slot) {
                slot = (Slot) serializable;
            } else {
                slot = null;
            }
            if (slot == null) {
                slot = Slot.Unknown;
            }
            setSlot(slot);
            String string = arguments.getString(this.TYPE$1);
            if (string != null) {
                setType(string);
                return;
            }
            throw new IllegalArgumentException("Type is required for detail fragment".toString());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int r1, boolean z, int r3) {
        return AnimationUtils.loadAnimation(getContext(), R.anim.none);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        String str;
        int r0;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (ProviderFactory.getLabsProvider().isBehaviourTypeLabs(getType())) {
            ImageView imageView = (ImageView) view.findViewById(R.id.feature_icon);
            if (imageView != null) {
                Context requireContext = requireContext();
                int iconResourceId = getBehaviourPlugin().getIconResourceId();
                Object obj = ContextCompat.sLock;
                Drawable drawable = ContextCompat.Api21Impl.getDrawable(requireContext, iconResourceId);
                if (drawable != null) {
                    UIUtility.setColorIntFilter(drawable, -1, BlendModeCompat.SRC_IN);
                }
                imageView.setImageDrawable(drawable);
            }
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.detail_layout);
            if (viewGroup != null) {
                Context requireContext2 = requireContext();
                Object obj2 = ContextCompat.sLock;
                viewGroup.setBackgroundColor(ContextCompat.Api23Impl.getColor(requireContext2, R.color.labs_color));
            }
        }
        ImageView imageView2 = (ImageView) view.findViewById(R.id.overview_end_line);
        if (imageView2 != null) {
            ThemeProviderBase.Companion companion = ThemeProviderBase.Companion;
            Context requireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
            if (companion.getBoolean(requireContext3, R.attr.detailOverviewEndLineVisible)) {
                r0 = 0;
            } else {
                r0 = 8;
            }
            imageView2.setVisibility(r0);
        }
        MorseCodeView morseCodeView = (MorseCodeView) view.findViewById(R.id.crown_press_morse);
        if (morseCodeView != null) {
            if (getSlot() == Slot.MainComplicationDouble) {
                str = "..";
            } else {
                str = InstructionFileId.DOT;
            }
            morseCodeView.setPattern(str);
        }
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        ref$FloatRef.element = 180.0f;
        if (getHasQuickAction()) {
            View findViewById = view.findViewById(R.id.quick_action_container);
            if (findViewById != null) {
                ViewKt.visible(findViewById);
            }
            setupQuickActionButton(view);
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.details.BaseDetailsFragment$onViewCreated$updateViews$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    boolean z;
                    ViewPropertyAnimator animate;
                    ViewPropertyAnimator rotation;
                    ViewPropertyAnimator duration;
                    Ref$FloatRef ref$FloatRef2 = Ref$FloatRef.this;
                    ref$FloatRef2.element = (ref$FloatRef2.element > 180.0f ? 1 : (ref$FloatRef2.element == 180.0f ? 0 : -1)) == 0 ? 0.0f : 180.0f;
                    z = this.quickActionVisible;
                    int r3 = z ? 0 : 8;
                    View findViewById2 = view.findViewById(R.id.iv_chevron);
                    if (findViewById2 != null && (animate = findViewById2.animate()) != null && (rotation = animate.rotation(Ref$FloatRef.this.element)) != null && (duration = rotation.setDuration(150L)) != null) {
                        duration.start();
                    }
                    View findViewById3 = view.findViewById(R.id.quick_action_description);
                    if (findViewById3 != null) {
                        findViewById3.setVisibility(r3);
                    }
                    View findViewById4 = view.findViewById(R.id.quick_action_description_long_press);
                    if (findViewById4 != null) {
                        findViewById4.setVisibility(r3);
                    }
                    View findViewById5 = view.findViewById(R.id.quick_action_assign_container);
                    if (findViewById5 != null) {
                        findViewById5.setVisibility(r3);
                    }
                    View findViewById6 = view.findViewById(R.id.trigger_container);
                    if (findViewById6 != null) {
                        findViewById6.setVisibility(r3);
                    }
                    View findViewById7 = view.findViewById(R.id.morse_legends);
                    if (findViewById7 == null) {
                        return;
                    }
                    findViewById7.setVisibility(r3);
                }
            };
            View findViewById2 = view.findViewById(R.id.quick_action_header);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.details.BaseDetailsFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        BaseDetailsFragment.onViewCreated$lambda$4(BaseDetailsFragment.this, function0, view2);
                    }
                });
            }
            function0.invoke();
        } else {
            TextView textView = (TextView) view.findViewById(R.id.pusher_header_title);
            if (textView != null) {
                ViewKt.visible(textView);
                if (getSlot() == Slot.BottomPusher) {
                    textView.setText(R.string.bottom_pusher);
                } else if (getSlot() == Slot.TopPusher) {
                    textView.setText(R.string.top_pusher);
                }
            }
        }
        FeedbackView feedbackView = (FeedbackView) view.findViewById(R.id.feedback_view);
        if (feedbackView != null) {
            feedbackView.setAnalyticsName(getBehaviourPlugin().getBehaviour().getAnalyticsName());
        }
    }

    public final void setSlot(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "<set-?>");
        this.slot = slot;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public void startRefreshing() {
    }

    public void stopRefreshing() {
    }
}
