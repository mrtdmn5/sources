package com.amazonaws.mobileconnectors.lambdainvoker;

import com.amazonaws.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public class LambdaJsonBinder implements LambdaDataBinder {
    private final Gson gson;

    public LambdaJsonBinder() {
        this(new Gson());
    }

    @Override // com.amazonaws.mobileconnectors.lambdainvoker.LambdaDataBinder
    public <T> T deserialize(byte[] bArr, Class<T> cls) {
        if (bArr == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr), StringUtils.UTF8));
        Gson gson = this.gson;
        gson.getClass();
        return (T) Primitives.wrap(cls).cast(gson.fromJson(bufferedReader, TypeToken.get((Class) cls)));
    }

    @Override // com.amazonaws.mobileconnectors.lambdainvoker.LambdaDataBinder
    public byte[] serialize(Object obj) {
        return this.gson.toJson(obj).getBytes(StringUtils.UTF8);
    }

    public LambdaJsonBinder(Gson gson) {
        this.gson = gson;
    }
}
