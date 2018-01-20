/**
 * Created by tswed on 20.01.2018.
 */
public class DigraphEdge {
    int prefixIndex;
    int suffixIndex;
    String letter;

    public DigraphEdge() {
    }

    public DigraphEdge(int prefixIndex, int suffixIndex, String letter) {
        this.prefixIndex = prefixIndex;
        this.suffixIndex = suffixIndex;
        this.letter=letter;
    }

    public int getPrefixIndex() {

        return prefixIndex;
    }

    public void setPrefixIndex(int prefixIndex) {
        this.prefixIndex = prefixIndex;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
    public int getSuffixIndex() {
        return suffixIndex;
    }

    public void setSuffixIndex(int suffixIndex) {
        this.suffixIndex = suffixIndex;
    }
}
