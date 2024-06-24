package com.amplifyframework.auth.cognito.helpers;

import android.util.Base64;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amplifyframework.auth.exceptions.UnknownException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* compiled from: JWTParser.kt */
/* loaded from: classes.dex */
public final class JWTParser {
    private static final int HEADER = 0;
    public static final JWTParser INSTANCE = new JWTParser();
    private static final int JWT_PARTS = 3;
    private static final int PAYLOAD = 1;
    private static final int SIGNATURE = 2;

    private JWTParser() {
    }

    public final String getClaim(String jwt, String str) {
        boolean z;
        Object obj;
        Intrinsics.checkNotNullParameter(jwt, "jwt");
        if (jwt.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return jwt;
        }
        try {
            JSONObject payload = getPayload(jwt);
            if (str != null) {
                obj = payload.get(str);
            } else {
                obj = null;
            }
            return String.valueOf(obj);
        } catch (Exception e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "";
            }
            throw new UnknownException(localizedMessage.concat(", Invalid token"), null, 2, null);
        }
    }

    public final JSONObject getHeader(String jwt) {
        Intrinsics.checkNotNullParameter(jwt, "jwt");
        try {
            validateJWT(jwt);
            byte[] sectionDecoded = Base64.decode(((String[]) StringsKt__StringsKt.split$default(jwt, new String[]{InstructionFileId.DOT}, 0, 6).toArray(new String[0]))[0], 8);
            Intrinsics.checkNotNullExpressionValue(sectionDecoded, "sectionDecoded");
            return new JSONObject(new String(sectionDecoded, Charsets.UTF_8));
        } catch (Exception e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "";
            }
            throw new UnknownException(localizedMessage.concat(", error in parsing JSON"), null, 2, null);
        }
    }

    public final JSONObject getPayload(String jwt) {
        Intrinsics.checkNotNullParameter(jwt, "jwt");
        try {
            validateJWT(jwt);
            byte[] sectionDecoded = Base64.decode(((String[]) StringsKt__StringsKt.split$default(jwt, new String[]{InstructionFileId.DOT}, 0, 6).toArray(new String[0]))[1], 8);
            Intrinsics.checkNotNullExpressionValue(sectionDecoded, "sectionDecoded");
            return new JSONObject(new String(sectionDecoded, Charsets.UTF_8));
        } catch (Exception e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "";
            }
            throw new UnknownException(localizedMessage.concat(", error in parsing JSON"), null, 2, null);
        }
    }

    public final String getSignature(String jwt) {
        Intrinsics.checkNotNullParameter(jwt, "jwt");
        try {
            validateJWT(jwt);
            byte[] sectionDecoded = Base64.decode(((String[]) StringsKt__StringsKt.split$default(jwt, new String[]{InstructionFileId.DOT}, 0, 6).toArray(new String[0]))[2], 8);
            Intrinsics.checkNotNullExpressionValue(sectionDecoded, "sectionDecoded");
            return new String(sectionDecoded, Charsets.UTF_8);
        } catch (Exception e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "";
            }
            throw new UnknownException(localizedMessage.concat(", error in parsing JSON"), null, 2, null);
        }
    }

    public final boolean hasClaim(String jwt, String str) {
        Intrinsics.checkNotNullParameter(jwt, "jwt");
        try {
            return getPayload(jwt).has(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void validateJWT(String jwt) {
        Intrinsics.checkNotNullParameter(jwt, "jwt");
        if (((String[]) StringsKt__StringsKt.split$default(jwt, new String[]{InstructionFileId.DOT}, 0, 6).toArray(new String[0])).length == 3) {
        } else {
            throw new UnknownException("Not a JSON web token. Error in parsing JSON", null, 2, null);
        }
    }
}
