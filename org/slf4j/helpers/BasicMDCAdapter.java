package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.spi.MDCAdapter;

/* loaded from: classes4.dex */
public final class BasicMDCAdapter implements MDCAdapter {
    public final AnonymousClass1 inheritableThreadLocalMap;

    /* renamed from: org.slf4j.helpers.BasicMDCAdapter$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 extends InheritableThreadLocal<Map<String, String>> {
        @Override // java.lang.InheritableThreadLocal
        public final Map<String, String> childValue(Map<String, String> map) {
            Map<String, String> map2 = map;
            if (map2 == null) {
                return null;
            }
            return new HashMap(map2);
        }
    }

    public BasicMDCAdapter() {
        new ThreadLocal();
        this.inheritableThreadLocalMap = new AnonymousClass1();
    }

    @Override // org.slf4j.spi.MDCAdapter
    public final void clear() {
        AnonymousClass1 anonymousClass1 = this.inheritableThreadLocalMap;
        Map<String, String> map = anonymousClass1.get();
        if (map != null) {
            map.clear();
            anonymousClass1.remove();
        }
    }

    @Override // org.slf4j.spi.MDCAdapter
    public final Map<String, String> getCopyOfContextMap() {
        Map<String, String> map = this.inheritableThreadLocalMap.get();
        if (map != null) {
            return new HashMap(map);
        }
        return null;
    }

    @Override // org.slf4j.spi.MDCAdapter
    public final void setContextMap(Map<String, String> map) {
        HashMap hashMap;
        if (map != null) {
            hashMap = new HashMap(map);
        } else {
            hashMap = null;
        }
        this.inheritableThreadLocalMap.set(hashMap);
    }
}
