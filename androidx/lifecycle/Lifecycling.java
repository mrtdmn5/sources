package androidx.lifecycle;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: Lifecycling.kt */
/* loaded from: classes.dex */
public final class Lifecycling {
    public static final HashMap callbackCache = new HashMap();
    public static final HashMap classToAdapters = new HashMap();

    public static GeneratedAdapter createGeneratedAdapter(Constructor constructor, Object obj) {
        try {
            Object newInstance = constructor.newInstance(obj);
            Intrinsics.checkNotNullExpressionValue(newInstance, "{\n            constructo…tance(`object`)\n        }");
            return (GeneratedAdapter) newInstance;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getObserverConstructorType(Class cls) {
        Constructor constructor;
        boolean z;
        boolean z2;
        boolean z3;
        String fullPackage;
        boolean z4;
        boolean z5;
        HashMap hashMap = callbackCache;
        Integer num = (Integer) hashMap.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int r2 = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r4 = cls.getPackage();
                String name = cls.getCanonicalName();
                if (r4 != null) {
                    fullPackage = r4.getName();
                } else {
                    fullPackage = "";
                }
                Intrinsics.checkNotNullExpressionValue(fullPackage, "fullPackage");
                if (fullPackage.length() == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z4) {
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    name = name.substring(fullPackage.length() + 1);
                    Intrinsics.checkNotNullExpressionValue(name, "this as java.lang.String).substring(startIndex)");
                }
                Intrinsics.checkNotNullExpressionValue(name, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
                String concat = StringsKt__StringsJVMKt.replace$default(name, InstructionFileId.DOT, "_").concat("_LifecycleAdapter");
                if (fullPackage.length() == 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (!z5) {
                    concat = fullPackage + '.' + concat;
                }
                constructor = Class.forName(concat).getDeclaredConstructor(cls);
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            HashMap hashMap2 = classToAdapters;
            if (constructor != null) {
                hashMap2.put(cls, CollectionsKt__CollectionsKt.listOf(constructor));
            } else {
                ClassesInfoCache classesInfoCache = ClassesInfoCache.sInstance;
                HashMap hashMap3 = classesInfoCache.mHasLifecycleMethods;
                Boolean bool = (Boolean) hashMap3.get(cls);
                if (bool != null) {
                    z = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int r9 = 0;
                        while (true) {
                            if (r9 < length) {
                                if (((OnLifecycleEvent) declaredMethods[r9].getAnnotation(OnLifecycleEvent.class)) != null) {
                                    classesInfoCache.createInfo(cls, declaredMethods);
                                    z = true;
                                    break;
                                }
                                r9++;
                            } else {
                                hashMap3.put(cls, Boolean.FALSE);
                                z = false;
                                break;
                            }
                        }
                    } catch (NoClassDefFoundError e2) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
                    }
                }
                if (!z) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && LifecycleObserver.class.isAssignableFrom(superclass)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        Intrinsics.checkNotNullExpressionValue(superclass, "superclass");
                        if (getObserverConstructorType(superclass) != 1) {
                            Object obj = hashMap2.get(superclass);
                            Intrinsics.checkNotNull(obj);
                            arrayList = new ArrayList((Collection) obj);
                        }
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    Intrinsics.checkNotNullExpressionValue(interfaces, "klass.interfaces");
                    int length2 = interfaces.length;
                    int r8 = 0;
                    while (true) {
                        if (r8 < length2) {
                            Class<?> intrface = interfaces[r8];
                            if (intrface != null && LifecycleObserver.class.isAssignableFrom(intrface)) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                Intrinsics.checkNotNullExpressionValue(intrface, "intrface");
                                if (getObserverConstructorType(intrface) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                Object obj2 = hashMap2.get(intrface);
                                Intrinsics.checkNotNull(obj2);
                                arrayList.addAll((Collection) obj2);
                            }
                            r8++;
                        } else if (arrayList != null) {
                            hashMap2.put(cls, arrayList);
                        }
                    }
                }
            }
            r2 = 2;
        }
        hashMap.put(cls, Integer.valueOf(r2));
        return r2;
    }
}
