package com.animaconnected.draganddrop;

import android.view.View;
import com.animaconnected.draganddrop.dataadapter.DragAndDropSourceGridViewAdapter;
import com.animaconnected.draganddrop.provider.DragAndDropProvider;

/* loaded from: classes.dex */
public class DragAndDropSettings {
    DragAndDropProvider<Object> dragAndDropProvider;
    DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter1;
    DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter2;
    DragAndDropTargetLayout dragAndDropTargetLayout;
    Integer extraViewHeightPx;
    Integer extraViewWidthPx;
    Integer sourceGridColor;
    Integer sourceGridHeightPx;
    TabController tabController;
    int tabSelectIndicatorColor;
    int tabTextStyle;
    int toolbarHeightPx;
    View toolbarView;

    /* loaded from: classes.dex */
    public static class Builder {
        private final DragAndDropSettings mSettings;

        public Builder(DragAndDropProvider dragAndDropProvider, DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter, DragAndDropTargetLayout dragAndDropTargetLayout, View view, int r6) {
            DragAndDropSettings dragAndDropSettings = new DragAndDropSettings();
            this.mSettings = dragAndDropSettings;
            dragAndDropSettings.dragAndDropProvider = dragAndDropProvider;
            dragAndDropSettings.dragAndDropSourceGridViewAdapter1 = dragAndDropSourceGridViewAdapter;
            dragAndDropSettings.dragAndDropTargetLayout = dragAndDropTargetLayout;
            dragAndDropSettings.toolbarView = view;
            dragAndDropSettings.toolbarHeightPx = r6;
        }

        public DragAndDropSettings build() {
            return this.mSettings;
        }

        public Builder setExtraViewSize(int r2, int r3) {
            this.mSettings.extraViewWidthPx = Integer.valueOf(r2);
            this.mSettings.extraViewHeightPx = Integer.valueOf(r3);
            return this;
        }

        public Builder setSourceGridColor(int r2) {
            this.mSettings.sourceGridColor = Integer.valueOf(r2);
            return this;
        }

        public Builder setSourceGridHeightPx(int r2) {
            this.mSettings.sourceGridHeightPx = Integer.valueOf(r2);
            return this;
        }

        public Builder setTab(TabController tabController, DragAndDropSourceGridViewAdapter dragAndDropSourceGridViewAdapter) {
            DragAndDropSettings dragAndDropSettings = this.mSettings;
            dragAndDropSettings.tabController = tabController;
            dragAndDropSettings.dragAndDropSourceGridViewAdapter2 = dragAndDropSourceGridViewAdapter;
            return this;
        }

        public Builder setTabStyle(int r2, int r3) {
            DragAndDropSettings dragAndDropSettings = this.mSettings;
            dragAndDropSettings.tabTextStyle = r2;
            dragAndDropSettings.tabSelectIndicatorColor = r3;
            return this;
        }
    }
}
