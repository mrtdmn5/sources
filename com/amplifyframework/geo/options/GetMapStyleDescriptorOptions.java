package com.amplifyframework.geo.options;

import java.util.Objects;

/* loaded from: classes.dex */
public final class GetMapStyleDescriptorOptions {
    private final String mapName;

    /* loaded from: classes.dex */
    public static final class Builder {
        private String mapName;

        public GetMapStyleDescriptorOptions build() {
            return new GetMapStyleDescriptorOptions(this);
        }

        public Builder mapName(String str) {
            Objects.requireNonNull(str);
            this.mapName = str;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static GetMapStyleDescriptorOptions defaults() {
        return builder().build();
    }

    public String getMapName() {
        return this.mapName;
    }

    private GetMapStyleDescriptorOptions(Builder builder) {
        this.mapName = builder.mapName;
    }
}
