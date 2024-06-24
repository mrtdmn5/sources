package com.google.api.client.googleapis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class GoogleUtils {
    static {
        String str = null;
        try {
            InputStream resourceAsStream = GoogleUtils.class.getResourceAsStream("google-api-client.properties");
            if (resourceAsStream != null) {
                try {
                    Properties properties = new Properties();
                    properties.load(resourceAsStream);
                    str = properties.getProperty("google-api-client.version");
                } finally {
                }
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        } catch (IOException unused) {
        }
        if (str == null) {
            str = "unknown-version";
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)(-SNAPSHOT)?").matcher(str);
        matcher.find();
        Integer.parseInt(matcher.group(1));
        Integer.parseInt(matcher.group(2));
        Integer.parseInt(matcher.group(3));
    }

    private GoogleUtils() {
    }
}
