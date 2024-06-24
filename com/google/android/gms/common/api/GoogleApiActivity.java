package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
@KeepName
/* loaded from: classes3.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    public static final /* synthetic */ int $r8$clinit = 0;
    public int zaa = 0;

    @Override // android.app.Activity
    public final void onActivityResult(int r4, int r5, Intent intent) {
        super.onActivityResult(r4, r5, intent);
        if (r4 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.zaa = 0;
            setResult(r5, intent);
            if (booleanExtra) {
                GoogleApiManager zam = GoogleApiManager.zam(this);
                if (r5 != -1) {
                    if (r5 == 0) {
                        zam.zaz(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                    }
                } else {
                    zau zauVar = zam.zat;
                    zauVar.sendMessage(zauVar.obtainMessage(3));
                }
            }
        } else if (r4 == 2) {
            this.zaa = 0;
            setResult(r5, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zaa = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zaa = bundle.getInt("resolution");
        }
        if (this.zaa != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Log.e("GoogleApiActivity", "Activity started without extras");
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get(AnalyticsConstants.KEY_ERROR_CODE);
            if (pendingIntent == null && num == null) {
                Log.e("GoogleApiActivity", "Activity started without resolution");
                finish();
                return;
            }
            if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.zaa = 1;
                    return;
                } catch (ActivityNotFoundException e) {
                    if (extras.getBoolean("notify_manager", true)) {
                        GoogleApiManager.zam(this).zaz(new ConnectionResult(22, null), getIntent().getIntExtra("failing_client_id", -1));
                    } else {
                        String m = zzav$$ExternalSyntheticOutline0.m("Activity not found while launching ", pendingIntent.toString(), InstructionFileId.DOT);
                        if (Build.FINGERPRINT.contains("generic")) {
                            m = m.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                        }
                        Log.e("GoogleApiActivity", m, e);
                    }
                    this.zaa = 1;
                    finish();
                    return;
                } catch (IntentSender.SendIntentException e2) {
                    Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e2);
                    finish();
                    return;
                }
            }
            Preconditions.checkNotNull(num);
            GoogleApiAvailability.zab.showErrorDialogFragment(this, num.intValue(), this);
            this.zaa = 1;
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.zaa);
        super.onSaveInstanceState(bundle);
    }
}
