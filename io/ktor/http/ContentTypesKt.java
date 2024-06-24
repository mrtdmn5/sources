package io.ktor.http;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.Locale;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.AbstractJsonLexer;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.JsonEncodingException;

/* compiled from: ContentTypes.kt */
/* loaded from: classes3.dex */
public final class ContentTypesKt {
    public static final JsonDecodingException InvalidFloatingPointDecoded(Number value, String key, String output) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(output, "output");
        return JsonDecodingException(-1, "Unexpected special floating-point value " + value + " with key " + key + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) minify(-1, output)));
    }

    public static final JsonEncodingException InvalidFloatingPointEncoded(Number value, String output) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(output, "output");
        return new JsonEncodingException("Unexpected special floating-point value " + value + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) minify(-1, output)));
    }

    public static final JsonEncodingException InvalidKeyKindException(SerialDescriptor serialDescriptor) {
        return new JsonEncodingException("Value of type '" + serialDescriptor.getSerialName() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + serialDescriptor.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final JsonDecodingException JsonDecodingException(int r3, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (r3 >= 0) {
            message = "Unexpected JSON token at offset " + r3 + ": " + message;
        }
        return new JsonDecodingException(message);
    }

    public static final Charset charset(HeaderValueWithParameters headerValueWithParameters) {
        Intrinsics.checkNotNullParameter(headerValueWithParameters, "<this>");
        String parameter = headerValueWithParameters.parameter("charset");
        if (parameter == null) {
            return null;
        }
        try {
            return Charset.forName(parameter);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static final ArrayIterator iterator(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayIterator(array);
    }

    public static final CharSequence minify(int r5, CharSequence charSequence) {
        String str;
        if (charSequence.length() < 200) {
            return charSequence;
        }
        String str2 = ".....";
        if (r5 == -1) {
            int length = charSequence.length() - 60;
            if (length <= 0) {
                return charSequence;
            }
            return "....." + charSequence.subSequence(length, charSequence.length()).toString();
        }
        int r0 = r5 - 30;
        int r52 = r5 + 30;
        if (r0 > 0) {
            str = ".....";
        } else {
            str = "";
        }
        if (r52 >= charSequence.length()) {
            str2 = "";
        }
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
        if (r0 < 0) {
            r0 = 0;
        }
        int length2 = charSequence.length();
        if (r52 > length2) {
            r52 = length2;
        }
        m.append(charSequence.subSequence(r0, r52).toString());
        m.append(str2);
        return m.toString();
    }

    public static final void throwInvalidFloatingPointDecoded(AbstractJsonLexer abstractJsonLexer, Number result) {
        Intrinsics.checkNotNullParameter(abstractJsonLexer, "<this>");
        Intrinsics.checkNotNullParameter(result, "result");
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected special floating-point value " + result + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
        throw null;
    }

    public static final ContentType withCharsetIfNeeded(ContentType contentType, Charset charset) {
        Intrinsics.checkNotNullParameter(contentType, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String lowerCase = contentType.contentType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (Intrinsics.areEqual(lowerCase, "text")) {
            return contentType.withParameter("charset", CharsetJVMKt.getName(charset));
        }
        return contentType;
    }

    public static final JsonDecodingException JsonDecodingException(int r1, String message, CharSequence input) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(input, "input");
        return JsonDecodingException(r1, message + "\nJSON input: " + ((Object) minify(r1, input)));
    }
}
