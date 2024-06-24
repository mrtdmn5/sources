package com.animaconnected.secondo.screens.apps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.BehaviourFactory;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.databinding.ItemAppsTextBinding;
import com.animaconnected.secondo.databinding.ItemWatchAppBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.apps.AppsListItem;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.WatchManager;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.QuickActionType;
import com.animaconnected.watch.display.WatchApp;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchAppAdapter.kt */
/* loaded from: classes3.dex */
public final class WatchAppAdapter extends RecyclerView.Adapter<AppsListViewHolder> {
    public static final int $stable = 8;
    private final AppEvents analytics;
    private final Behaviours behaviours;
    private boolean isEditModeActive;
    private final Function2<View, Behaviour, Unit> itemClick;
    private final List<AppsListItem> listItems;
    private List<AppId> positionList;
    private final Watch watch;
    private final WatchManager watchManager;

    /* JADX WARN: Multi-variable type inference failed */
    public WatchAppAdapter(BehaviourFactory behaviourFactory, Function2<? super View, ? super Behaviour, Unit> itemClick) {
        boolean z;
        Intrinsics.checkNotNullParameter(behaviourFactory, "behaviourFactory");
        Intrinsics.checkNotNullParameter(itemClick, "itemClick");
        this.itemClick = itemClick;
        this.watch = ProviderFactory.getWatch().getWatchManager().getCurrentWatch();
        WatchManager watchManager = ProviderFactory.getWatch().getWatchManager();
        this.watchManager = watchManager;
        Behaviours behaviours = watchManager.getBehaviours();
        this.behaviours = behaviours;
        List<WatchApp> watchApps = behaviours.getWatchApps();
        ArrayList arrayList = new ArrayList();
        for (Object obj : watchApps) {
            if (true ^ ((WatchApp) obj).isHidden()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            WatchApp watchApp = (WatchApp) it.next();
            BehaviourPlugin<Behaviour> plugin = behaviourFactory.getPlugin(watchApp.getType());
            Integer valueOf = plugin != null ? Integer.valueOf(plugin.getIconResourceId()) : null;
            if (this.behaviours.getAppPosition(watchApp.getId()) != null) {
                z = true;
            } else {
                z = false;
            }
            if (watchApp.getQuickActionType() != QuickActionType.None) {
                z2 = true;
            }
            arrayList2.add(new WatchAppListItem(watchApp, valueOf, z, z2));
        }
        ArrayList mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        this.listItems = mutableList;
        List<WatchAppListItem> activeApps = getActiveApps(mutableList);
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(activeApps, 10));
        Iterator<T> it2 = activeApps.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((WatchAppListItem) it2.next()).getApp().getId());
        }
        this.positionList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        this.analytics = ProviderFactory.getAppAnalytics();
        Context context = KronabyApplication.Companion.getContext();
        List<AppsListItem> list = this.listItems;
        String string = context.getString(R.string.display_apps_active_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        list.add(0, new AppsTextListItem(string, null, 2, null));
        List<AppsListItem> list2 = this.listItems;
        int hiddenTextPos = getHiddenTextPos();
        String string2 = context.getString(R.string.display_apps_hidden_title);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = context.getString(R.string.display_apps_hidden_description);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        list2.add(hiddenTextPos, new AppsTextListItem(string2, string3));
    }

    private final List<WatchAppListItem> getActiveApps(List<? extends AppsListItem> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof WatchAppListItem) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((WatchAppListItem) obj2).isActive()) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    private final List<WatchAppListItem> getHiddenApps(List<? extends AppsListItem> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof WatchAppListItem) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!((WatchAppListItem) obj2).isActive()) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    private final int getHiddenTextPos() {
        return getActiveApps(this.listItems).size() + 1;
    }

    private final void refreshPositionList(WatchAppListItem watchAppListItem, int r3, int r4, boolean z) {
        if (z) {
            notifyItemChanged(r4);
        }
        this.listItems.remove(r4);
        this.listItems.add(r3, watchAppListItem);
        notifyItemMoved(r4, r3);
        if (z) {
            notifyItemChanged(r3);
        }
        List<WatchAppListItem> activeApps = getActiveApps(this.listItems);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(activeApps, 10));
        Iterator<T> it = activeApps.iterator();
        while (it.hasNext()) {
            arrayList.add(((WatchAppListItem) it.next()).getApp().getId());
        }
        this.positionList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
    }

    public final Behaviours getBehaviours() {
        return this.behaviours;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r2) {
        return this.listItems.get(r2).getItemType().ordinal();
    }

    public final List<AppsListItem> getListItems() {
        return this.listItems;
    }

    public final List<AppId> getPositionList() {
        return this.positionList;
    }

    public final Watch getWatch() {
        return this.watch;
    }

    public final WatchManager getWatchManager() {
        return this.watchManager;
    }

    public final boolean isEditModeActive() {
        return this.isEditModeActive;
    }

    public final void onClickWatchApp(int r6) {
        AppsListItem appsListItem = this.listItems.get(r6);
        if (!(appsListItem instanceof WatchAppListItem)) {
            return;
        }
        int hiddenTextPos = getHiddenTextPos();
        WatchAppListItem watchAppListItem = (WatchAppListItem) appsListItem;
        boolean isActive = watchAppListItem.isActive();
        boolean isQuickAction = this.behaviours.isQuickAction(watchAppListItem.getApp());
        if (isActive && isQuickAction) {
            this.behaviours.removeQuickAction(watchAppListItem.getApp());
        }
        if (isActive) {
            this.analytics.appListHideApp(watchAppListItem.getApp().getAnalyticsName());
        } else {
            this.analytics.appListShowApp(watchAppListItem.getApp().getAnalyticsName());
        }
        watchAppListItem.setActive(!watchAppListItem.isActive());
        refreshPositionList(watchAppListItem, hiddenTextPos, r6, true);
    }

    public final boolean onDragWatchApp(int r8, int r9, RecyclerView.ViewHolder viewHolder) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        AppsListItem appsListItem = this.listItems.get(r9);
        if (r8 == 0 || !(appsListItem instanceof WatchAppListItem) || !(viewHolder instanceof WatchAppListViewHolder)) {
            return false;
        }
        int hiddenTextPos = getHiddenTextPos();
        if (r9 > hiddenTextPos) {
            z = true;
        } else {
            z = false;
        }
        if (r8 == hiddenTextPos && z) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (r9 < hiddenTextPos) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (r8 == hiddenTextPos && z3) {
            z4 = true;
        } else {
            z4 = false;
        }
        WatchAppListItem watchAppListItem = (WatchAppListItem) appsListItem;
        boolean isQuickAction = this.behaviours.isQuickAction(watchAppListItem.getApp());
        if (z2) {
            watchAppListItem.setActive(true);
            this.analytics.appListShowApp(watchAppListItem.getApp().getAnalyticsName());
        } else if (z4) {
            watchAppListItem.setActive(false);
            this.analytics.appListHideApp(watchAppListItem.getApp().getAnalyticsName());
        }
        if (z4 && isQuickAction) {
            Behaviours.removeQuickAction$default(this.behaviours, null, 1, null);
        }
        refreshPositionList(watchAppListItem, r8, r9, false);
        ((WatchAppListViewHolder) viewHolder).invalidate();
        return true;
    }

    public final void toggleEditMode() {
        this.isEditModeActive = !this.isEditModeActive;
        int size = getActiveApps(this.listItems).size();
        WatchAppPayLoad watchAppPayLoad = WatchAppPayLoad.EDIT_MODE_TOGGLE;
        notifyItemRangeChanged(1, size, watchAppPayLoad);
        notifyItemRangeChanged(getHiddenTextPos() + 1, getHiddenApps(this.listItems).size(), watchAppPayLoad);
    }

    public final void updateRadioSelection(int r7) {
        AppId appId;
        Object obj;
        WatchAppListItem watchAppListItem;
        WatchApp app2;
        AppsListItem appsListItem = this.listItems.get(r7);
        if (!(appsListItem instanceof WatchAppListItem)) {
            return;
        }
        List<AppsListItem> list = this.listItems;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (obj2 instanceof WatchAppListItem) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            appId = null;
            if (it.hasNext()) {
                obj = it.next();
                if (this.behaviours.isQuickAction(((WatchAppListItem) obj).getApp())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        WatchAppListItem watchAppListItem2 = (WatchAppListItem) obj;
        List<AppsListItem> list2 = this.listItems;
        if (watchAppListItem2 instanceof AppsListItem) {
            watchAppListItem = watchAppListItem2;
        } else {
            watchAppListItem = null;
        }
        Intrinsics.checkNotNullParameter(list2, "<this>");
        int indexOf = list2.indexOf(watchAppListItem);
        if (watchAppListItem2 != null && (app2 = watchAppListItem2.getApp()) != null) {
            appId = app2.getId();
        }
        WatchAppListItem watchAppListItem3 = (WatchAppListItem) appsListItem;
        if (appId == watchAppListItem3.getApp().getId()) {
            this.behaviours.removeQuickAction(watchAppListItem3.getApp());
        } else {
            this.behaviours.setQuickAction(watchAppListItem3.getApp());
        }
        if (indexOf != -1) {
            notifyItemChanged(indexOf, WatchAppPayLoad.RADIO_CHECK_CHANGE);
        }
        notifyItemChanged(r7, WatchAppPayLoad.RADIO_CHECK_CHANGE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(AppsListViewHolder appsListViewHolder, int r2, List list) {
        onBindViewHolder2(appsListViewHolder, r2, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AppsListViewHolder onCreateViewHolder(ViewGroup parent, int r5) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (r5 == AppsListItem.Type.App.ordinal()) {
            ItemWatchAppBinding inflate = ItemWatchAppBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new WatchAppListViewHolder(inflate, this, this.itemClick);
        }
        if (r5 == AppsListItem.Type.Text.ordinal()) {
            ItemAppsTextBinding inflate2 = ItemAppsTextBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
            return new TextAppsListViewHolder(inflate2);
        }
        throw new IllegalArgumentException("Illegal ViewType: " + r5 + '.');
    }

    /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(AppsListViewHolder holder, int r3, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!payloads.isEmpty() && (holder instanceof WatchAppListViewHolder)) {
            Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) payloads);
            if (first == WatchAppPayLoad.RADIO_CHECK_CHANGE) {
                ((WatchAppListViewHolder) holder).invalidateRadioIsChecked();
                return;
            } else {
                if (first == WatchAppPayLoad.EDIT_MODE_TOGGLE) {
                    ((WatchAppListViewHolder) holder).invalidate();
                    return;
                }
                return;
            }
        }
        super.onBindViewHolder((WatchAppAdapter) holder, r3, payloads);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(AppsListViewHolder holder, int r3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bindType(this.listItems.get(r3));
    }
}
