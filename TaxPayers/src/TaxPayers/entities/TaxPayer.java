package TaxPayers.entities;

public class TaxPayer {

    private final Double salaryIncome;
    private final Double servicesIncome;
    private final Double capitalIncome;
    private final Double healthSpending;
    private final Double educationSpending;

    public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending, Double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double salaryTax(){
        double tax;
        if (salaryIncome < 3000){
            tax = 0.0;
        } else if (salaryIncome >= 3000 && salaryIncome < 5000) {
            tax = salaryIncome * 0.10;
        } else {
            tax = salaryIncome * 0.20;
        }
        return tax;
    }

    public double servicesTax(){
        return servicesIncome * 0.15;
    }

    public double capitalTax(){
        return  capitalIncome * 0.20;
    }

    public double grossTax(){
        return salaryTax() + servicesTax() + capitalTax();
    }

    public double taxRebate(){
        double rateTax = grossTax() * 0.30;
        double expenses = educationSpending + healthSpending;
        return Math.min(rateTax, expenses);
    }

    public double netTax(){
        return grossTax() - taxRebate();
    }

    public String toString(){
        return String.format(
                "Imposto bruto total: %.2f\nAbatimento: %.2f\nImposto devido: %.2f\n",
                grossTax(), taxRebate(), netTax()
        );
    }
}
