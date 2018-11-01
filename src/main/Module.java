/*
    Programming for Computer Scientists (CS118) - Lab 5
    Classes and objects
*/

package lab5;

/**
* Represents a module.
*/
public class Module {
    private String moduleCode;
    private String moduleName;
    private DynamicAssessmentArray assessments = new DynamicAssessmentArray(10);
    /**
    * Initialises a new module.
    */
    public Module(String moduleCode, String moduleName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }

    /**
    * Gets the module code for this module.
    */
    public String getModuleCode() {
        return this.moduleCode;
    }

    /**
    * Gets the name of the module.
    */
    public String getModuleName() {
        return this.moduleName;
    }

    /**
    * Adds an asssessment to this module. This method returns true if the
    * assessment has successfully been added or false if not. An assessment
    * is not added to the module if it would push assessmentsthe sum of the module's
    * assessment weights above 100.
    */
    public boolean addAssessment(Assessment assessment) {
        int sum = 0;
        for (int i = 0; i < assessments.getSize(); i++) {
          sum += assessments.get(i).getWeight();
        }

        if (sum + assessment.getWeight() > 100) {
          return false;
        } else {
          assessments.add(assessment);
          return true;
        }
    }

    /**
    * Calculates the overall, weighted average for this module.
    */
    public int calculateOverallMark() {
        double sum = 0;
        for (int i = 0; i < assessments.getSize(); i++) {
          Assessment assessment = assessments.get(i);
          sum += assessment.getWeight() * assessment.getMark() / 100.0;
        }
        return (int) Math.ceil(sum);
    }
}
