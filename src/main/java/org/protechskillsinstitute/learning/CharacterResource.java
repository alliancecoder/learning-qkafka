package org.protechskillsinstitute.learning;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.reactivestreams.Publisher;

import io.quarkus.vertx.web.Body;
import io.quarkus.vertx.web.ReactiveRoutes;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RouteBase;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.core.http.HttpMethod;

@RouteBase(path = "wow")
@ApplicationScoped
public class CharacterResource {

    @Inject
    @Channel("generated-characters")
    Emitter<RpgCharacter> characterEmitter;

    @Inject
    @Channel("my-data-stream")
    Publisher<RpgCharacter> toons;

    @Route(path = "/char", methods = HttpMethod.GET, produces = "application/json")
    public Uni<RpgCharacter> getCharacter() {
        return Uni.createFrom().item(() -> new RpgCharacter("dwarf", "warrior", "cragganmore"));
    }

    @Route(path = "/chars", methods = HttpMethod.GET, produces = "application/json")
    public Multi<RpgCharacter> getCharacters() {
        return ReactiveRoutes.asJsonArray(Multi.createFrom().items(new RpgCharacter("dwarf", "warrior", "cragganmore"),
                new RpgCharacter("gnome", "mage", "xaithor"), new RpgCharacter("human", "paladin", "graesyn"),
                new RpgCharacter("night elf", "druid", "jodoc")));
    }

    @Route(path = "/char", methods = HttpMethod.POST, produces = "application/json", consumes = "application/json")
    public Uni<RpgCharacter> createCharacter(@Body RpgCharacter toon) {
        RpgCharacter created = new RpgCharacter(toon.getRace(), toon.getAdventure_class(), toon.getName());
        characterEmitter.send(created);
        return Uni.createFrom().item(created);
    }

    @Route(path = "/stream", methods = HttpMethod.GET)
    public Multi<RpgCharacter> getCreatedCharsFeed() {
        return ReactiveRoutes.asEventStream(Multi.createFrom().publisher(toons));
    }
}
