package ui;

import model.Puissance4Builder;

public class TextBuilder implements Puissance4Builder {

    StringBuilder _string = new StringBuilder();

    @Override
    public void createNewPuissance4() {
        _string = new StringBuilder();
    }

    @Override
    public void addString(String s) {
        _string.append(s);
    }

    public String getPuissance4() {
        return _string.toString();
    }

    @Override
    public void finish() {
    }
}
