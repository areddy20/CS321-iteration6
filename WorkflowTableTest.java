import org.junit.Test;
import static org.junit.Assert.*;

public class WorkflowTableTest {

    /**
     * Testing getCurrentStep().
     * Should pass since "Done!" = "Done!".
     */
    @Test
    public void testInitialStep() {
        
        WorkflowTable workflow = new WorkflowTable();
        
        assertEquals("Done!", workflow.getCurrentStep());  
    
    }

    /**
     * Testing loadNextItem(). 
     * Should fail since "Loading next item now" != "Loading the first item now".
     * 
     * UPDATE: should now pass
     */
    @Test
    public void testLoadNextItem() {
        
        WorkflowTable workflow = new WorkflowTable();
        
        workflow.loadNextItem();
        
        assertEquals("Next item is being loaded", workflow.getCurrentStep());  
    
    }

    /**
     * Testing updateStep().
     * Should pass since "Step is updated" = "Step is updated".
     */
    @Test
    public void testUpdateStep() {
        
        WorkflowTable workflow = new WorkflowTable();
        
        workflow.updateStep("Step is updated");
        
        assertEquals("Step is updated", workflow.getCurrentStep());  
    
    }

}

