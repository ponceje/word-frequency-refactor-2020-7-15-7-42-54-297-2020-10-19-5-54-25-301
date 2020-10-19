import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class WordFrequencyGame {

    private static final String WHITE_SPACE = "\\s+";

    public String getResult(String inputStr){


        if (inputStr.split(WHITE_SPACE).length==1) {
            return inputStr + " 1";
        } else {

            try {

                String[] words = inputStr.split(WHITE_SPACE);

                List<WordInfo> wordInfoList = new ArrayList<>();
                for (String word : words) {
                    WordInfo wordInfo = new WordInfo(word, 1);
                    wordInfoList.add(wordInfo);
                }

                Map<String, List<WordInfo>> wordInfoMap =getListMap(wordInfoList);

                List<WordInfo> distinctWordInfoList = new ArrayList<>();
                for (Map.Entry<String, List<WordInfo>> entry : wordInfoMap.entrySet()){
                    WordInfo wordInfo = new WordInfo(entry.getKey(), entry.getValue().size());
                    distinctWordInfoList.add(wordInfo);
                }
                wordInfoList = distinctWordInfoList;

                wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (WordInfo wordInfo : wordInfoList) {
                    String wordInfoLine = wordInfo.getValue() + " " +wordInfo.getWordCount();
                    joiner.add(wordInfoLine);
                }
                return joiner.toString();
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
    }


    private Map<String,List<WordInfo>> getListMap(List<WordInfo> wordInfoList) {
        Map<String, List<WordInfo>> map = new HashMap<>();
        for (WordInfo wordInfo : wordInfoList){
            if (!map.containsKey(wordInfo.getValue())){
                ArrayList arr = new ArrayList<>();
                arr.add(wordInfo);
                map.put(wordInfo.getValue(), arr);
            }

            else {
                map.get(wordInfo.getValue()).add(wordInfo);
            }
        }


        return map;
    }


}
