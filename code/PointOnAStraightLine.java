package project;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointOnAStraightLine {

    public static void main(String[] args) {
        int N = 1000;
        List<Point2D> set = generateSet(N);

        Random rand = new Random();

        StraightLine line = new StraightLine(rand.nextInt(20)-10);

        System.out.println("Line equation\ny = " + line.getA() + " * x");

        Point2D closestPoint = closestPointToPlayer(set, N, line);

        if (closestPoint != null) {
            System.out.println("Closest point:\nx = " + closestPoint.getX() + "\ny = " + closestPoint.getY());
        } else {
            System.out.println("No obstacle on the line");
        }
    }

    public static List<Point2D> generateSet(int N) {
        Random rand = new Random();
        List<Point2D> set = new ArrayList<>();
        for (int i=0;i<N;i++) {
            Point2D point = new Point2D.Double(rand.nextDouble(100)-50, rand.nextDouble(100)-50);
            point.setLocation(Math.floor(point.getX()), Math.floor(point.getY()));
            set.add(point);
            // System.out.println("\nPoint " + i + ":\nx = " + set.get(i).getX() + "\ny = " + set.get(i).getY());
        }

        return set;
    }

    public static Point2D closestPointToPlayer(List<Point2D> set, int N, StraightLine line) {
        List<Point2D> pointsOnLine = findPointsOnLine(set, N, line);

        if (pointsOnLine.size() == 0) {
            return null;
        } else {
            List<Point2D> pointsOnLineSorted = quicksort(pointsOnLine, 0, pointsOnLine.size()-1);
            return pointsOnLineSorted.get(0);
        }
    }

    public static List<Point2D> findPointsOnLine(List<Point2D> set, int N, StraightLine line) {
        List<Point2D> pointsOnLine = new ArrayList<>();

        for (Point2D point : set) {
            if (point.getY() == line.getA() * point.getX()) {
                pointsOnLine.add(point);
            }
        }

        return pointsOnLine;
    }

    public static List<Point2D> quicksort(List<Point2D> A, int l, int r) {
        if (l < r) {
            int s = lomutoPartioning(A, l, r);
            quicksort(A, l, s-1);
            quicksort(A, s+1, r);
        }
        return A;
    }

    public static int lomutoPartioning(List<Point2D> A, int l, int r) {
        Point2D p = A.get(l);
        int s = l;
        for (int i=l+1;i<r+1;i++) {
            if (Math.abs(A.get(i).getX()) < Math.abs(p.getX())) {
                s++;
                swap(A, s, i);
            }
        }
        swap(A, l, s);
        return s;
    }

    public static void swap(List<Point2D> A, int index1, int index2) {
        Point2D tmp = A.get(index1);
        A.set(index1, A.get(index2));
        A.set(index2, tmp);
    }
}

