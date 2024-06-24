package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzer {
    public final /* synthetic */ zzew zza;
    public final String zzb;
    public final Bundle zzc;
    public Bundle zzd;

    public zzer(zzew zzewVar) {
        this.zza = zzewVar;
        Preconditions.checkNotEmpty("default_event_parameters");
        this.zzb = "default_event_parameters";
        this.zzc = new Bundle();
    }

    public final Bundle zza() {
        char c;
        if (this.zzd == null) {
            zzew zzewVar = this.zza;
            String string = zzewVar.zza().getString(this.zzb, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int r4 = 0; r4 < jSONArray.length(); r4++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(r4);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            int hashCode = string3.hashCode();
                            if (hashCode != 100) {
                                if (hashCode != 108) {
                                    if (hashCode == 115 && string3.equals("s")) {
                                        c = 0;
                                    }
                                    c = 65535;
                                } else {
                                    if (string3.equals("l")) {
                                        c = 2;
                                    }
                                    c = 65535;
                                }
                            } else {
                                if (string3.equals(DateTimeFormattersKt.dayInMonthFormat)) {
                                    c = 1;
                                }
                                c = 65535;
                            }
                            if (c != 0) {
                                if (c != 1) {
                                    if (c != 2) {
                                        zzeh zzehVar = zzewVar.zzt.zzm;
                                        zzfr.zzR(zzehVar);
                                        zzehVar.zzd.zzb(string3, "Unrecognized persisted bundle type. Type");
                                    } else {
                                        bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                                    }
                                } else {
                                    bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                                }
                            } else {
                                bundle.putString(string2, jSONObject.getString("v"));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            zzeh zzehVar2 = zzewVar.zzt.zzm;
                            zzfr.zzR(zzehVar2);
                            zzehVar2.zzd.zza("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.zzd = bundle;
                } catch (JSONException unused2) {
                    zzeh zzehVar3 = zzewVar.zzt.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zza("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.zzd == null) {
                this.zzd = this.zzc;
            }
        }
        return this.zzd;
    }

    public final void zzb(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        zzew zzewVar = this.zza;
        SharedPreferences.Editor edit = zzewVar.zza().edit();
        int size = bundle.size();
        String str = this.zzb;
        if (size == 0) {
            edit.remove(str);
        } else {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        jSONObject.put("v", obj.toString());
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", DateTimeFormattersKt.dayInMonthFormat);
                        } else {
                            zzeh zzehVar = zzewVar.zzt.zzm;
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zzb(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        zzeh zzehVar2 = zzewVar.zzt.zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzd.zzb(e, "Cannot serialize bundle value to SharedPreferences");
                    }
                }
            }
            edit.putString(str, jSONArray.toString());
        }
        edit.apply();
        this.zzd = bundle;
    }
}
