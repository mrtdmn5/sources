package com.animaconnected.secondo.provider.productinfo;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProductInfoStorage.kt */
/* loaded from: classes3.dex */
public final class ProductInfoStorage {
    private static final String KEY_CURRENT_SKU = "current_sku";
    private static final String KEY_PRODUCT_INFO = "product_info";
    private static final String SKU_STORAGE = "ProductInfoStorage";
    private HashMap<String, ProductInfoData> data;
    private final SharedPreferences sharedPreferences;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Type productInfoType = new TypeToken<HashMap<String, ProductInfoData>>() { // from class: com.animaconnected.secondo.provider.productinfo.ProductInfoStorage$Companion$productInfoType$1
    }.getType();

    /* compiled from: ProductInfoStorage.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ProductInfoStorage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.sharedPreferences = context.getSharedPreferences(SKU_STORAGE, 0);
    }

    private final HashMap<String, ProductInfoData> load() {
        String string = this.sharedPreferences.getString(KEY_PRODUCT_INFO, null);
        if (string == null) {
            return null;
        }
        Object fromJson = new Gson().fromJson(string, productInfoType);
        Intrinsics.checkNotNull(fromJson, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, com.animaconnected.secondo.provider.productinfo.ProductInfoData>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, com.animaconnected.secondo.provider.productinfo.ProductInfoData> }");
        return (HashMap) fromJson;
    }

    private final Unit save() {
        HashMap<String, ProductInfoData> hashMap = this.data;
        if (hashMap != null) {
            this.sharedPreferences.edit().putString(KEY_PRODUCT_INFO, new Gson().toJson(hashMap)).apply();
            return Unit.INSTANCE;
        }
        return null;
    }

    public final String getCurrentSku() {
        return this.sharedPreferences.getString(KEY_CURRENT_SKU, null);
    }

    public final ProductInfoData getDataFromCurrentSku() {
        return getDataFromSku(getCurrentSku());
    }

    public final ProductInfoData getDataFromSku(String str) {
        if (this.data == null) {
            this.data = load();
        }
        HashMap<String, ProductInfoData> hashMap = this.data;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public final void setCurrentSku(String str) {
        this.sharedPreferences.edit().putString(KEY_CURRENT_SKU, str).apply();
    }

    public final void setData(ProductInfoData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.data == null) {
            HashMap<String, ProductInfoData> load = load();
            if (load == null) {
                load = new HashMap<>();
            }
            this.data = load;
        }
        HashMap<String, ProductInfoData> hashMap = this.data;
        if (hashMap != null) {
            String str = data.sku;
            Intrinsics.checkNotNull(str);
            hashMap.put(str, data);
        }
        save();
    }
}
