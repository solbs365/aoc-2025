import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.aoc2025.day9.app.RectangleSolver;
import software.aoc2025.day9.io.PositionParser;
import software.aoc2025.day9.model.Position;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AreaSolverTest {

    private RectangleSolver solver;
    private PositionParser parser;

    @BeforeEach
    void setUp() {
        // Inicialización de componentes (Inyección manual para pruebas)
        solver = new RectangleSolver();
        parser = new PositionParser();
    }

    @Test
    @DisplayName("Debe calcular el área correcta para el ejemplo del enunciado (Área 50)")
    void testExampleCase() {
        // Datos del ejemplo: entre 2,5 y 11,1 debe dar 50
        List<Position> positions = List.of(
                Position.of(2, 5),
                Position.of(11, 1)
        );

        long area = solver.findMaxArea(positions);

        // (abs(2-11)+1) * (abs(5-1)+1) = 10 * 5 = 50
        Assertions.assertEquals(50, area, "El área máxima entre (2,5) y (11,1) debería ser 50");
    }

    @Test
    @DisplayName("Debe parsear correctamente las coordenadas y calcular el área")
    void testParserAndSolverIntegration() {
        // Simulación de entrada de archivo
        Stream<String> input = Stream.of("7,1", "11,7");

        List<Position> positions = parser.parse(input);
        long area = solver.findMaxArea(positions);

        // (abs(7-11)+1) * (abs(1-7)+1) = 5 * 7 = 35
        Assertions.assertEquals(35, area);
    }

    @Test
    @DisplayName("Debe devolver área 1 para un rectángulo formado por el mismo punto")
    void testSinglePointArea() {
        List<Position> positions = List.of(
                Position.of(5, 5),
                Position.of(5, 5)
        );

        long area = solver.findMaxArea(positions);
        Assertions.assertEquals(1, area, "Un punto sobre sí mismo representa una baldosa (1x1)");
    }
}
