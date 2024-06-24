package com.animaconnected.secondo.provider.remotecrash;

import com.animaconnected.future.MapCallback;
import com.animaconnected.secondo.screens.notification.magicword.MagicWordAdapter;
import com.animaconnected.secondo.screens.notification.magicword.MagicWordFragment;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class RemoteCrashProvider$$ExternalSyntheticLambda0 implements MapCallback, MagicWordAdapter.OnKeyWordClickedListener {
    @Override // com.animaconnected.secondo.screens.notification.magicword.MagicWordAdapter.OnKeyWordClickedListener
    public final void onKeyWordDeletedClick(int r1) {
        MagicWordFragment.lambda$onCreateView$0(r1);
    }

    @Override // com.animaconnected.future.MapCallback
    public final Object onResult(Object obj) {
        Boolean lambda$crashDeviceIfNeeded$0;
        lambda$crashDeviceIfNeeded$0 = RemoteCrashProvider.lambda$crashDeviceIfNeeded$0((Boolean) obj);
        return lambda$crashDeviceIfNeeded$0;
    }
}
