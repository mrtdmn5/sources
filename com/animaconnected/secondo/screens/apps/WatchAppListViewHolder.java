package com.animaconnected.secondo.screens.apps;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.animaconnected.draganddrop.provider.BadgeState;
import com.animaconnected.secondo.behaviour.BehaviourFactory;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.behaviour.BehaviourPluginKt;
import com.animaconnected.secondo.databinding.ItemWatchAppBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.behaviour.Behaviour;
import com.kronaby.watch.app.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchAppViewHolder.kt */
/* loaded from: classes3.dex */
public final class WatchAppListViewHolder extends AppsListViewHolder {
    public static final int $stable = 8;
    private final WatchAppAdapter adapter;

    /* renamed from: app */
    private Behaviour f135app;
    private final ItemWatchAppBinding binding;
    private final Function2<View, Behaviour, Unit> itemClick;
    private WatchAppListItem watchAppListItem;

    /* compiled from: WatchAppViewHolder.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[BadgeState.values().length];
            try {
                r0[BadgeState.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[BadgeState.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[BadgeState.Neutral.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[BadgeState.Positive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public WatchAppListViewHolder(final com.animaconnected.secondo.databinding.ItemWatchAppBinding r3, com.animaconnected.secondo.screens.apps.WatchAppAdapter r4, kotlin.jvm.functions.Function2<? super android.view.View, ? super com.animaconnected.watch.behaviour.Behaviour, kotlin.Unit> r5) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "adapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "itemClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.widget.RelativeLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0)
            r2.binding = r3
            r2.adapter = r4
            r2.itemClick = r5
            android.widget.RelativeLayout r4 = r3.listItem
            com.animaconnected.secondo.screens.apps.WatchAppListViewHolder$$ExternalSyntheticLambda0 r5 = new com.animaconnected.secondo.screens.apps.WatchAppListViewHolder$$ExternalSyntheticLambda0
            r5.<init>()
            r4.setOnClickListener(r5)
            android.widget.ImageView r4 = r3.ivAffordance
            com.animaconnected.secondo.screens.settings.SettingsFragment$$ExternalSyntheticLambda1 r5 = new com.animaconnected.secondo.screens.settings.SettingsFragment$$ExternalSyntheticLambda1
            r0 = 1
            r5.<init>(r0, r2)
            r4.setOnClickListener(r5)
            android.widget.RadioButton r3 = r3.radioButton
            com.animaconnected.secondo.screens.settings.SettingsFragment$$ExternalSyntheticLambda2 r4 = new com.animaconnected.secondo.screens.settings.SettingsFragment$$ExternalSyntheticLambda2
            r4.<init>(r0, r2)
            r3.setOnClickListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.apps.WatchAppListViewHolder.<init>(com.animaconnected.secondo.databinding.ItemWatchAppBinding, com.animaconnected.secondo.screens.apps.WatchAppAdapter, kotlin.jvm.functions.Function2):void");
    }

    private final void invalidateAffordanceIcon() {
        int r0;
        ImageView ivAffordance = this.binding.ivAffordance;
        Intrinsics.checkNotNullExpressionValue(ivAffordance, "ivAffordance");
        ViewKt.gone(ivAffordance);
        if (this.adapter.isEditModeActive()) {
            WatchAppListItem watchAppListItem = this.watchAppListItem;
            if (watchAppListItem != null) {
                if (watchAppListItem.isActive()) {
                    r0 = R.drawable.ic_minus;
                } else {
                    r0 = R.drawable.ic_plus;
                }
                ImageView ivAffordance2 = this.binding.ivAffordance;
                Intrinsics.checkNotNullExpressionValue(ivAffordance2, "ivAffordance");
                ViewKt.visible(ivAffordance2);
                this.binding.ivAffordance.setImageResource(r0);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("watchAppListItem");
            throw null;
        }
    }

    private final void invalidateAppTitleAndIcon() {
        int intValue;
        TextView textView = this.binding.tvAppTitle;
        WatchAppListItem watchAppListItem = this.watchAppListItem;
        if (watchAppListItem != null) {
            textView.setText(watchAppListItem.getApp().getTitle().app());
            WatchAppListItem watchAppListItem2 = this.watchAppListItem;
            if (watchAppListItem2 != null) {
                Integer iconResource = watchAppListItem2.getIconResource();
                boolean z = true;
                if (iconResource != null && iconResource.intValue() != -1) {
                    z = false;
                }
                if (z) {
                    intValue = R.drawable.ic_stopwatch;
                } else {
                    intValue = iconResource.intValue();
                }
                this.binding.ivIconForeground.setImageResource(intValue);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("watchAppListItem");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("watchAppListItem");
        throw null;
    }

    private final void invalidateBadge(BehaviourPlugin<Behaviour> behaviourPlugin) {
        ImageView badge = this.binding.badge;
        Intrinsics.checkNotNullExpressionValue(badge, "badge");
        ViewKt.gone(badge);
        WatchAppListItem watchAppListItem = this.watchAppListItem;
        Integer num = null;
        if (watchAppListItem != null) {
            if (!watchAppListItem.isActive()) {
                return;
            }
            int r4 = WhenMappings.$EnumSwitchMapping$0[BehaviourPluginKt.getBadgeState(behaviourPlugin).ordinal()];
            if (r4 != 1) {
                if (r4 != 2) {
                    if (r4 != 3) {
                        if (r4 == 4) {
                            num = Integer.valueOf(R.drawable.badge_on_marble_positive);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        num = Integer.valueOf(R.drawable.badge_on_marble_neutral);
                    }
                } else {
                    num = Integer.valueOf(R.drawable.ic_badge_on_marble_attention);
                }
            }
            if (num != null) {
                this.binding.badge.setImageResource(num.intValue());
                ImageView badge2 = this.binding.badge;
                Intrinsics.checkNotNullExpressionValue(badge2, "badge");
                ViewKt.visible(badge2);
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("watchAppListItem");
        throw null;
    }

    private final void invalidateQuickActionVisibility() {
        WatchAppListItem watchAppListItem;
        if (this.adapter.isEditModeActive()) {
            ImageView ivQuickAction = this.binding.ivQuickAction;
            Intrinsics.checkNotNullExpressionValue(ivQuickAction, "ivQuickAction");
            ViewKt.gone(ivQuickAction);
            return;
        }
        AppsListItem appsListItem = this.adapter.getListItems().get(getAbsoluteAdapterPosition());
        if (appsListItem instanceof WatchAppListItem) {
            watchAppListItem = (WatchAppListItem) appsListItem;
        } else {
            watchAppListItem = null;
        }
        if (watchAppListItem == null) {
            return;
        }
        if (this.adapter.getWatchManager().getBehaviours().isQuickAction(watchAppListItem.getApp())) {
            ImageView ivQuickAction2 = this.binding.ivQuickAction;
            Intrinsics.checkNotNullExpressionValue(ivQuickAction2, "ivQuickAction");
            ViewKt.visible(ivQuickAction2);
        } else {
            ImageView ivQuickAction3 = this.binding.ivQuickAction;
            Intrinsics.checkNotNullExpressionValue(ivQuickAction3, "ivQuickAction");
            ViewKt.gone(ivQuickAction3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void invalidateRadioVisibility() {
        /*
            r4 = this;
            com.animaconnected.secondo.databinding.ItemWatchAppBinding r0 = r4.binding
            android.widget.RadioButton r0 = r0.radioButton
            java.lang.String r1 = "radioButton"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.animaconnected.secondo.utils.ViewKt.gone(r0)
            com.animaconnected.secondo.screens.apps.WatchAppAdapter r0 = r4.adapter
            boolean r0 = r0.isEditModeActive()
            if (r0 == 0) goto L43
            com.animaconnected.secondo.screens.apps.WatchAppListItem r0 = r4.watchAppListItem
            r2 = 0
            java.lang.String r3 = "watchAppListItem"
            if (r0 == 0) goto L3f
            boolean r0 = r0.isActive()
            if (r0 == 0) goto L31
            com.animaconnected.secondo.screens.apps.WatchAppListItem r0 = r4.watchAppListItem
            if (r0 == 0) goto L2d
            boolean r0 = r0.getSupportsQuickActions()
            if (r0 == 0) goto L31
            r0 = 1
            goto L32
        L2d:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            throw r2
        L31:
            r0 = 0
        L32:
            if (r0 == 0) goto L43
            com.animaconnected.secondo.databinding.ItemWatchAppBinding r0 = r4.binding
            android.widget.RadioButton r0 = r0.radioButton
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.animaconnected.secondo.utils.ViewKt.visible(r0)
            goto L43
        L3f:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            throw r2
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.apps.WatchAppListViewHolder.invalidateRadioVisibility():void");
    }

    public static final void lambda$3$lambda$0(WatchAppListViewHolder this$0, ItemWatchAppBinding this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.itemClick.invoke(this_apply.layoutItemWatchAppIcon, this$0.f135app);
    }

    public static final void lambda$3$lambda$1(WatchAppListViewHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.adapter.onClickWatchApp(this$0.getBindingAdapterPosition());
    }

    public static final void lambda$3$lambda$2(WatchAppListViewHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.adapter.updateRadioSelection(this$0.getBindingAdapterPosition());
    }

    @Override // com.animaconnected.secondo.screens.apps.AppsListViewHolder
    public void bindType(AppsListItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        WatchAppListItem watchAppListItem = (WatchAppListItem) item;
        this.watchAppListItem = watchAppListItem;
        this.f135app = watchAppListItem.getApp();
        invalidate();
    }

    public final WatchAppAdapter getAdapter() {
        return this.adapter;
    }

    public final void invalidate() {
        invalidateAffordanceIcon();
        invalidateRadioVisibility();
        invalidateRadioIsChecked();
        invalidateQuickActionVisibility();
        invalidateAppTitleAndIcon();
        BehaviourFactory behaviourFactory = ProviderFactory.getBehaviourFactory();
        WatchAppListItem watchAppListItem = this.watchAppListItem;
        if (watchAppListItem != null) {
            BehaviourPlugin<Behaviour> plugin = behaviourFactory.getPlugin(watchAppListItem.getApp().getType());
            if (plugin != null) {
                invalidateBadge(plugin);
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("watchAppListItem");
        throw null;
    }

    public final void invalidateDragAppIcon(boolean z, int r3) {
        if (z && r3 == 2) {
            ImageView ivIconBackgroundDrag = this.binding.ivIconBackgroundDrag;
            Intrinsics.checkNotNullExpressionValue(ivIconBackgroundDrag, "ivIconBackgroundDrag");
            ViewKt.visible(ivIconBackgroundDrag);
        } else {
            ImageView ivIconBackgroundDrag2 = this.binding.ivIconBackgroundDrag;
            Intrinsics.checkNotNullExpressionValue(ivIconBackgroundDrag2, "ivIconBackgroundDrag");
            ViewKt.gone(ivIconBackgroundDrag2);
        }
    }

    public final void invalidateRadioIsChecked() {
        WatchAppListItem watchAppListItem;
        AppsListItem appsListItem = this.adapter.getListItems().get(getAbsoluteAdapterPosition());
        if (appsListItem instanceof WatchAppListItem) {
            watchAppListItem = (WatchAppListItem) appsListItem;
        } else {
            watchAppListItem = null;
        }
        if (watchAppListItem == null) {
            this.binding.radioButton.setChecked(false);
        } else {
            this.binding.radioButton.setChecked(this.adapter.getWatchManager().getBehaviours().isQuickAction(watchAppListItem.getApp()));
        }
    }
}
