package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatPopupWindow;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.kronaby.watch.app.R;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    public final AccessibilityManager accessibilityManager;
    public final ListPopupWindow modalListPopup;
    public final int simpleItemLayout;
    public final Rect tempRect;

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, R.attr.autoCompleteTextViewStyle, 0), attributeSet, 0);
        this.tempRect = new Rect();
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.MaterialAutoCompleteTextView, R.attr.autoCompleteTextViewStyle, 2132083537, new int[0]);
        if (obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.simpleItemLayout = obtainStyledAttributes.getResourceId(1, R.layout.mtrl_auto_complete_simple_item);
        this.accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2, null, R.attr.listPopupWindowStyle, 0);
        this.modalListPopup = listPopupWindow;
        listPopupWindow.mModal = true;
        AppCompatPopupWindow appCompatPopupWindow = listPopupWindow.mPopup;
        appCompatPopupWindow.setFocusable(true);
        listPopupWindow.mDropDownAnchorView = this;
        appCompatPopupWindow.setInputMethodMode(2);
        listPopupWindow.setAdapter(getAdapter());
        listPopupWindow.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.google.android.material.textfield.MaterialAutoCompleteTextView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int r11, long j) {
                Object item;
                int selectedItemPosition;
                View view2 = null;
                MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
                if (r11 < 0) {
                    ListPopupWindow listPopupWindow2 = materialAutoCompleteTextView.modalListPopup;
                    if (!listPopupWindow2.isShowing()) {
                        item = null;
                    } else {
                        item = listPopupWindow2.mDropDownList.getSelectedItem();
                    }
                } else {
                    item = materialAutoCompleteTextView.getAdapter().getItem(r11);
                }
                MaterialAutoCompleteTextView.access$100(materialAutoCompleteTextView, item);
                AdapterView.OnItemClickListener onItemClickListener = materialAutoCompleteTextView.getOnItemClickListener();
                ListPopupWindow listPopupWindow3 = materialAutoCompleteTextView.modalListPopup;
                if (onItemClickListener != null) {
                    if (view == null || r11 < 0) {
                        if (listPopupWindow3.isShowing()) {
                            view2 = listPopupWindow3.mDropDownList.getSelectedView();
                        }
                        view = view2;
                        if (!listPopupWindow3.isShowing()) {
                            selectedItemPosition = -1;
                        } else {
                            selectedItemPosition = listPopupWindow3.mDropDownList.getSelectedItemPosition();
                        }
                        r11 = selectedItemPosition;
                        if (!listPopupWindow3.isShowing()) {
                            j = Long.MIN_VALUE;
                        } else {
                            j = listPopupWindow3.mDropDownList.getSelectedItemId();
                        }
                    }
                    onItemClickListener.onItemClick(listPopupWindow3.mDropDownList, view, r11, j);
                }
                listPopupWindow3.dismiss();
            }
        };
        if (obtainStyledAttributes.hasValue(2)) {
            setSimpleItems(obtainStyledAttributes.getResourceId(2, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public static void access$100(MaterialAutoCompleteTextView materialAutoCompleteTextView, Object obj) {
        materialAutoCompleteTextView.setText(materialAutoCompleteTextView.convertSelectionToString(obj), false);
    }

    public final TextInputLayout findTextInputLayoutAncestor() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (findTextInputLayoutAncestor != null && findTextInputLayoutAncestor.isProvidingHint) {
            return findTextInputLayoutAncestor.getHint();
        }
        return super.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (findTextInputLayoutAncestor != null && findTextInputLayoutAncestor.isProvidingHint && super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r14, int r15) {
        int selectedItemPosition;
        super.onMeasure(r14, r15);
        if (View.MeasureSpec.getMode(r14) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
            int r2 = 0;
            if (adapter != null && findTextInputLayoutAncestor != null) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                ListPopupWindow listPopupWindow = this.modalListPopup;
                if (!listPopupWindow.isShowing()) {
                    selectedItemPosition = -1;
                } else {
                    selectedItemPosition = listPopupWindow.mDropDownList.getSelectedItemPosition();
                }
                int min = Math.min(adapter.getCount(), Math.max(0, selectedItemPosition) + 15);
                View view = null;
                int r7 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != r2) {
                        view = null;
                        r2 = itemViewType;
                    }
                    view = adapter.getView(max, view, findTextInputLayoutAncestor);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    r7 = Math.max(r7, view.getMeasuredWidth());
                }
                Drawable background = listPopupWindow.getBackground();
                if (background != null) {
                    Rect rect = this.tempRect;
                    background.getPadding(rect);
                    r7 += rect.left + rect.right;
                }
                r2 = findTextInputLayoutAncestor.getEndIconView().getMeasuredWidth() + r7;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, r2), View.MeasureSpec.getSize(r14)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.modalListPopup.setAdapter(getAdapter());
    }

    public void setSimpleItems(int r2) {
        setSimpleItems(getResources().getStringArray(r2));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.modalListPopup.show();
        } else {
            super.showDropDown();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new ArrayAdapter(getContext(), this.simpleItemLayout, strArr));
    }
}
