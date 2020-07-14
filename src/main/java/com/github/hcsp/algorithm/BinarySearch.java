package com.github.hcsp.algorithm;

public class BinarySearch {
    public static void main(String[] args) {
//        我这里改了下target,想看下两个代码的差别，试过尾部查找，我的声明了头尾，同学的只有头，
//        过程总我发现一个if()条件很费时间，想搞清楚之间的区别，
//        结果试着试着发现同样的代码都有10倍的速度区别，检查几遍搞不懂就想请教下老师
        long starTime1 = System.nanoTime();
        System.out.println(binarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "aaa"));
        long endTime1 = System.nanoTime();
        System.out.println(endTime1 - starTime1);
        long starTime = System.nanoTime();
        System.out.println(binarySearch1(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "aaa"));
        long endTime = System.nanoTime();
        System.out.println(endTime - starTime);
    }

    // 给定一个按照字符串升序升序排好序的用户数组，寻找目标字符串的位置，返回其索引值
    // 如果未找到，返回-1
//        while (true) {
//            if (strings[start].equals(target)) {
//                return start;
//            }
//            if (strings[end].equals(target)) {
//                return end;
    // 我们鼓励你使用递归和非递归两种方式
//    public static int binarySearch(String[] strings, String target) {
//        int start = 0, end = strings.length - 1;
//            }
//            if (target.compareTo(strings[start]) < 0 || target.compareTo(strings[end]) > 0) {
//                return -1;
//            }
//            int mid = (start + end) / 2;
//            if (target.compareTo(strings[mid]) > 0) {
//                start = mid + 1;
//            } else if (target.compareTo(strings[mid]) < 0) {
//                end = mid -1;
//            }else {
//                return mid;
//            }
//        }
//    }
    //这是我的：
    public static int binarySearch(String[] strings, String target) {
        int start = 0;
        int end = strings.length - 1;
        return search(strings, target, start, end);
    }

    static int search(String[] strings, String target, int start, int end) {
        if (target.compareTo(strings[start]) == 0) {
            //这里同样的代码，结果时间却差10倍，肯定是我测试时间的代码有问题吧
            return start;
        }

        long startTime = System.nanoTime();
        if (target.compareTo(strings[end]) == 0) {
            long endTime = System.nanoTime();
            System.out.println(endTime - startTime);
            return end;
        }
        int mid = (start + end) / 2;
        if (target.compareTo(strings[mid]) > 0) {
            return search(strings, target, mid + 1, end);
        } else if (target.compareTo(strings[mid]) < 0) {
            if (mid < 1) {
                return -1;
            }
            return search(strings, target, start, end - 1);
        } else {
            return mid;
        }
    }

    //这是同学的：
    public static int binarySearch1(String[] strings, String target) {
        int last = strings.length - 1;
        int first = 0;
        return search1(first, last, strings, target);
    }

    static int search1(int first, int last, String[] strings, String target) {
        if (target.compareTo(strings[first]) == 0) {
            //这里同样的代码，结果时间却差10倍，肯定是我测试时间的代码有问题吧
            return first;
        }

//        long startTime = System.nanoTime();
        int middle = (last + first) % 2 == 0 ? (last + first) / 2 : (last + first) / 2 + 1;
//        System.out.println(endTime - startTime);
        if (target.compareTo(strings[middle]) > 0) {
            return search1(middle, last, strings, target);
        } else if (target.compareTo(strings[middle]) < 0) {
            if (last == middle) {
                return -1;
            }
            return search1(first, middle, strings, target);
        } else {
            return middle;
        }

    }
}
