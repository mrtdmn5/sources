package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedStateViewModelFactory.kt */
/* loaded from: classes.dex */
public final class SavedStateViewModelFactoryKt {
    public static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{Application.class, SavedStateHandle.class});
    public static final List<Class<?>> VIEWMODEL_SIGNATURE = CollectionsKt__CollectionsKt.listOf(SavedStateHandle.class);

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> cls, List<? extends Class<?>> signature) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        Object[] constructors = cls.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "modelClass.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
            List list = ArraysKt___ArraysKt.toList(parameterTypes);
            if (Intrinsics.areEqual(signature, list)) {
                return constructor;
            }
            if (signature.size() == list.size() && list.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        try {
            return constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Failed to access ", cls), e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("An exception happened in constructor of ", cls), e3.getCause());
        }
    }
}
