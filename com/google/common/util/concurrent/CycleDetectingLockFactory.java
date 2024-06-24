package com.google.common.util.concurrent;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import kotlin.text.UStringsKt;

/* loaded from: classes3.dex */
public final class CycleDetectingLockFactory {

    /* renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static class AnonymousClass1 extends ThreadLocal<ArrayList<LockGraphNode>> {
        @Override // java.lang.ThreadLocal
        public final ArrayList<LockGraphNode> initialValue() {
            UStringsKt.checkNonnegative(3, "initialArraySize");
            return new ArrayList<>(3);
        }
    }

    /* loaded from: classes3.dex */
    public static class ExampleStackTrace extends IllegalStateException {
        static {
            ImmutableSet.construct(3, CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), LockGraphNode.class.getName());
        }
    }

    /* loaded from: classes3.dex */
    public static class LockGraphNode {
    }

    /* loaded from: classes3.dex */
    public static final class PotentialDeadlockException extends ExampleStackTrace {
        @Override // java.lang.Throwable
        public final String getMessage() {
            return new StringBuilder(super.getMessage()).toString();
        }
    }

    static {
        boolean z;
        MapMaker mapMaker = new MapMaker();
        MapMakerInternalMap.Strength strength = MapMakerInternalMap.Strength.WEAK;
        MapMakerInternalMap.Strength strength2 = mapMaker.keyStrength;
        if (strength2 == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            strength.getClass();
            mapMaker.keyStrength = strength;
            MapMakerInternalMap.Strength strength3 = MapMakerInternalMap.Strength.STRONG;
            if (strength != strength3) {
                mapMaker.useCustomMap = true;
            }
            if (!mapMaker.useCustomMap) {
                new ConcurrentHashMap(16, 0.75f, 4);
            } else {
                MapMakerInternalMap.AnonymousClass1 anonymousClass1 = MapMakerInternalMap.UNSET_WEAK_VALUE_REFERENCE;
                if (mapMaker.getKeyStrength() == strength3) {
                    if (strength3 != null) {
                        new MapMakerInternalMap(mapMaker, MapMakerInternalMap.StrongKeyStrongValueEntry.Helper.INSTANCE);
                    } else {
                        throw new NullPointerException("Both parameters are null");
                    }
                } else {
                    if (mapMaker.getKeyStrength() == strength3) {
                        if (strength3 != null) {
                            if (strength3 == strength) {
                                new MapMakerInternalMap(mapMaker, MapMakerInternalMap.StrongKeyWeakValueEntry.Helper.INSTANCE);
                            }
                        } else {
                            throw new NullPointerException("Both parameters are null");
                        }
                    }
                    if (mapMaker.getKeyStrength() == strength) {
                        if (strength3 != null) {
                            new MapMakerInternalMap(mapMaker, MapMakerInternalMap.WeakKeyStrongValueEntry.Helper.INSTANCE);
                        } else {
                            throw new NullPointerException("Both parameters are null");
                        }
                    } else {
                        if (mapMaker.getKeyStrength() == strength) {
                            if (strength3 != null) {
                                if (strength3 == strength) {
                                    new MapMakerInternalMap(mapMaker, MapMakerInternalMap.WeakKeyWeakValueEntry.Helper.INSTANCE);
                                }
                            } else {
                                throw new NullPointerException("Both parameters are null");
                            }
                        }
                        throw new AssertionError();
                    }
                }
            }
            Logger.getLogger(CycleDetectingLockFactory.class.getName());
            new AnonymousClass1();
            return;
        }
        throw new IllegalStateException(Strings.lenientFormat("Key strength was already set to %s", strength2));
    }
}
