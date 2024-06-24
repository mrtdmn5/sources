package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public final class ViewModelProvider {
    public final CreationExtras defaultCreationExtras;
    public final Factory factory;
    public final ViewModelStore store;

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public interface Factory {
        default <T extends ViewModel> T create(Class<T> cls) {
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        default ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
            return create(cls);
        }
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class NewInstanceFactory implements Factory {
        public static NewInstanceFactory sInstance;

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls) {
            try {
                T newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(newInstance, "{\n                modelC…wInstance()\n            }");
                return newInstance;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Cannot create an instance of ", cls), e);
            } catch (InstantiationException e2) {
                throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Cannot create an instance of ", cls), e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Cannot create an instance of ", cls), e3);
            }
        }
    }

    public ViewModelProvider(ViewModelStore store, Factory factory, CreationExtras defaultCreationExtras) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(defaultCreationExtras, "defaultCreationExtras");
        this.store = store;
        this.factory = factory;
        this.defaultCreationExtras = defaultCreationExtras;
    }

    public final <T extends ViewModel> T get(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends ViewModel> T get(String key, Class<T> cls) {
        T t;
        Intrinsics.checkNotNullParameter(key, "key");
        ViewModelStore viewModelStore = this.store;
        viewModelStore.getClass();
        T t2 = (T) viewModelStore.map.get(key);
        boolean isInstance = cls.isInstance(t2);
        Factory factory = this.factory;
        if (isInstance) {
            OnRequeryFactory onRequeryFactory = factory instanceof OnRequeryFactory ? (OnRequeryFactory) factory : null;
            if (onRequeryFactory != null) {
                Intrinsics.checkNotNull(t2);
                onRequeryFactory.onRequery(t2);
            }
            Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return t2;
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.defaultCreationExtras);
        mutableCreationExtras.map.put(ViewModelProvider$NewInstanceFactory$Companion$ViewModelKeyImpl.INSTANCE, key);
        try {
            t = (T) factory.create(cls, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            t = (T) factory.create(cls);
        }
        T viewModel = t;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        ViewModel viewModel2 = (ViewModel) viewModelStore.map.put(key, t);
        if (viewModel2 != null) {
            viewModel2.onCleared();
        }
        return t;
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore store, Factory factory) {
        this(store, factory, CreationExtras.Empty.INSTANCE);
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static AndroidViewModelFactory sInstance;
        public final Application application;

        public AndroidViewModelFactory(Application application) {
            this.application = application;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
            if (this.application != null) {
                return create(cls);
            }
            Application application = (Application) mutableCreationExtras.map.get(ViewModelProvider$AndroidViewModelFactory$Companion$ApplicationKeyImpl.INSTANCE);
            if (application != null) {
                return create(cls, application);
            }
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T create(Class<T> cls) {
            Application application = this.application;
            if (application != null) {
                return (T) create(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        public final <T extends ViewModel> T create(Class<T> cls, Application application) {
            if (AndroidViewModel.class.isAssignableFrom(cls)) {
                try {
                    T newInstance = cls.getConstructor(Application.class).newInstance(application);
                    Intrinsics.checkNotNullExpressionValue(newInstance, "{\n                try {\n…          }\n            }");
                    return newInstance;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Cannot create an instance of ", cls), e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Cannot create an instance of ", cls), e2);
                } catch (NoSuchMethodException e3) {
                    throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Cannot create an instance of ", cls), e3);
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Cannot create an instance of ", cls), e4);
                }
            }
            return (T) super.create(cls);
        }
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class OnRequeryFactory {
        public void onRequery(ViewModel viewModel) {
        }
    }
}
