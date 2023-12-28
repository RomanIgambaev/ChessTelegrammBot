package org.example.enums;

public enum Color {
    WHITE("Белый"),
    BLACK("Черный"),
    EMPTYFIELD("Пустое поле");

    private final String displayName;

    Color(String displayName) {
        this.displayName = displayName;
    }

    }
