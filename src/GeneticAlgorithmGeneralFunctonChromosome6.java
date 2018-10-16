import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithmGeneralFunctonChromosome6 {
    GeneticAlgorithmDollarFunction dollarFunction = new GeneticAlgorithmDollarFunction();

    public void initWeight6(Chromosome6 chromosome6) {
        chromosome6.setTheta((Math.random()) % 2000);
        chromosome6.setThetaI1((Math.random()) % 1);
        chromosome6.setThetaI2((Math.random()) % 1);
        chromosome6.setThetaI3((Math.random()) % 1);
        chromosome6.setThetaI4((Math.random()) % 1);
        chromosome6.setThetaI5((Math.random()) % 1);
        chromosome6.setThetaI6((Math.random()) % 1);
        chromosome6.setThetaC1((Math.random()) % 1000);
        chromosome6.setThetaC2((Math.random()) % 1000);
        chromosome6.setThetaC3((Math.random()) % 1000);
        chromosome6.setThetaC4((Math.random()) % 1000);
        chromosome6.setThetaC5((Math.random()) % 1000);
        chromosome6.setThetaC6((Math.random()) % 1000);
    }

    public List<Chromosome6> initializePopulation(int quantity) {
        List<Chromosome6> chromosome6List = new ArrayList<>();
        int i = 0;
        while (i < quantity) {
            chromosome6List.add(new Chromosome6());
            initWeight6(chromosome6List.get(i));
            Chromosome6 chromosome6 = chromosome6List.get(i);
            dollarFunction.calculateFitness6(chromosome6);
            i++;
        }
        return chromosome6List;
    }
    public List<Chromosome6> rouletteWheelSelection(List<Chromosome6> chromosome6List, int selectedQuantity) {
        System.out.println("RWS");
        int i = 0;
        int j = 0;
        int k;
        int l = 0;
        List<Chromosome6> selectedChromosomes = new ArrayList<Chromosome6>();
        double sigmaFitness = 0.0;
        double fitnessCumulative = 0.0;
        int quantity = 0;
        List<Double> fitnessList = new ArrayList<>();
        while (i < chromosome6List.size()) {
            fitnessList.add(i, chromosome6List.get(i).getFitness());
            sigmaFitness = sigmaFitness + chromosome6List.get(i).getFitness();
            i++;
        }
        while (j < fitnessList.size()) {
            chromosome6List.get(j).setLowerFitnessRange(fitnessCumulative);
            fitnessCumulative = fitnessCumulative + chromosome6List.get(j).getFitness() / sigmaFitness;
            chromosome6List.get(j).setUpperFitnessRange(fitnessCumulative);
            j++;
        }
        while (quantity < selectedQuantity) {
            double randomNumber = Math.random() % 1;
            k = 0;
            while (k < fitnessList.size()) {
                if (chromosome6List.get(k).getLowerFitnessRange() <= randomNumber
                        &&
                        chromosome6List.get(k).getUpperFitnessRange() >= randomNumber) {
                    selectedChromosomes.add(chromosome6List.get(k));
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
    public List<Chromosome6> simpleArithmeticCrossover(List<Chromosome6> chromosome6List, Double alpha) {
        List<Chromosome6> offsprings = new ArrayList<>();
        int i = 0;
        int j = 0;
        double alphaComplement = 1 - alpha;
        int process = 0;
        while (process < chromosome6List.size()) {
            Chromosome6 chromosome6 = new Chromosome6();
            chromosome6.setTheta((chromosome6List.get(i).getTheta() * alpha) + (chromosome6List.get(process + 1).getTheta() * alphaComplement));
            chromosome6.setThetaI1((chromosome6List.get(i).getThetaI1() * alpha) + (chromosome6List.get(process + 1).getThetaI1() * alphaComplement));
            chromosome6.setThetaI2((chromosome6List.get(i).getThetaI2() * alpha) + (chromosome6List.get(process + 1).getThetaI2() * alphaComplement));
            chromosome6.setThetaI3((chromosome6List.get(i).getThetaI3() * alpha) + (chromosome6List.get(process + 1).getThetaI3() * alphaComplement));
            chromosome6.setThetaI4((chromosome6List.get(i).getThetaI4() * alpha) + (chromosome6List.get(process + 1).getThetaI4() * alphaComplement));
            chromosome6.setThetaI5((chromosome6List.get(i).getThetaI5() * alpha) + (chromosome6List.get(process + 1).getThetaI5() * alphaComplement));
            chromosome6.setThetaI6((chromosome6List.get(i).getThetaI6() * alpha) + (chromosome6List.get(process + 1).getThetaI6() * alphaComplement));
            chromosome6.setThetaC1((chromosome6List.get(i).getThetaC1() * alpha) + (chromosome6List.get(process + 1).getThetaC1() * alphaComplement));
            chromosome6.setThetaC2((chromosome6List.get(i).getThetaC2() * alpha) + (chromosome6List.get(process + 1).getThetaC2() * alphaComplement));
            chromosome6.setThetaC3((chromosome6List.get(i).getThetaC3() * alpha) + (chromosome6List.get(process + 1).getThetaC3() * alphaComplement));
            chromosome6.setThetaC4((chromosome6List.get(i).getThetaC4() * alpha) + (chromosome6List.get(process + 1).getThetaC4() * alphaComplement));
            chromosome6.setThetaC5((chromosome6List.get(i).getThetaC5() * alpha) + (chromosome6List.get(process + 1).getThetaC5() * alphaComplement));
            chromosome6.setThetaC6((chromosome6List.get(i).getThetaC6() * alpha) + (chromosome6List.get(process + 1).getThetaC6() * alphaComplement));
            process += 2;
            offsprings.add(chromosome6);
        }
        while (j < offsprings.size()) {
            dollarFunction.calculateFitness6(offsprings.get(j));
            j++;
        }
        return offsprings;
    }
    public void equalList(List<Chromosome6> inserted, List<Chromosome6> insert){
        int i = 0;
        inserted.clear();
        while(i<insert.size()){
            inserted.add(insert.get(i));
            i++;
        }
    }
    public void insert(List<Chromosome6> chromosome6s, List<Chromosome6> chromosome6Inserted) {
        int i = 0;
        while (i < chromosome6Inserted.size()) {
            chromosome6s.add(chromosome6Inserted.get(i));
            i++;
        }
    }
    public void mutation(List<Chromosome6> chromosome6s, Double mutationProb) {
        int i = 0;
        int j;
        double randomNumber ;
        double mutationProbability = mutationProb;
        while (i < chromosome6s.size()) {
            Chromosome6 chromosome6Before = new Chromosome6();
            chromosome6Before.setTheta(chromosome6s.get(i).getTheta());
            chromosome6Before.setThetaI1(chromosome6s.get(i).getThetaI1());
            chromosome6Before.setThetaI2(chromosome6s.get(i).getThetaI2());
            chromosome6Before.setThetaI3(chromosome6s.get(i).getThetaI3());
            chromosome6Before.setThetaI4(chromosome6s.get(i).getThetaI4());
            chromosome6Before.setThetaI5(chromosome6s.get(i).getThetaI5());
            chromosome6Before.setThetaI6(chromosome6s.get(i).getThetaI6());
            chromosome6Before.setThetaC1(chromosome6s.get(i).getThetaC1());
            chromosome6Before.setThetaC2(chromosome6s.get(i).getThetaC2());
            chromosome6Before.setThetaC3(chromosome6s.get(i).getThetaC3());
            chromosome6Before.setThetaC4(chromosome6s.get(i).getThetaC4());
            chromosome6Before.setThetaC5(chromosome6s.get(i).getThetaC5());
            chromosome6Before.setThetaC6(chromosome6s.get(i).getThetaC6());
            dollarFunction.calculateFitness6(chromosome6Before);
            j = 0;
            while (j < 15) {
                randomNumber = Math.random() % 1;
                if (randomNumber <= mutationProbability) {
                    if (j == 0) {
                        chromosome6s.get(i).setTheta(Math.random() % 2000);
                        j++;
                    } else if (j == 1) {
                        chromosome6s.get(i).setThetaC1(Math.random() % 1);

                        j++;
                    } else if (j == 2) {
                        chromosome6s.get(i).setThetaC2(Math.random() % 1);
                        j++;
                    } else if (j == 3) {
                        chromosome6s.get(i).setThetaC3(Math.random() % 1);
                        j++;
                    }  else if (j == 4) {
                        chromosome6s.get(i).setThetaC4(Math.random() % 1);
                        j++;
                    } else if (j == 5) {
                        chromosome6s.get(i).setThetaC5(Math.random() % 1);
                        j++;
                    } else if (j == 6) {
                        chromosome6s.get(i).setThetaC6(Math.random() % 1);
                        j++;
                    }else if (j == 7) {
                        chromosome6s.get(i).setThetaI1(Math.random() % 1000);
                        j++;
                    } else if (j == 8) {
                        chromosome6s.get(i).setThetaI2(Math.random() % 1000);
                        j++;
                    } else if (j == 9) {
                        chromosome6s.get(i).setThetaI3(Math.random() % 1000);
                        j++;
                    } else if (j == 10) {
                        chromosome6s.get(i).setThetaI4(Math.random() % 1000);
                        j++;
                    } else if (j == 11) {
                        chromosome6s.get(i).setThetaI5(Math.random() % 1000);
                        j++;
                    }else if (j == 12) {
                        chromosome6s.get(i).setThetaI6(Math.random() % 1000);
                        j++;
                    }
                }
                j++;
            }
            dollarFunction.calculateFitness6(chromosome6s.get(i));
            if(chromosome6s.get(i).getFitness()<chromosome6Before.getFitness()) {
                chromosome6s.get(i).setTheta(chromosome6Before.getTheta());

                chromosome6s.get(i).setThetaC1(chromosome6Before.getThetaC1());
                chromosome6s.get(i).setThetaC2(chromosome6Before.getThetaC2());
                chromosome6s.get(i).setThetaC3(chromosome6Before.getThetaC3());
                chromosome6s.get(i).setThetaC4(chromosome6Before.getThetaC4());
                chromosome6s.get(i).setThetaC5(chromosome6Before.getThetaC5());
                chromosome6s.get(i).setThetaC6(chromosome6Before.getThetaC6());

                chromosome6s.get(i).setThetaI1(chromosome6Before.getThetaI1());
                chromosome6s.get(i).setThetaI2(chromosome6Before.getThetaI2());
                chromosome6s.get(i).setThetaI3(chromosome6Before.getThetaI3());
                chromosome6s.get(i).setThetaI4(chromosome6Before.getThetaI4());
                chromosome6s.get(i).setThetaI5(chromosome6Before.getThetaI5());
                chromosome6s.get(i).setThetaI6(chromosome6Before.getThetaI6());
                dollarFunction.calculateFitness6(chromosome6s.get(i));
//                System.out.println("BATAL");
            }
            i++;
        }
        for (Chromosome6 chromosome7:chromosome6s
                ) {
//            System.out.println("Chromosome hasil mutasi "+": "+chromosome7.getFitness());

        }
    }
    public void calculateFitness(List<Chromosome6> chromosome6s) {
        int j = 0;
        while (j < chromosome6s.size()) {
            dollarFunction.calculateFitness6(chromosome6s.get(j));
            j++;
        }
    }
    public void generationUpdate(List<Chromosome6> chromosome6s, int population) {
        int i=0;
        int j=0;
        while(chromosome6s.size()>population){
            double lowest = chromosome6s.get(0).getFitness();
            while(i<chromosome6s.size()){
                if(lowest>chromosome6s.get(i).getFitness()){
                    lowest=chromosome6s.get(i).getFitness();
                }
                else
                    i++;
            }
            while(j<chromosome6s.size()&&chromosome6s.size()>population){
                if(lowest==chromosome6s.get(j).getFitness()){
//                    System.out.println("yang dibuang: "+chromosome5s.get(j).getFitness());
                    chromosome6s.remove(j);
                }
                else
                    j++;
            }
            i=0;
            j=0;
        }
    }
    public Chromosome6 findSolution(List<Chromosome6> chromosome6s){
        int i = 0;
        int j=0;
        for (Chromosome6 chromosome: chromosome6s
                ) {
//            System.out.println("Kandidat Kromosom : "+chromosome.getFitness());
        }
        Chromosome6 solution = new Chromosome6();
        double highest = chromosome6s.get(0).getFitness();
        while(i<chromosome6s.size()){
            if(highest<chromosome6s.get(i).getFitness()){
                highest=chromosome6s.get(i).getFitness();
            }
            else
                i++;
        }
        while(j<chromosome6s.size()){
            if(highest==chromosome6s.get(j).getFitness()){
                solution=chromosome6s.get(j);
                j++;
            }
            else
                j++;
        }
        return solution;
    }
    public void showSolution(Chromosome6 solution){
        System.out.println("Solusi");
        System.out.println("Fitness :" + solution.getFitness());
        System.out.println("Theta1: " + solution.getTheta());
        System.out.println("Theta2: " + solution.getThetaC1());
        System.out.println("Theta3: " + solution.getThetaC2());
        System.out.println("Theta4: " + solution.getThetaC3());
        System.out.println("Theta5: " + solution.getThetaC4());
        System.out.println("Theta6: " + solution.getThetaC5());
        System.out.println("Theta7: " + solution.getThetaC6());
        System.out.println("Theta9: " + solution.getThetaI1());
        System.out.println("Theta10: " + solution.getThetaI2());
        System.out.println("Theta11: " + solution.getThetaI3());
        System.out.println("Theta12: " + solution.getThetaI4());
        System.out.println("Theta13: " + solution.getThetaI5());
        System.out.println("Theta14: " + solution.getThetaI6());
    }
}
