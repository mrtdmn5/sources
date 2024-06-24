package com.animaconnected.secondo.provider.behaviouritems;

import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
class DoubleCrownProviderStorage {
    private static final String DOUBLE_CROWN_PROVIDER_STORAGE = "doubleCrownProviderStorage";
    private static final String KEY_SHOULD_SHOW_DOUBLE_CROWN = "shouldShowDoubleCrown";
    private final Context mContext;

    public DoubleCrownProviderStorage(Context context) {
        this.mContext = context;
    }

    private SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(DOUBLE_CROWN_PROVIDER_STORAGE, 0);
    }

    public boolean getShouldShowDoubleCrown() {
        return getSharedPreferences(this.mContext).getBoolean(KEY_SHOULD_SHOW_DOUBLE_CROWN, false);
    }

    public void setShouldShowDoubleCrown(boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(this.mContext), KEY_SHOULD_SHOW_DOUBLE_CROWN, z);
    }
}
