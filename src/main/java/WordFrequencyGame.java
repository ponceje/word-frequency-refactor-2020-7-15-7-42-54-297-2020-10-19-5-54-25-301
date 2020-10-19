import java.util.*;

public class WordFrequencyGame {

    private static final String WHITE_SPACE = "\\s+";
    private static final String NEW_LINE = "\n";

    public String getResult(String inputStr){
        List<WordInfo> wordInfoList = calculateWordFrequency(inputStr) ;
        sortWordInfoList(wordInfoList);
        return getResultStrJoiner(wordInfoList).toString();
    }

    private void sortWordInfoList(List<WordInfo> wordInfoList) {
        wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());
    }

    private StringJoiner getResultStrJoiner(List<WordInfo> wordInfoList) {
        StringJoiner resultStrJoiner = new StringJoiner(NEW_LINE);
        wordInfoList.stream().map(wordInfo -> String.format("%s %d", wordInfo.getValue(), wordInfo.getWordCount()))
                .forEachOrdered(resultStrJoiner::add);
        return resultStrJoiner;
    }

    private List<WordInfo> calculateWordFrequency(String sentence){
        List<String> words = Arrays.asList(sentence.split(WHITE_SPACE));
        List<WordInfo> wordInfoList = new ArrayList<>();
        new HashSet<>(words).stream().map(word -> new WordInfo(word,Collections.frequency(words,word)))
                .forEachOrdered(wordInfoList::add);
        return wordInfoList;
    }
}
