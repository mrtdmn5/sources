package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.connection.ConnectionModule_ProvideCharacteristicPropertiesParserFactory;
import com.polidea.rxandroidble2.internal.util.CharacteristicPropertiesParser;

/* loaded from: classes3.dex */
public final class IllegalOperationMessageCreator_Factory implements Provider {
    public final Provider<CharacteristicPropertiesParser> propertiesParserProvider = ConnectionModule_ProvideCharacteristicPropertiesParserFactory.InstanceHolder.INSTANCE;

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new IllegalOperationMessageCreator(this.propertiesParserProvider.get());
    }
}
