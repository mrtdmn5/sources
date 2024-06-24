package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: Firebase.kt */
@Keep
/* loaded from: classes3.dex */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        Component<?> create = LibraryVersionComponent.create("fire-core-ktx", "20.3.1");
        Qualified qualified = new Qualified(Background.class, CoroutineDispatcher.class);
        Qualified[] qualifiedArr = new Qualified[0];
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(qualified);
        for (Qualified qualified2 : qualifiedArr) {
            if (qualified2 == null) {
                throw new NullPointerException("Null interface");
            }
        }
        Collections.addAll(hashSet, qualifiedArr);
        Dependency dependency = new Dependency((Qualified<?>) new Qualified(Background.class, Executor.class), 1, 0);
        if (!hashSet.contains(dependency.anInterface)) {
            hashSet2.add(dependency);
            Component component = new Component(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1.INSTANCE, hashSet3);
            Qualified qualified3 = new Qualified(Lightweight.class, CoroutineDispatcher.class);
            Qualified[] qualifiedArr2 = new Qualified[0];
            HashSet hashSet4 = new HashSet();
            HashSet hashSet5 = new HashSet();
            HashSet hashSet6 = new HashSet();
            hashSet4.add(qualified3);
            for (Qualified qualified4 : qualifiedArr2) {
                if (qualified4 == null) {
                    throw new NullPointerException("Null interface");
                }
            }
            Collections.addAll(hashSet4, qualifiedArr2);
            Dependency dependency2 = new Dependency((Qualified<?>) new Qualified(Lightweight.class, Executor.class), 1, 0);
            if (!hashSet4.contains(dependency2.anInterface)) {
                hashSet5.add(dependency2);
                Component component2 = new Component(null, new HashSet(hashSet4), new HashSet(hashSet5), 0, 0, FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$2.INSTANCE, hashSet6);
                Qualified qualified5 = new Qualified(Blocking.class, CoroutineDispatcher.class);
                Qualified[] qualifiedArr3 = new Qualified[0];
                HashSet hashSet7 = new HashSet();
                HashSet hashSet8 = new HashSet();
                HashSet hashSet9 = new HashSet();
                hashSet7.add(qualified5);
                for (Qualified qualified6 : qualifiedArr3) {
                    if (qualified6 == null) {
                        throw new NullPointerException("Null interface");
                    }
                }
                Collections.addAll(hashSet7, qualifiedArr3);
                Dependency dependency3 = new Dependency((Qualified<?>) new Qualified(Blocking.class, Executor.class), 1, 0);
                if (!hashSet7.contains(dependency3.anInterface)) {
                    hashSet8.add(dependency3);
                    Component component3 = new Component(null, new HashSet(hashSet7), new HashSet(hashSet8), 0, 0, FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3.INSTANCE, hashSet9);
                    Qualified qualified7 = new Qualified(UiThread.class, CoroutineDispatcher.class);
                    Qualified[] qualifiedArr4 = new Qualified[0];
                    HashSet hashSet10 = new HashSet();
                    HashSet hashSet11 = new HashSet();
                    HashSet hashSet12 = new HashSet();
                    hashSet10.add(qualified7);
                    for (Qualified qualified8 : qualifiedArr4) {
                        if (qualified8 == null) {
                            throw new NullPointerException("Null interface");
                        }
                    }
                    Collections.addAll(hashSet10, qualifiedArr4);
                    Dependency dependency4 = new Dependency((Qualified<?>) new Qualified(UiThread.class, Executor.class), 1, 0);
                    if (!hashSet10.contains(dependency4.anInterface)) {
                        hashSet11.add(dependency4);
                        return CollectionsKt__CollectionsKt.listOf((Object[]) new Component[]{create, component, component2, component3, new Component(null, new HashSet(hashSet10), new HashSet(hashSet11), 0, 0, FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$4.INSTANCE, hashSet12)});
                    }
                    throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
                }
                throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
            }
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }
        throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
    }
}
