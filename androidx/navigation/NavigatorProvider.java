package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.navigation.Navigator;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;

@SuppressLint({"TypeParameterUnusedInFormals"})
/* loaded from: classes.dex */
public final class NavigatorProvider {
    public static final HashMap<Class<?>, String> sAnnotationNames = new HashMap<>();
    public final HashMap<String, Navigator<? extends NavDestination>> mNavigators = new HashMap<>();

    public static String getNameForNavigator(Class<? extends Navigator> cls) {
        boolean z;
        HashMap<Class<?>, String> hashMap = sAnnotationNames;
        String str = hashMap.get(cls);
        if (str == null) {
            Navigator.Name name = (Navigator.Name) cls.getAnnotation(Navigator.Name.class);
            if (name != null) {
                str = name.value();
            } else {
                str = null;
            }
            if (str != null && !str.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                hashMap.put(cls, str);
            } else {
                throw new IllegalArgumentException("No @Navigator.Name annotation found for ".concat(cls.getSimpleName()));
            }
        }
        return str;
    }

    public final void addNavigator(Navigator navigator) {
        boolean z;
        String nameForNavigator = getNameForNavigator(navigator.getClass());
        if (nameForNavigator != null && !nameForNavigator.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.mNavigators.put(nameForNavigator, navigator);
            return;
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    public final <T extends Navigator<?>> T getNavigator(String str) {
        boolean z;
        if (str != null && !str.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Navigator<? extends NavDestination> navigator = this.mNavigators.get(str);
            if (navigator != null) {
                return navigator;
            }
            throw new IllegalStateException(zzav$$ExternalSyntheticOutline0.m("Could not find Navigator with name \"", str, "\". You must call NavController.addNavigator() for each navigation type."));
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }
}
