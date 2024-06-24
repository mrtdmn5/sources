package com.amplifyframework.core.category;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.InitializationResult;
import com.amplifyframework.core.InitializationStatus;
import com.amplifyframework.core.plugin.Plugin;
import com.amplifyframework.hub.HubChannel;
import com.amplifyframework.hub.HubEvent;
import com.amplifyframework.util.Immutable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class Category<P extends Plugin<?>> implements CategoryTypeable {
    private final Map<String, P> plugins = new ConcurrentHashMap();
    private final AtomicReference<State> state = new AtomicReference<>(State.NOT_CONFIGURED);
    private final AtomicReference<CategoryInitializationResult> categoryInitializationResult = new AtomicReference<>(null);

    /* loaded from: classes.dex */
    public enum State {
        NOT_CONFIGURED,
        CONFIGURING,
        CONFIGURED,
        INITIALIZING,
        INITIALIZED,
        CONFIGURATION_FAILED,
        INITIALIZATION_FAILED
    }

    private P getPluginIfConfiguredOrThrow(P p) throws IllegalStateException {
        Throwable th;
        if (p != null) {
            if (!State.CONFIGURATION_FAILED.equals(this.state.get())) {
                if (State.INITIALIZATION_FAILED.equals(this.state.get())) {
                    CategoryInitializationResult categoryInitializationResult = this.categoryInitializationResult.get();
                    if (categoryInitializationResult != null) {
                        th = categoryInitializationResult.getPluginInitializationFailures().get(p.getPluginKey());
                    } else {
                        th = null;
                    }
                    throw new IllegalStateException("Failed to get plugin because initialization previously failed.  See attached exception for details.", th);
                }
                if (isConfigured()) {
                    return p;
                }
                throw new IllegalStateException("Tried to get a plugin before it was configured.  Make sure you call Amplify.configure() first.");
            }
            throw new IllegalStateException("Failed to get plugin because configuration previously failed.  Check for failures by logging any exceptions thrown by Amplify.configure().");
        }
        throw new IllegalStateException("Tried to get a plugin but that plugin was not present. Check if the plugin was added originally or perhaps was already removed.");
    }

    public final void addPlugin(P p) throws AmplifyException {
        if (State.NOT_CONFIGURED.equals(this.state.get())) {
            this.plugins.put(p.getPluginKey(), p);
        } else {
            throw new AmplifyException("Category " + getCategoryType() + " has already been configured or is configuring.", "Make sure that you have added all plugins before attempting configuration.");
        }
    }

    public synchronized void configure(CategoryConfiguration categoryConfiguration, Context context) throws AmplifyException {
        synchronized (this.state) {
            if (State.NOT_CONFIGURED.equals(this.state.get())) {
                this.state.set(State.CONFIGURING);
                try {
                    for (P p : getPlugins()) {
                        JSONObject pluginConfig = categoryConfiguration.getPluginConfig(p.getPluginKey());
                        if (pluginConfig == null) {
                            pluginConfig = new JSONObject();
                        }
                        p.configure(pluginConfig, context);
                    }
                    this.state.set(State.CONFIGURED);
                } catch (Throwable th) {
                    this.state.set(State.CONFIGURATION_FAILED);
                    throw th;
                }
            } else {
                throw new AmplifyException("Category " + getCategoryType() + " has already been configured or is currently configuring.", "Ensure that you are only attempting configuration once.");
            }
        }
    }

    public final P getPlugin(String str) throws IllegalStateException {
        return getPluginIfConfiguredOrThrow(this.plugins.get(str));
    }

    public final Set<P> getPlugins() {
        return Immutable.of(new HashSet(this.plugins.values()));
    }

    public P getSelectedPlugin() throws IllegalStateException {
        P p;
        if (this.plugins.size() <= 1) {
            Iterator<P> it = getPlugins().iterator();
            if (it.hasNext()) {
                p = it.next();
            } else {
                p = null;
            }
            return getPluginIfConfiguredOrThrow(p);
        }
        throw new IllegalStateException("Tried to get a default plugin but there are more than one to choose from in this category. Call getPlugin(pluginKey) to choose the specific plugin you want to use in this case.");
    }

    public synchronized CategoryInitializationResult initialize(Context context) {
        InitializationResult failure;
        CategoryInitializationResult with;
        InitializationStatus initializationStatus;
        HashMap hashMap = new HashMap();
        if (!State.CONFIGURED.equals(this.state.get())) {
            for (P p : getPlugins()) {
                hashMap.put(p.getPluginKey(), InitializationResult.failure(new AmplifyException("Tried to init before category was not configured.", "Call configure() on category, first.")));
            }
        } else {
            this.state.set(State.CONFIGURING);
            for (P p2 : getPlugins()) {
                try {
                    p2.initialize(context);
                    failure = InitializationResult.success();
                } catch (AmplifyException e) {
                    failure = InitializationResult.failure(e);
                }
                hashMap.put(p2.getPluginKey(), failure);
            }
        }
        with = CategoryInitializationResult.with(hashMap);
        this.categoryInitializationResult.set(with);
        if (with.isFailure()) {
            this.state.set(State.INITIALIZATION_FAILED);
        } else {
            this.state.set(State.INITIALIZED);
        }
        HubChannel forCategoryType = HubChannel.forCategoryType(getCategoryType());
        if (with.isFailure()) {
            initializationStatus = InitializationStatus.FAILED;
        } else {
            initializationStatus = InitializationStatus.SUCCEEDED;
        }
        Amplify.Hub.publish(forCategoryType, HubEvent.create(initializationStatus, with));
        return with;
    }

    public synchronized boolean isConfigured() {
        return Arrays.asList(State.CONFIGURED, State.INITIALIZING, State.INITIALIZED).contains(this.state.get());
    }

    public synchronized boolean isInitialized() {
        return State.INITIALIZED.equals(this.state.get());
    }

    public final void removePlugin(P p) {
        this.plugins.remove(p.getPluginKey());
    }
}
