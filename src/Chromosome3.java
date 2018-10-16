public class Chromosome3 {

    private Double theta;
    private Double thetaC1;
    private Double thetaC2;
    private Double thetaC3;
    private Double thetaI1;
    private Double thetaI2;
    private Double thetaI3;
    private Double fitness;
    private Double UpperFitnessRange;
    private Double LowerFitnessRange;

    public Double getFitnessRange() {
        return UpperFitnessRange;
    }

    public Double getUpperFitnessRange() {
        return UpperFitnessRange;
    }

    public void setUpperFitnessRange(Double upperFitnessRange) {
        UpperFitnessRange = upperFitnessRange;
    }

    public Double getLowerFitnessRange() {
        return LowerFitnessRange;
    }

    public void setLowerFitnessRange(Double lowerFitnessRange) {
        LowerFitnessRange = lowerFitnessRange;
    }

    public void setFitnessRange(Double fitnessRange) {
        this.UpperFitnessRange = fitnessRange;
    }

    public Double getTheta() {
        return theta;
    }

    public void setTheta(Double theta) {
        this.theta = theta;
    }

    public Double getFitness() {
        return fitness;
    }

    public void setFitness(Double fitness) {
        this.fitness = fitness;
    }

    public Double getThetaC1() {
        return thetaC1;
    }

    public void setThetaC1(Double thetaC1) {
        this.thetaC1 = thetaC1;
    }

    public Double getThetaC2() {
        return thetaC2;
    }

    public void setThetaC2(Double thetaC2) {
        this.thetaC2 = thetaC2;
    }

    public Double getThetaC3() {
        return thetaC3;
    }

    public void setThetaC3(Double thetaC3) {
        this.thetaC3 = thetaC3;
    }

    public Double getThetaI1() {
        return thetaI1;
    }

    public void setThetaI1(Double thetaI1) {
        this.thetaI1 = thetaI1;
    }

    public Double getThetaI2() {
        return thetaI2;
    }

    public void setThetaI2(Double thetaI2) {
        this.thetaI2 = thetaI2;
    }

    public Double getThetaI3() {
        return thetaI3;
    }

    public void setThetaI3(Double thetaI3) {
        this.thetaI3 = thetaI3;
    }
}
