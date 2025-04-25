package Queue;
public class CircularQueue {

    private static int[] data;
    private final static int default_size = 5;
    private int size = 0;
    protected int front = 0;
    protected int end = 0;
    public CircularQueue(){
        this.data = new int[default_size];
    }
    public CircularQueue(int size){
        this.data = new int[size];
    }

    public static boolean isFull(){return data.length == default_size;}


}