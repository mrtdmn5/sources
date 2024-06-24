package com.google.firebase.components;

import android.util.Log;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ComponentRuntime implements ComponentContainer, ComponentLoader {
    public static final ComponentRuntime$$ExternalSyntheticLambda1 EMPTY_PROVIDER = new ComponentRuntime$$ExternalSyntheticLambda1();
    public final ComponentRegistrarProcessor componentRegistrarProcessor;
    public final EventBus eventBus;
    public final HashMap components = new HashMap();
    public final HashMap lazyInstanceMap = new HashMap();
    public final HashMap lazySetMap = new HashMap();
    public final AtomicReference<Boolean> eagerComponentsInitializedWith = new AtomicReference<>();

    public ComponentRuntime(Executor executor, ArrayList arrayList, ArrayList arrayList2, ComponentRegistrarProcessor componentRegistrarProcessor) {
        EventBus eventBus = new EventBus(executor);
        this.eventBus = eventBus;
        this.componentRegistrarProcessor = componentRegistrarProcessor;
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(Component.of(eventBus, EventBus.class, Subscriber.class, Publisher.class));
        arrayList3.add(Component.of(this, ComponentLoader.class, new Class[0]));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Component component = (Component) it.next();
            if (component != null) {
                arrayList3.add(component);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList4.add(it2.next());
        }
        ArrayList arrayList5 = new ArrayList();
        synchronized (this) {
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((Provider) it3.next()).get();
                    if (componentRegistrar != null) {
                        arrayList3.addAll(this.componentRegistrarProcessor.processRegistrar(componentRegistrar));
                        it3.remove();
                    }
                } catch (InvalidRegistrarException e) {
                    it3.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            if (this.components.isEmpty()) {
                CycleDetector.detect(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.components.keySet());
                arrayList6.addAll(arrayList3);
                CycleDetector.detect(arrayList6);
            }
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                final Component component2 = (Component) it4.next();
                this.components.put(component2, new Lazy(new Provider() { // from class: com.google.firebase.components.ComponentRuntime$$ExternalSyntheticLambda0
                    @Override // com.google.firebase.inject.Provider
                    public final Object get() {
                        ComponentRuntime componentRuntime = ComponentRuntime.this;
                        componentRuntime.getClass();
                        Component component3 = component2;
                        return component3.factory.create(new RestrictedComponentContainer(component3, componentRuntime));
                    }
                }));
            }
            arrayList5.addAll(processInstanceComponents(arrayList3));
            arrayList5.addAll(processSetComponents());
            processDependencies();
        }
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            ((Runnable) it5.next()).run();
        }
        Boolean bool = this.eagerComponentsInitializedWith.get();
        if (bool != null) {
            doInitializeEagerComponents(this.components, bool.booleanValue());
        }
    }

    public final void doInitializeEagerComponents(Map<Component<?>, Provider<?>> map, boolean z) {
        ArrayDeque<Event> arrayDeque;
        Set<Map.Entry> entrySet;
        boolean z2;
        for (Map.Entry<Component<?>, Provider<?>> entry : map.entrySet()) {
            Component<?> key = entry.getKey();
            Provider<?> value = entry.getValue();
            int r1 = key.instantiation;
            boolean z3 = false;
            if (r1 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                if (r1 == 2) {
                    z3 = true;
                }
                if (z3 && z) {
                }
            }
            value.get();
        }
        EventBus eventBus = this.eventBus;
        synchronized (eventBus) {
            try {
                arrayDeque = eventBus.pendingEvents;
                if (arrayDeque != null) {
                    eventBus.pendingEvents = null;
                } else {
                    arrayDeque = null;
                }
            } finally {
            }
        }
        if (arrayDeque != null) {
            for (final Event event : arrayDeque) {
                event.getClass();
                synchronized (eventBus) {
                    ArrayDeque arrayDeque2 = eventBus.pendingEvents;
                    if (arrayDeque2 != null) {
                        arrayDeque2.add(event);
                    } else {
                        synchronized (eventBus) {
                            Map map2 = (Map) eventBus.handlerMap.get(null);
                            if (map2 == null) {
                                entrySet = Collections.emptySet();
                            } else {
                                entrySet = map2.entrySet();
                            }
                        }
                        for (final Map.Entry entry2 : entrySet) {
                            ((Executor) entry2.getValue()).execute(new Runnable() { // from class: com.google.firebase.components.EventBus$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ((EventHandler) entry2.getKey()).handle(event);
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final <T> Deferred<T> getDeferred(Qualified<T> qualified) {
        Provider<T> provider = getProvider(qualified);
        if (provider == null) {
            return new OptionalProvider(OptionalProvider.NOOP_HANDLER, OptionalProvider.EMPTY_PROVIDER);
        }
        if (provider instanceof OptionalProvider) {
            return (OptionalProvider) provider;
        }
        return new OptionalProvider(null, provider);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final synchronized <T> Provider<T> getProvider(Qualified<T> qualified) {
        if (qualified != null) {
        } else {
            throw new NullPointerException("Null interface requested.");
        }
        return (Provider) this.lazyInstanceMap.get(qualified);
    }

    public final void processDependencies() {
        boolean z;
        boolean z2;
        for (Component component : this.components.keySet()) {
            for (Dependency dependency : component.dependencies) {
                boolean z3 = true;
                if (dependency.type == 2) {
                    z = true;
                } else {
                    z = false;
                }
                Qualified<?> qualified = dependency.anInterface;
                if (z) {
                    HashMap hashMap = this.lazySetMap;
                    if (!hashMap.containsKey(qualified)) {
                        hashMap.put(qualified, new LazySet(Collections.emptySet()));
                    }
                }
                HashMap hashMap2 = this.lazyInstanceMap;
                if (hashMap2.containsKey(qualified)) {
                    continue;
                } else {
                    int r3 = dependency.type;
                    if (r3 == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        if (r3 != 2) {
                            z3 = false;
                        }
                        if (!z3) {
                            hashMap2.put(qualified, new OptionalProvider(OptionalProvider.NOOP_HANDLER, OptionalProvider.EMPTY_PROVIDER));
                        }
                    } else {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component, qualified));
                    }
                }
            }
        }
    }

    public final ArrayList processInstanceComponents(ArrayList arrayList) {
        boolean z;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Component component = (Component) it.next();
            if (component.type == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                final Provider provider = (Provider) this.components.get(component);
                Iterator it2 = component.providedInterfaces.iterator();
                while (it2.hasNext()) {
                    Qualified qualified = (Qualified) it2.next();
                    HashMap hashMap = this.lazyInstanceMap;
                    if (!hashMap.containsKey(qualified)) {
                        hashMap.put(qualified, provider);
                    } else {
                        final OptionalProvider optionalProvider = (OptionalProvider) ((Provider) hashMap.get(qualified));
                        arrayList2.add(new Runnable() { // from class: com.google.firebase.components.ComponentRuntime$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                Deferred.DeferredHandler<T> deferredHandler;
                                OptionalProvider optionalProvider2 = OptionalProvider.this;
                                Provider<T> provider2 = provider;
                                if (optionalProvider2.delegate == OptionalProvider.EMPTY_PROVIDER) {
                                    synchronized (optionalProvider2) {
                                        deferredHandler = optionalProvider2.handler;
                                        optionalProvider2.handler = null;
                                        optionalProvider2.delegate = provider2;
                                    }
                                    deferredHandler.handle(provider2);
                                    return;
                                }
                                throw new IllegalStateException("provide() can be called only once.");
                            }
                        });
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList processSetComponents() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.components.entrySet()) {
            Component component = (Component) entry.getKey();
            if (component.type == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Provider provider = (Provider) entry.getValue();
                Iterator it = component.providedInterfaces.iterator();
                while (it.hasNext()) {
                    Qualified qualified = (Qualified) it.next();
                    if (!hashMap.containsKey(qualified)) {
                        hashMap.put(qualified, new HashSet());
                    }
                    ((Set) hashMap.get(qualified)).add(provider);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            Object key = entry2.getKey();
            HashMap hashMap2 = this.lazySetMap;
            if (!hashMap2.containsKey(key)) {
                hashMap2.put((Qualified) entry2.getKey(), new LazySet((Set) ((Collection) entry2.getValue())));
            } else {
                final LazySet lazySet = (LazySet) hashMap2.get(entry2.getKey());
                for (final Provider provider2 : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: com.google.firebase.components.ComponentRuntime$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            LazySet lazySet2 = LazySet.this;
                            Provider provider3 = provider2;
                            synchronized (lazySet2) {
                                if (lazySet2.actualSet == null) {
                                    lazySet2.providers.add(provider3);
                                } else {
                                    lazySet2.actualSet.add(provider3.get());
                                }
                            }
                        }
                    });
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final synchronized <T> Provider<Set<T>> setOfProvider(Qualified<T> qualified) {
        LazySet lazySet = (LazySet) this.lazySetMap.get(qualified);
        if (lazySet != null) {
            return lazySet;
        }
        return EMPTY_PROVIDER;
    }
}
