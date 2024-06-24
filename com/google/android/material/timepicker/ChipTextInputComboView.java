package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {
    public final Chip chip;
    public final EditText editText;

    /* loaded from: classes3.dex */
    public class TextFormatter extends TextWatcherAdapter {
        public TextFormatter() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            boolean isEmpty = TextUtils.isEmpty(editable);
            ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
            if (isEmpty) {
                chipTextInputComboView.chip.setText(ChipTextInputComboView.access$100(chipTextInputComboView, "00"));
            } else {
                chipTextInputComboView.chip.setText(ChipTextInputComboView.access$100(chipTextInputComboView, editable));
            }
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.chip = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        EditText editText = textInputLayout.getEditText();
        this.editText = editText;
        editText.setVisibility(4);
        editText.addTextChangedListener(new TextFormatter());
        editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        addView(chip);
        addView(textInputLayout);
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }

    public static String access$100(ChipTextInputComboView chipTextInputComboView, CharSequence charSequence) {
        return String.format(chipTextInputComboView.getResources().getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.chip.isChecked();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z) {
        int r2;
        Chip chip = this.chip;
        chip.setChecked(z);
        int r1 = 0;
        if (z) {
            r2 = 0;
        } else {
            r2 = 4;
        }
        EditText editText = this.editText;
        editText.setVisibility(r2);
        if (z) {
            r1 = 8;
        }
        chip.setVisibility(r1);
        if (isChecked()) {
            editText.requestFocus();
            editText.post(new Runnable() { // from class: com.google.android.material.internal.ViewUtils.1
                public final /* synthetic */ View val$view;

                public AnonymousClass1(EditText editText2) {
                    r1 = editText2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    View view = r1;
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
                }
            });
            if (!TextUtils.isEmpty(editText2.getText())) {
                editText2.setSelection(editText2.getText().length());
            }
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.chip.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setTag(int r2, Object obj) {
        this.chip.setTag(r2, obj);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.chip.toggle();
    }
}
