import org.junit.Test;
import static org.junit.Assert.*;

public class GenealogyRequestReviewTest {


    /**
     * Testing getReviewStatus().
     * Should fail since "InProgress" != "Starting"
     * 
     * UPDATE: should now pass
     */
    @Test
    public void testReviewStatus() {
        
        Form form = new Form(1, "Sample Form", "Description");
        
        WorkflowTable workflow = new WorkflowTable();
        
        GenealogyRequestReview review = new GenealogyRequestReview(1, "Comments", "Starting", form, workflow);
        
        assertEquals("Starting", review.getReviewStatus());  
    
    }

    /**
     * Testing startReview().
     * Should pass since "InProgress" = "InProgress"
     */
    @Test
    public void testStartReview() {
    
        Form form = new Form(1, "Sample Form", "Description");
    
        WorkflowTable workflow = new WorkflowTable();
    
        GenealogyRequestReview review = new GenealogyRequestReview(1, "Comments", "InProgress", form, workflow);
    
        review.startReview();
    
        assertEquals("InProgress", review.getReviewStatus());  
    
    }

    /**
     * Testing loadNextReviewItem().
     * Should fail since "Loading next item now" != "Next item is being loaded" 
     * 
     * UPDATE: should now pass
     */
    @Test
    public void testLoadNextReviewItem() {
    
        Form form = new Form(1, "Sample Form", "Description");
    
        WorkflowTable workflow = new WorkflowTable();
    
        GenealogyRequestReview review = new GenealogyRequestReview(1, "Comments", "InProgress", form, workflow);
    
        review.loadNextReviewItem();
    
        assertEquals("Next item is being loaded", review.getWorkflowTable().getCurrentStep());  
    
    }

    /**
     * Testing editData().
     * Should fail since "Editing" != "Editing".
     */
    @Test
    public void testEditData() {
    
        Form form1 = new Form(1, "Original Form", "Description");
    
        Form form2 = new Form(2, "Editing", "Description");
    
        WorkflowTable workflow = new WorkflowTable();
    
        GenealogyRequestReview review = new GenealogyRequestReview(1, "Comments", "InProgress", form1, workflow);
    
        review.editData(form2);
    
        assertEquals("Editing", review.getForm().getFormName());  
    
    }

    /**
     * Testing validateData().
     * Should fail since assertNotEquals is being used.
     * 
     * UPDATE: should now pass
     */
    @Test
    public void testValidateData() {
    
        Form form = new Form(1, "Sample Form", "Description");
    
        WorkflowTable workflow = new WorkflowTable();
    
        GenealogyRequestReview review = new GenealogyRequestReview(1, "Comments", "InProgress", form, workflow);
    
        assertEquals(true, review.validateData());  
    
    }

    /**
     * Testing needCorrection().
     * Should pass since assertEquals is being used.
     */
    @Test
    public void testNeedCorrections() {
    
        Form form = new Form(1, "Sample Form", "Description");
    
        WorkflowTable workflow = new WorkflowTable();
    
        GenealogyRequestReview review = new GenealogyRequestReview(1, "Comments", "InProgress", form, workflow);
    
        review.needCorrections();
    
        assertEquals("Returned", review.getReviewStatus());  
    
    }

    /**
     * Testing finalizeReview().
     * Should fail since assertNotEquals is being used.
     */
    @Test
    public void testFinalizeReview() {
    
        Form form = new Form(1, "Sample Form", "Description");
    
        WorkflowTable workflow = new WorkflowTable();
    
        GenealogyRequestReview review = new GenealogyRequestReview(1, "Comments", "InProgress", form, workflow);
    
        review.finalizeReview();
    
        assertEquals("Reviewed", review.getReviewStatus());  
    
    }

}

