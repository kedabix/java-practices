package semester1.practice08.block5;

import java.util.Locale;

public class WeightedGradeSheet extends GradeSheet {
    private double[] weights;

    public WeightedGradeSheet(String studentName, int[] grades, double[] weights) {
        super(studentName, grades);
        // Масив ваг має бути тієї ж довжини, що й оцінки; зайвих немає - ставимо 1.0
        this.weights = new double[grades.length];
        for (int i = 0; i < this.weights.length; i++) {
            if (i < weights.length) {
                this.weights[i] = weights[i];
            } else {
                this.weights[i] = 1.0;
            }
        }
    }

    // Зважене середнє: сума(оцінка * вага) / сума(ваг)
    @Override
    public double calculateScore() {
        double sumGrades = 0;
        double sumWeights = 0;
        for (int i = 0; i < grades.length; i++) {
            sumGrades += grades[i] * weights[i];
            sumWeights += weights[i];
        }
        return sumGrades / sumWeights;
    }

    @Override
    public String toString() {
        String w = "[";
        for (int i = 0; i < weights.length; i++) {
            w += weights[i];
            if (i < weights.length - 1) {
                w += ", ";
            }
        }
        w += "]";
        return String.format(Locale.US, "WeightedGradeSheet{student='%s', grades=%s, weights=%s, звичайний=%.2f, зважений=%.2f}",
                getStudentName(), gradesToString(), w, calculateAverage(), calculateScore());
    }
}
