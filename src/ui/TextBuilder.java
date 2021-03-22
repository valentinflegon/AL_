package ui;

import model.P4Builder;

public class TextBuilder implements P4Builder {

    StringBuilder _string = new StringBuilder();

    public TextBuilder() {
    }

    @Override
    public void createNewPuissance4() {
        _string = new StringBuilder();
    }

    @Override
    public void addString(String s) {
        _string.append(s);
    }

    @Override
    public void finish() {
    }

    @Override
    public void beginHeader() {
    	_string.append("***************");
    }

    @Override
    public void endHeader() {
        _string.append("\n");
    }

    @Override
    public void beginTable() {
    }

    @Override
    public void endTable() {
    }

    @Override
    public void beginRow() {
    }

    @Override
    public void endRow() {
        _string.append("\n");
    }

    @Override
    public void beginColumn() {
        _string.append("\t");
    }

    @Override
    public void endColumn() {
    }

    @Override
    public void beginParagraph() {
        _string.append("\n");
    }

    @Override
    public void endParagraph() {
    }

    @Override
    public String getPuissance4() {
        return _string.toString();
    }
}
