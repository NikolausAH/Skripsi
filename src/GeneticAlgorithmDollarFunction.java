import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithmDollarFunction {

    public DollarToRupiah dollarToRupiah;
    public DollarInterest dollarInterest;

//    Chromosome3Function
    public Double calculateFitness3(Chromosome3 chromosome3) {
        double sigmaError = 0.0;
        double fitness = 0.0;
        double totalError = 0.0;
        int i = 0;
        while (i < dollarToRupiah.value.length - 3) {
            double prediction =
                    chromosome3.getTheta() + (chromosome3.getThetaC1() * dollarToRupiah.value[i])
                            + (chromosome3.getThetaC2() * dollarToRupiah.value[i + 1])
                            + (chromosome3.getThetaC3() * dollarToRupiah.value[i + 2])
                            + (chromosome3.getThetaI1() * dollarInterest.value[i])
                            + (chromosome3.getThetaI2() * dollarInterest.value[i + 1])
                            + (chromosome3.getThetaI3() * dollarInterest.value[i + 2]);
            double error = Math.abs(prediction - dollarToRupiah.value[i + 3]);
            sigmaError = error + sigmaError;
            i++;
        }
        totalError = sigmaError / (dollarToRupiah.value.length - 3);
        fitness = 1 / totalError;
        chromosome3.setFitness(fitness);
        return fitness;
    }

    public List<Double> validationCheck3(Chromosome3 chromosome3) {
        double sigmaErrorAbsolute = 0;
        double sigmaErrorSquared = 0;
        List<Double> predictionList = new ArrayList<>();
        double MAE = 0;
        double MSE = 0;
        int i = 0;
        while (i < dollarToRupiah.validation.length - 3) {
            double prediction =
                    chromosome3.getTheta() + (chromosome3.getThetaC1() * dollarToRupiah.validation[i])
                            + (chromosome3.getThetaC2() * dollarToRupiah.validation[i + 1])
                            + (chromosome3.getThetaC3() * dollarToRupiah.validation[i + 2])
                            + (chromosome3.getThetaI1() * dollarInterest.validation[i])
                            + (chromosome3.getThetaI2() * dollarInterest.validation[i + 1])
                            + (chromosome3.getThetaI3() * dollarInterest.validation[i + 2]);
            double errorAbsolute = Math.abs(prediction - dollarToRupiah.validation[i + 3]);
            double errorSquared = (prediction - dollarToRupiah.validation[i + 3]) * (prediction - dollarToRupiah.validation[i + 3]);
            predictionList.add(prediction);
            sigmaErrorAbsolute = errorAbsolute + sigmaErrorAbsolute;
            sigmaErrorSquared = errorSquared + sigmaErrorSquared;
            i++;
        }
        MAE = sigmaErrorAbsolute / (dollarToRupiah.validation.length - 3);
        MSE = sigmaErrorSquared / (dollarToRupiah.validation.length - 3);
        System.out.println("MAE :" + MAE);
        System.out.println("MSE :" + MSE);
        return predictionList;
    }

    //    Chromosome4Function
    public Double calculateFitness4(Chromosome4 chromosome4) {
        double sigmaError = 0.0;
        double fitness;
        double totalError;
        int i = 0;
        while (i <= dollarToRupiah.value.length - 6) {
            double prediction =
                    chromosome4.getTheta() + (chromosome4.getThetaC1() * dollarToRupiah.value[i + 1])
                            + (chromosome4.getThetaC2() * dollarToRupiah.value[i + 2])
                            + (chromosome4.getThetaC3() * dollarToRupiah.value[i + 3])
                            + (chromosome4.getThetaC4() * dollarToRupiah.value[i + 4])
                            + (chromosome4.getThetaI1() * dollarInterest.value[i + 1])
                            + (chromosome4.getThetaI2() * dollarInterest.value[i + 2])
                            + (chromosome4.getThetaI3() * dollarInterest.value[i + 3])
                            + (chromosome4.getThetaI4() * dollarToRupiah.value[i + 4]);
            double error = Math.abs(prediction - dollarToRupiah.value[i + 5]);
            sigmaError = error + sigmaError;
            i++;
        }
        totalError = sigmaError / (dollarToRupiah.value.length - 6);
        fitness = 1 / totalError;
        chromosome4.setFitness(fitness);
        return fitness;
    }
    public List<Double> validationCheck4(Chromosome4 chromosome4) {
        double sigmaErrorAbsolute = 0;
        double sigmaErrorSquared = 0;
        List<Double> predictionList = new ArrayList<>();
        double MAE;
        double MSE;
        int i = 0;
        while (i < dollarToRupiah.validation.length - 4) {
            double prediction =
                    chromosome4.getTheta() + (chromosome4.getThetaC1() * dollarToRupiah.validation[i])
                            + (chromosome4.getThetaC2() * dollarToRupiah.validation[i + 1])
                            + (chromosome4.getThetaC3() * dollarToRupiah.validation[i + 2])
                            + (chromosome4.getThetaC4() * dollarToRupiah.validation[i + 3])
                            + (chromosome4.getThetaI1() * dollarInterest.validation[i])
                            + (chromosome4.getThetaI2() * dollarInterest.validation[i + 1])
                            + (chromosome4.getThetaI3() * dollarInterest.validation[i + 2])
                            + (chromosome4.getThetaI4() * dollarInterest.validation[i + 3]);
            double errorAbsolute = Math.abs(prediction - dollarToRupiah.validation[i + 4]);
            double errorSquared = (prediction - dollarToRupiah.validation[i + 4]) * (prediction - dollarToRupiah.validation[i + 4]);
            predictionList.add(prediction);
            sigmaErrorAbsolute = errorAbsolute + sigmaErrorAbsolute;
            sigmaErrorSquared = errorSquared + sigmaErrorSquared;
            i++;
        }
        MAE = sigmaErrorAbsolute / (dollarToRupiah.validation.length - 4);
        MSE = sigmaErrorSquared / (dollarToRupiah.validation.length - 4);
        System.out.println("MAE :" + MAE);
        System.out.println("MSE :" + MSE);
        return predictionList;
    }

    //    Chromosome5Function
    public Double calculateFitness5(Chromosome5 chromosome5) {
        double sigmaError = 0.0;
        double fitness = 0.0;
        double totalError = 0.0;
        int i = 0;
        while (i < dollarToRupiah.value.length - 5) {
            double prediction =
                    chromosome5.getTheta() + (chromosome5.getThetaC1() * dollarToRupiah.value[i])
                            + (chromosome5.getThetaC2() * dollarToRupiah.value[i + 1])
                            + (chromosome5.getThetaC3() * dollarToRupiah.value[i + 2])
                            + (chromosome5.getThetaC4() * dollarToRupiah.value[i + 3])
                            + (chromosome5.getThetaC5() * dollarToRupiah.value[i + 4])
                            + (chromosome5.getThetaI1() * dollarInterest.value[i])
                            + (chromosome5.getThetaI2() * dollarInterest.value[i + 1])
                            + (chromosome5.getThetaI3() * dollarInterest.value[i + 2])
                            + (chromosome5.getThetaI4() * dollarToRupiah.value[i + 3])
                            + (chromosome5.getThetaI5() * dollarToRupiah.value[i + 4]);
            double error = Math.abs(prediction - dollarToRupiah.value[i + 5]);
            sigmaError = error + sigmaError;
            i++;
        }
        totalError = sigmaError / (dollarToRupiah.value.length - 5);
        fitness = 1 / totalError;
        chromosome5.setFitness(fitness);
        return fitness;
    }

    public List<Double> validationCheck5(Chromosome5 chromosome5) {
        double sigmaErrorAbsolute = 0;
        double sigmaErrorSquared = 0;
        List<Double> predictionList = new ArrayList<>();
        double MAE = 0;
        double MSE = 0;
        int i = 0;
        while (i < dollarToRupiah.validation.length - 5) {
            double prediction =
                    chromosome5.getTheta() + (chromosome5.getThetaC1() * dollarToRupiah.validation[i])
                            + (chromosome5.getThetaC2() * dollarToRupiah.validation[i + 1])
                            + (chromosome5.getThetaC3() * dollarToRupiah.validation[i + 2])
                            + (chromosome5.getThetaC4() * dollarToRupiah.validation[i + 3])
                            + (chromosome5.getThetaC5() * dollarToRupiah.validation[i + 4])
                            + (chromosome5.getThetaI1() * dollarInterest.validation[i])
                            + (chromosome5.getThetaI2() * dollarInterest.validation[i + 1])
                            + (chromosome5.getThetaI3() * dollarInterest.validation[i + 2])
                            + (chromosome5.getThetaI4() * dollarInterest.validation[i + 3])
                            + (chromosome5.getThetaI5() * dollarInterest.validation[i + 4]);
            double errorAbsolute = Math.abs(prediction - dollarToRupiah.validation[i + 5]);
            double errorSquared = (prediction - dollarToRupiah.validation[i + 5]) * (prediction - dollarToRupiah.validation[i + 5]);
            predictionList.add(prediction);
            sigmaErrorAbsolute = errorAbsolute + sigmaErrorAbsolute;
            sigmaErrorSquared = errorSquared + sigmaErrorSquared;
            i++;
        }
        MAE = sigmaErrorAbsolute / (dollarToRupiah.validation.length - 5);
        MSE = sigmaErrorSquared / (dollarToRupiah.validation.length - 5);
        System.out.println("MAE :" + MAE);
        System.out.println("MSE :" + MSE);
        return predictionList;
    }
    //    Chromosome6Function
    public Double calculateFitness6(Chromosome6 chromosome6) {
        double sigmaError = 0.0;
        double fitness = 0.0;
        double totalError = 0.0;
        int i = 0;
        while (i < dollarToRupiah.value.length - 6) {
            double prediction =
                    chromosome6.getTheta() + (chromosome6.getThetaC1() * dollarToRupiah.value[i])
                            + (chromosome6.getThetaC2() * dollarToRupiah.value[i + 1])
                            + (chromosome6.getThetaC3() * dollarToRupiah.value[i + 2])
                            + (chromosome6.getThetaC4() * dollarToRupiah.value[i + 3])
                            + (chromosome6.getThetaC5() * dollarToRupiah.value[i + 4])
                            + (chromosome6.getThetaC6() * dollarToRupiah.value[i + 5])
                            + (chromosome6.getThetaI1() * dollarInterest.value[i])
                            + (chromosome6.getThetaI2() * dollarInterest.value[i + 1])
                            + (chromosome6.getThetaI3() * dollarInterest.value[i + 2])
                            + (chromosome6.getThetaI4() * dollarToRupiah.value[i + 3])
                            + (chromosome6.getThetaI5() * dollarToRupiah.value[i + 4])
                            + (chromosome6.getThetaI6() * dollarToRupiah.value[i + 5]);
            double error = Math.abs(prediction - dollarToRupiah.value[i + 6]);
            sigmaError = error + sigmaError;
            i++;
        }
        totalError = sigmaError / (dollarToRupiah.value.length - 6);
        fitness = 1 / totalError;
        chromosome6.setFitness(fitness);
        return fitness;
    }
    public List<Double> validationCheck6(Chromosome6 chromosome6) {
        double sigmaErrorAbsolute = 0;
        double sigmaErrorSquared = 0;
        List<Double> predictionList = new ArrayList<>();
        double MAE = 0;
        double MSE = 0;
        int i = 0;
        while (i < dollarToRupiah.validation.length - 6) {
            double prediction =
                    chromosome6.getTheta() + (chromosome6.getThetaC1() * dollarToRupiah.validation[i])
                            + (chromosome6.getThetaC2() * dollarToRupiah.validation[i + 1])
                            + (chromosome6.getThetaC3() * dollarToRupiah.validation[i + 2])
                            + (chromosome6.getThetaC4() * dollarToRupiah.validation[i + 3])
                            + (chromosome6.getThetaC5() * dollarToRupiah.validation[i + 4])
                            + (chromosome6.getThetaC6() * dollarToRupiah.validation[i + 5])
                            + (chromosome6.getThetaI1() * dollarInterest.validation[i])
                            + (chromosome6.getThetaI2() * dollarInterest.validation[i + 1])
                            + (chromosome6.getThetaI3() * dollarInterest.validation[i + 2])
                            + (chromosome6.getThetaI4() * dollarInterest.validation[i + 3])
                            + (chromosome6.getThetaI5() * dollarInterest.validation[i + 4])
                            + (chromosome6.getThetaI6() * dollarInterest.validation[i + 5]);
            double errorAbsolute = Math.abs(prediction - dollarToRupiah.validation[i + 6]);
            double errorSquared = (prediction - dollarToRupiah.validation[i + 6]) * (prediction - dollarToRupiah.validation[i + 6]);
            predictionList.add(prediction);
            sigmaErrorAbsolute = errorAbsolute + sigmaErrorAbsolute;
            sigmaErrorSquared = errorSquared + sigmaErrorSquared;
            i++;
        }
        MAE = sigmaErrorAbsolute / (dollarToRupiah.validation.length - 6);
        MSE = sigmaErrorSquared / (dollarToRupiah.validation.length - 6);
        System.out.println("MAE :" + MAE);
        System.out.println("MSE :" + MSE);
        return predictionList;
    }

//    Chromosome7Function
public Double calculateFitness7(Chromosome7 chromosome7) {
    double sigmaError = 0.0;
    double fitness = 0.0;
    double totalError = 0.0;
    int i = 0;
    while (i < dollarToRupiah.value.length - 7) {
        double prediction =
                chromosome7.getTheta() + (chromosome7.getThetaC1() * dollarToRupiah.value[i])
                        + (chromosome7.getThetaC2() * dollarToRupiah.value[i + 1])
                        + (chromosome7.getThetaC3() * dollarToRupiah.value[i + 2])
                        + (chromosome7.getThetaC4() * dollarToRupiah.value[i + 3])
                        + (chromosome7.getThetaC5() * dollarToRupiah.value[i + 4])
                        + (chromosome7.getThetaC6() * dollarToRupiah.value[i + 5])
                        + (chromosome7.getThetaC7() * dollarToRupiah.value[i + 6])
                        + (chromosome7.getThetaI1() * dollarInterest.value[i])
                        + (chromosome7.getThetaI2() * dollarInterest.value[i + 1])
                        + (chromosome7.getThetaI3() * dollarInterest.value[i + 2])
                        + (chromosome7.getThetaI4() * dollarToRupiah.value[i + 3])
                        + (chromosome7.getThetaI5() * dollarToRupiah.value[i + 4])
                        + (chromosome7.getThetaI6() * dollarToRupiah.value[i + 5])
                        + (chromosome7.getThetaI7() * dollarToRupiah.value[i + 6]);
        double error = Math.abs(prediction - dollarToRupiah.value[i + 7]);
        sigmaError = error + sigmaError;
        i++;
    }
    totalError = sigmaError / (dollarToRupiah.value.length - 7);
    fitness = 1 / totalError;
    chromosome7.setFitness(fitness);
    return fitness;
}
    public List<Double> validationCheck7(Chromosome7 chromosome7) {
        double sigmaErrorAbsolute = 0;
        double sigmaErrorSquared = 0;
        List<Double> predictionList = new ArrayList<>();
        double MAE = 0;
        double MSE = 0;
        int i = 0;
        while (i < dollarToRupiah.validation.length - 7) {
            double prediction =
                    chromosome7.getTheta() + (chromosome7.getThetaC1() * dollarToRupiah.validation[i])
                            + (chromosome7.getThetaC2() * dollarToRupiah.validation[i + 1])
                            + (chromosome7.getThetaC3() * dollarToRupiah.validation[i + 2])
                            + (chromosome7.getThetaC4() * dollarToRupiah.validation[i + 3])
                            + (chromosome7.getThetaC5() * dollarToRupiah.validation[i + 4])
                            + (chromosome7.getThetaC6() * dollarToRupiah.validation[i + 5])
                            + (chromosome7.getThetaC7() * dollarToRupiah.validation[i + 6])
                            + (chromosome7.getThetaI1() * dollarInterest.validation[i])
                            + (chromosome7.getThetaI2() * dollarInterest.validation[i + 1])
                            + (chromosome7.getThetaI3() * dollarInterest.validation[i + 2])
                            + (chromosome7.getThetaI4() * dollarInterest.validation[i + 3])
                            + (chromosome7.getThetaI5() * dollarInterest.validation[i + 4])
                            + (chromosome7.getThetaI6() * dollarInterest.validation[i + 5])
                            + (chromosome7.getThetaI7() * dollarInterest.validation[i + 6]);
            double errorAbsolute = Math.abs(prediction - dollarToRupiah.validation[i + 7]);
            double errorSquared = (prediction - dollarToRupiah.validation[i + 7]) * (prediction - dollarToRupiah.validation[i + 7]);
            predictionList.add(prediction);
            sigmaErrorAbsolute = errorAbsolute + sigmaErrorAbsolute;
            sigmaErrorSquared = errorSquared + sigmaErrorSquared;
            i++;
        }
        MAE = sigmaErrorAbsolute / (dollarToRupiah.validation.length - 7);
        MSE = sigmaErrorSquared / (dollarToRupiah.validation.length - 7);
        System.out.println("MAE :" + MAE);
        System.out.println("MSE :" + MSE);
        return predictionList;
    }
}
