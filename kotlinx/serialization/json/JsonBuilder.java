package kotlinx.serialization.json;

import com.google.common.hash.AbstractHasher;

/* compiled from: Json.kt */
/* loaded from: classes4.dex */
public final class JsonBuilder {
    public boolean allowSpecialFloatingPointValues;
    public boolean allowStructuredMapKeys;
    public final String classDiscriminator;
    public final boolean coerceInputValues;
    public boolean encodeDefaults;
    public final boolean explicitNulls;
    public boolean ignoreUnknownKeys;
    public boolean isLenient;
    public boolean prettyPrint;
    public final String prettyPrintIndent;
    public final AbstractHasher serializersModule;
    public final boolean useAlternativeNames;
    public boolean useArrayPolymorphism;

    public JsonBuilder(Json json) {
        JsonConfiguration jsonConfiguration = json.configuration;
        this.encodeDefaults = jsonConfiguration.encodeDefaults;
        this.explicitNulls = jsonConfiguration.explicitNulls;
        this.ignoreUnknownKeys = jsonConfiguration.ignoreUnknownKeys;
        this.isLenient = jsonConfiguration.isLenient;
        this.allowStructuredMapKeys = jsonConfiguration.allowStructuredMapKeys;
        this.prettyPrint = jsonConfiguration.prettyPrint;
        this.prettyPrintIndent = jsonConfiguration.prettyPrintIndent;
        this.coerceInputValues = jsonConfiguration.coerceInputValues;
        this.useArrayPolymorphism = jsonConfiguration.useArrayPolymorphism;
        this.classDiscriminator = jsonConfiguration.classDiscriminator;
        this.allowSpecialFloatingPointValues = jsonConfiguration.allowSpecialFloatingPointValues;
        this.useAlternativeNames = jsonConfiguration.useAlternativeNames;
        this.serializersModule = json.serializersModule;
    }
}
