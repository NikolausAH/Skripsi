import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithmGeneralFunctionChromosome2 {
    GeneticAlgorithmCurrencyInterestFunction geneticAlgorithmCurrencyInterestFunction = new GeneticAlgorithmCurrencyInterestFunction();

    public void initWeight2(Chromosome2 chromosome2) {
        chromosome2.setTheta((Math.random()) % 1);
        chromosome2.setThetaI1((Math.random()) % 1);
        chromosome2.setThetaI2((Math.random()) % 1);
        chromosome2.setThetaC1((Math.random()) % 1);
        chromosome2.setThetaC2((Math.random()) % 1);
    }



    public List<Chromosome2> initializePopulation(int quantity) {
        List<Chromosome2> chromosome2List = new ArrayList<>();
        int i = 0;
        while (i < quantity) {
            chromosome2List.add(new Chromosome2());
            initWeight2(chromosome2List.get(i));
            geneticAlgorithmCurrencyInterestFunction.calculateFitness2(chromosome2List.get(i));
            i++;
        }
        return chromosome2List;
    }

    public List<Chromosome2> simpleArithmeticCrossover(List<Chromosome2> chromosome2List, Double alpha, Integer crossoverPoint) {
        List<Chromosome2> offsprings = new ArrayList<>();
        int i = 0;
        int j = 0;
        double alphaComplement = 1 - alpha;
        int process = 0;
        while (process < chromosome2List.size()) {
            Chromosome2 chromosome2 = chromosome2List.get(i);
            if(crossoverPoint ==0) {
                chromosome2.setTheta((chromosome2List.get(i).getTheta() * alpha) + (chromosome2List.get(process + 1).getTheta() * alphaComplement));
                crossoverPoint++;
            }
            else if(crossoverPoint==1) {
                chromosome2.setThetaI1((chromosome2List.get(i).getThetaI1() * alpha) + (chromosome2List.get(process + 1).getThetaI1() * alphaComplement));
                crossoverPoint++;
            }
            else if(crossoverPoint == 2) {
                chromosome2.setThetaI2((chromosome2List.get(i).getThetaI2() * alpha) + (chromosome2List.get(process + 1).getThetaI2() * alphaComplement));
            crossoverPoint++;
            }
            else if(crossoverPoint ==3) {
                chromosome2.setThetaC1((chromosome2List.get(i).getThetaC1() * alpha) + (chromosome2List.get(process + 1).getThetaC1() * alphaComplement));
            crossoverPoint++;
            }
            else if(crossoverPoint == 4){
                chromosome2.setThetaC2((chromosome2List.get(i).getThetaC2() * alpha) + (chromosome2List.get(process + 1).getThetaC2() * alphaComplement));
            crossoverPoint++;
            }
            else{
            process += 2;
            offsprings.add(chromosome2);}
        }
        while (j < offsprings.size()) {
            geneticAlgorithmCurrencyInterestFunction.calculateFitness2(offsprings.get(j));
            j++;
        }
        return offsprings;
    }

    public void equalList(List<Chromosome2> inserted, List<Chromosome2> insert) {
        int i = 0;
        inserted.clear();
        while (i < insert.size()) {
            inserted.add(insert.get(i));
            i++;
        }
    }

    public void insert(List<Chromosome2> chromosome2s, List<Chromosome2> chromosome2Inserted) {
        int i = 0;
        while (i < chromosome2Inserted.size()) {
            chromosome2s.add(chromosome2Inserted.get(i));
            i++;
        }
    }

    public void mutation(List<Chromosome2> chromosome2s, Double mutationProb) {
        int i = 0;
        int j;
        double randomNumber;
        double mutationProbability = mutationProb;
        while (i < chromosome2s.size()) {
//                System.out.println("Chromosome sebelum mutasi "+": "+chromosome5s.get(i).getFitness());
            Chromosome2 chromosome2Before = new Chromosome2();
            chromosome2Before.setTheta(chromosome2s.get(i).getTheta());
            chromosome2Before.setThetaI1(chromosome2s.get(i).getThetaI1());
            chromosome2Before.setThetaI2(chromosome2s.get(i).getThetaI2());
            chromosome2Before.setThetaC1(chromosome2s.get(i).getThetaC1());
            chromosome2Before.setThetaC2(chromosome2s.get(i).getThetaC2());
            geneticAlgorithmCurrencyInterestFunction.calculateFitness2(chromosome2Before);
            j = 0;
            while (j < 5) {
                randomNumber = Math.random() % 1;
                if (randomNumber <= mutationProbability) {
                    if (j == 0) {
                        chromosome2s.get(i).setTheta(Math.random() % 1);
                        j++;
                    } else if (j == 1) {
                        chromosome2s.get(i).setThetaC1(Math.random() % 1);

                        j++;
                    } else if (j == 2) {
                        chromosome2s.get(i).setThetaC2(Math.random() % 1);

                        j++;
                    } else if (j == 3) {
                        chromosome2s.get(i).setThetaI1(Math.random() % 1);
                        j++;
                    } else if (j == 4) {
                        chromosome2s.get(i).setThetaI2(Math.random() % 1);
                        j++;
                    }
                }
                j++;
            }
            geneticAlgorithmCurrencyInterestFunction.calculateFitness2(chromosome2s.get(i));
            if (chromosome2s.get(i).getFitness() < chromosome2Before.getFitness()) {
                chromosome2s.get(i).setTheta(chromosome2Before.getTheta());

                chromosome2s.get(i).setThetaC1(chromosome2Before.getThetaC1());
                chromosome2s.get(i).setThetaC2(chromosome2Before.getThetaC2());
                chromosome2s.get(i).setThetaI1(chromosome2Before.getThetaI1());
                chromosome2s.get(i).setThetaI2(chromosome2Before.getThetaI2());
                geneticAlgorithmCurrencyInterestFunction.calculateFitness2(chromosome2s.get(i));
            }
            i++;
        }
    }
    public void calculateFitness(List<Chromosome2> chromosome2s) {
        int j = 0;
        while (j < chromosome2s.size()) {
            geneticAlgorithmCurrencyInterestFunction.calculateFitness2(chromosome2s.get(j));
            j++;
        }
    }
    public void generationUpdate(List<Chromosome2> chromosome2s,int population) {
        int i=0;
        int j=0;
        while(chromosome2s.size()>population){
            double lowest = chromosome2s.get(0).getFitness();
            while(i<chromosome2s.size()){
                if(lowest>chromosome2s.get(i).getFitness()){
                    lowest=chromosome2s.get(i).getFitness();
                }
                else
                    i++;
            }
            while(j<chromosome2s.size()&&chromosome2s.size()>population){
                if(lowest==chromosome2s.get(j).getFitness()){
                    chromosome2s.remove(j);
                }
                else
                    j++;
            }
            i=0;
            j=0;
        }
    }
    public Chromosome2 findSolution(List<Chromosome2> chromosome2s){
        int i = 0;
        int j=0;
        Chromosome2 solution = new Chromosome2();
        double highest = chromosome2s.get(0).getFitness();
        while(i<chromosome2s.size()){
            if(highest<chromosome2s.get(i).getFitness()){
                highest=chromosome2s.get(i).getFitness();
            }
            else
                i++;
        }
        while(j<chromosome2s.size()){
            if(highest==chromosome2s.get(j).getFitness()){
                solution=chromosome2s.get(j);
                j++;
            }
            else
                j++;
        }
        return solution;
    }
    public void showSolution(Chromosome2 solution){

        System.out.println("Solusi");
        System.out.println("Fitness :" + solution.getFitness());
        System.out.println("Theta1: " + solution.getTheta());
        System.out.println("Theta2: " + solution.getThetaC1());
        System.out.println("Theta3: " + solution.getThetaC2());
        System.out.println("Theta4: " + solution.getThetaI1());
        System.out.println("Theta5: " + solution.getThetaI2());
    }

    public List<Chromosome2> rouletteWheelSelection(List<Chromosome2> chromosome2List, int selectedQuantity) {
        int i = 0;
        int j = 0;
        int k;
        int l = 0;
        List<Chromosome2> selectedChromosomes = new ArrayList<Chromosome2>();
        double sigmaFitness = 0.0;
        double fitnessCumulative = 0.0;
        int quantity = 0;
        List<Double> fitnessList = new ArrayList<>();
        while (i < chromosome2List.size()) {
            fitnessList.add(i, chromosome2List.get(i).getFitness());
            sigmaFitness = sigmaFitness + chromosome2List.get(i).getFitness();
            i++;
        }
        while (j < fitnessList.size()) {
            chromosome2List.get(j).setLowerFitnessRange(fitnessCumulative);
            fitnessCumulative = fitnessCumulative + chromosome2List.get(j).getFitness() / sigmaFitness;
            chromosome2List.get(j).setUpperFitnessRange(fitnessCumulative);
            j++;
        }
        while (quantity < selectedQuantity) {
            double randomNumber = Math.random() % 1;
            k = 0;
            while (k < fitnessList.size()) {
                if (chromosome2List.get(k).getLowerFitnessRange() <= randomNumber
                        &&
                        chromosome2List.get(k).getUpperFitnessRange() >= randomNumber) {
                    selectedChromosomes.add(chromosome2List.get(k));
                    quantity++;
                    k = fitnessList.size();
                } else
                    k++;
            }
        }
        while (l < selectedChromosomes.size()) {
            l++;
        }
        return selectedChromosomes;
    }
}

