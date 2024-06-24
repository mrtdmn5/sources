package com.animaconnected.secondo.screens.pickerdialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.Calendar;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimePickerShower.kt */
/* loaded from: classes3.dex */
public final class TimePickerShower {
    public static final int $stable = 0;
    private static final String FRAG_TAG_TIME_PICKER = "time_dialog";
    public static final TimePickerShower INSTANCE = new TimePickerShower();

    /* compiled from: TimePickerShower.kt */
    /* loaded from: classes3.dex */
    public static final class TimePickerDialogFragment extends DialogFragment {
        public static final int $stable = 8;
        private Integer hours;
        private TimePickerDialog.OnTimeSetListener listener;
        private Integer minutes;
        private final int style;

        @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
        public CreationExtras getDefaultViewModelCreationExtras() {
            return CreationExtras.Empty.INSTANCE;
        }

        public final Integer getHours() {
            return this.hours;
        }

        public final TimePickerDialog.OnTimeSetListener getListener() {
            return this.listener;
        }

        public final Integer getMinutes() {
            return this.minutes;
        }

        public final int getStyle() {
            return this.style;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            int r0;
            int r9;
            Calendar calendar = Calendar.getInstance();
            Integer num = this.hours;
            if (num != null) {
                r0 = num.intValue();
            } else {
                r0 = calendar.get(11);
            }
            int r5 = r0;
            Integer num2 = this.minutes;
            if (num2 != null) {
                r9 = num2.intValue();
            } else {
                r9 = calendar.get(12);
            }
            return new TimePickerDialog(getActivity(), this.style, this.listener, r5, r9, DateFormat.is24HourFormat(getActivity()));
        }

        public final void setHours(Integer num) {
            this.hours = num;
        }

        public final void setListener(TimePickerDialog.OnTimeSetListener onTimeSetListener) {
            this.listener = onTimeSetListener;
        }

        public final void setMinutes(Integer num) {
            this.minutes = num;
        }
    }

    private TimePickerShower() {
    }

    public static final void showTimeEditDialog(Fragment targetFragment, int r5, int r6, final Function2<? super Integer, ? super Integer, Unit> onTimeSetListener) {
        Intrinsics.checkNotNullParameter(targetFragment, "targetFragment");
        Intrinsics.checkNotNullParameter(onTimeSetListener, "onTimeSetListener");
        FragmentManager parentFragmentManager = targetFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        BackStackRecord backStackRecord = new BackStackRecord(parentFragmentManager);
        Fragment findFragmentByTag = parentFragmentManager.findFragmentByTag(FRAG_TAG_TIME_PICKER);
        if (findFragmentByTag != null) {
            backStackRecord.remove(findFragmentByTag);
        }
        backStackRecord.commit();
        TimePickerDialogFragment timePickerDialogFragment = new TimePickerDialogFragment();
        timePickerDialogFragment.setTargetFragment(targetFragment, 0);
        timePickerDialogFragment.setListener(new TimePickerDialog.OnTimeSetListener() { // from class: com.animaconnected.secondo.screens.pickerdialog.TimePickerShower$$ExternalSyntheticLambda0
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public final void onTimeSet(TimePicker timePicker, int r3, int r4) {
                TimePickerShower.showTimeEditDialog$lambda$2$lambda$1(Function2.this, timePicker, r3, r4);
            }
        });
        timePickerDialogFragment.setHours(Integer.valueOf(r5));
        timePickerDialogFragment.setMinutes(Integer.valueOf(r6));
        timePickerDialogFragment.show(parentFragmentManager, FRAG_TAG_TIME_PICKER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTimeEditDialog$lambda$2$lambda$1(Function2 onTimeSetListener, TimePicker timePicker, int r2, int r3) {
        Intrinsics.checkNotNullParameter(onTimeSetListener, "$onTimeSetListener");
        onTimeSetListener.invoke(Integer.valueOf(r2), Integer.valueOf(r3));
    }
}
