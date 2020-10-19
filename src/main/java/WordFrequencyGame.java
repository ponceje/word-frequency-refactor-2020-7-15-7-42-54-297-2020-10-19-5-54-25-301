import java.util.*;

public class WordFrequencyGame {

    private static final String WHITE_SPACE = "\\s+";
    private static final String NEW_LINE = "\n";

    public String getResult(String inputStr){
        List<WordInfo> wordInfoList = calculateWordFrequency(inputStr) ;
        wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());
        return getStringJoiner(wordInfoList).toString();
    }

    private StringJoiner getStringJoiner(List<WordInfo> wordInfoList) {
        StringJoiner joiner = new StringJoiner(NEW_LINE);
        for (WordInfo wordInfo : wordInfoList) {
            String wordInfoLine = String.format("%s %d", wordInfo.getValue(), wordInfo.getWordCount());
            joiner.add(wordInfoLine);
        }
        return joiner;
    }

    private List<WordInfo> calculateWordFrequency(String sentence){
        List<String> words = Arrays.asList(sentence.split(WHITE_SPACE));
        List<WordInfo> wordInfoList = new ArrayList<>();
        for(String word : new HashSet<>(words)){
            int count = Collections.frequency(words,word);
            wordInfoList.add(new WordInfo(word,count));
        }
        return wordInfoList;
    }


}
