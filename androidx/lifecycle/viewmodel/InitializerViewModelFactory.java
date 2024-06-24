package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: classes.dex */
public final class InitializerViewModelFactory implements ViewModelProvider.Factory {
    public final ViewModelInitializer<?>[] initializers;

    public InitializerViewModelFactory(ViewModelInitializer<?>... initializers) {
        Intrinsics.checkNotNullParameter(initializers, "initializers");
        this.initializers = initializers;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        ViewModel viewModel = null;
        for (ViewModelInitializer<?> viewModelInitializer : this.initializers) {
            if (Intrinsics.areEqual(viewModelInitializer.clazz, cls)) {
                Object invoke = viewModelInitializer.initializer.invoke(mutableCreationExtras);
                if (invoke instanceof ViewModel) {
                    viewModel = (ViewModel) invoke;
                } else {
                    viewModel = null;
                }
            }
        }
        if (viewModel != null) {
            return viewModel;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }
}
