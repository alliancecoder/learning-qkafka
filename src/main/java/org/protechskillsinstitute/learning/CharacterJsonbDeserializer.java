package org.protechskillsinstitute.learning;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class CharacterJsonbDeserializer extends JsonbDeserializer<RpgCharacter> {

    public CharacterJsonbDeserializer() {
        super(RpgCharacter.class);
    }
}
