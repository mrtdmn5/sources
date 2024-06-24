package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;

/* compiled from: HasDefaultViewModelProviderFactory.kt */
/* loaded from: classes.dex */
public interface HasDefaultViewModelProviderFactory {
    default CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }
}
