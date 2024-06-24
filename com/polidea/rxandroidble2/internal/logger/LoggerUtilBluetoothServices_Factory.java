package com.polidea.rxandroidble2.internal.logger;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvideCharacteristicPropertiesParserFactory;
import com.polidea.rxandroidble2.internal.util.CharacteristicPropertiesParser;

/* loaded from: classes3.dex */
public final class LoggerUtilBluetoothServices_Factory implements Provider {
    public final Provider<CharacteristicPropertiesParser> characteristicPropertiesParserProvider = ConnectionModule_ProvideCharacteristicPropertiesParserFactory.InstanceHolder.INSTANCE;

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new LoggerUtilBluetoothServices(this.characteristicPropertiesParserProvider.get());
    }
}
