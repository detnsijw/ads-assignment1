package assignment3;

public class Experiment {
    public long measureSortTime(int[] arr, String type, Sorter sorter) {
        int[] copy = arr.clone();
        long start = System.nanoTime();
        if (type.equals("basic")) {
            sorter.basicSort(copy);
        } else {
            sorter.advancedSort(copy);
        }
        long end = System.nanoTime();

        return end - start;
    }

    public long measureSearchTime(int[] arr, int target, Searcher searcher) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();

        return end - start;
    }

    public void runAllExperiments() {
        Sorter sorter = new Sorter();
        Searcher searcher = new Searcher();
        int[] sizes = {10, 100, 1000};
        for (int size : sizes) {
            System.out.println("\nArray size: " + size);
            int[] arr = sorter.generateRandomArray(size);
            long bubbleTime = measureSortTime(arr, "basic", sorter);
            long quickTime = measureSortTime(arr, "advanced", sorter);
            sorter.advancedSort(arr);
            int target = arr[size / 2];
            long searchTime = measureSearchTime(arr, target, searcher);
            System.out.println("Bubble Sort time: " + bubbleTime);
            System.out.println("Quick Sort time: " + quickTime);
            System.out.println("Binary Search time: " + searchTime);
        }
    }
}
