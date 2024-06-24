package com.amplifyframework.geo.options;

/* loaded from: classes.dex */
public class GeoSearchByCoordinatesOptions {
    private final int maxResults;

    /* loaded from: classes.dex */
    public static class Builder {
        private static final int DEFAULT_MAX_RESULTS_LIMIT = 50;
        private int maxResults = 50;

        public GeoSearchByCoordinatesOptions build() {
            return new GeoSearchByCoordinatesOptions(this);
        }

        public Builder maxResults(int r1) {
            this.maxResults = r1;
            return this;
        }
    }

    public GeoSearchByCoordinatesOptions(Builder builder) {
        this.maxResults = builder.maxResults;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static GeoSearchByCoordinatesOptions defaults() {
        return builder().build();
    }

    public int getMaxResults() {
        return this.maxResults;
    }
}
