package ru.levelup.at.java.operators.conditionals;

public class SwitchDemo {

    public static void main(String[] args) {
        int[] testScores = {91, 50, 68, 45, 70, 85};

        for (int testScore : testScores) {
            char grade;
            switch (testScore) {
                case 100:
                case 99:
                case 98:
                case 97:
                case 96:
                case 95:
                case 94:
                case 93:
                case 92:
                case 91:
                case 90:
                    grade = 'A';
                    break;
                case 89:
                case 88:
                case 87:
                case 86:
                case 85:
                case 84:
                case 83:
                case 82:
                case 81:
                case 80:
                    grade = 'B';
                    break;

                default:
                    grade = 'C';
                    break;
            }
        }
    }
}
