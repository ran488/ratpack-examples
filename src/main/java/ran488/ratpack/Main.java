package ran488.ratpack;

import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

/**
 * To run from command line using Gradle: gradlew run
 *
 */
public class Main {
	public static void main(String... args) throws Exception {
		RatpackServer.start(server -> server
			.serverConfig(ServerConfig.builder().findBaseDir().port(5000).build())
			.registryOf(registry -> registry.add("World! (from registry)")) 
			.handlers(chain -> chain
				.get(ctx -> ctx.render("Hello " + ctx.get(String.class))) 							// http://localhost:5000
				.files() 																			// http://localhost:5000/test-file.txt
				.get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + "!")) 	// http://localhost:5000/Robb
			)
		);
	}
}
