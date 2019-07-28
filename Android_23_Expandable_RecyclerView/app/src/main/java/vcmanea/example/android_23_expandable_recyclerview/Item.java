package vcmanea.example.android_23_expandable_recyclerview;

public class Item {
    private String text, subText;
    private boolean expdanded;


    public Item(String text, String subText, boolean expandable) {
        this.text = text;
        this.subText = subText;
        this.expdanded = expandable;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }

    public boolean isExpanded() {
        return expdanded;
    }

    public void setExpanded(boolean expandable) {
        this.expdanded = expandable;
    }
}