import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WordInfoFrequencyGameTest {

    @Test
    public void should_get_the_1_when_input_the(){
        //Given
        validate_Input_words_process_to_expected_word("the", "the 1");
    }

    @Test
    public void should_process_two_words(){
        //Given
        validate_Input_words_process_to_expected_word("the is", "the 1\nis 1");
    }

    @Test
    public void should_process_two_words_with_special_spaces() {
        //Given
        validate_Input_words_process_to_expected_word("the      is", "the 1\nis 1");
    }

    @Test
    public void should_process_two_words_with_special_enter(){
        //Given
        validate_Input_words_process_to_expected_word("the   \n   is", "the 1\nis 1");
    }

    @Test
    public void should_process_two_same_words_with_sorted(){
        //Given
        validate_Input_words_process_to_expected_word("the the is", "the 2\nis 1");
    }

    @Test
    public void should_pracess_two_same_words_with_sorted() throws Exception {
        //Given
        validate_Input_words_process_to_expected_word("the is is", "is 2\nthe 1");
    }

    @Test
    public void should_process_sorted_with_count_descending() throws Exception {
        //Given
        String inputStr = "the is is";
        String expectResult = "is 2\nthe 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    private void validate_Input_words_process_to_expected_word(String inputStr, String expectResult) {
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.getResult(inputStr);
        //Then
        assertEquals(result, expectResult);
    }
}
