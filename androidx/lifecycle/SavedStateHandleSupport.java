package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: classes.dex */
public final class SavedStateHandleSupport {
    public static final SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1 SAVED_STATE_REGISTRY_OWNER_KEY = new SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1();
    public static final SavedStateHandleSupport$VIEW_MODEL_STORE_OWNER_KEY$1 VIEW_MODEL_STORE_OWNER_KEY = new SavedStateHandleSupport$VIEW_MODEL_STORE_OWNER_KEY$1();
    public static final SavedStateHandleSupport$DEFAULT_ARGS_KEY$1 DEFAULT_ARGS_KEY = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();

    public static final SavedStateHandle createSavedStateHandle(MutableCreationExtras mutableCreationExtras) {
        SavedStateHandlesProvider savedStateHandlesProvider;
        Bundle bundle;
        SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1 savedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1 = SAVED_STATE_REGISTRY_OWNER_KEY;
        LinkedHashMap linkedHashMap = mutableCreationExtras.map;
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) linkedHashMap.get(savedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1);
        if (savedStateRegistryOwner != null) {
            ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) linkedHashMap.get(VIEW_MODEL_STORE_OWNER_KEY);
            if (viewModelStoreOwner != null) {
                Bundle bundle2 = (Bundle) linkedHashMap.get(DEFAULT_ARGS_KEY);
                String str = (String) linkedHashMap.get(ViewModelProvider$NewInstanceFactory$Companion$ViewModelKeyImpl.INSTANCE);
                if (str != null) {
                    SavedStateRegistry.SavedStateProvider savedStateProvider = savedStateRegistryOwner.getSavedStateRegistry().getSavedStateProvider();
                    if (savedStateProvider instanceof SavedStateHandlesProvider) {
                        savedStateHandlesProvider = (SavedStateHandlesProvider) savedStateProvider;
                    } else {
                        savedStateHandlesProvider = null;
                    }
                    if (savedStateHandlesProvider != null) {
                        LinkedHashMap linkedHashMap2 = getSavedStateHandlesVM(viewModelStoreOwner).handles;
                        SavedStateHandle savedStateHandle = (SavedStateHandle) linkedHashMap2.get(str);
                        if (savedStateHandle == null) {
                            Class<? extends Object>[] clsArr = SavedStateHandle.ACCEPTABLE_CLASSES;
                            boolean z = true;
                            if (!savedStateHandlesProvider.restored) {
                                savedStateHandlesProvider.restoredState = savedStateHandlesProvider.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
                                savedStateHandlesProvider.restored = true;
                            }
                            Bundle bundle3 = savedStateHandlesProvider.restoredState;
                            if (bundle3 != null) {
                                bundle = bundle3.getBundle(str);
                            } else {
                                bundle = null;
                            }
                            Bundle bundle4 = savedStateHandlesProvider.restoredState;
                            if (bundle4 != null) {
                                bundle4.remove(str);
                            }
                            Bundle bundle5 = savedStateHandlesProvider.restoredState;
                            if (bundle5 == null || !bundle5.isEmpty()) {
                                z = false;
                            }
                            if (z) {
                                savedStateHandlesProvider.restoredState = null;
                            }
                            SavedStateHandle createHandle = SavedStateHandle.Companion.createHandle(bundle, bundle2);
                            linkedHashMap2.put(str, createHandle);
                            return createHandle;
                        }
                        return savedStateHandle;
                    }
                    throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    public static final SavedStateHandlesVM getSavedStateHandlesVM(ViewModelStoreOwner viewModelStoreOwner) {
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "<this>");
        ArrayList arrayList = new ArrayList();
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SavedStateHandlesVM.class);
        SavedStateHandleSupport$savedStateHandlesVM$1$1 initializer = new Function1<CreationExtras, SavedStateHandlesVM>() { // from class: androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1
            @Override // kotlin.jvm.functions.Function1
            public final SavedStateHandlesVM invoke(CreationExtras creationExtras2) {
                CreationExtras initializer2 = creationExtras2;
                Intrinsics.checkNotNullParameter(initializer2, "$this$initializer");
                return new SavedStateHandlesVM();
            }
        };
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        arrayList.add(new ViewModelInitializer(JvmClassMappingKt.getJavaClass(orCreateKotlinClass), initializer));
        ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) arrayList.toArray(new ViewModelInitializer[0]);
        InitializerViewModelFactory initializerViewModelFactory = new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
        ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
        if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
            creationExtras = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras();
        } else {
            creationExtras = CreationExtras.Empty.INSTANCE;
        }
        return (SavedStateHandlesVM) new ViewModelProvider(viewModelStore, initializerViewModelFactory, creationExtras).get("androidx.lifecycle.internal.SavedStateHandlesVM", SavedStateHandlesVM.class);
    }
}
