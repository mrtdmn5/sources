package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public final class ClassesInfoCache {
    public static final ClassesInfoCache sInstance = new ClassesInfoCache();
    public final HashMap mCallbackMap = new HashMap();
    public final HashMap mHasLifecycleMethods = new HashMap();

    @Deprecated
    /* loaded from: classes.dex */
    public static class CallbackInfo {
        public final HashMap mEventToHandlers = new HashMap();
        public final Map<MethodReference, Lifecycle.Event> mHandlerToEvent;

        public CallbackInfo(HashMap hashMap) {
            this.mHandlerToEvent = hashMap;
            for (Map.Entry entry : hashMap.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) entry.getValue();
                List list = (List) this.mEventToHandlers.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.mEventToHandlers.put(event, list);
                }
                list.add((MethodReference) entry.getKey());
            }
        }

        public static void invokeMethodsForEvent(List<MethodReference> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    MethodReference methodReference = list.get(size);
                    methodReference.getClass();
                    try {
                        int r3 = methodReference.mCallType;
                        Method method = methodReference.mMethod;
                        if (r3 != 0) {
                            if (r3 != 1) {
                                if (r3 == 2) {
                                    method.invoke(obj, lifecycleOwner, event);
                                }
                            } else {
                                method.invoke(obj, lifecycleOwner);
                            }
                        } else {
                            method.invoke(obj, new Object[0]);
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to call observer method", e2.getCause());
                    }
                }
            }
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static final class MethodReference {
        public final int mCallType;
        public final Method mMethod;

        public MethodReference(int r1, Method method) {
            this.mCallType = r1;
            this.mMethod = method;
            method.setAccessible(true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodReference)) {
                return false;
            }
            MethodReference methodReference = (MethodReference) obj;
            if (this.mCallType == methodReference.mCallType && this.mMethod.getName().equals(methodReference.mMethod.getName())) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.mMethod.getName().hashCode() + (this.mCallType * 31);
        }
    }

    public static void verifyAndPutHandler(HashMap hashMap, MethodReference methodReference, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = (Lifecycle.Event) hashMap.get(methodReference);
        if (event2 != null && event != event2) {
            throw new IllegalArgumentException("Method " + methodReference.mMethod.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        }
        if (event2 == null) {
            hashMap.put(methodReference, event);
        }
    }

    public final CallbackInfo createInfo(Class<?> cls, Method[] methodArr) {
        int r7;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null) {
            hashMap.putAll(getInfo(superclass).mHandlerToEvent);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : getInfo(cls2).mHandlerToEvent.entrySet()) {
                verifyAndPutHandler(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length > 0) {
                    if (LifecycleOwner.class.isAssignableFrom(parameterTypes[0])) {
                        r7 = 1;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                } else {
                    r7 = 0;
                }
                Lifecycle.Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        if (value == Lifecycle.Event.ON_ANY) {
                            r7 = 2;
                        } else {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    verifyAndPutHandler(hashMap, new MethodReference(r7, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        CallbackInfo callbackInfo = new CallbackInfo(hashMap);
        this.mCallbackMap.put(cls, callbackInfo);
        this.mHasLifecycleMethods.put(cls, Boolean.valueOf(z));
        return callbackInfo;
    }

    public final CallbackInfo getInfo(Class<?> cls) {
        CallbackInfo callbackInfo = (CallbackInfo) this.mCallbackMap.get(cls);
        if (callbackInfo != null) {
            return callbackInfo;
        }
        return createInfo(cls, null);
    }
}
