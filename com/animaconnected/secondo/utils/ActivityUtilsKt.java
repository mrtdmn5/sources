package com.animaconnected.secondo.utils;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityUtils.kt */
/* loaded from: classes3.dex */
public final class ActivityUtilsKt {
    public static final void hideKeyboard(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = activity.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }
}
