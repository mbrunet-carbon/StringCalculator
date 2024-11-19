import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class StringCalculatorTest {

    @Test
    void shouldAdd() throws Exception {
        // Given
        String input = "1,2,//;\n3,1000\n4";

        //When
        int result = StringCalculator.Add(input);

        //Then
        assertEquals(10, result);
    }

    @Test
    void shouldThrowWhenNegativeNumberExists() {
        // Given
        String input = "-1,2,-3\n4";

        //When + Then
        assertThatThrownBy(() -> StringCalculator.Add(input))
                .hasMessage("Les nombres négatifs ne sont pas autorisés : -1,-3");
    }
}