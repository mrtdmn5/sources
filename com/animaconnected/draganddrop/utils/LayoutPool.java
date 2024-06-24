package com.animaconnected.draganddrop.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class LayoutPool {
    private static LayoutPool sInstance;
    private final Map<Integer, List<View>> mLayoutPool = new HashMap();
    private final Map<View, Integer> mViewToLayoutMap = new HashMap();

    private LayoutPool() {
    }

    public static LayoutPool getInstance() {
        if (sInstance == null) {
            sInstance = new LayoutPool();
        }
        return sInstance;
    }

    public void clear() {
        this.mLayoutPool.clear();
        this.mViewToLayoutMap.clear();
    }

    public void dontPoolView(View view) {
        this.mViewToLayoutMap.remove(view);
    }

    public View getViewOrCreateIfNeeded(Context context, int r5) {
        List<View> list = this.mLayoutPool.get(Integer.valueOf(r5));
        if (list != null && !list.isEmpty()) {
            return list.remove(list.size() - 1);
        }
        View inflate = LayoutInflater.from(context).inflate(r5, (ViewGroup) null, true);
        this.mViewToLayoutMap.put(inflate, Integer.valueOf(r5));
        return inflate;
    }

    public void poolView(View view) {
        Integer num = this.mViewToLayoutMap.get(view);
        if (num != null) {
            List<View> list = this.mLayoutPool.get(num);
            if (list == null) {
                list = new ArrayList<>();
                this.mLayoutPool.put(num, list);
            }
            list.add(view);
        }
    }
}
