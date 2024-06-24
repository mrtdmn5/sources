package com.animaconnected.secondo.screens.apps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.details.DetailsFragment;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragmentCallback;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingConstants;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingStorage;
import com.animaconnected.secondo.screens.watch.HideWatchLayouter;
import com.animaconnected.secondo.screens.watch.WatchViewLayouter;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.secondo.utils.ScreenLocationHelper;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchManager;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.CutoutCalibration;
import com.animaconnected.watch.display.DpUtils;
import com.animaconnected.watch.display.WatchApp;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchAppFragment.kt */
/* loaded from: classes3.dex */
public final class WatchAppFragment extends BaseFragment implements MiniOnboardingBaseDialogFragmentCallback, WatchViewLayouter {
    private TextView editApps;
    private final ItemTouchHelper itemTouchHelper;
    private final WatchAppFragment$itemTouchHelperCallback$1 itemTouchHelperCallback;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final /* synthetic */ HideWatchLayouter $$delegate_0 = new HideWatchLayouter(0, 1, null);
    private final String name = "WatchApps";
    private final WatchAppAdapter adapter = new WatchAppAdapter(ProviderFactory.getBehaviourFactory(), new Function2<View, Behaviour, Unit>() { // from class: com.animaconnected.secondo.screens.apps.WatchAppFragment$adapter$1
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, Behaviour behaviour) {
            invoke2(view, behaviour);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, Behaviour behaviour) {
            WatchAppFragment.this.openApp(view, behaviour);
        }
    });
    private final WatchManager watchManager = ProviderFactory.getWatch().getWatchManager();
    private final BroadcastReceiver gpsSwitchStateReceiver = new BroadcastReceiver() { // from class: com.animaconnected.secondo.screens.apps.WatchAppFragment$gpsSwitchStateReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WatchAppFragment.this.getAdapter().notifyDataSetChanged();
        }
    };

    /* compiled from: WatchAppFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WatchAppFragment newInstance() {
            return new WatchAppFragment();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.animaconnected.secondo.screens.apps.WatchAppFragment$itemTouchHelperCallback$1, androidx.recyclerview.widget.ItemTouchHelper$Callback] */
    public WatchAppFragment() {
        ?? r0 = new ItemTouchHelper.Callback() { // from class: com.animaconnected.secondo.screens.apps.WatchAppFragment$itemTouchHelperCallback$1
            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                super.clearView(recyclerView, viewHolder);
                WatchAppFragment.this.syncApps();
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int r2;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                if (viewHolder instanceof TextAppsListViewHolder) {
                    r2 = 0;
                } else {
                    r2 = 3;
                }
                return ItemTouchHelper.Callback.makeMovementFlags(r2, 0);
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean isLongPressDragEnabled() {
                return WatchAppFragment.this.getAdapter().isEditModeActive();
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int r7, boolean z) {
                WatchAppListViewHolder watchAppListViewHolder;
                Intrinsics.checkNotNullParameter(c, "c");
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                super.onChildDraw(c, recyclerView, viewHolder, f, f2, r7, z);
                if (viewHolder instanceof WatchAppListViewHolder) {
                    watchAppListViewHolder = (WatchAppListViewHolder) viewHolder;
                } else {
                    watchAppListViewHolder = null;
                }
                if (watchAppListViewHolder == null) {
                    return;
                }
                watchAppListViewHolder.invalidateDragAppIcon(z, r7);
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                Intrinsics.checkNotNullParameter(target, "target");
                return WatchAppFragment.this.getAdapter().onDragWatchApp(target.getBindingAdapterPosition(), viewHolder.getBindingAdapterPosition(), viewHolder);
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int r2) {
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            }
        };
        this.itemTouchHelperCallback = r0;
        this.itemTouchHelper = new ItemTouchHelper(r0);
    }

    public static final WatchAppFragment newInstance() {
        return Companion.newInstance();
    }

    public static final void onCreateView$lambda$3$lambda$2$lambda$1(WatchAppFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onEditModeClick();
    }

    private final void onEditModeClick() {
        this.adapter.toggleEditMode();
        if (this.adapter.isEditModeActive()) {
            TextView textView = this.editApps;
            if (textView != null) {
                textView.setText(getString(R.string.remember_this_spot_saved_spots_done));
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("editApps");
                throw null;
            }
        }
        TextView textView2 = this.editApps;
        if (textView2 != null) {
            textView2.setText(getString(R.string.remember_this_spot_saved_spots_edit));
            syncApps();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("editApps");
            throw null;
        }
    }

    public final void openApp(View view, Behaviour behaviour) {
        if (behaviour == null || (behaviour instanceof CutoutCalibration) || this.adapter.isEditModeActive()) {
            return;
        }
        LogKt.debug$default((Object) this, "openApp with type " + behaviour.getType(), (String) null, (Throwable) null, false, 14, (Object) null);
        Size screenSize = ScreenLocationHelper.getScreenSize(getContext());
        Intrinsics.checkNotNullExpressionValue(screenSize, "getScreenSize(...)");
        if (view == null) {
            return;
        }
        View findViewById = requireView().findViewById(R.id.rootView);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        Rect viewRectBounds$default = ViewKt.getViewRectBounds$default(view, (ViewGroup) findViewById, 0, 2, null);
        ProviderFactory.getAppAnalytics().appListOpenAppDetail(((WatchApp) behaviour).getAnalyticsName());
        getMainController().gotoRevealedFragment(DetailsFragment.Companion.newInstance(behaviour.getType(), Slot.Display, getFeaturePathName(), viewRectBounds$default.centerX(), viewRectBounds$default.centerY(), screenSize.getWidth(), screenSize.getHeight(), true));
    }

    public final WatchAppAdapter getAdapter() {
        return this.adapter;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.display_app_details_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r2, int r3, int r4, int r5) {
        return this.$$delegate_0.getWatchOffset(r2, r3, r4, r5);
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int hideWatch() {
        return 1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_watch_apps, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_apps);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.adapter);
        this.itemTouchHelper.attachToRecyclerView(recyclerView);
        View findViewById = inflate.findViewById(R.id.toolbar_action);
        TextView textView = (TextView) findViewById;
        textView.setText(getString(R.string.remember_this_spot_saved_spots_edit));
        DpUtils dpUtils = DpUtils.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        ViewKt.setMargin$default(textView, 0, 0, dpUtils.dpToPx(requireContext, 24.0f), 0, 11, null);
        textView.setVisibility(0);
        textView.setOnClickListener(new WatchAppFragment$$ExternalSyntheticLambda0(this, 0));
        Intrinsics.checkNotNullExpressionValue(findViewById, "apply(...)");
        this.editApps = (TextView) findViewById;
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        requireContext().unregisterReceiver(this.gpsSwitchStateReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireContext().registerReceiver(this.gpsSwitchStateReceiver, new IntentFilter("android.location.PROVIDERS_CHANGED"));
        this.adapter.notifyDataSetChanged();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public void onRevealedFragmentClosed() {
        super.onRevealedFragmentClosed();
        this.adapter.notifyDataSetChanged();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        BaseFragmentUtilsKt.launchOnStarted(this, new WatchAppFragment$onViewCreated$1(this, null));
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
        if (!MiniOnboardingStorage.getOnboardingDone(getContext(), MiniOnboardingConstants.APPS_ONBOARDING_STORAGE)) {
            MiniOnboardingStorage.setOnboardingDone(getContext(), true, MiniOnboardingConstants.APPS_ONBOARDING_STORAGE);
        }
    }

    public final void syncApps() {
        LogKt.debug$default((Object) this, "WatchAppAdapter", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.apps.WatchAppFragment$syncApps$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "List updated to ".concat(CollectionsKt___CollectionsKt.joinToString$default(WatchAppFragment.this.getAdapter().getPositionList(), null, null, null, null, 63));
            }
        }, 6, (Object) null);
        this.watchManager.getBehaviours().updatePositions(this.adapter.getPositionList());
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r7, int r8, int r9, int r10, int r11) {
        return this.$$delegate_0.getWatchOffset(r7, r8, r9, r10, r11);
    }
}
