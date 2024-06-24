package com.google.android.gms.internal.measurement;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzlo {
    public static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void zzb(StringBuilder sb, int r5, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, r5, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, r5, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(r5, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int r1 = 1; r1 < str.length(); r1++) {
                char charAt = str.charAt(r1);
                if (Character.isUpperCase(charAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(charAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            zzjb zzjbVar = zzje.zzb;
            sb.append(zzmm.zza(new zzjb(((String) obj).getBytes(zzkn.zzb))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzje) {
            sb.append(": \"");
            sb.append(zzmm.zza((zzje) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzkf) {
            sb.append(" {");
            zzd((zzkf) obj, sb, r5 + 2);
            sb.append("\n");
            zzc(r5, sb);
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int r6 = r5 + 2;
            zzb(sb, r6, TransferTable.COLUMN_KEY, entry.getKey());
            zzb(sb, r6, "value", entry.getValue());
            sb.append("\n");
            zzc(r5, sb);
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj);
    }

    public static void zzc(int r3, StringBuilder sb) {
        while (r3 > 0) {
            int r0 = 80;
            if (r3 <= 80) {
                r0 = r3;
            }
            sb.append(zza, 0, r0);
            r3 -= r0;
        }
    }

    public static void zzd(zzlm zzlmVar, StringBuilder sb, int r20) {
        int r10;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzlmVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int r9 = 0;
        while (true) {
            r10 = 3;
            if (r9 >= length) {
                break;
            }
            Method method3 = declaredMethods[r9];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            r9++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(r10);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb, r20, substring.substring(0, substring.length() - 4), zzkf.zzbH(zzlmVar, method2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, r20, substring.substring(0, substring.length() - 3), zzkf.zzbH(zzlmVar, method, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object zzbH = zzkf.zzbH(zzlmVar, method4, new Object[0]);
                    if (method5 == null) {
                        if (zzbH instanceof Boolean) {
                            if (!((Boolean) zzbH).booleanValue()) {
                            }
                            zzb(sb, r20, substring, zzbH);
                        } else if (zzbH instanceof Integer) {
                            if (((Integer) zzbH).intValue() == 0) {
                            }
                            zzb(sb, r20, substring, zzbH);
                        } else if (zzbH instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzbH).floatValue()) == 0) {
                            }
                            zzb(sb, r20, substring, zzbH);
                        } else if (zzbH instanceof Double) {
                            if (Double.doubleToRawLongBits(((Double) zzbH).doubleValue()) == 0) {
                            }
                            zzb(sb, r20, substring, zzbH);
                        } else {
                            if (zzbH instanceof String) {
                                equals = zzbH.equals("");
                            } else if (zzbH instanceof zzje) {
                                equals = zzbH.equals(zzje.zzb);
                            } else if (zzbH instanceof zzlm) {
                                if (zzbH == ((zzlm) zzbH).zzbS()) {
                                }
                                zzb(sb, r20, substring, zzbH);
                            } else {
                                if ((zzbH instanceof Enum) && ((Enum) zzbH).ordinal() == 0) {
                                }
                                zzb(sb, r20, substring, zzbH);
                            }
                            if (equals) {
                            }
                            zzb(sb, r20, substring, zzbH);
                        }
                    } else {
                        if (!((Boolean) zzkf.zzbH(zzlmVar, method5, new Object[0])).booleanValue()) {
                        }
                        zzb(sb, r20, substring, zzbH);
                    }
                }
            }
            r10 = 3;
        }
        if (!(zzlmVar instanceof zzkc)) {
            zzmp zzmpVar = ((zzkf) zzlmVar).zzc;
            if (zzmpVar != null) {
                for (int r8 = 0; r8 < zzmpVar.zzb; r8++) {
                    zzb(sb, r20, String.valueOf(zzmpVar.zzc[r8] >>> 3), zzmpVar.zzd[r8]);
                }
                return;
            }
            return;
        }
        throw null;
    }
}
