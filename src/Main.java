import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        double alpha = 0.2;
        int crossoverPoint = 3;
        long startTime = System.nanoTime();
        int slidingWindow = 2;
        int i = 0;
        int population = 100;
        int selection = 80;
        Double mutationProbability = 0.8;
        int generation = 100;
        if (slidingWindow == 2) {
            System.out.println("Sliding Window 2, Prediksi dollar");
            Chromosome2 solution;
            List<Chromosome2> matingPool = new ArrayList<>();
            List<Chromosome2> selectedChromosomes;
            List<Chromosome2> offsprings;
            List<Double> predictionList;
            //Initialization
            GeneticAlgorithmGeneralFunctionChromosome2 generalFunction = new GeneticAlgorithmGeneralFunctionChromosome2();
            GeneticAlgorithmCurrencyInterestFunction dollarFunction = new GeneticAlgorithmCurrencyInterestFunction();
            //Population Init
            List<Chromosome2> chromosome2List = generalFunction.initializePopulation(population);
            while (i <= generation) {
                System.out.println("Generasi " + i);
                selectedChromosomes = generalFunction.rouletteWheelSelection(chromosome2List, selection);
                offsprings = generalFunction.simpleArithmeticCrossover(selectedChromosomes, alpha, crossoverPoint);
                generalFunction.insert(matingPool, offsprings);
                generalFunction.insert(matingPool, chromosome2List);
                generalFunction.mutation(matingPool, mutationProbability);
                generalFunction.calculateFitness(matingPool);
                generalFunction.generationUpdate(matingPool, population);
                generalFunction.equalList(chromosome2List, matingPool);
                matingPool.clear();
                solution = generalFunction.findSolution(chromosome2List);
//                System.out.println("Paling gede : " + solution.getFitness());
                i++;
            }
            solution = generalFunction.findSolution(chromosome2List);
//                generalFunction.showSolution(solution);
            predictionList = dollarFunction.testing2(solution);
//            for (Double prediction : predictionList
//                    ) {
//                System.out.println(prediction);
//            }
            Chart chart = new Chart("Dollar Prediction"+ " " + generation+" Generasi " + slidingWindow + " Window", "Dollar Prediction", predictionList, Currency.testingChart);
            chart.runChart(chart);
        }
        if (slidingWindow == 3) {
            System.out.println("Sliding Window 3, Prediksi dollar");
            Chromosome3 solution;
            List<Chromosome3> matingPool = new ArrayList<>();
            List<Chromosome3> selectedChromosomes;
            List<Chromosome3> offsprings;
            List<Double> predictionList;
            //Initialization
            GeneticAlgorithmGeneralFunctionChromosome3 generalFunction = new GeneticAlgorithmGeneralFunctionChromosome3();
            GeneticAlgorithmCurrencyInterestFunction dollarFunction = new GeneticAlgorithmCurrencyInterestFunction();
            //Population Init
            List<Chromosome3> chromosome3List = generalFunction.initializePopulation(population);
            while (i <= generation) {
                System.out.println("Generasi " + i);
                selectedChromosomes = generalFunction.rouletteWheelSelection(chromosome3List, selection);
                offsprings = generalFunction.simpleArithmeticCrossover(selectedChromosomes, alpha, crossoverPoint);
                generalFunction.insert(matingPool, offsprings);
                generalFunction.insert(matingPool, chromosome3List);
                generalFunction.mutation(matingPool, mutationProbability);
                generalFunction.calculateFitness(matingPool);
                generalFunction.generationUpdate(matingPool, population);
                generalFunction.equalList(chromosome3List, matingPool);
                matingPool.clear();
                solution = generalFunction.findSolution(chromosome3List);
                System.out.println("Paling gede : " + solution.getFitness());
                i++;
            }
            solution = generalFunction.findSolution(chromosome3List);
            generalFunction.showSolution(solution);
            predictionList = dollarFunction.testingCheck3(solution);
//            for (Double prediction: predictionList
//                 ) {
//                System.out.println(prediction);
//            }
//        Chart
            Chart chart = new Chart("Dollar Prediction" + " " + generation + " Generasi " + slidingWindow + " Window", "Dollar Prediction", predictionList, Currency.getForTestingTable());
            chart.runChart(chart);

        } else if (slidingWindow == 4) {
            System.out.println("Sliding Window 4, Prediksi dollar");
            Chromosome4 solution;
            List<Chromosome4> matingPool = new ArrayList<>();
            List<Chromosome4> selectedChromosomes;
            List<Chromosome4> offsprings;
            List<Double> predictionList;
            //Initialization
            GeneticAlgorithmGeneralFunctionChromosome4 generalFunction4 = new GeneticAlgorithmGeneralFunctionChromosome4();
            GeneticAlgorithmCurrencyInterestFunction dollarFunction = new GeneticAlgorithmCurrencyInterestFunction();
            //Population Init
            List<Chromosome4> chromosome4List = generalFunction4.initializePopulation(population);
            while (i <= generation) {
                System.out.println("Generasi " + i);
                selectedChromosomes = generalFunction4.rouletteWheelSelection(chromosome4List, selection);
                offsprings = generalFunction4.simpleArithmeticCrossover(selectedChromosomes, alpha, crossoverPoint);
                generalFunction4.insert(matingPool, offsprings);
                generalFunction4.insert(matingPool, chromosome4List);
                generalFunction4.mutation(matingPool, mutationProbability);
                generalFunction4.calculateFitness(matingPool);
                generalFunction4.generationUpdate(matingPool, population);
                generalFunction4.equalList(chromosome4List, matingPool);
                matingPool.clear();
                for (Chromosome4 chromosome : chromosome4List) {
//                    System.out.println("Fitnessnya: " + chromosome.getFitness());
                }
                solution = generalFunction4.findSolution(chromosome4List);
                System.out.println("Paling gede : " + solution.getFitness());
                i++;
            }
            solution = generalFunction4.findSolution(chromosome4List);
            generalFunction4.showSolution(solution);
            predictionList = dollarFunction.testingCheck4(solution);
//            System.out.println("PREDICTION");
//        Chart
//            Chart chart = new Chart("Dollar Prediction"+ " " + generation+" Generasi " + slidingWindow + " Window", "Dollar Prediction", predictionList, Currency.getTesting());
//            chart.runChart(chart);

        } else if (slidingWindow == 5) {
            System.out.println("Sliding Window 5, Prediksi dollar");
            Chromosome5 solution;
            List<Chromosome5> matingPool = new ArrayList<>();
            List<Chromosome5> selectedChromosomes;
            List<Chromosome5> offsprings;
            List<Double> predictionList;
            //Initialization
            GeneticAlgorithmGeneralFunctionChromosome5 generalFunction5 = new GeneticAlgorithmGeneralFunctionChromosome5();
            GeneticAlgorithmCurrencyInterestFunction dollarFunction = new GeneticAlgorithmCurrencyInterestFunction();
            //Population Init
            List<Chromosome5> chromosome5List = generalFunction5.initializePopulation(population);
            while (i <= generation) {
                System.out.println("Generasi " + i);
                selectedChromosomes = generalFunction5.rouletteWheelSelection(chromosome5List, selection);
                offsprings = generalFunction5.simpleArithmeticCrossover(selectedChromosomes, alpha, crossoverPoint);
                generalFunction5.insert(matingPool, offsprings);
                generalFunction5.insert(matingPool, chromosome5List);
                generalFunction5.mutation(matingPool, mutationProbability);
                generalFunction5.calculateFitness(matingPool);
                generalFunction5.generationUpdate(matingPool, population);
                generalFunction5.equalList(chromosome5List, matingPool);
                matingPool.clear();
                for (Chromosome5 chromosome : chromosome5List) {
                    System.out.println("Fitnessnya: " + chromosome.getFitness());
                }
                solution = generalFunction5.findSolution(chromosome5List);
                System.out.println("Paling gede : " + solution.getFitness());
                i++;
            }
            solution = generalFunction5.findSolution(chromosome5List);
            generalFunction5.showSolution(solution);
            predictionList = dollarFunction.testingCheck5(solution);
            System.out.println("PREDICTION");
            for (double pred : predictionList
                    ) {
//                System.out.println(pred);
            }
//        Chart
//            Chart chart = new Chart("Dollar Prediction"+ " " + generation+" Generasi " + slidingWindow + " Window", "Dollar Prediction", predictionList, Currency.getTesting());
//            chart.runChart(chart);
        } else if (slidingWindow == 6) {
            System.out.println("Sliding Window 6, Prediksi dollar");
            Chromosome6 solution;
            List<Chromosome6> matingPool = new ArrayList<>();
            List<Chromosome6> selectedChromosomes;
            List<Chromosome6> offsprings;
            List<Double> predictionList;
            //Initialization
            GeneticAlgorithmGeneralFunctonChromosome6 generalFunction6 = new GeneticAlgorithmGeneralFunctonChromosome6();
            GeneticAlgorithmCurrencyInterestFunction dollarFunction = new GeneticAlgorithmCurrencyInterestFunction();
            //Population Init
            List<Chromosome6> chromosome6List = generalFunction6.initializePopulation(population);
            while (i <= generation) {
                System.out.println("Generasi " + i);
                selectedChromosomes = generalFunction6.rouletteWheelSelection(chromosome6List, selection);
                offsprings = generalFunction6.simpleArithmeticCrossover(selectedChromosomes, alpha, crossoverPoint);
                generalFunction6.insert(matingPool, offsprings);
                generalFunction6.insert(matingPool, chromosome6List);
                generalFunction6.mutation(matingPool, mutationProbability);
                generalFunction6.calculateFitness(matingPool);
                generalFunction6.generationUpdate(matingPool, population);
                generalFunction6.equalList(chromosome6List, matingPool);
                matingPool.clear();
                for (Chromosome6 chromosome : chromosome6List) {
                    System.out.println("Fitnessnya: " + chromosome.getFitness());
                }
                solution = generalFunction6.findSolution(chromosome6List);
                System.out.println("Paling gede : " + solution.getFitness());
                i++;
            }
            solution = generalFunction6.findSolution(chromosome6List);
            generalFunction6.showSolution(solution);
            predictionList = dollarFunction.testingCheck6(solution);
//            System.out.println("PREDICTION");
//            for (double pred : predictionList
//                    ) {
//                System.out.println(pred);
//            }
//        Chart
//            Chart chart = new Chart("Dollar Prediction"+ " " + generation+" Generasi " + slidingWindow + " Window", "Dollar Prediction", predictionList, Currency.getTesting());
//            chart.runChart(chart);
        } else if (slidingWindow == 7) {
            System.out.println("Sliding Window 7, Prediksi dollar");
            Chromosome7 solution;
            List<Chromosome7> matingPool = new ArrayList<>();
            List<Chromosome7> selectedChromosomes;
            List<Chromosome7> offsprings;
            List<Double> predictionList;
            //Initialization
            GeneticAlgorithmGeneralFunctonChromosome7 generalFunction7 = new GeneticAlgorithmGeneralFunctonChromosome7();
            GeneticAlgorithmCurrencyInterestFunction dollarFunction = new GeneticAlgorithmCurrencyInterestFunction();
            //Population Init
            List<Chromosome7> chromosome7List = generalFunction7.initializePopulation(population);
            while (i <= generation) {
                System.out.println("Generasi " + i);
                selectedChromosomes = generalFunction7.rouletteWheelSelection(chromosome7List, selection);
                offsprings = generalFunction7.simpleArithmeticCrossover(selectedChromosomes, alpha, crossoverPoint);
                generalFunction7.insert(matingPool, offsprings);
                generalFunction7.insert(matingPool, chromosome7List);
                generalFunction7.mutation(matingPool, mutationProbability);
                generalFunction7.calculateFitness(matingPool);
                generalFunction7.generationUpdate(matingPool, population);
                generalFunction7.equalList(chromosome7List, matingPool);
                matingPool.clear();
                for (Chromosome7 chromosome : chromosome7List) {
                    System.out.println("Fitnessnya: " + chromosome.getFitness());
                }
                solution = generalFunction7.findSolution(chromosome7List);
                System.out.println("Paling gede : " + solution.getFitness());
                i++;
            }
            solution = generalFunction7.findSolution(chromosome7List);
            generalFunction7.showSolution(solution);
            predictionList = dollarFunction.testingCheck7(solution);
//            System.out.println("PREDICTION");
//            for (double pred : predictionList
//                    ) {
//                System.out.println(pred);
//            }
//        Chart
//            Chart chart = new Chart("Dollar Prediction"+ " " + generation+" Generasi " + slidingWindow + " Window", "Dollar Prediction", predictionList, Currency.getTesting());
//            chart.runChart(chart);
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Runtime: " + totalTime);
    }
}

