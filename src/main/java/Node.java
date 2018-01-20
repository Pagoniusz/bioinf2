/**
 * Created by tswed on 20.01.2018.
 */
public class Node {
    String fullWord;
    String prefix;
    String suffix;
    String lastChar;

    public Node(String fullWord, String prefix, String suffix, String lastChar) {
        this.fullWord = fullWord;
        this.prefix = prefix;
        this.suffix = suffix;
        this.lastChar = lastChar;
    }

    public String getFullWord() {

        return fullWord;
    }

    public void setFullWord(String fullWord) {
        this.fullWord = fullWord;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getLastChar() {
        return lastChar;
    }

    public void setLastChar(String lastChar) {
        this.lastChar = lastChar;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
