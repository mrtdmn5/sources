package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedStateViewModelFactory.kt */
/* loaded from: classes.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    public final Application application;
    public final Bundle defaultArgs;
    public final ViewModelProvider.AndroidViewModelFactory factory;
    public final Lifecycle lifecycle;
    public final SavedStateRegistry savedStateRegistry;

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner owner, Bundle bundle) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.savedStateRegistry = owner.getSavedStateRegistry();
        this.lifecycle = owner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = application;
        if (application != null) {
            if (ViewModelProvider.AndroidViewModelFactory.sInstance == null) {
                ViewModelProvider.AndroidViewModelFactory.sInstance = new ViewModelProvider.AndroidViewModelFactory(application);
            }
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.sInstance;
            Intrinsics.checkNotNull(androidViewModelFactory);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory(null);
        }
        this.factory = androidViewModelFactory;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        Constructor findMatchingConstructor;
        ViewModelProvider$NewInstanceFactory$Companion$ViewModelKeyImpl viewModelProvider$NewInstanceFactory$Companion$ViewModelKeyImpl = ViewModelProvider$NewInstanceFactory$Companion$ViewModelKeyImpl.INSTANCE;
        LinkedHashMap linkedHashMap = mutableCreationExtras.map;
        String str = (String) linkedHashMap.get(viewModelProvider$NewInstanceFactory$Companion$ViewModelKeyImpl);
        if (str != null) {
            if (linkedHashMap.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) != null && linkedHashMap.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) != null) {
                Application application = (Application) linkedHashMap.get(ViewModelProvider$AndroidViewModelFactory$Companion$ApplicationKeyImpl.INSTANCE);
                boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
                if (isAssignableFrom && application != null) {
                    findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.ANDROID_VIEWMODEL_SIGNATURE);
                } else {
                    findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.VIEWMODEL_SIGNATURE);
                }
                if (findMatchingConstructor == null) {
                    return this.factory.create(cls, mutableCreationExtras);
                }
                if (isAssignableFrom && application != null) {
                    return SavedStateViewModelFactoryKt.newInstance(cls, findMatchingConstructor, application, SavedStateHandleSupport.createSavedStateHandle(mutableCreationExtras));
                }
                return SavedStateViewModelFactoryKt.newInstance(cls, findMatchingConstructor, SavedStateHandleSupport.createSavedStateHandle(mutableCreationExtras));
            }
            if (this.lifecycle != null) {
                return create(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    public final void onRequery(ViewModel viewModel) {
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            Intrinsics.checkNotNull(savedStateRegistry);
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, lifecycle);
        }
    }

    public final <T extends ViewModel> T create(String str, Class<T> cls) {
        Constructor findMatchingConstructor;
        T t;
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            Application application = this.application;
            if (isAssignableFrom && application != null) {
                findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.ANDROID_VIEWMODEL_SIGNATURE);
            } else {
                findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.VIEWMODEL_SIGNATURE);
            }
            if (findMatchingConstructor == null) {
                if (application != null) {
                    return (T) this.factory.create(cls);
                }
                if (ViewModelProvider.NewInstanceFactory.sInstance == null) {
                    ViewModelProvider.NewInstanceFactory.sInstance = new ViewModelProvider.NewInstanceFactory();
                }
                ViewModelProvider.NewInstanceFactory newInstanceFactory = ViewModelProvider.NewInstanceFactory.sInstance;
                Intrinsics.checkNotNull(newInstanceFactory);
                return (T) newInstanceFactory.create(cls);
            }
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            Intrinsics.checkNotNull(savedStateRegistry);
            Bundle consumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey(str);
            Class<? extends Object>[] clsArr = SavedStateHandle.ACCEPTABLE_CLASSES;
            SavedStateHandle createHandle = SavedStateHandle.Companion.createHandle(consumeRestoredStateForKey, this.defaultArgs);
            SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, createHandle);
            savedStateHandleController.attachToLifecycle(lifecycle, savedStateRegistry);
            Lifecycle.State currentState = lifecycle.getCurrentState();
            if (currentState != Lifecycle.State.INITIALIZED && !currentState.isAtLeast(Lifecycle.State.STARTED)) {
                lifecycle.addObserver(new LegacySavedStateHandleController$tryToAddRecreator$1(lifecycle, savedStateRegistry));
            } else {
                savedStateRegistry.runOnNextRecreation();
            }
            if (isAssignableFrom && application != null) {
                t = (T) SavedStateViewModelFactoryKt.newInstance(cls, findMatchingConstructor, application, createHandle);
            } else {
                t = (T) SavedStateViewModelFactoryKt.newInstance(cls, findMatchingConstructor, createHandle);
            }
            t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
            return t;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
