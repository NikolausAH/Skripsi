import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithmGeneralFunctionChromosome3 {
    GeneticAlgorithmDollarFunction geneticAlgorithmDollarFunction = new GeneticAlgorithmDollarFunction();

    public void insert(List<Chromosome3> chromosome3s, List<Chromosome3> chromosome3Inserted) {
        int i = 0;
        while (i < chromosome3Inserted.size()) {
            chromosome3s.add(chromosome3Inserted.get(i));
            i++;
        }
    }

    public void generationUpdate(List<Chromosome3> chromosome3s,int population) {
        int i=0;
        int j=0;
        while(chromosome3s.size()>population){
            double lowest = chromosome3s.get(0).getFitness();
            while(i<chromosome3s.size()){
                if(lowest>chromosome3s.get(i).getFitness()){
                    lowest=chromosome3s.get(i).getFitness();
                }
                else
                    i++;
            }
            while(j<chromosome3s.size()&&chromosome3s.size()>population){
                if(lowest==chromosome3s.get(j).getFitness()){
                    chromosome3s.remove(j);
                }
                else
                    j++;
            }
            i=0;
            j=0;
        }
    }

    public void initWeight3(Chromosome3 chromosome3) {
        chromosome3.setTheta((Math.random()) % 2000);
        chromosome3.setThetaI1((Math.random()) % 1000);
        chromosome3.setThetaI2((Math.random()) % 1000);
        chromosome3.setThetaI3((Math.random()) % 1000);
        chromosome3.setThetaC1((Math.random()) % 1);
        chromosome3.setThetaC2((Math.random()) % 1);
        chromosome3.setThetaC3((Math.random()) % 1);
    }

    public List<Chromosome3> simpleArithmeticCrossover(List<Chromosome3> chromosome3List, Double alpha) {
        List<Chromosome3> offsprings = new ArrayList<>();
        int i = 0;
        int j = 0;
        double alphaComplement = 1 - alpha;
        int process = 0;
        while (process < chromosome3List.size()) {
            Chromosome3 chromosome3 = new Chromosome3();
            chromosome3.setTheta((chromosome3List.get(i).getTheta() * alpha) + (chromosome3List.get(process + 1).getTheta() * alphaComplement));
            chromosome3.setThetaI1((chromosome3List.get(i).getThetaI1() * alpha) + (chromosome3List.get(process + 1).getThetaI1() * alphaComplement));
            chromosome3.setThetaI2((chromosome3List.get(i).getThetaI2() * alpha) + (chromosome3List.get(process + 1).getThetaI2() * alphaComplement));
            chromosome3.setThetaI3((chromosome3List.get(i).getThetaI3() * alpha) + (chromosome3List.get(process + 1).getThetaI3() * alphaComplement));
            chromosome3.setThetaC1((chromosome3List.get(i).getThetaC1() * alpha) + (chromosome3List.get(process + 1).getThetaC1() * alphaComplement));
            chromosome3.setThetaC2((chromosome3List.get(i).getThetaC2() * alpha) + (chromosome3List.get(process + 1).getThetaC2() * alphaComplement));
            chromosome3.setThetaC3((chromosome3List.get(i).getThetaC3() * alpha) + (chromosome3List.get(process + 1).getThetaC3() * alphaComplement));
            process += 2;
            offsprings.add(chromosome3);
        }
        while (j < offsprings.size()) {
            geneticAlgorithmDollarFunction.calculateFitness3(offsprings.get(j));
            j++;
        }
        return offsprings;
    }

    public List<Chromosome3> rouletteWheelSelection(List<Chromosome3> chromosome3List, int selectedQuantity) {
//        System.out.println("woi sizenya!");
//        System.out.println(chromosome3List.size());
        int i = 0;
        int j = 0;
        int k;
        int l = 0;
        List<Chromosome3> selectedChromosomes = new ArrayList<Chromosome3>();
//        System.out.println("woi");
        double sigmaFitness = 0.0;
        double fitnessCumulative = 0.0;
        int quantity = 0;
        List<Double> fitnessList = new ArrayList<>();
        while (i < chromosome3List.size()) {
//            System.out.println("woi 1");
            fitnessList.add(i, chromosome3List.get(i).getFitness());
//            System.out.println("woi 2");
            sigmaFitness = sigmaFitness + chromosome3List.get(i).getFitness();
            i++;
//            System.out.println(1);
//            System.out.println("woi 3");
        }
        while (j < fitnessList.size()) {
            chromosome3List.get(j).setLowerFitnessRange(fitnessCumulative);
            fitnessCumulative = fitnessCumulative + chromosome3List.get(j).getFitness() / sigmaFitness;
            chromosome3List.get(j).setUpperFitnessRange(fitnessCumulative);
            j++;
//            System.out.println(2);
        }
        while (quantity < selectedQuantity) {
            double randomNumber = Math.random() % 1;
            k = 0;
            while (k < fitnessList.size()) {
                if (chromosome3List.get(k).getLowerFitnessRange() <= randomNumber
                        &&
                        chromosome3List.get(k).getUpperFitnessRange() >= randomNumber) {
                    selectedChromosomes.add(chromosome3List.get(k));
                    quantity++;
                    k = fitnessList.size();
                } else
                    k++;
//                System.out.println(2);
            }
        }
        while (l < selectedChromosomes.size()) {
            l++;
        }
        return selectedChromosomes;
    }

    public List<Chromosome3> initializePopulation(int quantity) {
        List<Chromosome3> chromosome3List = new ArrayList<>();
        int i = 0;
        while (i < quantity) {
            chromosome3List.add(new Chromosome3());
            initWeight3(chromosome3List.get(i));
            geneticAlgorithmDollarFunction.calculateFitness3(chromosome3List.get(i));
            i++;
        }
        return chromosome3List;
    }

    public void calculateFitness(List<Chromosome3> chromosome3s) {
        int j = 0;
        while (j < chromosome3s.size()) {
            geneticAlgorithmDollarFunction.calculateFitness3(chromosome3s.get(j));
            j++;
        }
    }

    public void mutation(List<Chromosome3> chromosome3s,Double mutationProb) {
        int i = 0;
        int j;
        double randomNumber ;
        double mutationProbability = mutationProb;
        while (i < chromosome3s.size()) {
//                System.out.println("Chromosome sebelum mutasi "+": "+chromosome5s.get(i).getFitness());
            Chromosome3 chromosome3Before = new Chromosome3();
            chromosome3Before.setTheta(chromosome3s.get(i).getTheta());
            chromosome3Before.setThetaI1(chromosome3s.get(i).getThetaI1());
            chromosome3Before.setThetaI2(chromosome3s.get(i).getThetaI2());
            chromosome3Before.setThetaI3(chromosome3s.get(i).getThetaI3());
            chromosome3Before.setThetaC1(chromosome3s.get(i).getThetaC1());
            chromosome3Before.setThetaC2(chromosome3s.get(i).getThetaC2());
            chromosome3Before.setThetaC3(chromosome3s.get(i).getThetaC3());
            geneticAlgorithmDollarFunction.calculateFitness3(chromosome3Before);
            j = 0;
            while (j < 7) {
                randomNumber = Math.random() % 1;
                if (randomNumber <= mutationProbability) {
                    if (j == 0) {
                        chromosome3s.get(i).setTheta(Math.random() % 2000);
                        j++;
                    } else if (j == 1) {
                        chromosome3s.get(i).setThetaC1(Math.random() % 1);

                        j++;
                    } else if (j == 2) {
                        chromosome3s.get(i).setThetaC2(Math.random() % 1);

                        j++;
                    } else if (j == 3) {
                        chromosome3s.get(i).setThetaC3(Math.random() % 1);
                        j++;
                    }else if (j == 4) {
                        chromosome3s.get(i).setThetaI1(Math.random() % 1000);
                        j++;
                    } else if (j == 5) {
                        chromosome3s.get(i).setThetaI2(Math.random() % 1000);
                        j++;
                    } else if (j == 6) {
                        chromosome3s.get(i).setThetaI3(Math.random() % 1000);
                        j++;
                    }
                }
                j++;
            }
            geneticAlgorithmDollarFunction.calculateFitness3(chromosome3s.get(i));
            if(chromosome3s.get(i).getFitness()<chromosome3Before.getFitness()) {
                chromosome3s.get(i).setTheta(chromosome3Before.getTheta());

                chromosome3s.get(i).setThetaC1(chromosome3Before.getThetaC1());
                chromosome3s.get(i).setThetaC2(chromosome3Before.getThetaC2());
                chromosome3s.get(i).setThetaC3(chromosome3Before.getThetaC3());
                chromosome3s.get(i).setThetaI1(chromosome3Before.getThetaI1());
                chromosome3s.get(i).setThetaI2(chromosome3Before.getThetaI2());
                chromosome3s.get(i).setThetaI3(chromosome3Before.getThetaI3());
                geneticAlgorithmDollarFunction.calculateFitness3(chromosome3s.get(i));
//                System.out.println("BATAL");
            }
            i++;
        }
        for (Chromosome3 chromosome3:chromosome3s
                ) {
//            System.out.println("Chromosome hasil mutasi "+": "+chromosome5.getFitness());

        }
    }

    public Chromosome3 findSolution(List<Chromosome3> chromosome3s){
        int i = 0;
        int j=0;
        Chromosome3 solution = new Chromosome3();
        double highest = chromosome3s.get(0).getFitness();
        while(i<chromosome3s.size()){
            if(highest<chromosome3s.get(i).getFitness()){
                highest=chromosome3s.get(i).getFitness();
            }
            else
                i++;
        }
        while(j<chromosome3s.size()){
            if(highest==chromosome3s.get(j).getFitness()){
                solution=chromosome3s.get(j);
                j++;
            }
            else
                j++;
        }
        return solution;
    }

    public void equalList(List<Chromosome3> inserted, List<Chromosome3> insert){
        int i = 0;
        inserted.clear();
        while(i<insert.size()){
            inserted.add(insert.get(i));
            i++;
        }
    }
    public void showSolution(Chromosome3 solution){

        System.out.println("Solusi");
        System.out.println("Fitness :" + solution.getFitness());
        System.out.println("Theta1: " + solution.getTheta());
        System.out.println("Theta2: " + solution.getThetaC1());
        System.out.println("Theta3: " + solution.getThetaC2());
        System.out.println("Theta4: " + solution.getThetaC3());
        System.out.println("Theta5: " + solution.getThetaI1());
        System.out.println("Theta6: " + solution.getThetaI2());
        System.out.println("Theta7: " + solution.getThetaI3());
    }
}
