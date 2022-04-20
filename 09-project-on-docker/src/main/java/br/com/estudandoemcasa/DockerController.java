package br.com.estudandoemcasa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

	@RequestMapping("/hello-docker")
	public HelloDocker greeting() {

		System.out.println("Endpoint /hello-docker - Miguel");

		//var hostName = System.getenv("COMPUTERNAME");
		var hostName = System.getenv("HOSTNAME");

		return new HelloDocker(
					"Hello Docker - By: MiguelProgrammer!",
					hostName
				);
	}
}
