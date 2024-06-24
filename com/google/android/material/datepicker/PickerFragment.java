package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import com.google.android.material.datepicker.MaterialDatePicker;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public abstract class PickerFragment<S> extends Fragment {
    public final LinkedHashSet<OnSelectionChangedListener<S>> onSelectionChangedListeners = new LinkedHashSet<>();

    public boolean addOnSelectionChangedListener(MaterialDatePicker.AnonymousClass4 anonymousClass4) {
        return this.onSelectionChangedListeners.add(anonymousClass4);
    }
}
