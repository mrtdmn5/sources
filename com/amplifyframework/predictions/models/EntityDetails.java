package com.amplifyframework.predictions.models;

import android.graphics.RectF;
import com.amplifyframework.util.Immutable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class EntityDetails {
    private final AgeRange ageRange;
    private final RectF box;
    private final List<Emotion> emotions;
    private final List<BinaryFeature> features;
    private final Gender gender;
    private final List<Landmark> landmarks;
    private final Polygon polygon;
    private final Pose pose;

    /* loaded from: classes.dex */
    public static final class Builder {
        private AgeRange ageRange;
        private RectF box;
        private List<Emotion> emotions;
        private List<BinaryFeature> features;
        private Gender gender;
        private List<Landmark> landmarks;
        private Polygon polygon;
        private Pose pose;

        public Builder ageRange(AgeRange ageRange) {
            this.ageRange = ageRange;
            return this;
        }

        public Builder box(RectF rectF) {
            this.box = rectF;
            return this;
        }

        public EntityDetails build() {
            return new EntityDetails(this);
        }

        public Builder emotions(List<Emotion> list) {
            Objects.requireNonNull(list);
            this.emotions = list;
            return this;
        }

        public Builder features(List<BinaryFeature> list) {
            Objects.requireNonNull(list);
            this.features = list;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public AgeRange getAgeRange() {
            return this.ageRange;
        }

        public RectF getBox() {
            return this.box;
        }

        public List<Emotion> getEmotions() {
            List<Emotion> list = this.emotions;
            Objects.requireNonNull(list);
            return list;
        }

        public Gender getGender() {
            return this.gender;
        }

        public List<Landmark> getLandmarks() {
            List<Landmark> list = this.landmarks;
            Objects.requireNonNull(list);
            return list;
        }

        public Polygon getPolygon() {
            return this.polygon;
        }

        public Pose getPose() {
            return this.pose;
        }

        public List<BinaryFeature> getValues() {
            List<BinaryFeature> list = this.features;
            Objects.requireNonNull(list);
            return list;
        }

        public Builder landmarks(List<Landmark> list) {
            Objects.requireNonNull(list);
            this.landmarks = list;
            return this;
        }

        public Builder polygon(Polygon polygon) {
            this.polygon = polygon;
            return this;
        }

        public Builder pose(Pose pose) {
            this.pose = pose;
            return this;
        }

        private Builder() {
            this.landmarks = Collections.emptyList();
            this.emotions = Collections.emptyList();
            this.features = Collections.emptyList();
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public AgeRange getAgeRange() {
        return this.ageRange;
    }

    public RectF getBox() {
        return this.box;
    }

    public List<Emotion> getEmotions() {
        return Immutable.of(this.emotions);
    }

    public Gender getGender() {
        return this.gender;
    }

    public List<Landmark> getLandmarks() {
        return Immutable.of(this.landmarks);
    }

    public Polygon getPolygon() {
        return this.polygon;
    }

    public Pose getPose() {
        return this.pose;
    }

    public List<BinaryFeature> getValues() {
        return Immutable.of(this.features);
    }

    private EntityDetails(Builder builder) {
        this.box = builder.getBox();
        this.polygon = builder.getPolygon();
        this.ageRange = builder.getAgeRange();
        this.pose = builder.getPose();
        this.gender = builder.getGender();
        this.landmarks = builder.getLandmarks();
        this.emotions = builder.getEmotions();
        this.features = builder.getValues();
    }
}
