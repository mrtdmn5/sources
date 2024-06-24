package com.amazonaws.util;

import com.amazonaws.ResponseMetadata;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ResponseMetadataCache {
    private final InternalCache internalCache;

    /* loaded from: classes.dex */
    public static final class InternalCache extends LinkedHashMap<Integer, ResponseMetadata> {
        private int maxSize;

        public InternalCache(int r1) {
            super(r1);
            this.maxSize = r1;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<Integer, ResponseMetadata> entry) {
            if (size() > this.maxSize) {
                return true;
            }
            return false;
        }
    }

    public ResponseMetadataCache(int r2) {
        this.internalCache = new InternalCache(r2);
    }

    public synchronized void add(Object obj, ResponseMetadata responseMetadata) {
        if (obj == null) {
            return;
        }
        this.internalCache.put(Integer.valueOf(System.identityHashCode(obj)), responseMetadata);
    }

    public ResponseMetadata get(Object obj) {
        return this.internalCache.get(Integer.valueOf(System.identityHashCode(obj)));
    }
}
