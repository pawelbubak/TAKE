package ai.beans;

public class ColorBean {
    private String foregroundColor;
    private String backgroundColor;
    private int drawBorder;

    public ColorBean() {
    }

    public String getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getDrawBorder() {
        return drawBorder;
    }

    public void setDrawBorder(int drawBorder) {
        this.drawBorder = drawBorder;
    }
}
