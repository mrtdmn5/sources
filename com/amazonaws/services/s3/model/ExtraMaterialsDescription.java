package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ExtraMaterialsDescription implements Serializable {
    public static final ExtraMaterialsDescription NONE = new ExtraMaterialsDescription(Collections.EMPTY_MAP);
    private final Map<String, String> extra;
    private final ConflictResolution resolve;

    /* renamed from: com.amazonaws.services.s3.model.ExtraMaterialsDescription$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution;

        static {
            int[] r0 = new int[ConflictResolution.values().length];
            $SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution = r0;
            try {
                r0[ConflictResolution.FAIL_FAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution[ConflictResolution.OVERRIDDEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution[ConflictResolution.OVERRIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum ConflictResolution {
        FAIL_FAST,
        OVERRIDE,
        OVERRIDDEN
    }

    public ExtraMaterialsDescription(Map<String, String> map) {
        this(map, ConflictResolution.FAIL_FAST);
    }

    public ConflictResolution getConflictResolution() {
        return this.resolve;
    }

    public Map<String, String> getMaterialDescription() {
        return this.extra;
    }

    public Map<String, String> mergeInto(Map<String, String> map) {
        if (this.extra.size() == 0) {
            return map;
        }
        if (map != null && map.size() != 0) {
            int r0 = AnonymousClass1.$SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution[this.resolve.ordinal()];
            if (r0 != 1) {
                if (r0 != 2) {
                    if (r0 == 3) {
                        HashMap hashMap = new HashMap(map);
                        hashMap.putAll(this.extra);
                        return Collections.unmodifiableMap(hashMap);
                    }
                    throw new UnsupportedOperationException();
                }
                HashMap hashMap2 = new HashMap(this.extra);
                hashMap2.putAll(map);
                return Collections.unmodifiableMap(hashMap2);
            }
            int size = this.extra.size() + map.size();
            HashMap hashMap3 = new HashMap(map);
            hashMap3.putAll(this.extra);
            if (size == hashMap3.size()) {
                return Collections.unmodifiableMap(hashMap3);
            }
            throw new IllegalArgumentException("The supplemental material descriptions contains conflicting entries");
        }
        return this.extra;
    }

    public ExtraMaterialsDescription(Map<String, String> map, ConflictResolution conflictResolution) {
        if (map != null && conflictResolution != null) {
            this.extra = Collections.unmodifiableMap(new HashMap(map));
            this.resolve = conflictResolution;
            return;
        }
        throw new IllegalArgumentException();
    }
}
