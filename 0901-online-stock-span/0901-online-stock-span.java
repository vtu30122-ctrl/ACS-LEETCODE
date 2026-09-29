
class StockSpanner {

    private int[] prices;
    private int[] spans;
    private int top;

    public StockSpanner() {
        prices = new int[10001];
        spans = new int[10001];
        top = -1;
    }

    public int next(int price) {
        int span = 1;

        while (top >= 0 && prices[top] <= price) {
            span += spans[top];
            top--;
        }

        top++;
        prices[top] = price;
        spans[top] = span;

        return span;
    }
}

