package net.dnadas.freeroam_gateway.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Log4j2
public class TestController {
  private final WebClient.Builder webClientBuilder;

  @GetMapping
  public Mono<String> test(Principal principal, ServerWebExchange exchange) {
    String token = exchange.getRequest().getHeaders().getFirst("Authorization");
    return webClientBuilder.build()
      .get()
      .uri("lb://FREEROAM-SUMMITS-SERVICE/hello")
      .header("Authorization", token) // Propagate the token
      .retrieve()
      .bodyToMono(String.class)
      .map(result -> "Hello, " + principal.getName() + "<br/>" + result)
      .onErrorResume(e -> Mono.just("Failed to retrieve data: " + e.getMessage()));
  }
}
