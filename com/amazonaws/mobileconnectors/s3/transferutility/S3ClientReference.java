package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.services.s3.AmazonS3;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class S3ClientReference {
    private static Map<Integer, AmazonS3> map = new ConcurrentHashMap();

    public static void clear() {
        map.clear();
    }

    public static AmazonS3 get(Integer num) {
        return map.get(num);
    }

    public static void put(Integer num, AmazonS3 amazonS3) {
        map.put(num, amazonS3);
    }

    public static void remove(Integer num) {
        map.remove(num);
    }
}
