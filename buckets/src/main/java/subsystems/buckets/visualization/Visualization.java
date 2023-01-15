package subsystems.buckets.visualization;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.Objects;

@Slf4j
public class Visualization {
    public static void main(String[] args) {
        DisposableServer server = HttpServer.create()
                .route(rb -> {
                    rb.get("/", (req, res) -> {
                        log.info("redirecting to index");
                        return res.sendRedirect("index.html");
                    });
                    rb.directory("/", staticPath());
                })
                .bindAddress(() -> InetSocketAddress.createUnresolved("localhost", 8080))
                .bindNow();

        log.info("started");
        server.onDispose().block();

    }

    @SneakyThrows
    private static Path staticPath() {
        return Path.of(Objects.requireNonNull(Visualization.class.getResource("/subsystems/buckets/visualization/static")).toURI());
    }
}
