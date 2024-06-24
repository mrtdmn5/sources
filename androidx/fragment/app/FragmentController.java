package androidx.fragment.app;

import androidx.fragment.app.FragmentActivity;

/* loaded from: classes.dex */
public final class FragmentController {
    public final FragmentHostCallback<?> mHost;

    public FragmentController(FragmentActivity.HostCallbacks hostCallbacks) {
        this.mHost = hostCallbacks;
    }

    public final void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }
}
