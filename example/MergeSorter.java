package example;

public class MergeSorter implements Sorter {
    private String plan;
    private int[] array;

    private void swap(int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        plan += "" + array[j] + "<->" + array[i] + "\n";
    }

    private void mergeSort(int l, int r) {
        if (l == r) {
            return;
        } else {
            int nr = (l + r) / 2;
            int nl = nr + 1;
            mergeSort(l, nr);
            mergeSort(nl, r);
            int left = l;
            int right = nl;
            while (left <= nr) {
                if (array[left] < array[right]) {
                    left++;
                } else {
                    swap(left, right);
                    int tr = right;
                    while (tr < r && array[tr] > array[tr + 1]) {
                        swap(tr, tr + 1);
                    }
                    left++;
                }
            }
        }
    }

    @Override
    public void load(int[] elements) {
        array = elements;
        plan = "";
    }

    @Override
    public void sort() {
        mergeSort(0, array.length - 1);
    }

    @Override
    public String getPlan() {
        return plan;
    }
}
