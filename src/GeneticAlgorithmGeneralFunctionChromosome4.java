import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithmGeneralFunctionChromosome4 {
    GeneticAlgorithmDollarFunction dollarFunction = new GeneticAlgorithmDollarFunction();

    public void initWeight4(Chromosome4 chromosome4) {
        chromosome4.setTheta((Math.random()) % 2000);
        chromosome4.setThetaI1((Math.random()) % 1);
        chromosome4.setThetaI2((Math.random()) % 1);
        chromosome4.setThetaI3((Math.random()) % 1);
        chromosome4.setThetaI4((Math.random()) % 1);
        chromosome4.setThetaC1((Math.random()) % 1000);
        chromosome4.setThetaC2((Math.random()) % 1000);
        chromosome4.setThetaC3((Math.random()) % 1000);
        chromosome4.setThetaC4((Math.random()) % 1000);
    }

    public List<Chromosome4> initializePopulation(int quantity) {
        List<Chromosome4> chromosome4List = new ArrayList<>();
        int i = 0;
        while (i < quantity) {
            chromosome4List.add(new Chromosome4());
            initWeight4(chromosome4List.get(i));
            Chromosome4 chromosome4= chromosome4List.get(i);
            dollarFunction.calculateFitness4(chromosome4);
            i++;
        }
        return chromosome4List;
    }
    public List<Chromosome4> rouletteWheelSelection(List<Chromosome4> chromosome4List, int selectedQuantity) {
        System.out.println("RWS");
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        List<Chromosome4> selectedChromosomes = new ArrayList<Chromosome4>();
        double sigmaFitness = 0.0;
        double fitnessCumulative = 0.0;
        int quantity = 0;
        List<Double> fitnessList = new ArrayList<>();
        while (i < chromosome4List.size()) {
            fitnessList.add(i, chromosome4List.get(i).getFitness());
            sigmaFitness = sigmaFitness + chromosome4List.get(i).getFitness();
            i++;
        }
        while (j < fitnessList.size()) {
            chromosome4List.get(j).setLowerFitnessRange(fitnessCumulative);
            fitnessCumulative = fitnessCumulative + chromosome4List.get(j).getFitness() / sigmaFitness;
            chromosome4List.get(j).setUpperFitnessRange(fitnessCumulative);
            j++;
        }
        while (quantity < selectedQuantity) {
            double randomNumber = Math.random() % 1;
            k = 0;
            while (k < fitnessList.size()) {
                if (chromosome4List.get(k).getLowerFitnessRange() <= randomNumber
                        &&
                        chromosome4List.get(k).getUpperFitnessRange() >= randomNumber) {
                    selectedChromosomes.add(chromosome4List.get(k));
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

    public List<Chromosome4> simpleArithmeticCrossover(List<Chromosome4> chromosome4List, Double alpha) {
        List<Chromosome4> offsprings = new ArrayList<>();
        int i = 0;
        int j = 0;
        double alphaComplement = 1 - alpha;
        int process = 0;
        while (process < chromosome4List.size()) {
            Chromosome4 chromosome4 = new Chromosome4();
            chromosome4.setTheta((chromosome4List.get(i).getTheta() * alpha) + (chromosome4List.get(process + 1).getTheta() * alphaComplement));
            chromosome4.setThetaI1((chromosome4List.get(i).getThetaI1() * alpha) + (chromosome4List.get(process + 1).getThetaI1() * alphaComplement));
            chromosome4.setThetaI2((chromosome4List.get(i).getThetaI2() * alpha) + (chromosome4List.get(process + 1).getThetaI2() * alphaComplement));
            chromosome4.setThetaI3((chromosome4List.get(i).getThetaI3() * alpha) + (chromosome4List.get(process + 1).getThetaI3() * alphaComplement));
            chromosome4.setThetaI4((chromosome4List.get(i).getThetaI4() * alpha) + (chromosome4List.get(process + 1).getThetaI4() * alphaComplement));
            chromosome4.setThetaC1((chromosome4List.get(i).getThetaC1() * alpha) + (chromosome4List.get(process + 1).getThetaC1() * alphaComplement));
            chromosome4.setThetaC2((chromosome4List.get(i).getThetaC2() * alpha) + (chromosome4List.get(process + 1).getThetaC2() * alphaComplement));
            chromosome4.setThetaC3((chromosome4List.get(i).getThetaC3() * alpha) + (chromosome4List.get(process + 1).getThetaC3() * alphaComplement));
            chromosome4.setThetaC4((chromosome4List.get(i).getThetaC4() * alpha) + (chromosome4List.get(process + 1).getThetaC4() * alphaComplement));
            process += 2;
            offsprings.add(chromosome4);
        }
        while (j < offsprings.size()) {
            dollarFunction.calculateFitness4(offsprings.get(j));
            j++;
        }
        return offsprings;
    }
    public void insert(List<Chromosome4> chromosome4s, List<Chromosome4> chromosome4Inserted) {
        int i = 0;
        while (i < chromosome4Inserted.size()) {
            chromosome4s.add(chromosome4Inserted.get(i));
            i++;
        }
    }

    public void mutation(List<Chromosome4> chromosome4s, Double mutationProb) {
        int i = 0;
        int j;
        double randomNumber ;
        double mutationProbability = mutationProb;
        while (i < chromosome4s.size()) {
//                System.out.println("Chromosome sebelum mutasi "+": "+chromosome5s.get(i).getFitness());
            Chromosome4 chromosome4Before = new Chromosome4();
            chromosome4Before.setTheta(chromosome4s.get(i).getTheta());
            chromosome4Before.setThetaI1(chromosome4s.get(i).getThetaI1());
            chromosome4Before.setThetaI2(chromosome4s.get(i).getThetaI2());
            chromosome4Before.setThetaI3(chromosome4s.get(i).getThetaI3());
            chromosome4Before.setThetaI4(chromosome4s.get(i).getThetaI4());
            chromosome4Before.setThetaC1(chromosome4s.get(i).getThetaC1());
            chromosome4Before.setThetaC2(chromosome4s.get(i).getThetaC2());
            chromosome4Before.setThetaC3(chromosome4s.get(i).getThetaC3());
            chromosome4Before.setThetaC4(chromosome4s.get(i).getThetaC4());
            dollarFunction.calculateFitness4(chromosome4Before);
            j = 0;
            while (j < 9) {
                randomNumber = Math.random() % 1;
                if (randomNumber <= mutationProbability) {
                    if (j == 0) {
                        chromosome4s.get(i).setTheta(Math.random() % 1625);
                        j++;
                    } else if (j == 1) {
                        chromosome4s.get(i).setThetaC1(Math.random() % 0.9);

                        j++;
                    } else if (j == 2) {
                        chromosome4s.get(i).setThetaC2(Math.random() % 0.9);

                        j++;
                    } else if (j == 3) {
                        chromosome4s.get(i).setThetaC3(Math.random() % 0.9);
                        j++;
                    }  else if (j == 4) {
                        chromosome4s.get(i).setThetaC4(Math.random() % 0.9);
                        j++;
                    }else if (j == 5) {
                        chromosome4s.get(i).setThetaI1(Math.random() % 900);
                        j++;
                    } else if (j == 6) {
                        chromosome4s.get(i).setThetaI2(Math.random() % 900);
                        j++;
                    } else if (j == 7) {
                        chromosome4s.get(i).setThetaI3(Math.random() % 900);
                        j++;
                    } else if (j == 8) {
                        chromosome4s.get(i).setThetaI4(Math.random() % 900);
                        j++;
                    }
                }
                j++;
            }
            dollarFunction.calculateFitness4(chromosome4s.get(i));
            if(chromosome4s.get(i).getFitness()<chromosome4Before.getFitness()) {
                chromosome4s.get(i).setTheta(chromosome4Before.getTheta());

                chromosome4s.get(i).setThetaC1(chromosome4Before.getThetaC1());
                chromosome4s.get(i).setThetaC2(chromosome4Before.getThetaC2());
                chromosome4s.get(i).setThetaC3(chromosome4Before.getThetaC3());
                chromosome4s.get(i).setThetaC4(chromosome4Before.getThetaC4());

                chromosome4s.get(i).setThetaI1(chromosome4Before.getThetaI1());
                chromosome4s.get(i).setThetaI2(chromosome4Before.getThetaI2());
                chromosome4s.get(i).setThetaI3(chromosome4Before.getThetaI3());
                chromosome4s.get(i).setThetaI4(chromosome4Before.getThetaI4());
                dollarFunction.calculateFitness4(chromosome4s.get(i));
          }
            i++;
        }

    }
    public void calculateFitness(List<Chromosome4> chromosome4s) {
        int j = 0;
        while (j < chromosome4s.size()) {
            dollarFunction.calculateFitness4(chromosome4s.get(j));
            j++;
        }
    }
    public void generationUpdate(List<Chromosome4> chromosome4s,int population) {
        int i=0;
        int j=0;
        while(chromosome4s.size()>population){
            double lowest = chromosome4s.get(0).getFitness();
            while(i<chromosome4s.size()){
                if(lowest>chromosome4s.get(i).getFitness()){
                    lowest=chromosome4s.get(i).getFitness();
                }
                else
                    i++;
            }
            while(j<chromosome4s.size()&&chromosome4s.size()>population){
                if(lowest==chromosome4s.get(j).getFitness()){
                    chromosome4s.remove(j);
                }
                else
                    j++;
            }
            i=0;
            j=0;
        }
    }
    public void equalList(List<Chromosome4> inserted, List<Chromosome4> insert){
        int i = 0;
        inserted.clear();
        while(i<insert.size()){
            inserted.add(insert.get(i));
            i++;
        }
    }
    public Chromosome4 findSolution(List<Chromosome4> chromosome4s){
        int i = 0;
        int j=0;
        Chromosome4 solution = new Chromosome4();
        double highest = chromosome4s.get(0).getFitness();
        while(i<chromosome4s.size()){
            if(highest<chromosome4s.get(i).getFitness()){
                highest=chromosome4s.get(i).getFitness();
            }
            else
                i++;
        }
        while(j<chromosome4s.size()){
            if(highest==chromosome4s.get(j).getFitness()){
                solution=chromosome4s.get(j);
                j++;
            }
            else
                j++;
        }
        return solution;
    }
    public void showSolution(Chromosome4 solution){

        System.out.println("Solusi");
        System.out.println("Fitness :" + solution.getFitness());
        System.out.println("Theta1: " + solution.getTheta());
        System.out.println("Theta2: " + solution.getThetaC1());
        System.out.println("Theta3: " + solution.getThetaC2());
        System.out.println("Theta4: " + solution.getThetaC3());
        System.out.println("Theta5: " + solution.getThetaC4());
        System.out.println("Theta7: " + solution.getThetaI1());
        System.out.println("Theta8: " + solution.getThetaI2());
        System.out.println("Theta9: " + solution.getThetaI3());
        System.out.println("Theta10: " + solution.getThetaI4());
    }
}
