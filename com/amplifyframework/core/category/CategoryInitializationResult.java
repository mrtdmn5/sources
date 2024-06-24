package com.amplifyframework.core.category;

import com.amplifyframework.core.InitializationResult;
import com.amplifyframework.core.InitializationStatus;
import com.amplifyframework.util.Immutable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class CategoryInitializationResult {
    private final InitializationStatus initializationStatus;
    private final Map<String, InitializationResult> pluginInitializationResults;

    /* loaded from: classes.dex */
    public interface PluginCriteria<T> {
        boolean appliesTo(T t);
    }

    private CategoryInitializationResult(InitializationStatus initializationStatus, Map<String, InitializationResult> map) {
        this.initializationStatus = initializationStatus;
        this.pluginInitializationResults = map;
    }

    private static boolean anyFailed(Map<String, InitializationResult> map) {
        Iterator<InitializationResult> it = map.values().iterator();
        while (it.hasNext()) {
            if (it.next().isFailure()) {
                return true;
            }
        }
        return false;
    }

    public static CategoryInitializationResult failure() {
        return new CategoryInitializationResult(InitializationStatus.FAILED, Collections.emptyMap());
    }

    private Set<String> filterPluginResults(PluginCriteria<Map.Entry<String, InitializationResult>> pluginCriteria) {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, InitializationResult> entry : this.pluginInitializationResults.entrySet()) {
            if (pluginCriteria.appliesTo(entry)) {
                hashSet.add(entry.getKey());
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getFailedPlugins$0(Map.Entry entry) {
        return ((InitializationResult) entry.getValue()).isFailure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getSuccessfulPlugins$1(Map.Entry entry) {
        return ((InitializationResult) entry.getValue()).isSuccess();
    }

    public static CategoryInitializationResult with(Map<String, InitializationResult> map) {
        InitializationStatus initializationStatus;
        Objects.requireNonNull(map);
        if (anyFailed(map)) {
            initializationStatus = InitializationStatus.FAILED;
        } else {
            initializationStatus = InitializationStatus.SUCCEEDED;
        }
        return new CategoryInitializationResult(initializationStatus, map);
    }

    public Set<String> getFailedPlugins() {
        return filterPluginResults(new CategoryInitializationResult$$ExternalSyntheticLambda0());
    }

    public InitializationStatus getInitializationStatus() {
        return this.initializationStatus;
    }

    public Map<String, Throwable> getPluginInitializationFailures() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, InitializationResult> entry : this.pluginInitializationResults.entrySet()) {
            Throwable failure = entry.getValue().getFailure();
            String key = entry.getKey();
            if (failure != null) {
                hashMap.put(key, failure);
            }
        }
        return Immutable.of(hashMap);
    }

    public Set<String> getSuccessfulPlugins() {
        return filterPluginResults(new CategoryInitializationResult$$ExternalSyntheticLambda1());
    }

    public boolean isFailure() {
        return InitializationStatus.FAILED.equals(this.initializationStatus);
    }

    public boolean isSuccess() {
        return InitializationStatus.SUCCEEDED.equals(this.initializationStatus);
    }
}
