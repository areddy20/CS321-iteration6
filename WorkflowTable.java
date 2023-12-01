public class WorkflowTable {
    
    /**
     * Attributes for WorkflowTable.
     */
    private int workflowID;
    private String currentStep;

    /**
     * Assigning currentStep to string
     */
    public WorkflowTable() {
        
        this.currentStep = "Current step";
    
    }

    /**
     * Getter for testing purposes.
     * @return currentStep for output.
     */
    public String getCurrentStep() {
        
        return (currentStep);
    
    }

    /**
     * Assigning currentStep to string.
     */
    public void loadNextItem() {
        
        this.currentStep = "Loading first item now";
    
    }

    /**
     * Assigning currentStep to parameter.
     * @param step for input.
     */
    public void updateStep(String step) {
        
        this.currentStep = step;
    
    }

}

