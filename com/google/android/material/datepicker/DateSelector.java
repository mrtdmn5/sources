package com.google.android.material.datepicker;

import android.os.Parcelable;
import android.view.View;
import androidx.core.util.Pair;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface DateSelector<S> extends Parcelable {
    int getDefaultThemeResId();

    Collection<Long> getSelectedDays();

    Collection<Pair<Long, Long>> getSelectedRanges();

    S getSelection();

    String getSelectionDisplayString();

    boolean isSelectionComplete();

    View onCreateTextInputView();

    void select();
}
