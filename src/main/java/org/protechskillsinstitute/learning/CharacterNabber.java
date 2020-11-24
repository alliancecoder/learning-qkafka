package org.protechskillsinstitute.learning;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Broadcast;

@ApplicationScoped
public class CharacterNabber {

    @Incoming("characters")
    @Outgoing("my-data-stream")
    @Broadcast
    public RpgCharacter process(RpgCharacter toon) {
        return toon;
    }
}
/**
 * This reads from the Kafka Chennel "characters" then pushes to an in-mmory
 * data stream for this service
 */