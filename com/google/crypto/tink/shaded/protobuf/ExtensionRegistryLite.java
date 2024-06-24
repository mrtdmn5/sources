package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ExtensionRegistryLite {
    public static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(0);
    public static volatile ExtensionRegistryLite emptyRegistry;
    public final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    /* loaded from: classes3.dex */
    public static final class ObjectIntPair {
        public final int number;
        public final Object object;

        public ObjectIntPair(int r1, Object obj) {
            this.object = obj;
            this.number = r1;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            if (this.object != objectIntPair.object || this.number != objectIntPair.number) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    public ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        ExtensionRegistryLite extensionRegistryLite = emptyRegistry;
        if (extensionRegistryLite == null) {
            synchronized (ExtensionRegistryLite.class) {
                extensionRegistryLite = emptyRegistry;
                if (extensionRegistryLite == null) {
                    Class<?> cls = ExtensionRegistryFactory.EXTENSION_REGISTRY_CLASS;
                    ExtensionRegistryLite extensionRegistryLite2 = null;
                    if (cls != null) {
                        try {
                            extensionRegistryLite2 = (ExtensionRegistryLite) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                    }
                    if (extensionRegistryLite2 == null) {
                        extensionRegistryLite2 = EMPTY_REGISTRY_LITE;
                    }
                    emptyRegistry = extensionRegistryLite2;
                    extensionRegistryLite = extensionRegistryLite2;
                }
            }
        }
        return extensionRegistryLite;
    }

    public ExtensionRegistryLite(int r1) {
        this.extensionsByNumber = Collections.emptyMap();
    }
}
