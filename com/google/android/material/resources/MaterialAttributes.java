package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;

/* loaded from: classes3.dex */
public final class MaterialAttributes {
    public static TypedValue resolve(Context context, int r3) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(r3, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static int resolveOrThrow(int r1, Context context, String str) {
        TypedValue resolve = resolve(context, r1);
        if (resolve != null) {
            return resolve.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(r1)));
    }
}
