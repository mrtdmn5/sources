package androidx.activity.result.contract;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityResultContracts.kt */
/* loaded from: classes.dex */
public final class ActivityResultContracts$RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    public final Intent createIntent(ComponentActivity context, Object obj) {
        String[] input = (String[]) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
        return putExtra;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public final ActivityResultContract.SynchronousResult getSynchronousResult(ComponentActivity context, Object obj) {
        boolean z;
        boolean z2;
        String[] input = (String[]) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        boolean z3 = true;
        if (input.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return new ActivityResultContract.SynchronousResult(EmptyMap.INSTANCE);
        }
        int length = input.length;
        int r3 = 0;
        while (true) {
            if (r3 >= length) {
                break;
            }
            if (ContextCompat.checkSelfPermission(context, input[r3]) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                z3 = false;
                break;
            }
            r3++;
        }
        if (z3) {
            int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(input.length);
            if (mapCapacity < 16) {
                mapCapacity = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
            for (String str : input) {
                linkedHashMap.put(str, Boolean.TRUE);
            }
            return new ActivityResultContract.SynchronousResult(linkedHashMap);
        }
        return null;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public final Object parseResult(Intent intent, int r7) {
        boolean z;
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (r7 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra != null && stringArrayExtra != null) {
                ArrayList arrayList = new ArrayList(intArrayExtra.length);
                for (int r0 : intArrayExtra) {
                    if (r0 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    arrayList.add(Boolean.valueOf(z));
                }
                ArrayList filterNotNull = ArraysKt___ArraysKt.filterNotNull(stringArrayExtra);
                Iterator it = filterNotNull.iterator();
                Iterator it2 = arrayList.iterator();
                ArrayList arrayList2 = new ArrayList(Math.min(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(filterNotNull, 10), CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10)));
                while (it.hasNext() && it2.hasNext()) {
                    arrayList2.add(new Pair(it.next(), it2.next()));
                }
                return MapsKt__MapsKt.toMap(arrayList2);
            }
            return emptyMap;
        }
        return emptyMap;
    }
}
