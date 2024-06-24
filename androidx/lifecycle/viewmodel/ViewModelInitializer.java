package androidx.lifecycle.viewmodel;

import androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1;
import androidx.lifecycle.ViewModel;
import kotlin.jvm.functions.Function1;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: classes.dex */
public final class ViewModelInitializer<T extends ViewModel> {
    public final Class<T> clazz;
    public final Function1<CreationExtras, T> initializer;

    public ViewModelInitializer(Class cls, SavedStateHandleSupport$savedStateHandlesVM$1$1 savedStateHandleSupport$savedStateHandlesVM$1$1) {
        this.clazz = cls;
        this.initializer = savedStateHandleSupport$savedStateHandlesVM$1$1;
    }
}
