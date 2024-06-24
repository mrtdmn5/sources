package androidx.security.crypto;

import android.content.SharedPreferences;
import android.util.ArraySet;
import android.util.Pair;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.aead.AesGcmKeyManager;
import com.google.crypto.tink.daead.AesSivKeyManager;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.subtle.Base64;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class EncryptedSharedPreferences implements SharedPreferences {
    public final String mFileName;
    public final DeterministicAead mKeyDeterministicAead;
    public final ArrayList mListeners = new ArrayList();
    public final SharedPreferences mSharedPreferences;
    public final Aead mValueAead;

    /* renamed from: androidx.security.crypto.EncryptedSharedPreferences$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType;

        static {
            int[] r0 = new int[EncryptedType.values().length];
            $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType = r0;
            try {
                r0[EncryptedType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType[EncryptedType.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType[EncryptedType.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType[EncryptedType.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType[EncryptedType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType[EncryptedType.STRING_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Editor implements SharedPreferences.Editor {
        public final SharedPreferences.Editor mEditor;
        public final EncryptedSharedPreferences mEncryptedSharedPreferences;
        public final AtomicBoolean mClearRequested = new AtomicBoolean(false);
        public final CopyOnWriteArrayList mKeysChanged = new CopyOnWriteArrayList();

        public Editor(EncryptedSharedPreferences encryptedSharedPreferences, SharedPreferences.Editor editor) {
            this.mEncryptedSharedPreferences = encryptedSharedPreferences;
            this.mEditor = editor;
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            clearKeysIfNeeded();
            this.mEditor.apply();
            notifyListeners();
            this.mKeysChanged.clear();
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.mClearRequested.set(true);
            return this;
        }

        public final void clearKeysIfNeeded() {
            if (this.mClearRequested.getAndSet(false)) {
                EncryptedSharedPreferences encryptedSharedPreferences = this.mEncryptedSharedPreferences;
                for (String str : ((HashMap) encryptedSharedPreferences.getAll()).keySet()) {
                    if (!this.mKeysChanged.contains(str) && !EncryptedSharedPreferences.isReservedKey(str)) {
                        this.mEditor.remove(encryptedSharedPreferences.encryptKey(str));
                    }
                }
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            CopyOnWriteArrayList copyOnWriteArrayList = this.mKeysChanged;
            clearKeysIfNeeded();
            try {
                return this.mEditor.commit();
            } finally {
                notifyListeners();
                copyOnWriteArrayList.clear();
            }
        }

        public final void notifyListeners() {
            EncryptedSharedPreferences encryptedSharedPreferences = this.mEncryptedSharedPreferences;
            Iterator it = encryptedSharedPreferences.mListeners.iterator();
            while (it.hasNext()) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener) it.next();
                Iterator it2 = this.mKeysChanged.iterator();
                while (it2.hasNext()) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(encryptedSharedPreferences, (String) it2.next());
                }
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.putInt(EncryptedType.BOOLEAN.getId());
            allocate.put(z ? (byte) 1 : (byte) 0);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public final void putEncryptedObject(String str, byte[] bArr) {
            EncryptedSharedPreferences encryptedSharedPreferences = this.mEncryptedSharedPreferences;
            encryptedSharedPreferences.getClass();
            if (!EncryptedSharedPreferences.isReservedKey(str)) {
                this.mKeysChanged.add(str);
                if (str == null) {
                    str = "__NULL__";
                }
                try {
                    String encryptKey = encryptedSharedPreferences.encryptKey(str);
                    try {
                        Pair pair = new Pair(encryptKey, new String(Base64.encode(encryptedSharedPreferences.mValueAead.encrypt(bArr, encryptKey.getBytes(StandardCharsets.UTF_8))), "US-ASCII"));
                        this.mEditor.putString((String) pair.first, (String) pair.second);
                        return;
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                } catch (GeneralSecurityException e2) {
                    throw new SecurityException("Could not encrypt data: " + e2.getMessage(), e2);
                }
            }
            throw new SecurityException(ComposableInvoker$$ExternalSyntheticOutline0.m(str, " is a reserved key for the encryption keyset."));
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.FLOAT.getId());
            allocate.putFloat(f);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int r4) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.INT.getId());
            allocate.putInt(r4);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j) {
            ByteBuffer allocate = ByteBuffer.allocate(12);
            allocate.putInt(EncryptedType.LONG.getId());
            allocate.putLong(j);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = "__NULL__";
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer allocate = ByteBuffer.allocate(length + 8);
            allocate.putInt(EncryptedType.STRING.getId());
            allocate.putInt(length);
            allocate.put(bytes);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:            r6 = r6;     */
        @Override // android.content.SharedPreferences.Editor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final android.content.SharedPreferences.Editor putStringSet(java.lang.String r5, java.util.Set<java.lang.String> r6) {
            /*
                r4 = this;
                if (r6 != 0) goto Lc
                android.util.ArraySet r6 = new android.util.ArraySet
                r6.<init>()
                java.lang.String r0 = "__NULL__"
                r6.add(r0)
            Lc:
                java.util.ArrayList r0 = new java.util.ArrayList
                int r1 = r6.size()
                r0.<init>(r1)
                int r1 = r6.size()
                int r1 = r1 * 4
                java.util.Iterator r6 = r6.iterator()
            L1f:
                boolean r2 = r6.hasNext()
                if (r2 == 0) goto L37
                java.lang.Object r2 = r6.next()
                java.lang.String r2 = (java.lang.String) r2
                java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8
                byte[] r2 = r2.getBytes(r3)
                r0.add(r2)
                int r2 = r2.length
                int r1 = r1 + r2
                goto L1f
            L37:
                int r1 = r1 + 4
                java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocate(r1)
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.STRING_SET
                int r1 = r1.getId()
                r6.putInt(r1)
                java.util.Iterator r0 = r0.iterator()
            L4a:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L5e
                java.lang.Object r1 = r0.next()
                byte[] r1 = (byte[]) r1
                int r2 = r1.length
                r6.putInt(r2)
                r6.put(r1)
                goto L4a
            L5e:
                byte[] r6 = r6.array()
                r4.putEncryptedObject(r5, r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.security.crypto.EncryptedSharedPreferences.Editor.putStringSet(java.lang.String, java.util.Set):android.content.SharedPreferences$Editor");
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String str) {
            EncryptedSharedPreferences encryptedSharedPreferences = this.mEncryptedSharedPreferences;
            encryptedSharedPreferences.getClass();
            if (!EncryptedSharedPreferences.isReservedKey(str)) {
                this.mEditor.remove(encryptedSharedPreferences.encryptKey(str));
                this.mKeysChanged.remove(str);
                return this;
            }
            throw new SecurityException(ComposableInvoker$$ExternalSyntheticOutline0.m(str, " is a reserved key for the encryption keyset."));
        }
    }

    /* loaded from: classes.dex */
    public enum EncryptedType {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);

        private final int mId;

        EncryptedType(int r3) {
            this.mId = r3;
        }

        public static EncryptedType fromId(int r1) {
            if (r1 != 0) {
                if (r1 != 1) {
                    if (r1 != 2) {
                        if (r1 != 3) {
                            if (r1 != 4) {
                                if (r1 != 5) {
                                    return null;
                                }
                                return BOOLEAN;
                            }
                            return FLOAT;
                        }
                        return LONG;
                    }
                    return INT;
                }
                return STRING_SET;
            }
            return STRING;
        }

        public int getId() {
            return this.mId;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'AES256_SIV' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class PrefKeyEncryptionScheme {
        private static final /* synthetic */ PrefKeyEncryptionScheme[] $VALUES;
        public static final PrefKeyEncryptionScheme AES256_SIV;
        private final KeyTemplate mDeterministicAeadKeyTemplate;

        static {
            KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
            AesSivKeyFormat.Builder newBuilder = AesSivKeyFormat.newBuilder();
            newBuilder.copyOnWrite();
            ((AesSivKeyFormat) newBuilder.instance).keySize_ = 64;
            AesSivKeyFormat build = newBuilder.build();
            new AesSivKeyManager();
            PrefKeyEncryptionScheme prefKeyEncryptionScheme = new PrefKeyEncryptionScheme("AES256_SIV", 0, KeyTemplate.create("type.googleapis.com/google.crypto.tink.AesSivKey", build.toByteArray(), outputPrefixType));
            AES256_SIV = prefKeyEncryptionScheme;
            $VALUES = new PrefKeyEncryptionScheme[]{prefKeyEncryptionScheme};
        }

        private PrefKeyEncryptionScheme(String str, int r2, KeyTemplate keyTemplate) {
            this.mDeterministicAeadKeyTemplate = keyTemplate;
        }

        public static PrefKeyEncryptionScheme valueOf(String str) {
            return (PrefKeyEncryptionScheme) Enum.valueOf(PrefKeyEncryptionScheme.class, str);
        }

        public static PrefKeyEncryptionScheme[] values() {
            return (PrefKeyEncryptionScheme[]) $VALUES.clone();
        }

        public KeyTemplate getKeyTemplate() {
            return this.mDeterministicAeadKeyTemplate;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'AES256_GCM' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class PrefValueEncryptionScheme {
        private static final /* synthetic */ PrefValueEncryptionScheme[] $VALUES;
        public static final PrefValueEncryptionScheme AES256_GCM;
        private final KeyTemplate mAeadKeyTemplate;

        static {
            KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
            AesGcmKeyFormat.Builder newBuilder = AesGcmKeyFormat.newBuilder();
            newBuilder.copyOnWrite();
            ((AesGcmKeyFormat) newBuilder.instance).keySize_ = 32;
            AesGcmKeyFormat build = newBuilder.build();
            new AesGcmKeyManager();
            PrefValueEncryptionScheme prefValueEncryptionScheme = new PrefValueEncryptionScheme("AES256_GCM", 0, KeyTemplate.create("type.googleapis.com/google.crypto.tink.AesGcmKey", build.toByteArray(), outputPrefixType));
            AES256_GCM = prefValueEncryptionScheme;
            $VALUES = new PrefValueEncryptionScheme[]{prefValueEncryptionScheme};
        }

        private PrefValueEncryptionScheme(String str, int r2, KeyTemplate keyTemplate) {
            this.mAeadKeyTemplate = keyTemplate;
        }

        public static PrefValueEncryptionScheme valueOf(String str) {
            return (PrefValueEncryptionScheme) Enum.valueOf(PrefValueEncryptionScheme.class, str);
        }

        public static PrefValueEncryptionScheme[] values() {
            return (PrefValueEncryptionScheme[]) $VALUES.clone();
        }

        public KeyTemplate getKeyTemplate() {
            return this.mAeadKeyTemplate;
        }
    }

    public EncryptedSharedPreferences(String str, SharedPreferences sharedPreferences, Aead aead, DeterministicAead deterministicAead) {
        this.mFileName = str;
        this.mSharedPreferences = sharedPreferences;
        this.mValueAead = aead;
        this.mKeyDeterministicAead = deterministicAead;
    }

    public static boolean isReservedKey(String str) {
        if (!"__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) && !"__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str)) {
            return false;
        }
        return true;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        if (!isReservedKey(str)) {
            return this.mSharedPreferences.contains(encryptKey(str));
        }
        throw new SecurityException(ComposableInvoker$$ExternalSyntheticOutline0.m(str, " is a reserved key for the encryption keyset."));
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new Editor(this, this.mSharedPreferences.edit());
    }

    public final String encryptKey(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            try {
                return new String(Base64.encode(this.mKeyDeterministicAead.encryptDeterministically(str.getBytes(StandardCharsets.UTF_8), this.mFileName.getBytes())), "US-ASCII");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        } catch (GeneralSecurityException e2) {
            throw new SecurityException("Could not encrypt key. " + e2.getMessage(), e2);
        }
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : this.mSharedPreferences.getAll().entrySet()) {
            if (!isReservedKey(entry.getKey())) {
                try {
                    String str = new String(this.mKeyDeterministicAead.decryptDeterministically(Base64.decode(entry.getKey()), this.mFileName.getBytes()), StandardCharsets.UTF_8);
                    if (str.equals("__NULL__")) {
                        str = null;
                    }
                    hashMap.put(str, getDecryptedObject(str));
                } catch (GeneralSecurityException e) {
                    throw new SecurityException("Could not decrypt key. " + e.getMessage(), e);
                }
            }
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject != null && (decryptedObject instanceof Boolean)) {
            return ((Boolean) decryptedObject).booleanValue();
        }
        return z;
    }

    public final Object getDecryptedObject(String str) {
        if (!isReservedKey(str)) {
            if (str == null) {
                str = "__NULL__";
            }
            try {
                String encryptKey = encryptKey(str);
                String string = this.mSharedPreferences.getString(encryptKey, null);
                if (string == null) {
                    return null;
                }
                ByteBuffer wrap = ByteBuffer.wrap(this.mValueAead.decrypt(Base64.decode(string), encryptKey.getBytes(StandardCharsets.UTF_8)));
                boolean z = false;
                wrap.position(0);
                switch (AnonymousClass1.$SwitchMap$androidx$security$crypto$EncryptedSharedPreferences$EncryptedType[EncryptedType.fromId(wrap.getInt()).ordinal()]) {
                    case 1:
                        int r1 = wrap.getInt();
                        ByteBuffer slice = wrap.slice();
                        wrap.limit(r1);
                        String charBuffer = StandardCharsets.UTF_8.decode(slice).toString();
                        if (charBuffer.equals("__NULL__")) {
                            return null;
                        }
                        return charBuffer;
                    case 2:
                        return Integer.valueOf(wrap.getInt());
                    case 3:
                        return Long.valueOf(wrap.getLong());
                    case 4:
                        return Float.valueOf(wrap.getFloat());
                    case 5:
                        if (wrap.get() != 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    case 6:
                        ArraySet arraySet = new ArraySet();
                        while (wrap.hasRemaining()) {
                            int r5 = wrap.getInt();
                            ByteBuffer slice2 = wrap.slice();
                            slice2.limit(r5);
                            wrap.position(wrap.position() + r5);
                            arraySet.add(StandardCharsets.UTF_8.decode(slice2).toString());
                        }
                        if (arraySet.size() == 1 && "__NULL__".equals(arraySet.valueAt(0))) {
                            return null;
                        }
                        return arraySet;
                    default:
                        return null;
                }
            } catch (GeneralSecurityException e) {
                throw new SecurityException("Could not decrypt value. " + e.getMessage(), e);
            }
        }
        throw new SecurityException(ComposableInvoker$$ExternalSyntheticOutline0.m(str, " is a reserved key for the encryption keyset."));
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f) {
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject != null && (decryptedObject instanceof Float)) {
            return ((Float) decryptedObject).floatValue();
        }
        return f;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int r3) {
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject != null && (decryptedObject instanceof Integer)) {
            return ((Integer) decryptedObject).intValue();
        }
        return r3;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject != null && (decryptedObject instanceof Long)) {
            return ((Long) decryptedObject).longValue();
        }
        return j;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject != null && (decryptedObject instanceof String)) {
            return (String) decryptedObject;
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        Set<String> arraySet;
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject instanceof Set) {
            arraySet = (Set) decryptedObject;
        } else {
            arraySet = new ArraySet<>();
        }
        if (arraySet.size() > 0) {
            return arraySet;
        }
        return set;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mListeners.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mListeners.remove(onSharedPreferenceChangeListener);
    }
}
