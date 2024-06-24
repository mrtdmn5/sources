package com.animaconnected.secondo.provider.behaviouritems;

import com.animaconnected.secondo.KronabyApplication;

/* loaded from: classes3.dex */
public class DoubleCrownProvider {
    private static DoubleCrownProvider sInstance;
    private final DoubleCrownProviderStorage mStorage = new DoubleCrownProviderStorage(KronabyApplication.getContext());

    public void setShouldShowDoubleCrown(boolean z) {
        this.mStorage.setShouldShowDoubleCrown(z);
    }

    public boolean shouldShowDoubleCrown() {
        return this.mStorage.getShouldShowDoubleCrown();
    }
}
