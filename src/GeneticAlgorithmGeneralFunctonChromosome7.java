import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithmGeneralFunctonChromosome7 {
    GeneticAlgorithmCurrencyInterestFunction dollarFunction = new GeneticAlgorithmCurrencyInterestFunction();

    public void initWeight7(Chromosome7 chromosome7) {
        chromosome7.setTheta((Math.random()) % 2000);
        chromosome7.setThetaI1((Math.random()) % 1);
        chromosome7.setThetaI2((Math.random()) % 1);
        chromosome7.setThetaI3((Math.random()) % 1);
        chromosome7.setThetaI4((Math.random()) % 1);
        chromosome7.setThetaI5((Math.random()) % 1);
        chromosome7.setThetaI6((Math.random()) % 1);
        chromosome7.setThetaI7((Math.random()) % 1);
        chromosome7.setThetaC1((Math.random()) % 1000);
        chromosome7.setThetaC2((Math.random()) % 1000);
        chromosome7.setThetaC3((Math.random()) % 1000);
        chromosome7.setThetaC4((Math.random()) % 1000);
        chromosome7.setThetaC5((Math.random()) % 1000);
        chromosome7.setThetaC6((Math.random()) % 1000);
        chromosome7.setThetaC7((Math.random()) % 1000);
    }

    public List<Chromosome7> initializePopulation(int quantity) {
        List<Chromosome7> chromosome7List = new ArrayList<>();
        int i = 0;
        while (i < quantity) {
            chromosome7List.add(new Chromosome7());
            initWeight7(chromosome7List.get(i));
            Chromosome7 chromosome7 = chromosome7List.get(i);
            dollarFunction.calculateFitness7(chromosome7);
            i++;
        }
        return chromosome7List;
    }

    public List<Chromosome7> rouletteWheelSelection(List<Chromosome7> chromosome7List, int selectedQuantity) {
        System.out.println("RWS");
        int i = 0;
        int j = 0;
        int k;
        int l = 0;
        List<Chromosome7> selectedChromosomes = new ArrayList<Chromosome7>();
        double sigmaFitness = 0.0;
        double fitnessCumulative = 0.0;
        int quantity = 0;
        List<Double> fitnessList = new ArrayList<>();
        while (i < chromosome7List.size()) {
            fitnessList.add(i, chromosome7List.get(i).getFitness());
            sigmaFitness = sigmaFitness + chromosome7List.get(i).getFitness();
            i++;
        }
        while (j < fitnessList.size()) {
            chromosome7List.get(j).setLowerFitnessRange(fitnessCumulative);
            fitnessCumulative = fitnessCumulative + chromosome7List.get(j).getFitness() / sigmaFitness;
            chromosome7List.get(j).setUpperFitnessRange(fitnessCumulative);
            j++;
        }
        while (quantity < selectedQuantity) {
            double randomNumber = Math.random() % 1;
            k = 0;
            while (k < fitnessList.size()) {
                if (chromosome7List.get(k).getLowerFitnessRange() <= randomNumber
                        &&
                        chromosome7List.get(k).getUpperFitnessRange() >= randomNumber) {
                    selectedChromosomes.add(chromosome7List.get(k));
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

    public List<Chromosome7> simpleArithmeticCrossover(List<Chromosome7> chromosome7List, Double alpha, Integer crossoverPoint) {
        List<Chromosome7> offsprings = new ArrayList<>();
        int i = 0;
        int j = 0;
        double alphaComplement = 1 - alpha;
        int process = 0;
        while (process < chromosome7List.size()) {
            Chromosome7 chromosome7 = chromosome7List.get(i);
            if (crossoverPoint == 0) {
                chromosome7.setTheta((chromosome7List.get(i).getTheta() * alpha) + (chromosome7List.get(process + 1).getTheta() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 1) {
                chromosome7.setThetaI1((chromosome7List.get(i).getThetaI1() * alpha) + (chromosome7List.get(process + 1).getThetaI1() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 2) {
                chromosome7.setThetaI2((chromosome7List.get(i).getThetaI2() * alpha) + (chromosome7List.get(process + 1).getThetaI2() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 3) {
                chromosome7.setThetaI3((chromosome7List.get(i).getThetaI3() * alpha) + (chromosome7List.get(process + 1).getThetaI3() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 4) {
                chromosome7.setThetaI4((chromosome7List.get(i).getThetaI4() * alpha) + (chromosome7List.get(process + 1).getThetaI4() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 5) {
                chromosome7.setThetaI5((chromosome7List.get(i).getThetaI5() * alpha) + (chromosome7List.get(process + 1).getThetaI5() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 6) {
                chromosome7.setThetaI6((chromosome7List.get(i).getThetaI6() * alpha) + (chromosome7List.get(process + 1).getThetaI6() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 7) {
                chromosome7.setThetaI7((chromosome7List.get(i).getThetaI7() * alpha) + (chromosome7List.get(process + 1).getThetaI7() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 8) {
                chromosome7.setThetaC1((chromosome7List.get(i).getThetaC1() * alpha) + (chromosome7List.get(process + 1).getThetaC1() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 9) {
                chromosome7.setThetaC2((chromosome7List.get(i).getThetaC2() * alpha) + (chromosome7List.get(process + 1).getThetaC2() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 10) {
                chromosome7.setThetaC3((chromosome7List.get(i).getThetaC3() * alpha) + (chromosome7List.get(process + 1).getThetaC3() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 11) {
                chromosome7.setThetaC4((chromosome7List.get(i).getThetaC4() * alpha) + (chromosome7List.get(process + 1).getThetaC4() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 12) {
                chromosome7.setThetaC5((chromosome7List.get(i).getThetaC5() * alpha) + (chromosome7List.get(process + 1).getThetaC5() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 13) {
                chromosome7.setThetaC6((chromosome7List.get(i).getThetaC6() * alpha) + (chromosome7List.get(process + 1).getThetaC6() * alphaComplement));
                crossoverPoint++;
            } else if (crossoverPoint == 14) {
                chromosome7.setThetaC7((chromosome7List.get(i).getThetaC7() * alpha) + (chromosome7List.get(process + 1).getThetaC7() * alphaComplement));
                crossoverPoint++;
            } else {
                process += 2;
                offsprings.add(chromosome7);
            }
        }
        while (j < offsprings.size()) {
            dollarFunction.calculateFitness7(offsprings.get(j));
            j++;
        }
        return offsprings;
    }

    public void equalList(List<Chromosome7> inserted, List<Chromosome7> insert) {
        int i = 0;
        inserted.clear();
        while (i < insert.size()) {
            inserted.add(insert.get(i));
            i++;
        }
    }

    public void insert(List<Chromosome7> chromosome7s, List<Chromosome7> chromosome7Inserted) {
        int i = 0;
        while (i < chromosome7Inserted.size()) {
            chromosome7s.add(chromosome7Inserted.get(i));
            i++;
        }
    }

    public void mutation(List<Chromosome7> chromosome7s, Double mutationProb) {
        int i = 0;
        int j;
        double randomNumber;
        double mutationProbability = mutationProb;
        while (i < chromosome7s.size()) {
            Chromosome7 chromosome7Before = new Chromosome7();
            chromosome7Before.setTheta(chromosome7s.get(i).getTheta());
            chromosome7Before.setThetaI1(chromosome7s.get(i).getThetaI1());
            chromosome7Before.setThetaI2(chromosome7s.get(i).getThetaI2());
            chromosome7Before.setThetaI3(chromosome7s.get(i).getThetaI3());
            chromosome7Before.setThetaI4(chromosome7s.get(i).getThetaI4());
            chromosome7Before.setThetaI5(chromosome7s.get(i).getThetaI5());
            chromosome7Before.setThetaI6(chromosome7s.get(i).getThetaI6());
            chromosome7Before.setThetaI7(chromosome7s.get(i).getThetaI7());
            chromosome7Before.setThetaC1(chromosome7s.get(i).getThetaC1());
            chromosome7Before.setThetaC2(chromosome7s.get(i).getThetaC2());
            chromosome7Before.setThetaC3(chromosome7s.get(i).getThetaC3());
            chromosome7Before.setThetaC4(chromosome7s.get(i).getThetaC4());
            chromosome7Before.setThetaC5(chromosome7s.get(i).getThetaC5());
            chromosome7Before.setThetaC6(chromosome7s.get(i).getThetaC6());
            chromosome7Before.setThetaC7(chromosome7s.get(i).getThetaC7());
            dollarFunction.calculateFitness7(chromosome7Before);
            j = 0;
            while (j < 15) {
                randomNumber = Math.random() % 1;
                if (randomNumber <= mutationProbability) {
                    if (j == 0) {
                        chromosome7s.get(i).setTheta(Math.random() % 2000);
                        j++;
                    } else if (j == 1) {
                        chromosome7s.get(i).setThetaC1(Math.random() % 1);

                        j++;
                    } else if (j == 2) {
                        chromosome7s.get(i).setThetaC2(Math.random() % 1);
                        j++;
                    } else if (j == 3) {
                        chromosome7s.get(i).setThetaC3(Math.random() % 1);
                        j++;
                    } else if (j == 4) {
                        chromosome7s.get(i).setThetaC4(Math.random() % 1);
                        j++;
                    } else if (j == 5) {
                        chromosome7s.get(i).setThetaC5(Math.random() % 1);
                        j++;
                    } else if (j == 6) {
                        chromosome7s.get(i).setThetaC6(Math.random() % 1);
                        j++;
                    } else if (j == 7) {
                        chromosome7s.get(i).setThetaC7(Math.random() % 1);
                        j++;
                    } else if (j == 8) {
                        chromosome7s.get(i).setThetaI1(Math.random() % 1000);
                        j++;
                    } else if (j == 9) {
                        chromosome7s.get(i).setThetaI2(Math.random() % 1000);
                        j++;
                    } else if (j == 10) {
                        chromosome7s.get(i).setThetaI3(Math.random() % 1000);
                        j++;
                    } else if (j == 11) {
                        chromosome7s.get(i).setThetaI4(Math.random() % 1000);
                        j++;
                    } else if (j == 12) {
                        chromosome7s.get(i).setThetaI5(Math.random() % 1000);
                        j++;
                    } else if (j == 13) {
                        chromosome7s.get(i).setThetaI6(Math.random() % 1000);
                        j++;
                    } else if (j == 14) {
                        chromosome7s.get(i).setThetaI7(Math.random() % 1000);
                        j++;
                    }
                }
                j++;
            }
            dollarFunction.calculateFitness7(chromosome7s.get(i));
            if (chromosome7s.get(i).getFitness() < chromosome7Before.getFitness()) {
                chromosome7s.get(i).setTheta(chromosome7Before.getTheta());

                chromosome7s.get(i).setThetaC1(chromosome7Before.getThetaC1());
                chromosome7s.get(i).setThetaC2(chromosome7Before.getThetaC2());
                chromosome7s.get(i).setThetaC3(chromosome7Before.getThetaC3());
                chromosome7s.get(i).setThetaC4(chromosome7Before.getThetaC4());
                chromosome7s.get(i).setThetaC5(chromosome7Before.getThetaC5());
                chromosome7s.get(i).setThetaC6(chromosome7Before.getThetaC6());
                chromosome7s.get(i).setThetaC7(chromosome7Before.getThetaC7());

                chromosome7s.get(i).setThetaI1(chromosome7Before.getThetaI1());
                chromosome7s.get(i).setThetaI2(chromosome7Before.getThetaI2());
                chromosome7s.get(i).setThetaI3(chromosome7Before.getThetaI3());
                chromosome7s.get(i).setThetaI4(chromosome7Before.getThetaI4());
                chromosome7s.get(i).setThetaI5(chromosome7Before.getThetaI5());
                chromosome7s.get(i).setThetaI6(chromosome7Before.getThetaI6());
                chromosome7s.get(i).setThetaI7(chromosome7Before.getThetaI7());
                dollarFunction.calculateFitness7(chromosome7s.get(i));
//                System.out.println("BATAL");
            }
            i++;
        }
        for (Chromosome7 chromosome7 : chromosome7s
                ) {
//            System.out.println("Chromosome hasil mutasi "+": "+chromosome7.getFitness());

        }
    }

    public void calculateFitness(List<Chromosome7> chromosome7s) {
        int j = 0;
        while (j < chromosome7s.size()) {
            dollarFunction.calculateFitness7(chromosome7s.get(j));
            j++;
        }
    }

    public void generationUpdate(List<Chromosome7> chromosome7s, int population) {
        int i = 0;
        int j = 0;
        while (chromosome7s.size() > population) {
            double lowest = chromosome7s.get(0).getFitness();
            while (i < chromosome7s.size()) {
                if (lowest > chromosome7s.get(i).getFitness()) {
                    lowest = chromosome7s.get(i).getFitness();
                } else
                    i++;
            }
            while (j < chromosome7s.size() && chromosome7s.size() > population) {
                if (lowest == chromosome7s.get(j).getFitness()) {
//                    System.out.println("yang dibuang: "+chromosome5s.get(j).getFitness());
                    chromosome7s.remove(j);
                } else
                    j++;
            }
            i = 0;
            j = 0;
        }
    }

    public Chromosome7 findSolution(List<Chromosome7> chromosome7s) {
        int i = 0;
        int j = 0;
        for (Chromosome7 chromosome : chromosome7s
                ) {
//            System.out.println("Kandidat Kromosom : "+chromosome.getFitness());
        }
        Chromosome7 solution = new Chromosome7();
        double highest = chromosome7s.get(0).getFitness();
        while (i < chromosome7s.size()) {
            if (highest < chromosome7s.get(i).getFitness()) {
                highest = chromosome7s.get(i).getFitness();
            } else
                i++;
        }
        while (j < chromosome7s.size()) {
            if (highest == chromosome7s.get(j).getFitness()) {
                solution = chromosome7s.get(j);
                j++;
            } else
                j++;
        }
        return solution;
    }

    public void showSolution(Chromosome7 solution) {
        System.out.println("Solusi");
        System.out.println("Fitness :" + solution.getFitness());
        System.out.println("Theta1: " + solution.getTheta());
        System.out.println("Theta2: " + solution.getThetaC1());
        System.out.println("Theta3: " + solution.getThetaC2());
        System.out.println("Theta4: " + solution.getThetaC3());
        System.out.println("Theta5: " + solution.getThetaC4());
        System.out.println("Theta6: " + solution.getThetaC5());
        System.out.println("Theta7: " + solution.getThetaC6());
        System.out.println("Theta8: " + solution.getThetaC7());
        System.out.println("Theta9: " + solution.getThetaI1());
        System.out.println("Theta10: " + solution.getThetaI2());
        System.out.println("Theta11: " + solution.getThetaI3());
        System.out.println("Theta12: " + solution.getThetaI4());
        System.out.println("Theta13: " + solution.getThetaI5());
        System.out.println("Theta14: " + solution.getThetaI6());
        System.out.println("Theta15: " + solution.getThetaI7());
    }
}
