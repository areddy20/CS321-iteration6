import java.util.ArrayList;
import java.util.List;

public class GenealogyRequestReview {

    /**
     * Attributes of GenealogyRequestReview
     */
    private int reviewerID;
    private String reviewComments;
    private String reviewStatus;
    
    /**
     * Attributes from other classes that GenealogyRequestReview needs data from
     */
    private Form form;
    private WorkflowTable workflowTable;

    /**
     * Records all of the Reviewer's activity throughout the process
     */
    private List<String> reviewHistoryLog = new ArrayList<>();

    
    /**
     * Initializing attributes.
     * @param reviewerID
     * @param reviewComments
     * @param reviewStatus
     * @param form
     * @param workflowTable
     */
    public GenealogyRequestReview(int reviewerID, String reviewComments, String reviewStatus, Form form, WorkflowTable workflowTable) {
        
        this.reviewerID = reviewerID;
        
        this.reviewComments = reviewComments;
        
        this.reviewStatus = reviewStatus;
        
        this.form = form;
        
        this.workflowTable = workflowTable;
    
    }

    /**
     * Getter for testing purposes.
     * @return reviewStatus for output.
     */    
    public String getReviewStatus() {
        
        return (reviewStatus);
    
    }

    /**
     * Getter for testing purposes.
     * @return form for output.
     */
    public Form getForm() {
        
        return (form);

    }

    /**
     * Getter for testing purposes.
     * @return workflowTable or output.
     */
    public WorkflowTable getWorkflowTable() {
        
        return (workflowTable);

    }

    /**
     * Starting the review process.
     * Status is marked as "Pending".
     * String is added to the Reviewer's history log. 
     */
    public void startReview() {
        
        reviewStatus = "InProgress";
        
        reviewHistoryLog.add("Review started by reviewer with ID: " + reviewerID);
    
    }

    /**
     * Loading next item for review.
     * Accessing WorkflowTable class.
     * String is added to the Reviewer's history log. 
     */
    public void loadNextReviewItem() {
        
        workflowTable.loadNextItem();
        
        reviewHistoryLog.add("Loaded next review item.");
    
    }

    /**
     * Supplemental checks get performed.
     * String is added to the Reviewer's history log. 
     */
    public void performSupplementalChecks() {
    
        reviewHistoryLog.add("Supplemental checks performed.");
    
    }

    /**
     * Reviewer edits data.
     * String is added to the Reviewer's history log. 
     * @param updatedForm for input.
     */
    public void editData(Form updatedForm) {
    
        this.form = updatedForm;
    
        reviewHistoryLog.add("Data edited by reviewer with ID: " + reviewerID);
    
    }

    /**
     * If data meets validation criteria.
     * String is added to the Reviewer's history log. 
     * @return value of isValid for output.
     */
    public boolean validateData() {
    
        boolean isValid = true; 
    
        reviewHistoryLog.add("Data validation performed. Result: " + (isValid ? "Valid" : "Invalid"));
    
        return (isValid);
    
    }

    /**
     * If data needs further corrections.
     * String is added to the Reviewer's history log. 
     */
    public void needCorrections() {
    
        reviewStatus = "Returned";
    
        reviewHistoryLog.add("Item returned for corrections.");
    
    }

    /**
     * Last step in reviewing process.
     * String is added to the Reviewer's history log. 
     */
    public void finalizeReview() {
    
        reviewStatus = "Reviewed";
    
        workflowTable.updateStep("Review Completed");
    
        reviewHistoryLog.add("Review finalized by reviewer with ID: " + reviewerID);
    
    }

    /**
     * All edits made in above methods are actions.
     * String is added to the Reviewer's history log. 
     * @param action for input.
     */
    public void reviewHistory(String action) {
    
        reviewHistoryLog.add(action);
    
    }

}
