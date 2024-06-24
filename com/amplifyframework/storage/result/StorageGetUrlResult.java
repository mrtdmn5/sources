package com.amplifyframework.storage.result;

import java.net.URL;
import java.util.Objects;

/* loaded from: classes.dex */
public final class StorageGetUrlResult {
    private final URL url;

    private StorageGetUrlResult(URL url) {
        this.url = url;
    }

    public static StorageGetUrlResult fromUrl(URL url) {
        Objects.requireNonNull(url);
        return new StorageGetUrlResult(url);
    }

    public URL getUrl() {
        return this.url;
    }
}
