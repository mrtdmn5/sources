package com.animaconnected.draganddrop.widget;

import java.util.List;

/* loaded from: classes.dex */
public class DragAndDropSourceGridRecyclerViewAdapter {
    private static final int NUMBER_OF_TABS = 2;
    private List<String> mTitles;

    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int r2) {
        return this.mTitles.get(r2);
    }

    public void setData(List<String> list) {
        this.mTitles = list;
    }
}
