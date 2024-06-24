package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class JsonPrimitive extends JsonElement {
    public final Serializable value;

    public JsonPrimitive(Boolean bool) {
        Objects.requireNonNull(bool);
        this.value = bool;
    }

    public static boolean isIntegral(JsonPrimitive jsonPrimitive) {
        Serializable serializable = jsonPrimitive.value;
        if (serializable instanceof Number) {
            Number number = (Number) serializable;
            if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        Serializable serializable = this.value;
        Serializable serializable2 = jsonPrimitive.value;
        if (serializable == null) {
            if (serializable2 == null) {
                return true;
            }
            return false;
        }
        if (isIntegral(this) && isIntegral(jsonPrimitive)) {
            if (getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue()) {
                return true;
            }
            return false;
        }
        if ((serializable instanceof Number) && (serializable2 instanceof Number)) {
            double doubleValue = getAsNumber().doubleValue();
            double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            if (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2)) {
                return true;
            }
            return false;
        }
        return serializable.equals(serializable2);
    }

    public final boolean getAsBoolean() {
        Serializable serializable = this.value;
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    public final Number getAsNumber() {
        Serializable serializable = this.value;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new LazilyParsedNumber((String) serializable);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    @Override // com.google.gson.JsonElement
    public final String getAsString() {
        Serializable serializable = this.value;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return getAsNumber().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final int hashCode() {
        long doubleToLongBits;
        Serializable serializable = this.value;
        if (serializable == null) {
            return 31;
        }
        if (isIntegral(this)) {
            doubleToLongBits = getAsNumber().longValue();
        } else if (serializable instanceof Number) {
            doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        } else {
            return serializable.hashCode();
        }
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public JsonPrimitive(Number number) {
        Objects.requireNonNull(number);
        this.value = number;
    }

    public JsonPrimitive(String str) {
        Objects.requireNonNull(str);
        this.value = str;
    }
}
