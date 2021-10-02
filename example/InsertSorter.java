package example;

public class InsertSorter implements Sorter {
    private String plan;
    private int[] array;

    private void swap(int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        plan += "" + array[j] + "<->" + array[i] + "\n";
    }

    @Override
    public void load(int[] elements) {
        array = elements;
        plan = "";
    }

    @Override
    public void sort() {
        for (int i = 0; i < array.length; ++i) {
            int m = array[i];
            int t = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < m) {
                    m = array[j];
                    t = j;
                }
            }
            if (m != array[i]) {
                swap(i, t);
            }
        }
    }

    @Override
    public String getPlan() {
        return plan;
    }
}
