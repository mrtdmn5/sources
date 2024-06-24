package com.amplifyframework.predictions.models;

/* loaded from: classes.dex */
public enum FeatureType {
    BOUNDED_KEY_VALUE("BoundedKeyValue"),
    CELEBRITY("Celebrity"),
    CELL("Cell"),
    EMOTION("EmotionType"),
    ENTITY("EntityType"),
    ENTITY_MATCH("EntityMatch"),
    GENDER("GenderBinaryType"),
    IDENTIFIED_TEXT("IdentifiedText"),
    KEY_PHRASE("KeyPhrase"),
    LANGUAGE("LanguageType"),
    SENTIMENT("SentimentType"),
    SYNTAX("SpeechType"),
    TABLE("Table");

    private final String typeAlias;

    FeatureType(String str) {
        this.typeAlias = str;
    }

    public static FeatureType fromAlias(String str) {
        try {
            return valueOf(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String getAlias() {
        return this.typeAlias;
    }
}
