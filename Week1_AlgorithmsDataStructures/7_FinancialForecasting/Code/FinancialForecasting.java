import java.util.Scanner;
public class FinancialForecasting{
    public static double calculateAverageGrowthRate(double[] pastData) {
        double totalGrowth = 0;
        for (int i = 1; i < pastData.length; i++) {
            double growth = (pastData[i] - pastData[i - 1]) / pastData[i - 1];
            totalGrowth += growth;
        }
        return totalGrowth / (pastData.length - 1);
    }
    public static double predictFutureValue(double currentValue, double averageGrowthRate, int remainingPeriods) {
        if (remainingPeriods == 0) return currentValue;
        double nextValue = currentValue * (1 + averageGrowthRate);
        return predictFutureValue(nextValue, averageGrowthRate, remainingPeriods - 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of past data points: ");
        int n = scanner.nextInt();
        double[] pastData = new double[n];
        System.out.println("Enter past data values:");
        for (int i = 0; i < n; i++)  pastData[i] = scanner.nextDouble();
        double averageGrowthRate = calculateAverageGrowthRate(pastData);
        double presentValue = pastData[n - 1];
        System.out.print("Enter number of future periods to predict: ");
        int futurePeriods = scanner.nextInt();
        double futureValue = predictFutureValue(presentValue, averageGrowthRate, futurePeriods);
        System.out.println("The predicted future value after " + futurePeriods + " periods is: " + futureValue);
    }
}
