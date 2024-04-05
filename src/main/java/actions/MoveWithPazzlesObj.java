package actions;

public  class MoveWithPazzlesObj {

    static String fromElement;

    static String toElement;

    public  static String getFromElement() {
        return fromElement;
    }

    public MoveWithPazzlesObj setFromElement(String fromElement) {
        MoveWithPazzlesObj.fromElement = fromElement;
        return this;
    }

    public static String getToElement() {
        return toElement;
    }

    public  MoveWithPazzlesObj setToElement(String toElement) {
        MoveWithPazzlesObj.toElement = toElement;
        return this;
    }
}
