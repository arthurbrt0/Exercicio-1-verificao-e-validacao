# Beecrowd 1490 — Attacking Rooks

## Tecnologias
- Java 17
- Maven
- JUnit 6 (Jupiter): `@DisplayName`, `@ParameterizedTest`, `@BeforeEach`

## Como rodar

Testes:
```bash
mvn test
```

Programa (entrada no stdin, no formato do Beecrowd):
```bash
mvn -q compile exec:java -Dexec.mainClass=Main
```

Ou compile e execute `Main` com `java`. Vários tabuleiros até EOF.

## Beecrowd
Os três exemplos oficiais (saídas 7, 5 e 0) estão nos testes. No juiz, cole `Main` e `AttackingRooks` no mesmo arquivo e tire o `public` da classe auxiliar.
