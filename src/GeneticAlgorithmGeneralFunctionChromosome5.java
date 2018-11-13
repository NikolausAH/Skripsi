import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithmGeneralFunctionChromosome5 {

    GeneticAlgorithmCurrencyInterestFunction dollarFunction = new GeneticAlgorithmCurrencyInterestFunction();
    public void calculateFitness(List<Chromosome5> chromosome5s) {
        int j = 0;
        while (j < chromosome5s.size()) {
            dollarFunction.calculateFitness5(chromosome5s.get(j));
            j++;
        }
    }
    public void showSolution(Chromosome5 solution){

        System.out.println("Solusi");
        System.out.println("Fitness :" + solution.getFitness());
        System.out.println("Theta1: " + solution.getTheta());
        System.out.println("Theta2: " + solution.getThetaC1());
        System.out.println("Theta3: " + solution.getThetaC2());
        System.out.println("Theta4: " + solution.getThetaC3());
        System.out.println("Theta5: " + solution.getThetaC4());
        System.out.println("Theta6: " + solution.getThetaC5());
        System.out.println("Theta7: " + solution.getThetaI1());
        System.out.println("Theta8: " + solution.getThetaI2());
        System.out.println("Theta9: " + solution.getThetaI3());
        System.out.println("Theta10: " + solution.getThetaI4());
        System.out.println("Theta11: " + solution.getThetaI5());
    }
    public void equalList(List<Chromosome5> inserted, List<Chromosome5> insert){
        int i = 0;
        inserted.clear();
        while(i<insert.size()){
            inserted.add(insert.get(i));
            i++;
        }
    }
    public Chromosome5 findSolution(List<Chromosome5> chromosome5s){
        int i = 0;
        int j=0;
        for (Chromosome5 chromosome: chromosome5s
             ) {
//            System.out.println("Kandidat Kromosom : "+chromosome.getFitness());

        }
        Chromosome5 solution = new Chromosome5();
        double highest = chromosome5s.get(0).getFitness();
        while(i<chromosome5s.size()){
            if(highest<chromosome5s.get(i).getFitness()){
                highest=chromosome5s.get(i).getFitness();
            }
            else
                i++;
        }
        while(j<chromosome5s.size()){
            if(highest==chromosome5s.get(j).getFitness()){
                solution=chromosome5s.get(j);
                j++;
            }
            else
                j++;
        }
        return solution;
    }
    public void generationUpdate(List<Chromosome5> chromosome5s,int population) {
        int i=0;
        int j=0;
        while(chromosome5s.size()>population){
            double lowest = chromosome5s.get(0).getFitness();
            while(i<chromosome5s.size()){
                if(lowest>chromosome5s.get(i).getFitness()){
                    lowest=chromosome5s.get(i).getFitness();
                }
                else
                    i++;
            }
            while(j<chromosome5s.size()&&chromosome5s.size()>population){
                if(lowest==chromosome5s.get(j).getFitness()){
//                    System.out.println("yang dibuang: "+chromosome5s.get(j).getFitness());
                    chromosome5s.remove(j);
                }
                else
                    j++;
            }
            i=0;
            j=0;
        }
    }
    public void initWeight5(Chromosome5 chromosome5) {
        chromosome5.setTheta((Math.random()) % 2000);
        chromosome5.setThetaI1((Math.random()) % 1000);
        chromosome5.setThetaI2((Math.random()) % 1000);
        chromosome5.setThetaI3((Math.random()) % 1000);
        chromosome5.setThetaI4((Math.random()) % 1000);
        chromosome5.setThetaI5((Math.random()) % 1000);
        chromosome5.setThetaC1((Math.random()) % 1);
        chromosome5.setThetaC2((Math.random()) % 1);
        chromosome5.setThetaC3((Math.random()) % 1);
        chromosome5.setThetaC4((Math.random()) % 1);
        chromosome5.setThetaC5((Math.random()) % 1);
    }
    public void insert(List<Chromosome5> chromosome5s, List<Chromosome5> chromosome5Inserted) {
        int i = 0;
        while (i < chromosome5Inserted.size()) {
            chromosome5s.add(chromosome5Inserted.get(i));
            i++;
        }
    }
    public void mutation(List<Chromosome5> chromosome5s, Double mutationProb) {
        int i = 0;
        int j;
        double randomNumber ;
        double mutationProbability = mutationProb;
        while (i < chromosome5s.size()) {
            Chromosome5 chromosome5Before = new Chromosome5();
            chromosome5Before.setTheta(chromosome5s.get(i).getTheta());
            chromosome5Before.setThetaI1(chromosome5s.get(i).getThetaI1());
            chromosome5Before.setThetaI2(chromosome5s.get(i).getThetaI2());
            chromosome5Before.setThetaI3(chromosome5s.get(i).getThetaI3());
            chromosome5Before.setThetaI4(chromosome5s.get(i).getThetaI4());
            chromosome5Before.setThetaI5(chromosome5s.get(i).getThetaI5());
            chromosome5Before.setThetaC1(chromosome5s.get(i).getThetaC1());
            chromosome5Before.setThetaC2(chromosome5s.get(i).getThetaC2());
            chromosome5Before.setThetaC3(chromosome5s.get(i).getThetaC3());
            chromosome5Before.setThetaC4(chromosome5s.get(i).getThetaC4());
            chromosome5Before.setThetaC5(chromosome5s.get(i).getThetaC5());
            dollarFunction.calculateFitness5(chromosome5Before);
            j = 0;
            while (j < 11) {
                randomNumber = Math.random() % 1;
                if (randomNumber <= mutationProbability) {
                    if (j == 0) {
                        chromosome5s.get(i).setTheta(Math.random() % 2000);
                        j++;
                    } else if (j == 1) {
                        chromosome5s.get(i).setThetaC1(Math.random() % 1);

                        j++;
                    } else if (j == 2) {
                        chromosome5s.get(i).setThetaC2(Math.random() % 1);

                        j++;
                    } else if (j == 3) {
                        chromosome5s.get(i).setThetaC3(Math.random() % 1);
                        j++;
                    }  else if (j == 4) {
                        chromosome5s.get(i).setThetaC4(Math.random() % 1);
                        j++;
                    } else if (j == 5) {
                        chromosome5s.get(i).setThetaC5(Math.random() % 1);
                        j++;
                    }else if (j == 6) {
                        chromosome5s.get(i).setThetaI1(Math.random() % 1000);
                        j++;
                    } else if (j == 7) {
                        chromosome5s.get(i).setThetaI2(Math.random() % 1000);
                        j++;
                    } else if (j == 8) {
                        chromosome5s.get(i).setThetaI3(Math.random() % 1000);
                        j++;
                    } else if (j == 9) {
                        chromosome5s.get(i).setThetaI4(Math.random() % 1000);
                        j++;
                    } else if (j == 10) {
                        chromosome5s.get(i).setThetaI5(Math.random() % 1000);
                        j++;
                    }
                }
                j++;
            }

            dollarFunction.calculateFitness5(chromosome5s.get(i));
            if(chromosome5s.get(i).getFitness()<chromosome5Before.getFitness()) {
                chromosome5s.get(i).setTheta(chromosome5Before.getTheta());

                chromosome5s.get(i).setThetaC1(chromosome5Before.getThetaC1());
                chromosome5s.get(i).setThetaC2(chromosome5Before.getThetaC2());
                chromosome5s.get(i).setThetaC3(chromosome5Before.getThetaC3());
                chromosome5s.get(i).setThetaC4(chromosome5Before.getThetaC4());
                chromosome5s.get(i).setThetaC5(chromosome5Before.getThetaC5());

                chromosome5s.get(i).setThetaI1(chromosome5Before.getThetaI1());
                chromosome5s.get(i).setThetaI2(chromosome5Before.getThetaI2());
                chromosome5s.get(i).setThetaI3(chromosome5Before.getThetaI3());
                chromosome5s.get(i).setThetaI4(chromosome5Before.getThetaI4());
                chromosome5s.get(i).setThetaI5(chromosome5Before.getThetaI5());
                dollarFunction.calculateFitness5(chromosome5s.get(i));
//                System.out.println("BATAL");
            }
            i++;
            }
        for (Chromosome5 chromosome5:chromosome5s
                ) {
//            System.out.println("Chromosome hasil mutasi "+": "+chromosome5.getFitness());

        }
    }
    public List<Chromosome5> initializePopulation(int quantity) {
        List<Chromosome5> chromosome5List = new ArrayList<>();
        int i = 0;
        while (i < quantity) {
            chromosome5List.add(new Chromosome5());
            initWeight5(chromosome5List.get(i));
            Chromosome5 chromosome5= chromosome5List.get(i);
            dollarFunction.calculateFitness5(chromosome5);
            i++;
        }
        return chromosome5List;
    }
    public List<Chromosome5> rouletteWheelSelection(List<Chromosome5> chromosome5List, int selectedQuantity) {
        System.out.println("RWS");
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        List<Chromosome5> selectedChromosomes = new ArrayList<Chromosome5>();
        double sigmaFitness = 0.0;
        double fitnessCumulative = 0.0;
        int quantity = 0;
        List<Double> fitnessList = new ArrayList<>();
        while (i < chromosome5List.size()) {
            fitnessList.add(i, chromosome5List.get(i).getFitness());
            sigmaFitness = sigmaFitness + chromosome5List.get(i).getFitness();
            i++;
        }
        while (j < fitnessList.size()) {
            chromosome5List.get(j).setLowerFitnessRange(fitnessCumulative);
            fitnessCumulative = fitnessCumulative + chromosome5List.get(j).getFitness() / sigmaFitness;
            chromosome5List.get(j).setUpperFitnessRange(fitnessCumulative);
            j++;
        }
        while (quantity < selectedQuantity) {
            double randomNumber = Math.random() % 1;
            k = 0;
            while (k < fitnessList.size()) {
                if (chromosome5List.get(k).getLowerFitnessRange() <= randomNumber
                        &&
                        chromosome5List.get(k).getUpperFitnessRange() >= randomNumber) {
                    selectedChromosomes.add(chromosome5List.get(k));
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
    public List<Chromosome5> simpleArithmeticCrossover(List<Chromosome5> chromosome5List, Double alpha, Integer crossoverPoint) {
        List<Chromosome5> offsprings = new ArrayList<>();
        int i = 0;
        int j = 0;
        double alphaComplement = 1 - alpha;
        int process = 0;
        while (process < chromosome5List.size()) {
            Chromosome5 chromosome5 = chromosome5List.get(i);
            if (crossoverPoint == 0) {
                chromosome5.setTheta((chromosome5List.get(i).getTheta() * alpha) + (chromosome5List.get(process + 1).getTheta() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 1) {
                chromosome5.setThetaI1((chromosome5List.get(i).getThetaI1() * alpha) + (chromosome5List.get(process + 1).getThetaI1() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 2) {
                chromosome5.setThetaI2((chromosome5List.get(i).getThetaI2() * alpha) + (chromosome5List.get(process + 1).getThetaI2() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 3) {
                chromosome5.setThetaI3((chromosome5List.get(i).getThetaI3() * alpha) + (chromosome5List.get(process + 1).getThetaI3() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 4) {
                chromosome5.setThetaI4((chromosome5List.get(i).getThetaI4() * alpha) + (chromosome5List.get(process + 1).getThetaI4() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 5) {
                chromosome5.setThetaI5((chromosome5List.get(i).getThetaI5() * alpha) + (chromosome5List.get(process + 1).getThetaI5() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 6) {
                chromosome5.setThetaC1((chromosome5List.get(i).getThetaC1() * alpha) + (chromosome5List.get(process + 1).getThetaC1() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 7) {
                chromosome5.setThetaC2((chromosome5List.get(i).getThetaC2() * alpha) + (chromosome5List.get(process + 1).getThetaC2() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 8) {
                chromosome5.setThetaC3((chromosome5List.get(i).getThetaC3() * alpha) + (chromosome5List.get(process + 1).getThetaC3() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 9) {
                chromosome5.setThetaC4((chromosome5List.get(i).getThetaC4() * alpha) + (chromosome5List.get(process + 1).getThetaC4() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 10) {
                chromosome5.setThetaC5((chromosome5List.get(i).getThetaC5() * alpha) + (chromosome5List.get(process + 1).getThetaC5() * alphaComplement));
                crossoverPoint++;
            }
            else {
                process += 2;
                offsprings.add(chromosome5);
            }
        }
        while (j < offsprings.size()) {
            dollarFunction.calculateFitness5(offsprings.get(j));
            j++;
        }
        return offsprings;
    }
}
