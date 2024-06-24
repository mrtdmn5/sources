package com.animaconnected.secondo.screens.behaviourconfiguration;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amplifyframework.devmenu.DevMenuFileIssueFragment$$ExternalSyntheticLambda0;
import com.animaconnected.draganddrop.DragAndDrop;
import com.animaconnected.draganddrop.DragAndDropSettings;
import com.animaconnected.draganddrop.DragAndDropTargetLayout;
import com.animaconnected.draganddrop.TabController;
import com.animaconnected.draganddrop.dataadapter.DragAndDropSourceGridViewAdapter;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.provider.DashboardConfigurationHelper;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.ThemeProviderBase;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter;
import com.animaconnected.secondo.screens.details.DetailsFragment;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragmentCallback;
import com.animaconnected.secondo.screens.watch.WatchViewLayouter;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.types.Empty;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: BehaviourConfigurationBaseFragment.kt */
/* loaded from: classes3.dex */
public abstract class BehaviourConfigurationBaseFragment extends BaseFragment implements BehaviourConfigurationBasePresenter.BehaviourConfigurationView, MiniOnboardingBaseDialogFragmentCallback, WatchViewLayouter, TabController {
    private static final int GRADIENT_ANIMATION_DURATION = 350;
    private final Animator.AnimatorListener animatorListener;
    protected DragAndDrop dragAndDrop;
    protected DragAndDropTargetLayout dragAndDropTarget;
    private FrameLayout dropTargetsContainer;
    private boolean dropTargetsContainerLayoutDone;
    private FrameLayout dropTargetsDoubleCrownContainer;
    private View dropTargetsDoubleCrownLine;
    private DropTargetsViewController dropTargetsViewController;
    private boolean hasDoubleMainComplication;
    private final ActivityResultLauncher<String[]> permissionLauncher;
    private BehaviourConfigurationBasePresenter presenter;
    private boolean useTabbed;
    private boolean watchLayoutDone;
    private int watchXOffset;
    private int watchYOffset;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: BehaviourConfigurationBaseFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BehaviourConfigurationBaseFragment() {
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment$special$$inlined$registerMultiplePermissions$default$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Map<String, Boolean> result) {
                BehaviourConfigurationBasePresenter behaviourConfigurationBasePresenter;
                Intrinsics.checkNotNullParameter(result, "result");
                Set<Map.Entry<String, Boolean>> entrySet = result.entrySet();
                boolean z = true;
                if (!(entrySet instanceof Collection) || !entrySet.isEmpty()) {
                    Iterator<T> it = entrySet.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                            z = false;
                            break;
                        }
                    }
                }
                if (z) {
                    behaviourConfigurationBasePresenter = BehaviourConfigurationBaseFragment.this.presenter;
                    if (behaviourConfigurationBasePresenter != null) {
                        behaviourConfigurationBasePresenter.onPrePermissionGranted();
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                        throw null;
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.permissionLauncher = registerForActivityResult;
        this.animatorListener = new Animator.AnimatorListener() { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment$animatorListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                BehaviourConfigurationBaseFragment.this.getMainController().setWatchLayerAboveContent(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                BehaviourConfigurationBaseFragment.this.getMainController().setWatchLayerAboveContent(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                BehaviourConfigurationBaseFragment.this.getMainController().setWatchLayerAboveContent(true);
            }
        };
    }

    private final int getCrownPlacingRectangleDrawableSizePx(float f, float f2, int r3) {
        return (int) TypedValue.applyDimension(1, r3 * (f2 / f), getResources().getDisplayMetrics());
    }

    public static final void onCreateView$lambda$3$lambda$2(BehaviourConfigurationBaseFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showOnboardingDialog(true);
    }

    public static final void onCreateView$lambda$5(BehaviourConfigurationBaseFragment this$0, View view, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.watchLayoutDone && !this$0.dropTargetsContainerLayoutDone) {
            if (this$0.dropTargetsDoubleCrownContainer != null) {
                DropTargetsViewController dropTargetsViewController = this$0.dropTargetsViewController;
                if (dropTargetsViewController != null) {
                    int r52 = this$0.watchXOffset;
                    int r62 = this$0.watchYOffset;
                    int watchLayoutWidth = this$0.getMainController().getWatchLayoutWidth();
                    int watchLayoutWidth2 = this$0.getMainController().getWatchLayoutWidth();
                    FrameLayout frameLayout = this$0.dropTargetsDoubleCrownContainer;
                    Intrinsics.checkNotNull(frameLayout);
                    dropTargetsViewController.animateDropTargets(r52, r62, (watchLayoutWidth - ((watchLayoutWidth2 - frameLayout.getWidth()) / 2)) - this$0.getResources().getDimensionPixelSize(R.dimen.double_crown_offset), true, 0);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("dropTargetsViewController");
                    throw null;
                }
            } else {
                DropTargetsViewController dropTargetsViewController2 = this$0.dropTargetsViewController;
                if (dropTargetsViewController2 != null) {
                    dropTargetsViewController2.animateDropTargets(this$0.watchXOffset, this$0.watchYOffset, 350);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("dropTargetsViewController");
                    throw null;
                }
            }
            this$0.dropTargetsContainerLayoutDone = true;
        }
    }

    public static final void onItemChanged$lambda$8(BehaviourConfigurationBaseFragment this$0, Behaviour behaviour) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(behaviour, "behaviour");
        if (this$0.hasDoubleMainComplication && !ProviderFactory.getDoubleCrownProvider().shouldShowDoubleCrown() && !Intrinsics.areEqual(behaviour.getType(), Empty.INSTANCE.getTYPE())) {
            ProviderFactory.getDoubleCrownProvider().setShouldShowDoubleCrown(true);
            View view = this$0.dropTargetsDoubleCrownLine;
            if (view != null) {
                view.setAlpha(0.0f);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.dropTargetsDoubleCrownLine, "alpha", 1.0f);
                ofFloat.setInterpolator(new DecelerateInterpolator());
                ofFloat.setDuration(this$0.getResources().getInteger(R.integer.double_crown_fade));
                ofFloat.setStartDelay(this$0.getResources().getInteger(R.integer.double_crown_delay));
                ofFloat.start();
                view.setVisibility(0);
            }
            if (this$0.getDragAndDropTarget().getDropTargetsExtraViewLayout() != null) {
                this$0.getDragAndDropTarget().getDropTargetsExtraViewLayout().setAlpha(0.0f);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this$0.getDragAndDropTarget().getDropTargetsExtraViewLayout(), "alpha", 1.0f);
                ofFloat2.setInterpolator(new DecelerateInterpolator());
                ofFloat2.setDuration(this$0.getResources().getInteger(R.integer.double_crown_fade));
                ofFloat2.setStartDelay(this$0.getResources().getInteger(R.integer.double_crown_delay));
                ofFloat2.start();
                this$0.getDragAndDropTarget().getDropTargetsExtraViewLayout().setVisibility(0);
            }
        }
    }

    private final void pause() {
        BehaviourConfigurationBasePresenter behaviourConfigurationBasePresenter = this.presenter;
        if (behaviourConfigurationBasePresenter != null) {
            behaviourConfigurationBasePresenter.onPause();
            getDragAndDrop().onPause();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    private final void resume() {
        BehaviourConfigurationBasePresenter behaviourConfigurationBasePresenter = this.presenter;
        if (behaviourConfigurationBasePresenter != null) {
            behaviourConfigurationBasePresenter.onResume();
            getDragAndDrop().onResume();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    public abstract DialogFragment createOnboardingDialog();

    public abstract float getAnimationTranslationAmount();

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public final DragAndDrop getDragAndDrop() {
        DragAndDrop dragAndDrop = this.dragAndDrop;
        if (dragAndDrop != null) {
            return dragAndDrop;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragAndDrop");
        throw null;
    }

    public final DragAndDropTargetLayout getDragAndDropTarget() {
        DragAndDropTargetLayout dragAndDropTargetLayout = this.dragAndDropTarget;
        if (dragAndDropTargetLayout != null) {
            return dragAndDropTargetLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragAndDropTarget");
        throw null;
    }

    public final View getDropTargetsDoubleCrownLine() {
        return this.dropTargetsDoubleCrownLine;
    }

    public final int getFillLayoutWidth() {
        return (int) getResources().getDimension(R.dimen.marble_empty_view_size_target_empty_text);
    }

    public final boolean getHasDoubleMainComplication() {
        return this.hasDoubleMainComplication;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public abstract String getName();

    public abstract boolean getOnboardingDone();

    public ActivityResultLauncher<String[]> getPermissionLauncher() {
        return this.permissionLauncher;
    }

    public final boolean getUseTabbed() {
        return this.useTabbed;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int hideWatch() {
        return 0;
    }

    public final void onCreate(Bundle bundle, boolean z) {
        super.onCreate(bundle);
        this.useTabbed = z;
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int r4, boolean z, int r6) {
        if (z) {
            if (r6 == R.anim.enter_from_right) {
                getDragAndDrop().animateInDropTargets(getResources().getInteger(R.integer.screen_transition_duration_horizontal), 200);
            }
        } else if (r6 == R.anim.exit_to_right) {
            getDragAndDrop().animateOutDropTargets(0);
        }
        return super.onCreateAnimation(r4, z, r6);
    }

    @SuppressLint({"MissingInflatedId"})
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, int r20) {
        float f;
        DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter;
        View view;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.draganddrop, viewGroup, false);
        Context context = getContext();
        if (context == null) {
            Intrinsics.checkNotNull(inflate);
            return inflate;
        }
        View findViewById = inflate.findViewById(R.id.draganddrop);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        setDragAndDrop((DragAndDrop) findViewById);
        View inflate2 = inflater.inflate(r20, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type com.animaconnected.draganddrop.DragAndDropTargetLayout");
        setDragAndDropTarget((DragAndDropTargetLayout) inflate2);
        getDragAndDropTarget().setAnimatorListener(this.animatorListener);
        getDragAndDropTarget().setAnimatorTranslationAmount(getAnimationTranslationAmount());
        RelativeLayout dragAndDropTargetRemoveLayout = getDragAndDropTarget().getDragAndDropTargetRemoveLayout();
        int dashboardButtonsHeightPx = DashboardConfigurationHelper.getDashboardButtonsHeightPx(getResources());
        dragAndDropTargetRemoveLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, dashboardButtonsHeightPx));
        View inflate3 = LayoutInflater.from(context).inflate(R.layout.draganddroptoolbar, (ViewGroup) null, false);
        ThemeProviderBase.Companion companion = ThemeProviderBase.Companion;
        int color = companion.getColor(context, R.attr.dragAndDropToolbarTint);
        ((AnimatedToolbar) inflate3.findViewById(R.id.animated_toolbar)).setTintColor(color);
        ImageView imageView = (ImageView) inflate3.findViewById(R.id.help_button);
        imageView.setOnClickListener(new DevMenuFileIssueFragment$$ExternalSyntheticLambda0(this, 1));
        imageView.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        Object obj = ContextCompat.sLock;
        Drawable drawable = ContextCompat.Api21Impl.getDrawable(context, R.drawable.main_complication_drop_zone_not_selected_light);
        if (drawable != null) {
            f = drawable.getIntrinsicWidth();
        } else {
            f = 0.0f;
        }
        Drawable drawable2 = ContextCompat.Api21Impl.getDrawable(context, R.drawable.crown_x2_placement_rectangle_light);
        Intrinsics.checkNotNull(drawable2);
        float intrinsicWidth = drawable2.getIntrinsicWidth();
        float intrinsicHeight = drawable2.getIntrinsicHeight();
        int dimension = (int) (getResources().getDimension(R.dimen.marble_empty_view_size_target_empty_text) / getResources().getDisplayMetrics().density);
        int crownPlacingRectangleDrawableSizePx = getCrownPlacingRectangleDrawableSizePx(f, intrinsicWidth, dimension);
        int crownPlacingRectangleDrawableSizePx2 = getCrownPlacingRectangleDrawableSizePx(f, intrinsicHeight, dimension);
        int color2 = companion.getColor(context, R.attr.colorGrid);
        if (this.useTabbed) {
            Context dragAndDropContext = getDragAndDrop().getDragAndDropContext();
            BehaviourConfigurationBasePresenter behaviourConfigurationBasePresenter = this.presenter;
            if (behaviourConfigurationBasePresenter != null) {
                dragAndDropSourceGridViewAdapter = new DragAndDropSourceGridViewAdapter(dragAndDropContext, behaviourConfigurationBasePresenter.getBehaviourItemProvider(), context.getString(R.string.tab_main_complication)) { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment$onCreateView$dragAndDropSourceGridViewAdapter1$1
                };
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
                throw null;
            }
        } else {
            Context dragAndDropContext2 = getDragAndDrop().getDragAndDropContext();
            BehaviourConfigurationBasePresenter behaviourConfigurationBasePresenter2 = this.presenter;
            if (behaviourConfigurationBasePresenter2 != null) {
                dragAndDropSourceGridViewAdapter = new DragAndDropSourceGridViewAdapter(dragAndDropContext2, behaviourConfigurationBasePresenter2.getBehaviourItemProvider()) { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment$onCreateView$dragAndDropSourceGridViewAdapter1$2
                };
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
                throw null;
            }
        }
        BehaviourConfigurationBasePresenter behaviourConfigurationBasePresenter3 = this.presenter;
        if (behaviourConfigurationBasePresenter3 != null) {
            DragAndDropSettings.Builder sourceGridColor = new DragAndDropSettings.Builder(behaviourConfigurationBasePresenter3.getBehaviourItemProvider(), dragAndDropSourceGridViewAdapter, getDragAndDropTarget(), inflate3, getResources().getDimensionPixelSize(R.dimen.toolbarHeight)).setSourceGridHeightPx(dashboardButtonsHeightPx).setExtraViewSize(crownPlacingRectangleDrawableSizePx, crownPlacingRectangleDrawableSizePx2).setSourceGridColor(color2);
            if (this.useTabbed) {
                String string = context.getString(R.string.tab_sub_complication);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Context dragAndDropContext3 = getDragAndDrop().getDragAndDropContext();
                BehaviourConfigurationBasePresenter behaviourConfigurationBasePresenter4 = this.presenter;
                if (behaviourConfigurationBasePresenter4 != null) {
                    sourceGridColor.setTab(this, new DragAndDropSourceGridViewAdapter(string, dragAndDropContext3, behaviourConfigurationBasePresenter4.getBehaviourItemProvider()) { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment$onCreateView$dragAndDropSourceGridViewAdapter2$1
                    }).setTabStyle(companion.getResourceId(context, R.attr.tabTextStyle), companion.getColor(context, R.attr.tabSelectIndicatorColor));
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    throw null;
                }
            }
            getDragAndDrop().init(sourceGridColor.build());
            DragAndDrop dragAndDrop = getDragAndDrop();
            BehaviourConfigurationBasePresenter behaviourConfigurationBasePresenter5 = this.presenter;
            if (behaviourConfigurationBasePresenter5 != null) {
                dragAndDrop.setItemClickListener(behaviourConfigurationBasePresenter5);
                FrameLayout dropTargetsContainerLayout = getDragAndDropTarget().getDropTargetsContainerLayout();
                Intrinsics.checkNotNullExpressionValue(dropTargetsContainerLayout, "getDropTargetsContainerLayout(...)");
                this.dropTargetsContainer = dropTargetsContainerLayout;
                this.dropTargetsDoubleCrownContainer = getDragAndDropTarget().getDropTargetsExtraViewContainerLayout();
                this.dropTargetsDoubleCrownLine = getDragAndDropTarget().getExtraView();
                FrameLayout frameLayout = this.dropTargetsContainer;
                if (frameLayout != null) {
                    frameLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnLayoutChangeListener
                        public final void onLayoutChange(View view2, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r202) {
                            BehaviourConfigurationBaseFragment.onCreateView$lambda$5(BehaviourConfigurationBaseFragment.this, view2, r13, r14, r15, r16, r17, r18, r19, r202);
                        }
                    });
                    FrameLayout frameLayout2 = this.dropTargetsContainer;
                    if (frameLayout2 != null) {
                        this.dropTargetsViewController = new DropTargetsViewController(frameLayout2, this.dropTargetsDoubleCrownContainer);
                        this.hasDoubleMainComplication = ProviderFactory.getWatch().getCapabilities().getHasDoubleMainComplication();
                        boolean shouldShowDoubleCrown = ProviderFactory.getDoubleCrownProvider().shouldShowDoubleCrown();
                        if ((!this.hasDoubleMainComplication || !shouldShowDoubleCrown) && (view = this.dropTargetsDoubleCrownLine) != null && view != null) {
                            view.setVisibility(4);
                        }
                        if (getDragAndDropTarget().getDropTargetsExtraViewLayout() != null && this.hasDoubleMainComplication && !shouldShowDoubleCrown) {
                            getDragAndDropTarget().getDropTargetsExtraViewLayout().setVisibility(4);
                        }
                        return inflate;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("dropTargetsContainer");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("dropTargetsContainer");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Context context = getContext();
        if (context != null) {
            getDragAndDrop().destroy(context.getResources().getInteger(R.integer.screen_transition_duration_horizontal));
        }
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter.BehaviourConfigurationView
    public void onItemChanged() {
        Hashing.getLifecycleScope(this);
        getDragAndDropTarget().update();
        ProviderFactory.getWatch().getBehaviourAsFuture(Slot.MainComplication).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                BehaviourConfigurationBaseFragment.onItemChanged$lambda$8(BehaviourConfigurationBaseFragment.this, (Behaviour) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        resume();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public void onRevealedFragmentClosed() {
        super.onRevealedFragmentClosed();
        BehaviourConfigurationBasePresenter behaviourConfigurationBasePresenter = this.presenter;
        if (behaviourConfigurationBasePresenter != null) {
            behaviourConfigurationBasePresenter.onRevealedFragmentClosed();
            resume();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public void onRevealedFragmentOpened() {
        pause();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        BehaviourConfigurationBasePresenter behaviourConfigurationBasePresenter = this.presenter;
        if (behaviourConfigurationBasePresenter != null) {
            behaviourConfigurationBasePresenter.onViewCreated();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewLayouted() {
        this.watchLayoutDone = true;
        this.watchXOffset = getMainController().getWatchViewController().getWatchXOffset();
        this.watchYOffset = getMainController().getWatchViewController().getWatchYOffset();
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewUpdated(int r10) {
        FrameLayout frameLayout = this.dropTargetsDoubleCrownContainer;
        if (this.hasDoubleMainComplication && frameLayout != null) {
            DropTargetsViewController dropTargetsViewController = this.dropTargetsViewController;
            if (dropTargetsViewController != null) {
                dropTargetsViewController.animateDropTargets(this.watchXOffset, this.watchYOffset, (getMainController().getWatchLayoutWidth() - ((getMainController().getWatchLayoutWidth() - frameLayout.getWidth()) / 2)) - getResources().getDimensionPixelSize(R.dimen.double_crown_offset), false, 350);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("dropTargetsViewController");
                throw null;
            }
        } else {
            DropTargetsViewController dropTargetsViewController2 = this.dropTargetsViewController;
            if (dropTargetsViewController2 != null) {
                dropTargetsViewController2.animateDropTargets(this.watchXOffset, this.watchYOffset, 350);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("dropTargetsViewController");
                throw null;
            }
        }
        FrameLayout frameLayout2 = this.dropTargetsContainer;
        if (frameLayout2 != null) {
            frameLayout2.invalidate();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("dropTargetsContainer");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragmentCallback
    public void onboardingDone() {
        setOnboardingDone();
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter.BehaviourConfigurationView
    public void requestPermissions(String[] permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        getPermissionLauncher().launch(permissions);
    }

    public final void setDragAndDrop(DragAndDrop dragAndDrop) {
        Intrinsics.checkNotNullParameter(dragAndDrop, "<set-?>");
        this.dragAndDrop = dragAndDrop;
    }

    public final void setDragAndDropTarget(DragAndDropTargetLayout dragAndDropTargetLayout) {
        Intrinsics.checkNotNullParameter(dragAndDropTargetLayout, "<set-?>");
        this.dragAndDropTarget = dragAndDropTargetLayout;
    }

    public final void setDropTargetsDoubleCrownLine(View view) {
        this.dropTargetsDoubleCrownLine = view;
    }

    public final void setHasDoubleMainComplication(boolean z) {
        this.hasDoubleMainComplication = z;
    }

    public abstract void setOnboardingDone();

    public final void setPresenter(BehaviourConfigurationBasePresenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenter = presenter;
    }

    public final void setUseTabbed(boolean z) {
        this.useTabbed = z;
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter.BehaviourConfigurationView
    public void showDetailsFragment(String behaviourType, Slot slot, int r13, int r14, int r15, int r16) {
        Intrinsics.checkNotNullParameter(behaviourType, "behaviourType");
        Intrinsics.checkNotNullParameter(slot, "slot");
        getMainController().gotoRevealedFragment(DetailsFragment.Companion.newInstance(behaviourType, slot, getFeaturePathName(), r13, r14, r15, r16, true));
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter.BehaviourConfigurationView
    public void showOnboardingDialog(boolean z) {
        ProviderFactory.getAppAnalytics().sendMiniOnboardingStarted(getName(), z);
        createOnboardingDialog().show(getChildFragmentManager(), (String) null);
    }

    @Override // com.animaconnected.draganddrop.TabController
    public void tabChanged(int r4) {
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new BehaviourConfigurationBaseFragment$tabChanged$1(this, r4, null), 3);
    }
}
