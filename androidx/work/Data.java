package androidx.work;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class Data {
    public static final Data EMPTY;
    public static final String TAG = Logger.tagWithPrefix("Data");
    public final HashMap mValues;

    /* loaded from: classes.dex */
    public static final class Builder {
        public final HashMap mValues = new HashMap();

        public final void putAll(HashMap values) {
            for (Map.Entry entry : values.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                HashMap hashMap = this.mValues;
                if (value == null) {
                    hashMap.put(str, null);
                } else {
                    Class<?> cls = value.getClass();
                    if (cls != Boolean.class && cls != Byte.class && cls != Integer.class && cls != Long.class && cls != Float.class && cls != Double.class && cls != String.class && cls != Boolean[].class && cls != Byte[].class && cls != Integer[].class && cls != Long[].class && cls != Float[].class && cls != Double[].class && cls != String[].class) {
                        int r5 = 0;
                        if (cls == boolean[].class) {
                            boolean[] zArr = (boolean[]) value;
                            String str2 = Data.TAG;
                            Boolean[] boolArr = new Boolean[zArr.length];
                            while (r5 < zArr.length) {
                                boolArr[r5] = Boolean.valueOf(zArr[r5]);
                                r5++;
                            }
                            hashMap.put(str, boolArr);
                        } else if (cls == byte[].class) {
                            byte[] bArr = (byte[]) value;
                            String str3 = Data.TAG;
                            Byte[] bArr2 = new Byte[bArr.length];
                            while (r5 < bArr.length) {
                                bArr2[r5] = Byte.valueOf(bArr[r5]);
                                r5++;
                            }
                            hashMap.put(str, bArr2);
                        } else if (cls == int[].class) {
                            int[] r0 = (int[]) value;
                            String str4 = Data.TAG;
                            Integer[] numArr = new Integer[r0.length];
                            while (r5 < r0.length) {
                                numArr[r5] = Integer.valueOf(r0[r5]);
                                r5++;
                            }
                            hashMap.put(str, numArr);
                        } else if (cls == long[].class) {
                            long[] jArr = (long[]) value;
                            String str5 = Data.TAG;
                            Long[] lArr = new Long[jArr.length];
                            while (r5 < jArr.length) {
                                lArr[r5] = Long.valueOf(jArr[r5]);
                                r5++;
                            }
                            hashMap.put(str, lArr);
                        } else if (cls == float[].class) {
                            float[] fArr = (float[]) value;
                            String str6 = Data.TAG;
                            Float[] fArr2 = new Float[fArr.length];
                            while (r5 < fArr.length) {
                                fArr2[r5] = Float.valueOf(fArr[r5]);
                                r5++;
                            }
                            hashMap.put(str, fArr2);
                        } else if (cls == double[].class) {
                            double[] dArr = (double[]) value;
                            String str7 = Data.TAG;
                            Double[] dArr2 = new Double[dArr.length];
                            while (r5 < dArr.length) {
                                dArr2[r5] = Double.valueOf(dArr[r5]);
                                r5++;
                            }
                            hashMap.put(str, dArr2);
                        } else {
                            throw new IllegalArgumentException(String.format("Key %s has invalid type %s", str, cls));
                        }
                    } else {
                        hashMap.put(str, value);
                    }
                }
            }
        }
    }

    static {
        Data data = new Data(new HashMap());
        toByteArrayInternal(data);
        EMPTY = data;
    }

    public Data() {
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0060: MOVE (r8 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:97), block:B:36:0x005f */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.work.Data fromByteArray(byte[] r8) {
        /*
            java.lang.String r0 = "Error in Data#fromByteArray: "
            java.lang.String r1 = androidx.work.Data.TAG
            int r2 = r8.length
            r3 = 10240(0x2800, float:1.4349E-41)
            if (r2 > r3) goto L74
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            r3.<init>(r8)
            r8 = 0
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L3c java.lang.ClassNotFoundException -> L3e java.io.IOException -> L40
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L3c java.lang.ClassNotFoundException -> L3e java.io.IOException -> L40
            int r8 = r4.readInt()     // Catch: java.lang.Throwable -> L36 java.lang.ClassNotFoundException -> L38 java.io.IOException -> L3a
        L1d:
            if (r8 <= 0) goto L2d
            java.lang.String r5 = r4.readUTF()     // Catch: java.lang.Throwable -> L36 java.lang.ClassNotFoundException -> L38 java.io.IOException -> L3a
            java.lang.Object r6 = r4.readObject()     // Catch: java.lang.Throwable -> L36 java.lang.ClassNotFoundException -> L38 java.io.IOException -> L3a
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L36 java.lang.ClassNotFoundException -> L38 java.io.IOException -> L3a
            int r8 = r8 + (-1)
            goto L1d
        L2d:
            r4.close()     // Catch: java.io.IOException -> L31
            goto L51
        L31:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
            goto L51
        L36:
            r8 = move-exception
            goto L5f
        L38:
            r8 = move-exception
            goto L44
        L3a:
            r8 = move-exception
            goto L44
        L3c:
            r2 = move-exception
            goto L61
        L3e:
            r4 = move-exception
            goto L41
        L40:
            r4 = move-exception
        L41:
            r7 = r4
            r4 = r8
            r8 = r7
        L44:
            android.util.Log.e(r1, r0, r8)     // Catch: java.lang.Throwable -> L36
            if (r4 == 0) goto L51
            r4.close()     // Catch: java.io.IOException -> L4d
            goto L51
        L4d:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
        L51:
            r3.close()     // Catch: java.io.IOException -> L55
            goto L59
        L55:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
        L59:
            androidx.work.Data r8 = new androidx.work.Data
            r8.<init>(r2)
            return r8
        L5f:
            r2 = r8
            r8 = r4
        L61:
            if (r8 == 0) goto L6b
            r8.close()     // Catch: java.io.IOException -> L67
            goto L6b
        L67:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
        L6b:
            r3.close()     // Catch: java.io.IOException -> L6f
            goto L73
        L6f:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
        L73:
            throw r2
        L74:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.fromByteArray(byte[]):androidx.work.Data");
    }

    public static byte[] toByteArrayInternal(Data data) {
        ObjectOutputStream objectOutputStream;
        String str = TAG;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeInt(data.mValues.size());
                    for (Map.Entry entry : data.mValues.entrySet()) {
                        objectOutputStream.writeUTF((String) entry.getKey());
                        objectOutputStream.writeObject(entry.getValue());
                    }
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                        Log.e(str, "Error in Data#toByteArray: ", e);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        Log.e(str, "Error in Data#toByteArray: ", e2);
                    }
                    if (byteArrayOutputStream.size() <= 10240) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                } catch (IOException e3) {
                    e = e3;
                    objectOutputStream2 = objectOutputStream;
                    Log.e(str, "Error in Data#toByteArray: ", e);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e4) {
                            Log.e(str, "Error in Data#toByteArray: ", e4);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        Log.e(str, "Error in Data#toByteArray: ", e5);
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e6) {
                            Log.e(str, "Error in Data#toByteArray: ", e6);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException e7) {
                        Log.e(str, "Error in Data#toByteArray: ", e7);
                        throw th;
                    }
                }
            } catch (IOException e8) {
                e = e8;
            }
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream = null;
        }
    }

    public final boolean equals(Object o) {
        boolean z;
        if (this == o) {
            return true;
        }
        if (o == null || Data.class != o.getClass()) {
            return false;
        }
        Data data = (Data) o;
        HashMap hashMap = this.mValues;
        Set<String> keySet = hashMap.keySet();
        if (!keySet.equals(data.mValues.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj = hashMap.get(str);
            Object obj2 = data.mValues.get(str);
            if (obj != null && obj2 != null) {
                if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                    z = Arrays.deepEquals((Object[]) obj, (Object[]) obj2);
                } else {
                    z = obj.equals(obj2);
                }
            } else if (obj == obj2) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        HashMap hashMap = this.mValues;
        if (!hashMap.isEmpty()) {
            for (String str : hashMap.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = hashMap.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public Data(Data other) {
        this.mValues = new HashMap(other.mValues);
    }

    public Data(HashMap values) {
        this.mValues = new HashMap(values);
    }
}
