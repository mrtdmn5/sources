package com.amplifyframework.auth.cognito.helpers;

import android.util.Base64;
import j$.util.DesugarTimeZone;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: SRPHelper.kt */
/* loaded from: classes.dex */
public final class SRPHelper {
    public static final Companion Companion = new Companion(null);
    private static final int EPHEMERAL_KEY_LENGTH = 1024;
    private static final String HMAC_SHA_256 = "HmacSHA256";
    private final String DERIVED_KEY_INFO;
    private final int DERIVED_KEY_SIZE;
    private final String HEX_N;
    private final BigInteger N;
    private String dateString;
    private final MessageDigest digest;
    private final BigInteger g;
    private final BigInteger k;
    private final String password;
    private BigInteger privateA;
    private BigInteger publicA;
    private final SecureRandom random;
    private String userId;
    private String userPoolName;

    /* compiled from: SRPHelper.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SRPHelper(String password) {
        BigInteger modPow;
        Intrinsics.checkNotNullParameter(password, "password");
        this.password = password;
        this.g = BigInteger.valueOf(2L);
        this.HEX_N = "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AAAC42DAD33170D04507A33A85521ABDF1CBA64ECFB850458DBEF0A8AEA71575D060C7DB3970F85A6E1E4C7ABF5AE8CDB0933D71E8C94E04A25619DCEE3D2261AD2EE6BF12FFA06D98A0864D87602733EC86A64521F2B18177B200CBBE117577A615D6C770988C0BAD946E208E24FA074E5AB3143DB5BFCE0FD108E4B82D120A93AD2CAFFFFFFFFFFFFFFFF";
        this.N = new BigInteger("FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AAAC42DAD33170D04507A33A85521ABDF1CBA64ECFB850458DBEF0A8AEA71575D060C7DB3970F85A6E1E4C7ABF5AE8CDB0933D71E8C94E04A25619DCEE3D2261AD2EE6BF12FFA06D98A0864D87602733EC86A64521F2B18177B200CBBE117577A615D6C770988C0BAD946E208E24FA074E5AB3143DB5BFCE0FD108E4B82D120A93AD2CAFFFFFFFFFFFFFFFF", 16);
        this.random = new SecureRandom();
        this.DERIVED_KEY_INFO = "Caldera Derived Key";
        this.DERIVED_KEY_SIZE = 16;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(\"SHA-256\")");
        this.digest = messageDigest;
        do {
            BigInteger mod = new BigInteger(EPHEMERAL_KEY_LENGTH, this.random).mod(this.N);
            Intrinsics.checkNotNullExpressionValue(mod, "BigInteger(EPHEMERAL_KEY_LENGTH, random).mod(N)");
            this.privateA = mod;
            modPow = this.g.modPow(mod, this.N);
            Intrinsics.checkNotNullExpressionValue(modPow, "g.modPow(privateA, N)");
            this.publicA = modPow;
        } while (Intrinsics.areEqual(modPow.mod(this.N), BigInteger.ZERO));
        this.digest.reset();
        this.digest.update(this.N.toByteArray());
        this.k = new BigInteger(1, this.digest.digest(this.g.toByteArray()));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "simpleDateFormat.format(Date())");
        this.dateString = format;
        this.userId = "";
        this.userPoolName = "";
    }

    public final byte[] computePasswordAuthenticationKey$aws_auth_cognito_release(BigInteger ikm, BigInteger salt) {
        Intrinsics.checkNotNullParameter(ikm, "ikm");
        Intrinsics.checkNotNullParameter(salt, "salt");
        String str = HMAC_SHA_256;
        Mac mac = Mac.getInstance(str);
        mac.init(new SecretKeySpec(salt.toByteArray(), str));
        byte[] doFinal = mac.doFinal(ikm.toByteArray());
        mac.reset();
        mac.init(new SecretKeySpec(doFinal, str));
        String str2 = this.DERIVED_KEY_INFO;
        Charset charset = Charsets.UTF_8;
        byte[] bytes = str2.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        mac.update(bytes);
        byte[] bytes2 = String.valueOf((char) 1).getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        byte[] hkdf = mac.doFinal(bytes2);
        Intrinsics.checkNotNullExpressionValue(hkdf, "hkdf");
        byte[] copyOf = Arrays.copyOf(hkdf, this.DERIVED_KEY_SIZE);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    public final BigInteger computePasswordVerifier$aws_auth_cognito_release(BigInteger salt) {
        Intrinsics.checkNotNullParameter(salt, "salt");
        BigInteger modPow = this.g.modPow(computeX$aws_auth_cognito_release(salt), this.N);
        Intrinsics.checkNotNullExpressionValue(modPow, "g.modPow(xValue, N)");
        return modPow;
    }

    public final BigInteger computeS$aws_auth_cognito_release(BigInteger uValue, BigInteger xValue, BigInteger srpB) {
        Intrinsics.checkNotNullParameter(uValue, "uValue");
        Intrinsics.checkNotNullParameter(xValue, "xValue");
        Intrinsics.checkNotNullParameter(srpB, "srpB");
        BigInteger mod = srpB.subtract(this.k.multiply(this.g.modPow(xValue, this.N))).modPow(this.privateA.add(uValue.multiply(xValue)), this.N).mod(this.N);
        Intrinsics.checkNotNullExpressionValue(mod, "srpB.subtract(k.multiply…iply(xValue)), N)).mod(N)");
        return mod;
    }

    public final BigInteger computeU$aws_auth_cognito_release(BigInteger srpB) {
        Intrinsics.checkNotNullParameter(srpB, "srpB");
        this.digest.reset();
        this.digest.update(this.publicA.toByteArray());
        return new BigInteger(1, this.digest.digest(srpB.toByteArray()));
    }

    public final BigInteger computeX$aws_auth_cognito_release(BigInteger salt) {
        Intrinsics.checkNotNullParameter(salt, "salt");
        this.digest.reset();
        MessageDigest messageDigest = this.digest;
        String str = this.userPoolName;
        Charset charset = Charsets.UTF_8;
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        MessageDigest messageDigest2 = this.digest;
        byte[] bytes2 = this.userId.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        messageDigest2.update(bytes2);
        MessageDigest messageDigest3 = this.digest;
        byte[] bytes3 = ":".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
        messageDigest3.update(bytes3);
        MessageDigest messageDigest4 = this.digest;
        byte[] bytes4 = this.password.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes4, "this as java.lang.String).getBytes(charset)");
        byte[] digest = messageDigest4.digest(bytes4);
        this.digest.reset();
        this.digest.update(salt.toByteArray());
        return new BigInteger(1, this.digest.digest(digest));
    }

    public final byte[] generateM1Signature$aws_auth_cognito_release(byte[] key, String secretBlock) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(secretBlock, "secretBlock");
        String str = HMAC_SHA_256;
        Mac mac = Mac.getInstance(str);
        mac.init(new SecretKeySpec(key, str));
        String str2 = this.userPoolName;
        Charset charset = Charsets.UTF_8;
        byte[] bytes = str2.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        mac.update(bytes);
        byte[] bytes2 = this.userId.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        mac.update(bytes2);
        mac.update(Base64.decode(secretBlock, 2));
        byte[] bytes3 = this.dateString.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
        byte[] doFinal = mac.doFinal(bytes3);
        Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal(dateString.toByteArray())");
        return doFinal;
    }

    public final String getDateString() {
        return this.dateString;
    }

    public final String getPublicA() {
        String bigInteger = this.publicA.toString(16);
        Intrinsics.checkNotNullExpressionValue(bigInteger, "publicA.toString(16)");
        return bigInteger;
    }

    public final String getSignature(String salt, String srpB, String secretBlock) {
        Intrinsics.checkNotNullParameter(salt, "salt");
        Intrinsics.checkNotNullParameter(srpB, "srpB");
        Intrinsics.checkNotNullParameter(secretBlock, "secretBlock");
        BigInteger bigInteger = new BigInteger(srpB, 16);
        BigInteger bigInteger2 = new BigInteger(salt, 16);
        BigInteger mod = bigInteger.mod(this.N);
        BigInteger bigInteger3 = BigInteger.ZERO;
        if (!Intrinsics.areEqual(mod, bigInteger3)) {
            BigInteger computeU$aws_auth_cognito_release = computeU$aws_auth_cognito_release(bigInteger);
            if (!Intrinsics.areEqual(computeU$aws_auth_cognito_release.mod(this.N), bigInteger3)) {
                String encodeToString = Base64.encodeToString(generateM1Signature$aws_auth_cognito_release(computePasswordAuthenticationKey$aws_auth_cognito_release(computeS$aws_auth_cognito_release(computeU$aws_auth_cognito_release, computeX$aws_auth_cognito_release(bigInteger2), bigInteger), computeU$aws_auth_cognito_release), secretBlock), 2);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(m1Signatu…roid.util.Base64.NO_WRAP)");
                return encodeToString;
            }
            throw new Exception("Hash of A and B cannot be zero");
        }
        throw new Exception("Bad server public value 'B'");
    }

    public final BigInteger modN(BigInteger value) {
        Intrinsics.checkNotNullParameter(value, "value");
        BigInteger mod = value.mod(this.N);
        Intrinsics.checkNotNullExpressionValue(mod, "value.mod(N)");
        return mod;
    }

    public final void setAValues(BigInteger privateA, BigInteger publicA) {
        Intrinsics.checkNotNullParameter(privateA, "privateA");
        Intrinsics.checkNotNullParameter(publicA, "publicA");
        this.privateA = privateA;
        this.publicA = publicA;
    }

    public final void setDateString(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dateString = str;
    }

    public final void setUserPoolParams(String userId, String userPoolName) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userPoolName, "userPoolName");
        this.userId = userId;
        this.userPoolName = userPoolName;
        if (StringsKt__StringsKt.contains(userPoolName, "_", false)) {
            this.userPoolName = (String) new Regex("_").split(2, userPoolName).get(1);
        }
    }
}
