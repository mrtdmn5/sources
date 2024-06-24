package com.animaconnected.secondo.screens.notification;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.core.content.ContextCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.draganddrop.DragAndDrop;
import com.animaconnected.draganddrop.DragAndDropSettings;
import com.animaconnected.draganddrop.dataadapter.DragAndDropSourceGridViewAdapter;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.notification.model.ImportantApp;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.ThemeProviderBase;
import com.animaconnected.secondo.provider.notification.configuration.item.NotificationItemConstants;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.ViewLayouter;
import com.animaconnected.secondo.screens.details.DetailsFragment;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragmentCallback;
import com.animaconnected.secondo.screens.notification.NotificationPresenter;
import com.animaconnected.secondo.screens.notification.alarm.AlarmFragment;
import com.animaconnected.secondo.screens.notification.magicword.MagicWordFragment;
import com.animaconnected.secondo.screens.notification.stepgoal.StepGoalFragment;
import com.animaconnected.secondo.screens.notification.widget.NotificationsDragAndDropTargetLayout;
import com.animaconnected.secondo.screens.outofrange.OutOfRangeFragment;
import com.animaconnected.secondo.screens.watch.HideWatchLayouter;
import com.animaconnected.secondo.screens.watch.WatchViewLayouter;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.types.Ifttt;
import com.animaconnected.watch.provider.quiethours.RefreshTimer;
import com.kronaby.watch.app.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationFragment.kt */
/* loaded from: classes3.dex */
public final class NotificationFragment extends BaseFragment implements NotificationPresenter.NotificationView, MiniOnboardingBaseDialogFragmentCallback, WatchViewLayouter {
    private final ActivityResultLauncher<String[]> callSmsPermissionLauncher;
    private final ActivityResultLauncher<String[]> contactPermissionLauncher;
    private DragAndDrop dragAndDrop;
    private ImageView quietHoursButton;
    private RefreshTimer quietHoursRefreshTimer;
    private final ActivityResultLauncher<String[]> readContactPermissionLauncher;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final /* synthetic */ HideWatchLayouter $$delegate_0 = new HideWatchLayouter(0, 1, null);
    private final boolean hasDnd = ProviderFactory.getWatch().hasDoNotDisturb();
    private final Lazy presenter$delegate = LazyKt__LazyJVMKt.lazy(new Function0<NotificationPresenter>() { // from class: com.animaconnected.secondo.screens.notification.NotificationFragment$presenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NotificationPresenter invoke() {
            Context context = NotificationFragment.this.getContext();
            NotificationFragment notificationFragment = NotificationFragment.this;
            return new NotificationPresenter(context, notificationFragment, notificationFragment.getMainController(), PermissionCompat.create(NotificationFragment.this));
        }
    });

    /* compiled from: NotificationFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NotificationFragment newInstance() {
            return new NotificationFragment();
        }

        private Companion() {
        }
    }

    public NotificationFragment() {
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback(this) { // from class: com.animaconnected.secondo.screens.notification.NotificationFragment$special$$inlined$registerMultiplePermissions$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Map<String, Boolean> result) {
                boolean z;
                NotificationPresenter presenter;
                NotificationPresenter presenter2;
                Intrinsics.checkNotNullParameter(result, "result");
                Set<Map.Entry<String, Boolean>> entrySet = result.entrySet();
                if (!(entrySet instanceof Collection) || !entrySet.isEmpty()) {
                    Iterator<T> it = entrySet.iterator();
                    while (it.hasNext()) {
                        if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    presenter2 = NotificationFragment.this.getPresenter();
                    presenter2.onCallAndSmsPermission(true);
                } else {
                    presenter = NotificationFragment.this.getPresenter();
                    presenter.onCallAndSmsPermission(false);
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.callSmsPermissionLauncher = registerForActivityResult;
        ActivityResultLauncher<String[]> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.animaconnected.secondo.screens.notification.NotificationFragment$special$$inlined$registerMultiplePermissions$default$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Map<String, Boolean> result) {
                NotificationPresenter presenter;
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
                    presenter = NotificationFragment.this.getPresenter();
                    presenter.onContactPermissionsGranted();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.contactPermissionLauncher = registerForActivityResult2;
        ActivityResultLauncher<String[]> registerForActivityResult3 = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback(this) { // from class: com.animaconnected.secondo.screens.notification.NotificationFragment$special$$inlined$registerMultiplePermissions$2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Map<String, Boolean> result) {
                NotificationPresenter presenter;
                NotificationPresenter presenter2;
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
                    presenter2 = NotificationFragment.this.getPresenter();
                    presenter2.onReadContactPermission(Boolean.TRUE);
                } else {
                    presenter = NotificationFragment.this.getPresenter();
                    presenter.onReadContactPermission(Boolean.FALSE);
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult3, "registerForActivityResult(...)");
        this.readContactPermissionLauncher = registerForActivityResult3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationPresenter getPresenter() {
        return (NotificationPresenter) this.presenter$delegate.getValue();
    }

    public static final NotificationFragment newInstance() {
        return Companion.newInstance();
    }

    private final void pausePresenter() {
        getPresenter().onPause();
    }

    private final void resumePresenter() {
        getPresenter().onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startQuietHourUpdates() {
        if (!this.hasDnd) {
            return;
        }
        RefreshTimer refreshTimer = this.quietHoursRefreshTimer;
        if (refreshTimer != null) {
            refreshTimer.dispose();
        }
        ProviderFactory providerFactory = ProviderFactory.INSTANCE;
        this.quietHoursRefreshTimer = providerFactory.getQuietHoursProvider().runOnNextChange(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.notification.NotificationFragment$startQuietHourUpdates$1
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
                NotificationFragment.this.startQuietHourUpdates();
            }
        });
        ImageView imageView = this.quietHoursButton;
        if (imageView != null) {
            imageView.setSelected(providerFactory.getQuietHoursProvider().isActive());
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("quietHoursButton");
            throw null;
        }
    }

    private final void tint(ImageView imageView, int r3) {
        imageView.setColorFilter(r3, PorterDuff.Mode.SRC_ATOP);
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationPresenter.NotificationView
    public CustomActivityResult<Intent, ActivityResult> activityLauncher() {
        return getActivityLauncher();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_notification);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "Notification";
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r2, int r3, int r4, int r5) {
        return this.$$delegate_0.getWatchOffset(r2, r3, r4, r5);
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int hideWatch() {
        return 2;
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int r4, boolean z, int r6) {
        if (z) {
            if (r6 == R.anim.enter_from_right) {
                DragAndDrop dragAndDrop = this.dragAndDrop;
                if (dragAndDrop != null) {
                    dragAndDrop.animateInDropTargets(getResources().getInteger(R.integer.screen_transition_duration_horizontal), 400);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("dragAndDrop");
                    throw null;
                }
            }
        } else if (r6 == R.anim.exit_to_right) {
            DragAndDrop dragAndDrop2 = this.dragAndDrop;
            if (dragAndDrop2 != null) {
                dragAndDrop2.animateOutDropTargets(0);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("dragAndDrop");
                throw null;
            }
        }
        return super.onCreateAnimation(r4, z, r6);
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"MissingInflatedId"})
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        int r1;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.draganddrop, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        View findViewById = inflate.findViewById(R.id.draganddrop);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.dragAndDrop = (DragAndDrop) findViewById;
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return inflate;
        }
        if (ProviderFactory.getLabsProvider().isMoreNumbersEnabled() && ProviderFactory.getWatch().getCapabilities().getHasSixAlerts()) {
            r1 = R.layout.notifications_draganddrop_target_layout_six;
        } else {
            r1 = R.layout.notifications_draganddrop_target_layout_three;
        }
        View inflate2 = LayoutInflater.from(activity).inflate(r1, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type com.animaconnected.secondo.screens.notification.widget.NotificationsDragAndDropTargetLayout");
        final NotificationsDragAndDropTargetLayout notificationsDragAndDropTargetLayout = (NotificationsDragAndDropTargetLayout) inflate2;
        notificationsDragAndDropTargetLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.animaconnected.secondo.screens.notification.NotificationFragment$onCreateView$$inlined$doAfterLayout$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                notificationsDragAndDropTargetLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                RelativeLayout dragAndDropTargetRemoveLayout = notificationsDragAndDropTargetLayout.getDragAndDropTargetRemoveLayout();
                KeyEventDispatcher.Component component = activity;
                if (component instanceof ViewLayouter) {
                    ((ViewLayouter) component).onViewLayouted(dragAndDropTargetRemoveLayout.getHeight());
                }
            }
        });
        View inflate3 = LayoutInflater.from(getContext()).inflate(R.layout.draganddroptoolbar, (ViewGroup) null, false);
        int color = ThemeProviderBase.Companion.getColor(activity, R.attr.dragAndDropToolbarTint);
        View findViewById2 = inflate3.findViewById(R.id.animated_toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        AnimatedToolbar animatedToolbar = (AnimatedToolbar) findViewById2;
        animatedToolbar.setTintColor(color);
        ((ImageView) animatedToolbar.findViewById(R.id.help_button)).setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        View findViewById3 = animatedToolbar.findViewById(R.id.touch_area_help_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        onClick(findViewById3, new NotificationFragment$onCreateView$3(this, null));
        View findViewById4 = animatedToolbar.findViewById(R.id.touch_area_quiet_hours_button);
        View findViewById5 = animatedToolbar.findViewById(R.id.quiet_hours_button);
        ImageView imageView = (ImageView) findViewById5;
        if (this.hasDnd) {
            imageView.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            Intrinsics.checkNotNull(findViewById4);
            ViewKt.visible(findViewById4);
            onClick(findViewById4, new NotificationFragment$onCreateView$4$1(this, null));
            imageView.setSelected(ProviderFactory.INSTANCE.getQuietHoursProvider().isActive());
        } else {
            Intrinsics.checkNotNull(findViewById4);
            ViewKt.gone(findViewById4);
        }
        Intrinsics.checkNotNullExpressionValue(findViewById5, "apply(...)");
        this.quietHoursButton = (ImageView) findViewById5;
        DragAndDrop dragAndDrop = this.dragAndDrop;
        if (dragAndDrop != null) {
            final Context dragAndDropContext = dragAndDrop.getDragAndDropContext();
            final NotificationDragAndDropProvider notificationDragAndDropProvider = getPresenter().getNotificationDragAndDropProvider();
            DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter = new DragAndDropSourceGridViewAdapter(dragAndDropContext, notificationDragAndDropProvider) { // from class: com.animaconnected.secondo.screens.notification.NotificationFragment$onCreateView$dragAndDropSourceGridViewAdapter$1
            };
            Object obj = ContextCompat.sLock;
            DragAndDropSettings.Builder sourceGridColor = new DragAndDropSettings.Builder(getPresenter().getNotificationDragAndDropProvider(), dragAndDropSourceGridViewAdapter, notificationsDragAndDropTargetLayout, inflate3, getResources().getDimensionPixelSize(R.dimen.toolbarHeight)).setSourceGridColor(ContextCompat.Api23Impl.getColor(activity, R.color.colorGrid));
            DragAndDrop dragAndDrop2 = this.dragAndDrop;
            if (dragAndDrop2 != null) {
                dragAndDrop2.init(sourceGridColor.build());
                DragAndDrop dragAndDrop3 = this.dragAndDrop;
                if (dragAndDrop3 != null) {
                    dragAndDrop3.setItemClickListener(getPresenter());
                    NotificationPresenter presenter = getPresenter();
                    DragAndDrop dragAndDrop4 = this.dragAndDrop;
                    if (dragAndDrop4 != null) {
                        presenter.setDragAndDrop(dragAndDrop4);
                        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.four_notifications_icon);
                        if (imageView2 != null) {
                            tint(imageView2, color);
                        }
                        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.five_notifications_icon);
                        if (imageView3 != null) {
                            tint(imageView3, color);
                        }
                        ImageView imageView4 = (ImageView) inflate.findViewById(R.id.six_notifications_icon);
                        if (imageView4 != null) {
                            tint(imageView4, color);
                        }
                        if (ProviderFactory.getWatch().isAlertComplicationEnabled()) {
                            inflate.findViewById(R.id.watch_icon_one).setVisibility(0);
                            inflate.findViewById(R.id.watch_icon_two).setVisibility(0);
                            inflate.findViewById(R.id.watch_icon_three).setVisibility(0);
                        } else {
                            inflate.findViewById(R.id.vibrating_icon_one).setVisibility(0);
                            inflate.findViewById(R.id.vibrating_icon_two).setVisibility(0);
                            inflate.findViewById(R.id.vibrating_icon_three).setVisibility(0);
                        }
                        return inflate;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("dragAndDrop");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("dragAndDrop");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dragAndDrop");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragAndDrop");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Context context = getContext();
        if (context != null) {
            DragAndDrop dragAndDrop = this.dragAndDrop;
            if (dragAndDrop != null) {
                dragAndDrop.destroy(context.getResources().getInteger(R.integer.screen_transition_duration_horizontal));
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("dragAndDrop");
                throw null;
            }
        }
        getPresenter().onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        pausePresenter();
        RefreshTimer refreshTimer = this.quietHoursRefreshTimer;
        if (refreshTimer != null) {
            refreshTimer.dispose();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        resumePresenter();
        startQuietHourUpdates();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public void onRevealedFragmentClosed() {
        super.onRevealedFragmentClosed();
        getPresenter().onViewCreated();
        resumePresenter();
        startQuietHourUpdates();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public void onRevealedFragmentOpened() {
        pausePresenter();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getPresenter().onViewCreated();
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewLayouted() {
        this.$$delegate_0.onWatchViewLayouted();
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewUpdated(int r2) {
        this.$$delegate_0.onWatchViewUpdated(r2);
    }

    @Override // com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragmentCallback
    public void onboardingDone() {
        if (isAdded()) {
            getPresenter().notificationOnboardingDone();
        }
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationPresenter.NotificationView
    public void requestCallPermissions() {
        this.callSmsPermissionLauncher.launch(NotificationItemConstants.requiredPermissions(0));
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationPresenter.NotificationView
    public void requestContactPermission() {
        this.contactPermissionLauncher.launch(NotificationItemConstants.requiredPermissions(2));
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationPresenter.NotificationView
    public void requestReadContactPermission() {
        this.readContactPermissionLauncher.launch(NotificationItemConstants.requiredPermissions(1));
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationPresenter.NotificationView
    public void requestSmsPermissions() {
        this.callSmsPermissionLauncher.launch(NotificationItemConstants.requiredPermissions(9));
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationPresenter.NotificationView
    public /* bridge */ /* synthetic */ void showContactFragment(int r9, Integer num, int r11, int r12, int r13, int r14, boolean z) {
        showContactFragment(r9, num.intValue(), r11, r12, r13, r14, z);
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationPresenter.NotificationView
    public void showFragment(int r17, int r18, int r19, int r20, int r21, boolean z) {
        BaseFragment allCallsFragment;
        if (r17 != 0) {
            if (r17 != 3) {
                if (r17 != 5) {
                    if (r17 != 6) {
                        if (r17 != 7) {
                            switch (r17) {
                                case 9:
                                    allCallsFragment = new AllMessagesFragment();
                                    break;
                                case 10:
                                    allCallsFragment = DetailsFragment.Companion.newInstance(Ifttt.TYPE, Slot.NotInitialized, getFeaturePathName(), r18, r19, r20, r21, true);
                                    break;
                                case 11:
                                    allCallsFragment = new MagicWordFragment();
                                    break;
                                case 12:
                                    allCallsFragment = new OutOfRangeFragment();
                                    break;
                                default:
                                    throw new IllegalArgumentException(r17 + " isn't supported");
                            }
                        } else {
                            allCallsFragment = new StepGoalFragment();
                        }
                    } else {
                        allCallsFragment = new GetMovingFragment();
                    }
                } else {
                    allCallsFragment = new AlarmFragment();
                }
            } else {
                allCallsFragment = new CalendarFragment();
            }
        } else {
            allCallsFragment = new AllCallsFragment();
        }
        BaseFragment baseFragment = allCallsFragment;
        if (baseFragment instanceof NotificationDetailsFragment) {
            NotificationDetailsFragment.Companion.setArguments((NotificationDetailsFragment) baseFragment, r18, r19, r20, r21, r17, z);
        }
        getMainController().gotoRevealedFragment(baseFragment);
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationPresenter.NotificationView
    public void showImportantAppFragment(int r11, ImportantApp importantApp, int r13, int r14, int r15, int r16, boolean z) {
        Intrinsics.checkNotNullParameter(importantApp, "importantApp");
        ImportantAppFragment importantAppFragment = new ImportantAppFragment();
        NotificationDetailsFragment.Companion.setArguments(importantAppFragment, r13, r14, r15, r16, r11, z);
        importantAppFragment.setImportantApp(importantApp);
        getMainController().gotoRevealedFragment(importantAppFragment);
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationPresenter.NotificationView
    public void showOnboardingDialog(boolean z) {
        ProviderFactory.getAppAnalytics().sendMiniOnboardingStarted(getName(), z);
        NotificationMiniOnboardingDialogFragment.newInstance().show(getChildFragmentManager(), (String) null);
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r7, int r8, int r9, int r10, int r11) {
        return this.$$delegate_0.getWatchOffset(r7, r8, r9, r10, r11);
    }

    public void showContactFragment(int r9, int r10, int r11, int r12, int r13, int r14, boolean z) {
        getMainController().gotoRevealedFragment(ContactFragment.Companion.newInstance(r11, r12, r13, r14, r9, z, r10));
    }
}
