package tree;

public abstract class Tree<T, U extends Tree<T, U>> {

    private U left = null;

    private U right = null;

    private T value;



    public Tree() {
        value = null;
        left = null;
        right = null;
    }

    public Tree(T value) {
        this.value = value;
    }

    public Tree(T value, U left) {
        this.value = value;
        this.left = left;
    }

    public Tree(T value, U left, U right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }



    public U getLeft() {
        return left;
    }

    public void setLeft(U left) {
        this.left = left;
    }

    public U getRight() {
        return right;
    }

    public void setRight(U right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }



    @Override
    public String toString() {
        return (left == null && right == null) ?
                (value == null) ?
                        "Tree{}"
                        : "Tree{" + value + "}"
                : "Tree{" +
                "\nvalue=" + value +
                "\nleft=" + left +
                "\nright=" + right +
                '}';
    }

}
