package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class SupportActionModeWrapper extends android.view.ActionMode {
    public final Context mContext;
    public final ActionMode mWrappedObject;

    /* loaded from: classes.dex */
    public static class CallbackWrapper implements ActionMode.Callback {
        public final Context mContext;
        public final ActionMode.Callback mWrappedCallback;
        public final ArrayList<SupportActionModeWrapper> mActionModes = new ArrayList<>();
        public final SimpleArrayMap<Menu, Menu> mMenus = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.mContext = context;
            this.mWrappedCallback = callback;
        }

        public final SupportActionModeWrapper getActionModeWrapper(ActionMode actionMode) {
            ArrayList<SupportActionModeWrapper> arrayList = this.mActionModes;
            int size = arrayList.size();
            for (int r2 = 0; r2 < size; r2++) {
                SupportActionModeWrapper supportActionModeWrapper = arrayList.get(r2);
                if (supportActionModeWrapper != null && supportActionModeWrapper.mWrappedObject == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.mContext, actionMode);
            arrayList.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(actionMode), new MenuItemWrapperICS(this.mContext, (SupportMenuItem) menuItem));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, MenuBuilder menuBuilder) {
            SupportActionModeWrapper actionModeWrapper = getActionModeWrapper(actionMode);
            SimpleArrayMap<Menu, Menu> simpleArrayMap = this.mMenus;
            Menu orDefault = simpleArrayMap.getOrDefault(menuBuilder, null);
            if (orDefault == null) {
                orDefault = new MenuWrapperICS(this.mContext, menuBuilder);
                simpleArrayMap.put(menuBuilder, orDefault);
            }
            return this.mWrappedCallback.onCreateActionMode(actionModeWrapper, orDefault);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, MenuBuilder menuBuilder) {
            SupportActionModeWrapper actionModeWrapper = getActionModeWrapper(actionMode);
            SimpleArrayMap<Menu, Menu> simpleArrayMap = this.mMenus;
            Menu orDefault = simpleArrayMap.getOrDefault(menuBuilder, null);
            if (orDefault == null) {
                orDefault = new MenuWrapperICS(this.mContext, menuBuilder);
                simpleArrayMap.put(menuBuilder, orDefault);
            }
            return this.mWrappedCallback.onPrepareActionMode(actionModeWrapper, orDefault);
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.mContext = context;
        this.mWrappedObject = actionMode;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.mWrappedObject.finish();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.mWrappedObject.getCustomView();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new MenuWrapperICS(this.mContext, this.mWrappedObject.getMenu());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.mWrappedObject.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.mWrappedObject.getSubtitle();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.mWrappedObject.mTag;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.mWrappedObject.mTitleOptionalHint;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.mWrappedObject.invalidate();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.mWrappedObject.isTitleOptional();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.mWrappedObject.setCustomView(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.mWrappedObject.setSubtitle(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.mWrappedObject.mTag = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.mWrappedObject.setTitle(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z) {
        this.mWrappedObject.setTitleOptionalHint(z);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int r2) {
        this.mWrappedObject.setSubtitle(r2);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int r2) {
        this.mWrappedObject.setTitle(r2);
    }
}
