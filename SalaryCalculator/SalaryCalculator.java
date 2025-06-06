public class SalaryCalculator {
    public static final double  baseSalary = 1000;
    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped >=5 ? 0.85 : 1.0;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold >= 20 ? 13: 10;
    }

    public double bonusForProductsSold(int productsSold) {
        double result = (double)productsSold * bonusMultiplier(productsSold);
        return result;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double result = (baseSalary*salaryMultiplier(daysSkipped))+bonusForProductsSold(productsSold);
        return result > 2000.00 ? 2000.00 : result;
    } 
}
