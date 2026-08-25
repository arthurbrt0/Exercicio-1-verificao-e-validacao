import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Beecrowd 1490 - Attacking Rooks")
class AttackingRooksTest {

    private AttackingRooks solver;

    @BeforeEach
    void setUp() {
        solver = new AttackingRooks();
    }

    static Stream<Arguments> sampleBoards() {
        return Stream.of(
                Arguments.of(
                        "sample 1 — tabuleiro 5x5 com vários peões",
                        new String[]{
                                "X....",
                                "X....",
                                "..X..",
                                ".X...",
                                "....X"
                        },
                        7
                ),
                Arguments.of(
                        "sample 2 — tabuleiro 4x4 com um peão",
                        new String[]{
                                "....",
                                ".X..",
                                "....",
                                "...."
                        },
                        5
                ),
                Arguments.of(
                        "sample 3 — único peão",
                        new String[]{"X"},
                        0
                )
        );
    }

    @ParameterizedTest(name = "{0} → {2} torres")
    @MethodSource("sampleBoards")
    @DisplayName("casos de exemplo do Beecrowd")
    void samplesFromStatement(String ignoredName, String[] board, int expected) {
        assertEquals(expected, solver.maxRooks(board));
    }

    @Test
    @DisplayName("tabuleiro vazio 1x1 cabe exatamente uma torre")
    void emptySingleSquare() {
        assertEquals(1, solver.maxRooks(new String[]{"."}));
    }

    @Test
    @DisplayName("linha vazia sem peões equivale ao número de linhas")
    void emptyBoardEqualsN() {
        assertEquals(3, solver.maxRooks(new String[]{
                "...",
                "...",
                "..."
        }));
    }

    @Test
    @DisplayName("peões em toda a diagonal ainda permitem uma torre por segmento")
    void allPawns() {
        assertEquals(0, solver.maxRooks(new String[]{
                "XX",
                "XX"
        }));
    }
}
