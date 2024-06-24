package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
public class FragmentFactory {
    public static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> sClassCacheMap = new SimpleArrayMap<>();

    public static Class<?> loadClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
        SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> simpleArrayMap = sClassCacheMap;
        SimpleArrayMap<String, Class<?>> orDefault = simpleArrayMap.getOrDefault(classLoader, null);
        if (orDefault == null) {
            orDefault = new SimpleArrayMap<>();
            simpleArrayMap.put(classLoader, orDefault);
        }
        Class<?> orDefault2 = orDefault.getOrDefault(str, null);
        if (orDefault2 == null) {
            Class<?> cls = Class.forName(str, false, classLoader);
            orDefault.put(str, cls);
            return cls;
        }
        return orDefault2;
    }

    public static Class<? extends Fragment> loadFragmentClass(ClassLoader classLoader, String str) {
        try {
            return loadClass(classLoader, str);
        } catch (ClassCastException e) {
            throw new Fragment.InstantiationException(zzav$$ExternalSyntheticOutline0.m("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.InstantiationException(zzav$$ExternalSyntheticOutline0.m("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        }
    }

    public Fragment instantiate(String str) {
        throw null;
    }
}
