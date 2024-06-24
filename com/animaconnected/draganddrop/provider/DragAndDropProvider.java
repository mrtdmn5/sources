package com.animaconnected.draganddrop.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.animaconnected.draganddrop.provider.model.DragAndDropDroppableItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DragAndDropProvider.kt */
/* loaded from: classes.dex */
public abstract class DragAndDropProvider<T> {
    public static final Companion Companion = new Companion(null);
    public static final int MAIN_COMPLICATION_ADAPTER = 0;
    public static final int NOT_TABBED_ADAPTER = 2;
    public static final int SUB_COMPLICATION_ADAPTER = 1;
    private final Context context;
    private final Set<ItemChangedListener<T>> itemListeners;
    private final List<DragAndDropItem> itemsTabbed1;
    private final List<DragAndDropItem> itemsTabbed2;
    private final Set<DragAndDropChangedListener> listeners;
    protected final List<DragAndDropItem> mutableItems;
    private final Set<ViewCreatedListener> viewCreatedListeners;

    /* compiled from: DragAndDropProvider.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: DragAndDropProvider.kt */
    /* loaded from: classes.dex */
    public interface DragAndDropChangedListener {
        void onDragAndDropDataChanged();
    }

    /* compiled from: DragAndDropProvider.kt */
    /* loaded from: classes.dex */
    public interface ViewCreatedListener {
        void onViewCreated();
    }

    public DragAndDropProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.listeners = new CopyOnWriteArraySet();
        this.viewCreatedListeners = new CopyOnWriteArraySet();
        this.itemListeners = new HashSet();
        this.mutableItems = new ArrayList();
        this.itemsTabbed1 = new ArrayList();
        this.itemsTabbed2 = new ArrayList();
    }

    public boolean belongsToAdapterType(int r1, int r2) {
        return true;
    }

    public abstract void clearBadgeState(DragAndDropDroppableItem dragAndDropDroppableItem);

    public void clearData() {
        this.mutableItems.clear();
        this.itemsTabbed1.clear();
        this.itemsTabbed2.clear();
    }

    public Drawable getBackgroundNotSelectedDrawable(int r1) {
        return null;
    }

    public Drawable getBackgroundSelectedDrawable(int r1) {
        return null;
    }

    public final Context getContext() {
        return this.context;
    }

    public List<Integer> getDisabledGroups(DragAndDropDroppableItem dragAndDropDroppableItem, int r2) {
        Intrinsics.checkNotNullParameter(dragAndDropDroppableItem, "dragAndDropDroppableItem");
        return null;
    }

    public Drawable getDraggedItemDrawable() {
        return null;
    }

    public Drawable getDroppedItemDrawable() {
        return null;
    }

    public abstract int getEmptyMarbleColorInt();

    public Drawable getGroupDrawable(int r1) {
        return null;
    }

    public String getGroupText(int r1) {
        return null;
    }

    public abstract int getHeaderTextStyle();

    public List<Integer> getHiddenGroups(int r1) {
        return null;
    }

    public List<DragAndDropItem> getItems(int r1) {
        return null;
    }

    public final List<DragAndDropItem> getItemsTabbed1() {
        return this.itemsTabbed1;
    }

    public final List<DragAndDropItem> getItemsTabbed2() {
        return this.itemsTabbed2;
    }

    public Drawable getPanelDropZoneNotSelectedDrawable() {
        return null;
    }

    public Drawable getPanelDropZoneSelectedDrawable() {
        return null;
    }

    public List<Integer> getShownGroups(int r1) {
        return null;
    }

    public final void initData() {
        initItemData();
    }

    public abstract void initItemData();

    public final void notifyDataChanged() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DragAndDropChangedListener) it.next()).onDragAndDropDataChanged();
        }
    }

    public final void notifyItemChanged(T t, int r4, int r5, int r6) {
        Iterator<T> it = this.itemListeners.iterator();
        while (it.hasNext()) {
            ((ItemChangedListener) it.next()).onItemChanged(t, r4, r5, r6);
        }
    }

    public final void notifyViewCreated() {
        Iterator<T> it = this.viewCreatedListeners.iterator();
        while (it.hasNext()) {
            ((ViewCreatedListener) it.next()).onViewCreated();
        }
    }

    public final void registerDragAndDropItemsChangedListener(DragAndDropChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void registerItemsChangedListener(ItemChangedListener<T> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.itemListeners.add(listener);
    }

    public final void registerViewCreatedListener(ViewCreatedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.viewCreatedListeners.add(listener);
    }

    public boolean shouldDrawEmptyIcon() {
        return false;
    }

    public final void unregisterDragAndDropItemsChangedListener(DragAndDropChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    public final void unregisterItemsChangedListener(ItemChangedListener<T> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.itemListeners.remove(listener);
    }

    public final void unregisterViewCreatedListener(ViewCreatedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.viewCreatedListeners.remove(listener);
    }

    public abstract void updateItemData(DragAndDropDroppableItem dragAndDropDroppableItem);

    public final List<DragAndDropItem> getItems() {
        return this.mutableItems;
    }
}
