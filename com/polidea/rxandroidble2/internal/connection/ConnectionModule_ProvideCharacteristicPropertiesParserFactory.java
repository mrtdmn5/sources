package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.util.CharacteristicPropertiesParser;

/* loaded from: classes3.dex */
public final class ConnectionModule_ProvideCharacteristicPropertiesParserFactory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final ConnectionModule_ProvideCharacteristicPropertiesParserFactory INSTANCE = new ConnectionModule_ProvideCharacteristicPropertiesParserFactory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new CharacteristicPropertiesParser();
    }
}
