import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithmCurrencyInterestFunction {

    public Currency currency = new Currency();
    public Interest interest = new Interest();

    //Chromosome2Function
    public Double calculateFitness2(Chromosome2 chromosome2){
        double fitness = 0.0;
        double prediction = 0.0;
        double sigmaError = 0.0;
        double averageError = 0.0;
        int i = 0;
        while(i< currency.value.length - 2){
            prediction =
                    chromosome2.getTheta()*2000 + (chromosome2.getThetaC1()* currency.getValue(i))
                    + (chromosome2.getThetaC2()* currency.getValue(i+1))
                    + (chromosome2.getThetaI1()* interest.getOneValue(i)*1000)
                    + (chromosome2.getThetaI2()* interest.getOneValue(i+1)*1000);
            double error = Math.abs(prediction- currency.getValue(i+2));
            sigmaError = sigmaError+error;
            i++;
        }
        averageError = sigmaError/(currency.value.length-2);
        fitness = 1/averageError;
        chromosome2.setFitness(fitness);
        return fitness;
    }

    public List<Double> testing2(Chromosome2 chromosome2){
        double sigmaErrorAbsolute = 0;
        double sigmaErrorSquared = 0;
        List<Double> predictionList = new ArrayList<>();
        double MAE = 0;
        double MSE = 0;
        double MAPD = 0;
        double sigmaError=0;
        double sigmaMAPD = 0;
        double prediction;
        int i = 0;
        while(i< currency.testing.length - 2){
            prediction =
                    chromosome2.getTheta()*2000 + (chromosome2.getThetaC1()* currency.getTesting(i))
                            + (chromosome2.getThetaC2()* currency.getTesting(i+1))
                            + (chromosome2.getThetaI1()* interest.getOneTesting(i)*1000)
                            + (chromosome2.getThetaI2()* interest.getOneTesting(i+1)*1000);
            double errorAbsolute = Math.abs(prediction - currency.testing[i + 2]);
            double errorSquared = (prediction - currency.testing[i + 2]) * (prediction - currency.testing[i + 2]);
            double errorMAPD = Math.abs((currency.testing[i + 2]-prediction)/currency.testing[i + 2]);
            predictionList.add(prediction);
            sigmaErrorAbsolute = errorAbsolute + sigmaErrorAbsolute;
            System.out.println(errorAbsolute);
            sigmaErrorSquared = errorSquared + sigmaErrorSquared;
            sigmaMAPD = sigmaMAPD+errorMAPD;
            i++;
        }
        MAPD = sigmaMAPD * 100 / (currency.testing.length-2);
        MAE = sigmaErrorAbsolute / (currency.testing.length - 2);
        MSE = sigmaErrorSquared / (currency.testing.length -2);
//        System.out.println("MAE :" + MAE);
//        System.out.println("MSE :" + MSE);
        System.out.println("MAPD: " + MAPD +"%");
        return predictionList;
    }
//    Chromosome3Function
    public Double calculateFitness3(Chromosome3 chromosome3) {
        double sigmaError = 0.0;
        double fitness = 0.0;
        double totalError = 0.0;
        int i = 0;
        while (i < currency.value.length - 3) {
            double prediction =
                    chromosome3.getTheta()*2000 + (chromosome3.getThetaC1() * currency.value[i])
                            + (chromosome3.getThetaC2() * currency.value[i + 1])
                            + (chromosome3.getThetaC3() * currency.value[i + 2])
                            + (chromosome3.getThetaI1() * interest.value[i]*1000)
                            + (chromosome3.getThetaI2() * interest.value[i + 1]*1000)
                            + (chromosome3.getThetaI3() * interest.value[i + 2]*1000);
            double error = Math.abs(prediction - currency.value[i + 3]);
            sigmaError = error + sigmaError;
            i++;
        }
        totalError = sigmaError / (currency.value.length - 3);
        fitness = 1 / totalError;
        chromosome3.setFitness(fitness);
        return fitness;
    }

    public List<Double> testingCheck3(Chromosome3 chromosome3) {
        double sigmaErrorAbsolute = 0;
        double sigmaErrorSquared = 0;
        List<Double> predictionList = new ArrayList<>();
        double MAE = 0;
        double MSE = 0;
        int i = 0;
        while (i < currency.testing.length - 3) {
            double prediction =
                    chromosome3.getTheta()*2000 + (chromosome3.getThetaC1() * currency.testing[i])
                            + (chromosome3.getThetaC2() * currency.testing[i + 1])
                            + (chromosome3.getThetaC3() * currency.testing[i + 2])
                            + (chromosome3.getThetaI1() * interest.testing[i]*1000)
                            + (chromosome3.getThetaI2() * interest.testing[i + 1]*1000)
                            + (chromosome3.getThetaI3() * interest.testing[i + 2]*1000);
            double errorAbsolute = Math.abs(prediction - currency.testing[i + 3]);
            double errorSquared = (prediction - currency.testing[i + 3]) * (prediction - currency.testing[i + 3]);
            predictionList.add(prediction);
            sigmaErrorAbsolute = errorAbsolute + sigmaErrorAbsolute;
            System.out.println(errorAbsolute);
            sigmaErrorSquared = errorSquared + sigmaErrorSquared;
            i++;
        }
        MAE = sigmaErrorAbsolute / (currency.testing.length - 3);
        MSE = sigmaErrorSquared / (currency.testing.length - 3);
        System.out.println("MAE :" + MAE);
        System.out.println("MSE :" + MSE);
        return predictionList;
    }

    //    Chromosome4Function
    public Double calculateFitness4(Chromosome4 chromosome4) {
        double sigmaError = 0.0;
        double fitness;
        double averageError;
        int i = 0;
        while (i < currency.value.length - 4) {
            double prediction =
                    chromosome4.getTheta()*2000 + (chromosome4.getThetaC1() * currency.value[i])
                            + (chromosome4.getThetaC2() * currency.value[i + 1])
                            + (chromosome4.getThetaC3() * currency.value[i + 2])
                            + (chromosome4.getThetaC4() * currency.value[i + 3])
                            + (chromosome4.getThetaI1() * interest.value[i]*1000)
                            + (chromosome4.getThetaI2() * interest.value[i + 1]*1000)
                            + (chromosome4.getThetaI3() * interest.value[i + 2]*1000)
                            + (chromosome4.getThetaI4() * currency.value[i + 3]*1000);
            double error = Math.abs(prediction - currency.value[i + 4]);
            sigmaError = error + sigmaError;
            i++;
        }
        averageError = sigmaError / (currency.value.length - 4);
        fitness = 1 / averageError;
        chromosome4.setFitness(fitness);
        return fitness;
    }
    public List<Double> testingCheck4(Chromosome4 chromosome4) {
        double sigmaErrorAbsolute = 0;
        double sigmaErrorSquared = 0;
        List<Double> predictionList = new ArrayList<>();
        double MAE;
        double MSE;
        int i = 0;
        while (i < currency.testing.length - 4) {
            double prediction =
                    chromosome4.getTheta()*2000 + (chromosome4.getThetaC1() * currency.testing[i])
                            + (chromosome4.getThetaC2() * currency.testing[i + 1])
                            + (chromosome4.getThetaC3() * currency.testing[i + 2])
                            + (chromosome4.getThetaC4() * currency.testing[i + 3])
                            + (chromosome4.getThetaI1() * interest.testing[i]*1000)
                            + (chromosome4.getThetaI2() * interest.testing[i + 1]*1000)
                            + (chromosome4.getThetaI3() * interest.testing[i + 2]*1000)
                            + (chromosome4.getThetaI4() * interest.testing[i + 3]*1000);
            double errorAbsolute = Math.abs(prediction - currency.testing[i + 4]);
            double errorSquared = (prediction - currency.testing[i + 4]) * (prediction - currency.testing[i + 4]);
            predictionList.add(prediction);
            sigmaErrorAbsolute = errorAbsolute + sigmaErrorAbsolute;
            sigmaErrorSquared = errorSquared + sigmaErrorSquared;
            i++;
        }
        MAE = sigmaErrorAbsolute / (currency.testing.length - 4);
        MSE = sigmaErrorSquared / (currency.testing.length - 4);
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
        while (i < currency.value.length - 5) {
            double prediction =
                    chromosome5.getTheta() + (chromosome5.getThetaC1() * currency.value[i])
                            + (chromosome5.getThetaC2() * currency.value[i + 1])
                            + (chromosome5.getThetaC3() * currency.value[i + 2])
                            + (chromosome5.getThetaC4() * currency.value[i + 3])
                            + (chromosome5.getThetaC5() * currency.value[i + 4])
                            + (chromosome5.getThetaI1() * interest.value[i])
                            + (chromosome5.getThetaI2() * interest.value[i + 1])
                            + (chromosome5.getThetaI3() * interest.value[i + 2])
                            + (chromosome5.getThetaI4() * currency.value[i + 3])
                            + (chromosome5.getThetaI5() * currency.value[i + 4]);
            double error = Math.abs(prediction - currency.value[i + 5]);
            sigmaError = error + sigmaError;
            i++;
        }
        totalError = sigmaError / (currency.value.length - 5);
        fitness = 1 / totalError;
        chromosome5.setFitness(fitness);
        return fitness;
    }

    public List<Double> testingCheck5(Chromosome5 chromosome5) {
        double sigmaErrorAbsolute = 0;
        double sigmaErrorSquared = 0;
        List<Double> predictionList = new ArrayList<>();
        double MAE = 0;
        double MSE = 0;
        int i = 0;
        while (i < currency.testing.length - 5) {
            double prediction =
                    chromosome5.getTheta() + (chromosome5.getThetaC1() * currency.testing[i])
                            + (chromosome5.getThetaC2() * currency.testing[i + 1])
                            + (chromosome5.getThetaC3() * currency.testing[i + 2])
                            + (chromosome5.getThetaC4() * currency.testing[i + 3])
                            + (chromosome5.getThetaC5() * currency.testing[i + 4])
                            + (chromosome5.getThetaI1() * interest.testing[i])
                            + (chromosome5.getThetaI2() * interest.testing[i + 1])
                            + (chromosome5.getThetaI3() * interest.testing[i + 2])
                            + (chromosome5.getThetaI4() * interest.testing[i + 3])
                            + (chromosome5.getThetaI5() * interest.testing[i + 4]);
            double errorAbsolute = Math.abs(prediction - currency.testing[i + 5]);
            double errorSquared = (prediction - currency.testing[i + 5]) * (prediction - currency.testing[i + 5]);
            predictionList.add(prediction);
            sigmaErrorAbsolute = errorAbsolute + sigmaErrorAbsolute;
            sigmaErrorSquared = errorSquared + sigmaErrorSquared;
            i++;
        }
        MAE = sigmaErrorAbsolute / (currency.testing.length - 5);
        MSE = sigmaErrorSquared / (currency.testing.length - 5);
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
        while (i < currency.value.length - 6) {
            double prediction =
                    chromosome6.getTheta() + (chromosome6.getThetaC1() * currency.value[i])
                            + (chromosome6.getThetaC2() * currency.value[i + 1])
                            + (chromosome6.getThetaC3() * currency.value[i + 2])
                            + (chromosome6.getThetaC4() * currency.value[i + 3])
                            + (chromosome6.getThetaC5() * currency.value[i + 4])
                            + (chromosome6.getThetaC6() * currency.value[i + 5])
                            + (chromosome6.getThetaI1() * interest.value[i])
                            + (chromosome6.getThetaI2() * interest.value[i + 1])
                            + (chromosome6.getThetaI3() * interest.value[i + 2])
                            + (chromosome6.getThetaI4() * currency.value[i + 3])
                            + (chromosome6.getThetaI5() * currency.value[i + 4])
                            + (chromosome6.getThetaI6() * currency.value[i + 5]);
            double error = Math.abs(prediction - currency.value[i + 6]);
            sigmaError = error + sigmaError;
            i++;
        }
        totalError = sigmaError / (currency.value.length - 6);
        fitness = 1 / totalError;
        chromosome6.setFitness(fitness);
        return fitness;
    }
    public List<Double> testingCheck6(Chromosome6 chromosome6) {
        double sigmaErrorAbsolute = 0;
        double sigmaErrorSquared = 0;
        List<Double> predictionList = new ArrayList<>();
        double MAE = 0;
        double MSE = 0;
        int i = 0;
        while (i < currency.testing.length - 6) {
            double prediction =
                    chromosome6.getTheta() + (chromosome6.getThetaC1() * currency.testing[i])
                            + (chromosome6.getThetaC2() * currency.testing[i + 1])
                            + (chromosome6.getThetaC3() * currency.testing[i + 2])
                            + (chromosome6.getThetaC4() * currency.testing[i + 3])
                            + (chromosome6.getThetaC5() * currency.testing[i + 4])
                            + (chromosome6.getThetaC6() * currency.testing[i + 5])
                            + (chromosome6.getThetaI1() * interest.testing[i])
                            + (chromosome6.getThetaI2() * interest.testing[i + 1])
                            + (chromosome6.getThetaI3() * interest.testing[i + 2])
                            + (chromosome6.getThetaI4() * interest.testing[i + 3])
                            + (chromosome6.getThetaI5() * interest.testing[i + 4])
                            + (chromosome6.getThetaI6() * interest.testing[i + 5]);
            double errorAbsolute = Math.abs(prediction - currency.testing[i + 6]);
            double errorSquared = (prediction - currency.testing[i + 6]) * (prediction - currency.testing[i + 6]);
            predictionList.add(prediction);
            sigmaErrorAbsolute = errorAbsolute + sigmaErrorAbsolute;
            sigmaErrorSquared = errorSquared + sigmaErrorSquared;
            i++;
        }
        MAE = sigmaErrorAbsolute / (currency.testing.length - 6);
        MSE = sigmaErrorSquared / (currency.testing.length - 6);
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
    while (i < currency.value.length - 7) {
        double prediction =
                chromosome7.getTheta() + (chromosome7.getThetaC1() * currency.value[i])
                        + (chromosome7.getThetaC2() * currency.value[i + 1])
                        + (chromosome7.getThetaC3() * currency.value[i + 2])
                        + (chromosome7.getThetaC4() * currency.value[i + 3])
                        + (chromosome7.getThetaC5() * currency.value[i + 4])
                        + (chromosome7.getThetaC6() * currency.value[i + 5])
                        + (chromosome7.getThetaC7() * currency.value[i + 6])
                        + (chromosome7.getThetaI1() * interest.value[i])
                        + (chromosome7.getThetaI2() * interest.value[i + 1])
                        + (chromosome7.getThetaI3() * interest.value[i + 2])
                        + (chromosome7.getThetaI4() * currency.value[i + 3])
                        + (chromosome7.getThetaI5() * currency.value[i + 4])
                        + (chromosome7.getThetaI6() * currency.value[i + 5])
                        + (chromosome7.getThetaI7() * currency.value[i + 6]);
        double error = Math.abs(prediction - currency.value[i + 7]);
        sigmaError = error + sigmaError;
        i++;
    }
    totalError = sigmaError / (currency.value.length - 7);
    fitness = 1 / totalError;
    chromosome7.setFitness(fitness);
    return fitness;
}
    public List<Double> testingCheck7(Chromosome7 chromosome7) {
        double sigmaErrorAbsolute = 0;
        double sigmaErrorSquared = 0;
        List<Double> predictionList = new ArrayList<>();
        double MAE = 0;
        double MSE = 0;
        int i = 0;
        while (i < currency.testing.length - 7) {
            double prediction =
                    chromosome7.getTheta() + (chromosome7.getThetaC1() * currency.testing[i])
                            + (chromosome7.getThetaC2() * currency.testing[i + 1])
                            + (chromosome7.getThetaC3() * currency.testing[i + 2])
                            + (chromosome7.getThetaC4() * currency.testing[i + 3])
                            + (chromosome7.getThetaC5() * currency.testing[i + 4])
                            + (chromosome7.getThetaC6() * currency.testing[i + 5])
                            + (chromosome7.getThetaC7() * currency.testing[i + 6])
                            + (chromosome7.getThetaI1() * interest.testing[i])
                            + (chromosome7.getThetaI2() * interest.testing[i + 1])
                            + (chromosome7.getThetaI3() * interest.testing[i + 2])
                            + (chromosome7.getThetaI4() * interest.testing[i + 3])
                            + (chromosome7.getThetaI5() * interest.testing[i + 4])
                            + (chromosome7.getThetaI6() * interest.testing[i + 5])
                            + (chromosome7.getThetaI7() * interest.testing[i + 6]);
            double errorAbsolute = Math.abs(prediction - currency.testing[i + 7]);
            double errorSquared = (prediction - currency.testing[i + 7]) * (prediction - currency.testing[i + 7]);
            predictionList.add(prediction);
            sigmaErrorAbsolute = errorAbsolute + sigmaErrorAbsolute;
            sigmaErrorSquared = errorSquared + sigmaErrorSquared;
            i++;
        }
        MAE = sigmaErrorAbsolute / (currency.testing.length - 7);
        MSE = sigmaErrorSquared / (currency.testing.length - 7);
        System.out.println("MAE :" + MAE);
        System.out.println("MSE :" + MSE);
        return predictionList;
    }
}
