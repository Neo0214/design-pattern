package org.group11.Patterns.mvc;

public class controller {
    private view view;
    private model model;

    public controller(view view, model model) {
        this.view = view;
        this.model = model;
    }
}
