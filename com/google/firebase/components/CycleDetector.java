package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public final class CycleDetector {

    /* loaded from: classes3.dex */
    public static class ComponentNode {
        public final Component<?> component;
        public final HashSet dependencies = new HashSet();
        public final HashSet dependents = new HashSet();

        public ComponentNode(Component<?> component) {
            this.component = component;
        }
    }

    /* loaded from: classes3.dex */
    public static class Dep {
        public final Qualified<?> anInterface;
        public final boolean set;

        public Dep() {
            throw null;
        }

        public Dep(Qualified qualified, boolean z) {
            this.anInterface = qualified;
            this.set = z;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Dep)) {
                return false;
            }
            Dep dep = (Dep) obj;
            if (!dep.anInterface.equals(this.anInterface) || dep.set != this.set) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return ((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.set).hashCode();
        }
    }

    public static void detect(ArrayList arrayList) {
        boolean z;
        boolean z2;
        boolean z3;
        HashMap hashMap = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (true) {
            int r3 = 0;
            if (it.hasNext()) {
                Component component = (Component) it.next();
                ComponentNode componentNode = new ComponentNode(component);
                Iterator it2 = component.providedInterfaces.iterator();
                while (it2.hasNext()) {
                    Qualified qualified = (Qualified) it2.next();
                    if (component.type == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    boolean z4 = !z3;
                    Dep dep = new Dep(qualified, z4);
                    if (!hashMap.containsKey(dep)) {
                        hashMap.put(dep, new HashSet());
                    }
                    Set set = (Set) hashMap.get(dep);
                    if (!set.isEmpty() && !z4) {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", qualified));
                    }
                    set.add(componentNode);
                }
            } else {
                Iterator it3 = hashMap.values().iterator();
                while (it3.hasNext()) {
                    for (ComponentNode componentNode2 : (Set) it3.next()) {
                        for (Dependency dependency : componentNode2.component.dependencies) {
                            if (dependency.injection == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                if (dependency.type == 2) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                Set<ComponentNode> set2 = (Set) hashMap.get(new Dep(dependency.anInterface, z2));
                                if (set2 != null) {
                                    for (ComponentNode componentNode3 : set2) {
                                        componentNode2.dependencies.add(componentNode3);
                                        componentNode3.dependents.add(componentNode2);
                                    }
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it4 = hashMap.values().iterator();
                while (it4.hasNext()) {
                    hashSet.addAll((Set) it4.next());
                }
                HashSet hashSet2 = new HashSet();
                Iterator it5 = hashSet.iterator();
                while (it5.hasNext()) {
                    ComponentNode componentNode4 = (ComponentNode) it5.next();
                    if (componentNode4.dependents.isEmpty()) {
                        hashSet2.add(componentNode4);
                    }
                }
                while (!hashSet2.isEmpty()) {
                    ComponentNode componentNode5 = (ComponentNode) hashSet2.iterator().next();
                    hashSet2.remove(componentNode5);
                    r3++;
                    Iterator it6 = componentNode5.dependencies.iterator();
                    while (it6.hasNext()) {
                        ComponentNode componentNode6 = (ComponentNode) it6.next();
                        componentNode6.dependents.remove(componentNode5);
                        if (componentNode6.dependents.isEmpty()) {
                            hashSet2.add(componentNode6);
                        }
                    }
                }
                if (r3 == arrayList.size()) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it7 = hashSet.iterator();
                while (it7.hasNext()) {
                    ComponentNode componentNode7 = (ComponentNode) it7.next();
                    if (!componentNode7.dependents.isEmpty() && !componentNode7.dependencies.isEmpty()) {
                        arrayList2.add(componentNode7.component);
                    }
                }
                throw new DependencyCycleException(arrayList2);
            }
        }
    }
}
