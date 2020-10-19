import java.util.*;

public class WordFrequencyGame {

    private static final String WHITE_SPACE = "\\s+";
    private static final String NEW_LINE = "\n";

    public String getResult(String inputStr){
        List<WordInfo> wordInfoList = calculateWordFrequency(inputStr) ;
        wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());
        return getResultJoiner(wordInfoList).toString();
    }

    private StringJoiner getResultJoiner(List<WordInfo> wordInfoList) {
        StringJoiner resultStrJoiner = new StringJoiner(NEW_LINE);
        wordInfoList.stream().map(wordInfo -> String.format("%s %d", wordInfo.getValue(), wordInfo.getWordCount()))
                .forEachOrdered(resultStrJoiner::add);
        return resultStrJoiner;
    }

    private List<WordInfo> calculateWordFrequency(String sentence){
        List<String> words = Arrays.asList(sentence.split(WHITE_SPACE));
        List<WordInfo> wordInfoList = new ArrayList<>();
        new HashSet<>(words).forEach(word -> {
            int count = Collections.frequency(words, word);
            wordInfoList.add(new WordInfo(word, count));
        });
        return wordInfoList;
    }
}
