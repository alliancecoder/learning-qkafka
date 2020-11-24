package org.protechskillsinstitute.learning;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class CharacterJacksonDeserializer extends ObjectMapperDeserializer<RpgCharacter> {
    public CharacterJacksonDeserializer() {
        super(RpgCharacter.class);
    }
}
